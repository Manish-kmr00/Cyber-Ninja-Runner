package com.ogury.core.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.ogury.core.internal.advertising.AdvertisingInfo;
import com.ogury.sdk.BuildConfig;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridge;
import com.unity3d.services.core.properties.MadeWithUnityDetector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: InternalCore.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007J\b\u0010\u000b\u001a\u00020\tH\u0007J\b\u0010\f\u001a\u00020\tH\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J \u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J \u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH\u0007J \u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0019H\u0007J\u0018\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\tH\u0007J\u001a\u0010\u001b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\tH\u0007J\u0018\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\tH\u0007J\u001a\u0010\u001d\u001a\f\u0012\u0004\u0012\u00020\t\u0012\u0002\b\u00030\u001e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\u001f"}, d2 = {"Lcom/ogury/core/internal/InternalCore;", "", "<init>", "()V", "getAdvertisingInfo", "Lcom/ogury/core/internal/advertising/AdvertisingInfo;", "context", "Landroid/content/Context;", "getToken", "", "keyName", MobileAdsBridge.versionMethodName, "getFrameworkName", "setOnPrivacyDataChangeListener", "", "onConsentDataChanged", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "onOguryPrivacyDataChanged", "retrieveGppConsentString", "retrieveGppSectionIdsString", "retrieveTcfConsentString", "storePrivacyData", "key", "value", "", "", "retrievePrivacyDataBoolean", "retrievePrivacyDataString", "retrievePrivacyDataInt", "getAllPublisherData", "", "sdk-core_prodRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InternalCore {
    public static final InternalCore INSTANCE = new InternalCore();

    private InternalCore() {
    }

    @JvmStatic
    public static final AdvertisingInfo getAdvertisingInfo(Context context) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            a aVarA = c.a(context);
            if (aVarA == null || (str = aVarA.f7486a) == null) {
                throw new IllegalStateException("Advertising Id is null".toString());
            }
            return new AdvertisingInfo(str, !aVarA.b);
        } catch (Exception unused) {
            return new AdvertisingInfo("00000000-0000-0000-0000-000000000000", true);
        }
    }

    @JvmStatic
    public static final Map<String, ?> getAllPublisherData(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(context, "context");
        PreferenceManager.getDefaultSharedPreferences(context);
        Map<String, ?> all = context.getSharedPreferences("ogury_privacy_data", 0).getAll();
        Intrinsics.checkNotNullExpressionValue(all, "getAll(...)");
        return all;
    }

    @JvmStatic
    public static final String getFrameworkName() {
        e eVar;
        i reflectionUtil = new i();
        Intrinsics.checkNotNullParameter(reflectionUtil, "reflectionUtil");
        if (i.a(MadeWithUnityDetector.UNITY_PLAYER_CLASS_NAME)) {
            eVar = new e("Unity");
        } else if (i.a("org.apache.cordova.CordovaWebView")) {
            eVar = new e("Cordova");
        } else if (i.a("mono.android.Runtime")) {
            eVar = new e("Xamarin");
        } else {
            eVar = i.a("com.adobe.fre.FREFunction") ? new e("Adobe Air") : new e("Native");
        }
        return eVar.f7489a;
    }

    @JvmStatic
    public static final String getToken(Context context, String keyName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyName, "keyName");
        return new h(context).a(keyName);
    }

    @JvmStatic
    public static final String getVersion() {
        return BuildConfig.CORE_VERSION;
    }

    @JvmStatic
    public static final String retrieveGppConsentString(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        context.getSharedPreferences("ogury_privacy_data", 0);
        Intrinsics.checkNotNullParameter("IABGPP_HDR_GppString", "key");
        if (StringsKt.isBlank("IABGPP_HDR_GppString")) {
            throw new IllegalArgumentException("Key cannot be blank".toString());
        }
        return defaultSharedPreferences.getString("IABGPP_HDR_GppString", null);
    }

    @JvmStatic
    public static final String retrieveGppSectionIdsString(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        context.getSharedPreferences("ogury_privacy_data", 0);
        Intrinsics.checkNotNullParameter("IABGPP_GppSID", "key");
        if (StringsKt.isBlank("IABGPP_GppSID")) {
            throw new IllegalArgumentException("Key cannot be blank".toString());
        }
        return defaultSharedPreferences.getString("IABGPP_GppSID", null);
    }

    @JvmStatic
    public static final boolean retrievePrivacyDataBoolean(Context context, String key) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(context, "context");
        PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences("ogury_privacy_data", 0);
        Intrinsics.checkNotNullParameter(key, "key");
        return sharedPreferences.getBoolean(key, false);
    }

    @JvmStatic
    public static final int retrievePrivacyDataInt(Context context, String key) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(context, "context");
        PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences("ogury_privacy_data", 0);
        Intrinsics.checkNotNullParameter(key, "key");
        return sharedPreferences.getInt(key, -1);
    }

    @JvmStatic
    public static final String retrievePrivacyDataString(Context context, String key) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(context, "context");
        PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences("ogury_privacy_data", 0);
        Intrinsics.checkNotNullParameter(key, "key");
        return sharedPreferences.getString(key, null);
    }

    @JvmStatic
    public static final String retrieveTcfConsentString(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        context.getSharedPreferences("ogury_privacy_data", 0);
        Intrinsics.checkNotNullParameter("IABTCF_TCString", "key");
        if (StringsKt.isBlank("IABTCF_TCString")) {
            throw new IllegalArgumentException("Key cannot be blank".toString());
        }
        return defaultSharedPreferences.getString("IABTCF_TCString", null);
    }

    @JvmStatic
    public static final void setOnPrivacyDataChangeListener(Context context, SharedPreferences.OnSharedPreferenceChangeListener onConsentDataChanged, SharedPreferences.OnSharedPreferenceChangeListener onOguryPrivacyDataChanged) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onConsentDataChanged, "onConsentDataChanged");
        Intrinsics.checkNotNullParameter(onOguryPrivacyDataChanged, "onOguryPrivacyDataChanged");
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences("ogury_privacy_data", 0);
        Intrinsics.checkNotNullParameter(onConsentDataChanged, "onConsentDataChanged");
        Intrinsics.checkNotNullParameter(onOguryPrivacyDataChanged, "onPublisherDataChanged");
        defaultSharedPreferences.registerOnSharedPreferenceChangeListener(onConsentDataChanged);
        sharedPreferences.registerOnSharedPreferenceChangeListener(onOguryPrivacyDataChanged);
    }

    @JvmStatic
    public static final void storePrivacyData(Context context, String key, boolean value) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        new j(context).a(key, Boolean.valueOf(value));
    }

    @JvmStatic
    public static final void storePrivacyData(Context context, String key, String value) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        new j(context).a(key, value);
    }

    @JvmStatic
    public static final void storePrivacyData(Context context, String key, int value) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        new j(context).a(key, Integer.valueOf(value));
    }
}
