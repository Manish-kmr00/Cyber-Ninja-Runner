package com.yandex.mobile.ads.impl;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class hh {
    private static final ArrayDeque<b> g = new ArrayDeque<>();
    private static final Object h = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediaCodec f9093a;
    private final HandlerThread b;
    private Handler c;
    private final AtomicReference<RuntimeException> d;
    private final gr e;
    private boolean f;

    private static b b() {
        ArrayDeque<b> arrayDeque = g;
        synchronized (arrayDeque) {
            if (arrayDeque.isEmpty()) {
                return new b();
            }
            return arrayDeque.removeFirst();
        }
    }

    public final void e() throws InterruptedException {
        this.e.c();
        Handler handler = this.c;
        handler.getClass();
        handler.obtainMessage(2).sendToTarget();
        this.e.a();
    }

    public hh(MediaCodec mediaCodec, HandlerThread handlerThread) {
        this(mediaCodec, handlerThread, new gr());
    }

    public final void d() {
        if (this.f) {
            return;
        }
        this.b.start();
        this.c = new a(this.b.getLooper());
        this.f = true;
    }

    final class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            hh.this.a(message);
        }
    }

    public final void c() {
        if (this.f) {
            a();
            this.b.quit();
        }
        this.f = false;
    }

    hh(MediaCodec mediaCodec, HandlerThread handlerThread, gr grVar) {
        this.f9093a = mediaCodec;
        this.b = handlerThread;
        this.e = grVar;
        this.d = new AtomicReference<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:28:0x0061  */
    /* JADX WARN: Code duplicated, block: B:35:? A[RETURN, SYNTHETIC] */
    public void a(Message message) {
        b bVar;
        int i = message.what;
        b bVar2 = null;
        if (i != 0) {
            if (i == 1) {
                bVar = (b) message.obj;
                int i2 = bVar.f9095a;
                int i3 = bVar.b;
                MediaCodec.CryptoInfo cryptoInfo = bVar.d;
                long j = bVar.e;
                int i4 = bVar.f;
                try {
                    synchronized (h) {
                        this.f9093a.queueSecureInputBuffer(i2, i3, cryptoInfo, j, i4);
                    }
                } catch (RuntimeException e) {
                    MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.d, null, e);
                }
            } else if (i != 2) {
                MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.d, null, new IllegalStateException(String.valueOf(message.what)));
            } else {
                this.e.e();
            }
            if (bVar2 != null) {
                a(bVar2);
            }
        }
        bVar = (b) message.obj;
        try {
            this.f9093a.queueInputBuffer(bVar.f9095a, bVar.b, bVar.c, bVar.e, bVar.f);
        } catch (RuntimeException e2) {
            MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.d, null, e2);
        }
        bVar2 = bVar;
        if (bVar2 != null) {
            a(bVar2);
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f9095a;
        public int b;
        public int c;
        public final MediaCodec.CryptoInfo d = new MediaCodec.CryptoInfo();
        public long e;
        public int f;

        b() {
        }
    }

    public final void a() {
        if (this.f) {
            try {
                Handler handler = this.c;
                handler.getClass();
                handler.removeCallbacksAndMessages(null);
                this.e.c();
                Handler handler2 = this.c;
                handler2.getClass();
                handler2.obtainMessage(2).sendToTarget();
                this.e.a();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    public final void a(int i, int i2, long j, int i3) {
        RuntimeException andSet = this.d.getAndSet(null);
        if (andSet == null) {
            b bVarB = b();
            bVarB.f9095a = i;
            bVarB.b = 0;
            bVarB.c = i2;
            bVarB.e = j;
            bVarB.f = i3;
            Handler handler = this.c;
            int i4 = x82.f10629a;
            handler.obtainMessage(0, bVarB).sendToTarget();
            return;
        }
        throw andSet;
    }

    public final void a(int i, dv dvVar, long j) {
        RuntimeException andSet = this.d.getAndSet(null);
        if (andSet == null) {
            b bVarB = b();
            bVarB.f9095a = i;
            bVarB.b = 0;
            bVarB.c = 0;
            bVarB.e = j;
            bVarB.f = 0;
            MediaCodec.CryptoInfo cryptoInfo = bVarB.d;
            cryptoInfo.numSubSamples = dvVar.f;
            int[] iArr = dvVar.d;
            int[] iArrCopyOf = cryptoInfo.numBytesOfClearData;
            if (iArr != null) {
                if (iArrCopyOf != null && iArrCopyOf.length >= iArr.length) {
                    System.arraycopy(iArr, 0, iArrCopyOf, 0, iArr.length);
                } else {
                    iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
                }
            }
            cryptoInfo.numBytesOfClearData = iArrCopyOf;
            int[] iArr2 = dvVar.e;
            int[] iArrCopyOf2 = cryptoInfo.numBytesOfEncryptedData;
            if (iArr2 != null) {
                if (iArrCopyOf2 != null && iArrCopyOf2.length >= iArr2.length) {
                    System.arraycopy(iArr2, 0, iArrCopyOf2, 0, iArr2.length);
                } else {
                    iArrCopyOf2 = Arrays.copyOf(iArr2, iArr2.length);
                }
            }
            cryptoInfo.numBytesOfEncryptedData = iArrCopyOf2;
            byte[] bArr = dvVar.b;
            byte[] bArrCopyOf = cryptoInfo.key;
            if (bArr != null) {
                if (bArrCopyOf != null && bArrCopyOf.length >= bArr.length) {
                    System.arraycopy(bArr, 0, bArrCopyOf, 0, bArr.length);
                } else {
                    bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                }
            }
            bArrCopyOf.getClass();
            cryptoInfo.key = bArrCopyOf;
            byte[] bArr2 = dvVar.f8735a;
            byte[] bArrCopyOf2 = cryptoInfo.iv;
            if (bArr2 != null) {
                if (bArrCopyOf2 != null && bArrCopyOf2.length >= bArr2.length) {
                    System.arraycopy(bArr2, 0, bArrCopyOf2, 0, bArr2.length);
                } else {
                    bArrCopyOf2 = Arrays.copyOf(bArr2, bArr2.length);
                }
            }
            bArrCopyOf2.getClass();
            cryptoInfo.iv = bArrCopyOf2;
            cryptoInfo.mode = dvVar.c;
            if (x82.f10629a >= 24) {
                cryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(dvVar.g, dvVar.h));
            }
            this.c.obtainMessage(1, bVarB).sendToTarget();
            return;
        }
        throw andSet;
    }

    private static void a(b bVar) {
        ArrayDeque<b> arrayDeque = g;
        synchronized (arrayDeque) {
            arrayDeque.add(bVar);
        }
    }
}
