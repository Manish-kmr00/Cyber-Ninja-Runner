package kotlin.collections;

import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UArraySorting.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\t\u0010\n\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\f\u0010\r\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0013\u0010\u0014\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0015\u0010\u0016\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0017\u0010\u0018\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0019\u0010\u001a\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001e\u0010\u0014\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001f\u0010\u0016\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b \u0010\u0018\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b!\u0010\u001a¨\u0006\""}, d2 = {"partition", "", "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-oBK06Vg", "sortArray--nroSd4", "sortArray-Aa5vz7o", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UArraySortingKt {
    /* JADX INFO: renamed from: partition-4UcCI2c, reason: not valid java name */
    private static final int m8362partition4UcCI2c(byte[] bArr, int i, int i2) {
        int i3;
        byte bM7982getw2LRezQ = UByteArray.m7982getw2LRezQ(bArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                i3 = bM7982getw2LRezQ & 255;
                if (Intrinsics.compare(UByteArray.m7982getw2LRezQ(bArr, i) & 255, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UByteArray.m7982getw2LRezQ(bArr, i2) & 255, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                byte bM7982getw2LRezQ2 = UByteArray.m7982getw2LRezQ(bArr, i);
                UByteArray.m7987setVurrAj0(bArr, i, UByteArray.m7982getw2LRezQ(bArr, i2));
                UByteArray.m7987setVurrAj0(bArr, i2, bM7982getw2LRezQ2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort-4UcCI2c, reason: not valid java name */
    private static final void m8366quickSort4UcCI2c(byte[] bArr, int i, int i2) {
        int iM8362partition4UcCI2c = m8362partition4UcCI2c(bArr, i, i2);
        int i3 = iM8362partition4UcCI2c - 1;
        if (i < i3) {
            m8366quickSort4UcCI2c(bArr, i, i3);
        }
        if (iM8362partition4UcCI2c < i2) {
            m8366quickSort4UcCI2c(bArr, iM8362partition4UcCI2c, i2);
        }
    }

    /* JADX INFO: renamed from: partition-Aa5vz7o, reason: not valid java name */
    private static final int m8363partitionAa5vz7o(short[] sArr, int i, int i2) {
        int i3;
        short sM8245getMh2AYeg = UShortArray.m8245getMh2AYeg(sArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                int iM8245getMh2AYeg = UShortArray.m8245getMh2AYeg(sArr, i) & UShort.MAX_VALUE;
                i3 = sM8245getMh2AYeg & UShort.MAX_VALUE;
                if (Intrinsics.compare(iM8245getMh2AYeg, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UShortArray.m8245getMh2AYeg(sArr, i2) & UShort.MAX_VALUE, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                short sM8245getMh2AYeg2 = UShortArray.m8245getMh2AYeg(sArr, i);
                UShortArray.m8250set01HTLdE(sArr, i, UShortArray.m8245getMh2AYeg(sArr, i2));
                UShortArray.m8250set01HTLdE(sArr, i2, sM8245getMh2AYeg2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort-Aa5vz7o, reason: not valid java name */
    private static final void m8367quickSortAa5vz7o(short[] sArr, int i, int i2) {
        int iM8363partitionAa5vz7o = m8363partitionAa5vz7o(sArr, i, i2);
        int i3 = iM8363partitionAa5vz7o - 1;
        if (i < i3) {
            m8367quickSortAa5vz7o(sArr, i, i3);
        }
        if (iM8363partitionAa5vz7o < i2) {
            m8367quickSortAa5vz7o(sArr, iM8363partitionAa5vz7o, i2);
        }
    }

    /* JADX INFO: renamed from: partition-oBK06Vg, reason: not valid java name */
    private static final int m8364partitionoBK06Vg(int[] iArr, int i, int i2) {
        int iM8061getpVg5ArA = UIntArray.m8061getpVg5ArA(iArr, (i + i2) / 2);
        while (i <= i2) {
            while (Integer.compare(UIntArray.m8061getpVg5ArA(iArr, i) ^ Integer.MIN_VALUE, iM8061getpVg5ArA ^ Integer.MIN_VALUE) < 0) {
                i++;
            }
            while (Integer.compare(UIntArray.m8061getpVg5ArA(iArr, i2) ^ Integer.MIN_VALUE, iM8061getpVg5ArA ^ Integer.MIN_VALUE) > 0) {
                i2--;
            }
            if (i <= i2) {
                int iM8061getpVg5ArA2 = UIntArray.m8061getpVg5ArA(iArr, i);
                UIntArray.m8066setVXSXFK8(iArr, i, UIntArray.m8061getpVg5ArA(iArr, i2));
                UIntArray.m8066setVXSXFK8(iArr, i2, iM8061getpVg5ArA2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort-oBK06Vg, reason: not valid java name */
    private static final void m8368quickSortoBK06Vg(int[] iArr, int i, int i2) {
        int iM8364partitionoBK06Vg = m8364partitionoBK06Vg(iArr, i, i2);
        int i3 = iM8364partitionoBK06Vg - 1;
        if (i < i3) {
            m8368quickSortoBK06Vg(iArr, i, i3);
        }
        if (iM8364partitionoBK06Vg < i2) {
            m8368quickSortoBK06Vg(iArr, iM8364partitionoBK06Vg, i2);
        }
    }

    /* JADX INFO: renamed from: partition--nroSd4, reason: not valid java name */
    private static final int m8361partitionnroSd4(long[] jArr, int i, int i2) {
        long jM8140getsVKNKU = ULongArray.m8140getsVKNKU(jArr, (i + i2) / 2);
        while (i <= i2) {
            while (Long.compare(ULongArray.m8140getsVKNKU(jArr, i) ^ Long.MIN_VALUE, jM8140getsVKNKU ^ Long.MIN_VALUE) < 0) {
                i++;
            }
            while (Long.compare(ULongArray.m8140getsVKNKU(jArr, i2) ^ Long.MIN_VALUE, jM8140getsVKNKU ^ Long.MIN_VALUE) > 0) {
                i2--;
            }
            if (i <= i2) {
                long jM8140getsVKNKU2 = ULongArray.m8140getsVKNKU(jArr, i);
                ULongArray.m8145setk8EXiF4(jArr, i, ULongArray.m8140getsVKNKU(jArr, i2));
                ULongArray.m8145setk8EXiF4(jArr, i2, jM8140getsVKNKU2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort--nroSd4, reason: not valid java name */
    private static final void m8365quickSortnroSd4(long[] jArr, int i, int i2) {
        int iM8361partitionnroSd4 = m8361partitionnroSd4(jArr, i, i2);
        int i3 = iM8361partitionnroSd4 - 1;
        if (i < i3) {
            m8365quickSortnroSd4(jArr, i, i3);
        }
        if (iM8361partitionnroSd4 < i2) {
            m8365quickSortnroSd4(jArr, iM8361partitionnroSd4, i2);
        }
    }

    /* JADX INFO: renamed from: sortArray-4UcCI2c, reason: not valid java name */
    public static final void m8370sortArray4UcCI2c(byte[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m8366quickSort4UcCI2c(array, i, i2 - 1);
    }

    /* JADX INFO: renamed from: sortArray-Aa5vz7o, reason: not valid java name */
    public static final void m8371sortArrayAa5vz7o(short[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m8367quickSortAa5vz7o(array, i, i2 - 1);
    }

    /* JADX INFO: renamed from: sortArray-oBK06Vg, reason: not valid java name */
    public static final void m8372sortArrayoBK06Vg(int[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m8368quickSortoBK06Vg(array, i, i2 - 1);
    }

    /* JADX INFO: renamed from: sortArray--nroSd4, reason: not valid java name */
    public static final void m8369sortArraynroSd4(long[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m8365quickSortnroSd4(array, i, i2 - 1);
    }
}
