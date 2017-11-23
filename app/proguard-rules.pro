# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in C:\Users\Administrator\AppData\Local\Android\Sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses

-optimizations !code/simplification/cast,!field/*,!class/merging/*
-keep @com.facebook.common.internal.DoNotStrip class *
-keepclassmembers class * {
    @com.facebook.common.internal.DoNotStrip *;
}
#############################################
       #
       # Android开发中一些需要保留的公共部分
       #
       #############################################

       # 保留我们使用的四大组件，自定义的Application等等这些类不被混淆
       # 因为这些子类都有可能被外部调用
       -keep public class * extends android.app.Activity
       -keep public class * extends android.app.Appliction
       -keep public class * extends android.app.Service
       -keep public class * extends android.content.BroadcastReceiver
       -keep public class * extends android.content.ContentProvider
       -keep public class * extends android.app.backup.BackupAgentHelper
       -keep public class * extends android.preference.Preference
       -keep public class * extends android.view.View
       -keep public class com.android.vending.licensing.ILicensingService
# 保留support下的所有类及其内部类
       -keep class android.support.** {*;}
       # 保留继承的
              -keep public class * extends android.support.v4.**
              -keep public class * extends android.support.v7.**
              -keep public class * extends android.support.annotation.**

# 保留在Activity中的方法参数是view的方法，
       # 这样以来我们在layout中写的onClick就不会被影响
       -keepclassmembers class * extends android.app.Activity{
           public void *(android.view.View);
       }
# Keep native methods
-keepclassmembers class * {
    native <methods>;
}

-dontwarn okio.**
-dontwarn com.squareup.okhttp.**
-dontwarn okhttp3.**
-dontwarn javax.annotation.**
-dontwarn com.android.volley.toolbox.**
-dontwarn com.facebook.infer.**


-keep class retrofit2.** { *; }
-dontwarn retrofit2.**
-keepattributes Signature
-keepattributes Exceptions
-dontwarn okio.**
-dontwarn javax.annotation.**

#zxing
-dontwarn com.google.zxing.**
-keep class com.google.zxing.** {*;} #gson
-keep class com.google.gson.** { *; }
# okhttp
-dontwarn com.squareup.okhttp.**
-keep class com.squareup.okhttp.** {*;}
-keep interface com.squareup.okhttp.** { *; }
-dontwarn okio.**
-keep class okio.** {*;}
#x5 core
-dontwarn com.tencent.**
-keep class com.tencent.**{*;}
