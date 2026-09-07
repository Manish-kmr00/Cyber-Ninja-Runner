package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class UG {
    public static byte[] A03;
    public static String[] A04 = {"iyyUjXp", "P88zN0aelW", "mNluFpyyjV1QT8aP2GC04Mh9Rf8CEmrn", "A78cA", "k4sjM1DVTAxuVVu9BGpk3pGlhvYD5YcK", "UEBM4ijtyg5tUNZxA", "gJ7", "rs6FgzFUIAnakk5Hwzcq4oG8n"};
    public final UF A00;
    public final Constructor<? extends UK> A01;
    public final AtomicBoolean A02 = new AtomicBoolean(false);

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A04[0].length() == 3) {
                throw new RuntimeException();
            }
            A04[1] = "yTgDbTyvDcUeIJbr";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE);
            i4++;
        }
    }

    public static void A02() {
        A03 = new byte[]{126, 73, 73, 84, 73, Ascii.ESC, 82, 85, 72, 79, 90, 85, 79, 82, 90, 79, 82, 85, 92, Ascii.ESC, 94, 67, 79, 94, 85, 72, 82, 84, 85, 59, 0, Ascii.VT, Ascii.SYN, Ascii.RS, Ascii.VT, Ascii.CR, Ascii.SUB, Ascii.VT, 10, 78, Ascii.VT, Ascii.FS, Ascii.FS, 1, Ascii.FS, 78, Ascii.CR, Ascii.FS, Ascii.VT, Ascii.SI, Ascii.SUB, 7, 0, 9, 78, Ascii.VT, Ascii.SYN, Ascii.SUB, Ascii.FS, Ascii.SI, Ascii.CR, Ascii.SUB, 1, Ascii.FS};
    }

    static {
        A02();
    }

    public UG(UF uf) {
        this.A00 = uf;
    }

    private Constructor<? extends UK> A01() {
        synchronized (this.A02) {
            if (this.A02.get()) {
                return this.A01;
            }
            try {
                return this.A00.A7H();
            } catch (ClassNotFoundException unused) {
                this.A02.set(true);
                return this.A01;
            } catch (Exception e) {
                throw new RuntimeException(A00(0, 29, 64), e);
            }
        }
    }

    public final UK A03(Object... objArr) {
        Constructor<? extends UK> constructorA01 = A01();
        if (constructorA01 == null) {
            return null;
        }
        try {
            return constructorA01.newInstance(objArr);
        } catch (Exception e) {
            throw new IllegalStateException(A00(29, 35, 21), e);
        }
    }
}
