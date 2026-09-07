package com.bytedance.sdk.component.adexpress.dynamic.KZx;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.JG.eG;
import com.google.common.base.Ascii;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;
import net.pubnative.lite.sdk.models.Protocol;

/* JADX INFO: loaded from: classes3.dex */
public class Bzk extends FrameLayout implements omh {
    private com.bytedance.sdk.component.adexpress.dynamic.ZZv.SGo BSW;
    private int Bzk;
    private String JG;
    private com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD KZx;
    private SD ML;
    private com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML Og;
    private com.bytedance.sdk.component.adexpress.JG.XT SD;
    private boolean SGo;
    private com.bytedance.sdk.component.adexpress.Og.Wx WV;
    private View ZZv;
    private View.OnTouchListener omh;
    private Context pA;

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public Bzk(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML ml, com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD sd) {
        super(context);
        this.pA = context;
        this.Og = ml;
        this.KZx = sd;
        SD();
    }

    public Bzk(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML ml, com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD sd, com.bytedance.sdk.component.adexpress.dynamic.ZZv.SGo sGo, com.bytedance.sdk.component.adexpress.Og.Wx wx) {
        super(context);
        this.pA = context;
        this.Og = ml;
        this.KZx = sd;
        this.BSW = sGo;
        this.WV = wx;
        SD();
    }

    private void SD() {
        setBackgroundColor(0);
        setClipChildren(false);
        setClipToPadding(false);
        this.JG = this.KZx.Gx();
        this.Bzk = this.KZx.JBA();
        this.SGo = this.KZx.vA();
        SD sdPA = SGo.pA(this.pA, this.Og, this.KZx, this.BSW, this.WV);
        this.ML = sdPA;
        if (sdPA != null) {
            this.ZZv = sdPA.KZx();
            if (this.KZx.Bf()) {
                setBackgroundColor(Color.parseColor("#50000000"));
            }
            if (TextUtils.equals(this.JG, "6")) {
                if (this.KZx.PV() && !TextUtils.isEmpty(this.KZx.cFQ())) {
                    this.SD = new com.bytedance.sdk.component.adexpress.JG.XT(this.pA, com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD.pA(this.KZx.cFQ()));
                } else {
                    this.SD = new com.bytedance.sdk.component.adexpress.JG.XT(this.pA, Color.parseColor("#99000000"));
                }
                FrameLayout frameLayout = new FrameLayout(this.pA);
                frameLayout.addView(this.SD, new FrameLayout.LayoutParams(-1, -1));
                frameLayout.setClipChildren(true);
                addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
                post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.KZx.Bzk.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Bzk.this.SD.Og();
                    }
                });
            }
            if (pA(this.JG) && com.bytedance.sdk.component.adexpress.ZZv.Og()) {
                int color = Color.parseColor("#99000000");
                if (this.KZx.PV() && !TextUtils.isEmpty(this.KZx.cFQ())) {
                    try {
                        color = com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD.pA(this.KZx.cFQ());
                    } catch (Exception unused) {
                    }
                }
                View view = new View(this.pA);
                view.setBackgroundColor(color);
                addView(view, new FrameLayout.LayoutParams(-1, -1));
            }
            addView(this.ML.KZx());
            pA(this.ML.KZx());
            setVisibility(0);
        }
    }

    private boolean pA(String str) {
        return TextUtils.equals(str, "24") || TextUtils.equals(str, "23") || TextUtils.equals(str, "25") || TextUtils.equals(str, "22") || TextUtils.equals(str, "1");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.omh instanceof com.bytedance.sdk.component.adexpress.dynamic.KZx.pA.KZx) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void pA(ViewGroup viewGroup) {
        if (this.ZZv == null) {
            return;
        }
        String str = this.JG;
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    b = 0;
                }
                break;
            case 49:
                if (str.equals("1")) {
                    b = 1;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    b = 2;
                }
                break;
            case 53:
                if (str.equals("5")) {
                    b = 3;
                }
                break;
            case 54:
                if (str.equals("6")) {
                    b = 4;
                }
                break;
            case 55:
                if (str.equals("7")) {
                    b = 5;
                }
                break;
            case 56:
                if (str.equals("8")) {
                    b = 6;
                }
                break;
            case 57:
                if (str.equals("9")) {
                    b = 7;
                }
                break;
            case 1567:
                if (str.equals("10")) {
                    b = 8;
                }
                break;
            case 1568:
                if (str.equals(Protocol.VAST_4_1)) {
                    b = 9;
                }
                break;
            case 1569:
                if (str.equals(Protocol.VAST_4_1_WRAPPER)) {
                    b = 10;
                }
                break;
            case 1570:
                if (str.equals(Protocol.VAST_4_2)) {
                    b = Ascii.VT;
                }
                break;
            case 1571:
                if (str.equals(Protocol.VAST_4_2_WRAPPER)) {
                    b = Ascii.FF;
                }
                break;
            case 1573:
                if (str.equals("16")) {
                    b = Ascii.CR;
                }
                break;
            case 1574:
                if (str.equals("17")) {
                    b = Ascii.SO;
                }
                break;
            case 1575:
                if (str.equals("18")) {
                    b = Ascii.SI;
                }
                break;
            case 1598:
                if (str.equals("20")) {
                    b = Ascii.DLE;
                }
                break;
            case IronSourceConstants.RV_OPERATIONAL_LOAD_AD /* 1600 */:
                if (str.equals("22")) {
                    b = 17;
                }
                break;
            case IronSourceConstants.RV_OPERATIONAL_LOAD_SUCCESS /* 1601 */:
                if (str.equals("23")) {
                    b = Ascii.DC2;
                }
                break;
            case IronSourceConstants.RV_OPERATIONAL_LOAD_FAILED /* 1602 */:
                if (str.equals("24")) {
                    b = 19;
                }
                break;
            case 1603:
                if (str.equals("25")) {
                    b = Ascii.DC4;
                }
                break;
            case 1607:
                if (str.equals("29")) {
                    b = Ascii.NAK;
                }
                break;
        }
        switch (b) {
            case 0:
                this.omh = new com.bytedance.sdk.component.adexpress.dynamic.KZx.pA.ML(this, this.Bzk);
                setBackgroundColor(Color.parseColor("#80000000"));
                break;
            case 1:
            case 4:
                if (!this.KZx.PV() || TextUtils.isEmpty(this.KZx.cFQ())) {
                    setBackgroundColor(Color.parseColor("#80000000"));
                }
                this.omh = new com.bytedance.sdk.component.adexpress.dynamic.KZx.pA.JG(this);
                break;
            case 2:
            case 5:
                setBackgroundColor(Color.parseColor("#80000000"));
                this.omh = new com.bytedance.sdk.component.adexpress.dynamic.KZx.pA.Og(this, this);
                break;
            case 3:
                if (this.KZx.PV() && !TextUtils.isEmpty(this.KZx.cFQ())) {
                    setBackgroundColor(com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD.pA(this.KZx.cFQ()));
                } else {
                    setBackgroundColor(Color.parseColor("#80000000"));
                }
                this.omh = new com.bytedance.sdk.component.adexpress.dynamic.KZx.pA.KZx(this);
                this.ZZv.setTag(2);
                break;
            case 6:
            case 9:
                this.Og.setClipChildren(false);
                this.Og.setClipChildren(false);
                ViewGroup viewGroup2 = (ViewGroup) this.Og.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.setClipChildren(false);
                    viewGroup2.setClipToPadding(false);
                }
                this.omh = new com.bytedance.sdk.component.adexpress.dynamic.KZx.pA.JG(this);
                break;
            case 7:
            case 14:
                this.ZZv.setTag(2);
                break;
            case 8:
                this.omh = new com.bytedance.sdk.component.adexpress.dynamic.KZx.pA.ZZv(this, this.Bzk, this.SGo);
                break;
            case 10:
                this.omh = new com.bytedance.sdk.component.adexpress.dynamic.KZx.pA.KZx(this);
                this.ZZv.setTag(2);
                break;
            case 11:
            case 19:
                if (this.JG.equals("24") && com.bytedance.sdk.component.adexpress.ZZv.Og()) {
                    this.Og.setClipChildren(false);
                    this.omh = new com.bytedance.sdk.component.adexpress.dynamic.KZx.pA.JG(this);
                } else {
                    this.omh = new com.bytedance.sdk.component.adexpress.dynamic.KZx.pA.ML(this, this.Bzk);
                }
                break;
            case 12:
                this.omh = new com.bytedance.sdk.component.adexpress.dynamic.KZx.pA.Og(this, this);
                break;
            case 13:
                View view = this.ZZv;
                if (view != null && (view instanceof com.bytedance.sdk.component.adexpress.JG.yFO) && ((com.bytedance.sdk.component.adexpress.JG.yFO) view).getShakeLayout() != null) {
                    ((com.bytedance.sdk.component.adexpress.JG.yFO) this.ZZv).getShakeLayout().setTag(2);
                }
                this.ZZv.setTag(2);
                break;
            case 15:
                View view2 = this.ZZv;
                if (view2 != null && (view2 instanceof eG) && ((eG) view2).getWriggleLayout() != null) {
                    ((eG) this.ZZv).getWriggleLayout().setTag(2);
                }
                this.ZZv.setTag(2);
                break;
            case 16:
                this.omh = new com.bytedance.sdk.component.adexpress.dynamic.KZx.pA.pA(this, this.Bzk, viewGroup);
                break;
            case 17:
                if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
                    this.omh = new com.bytedance.sdk.component.adexpress.dynamic.KZx.pA.omh(this, this.SGo);
                } else {
                    this.omh = new com.bytedance.sdk.component.adexpress.dynamic.KZx.pA.SD(this, this.Bzk, viewGroup);
                }
                break;
            case 18:
                if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
                    this.omh = new com.bytedance.sdk.component.adexpress.dynamic.KZx.pA.JG(this);
                }
                break;
            case 20:
                if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
                    this.omh = new com.bytedance.sdk.component.adexpress.dynamic.KZx.pA.omh(this, this.SGo);
                }
                break;
            case 21:
                View view3 = this.ZZv;
                if (view3 != null && (view3 instanceof com.bytedance.sdk.component.adexpress.JG.JG) && ((com.bytedance.sdk.component.adexpress.JG.JG) view3).getShakeView() != null) {
                    ((com.bytedance.sdk.component.adexpress.JG.JG) this.ZZv).getShakeView().setTag(2);
                }
                this.omh = new com.bytedance.sdk.component.adexpress.dynamic.KZx.pA.ML(this, this.Bzk);
                break;
        }
        View.OnTouchListener onTouchListener = this.omh;
        if (onTouchListener != null) {
            setOnTouchListener(onTouchListener);
        }
        if (omh()) {
            this.ZZv.setTag(2);
            setOnClickListener((View.OnClickListener) this.Og.getDynamicClickListener());
        }
    }

    private boolean omh() {
        return (this.KZx.vA() || TextUtils.equals("9", this.JG) || TextUtils.equals("16", this.JG) || TextUtils.equals("17", this.JG) || TextUtils.equals("18", this.JG) || TextUtils.equals("20", this.JG) || TextUtils.equals("29", this.JG) || TextUtils.equals("10", this.JG)) ? false : true;
    }

    public void KZx() {
        SD sd = this.ML;
        if (sd != null) {
            sd.pA();
        }
    }

    public void ZZv() {
        SD sd = this.ML;
        if (sd != null) {
            sd.Og();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            SD sd = this.ML;
            if (sd != null) {
                sd.Og();
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.WV.Og(e.getMessage());
        }
    }

    public void ML() {
        if (this.ZZv != null && TextUtils.equals(this.JG, "2")) {
            View view = this.ZZv;
            if (view instanceof com.bytedance.sdk.component.adexpress.JG.KZx) {
                ((com.bytedance.sdk.component.adexpress.JG.KZx) view).KZx();
            }
        }
    }

    public void JG() {
        if (this.ZZv != null && TextUtils.equals(this.JG, "2")) {
            View view = this.ZZv;
            if (view instanceof com.bytedance.sdk.component.adexpress.JG.KZx) {
                ((com.bytedance.sdk.component.adexpress.JG.KZx) view).ZZv();
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.KZx.omh
    public void pA() {
        if (TextUtils.equals(this.JG, "6")) {
            com.bytedance.sdk.component.adexpress.JG.XT xt = this.SD;
            if (xt != null) {
                xt.KZx();
                postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.KZx.Bzk.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Bzk.this.Bzk();
                    }
                }, 300L);
                return;
            }
            return;
        }
        if (TextUtils.equals(this.JG, "20")) {
            postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.KZx.Bzk.3
                @Override // java.lang.Runnable
                public void run() {
                    Bzk.this.Bzk();
                }
            }, 400L);
        } else {
            Bzk();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.KZx.omh
    public void Og() {
        if (omh()) {
            setOnClickListener((View.OnClickListener) this.Og.getDynamicClickListener());
            performClick();
            if (this.KZx.Gag()) {
                return;
            }
            setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bzk() {
        if (this.omh != null) {
            setOnClickListener((View.OnClickListener) this.Og.getDynamicClickListener());
            performClick();
            if (this.KZx.Gag()) {
                return;
            }
            setVisibility(8);
        }
    }
}
