package io.appmetrica.analytics.identifiers.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes12.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f11039a;
    public final Function1 b;
    public final String c;
    public final SafePackageManager d;

    public f(e eVar, Function1 function1, String str, SafePackageManager safePackageManager) {
        this.f11039a = eVar;
        this.b = function1;
        this.c = str;
        this.d = safePackageManager;
    }

    public final Object a(Context context) throws g {
        IBinder iBinder;
        if (this.d.resolveService(context, this.f11039a.f11038a, 0) == null) {
            throw new l("could not resolve " + this.c + " services");
        }
        try {
            e eVar = this.f11039a;
            if (context.bindService(eVar.f11038a, eVar, 1)) {
                e eVar2 = this.f11039a;
                if (eVar2.b == null) {
                    synchronized (eVar2.c) {
                        if (eVar2.b == null) {
                            try {
                                eVar2.c.wait(3000L);
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                }
                iBinder = eVar2.b;
            } else {
                iBinder = null;
            }
        } catch (Throwable unused2) {
        }
        if (iBinder != null) {
            return this.b.invoke(iBinder);
        }
        throw new g("could not bind to " + this.c + " services");
    }

    public final void b(Context context) {
        try {
            this.f11039a.a(context);
        } catch (Throwable unused) {
        }
    }

    public f(Intent intent, Function1 function1, String str) {
        this(new e(intent, str), function1, str, new SafePackageManager());
    }
}
