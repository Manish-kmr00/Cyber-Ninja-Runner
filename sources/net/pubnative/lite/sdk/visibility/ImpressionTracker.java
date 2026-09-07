package net.pubnative.lite.sdk.visibility;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.pubnative.lite.sdk.models.AdSize;

/* JADX INFO: loaded from: classes4.dex */
public class ImpressionTracker {
    private static final double DEFAULT_BIG_MIN_VISIBLE_PERCENT = 0.0d;
    private static final double DEFAULT_MIN_VISIBLE_PERCENT = 0.0d;
    private static final int VISIBILITY_CHECK_MILLIS = 250;
    private static final int VISIBILITY_TIME_MILLIS = 0;
    protected Handler mHandler;
    protected WeakReference<Listener> mImpressionListener;
    protected final Runnable mImpressionRunnable;
    protected final List<View> mTrackingViews;
    protected VisibilityTracker.Listener mVisibilityListener;
    protected VisibilityTracker mVisibilityTracker;
    protected double mVisiblePercent;
    protected int mVisibleTimeMiliseconds;
    protected final HashMap<View, Long> mVisibleViews;

    public interface Listener {
        void onImpression(View view);
    }

    /* JADX INFO: renamed from: lambda$new$0$net-pubnative-lite-sdk-visibility-ImpressionTracker, reason: not valid java name */
    /* synthetic */ void m9829lambda$new$0$netpubnativelitesdkvisibilityImpressionTracker(List list, List list2) {
        WeakReference<Listener> weakReference = this.mImpressionListener;
        if (weakReference == null || weakReference.get() == null) {
            clear();
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            View view = (View) it.next();
            if (!this.mVisibleViews.containsKey(view)) {
                this.mVisibleViews.put(view, Long.valueOf(SystemClock.uptimeMillis()));
            }
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            this.mVisibleViews.remove((View) it2.next());
        }
        if (this.mVisibleViews.isEmpty()) {
            return;
        }
        scheduleNextRun();
    }

    public ImpressionTracker() {
        this.mImpressionListener = null;
        this.mTrackingViews = new ArrayList();
        this.mVisibleViews = new HashMap<>();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mImpressionRunnable = new ImpressionRunnable();
        this.mVisibilityTracker = null;
        this.mVisiblePercent = 0.0d;
        this.mVisibleTimeMiliseconds = 0;
        this.mVisibilityListener = new VisibilityTracker.Listener() { // from class: net.pubnative.lite.sdk.visibility.ImpressionTracker$$ExternalSyntheticLambda0
            @Override // net.pubnative.lite.sdk.visibility.VisibilityTracker.Listener
            public final void onVisibilityCheck(List list, List list2) {
                this.f$0.m9829lambda$new$0$netpubnativelitesdkvisibilityImpressionTracker(list, list2);
            }
        };
    }

    public ImpressionTracker(Integer num, Double d) {
        this.mImpressionListener = null;
        this.mTrackingViews = new ArrayList();
        this.mVisibleViews = new HashMap<>();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mImpressionRunnable = new ImpressionRunnable();
        this.mVisibilityTracker = null;
        this.mVisiblePercent = 0.0d;
        this.mVisibleTimeMiliseconds = 0;
        this.mVisibilityListener = new VisibilityTracker.Listener() { // from class: net.pubnative.lite.sdk.visibility.ImpressionTracker$$ExternalSyntheticLambda0
            @Override // net.pubnative.lite.sdk.visibility.VisibilityTracker.Listener
            public final void onVisibilityCheck(List list, List list2) {
                this.f$0.m9829lambda$new$0$netpubnativelitesdkvisibilityImpressionTracker(list, list2);
            }
        };
        if (num != null) {
            this.mVisibleTimeMiliseconds = num.intValue();
        }
        if (d != null) {
            this.mVisiblePercent = d.doubleValue();
        }
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof View) {
            return this.mTrackingViews.contains(obj);
        }
        if (obj instanceof Listener) {
            return this.mImpressionListener.equals(obj);
        }
        return super.equals(obj);
    }

    public void setListener(Listener listener) {
        this.mImpressionListener = new WeakReference<>(listener);
    }

    public void setAdSize(AdSize adSize, Double d) {
        if (d != null) {
            this.mVisiblePercent = d.doubleValue();
            return;
        }
        if (adSize != null) {
            switch (AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$models$AdSize[adSize.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    this.mVisiblePercent = 0.0d;
                    break;
                default:
                    this.mVisiblePercent = 0.0d;
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: net.pubnative.lite.sdk.visibility.ImpressionTracker$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$pubnative$lite$sdk$models$AdSize;

        static {
            int[] iArr = new int[AdSize.values().length];
            $SwitchMap$net$pubnative$lite$sdk$models$AdSize = iArr;
            try {
                iArr[AdSize.SIZE_160x600.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$models$AdSize[AdSize.SIZE_300x600.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$models$AdSize[AdSize.SIZE_320x480.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$models$AdSize[AdSize.SIZE_480x320.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$models$AdSize[AdSize.SIZE_768x1024.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$models$AdSize[AdSize.SIZE_1024x768.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public void addView(View view) {
        if (this.mTrackingViews.contains(view)) {
            return;
        }
        this.mTrackingViews.add(view);
        getVisibilityTracker().addView(view, this.mVisiblePercent);
    }

    public void removeView(View view) {
        this.mTrackingViews.remove(view);
        this.mVisibleViews.remove(view);
        getVisibilityTracker().removeView(view);
    }

    public boolean isEmpty() {
        return this.mTrackingViews.isEmpty();
    }

    public void clear() {
        Iterator<View> it = this.mTrackingViews.iterator();
        while (it.hasNext()) {
            ImpressionManager.stopTrackingView(it.next());
        }
        this.mHandler.removeMessages(0);
        this.mTrackingViews.clear();
        this.mVisibleViews.clear();
        VisibilityTracker visibilityTracker = this.mVisibilityTracker;
        if (visibilityTracker != null) {
            visibilityTracker.clear();
            this.mVisibilityTracker = null;
        }
    }

    protected VisibilityTracker getVisibilityTracker() {
        if (this.mVisibilityTracker == null) {
            VisibilityTracker visibilityTracker = new VisibilityTracker();
            this.mVisibilityTracker = visibilityTracker;
            visibilityTracker.setListener(this.mVisibilityListener);
        }
        return this.mVisibilityTracker;
    }

    protected void scheduleNextRun() {
        if (this.mHandler.hasMessages(0)) {
            return;
        }
        this.mHandler.postDelayed(this.mImpressionRunnable, 250L);
    }

    protected class ImpressionRunnable implements Runnable {
        private final List<View> mRemovedViews = new ArrayList();

        ImpressionRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (Map.Entry<View, Long> entry : ImpressionTracker.this.mVisibleViews.entrySet()) {
                View key = entry.getKey();
                if (SystemClock.uptimeMillis() - entry.getValue().longValue() >= ImpressionTracker.this.mVisibleTimeMiliseconds) {
                    if (ImpressionTracker.this.mImpressionListener != null && ImpressionTracker.this.mImpressionListener.get() != null) {
                        ImpressionTracker.this.mImpressionListener.get().onImpression(key);
                    }
                    this.mRemovedViews.add(key);
                }
            }
            Iterator<View> it = this.mRemovedViews.iterator();
            while (it.hasNext()) {
                ImpressionManager.stopTrackingView(it.next());
            }
            this.mRemovedViews.clear();
            if (ImpressionTracker.this.mVisibleViews.isEmpty()) {
                return;
            }
            ImpressionTracker.this.scheduleNextRun();
        }
    }
}
