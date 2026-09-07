package sg.bigo.ads.common.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.common.view.a.c;
import sg.bigo.ads.common.view.a.d;

/* JADX INFO: loaded from: classes8.dex */
public class RealtimeBlurLinearLayout extends LinearLayout implements c<RealtimeBlurLinearLayout> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d<RealtimeBlurLinearLayout> f13323a;

    public RealtimeBlurLinearLayout(Context context) {
        this(context, null);
    }

    public RealtimeBlurLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RealtimeBlurLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d<RealtimeBlurLinearLayout> dVar = new d<>(this);
        this.f13323a = dVar;
        setBackground(dVar.d);
    }

    @Override // android.view.View
    public Drawable getBackground() {
        Drawable background = super.getBackground();
        return background instanceof sg.bigo.ads.common.view.a.a ? ((sg.bigo.ads.common.view.a.a) background).f13210a : background;
    }

    public sg.bigo.ads.common.view.a.b getBlurStyle() {
        return this.f13323a.d.b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d<RealtimeBlurLinearLayout> dVar = this.f13323a;
        dVar.f = u.a(dVar.c, dVar.b);
        if (dVar.f == null) {
            dVar.g = false;
            return;
        }
        dVar.f.getViewTreeObserver().addOnPreDrawListener(dVar.h);
        dVar.a();
        dVar.g = dVar.f.getRootView() != dVar.b.getRootView();
        if (dVar.g) {
            dVar.f.postInvalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        d<RealtimeBlurLinearLayout> dVar = this.f13323a;
        if (dVar.f != null) {
            dVar.f.getViewTreeObserver().removeOnPreDrawListener(dVar.h);
        }
        dVar.b();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        d<RealtimeBlurLinearLayout> dVar = this.f13323a;
        if (drawable != dVar.d) {
            dVar.d.a(drawable);
            dVar.b();
        }
        super.setBackground(dVar.d);
    }

    @Override // sg.bigo.ads.common.view.a.c
    public void setBlurStyle(sg.bigo.ads.common.view.a.b bVar) {
        this.f13323a.setBlurStyle(bVar);
    }
}
