package io.bidmachine.rendering.internal.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import io.bidmachine.rendering.internal.controller.g;
import io.bidmachine.rendering.internal.i;
import io.bidmachine.rendering.internal.l;
import io.bidmachine.rendering.internal.m;
import io.bidmachine.rendering.model.AdPhaseParams;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.model.PrivacySheetParams;
import io.bidmachine.rendering.utils.Tag;
import io.bidmachine.rendering.utils.UiUtils;

/* JADX INFO: loaded from: classes8.dex */
public class f extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Tag f12381a;
    private final io.bidmachine.rendering.internal.view.d b;
    private final io.bidmachine.rendering.internal.controller.d c;
    private final e d;
    private final e e;
    private d f;

    private final class b implements io.bidmachine.rendering.internal.controller.f {
        private b() {
        }

        @Override // io.bidmachine.rendering.internal.controller.f
        public void a(io.bidmachine.rendering.internal.controller.d dVar, Error error) {
            m.a(f.this.f12381a, "onAdPhaseFailToLoad (%s) - %s", dVar, error);
            dVar.a();
        }

        @Override // io.bidmachine.rendering.internal.controller.f
        public void a(io.bidmachine.rendering.internal.controller.d dVar) {
            m.b(f.this.f12381a, "onAdPhaseLoaded (%s)", dVar);
            f.this.setBackgroundColor(dVar.f().getBackgroundColor());
            f fVar = f.this;
            io.bidmachine.rendering.internal.e.a(fVar, fVar.d, dVar.g());
            f fVar2 = f.this;
            io.bidmachine.rendering.internal.e.a(fVar2, fVar2.e, dVar.h());
            dVar.a(new c());
            f.this.h();
        }
    }

    private final class c implements g {
        private c() {
        }

        @Override // io.bidmachine.rendering.internal.controller.g
        public void a(PrivacySheetParams privacySheetParams) {
        }

        @Override // io.bidmachine.rendering.internal.controller.g
        public void b() {
            f.this.a();
        }

        @Override // io.bidmachine.rendering.internal.controller.g
        public void c() {
            f.this.b.a();
        }

        @Override // io.bidmachine.rendering.internal.controller.g
        public void d() {
        }

        @Override // io.bidmachine.rendering.internal.controller.g
        public void f() {
            f.this.a();
        }

        @Override // io.bidmachine.rendering.internal.controller.g
        public void a() {
            f.this.b.c();
        }
    }

    public interface d {
        void a();

        void onLoaded();
    }

    public f(Context context, AdPhaseParams adPhaseParams) {
        super(context);
        this.f12381a = new Tag("PlaceholderView");
        this.c = new io.bidmachine.rendering.internal.controller.e(context, adPhaseParams == null ? i.a() : adPhaseParams, new b());
        e eVar = new e(context);
        this.d = eVar;
        addView(eVar, new ViewGroup.LayoutParams(-1, -1));
        e eVar2 = new e(context);
        this.e = eVar2;
        addView(eVar2, new ViewGroup.LayoutParams(-1, -1));
        io.bidmachine.rendering.internal.view.d dVar = new io.bidmachine.rendering.internal.view.d(context);
        this.b = dVar;
        addView(dVar, new ViewGroup.LayoutParams(-1, -1));
        dVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        d dVar = this.f;
        if (dVar != null) {
            dVar.onLoaded();
        }
    }

    private void g() {
        m.b(this.f12381a, "notifyPlaceholderClosed", new Object[0]);
        UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.internal.view.f$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.d();
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch("io.bidmachine", this, me);
        return super.dispatchTouchEvent(me);
    }

    public void f() {
        m.b(this.f12381a, "load", new Object[0]);
        this.c.c();
    }

    void h() {
        m.b(this.f12381a, "notifyPlaceholderLoaded", new Object[0]);
        UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.internal.view.f$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.e();
            }
        });
    }

    public void i() {
        this.c.onShown();
    }

    public void j() {
        this.c.d();
    }

    public void k() {
        this.c.e();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public void setListener(d listener) {
        this.f = listener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        this.d.removeAllViews();
        this.e.removeAllViews();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        d dVar = this.f;
        if (dVar != null) {
            dVar.a();
        }
    }

    void a() {
        g();
    }

    public void b() {
        this.c.a();
        UiUtils.onUiThread(new l() { // from class: io.bidmachine.rendering.internal.view.f$$ExternalSyntheticLambda1
            @Override // io.bidmachine.rendering.utils.SafeRunnable
            public final void onRun() {
                this.f$0.c();
            }
        });
    }
}
