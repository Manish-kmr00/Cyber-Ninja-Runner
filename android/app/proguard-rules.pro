# FMOD Studio Android SDK Proguard Rules
-keep class org.fmod.** { *; }
-dontwarn org.fmod.**

# TopOn / AnyThink Mediation Proguard Rules
-keep class com.anythink.** { *; }
-dontwarn com.anythink.**
-keepattributes *Annotation*,InnerClasses,Signature,EnclosingMethod

# Mintegral / MBridge Proguard Rules
-keep class com.mbridge.** { *; }
-dontwarn com.mbridge.**

# IAB Open Measurement (OMID) Proguard Rules
-keep class com.iab.omid.** { *; }
-dontwarn com.iab.omid.**

# Tencent MMKV Proguard Rules
-keep class com.tencent.mmkv.** { *; }
-dontwarn com.tencent.mmkv.**


