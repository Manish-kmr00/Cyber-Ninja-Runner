package com.json;

import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.json.environment.ContextProvider;
import com.json.mediationsdk.ISBannerSize;
import com.json.mediationsdk.IronSourceBannerLayout;
import com.json.mediationsdk.adunit.adapter.internal.AdapterBannerInterface;
import com.json.mediationsdk.adunit.adapter.listener.BannerAdListener;
import com.json.mediationsdk.adunit.adapter.utility.AdData;
import com.json.mediationsdk.impressionData.ImpressionData;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.model.Placement;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.mediation.LevelPlayAdInfo;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010\u001f\u001a\u00020\u001b¢\u0006\u0004\b+\u0010,J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eJ\b\u0010\u0010\u001a\u00020\u0005H\u0014J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016R$\u0010\u001f\u001a\u0010\u0012\f\u0012\n \u001c*\u0004\u0018\u00010\u001b0\u001b0\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006-"}, d2 = {"Lcom/ironsource/x5;", "Lcom/ironsource/a0;", "Lcom/ironsource/mediationsdk/adunit/adapter/listener/BannerAdListener;", "Lcom/ironsource/mediationsdk/ISBannerSize;", "H", "", "K", "J", "I", "Lcom/unity3d/mediation/LevelPlayAdInfo;", "e", "Lcom/ironsource/j0;", "adInstancePresenter", "a", "Lcom/ironsource/ov;", "viewBinder", "z", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Landroid/view/View;", "adView", "Landroid/widget/FrameLayout$LayoutParams;", "frameLayoutParams", "onAdLoadSuccess", nu.k, nu.l, nu.m, "Ljava/lang/ref/WeakReference;", "Lcom/ironsource/z5;", "kotlin.jvm.PlatformType", "w", "Ljava/lang/ref/WeakReference;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, VastAttributes.HORIZONTAL_POSITION, "Landroid/view/View;", VastAttributes.VERTICAL_POSITION, "Landroid/widget/FrameLayout$LayoutParams;", "bannerLayoutParams", "Lcom/ironsource/w2;", "adTools", "Lcom/ironsource/b0;", "instanceData", "Lcom/ironsource/h0;", "adInstancePayload", "<init>", "(Lcom/ironsource/w2;Lcom/ironsource/b0;Lcom/ironsource/h0;Lcom/ironsource/z5;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class x5 extends a0 implements BannerAdListener {

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    private WeakReference<z5> listener;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    private View adView;

    /* JADX INFO: renamed from: y, reason: from kotlin metadata */
    private FrameLayout.LayoutParams bannerLayoutParams;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x5(w2 adTools, b0 instanceData, h0 adInstancePayload, z5 listener) {
        super(adTools, instanceData, adInstancePayload, listener);
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(instanceData, "instanceData");
        Intrinsics.checkNotNullParameter(adInstancePayload, "adInstancePayload");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = new WeakReference<>(listener);
    }

    private final ISBannerSize H() {
        w2 adTools = getAdTools();
        w1 w1VarI = getInstanceData().i();
        Intrinsics.checkNotNull(w1VarI, "null cannot be cast to non-null type com.unity3d.mediation.internal.ads.controllers.adunits.data.BannerAdUnitData");
        return adTools.a(((m6) w1VarI).getAdProperties().getAdSize());
    }

    private final void I() {
        Placement placementJ = j();
        if (placementJ != null) {
            getAdTools().getEventSender().getAdInteraction().f(placementJ.getPlacementName());
        }
        z5 z5Var = this.listener.get();
        if (z5Var != null) {
            z5Var.a(this);
        }
    }

    private final void J() {
        Placement placementJ = j();
        if (placementJ != null) {
            getAdTools().getEventSender().getAdInteraction().c(placementJ.getPlacementName());
        }
        z5 z5Var = this.listener.get();
        if (z5Var != null) {
            z5Var.b(this);
        }
    }

    private final void K() {
        Placement placementJ = j();
        if (placementJ != null) {
            getAdTools().getEventSender().getAdInteraction().h(placementJ.getPlacementName());
        }
        z5 z5Var = this.listener.get();
        if (z5Var != null) {
            z5Var.c(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(x5 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.adView = null;
        this$0.bannerLayoutParams = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(x5 this$0, View adView, FrameLayout.LayoutParams frameLayoutParams) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adView, "$adView");
        Intrinsics.checkNotNullParameter(frameLayoutParams, "$frameLayoutParams");
        this$0.adView = adView;
        this$0.bannerLayoutParams = frameLayoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final x5 this$0, ov viewBinder) {
        FrameLayout.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewBinder, "$viewBinder");
        View view = this$0.adView;
        if (view == null || (layoutParams = this$0.bannerLayoutParams) == null) {
            return;
        }
        viewBinder.a(view, layoutParams, this$0.getAdTools());
        IronLog.INTERNAL.verbose(o1.a(this$0.getAdTools(), "Bind banner view", (String) null, 2, (Object) null));
        this$0.getAdTools().d(new Runnable() { // from class: com.ironsource.x5$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                x5.e(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(x5 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(x5 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(x5 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(x5 this$0) {
        String placementName;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        n0 adInteraction = this$0.getAdTools().getEventSender().getAdInteraction();
        Placement placementJ = this$0.j();
        if (placementJ == null || (placementName = placementJ.getPlacementName()) == null) {
            placementName = "";
        }
        adInteraction.j(placementName);
    }

    @Override // com.json.a0
    public void a(j0 adInstancePresenter) {
        Intrinsics.checkNotNullParameter(adInstancePresenter, "adInstancePresenter");
        adInstancePresenter.a(this);
    }

    public final void a(final ov viewBinder) {
        Intrinsics.checkNotNullParameter(viewBinder, "viewBinder");
        vl.a(getAdTools(), new Runnable() { // from class: com.ironsource.x5$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                x5.a(this.f$0, viewBinder);
            }
        }, 0L, 2, (Object) null);
    }

    @Override // com.json.a0
    public void b() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(getInstanceSignature());
        vl.a(getAdTools(), new Runnable() { // from class: com.ironsource.x5$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                x5.a(this.f$0);
            }
        }, 0L, 2, (Object) null);
        if (g() == null) {
            ironLog.warning("adapter == null");
            return;
        }
        try {
            if (g() instanceof AdapterBannerInterface) {
                Object objG = g();
                Intrinsics.checkNotNull(objG, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBannerInterface<*>");
                ((AdapterBannerInterface) objG).destroyAd(getCurrentAdData());
            } else {
                ironLog.error(a("adapter not instance of AdapterBannerInterface"));
            }
        } catch (Throwable th) {
            o9.d().a(th);
            String str = "destroyBanner - exception = " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(a(str));
            getAdTools().getEventSender().getTroubleshoot().g(str);
        }
        super.b();
    }

    @Override // com.json.a0
    public LevelPlayAdInfo e() {
        String string = getInstanceData().i().getAdProperties().getAdId().toString();
        Intrinsics.checkNotNullExpressionValue(string, "instanceData.adUnitData.…roperties.adId.toString()");
        String adUnitId = getInstanceData().i().getAdProperties().getAdUnitId();
        String string2 = getInstanceData().getAdFormat().toString();
        Intrinsics.checkNotNullExpressionValue(string2, "instanceData.adFormat.toString()");
        ImpressionData impressionDataA = getInstanceData().n().a(k());
        am amVarD = getInstanceData().n().d();
        w1 w1VarI = getInstanceData().i();
        Intrinsics.checkNotNull(w1VarI, "null cannot be cast to non-null type com.unity3d.mediation.internal.ads.controllers.adunits.data.BannerAdUnitData");
        return new LevelPlayAdInfo(string, adUnitId, string2, impressionDataA, amVarD, ((m6) w1VarI).getAdProperties().getAdSize(), null, 64, null);
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public void onAdLeftApplication() {
        a(new Runnable() { // from class: com.ironsource.x5$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                x5.b(this.f$0);
            }
        });
    }

    @Override // com.json.mediationsdk.adunit.adapter.listener.BannerAdListener, com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public void onAdLoadSuccess(final View adView, final FrameLayout.LayoutParams frameLayoutParams) {
        Intrinsics.checkNotNullParameter(adView, "adView");
        Intrinsics.checkNotNullParameter(frameLayoutParams, "frameLayoutParams");
        vl.a(getAdTools(), new Runnable() { // from class: com.ironsource.x5$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                x5.a(this.f$0, adView, frameLayoutParams);
            }
        }, 0L, 2, (Object) null);
        super.onAdLoadSuccess();
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public void onAdScreenDismissed() {
        a(new Runnable() { // from class: com.ironsource.x5$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                x5.c(this.f$0);
            }
        });
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public void onAdScreenPresented() {
        a(new Runnable() { // from class: com.ironsource.x5$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                x5.d(this.f$0);
            }
        });
    }

    @Override // com.json.a0
    protected void z() {
        if (!(g() instanceof AdapterBannerInterface)) {
            IronLog.INTERNAL.error(a("adapter not instance of AdapterBannerInterface"));
            return;
        }
        AdData currentAdData = getCurrentAdData();
        ISBannerSize iSBannerSizeH = H();
        Map<String, Object> adUnitData = currentAdData.getAdUnitData();
        Intrinsics.checkNotNullExpressionValue(adUnitData, "adData.adUnitData");
        adUnitData.put("bannerLayout", new IronSourceBannerLayout(ContextProvider.getInstance().getCurrentActiveActivity(), iSBannerSizeH));
        Object objG = g();
        Intrinsics.checkNotNull(objG, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBannerInterface<com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener>");
        ((AdapterBannerInterface) objG).loadAd(currentAdData, ContextProvider.getInstance().getCurrentActiveActivity(), iSBannerSizeH, this);
    }
}
