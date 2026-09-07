package com.mbridge.msdk.util.timer;

import android.os.CountDownTimer;

/* JADX INFO: compiled from: MBCountDownTimer.java */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.util.timer.a f5672a;
    private long b;
    private a c;
    private long d = 0;

    /* JADX INFO: compiled from: MBCountDownTimer.java */
    private static class a extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.mbridge.msdk.util.timer.a f5673a;

        public a(long j, long j2) {
            super(j, j2);
        }

        void a(com.mbridge.msdk.util.timer.a aVar) {
            this.f5673a = aVar;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            com.mbridge.msdk.util.timer.a aVar = this.f5673a;
            if (aVar != null) {
                aVar.onFinish();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            com.mbridge.msdk.util.timer.a aVar = this.f5673a;
            if (aVar != null) {
                aVar.onTick(j);
            }
        }
    }

    public void a() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.cancel();
            this.c = null;
        }
    }

    public b b(long j) {
        this.d = j;
        return this;
    }

    public void c() {
        if (this.c == null) {
            b();
        }
        this.c.start();
    }

    public void b() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.cancel();
            this.c = null;
        }
        if (this.b <= 0) {
            this.b = this.d + 1000;
        }
        a aVar2 = new a(this.d, this.b);
        this.c = aVar2;
        aVar2.a(this.f5672a);
    }

    public b a(long j) {
        if (j < 0) {
            j = 1000;
        }
        this.b = j;
        return this;
    }

    public b a(com.mbridge.msdk.util.timer.a aVar) {
        this.f5672a = aVar;
        return this;
    }
}
