package sg.bigo.ads.common.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;
import sg.bigo.ads.common.utils.u;

/* JADX INFO: loaded from: classes9.dex */
public abstract class a extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13338a;
    private boolean b;
    private AbstractRunnableC0878a c;

    /* JADX INFO: renamed from: sg.bigo.ads.common.view.a$a, reason: collision with other inner class name */
    static abstract class AbstractRunnableC0878a implements Runnable {
        boolean b;

        private AbstractRunnableC0878a() {
        }

        /* synthetic */ AbstractRunnableC0878a(byte b) {
            this();
        }

        protected abstract void a();

        @Override // java.lang.Runnable
        public void run() {
            if (this.b) {
                return;
            }
            a();
        }
    }

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13338a = 3000;
        this.b = false;
    }

    private synchronized void a(boolean z) {
        AbstractRunnableC0878a abstractRunnableC0878a = this.c;
        if (abstractRunnableC0878a != null) {
            abstractRunnableC0878a.b = true;
            this.c = null;
        }
        if (z) {
            AbstractRunnableC0878a abstractRunnableC0878a2 = new AbstractRunnableC0878a() { // from class: sg.bigo.ads.common.view.a.1
                @Override // sg.bigo.ads.common.view.a.AbstractRunnableC0878a
                protected final void a() {
                    if (a.this.b && a.this.b() && u.c(a.this) && sg.bigo.ads.common.ab.a.a(a.this, new Rect())) {
                        a.this.a();
                    }
                    a aVar = a.this;
                    aVar.postDelayed(this, aVar.f13338a);
                }
            };
            this.c = abstractRunnableC0878a2;
            postDelayed(abstractRunnableC0878a2, this.f13338a);
        }
    }

    protected abstract void a();

    protected abstract boolean b();

    public final void c() {
        if (this.b) {
            return;
        }
        this.b = true;
        a(true);
    }

    public final void d() {
        this.b = false;
        a(false);
    }

    public int getFlipInterval() {
        return this.f13338a;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a(false);
    }

    public void setFlipInterval(int i) {
        this.f13338a = i;
    }
}
