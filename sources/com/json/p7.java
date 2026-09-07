package com.json;

import com.json.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.p;
import com.json.mediationsdk.utils.IronSourceUtils;
import com.json.v2;
import java.util.HashMap;

/* JADX INFO: loaded from: classes9.dex */
public class p7<Listener extends v2> extends m7<Listener> implements AdapterAdRewardListener {
    private ib r;

    class a extends hr {
        a() {
        }

        @Override // com.json.hr
        public void a() {
            p7.this.U();
        }
    }

    public p7(tp tpVar, m1 m1Var, BaseAdAdapter<?, AdapterAdRewardListener> baseAdAdapter, c3 c3Var, m5 m5Var, Listener listener) {
        super(tpVar, m1Var, baseAdAdapter, c3Var, m5Var, listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (this.g == null) {
            IronLog.INTERNAL.verbose(a("placement is null "));
            e2 e2Var = this.d;
            if (e2Var != null) {
                e2Var.k.g("mCurrentPlacement is null state = " + this.e);
                return;
            }
            return;
        }
        IronLog.INTERNAL.verbose(a("placement name = " + j()));
        if (this.d != null) {
            HashMap map = new HashMap();
            if (p.m().s() != null) {
                for (String str : p.m().s().keySet()) {
                    map.put("custom_" + str, p.m().s().get(str));
                }
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.d.j.a(j(), this.g.getCom.ironsource.mediationsdk.utils.IronSourceConstants.EVENTS_REWARD_NAME java.lang.String(), this.g.getRewardAmount(), jCurrentTimeMillis, IronSourceUtils.getTransId(jCurrentTimeMillis, c()), ib.a(this.r), map, p.m().l());
        }
        ((v2) this.b).a((p7<?>) this, this.g);
    }

    @Override // com.json.m7, com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdClosed() {
        this.r = new ib();
        super.onAdClosed();
    }

    @Override // com.json.q7, com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdOpened() {
        this.r = null;
        super.onAdOpened();
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener
    public void onAdRewarded() {
        if (u().c()) {
            u().a(new a());
        } else {
            U();
        }
    }
}
