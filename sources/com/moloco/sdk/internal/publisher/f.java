package com.moloco.sdk.internal.publisher;

import com.facebook.login.LoginLogger;
import com.moloco.sdk.acm.AndroidClientMetrics;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.AdLoad;
import com.moloco.sdk.publisher.MolocoAd;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class f implements x {
    public static final a e = new a(null);
    public static final String f = "AdLoadListenerTrackerImpl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AdLoad.Listener f6188a;
    public final com.moloco.sdk.internal.w b;
    public final TimerEvent c;
    public final AdFormatType d;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    public f(AdLoad.Listener listener, com.moloco.sdk.internal.w sdkEventUrlTracker, TimerEvent acmLoadTimerEvent, AdFormatType adFormatType) {
        Intrinsics.checkNotNullParameter(sdkEventUrlTracker, "sdkEventUrlTracker");
        Intrinsics.checkNotNullParameter(acmLoadTimerEvent, "acmLoadTimerEvent");
        Intrinsics.checkNotNullParameter(adFormatType, "adFormatType");
        this.f6188a = listener;
        this.b = sdkEventUrlTracker;
        this.c = acmLoadTimerEvent;
        this.d = adFormatType;
    }

    @Override // com.moloco.sdk.internal.publisher.x
    public void a(MolocoAd molocoAd, long j, com.moloco.sdk.internal.ortb.model.q qVar) {
        String strG;
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, f, "onAdLoadStarted: " + molocoAd + ", " + j, null, false, 12, null);
        if (qVar == null || (strG = qVar.g()) == null) {
            return;
        }
        com.moloco.sdk.internal.w.a.a(this.b, strG, j, null, 4, null);
    }

    @Override // com.moloco.sdk.internal.publisher.x
    public void a(MolocoAd molocoAd, com.moloco.sdk.internal.ortb.model.q qVar) {
        String strI;
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, f, "onAdLoadSuccess: " + molocoAd, null, false, 12, null);
        if (qVar != null && (strI = qVar.i()) != null) {
            com.moloco.sdk.internal.w.a.a(this.b, strI, System.currentTimeMillis(), null, 4, null);
        }
        AndroidClientMetrics androidClientMetrics = AndroidClientMetrics.INSTANCE;
        TimerEvent timerEventWithTag = this.c.withTag(com.moloco.sdk.internal.client_metrics_data.c.Result.b(), "success");
        com.moloco.sdk.internal.client_metrics_data.c cVar = com.moloco.sdk.internal.client_metrics_data.c.AdType;
        String strB = cVar.b();
        String strName = this.d.name();
        Locale locale = Locale.ROOT;
        String lowerCase = strName.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        androidClientMetrics.recordTimerEvent(timerEventWithTag.withTag(strB, lowerCase));
        CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.LoadAdSuccess.b());
        String strB2 = cVar.b();
        String lowerCase2 = this.d.name().toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        androidClientMetrics.recordCountEvent(countEvent.withTag(strB2, lowerCase2));
        AdLoad.Listener listener = this.f6188a;
        if (listener != null) {
            listener.onAdLoadSuccess(molocoAd);
        }
    }

    @Override // com.moloco.sdk.internal.publisher.x
    public void a(com.moloco.sdk.internal.s internalError, com.moloco.sdk.internal.ortb.model.q qVar) {
        String strE;
        Intrinsics.checkNotNullParameter(internalError, "internalError");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, f, "onAdLoadFailed: " + internalError, null, false, 12, null);
        if (qVar != null && (strE = qVar.e()) != null) {
            this.b.a(strE, System.currentTimeMillis(), internalError);
        }
        AndroidClientMetrics androidClientMetrics = AndroidClientMetrics.INSTANCE;
        TimerEvent timerEventWithTag = this.c.withTag(com.moloco.sdk.internal.client_metrics_data.c.Result.b(), LoginLogger.EVENT_EXTRAS_FAILURE);
        com.moloco.sdk.internal.client_metrics_data.c cVar = com.moloco.sdk.internal.client_metrics_data.c.Reason;
        TimerEvent timerEventWithTag2 = timerEventWithTag.withTag(cVar.b(), internalError.d().a());
        com.moloco.sdk.internal.client_metrics_data.c cVar2 = com.moloco.sdk.internal.client_metrics_data.c.AdType;
        String strB = cVar2.b();
        String strName = this.d.name();
        Locale locale = Locale.ROOT;
        String lowerCase = strName.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        androidClientMetrics.recordTimerEvent(timerEventWithTag2.withTag(strB, lowerCase));
        CountEvent countEventWithTag = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.LoadAdFailed.b()).withTag("network", internalError.c().getNetworkName()).withTag(cVar.b(), internalError.d().a());
        String strB2 = cVar2.b();
        String lowerCase2 = this.d.name().toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        androidClientMetrics.recordCountEvent(countEventWithTag.withTag(strB2, lowerCase2));
        AdLoad.Listener listener = this.f6188a;
        if (listener != null) {
            listener.onAdLoadFailed(internalError.c());
        }
    }
}
