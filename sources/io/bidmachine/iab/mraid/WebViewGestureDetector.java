package io.bidmachine.iab.mraid;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes13.dex */
public class WebViewGestureDetector extends GestureDetector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f12226a;

    static class a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f12227a = false;

        a() {
        }

        boolean a() {
            return this.f12227a;
        }

        void b() {
            this.f12227a = false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            this.f12227a = true;
            return super.onSingleTapUp(motionEvent);
        }
    }

    public WebViewGestureDetector(Context context) {
        this(context, new a());
    }

    public boolean isClicked() {
        return this.f12226a.a();
    }

    public void resetClick() {
        this.f12226a.b();
    }

    private WebViewGestureDetector(Context context, a listener) {
        super(context, listener);
        this.f12226a = listener;
        setIsLongpressEnabled(false);
    }
}
