package io.bidmachine.iab.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes.dex */
public abstract class IabElementWrapper<T extends View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View.OnClickListener f12239a;
    protected View b;
    protected IabElementStyle c;
    private boolean d = false;
    private final Runnable e = new a();
    private final Animator.AnimatorListener f = new b();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IabElementWrapper.this.d = false;
            IabElementWrapper iabElementWrapper = IabElementWrapper.this;
            View view = iabElementWrapper.b;
            if (view == null || iabElementWrapper.c == null) {
                return;
            }
            view.animate().alpha(0.0f).setDuration(400L).setListener(IabElementWrapper.this.f).withLayer();
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            animator.removeAllListeners();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            View view = IabElementWrapper.this.b;
            if (view != null) {
                view.setClickable(view.getAlpha() != 0.0f);
            }
        }
    }

    public IabElementWrapper(View.OnClickListener onClickListener) {
        this.f12239a = onClickListener;
    }

    protected void a(Context context, View view, IabElementStyle iabElementStyle) {
    }

    public void attach(Context context, ViewGroup viewGroup, IabElementStyle iabElementStyle) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        IabElementStyle iabElementStyle2;
        IabElementStyle iabElementStyleCopyWith = c(context, iabElementStyle).copyWith(iabElementStyle);
        if (!iabElementStyleCopyWith.isVisible().booleanValue()) {
            detach();
            return;
        }
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a(context, iabElementStyleCopyWith));
            iabElementStyleCopyWith.applyAlignment(layoutParams);
            marginLayoutParams = layoutParams;
        } else {
            if (!(viewGroup instanceof RelativeLayout)) {
                throw new IllegalArgumentException("Parent should be instance of FrameLayout or RelativeLayout");
            }
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a(context, iabElementStyleCopyWith));
            iabElementStyleCopyWith.applyRelativeAlignment(layoutParams2);
            marginLayoutParams = layoutParams2;
        }
        iabElementStyleCopyWith.applyMargin(context, marginLayoutParams);
        View view = this.b;
        if (view == null || (iabElementStyle2 = this.c) == null || a(view, iabElementStyle2, iabElementStyleCopyWith)) {
            Utils.removeFromParent(this.b);
            View viewB = b(context, iabElementStyleCopyWith);
            this.b = viewB;
            viewGroup.addView(viewB, marginLayoutParams);
        } else {
            this.b.setLayoutParams(marginLayoutParams);
            this.b.setVisibility(0);
        }
        this.b.setAlpha(iabElementStyleCopyWith.getOpacity().floatValue());
        iabElementStyleCopyWith.applyPadding(context, this.b);
        this.b.setOnClickListener(this.f12239a);
        this.c = iabElementStyleCopyWith;
        a(this.b, iabElementStyleCopyWith);
        a(context, this.b, iabElementStyleCopyWith);
    }

    abstract View b(Context context, IabElementStyle iabElementStyle);

    public void bringToFront() {
        View view = this.b;
        if (view != null) {
            view.bringToFront();
        }
    }

    protected abstract IabElementStyle c(Context context, IabElementStyle iabElementStyle);

    public void cancelHide() {
        this.d = false;
        View view = this.b;
        if (view == null || this.c == null) {
            return;
        }
        view.animate().cancel();
        this.b.removeCallbacks(this.e);
        this.b.setClickable(true);
        this.b.setAlpha(this.c.getOpacity().floatValue());
    }

    public void detach() {
        if (this.b != null) {
            cancelHide();
            Utils.removeFromParent(this.b);
            this.b = null;
            this.c = null;
        }
    }

    public T getCachedView() {
        return (T) this.b;
    }

    public void invalidate() {
        View view;
        if (!isAttached() || (view = this.b) == null || this.c == null) {
            return;
        }
        a(view.getContext(), this.b, this.c);
    }

    public boolean isAttached() {
        return this.b != null;
    }

    public void setVisibility(int visibility) {
        View view = this.b;
        if (view != null) {
            view.setVisibility(visibility);
        }
    }

    public void toggleHide() {
        IabElementStyle iabElementStyle;
        Float hideAfter;
        if (this.d || this.b == null || (iabElementStyle = this.c) == null || (hideAfter = iabElementStyle.getHideAfter()) == null || hideAfter.floatValue() == 0.0f) {
            return;
        }
        this.d = true;
        this.b.postDelayed(this.e, (long) (hideAfter.floatValue() * 1000.0f));
    }

    public void toggleShow() {
        if (this.b == null || this.c == null) {
            return;
        }
        cancelHide();
        toggleHide();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void a(View view, IabElementStyle iabElementStyle) {
        if (view instanceof IabElement) {
            ((IabElement) view).setStyle(iabElementStyle);
        }
    }

    protected ViewGroup.MarginLayoutParams a(Context context, IabElementStyle iabElementStyle) {
        return new ViewGroup.MarginLayoutParams(iabElementStyle.getWidth(context).intValue(), iabElementStyle.getHeight(context).intValue());
    }

    protected boolean a(View view, IabElementStyle iabElementStyle, IabElementStyle iabElementStyle2) {
        return !TextUtils.equals(iabElementStyle.getStyle(), iabElementStyle2.getStyle());
    }
}
