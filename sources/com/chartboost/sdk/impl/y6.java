package com.chartboost.sdk.impl;

import android.os.Build;
import com.chartboost.sdk.ads.Ad;
import com.chartboost.sdk.ads.Interstitial;
import com.chartboost.sdk.callbacks.AdCallback;
import com.chartboost.sdk.callbacks.InterstitialCallback;
import com.chartboost.sdk.events.CacheError;
import com.chartboost.sdk.events.CacheEvent;
import com.chartboost.sdk.events.ShowError;
import com.chartboost.sdk.events.ShowEvent;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010!\u001a\u00020 \u0012\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"¢\u0006\u0004\b%\u0010&J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0007\u0010\u000bJ\u001d\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006'"}, d2 = {"Lcom/chartboost/sdk/impl/y6;", "Lcom/chartboost/sdk/impl/c;", "Lcom/chartboost/sdk/ads/Interstitial;", Reporting.Key.CLICK_SOURCE_TYPE_AD, "Lcom/chartboost/sdk/callbacks/InterstitialCallback;", "callback", "", "a", "(Lcom/chartboost/sdk/ads/Interstitial;Lcom/chartboost/sdk/callbacks/InterstitialCallback;)V", "", "bidResponse", "(Lcom/chartboost/sdk/ads/Interstitial;Lcom/chartboost/sdk/callbacks/InterstitialCallback;Ljava/lang/String;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/chartboost/sdk/impl/sa;", "l", "Lcom/chartboost/sdk/impl/sa;", "uiPoster", "Lcom/chartboost/sdk/impl/y;", "adUnitLoader", "Lcom/chartboost/sdk/impl/g0;", "adUnitRenderer", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/chartboost/sdk/impl/o9;", "sdkConfig", "Ljava/util/concurrent/ScheduledExecutorService;", "backgroundExecutorService", "Lcom/chartboost/sdk/impl/d;", "adApiCallbackSender", "Lcom/chartboost/sdk/impl/s9;", "session", "Lcom/chartboost/sdk/impl/n1;", "base64Wrapper", "Lcom/chartboost/sdk/impl/m4;", "eventTracker", "Lkotlin/Function0;", "", "androidVersion", "<init>", "(Lcom/chartboost/sdk/impl/y;Lcom/chartboost/sdk/impl/g0;Lcom/chartboost/sdk/impl/sa;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/ScheduledExecutorService;Lcom/chartboost/sdk/impl/d;Lcom/chartboost/sdk/impl/s9;Lcom/chartboost/sdk/impl/n1;Lcom/chartboost/sdk/impl/m4;Lkotlin/jvm/functions/Function0;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class y6 extends com.chartboost.sdk.impl.c {

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final sa uiPoster;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function0<Integer> {
        public static final a b = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            return Integer.valueOf(Build.VERSION.SDK_INT);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y6(y adUnitLoader, g0 adUnitRenderer, sa uiPoster, AtomicReference<o9> sdkConfig, ScheduledExecutorService backgroundExecutorService, com.chartboost.sdk.impl.d adApiCallbackSender, s9 session, n1 base64Wrapper, m4 eventTracker, Function0<Integer> androidVersion) {
        super(adUnitLoader, adUnitRenderer, sdkConfig, backgroundExecutorService, adApiCallbackSender, session, base64Wrapper, eventTracker, androidVersion);
        Intrinsics.checkNotNullParameter(adUnitLoader, "adUnitLoader");
        Intrinsics.checkNotNullParameter(adUnitRenderer, "adUnitRenderer");
        Intrinsics.checkNotNullParameter(uiPoster, "uiPoster");
        Intrinsics.checkNotNullParameter(sdkConfig, "sdkConfig");
        Intrinsics.checkNotNullParameter(backgroundExecutorService, "backgroundExecutorService");
        Intrinsics.checkNotNullParameter(adApiCallbackSender, "adApiCallbackSender");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(base64Wrapper, "base64Wrapper");
        Intrinsics.checkNotNullParameter(eventTracker, "eventTracker");
        Intrinsics.checkNotNullParameter(androidVersion, "androidVersion");
        this.uiPoster = uiPoster;
    }

    public final void a(Interstitial ad, InterstitialCallback callback) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(callback, "callback");
        a(ad, callback, (String) null);
    }

    public final void b(Interstitial ad, InterstitialCallback callback) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (g(ad.getLocation())) {
            this.uiPoster.a(new c(callback, ad));
            a(ma.i.FINISH_FAILURE, "Invalid configuration. Check logs for more details.", u.b.g, ad.getLocation());
        } else if (b()) {
            a((Ad) ad, (AdCallback) callback);
        } else {
            this.uiPoster.a(new d(callback, ad));
        }
    }

    public final void a(Interstitial ad, InterstitialCallback callback, String bidResponse) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (g(ad.getLocation())) {
            this.uiPoster.a(new b(callback, ad));
            a(ma.a.FINISH_FAILURE, "Invalid configuration. Check logs for more details.", u.b.g, ad.getLocation());
        } else {
            a(ad.getLocation(), ad, callback, bidResponse);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ InterstitialCallback b;
        public final /* synthetic */ Interstitial c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterstitialCallback interstitialCallback, Interstitial interstitial) {
            super(0);
            this.b = interstitialCallback;
            this.c = interstitial;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            this.b.onAdLoaded(new CacheEvent(null, this.c), new CacheError(CacheError.Code.SESSION_NOT_STARTED, null, 2, null));
        }
    }

    public /* synthetic */ y6(y yVar, g0 g0Var, sa saVar, AtomicReference atomicReference, ScheduledExecutorService scheduledExecutorService, com.chartboost.sdk.impl.d dVar, s9 s9Var, n1 n1Var, m4 m4Var, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(yVar, g0Var, saVar, atomicReference, scheduledExecutorService, dVar, s9Var, n1Var, m4Var, (i & 512) != 0 ? a.b : function0);
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ InterstitialCallback b;
        public final /* synthetic */ Interstitial c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(InterstitialCallback interstitialCallback, Interstitial interstitial) {
            super(0);
            this.b = interstitialCallback;
            this.c = interstitial;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            this.b.onAdShown(new ShowEvent(null, this.c), new ShowError(ShowError.Code.SESSION_NOT_STARTED, null, 2, null));
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class d extends Lambda implements Function0<Unit> {
        public final /* synthetic */ InterstitialCallback b;
        public final /* synthetic */ Interstitial c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(InterstitialCallback interstitialCallback, Interstitial interstitial) {
            super(0);
            this.b = interstitialCallback;
            this.c = interstitial;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            this.b.onAdShown(new ShowEvent(null, this.c), new ShowError(ShowError.Code.NO_CACHED_AD, null, 2, null));
        }
    }
}
