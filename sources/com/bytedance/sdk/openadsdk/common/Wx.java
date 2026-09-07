package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.model.yFO;

/* JADX INFO: loaded from: classes.dex */
public class Wx {
    private final String JG;
    private final Context KZx;
    private ImageView ML;
    private RelativeLayout Og;
    private XT SD;
    private com.bytedance.sdk.component.Bzk.ZZv ZZv;
    private oX omh;
    private final yFO pA;

    public Wx(Context context, yFO yfo, String str) {
        this.KZx = context;
        this.pA = yfo;
        this.JG = str;
        JG();
    }

    private static RelativeLayout pA(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setBackgroundColor(-1);
        relativeLayout.addView(new Bzk(context));
        com.bytedance.sdk.component.Bzk.ZZv zZv = new com.bytedance.sdk.component.Bzk.ZZv(context);
        zZv.setId(com.bytedance.sdk.openadsdk.utils.Sn.JBA);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(12);
        layoutParams.addRule(3, com.bytedance.sdk.openadsdk.utils.Sn.gy);
        relativeLayout.addView(zZv, layoutParams);
        omh omhVar = new omh(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(omhVar.getLayoutParams());
        layoutParams2.addRule(12);
        relativeLayout.addView(omhVar, layoutParams2);
        return relativeLayout;
    }

    private void JG() {
        RelativeLayout relativeLayoutPA = pA(this.KZx);
        this.Og = relativeLayoutPA;
        this.ZZv = (com.bytedance.sdk.component.Bzk.ZZv) relativeLayoutPA.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.JBA);
        XT xt = new XT(this.KZx, (RelativeLayout) this.Og.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.gy), this.pA);
        this.SD = xt;
        this.ML = xt.KZx();
        this.omh = new oX(this.KZx, (LinearLayout) this.Og.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.tM), this.ZZv, this.pA, this.JG);
    }

    public void pA() {
        XT xt = this.SD;
        if (xt != null) {
            xt.pA();
        }
        oX oXVar = this.omh;
        if (oXVar != null) {
            oXVar.pA();
        }
    }

    public void Og() {
        XT xt = this.SD;
        if (xt != null) {
            xt.Og();
        }
        oX oXVar = this.omh;
        if (oXVar != null) {
            oXVar.Og();
        }
    }

    public ImageView KZx() {
        return this.ML;
    }

    public com.bytedance.sdk.component.Bzk.ZZv ZZv() {
        return this.ZZv;
    }

    public View ML() {
        return this.Og;
    }

    public void pA(WebView webView, int i, com.bytedance.sdk.openadsdk.core.widget.pA.JG.pA pAVar) {
        XT xt = this.SD;
        if (xt != null) {
            xt.pA(i);
        }
        oX oXVar = this.omh;
        if (oXVar != null) {
            oXVar.pA(webView, pAVar);
        }
    }
}
