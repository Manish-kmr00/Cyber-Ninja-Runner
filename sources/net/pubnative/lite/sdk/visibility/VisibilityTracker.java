package net.pubnative.lite.sdk.visibility;

import android.graphics.Rect;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class VisibilityTracker {
    private static final String TAG = "VisibilityTracker";
    private static final int VISIBILITY_CHECK_DELAY = 100;
    protected WeakReference<View> mDeviceView = null;
    protected WeakReference<Listener> mListener = null;
    protected final List<PubnativeVisibilityTrackerItem> mTrackedViews = new ArrayList();
    protected Handler mHandler = new Handler();
    protected boolean mIsVisibilityCheckScheduled = false;
    protected final VisibilityRunnable mVisibilityRunnable = new VisibilityRunnable();
    protected ViewTreeObserver.OnPreDrawListener mOnPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: net.pubnative.lite.sdk.visibility.VisibilityTracker$$ExternalSyntheticLambda0
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            return this.f$0.m9831lambda$new$0$netpubnativelitesdkvisibilityVisibilityTracker();
        }
    };

    public interface Listener {
        void onVisibilityCheck(List<View> list, List<View> list2);
    }

    /* JADX INFO: renamed from: lambda$new$0$net-pubnative-lite-sdk-visibility-VisibilityTracker, reason: not valid java name */
    /* synthetic */ boolean m9831lambda$new$0$netpubnativelitesdkvisibilityVisibilityTracker() {
        WeakReference<Listener> weakReference = this.mListener;
        if (weakReference == null || weakReference.get() == null) {
            clear();
            return true;
        }
        scheduleVisibilityCheck();
        return true;
    }

    public void setListener(Listener listener) {
        this.mListener = new WeakReference<>(listener);
    }

    public void addView(View view, double d) {
        if (this.mDeviceView == null) {
            this.mDeviceView = new WeakReference<>(view);
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnPreDrawListener(this.mOnPreDrawListener);
            } else {
                Log.d(TAG, "Unable to start tracking, Window ViewTreeObserver is not alive");
            }
        }
        if (containsTrackedView(view)) {
            return;
        }
        PubnativeVisibilityTrackerItem pubnativeVisibilityTrackerItem = new PubnativeVisibilityTrackerItem();
        pubnativeVisibilityTrackerItem.mTrackingView = view;
        pubnativeVisibilityTrackerItem.mMinVisibilityPercent = d;
        this.mTrackedViews.add(pubnativeVisibilityTrackerItem);
        scheduleVisibilityCheck();
    }

    public void removeView(View view) {
        this.mTrackedViews.remove(view);
    }

    public void clear() {
        View view;
        this.mHandler.removeMessages(0);
        this.mTrackedViews.clear();
        this.mIsVisibilityCheckScheduled = false;
        WeakReference<View> weakReference = this.mDeviceView;
        if (weakReference != null && (view = weakReference.get()) != null && this.mOnPreDrawListener != null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.mOnPreDrawListener);
            }
            this.mOnPreDrawListener = null;
        }
        this.mListener = null;
    }

    protected void scheduleVisibilityCheck() {
        if (this.mIsVisibilityCheckScheduled) {
            return;
        }
        this.mIsVisibilityCheckScheduled = true;
        this.mHandler.postDelayed(this.mVisibilityRunnable, 100L);
    }

    protected boolean containsTrackedView(View view) {
        return indexOfTrackedView(view) >= 0;
    }

    protected int indexOfTrackedView(View view) {
        for (int i = 0; i < this.mTrackedViews.size(); i++) {
            if (this.mTrackedViews.get(i).equals(view)) {
                return i;
            }
        }
        return -1;
    }

    protected static class PubnativeVisibilityTrackerItem {
        private final String TAG = PubnativeVisibilityTrackerItem.class.getSimpleName();
        public double mMinVisibilityPercent;
        public View mTrackingView;

        protected PubnativeVisibilityTrackerItem() {
        }

        public boolean equals(Object obj) {
            if (obj instanceof View) {
                return obj.equals(this.mTrackingView);
            }
            return super.equals(obj);
        }
    }

    protected class VisibilityRunnable implements Runnable {
        private final Rect mVisibleRect = new Rect();
        private final ArrayList<View> mInvisibleViews = new ArrayList<>();
        private final ArrayList<View> mVisibleViews = new ArrayList<>();

        VisibilityRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VisibilityTracker.this.mIsVisibilityCheckScheduled = false;
            for (PubnativeVisibilityTrackerItem pubnativeVisibilityTrackerItem : VisibilityTracker.this.mTrackedViews) {
                if (isVisible(pubnativeVisibilityTrackerItem)) {
                    this.mVisibleViews.add(pubnativeVisibilityTrackerItem.mTrackingView);
                } else {
                    this.mInvisibleViews.add(pubnativeVisibilityTrackerItem.mTrackingView);
                }
            }
            if (VisibilityTracker.this.mListener != null && VisibilityTracker.this.mListener.get() != null) {
                VisibilityTracker.this.mListener.get().onVisibilityCheck(this.mVisibleViews, this.mInvisibleViews);
            }
            this.mInvisibleViews.clear();
            this.mVisibleViews.clear();
        }

        protected boolean isVisible(PubnativeVisibilityTrackerItem pubnativeVisibilityTrackerItem) {
            View view = pubnativeVisibilityTrackerItem.mTrackingView;
            if (view == null || !view.isShown() || view.getParent() == null || !view.getLocalVisibleRect(this.mVisibleRect)) {
                return false;
            }
            return ((double) ((float) (this.mVisibleRect.height() * this.mVisibleRect.width()))) / ((double) ((float) (view.getHeight() * view.getWidth()))) >= pubnativeVisibilityTrackerItem.mMinVisibilityPercent;
        }
    }
}
