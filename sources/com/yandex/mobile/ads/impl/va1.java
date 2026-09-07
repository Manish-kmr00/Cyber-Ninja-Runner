package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.net.Uri;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class va1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v30 f10468a;
    private final ConcurrentHashMap<String, wd2> b;

    public va1(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context appContext = context.getApplicationContext();
        int i = fe2.c;
        Intrinsics.checkNotNullExpressionValue(appContext, "appContext");
        this.f10468a = fe2.b(appContext);
        this.b = new ConcurrentHashMap<>();
    }

    public final void a(String url, wd2 videoCacheListener, String requestId) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(videoCacheListener, "videoCacheListener");
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        if (this.f10468a == null) {
            videoCacheListener.b();
            a();
            return;
        }
        x30 x30VarA = new x30.b(Uri.parse(url), requestId).a();
        this.b.put(requestId, videoCacheListener);
        this.f10468a.a(new ij2(requestId, videoCacheListener));
        this.f10468a.a(x30VarA);
        this.f10468a.a();
    }

    public final void a() {
        Iterator<Map.Entry<String, wd2>> it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            v30 v30Var = this.f10468a;
            if (v30Var != null) {
                v30Var.a(key);
            }
        }
        this.b.clear();
    }

    public final void a(String requestId) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        v30 v30Var = this.f10468a;
        if (v30Var != null) {
            v30Var.a(requestId);
        }
        this.b.remove(requestId);
    }
}
