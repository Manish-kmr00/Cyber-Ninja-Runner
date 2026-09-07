package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.bytedance.sdk.component.utils.TV;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.component.reward.Og.SD;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.TX;
import com.bytedance.sdk.openadsdk.utils.Wx;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public abstract class pA extends JG implements TV.pA, com.bytedance.sdk.openadsdk.component.reward.pA.ML.pA, com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og {
    private boolean DX;
    private int JG;
    protected com.bytedance.sdk.openadsdk.component.reward.pA.pA KZx;
    private final AtomicBoolean ML;
    protected com.bytedance.sdk.openadsdk.component.reward.Og.Og Og;
    private Bundle SD;
    private boolean Sn;
    private int Wx;
    protected int ZZv;
    protected final TV pA;

    protected abstract void KZx();

    protected abstract void Og();

    protected abstract void SD();

    @Override // com.bytedance.sdk.openadsdk.activity.JG, com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void Sn() {
    }

    public void WV() {
    }

    public void pA(int i) {
    }

    public abstract void pA(Bundle bundle);

    public void pA(boolean z) {
    }

    public pA(Og og, yFO yfo, int i) {
        super(og, yfo, i);
        this.pA = new TV(Looper.getMainLooper(), this);
        this.ML = new AtomicBoolean(false);
        this.JG = 1;
        this.Wx = 0;
        this.Sn = false;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    public final void pA(Activity activity, Bundle bundle) {
        this.SD = bundle;
        super.pA(activity, bundle);
        pA(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    public final View pA() {
        return this.KZx.CIG;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    public void pA(Activity activity, Og.ML ml) {
        super.pA(activity, ml);
        this.JG = this.omh.rtW();
        pA(this.omh, this.SD);
        if (this.KZx.Itl && this.Bzk > 0) {
            this.KZx.agB = ml.ZZv;
        }
        try {
            BF();
            IG();
        } catch (Throwable th) {
            WV.pA("TTAD.AdScene", "onCreate: ", th);
            com.bytedance.sdk.openadsdk.Sn.KZx.Og();
            du();
        }
    }

    private void pA(yFO yfo, Bundle bundle) {
        Activity activityTV = TV();
        com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar = new com.bytedance.sdk.openadsdk.component.reward.pA.pA(activityTV, this.pA, yfo, this, 1);
        this.KZx = pAVar;
        pAVar.Itl = WQf().pA();
        this.KZx.tM = WQf().omh();
        this.KZx.RS = this;
        this.KZx.lT = WQf().XT();
        Intent intent = activityTV.getIntent();
        com.bytedance.sdk.openadsdk.component.reward.pA.Og.pA(this.KZx, intent, bundle);
        if (intent != null) {
            com.bytedance.sdk.openadsdk.component.reward.pA.Og.pA(intent, this.KZx);
            yfo.pA(intent.getLongExtra("start_show_time", 0L));
        }
        if (bundle != null && this.KZx.cFQ) {
            Og();
        }
        com.bytedance.sdk.openadsdk.component.reward.Og.Og ogPA = SD.pA(this.KZx);
        this.Og = ogPA;
        this.KZx.nCO = ogPA;
        this.KZx.gbA.pA(this);
        if (this.KZx.Itl) {
            this.KZx.BF.pA(new com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA.InterfaceC0240pA() { // from class: com.bytedance.sdk.openadsdk.activity.pA.1
                @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA.InterfaceC0240pA
                public void pA(int i) {
                    Og ogWQf = pA.this.WQf();
                    if (ogWQf == null) {
                        return;
                    }
                    ogWQf.pA(i);
                }
            });
            WQf().omh().setShowSound(yFO.ML(yfo));
        }
        Wx.pA(this.KZx);
        new StringBuilder("init: mAdType = ").append(this.Og);
    }

    private void BF() {
        this.KZx.CIG.pA(this.Og);
        this.Og.pA(this, this.pA);
        this.Og.BSW();
    }

    private void IG() {
        this.Og.pA(this.WV);
        this.ZZv = (int) this.KZx.BF.roi();
        if (this.KZx.Itl) {
            pA(this.KZx.roi.ML());
            pA(this.KZx.roi.ZZv());
        }
        KZx();
        xy();
        if (this.KZx.Og.dGZ() == null || this.KZx.Og.dGZ().pA() == null) {
            return;
        }
        this.KZx.Og.dGZ().pA().pA(0L);
    }

    private void pA(com.bytedance.sdk.openadsdk.core.Og.Og og) {
        if (og != null) {
            HashMap map = new HashMap();
            map.put("ad_show_order", Integer.valueOf(this.Bzk + 1));
            og.pA(map);
        }
    }

    private boolean lT() {
        if (this.KZx.SGo.get() && this.KZx.SD) {
            return false;
        }
        if (this.omh.pA()) {
            return this.KZx.SGo.get();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    public void pA(Activity activity) {
        super.pA(activity);
        com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar = this.KZx;
        if (pAVar == null) {
            return;
        }
        pAVar.eG.pA();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    public final void Og(Activity activity) {
        com.bytedance.sdk.openadsdk.component.reward.Og.Og og;
        super.Og(activity);
        if (this.KZx == null || (og = this.Og) == null) {
            return;
        }
        og.aBv();
        this.KZx.fN = true;
        this.KZx.eG.Og(this.pA);
        if (lT()) {
            this.KZx.qmB.pA(this.KZx.Og.uQ());
        }
        this.KZx.Vgu.DX();
        this.KZx.rB.TX();
        this.KZx.TV.Wx();
        if (this.Og.Og()) {
            this.KZx.BF.pA(this.Og);
            this.KZx.BF.pA(false, this, this.Wx != 0);
        }
        this.Wx++;
        rB();
        if (this.KZx.du != null) {
            this.KZx.du.SD();
        }
        this.KZx.eG.pA(this.pA);
        this.Og.yFO();
    }

    private void rB() {
        if (this.omh.pA() && !this.Sn) {
            this.Sn = true;
            pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.pA.2
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.component.reward.pA.JG jg = pA.this.KZx.Mc;
                    float[] fArrPA = pA.this.KZx.eG.pA(pA.this.JG);
                    pA pAVar = pA.this;
                    jg.pA(fArrPA, pAVar, pAVar.Og);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    public void KZx(Activity activity) {
        super.KZx(activity);
        com.bytedance.sdk.openadsdk.component.reward.Og.Og og = this.Og;
        if (og == null) {
            return;
        }
        og.Sd();
    }

    private void xy() {
        if (this.omh.pA()) {
            return;
        }
        if (WQf.XT(this.KZx.Og)) {
            pA(false, com.bytedance.sdk.openadsdk.ZZv.Og.C0216Og.KZx);
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.Og.Og og = this.Og;
        if (og != null) {
            og.pA(this.KZx.Vgu.JG());
            this.Og.du();
        }
    }

    public final void pA(boolean z, int i) {
        pA(z, false, i);
    }

    public final void pA(boolean z, boolean z2, int i) {
        this.KZx.gbA.pA(z, z2, false, this.KZx.nCO, i);
    }

    @Override // com.bytedance.sdk.component.utils.TV.pA
    public final void pA(Message message) {
        com.bytedance.sdk.openadsdk.component.reward.Og.Og og = this.Og;
        if (og == null) {
            return;
        }
        og.pA(message);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public final void ZZv() {
        Mc();
        this.KZx.Og.Ky();
        this.KZx.Og.pA(true);
        if (yFO.ML(this.KZx.Og)) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.Og(this.KZx.Og, this.KZx.ML, this.KZx.Og.Io());
        }
    }

    public void pA(String str, JSONObject jSONObject) {
        if (str == null || !"skipToNextAd".equals(str) || WQf() == null) {
            return;
        }
        WQf().Og(this, Og(7));
    }

    protected final void ML() {
        Message message = new Message();
        message.what = 400;
        if (this.omh.kK()) {
            pA(10000);
        }
        this.pA.sendMessageDelayed(message, 2000L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public final void JG() {
        if (this.ML.compareAndSet(false, true)) {
            TX.pA("BVA", "invoke callback onShow, ".concat(String.valueOf(this)));
            SD();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public final void omh() {
        com.bytedance.sdk.openadsdk.component.reward.Og.Og og = this.Og;
        if (og == null) {
            return;
        }
        og.Wx();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    public final void ZZv(Activity activity) {
        super.ZZv(activity);
        com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar = this.KZx;
        if (pAVar == null) {
            return;
        }
        pAVar.rB.rB();
        com.bytedance.sdk.openadsdk.utils.KZx.pA(activity, this.KZx.Og);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    public final void ML(Activity activity) {
        super.ML(activity);
        com.bytedance.sdk.openadsdk.component.reward.Og.Og og = this.Og;
        if (og == null) {
            return;
        }
        og.vZF();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public final void Bzk() {
        this.KZx.BF.Mc();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public final View SGo() {
        return this.KZx.BF.IG();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public final void BSW() {
        if (!this.KZx.Sn.getAndSet(true) || WQf.KZx(this.KZx.Og)) {
            this.KZx.roi.pA();
        }
    }

    protected final void Wx() {
        this.pA.removeMessages(400);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    public void DX() {
        super.DX();
        com.bytedance.sdk.openadsdk.component.reward.Og.Og og = this.Og;
        if (og == null) {
            return;
        }
        og.TX();
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pA.ML.pA
    public void pA(boolean z, boolean z2, boolean z3, com.bytedance.sdk.openadsdk.component.reward.Og.Og og, int i) {
        pA(z, z2, z3, i);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pA.ML.pA
    public void oX() {
        KZx kZxML;
        Og ogWQf = WQf();
        if (ogWQf == null || (kZxML = ogWQf.ML()) == null) {
            return;
        }
        kZxML.ML();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    public void aBv() {
        super.aBv();
        com.bytedance.sdk.openadsdk.component.reward.Og.Og og = this.Og;
        if (og != null) {
            og.BF();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    public void pA(JG jg, JG jg2, Og.ML ml) {
        super.pA(jg, jg2, ml);
        if (jg == this && (jg2 instanceof KZx)) {
            if (ml.Og == 3) {
                this.KZx.BF.pA(!this.KZx.BF.eG() ? 1 : 0, 2);
            } else if (ml.Og == 6) {
                this.KZx.BF.pA(!this.KZx.BF.eG() ? 1 : 0, !this.KZx.BF.eG() ? 1 : 0);
            } else if (ml.Og == 5 && !yFO.ML(this.KZx.Og) && ml.ML) {
                this.KZx.BF.pA(EventConstants.SKIP, true);
            }
            this.KZx.qmB.pA(false);
            this.KZx.qmB.ZZv(false);
        }
        if (jg2.Bzk != 0 || this.Bzk == 0) {
            return;
        }
        this.omh.Bzk("0");
        Map<String, Object> mapTZW = this.omh.tZW();
        if (mapTZW != null) {
            mapTZW.put("price", "0");
        }
    }

    public void pA(float f) {
        Og ogWQf = WQf();
        if (ogWQf == null) {
            return;
        }
        ogWQf.pA(f);
        if (this.DX || f < this.omh.vON() / 100.0f) {
            return;
        }
        this.DX = true;
        JG jgBzk = ogWQf.Bzk();
        if (jgBzk instanceof pA) {
            ((pA) jgBzk).XT();
        }
    }

    public void XT() {
        com.bytedance.sdk.openadsdk.core.Wx.pA.Og ogPA = yFO.pA(CacheDirFactory.getICacheDir(this.omh.FK()).pA(), this.omh);
        ogPA.pA("material_meta", this.omh);
        ogPA.pA("ad_slot", this.omh.rB());
        com.bytedance.sdk.openadsdk.core.Wx.ML.pA.pA(ogPA, new com.bykv.vk.openvk.pA.pA.pA.ML.Og() { // from class: com.bytedance.sdk.openadsdk.activity.pA.3
            @Override // com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA
            public void pA(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx, int i) {
            }

            @Override // com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA
            public void pA(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx, int i, String str) {
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    public boolean yFO() {
        com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar = this.KZx;
        return pAVar != null && pAVar.BF.WQf();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    protected String vZF() {
        return this.KZx.JBA;
    }

    protected Og.ML Og(int i) {
        Og.ML ml = new Og.ML(i, this.KZx);
        ml.ZZv = this.KZx.agB;
        return ml;
    }

    public void Sd() {
        WQf().pA(this, Og(com.bytedance.sdk.openadsdk.ZZv.Og.C0216Og.Og));
    }

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    public void Og(boolean z) {
        com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar = this.KZx;
        if (pAVar != null && pAVar.roi != null) {
            this.KZx.roi.Og(z);
            this.KZx.roi.KZx(z);
        }
        com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar2 = this.KZx;
        if (pAVar2 == null || !(pAVar2.nCO instanceof com.bytedance.sdk.openadsdk.component.reward.Og.JG)) {
            return;
        }
        ((com.bytedance.sdk.openadsdk.component.reward.Og.JG) this.KZx.nCO).Og(z);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    public com.bytedance.sdk.openadsdk.component.reward.pA.pA TX() {
        return this.KZx;
    }
}
