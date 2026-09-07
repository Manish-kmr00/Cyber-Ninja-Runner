package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class le1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9505a;
    private final ne1 b;
    private final zp1 c;
    private final iw1 d;

    public le1(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f9505a = context.getApplicationContext();
        this.b = oe1.a(context);
        int i = zp1.c;
        this.c = zp1.a.a();
        int i2 = iw1.l;
        this.d = iw1.a.a();
    }

    public final void a() {
        zp1 zp1Var = this.c;
        Context appContext = this.f9505a;
        Intrinsics.checkNotNullExpressionValue(appContext, "appContext");
        zp1Var.getClass();
        zp1.a(appContext, "om_sdk_js_request_tag");
    }

    public final void a(ua2 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        iw1 iw1Var = this.d;
        Context appContext = this.f9505a;
        Intrinsics.checkNotNullExpressionValue(appContext, "appContext");
        cu1 cu1VarA = iw1Var.a(appContext);
        String strF = cu1VarA != null ? cu1VarA.F() : null;
        String strB = this.b.b();
        if (strF != null && strF.length() > 0 && !Intrinsics.areEqual(strF, strB)) {
            a aVar = new a(this, strF, listener);
            x22 request = new x22(strF, aVar, aVar);
            request.b((Object) "om_sdk_js_request_tag");
            zp1 zp1Var = this.c;
            Context context = this.f9505a;
            Intrinsics.checkNotNullExpressionValue(context, "appContext");
            synchronized (zp1Var) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(request, "request");
                dd1.a(context).a(request);
            }
            return;
        }
        me1.a(me1.this);
    }

    private final class a implements qq1.b<String>, qq1.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9506a;
        private final ua2 b;
        final /* synthetic */ le1 c;

        public a(le1 le1Var, String omSdkControllerUrl, ua2 listener) {
            Intrinsics.checkNotNullParameter(omSdkControllerUrl, "omSdkControllerUrl");
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.c = le1Var;
            this.f9506a = omSdkControllerUrl;
            this.b = listener;
        }

        @Override // com.yandex.mobile.ads.impl.qq1.a
        public final void a(ki2 error) {
            Intrinsics.checkNotNullParameter(error, "error");
            this.b.a();
        }

        @Override // com.yandex.mobile.ads.impl.qq1.b
        public final void a(String str) {
            String response = str;
            Intrinsics.checkNotNullParameter(response, "response");
            this.c.b.a(response);
            this.c.b.b(this.f9506a);
            this.b.a();
        }
    }
}
