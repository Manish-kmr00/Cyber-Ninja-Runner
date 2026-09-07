package com.ogury.ad.internal;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.Logger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class h extends FrameLayout implements t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7310a;
    public int b;
    public final v6 c;
    public r1 d;
    public e8 e;
    public Function1<? super h, Unit> f;
    public Function1<? super h, Unit> g;
    public Function0<Unit> h;
    public Function0<Unit> i;
    public Function0<Unit> j;
    public Function0<Unit> k;
    public Function0<Unit> l;
    public boolean m;
    public boolean n;
    public e8 o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.c = new v6(0);
        this.d = s1.e;
        setLayoutParams(new FrameLayout.LayoutParams(600, 600));
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.ogury.ad.internal.h$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                h.a(this.f$0, view, i, i2, i3, i4, i5, i6, i7, i8);
            }
        });
    }

    public static final void a(h hVar, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Function1<? super h, Unit> function1 = hVar.f;
        if (function1 != null) {
            function1.invoke(hVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View child, ViewGroup.LayoutParams params) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(params, "params");
        if (!(child instanceof WebView) || getChildCount() <= 0) {
            super.addView(child, params);
        } else {
            addView(child, getChildCount() - 1, params);
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001f  */
    /* JADX WARN: Code duplicated, block: B:13:0x0027  */
    /* JADX WARN: Code duplicated, block: B:15:0x0031 A[LOOP:0: B:8:0x001b->B:15:0x0031, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:21:0x0034 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:22:0x0023 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x001a A[EDGE_INSN: B:23:0x001a->B:7:0x001a BREAK  A[LOOP:0: B:8:0x001b->B:15:0x0031], SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x001a -> B:8:0x001b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final boolean b() {
        /*
            r3 = this;
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.view.View r0 = r3.getRootView()
            r1 = 0
            if (r0 == 0) goto L1a
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r0 = r0.findViewById(r2)
            if (r0 == 0) goto L1a
            android.content.Context r0 = r0.getContext()
            goto L1b
        L1a:
            r0 = r1
        L1b:
            boolean r2 = r0 instanceof android.content.ContextWrapper
            if (r2 == 0) goto L34
            boolean r2 = r0 instanceof android.app.Activity
            if (r2 == 0) goto L27
            r1 = r0
            android.app.Activity r1 = (android.app.Activity) r1
            goto L34
        L27:
            android.content.ContextWrapper r0 = (android.content.ContextWrapper) r0
            android.content.Context r0 = r0.getBaseContext()
            boolean r2 = r0 instanceof android.content.ContextWrapper
            if (r2 == 0) goto L1a
            android.content.ContextWrapper r0 = (android.content.ContextWrapper) r0
            goto L1b
        L34:
            if (r1 != 0) goto L38
            r0 = 1
            return r0
        L38:
            boolean r0 = r1.hasWindowFocus()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ogury.ad.internal.h.b():boolean");
    }

    public final void c() {
        setX(0.0f);
        setY(0.0f);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        setLayoutParams(layoutParams2);
    }

    public final void d() {
        ViewGroup parentAsViewGroup = getParentAsViewGroup();
        if (parentAsViewGroup != null) {
            parentAsViewGroup.removeView(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Logger.d("Ogury|SafeDK: Execution> Lcom/ogury/ad/internal/h;->dispatchTouchEvent(Landroid/view/MotionEvent;)Z");
        DetectTouchUtils.viewOnTouch("io.presage", this, motionEvent);
        return safedk_h_dispatchTouchEvent_35e00d1743b42f5842222f95079d7245(motionEvent);
    }

    public final void e() {
        setX(0.0f);
        setY(0.0f);
        ViewParent parent = getParent();
        e8 e8VarA = null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return;
        }
        if (this.n) {
            v6 v6Var = this.c;
            e8 e8Var = this.o;
            v6Var.getClass();
            if (e8Var != null) {
                int i = e8Var.d;
                int i2 = e8Var.e;
                Rect rect = new Rect(i, i2, e8Var.b + i, e8Var.c + i2);
                v6Var.f7422a.getClass();
                Rect rectA = z9.a(viewGroup);
                rect.offset(rectA.left, rectA.top);
                e8VarA = v6Var.a(viewGroup, rect);
                if (e8VarA != null) {
                    e8VarA.f = e8Var.f;
                }
            }
            this.e = e8VarA;
        } else {
            this.e = this.o;
        }
        setContainerWidth(viewGroup.getMeasuredWidth());
        setContainerHeight(viewGroup.getMeasuredHeight());
    }

    public final Function1<h, Unit> getAdLayoutChangeListener() {
        return this.f;
    }

    @Override // com.ogury.ad.internal.t1
    public int getContainerHeight() {
        return this.f7310a;
    }

    @Override // com.ogury.ad.internal.t1
    public int getContainerWidth() {
        return this.b;
    }

    public final boolean getContainsOverlayAd() {
        return this.n;
    }

    public final Function0<Unit> getOnAttachToWindowListener() {
        return this.j;
    }

    public final Function0<Unit> getOnDetachFromWindowListener() {
        return this.k;
    }

    public final Function1<h, Unit> getOnMouseUpListener() {
        return this.g;
    }

    public final Function0<Unit> getOnOverlayPositionChanged() {
        return this.l;
    }

    public final Function0<Unit> getOnWindowGainFocusListener() {
        return this.h;
    }

    public final Function0<Unit> getOnWindowLoseFocusListener() {
        return this.i;
    }

    public final ViewGroup getParentAsViewGroup() {
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            return (ViewGroup) parent;
        }
        return null;
    }

    public final e8 getResizeProps() {
        return this.e;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        if (this.n) {
            w5.b = true;
        }
        super.onAttachedToWindow();
        Function0<Unit> function0 = this.j;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.m = false;
        if (this.n) {
            w5.b = false;
        }
        super.onDetachedFromWindow();
        Function0<Unit> function0 = this.k;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        ViewGroup container = getParentAsViewGroup();
        if (container == null) {
            return;
        }
        if (!this.m && this.n) {
            if (getContainerHeight() != container.getMeasuredHeight() || getContainerWidth() != container.getMeasuredWidth()) {
                v6 v6Var = this.c;
                v6Var.getClass();
                Intrinsics.checkNotNullParameter(this, "adLayout");
                Intrinsics.checkNotNullParameter(container, "container");
                v6Var.f7422a.getClass();
                Rect rectA = z9.a(this);
                setOnMouseUpListener(new u6(v6Var));
                a(v6Var.a(container, rectA));
            }
            Function0<Unit> function0 = this.l;
            if (function0 != null) {
                function0.invoke();
            }
        }
        setContainerWidth(container.getMeasuredWidth());
        setContainerHeight(container.getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            Function0<Unit> function0 = this.h;
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        Function0<Unit> function1 = this.i;
        if (function1 != null) {
            function1.invoke();
        }
    }

    public boolean safedk_h_dispatchTouchEvent_35e00d1743b42f5842222f95079d7245(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (this.d.a(ev)) {
            return true;
        }
        return super.dispatchTouchEvent(ev);
    }

    public final void setAdLayoutChangeListener(Function1<? super h, Unit> function1) {
        this.f = function1;
    }

    public void setContainerHeight(int i) {
        this.f7310a = i;
    }

    public void setContainerWidth(int i) {
        this.b = i;
    }

    public final void setContainsOverlayAd(boolean z) {
        this.n = z;
    }

    public final void setDisplayedInFullScreen(boolean z) {
        this.m = z;
    }

    public final void setInitialSize(e8 initialSize) {
        Intrinsics.checkNotNullParameter(initialSize, "initialSize");
        this.o = initialSize;
        setX(0.0f);
        setY(0.0f);
        a(initialSize);
    }

    public final void setInitialSizeWithoutResizing(e8 initialSize) {
        Intrinsics.checkNotNullParameter(initialSize, "initialSize");
        this.o = initialSize;
    }

    public final void setOnAttachToWindowListener(Function0<Unit> function0) {
        this.j = function0;
    }

    public final void setOnDetachFromWindowListener(Function0<Unit> function0) {
        this.k = function0;
    }

    public final void setOnMouseUpListener(Function1<? super h, Unit> function1) {
        this.g = function1;
    }

    public final void setOnOverlayPositionChanged(Function0<Unit> function0) {
        this.l = function0;
    }

    public final void setOnWindowGainFocusListener(Function0<Unit> function0) {
        this.h = function0;
    }

    public final void setOnWindowLoseFocusListener(Function0<Unit> function0) {
        this.i = function0;
    }

    public final void setResizeProps(e8 e8Var) {
        this.e = e8Var;
    }

    public final void setupDrag(boolean z) {
        Intrinsics.checkNotNullParameter(this, "adLayout");
        this.d = z ? new s1(this) : s1.e;
    }

    @Override // com.ogury.ad.internal.t1
    public final void a() {
        Function0<Unit> function0;
        Function1<? super h, Unit> function1 = this.g;
        if (function1 != null) {
            function1.invoke(this);
        }
        Function1<? super h, Unit> function2 = this.f;
        if (function2 != null) {
            function2.invoke(this);
        }
        if (this.m || !this.n || (function0 = this.l) == null) {
            return;
        }
        function0.invoke();
    }

    public final void a(e8 e8Var) {
        if (e8Var == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        setX(e8Var.d);
        setY(e8Var.e);
        layoutParams2.width = e8Var.b;
        layoutParams2.height = e8Var.c;
        layoutParams2.gravity = e8Var.f;
        setLayoutParams(layoutParams2);
    }
}
