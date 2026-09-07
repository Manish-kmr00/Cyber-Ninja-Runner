package com.json;

import android.app.Activity;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.json.mediationsdk.d;
import com.json.mediationsdk.impressionData.ImpressionData;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.logger.IronSourceError;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.rewarded.LevelPlayReward;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000bBq\u0012\u0006\u0010\"\u001a\u00020 \u0012\u0006\u0010%\u001a\u00020#\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010,\u001a\u00020*\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\f\u0012(\b\u0002\u00100\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n\u0018\u00010-j\u0004\u0018\u0001`.\u0012\b\b\u0002\u00103\u001a\u000201\u0012\b\b\u0002\u00107\u001a\u000204¢\u0006\u0004\bN\u0010OJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0001H\u0002J\u0012\u0010\u000b\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u000b\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\u000e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012J\u0016\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010!R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010+R4\u00100\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n\u0018\u00010-j\u0004\u0018\u0001`.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010/R\u0014\u00103\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010>\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010I\u001a\u00020G8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010HR\u0014\u0010L\u001a\u00020J8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010K¨\u0006P"}, d2 = {"Lcom/ironsource/pd;", "Lcom/ironsource/jd;", "Lcom/ironsource/rl;", "", "d", "Lcom/ironsource/b0;", "data", "Lcom/ironsource/h0;", "adInstancePayload", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/ironsource/id;", "a", "Lcom/ironsource/wv;", "factory", "Lcom/ironsource/vv;", "Lcom/ironsource/cw;", "e", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/ironsource/pd$a;", "loadListener", "Landroid/app/Activity;", "activity", "Lcom/ironsource/y1;", "displayListener", "Lcom/ironsource/a0;", m5.p, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "fullscreenInstance", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "error", "Lcom/unity3d/mediation/rewarded/LevelPlayReward;", "reward", "Lcom/ironsource/mm;", "Lcom/ironsource/mm;", "mediationServices", "Lcom/ironsource/w2;", "Lcom/ironsource/w2;", "adUnitTools", "Lcom/ironsource/w1;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/w1;", "adUnitData", "Lcom/ironsource/sd;", "Lcom/ironsource/sd;", "fullscreenListener", "Lkotlin/Function3;", "Lcom/unity3d/mediation/internal/ads/controllers/adunits/FullscreenAdInstanceFactory;", "Lkotlin/jvm/functions/Function3;", "fullscreenAdInstanceFactory", "Lcom/ironsource/ut;", "Lcom/ironsource/ut;", "taskScheduler", "Lcom/ironsource/q9;", "g", "Lcom/ironsource/q9;", "currentTimeProvider", "h", "Lcom/ironsource/pd$a;", "i", "Lcom/ironsource/y1;", "j", "Lcom/ironsource/vv;", d.h, "Lcom/ironsource/ut$a;", CampaignEx.JSON_KEY_AD_K, "Lcom/ironsource/ut$a;", "expirationScheduledTask", "", "l", "Ljava/lang/Long;", b9.h.y0, "Lcom/unity3d/mediation/LevelPlay$AdFormat;", "()Lcom/unity3d/mediation/LevelPlay$AdFormat;", ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT, "", "()Ljava/lang/String;", "currentPlacementName", "waterfallFactory", "<init>", "(Lcom/ironsource/mm;Lcom/ironsource/w2;Lcom/ironsource/w1;Lcom/ironsource/sd;Lcom/ironsource/wv;Lkotlin/jvm/functions/Function3;Lcom/ironsource/ut;Lcom/ironsource/q9;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class pd implements jd {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final mm mediationServices;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final w2 adUnitTools;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final w1 adUnitData;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final sd fullscreenListener;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final Function3<b0, h0, jd, id> fullscreenAdInstanceFactory;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final ut taskScheduler;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final q9 currentTimeProvider;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private a loadListener;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private y1 displayListener;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final vv waterfall;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private ut.a expirationScheduledTask;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private Long loadStartTime;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0004H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Lcom/ironsource/pd$a;", "", "Lcom/unity3d/mediation/LevelPlayAdInfo;", "adInfo", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "error", "a", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public interface a {
        void a();

        void a(IronSourceError error);

        void a(LevelPlayAdInfo adInfo);

        void b(LevelPlayAdInfo adInfo);
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, d2 = {"com/ironsource/pd$b", "Lcom/ironsource/cw;", "Lcom/ironsource/a0;", m5.p, "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "errorCode", "", "errorReason", "a", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements cw {
        b() {
        }

        @Override // com.json.cw
        public void a(int errorCode, String errorReason) {
            Long lValueOf;
            Intrinsics.checkNotNullParameter(errorReason, "errorReason");
            Long l = pd.this.loadStartTime;
            if (l != null) {
                lValueOf = Long.valueOf(pd.this.currentTimeProvider.a() - l.longValue());
            } else {
                lValueOf = null;
            }
            pd.this.adUnitTools.getEventSender().getLoad().a(lValueOf != null ? lValueOf.longValue() : 0L, errorCode, errorReason, pd.this.adUnitData.getIsPublisherLoad());
            a aVar = pd.this.loadListener;
            if (aVar != null) {
                aVar.a(new IronSourceError(errorCode, errorReason));
            }
        }

        @Override // com.json.cw
        public void a(a0 instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            pd.this.adUnitTools.getEventSender().getAdInteraction().e(pd.this.c());
            pd.this.e();
            a aVar = pd.this.loadListener;
            if (aVar != null) {
                aVar.a(instance.e());
            }
        }

        @Override // com.json.cw
        public void b(a0 instance) {
            Long lValueOf;
            Intrinsics.checkNotNullParameter(instance, "instance");
            Long l = pd.this.loadStartTime;
            if (l != null) {
                lValueOf = Long.valueOf(pd.this.currentTimeProvider.a() - l.longValue());
            } else {
                lValueOf = null;
            }
            pd.this.adUnitTools.getEventSender().getLoad().a(lValueOf != null ? lValueOf.longValue() : 0L, pd.this.adUnitData.getIsPublisherLoad());
            pd.this.e();
            a aVar = pd.this.loadListener;
            if (aVar != null) {
                aVar.b(instance.e());
            }
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class c extends FunctionReferenceImpl implements Function3<b0, h0, jd, id> {
        c(Object obj) {
            super(3, obj, pd.class, "createAdInstance", "createAdInstance(Lcom/unity3d/mediation/internal/ads/controllers/adunits/adinstances/AdInstanceData;Lcom/unity3d/mediation/internal/ads/controllers/adunits/adinstances/AdInstancePayload;Lcom/unity3d/mediation/internal/ads/controllers/adunits/adinstances/listeners/FullscreenAdInstanceListener;)Lcom/unity3d/mediation/internal/ads/controllers/adunits/adinstances/FullscreenAdInstance;", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final id invoke(b0 p0, h0 p1, jd p2) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            Intrinsics.checkNotNullParameter(p2, "p2");
            return ((pd) this.receiver).a(p0, p1, p2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public pd(mm mediationServices, w2 adUnitTools, w1 adUnitData, sd fullscreenListener, wv wvVar, Function3<? super b0, ? super h0, ? super jd, id> function3, ut taskScheduler, q9 currentTimeProvider) {
        Intrinsics.checkNotNullParameter(mediationServices, "mediationServices");
        Intrinsics.checkNotNullParameter(adUnitTools, "adUnitTools");
        Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
        Intrinsics.checkNotNullParameter(fullscreenListener, "fullscreenListener");
        Intrinsics.checkNotNullParameter(taskScheduler, "taskScheduler");
        Intrinsics.checkNotNullParameter(currentTimeProvider, "currentTimeProvider");
        this.mediationServices = mediationServices;
        this.adUnitTools = adUnitTools;
        this.adUnitData = adUnitData;
        this.fullscreenListener = fullscreenListener;
        this.fullscreenAdInstanceFactory = function3;
        this.taskScheduler = taskScheduler;
        this.currentTimeProvider = currentTimeProvider;
        this.waterfall = a(wvVar);
    }

    public /* synthetic */ pd(mm mmVar, w2 w2Var, w1 w1Var, sd sdVar, wv wvVar, Function3 function3, ut utVar, q9 q9Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(mmVar, w2Var, w1Var, sdVar, (i & 16) != 0 ? null : wvVar, (i & 32) != 0 ? null : function3, (i & 64) != 0 ? new le(Handler.a(w2Var.a())) : utVar, (i & 128) != 0 ? new q9.a() : q9Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 a(pd this$0, b0 instanceData, h0 adInstancePayload) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(instanceData, "instanceData");
        Intrinsics.checkNotNullParameter(adInstancePayload, "adInstancePayload");
        Function3 cVar = this$0.fullscreenAdInstanceFactory;
        if (cVar == null) {
            cVar = new c(this$0);
        }
        return (a0) cVar.invoke(instanceData, adInstancePayload, this$0);
    }

    private final cw a() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final id a(b0 data, h0 adInstancePayload, jd listener) {
        return new id(new w2(this.adUnitTools, e2.b.PROVIDER), data, adInstancePayload, listener);
    }

    private final vv a(wv factory) {
        cw cwVarA = a();
        return factory != null ? factory.a(cwVarA) : new vv(this.adUnitTools, this.adUnitData, cwVarA);
    }

    private final LevelPlay.AdFormat b() {
        return this.adUnitData.getAdProperties().d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String c() {
        return this.adUnitData.l();
    }

    private final rl<Unit> d() {
        if (!this.waterfall.c()) {
            return new rl.a(new IronSourceError(509, "show called while ad unit is not ready to show"));
        }
        if (this.mediationServices.y().a(c(), b()).d()) {
            return new rl.a(new IronSourceError(IronSourceError.ERROR_PLACEMENT_CAPPED, "placement " + c() + " is capped"));
        }
        return this.mediationServices.u().a(this.adUnitData.getAdProperties().getAdUnitId()).d() ? new rl.a(new IronSourceError(IronSourceError.ERROR_AD_UNIT_CAPPED, "adUnitId " + this.adUnitData.getAdProperties().getAdUnitId() + " is capped")) : new rl.b(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        ut.a aVar = this.expirationScheduledTask;
        if (aVar != null) {
            aVar.a();
        }
        long jB = this.adUnitTools.b(b());
        ut utVar = this.taskScheduler;
        Runnable runnable = new Runnable() { // from class: com.ironsource.pd$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                pd.h(this.f$0);
            }
        };
        Duration.Companion companion = Duration.INSTANCE;
        this.expirationScheduledTask = utVar.a(runnable, DurationKt.toDuration(jB, DurationUnit.MILLISECONDS));
    }

    private final void f() {
        String strC = c();
        if (strC.length() > 0) {
            this.mediationServices.a().b(strC, b());
            l8 l8VarA = this.mediationServices.y().a(strC, b());
            if (l8VarA.d()) {
                this.adUnitTools.getEventSender().getAdInteraction().b(strC, l8VarA.e());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(pd this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.loadListener;
        if (aVar != null) {
            aVar.a();
        }
        this$0.waterfall.b();
    }

    public final void a(Activity activity, y1 displayListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(displayListener, "displayListener");
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(o1.a(this.adUnitTools, (String) null, (String) null, 3, (Object) null));
        this.displayListener = displayListener;
        this.adUnitTools.getEventSender().getAdInteraction().a(activity, c());
        rl<Unit> rlVarD = d();
        if (rlVarD instanceof rl.a) {
            IronSourceError ironSourceErrorB = ((rl.a) rlVarD).b();
            ironLog.verbose(o1.a(this.adUnitTools, ironSourceErrorB.getErrorMessage(), (String) null, 2, (Object) null));
            this.adUnitTools.getEventSender().getAdInteraction().a(c(), ironSourceErrorB.getErrorCode(), ironSourceErrorB.getErrorMessage(), "");
            displayListener.b(ironSourceErrorB);
            return;
        }
        ut.a aVar = this.expirationScheduledTask;
        if (aVar != null) {
            aVar.a();
        }
        this.waterfall.a(new kd(activity));
    }

    @Override // com.json.e0
    public void a(a0 instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        this.adUnitTools.getEventSender().getAdInteraction().a(c());
        this.fullscreenListener.c();
    }

    @Override // com.json.jd
    public void a(id fullscreenInstance) {
        Intrinsics.checkNotNullParameter(fullscreenInstance, "fullscreenInstance");
        this.adUnitTools.getEventSender().getAdInteraction().l(c());
        y1 y1Var = this.displayListener;
        if (y1Var != null) {
            y1Var.b();
        }
        f();
        this.mediationServices.w().b(this.adUnitData.getAdProperties().getAdUnitId());
    }

    @Override // com.json.jd
    public void a(id fullscreenInstance, IronSourceError error) {
        Intrinsics.checkNotNullParameter(fullscreenInstance, "fullscreenInstance");
        Intrinsics.checkNotNullParameter(error, "error");
        IronLog.INTERNAL.verbose(o1.a(this.adUnitTools, error.toString(), (String) null, 2, (Object) null));
        this.adUnitTools.getEventSender().getAdInteraction().a(c(), error.getErrorCode(), error.getErrorMessage(), "");
        y1 y1Var = this.displayListener;
        if (y1Var != null) {
            y1Var.b(error);
        }
    }

    @Override // com.json.jd
    public void a(id fullscreenInstance, LevelPlayReward reward) {
        Intrinsics.checkNotNullParameter(fullscreenInstance, "fullscreenInstance");
        Intrinsics.checkNotNullParameter(reward, "reward");
        IronLog.INTERNAL.verbose(o1.a(this.adUnitTools, fullscreenInstance.getInstanceSignature(), (String) null, 2, (Object) null));
        this.fullscreenListener.a(reward);
    }

    public final void a(a loadListener) {
        Intrinsics.checkNotNullParameter(loadListener, "loadListener");
        IronLog.INTERNAL.verbose(o1.a(this.adUnitTools, (String) null, (String) null, 3, (Object) null));
        this.loadListener = loadListener;
        this.loadStartTime = Long.valueOf(this.currentTimeProvider.a());
        this.adUnitTools.a(new r1(this.adUnitData.getAdProperties()));
        d0 d0Var = new d0() { // from class: com.ironsource.pd$$ExternalSyntheticLambda0
            @Override // com.json.d0
            public final a0 a(b0 b0Var, h0 h0Var) {
                return pd.a(this.f$0, b0Var, h0Var);
            }
        };
        this.adUnitTools.getEventSender().getLoad().a(this.adUnitData.getIsPublisherLoad());
        this.waterfall.a(d0Var);
    }

    @Override // com.json.e0
    public void b(a0 instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        this.waterfall.b(instance);
        this.adUnitTools.getEventSender().getAdInteraction().g(c());
        this.mediationServices.e().b(com.unity3d.mediation.a.a(b()));
    }

    @Override // com.json.jd
    public void b(id fullscreenInstance) {
        Intrinsics.checkNotNullParameter(fullscreenInstance, "fullscreenInstance");
        this.adUnitTools.getEventSender().getAdInteraction().b(c());
        this.fullscreenListener.onClosed();
    }
}
