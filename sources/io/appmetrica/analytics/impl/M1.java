package io.appmetrica.analytics.impl;

import android.content.Context;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class M1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4163ha f11251a;
    public boolean b;

    public M1() {
        this(new C4163ha());
    }

    public final synchronized long a(Context context) {
        String strA;
        try {
            this.f11251a.getClass();
            strA = Qa.a(FileUtils.getFileFromAppStorage(context, "metrica_service_settings.dat"));
        } catch (Throwable unused) {
        }
        return !TextUtils.isEmpty(strA) ? new JSONObject(strA).optLong("delay") : 0L;
    }

    public final void b(Context context) {
        synchronized (this) {
        }
        if (this.b) {
            return;
        }
        long jA = a(context);
        if (jA > 0) {
            try {
                Thread.sleep(jA);
            } catch (Throwable unused) {
            }
        }
        this.b = true;
    }

    public M1(C4163ha c4163ha) {
        this.b = false;
        this.f11251a = c4163ha;
    }
}
