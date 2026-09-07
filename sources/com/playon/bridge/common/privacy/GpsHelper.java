package com.playon.bridge.common.privacy;

import android.content.Context;
import com.json.b9;
import com.playon.bridge.common.Log;
import com.playon.bridge.common.MethodBuilderFactory;

/* JADX INFO: loaded from: classes13.dex */
public class GpsHelper {
    protected static final String TAG = Log.makeTag("GPSHelper");
    private static final String sAdvertisingIdClientClassName = "com.google.android.gms.ads.identifier.AdvertisingIdClient";

    public static class AdvertisingInfo {
        public final String advertisingId;
        public final boolean limitAdTracking;

        public AdvertisingInfo(String str, boolean z) {
            this.advertisingId = str;
            this.limitAdTracking = z;
        }
    }

    public static AdvertisingInfo fetchAdvertisingInfoSync(Context context) {
        if (context == null) {
            return null;
        }
        try {
            Object objExecute = MethodBuilderFactory.create(null, "getAdvertisingIdInfo").setStatic(Class.forName(sAdvertisingIdClientClassName)).addParam((Class<Context>) Context.class, context).execute();
            return new AdvertisingInfo(reflectedGetAdvertisingId(objExecute), reflectedIsLimitAdTrackingEnabled(objExecute));
        } catch (Exception unused) {
            Log.d(TAG, "Unable to obtain Google AdvertisingIdClient.Info via reflection.");
            return null;
        }
    }

    static String reflectedGetAdvertisingId(Object obj) {
        try {
            return (String) MethodBuilderFactory.create(obj, "getId").execute();
        } catch (Exception unused) {
            return "";
        }
    }

    static boolean reflectedIsLimitAdTrackingEnabled(Object obj) {
        try {
            Boolean bool = (Boolean) MethodBuilderFactory.create(obj, b9.i.M).execute();
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
