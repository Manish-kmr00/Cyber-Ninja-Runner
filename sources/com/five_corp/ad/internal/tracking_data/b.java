package com.five_corp.ad.internal.tracking_data;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1553a;

    public b(Context context) {
        this.f1553a = context;
    }

    public final a a() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new RuntimeException("UI Thread cannot run this method");
        }
        for (int i = 1; i <= 3; i++) {
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.f1553a);
                if (advertisingIdInfo != null) {
                    return new a(advertisingIdInfo.getId(), advertisingIdInfo.isLimitAdTrackingEnabled());
                }
            } catch (Exception unused) {
            }
        }
        return new a(null, true);
    }
}
