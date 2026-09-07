package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.SystemClock;
import com.monetization.ads.mediation.banner.MediatedBannerSize;
import com.monetization.ads.mediation.base.MediatedBidderTokenLoadListener;
import com.monetization.ads.mediation.base.MediatedBidderTokenLoader;
import java.util.HashMap;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class lz0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f9580a;
    private final yx0<com.monetization.ads.mediation.base.a> b;
    private final kz0 c;
    private final jz0 d;
    private final qx0 e;

    public interface a {
        void a(JSONObject jSONObject);
    }

    public static final class b implements MediatedBidderTokenLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ hz0 f9581a;
        final /* synthetic */ lz0 b;
        final /* synthetic */ Context c;
        final /* synthetic */ px0 d;
        final /* synthetic */ a e;
        final /* synthetic */ dl f;
        final /* synthetic */ long g;

        b(hz0 hz0Var, lz0 lz0Var, Context context, px0 px0Var, a aVar, dl dlVar, long j) {
            this.f9581a = hz0Var;
            this.b = lz0Var;
            this.c = context;
            this.d = px0Var;
            this.e = aVar;
            this.f = dlVar;
            this.g = j;
        }

        @Override // com.monetization.ads.mediation.base.MediatedBidderTokenLoadListener
        public final void onBidderTokenFailedToLoad(String failureReason) {
            Intrinsics.checkNotNullParameter(failureReason, "failureReason");
            lz0.a(this.b, this.c, this.f9581a, this.d, failureReason, null, this.e);
        }

        @Override // com.monetization.ads.mediation.base.MediatedBidderTokenLoadListener
        public final void onBidderTokenLoaded(String bidderToken, MediatedBannerSize mediatedBannerSize) {
            Intrinsics.checkNotNullParameter(bidderToken, "bidderToken");
            if (bidderToken.length() == 0) {
                lz0.a(this.b, this.c, this.f9581a, this.d, this.f9581a.e() + " provided empty token", null, this.e);
            } else {
                if (this.f.a()) {
                    lz0.a(this.b, this.c, this.f9581a, this.d, this.f9581a.e() + " didn't provide bidder token after timeout", Long.valueOf(SystemClock.elapsedRealtime() - this.g), this.e);
                    return;
                }
                kz0 kz0Var = this.b.c;
                hz0 hz0Var = this.f9581a;
                kz0Var.getClass();
                JSONObject jSONObjectA = kz0.a(hz0Var, bidderToken, mediatedBannerSize);
                if (jSONObjectA == null) {
                    lz0.a(this.b, this.c, this.f9581a, this.d, "Can't create bidding data json object for network.", null, this.e);
                } else {
                    lz0.a(this.b, this.c, this.f9581a, this.d, jSONObjectA, this.e);
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ lz0(cy0 cy0Var) {
        this(cy0Var, is0.a.a().c(), new yx0(cy0Var), new kz0(), new jz0(cy0Var), new qx0());
        int i = is0.f;
    }

    public lz0(cy0 mediatedAdapterReporter, Executor loadingExecutor, yx0<com.monetization.ads.mediation.base.a> mediatedAdapterCreator, kz0 mediationNetworkBiddingDataJsonCreator, jz0 bidderTokenLoadingReporter, qx0 mediatedAdDataFactory) {
        Intrinsics.checkNotNullParameter(mediatedAdapterReporter, "mediatedAdapterReporter");
        Intrinsics.checkNotNullParameter(loadingExecutor, "loadingExecutor");
        Intrinsics.checkNotNullParameter(mediatedAdapterCreator, "mediatedAdapterCreator");
        Intrinsics.checkNotNullParameter(mediationNetworkBiddingDataJsonCreator, "mediationNetworkBiddingDataJsonCreator");
        Intrinsics.checkNotNullParameter(bidderTokenLoadingReporter, "bidderTokenLoadingReporter");
        Intrinsics.checkNotNullParameter(mediatedAdDataFactory, "mediatedAdDataFactory");
        this.f9580a = loadingExecutor;
        this.b = mediatedAdapterCreator;
        this.c = mediationNetworkBiddingDataJsonCreator;
        this.d = bidderTokenLoadingReporter;
        this.e = mediatedAdDataFactory;
    }

    public static final void a(lz0 lz0Var, Context context, hz0 hz0Var, px0 px0Var, String str, Long l, a aVar) {
        lz0Var.d.a(context, hz0Var, px0Var, str, l);
        aVar.a(null);
    }

    public static final void a(lz0 lz0Var, Context context, hz0 hz0Var, px0 px0Var, JSONObject jSONObject, a aVar) {
        lz0Var.d.a(context, hz0Var, px0Var);
        aVar.a(jSONObject);
    }

    public final void a(final Context context, zy1 zy1Var, final hz0 mediationNetwork, final dl timeoutHolder, final a listener) {
        px0 px0Var;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediationNetwork, "mediationNetwork");
        Intrinsics.checkNotNullParameter(timeoutHolder, "timeoutHolder");
        Intrinsics.checkNotNullParameter(listener, "listener");
        final com.monetization.ads.mediation.base.a mediatedAdapter = this.b.a(context, mediationNetwork, (Class<com.monetization.ads.mediation.base.a>) com.monetization.ads.mediation.base.a.class);
        if (mediatedAdapter != null) {
            this.e.getClass();
            Intrinsics.checkNotNullParameter(mediatedAdapter, "mediatedAdapter");
            px0Var = new px0(mediatedAdapter);
        } else {
            px0Var = null;
        }
        if (!(mediatedAdapter instanceof MediatedBidderTokenLoader)) {
            if (mediatedAdapter == null) {
                listener.a(null);
                return;
            } else {
                this.d.a(context, mediationNetwork, px0Var, "Can't create bidder token loader.", null);
                listener.a(null);
                return;
            }
        }
        try {
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            final HashMap map = new HashMap(mediationNetwork.i());
            if (zy1Var != null) {
                map.put("width", String.valueOf(zy1Var.getWidth()));
                map.put("height", String.valueOf(zy1Var.getHeight()));
            }
            final px0 px0Var2 = px0Var;
            try {
                this.f9580a.execute(new Runnable() { // from class: com.yandex.mobile.ads.impl.lz0$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        lz0.a(mediatedAdapter, context, map, mediationNetwork, this, px0Var2, listener, timeoutHolder, jElapsedRealtime);
                    }
                });
            } catch (Throwable th) {
                th = th;
                this.d.a(context, mediationNetwork, px0Var, th.toString(), null);
                listener.a(null);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(com.monetization.ads.mediation.base.a aVar, Context context, HashMap extras, hz0 mediationNetwork, lz0 this$0, px0 px0Var, a listener, dl timeoutHolder, long j) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(extras, "$extras");
        Intrinsics.checkNotNullParameter(mediationNetwork, "$mediationNetwork");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(timeoutHolder, "$timeoutHolder");
        ((MediatedBidderTokenLoader) aVar).loadBidderToken(context, extras, new b(mediationNetwork, this$0, context, px0Var, listener, timeoutHolder, j));
    }
}
