package com.json;

import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.json.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface;
import com.json.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.logger.IronSourceError;
import com.json.mediationsdk.model.Placement;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u001a¢\u0006\u0004\b:\u0010;J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0006\u0010\t\u001a\u00020\u0005J\u0010\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013R\u001a\u0010\u0019\u001a\u00020\u00158\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00038\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\t\u0010\u001dR\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u001fR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R(\u00100\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010*8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0013\u00103\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b1\u00102R\u0013\u00104\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b!\u00102R\u0013\u00105\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b$\u00102R\u0013\u00106\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b'\u00102R\u0013\u00109\u001a\u0004\u0018\u0001078F¢\u0006\u0006\u001a\u0004\b,\u00108¨\u0006<"}, d2 = {"Lcom/ironsource/ol;", "Lcom/ironsource/bl;", "Lcom/ironsource/wm;", "Lcom/ironsource/tm;", "e", "", "n", "", "d", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/ironsource/ql;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "a", "Lcom/unity3d/mediation/LevelPlayAdInfo;", "adInfo", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "error", "onNativeAdLoadFailed", "", "placementName", "Ljava/util/UUID;", "Ljava/util/UUID;", "g", "()Ljava/util/UUID;", "adId", "Lcom/ironsource/ml;", "Lcom/ironsource/ml;", "nativeAd", "Lcom/ironsource/tm;", "nativeAdController", "Ljava/lang/String;", "Lcom/ironsource/mediationsdk/model/Placement;", "h", "Lcom/ironsource/mediationsdk/model/Placement;", "placement", "i", "Lcom/ironsource/ql;", "Lcom/ironsource/mediationsdk/ads/nativead/AdapterNativeAdData;", "j", "Lcom/ironsource/mediationsdk/ads/nativead/AdapterNativeAdData;", "adapterNativeAdData", "Lcom/ironsource/mediationsdk/adunit/adapter/internal/nativead/AdapterNativeAdViewBinder;", "<set-?>", CampaignEx.JSON_KEY_AD_K, "Lcom/ironsource/mediationsdk/adunit/adapter/internal/nativead/AdapterNativeAdViewBinder;", "l", "()Lcom/ironsource/mediationsdk/adunit/adapter/internal/nativead/AdapterNativeAdViewBinder;", "nativeAdViewBinder", "m", "()Ljava/lang/String;", "title", b9.h.F0, "body", "callToAction", "Lcom/ironsource/nl$a;", "()Lcom/ironsource/nl$a;", "icon", "<init>", "(Ljava/util/UUID;Lcom/ironsource/ml;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class ol extends bl implements wm {

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final UUID adId;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final ml nativeAd;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private tm nativeAdController;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private String placementName;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private Placement placement;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private ql listener;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private AdapterNativeAdData adapterNativeAdData;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private AdapterNativeAdViewBinder nativeAdViewBinder;

    /* JADX WARN: Illegal instructions before constructor call */
    public ol(UUID adId, ml nativeAd) {
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(nativeAd, "nativeAd");
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.NATIVE_AD;
        super(new o1(ad_unit, e2.b.MEDIATION));
        this.adId = adId;
        this.nativeAd = nativeAd;
        this.placementName = "";
        getAdTools().getEventSender().a(new o(ad_unit, adId, getAdUnitId()));
    }

    public /* synthetic */ ol(UUID uuid, ml mlVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? lf.f3858a.a() : uuid, mlVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ol this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IronLog.API.info(String.valueOf(this$0));
        try {
            tm tmVar = this$0.nativeAdController;
            if (tmVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nativeAdController");
                tmVar = null;
            }
            tmVar.j();
            this$0.listener = null;
        } catch (Throwable th) {
            o9.d().a(th);
            IronLog.API.error("destroyNativeAd()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ol this$0, ql qlVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.listener = qlVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ol this$0, LevelPlayAdError levelPlayError) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(levelPlayError, "$levelPlayError");
        ql qlVar = this$0.listener;
        if (qlVar != null) {
            qlVar.a(this$0.nativeAd, levelPlayError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ol this$0, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adInfo, "$adInfo");
        ql qlVar = this$0.listener;
        if (qlVar != null) {
            qlVar.b(this$0.nativeAd, adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ol this$0, String placementName) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(placementName, "$placementName");
        this$0.placementName = placementName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ol this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        tm tmVar = null;
        if (this$0.getIsLoadAdCalled()) {
            IronLog.INTERNAL.warning(o1.a(this$0.getAdTools(), "Native ad load already called", (String) null, 2, (Object) null));
            return;
        }
        this$0.a(true);
        if (this$0.d()) {
            tm tmVar2 = this$0.nativeAdController;
            if (tmVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nativeAdController");
            } else {
                tmVar = tmVar2;
            }
            tmVar.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ol this$0, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adInfo, "$adInfo");
        ql qlVar = this$0.listener;
        if (qlVar != null) {
            qlVar.c(this$0.nativeAd, adInfo);
        }
    }

    private final tm e() {
        this.placement = getAdTools().d(this.placementName);
        UUID uuid = this.adId;
        String adUnitId = getAdUnitId();
        Placement placement = this.placement;
        if (placement == null) {
            Intrinsics.throwUninitializedPropertyAccessException("placement");
            placement = null;
        }
        dn dnVar = new dn(uuid, adUnitId, placement);
        a(dnVar);
        return new tm(this, getAdTools(), dnVar);
    }

    public final void a(final ql listener) {
        a(new Runnable() { // from class: com.ironsource.ol$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ol.a(this.f$0, listener);
            }
        });
    }

    @Override // com.json.wm
    public void b(final LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        IronLog.CALLBACK.info(String.valueOf(this));
        qm qmVar = new qm();
        tm tmVar = this.nativeAdController;
        if (tmVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeAdController");
            tmVar = null;
        }
        tmVar.a(qmVar);
        this.adapterNativeAdData = qmVar.getNativeAdData();
        this.nativeAdViewBinder = qmVar.getNativeAdViewBinder();
        b(new Runnable() { // from class: com.ironsource.ol$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ol.b(this.f$0, adInfo);
            }
        });
    }

    public final void b(final String placementName) {
        Intrinsics.checkNotNullParameter(placementName, "placementName");
        a(new Runnable() { // from class: com.ironsource.ol$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                ol.a(this.f$0, placementName);
            }
        });
    }

    @Override // com.json.bl
    public boolean d() {
        this.nativeAdController = e();
        return true;
    }

    public final void f() {
        a(new Runnable() { // from class: com.ironsource.ol$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                ol.a(this.f$0);
            }
        });
    }

    @Override // com.json.wm
    public void f(final LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        b(new Runnable() { // from class: com.ironsource.ol$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                ol.a(this.f$0, adInfo);
            }
        });
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final UUID getAdId() {
        return this.adId;
    }

    public final String h() {
        AdapterNativeAdData adapterNativeAdData = this.adapterNativeAdData;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getAdvertiser();
        }
        return null;
    }

    public final String i() {
        AdapterNativeAdData adapterNativeAdData = this.adapterNativeAdData;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getBody();
        }
        return null;
    }

    public final String j() {
        AdapterNativeAdData adapterNativeAdData = this.adapterNativeAdData;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getCallToAction();
        }
        return null;
    }

    public final nl.a k() {
        NativeAdDataInterface.Image icon;
        AdapterNativeAdData adapterNativeAdData = this.adapterNativeAdData;
        if (adapterNativeAdData == null || (icon = adapterNativeAdData.getIcon()) == null) {
            return null;
        }
        return new nl.a(icon.getDrawable(), icon.getUri());
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final AdapterNativeAdViewBinder getNativeAdViewBinder() {
        return this.nativeAdViewBinder;
    }

    public final String m() {
        AdapterNativeAdData adapterNativeAdData = this.adapterNativeAdData;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getTitle();
        }
        return null;
    }

    public final void n() {
        a(new Runnable() { // from class: com.ironsource.ol$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                ol.b(this.f$0);
            }
        });
    }

    @Override // com.json.wm
    public void onNativeAdLoadFailed(IronSourceError error) {
        String string = this.adId.toString();
        Intrinsics.checkNotNullExpressionValue(string, "adId.toString()");
        final LevelPlayAdError levelPlayAdError = new LevelPlayAdError(error, string, getAdUnitId());
        b(new Runnable() { // from class: com.ironsource.ol$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                ol.a(this.f$0, levelPlayAdError);
            }
        });
    }
}
