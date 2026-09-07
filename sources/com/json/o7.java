package com.json;

import com.json.mediationsdk.IronSourceSegment;
import com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.model.Placement;
import com.json.p7;

/* JADX INFO: loaded from: classes10.dex */
public abstract class o7<Smash extends p7<?>> extends l7<Smash, AdapterAdRewardListener> implements v2 {
    public o7(u0 u0Var, qk qkVar, IronSourceSegment ironSourceSegment) {
        super(u0Var, qkVar, ironSourceSegment);
    }

    @Override // com.json.v2
    public void a(p7<?> p7Var, Placement placement) {
        IronLog.INTERNAL.verbose(b(p7Var.k()));
        this.t.b(placement, p7Var.f());
    }
}
