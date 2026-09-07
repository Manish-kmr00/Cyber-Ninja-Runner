package com.apm.insight.j;

import android.content.Context;
import android.os.Handler;
import com.apm.insight.e;
import com.apm.insight.runtime.n;
import com.apm.insight.runtime.q;
import java.util.Map;

/* JADX INFO: compiled from: CommonParamsTask.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b extends a {
    private static Runnable b = new Runnable() { // from class: com.apm.insight.j.b.1
        @Override // java.lang.Runnable
        public final void run() {
            n.a().a().removeCallbacks(this);
            n.a().a(new b(n.a().a(), e.g()));
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f220a;

    public b(Handler handler, Context context) {
        super(handler, 30000L);
        this.f220a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Map<String, Object> commonParams;
        try {
            commonParams = e.a().c().getCommonParams();
        } catch (Throwable unused) {
            commonParams = null;
        }
        if (commonParams != null) {
            try {
                if (com.apm.insight.nativecrash.b.a(commonParams)) {
                    a(b());
                    return;
                }
            } catch (Throwable unused2) {
                return;
            }
        }
        q.a().a(commonParams, com.apm.insight.entity.b.b());
    }

    public static void c() {
        n.a().a(b, 100L);
    }
}
