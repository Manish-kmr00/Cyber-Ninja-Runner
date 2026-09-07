package io.bidmachine.rendering.ad.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import io.bidmachine.rendering.internal.l;
import io.bidmachine.rendering.internal.m;
import io.bidmachine.rendering.internal.v;
import io.bidmachine.rendering.internal.view.d;
import io.bidmachine.rendering.internal.view.e;
import io.bidmachine.rendering.internal.view.f;
import io.bidmachine.rendering.internal.w;
import io.bidmachine.rendering.model.AdParams;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.model.Orientation;
import io.bidmachine.rendering.model.PrivacySheetParams;
import io.bidmachine.rendering.utils.Tag;
import io.bidmachine.rendering.utils.UiUtils;
import io.bidmachine.util.Executable;
import io.bidmachine.util.Utils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes8.dex */
public class AdView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Tag f12327a;
    private final io.bidmachine.rendering.internal.c b;
    private final io.bidmachine.rendering.internal.controller.a c;
    private final e d;
    private final e e;
    private final d f;
    private final v g;
    private AdViewListener h;
    private boolean i;

    /* JADX INFO: Access modifiers changed from: private */
    static class b implements io.bidmachine.rendering.internal.controller.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference f12328a;

        private b(AdView adView) {
            this.f12328a = new WeakReference(adView);
        }

        @Override // io.bidmachine.rendering.internal.controller.c
        public void b() {
            AdView adView = (AdView) this.f12328a.get();
            if (adView != null) {
                adView.a();
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.c
        public void c(io.bidmachine.rendering.internal.controller.a aVar) {
            AdView adView = (AdView) this.f12328a.get();
            if (adView != null) {
                adView.q();
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.c
        public void d() {
            AdView adView = (AdView) this.f12328a.get();
            if (adView != null) {
                adView.s();
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.c
        public void e() {
            AdView adView = (AdView) this.f12328a.get();
            if (adView != null) {
                adView.d(new Error("Ad loading timeout after display"));
                adView.a();
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.c
        public void onAdClicked() {
            AdView adView = (AdView) this.f12328a.get();
            if (adView != null) {
                adView.l();
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.c
        public void a(io.bidmachine.rendering.internal.controller.a aVar) {
            AdView adView = (AdView) this.f12328a.get();
            if (adView != null) {
                adView.n();
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.c
        public void b(io.bidmachine.rendering.internal.controller.a aVar) {
            AdView adView = (AdView) this.f12328a.get();
            if (adView != null) {
                adView.r();
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.c
        public void c() {
            AdView adView = (AdView) this.f12328a.get();
            if (adView != null) {
                adView.b();
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.c
        public void a(io.bidmachine.rendering.internal.controller.a aVar, Error error) {
            AdView adView = (AdView) this.f12328a.get();
            if (adView != null) {
                adView.e(error);
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.c
        public void b(f fVar) {
            AdView adView = (AdView) this.f12328a.get();
            if (adView != null) {
                adView.a(fVar);
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.c
        public void a(final PrivacySheetParams privacySheetParams) {
            Utils.ifNotNull((AdView) this.f12328a.get(), new Executable() { // from class: io.bidmachine.rendering.ad.view.AdView$b$$ExternalSyntheticLambda0
                @Override // io.bidmachine.util.Executable
                public final void execute(Object obj) {
                    AdView.a((AdView) obj, privacySheetParams);
                }
            });
        }

        @Override // io.bidmachine.rendering.internal.controller.c
        public void a(io.bidmachine.rendering.internal.controller.d dVar) {
            AdView adView = (AdView) this.f12328a.get();
            if (adView != null) {
                adView.a(dVar);
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.c
        public void a(io.bidmachine.rendering.internal.controller.d dVar, Error error) {
            AdView adView = (AdView) this.f12328a.get();
            if (adView != null) {
                adView.f(error);
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.c
        public void a(f fVar) {
            AdView adView = (AdView) this.f12328a.get();
            if (adView != null) {
                adView.d(fVar);
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.c
        public void a() {
            AdView adView = (AdView) this.f12328a.get();
            if (adView != null) {
                adView.x();
            }
        }
    }

    private static class c implements v.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference f12329a;

        private c(AdView adView) {
            this.f12329a = new WeakReference(adView);
        }

        @Override // io.bidmachine.rendering.internal.v.a
        public void a() {
            AdView adView = (AdView) this.f12329a.get();
            if (adView != null) {
                adView.t();
            }
        }

        @Override // io.bidmachine.rendering.internal.v.a
        public void b() {
            AdView adView = (AdView) this.f12329a.get();
            if (adView != null) {
                adView.u();
            }
        }
    }

    public AdView(Context context, AdParams adParams) {
        super(context);
        this.f12327a = new Tag("AdView");
        this.b = new io.bidmachine.rendering.internal.d();
        this.c = new io.bidmachine.rendering.internal.controller.b(context, adParams, new b());
        e eVar = new e(context);
        this.d = eVar;
        addView(eVar, new ViewGroup.LayoutParams(-1, -1));
        e eVar2 = new e(context);
        this.e = eVar2;
        addView(eVar2, new ViewGroup.LayoutParams(-1, -1));
        d dVar = new d(context);
        this.f = dVar;
        addView(dVar, new ViewGroup.LayoutParams(-1, -1));
        dVar.a();
        this.g = new w(this, adParams.getVisibilityParams(), new c());
        this.i = false;
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    private void k() {
        if (this.b.b(true)) {
            m.b(this.f12327a, "notifyAdAppeared", new Object[0]);
            UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.ad.view.AdView$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.d();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.b.e();
        m.b(this.f12327a, "notifyAdClicked", new Object[0]);
        UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.ad.view.AdView$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.e();
            }
        });
    }

    private void m() {
        if (this.b.b(false)) {
            m.b(this.f12327a, "notifyAdDisappeared", new Object[0]);
            UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.ad.view.AdView$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.f();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.b.j()) {
            m.b(this.f12327a, "notifyAdExpired", new Object[0]);
            UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.ad.view.AdView$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.g();
                }
            });
        }
    }

    private void o() {
        if (this.b.i()) {
            m.b(this.f12327a, "notifyAdFinished", new Object[0]);
            UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.ad.view.AdView$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.h();
                }
            });
        }
    }

    private void p() {
        if (this.b.a(true)) {
            m.b(this.f12327a, "notifyAdLoaded", new Object[0]);
            UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.ad.view.AdView$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.i();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.b.h()) {
            m.b(this.f12327a, "notifyAdShown", new Object[0]);
            UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.ad.view.AdView$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.j();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        m.b(this.f12327a, "onPreparingForShowStarted", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        m.b(this.f12327a, "onViewOnScreen", new Object[0]);
        this.c.e();
        this.c.onShown();
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        m.b(this.f12327a, "onViewOutOfScreen", new Object[0]);
        v();
    }

    private void v() {
        this.g.stop();
        this.c.d();
        m();
    }

    private void w() {
        if (this.i && UiUtils.isViewVisible(this)) {
            this.b.k();
            this.g.start();
            if (this.g.b()) {
                t();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        this.f.c();
    }

    public void destroy() {
        m.b(this.f12327a, "destroy", new Object[0]);
        this.g.a();
        this.h = null;
        this.b.a();
        this.c.a();
        UiUtils.onUiThread(new l() { // from class: io.bidmachine.rendering.ad.view.AdView$$ExternalSyntheticLambda13
            @Override // io.bidmachine.rendering.utils.SafeRunnable
            public final void onRun() {
                this.f$0.c();
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch("io.bidmachine", this, me);
        return super.dispatchTouchEvent(me);
    }

    public Orientation getRequiredOrientation() {
        return this.c.b();
    }

    public boolean isLoaded() {
        return this.b.b();
    }

    public void load() {
        if (this.b.c()) {
            this.c.c();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m.b(this.f12327a, "onAttachedToWindow", new Object[0]);
        this.i = true;
        w();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m.b(this.f12327a, "onDetachedFromWindow", new Object[0]);
        this.i = false;
        v();
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
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        m.b(this.f12327a, "onVisibilityChanged - %s", UiUtils.toString(i));
        if (UiUtils.isViewVisible(i)) {
            w();
        } else {
            v();
        }
    }

    public void setAdViewListener(AdViewListener adViewListener) {
        this.h = adViewListener;
    }

    @Override // android.view.View
    public String toString() {
        return this.f12327a.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        AdViewListener adViewListener = this.h;
        if (adViewListener != null) {
            adViewListener.onAdAppeared(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        AdViewListener adViewListener = this.h;
        if (adViewListener != null) {
            adViewListener.onAdClicked(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        AdViewListener adViewListener = this.h;
        if (adViewListener != null) {
            adViewListener.onAdDisappeared(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        AdViewListener adViewListener = this.h;
        if (adViewListener != null) {
            adViewListener.onAdExpired(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        AdViewListener adViewListener = this.h;
        if (adViewListener != null) {
            adViewListener.onAdFinished(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        AdViewListener adViewListener = this.h;
        if (adViewListener != null) {
            adViewListener.onAdLoaded(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        AdViewListener adViewListener = this.h;
        if (adViewListener != null) {
            adViewListener.onAdShown(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        this.d.removeAllViews();
        this.e.removeAllViews();
        this.f.removeAllViews();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final Error error) {
        if (this.b.f()) {
            m.a(this.f12327a, "notifyAdFailToShow - %s", error);
            UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.ad.view.AdView$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b(error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Error error) {
        c(error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Error error) {
        m.a(this.f12327a, "onPreparingForShowFail - %s", error);
        d(new Error("No phase loaded"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(AdView adView, PrivacySheetParams privacySheetParams) {
        adView.c(privacySheetParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.f.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(f fVar) {
        if (fVar.getParent() == this) {
            return;
        }
        io.bidmachine.iab.utils.Utils.removeFromParent(fVar);
        addView(fVar, new ViewGroup.LayoutParams(-1, -1));
        fVar.bringToFront();
        fVar.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final f fVar) {
        m.b(this.f12327a, "showPlaceholder (%s)", fVar);
        UiUtils.onUiThread(new l() { // from class: io.bidmachine.rendering.ad.view.AdView$$ExternalSyntheticLambda0
            @Override // io.bidmachine.rendering.utils.SafeRunnable
            public final void onRun() {
                this.f$0.c(fVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(f fVar) {
        removeView(fVar);
    }

    private void c(final Error error) {
        if (this.b.a(false)) {
            m.a(this.f12327a, "notifyAdFailToLoad - %s", error);
            UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.ad.view.AdView$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Error error) {
        AdViewListener adViewListener = this.h;
        if (adViewListener != null) {
            adViewListener.onAdFailToShow(this, error);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PrivacySheetParams privacySheetParams) {
        m.b(this.f12327a, "onOpenPrivacySheet", new Object[0]);
        b(privacySheetParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final f fVar) {
        m.b(this.f12327a, "hidePlaceholder (%s)", fVar);
        UiUtils.onUiThread(new l() { // from class: io.bidmachine.rendering.ad.view.AdView$$ExternalSyntheticLambda9
            @Override // io.bidmachine.rendering.utils.SafeRunnable
            public final void onRun() {
                this.f$0.b(fVar);
            }
        });
    }

    private void b(final PrivacySheetParams privacySheetParams) {
        UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.ad.view.AdView$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(privacySheetParams);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Error error) {
        AdViewListener adViewListener = this.h;
        if (adViewListener != null) {
            adViewListener.onAdFailToLoad(this, error);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(PrivacySheetParams privacySheetParams, AdViewListener adViewListener) {
        adViewListener.onOpenPrivacySheet(this, privacySheetParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final PrivacySheetParams privacySheetParams) {
        Utils.ifNotNull(this.h, new Executable() { // from class: io.bidmachine.rendering.ad.view.AdView$$ExternalSyntheticLambda5
            @Override // io.bidmachine.util.Executable
            public final void execute(Object obj) {
                this.f$0.a(privacySheetParams, (AdViewListener) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(io.bidmachine.rendering.internal.controller.d dVar) {
        m.b(this.f12327a, "onPreparingForShowComplete", new Object[0]);
        b();
        setBackgroundColor(dVar.f().getBackgroundColor());
        io.bidmachine.rendering.internal.e.a(this, this.d, dVar.g());
        io.bidmachine.rendering.internal.e.a(this, this.e, dVar.h());
        w();
    }
}
