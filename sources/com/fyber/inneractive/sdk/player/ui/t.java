package com.fyber.inneractive.sdk.player.ui;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.Property;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.global.features.v;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.i0;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;

/* JADX INFO: loaded from: classes13.dex */
public abstract class t extends e {
    public final int i;
    public final int j;
    public final int k;
    public ViewGroup l;
    public Button m;
    public int n;
    public int o;
    public boolean p;
    public ViewGroup q;
    public ViewGroup r;
    public final i0 s;
    public i0 t;
    public TextView u;
    public final com.fyber.inneractive.sdk.config.global.r v;
    public ObjectAnimator w;
    public boolean x;
    public final String y;
    public final i0 z;

    public t(Context context, com.fyber.inneractive.sdk.config.global.r rVar, String str) {
        super(context);
        this.n = -1;
        this.o = -1;
        this.p = false;
        this.s = new i0(0, 0);
        this.x = false;
        this.z = new i0(0, 0);
        IAlog.a("%sctor called", IAlog.a(this));
        int tickFractions = getTickFractions();
        this.j = tickFractions;
        this.i = getMaxTickFactor();
        this.k = 1000 / tickFractions;
        setBackgroundColor(getResources().getColor(R.color.ia_video_background_color));
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.v = rVar;
        this.y = str;
    }

    public abstract void a(int i, int i2);

    public abstract void a(com.fyber.inneractive.sdk.flow.endcard.b bVar, b bVar2);

    public abstract void a(boolean z);

    public void a(boolean z, int i, int i2) {
        this.n = i;
        this.o = i2;
        this.p = z;
    }

    public abstract void a(boolean z, com.fyber.inneractive.sdk.ignite.m mVar);

    public abstract void a(boolean z, String str);

    public abstract void b(boolean z);

    public abstract void c(boolean z);

    public abstract void d(boolean z);

    public void destroy() {
        g();
        setVisibility(8);
        if (this.g != null) {
            this.g = null;
        }
        IAlog.a("%sdestroyed called", IAlog.a(this));
    }

    @Override // com.fyber.inneractive.sdk.player.ui.e, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.p, this, me);
        return super.dispatchTouchEvent(me);
    }

    public abstract void e();

    public abstract void e(boolean z);

    public abstract void f();

    public abstract void f(boolean z);

    public abstract void g();

    public abstract void g(boolean z);

    public ViewGroup getDefaultEndCardContainer() {
        return this.q;
    }

    public abstract View getEndCardView();

    public int getMaxTickFactor() {
        return 1000;
    }

    public ViewGroup getTextureHost() {
        return this.l;
    }

    public int getTickFractions() {
        return 5;
    }

    public abstract View[] getTrackingFriendlyView();

    public abstract View[] getTrackingFriendlyViewObstructionPurposeOther();

    public int getVideoHeight() {
        return this.o;
    }

    public int getVideoWidth() {
        return this.n;
    }

    public final boolean h() {
        return this.q.getVisibility() == 0 || this.r.getChildCount() > 0;
    }

    public abstract boolean i();

    public abstract void j();

    public abstract void k();

    public abstract boolean l();

    public abstract void m();

    public abstract void n();

    public abstract void o();

    @Override // com.fyber.inneractive.sdk.player.ui.e, android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        a(this.z, size, size2);
        i0 i0Var = this.z;
        int i3 = i0Var.f2365a;
        if (i3 <= 0 || i0Var.b <= 0) {
            i0Var.f2365a = size;
            i0Var.b = size2;
        } else {
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(this.z.b, 1073741824);
            i = iMakeMeasureSpec;
        }
        if (!this.s.equals(this.z)) {
            i0 i0Var2 = this.s;
            i0 i0Var3 = this.z;
            i0Var2.getClass();
            i0Var2.f2365a = i0Var3.f2365a;
            i0Var2.b = i0Var3.b;
            o();
        }
        super.onMeasure(i, i2);
    }

    public abstract void setAppInfoButtonRound(TextView textView);

    public abstract void setMuteButtonState(boolean z);

    public abstract void setRemainingTime(String str);

    public abstract void setSkipText(String str);

    public void a(com.fyber.inneractive.sdk.flow.endcard.d dVar, b bVar) {
        ViewGroup defaultEndCardContainer = getDefaultEndCardContainer();
        if (defaultEndCardContainer != null) {
            defaultEndCardContainer.setVisibility(0);
            n nVar = this.g;
            com.fyber.inneractive.sdk.flow.endcard.f fVar = (com.fyber.inneractive.sdk.flow.endcard.f) dVar.f();
            fVar.a(bVar, nVar);
            ViewGroup viewGroup = fVar.c;
            AbstractC3256u.a(viewGroup);
            defaultEndCardContainer.addView(viewGroup);
            dVar.a(dVar.d, dVar.b);
        }
    }

    public final void a(boolean z, long j) {
        ViewGroup viewGroup;
        ObjectAnimator objectAnimator = this.w;
        if (objectAnimator != null) {
            if (objectAnimator.getDuration() <= j) {
                ViewGroup viewGroup2 = this.r;
                if (viewGroup2 != null) {
                    a((View) viewGroup2.getParent(), 4);
                }
                this.w.start();
                this.w.addListener(new q(this));
            } else {
                this.x = true;
                this.w = null;
                ViewGroup viewGroup3 = this.r;
                if (viewGroup3 != null && viewGroup3.getParent() != null) {
                    ((View) this.r.getParent()).setOnTouchListener(null);
                }
            }
            if (z && (viewGroup = this.q) != null) {
                viewGroup.setVisibility(0);
                return;
            }
            ViewGroup viewGroup4 = this.r;
            if (viewGroup4 != null) {
                viewGroup4.setVisibility(0);
            }
        }
    }

    public final void a(View view, int i) {
        if (view != null) {
            view.setOnTouchListener(new s(new GestureDetector(view.getContext(), new r(this, view, new int[2], i))));
        }
    }

    public final void a(b bVar) {
        if (this.r != null) {
            if (com.fyber.inneractive.sdk.model.vast.i.Static == bVar.f && !v.NONE.equals(bVar.k)) {
                ViewGroup viewGroup = this.r;
                v vVar = bVar.k;
                int i = bVar.l;
                if (this.x || !v.ZOOM_IN.equals(vVar)) {
                    return;
                }
                ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(viewGroup, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, 0.0f, 1.0f), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, 0.0f, 1.0f));
                this.w = objectAnimatorOfPropertyValuesHolder;
                objectAnimatorOfPropertyValuesHolder.setDuration(i);
                return;
            }
            this.r.setVisibility(0);
        }
    }
}
