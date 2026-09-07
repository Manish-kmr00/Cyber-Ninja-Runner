package com.bytedance.sdk.openadsdk.component.reward.Og;

import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.core.model.vZF;
import com.bytedance.sdk.openadsdk.core.model.yFO;

/* JADX INFO: loaded from: classes13.dex */
public class SD {
    public static Og pA(com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar) {
        yFO yfo = pAVar.Og;
        if ((yfo instanceof vZF) && ((vZF) yfo).PF()) {
            return new JG(pAVar);
        }
        if (WQf.XT(yfo)) {
            return new SGo(pAVar);
        }
        if (omh.pA(yfo) && !KZx.pA(yfo)) {
            return new omh(pAVar);
        }
        if (Bzk.pA(yfo)) {
            return new Bzk(pAVar);
        }
        if (SGo.pA(yfo)) {
            return new SGo(pAVar);
        }
        if (ZZv.pA(yfo)) {
            return new ZZv(pAVar);
        }
        if (KZx.pA(yfo)) {
            return new KZx(pAVar);
        }
        return new ML(pAVar);
    }
}
