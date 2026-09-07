package com.json;

import com.json.environment.thread.IronSourceThreadManager;
import com.json.mediationsdk.adunit.adapter.utility.AdInfo;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.logger.IronSourceError;
import com.json.mediationsdk.sdk.LevelPlayBannerListener;

/* JADX INFO: loaded from: classes7.dex */
public class t5 extends t7 {
    private static final t5 d = new t5();
    private LevelPlayBannerListener b = null;
    private LevelPlayBannerListener c = null;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f4442a;

        a(AdInfo adInfo) {
            this.f4442a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (t5.this.b != null) {
                t5.this.b.onAdLeftApplication(t5.this.a(this.f4442a));
                IronLog.CALLBACK.info("onAdLeftApplication() adInfo = " + t5.this.a(this.f4442a));
            }
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f4443a;

        b(AdInfo adInfo) {
            this.f4443a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (t5.this.c != null) {
                t5.this.c.onAdClicked(t5.this.a(this.f4443a));
                IronLog.CALLBACK.info("onAdClicked() adInfo = " + t5.this.a(this.f4443a));
            }
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f4444a;

        c(AdInfo adInfo) {
            this.f4444a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (t5.this.b != null) {
                t5.this.b.onAdClicked(t5.this.a(this.f4444a));
                IronLog.CALLBACK.info("onAdClicked() adInfo = " + t5.this.a(this.f4444a));
            }
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f4445a;

        d(AdInfo adInfo) {
            this.f4445a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (t5.this.c != null) {
                t5.this.c.onAdLoaded(t5.this.a(this.f4445a));
                IronLog.CALLBACK.info("onAdLoaded() adInfo = " + t5.this.a(this.f4445a));
            }
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f4446a;

        e(AdInfo adInfo) {
            this.f4446a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (t5.this.b != null) {
                t5.this.b.onAdLoaded(t5.this.a(this.f4446a));
                IronLog.CALLBACK.info("onAdLoaded() adInfo = " + t5.this.a(this.f4446a));
            }
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f4447a;

        f(IronSourceError ironSourceError) {
            this.f4447a = ironSourceError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (t5.this.c != null) {
                t5.this.c.onAdLoadFailed(this.f4447a);
                IronLog.CALLBACK.info("onAdLoadFailed() error = " + this.f4447a.getErrorMessage());
            }
        }
    }

    class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f4448a;

        g(IronSourceError ironSourceError) {
            this.f4448a = ironSourceError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (t5.this.b != null) {
                t5.this.b.onAdLoadFailed(this.f4448a);
                IronLog.CALLBACK.info("onAdLoadFailed() error = " + this.f4448a.getErrorMessage());
            }
        }
    }

    class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f4449a;

        h(AdInfo adInfo) {
            this.f4449a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (t5.this.c != null) {
                t5.this.c.onAdScreenPresented(t5.this.a(this.f4449a));
                IronLog.CALLBACK.info("onAdScreenPresented() adInfo = " + t5.this.a(this.f4449a));
            }
        }
    }

    class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f4450a;

        i(AdInfo adInfo) {
            this.f4450a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (t5.this.b != null) {
                t5.this.b.onAdScreenPresented(t5.this.a(this.f4450a));
                IronLog.CALLBACK.info("onAdScreenPresented() adInfo = " + t5.this.a(this.f4450a));
            }
        }
    }

    class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f4451a;

        j(AdInfo adInfo) {
            this.f4451a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (t5.this.c != null) {
                t5.this.c.onAdScreenDismissed(t5.this.a(this.f4451a));
                IronLog.CALLBACK.info("onAdScreenDismissed() adInfo = " + t5.this.a(this.f4451a));
            }
        }
    }

    class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f4452a;

        k(AdInfo adInfo) {
            this.f4452a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (t5.this.b != null) {
                t5.this.b.onAdScreenDismissed(t5.this.a(this.f4452a));
                IronLog.CALLBACK.info("onAdScreenDismissed() adInfo = " + t5.this.a(this.f4452a));
            }
        }
    }

    class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f4453a;

        l(AdInfo adInfo) {
            this.f4453a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (t5.this.c != null) {
                t5.this.c.onAdLeftApplication(t5.this.a(this.f4453a));
                IronLog.CALLBACK.info("onAdLeftApplication() adInfo = " + t5.this.a(this.f4453a));
            }
        }
    }

    private t5() {
    }

    public static t5 a() {
        return d;
    }

    public void a(IronSourceError ironSourceError) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new f(ironSourceError));
        } else if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new g(ironSourceError));
        }
    }

    public void a(LevelPlayBannerListener levelPlayBannerListener) {
        this.b = levelPlayBannerListener;
    }

    public LevelPlayBannerListener b() {
        return this.b;
    }

    public void b(AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new b(adInfo));
        } else if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new c(adInfo));
        }
    }

    public void b(LevelPlayBannerListener levelPlayBannerListener) {
        this.c = levelPlayBannerListener;
    }

    public void c(AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new l(adInfo));
        } else if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new a(adInfo));
        }
    }

    public void d(AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new d(adInfo));
        } else if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new e(adInfo));
        }
    }

    public void e(AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new j(adInfo));
        } else if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new k(adInfo));
        }
    }

    public void f(AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new h(adInfo));
        } else if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new i(adInfo));
        }
    }
}
