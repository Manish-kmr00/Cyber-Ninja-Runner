package com.json;

import com.json.environment.thread.IronSourceThreadManager;
import com.json.mediationsdk.adunit.adapter.utility.AdInfo;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.logger.IronSourceError;
import com.json.mediationsdk.logger.IronSourceLogger;
import com.json.mediationsdk.logger.IronSourceLoggerManager;
import com.json.mediationsdk.sdk.LevelPlayInterstitialListener;

/* JADX INFO: loaded from: classes9.dex */
public class sg extends t7 {
    private static final sg d = new sg();
    private LevelPlayInterstitialListener b = null;
    private LevelPlayInterstitialListener c = null;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f4408a;

        a(AdInfo adInfo) {
            this.f4408a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (sg.this.b != null) {
                sg.this.b.onAdShowSucceeded(sg.this.a(this.f4408a));
                IronLog.CALLBACK.info("onAdShowSucceeded() adInfo = " + sg.this.a(this.f4408a));
            }
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f4409a;
        final /* synthetic */ AdInfo b;

        b(IronSourceError ironSourceError, AdInfo adInfo) {
            this.f4409a = ironSourceError;
            this.b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (sg.this.c != null) {
                sg.this.c.onAdShowFailed(this.f4409a, sg.this.a(this.b));
                IronLog.CALLBACK.info("onAdShowFailed() adInfo = " + sg.this.a(this.b) + ", error = " + this.f4409a.getErrorMessage());
            }
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f4410a;
        final /* synthetic */ AdInfo b;

        c(IronSourceError ironSourceError, AdInfo adInfo) {
            this.f4410a = ironSourceError;
            this.b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (sg.this.b != null) {
                sg.this.b.onAdShowFailed(this.f4410a, sg.this.a(this.b));
                IronLog.CALLBACK.info("onAdShowFailed() adInfo = " + sg.this.a(this.b) + ", error = " + this.f4410a.getErrorMessage());
            }
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f4411a;

        d(AdInfo adInfo) {
            this.f4411a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (sg.this.c != null) {
                sg.this.c.onAdClicked(sg.this.a(this.f4411a));
                IronLog.CALLBACK.info("onAdClicked() adInfo = " + sg.this.a(this.f4411a));
            }
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f4412a;

        e(AdInfo adInfo) {
            this.f4412a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (sg.this.b != null) {
                sg.this.b.onAdClicked(sg.this.a(this.f4412a));
                IronLog.CALLBACK.info("onAdClicked() adInfo = " + sg.this.a(this.f4412a));
            }
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f4413a;

        f(AdInfo adInfo) {
            this.f4413a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (sg.this.c != null) {
                sg.this.c.onAdReady(sg.this.a(this.f4413a));
                IronLog.CALLBACK.info("onAdReady() adInfo = " + sg.this.a(this.f4413a));
            }
        }
    }

    class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f4414a;

        g(AdInfo adInfo) {
            this.f4414a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (sg.this.b != null) {
                sg.this.b.onAdReady(sg.this.a(this.f4414a));
                IronLog.CALLBACK.info("onAdReady() adInfo = " + sg.this.a(this.f4414a));
            }
        }
    }

    class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f4415a;

        h(IronSourceError ironSourceError) {
            this.f4415a = ironSourceError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (sg.this.c != null) {
                sg.this.c.onAdLoadFailed(this.f4415a);
                IronLog.CALLBACK.info("onAdLoadFailed() error = " + this.f4415a.getErrorMessage());
            }
        }
    }

    class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f4416a;

        i(IronSourceError ironSourceError) {
            this.f4416a = ironSourceError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (sg.this.b != null) {
                sg.this.b.onAdLoadFailed(this.f4416a);
                IronLog.CALLBACK.info("onAdLoadFailed() error = " + this.f4416a.getErrorMessage());
            }
        }
    }

    class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f4417a;

        j(AdInfo adInfo) {
            this.f4417a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (sg.this.c != null) {
                sg.this.c.onAdOpened(sg.this.a(this.f4417a));
                IronLog.CALLBACK.info("onAdOpened() adInfo = " + sg.this.a(this.f4417a));
            }
        }
    }

    class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f4418a;

        k(AdInfo adInfo) {
            this.f4418a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (sg.this.b != null) {
                sg.this.b.onAdOpened(sg.this.a(this.f4418a));
                IronLog.CALLBACK.info("onAdOpened() adInfo = " + sg.this.a(this.f4418a));
            }
        }
    }

    class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f4419a;

        l(AdInfo adInfo) {
            this.f4419a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (sg.this.c != null) {
                sg.this.c.onAdClosed(sg.this.a(this.f4419a));
                IronLog.CALLBACK.info("onAdClosed() adInfo = " + sg.this.a(this.f4419a));
            }
        }
    }

    class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f4420a;

        m(AdInfo adInfo) {
            this.f4420a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (sg.this.b != null) {
                sg.this.b.onAdClosed(sg.this.a(this.f4420a));
                IronLog.CALLBACK.info("onAdClosed() adInfo = " + sg.this.a(this.f4420a));
            }
        }
    }

    class n implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f4421a;

        n(AdInfo adInfo) {
            this.f4421a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (sg.this.c != null) {
                sg.this.c.onAdShowSucceeded(sg.this.a(this.f4421a));
                IronLog.CALLBACK.info("onAdShowSucceeded() adInfo = " + sg.this.a(this.f4421a));
            }
        }
    }

    private sg() {
    }

    public static synchronized sg a() {
        return d;
    }

    private void a(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, str, 1);
    }

    public void a(IronSourceError ironSourceError) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new h(ironSourceError));
        } else if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new i(ironSourceError));
        }
    }

    public void a(IronSourceError ironSourceError, AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new b(ironSourceError, adInfo));
        } else if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new c(ironSourceError, adInfo));
        }
    }

    public synchronized void a(LevelPlayInterstitialListener levelPlayInterstitialListener) {
        this.b = levelPlayInterstitialListener;
    }

    public void b(AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new d(adInfo));
        } else if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new e(adInfo));
        }
    }

    public synchronized void b(LevelPlayInterstitialListener levelPlayInterstitialListener) {
        this.c = levelPlayInterstitialListener;
    }

    public void c(AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new l(adInfo));
        } else if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new m(adInfo));
        }
    }

    public void d(AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new j(adInfo));
        } else if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new k(adInfo));
        }
    }

    public void e(AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new f(adInfo));
        } else if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new g(adInfo));
        }
    }

    public void f(AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new n(adInfo));
        } else if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new a(adInfo));
        }
    }
}
