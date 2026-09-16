# FMOD Studio Android SDK Proguard Rules
-keep class org.fmod.** { *; }
-dontwarn org.fmod.**

# TopOn New Platform (Secmtp) Proguard Rules
-keep class com.secmtp.sdk.** { *; }
-keepclassmembers class com.secmtp.sdk.** { *; }
-keep public class com.secmtp.sdk.mediation.adapters.** { public *; }
-dontwarn com.secmtp.sdk.**
-keep class com.anythink.** { *; }
-dontwarn com.anythink.**
-keepattributes *Annotation*,InnerClasses,Signature,EnclosingMethod

# Google Mobile Ads SDK (AdMob) ProGuard Rules
-keep class com.google.android.gms.ads.** { *; }
-dontwarn com.google.android.gms.ads.**



# Tencent MMKV Proguard Rules
-keep class com.tencent.mmkv.** { *; }
-dontwarn com.tencent.mmkv.**


