package com.bytedance.sdk.openadsdk.component.reward.pA;

import android.app.Activity;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.utils.gbA;
import java.io.File;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class aBv {
    private long BSW;
    private FrameLayout Bzk;
    com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx JG;
    boolean KZx;
    private final Activity SD;
    private final String SGo;
    private String Sn;
    private long WV;
    private boolean XT;
    final boolean ZZv;
    private final pA aBv;
    private boolean oX;
    private final com.bytedance.sdk.openadsdk.core.model.yFO omh;
    private com.bytedance.sdk.openadsdk.ZZv.SD vZF;
    private com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA.InterfaceC0240pA yFO;
    protected boolean pA = false;
    boolean Og = false;
    protected boolean ML = false;
    private int Wx = -1;
    private HashSet<String> DX = new HashSet<>();

    public com.bytedance.sdk.openadsdk.ZZv.SD pA() {
        return this.vZF;
    }

    public aBv(pA pAVar) {
        this.aBv = pAVar;
        this.SD = pAVar.SzT;
        this.omh = pAVar.Og;
        this.ZZv = pAVar.ZZv;
        this.SGo = pAVar.ML;
    }

    public void pA(FrameLayout frameLayout, com.bytedance.sdk.openadsdk.ZZv.SD sd) {
        if (this.oX) {
            return;
        }
        this.oX = true;
        this.Bzk = frameLayout;
        this.vZF = sd;
        if (com.bytedance.sdk.openadsdk.core.model.yFO.ML(this.omh)) {
            this.JG = new com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA(this.SD, this.Bzk, this.omh, sd);
            ZZv(this.XT);
            com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA.InterfaceC0240pA interfaceC0240pA = this.yFO;
            if (interfaceC0240pA != null) {
                ((com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA) this.JG).pA(interfaceC0240pA);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.KZx kZx = new com.bytedance.sdk.openadsdk.component.reward.KZx(this.omh, sd);
        this.JG = kZx;
        com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA.InterfaceC0240pA interfaceC0240pA2 = this.yFO;
        if (interfaceC0240pA2 != null) {
            kZx.pA(interfaceC0240pA2);
        }
    }

    public void pA(com.bytedance.sdk.openadsdk.ZZv.SD sd) {
        this.vZF = sd;
    }

    public boolean Og() {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.JG;
        return (kZx == null || kZx.WV() == null || !this.JG.WV().JG()) ? false : true;
    }

    public com.bykv.vk.openvk.pA.pA.pA.Og.pA KZx() {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.JG;
        if (kZx == null) {
            return null;
        }
        if (kZx instanceof com.bytedance.sdk.openadsdk.component.reward.KZx) {
            return ((com.bytedance.sdk.openadsdk.component.reward.KZx) kZx).XT();
        }
        return kZx.Wx();
    }

    public boolean ZZv() {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.JG;
        return (kZx == null || kZx.WV() == null || !this.JG.WV().SD()) ? false : true;
    }

    public boolean ML() {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.JG;
        return kZx != null && kZx.oX();
    }

    public void pA(long j, long j2) {
        this.WV = j;
        Og(j, j2);
    }

    private void Og(long j, long j2) {
        int iAbs = (int) Math.abs(((long) this.Wx) - j);
        int i = this.Wx;
        if (i < 0 || iAbs > 500 || i > j2 || iAbs >= 500 || this.DX.contains(this.Sn)) {
            return;
        }
        if (this.Wx > j) {
            com.bytedance.sdk.openadsdk.core.Sn.KZx().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.aBv.1
                @Override // java.lang.Runnable
                public void run() {
                    aBv.this.du();
                    aBv.this.aBv.du.pA(aBv.this.Wx, aBv.this.Sn);
                }
            }, iAbs);
        } else {
            du();
            this.aBv.du.pA(this.Wx, this.Sn);
        }
        this.DX.add(this.Sn);
    }

    public void pA(int i, String str) {
        this.Wx = i;
        this.Sn = str;
    }

    public boolean JG() {
        return this.pA;
    }

    public long SD() {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.JG;
        if (kZx != null) {
            return kZx.ML();
        }
        return this.BSW;
    }

    public long omh() {
        return this.WV;
    }

    public long Bzk() {
        return this.BSW;
    }

    public void pA(long j) {
        this.BSW = j;
    }

    public void pA(boolean z) {
        this.pA = z;
    }

    public void SGo() {
        try {
            if (Og()) {
                this.JG.pA();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.Og("RewardFullVideoPlayerManager onPause throw Exception :" + th.getMessage());
        }
    }

    public void pA(int i, int i2) {
        if (this.JG != null) {
            com.bytedance.sdk.openadsdk.ZZv.ML.Og.DX.pA pAVar = new com.bytedance.sdk.openadsdk.ZZv.ML.Og.DX.pA();
            pAVar.Og(BSW());
            pAVar.KZx(yFO());
            pAVar.pA(SD());
            pAVar.pA(i);
            pAVar.Og(i2);
            com.bytedance.sdk.openadsdk.ZZv.ML.pA.pA.ZZv(this.JG.Wx(), pAVar);
        }
    }

    public long BSW() {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.JG;
        if (kZx != null) {
            return kZx.JG();
        }
        return 0L;
    }

    private void xy() {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.JG;
        if (kZx == null || kZx.WV() == null) {
            return;
        }
        this.BSW = this.JG.ML();
        if (this.JG.WV().KZx() || !this.JG.WV().Og()) {
            this.JG.pA();
            this.JG.KZx();
            this.pA = true;
        }
    }

    public void WV() {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.JG;
        if (kZx == null) {
            return;
        }
        kZx.KZx();
        this.JG = null;
    }

    public void Wx() {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.JG;
        if (kZx != null) {
            kZx.ZZv();
        }
    }

    public void Sn() {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.JG;
        if (kZx != null) {
            kZx.Og();
        }
    }

    public void DX() {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.JG;
        if (kZx != null) {
            kZx.pA();
        }
    }

    public void pA(com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA pAVar) {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.JG;
        if (kZx != null) {
            kZx.pA(pAVar);
        }
    }

    public void Og(boolean z) {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.JG;
        if (kZx != null) {
            kZx.Og(z);
        }
    }

    public long oX() {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.JG;
        if (kZx != null) {
            return kZx.omh();
        }
        return 0L;
    }

    public int aBv() {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.JG;
        if (kZx != null) {
            return kZx.SGo();
        }
        return 0;
    }

    public int XT() {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.JG;
        if (kZx != null) {
            return kZx.SD();
        }
        return 0;
    }

    public long yFO() {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.JG;
        if (kZx != null) {
            return kZx.omh() + this.JG.JG();
        }
        return 0L;
    }

    public void pA(String str, boolean z) {
        if (this.JG != null) {
            long jSD = SD();
            if (this.omh.xkc()) {
                jSD = this.aBv.KZx();
            }
            long j = jSD;
            JSONObject jSONObjectPA = gbA.pA(this.omh, this.JG.JG(), this.JG.WV());
            try {
                jSONObjectPA.put("auto_click", z);
            } catch (Exception unused) {
            }
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(this.omh, this.SGo, str, j, aBv(), jSONObjectPA, this.vZF);
            yFO();
            aBv();
        }
        lT();
    }

    public long vZF() {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.JG;
        if (kZx != null) {
            return kZx.omh();
        }
        return 0L;
    }

    public boolean Sd() {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.JG;
        if (kZx != null) {
            if (kZx.WV() != null) {
                com.bykv.vk.openvk.pA.pA.pA.pA pAVarWV = this.JG.WV();
                if (pAVarWV.SD() || pAVarWV.omh()) {
                    com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx2 = this.JG;
                    if (kZx2 instanceof com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA) {
                        ((com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA) kZx2).xy();
                    }
                    return true;
                }
            } else if (JG()) {
                pA(false);
                com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx3 = this.JG;
                if (kZx3 instanceof com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA) {
                    ((com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA) kZx3).xy();
                }
                return true;
            }
        }
        return false;
    }

    public boolean TX() {
        return this.JG != null;
    }

    public boolean BF() {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.JG;
        return kZx != null && kZx.WV() == null;
    }

    public boolean pA(long j, boolean z, Map<String, Object> map, com.bytedance.sdk.openadsdk.component.reward.Og.Og og) {
        boolean zPA = false;
        if (!TX()) {
            return false;
        }
        if (com.bytedance.sdk.openadsdk.core.model.aBv.ZZv(this.aBv.Og) || com.bytedance.sdk.openadsdk.core.model.aBv.ML(this.aBv.Og)) {
            return true;
        }
        if (!z || !BF()) {
            pA(og);
        }
        try {
            zPA = pA(j, this.aBv.agB);
        } catch (Exception e) {
            Log.e("TTAD.RFVideoPlayerMag", "playVideo: ", e);
        }
        if (zPA && !z) {
            this.aBv.roi.pA(map);
        }
        return zPA;
    }

    public void pA(com.bytedance.sdk.openadsdk.component.reward.Og.Og og) {
        if (this.aBv.SGo.get() || !this.aBv.fN || WQf.KZx(this.aBv.Og)) {
            return;
        }
        if ((!com.bytedance.sdk.openadsdk.core.model.yFO.ML(this.aBv.Og) && com.bytedance.sdk.openadsdk.core.aBv.ZZv().Wx(String.valueOf(this.aBv.JG)) == 1 && this.aBv.du.ZZv()) || com.bytedance.sdk.openadsdk.core.model.aBv.ZZv(this.aBv.Og) || com.bytedance.sdk.openadsdk.core.model.aBv.ML(this.aBv.Og) || this.ML || !og.JG()) {
            return;
        }
        this.aBv.Bf.removeMessages(300);
        Message messageObtain = Message.obtain();
        messageObtain.what = 300;
        this.aBv.Bf.sendMessageDelayed(messageObtain, 5000L);
    }

    private boolean pA(long j, boolean z) {
        if (this.JG == null || this.omh.Bf() == null) {
            return false;
        }
        String strPA = CacheDirFactory.getICacheDir(this.omh.FK()).pA();
        File file = new File(strPA, this.omh.Bf().Sn());
        if (file.exists() && file.length() > 0) {
            this.Og = true;
        }
        com.bytedance.sdk.openadsdk.core.Wx.pA.Og ogPA = com.bytedance.sdk.openadsdk.core.model.yFO.pA(strPA, this.omh);
        ogPA.Og(this.omh.nCO());
        ogPA.pA(this.Bzk.getWidth());
        ogPA.Og(this.Bzk.getHeight());
        ogPA.KZx(this.omh.tM());
        ogPA.pA(j);
        ogPA.pA(z);
        if (this.aBv.Og.pA() && !this.aBv.du.omh() && com.bytedance.sdk.openadsdk.core.model.yFO.ML(this.omh)) {
            ogPA.ZZv = 1;
        }
        return this.JG.pA(ogPA);
    }

    public void KZx(boolean z) {
        this.KZx = z;
    }

    public boolean WQf() {
        return this.KZx;
    }

    public void TV() {
        WV();
    }

    public void du() {
        try {
            if (Og()) {
                this.ML = true;
                DX();
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.WV.pA("TTAD.RFVideoPlayerMag", "onPause throw Exception :" + e.getMessage());
        }
    }

    public void pA(com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og og) {
        try {
            this.ML = false;
            if (JG()) {
                xy();
                Og(og);
            } else if (ZZv()) {
                Sn();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("TTAD.RFVideoPlayerMag", "onContinue throw Exception :" + th.getMessage());
        }
    }

    public void pA(boolean z, com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og og, boolean z2) {
        if (!z2 || z || this.ML) {
            return;
        }
        if (ZZv()) {
            Sn();
            Log.i("TTAD.RFVideoPlayerMag", "resumeOrRestartVideo: continue play");
        } else {
            xy();
            Og(og);
            Log.i("TTAD.RFVideoPlayerMag", "resumeOrRestartVideo: recreate video player & exec play");
        }
    }

    public boolean eG() {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.JG;
        if (kZx == null || kZx.WV() == null) {
            return false;
        }
        return this.JG.WV().pA();
    }

    protected void Og(com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og og) {
        if (!Sd() || og == null) {
            return;
        }
        og.pA(Bzk(), true);
    }

    public double roi() {
        long jZZv;
        com.bytedance.sdk.openadsdk.core.model.XT xtBzk = this.omh.Bzk();
        if (com.bytedance.sdk.openadsdk.core.model.aBv.ZZv(this.omh) && xtBzk != null) {
            jZZv = xtBzk.Og();
        } else if (com.bytedance.sdk.openadsdk.core.model.aBv.ML(this.omh) && xtBzk != null) {
            jZZv = xtBzk.ZZv();
        } else {
            com.bykv.vk.openvk.pA.pA.pA.KZx.Og ogBf = this.omh.Bf();
            if (ogBf != null) {
                return ogBf.JG() * ((double) ogBf.TX());
            }
            return 0.0d;
        }
        return jZZv;
    }

    public void Mc() {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.JG;
        if (kZx instanceof com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA) {
            ((com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA) kZx).rB();
        }
    }

    public View IG() {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.JG;
        if (kZx instanceof com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA) {
            return (View) ((com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA) kZx).qmB();
        }
        return null;
    }

    public void lT() {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.JG;
        if (kZx instanceof com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA) {
            ((com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA) kZx).gbA();
        }
    }

    public void rB() {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.JG;
        if (kZx instanceof com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA) {
            ((com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA) kZx).Vgu();
        }
    }

    public void ZZv(boolean z) {
        this.XT = z;
        if (this.JG instanceof com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA) {
            if (z) {
                ((com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA) this.JG).Og(this.omh.Bf().TX());
            } else {
                this.omh.Bf().SGo(1);
                ((com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA) this.JG).Og(1);
            }
        }
    }

    public void pA(com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA.InterfaceC0240pA interfaceC0240pA) {
        this.yFO = interfaceC0240pA;
    }
}
