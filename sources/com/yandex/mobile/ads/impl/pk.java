package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class pk<T> extends np1<T> {
    private static final int w = (int) TimeUnit.SECONDS.toMillis(10);
    private final Context s;
    private final a<T> t;
    private final xp1 u;
    private final fq1 v;

    public interface a<T> extends qq1.b<T>, qq1.a {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pk(Context context, int i, String url, a<T> listener, xp1 xp1Var) {
        super(i, url, listener);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.s = context;
        this.t = listener;
        this.u = xp1Var;
        q();
        a(new j00(1.0f, w, 0));
        this.v = fq1.b;
    }

    @Override // com.yandex.mobile.ads.impl.np1
    protected ki2 b(ki2 volleyError) {
        Intrinsics.checkNotNullParameter(volleyError, "volleyError");
        tc1 tc1Var = volleyError.b;
        a(tc1Var != null ? Integer.valueOf(tc1Var.f10286a) : null);
        Intrinsics.checkNotNullExpressionValue(volleyError, "parseNetworkError(...)");
        return volleyError;
    }

    protected fq1 w() {
        return this.v;
    }

    public /* synthetic */ pk(Context context, String str, a aVar) {
        this(context, 0, str, aVar, null);
    }

    public final void x() {
        xp1 xp1Var = this.u;
        if (xp1Var != null) {
            xp1Var.b();
        }
    }

    protected final void a(Integer num) {
        Context context = this.s;
        Intrinsics.checkNotNullParameter(context, "context");
        int i = n2.e;
        n2.a.a(context).a(w(), num);
    }

    @Override // com.yandex.mobile.ads.impl.np1
    protected final void a(T t) {
        this.t.a(t);
    }

    protected final void a(Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        String strA = kf0.a(headers, sh0.c0);
        if (strA != null) {
            hx1.a aVar = hx1.f9146a;
            Context context = this.s;
            aVar.getClass();
            hx1.a.a(context).a(strA);
        }
    }
}
