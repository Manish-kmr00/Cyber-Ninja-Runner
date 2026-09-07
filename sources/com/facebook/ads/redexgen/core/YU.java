package com.facebook.ads.redexgen.core;

import com.json.fe;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class YU {
    public static String[] A00 = {"raiZexzcSLu8VHzyF5Yi5A1wS78BH1RV", "3kGwY1fDjldhWGY5QDheot1YUsS7C4AJ", fe.u0, "UP6X7ZW0a1WAuLd47Sb6F2quoJi2hMLB", "AHmqvYHp8NMO9gAMYhoRSwwJevbU4zLW", "xfQKS4uejnobZBIBLIZBjpbf8", "sol5eQAp3mMREoTYVQWWtSEUthqSxsOz", "7zCpV0a32XoMO1MJWSobGmDxrbcYEpc"};

    public static int A00(byte[] bArr, int i, int i2) {
        while (i < i2) {
            byte b = bArr[i];
            if (A00[2].length() == 2) {
                String[] strArr = A00;
                strArr[4] = "bHHeJRwgrIMVMuWCUa5g4wjcHkmCzccT";
                strArr[6] = "yQr04RBpOSMMpODEgR4tEhGOq1fgkNXy";
                if (b == 71) {
                    break;
                }
                i++;
            } else {
                throw new RuntimeException();
            }
        }
        return i;
    }

    public static long A01(C2447fq c2447fq, int i, int i2) {
        c2447fq.A0f(i);
        if (c2447fq.A07() < 5) {
            return -9223372036854775807L;
        }
        int pid = c2447fq.A0C();
        int tsPacketHeader = 8388608 & pid;
        if (tsPacketHeader != 0) {
            return -9223372036854775807L;
        }
        int tsPacketHeader2 = 2096896 & pid;
        if ((tsPacketHeader2 >> 8) != i2) {
            return -9223372036854775807L;
        }
        int tsPacketHeader3 = pid & 32;
        int tsPacketHeader4 = tsPacketHeader3 != 0 ? 1 : 0;
        if (tsPacketHeader4 == 0) {
            return -9223372036854775807L;
        }
        int tsPacketHeader5 = c2447fq.A0I();
        if (tsPacketHeader5 >= 7) {
            int tsPacketHeader6 = c2447fq.A07();
            if (tsPacketHeader6 >= 7) {
                int tsPacketHeader7 = c2447fq.A0I();
                if ((tsPacketHeader7 & 16) == 16) {
                    byte[] bArr = new byte[6];
                    int tsPacketHeader8 = bArr.length;
                    c2447fq.A0k(bArr, 0, tsPacketHeader8);
                    return A02(bArr);
                }
            }
        }
        return -9223372036854775807L;
    }

    public static long A02(byte[] bArr) {
        return ((((long) bArr[0]) & 255) << 25) | ((((long) bArr[1]) & 255) << 17) | ((((long) bArr[2]) & 255) << 9) | ((((long) bArr[3]) & 255) << 1) | ((255 & ((long) bArr[4])) >> 7);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0012  */
    public static boolean A03(byte[] bArr, int i, int i2, int i3) {
        int i4 = 0;
        for (int currentPosition = -4; currentPosition <= 4; currentPosition++) {
            int consecutiveSyncByteCount = (currentPosition * 188) + i3;
            if (consecutiveSyncByteCount < i || consecutiveSyncByteCount >= i2) {
                i4 = 0;
            } else {
                int i5 = bArr[consecutiveSyncByteCount];
                if (i5 != 71) {
                    i4 = 0;
                } else {
                    i4++;
                    if (i4 == 5) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
