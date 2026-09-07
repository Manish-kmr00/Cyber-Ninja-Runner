package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class re2 {
    public static final a c = new a(0);
    private static volatile re2 d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10101a;
    private final bq1 b;

    private re2(Context context) {
        Context appContext = context.getApplicationContext();
        this.f10101a = appContext;
        Intrinsics.checkNotNullExpressionValue(appContext, "appContext");
        this.b = zk2.a(appContext, 4);
    }

    public final void a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Context context = this.f10101a;
        Intrinsics.checkNotNullExpressionValue(context, "appContext");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        this.b.a(new gh1(context, url, new qi2()));
    }

    public /* synthetic */ re2(Context context, int i) {
        this(context);
    }

    public static final class a {
        @JvmStatic
        public final re2 a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            re2 re2Var = re2.d;
            if (re2Var == null) {
                synchronized (this) {
                    re2Var = re2.d;
                    if (re2Var == null) {
                        re2Var = new re2(context, 0);
                        re2.d = re2Var;
                    }
                }
            }
            return re2Var;
        }

        private a() {
        }

        public /* synthetic */ a(int i) {
            this();
        }
    }
}
