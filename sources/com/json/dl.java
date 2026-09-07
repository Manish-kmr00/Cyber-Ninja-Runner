package com.json;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.json.environment.ContextProvider;
import com.json.mediationsdk.ISBannerSize;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.model.Placement;
import com.json.sdk.mediation.R;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.LevelPlayAdSize;
import com.unity3d.mediation.banner.LevelPlayBannerAdViewListener;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\b\b\u0002\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010%\u001a\u00020#\u0012\b\u0010;\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b<\u0010=J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0007J\u0006\u0010\u0015\u001a\u00020\u0007J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R\u001a\u0010\"\u001a\u00020\u001f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0017\u0010 \u001a\u0004\b\u001e\u0010!R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010$R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010'R$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u000f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001e\u0010*\u001a\u0004\b+\u0010,R(\u00100\u001a\u0004\u0018\u00010\r2\b\u0010)\u001a\u0004\u0018\u00010\r8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b+\u0010-\u001a\u0004\b.\u0010/R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u00118\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b.\u00101\u001a\u0004\b2\u00103R\u0018\u00105\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00104R\u0018\u00107\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u00106R\u0016\u0010:\u001a\u0002088\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0014\u00109¨\u0006>"}, d2 = {"Lcom/ironsource/dl;", "Lcom/ironsource/bl;", "Lcom/ironsource/w5;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "a", "Lcom/ironsource/v5;", "e", CampaignEx.JSON_KEY_AD_K, InneractiveMediationDefs.GENDER_FEMALE, "Lcom/unity3d/mediation/banner/LevelPlayBannerAdViewListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/unity3d/mediation/LevelPlayAdSize;", "adSize", "", "placementName", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "l", "m", "", "d", "Lcom/unity3d/mediation/LevelPlayAdInfo;", "adInfo", "isReload", "Lcom/unity3d/mediation/LevelPlayAdError;", "error", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "g", "Ljava/util/UUID;", "Ljava/util/UUID;", "()Ljava/util/UUID;", "adId", "Lcom/ironsource/w6;", "Lcom/ironsource/w6;", "bannerContainer", "Lcom/ironsource/fi;", "Lcom/ironsource/fi;", "testSuiteLoadConfigService", "<set-?>", "Lcom/unity3d/mediation/LevelPlayAdSize;", "h", "()Lcom/unity3d/mediation/LevelPlayAdSize;", "Lcom/unity3d/mediation/banner/LevelPlayBannerAdViewListener;", "i", "()Lcom/unity3d/mediation/banner/LevelPlayBannerAdViewListener;", "bannerListener", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "Lcom/ironsource/v5;", "bannerAdController", "Ljava/lang/Boolean;", "isAutoRefreshEnabled", "Lcom/ironsource/mediationsdk/model/Placement;", "Lcom/ironsource/mediationsdk/model/Placement;", "bannerPlacement", "attributeSet", "<init>", "(Ljava/util/UUID;Lcom/ironsource/w6;Landroid/util/AttributeSet;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class dl extends bl implements w5 {

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final UUID adId;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final w6 bannerContainer;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final fi testSuiteLoadConfigService;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private LevelPlayAdSize adSize;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private LevelPlayBannerAdViewListener bannerListener;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private String placementName;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private v5 bannerAdController;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private Boolean isAutoRefreshEnabled;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private Placement bannerPlacement;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"com/ironsource/dl$a", "Lcom/ironsource/hr;", "", "a", "", ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends hr {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3613a;
        final /* synthetic */ String b;
        final /* synthetic */ dl c;

        a(String str, String str2, dl dlVar) {
            this.f3613a = str;
            this.b = str2;
            this.c = dlVar;
        }

        @Override // com.json.hr
        public void a() {
            String str = this.f3613a;
            if (str != null) {
                this.c.a(str);
            }
            String str2 = this.b;
            if (str2 != null) {
                this.c.adSize = LevelPlayAdSize.INSTANCE.createAdSize$mediationsdk_release(str2);
            }
        }

        @Override // com.json.hr
        public void a(Throwable t) throws Throwable {
            Intrinsics.checkNotNullParameter(t, "t");
            if (t instanceof IllegalArgumentException) {
                throw t;
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public dl(UUID adId, w6 bannerContainer, AttributeSet attributeSet) {
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(bannerContainer, "bannerContainer");
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
        super(new o1(ad_unit, e2.b.MEDIATION));
        this.adId = adId;
        this.bannerContainer = bannerContainer;
        this.testSuiteLoadConfigService = mm.INSTANCE.d().o();
        this.adSize = LevelPlayAdSize.BANNER;
        this.placementName = "";
        getAdTools().getEventSender().a(new o(ad_unit, adId, getAdUnitId()));
        if (attributeSet != null) {
            Context context = bannerContainer.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "bannerContainer.context");
            a(context, attributeSet);
        }
    }

    public /* synthetic */ dl(UUID uuid, w6 w6Var, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? lf.f3858a.a() : uuid, w6Var, attributeSet);
    }

    private final void a(Context context, AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.LevelPlayBannerAdView);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…le.LevelPlayBannerAdView)");
        getAdTools().d(new a(typedArrayObtainStyledAttributes.getString(R.styleable.LevelPlayBannerAdView_adUnitId), typedArrayObtainStyledAttributes.getString(R.styleable.LevelPlayBannerAdView_adSize), this));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final dl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.getIsLoadAdCalled()) {
            IronLog.INTERNAL.warning(o1.a(this$0.getAdTools(), "Banner not loaded", (String) null, 2, (Object) null));
            return;
        }
        if (this$0.bannerAdController == null) {
            IronLog.INTERNAL.warning(o1.a(this$0.getAdTools(), "Banner already destroyed", (String) null, 2, (Object) null));
            return;
        }
        vl.a(this$0.getAdTools(), new Runnable() { // from class: com.ironsource.dl$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                dl.b(this.f$0);
            }
        }, 0L, 2, (Object) null);
        v5 v5Var = this$0.bannerAdController;
        if (v5Var != null) {
            v5Var.k();
        }
        this$0.bannerAdController = null;
        this$0.isAutoRefreshEnabled = null;
        this$0.bannerListener = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(dl this$0, LevelPlayAdError it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this$0.bannerListener;
        if (levelPlayBannerAdViewListener != null) {
            levelPlayBannerAdViewListener.onAdLoadFailed(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(dl this$0, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adInfo, "$adInfo");
        LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this$0.bannerListener;
        if (levelPlayBannerAdViewListener != null) {
            levelPlayBannerAdViewListener.onAdClicked(adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(dl this$0, LevelPlayAdInfo adInfo, LevelPlayAdError it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adInfo, "$adInfo");
        Intrinsics.checkNotNullParameter(it, "$it");
        LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this$0.bannerListener;
        if (levelPlayBannerAdViewListener != null) {
            levelPlayBannerAdViewListener.onAdDisplayFailed(adInfo, it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(dl this$0, LevelPlayBannerAdViewListener levelPlayBannerAdViewListener) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.bannerListener = levelPlayBannerAdViewListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(dl this$0, String placementName) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(placementName, "$placementName");
        if (this$0.getIsLoadAdCalled()) {
            return;
        }
        this$0.placementName = placementName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(dl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.bannerContainer.removeAllViews();
        ViewParent parent = this$0.bannerContainer.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this$0.bannerContainer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(dl this$0, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adInfo, "$adInfo");
        LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this$0.bannerListener;
        if (levelPlayBannerAdViewListener != null) {
            levelPlayBannerAdViewListener.onAdDisplayed(adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(dl this$0, LevelPlayAdSize adSize) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adSize, "$adSize");
        if (this$0.getIsLoadAdCalled()) {
            return;
        }
        this$0.adSize = adSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(dl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getIsLoadAdCalled()) {
            IronLog.INTERNAL.warning(o1.a(this$0.getAdTools(), "Banner load already called", (String) null, 2, (Object) null));
            return;
        }
        this$0.a(true);
        if (this$0.d()) {
            v5 v5VarE = this$0.e();
            Boolean bool = this$0.isAutoRefreshEnabled;
            if (bool != null) {
                if (bool.booleanValue()) {
                    v5VarE.q();
                } else {
                    v5VarE.p();
                }
            }
            v5VarE.l();
            this$0.bannerAdController = v5VarE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(dl this$0, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adInfo, "$adInfo");
        LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this$0.bannerListener;
        if (levelPlayBannerAdViewListener != null) {
            levelPlayBannerAdViewListener.onAdLeftApplication(adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(dl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAdTools().getEventSender().getOperational().b();
        v5 v5Var = this$0.bannerAdController;
        if (v5Var != null) {
            v5Var.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(dl this$0, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adInfo, "$adInfo");
        LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this$0.bannerListener;
        if (levelPlayBannerAdViewListener != null) {
            levelPlayBannerAdViewListener.onAdLoaded(adInfo);
        }
    }

    private final v5 e() {
        Placement placement;
        this.bannerPlacement = getAdTools().a(this.placementName);
        Context context = this.bannerContainer.getContext();
        if (context instanceof Activity) {
            ContextProvider.getInstance().updateActivity((Activity) context);
        }
        UUID uuid = this.adId;
        String adUnitId = getAdUnitId();
        Placement placement2 = this.bannerPlacement;
        Placement placement3 = null;
        if (placement2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bannerPlacement");
            placement = null;
        } else {
            placement = placement2;
        }
        j6 j6Var = new j6(uuid, adUnitId, placement, this.adSize, null, null, this.testSuiteLoadConfigService.getTestSuiteLoadAdConfigInternal(), 48, null);
        a(j6Var);
        ISBannerSize iSBannerSizeA = getAdTools().a(j6Var.getAdSize());
        ac eventSender = getAdTools().getEventSender();
        o1 adTools = getAdTools();
        Placement placement4 = this.bannerPlacement;
        if (placement4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bannerPlacement");
        } else {
            placement3 = placement4;
        }
        eventSender.a(new y6(adTools, iSBannerSizeA, placement3.getPlacementName()));
        return new v5(this, getAdTools(), j6Var, this.bannerContainer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(dl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAdTools().getEventSender().getOperational().c();
        v5 v5Var = this$0.bannerAdController;
        if (v5Var != null) {
            v5Var.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(dl this$0, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adInfo, "$adInfo");
        LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this$0.bannerListener;
        if (levelPlayBannerAdViewListener != null) {
            levelPlayBannerAdViewListener.onAdCollapsed(adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(dl this$0, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adInfo, "$adInfo");
        LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this$0.bannerListener;
        if (levelPlayBannerAdViewListener != null) {
            levelPlayBannerAdViewListener.onAdExpanded(adInfo);
        }
    }

    @Override // com.json.w5
    public void a(final LevelPlayAdError error) {
        if (error != null) {
            b(new Runnable() { // from class: com.ironsource.dl$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    dl.a(this.f$0, error);
                }
            });
        }
    }

    @Override // com.json.w5
    public void a(final LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        b(new Runnable() { // from class: com.ironsource.dl$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                dl.f(this.f$0, adInfo);
            }
        });
    }

    @Override // com.json.w5
    public void a(final LevelPlayAdInfo adInfo, final LevelPlayAdError error) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        if (error != null) {
            b(new Runnable() { // from class: com.ironsource.dl$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    dl.a(this.f$0, adInfo, error);
                }
            });
        }
    }

    @Override // com.json.w5
    public void a(final LevelPlayAdInfo adInfo, boolean isReload) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        b(new Runnable() { // from class: com.ironsource.dl$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                dl.d(this.f$0, adInfo);
            }
        });
    }

    public final void a(final LevelPlayAdSize adSize) {
        Intrinsics.checkNotNullParameter(adSize, "adSize");
        a(new Runnable() { // from class: com.ironsource.dl$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                dl.b(this.f$0, adSize);
            }
        });
    }

    public final void a(final LevelPlayBannerAdViewListener listener) {
        a(new Runnable() { // from class: com.ironsource.dl$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                dl.a(this.f$0, listener);
            }
        });
    }

    public final void b(final String placementName) {
        Intrinsics.checkNotNullParameter(placementName, "placementName");
        a(new Runnable() { // from class: com.ironsource.dl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                dl.a(this.f$0, placementName);
            }
        });
    }

    @Override // com.json.w5
    public void c(final LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        b(new Runnable() { // from class: com.ironsource.dl$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                dl.b(this.f$0, adInfo);
            }
        });
    }

    @Override // com.json.w5
    public void d(final LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        b(new Runnable() { // from class: com.ironsource.dl$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                dl.e(this.f$0, adInfo);
            }
        });
    }

    @Override // com.json.bl
    public boolean d() {
        LevelPlayAdError levelPlayAdError;
        if (getAdUnitId().length() == 0) {
            String string = this.adId.toString();
            Intrinsics.checkNotNullExpressionValue(string, "adId.toString()");
            levelPlayAdError = new LevelPlayAdError(string, getAdUnitId(), LevelPlayAdError.ERROR_CODE_NO_AD_UNIT_ID_SPECIFIED, "Ad unit ID should be specified");
        } else {
            if (getAdTools().g()) {
                el elVarA = mm.INSTANCE.d().t().a();
                if (elVarA != null && elVarA.a(getAdUnitId(), LevelPlay.AdFormat.BANNER)) {
                    return true;
                }
                LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this.bannerListener;
                if (levelPlayBannerAdViewListener != null) {
                    String string2 = this.adId.toString();
                    Intrinsics.checkNotNullExpressionValue(string2, "adId.toString()");
                    levelPlayBannerAdViewListener.onAdLoadFailed(new LevelPlayAdError(string2, getAdUnitId(), LevelPlayAdError.ERROR_CODE_INVALID_AD_UNIT_ID, "Invalid ad unit id"));
                }
                return false;
            }
            String string3 = this.adId.toString();
            Intrinsics.checkNotNullExpressionValue(string3, "adId.toString()");
            levelPlayAdError = new LevelPlayAdError(string3, getAdUnitId(), LevelPlayAdError.ERROR_CODE_LOAD_BEFORE_INIT_SUCCESS_CALLBACK, "load must be called after init success callback");
        }
        a(levelPlayAdError);
        return false;
    }

    @Override // com.json.w5
    public void e(final LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        b(new Runnable() { // from class: com.ironsource.dl$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                dl.a(this.f$0, adInfo);
            }
        });
    }

    public final void f() {
        a(new Runnable() { // from class: com.ironsource.dl$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                dl.a(this.f$0);
            }
        });
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final UUID getAdId() {
        return this.adId;
    }

    @Override // com.json.w5
    public void g(final LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        b(new Runnable() { // from class: com.ironsource.dl$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                dl.c(this.f$0, adInfo);
            }
        });
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final LevelPlayAdSize getAdSize() {
        return this.adSize;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final LevelPlayBannerAdViewListener getBannerListener() {
        return this.bannerListener;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final String getPlacementName() {
        return this.placementName;
    }

    public final void k() {
        a(new Runnable() { // from class: com.ironsource.dl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                dl.c(this.f$0);
            }
        });
    }

    public final void l() {
        Unit unit;
        if (this.bannerAdController != null) {
            a(new Runnable() { // from class: com.ironsource.dl$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    dl.d(this.f$0);
                }
            });
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.isAutoRefreshEnabled = Boolean.FALSE;
        }
    }

    public final void m() {
        Unit unit;
        if (this.bannerAdController != null) {
            a(new Runnable() { // from class: com.ironsource.dl$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    dl.e(this.f$0);
                }
            });
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.isAutoRefreshEnabled = Boolean.TRUE;
        }
    }
}
