package com.fyber.inneractive.sdk.config;

import android.content.Context;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.fyber.inneractive.sdk.util.IAlog;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/* JADX INFO: loaded from: classes13.dex */
public abstract class O {
    public static void a(Context context, C3092w c3092w) {
        boolean zIsLimitAdTrackingEnabled;
        String id = null;
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            zIsLimitAdTrackingEnabled = advertisingIdInfo.isLimitAdTrackingEnabled();
            try {
                IAlog.e("limit ad tracking: %s", Boolean.valueOf(zIsLimitAdTrackingEnabled));
                if (zIsLimitAdTrackingEnabled) {
                    IAlog.e("user has opt out of Ads Personalization. not accessing Advertising ID.", new Object[0]);
                } else {
                    id = advertisingIdInfo.getId();
                    IAlog.e("advertising id: %s", id);
                }
            } catch (Throwable th) {
                th = th;
                IAlog.e("Handled Exception:", new Object[0]);
                IAlog.e(AbstractC3256u.a(th), new Object[0]);
                IAlog.c("Advertising ID is not available. Please add Google Play Services library to improve your ad targeting.", new Object[0]);
            }
        } catch (Throwable th2) {
            th = th2;
            zIsLimitAdTrackingEnabled = false;
        }
        synchronized (c3092w) {
            C3091v c3091v = c3092w.b;
            c3091v.f1728a = id;
            c3091v.b = zIsLimitAdTrackingEnabled;
            c3091v.c = false;
        }
    }
}
