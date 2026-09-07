package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fY, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2429fY<T> {
    public static byte[] A09;
    public static String[] A0A = {"UuLgjUOIdyGS", "ee6yES2M3", "DH1W5VPkD68OHV5TXQZBMwP", "XgArYMb", "rlcAueV0YRu7ViMRxjPXXB7wxVHCqlgX", "giRCnbhmv8XTp9tbMUeioURlJgICIUe1", "BYkF1ZhmMA6H", "oMzlOxjvbUq0Bzk1AXuAobFM66"};
    public boolean A00;
    public boolean A01;
    public final InterfaceC2395ez A02;
    public final InterfaceC2423fS A03;
    public final InterfaceC2427fW<T> A04;
    public final Object A05;
    public final ArrayDeque<Runnable> A06;
    public final ArrayDeque<Runnable> A07;
    public final CopyOnWriteArraySet<C2428fX<T>> A08;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public C2429fY(CopyOnWriteArraySet<C2428fX<T>> copyOnWriteArraySet, Looper looper, InterfaceC2395ez interfaceC2395ez, InterfaceC2427fW<T> interfaceC2427fW) {
        this.A02 = interfaceC2395ez;
        this.A08 = copyOnWriteArraySet;
        this.A04 = interfaceC2427fW;
        this.A05 = new Object();
        this.A06 = new ArrayDeque<>();
        this.A07 = new ArrayDeque<>();
        this.A03 = interfaceC2395ez.A5F(looper, new Handler.Callback() { // from class: com.facebook.ads.redexgen.X.fU
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.A00.A05(message);
            }
        });
        this.A01 = true;
        this.A00 = MetaExoPlayerUpgradeConfig.A03(EnumC1764Mn.A0E);
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A09 = new byte[]{123, 124, 100, 125, 121, 119, Ascii.DC2, Ascii.SI, Ascii.RS, 9, Ascii.SUB, Ascii.SI, Ascii.DC2, Ascii.DC4, Ascii.NAK, Base64.padSymbol, Ascii.DC2, Ascii.NAK, Ascii.DC2, 8, 19, Ascii.RS, Ascii.US};
    }

    static {
        A03();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.fW != com.google.android.exoplayer2.util.ListenerSet$IterationFinishedEvent<T> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.fY != com.google.android.exoplayer2.util.ListenerSet<T> */
    public C2429fY(Looper looper, InterfaceC2395ez interfaceC2395ez, InterfaceC2427fW<T> interfaceC2427fW) {
        this(new CopyOnWriteArraySet(), looper, interfaceC2395ez, interfaceC2427fW);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.fW != com.google.android.exoplayer2.util.ListenerSet$IterationFinishedEvent<T> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.fY != com.google.android.exoplayer2.util.ListenerSet<T> */
    private final C2429fY<T> A00(Looper looper, InterfaceC2395ez interfaceC2395ez, InterfaceC2427fW<T> interfaceC2427fW) {
        return new C2429fY<>(this.A08, looper, interfaceC2395ez, interfaceC2427fW);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.fY != com.google.android.exoplayer2.util.ListenerSet<T> */
    private void A02() {
        if (!this.A01) {
            return;
        }
        AbstractC2388es.A08(Thread.currentThread() == this.A03.A8H().getThread());
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.fX != com.google.android.exoplayer2.util.ListenerSet$ListenerHolder<T> */
    public static /* synthetic */ void A04(CopyOnWriteArraySet copyOnWriteArraySet, int i, InterfaceC2426fV interfaceC2426fV) {
        Iterator it = copyOnWriteArraySet.iterator();
        if (it.hasNext()) {
            it.next();
            throw new NullPointerException(A01(0, 6, 110));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.fX != com.google.android.exoplayer2.util.ListenerSet$ListenerHolder<T> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.fY != com.google.android.exoplayer2.util.ListenerSet<T> */
    public boolean A05(Message message) {
        Iterator<C2428fX<T>> it = this.A08.iterator();
        if (it.hasNext()) {
            it.next();
            throw new NullPointerException(A01(6, 17, 7));
        }
        return true;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.fW != com.google.android.exoplayer2.util.ListenerSet$IterationFinishedEvent<T> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.fY != com.google.android.exoplayer2.util.ListenerSet<T> */
    public final C2429fY<T> A07(Looper looper, InterfaceC2427fW<T> interfaceC2427fW) {
        return A00(looper, this.A02, interfaceC2427fW);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.fY != com.google.android.exoplayer2.util.ListenerSet<T> */
    public final void A08() {
        A02();
        if (this.A07.isEmpty()) {
            return;
        }
        if (!this.A03.A9d(0)) {
            this.A03.AIJ(this.A03.AC1(0));
        }
        boolean z = !this.A06.isEmpty();
        ArrayDeque<Runnable> arrayDeque = this.A06;
        ArrayDeque<Runnable> arrayDeque2 = this.A07;
        String[] strArr = A0A;
        if (strArr[1].length() != strArr[6].length()) {
            String[] strArr2 = A0A;
            strArr2[2] = "UNsujj5bBKI2lC9QEO6YJnt";
            strArr2[0] = "dXWZh9dgGEaI";
            arrayDeque.addAll(arrayDeque2);
            this.A07.clear();
            if (z) {
                return;
            }
            while (!recursiveFlushInProgress) {
                Runnable runnablePeekFirst = this.A06.peekFirst();
                String[] strArr3 = A0A;
                if (strArr3[4].charAt(27) == strArr3[5].charAt(27)) {
                    String[] strArr4 = A0A;
                    strArr4[1] = "JjeenRb0h";
                    strArr4[6] = "RHSD9U62NwjI";
                    runnablePeekFirst.run();
                    this.A06.removeFirst();
                }
            }
            return;
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.fV != com.google.android.exoplayer2.util.ListenerSet$Event<T> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.fX != com.google.android.exoplayer2.util.ListenerSet$ListenerHolder<T> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.fY != com.google.android.exoplayer2.util.ListenerSet<T> */
    public final void A09(final int i, final InterfaceC2426fV<T> interfaceC2426fV) {
        A02();
        final CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(this.A08);
        if (this.A00) {
            Iterator it = copyOnWriteArraySet.iterator();
            if (it.hasNext()) {
                it.next();
                throw new NullPointerException(A01(0, 6, 110));
            }
            return;
        }
        this.A07.add(new Runnable() { // from class: com.facebook.ads.redexgen.X.fT
            @Override // java.lang.Runnable
            public final void run() {
                C2429fY.A04(copyOnWriteArraySet, i, interfaceC2426fV);
            }
        });
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.fV != com.google.android.exoplayer2.util.ListenerSet$Event<T> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.fY != com.google.android.exoplayer2.util.ListenerSet<T> */
    public final void A0A(int i, InterfaceC2426fV<T> interfaceC2426fV) {
        A09(i, interfaceC2426fV);
        A08();
    }
}
