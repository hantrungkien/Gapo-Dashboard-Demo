# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

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


##---------------Begin: proguard configuration common for all Android apps ----------
-optimizationpasses 5
-verbose
#-dump class_files.txt
-printseeds seeds.txt
-printusage unused.txt
-printmapping mapping.txt
-optimizations !code/simplification/arithmetic,!code/simplification/cast,!code/simplification/advanced,!class/merging/*,!code/allocation/variable,!field/*,!method/removal/parameter,!method/propagation/parameter,!method/inlining/*
#-repackageclasses ''
-keeppackagenames doNotKeepAThing
-dontnote
-allowaccessmodification
-dontwarn **
-target 1.8
#-useuniqueclassmembernames
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontpreverify

-keepclassmembers class com.google.protobuf.** {
    public <methods>;
    public static <fields>;
}

-keepattributes *Annotation*
-keepattributes SourceFile,LineNumberTable

-keepnames class * implements java.io.Serializable

-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    !static !transient <fields>;
    !private <fields>;
    !private <methods>;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

-keepclassmembers class * implements android.os.Parcelable {
      public static final android.os.Parcelable$Creator *;
}

-keep interface org.parceler.Parcel
-keep @org.parceler.Parcel class * { *; }
-keep class **$$Parcelable { *; }

-keepclasseswithmembernames class * {
 native <methods>;
}

-keepclasseswithmembers class * {
 public <init>(android.content.Context, android.util.AttributeSet);
 public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclassmembers class **.R$* {
 public static <fields>;
}

-keep class com.squareup.okhttp.** { *; }
-keep interface com.squareup.okhttp.** { *; }
-dontwarn com.squareup.okhttp.**
-keep class com.squareup.okhttp3.** {
*;
}
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase
-dontwarn okhttp3.internal.platform.ConscryptPlatform

-dontwarn javax.annotation.**

-dontwarn org.codehaus.mojo.animal_sniffer.*

-dontwarn okio.**
-dontwarn kotlin.Unit
-dontwarn kotlin.**
-dontwarn kotlin.reflect.jvm.internal.**
-dontwarn retrofit2.KotlinExtensions
-keepattributes Signature
-keepattributes InnerClasses, EnclosingMethod
-keepattributes Exceptions
-keepattributes RuntimeVisibleAnnotations, RuntimeVisibleParameterAnnotations
-keepclassmembers,allowshrinking,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}
-if interface * { @retrofit2.http.* <methods>; }
-keep,allowobfuscation interface <1>
-dontnote retrofit2.Platform
-dontwarn retrofit2.Platform$Java8

-dontwarn com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork

-keepnames public class * extends io.realm.RealmObject
-keep class io.realm.annotations.RealmModule
-keep @io.realm.annotations.RealmModule class *
-keep class io.realm.internal.Keep
-keep @io.realm.internal.Keep class * { *; }
-dontwarn io.realm.*

-keepclassmembers class * {
    @org.greenrobot.eventbus.Subscribe <methods>;
}
-keep enum org.greenrobot.eventbus.ThreadMode { *; }

-assumenosideeffects class android.util.Log {
    public static boolean isLoggable(java.lang.String, int);
    public static int v(...);
    public static int i(...);
    public static int w(...);
    public static int d(...);
    public static int e(...);
}

-assumenosideeffects class java.io.PrintStream {
    public void println(...);
    public void print(...);
}

-assumenosideeffects class kotlin.jvm.internal.Intrinsics {
    public static void checkExpressionValueIsNotNull(...);
    public static void checkReturnedValueIsNotNull(...);
    public static void checkFieldIsNotNull(...);
    public static void checkParameterIsNotNull(...);
    public static void checkNotNullExpressionValue(...);
    public static void checkNotNullParameter(...);
    public static void checkNotNullExpressionValue(...);
    public static void checkNotNull(...);
    public static void thowUninitializedPropertyAccessException(...);
}

-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.module.AppGlideModule
-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
-dontwarn com.bumptech.glide.load.resource.bitmap.VideoDecoder

-keep interface kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader
-keep class kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader
-keep class kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoaderImpl
-keep class kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsLoaderImpl
-keep class kotlin.reflect.jvm.internal.impl.load.java.FieldOverridabilityCondition
-keep class kotlin.reflect.jvm.internal.impl.load.java.ErasedOverridabilityCondition
-keep class kotlin.reflect.jvm.internal.impl.load.java.JavaIncompatibilityRulesOverridabilityCondition

-keep class kotlin.Metadata { *; }
-keepclassmembers class kotlin.Metadata {
    public <methods>;
}
-dontwarn org.jetbrains.annotations.**

-keep class android.transition.** { *; }
-keep class androidx.transition.** { *; }
-keep class android.animation.** { *; }
-keep class androidx.appcompat.graphics.drawable.DrawerArrowDrawable { *; }

-keepattributes SourceFile,LineNumberTable
-keep public class * extends java.lang.Exception
-keep class com.google.firebase.crashlytics.** { *; }
-dontwarn com.google.firebase.crashlytics.**

-keep class * extends androidx.databinding.DataBinderMapper { *; }

-keep class com.google.crypto.** { *; }

-keep,allowoptimization class com.google.android.gms.maps.** { *; }
-keep,allowoptimization class com.google.android.libraries.maps.** { *; }
-keep,allowoptimization class com.google.android.apps.gmm.renderer.** { *; }

-keep class androidx.navigation.fragment.NavHostFragment

-keep @interface com.airbnb.deeplinkdispatch.DeepLink
-keepclasseswithmembers class * {
    @com.airbnb.deeplinkdispatch.DeepLink <methods>;
}
-keep public class * extends com.airbnb.deeplinkdispatch.BaseRegistry
-keepclasseswithmembers class * {
    @com.airbnb.deeplinkdispatch.DeepLinkModule <methods>;
}

##---------------End: proguard configuration common for all Android apps ----------