package com.json;

import androidx.exifinterface.media.ExifInterface;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.json.environment.ContextProvider;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.json.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.json.mediationsdk.adunit.adapter.listener.NetworkInitializationListener;
import com.json.mediationsdk.adunit.adapter.utility.AdData;
import com.json.mediationsdk.adunit.adapter.utility.AdapterErrorType;
import com.json.mediationsdk.impressionData.ImpressionData;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.logger.IronSourceError;
import com.json.mediationsdk.model.Placement;
import com.json.mediationsdk.utils.ErrorBuilder;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.unity3d.mediation.LevelPlayAdInfo;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.models.AdExperience;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000Ã\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\n\b&\u0018\u00002\u00020\u0001:\u0001\u0005B)\u0012\u0006\u00105\u001a\u000201\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010;\u001a\u000209\u0012\u0006\u0010'\u001a\u00020=¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\u001a\u0010\u0005\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u000f\u0010\u0005\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0005\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0002J*\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0004J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#H\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u001fJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&J\b\u0010(\u001a\u00020\u0006H\u0016J\u000f\u0010)\u001a\u00020\u0006H\u0010¢\u0006\u0004\b)\u0010*J\b\u0010+\u001a\u00020\u0006H$J\u0014\u0010\u0005\u001a\u00020\u00112\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0011H\u0004J\b\u0010-\u001a\u00020\u0006H\u0016J \u0010.\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010/\u001a\u00020\u0006H\u0016J\b\u00100\u001a\u00020\u0006H\u0016R\u0017\u00105\u001a\u0002018\u0006¢\u0006\f\n\u0004\b\u0005\u00102\u001a\u0004\b3\u00104R\u001a\u0010\u0003\u001a\u00020\u00028\u0004X\u0084\u0004¢\u0006\f\n\u0004\b(\u00106\u001a\u0004\b7\u00108R\u0014\u0010;\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010:R$\u0010'\u001a\u0010\u0012\f\u0012\n >*\u0004\u0018\u00010=0=0<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020&8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010AR!\u0010F\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b3\u0010C\u001a\u0004\bD\u0010ER\u0018\u0010I\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR$\u0010S\u001a\u00020\u001f2\u0006\u0010N\u001a\u00020\u001f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR$\u0010V\u001a\u00020\u001f2\u0006\u0010N\u001a\u00020\u001f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bT\u0010P\u001a\u0004\bU\u0010RR$\u0010Y\u001a\u00020\u001f2\u0006\u0010N\u001a\u00020\u001f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bW\u0010P\u001a\u0004\bX\u0010RR$\u0010\\\u001a\u00020\u001f2\u0006\u0010N\u001a\u00020\u001f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bZ\u0010P\u001a\u0004\b[\u0010RR\u001a\u0010`\u001a\u00020]8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b7\u0010^\u001a\u0004\bO\u0010_R\u0017\u0010e\u001a\u00020a8\u0006¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bK\u0010dR\u0019\u0010g\u001a\u0004\u0018\u00010a8\u0006¢\u0006\f\n\u0004\bf\u0010c\u001a\u0004\bZ\u0010dR\u0017\u0010j\u001a\u00020\u001f8\u0006¢\u0006\f\n\u0004\bh\u0010P\u001a\u0004\bi\u0010RR\u0017\u0010n\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\bk\u0010l\u001a\u0004\bf\u0010mR\u0017\u0010r\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\bo\u0010p\u001a\u0004\bk\u0010qR\u0017\u0010t\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\bs\u0010l\u001a\u0004\bh\u0010mR\u0017\u0010x\u001a\u00020u8\u0006¢\u0006\f\n\u0004\bi\u0010v\u001a\u0004\b?\u0010wR\u0017\u0010y\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b[\u0010p\u001a\u0004\bs\u0010qR\u0017\u0010\u001c\u001a\u00020z8\u0006¢\u0006\f\n\u0004\bU\u0010{\u001a\u0004\bo\u0010|R\u0014\u0010}\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bb\u0010qR\u0014\u0010~\u001a\u00020\u00118DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bW\u0010mR\u0018\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u007f8DX\u0084\u0004¢\u0006\u0007\u001a\u0005\bT\u0010\u0080\u0001¨\u0006\u0084\u0001"}, d2 = {"Lcom/ironsource/a0;", "Lcom/ironsource/mediationsdk/adunit/adapter/internal/listener/AdapterAdListener;", "Lcom/ironsource/b0;", "instanceData", "Lcom/ironsource/mediationsdk/adunit/adapter/internal/BaseAdAdapter;", "a", "", "F", "G", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "com/ironsource/a0$b", "()Lcom/ironsource/a0$b;", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "error", ExifInterface.LONGITUDE_EAST, "", "errorCode", "", "errorMessage", "C", "Lcom/ironsource/mediationsdk/adunit/adapter/utility/AdapterErrorType;", "adapterErrorType", "D", "B", "errorType", "", "duration", "Lcom/ironsource/q1$a;", AdExperience.PERFORMANCE, "Lcom/unity3d/mediation/LevelPlayAdInfo;", "e", "", VastAttributes.VERTICAL_POSITION, "Lcom/ironsource/j0;", "adInstancePresenter", "Ljava/lang/Runnable;", "callback", "status", "Lcom/ironsource/f0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()V", "z", "message", "onAdLoadSuccess", nu.b, nu.c, nu.f, "Lcom/ironsource/w2;", "Lcom/ironsource/w2;", InneractiveMediationDefs.GENDER_FEMALE, "()Lcom/ironsource/w2;", "adTools", "Lcom/ironsource/b0;", "m", "()Lcom/ironsource/b0;", "Lcom/ironsource/h0;", "Lcom/ironsource/h0;", "adInstancePayload", "Ljava/lang/ref/WeakReference;", "Lcom/ironsource/e0;", "kotlin.jvm.PlatformType", "d", "Ljava/lang/ref/WeakReference;", "Lcom/ironsource/f0;", "loadListener", "Lcom/ironsource/mediationsdk/adunit/adapter/internal/BaseAdAdapter;", "g", "()Lcom/ironsource/mediationsdk/adunit/adapter/internal/BaseAdAdapter;", "adapter", "Lcom/ironsource/ib;", "Lcom/ironsource/ib;", "loadDuration", "Lcom/ironsource/hr;", "h", "Lcom/ironsource/hr;", "timeoutRunnable", "<set-?>", "i", "Z", "w", "()Z", "isInstanceLoading", "j", "v", "isInstanceLoaded", CampaignEx.JSON_KEY_AD_K, VastAttributes.HORIZONTAL_POSITION, "isInstanceOpened", "l", ApsMetricsDataMap.APSMETRICS_FIELD_URL, "isInstanceFailed", "Lcom/ironsource/mediationsdk/adunit/adapter/utility/AdData;", "Lcom/ironsource/mediationsdk/adunit/adapter/utility/AdData;", "()Lcom/ironsource/mediationsdk/adunit/adapter/utility/AdData;", "currentAdData", "Lcom/ironsource/m5;", "n", "Lcom/ironsource/m5;", "()Lcom/ironsource/m5;", "auctionResponseItem", "o", "genericNotifications", "p", ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, "isBidder", CampaignEx.JSON_KEY_AD_Q, "Ljava/lang/String;", "()Ljava/lang/String;", "instanceName", "r", "I", "()I", "instanceType", "s", "instanceSignature", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "()Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT, "sessionDepth", "Lcom/ironsource/i0;", "Lcom/ironsource/i0;", "()Lcom/ironsource/i0;", "instanceLoadTimeoutInSeconds", "currentPlacementName", "Lcom/ironsource/mediationsdk/model/Placement;", "()Lcom/ironsource/mediationsdk/model/Placement;", "currentPlacement", "<init>", "(Lcom/ironsource/w2;Lcom/ironsource/b0;Lcom/ironsource/h0;Lcom/ironsource/e0;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public abstract class a0 implements AdapterAdListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final w2 adTools;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final b0 instanceData;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final h0 adInstancePayload;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private WeakReference<e0> listener;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private f0 loadListener;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final BaseAdAdapter<?, ?> adapter;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private ib loadDuration;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private hr timeoutRunnable;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private boolean isInstanceLoading;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private boolean isInstanceLoaded;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private boolean isInstanceOpened;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private boolean isInstanceFailed;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private final AdData currentAdData;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private final m5 auctionResponseItem;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private final m5 genericNotifications;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private final boolean isBidder;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    private final String instanceName;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    private final int instanceType;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    private final String instanceSignature;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    private final IronSource.AD_UNIT adFormat;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    private final int sessionDepth;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    private final i0 performance;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u000b"}, d2 = {"Lcom/ironsource/a0$a;", "Lcom/ironsource/mediationsdk/adunit/adapter/listener/NetworkInitializationListener;", "", "onInitSuccess", "", "errorCode", "", "errorMessage", "onInitFailed", "<init>", "(Lcom/ironsource/a0;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    final class a implements NetworkInitializationListener {
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(a0 this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.E();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(a0 this$0, int i, String str) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.a(i, str);
        }

        @Override // com.json.mediationsdk.adunit.adapter.listener.NetworkInitializationListener
        public void onInitFailed(final int errorCode, final String errorMessage) {
            final a0 a0Var = a0.this;
            a0Var.a(new Runnable() { // from class: com.ironsource.a0$a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    a0.a.a(a0Var, errorCode, errorMessage);
                }
            });
        }

        @Override // com.json.mediationsdk.adunit.adapter.listener.NetworkInitializationListener
        public void onInitSuccess() {
            final a0 a0Var = a0.this;
            a0Var.a(new Runnable() { // from class: com.ironsource.a0$a$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    a0.a.a(a0Var);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/ironsource/a0$b", "Lcom/ironsource/hr;", "", "a", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends hr {
        b() {
        }

        @Override // com.json.hr
        public void a() {
            long jA = ib.a(a0.this.loadDuration);
            IronLog.INTERNAL.verbose(a0.this.a("Load duration = " + jA + ", isBidder = " + a0.this.getIsBidder()));
            a0.this.isInstanceFailed = true;
            a0.this.getAdTools().getEventSender().getLoad().a(jA, 1025, false);
            a0.this.getAdTools().getEventSender().getLoad().a(jA, 1025, "time out", false);
            a0 a0Var = a0.this;
            IronSourceError ironSourceErrorBuildLoadFailedError = ErrorBuilder.buildLoadFailedError("time out");
            Intrinsics.checkNotNullExpressionValue(ironSourceErrorBuildLoadFailedError, "buildLoadFailedError(errorMessage)");
            a0Var.a(ironSourceErrorBuildLoadFailedError);
        }
    }

    public a0(w2 adTools, b0 instanceData, h0 adInstancePayload, e0 listener) {
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(instanceData, "instanceData");
        Intrinsics.checkNotNullParameter(adInstancePayload, "adInstancePayload");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.adTools = adTools;
        this.instanceData = instanceData;
        this.adInstancePayload = adInstancePayload;
        this.listener = new WeakReference<>(listener);
        this.currentAdData = instanceData.getAdData();
        this.auctionResponseItem = instanceData.n();
        this.genericNotifications = instanceData.getGenericNotifications();
        this.isBidder = instanceData.j().j();
        this.instanceName = instanceData.getInstanceName();
        this.instanceType = instanceData.getInstanceType();
        this.instanceSignature = instanceData.getSignature();
        this.adFormat = instanceData.getAdFormat();
        this.sessionDepth = instanceData.v();
        this.performance = instanceData.getPerformance();
        BaseAdAdapter<?, ?> baseAdAdapterA = a(instanceData);
        this.adapter = baseAdAdapterA;
        adTools.getEventSender().a(new c0(adTools, instanceData, baseAdAdapterA));
        adTools.getEventSender().a(new u4(instanceData.k()));
    }

    private final void A() {
        IronLog.INTERNAL.verbose(a(this, (String) null, 1, (Object) null));
        try {
            F();
            z();
        } catch (Throwable th) {
            o9.d().a(th);
            String str = "unexpected error while calling adapter.loadAd() - " + th.getMessage();
            IronLog.INTERNAL.error(a(str));
            this.adTools.getEventSender().getTroubleshoot().g(str);
            a(AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL, 510, str);
        }
    }

    private final void B() {
        IronLog.INTERNAL.verbose(a(this, (String) null, 1, (Object) null));
        this.adTools.getEventSender().getAdInteraction().a(k());
        e0 e0Var = this.listener.get();
        if (e0Var != null) {
            e0Var.a(this);
        }
    }

    private final void C() {
        IronLog ironLog = IronLog.INTERNAL;
        f0 f0Var = null;
        ironLog.verbose(a(this, (String) null, 1, (Object) null));
        G();
        if (this.isInstanceFailed) {
            c();
            return;
        }
        if (this.isInstanceLoaded) {
            return;
        }
        this.isInstanceLoaded = true;
        long jA = ib.a(this.loadDuration);
        ironLog.verbose(a("Load duration = " + jA));
        this.adTools.getEventSender().getLoad().a(jA, false);
        a(q1.a.LoadedSuccessfully);
        f0 f0Var2 = this.loadListener;
        if (f0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadListener");
        } else {
            f0Var = f0Var2;
        }
        f0Var.a(this);
    }

    private final void D() {
        IronLog.INTERNAL.verbose(a(this, (String) null, 1, (Object) null));
        if (this.isInstanceOpened) {
            return;
        }
        this.isInstanceOpened = true;
        this.adTools.getEventSender().getAdInteraction().g(k());
        a(q1.a.ShowedSuccessfully);
        e0 e0Var = this.listener.get();
        if (e0Var != null) {
            e0Var.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E() {
        IronLog.INTERNAL.verbose(a(this, (String) null, 1, (Object) null));
        G();
        if (this.isInstanceFailed) {
            return;
        }
        A();
    }

    private final void F() {
        G();
        b bVarA = a();
        this.timeoutRunnable = bVarA;
        if (bVarA != null) {
            this.adTools.a((hr) bVarA, TimeUnit.SECONDS.toMillis(n()));
        }
    }

    private final void G() {
        hr hrVar = this.timeoutRunnable;
        if (hrVar != null) {
            this.adTools.b(hrVar);
            this.timeoutRunnable = null;
        }
    }

    private final b a() {
        return new b();
    }

    private final BaseAdAdapter<?, ?> a(b0 instanceData) {
        return instanceData.i().getAuctionSettings().p() ? this.adInstancePayload.b() : this.adTools.a(instanceData);
    }

    public static /* synthetic */ String a(a0 a0Var, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createLogMessage");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        return a0Var.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int errorCode, String errorMessage) {
        IronLog.INTERNAL.verbose(a("error = " + errorCode + ", " + errorMessage));
        G();
        this.isInstanceFailed = true;
        a(AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL, errorCode, errorMessage, ib.a(this.loadDuration));
        a(new IronSourceError(errorCode, errorMessage));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(a0 this$0, AdapterErrorType adapterErrorType, int i, String errorMessage) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapterErrorType, "$adapterErrorType");
        Intrinsics.checkNotNullParameter(errorMessage, "$errorMessage");
        this$0.a(adapterErrorType, i, errorMessage);
    }

    private final void a(AdapterErrorType adapterErrorType, int errorCode, String errorMessage) {
        long jA = ib.a(this.loadDuration);
        IronLog.INTERNAL.verbose(a("Load duration = " + jA + ", error = " + errorCode + ", " + errorMessage));
        G();
        c();
        a(adapterErrorType, errorCode, errorMessage, jA);
        this.isInstanceFailed = true;
        a(new IronSourceError(errorCode, errorMessage));
    }

    private final void a(AdapterErrorType errorType, int errorCode, String errorMessage, long duration) {
        if (errorType == AdapterErrorType.ADAPTER_ERROR_TYPE_NO_FILL) {
            this.adTools.getEventSender().getLoad().a(duration, errorCode);
        } else {
            this.adTools.getEventSender().getLoad().a(duration, errorCode, errorMessage, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(IronSourceError error) {
        a(q1.a.FailedToLoad);
        f0 f0Var = this.loadListener;
        if (f0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadListener");
            f0Var = null;
        }
        f0Var.a(error, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(a0 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(a0 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(a0 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.D();
    }

    private final int n() {
        Integer numF = this.instanceData.n().f();
        return (numF == null || numF.intValue() <= 0) ? this.instanceData.i().getInstanceLoadTimeout() : numF.intValue();
    }

    protected final String a(String message) {
        return this.adTools.a(message, this.instanceSignature);
    }

    public final void a(f0 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a(this, (String) null, 1, (Object) null));
        this.loadListener = listener;
        this.isInstanceLoading = true;
        try {
            this.adTools.getEventSender().getLoad().a(false);
            this.loadDuration = new ib();
            F();
            BaseAdAdapter<?, ?> baseAdAdapter = this.adapter;
            Intrinsics.checkNotNull(baseAdAdapter);
            AdapterBaseInterface networkAdapter = baseAdAdapter.getNetworkAdapter();
            if (networkAdapter != null) {
                networkAdapter.init(this.instanceData.getAdData(), ContextProvider.getInstance().getApplicationContext(), new a());
            } else {
                String str = "loadAd - network adapter not available " + this.instanceSignature;
                ironLog.error(a(str));
                a(a2.c(this.instanceData.getAdFormat()), str);
            }
        } catch (Throwable th) {
            o9.d().a(th);
            String str2 = "loadAd - exception = " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(a(str2));
            this.adTools.getEventSender().getTroubleshoot().g(str2);
            a(a2.c(this.instanceData.getAdFormat()), str2);
        }
    }

    public abstract void a(j0 adInstancePresenter);

    protected final void a(q1.a performance) {
        Intrinsics.checkNotNullParameter(performance, "performance");
        this.instanceData.a(performance);
    }

    protected final void a(Runnable callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.adTools.a(callback);
    }

    public final void a(boolean status) {
        this.adTools.getEventSender().getAdInteraction().a(status);
    }

    public void b() {
        IronLog.INTERNAL.verbose(a(this, (String) null, 1, (Object) null));
        G();
        this.adTools.getEventSender().getLoad().a(this.sessionDepth);
    }

    public void c() {
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final IronSource.AD_UNIT getAdFormat() {
        return this.adFormat;
    }

    public LevelPlayAdInfo e() {
        String string = this.instanceData.i().getAdProperties().getAdId().toString();
        Intrinsics.checkNotNullExpressionValue(string, "instanceData.adUnitData.…roperties.adId.toString()");
        String strC = this.instanceData.i().getAdProperties().getAdUnitId();
        String string2 = this.instanceData.getAdFormat().toString();
        Intrinsics.checkNotNullExpressionValue(string2, "instanceData.adFormat.toString()");
        return new LevelPlayAdInfo(string, strC, string2, this.instanceData.n().a(k()), this.instanceData.n().d(), null, null, 96, null);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final w2 getAdTools() {
        return this.adTools;
    }

    public final BaseAdAdapter<?, ?> g() {
        return this.adapter;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final m5 getAuctionResponseItem() {
        return this.auctionResponseItem;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    protected final AdData getCurrentAdData() {
        return this.currentAdData;
    }

    protected final Placement j() {
        return this.instanceData.i().getAdProperties().getPlacement();
    }

    protected final String k() {
        return this.instanceData.i().l();
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final m5 getGenericNotifications() {
        return this.genericNotifications;
    }

    /* JADX INFO: renamed from: m, reason: from getter */
    protected final b0 getInstanceData() {
        return this.instanceData;
    }

    /* JADX INFO: renamed from: o, reason: from getter */
    public final String getInstanceName() {
        return this.instanceName;
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdClicked() {
        a(new Runnable() { // from class: com.ironsource.a0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                a0.c(this.f$0);
            }
        });
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdLoadFailed(final AdapterErrorType adapterErrorType, final int errorCode, final String errorMessage) {
        Intrinsics.checkNotNullParameter(adapterErrorType, "adapterErrorType");
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        a(new Runnable() { // from class: com.ironsource.a0$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                a0.a(this.f$0, adapterErrorType, errorCode, errorMessage);
            }
        });
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdLoadSuccess() {
        a(new Runnable() { // from class: com.ironsource.a0$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                a0.d(this.f$0);
            }
        });
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdOpened() {
        a(new Runnable() { // from class: com.ironsource.a0$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                a0.e(this.f$0);
            }
        });
    }

    /* JADX INFO: renamed from: p, reason: from getter */
    public final String getInstanceSignature() {
        return this.instanceSignature;
    }

    /* JADX INFO: renamed from: q, reason: from getter */
    public final int getInstanceType() {
        return this.instanceType;
    }

    /* JADX INFO: renamed from: r, reason: from getter */
    public final i0 getPerformance() {
        return this.performance;
    }

    /* JADX INFO: renamed from: s, reason: from getter */
    public final int getSessionDepth() {
        return this.sessionDepth;
    }

    /* JADX INFO: renamed from: t, reason: from getter */
    public final boolean getIsBidder() {
        return this.isBidder;
    }

    /* JADX INFO: renamed from: u, reason: from getter */
    public final boolean getIsInstanceFailed() {
        return this.isInstanceFailed;
    }

    /* JADX INFO: renamed from: v, reason: from getter */
    public final boolean getIsInstanceLoaded() {
        return this.isInstanceLoaded;
    }

    /* JADX INFO: renamed from: w, reason: from getter */
    public final boolean getIsInstanceLoading() {
        return this.isInstanceLoading;
    }

    /* JADX INFO: renamed from: x, reason: from getter */
    public final boolean getIsInstanceOpened() {
        return this.isInstanceOpened;
    }

    public boolean y() {
        return this.isInstanceLoaded;
    }

    protected abstract void z();
}
