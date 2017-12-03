package com.myapplication.utils;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;


import com.myapplication.bean.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2017/5/4.
 */

public class GetContactsUtil {
    /**
     * 获取库Phon表字段
     **/
    private  final String[] PHONES_PROJECTION = new String[]{
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Photo.PHOTO_ID, ContactsContract.CommonDataKinds.Phone.CONTACT_ID};
    /**
     * 联系人显示名称
     **/
    private  final int PHONES_DISPLAY_NAME_INDEX = 0;

    /**
     * 电话号码
     **/
    private  final int PHONES_NUMBER_INDEX = 1;

    /**
     * 头像ID
     **/
    private final int PHONES_PHOTO_ID_INDEX = 2;

    /**
     * 联系人的ID
     **/
    private  final int PHONES_CONTACT_ID_INDEX = 3;
    private  String[] PERMISSIONS_CONTACT = {Manifest.permission.READ_CONTACTS, Manifest.permission.READ_SMS};

    /**
     * 联系人名称
     **/
    private ArrayList<String> mContactsName = new ArrayList<String>();

    /**
     * 联系人头像
     **/
    private ArrayList<String> mContactsNumber = new ArrayList<String>();

    /**
     * 联系人头像
     **/
    private ArrayList<Bitmap> mContactsPhonto = new ArrayList<Bitmap>();
    private Context mContext ;
    public GetContactsUtil(Context context){
        this.mContext = context ;
    }

    public List<Contact> getContacts(){
        List<Contact> result = getPhoneContacts() ;
        Log.d("TAG","SIM"+getSIMContacts().size());
        result.addAll(getSIMContacts()) ;

        return  result ;
    }

    /**
     * 得到手机通讯录联系人信息
     **/
    private List<Contact> getPhoneContacts() {
        List<Contact> contacts  = new ArrayList<>() ;
        ContentResolver resolver = mContext.getContentResolver();
        // 获取手机联系人

        Cursor phoneCursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, PHONES_PROJECTION, null, null, null);


        if (phoneCursor != null) {
            while (phoneCursor.moveToNext()) {

                //得到手机号码
                String phoneNumber = phoneCursor.getString(PHONES_NUMBER_INDEX);
                //当手机号码为空的或者为空字段 跳过当前循环
                if (TextUtils.isEmpty(phoneNumber))
                    continue;

                //得到联系人名称
                String contactName = phoneCursor.getString(PHONES_DISPLAY_NAME_INDEX);
                Contact contact = new Contact(contactName , phoneNumber) ;
                contacts.add(contact) ;
            }

            phoneCursor.close();

        }
        return contacts ;
    }

    /**
     * 得到手机SIM卡联系人人信息
     **/
    private List<Contact> getSIMContacts() {
        ContentResolver resolver = mContext.getContentResolver();
        List<Contact> contacts  = new ArrayList<>() ;
        // 获取Sims卡联系人
        Uri uri = Uri.parse("content://sim/adn");
        Cursor phoneCursor = resolver.query(uri, PHONES_PROJECTION, null, null,
                null);

        if (phoneCursor != null) {
            while (phoneCursor.moveToNext()) {

                // 得到手机号码
                String phoneNumber = phoneCursor.getString(PHONES_NUMBER_INDEX);
                // 当手机号码为空的或者为空字段 跳过当前循环
                if (TextUtils.isEmpty(phoneNumber))
                    continue;
                // 得到联系人名称
                String contactName = phoneCursor
                        .getString(PHONES_DISPLAY_NAME_INDEX);

                Contact contact = new Contact(contactName , phoneNumber) ;
                contacts.add(contact);
            }

            phoneCursor.close();
        }
        return contacts ;
    }

}
