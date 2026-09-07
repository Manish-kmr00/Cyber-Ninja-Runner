package io.bidmachine.iab.mraid;

import android.view.View;
import android.view.ViewTreeObserver;
import io.bidmachine.iab.utils.Utils;

/* JADX INFO: loaded from: classes5.dex */
public class ViewOnScreenObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewOnScreenObserverRequest f12221a;

    public static class ViewOnScreenObserverRequest {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View[] f12222a;
        private final Runnable b = new a();
        private Runnable c;
        private int d;

        class a implements Runnable {

            /* JADX INFO: renamed from: io.bidmachine.iab.mraid.ViewOnScreenObserver$ViewOnScreenObserverRequest$a$a, reason: collision with other inner class name */
            class ViewTreeObserverOnPreDrawListenerC0780a implements ViewTreeObserver.OnPreDrawListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ View f12224a;

                ViewTreeObserverOnPreDrawListenerC0780a(View view) {
                    this.f12224a = view;
                }

                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    this.f12224a.getViewTreeObserver().removeOnPreDrawListener(this);
                    ViewOnScreenObserverRequest.this.b();
                    return true;
                }
            }

            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                for (View view : ViewOnScreenObserverRequest.this.f12222a) {
                    if (view.getHeight() > 0 || view.getWidth() > 0) {
                        ViewOnScreenObserverRequest.this.b();
                    } else {
                        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC0780a(view));
                    }
                }
            }
        }

        public ViewOnScreenObserverRequest(final View[] views) {
            this.f12222a = views;
        }

        void b() {
            Runnable runnable;
            int i = this.d - 1;
            this.d = i;
            if (i != 0 || (runnable = this.c) == null) {
                return;
            }
            runnable.run();
            this.c = null;
        }

        public void start(Runnable successRunnable) {
            this.c = successRunnable;
            this.d = this.f12222a.length;
            Utils.postOnUiThread(this.b);
        }

        void a() {
            Utils.cancelOnUiThread(this.b);
            this.c = null;
        }
    }

    public void cancelLastRequest() {
        ViewOnScreenObserverRequest viewOnScreenObserverRequest = this.f12221a;
        if (viewOnScreenObserverRequest != null) {
            viewOnScreenObserverRequest.a();
            this.f12221a = null;
        }
    }

    public ViewOnScreenObserverRequest wait(View... views) {
        cancelLastRequest();
        ViewOnScreenObserverRequest viewOnScreenObserverRequest = new ViewOnScreenObserverRequest(views);
        this.f12221a = viewOnScreenObserverRequest;
        return viewOnScreenObserverRequest;
    }
}
