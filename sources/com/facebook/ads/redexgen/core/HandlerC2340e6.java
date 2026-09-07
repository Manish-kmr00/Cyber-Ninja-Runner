package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.facebook.ads.redexgen.core.InterfaceC2341e7;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.io.IOException;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.e6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class HandlerC2340e6<T extends InterfaceC2341e7> extends Handler implements Runnable {
    public static byte[] A0C;
    public static String[] A0D = {"qRlIVfpybLSxoPLWf1TvcUw69qTji", "cSKUugD5eDDQMMPgDouuHQJJPVQpGyf5", "yOZKf7xLU5LJVytLPEHpMJqJz3Stf8V5", "fAagIk3TKLqXMjBZ", "BIij5mDFS23rAGHL30QPA0H1pIevJ9Q4", "5rhI7ybfNHxzM2SLipkBQtSml", "6VhIdsHK1vC0rDVw2X6nIiT8vfoGVBfb", "oTkpv8QcQ0P2p05BJbM5VXT605qhd"};
    public boolean A00;
    public int A01;
    public InterfaceC2338e4<T> A02;
    public C2339e5 A03;
    public IOException A04;
    public Thread A05;
    public boolean A06;
    public final int A07;
    public final long A08;
    public final T A09;
    public volatile boolean A0A;
    public final /* synthetic */ C1831Pj A0B;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A0D;
            if (strArr[3].length() == strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0D;
            strArr2[3] = "TIP2LCTlaY7VBEzS";
            strArr2[5] = "k9TNZr036js2liEpiAWKjrPj9";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE);
            i4++;
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @MetaExoPlayerCustomization("Customized to support load retries")
    private void A02() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.A02.ADw(this.A09, jElapsedRealtime, jElapsedRealtime - this.A08, this.A01);
        this.A04 = null;
        this.A0B.A02.execute((Runnable) AbstractC2388es.A01(this.A0B.A00));
    }

    public static void A04() {
        byte[] bArr = {Ascii.DLE, 51, Base64.padSymbol, 56, 8, Base64.padSymbol, 47, 55, 87, 109, 108, 87, 126, 85, 125, 117, 119, 106, 97, 56, 125, 106, 106, 119, 106, 56, 116, 119, 121, 124, 113, 118, 127, 56, 107, 108, 106, 125, 121, 117, 57, 2, 9, Ascii.DC4, Ascii.FS, 9, Ascii.SI, Ascii.CAN, 9, 8, 76, 9, Ascii.RS, Ascii.RS, 3, Ascii.RS, 76, 0, 3, Ascii.CR, 8, 5, 2, Ascii.VT, 76, Ascii.US, Ascii.CAN, Ascii.RS, 9, Ascii.CR, 1, 85, 110, 101, 120, 112, 101, 99, 116, 101, 100, 32, 101, 120, 99, 101, 112, 116, 105, 111, 110, 32, 104, 97, 110, 100, 108, 105, 110, 103, 32, 108, 111, 97, 100, 32, 99, 111, 109, 112, 108, 101, 116, 101, 100, 100, 95, 84, 73, 65, 84, 82, 69, 84, 85, 17, 84, 73, 82, 84, 65, 69, 88, 94, 95, 17, 93, 94, 80, 85, 88, 95, 86, 17, 66, 69, 67, 84, 80, 92, 17, Ascii.DC2, Ascii.FS, Ascii.EM, 71};
        String[] strArr = A0D;
        if (strArr[2].charAt(15) != strArr[4].charAt(15)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0D;
        strArr2[0] = "H0g8RzKpMK15rJa4eHG9oUaWFtLcI";
        strArr2[7] = "XOVfPWPqToSG8gL66MwxJtnpfJjML";
        A0C = bArr;
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // android.os.Handler
    @MetaExoPlayerCustomization("enableContinueLoadingLogging and currentLoadErrorAction saving are custom")
    public final void handleMessage(Message message) throws Throwable {
        if (BQ.A02(this)) {
            return;
        }
        try {
            if (this.A0A) {
                return;
            }
            if (message.what == 0) {
                A02();
                this.A00 = false;
                return;
            }
            if (message.what == 3) {
                throw ((Error) message.obj);
            }
            A03();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = jElapsedRealtime - this.A08;
            InterfaceC2338e4 interfaceC2338e4 = (InterfaceC2338e4) AbstractC2388es.A01(this.A02);
            if (this.A06) {
                interfaceC2338e4.ADq(this.A09, jElapsedRealtime, j, false);
                return;
            }
            switch (message.what) {
                case 1:
                    try {
                        interfaceC2338e4.ADs(this.A09, jElapsedRealtime, j);
                        return;
                    } catch (RuntimeException e) {
                        AbstractC2432fb.A08(A01(0, 8, 33), A01(71, 44, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE), e);
                        this.A0B.A01 = new C2345eB(e);
                        return;
                    }
                case 2:
                    this.A04 = (IOException) message.obj;
                    this.A01++;
                    C2339e5 c2339e5ADt = interfaceC2338e4.ADt(this.A09, jElapsedRealtime, j, this.A04, this.A01);
                    this.A03 = c2339e5ADt;
                    if (c2339e5ADt.A00 == 3) {
                        this.A0B.A01 = this.A04;
                        return;
                    } else {
                        if (c2339e5ADt.A00 != 2) {
                            if (c2339e5ADt.A00 == 1) {
                                this.A01 = 1;
                            }
                            this.A00 = true;
                            A06(c2339e5ADt.A01 != -9223372036854775807L ? c2339e5ADt.A01 : A00());
                            return;
                        }
                        return;
                    }
                default:
                    return;
            }
            BQ.A00(th, this);
        } catch (Throwable th) {
            BQ.A00(th, this);
        }
    }

    static {
        A04();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.e4 != com.google.android.exoplayer2.upstream.Loader$Callback<T extends com.facebook.ads.redexgen.X.e7> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.e6 != com.google.android.exoplayer2.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.e7> */
    public HandlerC2340e6(C1831Pj c1831Pj, Looper looper, T loadable, InterfaceC2338e4<T> interfaceC2338e4, int i, long j) {
        super(looper);
        this.A0B = c1831Pj;
        this.A09 = loadable;
        this.A02 = interfaceC2338e4;
        this.A07 = i;
        this.A08 = j;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.e6 != com.google.android.exoplayer2.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.e7> */
    @MetaExoPlayerCustomization("D36993743 Customized Hero Retry Delay Values")
    private long A00() {
        return MJ.A00(this.A01, 0);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.e6 != com.google.android.exoplayer2.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.e7> */
    private void A03() {
        this.A0B.A00 = null;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.e6 != com.google.android.exoplayer2.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.e7> */
    public final void A05(int i) throws IOException {
        if (this.A04 == null || this.A01 <= i) {
        } else {
            throw this.A04;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.e6 != com.google.android.exoplayer2.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.e7> */
    public final void A06(long j) {
        AbstractC2388es.A08(this.A0B.A00 == null);
        this.A0B.A00 = this;
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            A02();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.e6 != com.google.android.exoplayer2.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.e7> */
    public final void A07(boolean z) {
        this.A0A = z;
        this.A04 = null;
        if (hasMessages(0)) {
            this.A06 = true;
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            synchronized (this) {
                this.A06 = true;
                this.A09.A4h();
                Thread thread = this.A05;
                if (thread != null) {
                    thread.interrupt();
                }
            }
        }
        if (z) {
            A03();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            ((InterfaceC2338e4) AbstractC2388es.A01(this.A02)).ADq(this.A09, jElapsedRealtime, jElapsedRealtime - this.A08, true);
            this.A02 = null;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.e6 != com.google.android.exoplayer2.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.e7> */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        boolean z;
        if (BQ.A02(this)) {
            return;
        }
        try {
            try {
                try {
                    try {
                        synchronized (this) {
                            z = !this.A06;
                            this.A05 = Thread.currentThread();
                        }
                        if (z) {
                            AbstractC2462g5.A02(A01(150, 5, 0) + this.A09.getClass().getSimpleName());
                            try {
                                this.A09.AAg();
                                AbstractC2462g5.A00();
                            } catch (Throwable th) {
                                AbstractC2462g5.A00();
                                throw th;
                            }
                        }
                        synchronized (this) {
                            this.A05 = null;
                            Thread.interrupted();
                        }
                        if (!this.A0A) {
                            sendEmptyMessage(1);
                        }
                    } catch (IOException e) {
                        if (!this.A0A) {
                            obtainMessage(2, e).sendToTarget();
                        }
                    } catch (OutOfMemoryError e2) {
                        if (!this.A0A) {
                            AbstractC2432fb.A08(A01(0, 8, 33), A01(8, 32, 101), e2);
                            obtainMessage(2, new C2345eB(e2)).sendToTarget();
                        }
                    }
                } catch (Exception e3) {
                    if (!this.A0A) {
                        AbstractC2432fb.A08(A01(0, 8, 33), A01(115, 35, 76), e3);
                        obtainMessage(2, new C2345eB(e3)).sendToTarget();
                    }
                }
            } catch (Error e4) {
                if (!this.A0A) {
                    AbstractC2432fb.A08(A01(0, 8, 33), A01(40, 31, 17), e4);
                    obtainMessage(3, e4).sendToTarget();
                }
                throw e4;
            }
        } catch (Throwable th2) {
            BQ.A00(th2, this);
        }
    }
}
