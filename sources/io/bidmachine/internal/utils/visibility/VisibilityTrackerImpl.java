package io.bidmachine.internal.utils.visibility;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.core.VisibilityParams;
import io.bidmachine.internal.utils.LogSafeRunnable;
import io.bidmachine.utils.lazy.LazyValue;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public class VisibilityTrackerImpl implements VisibilityTracker {
    private static final int AFD_MAX_COUNT_OVERLAPPED_VIEWS = 3;
    private static final int CHECK_DELAY = 100;
    private static final int NO_TRACK = -1;
    private final Runnable checkRunnable;
    private final Runnable finishRunnable;
    private boolean isFinishedRequested;
    private boolean isFinishedTracked;
    private boolean isShownTracked;
    private long lastShownTimeMs;
    private final ViewTreeObserver.OnPreDrawListener preDrawListener;
    private final VisibilityParams visibilityParams;
    private final VisibilityTrackerListener visibilityTrackerListener;
    private final WeakReference<View> weakView;
    private final Object lock = new Object();
    private final AtomicBoolean isStarted = new AtomicBoolean(false);
    private final AtomicBoolean isCheckerScheduled = new AtomicBoolean(false);

    public VisibilityTrackerImpl(View view, VisibilityParams visibilityParams, VisibilityTrackerListener visibilityTrackerListener) {
        this.weakView = new WeakReference<>(view);
        this.visibilityParams = visibilityParams;
        this.visibilityTrackerListener = visibilityTrackerListener;
        this.preDrawListener = new ViewPreDrawListener();
        this.checkRunnable = new CheckRunnable();
        this.finishRunnable = new FinishRunnable();
    }

    @Override // io.bidmachine.internal.utils.visibility.VisibilityTracker
    public void start() {
        synchronized (this.lock) {
            if (this.isStarted.compareAndSet(false, true)) {
                final View view = getView();
                if (view == null) {
                    stop();
                } else {
                    Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.internal.utils.visibility.VisibilityTrackerImpl$$ExternalSyntheticLambda0
                        @Override // io.bidmachine.utils.lazy.LazyValue
                        public final Object get() {
                            return String.format("Start tracking - %s", view);
                        }
                    });
                    view.getViewTreeObserver().addOnPreDrawListener(this.preDrawListener);
                }
            }
        }
    }

    @Override // io.bidmachine.internal.utils.visibility.VisibilityTracker
    public void stop() {
        synchronized (this.lock) {
            this.isStarted.set(false);
            final View view = getView();
            if (view != null) {
                Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.internal.utils.visibility.VisibilityTrackerImpl$$ExternalSyntheticLambda3
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        return String.format("Stop tracking - %s", view);
                    }
                });
                long timeThresholdMs = this.visibilityParams.getTimeThresholdMs();
                if (this.isShownTracked && !this.isFinishedTracked && timeThresholdMs > -1 && this.lastShownTimeMs > 0 && System.currentTimeMillis() - this.lastShownTimeMs >= timeThresholdMs) {
                    this.isFinishedTracked = true;
                    this.visibilityTrackerListener.onViewTrackingFinished();
                }
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(this.preDrawListener);
                }
            }
            Utils.cancelUiThreadTask(this.checkRunnable);
            Utils.cancelUiThreadTask(this.finishRunnable);
        }
    }

    View getView() {
        return this.weakView.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forceScheduleChecker() {
        this.isCheckerScheduled.set(false);
        scheduleChecker();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleChecker() {
        if (this.isCheckerScheduled.compareAndSet(false, true)) {
            Utils.cancelUiThreadTask(this.checkRunnable);
            Utils.onUiThread(this.checkRunnable, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean check() {
        View view = getView();
        if (view == null) {
            stop();
            return true;
        }
        if (this.isShownTracked && this.isFinishedTracked) {
            stop();
            return true;
        }
        long timeThresholdMs = this.visibilityParams.getTimeThresholdMs();
        if (isVisibilityVerified(view, this.visibilityParams.getPixelThreshold(), this.visibilityParams.isIgnoreWindowFocus(), this.visibilityParams.isIgnoreOverlap()) && this.visibilityTrackerListener.onViewShown()) {
            this.isShownTracked = true;
            if (!this.isFinishedRequested && !this.isFinishedTracked) {
                Utils.onUiThread(this.finishRunnable, timeThresholdMs);
                this.lastShownTimeMs = System.currentTimeMillis();
                this.isFinishedRequested = true;
            }
        } else if (!this.isFinishedTracked) {
            Utils.cancelUiThreadTask(this.finishRunnable);
            this.lastShownTimeMs = 0L;
            this.isFinishedRequested = false;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r11v2, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r14v2, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r14v3, types: [android.view.View, android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r9v0 */
    private boolean isVisibilityVerified(View view, final float f, boolean z, boolean z2) {
        try {
            final String string = view.toString();
            if (!view.isShown()) {
                Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.internal.utils.visibility.VisibilityTrackerImpl$$ExternalSyntheticLambda4
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        return String.format("Show wasn't tracked: view visibility verification failed - %s", string);
                    }
                });
                return false;
            }
            if (Utils.isViewTransparent(view)) {
                Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.internal.utils.visibility.VisibilityTrackerImpl$$ExternalSyntheticLambda5
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        return String.format("Show wasn't tracked: view transparent verification failed - %s", string);
                    }
                });
                return false;
            }
            if (!z && !view.hasWindowFocus()) {
                Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.internal.utils.visibility.VisibilityTrackerImpl$$ExternalSyntheticLambda6
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        return String.format("Show wasn't tracked: window focus verification failed - %s", string);
                    }
                });
                return false;
            }
            float width = view.getWidth() * view.getHeight();
            if (width == 0.0f) {
                Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.internal.utils.visibility.VisibilityTrackerImpl$$ExternalSyntheticLambda7
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        return String.format("Show wasn't tracked: view size verification failed - %s", string);
                    }
                });
                return false;
            }
            Rect rect = new Rect();
            if (!view.getGlobalVisibleRect(rect)) {
                Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.internal.utils.visibility.VisibilityTrackerImpl$$ExternalSyntheticLambda8
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        return String.format("Show wasn't tracked: global visibility verification failed - %s", string);
                    }
                });
                return false;
            }
            final float fWidth = (rect.width() * rect.height()) / width;
            if (fWidth < f) {
                Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.internal.utils.visibility.VisibilityTrackerImpl$$ExternalSyntheticLambda9
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        return String.format("Show wasn't tracked: ad view not completely visible (%s / %s) - %s", Float.valueOf(fWidth), Float.valueOf(f), string);
                    }
                });
                return false;
            }
            View viewFindContentOrRootView = findContentOrRootView(view);
            if (viewFindContentOrRootView == null) {
                Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.internal.utils.visibility.VisibilityTrackerImpl$$ExternalSyntheticLambda10
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        return String.format("Show wasn't tracked: content or root layout not found - %s", string);
                    }
                });
                return false;
            }
            Rect rect2 = new Rect();
            viewFindContentOrRootView.getGlobalVisibleRect(rect2);
            if (!Rect.intersects(rect, rect2)) {
                Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.internal.utils.visibility.VisibilityTrackerImpl$$ExternalSyntheticLambda11
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        return String.format("Show wasn't tracked: ad view is out of current window - %s", string);
                    }
                });
                return false;
            }
            if (!z2) {
                ViewGroup viewGroup = (ViewGroup) view.getRootView();
                ?? r14 = (ViewGroup) view.getParent();
                final int i = 0;
                while (r14 != 0) {
                    for (int iIndexOfChild = r14.indexOfChild(view) + 1; iIndexOfChild < r14.getChildCount(); iIndexOfChild++) {
                        final View childAt = r14.getChildAt(iIndexOfChild);
                        if (childAt.getVisibility() == 0) {
                            Rect viewRectangle = Utils.getViewRectangle(childAt);
                            if (Rect.intersects(rect, viewRectangle)) {
                                final float fViewNotOverlappedAreaPercent = viewNotOverlappedAreaPercent(rect, viewRectangle);
                                if (fViewNotOverlappedAreaPercent < f) {
                                    Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.internal.utils.visibility.VisibilityTrackerImpl$$ExternalSyntheticLambda1
                                        @Override // io.bidmachine.utils.lazy.LazyValue
                                        public final Object get() {
                                            return String.format("Show wasn't tracked: ad view is covered by another view (visible percent - %s / %s, ad view - %s, overlapping view - %s)", Float.valueOf(fViewNotOverlappedAreaPercent), Float.valueOf(f), string, childAt);
                                        }
                                    });
                                    return false;
                                }
                                i++;
                                if (i >= 3) {
                                    Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.internal.utils.visibility.VisibilityTrackerImpl$$ExternalSyntheticLambda2
                                        @Override // io.bidmachine.utils.lazy.LazyValue
                                        public final Object get() {
                                            return String.format("Show wasn't tracked: ad view is covered by too many views (overlapping views count - %s, ad view - %s)", Integer.valueOf(i), string);
                                        }
                                    });
                                    return false;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                    if (r14 != viewGroup) {
                        ?? r9 = r14;
                        r14 = (ViewGroup) r14.getParent();
                        view = r9;
                    } else {
                        r14 = 0;
                    }
                }
            }
            return true;
        } catch (Exception e) {
            Logger.w(e);
        }
    }

    private View findContentOrRootView(View view) {
        View view2 = null;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            view2 = (View) parent;
            if (view2.getId() == 16908290) {
                break;
            }
        }
        return view2;
    }

    private float viewNotOverlappedAreaPercent(Rect rect, Rect rect2) {
        int iWidth = rect.width() * rect.height();
        if (iWidth == 0) {
            return 0.0f;
        }
        return (iWidth - (Math.max(0, Math.min(rect.right, rect2.right) - Math.max(rect.left, rect2.left)) * Math.max(0, Math.min(rect.bottom, rect2.bottom) - Math.max(rect.top, rect2.top)))) / iWidth;
    }

    private class ViewPreDrawListener implements ViewTreeObserver.OnPreDrawListener {
        private ViewPreDrawListener() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            VisibilityTrackerImpl.this.scheduleChecker();
            return true;
        }
    }

    private class CheckRunnable implements LogSafeRunnable {
        private CheckRunnable() {
        }

        @Override // io.bidmachine.utils.SafeRunnable
        public void onRun() throws Throwable {
            if (VisibilityTrackerImpl.this.check()) {
                return;
            }
            VisibilityTrackerImpl.this.forceScheduleChecker();
        }

        @Override // io.bidmachine.internal.utils.LogSafeRunnable, io.bidmachine.utils.SafeRunnable
        public void onThrows(Throwable th) throws Throwable {
            super.onThrows(th);
            VisibilityTrackerImpl.this.forceScheduleChecker();
        }
    }

    private class FinishRunnable implements LogSafeRunnable {
        private FinishRunnable() {
        }

        @Override // io.bidmachine.utils.SafeRunnable
        public void onRun() throws Throwable {
            VisibilityTrackerImpl.this.stop();
        }
    }
}
