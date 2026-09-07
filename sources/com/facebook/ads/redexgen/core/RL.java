package com.facebook.ads.redexgen.core;

import android.util.SparseArray;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.concurrent.Executor;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class RL implements InterfaceC2111aJ {
    public static byte[] A02;
    public static String[] A03 = {"Ulq9k3xGQBCBjyPP0kXtwtb56IG", "4zW3cybUTANcrI", "E48BpRIrDfgBXEJqLj9s", "TfRbV1RzUu6tuiFHojOJ", "DMtCCmYNgsf9oVPruwtmcMDh8qrQiIiv", "yICYaZTzLhdkG2", "nFyYLsyOyT0Yp5xYmRcA13RlJDX8TddY", "b0Owjge10VTCc21YLtM4gKm1t5xX54HI"};
    public static final SparseArray<Constructor<? extends InterfaceC2109aH>> A04;
    public final PX A00;
    public final Executor A01;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A03;
            if (strArr[5].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            A03[4] = "HkoHSSoTSOJPHKCGZfPEBPIcuo54aoHm";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 97);
            i4++;
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static Constructor<? extends InterfaceC2109aH> A03(Class<?> cls) {
        try {
            return cls.asSubclass(InterfaceC2109aH.class).getConstructor(ZE.class, PX.class, Executor.class);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException(A02(0, 30, 30), e);
        }
    }

    public static void A04() {
        A02 = new byte[]{59, Ascii.DLE, 8, 17, 19, Ascii.DLE, Ascii.RS, Ascii.ESC, Ascii.SUB, Ascii.CR, 95, Ascii.FS, Ascii.DLE, 17, Ascii.FF, Ascii.VT, Ascii.CR, 10, Ascii.FS, Ascii.VT, Ascii.DLE, Ascii.CR, 95, Ascii.DC2, Ascii.SYN, Ascii.FF, Ascii.FF, Ascii.SYN, 17, Ascii.CAN, 37, 2, 10, Ascii.SI, 6, 7, 67, Ascii.ETB, Ascii.FF, 67, 10, Ascii.CR, Ascii.DLE, Ascii.ETB, 2, Ascii.CR, Ascii.ETB, 10, 2, Ascii.ETB, 6, 67, 7, Ascii.FF, Ascii.DC4, Ascii.CR, Ascii.SI, Ascii.FF, 2, 7, 6, 17, 67, 5, Ascii.FF, 17, 67, 0, Ascii.FF, Ascii.CR, Ascii.ETB, 6, Ascii.CR, Ascii.ETB, 67, Ascii.ETB, Ascii.SUB, 19, 6, 67, 63, Ascii.GS, Ascii.SYN, 7, Ascii.RS, Ascii.ETB, 82, Ascii.US, Ascii.ESC, 1, 1, Ascii.ESC, Ascii.FS, Ascii.NAK, 82, Ascii.DC4, Ascii.GS, 0, 82, 17, Ascii.GS, Ascii.FS, 6, Ascii.ETB, Ascii.FS, 6, 82, 6, Ascii.VT, 2, Ascii.ETB, 82, 107, 80, 77, 75, 78, 78, 81, 76, 74, 91, 90, Ascii.RS, 74, 71, 78, 91, 4, Ascii.RS, 46, 34, 32, 99, 42, 34, 34, 42, 33, 40, 99, 44, 35, 41, 63, 34, 36, 41, 99, 40, 53, 34, Base64.padSymbol, 33, 44, 52, 40, 63, 127, 99, 62, 34, 56, 63, 46, 40, 99, 41, 44, 62, 37, 99, 34, 43, 43, 33, 36, 35, 40, 99, 9, 44, 62, 37, 9, 34, 58, 35, 33, 34, 44, 41, 40, 63, 40, 36, 38, 101, 44, 36, 36, 44, 39, 46, 101, 42, 37, 47, 57, 36, 34, 47, 101, 46, 51, 36, 59, 39, 42, 50, 46, 57, 121, 101, 56, 36, 62, 57, 40, 46, 101, 35, 39, 56, 101, 36, 45, 45, 39, 34, 37, 46, 101, 3, 39, 56, Ascii.SI, 36, 60, 37, 39, 36, 42, 47, 46, 57, 87, 91, 89, Ascii.SUB, 83, 91, 91, 83, 88, 81, Ascii.SUB, 85, 90, 80, 70, 91, 93, 80, Ascii.SUB, 81, 76, 91, 68, 88, 85, 77, 81, 70, 6, Ascii.SUB, 71, 91, 65, 70, 87, 81, Ascii.SUB, 71, 89, 91, 91, SignedBytes.MAX_POWER_OF_TWO, 92, 71, SignedBytes.MAX_POWER_OF_TWO, 70, 81, 85, 89, 93, 90, 83, Ascii.SUB, 91, 82, 82, 88, 93, 90, 81, Ascii.SUB, 103, 71, 112, 91, 67, 90, 88, 91, 85, 80, 81, 70};
    }

    static {
        A04();
        A04 = A00();
    }

    public RL(PX px, Executor executor) {
        this.A00 = (PX) AbstractC2388es.A01(px);
        this.A01 = (Executor) AbstractC2388es.A01(executor);
    }

    public static SparseArray<Constructor<? extends InterfaceC2109aH>> A00() {
        SparseArray<Constructor<? extends InterfaceC2109aH>> sparseArray = new SparseArray<>();
        try {
            sparseArray.put(0, A03(Class.forName(A02(130, 64, 44))));
        } catch (ClassNotFoundException unused) {
        }
        try {
            sparseArray.put(2, A03(Class.forName(A02(194, 62, 42))));
        } catch (ClassNotFoundException unused2) {
        }
        try {
            sparseArray.put(1, A03(Class.forName(A02(256, 73, 85))));
        } catch (ClassNotFoundException unused3) {
        }
        return sparseArray;
    }

    private InterfaceC2109aH A01(DownloadRequest downloadRequest, int i) {
        Constructor<? extends InterfaceC2109aH> constructor = A04.get(i);
        if (constructor != null) {
            try {
                return constructor.newInstance(new PH().A00(downloadRequest.A00).A04(downloadRequest.A04).A02(downloadRequest.A01).A05(), this.A00, this.A01);
            } catch (Exception e) {
                throw new IllegalStateException(A02(30, 50, 2) + i, e);
            }
        }
        throw new IllegalStateException(A02(80, 32, 19) + i);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2111aJ
    public final InterfaceC2109aH A5C(DownloadRequest downloadRequest) {
        int iA0B = AbstractC2471gE.A0B(downloadRequest.A00, downloadRequest.A03);
        switch (iA0B) {
            case 0:
            case 1:
            case 2:
                InterfaceC2109aH interfaceC2109aHA01 = A01(downloadRequest, iA0B);
                if (A03[4].charAt(30) == 'x') {
                    throw new RuntimeException();
                }
                String[] strArr = A03;
                strArr[2] = "5qkQ9TiBqAoy97Dxm7VN";
                strArr[3] = "3DoYFcbxlhnwupfJ1YAA";
                return interfaceC2109aHA01;
            case 3:
            default:
                throw new IllegalArgumentException(A02(112, 18, 95) + iA0B);
            case 4:
                return new RE(new PH().A00(downloadRequest.A00).A02(downloadRequest.A01).A05(), this.A00, this.A01);
        }
    }
}
