package com.facebook.ads.redexgen.core;

import android.os.SystemClock;
import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Z6 {
    public static byte[] A06;
    public static final Z6 A07;

    @Nullable
    public MediaCodecPoolTracker A01;

    @Nullable
    public Boolean A02;
    public volatile Map<String, Set<InterfaceC2068Yz>> A04 = new HashMap();
    public final Z5 A03 = new Z5(this);
    public int A00 = 0;
    public volatile long A05 = -1;

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 75);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A06 = new byte[]{6, -2, Ascii.CR, -6, -57, -3, -6, Ascii.SI, -54, -3, -57, -6, Ascii.SI, -54, -57, -3, -2, -4, 8, -3, -2, Ascii.VT};
    }

    /* JADX WARN: Code duplicated, block: B:46:0x0082 A[Catch: all -> 0x009f, TRY_LEAVE, TryCatch #3 {all -> 0x009f, blocks: (B:41:0x0078, B:44:0x007e, B:46:0x0082), top: B:56:0x0078 }] */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private void A0C(boolean z, C1760Mg c1760Mg, EnumC1757Mb enumC1757Mb, String str, InterfaceC2068Yz interfaceC2068Yz) {
        if (A0I(z, c1760Mg) && A0G(str, c1760Mg)) {
            boolean z2 = true;
            synchronized (this) {
                if (this.A00 < c1760Mg.A05) {
                    Set<InterfaceC2068Yz> setA06 = this.A04.get(str);
                    if (setA06 == null) {
                        setA06 = A06();
                        this.A04.put(str, setA06);
                    }
                    if (setA06.contains(interfaceC2068Yz)) {
                        z2 = false;
                    } else if (((z && c1760Mg.A0M) || (!z && c1760Mg.A0L)) && setA06.size() < c1760Mg.A04) {
                        setA06.add(interfaceC2068Yz);
                        this.A00++;
                        z2 = false;
                    }
                }
                if (!z2) {
                    try {
                        try {
                            this.A05 = SystemClock.elapsedRealtime();
                            interfaceC2068Yz.reset();
                            A01().A07(enumC1757Mb, interfaceC2068Yz.hashCode());
                            this.A05 = -1L;
                            return;
                        } catch (Throwable th) {
                            this.A05 = -1L;
                            throw th;
                        }
                    } catch (IllegalStateException unused) {
                        A0B(str, interfaceC2068Yz);
                        this.A05 = -1L;
                        if (c1760Mg.A0Q) {
                            interfaceC2068Yz.stop();
                        } else {
                            interfaceC2068Yz.stop();
                        }
                    }
                }
            }
        }
        try {
            if (c1760Mg.A0Q || (!z && !c1760Mg.A0P)) {
                interfaceC2068Yz.stop();
            }
        } finally {
            A01().A06(enumC1757Mb, interfaceC2068Yz.hashCode());
            interfaceC2068Yz.AGj();
            A01().A05(enumC1757Mb, interfaceC2068Yz.hashCode());
        }
    }

    static {
        A08();
        A07 = new Z6();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaCodecPoolTracker A01() {
        if (this.A01 != null) {
            return this.A01;
        }
        return NoOpMediaCodecPoolTracker.A02;
    }

    private InterfaceC2068Yz A03(boolean z, C1760Mg c1760Mg, EnumC1757Mb enumC1757Mb, String str) throws Exception {
        if (A0I(z, c1760Mg) && A0G(str, c1760Mg)) {
            synchronized (this) {
                Set<InterfaceC2068Yz> set = this.A04.get(str);
                if (set != null && !set.isEmpty()) {
                    this.A00--;
                    Iterator<InterfaceC2068Yz> it = set.iterator();
                    InterfaceC2068Yz ret = it.next();
                    it.remove();
                    A01().A08(z, str, enumC1757Mb, ret.hashCode());
                    return ret;
                }
            }
        }
        try {
            MZ mzA03 = A01().A03(z, str, enumC1757Mb);
            InterfaceC2068Yz interfaceC2068YzA03 = this.A03.A03(z, str);
            A01().A04(mzA03, interfaceC2068YzA03.hashCode());
            return interfaceC2068YzA03;
        } catch (Exception e) {
            throw new MediaCodecInitializationException(str, e);
        }
    }

    public static Z6 A04() {
        return A07;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Set<InterfaceC2068Yz> A06() {
        if (this.A02 != null && this.A02.booleanValue()) {
            return new CopyOnWriteArraySet();
        }
        return new HashSet();
    }

    private void A09(MediaCodecPoolTracker mediaCodecPoolTracker) {
        if (this.A01 == null) {
            this.A01 = mediaCodecPoolTracker;
        }
    }

    private void A0A(C1760Mg c1760Mg) {
        if (this.A02 == null) {
            synchronized (this) {
                if (this.A02 == null) {
                    this.A02 = Boolean.valueOf(c1760Mg.A0R);
                    if (this.A02.booleanValue()) {
                        this.A04 = new ConcurrentHashMap();
                    }
                }
            }
        }
    }

    private void A0B(String str, InterfaceC2068Yz interfaceC2068Yz) {
        Set<InterfaceC2068Yz> set = this.A04.get(str);
        if (set != null && set.remove(interfaceC2068Yz)) {
            this.A00--;
        }
    }

    public static boolean A0E(String str) {
        return str.equals(A05(0, 22, 78));
    }

    public static boolean A0G(String str, C1760Mg c1760Mg) {
        if (A0E(str) && c1760Mg.A0A) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0I(boolean z, C1760Mg c1760Mg) {
        if (c1760Mg.A0C && this.A05 != -1 && SystemClock.elapsedRealtime() - this.A05 > 5000) {
            return false;
        }
        return A0J(z, c1760Mg);
    }

    public static boolean A0J(boolean z, C1760Mg c1760Mg) {
        return (z && c1760Mg.A0M) || (!z && c1760Mg.A0L);
    }

    public final InterfaceC2068Yz A0K(boolean z, C1760Mg c1760Mg, MediaCodecPoolTracker mediaCodecPoolTracker, EnumC1757Mb enumC1757Mb, String str) throws MediaCodecInitializationException {
        A09(mediaCodecPoolTracker);
        A0A(c1760Mg);
        if (c1760Mg.A0J) {
            return this.A03.A02(z, c1760Mg, enumC1757Mb, str);
        }
        return A03(z, c1760Mg, enumC1757Mb, str);
    }

    public final void A0L(boolean z, C1760Mg c1760Mg, MediaCodecPoolTracker mediaCodecPoolTracker, EnumC1757Mb enumC1757Mb, String str, InterfaceC2068Yz interfaceC2068Yz) throws Throwable {
        A09(mediaCodecPoolTracker);
        if (c1760Mg.A0J) {
            this.A03.A0A(z, c1760Mg, enumC1757Mb, str, interfaceC2068Yz);
        } else {
            A0C(z, c1760Mg, enumC1757Mb, str, interfaceC2068Yz);
        }
    }
}
