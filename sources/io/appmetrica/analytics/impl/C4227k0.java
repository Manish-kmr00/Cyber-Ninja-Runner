package io.appmetrica.analytics.impl;

import android.content.Context;
import com.mbridge.msdk.out.reveue.MBridgeRevenueParamsEntity;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.k0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4227k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4524vn f11625a;
    public volatile Boolean b;
    public Ia c;
    public Ja d;

    public C4227k0() {
        this(new C4524vn());
    }

    public final synchronized Ia a(Context context, C4206j4 c4206j4) {
        if (this.c == null) {
            if (a(context)) {
                this.c = new C4277m0();
            } else {
                this.c = new C4202j0(context, c4206j4);
            }
        }
        return this.c;
    }

    public C4227k0(C4524vn c4524vn) {
        this.f11625a = c4524vn;
    }

    public final boolean a(Context context) {
        Boolean bool = this.b;
        if (bool == null) {
            synchronized (this) {
                bool = this.b;
                if (bool == null) {
                    this.f11625a.getClass();
                    Boolean boolValueOf = Boolean.valueOf(!C4524vn.a(context));
                    this.b = boolValueOf;
                    if (boolValueOf.booleanValue()) {
                        ImportantLogger.INSTANCE.info(MBridgeRevenueParamsEntity.ATTRIBUTION_PLATFORM_APP_METRICA, "User is locked. So use stubs. Events will not be sent.", new Object[0]);
                    }
                    bool = boolValueOf;
                }
            }
        }
        return bool.booleanValue();
    }
}
