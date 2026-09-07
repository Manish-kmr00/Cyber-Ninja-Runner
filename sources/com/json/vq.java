package com.json;

import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.IronSourceSegment;
import com.json.mediationsdk.LoadWhileShowSupportState;
import com.json.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.json.mediationsdk.adunit.adapter.internal.AdapterSettingsInterface;
import com.json.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener;
import com.json.mediationsdk.adunit.adapter.utility.AdInfo;
import com.json.mediationsdk.logger.IronSourceError;
import com.json.mediationsdk.model.NetworkSettings;
import com.json.mediationsdk.utils.IronSourceConstants;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class vq extends o7<wq> {
    public vq(List<NetworkSettings> list, yq yqVar, String str, boolean z, qk qkVar, IronSourceSegment ironSourceSegment) {
        super(new tq(str, list, yqVar, z), qkVar, ironSourceSegment);
    }

    @Override // com.json.n7
    protected LoadWhileShowSupportState a(NetworkSettings networkSettings, AdapterBaseInterface adapterBaseInterface) {
        return ((AdapterSettingsInterface) adapterBaseInterface).getLoadWhileShowSupportedState(networkSettings);
    }

    @Override // com.json.n7
    protected /* bridge */ /* synthetic */ q7 a(NetworkSettings networkSettings, BaseAdAdapter baseAdAdapter, int i, String str, m5 m5Var) {
        return b(networkSettings, (BaseAdAdapter<?, AdapterAdRewardListener>) baseAdAdapter, i, str, m5Var);
    }

    @Override // com.json.n7
    protected void a(IronSourceError ironSourceError) {
        o2.a aVarA = this.o.getLoadingData().a();
        if (aVarA == o2.a.AUTOMATIC_LOAD_AFTER_CLOSE || aVarA == o2.a.AUTOMATIC_LOAD_WHILE_SHOW) {
            this.t.a(false, (AdInfo) null);
        } else {
            super.a(ironSourceError);
        }
    }

    protected wq b(NetworkSettings networkSettings, BaseAdAdapter<?, AdapterAdRewardListener> baseAdAdapter, int i, String str, m5 m5Var) {
        return new wq(this, new m1(IronSource.AD_UNIT.REWARDED_VIDEO, this.o.getUserId(), i, this.g, str, this.e, this.f, networkSettings, this.o.getSmashLoadTimeout()), baseAdAdapter, m5Var, this);
    }

    @Override // com.json.n7
    protected JSONObject b(NetworkSettings networkSettings) {
        return networkSettings.getRewardedVideoSettings();
    }

    @Override // com.json.n7
    protected l2 g() {
        return new br();
    }

    @Override // com.json.n7
    protected String l() {
        return IronSourceConstants.REWARDED_VIDEO_EVENT_TYPE;
    }

    @Override // com.json.n7
    protected String o() {
        return IronSourceConstants.OPW_RV_MANAGER_NAME;
    }

    @Override // com.json.n7
    protected boolean q() {
        return this.o.getLoadingData().a() == o2.a.MANUAL;
    }

    @Override // com.json.n7
    protected boolean t() {
        return this.o.getLoadingData().a() == o2.a.AUTOMATIC_LOAD_WHILE_SHOW;
    }
}
