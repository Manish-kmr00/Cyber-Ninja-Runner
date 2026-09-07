package com.json;

import android.text.TextUtils;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.json.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0010\u0010\u0012\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001e\u0010\u0012\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/ironsource/c0;", "Lcom/ironsource/d2;", "Lcom/ironsource/b2;", "event", "", "", "", "a", "Lcom/ironsource/w2;", "Lcom/ironsource/w2;", "adTools", "Lcom/ironsource/b0;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/b0;", "instanceData", "Lcom/ironsource/mediationsdk/adunit/adapter/internal/BaseAdAdapter;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/mediationsdk/adunit/adapter/internal/BaseAdAdapter;", "adapter", "<init>", "(Lcom/ironsource/w2;Lcom/ironsource/b0;Lcom/ironsource/mediationsdk/adunit/adapter/internal/BaseAdAdapter;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class c0 implements d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final w2 adTools;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final b0 instanceData;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final BaseAdAdapter<?, ?> adapter;

    public c0(w2 adTools, b0 instanceData, BaseAdAdapter<?, ?> baseAdAdapter) {
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(instanceData, "instanceData");
        this.adTools = adTools;
        this.instanceData = instanceData;
        this.adapter = baseAdAdapter;
    }

    @Override // com.json.d2
    public Map<String, Object> a(b2 event) {
        String adapterVersion;
        Intrinsics.checkNotNullParameter(event, "event");
        HashMap map = new HashMap();
        try {
            BaseAdAdapter<?, ?> baseAdAdapter = this.adapter;
            String networkSDKVersion = "";
            if (baseAdAdapter != null) {
                AdapterBaseInterface networkAdapter = baseAdAdapter.getNetworkAdapter();
                Intrinsics.checkNotNull(networkAdapter);
                adapterVersion = networkAdapter.getAdapterVersion();
            } else {
                adapterVersion = "";
            }
            Intrinsics.checkNotNullExpressionValue(adapterVersion, "if (adapter != null) ada…!!.adapterVersion else \"\"");
            map.put(IronSourceConstants.EVENTS_PROVIDER_ADAPTER_VERSION, adapterVersion);
            BaseAdAdapter<?, ?> baseAdAdapter2 = this.adapter;
            if (baseAdAdapter2 != null) {
                AdapterBaseInterface networkAdapter2 = baseAdAdapter2.getNetworkAdapter();
                Intrinsics.checkNotNull(networkAdapter2);
                networkSDKVersion = networkAdapter2.getNetworkSDKVersion();
            }
            Intrinsics.checkNotNull(networkSDKVersion);
            map.put(IronSourceConstants.EVENTS_PROVIDER_SDK_VERSION, networkSDKVersion);
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(o1.a(this.adTools, "could not get adapter version for event data " + this.instanceData.getCom.unity3d.ads.metadata.InAppPurchaseMetaData.KEY_SIGNATURE java.lang.String(), (String) null, 2, (Object) null));
        }
        String strI = this.instanceData.j().i();
        Intrinsics.checkNotNullExpressionValue(strI, "instanceData.adapterConfig.subProviderId");
        map.put("spId", strI);
        String strA = this.instanceData.j().a();
        Intrinsics.checkNotNullExpressionValue(strA, "instanceData.adapterConfig.adSourceNameForEvents");
        map.put(IronSourceConstants.EVENTS_PROVIDER, strA);
        map.put("instanceType", Integer.valueOf(this.instanceData.getInstanceType()));
        String serverData = this.instanceData.n().k();
        w2 w2Var = this.adTools;
        Intrinsics.checkNotNullExpressionValue(serverData, "serverData");
        String strE = w2Var.e(serverData);
        if (!TextUtils.isEmpty(strE)) {
            map.put("dynamicDemandSource", strE);
        }
        map.put("sessionDepth", Integer.valueOf(this.instanceData.v()));
        if (!TextUtils.isEmpty(this.instanceData.u().getCustomNetwork())) {
            String customNetwork = this.instanceData.u().getCustomNetwork();
            Intrinsics.checkNotNullExpressionValue(customNetwork, "instanceData.providerSettings.customNetwork");
            map.put(IronSourceConstants.EVENTS_CUSTOM_NETWORK_FIELD, customNetwork);
        }
        return map;
    }
}
