package io.bidmachine.rendering.ad.fullscreen;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import io.bidmachine.iab.utils.Utils;
import io.bidmachine.rendering.ad.view.AdView;
import io.bidmachine.rendering.ad.view.AdViewListener;
import io.bidmachine.rendering.internal.c;
import io.bidmachine.rendering.internal.d;
import io.bidmachine.rendering.model.AdParams;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.model.PrivacySheetParams;
import io.bidmachine.rendering.utils.UiUtils;
import io.bidmachine.util.Executable;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes13.dex */
public class FullScreenAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f12325a = new d();
    private final AdView b;
    private FullScreenAdListener c;
    private WeakReference d;

    private class b implements AdViewListener {
        private b() {
        }

        @Override // io.bidmachine.rendering.ad.AdListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onAdAppeared(AdView adView) {
            FullScreenAd.this.k();
        }

        @Override // io.bidmachine.rendering.ad.AdListener
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onAdClicked(AdView adView) {
            FullScreenAd.this.l();
        }

        @Override // io.bidmachine.rendering.ad.AdListener
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onAdDisappeared(AdView adView) {
            FullScreenAd.this.m();
        }

        @Override // io.bidmachine.rendering.ad.AdListener
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onAdExpired(AdView adView) {
            FullScreenAd.this.n();
        }

        @Override // io.bidmachine.rendering.ad.AdListener
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void onAdFinished(AdView adView) {
            FullScreenAd.this.r();
        }

        @Override // io.bidmachine.rendering.ad.AdListener
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onAdLoaded(AdView adView) {
            FullScreenAd.this.p();
        }

        @Override // io.bidmachine.rendering.ad.AdListener
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void onAdShown(AdView adView) {
            FullScreenAd.this.q();
        }

        @Override // io.bidmachine.rendering.ad.AdListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onAdFailToLoad(AdView adView, Error error) {
            FullScreenAd.this.c(error);
        }

        @Override // io.bidmachine.rendering.ad.AdListener
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onAdFailToShow(AdView adView, Error error) {
            FullScreenAd.this.d(error);
        }

        @Override // io.bidmachine.rendering.ad.AdListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onOpenPrivacySheet(AdView adView, PrivacySheetParams privacySheetParams) {
            FullScreenAd.this.b(privacySheetParams);
        }
    }

    public FullScreenAd(Context context, AdParams adParams) {
        this.b = new AdView(context.getApplicationContext(), adParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        FullScreenAdListener fullScreenAdListener = this.c;
        if (fullScreenAdListener != null) {
            fullScreenAdListener.onAdExpired(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        FullScreenAdListener fullScreenAdListener = this.c;
        if (fullScreenAdListener != null) {
            fullScreenAdListener.onAdFinished(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        FullScreenAdListener fullScreenAdListener = this.c;
        if (fullScreenAdListener != null) {
            fullScreenAdListener.onAdLoaded(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        FullScreenAdListener fullScreenAdListener = this.c;
        if (fullScreenAdListener != null) {
            fullScreenAdListener.onAdShown(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.f12325a.b(true)) {
            UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.ad.fullscreen.FullScreenAd$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.d();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.f12325a.e();
        UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.ad.fullscreen.FullScreenAd$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.e();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.f12325a.b(false)) {
            UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.ad.fullscreen.FullScreenAd$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.f();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.f12325a.j()) {
            UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.ad.fullscreen.FullScreenAd$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.g();
                }
            });
        }
    }

    private void o() {
        if (this.f12325a.i()) {
            UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.ad.fullscreen.FullScreenAd$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.h();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.f12325a.a(true)) {
            UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.ad.fullscreen.FullScreenAd$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.i();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.f12325a.h()) {
            UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.ad.fullscreen.FullScreenAd$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.j();
                }
            });
        }
    }

    public void destroy() {
        this.f12325a.a();
        this.b.destroy();
        a();
    }

    public boolean isFinished() {
        return this.f12325a.g();
    }

    public boolean isLoaded() {
        return this.f12325a.b();
    }

    public void load() {
        if (this.f12325a.c()) {
            this.b.setAdViewListener(new b());
            this.b.load();
        }
    }

    void r() {
        a();
        m();
        o();
    }

    public void setFullScreenAdListener(FullScreenAdListener fullScreenAdListener) {
        this.c = fullScreenAdListener;
    }

    public void show(Context context) {
        if (isLoaded()) {
            FullScreenActivity.show(context, this);
        } else {
            d(new Error("FullScreenAd not loaded"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        FullScreenAdListener fullScreenAdListener = this.c;
        if (fullScreenAdListener != null) {
            fullScreenAdListener.onAdAppeared(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        FullScreenAdListener fullScreenAdListener = this.c;
        if (fullScreenAdListener != null) {
            fullScreenAdListener.onAdClicked(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        FullScreenAdListener fullScreenAdListener = this.c;
        if (fullScreenAdListener != null) {
            fullScreenAdListener.onAdDisappeared(this);
        }
    }

    void b() {
        WeakReference weakReference = this.d;
        if (weakReference != null) {
            weakReference.clear();
            this.d = null;
        }
    }

    Activity c() {
        WeakReference weakReference = this.d;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Error error) {
        FullScreenAdListener fullScreenAdListener = this.c;
        if (fullScreenAdListener != null) {
            fullScreenAdListener.onAdFailToShow(this, error);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final Error error) {
        if (this.f12325a.a(false)) {
            UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.ad.fullscreen.FullScreenAd$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(error);
                }
            });
        }
    }

    void d(final Error error) {
        UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.ad.fullscreen.FullScreenAd$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final PrivacySheetParams privacySheetParams) {
        UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.ad.fullscreen.FullScreenAd$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(privacySheetParams);
            }
        });
    }

    void a(Activity activity) {
        this.d = new WeakReference(activity);
    }

    private void a() {
        Activity activityC = c();
        if (activityC != null) {
            try {
                Utils.finishActivityWithoutAnimation(activityC);
            } catch (Throwable unused) {
            }
        }
        b();
    }

    void b(Activity activity) {
        a(activity);
        UiUtils.setupActivityOrientation(activity, this.b.getRequiredOrientation());
        Utils.applyFullscreenActivityFlags(activity);
        Utils.removeFromParent(this.b);
        UiUtils.applyInsets(activity, this.b, false);
        activity.setContentView(this.b, new ViewGroup.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Error error) {
        FullScreenAdListener fullScreenAdListener = this.c;
        if (fullScreenAdListener != null) {
            fullScreenAdListener.onAdFailToLoad(this, error);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final PrivacySheetParams privacySheetParams) {
        io.bidmachine.util.Utils.ifNotNull(this.c, new Executable() { // from class: io.bidmachine.rendering.ad.fullscreen.FullScreenAd$$ExternalSyntheticLambda10
            @Override // io.bidmachine.util.Executable
            public final void execute(Object obj) {
                this.f$0.a(privacySheetParams, (FullScreenAdListener) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(PrivacySheetParams privacySheetParams, FullScreenAdListener fullScreenAdListener) {
        fullScreenAdListener.onOpenPrivacySheet(this, privacySheetParams);
    }
}
