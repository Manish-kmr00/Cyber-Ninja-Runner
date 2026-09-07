package com.bytedance.adsdk.ugeno.omh;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class KZx extends ViewGroup {
    private int BF;
    private Parcelable BSW;
    private int Bf;
    private final Rect Bzk;
    private int CIG;
    private JG DX;
    private int FQ;
    private int Gx;
    private int HSv;
    private int IG;
    private List<ZZv> IIF;
    private boolean JBA;
    com.bytedance.adsdk.ugeno.omh.Og KZx;
    private boolean Mc;
    private ZZv PV;
    private final ArrayList<Og> SD;
    private int SGo;
    private int SXO;
    private float Sd;
    private boolean Sn;
    private VelocityTracker SzT;
    private boolean TV;
    private int TX;
    private float Vgu;
    private boolean WQf;
    private ClassLoader WV;
    private int Wo;
    private Scroller Wx;
    private int XT;
    private boolean YkC;
    int ZZv;
    private Drawable aBv;
    private EdgeEffect agB;
    private final Runnable bU;
    private List<Object> cFQ;
    private int dC;
    private boolean dmv;
    private boolean du;
    private int eG;
    private boolean fJy;
    private EdgeEffect fN;
    private int fw;
    private float gbA;
    private ArrayList<View> gy;
    private int lT;
    private ML lx;
    private int oX;
    private final Og omh;
    private int pA;
    private float qmB;
    private int rB;
    private boolean roi;
    private ZZv vA;
    private float vZF;
    private float xy;
    private int yFO;
    static final int[] Og = {R.attr.layout_gravity};
    private static final Comparator<Og> ML = new Comparator<Og>() { // from class: com.bytedance.adsdk.ugeno.omh.KZx.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
        public int compare(Og og, Og og2) {
            return og.Og - og2.Og;
        }
    };
    private static final Interpolator JG = new Interpolator() { // from class: com.bytedance.adsdk.ugeno.omh.KZx.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    private static final omh nCO = new omh();

    public interface ML {
        void pA(View view, float f);
    }

    public interface ZZv {
        void omh(int i);

        void pA(int i, float f, int i2);
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface pA {
    }

    static class Og {
        boolean KZx;
        float ML;
        int Og;
        float ZZv;
        Object pA;

        Og() {
        }
    }

    public KZx(Context context) {
        super(context);
        this.SD = new ArrayList<>();
        this.omh = new Og();
        this.Bzk = new Rect();
        this.SGo = -1;
        this.BSW = null;
        this.WV = null;
        this.vZF = -3.4028235E38f;
        this.Sd = Float.MAX_VALUE;
        this.eG = 1;
        this.CIG = -1;
        this.dmv = true;
        this.fJy = false;
        this.bU = new Runnable() { // from class: com.bytedance.adsdk.ugeno.omh.KZx.3
            @Override // java.lang.Runnable
            public void run() {
                KZx.this.setScrollState(0);
                KZx.this.KZx();
            }
        };
        this.Wo = 0;
        pA();
    }

    void pA() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.Wx = new Scroller(context, JG);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.rB = viewConfiguration.getScaledPagingTouchSlop();
        this.FQ = (int) (400.0f * f);
        this.Gx = viewConfiguration.getScaledMaximumFlingVelocity();
        this.agB = new EdgeEffect(context);
        this.fN = new EdgeEffect(context);
        this.Bf = (int) (25.0f * f);
        this.HSv = (int) (2.0f * f);
        this.IG = (int) (f * 16.0f);
    }

    public void setScroller(Scroller scroller) {
        this.Wx = scroller;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.bU);
        Scroller scroller = this.Wx;
        if (scroller != null && !scroller.isFinished()) {
            this.Wx.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    void setScrollState(int i) {
        if (this.Wo == i) {
            return;
        }
        this.Wo = i;
        if (this.lx != null) {
            Og(i != 0);
        }
        JG(i);
    }

    public void setAdapter(com.bytedance.adsdk.ugeno.omh.Og og) {
        com.bytedance.adsdk.ugeno.omh.Og og2 = this.KZx;
        if (og2 != null) {
            og2.pA((DataSetObserver) null);
            for (int i = 0; i < this.SD.size(); i++) {
                Og og3 = this.SD.get(i);
                this.KZx.pA((ViewGroup) this, og3.Og, og3.pA);
            }
            this.SD.clear();
            JG();
            this.ZZv = 0;
            scrollTo(0, 0);
        }
        this.KZx = og;
        this.pA = 0;
        if (og != null) {
            if (this.DX == null) {
                this.DX = new JG();
            }
            this.KZx.pA((DataSetObserver) this.DX);
            this.du = false;
            boolean z = this.dmv;
            this.dmv = true;
            this.pA = this.KZx.pA();
            int i2 = this.SGo;
            if (i2 >= 0) {
                pA(i2, false, true);
                this.SGo = -1;
                this.BSW = null;
                this.WV = null;
            } else if (!z) {
                KZx();
            } else {
                requestLayout();
            }
        }
        List<Object> list = this.cFQ;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.cFQ.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.cFQ.get(i3);
        }
    }

    private void JG() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((C0180KZx) getChildAt(i).getLayoutParams()).pA) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    public com.bytedance.adsdk.ugeno.omh.Og getAdapter() {
        return this.KZx;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) {
        this.du = false;
        pA(i, !this.dmv, false);
    }

    public void pA(int i, boolean z) {
        this.du = false;
        pA(i, z, false);
    }

    public int getCurrentItem() {
        return this.ZZv;
    }

    void pA(int i, boolean z, boolean z2) {
        pA(i, z, z2, 0);
    }

    void pA(int i, boolean z, boolean z2, int i2) {
        com.bytedance.adsdk.ugeno.omh.Og og = this.KZx;
        if (og == null || og.pA() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z2 && this.ZZv == i && this.SD.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i < 0) {
            i = 0;
        } else if (i >= this.KZx.pA()) {
            i = this.KZx.pA() - 1;
        }
        int i3 = this.eG;
        int i4 = this.ZZv;
        if (i > i4 + i3 || i < i4 - i3) {
            for (int i5 = 0; i5 < this.SD.size(); i5++) {
                this.SD.get(i5).KZx = true;
            }
        }
        boolean z3 = this.ZZv != i;
        if (this.dmv) {
            this.ZZv = i;
            if (z3) {
                ML(i);
            }
            requestLayout();
            return;
        }
        pA(i);
        pA(i, z, i2, z3);
    }

    private void pA(int i, boolean z, int i2, boolean z2) {
        Og Og2 = Og(i);
        int clientWidth = Og2 != null ? (int) (getClientWidth() * Math.max(this.vZF, Math.min(Og2.ML, this.Sd))) : 0;
        if (z) {
            pA(clientWidth, 0, i2);
            if (z2) {
                ML(i);
                return;
            }
            return;
        }
        if (z2) {
            ML(i);
        }
        pA(false);
        scrollTo(clientWidth, 0);
        ZZv(clientWidth);
    }

    @Deprecated
    public void setOnPageChangeListener(ZZv zZv) {
        this.vA = zZv;
    }

    public void pA(ZZv zZv) {
        if (this.IIF == null) {
            this.IIF = new ArrayList();
        }
        this.IIF.add(zZv);
    }

    public void pA(boolean z, ML ml) {
        pA(z, ml, 2);
    }

    public void pA(boolean z, ML ml, int i) {
        boolean z2 = ml != null;
        boolean z3 = z2 != (this.lx != null);
        this.lx = ml;
        setChildrenDrawingOrderEnabled(z2);
        if (z2) {
            this.fw = z ? 2 : 1;
            this.SXO = i;
        } else {
            this.fw = 0;
        }
        if (z3) {
            KZx();
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        if (this.fw == 2) {
            i2 = (i - 1) - i2;
        }
        return ((C0180KZx) this.gy.get(i2).getLayoutParams()).JG;
    }

    public int getOffscreenPageLimit() {
        return this.eG;
    }

    public void setOffscreenPageLimit(int i) {
        if (i <= 0) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.eG) {
            this.eG = i;
            KZx();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.oX;
        this.oX = i;
        int width = getWidth();
        pA(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.oX;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.aBv = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.aBv;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.aBv;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    float pA(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    void pA(int i, int i2, int i3) {
        int scrollX;
        int iAbs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.Wx;
        if (scroller != null && !scroller.isFinished()) {
            scrollX = this.Sn ? this.Wx.getCurrX() : this.Wx.getStartX();
            this.Wx.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i4 = scrollX;
        int scrollY = getScrollY();
        int i5 = i - i4;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            pA(false);
            KZx();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i7 = clientWidth / 2;
        float f = clientWidth;
        float f2 = i7;
        float fPA = f2 + (pA(Math.min(1.0f, (Math.abs(i5) * 1.0f) / f)) * f2);
        int iAbs2 = Math.abs(i3);
        if (iAbs2 > 0) {
            iAbs = Math.round(Math.abs(fPA / iAbs2) * 1000.0f) * 4;
        } else {
            iAbs = (int) (((Math.abs(i5) / ((f * this.KZx.pA(this.ZZv)) + this.oX)) + 1.0f) * 100.0f);
        }
        int iMin = Math.min(iAbs, 600);
        this.Sn = false;
        this.Wx.startScroll(i4, scrollY, i5, i6, iMin);
        postInvalidateOnAnimation();
    }

    Og pA(int i, int i2) {
        Og og = new Og();
        og.Og = i;
        og.pA = this.KZx.pA((ViewGroup) this, i);
        og.ZZv = this.KZx.pA(i);
        if (i2 < 0 || i2 >= this.SD.size()) {
            this.SD.add(og);
        } else {
            this.SD.add(i2, og);
        }
        return og;
    }

    void Og() {
        int iPA = this.KZx.pA();
        this.pA = iPA;
        boolean z = this.SD.size() < (this.eG * 2) + 1 && this.SD.size() < iPA;
        int iMax = this.ZZv;
        int i = 0;
        while (i < this.SD.size()) {
            Og og = this.SD.get(i);
            int iPA2 = this.KZx.pA(og.pA);
            if (iPA2 != -1) {
                if (iPA2 == -2) {
                    this.SD.remove(i);
                    i--;
                    this.KZx.pA((ViewGroup) this, og.Og, og.pA);
                    if (this.ZZv == og.Og) {
                        iMax = Math.max(0, Math.min(this.ZZv, iPA - 1));
                    }
                } else if (og.Og != iPA2) {
                    if (og.Og == this.ZZv) {
                        iMax = iPA2;
                    }
                    og.Og = iPA2;
                }
                z = true;
            }
            i++;
        }
        Collections.sort(this.SD, ML);
        if (z) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                C0180KZx c0180KZx = (C0180KZx) getChildAt(i2).getLayoutParams();
                if (!c0180KZx.pA) {
                    c0180KZx.KZx = 0.0f;
                }
            }
            pA(iMax, false, true);
            requestLayout();
        }
    }

    void KZx() {
        pA(this.ZZv);
    }

    /* JADX WARN: Code duplicated, block: B:64:0x00f5 A[PHI: r7 r10 r15
  0x00f5: PHI (r7v6 int) = (r7v5 int), (r7v4 int), (r7v9 int) binds: [B:62:0x00ea, B:59:0x00d4, B:53:0x00be] A[DONT_GENERATE, DONT_INLINE]
  0x00f5: PHI (r10v9 int) = (r10v1 int), (r10v8 int), (r10v12 int) binds: [B:62:0x00ea, B:59:0x00d4, B:53:0x00be] A[DONT_GENERATE, DONT_INLINE]
  0x00f5: PHI (r15v7 float) = (r15v5 float), (r15v6 float), (r15v4 float) binds: [B:62:0x00ea, B:59:0x00d4, B:53:0x00be] A[DONT_GENERATE, DONT_INLINE]] */
    void pA(int i) {
        Og Og2;
        String hexString;
        Og ogPA;
        Og ogPA2;
        Og og;
        int i2 = this.ZZv;
        if (i2 != i) {
            Og2 = Og(i2);
            this.ZZv = i;
        } else {
            Og2 = null;
        }
        if (this.KZx == null) {
            SD();
            return;
        }
        if (this.du) {
            SD();
            return;
        }
        if (getWindowToken() == null) {
            return;
        }
        int i3 = this.eG;
        int iMax = Math.max(0, this.ZZv - i3);
        int iPA = this.KZx.pA();
        int iMin = Math.min(iPA - 1, this.ZZv + i3);
        if (iPA != this.pA) {
            try {
                hexString = getResources().getResourceName(getId());
            } catch (Resources.NotFoundException unused) {
                hexString = Integer.toHexString(getId());
            }
            throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.pA + ", found: " + iPA + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.KZx.getClass());
        }
        int i4 = 0;
        while (true) {
            if (i4 < this.SD.size()) {
                ogPA = this.SD.get(i4);
                if (ogPA.Og >= this.ZZv) {
                    if (ogPA.Og != this.ZZv) {
                        break;
                    } else {
                        break;
                    }
                }
                i4++;
            }
            ogPA = null;
            break;
        }
        if (ogPA == null && iPA > 0) {
            ogPA = pA(this.ZZv, i4);
        }
        if (ogPA != null) {
            int i5 = i4 - 1;
            Og og2 = i5 >= 0 ? this.SD.get(i5) : null;
            int clientWidth = getClientWidth();
            float paddingLeft = clientWidth <= 0 ? 0.0f : (2.0f - ogPA.ZZv) + (getPaddingLeft() / clientWidth);
            float f = 0.0f;
            for (int i6 = this.ZZv - 1; i6 >= 0; i6--) {
                if (f >= paddingLeft && i6 < iMax) {
                    if (og2 == null) {
                        break;
                    }
                    if (i6 == og2.Og && !og2.KZx) {
                        this.SD.remove(i5);
                        this.KZx.pA((ViewGroup) this, i6, og2.pA);
                        i5--;
                        i4--;
                        if (i5 >= 0) {
                            og = this.SD.get(i5);
                        } else {
                            og = null;
                        }
                        og2 = og;
                    }
                } else {
                    if (og2 != null && i6 == og2.Og) {
                        f += og2.ZZv;
                        i5--;
                        if (i5 >= 0) {
                            og = this.SD.get(i5);
                        } else {
                            og = null;
                        }
                    } else {
                        f += pA(i6, i5 + 1).ZZv;
                        i4++;
                        if (i5 >= 0) {
                            og = this.SD.get(i5);
                        } else {
                            og = null;
                        }
                    }
                    og2 = og;
                }
            }
            float f2 = ogPA.ZZv;
            int i7 = i4 + 1;
            if (f2 < 2.0f) {
                Og og3 = i7 < this.SD.size() ? this.SD.get(i7) : null;
                float paddingRight = clientWidth <= 0 ? 0.0f : (getPaddingRight() / clientWidth) + 2.0f;
                int i8 = this.ZZv;
                while (true) {
                    i8++;
                    if (i8 >= iPA) {
                        break;
                    }
                    if (f2 >= paddingRight && i8 > iMin) {
                        if (og3 == null) {
                            break;
                        }
                        if (i8 == og3.Og && !og3.KZx) {
                            this.SD.remove(i7);
                            this.KZx.pA((ViewGroup) this, i8, og3.pA);
                            if (i7 < this.SD.size()) {
                                og3 = this.SD.get(i7);
                            }
                        }
                    } else if (og3 != null && i8 == og3.Og) {
                        f2 += og3.ZZv;
                        i7++;
                        if (i7 < this.SD.size()) {
                            og3 = this.SD.get(i7);
                        }
                    } else {
                        Og ogPA3 = pA(i8, i7);
                        i7++;
                        f2 += ogPA3.ZZv;
                        og3 = i7 < this.SD.size() ? this.SD.get(i7) : null;
                    }
                }
            }
            pA(ogPA, i4, Og2);
        }
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            C0180KZx c0180KZx = (C0180KZx) childAt.getLayoutParams();
            c0180KZx.JG = i9;
            if (!c0180KZx.pA && c0180KZx.KZx == 0.0f && (ogPA2 = pA(childAt)) != null) {
                c0180KZx.KZx = ogPA2.ZZv;
                c0180KZx.ML = ogPA2.Og;
            }
        }
        SD();
        if (hasFocus()) {
            View viewFindFocus = findFocus();
            Og Og3 = viewFindFocus != null ? Og(viewFindFocus) : null;
            if (Og3 == null || Og3.Og != this.ZZv) {
                for (int i10 = 0; i10 < getChildCount(); i10++) {
                    View childAt2 = getChildAt(i10);
                    Og ogPA4 = pA(childAt2);
                    if (ogPA4 != null && ogPA4.Og == this.ZZv && childAt2.requestFocus(2)) {
                        return;
                    }
                }
            }
        }
    }

    private void SD() {
        if (this.fw != 0) {
            ArrayList<View> arrayList = this.gy;
            if (arrayList == null) {
                this.gy = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.gy.add(getChildAt(i));
            }
            Collections.sort(this.gy, nCO);
        }
    }

    private void pA(Og og, int i, Og og2) {
        Og og3;
        Og og4;
        int iPA = this.KZx.pA();
        int clientWidth = getClientWidth();
        float f = clientWidth > 0 ? this.oX / clientWidth : 0.0f;
        if (og2 != null) {
            int i2 = og2.Og;
            if (i2 < og.Og) {
                float fPA = og2.ML + og2.ZZv + f;
                int i3 = i2 + 1;
                int i4 = 0;
                while (i3 <= og.Og && i4 < this.SD.size()) {
                    Og og5 = this.SD.get(i4);
                    while (true) {
                        og4 = og5;
                        if (i3 <= og4.Og || i4 >= this.SD.size() - 1) {
                            break;
                        }
                        i4++;
                        og5 = this.SD.get(i4);
                    }
                    while (i3 < og4.Og) {
                        fPA += this.KZx.pA(i3) + f;
                        i3++;
                    }
                    og4.ML = fPA;
                    fPA += og4.ZZv + f;
                    i3++;
                }
            } else if (i2 > og.Og) {
                int size = this.SD.size() - 1;
                float fPA2 = og2.ML;
                while (true) {
                    i2--;
                    if (i2 < og.Og || size < 0) {
                        break;
                    }
                    Og og6 = this.SD.get(size);
                    while (true) {
                        og3 = og6;
                        if (i2 >= og3.Og || size <= 0) {
                            break;
                        }
                        size--;
                        og6 = this.SD.get(size);
                    }
                    while (i2 > og3.Og) {
                        fPA2 -= this.KZx.pA(i2) + f;
                        i2--;
                    }
                    fPA2 -= og3.ZZv + f;
                    og3.ML = fPA2;
                }
            }
        }
        int size2 = this.SD.size();
        float fPA3 = og.ML;
        int i5 = og.Og - 1;
        this.vZF = og.Og == 0 ? og.ML : -3.4028235E38f;
        int i6 = iPA - 1;
        this.Sd = og.Og == i6 ? (og.ML + og.ZZv) - 1.0f : Float.MAX_VALUE;
        int i7 = i - 1;
        while (i7 >= 0) {
            Og og7 = this.SD.get(i7);
            while (i5 > og7.Og) {
                fPA3 -= this.KZx.pA(i5) + f;
                i5--;
            }
            fPA3 -= og7.ZZv + f;
            og7.ML = fPA3;
            if (og7.Og == 0) {
                this.vZF = fPA3;
            }
            i7--;
            i5--;
        }
        float fPA4 = og.ML + og.ZZv + f;
        int i8 = og.Og + 1;
        int i9 = i + 1;
        while (i9 < size2) {
            Og og8 = this.SD.get(i9);
            while (i8 < og8.Og) {
                fPA4 += this.KZx.pA(i8) + f;
                i8++;
            }
            if (og8.Og == i6) {
                this.Sd = (og8.ZZv + fPA4) - 1.0f;
            }
            og8.ML = fPA4;
            fPA4 += og8.ZZv + f;
            i9++;
            i8++;
        }
        this.fJy = false;
    }

    public static class SD extends com.bytedance.adsdk.ugeno.omh.pA {
        public static final Parcelable.Creator<SD> CREATOR = new Parcelable.ClassLoaderCreator<SD>() { // from class: com.bytedance.adsdk.ugeno.omh.KZx.SD.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
            public SD createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SD(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
            public SD createFromParcel(Parcel parcel) {
                return new SD(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
            public SD[] newArray(int i) {
                return new SD[i];
            }
        };
        Parcelable KZx;
        int Og;
        ClassLoader ZZv;

        public SD(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // com.bytedance.adsdk.ugeno.omh.pA, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Og);
            parcel.writeParcelable(this.KZx, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.Og + "}";
        }

        SD(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.Og = parcel.readInt();
            this.KZx = parcel.readParcelable(classLoader);
            this.ZZv = classLoader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SD sd = new SD(super.onSaveInstanceState());
        sd.Og = this.ZZv;
        com.bytedance.adsdk.ugeno.omh.Og og = this.KZx;
        if (og != null) {
            sd.KZx = og.Og();
        }
        return sd;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SD)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SD sd = (SD) parcelable;
        super.onRestoreInstanceState(sd.pA());
        if (this.KZx != null) {
            pA(sd.Og, false, true);
            return;
        }
        this.SGo = sd.Og;
        this.BSW = sd.KZx;
        this.WV = sd.ZZv;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        C0180KZx c0180KZx = (C0180KZx) layoutParams;
        c0180KZx.pA |= KZx(view);
        if (this.WQf) {
            if (c0180KZx != null && c0180KZx.pA) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            c0180KZx.ZZv = true;
            addViewInLayout(view, i, layoutParams);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    private static boolean KZx(View view) {
        return view.getClass().getAnnotation(pA.class) != null;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.WQf) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    Og pA(View view) {
        for (int i = 0; i < this.SD.size(); i++) {
            Og og = this.SD.get(i);
            if (this.KZx.pA(view, og.pA)) {
                return og;
            }
        }
        return null;
    }

    Og Og(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } else {
                return pA(view);
            }
        }
    }

    Og Og(int i) {
        for (int i2 = 0; i2 < this.SD.size(); i2++) {
            Og og = this.SD.get(i2);
            if (og.Og == i) {
                return og;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.dmv = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        C0180KZx c0180KZx;
        C0180KZx c0180KZx2;
        int i3;
        int i4;
        int i5;
        boolean z = false;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.lT = Math.min(measuredWidth / 10, this.IG);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i6 = 0;
        while (true) {
            boolean z2 = true;
            int i7 = 1073741824;
            if (i6 >= childCount) {
                break;
            }
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8 && (c0180KZx2 = (C0180KZx) childAt.getLayoutParams()) != null && c0180KZx2.pA) {
                int i8 = c0180KZx2.Og & 7;
                int i9 = c0180KZx2.Og & 112;
                boolean z3 = (i9 == 48 || i9 == 80) ? true : z;
                if (i8 != 3 && i8 != 5) {
                    z2 = z;
                }
                int i10 = Integer.MIN_VALUE;
                if (z3) {
                    i3 = Integer.MIN_VALUE;
                    i10 = 1073741824;
                } else {
                    i3 = z2 ? 1073741824 : Integer.MIN_VALUE;
                }
                if (c0180KZx2.width != -2) {
                    i4 = c0180KZx2.width != -1 ? c0180KZx2.width : paddingLeft;
                    i10 = 1073741824;
                } else {
                    i4 = paddingLeft;
                }
                if (c0180KZx2.height != -2) {
                    i5 = c0180KZx2.height != -1 ? c0180KZx2.height : measuredHeight;
                } else {
                    i5 = measuredHeight;
                    i7 = i3;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, i10), View.MeasureSpec.makeMeasureSpec(i5, i7));
                if (z3) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z2) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i6++;
            z = false;
        }
        this.TX = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.BF = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.WQf = true;
        KZx();
        this.WQf = false;
        int childCount2 = getChildCount();
        for (int i11 = 0; i11 < childCount2; i11++) {
            View childAt2 = getChildAt(i11);
            if (childAt2.getVisibility() != 8 && ((c0180KZx = (C0180KZx) childAt2.getLayoutParams()) == null || !c0180KZx.pA)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * c0180KZx.KZx), 1073741824), this.BF);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            int i5 = this.oX;
            pA(i, i3, i5, i5);
        }
    }

    private void pA(int i, int i2, int i3, int i4) {
        if (i2 > 0 && !this.SD.isEmpty()) {
            if (!this.Wx.isFinished()) {
                this.Wx.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)) * (((i - getPaddingLeft()) - getPaddingRight()) + i3)), getScrollY());
                return;
            }
        }
        Og Og2 = Og(this.ZZv);
        int iMin = (int) ((Og2 != null ? Math.min(Og2.ML, this.Sd) : 0.0f) * ((i - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            pA(false);
            scrollTo(iMin, getScrollY());
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0073  */
    /* JADX WARN: Code duplicated, block: B:24:0x0077  */
    /* JADX WARN: Code duplicated, block: B:26:0x007b  */
    /* JADX WARN: Code duplicated, block: B:27:0x007d  */
    /* JADX WARN: Code duplicated, block: B:28:0x008a  */
    /* JADX WARN: Code duplicated, block: B:29:0x0090  */
    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        Og ogPA;
        int iMax;
        int measuredWidth;
        int iMax2;
        int measuredHeight;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                C0180KZx c0180KZx = (C0180KZx) childAt.getLayoutParams();
                if (c0180KZx.pA) {
                    int i9 = c0180KZx.Og & 7;
                    int i10 = c0180KZx.Og & 112;
                    if (i9 == 1) {
                        iMax = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    } else {
                        if (i9 == 3) {
                            measuredWidth = childAt.getMeasuredWidth() + paddingLeft;
                        } else if (i9 != 5) {
                            measuredWidth = paddingLeft;
                        } else {
                            iMax = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        if (i10 != 16) {
                            iMax2 = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                        } else {
                            if (i10 != 48) {
                                measuredHeight = childAt.getMeasuredHeight() + paddingTop;
                            } else if (i10 != 80) {
                                measuredHeight = paddingTop;
                            } else {
                                iMax2 = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                                paddingBottom += childAt.getMeasuredHeight();
                            }
                            int i11 = paddingLeft + scrollX;
                            childAt.layout(i11, paddingTop, childAt.getMeasuredWidth() + i11, paddingTop + childAt.getMeasuredHeight());
                            i7++;
                            paddingTop = measuredHeight;
                            paddingLeft = measuredWidth;
                        }
                        int i12 = iMax2;
                        measuredHeight = paddingTop;
                        paddingTop = i12;
                        int i13 = paddingLeft + scrollX;
                        childAt.layout(i13, paddingTop, childAt.getMeasuredWidth() + i13, paddingTop + childAt.getMeasuredHeight());
                        i7++;
                        paddingTop = measuredHeight;
                        paddingLeft = measuredWidth;
                    }
                    int i14 = iMax;
                    measuredWidth = paddingLeft;
                    paddingLeft = i14;
                    if (i10 != 16) {
                        iMax2 = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                    } else {
                        if (i10 != 48) {
                            measuredHeight = childAt.getMeasuredHeight() + paddingTop;
                        } else if (i10 != 80) {
                            measuredHeight = paddingTop;
                        } else {
                            iMax2 = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                            paddingBottom += childAt.getMeasuredHeight();
                        }
                        int i15 = paddingLeft + scrollX;
                        childAt.layout(i15, paddingTop, childAt.getMeasuredWidth() + i15, paddingTop + childAt.getMeasuredHeight());
                        i7++;
                        paddingTop = measuredHeight;
                        paddingLeft = measuredWidth;
                    }
                    int i16 = iMax2;
                    measuredHeight = paddingTop;
                    paddingTop = i16;
                    int i17 = paddingLeft + scrollX;
                    childAt.layout(i17, paddingTop, childAt.getMeasuredWidth() + i17, paddingTop + childAt.getMeasuredHeight());
                    i7++;
                    paddingTop = measuredHeight;
                    paddingLeft = measuredWidth;
                }
            }
        }
        int i18 = (i5 - paddingLeft) - paddingRight;
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt2 = getChildAt(i19);
            if (childAt2.getVisibility() != 8) {
                C0180KZx c0180KZx2 = (C0180KZx) childAt2.getLayoutParams();
                if (!c0180KZx2.pA && (ogPA = pA(childAt2)) != null) {
                    float f = i18;
                    int i20 = ((int) (ogPA.ML * f)) + paddingLeft;
                    if (c0180KZx2.ZZv) {
                        c0180KZx2.ZZv = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f * c0180KZx2.KZx), 1073741824), View.MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt2.layout(i20, paddingTop, childAt2.getMeasuredWidth() + i20, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.XT = paddingTop;
        this.yFO = i6 - paddingBottom;
        this.dC = i7;
        if (this.dmv) {
            z2 = false;
            pA(this.ZZv, false, 0, false);
        } else {
            z2 = false;
        }
        this.dmv = z2;
    }

    @Override // android.view.View
    public void computeScroll() {
        this.Sn = true;
        if (!this.Wx.isFinished() && this.Wx.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.Wx.getCurrX();
            int currY = this.Wx.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!ZZv(currX)) {
                    this.Wx.abortAnimation();
                    scrollTo(0, currY);
                }
            }
            postInvalidateOnAnimation();
            return;
        }
        pA(true);
    }

    private boolean ZZv(int i) {
        if (this.SD.size() == 0) {
            if (this.dmv) {
                return false;
            }
            this.YkC = false;
            pA(0, 0.0f, 0);
            if (this.YkC) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        Og ogBzk = Bzk();
        int clientWidth = getClientWidth();
        int i2 = this.oX;
        int i3 = clientWidth + i2;
        float f = clientWidth;
        int i4 = ogBzk.Og;
        float f2 = ((i / f) - ogBzk.ML) / (ogBzk.ZZv + (i2 / f));
        this.YkC = false;
        pA(i4, f2, (int) (i3 * f2));
        if (this.YkC) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0063  */
    protected void pA(int i, float f, int i2) {
        int iMax;
        int width;
        int left;
        if (this.dC > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width2 = getWidth();
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                C0180KZx c0180KZx = (C0180KZx) childAt.getLayoutParams();
                if (c0180KZx.pA) {
                    int i4 = c0180KZx.Og & 7;
                    if (i4 == 1) {
                        iMax = Math.max((width2 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    } else {
                        if (i4 == 3) {
                            width = childAt.getWidth() + paddingLeft;
                        } else if (i4 != 5) {
                            width = paddingLeft;
                        } else {
                            iMax = (width2 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        left = (paddingLeft + scrollX) - childAt.getLeft();
                        if (left != 0) {
                            childAt.offsetLeftAndRight(left);
                        }
                        paddingLeft = width;
                    }
                    int i5 = iMax;
                    width = paddingLeft;
                    paddingLeft = i5;
                    left = (paddingLeft + scrollX) - childAt.getLeft();
                    if (left != 0) {
                        childAt.offsetLeftAndRight(left);
                    }
                    paddingLeft = width;
                }
            }
        }
        Og(i, f, i2);
        if (this.lx != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i6 = 0; i6 < childCount2; i6++) {
                View childAt2 = getChildAt(i6);
                if (!((C0180KZx) childAt2.getLayoutParams()).pA) {
                    this.lx.pA(childAt2, (childAt2.getLeft() - scrollX2) / getClientWidth());
                }
            }
        }
        this.YkC = true;
    }

    private void Og(int i, float f, int i2) {
        ZZv zZv = this.vA;
        if (zZv != null) {
            zZv.pA(i, f, i2);
        }
        List<ZZv> list = this.IIF;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                ZZv zZv2 = this.IIF.get(i3);
                if (zZv2 != null) {
                    zZv2.pA(i, f, i2);
                }
            }
        }
        ZZv zZv3 = this.PV;
        if (zZv3 != null) {
            zZv3.pA(i, f, i2);
        }
    }

    private void ML(int i) {
        ZZv zZv = this.vA;
        if (zZv != null) {
            zZv.omh(i);
        }
        List<ZZv> list = this.IIF;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                ZZv zZv2 = this.IIF.get(i2);
                if (zZv2 != null) {
                    zZv2.omh(i);
                }
            }
        }
        ZZv zZv3 = this.PV;
        if (zZv3 != null) {
            zZv3.omh(i);
        }
    }

    private void JG(int i) {
        List<ZZv> list = this.IIF;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.IIF.get(i2);
            }
        }
    }

    private void pA(boolean z) {
        boolean z2 = this.Wo == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.Wx.isFinished()) {
                this.Wx.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.Wx.getCurrX();
                int currY = this.Wx.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        ZZv(currX);
                    }
                }
            }
        }
        this.du = false;
        for (int i = 0; i < this.SD.size(); i++) {
            Og og = this.SD.get(i);
            if (og.KZx) {
                og.KZx = false;
                z2 = true;
            }
        }
        if (z2) {
            if (z) {
                postOnAnimation(this.bU);
            } else {
                this.bU.run();
            }
        }
    }

    private boolean pA(float f, float f2) {
        if (f >= this.lT || f2 <= 0.0f) {
            return f > ((float) (getWidth() - this.lT)) && f2 < 0.0f;
        }
        return true;
    }

    private void Og(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setLayerType(z ? this.SXO : 0, null);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int iFindPointerIndex;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            omh();
            return false;
        }
        if (action != 0) {
            if (this.roi) {
                return true;
            }
            if (this.Mc) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.gbA = x;
            this.xy = x;
            float y = motionEvent.getY();
            this.Vgu = y;
            this.qmB = y;
            this.CIG = motionEvent.getPointerId(0);
            this.Mc = false;
            this.Sn = true;
            this.Wx.computeScrollOffset();
            if (this.Wo == 2 && Math.abs(this.Wx.getFinalX() - this.Wx.getCurrX()) > this.HSv) {
                this.Wx.abortAnimation();
                this.du = false;
                KZx();
                this.roi = true;
                KZx(true);
                setScrollState(1);
            } else {
                pA(false);
                this.roi = false;
            }
        } else if (action == 2) {
            int i = this.CIG;
            if (i != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i)) != -1) {
                float x2 = motionEvent.getX(iFindPointerIndex);
                float f = x2 - this.xy;
                float fAbs = Math.abs(f);
                float y2 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y2 - this.Vgu);
                if (f != 0.0f && !pA(this.xy, f) && pA(this, false, (int) f, (int) x2, (int) y2)) {
                    this.xy = x2;
                    this.qmB = y2;
                    this.Mc = true;
                    return false;
                }
                int i2 = this.rB;
                if (fAbs > i2 && fAbs * 0.5f > fAbs2) {
                    this.roi = true;
                    KZx(true);
                    setScrollState(1);
                    float f2 = this.gbA;
                    float f3 = this.rB;
                    this.xy = f > 0.0f ? f2 + f3 : f2 - f3;
                    this.qmB = y2;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > i2) {
                    this.Mc = true;
                }
                if (this.roi && Og(x2)) {
                    postInvalidateOnAnimation();
                }
            }
        } else if (action == 6) {
            pA(motionEvent);
        }
        if (this.SzT == null) {
            this.SzT = VelocityTracker.obtain();
        }
        this.SzT.addMovement(motionEvent);
        return this.roi;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.bytedance.adsdk.ugeno.omh.Og og;
        int iFindPointerIndex;
        if (this.JBA) {
            return true;
        }
        boolean zOmh = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (og = this.KZx) == null || og.pA() == 0) {
            return false;
        }
        if (this.SzT == null) {
            this.SzT = VelocityTracker.obtain();
        }
        this.SzT.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.Wx.abortAnimation();
            this.du = false;
            KZx();
            float x = motionEvent.getX();
            this.gbA = x;
            this.xy = x;
            float y = motionEvent.getY();
            this.Vgu = y;
            this.qmB = y;
            this.CIG = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action != 2) {
                if (action != 3) {
                    if (action == 5) {
                        int actionIndex = motionEvent.getActionIndex();
                        if (actionIndex != -1) {
                            this.xy = motionEvent.getX(actionIndex);
                            this.CIG = motionEvent.getPointerId(actionIndex);
                        }
                    } else if (action == 6) {
                        pA(motionEvent);
                        int iFindPointerIndex2 = motionEvent.findPointerIndex(this.CIG);
                        if (iFindPointerIndex2 != -1) {
                            this.xy = motionEvent.getX(iFindPointerIndex2);
                        }
                    }
                } else if (this.roi) {
                    pA(this.ZZv, true, 0, false);
                    zOmh = omh();
                }
            } else if (!this.roi) {
                int iFindPointerIndex3 = motionEvent.findPointerIndex(this.CIG);
                if (iFindPointerIndex3 == -1) {
                    zOmh = omh();
                } else {
                    float x2 = motionEvent.getX(iFindPointerIndex3);
                    float fAbs = Math.abs(x2 - this.xy);
                    float y2 = motionEvent.getY(iFindPointerIndex3);
                    float fAbs2 = Math.abs(y2 - this.qmB);
                    if (fAbs > this.rB && fAbs > fAbs2) {
                        this.roi = true;
                        KZx(true);
                        float f = this.gbA;
                        this.xy = x2 - f > 0.0f ? f + this.rB : f - this.rB;
                        this.qmB = y2;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (this.roi) {
                        zOmh = Og(motionEvent.getX(iFindPointerIndex));
                    }
                }
            } else if (this.roi && (iFindPointerIndex = motionEvent.findPointerIndex(this.CIG)) != -1) {
                zOmh = Og(motionEvent.getX(iFindPointerIndex));
            }
        } else if (this.roi) {
            VelocityTracker velocityTracker = this.SzT;
            velocityTracker.computeCurrentVelocity(1000, this.Gx);
            int xVelocity = (int) velocityTracker.getXVelocity(this.CIG);
            this.du = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            Og ogBzk = Bzk();
            float f2 = clientWidth;
            float f3 = this.oX / f2;
            int i = ogBzk.Og;
            float f4 = ((scrollX / f2) - ogBzk.ML) / (ogBzk.ZZv + f3);
            int iFindPointerIndex4 = motionEvent.findPointerIndex(this.CIG);
            if (iFindPointerIndex4 != -1) {
                pA(pA(i, f4, xVelocity, (int) (motionEvent.getX(iFindPointerIndex4) - this.gbA)), true, true, xVelocity);
                zOmh = omh();
            }
        }
        if (zOmh) {
            postInvalidateOnAnimation();
        }
        return true;
    }

    private boolean omh() {
        this.CIG = -1;
        SGo();
        this.agB.onRelease();
        this.fN.onRelease();
        return this.agB.isFinished() || this.fN.isFinished();
    }

    private void KZx(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean Og(float f) {
        boolean z;
        boolean z2;
        float f2 = this.xy - f;
        this.xy = f;
        float scrollX = getScrollX() + f2;
        float clientWidth = getClientWidth();
        float f3 = this.vZF * clientWidth;
        float f4 = this.Sd * clientWidth;
        boolean z3 = false;
        Og og = this.SD.get(0);
        ArrayList<Og> arrayList = this.SD;
        Og og2 = arrayList.get(arrayList.size() - 1);
        if (og.Og != 0) {
            f3 = og.ML * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (og2.Og != this.KZx.pA() - 1) {
            f4 = og2.ML * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f3) {
            if (z) {
                this.agB.onPull(Math.abs(f3 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f3;
        } else if (scrollX > f4) {
            if (z2) {
                this.fN.onPull(Math.abs(scrollX - f4) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        }
        int i = (int) scrollX;
        this.xy += scrollX - i;
        scrollTo(i, getScrollY());
        ZZv(i);
        return z3;
    }

    private Og Bzk() {
        int i;
        int clientWidth = getClientWidth();
        float f = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f2 = clientWidth > 0 ? this.oX / clientWidth : 0.0f;
        int i2 = 0;
        boolean z = true;
        Og og = null;
        int i3 = -1;
        float f3 = 0.0f;
        while (i2 < this.SD.size()) {
            Og og2 = this.SD.get(i2);
            if (!z && og2.Og != (i = i3 + 1)) {
                og2 = this.omh;
                og2.ML = f + f3 + f2;
                og2.Og = i;
                og2.ZZv = this.KZx.pA(og2.Og);
                i2--;
            }
            Og og3 = og2;
            f = og3.ML;
            float f4 = og3.ZZv + f + f2;
            if (!z && scrollX < f) {
                return og;
            }
            if (scrollX < f4 || i2 == this.SD.size() - 1) {
                return og3;
            }
            int i4 = og3.Og;
            float f5 = og3.ZZv;
            i2++;
            z = false;
            i3 = i4;
            f3 = f5;
            og = og3;
        }
        return og;
    }

    private int pA(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.Bf || Math.abs(i2) <= this.FQ) {
            i += (int) (f + (i >= this.ZZv ? 0.4f : 0.6f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.SD.size() <= 0) {
            return i;
        }
        Og og = this.SD.get(0);
        ArrayList<Og> arrayList = this.SD;
        return Math.max(og.Og, Math.min(i, arrayList.get(arrayList.size() - 1).Og));
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        com.bytedance.adsdk.ugeno.omh.Og og;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (og = this.KZx) != null && og.pA() > 1)) {
            if (!this.agB.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.vZF * width);
                this.agB.setSize(height, width);
                zDraw = this.agB.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.fN.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.Sd + 1.0f)) * width2);
                this.fN.setSize(height2, width2);
                zDraw |= this.fN.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.agB.finish();
            this.fN.finish();
        }
        if (zDraw) {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        float f2;
        super.onDraw(canvas);
        if (this.oX <= 0 || this.aBv == null || this.SD.size() <= 0 || this.KZx == null) {
            return;
        }
        int scrollX = getScrollX();
        int width = getWidth();
        float f3 = width;
        float f4 = this.oX / f3;
        int i = 0;
        Og og = this.SD.get(0);
        float f5 = og.ML;
        int size = this.SD.size();
        int i2 = og.Og;
        int i3 = this.SD.get(size - 1).Og;
        while (i2 < i3) {
            while (i2 > og.Og && i < size) {
                i++;
                og = this.SD.get(i);
            }
            if (i2 == og.Og) {
                f2 = (og.ML + og.ZZv) * f3;
                f = og.ML + og.ZZv + f4;
            } else {
                float fPA = this.KZx.pA(i2);
                float f6 = (f5 + fPA) * f3;
                f = f5 + fPA + f4;
                f2 = f6;
            }
            if (this.oX + f2 > scrollX) {
                this.aBv.setBounds(Math.round(f2), this.XT, Math.round(this.oX + f2), this.yFO);
                this.aBv.draw(canvas);
            }
            if (f2 > scrollX + width) {
                return;
            }
            i2++;
            f5 = f;
            f4 = f4;
        }
    }

    private void pA(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.CIG) {
            int i = actionIndex == 0 ? 1 : 0;
            this.xy = motionEvent.getX(i);
            this.CIG = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.SzT;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void SGo() {
        this.roi = false;
        this.Mc = false;
        VelocityTracker velocityTracker = this.SzT;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.SzT = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.TV != z) {
            this.TV = z;
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.KZx == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            return scrollX > ((int) (((float) clientWidth) * this.vZF));
        }
        return i > 0 && scrollX < ((int) (((float) clientWidth) * this.Sd));
    }

    protected boolean pA(View view, boolean z, int i, int i2, int i3) {
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && pA(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || pA(keyEvent);
    }

    public boolean pA(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                if (keyEvent.hasModifiers(2)) {
                    return ZZv();
                }
                return KZx(17);
            }
            if (keyCode == 22) {
                if (keyEvent.hasModifiers(2)) {
                    return ML();
                }
                return KZx(66);
            }
            if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return KZx(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return KZx(1);
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:40:0x00bb  */
    public boolean KZx(int i) {
        boolean zZZv;
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
            break;
        }
        if (viewFindFocus != null) {
            ViewParent parent = viewFindFocus.getParent();
            while (true) {
                if (!(parent instanceof ViewGroup)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(viewFindFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = viewFindFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ").append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                    viewFindFocus = null;
                    break;
                }
                if (parent == this) {
                    break;
                }
                parent = parent.getParent();
            }
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i);
        if (viewFindNextFocus == null || viewFindNextFocus == viewFindFocus) {
            if (i == 17 || i == 1) {
                zZZv = ZZv();
            } else if (i == 66 || i == 2) {
                zZZv = ML();
            } else {
                zZZv = false;
            }
        } else if (i == 17) {
            int i2 = pA(this.Bzk, viewFindNextFocus).left;
            int i3 = pA(this.Bzk, viewFindFocus).left;
            if (viewFindFocus != null && i2 >= i3) {
                zZZv = ZZv();
            } else {
                zZZv = viewFindNextFocus.requestFocus();
            }
        } else if (i == 66) {
            int i4 = pA(this.Bzk, viewFindNextFocus).left;
            int i5 = pA(this.Bzk, viewFindFocus).left;
            if (viewFindFocus == null || i4 > i5) {
                zZZv = viewFindNextFocus.requestFocus();
            } else {
                zZZv = ML();
            }
        } else {
            zZZv = false;
        }
        if (zZZv) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return zZZv;
    }

    private Rect pA(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    boolean ZZv() {
        int i = this.ZZv;
        if (i <= 0) {
            return false;
        }
        pA(i - 1, true);
        return true;
    }

    boolean ML() {
        com.bytedance.adsdk.ugeno.omh.Og og = this.KZx;
        if (og == null || this.ZZv >= og.pA() - 1) {
            return false;
        }
        pA(this.ZZv + 1, true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        Og ogPA;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (ogPA = pA(childAt)) != null && ogPA.Og == this.ZZv) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i2 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) || arrayList == null) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        Og ogPA;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (ogPA = pA(childAt)) != null && ogPA.Og == this.ZZv) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        int i4;
        Og ogPA;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = childCount;
            i2 = 0;
            i4 = 1;
        } else {
            i2 = childCount - 1;
            i3 = -1;
            i4 = -1;
        }
        while (i2 != i3) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (ogPA = pA(childAt)) != null && ogPA.Og == this.ZZv && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i4;
        }
        return false;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Og ogPA;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (ogPA = pA(childAt)) != null && ogPA.Og == this.ZZv && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C0180KZx();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0180KZx) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0180KZx(getContext(), attributeSet);
    }

    private class JG extends DataSetObserver {
        JG() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            KZx.this.Og();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            KZx.this.Og();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.omh.KZx$KZx, reason: collision with other inner class name */
    public static class C0180KZx extends ViewGroup.LayoutParams {
        int JG;
        float KZx;
        int ML;
        public int Og;
        boolean ZZv;
        public boolean pA;

        public C0180KZx() {
            super(-1, -1);
            this.KZx = 0.0f;
        }

        public C0180KZx(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.KZx = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, KZx.Og);
            this.Og = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    static class omh implements Comparator<View> {
        omh() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            C0180KZx c0180KZx = (C0180KZx) view.getLayoutParams();
            C0180KZx c0180KZx2 = (C0180KZx) view2.getLayoutParams();
            if (c0180KZx.pA != c0180KZx2.pA) {
                return c0180KZx.pA ? 1 : -1;
            }
            return c0180KZx.ML - c0180KZx2.ML;
        }
    }
}
