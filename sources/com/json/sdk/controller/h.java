package com.json.sdk.controller;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.json.b9;
import com.json.mm;
import com.json.nf;
import com.json.o9;
import com.json.so;
import com.json.u5;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;

/* JADX INFO: loaded from: classes12.dex */
public class h extends FrameLayout implements so {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4318a;
    private v b;
    private final nf c;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup windowDecorViewGroup = h.this.getWindowDecorViewGroup();
            if (windowDecorViewGroup != null) {
                windowDecorViewGroup.addView(h.this);
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup windowDecorViewGroup = h.this.getWindowDecorViewGroup();
            if (windowDecorViewGroup != null) {
                windowDecorViewGroup.removeView(h.this);
            }
        }
    }

    public h(Context context) {
        super(context);
        this.c = mm.S().f();
        this.f4318a = context;
        setClickable(true);
    }

    private void a() {
        ((Activity) this.f4318a).runOnUiThread(new a());
    }

    private void a(int i, int i2) {
        try {
            Context context = this.f4318a;
            if (context != null) {
                int iH = this.c.H(context);
                if (iH == 1) {
                    setPadding(0, i, 0, i2);
                } else if (iH == 2) {
                    setPadding(0, i, i2, 0);
                }
            }
        } catch (Exception e) {
            o9.d().a(e);
        }
    }

    private void b() {
        ((Activity) this.f4318a).runOnUiThread(new b());
    }

    private int getNavigationBarPadding() {
        Activity activity = (Activity) this.f4318a;
        try {
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getDrawingRect(rect);
            Rect rect2 = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect2);
            if (this.c.H(activity) == 1) {
                int i = rect.bottom - rect2.bottom;
                if (i > 0) {
                    return i;
                }
                return 0;
            }
            int i2 = rect.right - rect2.right;
            if (i2 > 0) {
                return i2;
            }
            return 0;
        } catch (Exception e) {
            o9.d().a(e);
            return 0;
        }
    }

    private int getStatusBarHeight() {
        int identifier;
        try {
            Context context = this.f4318a;
            if (context != null && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
                return this.f4318a.getResources().getDimensionPixelSize(identifier);
            }
        } catch (Exception e) {
            o9.d().a(e);
        }
        return 0;
    }

    private int getStatusBarPadding() {
        int statusBarHeight;
        if ((((Activity) this.f4318a).getWindow().getAttributes().flags & 1024) == 0 && (statusBarHeight = getStatusBarHeight()) > 0) {
            return statusBarHeight;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewGroup getWindowDecorViewGroup() {
        Activity activity = (Activity) this.f4318a;
        if (activity != null) {
            return (ViewGroup) activity.getWindow().getDecorView();
        }
        return null;
    }

    public void a(v vVar) {
        this.b = vVar;
        vVar.a(this);
        this.b.E();
        this.f4318a = this.b.q();
        a(getStatusBarPadding(), getNavigationBarPadding());
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.f, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b.F();
        this.b.a(true, b9.h.Z);
    }

    @Override // com.json.so
    public boolean onBackButtonPressed() {
        return u5.a().a((Activity) this.f4318a);
    }

    @Override // com.json.so
    public void onCloseRequested() {
        b();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b.B();
        this.b.a(false, b9.h.Z);
        v vVar = this.b;
        if (vVar != null) {
            vVar.a(v.u.Gone);
            this.b.C();
            this.b.D();
        }
        removeAllViews();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // com.json.so
    public void onOrientationChanged(String str, int i) {
    }
}
