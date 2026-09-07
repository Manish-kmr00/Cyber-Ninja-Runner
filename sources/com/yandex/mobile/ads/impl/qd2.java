package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class qd2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10007a;
    private final kk2 b;
    private final pd2 c;
    private final ArrayList d;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ qd2(Context context, o3 o3Var, fd2 fd2Var, aa2 aa2Var) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this(context, o3Var, fd2Var, aa2Var, applicationContext, new kk2(applicationContext, o3Var, aa2Var, fd2Var), new pd2());
    }

    public qd2(Context context, o3 adConfiguration, fd2 reportParametersProvider, aa2 requestConfigurationParametersProvider, Context applicationContext, kk2 wrapperAdsLoadManager, pd2 videoAdsResponseFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(reportParametersProvider, "reportParametersProvider");
        Intrinsics.checkNotNullParameter(requestConfigurationParametersProvider, "requestConfigurationParametersProvider");
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(wrapperAdsLoadManager, "wrapperAdsLoadManager");
        Intrinsics.checkNotNullParameter(videoAdsResponseFactory, "videoAdsResponseFactory");
        this.f10007a = applicationContext;
        this.b = wrapperAdsLoadManager;
        this.c = videoAdsResponseFactory;
        this.d = new ArrayList();
    }

    public final void a(List<eb2> videoAds, wp1<List<eb2>> listener) {
        Intrinsics.checkNotNullParameter(videoAds, "videoAds");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.c.getClass();
        od2 od2VarA = pd2.a(videoAds);
        this.d.addAll(od2VarA.a());
        this.b.a(this.f10007a, od2VarA.b(), new a(this, listener));
    }

    private final class a implements wp1<List<? extends eb2>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final wp1<List<eb2>> f10008a;
        final /* synthetic */ qd2 b;

        public a(qd2 qd2Var, wp1<List<eb2>> requestListener) {
            Intrinsics.checkNotNullParameter(requestListener, "requestListener");
            this.b = qd2Var;
            this.f10008a = requestListener;
        }

        private final void a() {
            if (!this.b.d.isEmpty()) {
                this.f10008a.a(this.b.d);
                return;
            }
            d50 error = new d50();
            wp1<List<eb2>> wp1Var = this.f10008a;
            Intrinsics.checkNotNullParameter(error, "error");
            String message = error.getMessage();
            if (message == null) {
                message = "Ad request completed successfully, but there are no ads available.";
            }
            wp1Var.a(new kb2(3, message));
        }

        @Override // com.yandex.mobile.ads.impl.wp1
        public final void a(kb2 error) {
            Intrinsics.checkNotNullParameter(error, "error");
            a();
        }

        @Override // com.yandex.mobile.ads.impl.wp1
        public final void a(List<? extends eb2> list) {
            List<? extends eb2> result = list;
            Intrinsics.checkNotNullParameter(result, "result");
            this.b.c.getClass();
            od2 od2VarA = pd2.a(result);
            this.b.d.addAll(od2VarA.a());
            List<eb2> listB = od2VarA.b();
            if (!listB.isEmpty()) {
                this.b.b.a(this.b.f10007a, listB, this);
            } else {
                a();
            }
        }
    }
}
