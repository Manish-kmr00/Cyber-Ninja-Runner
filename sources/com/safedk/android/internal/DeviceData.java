package com.safedk.android.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.AppLovinBridge;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.SdksMapping;
import com.safedk.android.utils.j;
import com.safedk.android.utils.n;

/* JADX INFO: loaded from: classes3.dex */
public class DeviceData implements AppLovinCommunicatorSubscriber {
    private static final String A = "is_ad_tracking_enabled";
    private static final String B = "enduser_id";
    private static final String C = "app_version_name";
    private static final String D = "app_version";
    private static final String E = "init_success";
    private static final String F = "value";
    private static final String G = "user_id";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8130a = "sdk_key";
    private static final String l = "DeviceData";
    private static final String m = "values";
    private static final String n = "operator";
    private static final String o = "lte";
    private static final String p = "gte";
    private static final String q = "deactivationPercentage";
    private static final String r = "device_type";
    private static final String s = "applovin_random_token";
    private static final String t = "device_brand";
    private static final String u = "device_model";
    private static final String v = "device_revision";
    private static final String w = "os_version";
    private static final String x = "safedk_version";
    private static final String y = "applovin_version";
    private static final String z = "from_store";
    private j H;
    String b;
    String c;
    int d;
    int e;
    String f;
    String g;
    String h;
    String i;
    String j;
    boolean k = false;

    private enum CriteriaField {
        deviceModel,
        manufacturer,
        country,
        appVersionCode,
        androidVersion,
        osVersion,
        appDeviceIDs,
        age,
        region
    }

    private DeviceData() {
    }

    public DeviceData(final Context context, j prefs) {
        Logger.d(l, "DeviceData started");
        this.H = prefs;
        this.b = Build.MODEL;
        this.c = Build.MANUFACTURER.toLowerCase();
        this.e = Build.VERSION.SDK_INT;
        try {
            new Thread(new Runnable() { // from class: com.safedk.android.internal.DeviceData.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        DeviceData.this.k = DeviceData.this.a(context);
                    } catch (Throwable th) {
                    }
                }
            }).start();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            this.f = packageInfo.versionName;
            this.d = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Logger.e(l, "Error getting device data", e);
        } catch (Throwable th) {
            Logger.e(l, "Error getting device data", th);
        }
        AppLovinBridge.registerToReceiveSafeDKSettings(this);
        AppLovinBridge.registerToReceiveUserInfo(this);
    }

    public String a() {
        if (this.i != null) {
            return this.i;
        }
        if (this.H != null && this.H.n() == this.d) {
            return this.H.m();
        }
        return null;
    }

    public String b() {
        if (this.h != null) {
            return this.h;
        }
        if (this.H != null && this.H.n() == this.d) {
            return this.H.o();
        }
        return null;
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage message) {
        Logger.d(l, "message received " + message.getMessageData());
        Bundle messageData = message.getMessageData();
        if (messageData.containsKey(E)) {
            if (this.H != null) {
                this.h = messageData.getString(s);
                this.i = messageData.getString("sdk_key");
                this.H.a(this.d, this.h, this.i);
                this.g = messageData.getString("device_type");
                SdksMapping.setMaxAdapterVersions(messageData);
                if (Boolean.parseBoolean(messageData.getString(E))) {
                    Logger.d(l, "AppLovinSdk reported success to retrieve settings");
                    SafeDK.getInstance().a(messageData, true);
                } else {
                    SafeDK.getInstance().a(true);
                    Logger.d(l, "AppLovinSdk reported a failure to retrieve settings. The saved settings from a previous session will be used.");
                }
            } else {
                Logger.d(l, "AppLovinSdk prefs is null");
            }
        } else if (messageData.containsKey("value")) {
            this.j = messageData.getString("value");
        } else if (messageData.containsKey("user_id")) {
            this.j = messageData.getString("user_id");
        }
        SafeDK.ad();
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return AppLovinBridge.f7952a;
    }

    public static float a(String str, String str2) {
        return (Math.abs((str + str2).hashCode()) % 100000) / 1000;
    }

    public Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putString("package", SafeDK.getInstance().m().getPackageName());
        bundle.putString("platform", "android");
        bundle.putString(s, b());
        bundle.putString(y, n.a());
        bundle.putString("safedk_version", com.safedk.android.a.f7945a);
        bundle.putString("device_type", this.g);
        bundle.putString(u, Build.MODEL);
        bundle.putString(t, Build.MANUFACTURER);
        bundle.putString(v, Build.DEVICE);
        bundle.putString("os_version", Build.VERSION.RELEASE);
        bundle.putString(D, String.valueOf(this.d));
        bundle.putString("app_version_name", this.f);
        SafeDK.getInstance();
        bundle.putBoolean(z, SafeDK.a());
        bundle.putString(B, this.j);
        bundle.putBoolean(A, this.k);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context) {
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            return (advertisingIdInfo == null || advertisingIdInfo.isLimitAdTrackingEnabled()) ? false : true;
        } catch (Throwable th) {
            return false;
        }
    }
}
