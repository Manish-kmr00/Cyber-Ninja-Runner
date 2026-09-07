package com.json;

import android.text.TextUtils;
import com.json.environment.ContextProvider;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.IronSourceSegment;
import com.json.mediationsdk.ads.nativead.internal.InternalNativeAdListener;
import com.json.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.json.mediationsdk.adunit.adapter.utility.AdInfo;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.logger.IronSourceError;
import com.json.mediationsdk.model.NetworkSettings;
import com.json.mediationsdk.model.Placement;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\u00020\u0004B=\u0012\u0010\u0010+\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010*\u0012\u0006\u0010-\u001a\u00020,\u0012\b\u0010.\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u00100\u001a\u00020/\u0012\b\u00102\u001a\u0004\u0018\u000101¢\u0006\u0004\b3\u00104J<\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\b\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\u0010\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0006\u0010\u0016\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0017J \u0010\u0015\u001a\u00020\u00142\f\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0014J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001f\u001a\u00020\u0014H\u0014J\u001c\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010!\u001a\u00020 H\u0016J\u0010\u0010\u000f\u001a\u00020$2\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010&\u001a\u00020%H\u0014J\b\u0010'\u001a\u00020\u000bH\u0014J\b\u0010(\u001a\u00020%H\u0014J\b\u0010)\u001a\u00020\u000bH\u0014¨\u00065"}, d2 = {"Lcom/ironsource/an;", "Lcom/ironsource/n7;", "Lcom/ironsource/en;", "Lcom/ironsource/mediationsdk/adunit/adapter/internal/listener/AdapterAdListener;", "Lcom/ironsource/r2;", "Lcom/ironsource/mediationsdk/model/NetworkSettings;", tr.b, "Lcom/ironsource/mediationsdk/adunit/adapter/internal/BaseAdAdapter;", "adapter", "", "sessionDepth", "", "currentAuctionId", "Lcom/ironsource/m5;", "item", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/l2;", "g", "Lcom/ironsource/mediationsdk/model/Placement;", "placement", "", "a", "M", "Lcom/ironsource/mediationsdk/ads/nativead/internal/InternalNativeAdListener;", "nativeAdListener", "Lcom/ironsource/q7;", "smash", "Lcom/ironsource/mediationsdk/adunit/adapter/utility/AdInfo;", "adInfo", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "error", "G", "Lcom/ironsource/b2;", "event", "", "", "Lorg/json/JSONObject;", "", "v", "o", "H", "l", "", "providersList", "Lcom/ironsource/rm;", ug.p, "userId", "Lcom/ironsource/qk;", "publisherDataHolder", "Lcom/ironsource/mediationsdk/IronSourceSegment;", "segment", "<init>", "(Ljava/util/List;Lcom/ironsource/rm;Ljava/lang/String;Lcom/ironsource/qk;Lcom/ironsource/mediationsdk/IronSourceSegment;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class an extends n7<en, AdapterAdListener> implements r2 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public an(List<? extends NetworkSettings> list, rm configs, String str, qk publisherDataHolder, IronSourceSegment ironSourceSegment) {
        super(new bn(str, list, configs), publisherDataHolder, ironSourceSegment);
        Intrinsics.checkNotNullParameter(configs, "configs");
        Intrinsics.checkNotNullParameter(publisherDataHolder, "publisherDataHolder");
    }

    @Override // com.json.n7
    protected void G() {
    }

    @Override // com.json.n7
    protected boolean H() {
        return false;
    }

    public final void M() {
        fv fvVar;
        int iIntValue;
        zl zlVar;
        IronLog.INTERNAL.verbose();
        try {
            en enVar = (en) this.f4075a.d();
            if (enVar != null) {
                Integer numR = enVar.r();
                if (numR == null) {
                    iIntValue = this.C.a(this.o.getAdUnit());
                } else {
                    Intrinsics.checkNotNullExpressionValue(numR, "it.sessionDepth ?: sessi…epth(mManagerData.adUnit)");
                    iIntValue = numR.intValue();
                }
                e2 e2Var = this.s;
                if (e2Var != null && (zlVar = e2Var.g) != null) {
                    zlVar.a(iIntValue);
                }
                enVar.P();
                this.f4075a.a(null);
                this.f4075a.b(null);
            }
            this.i = null;
            a(n7.f.NONE);
        } catch (Throwable th) {
            o9.d().a(th);
            String str = "destroyNativeAd - exception = " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(b(str));
            e2 e2Var2 = this.s;
            if (e2Var2 == null || (fvVar = e2Var2.k) == null) {
                return;
            }
            fvVar.g(str);
        }
    }

    @Override // com.json.n7
    public /* bridge */ /* synthetic */ q7 a(NetworkSettings networkSettings, BaseAdAdapter baseAdAdapter, int i, String str, m5 m5Var) {
        return b(networkSettings, (BaseAdAdapter<?, AdapterAdListener>) baseAdAdapter, i, str, m5Var);
    }

    @Override // com.json.n7, com.json.d2
    public Map<String, Object> a(b2 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Map<String, Object> data = super.a(event);
        Placement placement = this.i;
        if (placement != null) {
            Intrinsics.checkNotNullExpressionValue(data, "data");
            data.put("placement", placement.getPlacementName());
        }
        UUID uuid = this.w;
        if (uuid != null) {
            Intrinsics.checkNotNullExpressionValue(data, "data");
            data.put("objectId", uuid);
        }
        Intrinsics.checkNotNullExpressionValue(data, "data");
        return data;
    }

    public final void a(InternalNativeAdListener nativeAdListener) {
        Intrinsics.checkNotNullParameter(nativeAdListener, "nativeAdListener");
        a(new zm(nativeAdListener));
    }

    @Override // com.json.n7
    protected void a(IronSourceError error) {
        this.t.a(error);
    }

    public final void a(Placement placement) {
        String str;
        int iB;
        IronLog.INTERNAL.verbose("placement = " + placement);
        if (placement == null || TextUtils.isEmpty(placement.getPlacementName())) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            str = String.format("can't load native ad - %s", Arrays.copyOf(new Object[]{placement == null ? "placement is null" : "placement name is empty"}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            iB = a2.b(this.o.getAdUnit());
        } else if (this.E.b(ContextProvider.getInstance().getApplicationContext(), placement, this.o.getAdUnit())) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            str = String.format("placement %s is capped", Arrays.copyOf(new Object[]{placement.getPlacementName()}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            iB = a2.f(this.o.getAdUnit());
        } else {
            str = null;
            iB = 510;
        }
        if (TextUtils.isEmpty(str)) {
            this.i = placement;
            A();
        } else {
            IronLog.API.error(b(str));
            a(iB, str, false);
        }
    }

    @Override // com.json.n7
    protected void a(q7<?> smash, AdInfo adInfo) {
        if (smash instanceof en) {
            en enVar = (en) smash;
            this.t.a(enVar.getAdapterNativeAdData(), enVar.getNativeAdViewBinder(), adInfo);
        }
    }

    protected en b(NetworkSettings providerSettings, BaseAdAdapter<?, AdapterAdListener> adapter, int sessionDepth, String currentAuctionId, m5 item) {
        Intrinsics.checkNotNullParameter(providerSettings, "providerSettings");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(currentAuctionId, "currentAuctionId");
        Intrinsics.checkNotNullParameter(item, "item");
        return new en(this, new m1(IronSource.AD_UNIT.NATIVE_AD, this.o.getUserId(), sessionDepth, this.g, currentAuctionId, this.e, this.f, providerSettings, this.o.getSmashLoadTimeout()), adapter, this.i, item, this);
    }

    @Override // com.json.n7
    protected JSONObject b(NetworkSettings providerSettings) {
        Intrinsics.checkNotNullParameter(providerSettings, "providerSettings");
        JSONObject nativeAdSettings = providerSettings.getNativeAdSettings();
        Intrinsics.checkNotNullExpressionValue(nativeAdSettings, "providerSettings.nativeAdSettings");
        return nativeAdSettings;
    }

    @Override // com.json.n7
    protected l2 g() {
        return new jb();
    }

    @Override // com.json.n7
    protected String l() {
        return "NA";
    }

    @Override // com.json.n7
    protected String o() {
        return IronSourceConstants.OPW_NT_MANAGER_NAME;
    }

    @Override // com.json.n7
    protected boolean v() {
        return false;
    }
}
