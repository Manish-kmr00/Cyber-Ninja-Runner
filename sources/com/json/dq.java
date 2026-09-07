package com.json;

import com.json.environment.thread.IronSourceThreadManager;
import com.json.mediationsdk.adunit.adapter.utility.AdInfo;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.logger.IronSourceError;
import com.json.mediationsdk.logger.IronSourceLogger;
import com.json.mediationsdk.logger.IronSourceLoggerManager;
import com.json.mediationsdk.model.Placement;
import com.json.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener;
import com.json.mediationsdk.sdk.LevelPlayRewardedVideoListener;
import com.json.mediationsdk.sdk.LevelPlayRewardedVideoManualListener;

/* JADX INFO: loaded from: classes6.dex */
public class dq extends t7 {
    private static final dq d = new dq();
    private LevelPlayRewardedVideoBaseListener b = null;
    private LevelPlayRewardedVideoBaseListener c = null;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f3618a;
        final /* synthetic */ AdInfo b;

        a(boolean z, AdInfo adInfo) {
            this.f3618a = z;
            this.b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            IronLog ironLog;
            String str;
            if (dq.this.b != null) {
                if (this.f3618a) {
                    ((LevelPlayRewardedVideoListener) dq.this.b).onAdAvailable(dq.this.a(this.b));
                    ironLog = IronLog.CALLBACK;
                    str = "onAdAvailable() adInfo = " + dq.this.a(this.b);
                } else {
                    ((LevelPlayRewardedVideoListener) dq.this.b).onAdUnavailable();
                    ironLog = IronLog.CALLBACK;
                    str = "onAdUnavailable()";
                }
                ironLog.info(str);
            }
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Placement f3619a;
        final /* synthetic */ AdInfo b;

        b(Placement placement, AdInfo adInfo) {
            this.f3619a = placement;
            this.b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (dq.this.c != null) {
                dq.this.c.onAdRewarded(this.f3619a, dq.this.a(this.b));
                IronLog.CALLBACK.info("onAdRewarded() placement = " + this.f3619a + ", adInfo = " + dq.this.a(this.b));
            }
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Placement f3620a;
        final /* synthetic */ AdInfo b;

        c(Placement placement, AdInfo adInfo) {
            this.f3620a = placement;
            this.b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (dq.this.b != null) {
                dq.this.b.onAdRewarded(this.f3620a, dq.this.a(this.b));
                IronLog.CALLBACK.info("onAdRewarded() placement = " + this.f3620a + ", adInfo = " + dq.this.a(this.b));
            }
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f3621a;
        final /* synthetic */ AdInfo b;

        d(IronSourceError ironSourceError, AdInfo adInfo) {
            this.f3621a = ironSourceError;
            this.b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (dq.this.c != null) {
                dq.this.c.onAdShowFailed(this.f3621a, dq.this.a(this.b));
                IronLog.CALLBACK.info("onAdShowFailed() adInfo = " + dq.this.a(this.b) + ", error = " + this.f3621a.getErrorMessage());
            }
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f3622a;
        final /* synthetic */ AdInfo b;

        e(IronSourceError ironSourceError, AdInfo adInfo) {
            this.f3622a = ironSourceError;
            this.b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (dq.this.b != null) {
                dq.this.b.onAdShowFailed(this.f3622a, dq.this.a(this.b));
                IronLog.CALLBACK.info("onAdShowFailed() adInfo = " + dq.this.a(this.b) + ", error = " + this.f3622a.getErrorMessage());
            }
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Placement f3623a;
        final /* synthetic */ AdInfo b;

        f(Placement placement, AdInfo adInfo) {
            this.f3623a = placement;
            this.b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (dq.this.c != null) {
                dq.this.c.onAdClicked(this.f3623a, dq.this.a(this.b));
                IronLog.CALLBACK.info("onAdClicked() placement = " + this.f3623a + ", adInfo = " + dq.this.a(this.b));
            }
        }
    }

    class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Placement f3624a;
        final /* synthetic */ AdInfo b;

        g(Placement placement, AdInfo adInfo) {
            this.f3624a = placement;
            this.b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (dq.this.b != null) {
                dq.this.b.onAdClicked(this.f3624a, dq.this.a(this.b));
                IronLog.CALLBACK.info("onAdClicked() placement = " + this.f3624a + ", adInfo = " + dq.this.a(this.b));
            }
        }
    }

    class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f3625a;

        h(AdInfo adInfo) {
            this.f3625a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (dq.this.c != null) {
                ((LevelPlayRewardedVideoManualListener) dq.this.c).onAdReady(dq.this.a(this.f3625a));
                IronLog.CALLBACK.info("onAdReady() adInfo = " + dq.this.a(this.f3625a));
            }
        }
    }

    class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f3626a;

        i(AdInfo adInfo) {
            this.f3626a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (dq.this.b != null) {
                ((LevelPlayRewardedVideoManualListener) dq.this.b).onAdReady(dq.this.a(this.f3626a));
                IronLog.CALLBACK.info("onAdReady() adInfo = " + dq.this.a(this.f3626a));
            }
        }
    }

    class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f3627a;

        j(IronSourceError ironSourceError) {
            this.f3627a = ironSourceError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (dq.this.c != null) {
                ((LevelPlayRewardedVideoManualListener) dq.this.c).onAdLoadFailed(this.f3627a);
                IronLog.CALLBACK.info("onAdLoadFailed() error = " + this.f3627a.getErrorMessage());
            }
        }
    }

    class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f3628a;

        k(IronSourceError ironSourceError) {
            this.f3628a = ironSourceError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (dq.this.b != null) {
                ((LevelPlayRewardedVideoManualListener) dq.this.b).onAdLoadFailed(this.f3628a);
                IronLog.CALLBACK.info("onAdLoadFailed() error = " + this.f3628a.getErrorMessage());
            }
        }
    }

    class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f3629a;

        l(AdInfo adInfo) {
            this.f3629a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (dq.this.c != null) {
                dq.this.c.onAdOpened(dq.this.a(this.f3629a));
                IronLog.CALLBACK.info("onAdOpened() adInfo = " + dq.this.a(this.f3629a));
            }
        }
    }

    class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f3630a;

        m(AdInfo adInfo) {
            this.f3630a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (dq.this.b != null) {
                dq.this.b.onAdOpened(dq.this.a(this.f3630a));
                IronLog.CALLBACK.info("onAdOpened() adInfo = " + dq.this.a(this.f3630a));
            }
        }
    }

    class n implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f3631a;

        n(AdInfo adInfo) {
            this.f3631a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (dq.this.c != null) {
                dq.this.c.onAdClosed(dq.this.a(this.f3631a));
                IronLog.CALLBACK.info("onAdClosed() adInfo = " + dq.this.a(this.f3631a));
            }
        }
    }

    class o implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f3632a;

        o(AdInfo adInfo) {
            this.f3632a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (dq.this.b != null) {
                dq.this.b.onAdClosed(dq.this.a(this.f3632a));
                IronLog.CALLBACK.info("onAdClosed() adInfo = " + dq.this.a(this.f3632a));
            }
        }
    }

    class p implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f3633a;
        final /* synthetic */ AdInfo b;

        p(boolean z, AdInfo adInfo) {
            this.f3633a = z;
            this.b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            IronLog ironLog;
            String str;
            if (dq.this.c != null) {
                if (this.f3633a) {
                    ((LevelPlayRewardedVideoListener) dq.this.c).onAdAvailable(dq.this.a(this.b));
                    ironLog = IronLog.CALLBACK;
                    str = "onAdAvailable() adInfo = " + dq.this.a(this.b);
                } else {
                    ((LevelPlayRewardedVideoListener) dq.this.c).onAdUnavailable();
                    ironLog = IronLog.CALLBACK;
                    str = "onAdUnavailable()";
                }
                ironLog.info(str);
            }
        }
    }

    private dq() {
    }

    public static dq a() {
        return d;
    }

    private void a(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, str, 1);
    }

    public void a(IronSourceError ironSourceError) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new j(ironSourceError));
            return;
        }
        LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener = this.b;
        if (levelPlayRewardedVideoBaseListener == null || !(levelPlayRewardedVideoBaseListener instanceof LevelPlayRewardedVideoManualListener)) {
            return;
        }
        IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new k(ironSourceError));
    }

    public void a(IronSourceError ironSourceError, AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new d(ironSourceError, adInfo));
        } else if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new e(ironSourceError, adInfo));
        }
    }

    public void a(Placement placement, AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new f(placement, adInfo));
        } else if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new g(placement, adInfo));
        }
    }

    public void a(LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener) {
        this.b = levelPlayRewardedVideoBaseListener;
    }

    public void a(boolean z, AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new p(z, adInfo));
            return;
        }
        LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener = this.b;
        if (levelPlayRewardedVideoBaseListener == null || !(levelPlayRewardedVideoBaseListener instanceof LevelPlayRewardedVideoListener)) {
            return;
        }
        IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new a(z, adInfo));
    }

    public void b() {
    }

    public void b(AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new n(adInfo));
        } else if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new o(adInfo));
        }
    }

    public void b(Placement placement, AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new b(placement, adInfo));
        } else if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new c(placement, adInfo));
        }
    }

    public void b(LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener) {
        this.c = levelPlayRewardedVideoBaseListener;
    }

    public void c() {
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
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new h(adInfo));
            return;
        }
        LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener = this.b;
        if (levelPlayRewardedVideoBaseListener == null || !(levelPlayRewardedVideoBaseListener instanceof LevelPlayRewardedVideoManualListener)) {
            return;
        }
        IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new i(adInfo));
    }
}
