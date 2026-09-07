package com.bytedance.adsdk.ugeno.JG;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.adjust.sdk.Constants;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: loaded from: classes10.dex */
public abstract class pA<T> extends FrameLayout implements com.bytedance.adsdk.ugeno.omh.KZx.ZZv {
    private boolean BSW;
    private float Bzk;
    private int DX;
    private int JG;
    private int KZx;
    private int ML;
    protected com.bytedance.adsdk.ugeno.omh.KZx Og;
    private int SD;
    private boolean SGo;
    private final Runnable Sd;
    private int Sn;
    private boolean WV;
    private boolean Wx;
    private C0172pA XT;
    private int ZZv;
    private com.bytedance.adsdk.ugeno.JG.pA.pA aBv;
    private int oX;
    private String omh;
    protected List<T> pA;
    private final Runnable vZF;
    private KZx yFO;

    public abstract View SD(int i);

    public pA(Context context) {
        super(context);
        this.pA = new CopyOnWriteArrayList();
        this.KZx = 2000;
        this.ZZv = 500;
        this.ML = 10;
        this.JG = -1;
        this.SD = -1;
        this.omh = Constants.NORMAL;
        this.Bzk = 1.0f;
        this.SGo = true;
        this.BSW = true;
        this.WV = true;
        this.Wx = true;
        this.Sn = 0;
        this.DX = 0;
        this.oX = 0;
        this.vZF = new Runnable() { // from class: com.bytedance.adsdk.ugeno.JG.pA.1
            @Override // java.lang.Runnable
            public void run() {
                int currentItem = pA.this.Og.getCurrentItem() + 1;
                if (pA.this.WV) {
                    if (currentItem >= Integer.MAX_VALUE) {
                        pA.this.Og.pA(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, false);
                        return;
                    } else {
                        pA.this.Og.pA(currentItem, true);
                        return;
                    }
                }
                if (currentItem >= pA.this.Og.getAdapter().pA()) {
                    pA.this.Og.pA(0, false);
                } else {
                    pA.this.Og.pA(currentItem, true);
                }
            }
        };
        this.Sd = new Runnable() { // from class: com.bytedance.adsdk.ugeno.JG.pA.2
            @Override // java.lang.Runnable
            public void run() {
                if (pA.this.BSW) {
                    int currentItem = pA.this.Og.getCurrentItem() + 1;
                    if (pA.this.WV) {
                        if (currentItem >= Integer.MAX_VALUE) {
                            pA.this.Og.pA(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, false);
                        } else {
                            pA.this.Og.pA(currentItem, true);
                        }
                        pA pAVar = pA.this;
                        pAVar.postDelayed(pAVar.Sd, pA.this.KZx);
                        return;
                    }
                    if (currentItem >= pA.this.Og.getAdapter().pA()) {
                        pA.this.Og.pA(0, false);
                        pA pAVar2 = pA.this;
                        pAVar2.postDelayed(pAVar2.Sd, pA.this.KZx);
                    } else {
                        pA.this.Og.pA(currentItem, true);
                        pA pAVar3 = pA.this;
                        pAVar3.postDelayed(pAVar3.Sd, pA.this.KZx);
                    }
                }
            }
        };
        this.Og = new Og(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(this.Og, layoutParams);
        com.bytedance.adsdk.ugeno.JG.pA.pA pAVar = new com.bytedance.adsdk.ugeno.JG.pA.pA(context);
        this.aBv = pAVar;
        addView(pAVar);
    }

    public pA pA(boolean z) {
        this.BSW = z;
        Og();
        return this;
    }

    public pA pA(int i) {
        this.KZx = i;
        Og();
        return this;
    }

    public pA Og(boolean z) {
        this.SGo = z;
        return this;
    }

    public pA Og(int i) {
        this.aBv.setSelectedColor(i);
        return this;
    }

    public pA KZx(int i) {
        this.aBv.setUnSelectedColor(i);
        return this;
    }

    public pA KZx(boolean z) {
        this.aBv.setLoop(z);
        if (this.WV != z) {
            int iPA = ZZv.pA(z, this.Og.getCurrentItem(), this.pA.size());
            this.WV = z;
            C0172pA c0172pA = this.XT;
            if (c0172pA != null) {
                c0172pA.KZx();
                this.Og.setCurrentItem(iPA);
            }
        }
        return this;
    }

    public pA pA(float f) {
        this.Bzk = f;
        return this;
    }

    public pA pA(String str) {
        this.omh = str;
        pA(str, this.ML, this.JG, this.SD, true);
        return this;
    }

    public pA ZZv(int i) {
        this.ML = i;
        pA(this.omh, i, this.JG, this.SD, true);
        return this;
    }

    public pA ML(int i) {
        this.JG = i;
        pA(this.omh, this.ML, i, this.SD, true);
        return this;
    }

    public pA JG(int i) {
        this.SD = i;
        pA(this.omh, this.ML, this.JG, i, true);
        return this;
    }

    public void pA(String str, int i, int i2, int i3, boolean z) {
        C0172pA c0172pA = this.XT;
        if (c0172pA != null) {
            c0172pA.KZx();
        }
        setClipChildren(false);
        this.Og.setClipChildren(false);
        this.Og.setPageMargin(i);
        ViewGroup.LayoutParams layoutParams = this.Og.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = i2 + i;
            marginLayoutParams.rightMargin = i3 + i;
            this.Og.setLayoutParams(layoutParams);
        }
        if (TextUtils.equals(str, "linear")) {
            this.Og.pA(false, (com.bytedance.adsdk.ugeno.omh.KZx.ML) new com.bytedance.adsdk.ugeno.JG.Og.pA());
        } else {
            this.Og.pA(false, (com.bytedance.adsdk.ugeno.omh.KZx.ML) null);
        }
        this.Og.setOffscreenPageLimit((int) this.Bzk);
    }

    public void pA() {
        int i;
        pA(this.omh, this.ML, this.JG, this.SD, true);
        if (this.XT == null) {
            this.XT = new C0172pA();
            this.Og.pA((com.bytedance.adsdk.ugeno.omh.KZx.ZZv) this);
            this.Og.setAdapter(this.XT);
        }
        int i2 = this.Sn;
        if (i2 < 0 || i2 >= this.pA.size()) {
            this.Sn = 0;
        }
        if (this.WV) {
            i = this.Sn + LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        } else {
            i = this.Sn;
        }
        this.Og.pA(i, true);
        if (!this.WV) {
            omh(i);
        }
        if (this.BSW) {
            Og();
        }
    }

    public View pA(int i, int i2) {
        if (this.pA.size() == 0) {
            return new View(getContext());
        }
        View viewSD = SD(i2);
        FrameLayout frameLayout = new FrameLayout(getContext());
        if (viewSD instanceof ViewGroup) {
            frameLayout.setClipChildren(true);
        }
        if (viewSD.getParent() instanceof ViewGroup) {
            ((ViewGroup) viewSD.getParent()).removeView(viewSD);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout.addView(viewSD, layoutParams);
        frameLayout.addView(new View(getContext()), new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    public pA<T> pA(T t) {
        if (t != null) {
            this.pA.add(t);
            if (this.SGo) {
                this.aBv.Og();
            }
        }
        C0172pA c0172pA = this.XT;
        if (c0172pA != null) {
            c0172pA.KZx();
            this.aBv.pA(this.Sn, this.Og.getCurrentItem());
        }
        return this;
    }

    @Override // com.bytedance.adsdk.ugeno.omh.KZx.ZZv
    public void pA(int i, float f, int i2) {
        if (this.yFO != null) {
            ZZv.pA(this.WV, i, this.pA.size());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.omh.KZx.ZZv
    public void omh(int i) {
        if (this.yFO != null) {
            int iPA = ZZv.pA(this.WV, i, this.pA.size());
            this.yFO.pA(this.WV, iPA, i, iPA == 0, iPA == this.pA.size() - 1);
        }
        if (this.SGo) {
            this.aBv.pA(i);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.JG.pA$pA, reason: collision with other inner class name */
    class C0172pA extends com.bytedance.adsdk.ugeno.omh.Og {
        @Override // com.bytedance.adsdk.ugeno.omh.Og
        public int pA(Object obj) {
            return -2;
        }

        @Override // com.bytedance.adsdk.ugeno.omh.Og
        public boolean pA(View view, Object obj) {
            return view == obj;
        }

        C0172pA() {
        }

        @Override // com.bytedance.adsdk.ugeno.omh.Og
        public int pA() {
            if (pA.this.WV) {
                return Integer.MAX_VALUE;
            }
            return pA.this.pA.size();
        }

        @Override // com.bytedance.adsdk.ugeno.omh.Og
        public Object pA(ViewGroup viewGroup, int i) {
            View viewPA = pA.this.pA(i, ZZv.pA(pA.this.WV, i, pA.this.pA.size()));
            viewGroup.addView(viewPA);
            return viewPA;
        }

        @Override // com.bytedance.adsdk.ugeno.omh.Og
        public void pA(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // com.bytedance.adsdk.ugeno.omh.Og
        public float pA(int i) {
            if (pA.this.Bzk <= 0.0f) {
                return 1.0f;
            }
            return 1.0f / pA.this.Bzk;
        }
    }

    public void Og() {
        removeCallbacks(this.Sd);
        postDelayed(this.Sd, this.KZx);
    }

    public void KZx() {
        removeCallbacks(this.Sd);
    }

    public void Bzk(int i) {
        pA(this.omh, this.ML, this.JG, this.SD, true);
        if (this.XT == null) {
            this.XT = new C0172pA();
            this.Og.pA((com.bytedance.adsdk.ugeno.omh.KZx.ZZv) this);
            this.Og.setAdapter(this.XT);
        }
        if (this.WV) {
            if (i >= Integer.MAX_VALUE) {
                this.Og.pA(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, false);
                return;
            } else {
                this.Og.pA(i, true);
                return;
            }
        }
        if (i < 0 || i >= this.pA.size()) {
            return;
        }
        this.Og.pA(i, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.BSW) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 3 || action == 4) {
                Og();
            } else if (action == 0) {
                KZx();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getCurrentItem() {
        return this.Og.getCurrentItem();
    }

    public com.bytedance.adsdk.ugeno.omh.Og getAdapter() {
        return this.Og.getAdapter();
    }

    public com.bytedance.adsdk.ugeno.omh.KZx getViewPager() {
        return this.Og;
    }

    public void setOnPageChangeListener(KZx kZx) {
        this.yFO = kZx;
    }

    class Og extends com.bytedance.adsdk.ugeno.omh.KZx {
        public Og(Context context) {
            super(context);
        }

        @Override // com.bytedance.adsdk.ugeno.omh.KZx, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (!pA.this.Wx) {
                return false;
            }
            try {
                return super.onInterceptTouchEvent(motionEvent);
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.omh.KZx, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!pA.this.Wx) {
                return false;
            }
            try {
                return super.onTouchEvent(motionEvent);
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }
    }
}
