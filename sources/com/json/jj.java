package com.json;

import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener;
import com.json.mediationsdk.adunit.adapter.listener.InterstitialAdListener;

/* JADX INFO: loaded from: classes10.dex */
public class jj extends m7<j2> implements InterstitialAdListener {
    public jj(tp tpVar, m1 m1Var, BaseAdAdapter<?, AdapterAdInteractionListener> baseAdAdapter, m5 m5Var, j2 j2Var) {
        super(tpVar, m1Var, baseAdAdapter, new c3(m1Var.g(), m1Var.g().getInterstitialSettings(), IronSource.AD_UNIT.INTERSTITIAL), m5Var, j2Var);
    }
}
