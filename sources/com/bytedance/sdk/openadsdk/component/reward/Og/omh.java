package com.bytedance.sdk.openadsdk.component.reward.Og;

import android.app.Activity;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.DX;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.Sn;
import com.bytedance.sdk.openadsdk.utils.gbA;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class omh extends Og {
    private final int DX;
    private String XT;
    private com.bytedance.sdk.openadsdk.component.reward.view.ML aBv;
    private ViewGroup oX;

    public omh(com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar) {
        super(pAVar);
        this.XT = "fullscreen_interstitial_ad";
        this.DX = this.Og.RS();
    }

    private void Mc() {
        FrameLayout.LayoutParams layoutParams;
        FrameLayout frameLayout = new FrameLayout(this.pA.SzT);
        this.oX = frameLayout;
        frameLayout.setId(Sn.eD);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.oX.setLayoutParams(layoutParams2);
        View viewBSW = this.pA.Vgu.BSW();
        if (viewBSW != null) {
            layoutParams2.bottomMargin = viewBSW.getHeight();
        }
        com.bytedance.sdk.openadsdk.component.reward.view.ML ml = new com.bytedance.sdk.openadsdk.component.reward.view.ML(this.pA.SzT);
        this.aBv = ml;
        ml.setId(Sn.FGT);
        if (this.pA.Og.rtW() == 1) {
            layoutParams = new FrameLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -1);
        }
        layoutParams.gravity = 17;
        this.aBv.setLayoutParams(layoutParams);
        this.oX.addView(this.aBv);
        IG();
    }

    private void IG() {
        if (this.oX == null) {
            return;
        }
        pA((View) this.aBv);
    }

    private void Og(yFO yfo) {
        if (yfo == null || this.aBv == null) {
            return;
        }
        lT();
        pA((ImageView) this.aBv);
    }

    private void lT() {
        DX dx;
        List<DX> listIIF = this.Og.IIF();
        if (listIIF == null || listIIF.size() <= 0 || (dx = listIIF.get(0)) == null) {
            return;
        }
        try {
            int iOg = dx.Og();
            int iKZx = dx.KZx();
            if (iOg != 0 && iKZx != 0) {
                this.aBv.setRatio(iOg / iKZx);
                return;
            }
            int i = this.DX;
            if (i == 33) {
                this.aBv.setRatio(1.0f);
            } else if (i == 3) {
                this.aBv.setRatio(1.91f);
            } else {
                this.aBv.setRatio(0.56f);
            }
        } catch (Exception e) {
            WV.pA("TTAD.RFTI", e.getMessage());
        }
    }

    private void pA(ImageView imageView) {
        List<DX> listIIF;
        DX dx;
        if (this.Og == null || (listIIF = this.Og.IIF()) == null || listIIF.size() <= 0 || (dx = listIIF.get(0)) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.Bzk.ZZv.pA(listIIF.get(0)).KZx(2).pA(com.bytedance.sdk.openadsdk.Bzk.KZx.pA(this.Og, dx.pA(), imageView));
    }

    protected void pA(View view) {
        com.bytedance.sdk.openadsdk.core.Og.Og pAVar;
        if (view == null || this.pA.SzT == null || this.Og == null) {
            return;
        }
        if (this.WV == null) {
            Activity activity = this.pA.SzT;
            yFO yfo = this.Og;
            String str = this.XT;
            pAVar = new com.bytedance.sdk.openadsdk.core.Og.pA(activity, yfo, str, gbA.pA(str));
            pAVar.pA(KZx(this.Og));
            HashMap map = new HashMap();
            if (WQf.XT(this.Og)) {
                map.put("click_scence", 3);
            } else {
                map.put("click_scence", 1);
            }
            pAVar.pA(map);
        } else {
            pAVar = this.WV;
        }
        if (this.pA.SzT != null) {
            pAVar.pA(this.pA.SzT);
        }
        view.setOnTouchListener(pAVar);
        view.setOnClickListener(pAVar);
    }

    private com.bytedance.sdk.openadsdk.XT.pA.pA.JG KZx(yFO yfo) {
        if (yfo.JBA() == 4) {
            return new com.bytedance.sdk.openadsdk.XT.pA.pA.ZZv(aBv.pA(), yfo, this.XT);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public void pA(FrameLayout frameLayout) {
        try {
            Mc();
            Og(this.Og);
            frameLayout.addView(this.oX);
        } catch (Exception e) {
            Log.e("TTAD.RFTI", "bindAd: ", e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public void pA(com.bytedance.sdk.openadsdk.component.reward.view.SD sd) {
        if (com.bytedance.sdk.openadsdk.core.model.aBv.Og(this.Og)) {
            ZZv.Og(sd);
            this.pA.Wo.pA((long) (this.pA.BF.roi() * 1000.0d));
        } else if (com.bytedance.sdk.openadsdk.core.model.aBv.ZZv(this.Og) || com.bytedance.sdk.openadsdk.core.model.aBv.ML(this.Og)) {
            ZZv.KZx(sd);
            this.pA.Wo.pA((long) (this.pA.BF.roi() * 1000.0d));
        } else {
            super.pA(sd);
        }
    }

    public static boolean pA(yFO yfo) {
        return !yFO.ML(yfo) && yfo.slz() == 100.0f;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public boolean ML() {
        return rB() || WQf.SD(this.Og);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public boolean JG() {
        return rB();
    }

    private boolean rB() {
        return this.Og != null && this.Og.BF() == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public void SD() {
        if (com.bytedance.sdk.openadsdk.core.model.aBv.Og(this.Og)) {
            this.JG.Og(8);
        }
        this.omh.KZx(false);
        this.omh.ZZv(false);
        if (this.Og.BF() == 2) {
            this.omh.pA(false);
            this.JG.ML(8);
            return;
        }
        this.omh.pA(this.Og.uQ());
        if (this.pA.bU) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 900;
            com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar = this.pA;
            int iRoi = (int) (this.pA.BF.roi() * 1000.0d);
            pAVar.Bzk = iRoi;
            messageObtain.arg1 = iRoi;
            this.pA.Bf.sendMessage(messageObtain);
        }
    }
}
