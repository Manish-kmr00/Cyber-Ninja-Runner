package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import java.util.Map;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.rk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4421rk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11754a;
    public final C4297mk b;
    public final C4397qk c;
    public final IBinaryDataHelper d;

    public C4421rk(Context context, C4108f5 c4108f5) {
        c4108f5.a();
        this.f11754a = "session_extras";
        this.b = new C4297mk();
        this.c = new C4397qk();
        this.d = C4135g7.a(context).a(c4108f5);
    }

    public final Map a() {
        try {
            byte[] bArr = this.d.get(this.f11754a);
            if (bArr != null) {
                if (!(bArr.length == 0)) {
                    return this.b.toModel(this.c.toState(bArr));
                }
            }
        } catch (Throwable unused) {
        }
        C4297mk c4297mk = this.b;
        this.c.getClass();
        return c4297mk.toModel(new C4347ok());
    }
}
