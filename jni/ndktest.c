#include<jni.h>
#include<string.h>

jstring Java_com_myapplication_utils_NdkUtils_helloWorld(JNIEnv* env ,jobject obj){

    return (*env)->NewStringUTF(env,"Hello,World,这是从C出来的");
}
jstring Java_com_myapplication_utils_NdkUtils_daozhuanString(JNIEnv* env ,jobject obj){
       return (*env)->NewStringUTF(env,"这是从C出来的,Hello,World");
}