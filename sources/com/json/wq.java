package com.json;

import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener;
import com.json.mediationsdk.adunit.adapter.listener.RewardedVideoAdListener;

/* JADX INFO: loaded from: classes9.dex */
public class wq extends p7<v2> implements RewardedVideoAdListener {
    public wq(tp tpVar, m1 m1Var, BaseAdAdapter<?, AdapterAdRewardListener> baseAdAdapter, m5 m5Var, v2 v2Var) {
        super(tpVar, m1Var, baseAdAdapter, new c3(m1Var.g(), m1Var.g().getRewardedVideoSettings(), IronSource.AD_UNIT.REWARDED_VIDEO), m5Var, v2Var);
    }
}
