package com.bytedance.sdk.openadsdk.core.Wx.Og;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.TV;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.widget.XT;
import com.bytedance.sdk.openadsdk.utils.Bzk;
import com.bytedance.sdk.openadsdk.utils.Sn;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes7.dex */
public class ZZv extends ML {
    private ImageView Bf;
    private View CIG;
    private final Rect FGT;
    private TextView FQ;
    private final XT Gag;
    private TextView Gx;
    private View HSv;
    private final TV IIF;
    private final Rect Itl;
    private ImageView JBA;
    private float Ld;
    private boolean PV;
    private final int QI;
    private final View.OnTouchListener Qj;
    private final int RS;
    private int SXO;
    private TextView SzT;
    private ColorStateList Uz;
    private ImageView Vgu;
    private float Wo;
    private TextView YkC;
    private TextView agB;
    private ColorStateList bU;
    private int cFQ;
    private ImageView dC;
    private SeekBar dmv;
    private TextView fJy;
    private View fN;
    private int fw;
    private TextView gbA;
    private int gy;
    private final Rect jO;
    private int lx;
    private final Rect nCO;
    private final Rect rtW;
    private float sk;
    private float slz;
    private int tM;
    private ColorStateList tZW;
    private float uQ;
    private boolean vA;

    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.ML, com.bykv.vk.openvk.pA.pA.pA.ZZv.Og
    public /* bridge */ /* synthetic */ void pA(yFO yfo, WeakReference weakReference, boolean z) {
        pA(yfo, (WeakReference<Context>) weakReference, z);
    }

    public ZZv(Context context, ViewGroup viewGroup, boolean z, int i, yFO yfo, com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx, boolean z2) {
        super(context, viewGroup, z, i, yfo, kZx, z2);
        this.IIF = new TV(this);
        this.vA = false;
        this.PV = false;
        this.cFQ = 0;
        this.lx = 0;
        this.SXO = 0;
        this.fw = 0;
        this.gy = 0;
        this.nCO = new Rect();
        this.Itl = new Rect();
        this.tM = 0;
        this.Qj = new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.ZZv.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/Wx/Og/ZZv$7;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                CreativeInfoManager.onViewTouched(h.u, view, motionEvent);
                return safedk_ZZv$7_onTouch_64d216f214aa3bd5b534a0978a99157e(view, motionEvent);
            }

            public boolean safedk_ZZv$7_onTouch_64d216f214aa3bd5b534a0978a99157e(View p0, MotionEvent p1) {
                int actionMasked = p1.getActionMasked();
                if (actionMasked == 2) {
                    p0.getParent().requestDisallowInterceptTouchEvent(true);
                } else if (actionMasked == 3) {
                    p0.getParent().requestDisallowInterceptTouchEvent(false);
                }
                return false;
            }
        };
        this.rtW = new Rect();
        this.jO = new Rect();
        this.FGT = new Rect();
        this.du = aBv.pA().getApplicationContext();
        ZZv(z2);
        this.KZx = viewGroup;
        this.Sd = z;
        XT xt = new XT(this);
        this.Gag = xt;
        xt.pA(this.Sd);
        DisplayMetrics displayMetrics = this.du.getResources().getDisplayMetrics();
        this.RS = displayMetrics.widthPixels;
        this.QI = displayMetrics.heightPixels;
        this.WQf = i;
        this.lT = kZx;
        this.TV = yfo;
        ZZv(8);
        pA(context, this.KZx);
        ZZv();
        WV();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.ML
    protected void pA(Context context, View view) {
        super.pA(context, view);
        this.gbA = (TextView) view.findViewById(Sn.rX);
        this.Vgu = (ImageView) view.findViewById(Sn.BDQ);
        this.CIG = view.findViewById(Sn.mY);
        this.Bf = (ImageView) view.findViewById(Sn.Tsy);
        this.SzT = (TextView) view.findViewById(Sn.FK);
        this.FQ = (TextView) view.findViewById(Sn.Qd);
        this.Gx = (TextView) view.findViewById(Sn.HMH);
        this.HSv = view.findViewById(Sn.GbR);
        this.JBA = (ImageView) view.findViewById(Sn.aj);
        TextView textView = (TextView) view.findViewById(Sn.sPI);
        this.agB = textView;
        textView.setText(com.bytedance.sdk.component.utils.yFO.pA(context, "tt_video_retry_des_txt"));
        this.dmv = (SeekBar) view.findViewById(Sn.PKZ);
        this.fJy = (TextView) view.findViewById(Sn.FHA);
        this.YkC = (TextView) view.findViewById(Sn.fg);
        this.fN = view.findViewById(Sn.Bpk);
        this.dC = (ImageView) view.findViewById(Sn.Kj);
        this.Bzk = view.findViewById(Sn.Xj);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.ML
    protected void ZZv() {
        super.ZZv();
        this.Gag.pA(this.KZx);
        Vgu.pA((View) this.Vgu, (this.Sd || (this.WQf & 1) == 1) ? 8 : 0);
        this.Vgu.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.ZZv.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/Wx/Og/ZZv$1;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view);
                safedk_ZZv$1_onClick_af0819e6dd13b22aeb6801eec58c064b(view);
            }

            public void safedk_ZZv$1_onClick_af0819e6dd13b22aeb6801eec58c064b(View p0) {
                if (ZZv.this.oX()) {
                    ZZv.this.roi.KZx(ZZv.this, p0);
                }
            }
        });
        Vgu.pA((View) this.gbA, (!this.Sd || (this.WQf & 2) == 2) ? 0 : 8);
        this.gbA.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.ZZv.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/Wx/Og/ZZv$2;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view);
                safedk_ZZv$2_onClick_3ce4796edaf0770376457ecf8da70fea(view);
            }

            public void safedk_ZZv$2_onClick_3ce4796edaf0770376457ecf8da70fea(View p0) {
                if (ZZv.this.oX()) {
                    ZZv.this.roi.ZZv(ZZv.this, p0);
                }
            }
        });
        this.Bf.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.ZZv.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/Wx/Og/ZZv$3;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view);
                safedk_ZZv$3_onClick_a27c91d42b756b1c57021d43b30aecb4(view);
            }

            public void safedk_ZZv$3_onClick_a27c91d42b756b1c57021d43b30aecb4(View p0) {
                if (ZZv.this.oX()) {
                    ZZv.this.roi.ML(ZZv.this, p0);
                }
            }
        });
        this.JBA.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.ZZv.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/Wx/Og/ZZv$4;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view);
                safedk_ZZv$4_onClick_976a8055397919612077bdca001f0c29(view);
            }

            public void safedk_ZZv$4_onClick_976a8055397919612077bdca001f0c29(View p0) {
                ZZv.this.Og(false, true);
                ZZv.this.omh();
                ZZv.this.SD();
                ZZv.this.oX();
            }
        });
        this.dC.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.ZZv.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/Wx/Og/ZZv$5;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view);
                safedk_ZZv$5_onClick_9d97a1096e07455a435830185175d1e3(view);
            }

            public void safedk_ZZv$5_onClick_9d97a1096e07455a435830185175d1e3(View p0) {
                if (ZZv.this.oX()) {
                    ZZv.this.roi.Og(ZZv.this, p0);
                }
            }
        });
        this.dmv.setThumbOffset(0);
        this.dmv.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.ZZv.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (!ZZv.this.vA && ZZv.this.du != null) {
                    seekBar.setThumb(Bzk.pA(aBv.pA(), "tt_seek_thumb_normal"));
                }
                if (ZZv.this.oX()) {
                    seekBar.setThumbOffset(0);
                    ZZv.this.roi.pA(ZZv.this, seekBar.getProgress());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (!ZZv.this.vA && ZZv.this.du != null) {
                    seekBar.setThumb(Bzk.pA(aBv.pA(), "tt_seek_thumb_press"));
                }
                if (ZZv.this.oX()) {
                    seekBar.setThumbOffset(0);
                    ZZv.this.roi.Og(ZZv.this, seekBar.getProgress());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (ZZv.this.oX()) {
                    ZZv.this.roi.pA(ZZv.this, i, z);
                }
            }
        });
        this.dmv.setOnTouchListener(this.Qj);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.ML
    public void ML() {
        this.IIF.removeMessages(1);
        this.IIF.sendMessageDelayed(this.IIF.obtainMessage(1), 2000L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.ML
    public void JG() {
        this.IIF.removeMessages(1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.ML
    public void Og(boolean z) {
        int i = SGo() ? this.QI : this.aBv;
        int iKZx = SGo() ? this.RS : this.XT;
        if (this.vZF <= 0 || this.yFO <= 0 || i <= 0) {
            return;
        }
        if (!Sd() && !SGo() && (this.WQf & 8) != 8) {
            iKZx = Vgu.KZx(this.du, 228.0f);
        }
        int i2 = (int) (this.vZF * ((i * 1.0f) / this.yFO));
        if (i2 > iKZx) {
            i = (int) (this.yFO * ((iKZx * 1.0f) / this.vZF));
        } else {
            iKZx = i2;
        }
        if (!z && !SGo()) {
            i = this.aBv;
            iKZx = this.XT;
        }
        this.ZZv.pA(i, iKZx);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.ML
    public void pA(String str) {
        TextView textView = this.SzT;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.FQ;
        if (textView2 != null) {
            textView2.setText(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.ML
    public void pA(int i) {
        View view = this.fN;
        if (view == null || view.getVisibility() != 0) {
            this.dmv.setProgress(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.ML
    public void pA(long j, long j2) {
        this.fJy.setText(com.bykv.vk.openvk.pA.pA.Og.ML.pA.pA(j2));
        this.YkC.setText(com.bykv.vk.openvk.pA.pA.Og.ML.pA.pA(j));
        this.dmv.setProgress(com.bykv.vk.openvk.pA.pA.Og.ML.pA.pA(j, j2));
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.ML
    public void SD() {
        Vgu.JG(this.JG);
        Vgu.JG(this.SD);
        Vgu.ML(this.HSv);
        if (this.omh != null && this.TV != null && this.TV.Bf() != null && this.TV.Bf().SGo() != null) {
            Vgu.JG(this.omh);
            com.bytedance.sdk.openadsdk.aBv.KZx.pA().pA(this.TV.Bf().SGo(), this.TV.Bf().KZx(), this.TV.Bf().Og(), this.omh, this.TV);
        }
        if (this.ML.getVisibility() == 0) {
            Vgu.pA((View) this.ML, 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.ML, com.bykv.vk.openvk.pA.pA.pA.ZZv.Og
    public void pA() {
        pA(false, this.Sd);
        yFO();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.ML
    public void pA(long j) {
        this.YkC.setText(com.bykv.vk.openvk.pA.pA.Og.ML.pA.pA(j));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.ML
    public void pA(yFO yfo, WeakReference<Context> weakReference, boolean z) {
        String strFw;
        String strPA;
        if (yfo == null) {
            return;
        }
        pA(this.KZx, aBv.pA());
        pA(false, this.Sd);
        Vgu.pA(this.SGo, 0);
        Vgu.pA((View) this.BSW, 0);
        Vgu.pA(this.WV, 0);
        if (this.BSW != null && this.TV != null && this.TV.Bf() != null && this.TV.Bf().SGo() != null) {
            com.bytedance.sdk.openadsdk.aBv.KZx.pA().pA(this.TV.Bf().SGo(), this.TV.Bf().KZx(), this.TV.Bf().Og(), this.BSW, this.TV);
        }
        if (!TextUtils.isEmpty(yfo.HSv())) {
            strFw = yfo.HSv();
        } else if (!TextUtils.isEmpty(yfo.SXO())) {
            strFw = yfo.SXO();
        } else if (TextUtils.isEmpty(yfo.fw())) {
            strFw = "";
        } else {
            strFw = yfo.fw();
        }
        if (this.TV != null && this.TV.fJy() != null && this.TV.fJy().pA() != null) {
            Vgu.pA((View) this.Wx, 0);
            Vgu.pA((View) this.Sn, 4);
            if (this.Wx != null) {
                com.bytedance.sdk.openadsdk.aBv.KZx.pA().pA(this.TV.fJy(), this.Wx, yfo);
                this.Wx.setOnClickListener(this.rB);
                this.Wx.setOnTouchListener(this.rB);
            }
        } else if (!TextUtils.isEmpty(strFw)) {
            Vgu.pA((View) this.Wx, 4);
            Vgu.pA((View) this.Sn, 0);
            if (this.Sn != null) {
                this.Sn.setText(strFw.substring(0, 1));
                this.Sn.setOnClickListener(this.rB);
                this.Sn.setOnTouchListener(this.rB);
            }
        }
        if (this.DX != null && !TextUtils.isEmpty(strFw)) {
            this.DX.setText(strFw);
        }
        Vgu.pA((View) this.DX, 0);
        Vgu.pA((View) this.oX, 0);
        int iJBA = yfo.JBA();
        if (iJBA == 4) {
            strPA = com.bytedance.sdk.component.utils.yFO.pA(this.du, "tt_video_download_apk");
        } else if (iJBA == 5) {
            strPA = com.bytedance.sdk.component.utils.yFO.pA(this.du, "tt_video_dial_phone");
        } else {
            strPA = com.bytedance.sdk.component.utils.yFO.pA(this.du, "tt_video_mobile_go_detail");
        }
        if (this.oX != null) {
            this.oX.setText(strPA);
            this.oX.setOnClickListener(this.rB);
            this.oX.setOnTouchListener(this.rB);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.ML
    public void omh() {
        Vgu.ML(this.JG);
        Vgu.ML(this.HSv);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.ML
    public void Bzk() {
        this.dmv.setProgress(0);
        this.dmv.setSecondaryProgress(0);
        this.fJy.setText(com.bytedance.sdk.component.utils.yFO.pA(this.du, "tt_00_00"));
        this.YkC.setText(com.bytedance.sdk.component.utils.yFO.pA(this.du, "tt_00_00"));
        ZZv(8);
        if (WQf()) {
            this.ZZv.setVisibility(8);
        }
        if (this.omh != null) {
            this.omh.setImageDrawable(null);
        }
        ZZv(8);
        Vgu.pA(this.fN, 8);
        Vgu.pA(this.SGo, 8);
        Vgu.pA((View) this.BSW, 8);
        Vgu.pA(this.WV, 8);
        Vgu.pA((View) this.Wx, 8);
        Vgu.pA((View) this.Sn, 8);
        Vgu.pA((View) this.DX, 8);
        if (this.eG != null) {
            this.eG.pA(true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.ML, com.bytedance.sdk.openadsdk.core.widget.yFO.Og
    public boolean SGo() {
        return this.vA;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.ML
    public void pA(ViewGroup viewGroup) {
        if (viewGroup != null && (this.KZx.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            this.vA = true;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.KZx.getLayoutParams();
            this.lx = marginLayoutParams.leftMargin;
            this.cFQ = marginLayoutParams.topMargin;
            this.SXO = marginLayoutParams.width;
            this.fw = marginLayoutParams.height;
            marginLayoutParams.width = -1;
            marginLayoutParams.height = -1;
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.leftMargin = 0;
            this.KZx.setLayoutParams(marginLayoutParams);
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                int[] rules = layoutParams2.getRules();
                this.gy = rules.length > 0 ? rules[3] : 0;
                layoutParams2.addRule(3, 0);
                viewGroup.setLayoutParams(layoutParams2);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                this.nCO.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                Vgu.pA(viewGroup, 0, 0, 0, 0);
            }
            Og(true);
            this.dC.setImageDrawable(com.bytedance.sdk.component.utils.yFO.KZx(this.du, "tt_shrink_video"));
            this.dmv.setThumb(Bzk.pA(this.du, "tt_seek_thumb_fullscreen_selector"));
            this.dmv.setThumbOffset(0);
            com.bykv.vk.openvk.pA.pA.Og.ML.pA.pA((View) this.KZx, false);
            ML(this.vA);
            Vgu.pA(this.CIG, 8);
            if (!this.Sd) {
                Vgu.pA((View) this.Vgu, 8);
                Vgu.pA((View) this.gbA, 8);
            } else if ((this.WQf & 1) == 1) {
                Vgu.pA((View) this.Vgu, 8);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.ML
    public void Og(ViewGroup viewGroup) {
        WV.pA("FullScreen", "Detail exitFullScreen.....");
        if (viewGroup == null || this.KZx == null || !(this.KZx.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        this.vA = false;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.KZx.getLayoutParams();
        marginLayoutParams.width = this.SXO;
        marginLayoutParams.height = this.fw;
        marginLayoutParams.leftMargin = this.lx;
        marginLayoutParams.topMargin = this.cFQ;
        this.KZx.setLayoutParams(marginLayoutParams);
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.addRule(3, this.gy);
            viewGroup.setLayoutParams(layoutParams2);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            Vgu.pA(viewGroup, this.nCO.left, this.nCO.top, this.nCO.right, this.nCO.bottom);
        }
        Og(true);
        this.dC.setImageDrawable(com.bytedance.sdk.component.utils.yFO.KZx(this.du, "tt_enlarge_video"));
        this.dmv.setThumb(Bzk.pA(this.du, "tt_seek_thumb_normal"));
        this.dmv.setThumbOffset(0);
        com.bykv.vk.openvk.pA.pA.Og.ML.pA.pA((View) this.KZx, true);
        ML(this.vA);
        Vgu.pA(this.CIG, 8);
        if ((this.WQf & 2) == 2) {
            Vgu.pA((View) this.gbA, 0);
        }
    }

    private void ML(boolean z) {
        if (z) {
            TV();
        } else {
            du();
        }
    }

    private void TV() {
        DisplayMetrics displayMetrics = this.du.getResources().getDisplayMetrics();
        TextView textView = this.YkC;
        if (textView != null) {
            this.sk = textView.getTextSize();
            this.YkC.setTextSize(2, 14.0f);
            ColorStateList textColors = this.YkC.getTextColors();
            this.tZW = textColors;
            if (textColors != null) {
                this.YkC.setTextColor(-1);
            }
            this.Ld = this.YkC.getAlpha();
            this.YkC.setAlpha(0.85f);
            this.YkC.setShadowLayer(0.0f, Vgu.KZx(this.du, 0.5f), Vgu.KZx(this.du, 0.5f), com.bytedance.sdk.component.utils.yFO.SD(this.du, "tt_b2000000"));
            ViewGroup.LayoutParams layoutParams = this.YkC.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.rtW.set(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                Vgu.pA(this.YkC, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.rtW.top, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), this.rtW.bottom);
            }
        }
        TextView textView2 = this.fJy;
        if (textView2 != null) {
            this.slz = textView2.getTextSize();
            this.fJy.setTextSize(2, 14.0f);
            ColorStateList textColors2 = this.fJy.getTextColors();
            this.Uz = textColors2;
            if (textColors2 != null) {
                this.fJy.setTextColor(-1);
            }
            this.uQ = this.fJy.getAlpha();
            this.fJy.setAlpha(0.85f);
            this.fJy.setShadowLayer(0.0f, Vgu.KZx(this.du, 0.5f), Vgu.KZx(this.du, 0.5f), com.bytedance.sdk.component.utils.yFO.SD(this.du, "tt_b2000000"));
            ViewGroup.LayoutParams layoutParams2 = this.fJy.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                this.jO.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                Vgu.pA(this.fJy, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), this.jO.top, this.jO.right, this.jO.bottom);
            }
        }
        ImageView imageView = this.dC;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                this.FGT.set(marginLayoutParams3.leftMargin, marginLayoutParams3.topMargin, marginLayoutParams3.rightMargin, marginLayoutParams3.bottomMargin);
                Vgu.pA(this.dC, this.FGT.left, this.FGT.top, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.FGT.bottom);
            }
        }
        ImageView imageView2 = this.dC;
        if (imageView2 != null) {
            imageView2.setImageDrawable(com.bytedance.sdk.component.utils.yFO.KZx(this.du, "tt_shrink_fullscreen"));
        }
        TextView textView3 = this.FQ;
        if (textView3 != null) {
            ColorStateList textColors3 = textView3.getTextColors();
            this.bU = textColors3;
            if (textColors3 != null) {
                this.FQ.setTextColor(-1);
            }
            this.Wo = this.FQ.getAlpha();
            this.FQ.setAlpha(0.85f);
            ViewGroup.LayoutParams layoutParams4 = this.FQ.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                this.Itl.set(marginLayoutParams4.leftMargin, marginLayoutParams4.topMargin, marginLayoutParams4.rightMargin, marginLayoutParams4.bottomMargin);
                Vgu.pA(this.FQ, (int) TypedValue.applyDimension(1, 1.0f, displayMetrics), this.jO.top, this.jO.right, this.jO.bottom);
            }
        }
        View view = this.CIG;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
            this.tM = layoutParams5.height;
            layoutParams5.height = (int) TypedValue.applyDimension(1, 49.0f, displayMetrics);
            this.CIG.setLayoutParams(layoutParams5);
            this.CIG.setBackgroundResource(com.bytedance.sdk.component.utils.yFO.ZZv(this.du, "tt_shadow_fullscreen_top"));
        }
        Og(false, true);
    }

    private void du() {
        TextView textView = this.YkC;
        if (textView != null) {
            textView.setTextSize(0, this.sk);
            ColorStateList colorStateList = this.tZW;
            if (colorStateList != null) {
                this.YkC.setTextColor(colorStateList);
            }
            this.YkC.setAlpha(this.Ld);
            this.YkC.setShadowLayer(Vgu.KZx(this.du, 1.0f), 0.0f, 0.0f, com.bytedance.sdk.component.utils.yFO.SD(this.du, "tt_72000000"));
            Vgu.pA(this.YkC, this.rtW.left, this.rtW.top, this.rtW.right, this.rtW.bottom);
        }
        TextView textView2 = this.fJy;
        if (textView2 != null) {
            textView2.setTextSize(0, this.slz);
            ColorStateList colorStateList2 = this.Uz;
            if (colorStateList2 != null) {
                this.fJy.setTextColor(colorStateList2);
            }
            this.fJy.setAlpha(this.uQ);
            this.fJy.setShadowLayer(Vgu.KZx(this.du, 1.0f), 0.0f, 0.0f, com.bytedance.sdk.component.utils.yFO.SD(this.du, "tt_72000000"));
            Vgu.pA(this.fJy, this.jO.left, this.jO.top, this.jO.right, this.jO.bottom);
        }
        ImageView imageView = this.dC;
        if (imageView != null) {
            Vgu.pA(imageView, this.FGT.left, this.FGT.top, this.FGT.right, this.FGT.bottom);
        }
        ImageView imageView2 = this.dC;
        if (imageView2 != null) {
            imageView2.setImageDrawable(com.bytedance.sdk.component.utils.yFO.KZx(this.du, "tt_enlarge_video"));
        }
        TextView textView3 = this.FQ;
        if (textView3 != null) {
            ColorStateList colorStateList3 = this.bU;
            if (colorStateList3 != null) {
                textView3.setTextColor(colorStateList3);
            }
            this.FQ.setAlpha(this.Wo);
            Vgu.pA(this.FQ, this.jO.left, this.jO.top, this.jO.right, this.jO.bottom);
        }
        View view = this.CIG;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = this.tM;
            this.CIG.setLayoutParams(layoutParams);
            this.CIG.setBackground(Bzk.pA(this.du, "tt_video_black_desc_gradient"));
        }
        Og(false, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.ML, com.bytedance.sdk.component.utils.TV.pA
    public void pA(Message message) {
        if (message.what != 1) {
            return;
        }
        BSW();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.ML
    public void pA(boolean z, boolean z2, boolean z3) {
        Vgu.pA(this.fN, 0);
        if (this.vA) {
            Vgu.pA(this.CIG, 0);
            Vgu.pA((View) this.FQ, 0);
        } else if (z3) {
            Vgu.pA(this.CIG, 8);
        }
        Vgu.pA((View) this.ML, (!z || this.JG.getVisibility() == 0) ? 8 : 0);
        if (!this.Sd && !this.vA) {
            if ((this.WQf & 1) != 1 && !z3) {
                Vgu.pA((View) this.Vgu, 0);
            }
            Vgu.pA((View) this.gbA, z3 ? 8 : 0);
        }
        Vgu.pA((View) this.fJy, 0);
        Vgu.pA((View) this.YkC, 0);
        Vgu.pA((View) this.dmv, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.ML
    public void pA(boolean z, boolean z2) {
        Vgu.pA(this.fN, 8);
        Vgu.pA(this.CIG, 8);
        Vgu.pA((View) this.ML, 8);
        if (!this.Sd && !this.vA) {
            Vgu.pA((View) this.Vgu, 8);
            if ((this.WQf & 2) != 2) {
                Vgu.pA((View) this.gbA, 8);
            }
        } else if ((this.WQf & 1) == 1) {
            Vgu.pA((View) this.Vgu, 8);
        }
        if (z2) {
            Vgu.pA((View) this.Vgu, 8);
            Vgu.pA((View) this.gbA, 8);
        }
        KZx(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.ML, com.bytedance.sdk.openadsdk.core.widget.yFO.Og
    public void BSW() {
        pA(true, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.ML
    public boolean Og(int i) {
        SeekBar seekBar = this.dmv;
        return seekBar != null && i > seekBar.getSecondaryProgress();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.ML
    public void KZx(boolean z) {
        TextView textView;
        TextView textView2;
        int i;
        if (this.SzT != null) {
            if (this.Sd) {
                textView2 = this.SzT;
            } else {
                textView = this.SzT;
                if (z) {
                    i = 0;
                } else {
                    textView2 = textView;
                }
                Vgu.pA((View) textView, i);
            }
            textView = textView2;
            i = 8;
            Vgu.pA((View) textView, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.ML, com.bytedance.sdk.openadsdk.core.widget.XT.pA
    public void pA(View view, boolean z) {
        if (SGo()) {
            String str = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
            if (this.TV != null && !TextUtils.isEmpty(this.TV.SXO())) {
                pA(this.TV.SXO());
            }
            this.Gx.setText(str);
        } else {
            pA("");
            this.Gx.setText("");
        }
        if (this.Mc) {
            return;
        }
        KZx(this.Sd && !this.vA);
        if (oX()) {
            this.roi.pA(this, view, true, this.JG.getVisibility() != 0);
        }
    }
}
