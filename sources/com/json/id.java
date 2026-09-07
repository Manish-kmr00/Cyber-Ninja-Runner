package com.json;

import android.app.Activity;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.json.environment.ContextProvider;
import com.json.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface;
import com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener;
import com.json.mediationsdk.adunit.adapter.listener.InterstitialAdListener;
import com.json.mediationsdk.adunit.adapter.listener.RewardedVideoAdListener;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.logger.IronSourceError;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.mediation.rewarded.LevelPlayReward;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B'\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u0010%\u001a\u00020!¢\u0006\u0004\b0\u00101J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\u001a\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014J\b\u0010\u0016\u001a\u00020\u0005H\u0014J\u000f\u0010\u0017\u001a\u00020\u0005H\u0010¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\u001a\u0010\u001a\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016R$\u0010%\u001a\u0010\u0012\f\u0012\n \"*\u0004\u0018\u00010!0!0 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(¨\u00062"}, d2 = {"Lcom/ironsource/id;", "Lcom/ironsource/a0;", "Lcom/ironsource/mediationsdk/adunit/adapter/listener/InterstitialAdListener;", "Lcom/ironsource/mediationsdk/adunit/adapter/listener/RewardedVideoAdListener;", "Lcom/ironsource/mediationsdk/adunit/adapter/internal/listener/AdapterAdRewardListener;", "", "H", "L", "I", "M", "K", "", "errorCode", "", "errorMessage", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "J", "Lcom/ironsource/j0;", "adInstancePresenter", "a", "Landroid/app/Activity;", "activity", "z", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()V", nu.g, nu.e, "onAdShowSuccess", "onAdVisible", "onAdStarted", "onAdEnded", nu.i, "Ljava/lang/ref/WeakReference;", "Lcom/ironsource/jd;", "kotlin.jvm.PlatformType", "w", "Ljava/lang/ref/WeakReference;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/ironsource/ib;", VastAttributes.HORIZONTAL_POSITION, "Lcom/ironsource/ib;", "rewardDurationAfterClose", "Lcom/ironsource/w2;", "adTools", "Lcom/ironsource/b0;", "instanceData", "Lcom/ironsource/h0;", "adInstancePayload", "<init>", "(Lcom/ironsource/w2;Lcom/ironsource/b0;Lcom/ironsource/h0;Lcom/ironsource/jd;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class id extends a0 implements InterstitialAdListener, RewardedVideoAdListener, AdapterAdRewardListener {

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    private WeakReference<jd> listener;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    private ib rewardDurationAfterClose;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public id(w2 adTools, b0 instanceData, h0 adInstancePayload, jd listener) {
        super(adTools, instanceData, adInstancePayload, listener);
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(instanceData, "instanceData");
        Intrinsics.checkNotNullParameter(adInstancePayload, "adInstancePayload");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = new WeakReference<>(listener);
    }

    private final void H() {
        this.rewardDurationAfterClose = new ib();
        IronLog.INTERNAL.verbose(a0.a(this, (String) null, 1, (Object) null));
        getAdTools().getEventSender().getAdInteraction().a(k(), "");
        jd jdVar = this.listener.get();
        if (jdVar != null) {
            jdVar.b(this);
        }
        c();
    }

    private final void I() {
        IronLog.INTERNAL.verbose(a0.a(this, (String) null, 1, (Object) null));
        getAdTools().getEventSender().getAdInteraction().d(k());
    }

    private final void J() {
        HashMap map = new HashMap();
        Map<String, String> mapK = getAdTools().k();
        if (mapK != null) {
            for (String str : mapK.keySet()) {
                map.put("custom_" + str, mapK.get(str));
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strA = getAdTools().a(jCurrentTimeMillis, getInstanceName());
        long jA = ib.a(this.rewardDurationAfterClose);
        LevelPlayReward levelPlayRewardA = mm.INSTANCE.d().p().a(k(), getInstanceData().i().getAdProperties().getAdUnitId());
        if (levelPlayRewardA == null) {
            levelPlayRewardA = ja.INSTANCE.a();
        }
        LevelPlayReward levelPlayReward = levelPlayRewardA;
        getAdTools().getEventSender().getAdInteraction().a(k(), levelPlayReward.getName(), levelPlayReward.getAmount(), jCurrentTimeMillis, strA, jA, map, getAdTools().j());
        jd jdVar = this.listener.get();
        if (jdVar != null) {
            jdVar.a(this, levelPlayReward);
        }
    }

    private final void K() {
        IronLog.INTERNAL.verbose(a0.a(this, (String) null, 1, (Object) null));
        getAdTools().getEventSender().getAdInteraction().l(k());
        jd jdVar = this.listener.get();
        if (jdVar != null) {
            jdVar.a(this);
        }
    }

    private final void L() {
        IronLog.INTERNAL.verbose(a0.a(this, (String) null, 1, (Object) null));
        getAdTools().getEventSender().getAdInteraction().i(k());
    }

    private final void M() {
        IronLog.INTERNAL.verbose(a0.a(this, (String) null, 1, (Object) null));
        getAdTools().getEventSender().getAdInteraction().k(k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(id this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(id this$0, int i, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b(i, str);
    }

    private final void b(int errorCode, String errorMessage) {
        IronLog.INTERNAL.verbose(a("error = " + errorCode + ", " + errorMessage));
        getAdTools().getEventSender().getAdInteraction().a(k(), errorCode, errorMessage, "");
        a(q1.a.FailedToShow);
        IronSourceError ironSourceError = new IronSourceError(errorCode, errorMessage);
        jd jdVar = this.listener.get();
        if (jdVar != null) {
            jdVar.a(this, ironSourceError);
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(id this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(id this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(id this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(id this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.L();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(id this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.M();
    }

    public final void a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("placementName = " + k()));
        try {
            getAdTools().getEventSender().getAdInteraction().a(activity, k());
            if (g() instanceof AdapterAdFullScreenInterface) {
                Object objG = g();
                Intrinsics.checkNotNull(objG, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface<com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener>");
                ((AdapterAdFullScreenInterface) objG).showAd(getCurrentAdData(), this);
            } else {
                ironLog.error(a("showAd - adapter not instance of AdapterAdFullScreenInterface"));
                getAdTools().getEventSender().getTroubleshoot().g("showAd - adapter not instance of AdapterAdFullScreenInterface");
            }
        } catch (Throwable th) {
            o9.d().a(th);
            String str = "showAd - exception = " + th.getMessage();
            IronLog.INTERNAL.error(a(str));
            getAdTools().getEventSender().getTroubleshoot().g(str);
            b(a2.h(getInstanceData().getAdFormat()), str);
        }
    }

    @Override // com.json.a0
    public void a(j0 adInstancePresenter) {
        Intrinsics.checkNotNullParameter(adInstancePresenter, "adInstancePresenter");
        adInstancePresenter.a(this);
    }

    @Override // com.json.a0
    public void c() {
        if (mm.INSTANCE.d().d().d()) {
            if (!(g() instanceof AdapterAdFullScreenInterface)) {
                IronLog.INTERNAL.error(a("adapter not instance of AdapterAdFullScreenInterface"));
                return;
            }
            Object objG = g();
            Intrinsics.checkNotNull(objG, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface<*>");
            ((AdapterAdFullScreenInterface) objG).disposeAd(getInstanceData().getAdData());
        }
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdClosed() {
        a(new Runnable() { // from class: com.ironsource.id$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                id.a(this.f$0);
            }
        });
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdEnded() {
        a(new Runnable() { // from class: com.ironsource.id$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                id.b(this.f$0);
            }
        });
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener
    public void onAdRewarded() {
        a(new Runnable() { // from class: com.ironsource.id$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                id.c(this.f$0);
            }
        });
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdShowFailed(final int errorCode, final String errorMessage) {
        a(new Runnable() { // from class: com.ironsource.id$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                id.a(this.f$0, errorCode, errorMessage);
            }
        });
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdShowSuccess() {
        a(new Runnable() { // from class: com.ironsource.id$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                id.d(this.f$0);
            }
        });
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdStarted() {
        a(new Runnable() { // from class: com.ironsource.id$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                id.e(this.f$0);
            }
        });
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdVisible() {
        a(new Runnable() { // from class: com.ironsource.id$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                id.f(this.f$0);
            }
        });
    }

    @Override // com.json.a0
    protected void z() {
        if (!(g() instanceof AdapterAdFullScreenInterface)) {
            IronLog.INTERNAL.error(a("adapter not instance of AdapterAdFullScreenInterface"));
            return;
        }
        Object objG = g();
        Intrinsics.checkNotNull(objG, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface<com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener>");
        ((AdapterAdFullScreenInterface) objG).loadAd(getInstanceData().getAdData(), ContextProvider.getInstance().getCurrentActiveActivity(), this);
    }
}
