package com.bytedance.adsdk.ugeno.core.pA;

import android.util.Log;
import com.bytedance.adsdk.ugeno.Og.KZx;
import com.bytedance.adsdk.ugeno.ZZv.Og;
import com.bytedance.adsdk.ugeno.core.SGo;
import com.bytedance.adsdk.ugeno.core.WV;
import com.bytedance.sdk.component.uchain.action.EventChainAction;
import com.bytedance.sdk.component.uchain.listener.ICustomRouter;
import com.bytedance.sdk.component.uchain.listener.IEventChainLifeCycleListener;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class pA implements WV {
    private volatile C0179pA ML;
    private String Og;
    private JSONObject ZZv;
    private WV pA;
    private boolean KZx = true;
    private boolean JG = false;

    public pA(WV wv) {
        this.pA = wv;
    }

    public void pA(JSONObject jSONObject) {
        this.ZZv = jSONObject;
    }

    public void pA(String str) {
        this.Og = str;
    }

    public void pA(boolean z) {
        this.KZx = z;
    }

    public boolean pA() {
        String str;
        return this.KZx && (str = this.Og) != null && "3".compareTo(str) <= 0 && this.ZZv != null;
    }

    public void Og(boolean z) {
        this.JG = z;
    }

    @Override // com.bytedance.adsdk.ugeno.core.WV
    public void pA(SGo sGo, WV.Og og, WV.pA pAVar) {
        if (pA()) {
            KZx(sGo, og, pAVar);
        } else {
            Og(sGo, og, pAVar);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.core.WV
    public void pA(KZx kZx, String str, Og.pA pAVar) {
        WV wv = this.pA;
        if (wv == null) {
            return;
        }
        wv.pA(kZx, str, pAVar);
        Log.d("UGenEvent", "onUGenEvent: ");
    }

    private void Og(SGo sGo, WV.Og og, WV.pA pAVar) {
        WV wv = this.pA;
        if (wv == null) {
            return;
        }
        wv.pA(sGo, og, pAVar);
    }

    private void KZx(SGo sGo, WV.Og og, WV.pA pAVar) {
        if (this.ML == null) {
            this.ML = Og();
        }
        this.ML.pA(sGo);
        this.ML.pA(og);
        this.ML.pA(pAVar);
        JSONObject jSONObjectKZx = sGo.KZx();
        if (jSONObjectKZx == null) {
            return;
        }
        new EventChainAction.Builder(jSONObjectKZx.optString("type")).setChainData(this.ZZv).setEventChainLifeCycleListener(new IEventChainLifeCycleListener() { // from class: com.bytedance.adsdk.ugeno.core.pA.pA.1
        }).build().run();
    }

    private C0179pA Og() {
        if (this.ML != null) {
            return this.ML;
        }
        synchronized (C0179pA.class) {
            if (this.ML != null) {
                return this.ML;
            }
            this.ML = new C0179pA();
            return this.ML;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.core.pA.pA$pA, reason: collision with other inner class name */
    class C0179pA implements ICustomRouter {
        private SGo KZx;
        private WV.Og ZZv;
        WV.pA pA;

        C0179pA() {
        }

        public void pA(SGo sGo) {
            this.KZx = sGo;
        }

        public void pA(WV.Og og) {
            this.ZZv = og;
        }

        public void pA(WV.pA pAVar) {
            this.pA = pAVar;
        }
    }
}
