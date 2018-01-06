package com.myapplication.client;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by administrator on 2018/1/6.
 * C/S 架构的客户端对象，持有该对象，可以随时向服务端发送消息
 */

public class MyClient {
    private String serverIp;
    private int port;
    private Socket socket;
    private boolean running =false;
    private long lastSendTime;
    private ConcurrentHashMap<Class,ObjectAction> actionMapping = new ConcurrentHashMap<>();
    /**
     * 处理服务端发回的对象，可以实现该接口
     */
    public static interface ObjectAction{
        void doAction(Object object,MyClient client);
    }
    public static  final  class  DefaultObjectAction implements ObjectAction{
        @Override
        public void doAction(Object object, MyClient client) {
            Log.d("Server返回信息",""+object.toString());
        }
    }

    /**
     * 添加接收对象的处理对象，添加发送的消息
     * @param cls
     * @param action
     */
    public void addActionMap(Class<Object> cls,ObjectAction action){
        actionMapping.put(cls,action);
    }
    public void sendObject(Object object) throws IOException{
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.writeObject(object);
        outputStream.flush();
    }

    public MyClient(String serverIp,int port){
        this.serverIp=serverIp;
        this.port=port;
    }

    public void start() throws IOException{
        if (running) return;
        socket = new Socket(serverIp,port);
        lastSendTime = System.currentTimeMillis();
        running = true;
        new Thread(new KeepAliveWatchDog()).start();//保持长链接的thread，每隔两秒向服务器发送一个保持连接的心跳消息
        new Thread(new ReceiveWatchCat()).start();//接收服务器返回消息的thread，并且处理消息
    }
    public void stop(){
        if (running) running =false;
    }
    class KeepAliveWatchDog implements Runnable{
        long checkDelay = 10;
        long keepAliveDelay =2000;
        @Override
        public void run() {
            while (running){
                if(System.currentTimeMillis() -lastSendTime >keepAliveDelay){
                    try {
                        MyClient.this.sendObject("AAAA");
                    } catch (IOException e) {
                        Log.e("KeepAliveWatchDogError",e.toString());
                        MyClient.this.stop();
                    }
                    lastSendTime = System.currentTimeMillis();
                }else {
                    try {
                        Thread.sleep(checkDelay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        MyClient.this.stop();
                    }
                }
            }
        }
    }
    class ReceiveWatchCat implements Runnable {

        @Override
        public void run() {
            while (running){
                try {
                    InputStream inputStream = socket.getInputStream();
                    if(inputStream.available()>0){
                        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                        Object object = objectInputStream.readObject();
                        ObjectAction objectAction = actionMapping.get(object.getClass());
                        objectAction = objectAction==null?new DefaultObjectAction(): objectAction;
                        objectAction.doAction(object,MyClient.this);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    MyClient.this.stop();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
