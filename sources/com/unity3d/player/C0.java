package com.unity3d.player;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes12.dex */
final class C0 implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ E0 f8208a;

    C0(E0 e0) {
        this.f8208a = e0;
    }

    /* JADX WARN: Code duplicated, block: B:63:0x0123  */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 2269) {
            return false;
        }
        D0 d0 = (D0) message.obj;
        D0 d1 = D0.h;
        if (d0 == d1) {
            E0 e0 = this.f8208a;
            e0.f--;
            e0.f8214a.executeMainThreadJobs();
            E0 e1 = this.f8208a;
            if (!e1.c) {
                return true;
            }
            if (e1.f8214a.getHaveAndroidWindowSupport() && !this.f8208a.d) {
                return true;
            }
            E0 e2 = this.f8208a;
            int i = e2.i;
            if (i >= 0) {
                if (i == 0) {
                    if (e2.f8214a.getSplashEnabled()) {
                        this.f8208a.f8214a.disableStaticSplashScreen();
                    }
                    if (this.f8208a.f8214a.shouldReportFullyDrawn()) {
                        this.f8208a.f8214a.reportFullyDrawn();
                    }
                }
                this.f8208a.i--;
            }
            if (!this.f8208a.f8214a.isFinishing() && !this.f8208a.f8214a.nativeRender()) {
                this.f8208a.f8214a.finish();
            }
        } else if (d0 == D0.c) {
            Looper.myLooper().quit();
        } else if (d0 == D0.b) {
            this.f8208a.c = true;
        } else if (d0 == D0.f8211a) {
            this.f8208a.c = false;
        } else if (d0 == D0.d) {
            this.f8208a.d = false;
        } else if (d0 == D0.e) {
            E0 e3 = this.f8208a;
            e3.d = true;
            if (e3.e == 3 && (!e3.f8214a.getHaveAndroidWindowSupport() || this.f8208a.d)) {
                this.f8208a.f8214a.nativeFocusChanged(true);
                this.f8208a.e = 1;
            }
        } else if (d0 == D0.f) {
            E0 e4 = this.f8208a;
            if (e4.e == 1) {
                e4.f8214a.nativeFocusChanged(false);
            }
            this.f8208a.e = 2;
        } else if (d0 == D0.g) {
            E0 e5 = this.f8208a;
            e5.e = 3;
            if (!e5.f8214a.getHaveAndroidWindowSupport() || this.f8208a.d) {
                this.f8208a.f8214a.nativeFocusChanged(true);
                this.f8208a.e = 1;
            }
        } else if (d0 == D0.i) {
            E0 e6 = this.f8208a;
            e6.f8214a.nativeOrientationChanged(e6.g, e6.h);
        }
        E0 e7 = this.f8208a;
        if (e7.c && e7.f <= 0) {
            Message.obtain(e7.b, 2269, d1).sendToTarget();
            this.f8208a.f++;
        }
        return true;
    }
}
