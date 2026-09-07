package com.inmobi.media;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: renamed from: com.inmobi.media.qc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3532qc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C3532qc f3412a = new C3532qc();
    public static F0 b;

    public static void e() {
        boolean z;
        boolean zBooleanValue;
        F0 f0;
        try {
            Context contextD = C3517pb.d();
            if (contextD != null) {
                F0 f1 = new F0();
                try {
                    Reflection.getOrCreateKotlinClass(AdvertisingIdClient.class).getSimpleName();
                    try {
                        AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(contextD);
                        Intrinsics.checkNotNullExpressionValue(advertisingIdInfo, "getAdvertisingIdInfo(...)");
                        f1.a(advertisingIdInfo.getId());
                        f1.a(advertisingIdInfo.isLimitAdTrackingEnabled());
                        b = f1;
                        Boolean bool = I9.b;
                        if (bool == null) {
                            Context contextD2 = C3517pb.d();
                            z = false;
                            if (contextD2 != null) {
                                ConcurrentHashMap concurrentHashMap = K5.b;
                                K5 k5A = J5.a(contextD2, "user_info_store");
                                Intrinsics.checkNotNullParameter("user_age_restricted", "key");
                                I9.b = Boolean.valueOf(k5A.f3112a.getBoolean("user_age_restricted", false));
                            }
                            Boolean bool2 = I9.b;
                            if (bool2 != null) {
                                zBooleanValue = bool2.booleanValue();
                            }
                            if (z && (f0 = b) != null) {
                                f0.a((String) null);
                            }
                            return;
                        }
                        zBooleanValue = bool.booleanValue();
                        z = zBooleanValue;
                        if (z) {
                            f0.a((String) null);
                        }
                    } catch (Exception unused) {
                        Intrinsics.checkNotNullExpressionValue("qc", "TAG");
                    }
                } catch (NoClassDefFoundError unused2) {
                }
            }
        } catch (Exception unused3) {
            Intrinsics.checkNotNullExpressionValue("qc", "TAG");
        }
    }

    public static final void f() {
        e();
    }

    public final void a() {
        try {
            e();
            d();
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("qc", "TAG");
        }
    }

    public final F0 b() {
        return b;
    }

    public final Boolean c() {
        F0 f0 = b;
        if (f0 != null) {
            return f0.c();
        }
        return null;
    }

    public final void d() {
        String strA;
        try {
            F0 f0 = b;
            if (f0 == null || (strA = f0.a()) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue("qc", "TAG");
            AbstractC3498o6.a((byte) 2, "qc", "Publisher device Id is ".concat(strA));
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("qc", "TAG");
        }
    }

    public final void a(boolean z) {
        F0 f0 = b;
        if (f0 == null) {
            return;
        }
        if (z) {
            f0.a((String) null);
        } else if (f0.a() == null) {
            C3517pb.a(new Runnable() { // from class: com.inmobi.media.qc$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C3532qc.f();
                }
            });
        }
    }
}
