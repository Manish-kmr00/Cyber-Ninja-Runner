package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class s90 extends z80 {
    private final p71 A;
    private final v91 B;
    private final pg0 C;
    private final w90 x;
    private final v7 y;
    private final qt1 z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s90(Context context, uu1 sdkEnvironmentModule, o3 adConfiguration, w90 feedItemLoadListener, v7 adRequestData, ha0 ha0Var, qt1 sdkAdapterReporter, p71 requestParameterManager, v91 nativeResponseCreator, pg0 htmlAdResponseReportManager) {
        super(context, adConfiguration, new g5(), ha0Var);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(feedItemLoadListener, "feedItemLoadListener");
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        Intrinsics.checkNotNullParameter(sdkAdapterReporter, "sdkAdapterReporter");
        Intrinsics.checkNotNullParameter(requestParameterManager, "requestParameterManager");
        Intrinsics.checkNotNullParameter(nativeResponseCreator, "nativeResponseCreator");
        Intrinsics.checkNotNullParameter(htmlAdResponseReportManager, "htmlAdResponseReportManager");
        this.x = feedItemLoadListener;
        this.y = adRequestData;
        this.z = sdkAdapterReporter;
        this.A = requestParameterManager;
        this.B = nativeResponseCreator;
        this.C = htmlAdResponseReportManager;
    }

    public final class a implements wq1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final o8<String> f10185a;
        final /* synthetic */ s90 b;

        public a(s90 s90Var, o8<String> adResponse) {
            Intrinsics.checkNotNullParameter(adResponse, "adResponse");
            this.b = s90Var;
            this.f10185a = adResponse;
        }

        @Override // com.yandex.mobile.ads.impl.wq1
        public final void a(w3 adRequestError) {
            Intrinsics.checkNotNullParameter(adRequestError, "adRequestError");
            this.b.z.a(this.b.l(), this.f10185a, this.b.A);
            this.b.z.a(this.b.l(), this.f10185a, (q71) null);
        }

        @Override // com.yandex.mobile.ads.impl.wq1
        public final void a(u61 nativeAdResponse) {
            Intrinsics.checkNotNullParameter(nativeAdResponse, "nativeAdResponse");
            q71 q71Var = new q71(this.f10185a, nativeAdResponse, this.b.f());
            this.b.z.a(this.b.l(), this.f10185a, this.b.A);
            this.b.z.a(this.b.l(), this.f10185a, q71Var);
        }
    }

    @Override // com.yandex.mobile.ads.impl.bk
    protected final void a(w3 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        super.a(error);
        this.x.a(error);
    }

    public final void y() {
        b(this.y);
    }

    public final class b implements v91.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final o8<String> f10186a;
        final /* synthetic */ s90 b;

        public b(s90 s90Var, o8<String> adResponse) {
            Intrinsics.checkNotNullParameter(adResponse, "adResponse");
            this.b = s90Var;
            this.f10186a = adResponse;
        }

        @Override // com.yandex.mobile.ads.impl.v91.b
        public final void a(w3 adRequestError) {
            Intrinsics.checkNotNullParameter(adRequestError, "adRequestError");
            this.b.b(adRequestError);
        }

        @Override // com.yandex.mobile.ads.impl.v91.b
        public final void a(m61 nativeAd) {
            Intrinsics.checkNotNullParameter(nativeAd, "nativeAd");
            if (nativeAd instanceof uz1) {
                this.b.u();
                this.b.x.a(new cs0((uz1) nativeAd, this.f10186a));
            } else {
                this.b.b(w7.x());
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.bk, com.yandex.mobile.ads.impl.qq1.b
    public final void a(o8<String> adResponse) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        super.a((o8) adResponse);
        this.C.a(adResponse);
        this.C.a(f());
        this.B.a(adResponse, new b(this, adResponse), new a(this, adResponse));
    }
}
