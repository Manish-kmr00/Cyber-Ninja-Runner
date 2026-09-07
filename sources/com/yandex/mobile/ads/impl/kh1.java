package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;

/* JADX INFO: loaded from: classes13.dex */
public final class kh1 extends Surface {
    private static int e;
    private static boolean f;
    public final boolean b;
    private final a c;
    private boolean d;

    public static kh1 a(Context context, boolean z) {
        if (!z || a(context)) {
            return new a().a(z ? e : 0);
        }
        throw new IllegalStateException();
    }

    public static synchronized boolean a(Context context) {
        int i;
        if (!f) {
            if (ne0.a(context)) {
                i = ne0.c() ? 1 : 2;
            } else {
                i = 0;
            }
            e = i;
            f = true;
        }
        return e != 0;
    }

    private kh1(a aVar, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.c = aVar;
        this.b = z;
    }

    @Override // android.view.Surface
    public final void release() {
        super.release();
        synchronized (this.c) {
            if (!this.d) {
                a aVar = this.c;
                aVar.c.getClass();
                aVar.c.sendEmptyMessage(2);
                this.d = true;
            }
        }
    }

    private static class a extends HandlerThread implements Handler.Callback {
        private v40 b;
        private Handler c;
        private Error d;
        private RuntimeException e;
        private kh1 f;

        public a() {
            super("ExoPlayer:PlaceholderSurface");
        }

        public final kh1 a(int i) {
            boolean z;
            start();
            Handler handler = new Handler(getLooper(), this);
            this.c = handler;
            this.b = new v40(handler);
            synchronized (this) {
                z = false;
                this.c.obtainMessage(1, i, 0).sendToTarget();
                while (this.f == null && this.e == null && this.d == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.e;
            if (runtimeException == null) {
                Error error = this.d;
                if (error == null) {
                    kh1 kh1Var = this.f;
                    kh1Var.getClass();
                    return kh1Var;
                }
                throw error;
            }
            throw runtimeException;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i = message.what;
            try {
                if (i != 1) {
                    if (i != 2) {
                        return true;
                    }
                    try {
                        this.b.getClass();
                        this.b.b();
                    } catch (Throwable th) {
                        try {
                            at0.a("PlaceholderSurface", "Failed to release placeholder surface", th);
                        } finally {
                            quit();
                        }
                    }
                    return true;
                }
                try {
                    b(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e) {
                    at0.a("PlaceholderSurface", "Failed to initialize placeholder surface", e);
                    this.d = e;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e2) {
                    at0.a("PlaceholderSurface", "Failed to initialize placeholder surface", e2);
                    this.e = e2;
                    synchronized (this) {
                        notify();
                    }
                }
                return true;
            } catch (Throwable th2) {
                synchronized (this) {
                    notify();
                    throw th2;
                }
            }
        }

        private void b(int i) {
            this.b.getClass();
            this.b.a(i);
            this.f = new kh1(this, this.b.a(), i != 0);
        }
    }
}
