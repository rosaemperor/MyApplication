//package com.myapplication.utils
//
//import android.databinding.ObservableField
//import com.google.gson.*
//import com.myapplication.bean.UserBean
//import java.lang.reflect.ParameterizedType
//import java.lang.reflect.Type
//import android.icu.lang.UCharacter.GraphemeClusterBreak.T
//import com.google.gson.JsonSerializationContext
//import com.google.gson.JsonElement
//import com.google.gson.Gson
//import com.google.gson.reflect.TypeToken
//import android.icu.lang.UCharacter.GraphemeClusterBreak.T
//import android.icu.lang.UCharacter.GraphemeClusterBreak.T
//
//
//
//
//
//
///**
// * Created by administrator on 2018/5/31.
// */
//object ObservableFieldSerializerDeserializer  : JsonSerializer<ObservableField<*>>,JsonDeserializer<ObservableField<*>>{
//    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): ObservableField<*> {
//        val type = (typeOfT as ParameterizedType).actualTypeArguments[0]
//        return ObservableField(GsonUtils.getGson().fromJson(json, type) as T)
//    }
//
//    override fun serialize(src: ObservableField<*>, typeOfSrc: Type, context: JsonSerializationContext): JsonElement {
//        return context.serialize(src.get())
//    }
//
////    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?){
////        val type = (typeOfT as ParameterizedType).actualTypeArguments[0]
////        return ObservableField(GsonUtils.getGson().fromJson(json, type) )
////    }
//
//
//
//
//}
//}
