package com.bytedance.sdk.openadsdk.core.BSW.ZZv;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.core.WV;
import com.bytedance.adsdk.ugeno.core.Wx;
import com.bytedance.adsdk.ugeno.core.omh;
import com.bytedance.sdk.component.adexpress.ZZv.SD;
import com.bytedance.sdk.openadsdk.core.BSW.Og.JG;
import com.bytedance.sdk.openadsdk.core.model.Sn;
import com.bytedance.sdk.openadsdk.core.model.eG;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import java.util.HashMap;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class ML extends KZx {
    private com.bytedance.adsdk.ugeno.Og.KZx TV;
    private com.bytedance.adsdk.ugeno.Og.KZx WQf;
    private boolean du;

    @Override // com.bytedance.sdk.openadsdk.core.BSW.ZZv.KZx
    protected com.bytedance.adsdk.ugeno.Og.KZx SD() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.BSW.ZZv.KZx, com.bytedance.sdk.component.adexpress.dynamic.ZZv
    public void setSoundMute(boolean z) {
    }

    public ML(Context context, yFO yfo, boolean z, pA pAVar, ViewGroup viewGroup) {
        super(context, yfo, z, pAVar, viewGroup);
        this.du = false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.BSW.ZZv.KZx
    protected JSONObject pA() {
        JSONObject jSONObjectKZx = this.JG.KZx();
        if (jSONObjectKZx != null) {
            return jSONObjectKZx.optJSONObject("xTemplate");
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.BSW.ZZv.KZx
    protected JSONObject Og() {
        return this.JG.KZx();
    }

    @Override // com.bytedance.sdk.openadsdk.core.BSW.ZZv.KZx, com.bytedance.adsdk.ugeno.core.WV
    public void pA(com.bytedance.adsdk.ugeno.Og.KZx kZx, String str, com.bytedance.adsdk.ugeno.ZZv.Og.pA pAVar) {
        if (this.omh == null || pAVar == null) {
            return;
        }
        String strOg = pAVar.Og();
        strOg.hashCode();
        int i = 6;
        boolean z = true;
        switch (strOg) {
            case "openPrivacy":
                i = 7;
                break;
            case "pauseVideo":
            case "videoControl":
                i = 4;
                break;
            case "skip":
                break;
            case "convert":
                i = 2;
                break;
            case "muteVideo":
                i = 5;
                break;
            case "dislike":
                i = 3;
                break;
            default:
                i = 0;
                break;
        }
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        if (this.vZF != null) {
            int[] iArrPA = Vgu.pA(this.vZF.get());
            if (iArrPA != null) {
                iArr = iArrPA;
            }
            int[] iArrKZx = Vgu.KZx(this.vZF.get());
            if (iArrKZx != null) {
                iArr2 = iArrKZx;
            }
        }
        Sn.pA pAVarPA = new Sn.pA().ZZv(this.WV).KZx(this.Wx).Og(this.Sn).pA(this.DX).Og(this.oX).pA(this.aBv).KZx(iArr[0]).ZZv(iArr[1]).ML(iArr2[0]).JG(iArr2[1]).pA(this.TX);
        if (str.equals("tap") && !this.XT) {
            z = false;
        }
        this.omh.pA(kZx.Bzk(), i, pAVarPA.pA(z).pA(kZx.lT()).Og(false).pA());
    }

    @Override // com.bytedance.sdk.openadsdk.core.BSW.ZZv.KZx
    protected int ZZv() {
        Bzk();
        this.pA.pA((WV) this);
        this.pA.pA((Wx) this);
        eG eGVarFQ = this.ML.FQ();
        try {
            if (eGVarFQ != null) {
                this.KZx = this.pA.pA(this.ZZv, this.BF, eGVarFQ.ML());
            } else {
                this.KZx = this.pA.pA(this.ZZv, this.BF, null);
            }
            if (this.KZx != null) {
                if (TextUtils.equals(this.Sd, "rewarded_video")) {
                    this.WQf = this.KZx.ZZv("RVCountdown");
                    this.TV = this.KZx.ZZv("RVSkipView");
                } else {
                    this.WQf = this.KZx.ZZv("FVCountdown");
                    this.TV = this.KZx.ZZv("FVSkipView");
                }
                omh();
            }
            this.JG.Mc().Og();
            this.JG.Mc().KZx();
            return 0;
        } catch (UnsatisfiedLinkError unused) {
            return 139;
        }
    }

    private void omh() {
        com.bytedance.adsdk.ugeno.Og.KZx kZx = this.WQf;
        if (kZx != null) {
            kZx.KZx(8);
        }
        com.bytedance.adsdk.ugeno.Og.KZx kZx2 = this.TV;
        if (kZx2 != null) {
            kZx2.KZx(8);
        }
    }

    private void Bzk() {
        omh omhVar = new omh();
        HashMap map = new HashMap();
        map.put("image_info", this.JG.BSW());
        map.put("cache_dir", this.JG.Sn());
        omhVar.pA(map);
        omhVar.pA(this.Og);
        omhVar.pA(this.ZZv);
        omhVar.Og(this.BF);
        this.pA.pA(Reporting.Key.CLICK_SOURCE_TYPE_AD, omhVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.BSW.ZZv.KZx
    protected com.bytedance.adsdk.ugeno.Og.KZx JG() {
        if (this.KZx == null) {
            return null;
        }
        return this.KZx.ZZv("VideoV3");
    }

    @Override // com.bytedance.sdk.openadsdk.core.BSW.ZZv.KZx, com.bytedance.sdk.component.adexpress.dynamic.ZZv
    public void setTime(CharSequence charSequence, int i, int i2, boolean z) {
        if (this.KZx == null) {
            return;
        }
        boolean z2 = i == 1;
        pA(charSequence, z2, i2, z);
        Og(charSequence, z2, i2, z);
    }

    private void pA(CharSequence charSequence, boolean z, int i, boolean z2) {
        int i2;
        com.bytedance.adsdk.ugeno.Og.KZx kZx = this.WQf;
        if (kZx != null && (kZx instanceof com.bytedance.sdk.openadsdk.core.BSW.Og.Og)) {
            try {
                i2 = Integer.parseInt((String) charSequence);
            } catch (Exception unused) {
                com.bytedance.sdk.component.utils.WV.pA("UGenRender", "parse duration exception", charSequence);
                i2 = 0;
            }
            if (z2 || i2 <= 0 || this.du) {
                this.WQf.KZx(8);
                return;
            }
            this.WQf.KZx(0);
            if (!z && this.JG.pA() && SD.Og(this.JG.ZZv())) {
                ((com.bytedance.sdk.openadsdk.core.BSW.Og.Og) this.WQf).SD(String.valueOf(i));
            } else if (!"open_ad".equals(this.JG.ZZv()) && this.JG.pA()) {
                this.du = true;
                this.WQf.KZx(8);
            } else {
                ((com.bytedance.sdk.openadsdk.core.BSW.Og.Og) this.WQf).SD(String.valueOf(charSequence));
            }
        }
    }

    private void Og(CharSequence charSequence, boolean z, int i, boolean z2) {
        com.bytedance.adsdk.ugeno.Og.KZx kZx = this.TV;
        if (kZx != null && (kZx instanceof JG)) {
            int i2 = 0;
            if (!z && !z2) {
                i2 = 8;
            }
            kZx.KZx(i2);
        }
    }
}
