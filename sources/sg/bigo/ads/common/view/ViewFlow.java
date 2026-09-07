package sg.bigo.ads.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.util.ArrayList;
import java.util.List;
import sg.bigo.ads.common.p;

/* JADX INFO: loaded from: classes10.dex */
public class ViewFlow extends sg.bigo.ads.common.view.a {
    private static final Interpolator s = new Interpolator() { // from class: sg.bigo.ads.common.view.ViewFlow.1
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    private float A;
    private float B;
    private int C;
    private VelocityTracker D;
    private int E;
    private int F;
    private int G;
    private int H;
    private boolean I;
    private final Runnable J;
    private int K;
    private boolean L;
    private boolean M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f13327a;
    protected int b;
    protected int c;
    protected int d;
    protected View e;
    protected View f;
    public boolean g;
    public boolean h;
    protected int i;
    protected int j;
    private final a k;
    private int l;
    private int m;
    private int n;
    private d o;
    private d p;
    private p q;
    private boolean r;
    private Scroller t;
    private boolean u;
    private boolean v;
    private boolean w;
    private int x;
    private float y;
    private float z;

    static class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        c f13331a;
        int b;
        private final ViewFlow c;

        private a(ViewFlow viewFlow) {
            this.b = 0;
            this.c = viewFlow;
        }

        /* synthetic */ a(ViewFlow viewFlow, byte b) {
            this(viewFlow);
        }

        @Override // sg.bigo.ads.common.view.ViewFlow.c
        public final void a(final int i) {
            this.c.post(new Runnable() { // from class: sg.bigo.ads.common.view.ViewFlow.a.3
                @Override // java.lang.Runnable
                public final void run() {
                    int i2 = a.this.b;
                    int i3 = i;
                    if (i2 == i3) {
                        return;
                    }
                    a.this.b = i3;
                    if (a.this.f13331a != null) {
                        a.this.f13331a.a(i);
                    }
                }
            });
        }

        @Override // sg.bigo.ads.common.view.ViewFlow.c
        public final void a(final int i, final int i2) {
            this.c.post(new Runnable() { // from class: sg.bigo.ads.common.view.ViewFlow.a.4
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.f13331a != null) {
                        a.this.f13331a.a(i, i2);
                    }
                }
            });
        }

        @Override // sg.bigo.ads.common.view.ViewFlow.c
        public final void a(final View view, final int i) {
            this.c.post(new Runnable() { // from class: sg.bigo.ads.common.view.ViewFlow.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.f13331a != null) {
                        a.this.f13331a.a(view, i);
                    }
                }
            });
        }

        @Override // sg.bigo.ads.common.view.ViewFlow.c
        public final void a(final View view, final int i, final float f) {
            this.c.post(new Runnable() { // from class: sg.bigo.ads.common.view.ViewFlow.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.f13331a != null) {
                        a.this.f13331a.a(view, i, f);
                    }
                }
            });
        }
    }

    public static class b extends ViewGroup.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f13336a;
        public int b;
        public boolean c;
        public int d;
        public int e;

        public b() {
            this((byte) 0);
        }

        private b(byte b) {
            super(-1, -1);
            this.e = 17;
        }
    }

    public interface c {
        void a(int i);

        void a(int i, int i2);

        void a(View view, int i);

        void a(View view, int i, float f);
    }

    public interface d {
        void a();
    }

    public ViewFlow(Context context) {
        this(context, null);
    }

    public ViewFlow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = new a(this, (byte) 0);
        this.f13327a = 0;
        this.b = 0;
        this.l = 0;
        this.c = 3;
        this.r = true;
        this.g = false;
        this.h = false;
        this.C = -1;
        this.I = true;
        this.J = new Runnable() { // from class: sg.bigo.ads.common.view.ViewFlow.2
            @Override // java.lang.Runnable
            public final void run() {
                ViewFlow.this.setScrollState(0);
            }
        };
        this.K = 0;
        this.M = false;
        removeAllViews();
        setFocusable(true);
        setOverScrollMode(2);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        Context context2 = getContext();
        this.t = new Scroller(context2, s);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context2);
        float f = context2.getResources().getDisplayMetrics().density;
        this.x = viewConfiguration.getScaledPagingTouchSlop();
        this.E = (int) (400.0f * f);
        this.F = viewConfiguration.getScaledMaximumFlingVelocity();
        this.G = (int) (25.0f * f);
        this.H = (int) (2.0f * f);
        this.i = (int) (f * 16.0f);
    }

    private void a(int i, int i2) {
        int scrollX;
        int iAbs;
        if (this.b == 0) {
            return;
        }
        Scroller scroller = this.t;
        if (scroller == null || scroller.isFinished()) {
            scrollX = getScrollX();
        } else {
            scrollX = this.u ? this.t.getCurrX() : this.t.getStartX();
            this.t.abortAnimation();
        }
        int i3 = scrollX;
        int scrollY = getScrollY();
        int i4 = i - i3;
        int i5 = 0 - scrollY;
        if (i4 == 0 && i5 == 0) {
            a(false);
            setScrollState(0);
            return;
        }
        setScrollState(2);
        int measuredWidth = getMeasuredWidth();
        float f = measuredWidth / 2;
        float fB = f + (b(Math.min(1.0f, (Math.abs(i4) * 1.0f) / measuredWidth)) * f);
        int iAbs2 = Math.abs(i2);
        if (iAbs2 > 0) {
            iAbs = Math.round(Math.abs(fB / iAbs2) * 1000.0f) * 4;
        } else {
            iAbs = (int) (((Math.abs(i4) / getChildAt(this.f13327a).getWidth()) + 1.0f) * 100.0f);
        }
        int iMin = Math.min(iAbs, 600);
        this.u = false;
        this.t.startScroll(i3, scrollY, i4, i5, iMin);
        sg.bigo.ads.common.e.a.a(this);
    }

    private void a(int i, boolean z, int i2) {
        int iMax;
        int measuredWidth;
        int measuredWidth2;
        if (this.b <= 0) {
            return;
        }
        int iMin = Math.min(Math.max(0, i), this.b - 1);
        View childAt = getChildAt(0);
        if (childAt != null && childAt == this.e) {
            iMin++;
        }
        View childAt2 = getChildAt(iMin);
        if (childAt2 != null) {
            iMax = f() ? childAt2.getLeft() - ((getMeasuredWidth() - childAt2.getMeasuredWidth()) / 2) : childAt2.getLeft() - Math.max(this.d, this.m);
        } else {
            iMax = 0;
        }
        if (getChildAt(getChildCount() - 1) != null) {
            if (this.f != null) {
                measuredWidth = this.n - getMeasuredWidth();
                measuredWidth2 = this.f.getMeasuredWidth();
            } else {
                measuredWidth = this.n;
                measuredWidth2 = getMeasuredWidth();
            }
            iMax = (int) Math.max(0.0f, Math.min(iMax, measuredWidth - measuredWidth2));
        }
        if (iMax == getScrollX()) {
            return;
        }
        if (z) {
            a(iMax, i2);
        } else {
            a(false);
            scrollTo(iMax, 0);
        }
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.C) {
            int i = actionIndex == 0 ? 1 : 0;
            this.y = motionEvent.getX(i);
            this.C = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.D;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    static /* synthetic */ void a(ViewFlow viewFlow) {
        int scrollX = viewFlow.getScrollX();
        if (viewFlow.e != null) {
            View childAt = viewFlow.getChildAt(0);
            View view = viewFlow.e;
            if (childAt == view && scrollX < view.getRight()) {
                viewFlow.c(0);
                return;
            }
        }
        if (viewFlow.f != null) {
            View childAt2 = viewFlow.getChildAt(viewFlow.getChildCount() - 1);
            View view2 = viewFlow.f;
            if (childAt2 != view2 || scrollX <= view2.getLeft() - viewFlow.getMeasuredWidth()) {
                return;
            }
            viewFlow.c(viewFlow.getItemCount() - 1);
        }
    }

    private void a(boolean z) {
        boolean z2 = this.K == 2;
        if (z2 && !this.t.isFinished()) {
            this.t.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.t.getCurrX();
            int currY = this.t.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
            }
        }
        if (z2) {
            if (z) {
                sg.bigo.ads.common.e.a.a(this, this.J);
            } else {
                this.J.run();
            }
        }
    }

    private boolean a(float f) {
        float f2 = this.y - f;
        this.y = f;
        float fMax = Math.max(0.0f, Math.min(getScrollX() + f2, getScrollRange()));
        sg.bigo.ads.common.t.a.b("ViewFlow", "performDrag, getScrollRange()=" + getScrollRange() + ", scrollX=" + fMax);
        int i = (int) fMax;
        this.y += fMax - i;
        scrollTo(i, getScrollY());
        return false;
    }

    private static float b(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    private void c(int i) {
        a(i, true, -20);
    }

    private boolean f() {
        int i = this.c;
        return i == 2 || i == 3;
    }

    private boolean g() {
        this.C = -1;
        i();
        return true;
    }

    private int getScrollRange() {
        return Math.max(0, this.n - getMeasuredWidth());
    }

    private void h() {
        this.h = false;
        this.v = true;
    }

    private void i() {
        this.v = false;
        this.w = false;
        this.h = false;
        VelocityTracker velocityTracker = this.D;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.D = null;
        }
    }

    private void j() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public final int a(View view) {
        if (view == null) {
            return -1;
        }
        List<View> items = getItems();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) == view) {
                return i;
            }
        }
        return -1;
    }

    public final View a(int i) {
        List<View> items = getItems();
        if (i < 0 || i >= items.size()) {
            return null;
        }
        return items.get(i);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0036  */
    @Override // sg.bigo.ads.common.view.a
    protected final void a() {
        int i;
        int itemCount = getItemCount();
        if (itemCount <= 1) {
            return;
        }
        int currentItem = getCurrentItem();
        if (this.L) {
            if (currentItem == 0) {
                i = currentItem + 1;
                this.L = false;
            } else {
                i = currentItem - 1;
            }
        } else if (currentItem != itemCount - 1) {
            View view = this.f;
            int measuredWidth = this.n;
            if (view != null) {
                measuredWidth -= view.getMeasuredWidth();
            }
            if (getScrollX() + getMeasuredWidth() >= measuredWidth) {
                i = currentItem - 1;
                this.L = true;
            } else {
                i = currentItem + 1;
            }
        } else {
            i = currentItem - 1;
            this.L = true;
        }
        c(i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (i < 0) {
            View childAt = getChildAt(getChildCount() - 1);
            if (childAt != null && childAt == this.f) {
                i = getChildCount() - 1;
            }
        } else {
            View childAt2 = getChildAt(0);
            if (childAt2 != null && childAt2 == this.e) {
                i++;
            }
        }
        super.addView(view, i, layoutParams);
    }

    public final void b(int i) {
        this.f13327a = i;
        if (this.I) {
            requestLayout();
        } else {
            c(i);
        }
    }

    @Override // sg.bigo.ads.common.view.a
    protected final boolean b() {
        return !this.v;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof b) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.u = true;
        if (this.t.isFinished() || !this.t.computeScrollOffset()) {
            a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.t.getCurrX();
        int currY = this.t.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
        }
        sg.bigo.ads.common.e.a.a(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        this.g = true;
        if (!this.M) {
            onTouchEvent(motionEvent);
        }
        return zDispatchTouchEvent;
    }

    public final boolean e() {
        int measuredWidth = this.n;
        View view = this.e;
        if (view != null) {
            measuredWidth -= view.getRight();
        }
        View view2 = this.f;
        if (view2 != null) {
            measuredWidth -= view2.getMeasuredWidth();
        }
        return getWidth() >= measuredWidth;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new b();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public int getContentMaxWidthSpace() {
        return this.d;
    }

    public int getCurrentItem() {
        return this.f13327a;
    }

    public int getItemCount() {
        return this.b;
    }

    public List<View> getItems() {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != this.e && childAt != this.f) {
                arrayList.add(childAt);
            }
        }
        return arrayList;
    }

    public c getOnItemChangeListener() {
        return this.k.f13331a;
    }

    public int getViewStyle() {
        return this.c;
    }

    @Override // sg.bigo.ads.common.view.a, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.I = true;
    }

    @Override // sg.bigo.ads.common.view.a, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.J);
        Scroller scroller = this.t;
        if (scroller != null && !scroller.isFinished()) {
            this.t.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.M = false;
        if (this.r) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            g();
            return false;
        }
        if (action != 0) {
            if (this.v) {
                return true;
            }
            if (this.w) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.A = x;
            this.y = x;
            float y = motionEvent.getY();
            this.B = y;
            this.z = y;
            this.C = motionEvent.getPointerId(0);
            this.w = false;
            this.u = true;
            this.t.computeScrollOffset();
            if (this.K != 2 || Math.abs(this.t.getFinalX() - this.t.getCurrX()) <= this.H) {
                a(false);
                this.v = false;
            } else {
                this.t.abortAnimation();
                h();
                j();
                setScrollState(1);
            }
        } else if (action == 2) {
            int i = this.C;
            if (i != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i);
                float x2 = motionEvent.getX(iFindPointerIndex);
                float f = x2 - this.y;
                float fAbs = Math.abs(f);
                float y2 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y2 - this.B);
                if (f != 0.0f) {
                    float f2 = this.y;
                    if ((f2 >= this.j || f <= 0.0f) && ((f2 <= getWidth() - this.j || f >= 0.0f) && getWidth() < this.n)) {
                        this.y = x2;
                        this.z = y2;
                        this.w = true;
                        return false;
                    }
                }
                int i2 = this.x;
                if (fAbs > i2 && fAbs * 0.5f > fAbs2) {
                    h();
                    j();
                    setScrollState(1);
                    float f3 = this.A;
                    float f4 = this.x;
                    this.y = f > 0.0f ? f3 + f4 : f3 - f4;
                    this.z = y2;
                } else if (fAbs2 > i2) {
                    this.w = true;
                }
                if (this.v) {
                    a(x2);
                }
            }
        } else if (action == 6) {
            a(motionEvent);
        }
        if (this.D == null) {
            this.D = VelocityTracker.obtain();
        }
        this.D.addMovement(motionEvent);
        return this.v;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:38:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:41:0x00ce  */
    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float measuredWidth;
        int iMax;
        int iMax2;
        int i5;
        int i6;
        float measuredHeight;
        this.k.a(this.b);
        this.n = 0;
        int childCount = getChildCount();
        if (childCount <= 0) {
            return;
        }
        float fAbs = Math.abs(i4 - i2);
        int iAbs = Math.abs(i3 - i);
        View view = this.e;
        if (view != null) {
            if (view != null) {
                float measuredHeight2 = (fAbs - view.getMeasuredHeight()) / 2.0f;
                View view2 = this.e;
                view2.layout(0, (int) measuredHeight2, view2.getMeasuredWidth(), (int) (measuredHeight2 + this.e.getMeasuredHeight()));
            }
            this.n += this.e.getRight();
        }
        boolean z2 = true;
        View view3 = null;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt != this.e && childAt != this.f) {
                int i8 = this.c;
                if (i8 != 2) {
                    if (i8 != 3) {
                        this.n += z2 ? this.d : this.m;
                    } else {
                        if (view3 != null) {
                            this.n = (int) (this.n + ((iAbs - view3.getMeasuredWidth()) / 2.0f));
                        }
                        iMax2 = (int) (this.n + ((iAbs - childAt.getMeasuredWidth()) / 2.0f));
                    }
                    i5 = ((b) childAt.getLayoutParams()).e;
                    if (i5 != 48) {
                        if (i5 != 80) {
                            measuredHeight = (fAbs - childAt.getMeasuredHeight()) / 2.0f;
                        } else {
                            measuredHeight = fAbs - childAt.getMeasuredHeight();
                        }
                        i6 = (int) measuredHeight;
                    } else {
                        i6 = 0;
                    }
                    int i9 = this.n;
                    childAt.layout(i9, i6, childAt.getMeasuredWidth() + i9, childAt.getMeasuredHeight() + i6);
                    this.n = childAt.getRight();
                    z2 = false;
                    view3 = childAt;
                } else {
                    iMax2 = (int) (this.n + (z2 ? Math.max(this.d, (iAbs - childAt.getMeasuredWidth()) / 2.0f) : this.m));
                }
                this.n = iMax2;
                i5 = ((b) childAt.getLayoutParams()).e;
                if (i5 != 48) {
                    if (i5 != 80) {
                        measuredHeight = (fAbs - childAt.getMeasuredHeight()) / 2.0f;
                    } else {
                        measuredHeight = fAbs - childAt.getMeasuredHeight();
                    }
                    i6 = (int) measuredHeight;
                } else {
                    i6 = 0;
                }
                int i10 = this.n;
                childAt.layout(i10, i6, childAt.getMeasuredWidth() + i10, childAt.getMeasuredHeight() + i6);
                this.n = childAt.getRight();
                z2 = false;
                view3 = childAt;
            }
        }
        if (view3 != null) {
            int i11 = this.c;
            if (i11 != 2) {
                if (i11 != 3) {
                    iMax = this.n + this.d;
                } else {
                    f = this.n;
                    measuredWidth = (iAbs - view3.getMeasuredWidth()) / 2.0f;
                    f2 = 0.0f;
                }
                this.n = iMax;
            } else {
                f = this.n;
                f2 = this.d;
                measuredWidth = (iAbs - view3.getMeasuredWidth()) / 2.0f;
            }
            iMax = (int) (f + Math.max(f2, measuredWidth));
            this.n = iMax;
        }
        View view4 = this.f;
        if (view4 != null) {
            int measuredWidth2 = this.n;
            if (view4 != null) {
                View view5 = this.e;
                int right = view5 != null ? view5.getRight() : 0;
                if (measuredWidth2 - right < getMeasuredWidth()) {
                    measuredWidth2 = getMeasuredWidth() + right;
                }
                float measuredHeight3 = (fAbs - this.f.getMeasuredHeight()) / 2.0f;
                View view6 = this.f;
                view6.layout(measuredWidth2, (int) measuredHeight3, view6.getMeasuredWidth() + measuredWidth2, (int) (measuredHeight3 + this.f.getMeasuredHeight()));
            }
            this.n = this.f.getRight();
        }
        if (this.I) {
            a(this.f13327a, false, 0);
        } else {
            c(this.f13327a);
        }
        this.I = false;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00c0  */
    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        p pVarA;
        int i3;
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        p pVarA2;
        p pVar;
        b bVar;
        int i4 = 0;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.j = Math.min(measuredWidth / 10, this.i);
        int measuredWidth2 = getMeasuredWidth() - (this.d * 2);
        int childCount = getChildCount();
        int i5 = 0;
        while (true) {
            if (i5 < childCount) {
                View childAt = getChildAt(i5);
                if (childAt != this.e && childAt != this.f && (bVar = (b) childAt.getLayoutParams()) != null && bVar.c) {
                    if (bVar.f13336a > 0 && bVar.b > 0) {
                        pVarA = p.a(bVar.f13336a, bVar.b, measuredWidth2, measuredHeight);
                        break;
                    }
                    break;
                }
                i5++;
            }
            pVarA = null;
            break;
        }
        if (pVarA == null && (pVar = this.q) != null) {
            pVarA = p.a(pVar.b, this.q.c, measuredWidth2, measuredHeight);
        }
        this.f13327a = Math.min(Math.max(0, this.f13327a), this.b - 1);
        int i6 = 0;
        while (i6 < childCount) {
            View childAt2 = getChildAt(i6);
            if (childAt2 == this.e || childAt2 == this.f) {
                i3 = i4;
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), i3);
                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), i3);
            } else {
                b bVar2 = (b) childAt2.getLayoutParams();
                if (bVar2 != null) {
                    int i7 = bVar2.f13336a;
                    int i8 = bVar2.b;
                    if (this.c == Integer.MIN_VALUE) {
                        pVarA2 = p.a(i7, i8, measuredHeight);
                    } else {
                        int i9 = bVar2.d;
                        if (i9 != 1 && i9 != 2) {
                            pVarA2 = new p(measuredWidth2, measuredHeight);
                        } else if (bVar2.d == 2 && pVarA != null) {
                            pVarA2 = pVarA;
                        } else if (i7 <= 0 || i8 <= 0) {
                            pVarA2 = new p(measuredWidth2, measuredHeight);
                        } else {
                            pVarA2 = p.a(i7, i8, measuredWidth2, measuredHeight);
                        }
                    }
                    bVar2.width = pVarA2.b;
                    bVar2.height = pVarA2.c;
                    i3 = 0;
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, bVar2.width), 1073741824);
                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, bVar2.height), 1073741824);
                } else {
                    i3 = i4;
                }
                i6++;
                i4 = i3;
            }
            childAt2.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            i6++;
            i4 = i3;
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        int i5;
        int iMin;
        super.onScrollChanged(i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (childAt == null || childAt != this.e) {
            i5 = 0;
            iMin = i;
        } else {
            iMin = Math.max(childAt.getRight(), i);
            i5 = 1;
        }
        int childCount = getChildCount();
        View childAt2 = getChildAt(childCount - 1);
        if (childAt2 != null && childAt2 == this.f) {
            iMin = Math.min(childAt2.getLeft() - getMeasuredWidth(), iMin);
            childCount--;
        }
        float measuredWidth = f() ? iMin + ((getMeasuredWidth() * 1.0f) / 2.0f) : iMin + this.d;
        View childAt3 = getChildAt(this.f13327a + i5);
        int measuredWidth2 = (childAt3 == null || childAt3.getMeasuredWidth() <= 0) ? getMeasuredWidth() - (this.d * 2) : childAt3.getMeasuredWidth();
        sg.bigo.ads.common.t.a.a("ViewFlow", "computeScrollOffset, ----- begin -----");
        for (int i6 = i5; i6 < childCount; i6++) {
            View childAt4 = getChildAt(i6);
            if (childAt4 != null) {
                float fMax = Math.max(-1.0f, Math.min(1.0f, (f() ? (int) (((childAt4.getLeft() + ((childAt4.getMeasuredWidth() * 1.0f) / 2.0f)) - measuredWidth) + 0.5f) : childAt4.getLeft() - measuredWidth) / measuredWidth2));
                int i7 = i6 - i5;
                if (childAt4.getLeft() < measuredWidth && childAt4.getRight() > measuredWidth) {
                    this.l = i7;
                }
                this.k.a(childAt4, i7, fMax);
                if (fMax == 0.0f && this.f13327a != i7) {
                    this.f13327a = i7;
                    this.l = i7;
                    this.k.a(childAt4, i7);
                }
            }
        }
        sg.bigo.ads.common.t.a.a("ViewFlow", "computeScrollOffset, ----- end -----");
        a aVar = this.k;
        if (aVar != null) {
            aVar.a(i, getScrollRange());
        }
    }

    /* JADX WARN: Code duplicated, block: B:116:0x0214 A[PHI: r1
  0x0214: PHI (r1v12 sg.bigo.ads.common.view.ViewFlow$d) = (r1v11 sg.bigo.ads.common.view.ViewFlow$d), (r1v13 sg.bigo.ads.common.view.ViewFlow$d) binds: [B:125:0x0239, B:115:0x0212] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:134:0x026e  */
    /* JADX WARN: Code duplicated, block: B:54:0x00de  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:67:0x0139  */
    /* JADX WARN: Code duplicated, block: B:73:0x0155  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int pointerId;
        d dVar;
        int right;
        int scrollRange;
        boolean zG;
        this.M = true;
        boolean zG2 = false;
        if (!this.r) {
            return false;
        }
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || getChildCount() == 0) {
            return false;
        }
        if (this.D == null) {
            this.D = VelocityTracker.obtain();
        }
        this.D.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        if (this.v) {
                            a(this.f13327a, true, 0);
                            zG = g();
                        } else {
                            zG = false;
                        }
                        this.h = false;
                        zG2 = zG;
                    } else if (action == 5) {
                        int actionIndex = motionEvent.getActionIndex();
                        this.y = motionEvent.getX(actionIndex);
                        pointerId = motionEvent.getPointerId(actionIndex);
                    } else if (action == 6) {
                        a(motionEvent);
                        this.y = motionEvent.getX(motionEvent.findPointerIndex(this.C));
                    }
                } else if (!this.v) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.C);
                    if (iFindPointerIndex == -1) {
                        zG2 = g();
                    } else {
                        float x = motionEvent.getX(iFindPointerIndex);
                        float fAbs = Math.abs(x - this.y);
                        float y = motionEvent.getY(iFindPointerIndex);
                        float fAbs2 = Math.abs(y - this.z);
                        if (fAbs > this.x && fAbs > fAbs2) {
                            h();
                            j();
                            float f = this.A;
                            this.y = x - f > 0.0f ? f + this.x : f - this.x;
                            this.z = y;
                            setScrollState(1);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                        if (this.v) {
                            a(motionEvent.getX(motionEvent.findPointerIndex(this.C)));
                        } else {
                            this.h = true;
                        }
                    }
                } else if (this.v) {
                    a(motionEvent.getX(motionEvent.findPointerIndex(this.C)));
                } else {
                    this.h = true;
                }
            } else if (this.v) {
                VelocityTracker velocityTracker = this.D;
                velocityTracker.computeCurrentVelocity(1000, this.F);
                int xVelocity = (int) velocityTracker.getXVelocity(this.C);
                int scrollX = getScrollX();
                int x2 = (int) (motionEvent.getX(motionEvent.findPointerIndex(this.C)) - this.A);
                if (Integer.MIN_VALUE != this.c) {
                    int i = this.l;
                    int i2 = (Math.abs(x2) <= this.G || Math.abs(xVelocity) <= this.E || xVelocity > 0) ? i : i + 1;
                    if (i2 == i) {
                        double measuredWidth = (x2 * 1.0f) / a(i).getMeasuredWidth();
                        if (measuredWidth > 0.1d) {
                            i--;
                        } else if (measuredWidth < -0.1d) {
                            i++;
                        }
                    } else {
                        i = i2;
                    }
                    int iMax = Math.max(Math.min(i, this.f13327a + 1), this.f13327a - 1);
                    int childCount = getChildCount();
                    if (childCount > 0) {
                        View view = this.e;
                        if (view != null && view == getChildAt(0)) {
                            childCount--;
                        }
                        View view2 = this.f;
                        if (view2 != null && view2 == getChildAt(getChildCount() - 1)) {
                            childCount--;
                        }
                        iMax = Math.max(0, Math.min(iMax, childCount - 1));
                    }
                    a(iMax, true, xVelocity);
                } else if (Math.abs(xVelocity) > this.E) {
                    int i3 = -xVelocity;
                    if (this.e != null) {
                        View childAt = getChildAt(0);
                        View view3 = this.e;
                        if (childAt == view3) {
                            right = view3.getRight();
                        } else {
                            right = 0;
                        }
                    } else {
                        right = 0;
                    }
                    if (this.f != null) {
                        View childAt2 = getChildAt(getChildCount() - 1);
                        View view4 = this.f;
                        if (childAt2 == view4) {
                            scrollRange = view4.getLeft() - getMeasuredWidth();
                        } else {
                            scrollRange = getScrollRange();
                        }
                    } else {
                        scrollRange = getScrollRange();
                    }
                    int i4 = scrollRange;
                    if (getChildCount() > 0) {
                        this.t.fling(getScrollX(), getScrollY(), i3, 0, right, i4, 0, 0);
                        postInvalidateOnAnimation();
                    }
                } else {
                    post(new Runnable() { // from class: sg.bigo.ads.common.view.ViewFlow.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            ViewFlow.a(ViewFlow.this);
                        }
                    });
                }
                if (scrollX == 0 && x2 > 0 && this.e != null && getChildAt(0) == this.e) {
                    dVar = this.o;
                    if (dVar != null) {
                        dVar.a();
                    }
                } else if (this.f != null) {
                    View childAt3 = getChildAt(getChildCount() - 1);
                    View view5 = this.f;
                    if (childAt3 == view5 && x2 < 0 && scrollX == view5.getRight() - getMeasuredWidth() && (dVar = this.p) != null) {
                        dVar.a();
                    }
                }
                zG = g();
                this.h = false;
                zG2 = zG;
            } else {
                if (Integer.MIN_VALUE != this.c) {
                    c(this.l);
                } else {
                    post(new Runnable() { // from class: sg.bigo.ads.common.view.ViewFlow.4
                        @Override // java.lang.Runnable
                        public final void run() {
                            ViewFlow.a(ViewFlow.this);
                        }
                    });
                }
                zG = false;
                this.h = false;
                zG2 = zG;
            }
            if (zG2) {
                sg.bigo.ads.common.e.a.a(this);
            }
            return true;
        }
        this.t.abortAnimation();
        float x3 = motionEvent.getX();
        this.A = x3;
        this.y = x3;
        float y2 = motionEvent.getY();
        this.B = y2;
        this.z = y2;
        pointerId = motionEvent.getPointerId(0);
        this.C = pointerId;
        if (zG2) {
            sg.bigo.ads.common.e.a.a(this);
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view == this.f || view == this.e || view == null) {
            return;
        }
        this.b++;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view == this.f || view == this.e || view == null) {
            return;
        }
        this.b--;
    }

    public void setContentMaxWidthSpace(int i) {
        int iMax = Math.max(0, i);
        if (this.d != iMax) {
            this.d = iMax;
            requestLayout();
        }
    }

    public void setDividerWidth(int i) {
        int iMax = Math.max(0, i);
        if (this.m != iMax) {
            this.m = iMax;
            if (this.c != 3) {
                requestLayout();
            }
        }
    }

    public void setEndView(View view) {
        View view2 = this.f;
        if (view != view2) {
            if (view2 != null) {
                removeView(view2);
            }
            this.f = view;
            if (view != null) {
                addView(view);
            }
            requestLayout();
        }
    }

    public void setMainChildSize(p pVar) {
        this.q = pVar;
    }

    public void setOnEndViewShowListener(d dVar) {
        this.p = dVar;
    }

    public void setOnItemChangeListener(c cVar) {
        this.k.f13331a = cVar;
    }

    public void setOnStartViewShowListener(d dVar) {
        this.o = dVar;
    }

    public void setScrollEnabled(boolean z) {
        this.r = z;
    }

    void setScrollState(int i) {
        if (this.K == i) {
            return;
        }
        this.K = i;
    }

    public void setStartView(View view) {
        View view2 = this.e;
        if (view != view2) {
            if (view2 != null) {
                removeView(view2);
            }
            this.e = view;
            if (view != null) {
                addView(view, 0);
            }
            requestLayout();
        }
    }

    public void setViewStyle(int i) {
        if (this.c != i) {
            this.c = i;
            requestLayout();
        }
    }
}
