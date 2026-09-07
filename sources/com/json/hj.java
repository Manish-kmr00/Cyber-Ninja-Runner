package com.json;

import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.IronSourceSegment;
import com.json.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener;
import com.json.mediationsdk.model.NetworkSettings;
import com.json.mediationsdk.utils.IronSourceConstants;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class hj extends l7<jj, AdapterAdInteractionListener> {
    hj(xf xfVar, wf wfVar, List<NetworkSettings> list, mj mjVar, String str, qk qkVar, IronSourceSegment ironSourceSegment) {
        super(xfVar, wfVar, new ij(str, list, mjVar), qkVar, ironSourceSegment);
    }

    public hj(List<NetworkSettings> list, mj mjVar, String str, qk qkVar, IronSourceSegment ironSourceSegment) {
        super(new ij(str, list, mjVar), qkVar, ironSourceSegment);
    }

    @Override // com.json.n7
    protected /* bridge */ /* synthetic */ q7 a(NetworkSettings networkSettings, BaseAdAdapter baseAdAdapter, int i, String str, m5 m5Var) {
        return b(networkSettings, (BaseAdAdapter<?, AdapterAdInteractionListener>) baseAdAdapter, i, str, m5Var);
    }

    protected jj b(NetworkSettings networkSettings, BaseAdAdapter<?, AdapterAdInteractionListener> baseAdAdapter, int i, String str, m5 m5Var) {
        return new jj(this, new m1(IronSource.AD_UNIT.INTERSTITIAL, this.o.getUserId(), i, this.g, str, this.e, this.f, networkSettings, this.o.getSmashLoadTimeout()), baseAdAdapter, m5Var, this);
    }

    @Override // com.json.n7
    protected JSONObject b(NetworkSettings networkSettings) {
        return networkSettings.getInterstitialSettings();
    }

    @Override // com.json.n7
    protected l2 g() {
        return new qj();
    }

    @Override // com.json.n7
    protected String l() {
        return IronSourceConstants.INTERSTITIAL_EVENT_TYPE;
    }

    @Override // com.json.n7
    protected String o() {
        return IronSourceConstants.OPW_IS_MANAGER_NAME;
    }
}
