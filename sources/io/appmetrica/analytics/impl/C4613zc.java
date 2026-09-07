package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.zc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C4613zc implements J8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fg f11874a;
    public final Le b;
    public final String c = "activation_unlock_event_sending";
    public final AtomicBoolean d;

    public C4613zc(Fg fg, F4 f4, Le le) {
        this.f11874a = fg;
        this.b = le;
        this.d = new AtomicBoolean(le.a(false) || a(f4));
    }

    public final void a(String str) {
        try {
            Fj fj = AbstractC4097ej.f11536a;
            String str2 = this.c;
            JSONObject jSONObjectPut = new JSONObject().put("source", str).put("framework", FrameworkDetector.framework());
            T9 t9H = C4486ua.E.h();
            Bundle applicationMetaData = t9H.d.getApplicationMetaData(t9H.f11362a);
            JSONObject jSONObjectPut2 = jSONObjectPut.put("appmetrica_plugin_id", applicationMetaData != null ? applicationMetaData.getString("io.appmetrica.analytics.plugin_id") : null);
            Wj wj = C4486ua.E.D;
            String string = jSONObjectPut2.put("activation_offset", TimeUnit.SECONDS.convert(wj.f11407a.currentTimeMillis() - wj.b, TimeUnit.MILLISECONDS)).toString();
            fj.getClass();
            fj.a(new Dj(str2, string));
        } catch (Throwable unused) {
        }
    }

    @Override // io.appmetrica.analytics.impl.J8
    public final boolean b() {
        String str;
        if (!this.d.get() && (str = ((C4045ch) this.f11874a.a()).m) != null && !Intrinsics.areEqual(str, "629a824d-c717-4ba5-bc0f-3f3968554d01") && this.d.compareAndSet(false, true)) {
            this.b.b(true);
            a("activation");
        }
        return this.d.get();
    }

    public final void a() {
        if (this.d.compareAndSet(false, true)) {
            this.b.b(true);
            a("timer");
        }
    }

    public static boolean a(F4 f4) {
        String str = f4.f11134a;
        return (str == null || Intrinsics.areEqual(str, "629a824d-c717-4ba5-bc0f-3f3968554d01")) ? false : true;
    }
}
