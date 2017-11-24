package com.myapplication.utils;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;

import com.myapplication.bean.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by administrator on 2017/11/24.
 */

public class GetContactsUtils {
    private Uri uri;
    /**
     * 联系人显示名称
     **/
    private  final int PHONES_DISPLAY_NAME_INDEX = 0;
    /**
     * 电话号码
     **/
    private  final int PHONES_NUMBER_INDEX = 1;
    private List<Contact> contacts;
    private Context mContext;
    public void init(Context context){
        mContext=context;
    }

    public List<Contact> getSIMContacts(){
        ContentResolver resolver = mContext.getContentResolver();
         contacts = new ArrayList<>();
        TelephonyManager manager= (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
        Log.d("GetContactsUtils",""+manager.getSimState());
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if(manager.getPhoneCount()>1 && manager.getSimState() == TelephonyManager.SIM_STATE_READY){
//                Log.d("GetContactsUtils","2");
//                    uri = Uri.parse("content://icc/adn");
//                    Cursor cursor;
//                    try{
//                        cursor = resolver.query(uri,null,null,null,null);
//                    }
//                    catch (SecurityException se){
//                        Log.d("TAG","无法读取SIM卡联系人");
//                        cursor=null;
//                    }
//
//                    getSimContact(cursor);
//            }
//        }else {
//
//        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(manager.getPhoneCount()>0 && manager.getSimState() == TelephonyManager.SIM_STATE_READY){
                uri=Uri.parse("content://icc/adn");
                Cursor cursor= resolver.query(uri,null,null,null,null);
                getSimContact(cursor);
            }
        }

        return contacts;
    }
    public void getSimContact(Cursor cursor){
        if(cursor == null){
            return;
        }
        Log.d("TAG",""+cursor.getCount());
        while (cursor.moveToNext()) {

            // 得到手机号码
            String phoneNumber = cursor.getString(PHONES_NUMBER_INDEX);
            // 当手机号码为空的或者为空字段 跳过当前循环
            if (TextUtils.isEmpty(phoneNumber))
                continue;
            // 得到联系人名称
            String contactName = cursor
                    .getString(PHONES_DISPLAY_NAME_INDEX);

            Contact contact = new Contact(contactName , phoneNumber) ;
            contacts.add(contact);

        }
        cursor.close();
    }
}
