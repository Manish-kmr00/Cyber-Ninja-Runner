package com.json;

import android.app.Activity;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.json.mediationsdk.impressionData.ImpressionData;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.a;
import com.unity3d.mediation.rewarded.LevelPlayReward;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0002\u0007\u0019BI\u0012\u0006\u0010&\u001a\u00020\"\u0012\u0006\u0010*\u001a\u00020\u0010\u0012\u0006\u00100\u001a\u00020+\u0012\u0006\u00105\u001a\u000201\u0012\u0006\u0010;\u001a\u000206\u0012\b\b\u0002\u0010@\u001a\u00020<\u0012\u0006\u0010C\u001a\u00020A\u0012\u0006\u0010X\u001a\u00020W¢\u0006\u0004\bY\u0010ZJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0007\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0017\u0010\u0007\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0007\u0010\fJ\u0006\u0010\r\u001a\u00020\nJ\u0018\u0010\u0007\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\nJ\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\u0012\u0010\u0018\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016J\u0010\u0010\u0007\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\nH\u0016J\b\u0010\u001b\u001a\u00020\nH\u0016J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\nH\u0016J\u0010\u0010\u0007\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0017\u0010\u0007\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\u001fJ\u0019\u0010\u0019\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0019\u0010 J\u001f\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0019\u0010!R\u0017\u0010&\u001a\u00020\"8\u0006¢\u0006\f\n\u0004\b\u0007\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010*\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0019\u0010'\u001a\u0004\b(\u0010)R\u0017\u00100\u001a\u00020+8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0017\u00105\u001a\u0002018\u0006¢\u0006\f\n\u0004\b$\u00102\u001a\u0004\b3\u00104R\u001a\u0010;\u001a\u0002068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0017\u0010@\u001a\u00020<8\u0006¢\u0006\f\n\u0004\b.\u0010=\u001a\u0004\b>\u0010?R\u0014\u0010C\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010BR$\u0010H\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010E\u001a\u0004\b,\u0010F\"\u0004\b\u0007\u0010GR$\u0010N\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010J\u001a\u0004\bK\u0010L\"\u0004\b\u0007\u0010MR\u001a\u0010R\u001a\u00020O8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bK\u0010P\u001a\u0004\b7\u0010QR\u0016\u0010\u000b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010SR\u0018\u0010V\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010U¨\u0006["}, d2 = {"Lcom/ironsource/gl;", "Lcom/ironsource/gd;", "Lcom/unity3d/mediation/LevelPlayAdError;", "displayError", "Lcom/unity3d/mediation/LevelPlayAdInfo;", "currentAdInfo", "Lcom/ironsource/od;", "a", "oldAdInfo", "newAdInfo", "", "state", "(Lcom/ironsource/od;)V", "m", "Landroid/app/Activity;", "activity", "", "placementName", "", "l", "n", "adInfo", "onAdLoaded", "error", nu.b, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, nu.g, nu.f, "onAdInfoChanged", "Lcom/unity3d/mediation/rewarded/LevelPlayReward;", "reward", "(Lcom/unity3d/mediation/LevelPlayAdInfo;)V", "(Lcom/unity3d/mediation/LevelPlayAdError;)V", "(Lcom/unity3d/mediation/LevelPlayAdError;Lcom/unity3d/mediation/LevelPlayAdInfo;)V", "Lcom/unity3d/mediation/LevelPlay$AdFormat;", "Lcom/unity3d/mediation/LevelPlay$AdFormat;", "d", "()Lcom/unity3d/mediation/LevelPlay$AdFormat;", ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT, "Ljava/lang/String;", "h", "()Ljava/lang/String;", "adUnitId", "Lcom/ironsource/o1;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/o1;", InneractiveMediationDefs.GENDER_FEMALE, "()Lcom/ironsource/o1;", "adTools", "Lcom/ironsource/ed;", "Lcom/ironsource/ed;", "i", "()Lcom/ironsource/ed;", "fullscreenAdControllerFactory", "Lcom/ironsource/x1;", "e", "Lcom/ironsource/x1;", "g", "()Lcom/ironsource/x1;", "adUnitDataFactory", "Lcom/ironsource/xf;", "Lcom/ironsource/xf;", CampaignEx.JSON_KEY_AD_K, "()Lcom/ironsource/xf;", "mediationServicesProvider", "Lcom/ironsource/q9;", "Lcom/ironsource/q9;", "currentTimeProvider", "Lcom/ironsource/dd;", "Lcom/ironsource/dd;", "()Lcom/ironsource/dd;", "(Lcom/ironsource/dd;)V", "adController", "Lcom/ironsource/hl;", "Lcom/ironsource/hl;", "j", "()Lcom/ironsource/hl;", "(Lcom/ironsource/hl;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Ljava/util/UUID;", "Ljava/util/UUID;", "()Ljava/util/UUID;", "adId", "Lcom/ironsource/od;", "Lcom/ironsource/ib;", "Lcom/ironsource/ib;", "loadDuration", "Lcom/ironsource/lf;", "idFactory", "<init>", "(Lcom/unity3d/mediation/LevelPlay$AdFormat;Ljava/lang/String;Lcom/ironsource/o1;Lcom/ironsource/ed;Lcom/ironsource/x1;Lcom/ironsource/xf;Lcom/ironsource/q9;Lcom/ironsource/lf;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class gl implements gd {

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final LevelPlay.AdFormat adFormat;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String adUnitId;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final o1 adTools;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final ed fullscreenAdControllerFactory;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final x1 adUnitDataFactory;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final xf mediationServicesProvider;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final q9 currentTimeProvider;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private dd adController;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private hl listener;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final UUID adId;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private od state;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private ib loadDuration;

    /* JADX INFO: renamed from: com.ironsource.gl$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lcom/ironsource/gl$a;", "", "", "placementName", "Lcom/unity3d/mediation/LevelPlay$AdFormat;", ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT, "", "a", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(String placementName, LevelPlay.AdFormat adFormat) {
            Intrinsics.checkNotNullParameter(placementName, "placementName");
            Intrinsics.checkNotNullParameter(adFormat, "adFormat");
            o1 o1VarA = o1.a.a(a.a(adFormat), e2.b.MEDIATION);
            if (!o1VarA.g()) {
                o1VarA.getEventSender().getAdInteraction().a(placementName, "SDK is not initialized", false);
                return false;
            }
            l8 l8VarA = mm.INSTANCE.d().y().a(placementName, adFormat);
            boolean zD = l8VarA.d();
            o1VarA.getEventSender().getAdInteraction().a(placementName, l8VarA.e(), zD);
            return zD;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\nR\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\r\u0010\u0015R\u0017\u0010\u001a\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0018\u001a\u0004\b\u0013\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/ironsource/gl$b;", "", "Lcom/ironsource/o1;", "a", "Lcom/ironsource/o1;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Lcom/ironsource/o1;", "adTools", "Lcom/ironsource/ed;", "Lcom/ironsource/ed;", "()Lcom/ironsource/ed;", "adControllerFactory", "Lcom/ironsource/xf;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/xf;", "e", "()Lcom/ironsource/xf;", IronSourceConstants.EVENTS_PROVIDER, "Lcom/ironsource/q9;", "d", "Lcom/ironsource/q9;", "()Lcom/ironsource/q9;", "currentTimeProvider", "Lcom/ironsource/lf;", "Lcom/ironsource/lf;", "()Lcom/ironsource/lf;", "idFactory", "<init>", "(Lcom/ironsource/o1;Lcom/ironsource/ed;Lcom/ironsource/xf;Lcom/ironsource/q9;Lcom/ironsource/lf;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final o1 adTools;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final ed adControllerFactory;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private final xf provider;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private final q9 currentTimeProvider;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        private final lf idFactory;

        public b(o1 adTools, ed adControllerFactory, xf provider, q9 currentTimeProvider, lf idFactory) {
            Intrinsics.checkNotNullParameter(adTools, "adTools");
            Intrinsics.checkNotNullParameter(adControllerFactory, "adControllerFactory");
            Intrinsics.checkNotNullParameter(provider, "provider");
            Intrinsics.checkNotNullParameter(currentTimeProvider, "currentTimeProvider");
            Intrinsics.checkNotNullParameter(idFactory, "idFactory");
            this.adTools = adTools;
            this.adControllerFactory = adControllerFactory;
            this.provider = provider;
            this.currentTimeProvider = currentTimeProvider;
            this.idFactory = idFactory;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final ed getAdControllerFactory() {
            return this.adControllerFactory;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final o1 getAdTools() {
            return this.adTools;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final q9 getCurrentTimeProvider() {
            return this.currentTimeProvider;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final lf getIdFactory() {
            return this.idFactory;
        }

        /* JADX INFO: renamed from: e, reason: from getter */
        public final xf getProvider() {
            return this.provider;
        }
    }

    public gl(LevelPlay.AdFormat adFormat, String adUnitId, o1 adTools, ed fullscreenAdControllerFactory, x1 adUnitDataFactory, xf mediationServicesProvider, q9 currentTimeProvider, lf idFactory) {
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(fullscreenAdControllerFactory, "fullscreenAdControllerFactory");
        Intrinsics.checkNotNullParameter(adUnitDataFactory, "adUnitDataFactory");
        Intrinsics.checkNotNullParameter(mediationServicesProvider, "mediationServicesProvider");
        Intrinsics.checkNotNullParameter(currentTimeProvider, "currentTimeProvider");
        Intrinsics.checkNotNullParameter(idFactory, "idFactory");
        this.adFormat = adFormat;
        this.adUnitId = adUnitId;
        this.adTools = adTools;
        this.fullscreenAdControllerFactory = fullscreenAdControllerFactory;
        this.adUnitDataFactory = adUnitDataFactory;
        this.mediationServicesProvider = mediationServicesProvider;
        this.currentTimeProvider = currentTimeProvider;
        UUID uuidA = idFactory.a();
        this.adId = uuidA;
        this.state = new hd(this, false, 2, null);
        adTools.getEventSender().a(new o(a.a(adFormat), uuidA, adUnitId));
    }

    public /* synthetic */ gl(LevelPlay.AdFormat adFormat, String str, o1 o1Var, ed edVar, x1 x1Var, xf xfVar, q9 q9Var, lf lfVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(adFormat, str, o1Var, edVar, x1Var, (i & 32) != 0 ? mm.INSTANCE.d() : xfVar, q9Var, lfVar);
    }

    private final od a(LevelPlayAdError displayError, LevelPlayAdInfo currentAdInfo) {
        if (cb.f3577a.a(qu.f4209a.a(displayError))) {
            return new ld(this, currentAdInfo, this.currentTimeProvider);
        }
        return new hd(this, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(gl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.adTools.getEventSender().getOperational().a();
        this$0.state.loadAd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(gl this$0, long j) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.adTools.getEventSender().getOperational().a(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(gl this$0, long j, LevelPlayAdError levelPlayAdError) {
        String errorMessage;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        vo operational = this$0.adTools.getEventSender().getOperational();
        int errorCode = levelPlayAdError != null ? levelPlayAdError.getErrorCode() : 0;
        if (levelPlayAdError == null || (errorMessage = levelPlayAdError.getErrorMessage()) == null) {
            errorMessage = "";
        }
        operational.a(j, errorCode, errorMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(gl this$0, Activity activity, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        this$0.adTools.getEventSender().getTroubleshoot().d();
        this$0.state.a(activity, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(gl this$0, LevelPlayAdError error) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(error, "$error");
        this$0.adTools.getEventSender().getTroubleshoot().a(error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(gl this$0, LevelPlayAdError error, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(error, "$error");
        Intrinsics.checkNotNullParameter(adInfo, "$adInfo");
        hl hlVar = this$0.listener;
        if (hlVar != null) {
            hlVar.onAdDisplayFailed(error, adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(gl this$0, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adInfo, "$adInfo");
        hl hlVar = this$0.listener;
        if (hlVar != null) {
            hlVar.onAdLoaded(adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(gl this$0, LevelPlayReward reward) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reward, "$reward");
        hl hlVar = this$0.listener;
        if (hlVar != null) {
            hlVar.onAdRewarded(reward, this$0.state.getAdInfo());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LevelPlayAdError levelPlayAdError, gl this$0) {
        hl hlVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (levelPlayAdError == null || (hlVar = this$0.listener) == null) {
            return;
        }
        hlVar.onAdLoadFailed(levelPlayAdError);
    }

    private final void a(LevelPlayAdInfo oldAdInfo, LevelPlayAdInfo newAdInfo) {
        this.adTools.getEventSender().getTroubleshoot().a(oldAdInfo, newAdInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(gl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        hl hlVar = this$0.listener;
        if (hlVar != null) {
            hlVar.onAdClicked(this$0.state.getAdInfo());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(gl this$0, LevelPlayAdError error, LevelPlayAdInfo currentAdInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(error, "$error");
        Intrinsics.checkNotNullParameter(currentAdInfo, "$currentAdInfo");
        this$0.a(this$0.a(error, currentAdInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(gl this$0, LevelPlayAdInfo currentAdInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(currentAdInfo, "$currentAdInfo");
        hl hlVar = this$0.listener;
        if (hlVar != null) {
            hlVar.onAdClosed(currentAdInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(gl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a(new hd(this$0, false, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(gl this$0, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adInfo, "$adInfo");
        this$0.a(this$0.state.getAdInfo(), adInfo);
        this$0.state.onAdInfoChanged(adInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(gl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.adTools.getEventSender().getTroubleshoot().e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(gl this$0, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adInfo, "$adInfo");
        hl hlVar = this$0.listener;
        if (hlVar != null) {
            hlVar.onAdInfoChanged(adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(gl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        hl hlVar = this$0.listener;
        if (hlVar != null) {
            hlVar.onAdDisplayed(this$0.state.getAdInfo());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(gl this$0, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adInfo, "$adInfo");
        this$0.a(new ld(this$0, adInfo, this$0.currentTimeProvider));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(gl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.state.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(gl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a(new hd(this$0, false, 2, null));
    }

    @Override // com.json.gd
    public void a() {
        this.adTools.d(new Runnable() { // from class: com.ironsource.gl$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                gl.f(this.f$0);
            }
        });
    }

    public final void a(final Activity activity, final String placementName) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.adTools.d(new Runnable() { // from class: com.ironsource.gl$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                gl.a(this.f$0, activity, placementName);
            }
        });
    }

    public final void a(dd ddVar) {
        this.adController = ddVar;
    }

    public final void a(hl hlVar) {
        this.listener = hlVar;
    }

    public final void a(od state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.state = state;
    }

    @Override // com.json.gd
    public void a(final LevelPlayAdError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        final LevelPlayAdInfo adInfo = this.state.getAdInfo();
        this.adTools.d(new Runnable() { // from class: com.ironsource.gl$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                gl.b(this.f$0, error, adInfo);
            }
        });
        b(error, adInfo);
    }

    public final void a(final LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        IronLog.CALLBACK.verbose(o1.a(this.adTools, "onAdLoaded adInfo: " + adInfo, (String) null, 2, (Object) null));
        final long jA = ib.a(this.loadDuration);
        this.adTools.d(new Runnable() { // from class: com.ironsource.gl$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                gl.a(this.f$0, jA);
            }
        });
        this.adTools.e(new Runnable() { // from class: com.ironsource.gl$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                gl.a(this.f$0, adInfo);
            }
        });
    }

    @Override // com.json.gd
    public void a(final LevelPlayReward reward) {
        Intrinsics.checkNotNullParameter(reward, "reward");
        IronLog.CALLBACK.verbose(o1.a(this.adTools, "onAdRewarded adInfo: " + this.state.getAdInfo() + " reward: " + reward, (String) null, 2, (Object) null));
        this.adTools.e(new Runnable() { // from class: com.ironsource.gl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                gl.a(this.f$0, reward);
            }
        });
    }

    @Override // com.json.gd
    public void b() {
        IronLog.CALLBACK.verbose(o1.a(this.adTools, "onAdDisplayed adInfo: " + this.state.getAdInfo(), (String) null, 2, (Object) null));
        this.adTools.d(new Runnable() { // from class: com.ironsource.gl$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                gl.d(this.f$0);
            }
        });
        this.adTools.e(new Runnable() { // from class: com.ironsource.gl$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                gl.e(this.f$0);
            }
        });
    }

    public final void b(final LevelPlayAdError error) {
        IronLog.CALLBACK.verbose(o1.a(this.adTools, "onAdLoadFailed error: " + error, (String) null, 2, (Object) null));
        final long jA = ib.a(this.loadDuration);
        this.adTools.d(new Runnable() { // from class: com.ironsource.gl$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                gl.a(this.f$0, jA, error);
            }
        });
        this.adTools.e(new Runnable() { // from class: com.ironsource.gl$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                gl.a(error, this);
            }
        });
    }

    public final void b(final LevelPlayAdError error, final LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        IronLog.CALLBACK.verbose(o1.a(this.adTools, "onAdDisplayFailed error: " + error + ", adInfo: " + adInfo, (String) null, 2, (Object) null));
        this.adTools.d(new Runnable() { // from class: com.ironsource.gl$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                gl.a(this.f$0, error);
            }
        });
        this.adTools.e(new Runnable() { // from class: com.ironsource.gl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                gl.a(this.f$0, error, adInfo);
            }
        });
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final dd getAdController() {
        return this.adController;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final LevelPlay.AdFormat getAdFormat() {
        return this.adFormat;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final UUID getAdId() {
        return this.adId;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final o1 getAdTools() {
        return this.adTools;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final x1 getAdUnitDataFactory() {
        return this.adUnitDataFactory;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final String getAdUnitId() {
        return this.adUnitId;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final ed getFullscreenAdControllerFactory() {
        return this.fullscreenAdControllerFactory;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final hl getListener() {
        return this.listener;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final xf getMediationServicesProvider() {
        return this.mediationServicesProvider;
    }

    public final boolean l() {
        j1 j1VarC = this.state.c();
        this.adTools.getEventSender().getLoad().a(Boolean.valueOf(j1VarC.getIsReady()), j1VarC instanceof j1.a ? ((j1.a) j1VarC).c() : null);
        return j1VarC.getIsReady();
    }

    public final void m() {
        this.loadDuration = new ib();
        this.adTools.d(new Runnable() { // from class: com.ironsource.gl$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                gl.a(this.f$0);
            }
        });
    }

    public final void n() {
        a(new md(this));
        dd ddVar = this.adController;
        if (ddVar != null) {
            ddVar.i();
        }
    }

    @Override // com.json.gd
    public void onAdClicked() {
        IronLog.CALLBACK.verbose(o1.a(this.adTools, "onAdClicked adInfo: " + this.state.getAdInfo(), (String) null, 2, (Object) null));
        this.adTools.e(new Runnable() { // from class: com.ironsource.gl$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                gl.b(this.f$0);
            }
        });
    }

    @Override // com.json.gd
    public void onAdClosed() {
        final LevelPlayAdInfo adInfo = this.state.getAdInfo();
        IronLog.CALLBACK.verbose(o1.a(this.adTools, "onAdClosed adInfo: " + adInfo, (String) null, 2, (Object) null));
        this.adTools.d(new Runnable() { // from class: com.ironsource.gl$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                gl.c(this.f$0);
            }
        });
        this.adTools.e(new Runnable() { // from class: com.ironsource.gl$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                gl.b(this.f$0, adInfo);
            }
        });
    }

    @Override // com.json.gd
    public void onAdInfoChanged(final LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        IronLog.CALLBACK.verbose(o1.a(this.adTools, "onAdInfoChanged adInfo: " + adInfo, (String) null, 2, (Object) null));
        this.adTools.d(new Runnable() { // from class: com.ironsource.gl$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                gl.c(this.f$0, adInfo);
            }
        });
        this.adTools.e(new Runnable() { // from class: com.ironsource.gl$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                gl.d(this.f$0, adInfo);
            }
        });
    }

    @Override // com.json.gd
    public void onAdLoadFailed(LevelPlayAdError error) {
        this.adTools.d(new Runnable() { // from class: com.ironsource.gl$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                gl.g(this.f$0);
            }
        });
        b(error);
    }

    @Override // com.json.gd
    public void onAdLoaded(final LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.adTools.d(new Runnable() { // from class: com.ironsource.gl$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                gl.e(this.f$0, adInfo);
            }
        });
        a(adInfo);
    }
}
