package com.json;

import android.text.TextUtils;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.json.environment.ContextProvider;
import com.json.mediationsdk.AdapterUtils;
import com.json.mediationsdk.ISBannerSize;
import com.json.mediationsdk.l;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.model.Placement;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0005B\u001f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\u0006\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u0005\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bJ\b\u0010\u0005\u001a\u00020\u000bH\u0014J\b\u0010\r\u001a\u00020\fH\u0016R\"\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u00060\u0014R\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019¨\u0006 "}, d2 = {"Lcom/ironsource/l6;", "Lcom/ironsource/p1;", "Lcom/ironsource/mediationsdk/ISBannerSize;", "m", k6.u, "a", "Lcom/ironsource/ov;", "viewBinder", "Lcom/ironsource/y1;", "displayListener", "", "Lcom/ironsource/d0;", "Lcom/ironsource/r1;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/ref/WeakReference;", "Lcom/ironsource/o6;", "kotlin.jvm.PlatformType", CampaignEx.JSON_KEY_AD_K, "Ljava/lang/ref/WeakReference;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/ironsource/l6$a;", "l", "Lcom/ironsource/l6$a;", "adInstanceListener", "Lcom/ironsource/m6;", "Lcom/ironsource/m6;", "bannerAdUnitData", "Lcom/ironsource/o1;", "tools", "adUnitData", "<init>", "(Lcom/ironsource/o1;Lcom/ironsource/m6;Lcom/ironsource/o6;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class l6 extends p1 {

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final WeakReference<o6> listener;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private final a adInstanceListener;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private final m6 bannerAdUnitData;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\bH\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\bH\u0016¨\u0006\r"}, d2 = {"Lcom/ironsource/l6$a;", "Lcom/ironsource/p1$a;", "Lcom/ironsource/p1;", "Lcom/ironsource/z5;", "Lcom/ironsource/a0;", m5.p, "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/x5;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "a", "<init>", "(Lcom/ironsource/l6;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    private final class a extends p1.a implements z5 {
        public a() {
            super();
        }

        @Override // com.json.z5
        public void a(x5 instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            IronLog.INTERNAL.verbose(l6.this.a(instance.getInstanceSignature()));
            o6 o6Var = (o6) l6.this.listener.get();
            if (o6Var != null) {
                o6Var.d();
            }
        }

        @Override // com.ironsource.p1.a, com.json.e0
        public void b(a0 instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            super.b(instance);
            y1 displayListener = l6.this.getDisplayListener();
            if (displayListener != null) {
                displayListener.b();
            }
        }

        @Override // com.json.z5
        public void b(x5 instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            IronLog.INTERNAL.verbose(l6.this.a(instance.getInstanceSignature()));
            o6 o6Var = (o6) l6.this.listener.get();
            if (o6Var != null) {
                o6Var.g();
            }
        }

        @Override // com.json.z5
        public void c(x5 instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            IronLog.INTERNAL.verbose(l6.this.a(instance.getInstanceSignature()));
            o6 o6Var = (o6) l6.this.listener.get();
            if (o6Var != null) {
                o6Var.e();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l6(o1 tools, m6 adUnitData, o6 listener) {
        String str;
        int iB;
        super(tools, adUnitData, listener, null, 8, null);
        Intrinsics.checkNotNullParameter(tools, "tools");
        Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = new WeakReference<>(listener);
        this.adInstanceListener = new a();
        this.bannerAdUnitData = adUnitData;
        Placement placementG = g();
        IronLog.INTERNAL.verbose("placement = " + placementG);
        if (placementG == null || TextUtils.isEmpty(placementG.getPlacementName())) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            str = String.format("can't load banner - %s", Arrays.copyOf(new Object[]{placementG == null ? "placement is null" : "placement name is empty"}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            iB = a2.b(adUnitData.getAdProperties().getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String());
        } else {
            str = null;
            iB = 510;
        }
        if (str != null) {
            IronLog.API.error(a(str));
            a(iB, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 a(l6 this$0, b0 instanceData, h0 adInstancePayload) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(instanceData, "instanceData");
        Intrinsics.checkNotNullParameter(adInstancePayload, "adInstancePayload");
        return new x5(new w2(this$0.getAdUnitTools(), e2.b.PROVIDER), instanceData, adInstancePayload, this$0.adInstanceListener);
    }

    private final ISBannerSize a(ISBannerSize bannerSize) {
        if (bannerSize.isSmart()) {
            return AdapterUtils.isLargeScreen(ContextProvider.getInstance().getApplicationContext()) ? l.a() : ISBannerSize.BANNER;
        }
        return bannerSize;
    }

    private final ISBannerSize m() {
        return getAdUnitTools().a(this.bannerAdUnitData.getAdProperties().getAdSize());
    }

    @Override // com.json.p1
    protected d0 a() {
        return new d0() { // from class: com.ironsource.l6$$ExternalSyntheticLambda0
            @Override // com.json.d0
            public final a0 a(b0 b0Var, h0 h0Var) {
                return l6.a(this.f$0, b0Var, h0Var);
            }
        };
    }

    public final void a(ov viewBinder, y1 displayListener) {
        Intrinsics.checkNotNullParameter(displayListener, "displayListener");
        if (viewBinder != null) {
            a(new b6(viewBinder), displayListener);
        }
    }

    @Override // com.json.p1
    public r1 b() {
        return new s6(this.bannerAdUnitData.getAdProperties(), a(m()));
    }
}
