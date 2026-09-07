package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.json.mediationsdk.d;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.logger.IronSourceError;
import com.json.mediationsdk.model.Placement;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000£\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0002\b&\u0018\u00002\u00020\u0001:\u0001\bB)\u0012\u0006\u0010L\u001a\u00020K\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u0012\u0006\u00108\u001a\u000204\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001d¢\u0006\u0004\bM\u0010NJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H$J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fJ\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0004J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\b\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013H\u0004R\u001a\u0010\u001c\u001a\u00020\u00188\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u001eR\u001a\u0010$\u001a\u00020 8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010#R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b\u0016\u0010)R$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010*\u001a\u0004\b+\u0010,\"\u0004\b\b\u0010-R\u001a\u00102\u001a\u00020.8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\"\u0010/\u001a\u0004\b0\u00101R\"\u00108\u001a\u0010\u0012\f\u0012\n 5*\u0004\u0018\u00010404038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010>R\u0014\u0010B\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010AR\u0016\u0010E\u001a\u0004\u0018\u00010C8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b6\u0010DR\u0014\u0010G\u001a\u00020\u00138DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b:\u0010FR\u0014\u0010J\u001a\u00020H8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010I¨\u0006O"}, d2 = {"Lcom/ironsource/p1;", "", "com/ironsource/p1$b", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Lcom/ironsource/p1$b;", "", "l", "Lcom/ironsource/d0;", "a", "Lcom/ironsource/m2;", "loadListener", "Lcom/ironsource/j0;", "adInstancePresenter", "Lcom/ironsource/y1;", "displayListener", "", "isPublisherDestroy", "", "errorCode", "", "errorReason", "Lcom/ironsource/r1;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "message", "Lcom/ironsource/w1;", "Lcom/ironsource/w1;", "e", "()Lcom/ironsource/w1;", "adUnitData", "Lcom/ironsource/le;", "Lcom/ironsource/le;", "taskScheduler", "Lcom/ironsource/w2;", "Lcom/ironsource/w2;", InneractiveMediationDefs.GENDER_FEMALE, "()Lcom/ironsource/w2;", "adUnitTools", "d", "Lcom/ironsource/m2;", "j", "()Lcom/ironsource/m2;", "(Lcom/ironsource/m2;)V", "Lcom/ironsource/y1;", "i", "()Lcom/ironsource/y1;", "(Lcom/ironsource/y1;)V", "Lcom/ironsource/vv;", "Lcom/ironsource/vv;", CampaignEx.JSON_KEY_AD_K, "()Lcom/ironsource/vv;", d.h, "Ljava/lang/ref/WeakReference;", "Lcom/ironsource/k2;", "kotlin.jvm.PlatformType", "g", "Ljava/lang/ref/WeakReference;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/ironsource/ib;", "h", "Lcom/ironsource/ib;", "loadDuration", "Lcom/ironsource/ut$a;", "Lcom/ironsource/ut$a;", "expirationScheduledTask", "Lcom/ironsource/ac;", "Lcom/ironsource/ac;", "eventsWrapper", "Lcom/ironsource/mediationsdk/model/Placement;", "()Lcom/ironsource/mediationsdk/model/Placement;", "currentPlacement", "()Ljava/lang/String;", "currentPlacementName", "Lcom/ironsource/j1;", "()Lcom/ironsource/j1;", "adReadyStatus", "Lcom/ironsource/o1;", "adTools", "<init>", "(Lcom/ironsource/o1;Lcom/ironsource/w1;Lcom/ironsource/k2;Lcom/ironsource/le;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public abstract class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final w1 adUnitData;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final le taskScheduler;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final w2 adUnitTools;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private m2 loadListener;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private y1 displayListener;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final vv waterfall;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final WeakReference<k2> listener;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private ib loadDuration;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private ut.a expirationScheduledTask;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final ac eventsWrapper;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0094\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/ironsource/p1$a;", "Lcom/ironsource/e0;", "Lcom/ironsource/a0;", m5.p, "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "a", "<init>", "(Lcom/ironsource/p1;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    protected class a implements e0 {
        public a() {
        }

        @Override // com.json.e0
        public void a(a0 instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            p1.this.eventsWrapper.getAdInteraction().a(p1.this.h());
            k2 k2Var = (k2) p1.this.listener.get();
            if (k2Var != null) {
                k2Var.c();
            }
        }

        @Override // com.json.e0
        public void b(a0 instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            IronLog.INTERNAL.verbose(p1.this.a(instance.getInstanceSignature()));
            p1.this.getWaterfall().b(instance);
            p1.this.eventsWrapper.getAdInteraction().g(p1.this.h());
            p1.this.getAdUnitTools().m().b(p1.this.getAdUnitData().getAdProperties().getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String());
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, d2 = {"com/ironsource/p1$b", "Lcom/ironsource/cw;", "Lcom/ironsource/a0;", m5.p, "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "errorCode", "", "errorReason", "a", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements cw {
        b() {
        }

        @Override // com.json.cw
        public void a(int errorCode, String errorReason) {
            Intrinsics.checkNotNullParameter(errorReason, "errorReason");
            p1.this.a(errorCode, errorReason);
        }

        @Override // com.json.cw
        public void a(a0 instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            p1.this.getAdUnitTools().getEventSender().getAdInteraction().e(p1.this.h());
            m2 loadListener = p1.this.getLoadListener();
            if (loadListener != null) {
                loadListener.b(new t1(p1.this, instance.e()));
            }
            p1.this.l();
        }

        @Override // com.json.cw
        public void b(a0 instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            p1.this.eventsWrapper.getLoad().a(ib.a(p1.this.loadDuration), p1.this.getAdUnitData().getIsPublisherLoad());
            m2 loadListener = p1.this.getLoadListener();
            if (loadListener != null) {
                loadListener.c(new t1(p1.this, instance.e()));
            }
            p1.this.l();
        }
    }

    public p1(o1 adTools, w1 adUnitData, k2 listener, le taskScheduler) {
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(taskScheduler, "taskScheduler");
        this.adUnitData = adUnitData;
        this.taskScheduler = taskScheduler;
        w2 w2Var = new w2(adTools, adUnitData, e2.b.MEDIATION);
        this.adUnitTools = w2Var;
        this.waterfall = new vv(w2Var, adUnitData, c());
        this.listener = new WeakReference<>(listener);
        this.eventsWrapper = w2Var.getEventSender();
        IronLog.INTERNAL.verbose("adFormat = " + adUnitData.getAdProperties().getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String() + ", adUnitId = " + adUnitData.getAdProperties().getAdUnitId());
    }

    public /* synthetic */ p1(o1 o1Var, w1 w1Var, k2 k2Var, le leVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(o1Var, w1Var, k2Var, (i & 8) != 0 ? new le(Handler.a(o1Var.a())) : leVar);
    }

    private final b c() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(p1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        m2 m2Var = this$0.loadListener;
        if (m2Var != null) {
            m2Var.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        IronLog.INTERNAL.verbose(a("starting expiration scheduled task"));
        ut.a aVar = this.expirationScheduledTask;
        if (aVar != null) {
            aVar.a();
        }
        long jB = this.adUnitTools.b(this.adUnitData.getAdProperties().d());
        le leVar = this.taskScheduler;
        Runnable runnable = new Runnable() { // from class: com.ironsource.p1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                p1.e(this.f$0);
            }
        };
        Duration.Companion companion = Duration.INSTANCE;
        this.expirationScheduledTask = leVar.a(runnable, DurationKt.toDuration(jB, DurationUnit.MILLISECONDS));
    }

    protected abstract d0 a();

    protected final String a(String message) {
        return o1.a(this.adUnitTools, message, (String) null, 2, (Object) null);
    }

    protected final void a(int errorCode, String errorReason) {
        Intrinsics.checkNotNullParameter(errorReason, "errorReason");
        IronLog.INTERNAL.verbose(a("errorCode = " + errorCode + ", errorReason = " + errorReason));
        this.eventsWrapper.getLoad().a(ib.a(this.loadDuration), errorCode, errorReason, this.adUnitData.getIsPublisherLoad());
        m2 m2Var = this.loadListener;
        if (m2Var != null) {
            m2Var.a(new IronSourceError(errorCode, errorReason));
        }
    }

    public final void a(j0 adInstancePresenter, y1 displayListener) {
        Intrinsics.checkNotNullParameter(adInstancePresenter, "adInstancePresenter");
        Intrinsics.checkNotNullParameter(displayListener, "displayListener");
        this.displayListener = displayListener;
        ut.a aVar = this.expirationScheduledTask;
        if (aVar != null) {
            aVar.a();
        }
        this.waterfall.a(adInstancePresenter);
    }

    public final void a(m2 loadListener) {
        Intrinsics.checkNotNullParameter(loadListener, "loadListener");
        IronLog.INTERNAL.verbose(o1.a(this.adUnitTools, (String) null, (String) null, 3, (Object) null));
        this.adUnitTools.a(b());
        this.loadListener = loadListener;
        this.eventsWrapper.a(this.adUnitData.getIsPublisherLoad());
        this.loadDuration = new ib();
        this.waterfall.a(a());
    }

    protected final void a(y1 y1Var) {
        this.displayListener = y1Var;
    }

    public final void a(boolean isPublisherDestroy) {
        IronLog.INTERNAL.verbose(o1.a(this.adUnitTools, (String) null, (String) null, 3, (Object) null));
        this.waterfall.a();
        if (isPublisherDestroy) {
            this.adUnitTools.getEventSender().getLoad().a(this.adUnitTools.f());
        }
    }

    public r1 b() {
        return new r1(this.adUnitData.getAdProperties());
    }

    protected final void b(m2 m2Var) {
        this.loadListener = m2Var;
    }

    public j1 d() {
        return this.waterfall.c() ? j1.b.f3794a : new j1.a(null, 1, null);
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    protected final w1 getAdUnitData() {
        return this.adUnitData;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    protected final w2 getAdUnitTools() {
        return this.adUnitTools;
    }

    protected final Placement g() {
        return this.adUnitData.getAdProperties().getPlacement();
    }

    protected final String h() {
        return this.adUnitData.l();
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    protected final y1 getDisplayListener() {
        return this.displayListener;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    protected final m2 getLoadListener() {
        return this.loadListener;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    protected final vv getWaterfall() {
        return this.waterfall;
    }
}
