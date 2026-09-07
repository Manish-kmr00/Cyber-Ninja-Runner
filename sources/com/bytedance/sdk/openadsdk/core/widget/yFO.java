package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes2.dex */
public class yFO {
    private boolean JG = false;
    private Context KZx;
    private Og ML;
    private TextView Og;
    private com.bykv.vk.openvk.pA.pA.pA.KZx.Og SD;
    private com.bytedance.sdk.openadsdk.core.Wx.Og.pA ZZv;
    private ViewGroup omh;
    private View pA;

    public interface Og {
        void BSW();

        boolean SGo();
    }

    public enum pA {
        PAUSE_VIDEO,
        RELEASE_VIDEO,
        START_VIDEO
    }

    public void pA(Context context, ViewGroup viewGroup) {
        if (context == null || !(viewGroup instanceof ViewGroup)) {
            return;
        }
        this.omh = viewGroup;
        this.KZx = com.bytedance.sdk.openadsdk.core.aBv.pA().getApplicationContext();
    }

    private void pA(Context context, View view, boolean z) {
        ViewGroup.LayoutParams layoutParamsPA;
        if (context == null || view == null || this.pA != null || (layoutParamsPA = pA(this.omh)) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.Wx.DX dx = new com.bytedance.sdk.openadsdk.Wx.DX(context);
        this.pA = dx;
        dx.setLayoutParams(layoutParamsPA);
        this.omh.addView(this.pA);
        this.Og = (TextView) this.pA.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.EC);
        View viewFindViewById = this.pA.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.LhC);
        if (z) {
            viewFindViewById.setClickable(true);
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.yFO.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/widget/yFO$1;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(h.u, view2);
                    safedk_yFO$1_onClick_c595f1df44029245faaeb890cd144549(view2);
                }

                public void safedk_yFO$1_onClick_c595f1df44029245faaeb890cd144549(View p0) {
                    yFO.this.KZx();
                    if (yFO.this.ZZv != null) {
                        yFO.this.ZZv.pA(pA.START_VIDEO, (String) null);
                    }
                }
            });
        } else {
            viewFindViewById.setOnClickListener(null);
            viewFindViewById.setClickable(false);
        }
    }

    private ViewGroup.LayoutParams pA(ViewGroup viewGroup) {
        if (viewGroup instanceof RelativeLayout) {
            return new RelativeLayout.LayoutParams(-1, -1);
        }
        if (viewGroup instanceof LinearLayout) {
            return new LinearLayout.LayoutParams(-1, -1);
        }
        if (viewGroup instanceof FrameLayout) {
            return new FrameLayout.LayoutParams(-1, -1);
        }
        return null;
    }

    public void pA(com.bytedance.sdk.openadsdk.core.Wx.Og.pA pAVar, Og og) {
        this.ML = og;
        this.ZZv = pAVar;
    }

    private void Og() {
        this.SD = null;
    }

    public boolean pA(int i, com.bykv.vk.openvk.pA.pA.pA.KZx.Og og, boolean z) {
        Context context = this.KZx;
        if (context == null || og == null) {
            return true;
        }
        pA(context, this.omh, z);
        this.SD = og;
        if (i == 1 || i == 2) {
            return pA(i);
        }
        return true;
    }

    private boolean pA(int i) {
        Og og;
        if (pA() || this.JG) {
            return true;
        }
        if (this.ZZv != null && (og = this.ML) != null) {
            if (og.SGo()) {
                this.ZZv.ML(null, null);
            }
            this.ZZv.pA(pA.PAUSE_VIDEO, (String) null);
        }
        pA(this.SD, true);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KZx() {
        if (this.KZx == null) {
            return;
        }
        ZZv();
    }

    public void pA(boolean z) {
        if (z) {
            Og();
        }
        ZZv();
    }

    public boolean pA() {
        View view = this.pA;
        return view != null && view.getVisibility() == 0;
    }

    private void ZZv() {
        View view = this.pA;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void pA(com.bykv.vk.openvk.pA.pA.pA.KZx.Og og, boolean z) {
        View view;
        String str;
        View view2;
        if (og == null || (view = this.pA) == null || this.KZx == null || view.getVisibility() == 0) {
            return;
        }
        Og og2 = this.ML;
        if (og2 != null) {
            og2.BSW();
        }
        double dCeil = Math.ceil((og.ML() * 1.0d) / 1048576.0d);
        if (z) {
            str = String.format(com.bytedance.sdk.component.utils.yFO.pA(this.KZx, "tt_video_without_wifi_tips"), Float.valueOf(Double.valueOf(dCeil).floatValue()));
        } else {
            str = com.bytedance.sdk.component.utils.yFO.pA(this.KZx, "tt_video_without_wifi_tips") + com.bytedance.sdk.component.utils.yFO.pA(this.KZx, "tt_video_bytesize");
        }
        Vgu.pA(this.pA, 0);
        Vgu.pA(this.Og, str);
        Log.i("VideoTrafficTipLayout", "showTrafficTipCover: ");
        if (!Vgu.ZZv(this.pA) || (view2 = this.pA) == null) {
            return;
        }
        view2.bringToFront();
        Log.i("VideoTrafficTipLayout", "showTrafficTipCover: bringToFront");
    }
}
