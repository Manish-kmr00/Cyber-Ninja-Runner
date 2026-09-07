package com.ogury.ad.internal;

import android.content.Context;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class e0 extends v0 {
    public final d5 c;

    /* JADX WARN: Illegal instructions before constructor call */
    public e0(Context context, d5 webView) {
        d4.a aVar = d4.e;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        d4 monitoringEventLogger = aVar.a(applicationContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(monitoringEventLogger, "monitoringEventLogger");
        super(webView.getMraidCommandExecutor(), monitoringEventLogger);
        this.c = webView;
    }

    @Override // com.ogury.ad.internal.v0
    public final void a(boolean z) {
        d();
    }

    @Override // com.ogury.ad.internal.v0
    public final void b(c ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        d();
    }

    @Override // com.ogury.ad.internal.v0
    public final void c(boolean z) {
        this.c.setShowSdkCloseButton(z);
    }

    public final void d() {
        d5 webView = this.c;
        w4 w4Var = webView.p;
        w4Var.getClass();
        Intrinsics.checkNotNullParameter(webView, "webView");
        w4Var.c.a(webView.getMraidCommandExecutor());
        d5 d5Var = this.c;
        m4 m4Var = d5Var.n;
        String cacheId = d5Var.f7280a.b;
        m4Var.getClass();
        Intrinsics.checkNotNullParameter(cacheId, "cacheId");
        Iterator it = m4.b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (Intrinsics.areEqual(entry.getKey(), cacheId)) {
                it.remove();
                u5 u5Var = ((l4) entry.getValue()).f7343a.get();
                if (u5Var != null) {
                    u5Var.a(((l4) entry.getValue()).c);
                }
            }
        }
        f5 f5Var = d5Var.m;
        if (f5Var != null) {
            f5Var.a();
        }
    }
}
