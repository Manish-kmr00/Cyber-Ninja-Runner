package com.inmobi.media;

import android.content.Context;
import com.safedk.android.internal.partials.InMobiNetworkBridge;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class od {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S8 f3394a;
    public final Y1 b;
    public nd c;

    public od(S8 mNetworkRequest, Y1 mWebViewClient) {
        Intrinsics.checkNotNullParameter(mNetworkRequest, "mNetworkRequest");
        Intrinsics.checkNotNullParameter(mWebViewClient, "mWebViewClient");
        this.f3394a = mNetworkRequest;
        this.b = mWebViewClient;
    }

    public final void a() {
        try {
            Context contextD = C3517pb.d();
            if (contextD != null) {
                nd ndVar = new nd(contextD);
                ndVar.setWebViewClient(this.b);
                ndVar.getSettings().setJavaScriptEnabled(true);
                ndVar.getSettings().setCacheMode(2);
                this.c = ndVar;
            }
            nd ndVar2 = this.c;
            if (ndVar2 != null) {
                String strD = this.f3394a.d();
                S8 s8 = this.f3394a;
                boolean z = W8.f3228a;
                W8.a(s8.i);
                InMobiNetworkBridge.webviewLoadUrl(ndVar2, strD, s8.i);
            }
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("od", "TAG");
        }
    }
}
