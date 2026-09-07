package com.smaato.sdk.core.mvvm.view;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import com.smaato.sdk.core.AndroidsInjector;
import com.smaato.sdk.core.ad.AdType;
import com.smaato.sdk.core.api.ImpressionCountingType;
import com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.Threads;
import com.smaato.sdk.core.util.appbackground.AppBackgroundDetector;
import com.smaato.sdk.core.util.diinjection.Inject;
import com.smaato.sdk.core.util.fi.Consumer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes8.dex */
public class ViewVisibilityObserver implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener, AppBackgroundDetector.Listener {
    private static final long EXPECTED_VISIBILITY_TIME_MS = 1000;
    private static final long EXPECTED_VISIBILITY_TIME_VIDEO_MS = 2000;
    private static final long MAX_OBSERVER_TIME_MS = 10000;

    @Inject
    private static AppBackgroundDetector appBackgroundDetector;
    private final AdType adType;
    private final Handler handler = Threads.newUiHandler();
    private final ImpressionCountingType impressionCountingType;
    private long lastCheckTimeMs;
    private boolean on100PercentVisibleFired;
    private boolean on50PercentVisibleFired;
    private boolean onAdImpressedFired;
    private long remaining100PercentVisibleTimeMs;
    private long remaining50PercentVisibleTimeMs;
    private long remainingCheckTimeMs;
    private long remainingVisibleTimeMs;
    private final SmaatoSdkViewModel smaatoSdkViewModel;
    private final WeakReference<View> viewReference;
    private final VisibilityAnalyzer visibilityAnalyzer;
    private Runnable visibilityChecker;
    private boolean wasLastTime100PercentVisible;
    private boolean wasLastTime50PercentVisible;
    private boolean wasLastTimeVisible;

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    public ViewVisibilityObserver(View view, ImpressionCountingType impressionCountingType, AdType adType, SmaatoSdkViewModel smaatoSdkViewModel) {
        AndroidsInjector.injectStatic(ViewVisibilityObserver.class);
        this.viewReference = new WeakReference<>(view);
        this.impressionCountingType = impressionCountingType;
        this.adType = adType;
        this.smaatoSdkViewModel = smaatoSdkViewModel;
        this.visibilityAnalyzer = new VisibilityAnalyzer(view, impressionCountingType);
    }

    public void startObserving() {
        appBackgroundDetector.addListener(this, false);
        this.remainingCheckTimeMs = 10000L;
        this.remainingVisibleTimeMs = checkIfIsViewableVideo() ? 2000L : 1000L;
        this.remaining100PercentVisibleTimeMs = 1000L;
        this.remaining50PercentVisibleTimeMs = 1000L;
        this.visibilityChecker = createVisibilityChecker();
        this.lastCheckTimeMs = System.currentTimeMillis();
        this.visibilityChecker.run();
        Objects.onNotNull(this.viewReference.get(), new Consumer() { // from class: com.smaato.sdk.core.mvvm.view.ViewVisibilityObserver$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5565x4de3513b((View) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$startObserving$0$com-smaato-sdk-core-mvvm-view-ViewVisibilityObserver, reason: not valid java name */
    /* synthetic */ void m5565x4de3513b(View view) {
        view.getViewTreeObserver().addOnPreDrawListener(this);
        view.addOnAttachStateChangeListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        finishObserving();
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        this.visibilityChecker.run();
        return true;
    }

    @Override // com.smaato.sdk.core.util.appbackground.AppBackgroundDetector.Listener
    public void onAppEnteredInBackground() {
        this.visibilityChecker.run();
    }

    @Override // com.smaato.sdk.core.util.appbackground.AppBackgroundDetector.Listener
    public void onAppEnteredInForeground() {
        this.visibilityChecker.run();
    }

    private Runnable createVisibilityChecker() {
        return new Runnable() { // from class: com.smaato.sdk.core.mvvm.view.ViewVisibilityObserver$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5563x7ec54964();
            }
        };
    }

    /* JADX INFO: renamed from: lambda$createVisibilityChecker$1$com-smaato-sdk-core-mvvm-view-ViewVisibilityObserver, reason: not valid java name */
    /* synthetic */ void m5563x7ec54964() {
        synchronized (this) {
            this.handler.removeCallbacks(this.visibilityChecker);
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = jCurrentTimeMillis - this.lastCheckTimeMs;
            this.lastCheckTimeMs = jCurrentTimeMillis;
            updateRemainingCheckTimes(j);
            fireVisibilityTrackers();
            this.wasLastTimeVisible = this.visibilityAnalyzer.isImpressed();
            this.wasLastTime50PercentVisible = this.visibilityAnalyzer.is50PercentVisible();
            this.wasLastTime100PercentVisible = this.visibilityAnalyzer.is100PercentVisible();
            long jCalculateNextCheckTime = calculateNextCheckTime();
            if (jCalculateNextCheckTime > 0) {
                this.handler.postDelayed(this.visibilityChecker, jCalculateNextCheckTime);
            } else {
                finishObserving();
            }
        }
    }

    public void finishObserving() {
        Objects.onNotNull(this.viewReference.get(), new Consumer() { // from class: com.smaato.sdk.core.mvvm.view.ViewVisibilityObserver$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5564x66ad2944((View) obj);
            }
        });
        appBackgroundDetector.deleteListener(this);
        this.handler.removeCallbacks(this.visibilityChecker);
    }

    /* JADX INFO: renamed from: lambda$finishObserving$2$com-smaato-sdk-core-mvvm-view-ViewVisibilityObserver, reason: not valid java name */
    /* synthetic */ void m5564x66ad2944(View view) {
        view.getViewTreeObserver().removeOnPreDrawListener(this);
        view.removeOnAttachStateChangeListener(this);
    }

    private void fireVisibilityTrackers() {
        if (this.impressionCountingType == ImpressionCountingType.STANDARD && this.visibilityAnalyzer.isImpressed() && !this.onAdImpressedFired) {
            this.remainingVisibleTimeMs = 0L;
            this.smaatoSdkViewModel.onAdImpressed();
            this.onAdImpressedFired = true;
        }
        if (this.remainingVisibleTimeMs <= 0 && !this.onAdImpressedFired) {
            this.smaatoSdkViewModel.onAdImpressed();
            this.onAdImpressedFired = true;
        }
        if (this.remaining50PercentVisibleTimeMs <= 0 && !this.on50PercentVisibleFired) {
            this.smaatoSdkViewModel.on50PercentVisible();
            this.on50PercentVisibleFired = true;
        }
        if (this.remaining100PercentVisibleTimeMs > 0 || this.on100PercentVisibleFired) {
            return;
        }
        this.smaatoSdkViewModel.on100PercentVisible();
        this.on100PercentVisibleFired = true;
    }

    private void updateRemainingCheckTimes(long j) {
        this.remainingCheckTimeMs -= j;
        if (this.wasLastTimeVisible) {
            this.remainingVisibleTimeMs -= j;
        }
        if (this.wasLastTime50PercentVisible) {
            this.remaining50PercentVisibleTimeMs -= j;
        }
        if (this.wasLastTime100PercentVisible) {
            this.remaining100PercentVisibleTimeMs -= j;
        }
    }

    private long calculateNextCheckTime() {
        ArrayList arrayList = new ArrayList();
        long j = this.remainingCheckTimeMs;
        if (j > 0) {
            arrayList.add(Long.valueOf(j));
        }
        long j2 = this.remainingVisibleTimeMs;
        if (j2 > 0) {
            arrayList.add(Long.valueOf(j2));
        }
        long j3 = this.remaining50PercentVisibleTimeMs;
        if (j3 > 0) {
            arrayList.add(Long.valueOf(j3));
        }
        long j4 = this.remaining100PercentVisibleTimeMs;
        if (j4 > 0) {
            arrayList.add(Long.valueOf(j4));
        }
        if (arrayList.isEmpty()) {
            return 0L;
        }
        return ((Long) Collections.min(arrayList)).longValue();
    }

    private boolean checkIfIsViewableVideo() {
        return this.adType.equals(AdType.VIDEO) && this.impressionCountingType.equals(ImpressionCountingType.VIEWABLE);
    }
}
