package com.json;

import android.os.Handler;
import android.widget.FrameLayout;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.json.mediationsdk.testSuite.TestSuiteActivity;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.mediation.banner.LevelPlayBannerAdView;
import com.unity3d.mediation.interstitial.LevelPlayInterstitialAd;
import com.unity3d.mediation.rewarded.LevelPlayRewardedAd;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010)\u001a\u00020\b\u0012\u0006\u0010*\u001a\u00020\u001e¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\u0010\u0010\u0007\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J(\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\fH\u0016R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0018R\"\u0010\u001d\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\b0\b0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001fR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010#R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020%0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010#R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020'0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010#¨\u0006-"}, d2 = {"Lcom/ironsource/hu;", "Lcom/ironsource/yt$c;", "Lcom/ironsource/yt$d;", "Lcom/ironsource/yt$b;", "", "marginPercentageFromTop", "Landroid/widget/FrameLayout$LayoutParams;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/mediationsdk/testSuite/TestSuiteActivity;", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/ironsource/eu;", "loadAdConfig", "", "a", "", "e", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "d", "", "description", "", "width", "height", "Lcom/ironsource/fi$a;", "Lcom/ironsource/fi$a;", "testSuiteLoadAdConfigService", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "Ljava/lang/ref/WeakReference;", "mTestSuiteActivityWeakReference", "Landroid/os/Handler;", "Landroid/os/Handler;", "mHandler", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/unity3d/mediation/banner/LevelPlayBannerAdView;", "Ljava/util/concurrent/atomic/AtomicReference;", "bannerRef", "Lcom/unity3d/mediation/interstitial/LevelPlayInterstitialAd;", "interstitialAdRef", "Lcom/unity3d/mediation/rewarded/LevelPlayRewardedAd;", "rewardedAdRef", "activity", "handler", "<init>", "(Lcom/ironsource/mediationsdk/testSuite/TestSuiteActivity;Landroid/os/Handler;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class hu implements yt.c, yt.d, yt.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final fi.a testSuiteLoadAdConfigService;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final WeakReference<TestSuiteActivity> mTestSuiteActivityWeakReference;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final Handler mHandler;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final AtomicReference<LevelPlayBannerAdView> bannerRef;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final AtomicReference<LevelPlayInterstitialAd> interstitialAdRef;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final AtomicReference<LevelPlayRewardedAd> rewardedAdRef;

    public hu(TestSuiteActivity activity, Handler handler) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.testSuiteLoadAdConfigService = mm.INSTANCE.a().s();
        this.mTestSuiteActivityWeakReference = new WeakReference<>(activity);
        this.mHandler = handler;
        this.bannerRef = new AtomicReference<>();
        this.interstitialAdRef = new AtomicReference<>();
        this.rewardedAdRef = new AtomicReference<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(TestSuiteActivity testSuiteActivity, LevelPlayBannerAdView it) {
        Intrinsics.checkNotNullParameter(testSuiteActivity, "$testSuiteActivity");
        Intrinsics.checkNotNullParameter(it, "$it");
        testSuiteActivity.getContainer().removeView(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(TestSuiteActivity testSuiteActivity, LevelPlayBannerAdView banner, hu this$0, double d) {
        Intrinsics.checkNotNullParameter(testSuiteActivity, "$testSuiteActivity");
        Intrinsics.checkNotNullParameter(banner, "$banner");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        testSuiteActivity.getContainer().addView(banner, this$0.b(d));
    }

    private final FrameLayout.LayoutParams b(double marginPercentageFromTop) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = (int) (((double) lu.f3878a.a()) * marginPercentageFromTop);
        return layoutParams;
    }

    private final TestSuiteActivity f() {
        return this.mTestSuiteActivityWeakReference.get();
    }

    @Override // com.ironsource.yt.b
    public void a(final double marginPercentageFromTop) {
        final LevelPlayBannerAdView levelPlayBannerAdView;
        final TestSuiteActivity testSuiteActivityF = f();
        if (testSuiteActivityF == null || (levelPlayBannerAdView = this.bannerRef.get()) == null || levelPlayBannerAdView.getParent() != null) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.ironsource.hu$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                hu.a(testSuiteActivityF, levelPlayBannerAdView, this, marginPercentageFromTop);
            }
        });
    }

    @Override // com.ironsource.yt.c
    public void a(eu loadAdConfig) {
        Intrinsics.checkNotNullParameter(loadAdConfig, "loadAdConfig");
        this.testSuiteLoadAdConfigService.a(loadAdConfig);
        AtomicReference<LevelPlayInterstitialAd> atomicReference = this.interstitialAdRef;
        String mAdUnitId = loadAdConfig.getMAdUnitId();
        if (mAdUnitId == null) {
            mAdUnitId = "";
        }
        LevelPlayInterstitialAd levelPlayInterstitialAd = new LevelPlayInterstitialAd(mAdUnitId);
        levelPlayInterstitialAd.setListener(new ju());
        levelPlayInterstitialAd.loadAd();
        atomicReference.set(levelPlayInterstitialAd);
    }

    @Override // com.ironsource.yt.b
    public void a(eu loadAdConfig, String description, int width, int height) {
        Intrinsics.checkNotNullParameter(loadAdConfig, "loadAdConfig");
        Intrinsics.checkNotNullParameter(description, "description");
        b();
        TestSuiteActivity testSuiteActivityF = f();
        if (testSuiteActivityF != null) {
            this.testSuiteLoadAdConfigService.a(loadAdConfig);
            AtomicReference<LevelPlayBannerAdView> atomicReference = this.bannerRef;
            String mAdUnitId = loadAdConfig.getMAdUnitId();
            if (mAdUnitId == null) {
                mAdUnitId = "";
            }
            LevelPlayBannerAdView levelPlayBannerAdView = new LevelPlayBannerAdView(testSuiteActivityF, mAdUnitId);
            levelPlayBannerAdView.setAdSize(lu.f3878a.b(description, width, height));
            levelPlayBannerAdView.setBannerListener(new iu());
            levelPlayBannerAdView.pauseAutoRefresh();
            levelPlayBannerAdView.loadAd();
            atomicReference.set(levelPlayBannerAdView);
        }
    }

    @Override // com.ironsource.yt.d
    public boolean a() {
        LevelPlayRewardedAd levelPlayRewardedAd = this.rewardedAdRef.get();
        if (levelPlayRewardedAd != null) {
            return levelPlayRewardedAd.isAdReady();
        }
        return false;
    }

    @Override // com.ironsource.yt.b
    public void b() {
        final LevelPlayBannerAdView andSet;
        final TestSuiteActivity testSuiteActivityF = f();
        if (testSuiteActivityF == null || (andSet = this.bannerRef.getAndSet(null)) == null) {
            return;
        }
        andSet.destroy();
        this.mHandler.post(new Runnable() { // from class: com.ironsource.hu$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                hu.a(testSuiteActivityF, andSet);
            }
        });
    }

    @Override // com.ironsource.yt.d
    public void b(eu loadAdConfig) {
        Intrinsics.checkNotNullParameter(loadAdConfig, "loadAdConfig");
        this.testSuiteLoadAdConfigService.a(loadAdConfig);
        AtomicReference<LevelPlayRewardedAd> atomicReference = this.rewardedAdRef;
        String mAdUnitId = loadAdConfig.getMAdUnitId();
        if (mAdUnitId == null) {
            mAdUnitId = "";
        }
        LevelPlayRewardedAd levelPlayRewardedAd = new LevelPlayRewardedAd(mAdUnitId);
        levelPlayRewardedAd.setListener(new ku());
        levelPlayRewardedAd.loadAd();
        atomicReference.set(levelPlayRewardedAd);
    }

    @Override // com.ironsource.yt.c
    public void c() {
        TestSuiteActivity testSuiteActivityF = f();
        if (testSuiteActivityF != null) {
            LevelPlayInterstitialAd levelPlayInterstitialAd = this.interstitialAdRef.get();
            Intrinsics.checkNotNullExpressionValue(levelPlayInterstitialAd, "interstitialAdRef.get()");
            LevelPlayInterstitialAd.showAd$default(levelPlayInterstitialAd, testSuiteActivityF, null, 2, null);
        }
    }

    @Override // com.ironsource.yt.d
    public void d() {
        TestSuiteActivity testSuiteActivityF = f();
        if (testSuiteActivityF != null) {
            LevelPlayRewardedAd levelPlayRewardedAd = this.rewardedAdRef.get();
            Intrinsics.checkNotNullExpressionValue(levelPlayRewardedAd, "rewardedAdRef.get()");
            LevelPlayRewardedAd.showAd$default(levelPlayRewardedAd, testSuiteActivityF, null, 2, null);
        }
    }

    @Override // com.ironsource.yt.c
    public boolean e() {
        LevelPlayInterstitialAd levelPlayInterstitialAd = this.interstitialAdRef.get();
        if (levelPlayInterstitialAd != null) {
            return levelPlayInterstitialAd.isAdReady();
        }
        return false;
    }
}
