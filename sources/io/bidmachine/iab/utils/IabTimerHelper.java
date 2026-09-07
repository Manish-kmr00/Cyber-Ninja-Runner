package io.bidmachine.iab.utils;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes13.dex */
public class IabTimerHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f12242a;
    private final TimerHelperCallback b;
    private boolean c = false;
    private float d = 0.0f;
    private long e = 0;
    private long f = 0;
    private final ViewTreeObserver.OnGlobalLayoutListener g;
    private final Runnable h;

    public interface TimerHelperCallback {
        void onTimerFinish();

        void onTimerTick(float percent, long currentTimeMs, long totalTimeMs);
    }

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IabTimerHelper.this.a();
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long jMin = IabTimerHelper.this.f;
            if (IabTimerHelper.this.f12242a.isShown()) {
                jMin = Math.min(IabTimerHelper.this.e, jMin + 16);
                IabTimerHelper.this.a(jMin);
                IabTimerHelper.this.b.onTimerTick((IabTimerHelper.this.f * 100.0f) / IabTimerHelper.this.e, IabTimerHelper.this.f, IabTimerHelper.this.e);
            }
            if (jMin >= IabTimerHelper.this.e) {
                IabTimerHelper.this.b.onTimerFinish();
            } else {
                IabTimerHelper.this.f12242a.postDelayed(this, 16L);
            }
        }
    }

    public IabTimerHelper(View view, TimerHelperCallback callback) {
        a aVar = new a();
        this.g = aVar;
        this.h = new b();
        this.f12242a = view;
        this.b = callback;
        view.getViewTreeObserver().addOnGlobalLayoutListener(aVar);
        a();
    }

    public void detach() {
        stop();
        this.f12242a.getViewTreeObserver().removeGlobalOnLayoutListener(this.g);
    }

    public boolean isTicking() {
        long j = this.e;
        return j != 0 && this.f < j;
    }

    public void setTime(float timeSec) {
        if (this.d == timeSec) {
            return;
        }
        this.d = timeSec;
        this.e = (long) (timeSec * 1000.0f);
        start();
    }

    public void start() {
        if (!this.f12242a.isShown() || this.e == 0) {
            return;
        }
        this.f12242a.postDelayed(this.h, 16L);
    }

    public void stop() {
        this.f12242a.removeCallbacks(this.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        this.f = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        boolean zIsShown = this.f12242a.isShown();
        if (this.c == zIsShown) {
            return;
        }
        this.c = zIsShown;
        if (!zIsShown) {
            stop();
        } else if (isTicking()) {
            start();
        }
    }
}
