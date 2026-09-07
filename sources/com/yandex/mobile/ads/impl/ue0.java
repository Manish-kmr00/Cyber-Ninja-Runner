package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class ue0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final co1 f10380a;
    private final mc b;
    private final Context c;

    public /* synthetic */ ue0(Context context) {
        this(context, new co1(), new mc());
    }

    public ue0(Context context, co1 reflectHelper, mc advertisingInfoCreator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reflectHelper, "reflectHelper");
        Intrinsics.checkNotNullParameter(advertisingInfoCreator, "advertisingInfoCreator");
        this.f10380a = reflectHelper;
        this.b = advertisingInfoCreator;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.c = applicationContext;
    }

    public final lc a() {
        Class<?> cls;
        try {
            this.f10380a.getClass();
            Intrinsics.checkNotNullParameter("com.google.android.gms.ads.identifier.AdvertisingIdClient", "className");
            try {
                cls = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            } catch (Throwable unused) {
                op0.c("com.google.android.gms.ads.identifier.AdvertisingIdClient");
                cls = null;
            }
            if (cls == null) {
                return null;
            }
            co1 co1Var = this.f10380a;
            Object[] objArr = {this.c};
            co1Var.getClass();
            Object objA = co1.a(cls, "getAdvertisingIdInfo", objArr);
            if (objA == null) {
                return null;
            }
            String str = (String) co1.a.a(objA, "getId", new Object[0]);
            Boolean bool = (Boolean) co1.a.a(objA, com.ironsource.b9.i.M, new Object[0]);
            this.b.getClass();
            if (bool == null || str == null) {
                return null;
            }
            return new lc(str, bool.booleanValue());
        } catch (Throwable unused2) {
            op0.c(new Object[0]);
            return null;
        }
    }
}
