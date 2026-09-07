package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
public class SD extends View implements com.bytedance.sdk.component.utils.TV.pA {
    private ViewTreeObserver.OnGlobalLayoutListener BSW;
    private final Handler Bzk;
    private List<View> JG;
    private pA KZx;
    private List<View> ML;
    private boolean Og;
    private boolean SD;
    private final AtomicBoolean SGo;
    private boolean WV;
    private final Runnable Wx;
    private View ZZv;
    private int omh;
    private boolean pA;

    public interface pA {
        void Og();

        void pA();

        void pA(View view);

        void pA(boolean z);
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public SD(Context context, View view) {
        super(aBv.pA());
        this.Bzk = new com.bytedance.sdk.component.utils.TV(Sn.Og().getLooper(), this);
        this.SGo = new AtomicBoolean(true);
        this.WV = false;
        this.Wx = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.SD.3
            @Override // java.lang.Runnable
            public void run() {
                if (SD.this.KZx != null) {
                    SD.this.KZx.pA(SD.this.ZZv);
                }
            }
        };
        this.ZZv = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        this.BSW = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.SD.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (SD.this.WV) {
                    return;
                }
                SD.this.ML();
                SD.this.ZZv();
            }
        };
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        pA pAVar = this.KZx;
        if (pAVar != null) {
            pAVar.pA(z);
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.SD = false;
        Og();
        if (this.BSW != null) {
            getViewTreeObserver().addOnGlobalLayoutListener(this.BSW);
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        Og();
    }

    private void Og() {
        pA pAVar;
        if (!this.SGo.getAndSet(false) || (pAVar = this.KZx) == null) {
            return;
        }
        pAVar.pA();
    }

    private void KZx() {
        pA pAVar;
        if (this.SGo.getAndSet(true) || (pAVar = this.KZx) == null) {
            return;
        }
        pAVar.Og();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ML();
        this.SD = true;
        KZx();
        pA(false);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        KZx();
    }

    public void setRefClickViews(List<View> list) {
        this.ML = list;
    }

    public void setRefCreativeViews(List<View> list) {
        this.JG = list;
    }

    public void pA() {
        pA(this.ML, (com.bytedance.sdk.openadsdk.core.Og.KZx) null);
        pA(this.JG, (com.bytedance.sdk.openadsdk.core.Og.KZx) null);
    }

    public void pA(List<View> list, com.bytedance.sdk.openadsdk.core.Og.KZx kZx) {
        if (com.bytedance.sdk.component.utils.SGo.Og(list)) {
            for (View view : list) {
                if (view != null) {
                    view.setOnClickListener(kZx);
                    view.setOnTouchListener(kZx);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZZv() {
        if (!this.Og || this.pA) {
            return;
        }
        this.pA = true;
        this.Bzk.sendEmptyMessage(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ML() {
        if (this.pA) {
            this.Bzk.removeCallbacksAndMessages(null);
            this.pA = false;
        }
    }

    public void setNeedCheckingShow(boolean z) {
        this.Og = z;
        if (!z && this.pA) {
            ML();
        } else {
            if (!z || this.pA) {
                return;
            }
            ZZv();
        }
    }

    public void setCallback(pA pAVar) {
        this.KZx = pAVar;
    }

    public void setAdType(int i) {
        this.omh = i;
    }

    @Override // com.bytedance.sdk.component.utils.TV.pA
    public void pA(Message message) {
        if (message.what == 1 && this.pA) {
            if (JG() && lT.pA(this.ZZv, 20, this.omh)) {
                ML();
                this.WV = true;
                Sn.KZx().post(this.Wx);
                pA(true);
                return;
            }
            this.Bzk.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    private boolean JG() {
        View view = this.ZZv;
        if (view instanceof com.bytedance.sdk.openadsdk.core.omh.yFO) {
            return ((com.bytedance.sdk.openadsdk.core.omh.yFO) view).DX();
        }
        return true;
    }

    private void pA(final boolean z) {
        final ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        com.bytedance.sdk.component.utils.SD.Og().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.SD.2
            @Override // java.lang.Runnable
            public void run() {
                ViewTreeObserver viewTreeObserver2;
                if (SD.this.BSW != null && (viewTreeObserver2 = viewTreeObserver) != null) {
                    try {
                        viewTreeObserver2.removeOnGlobalLayoutListener(SD.this.BSW);
                    } catch (Exception unused) {
                    }
                }
                if (z) {
                    SD.this.BSW = null;
                }
            }
        });
    }
}
