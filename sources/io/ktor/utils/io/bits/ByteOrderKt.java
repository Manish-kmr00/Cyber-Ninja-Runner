package io.ktor.utils.io.bits;

import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;

/* JADX INFO: compiled from: ByteOrder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0013\u001a\u00020\u0014*\u00020\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0017\u0010\u0013\u001a\u00020\u0017*\u00020\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0017\u0010\u0013\u001a\u00020\u001a*\u00020\u001aø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001c\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0016\u0010\u0005\u001a\u00020\u0006*\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\t\"\u0016\u0010\n\u001a\u00020\u0002*\u00020\u00068Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0016\u0010\r\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0004\"\u0016\u0010\u000f\u001a\u00020\u0006*\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\t\"\u0016\u0010\u0011\u001a\u00020\u0002*\u00020\u00068Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"highByte", "", "", "getHighByte", "(S)B", "highInt", "", "", "getHighInt", "(J)I", "highShort", "getHighShort", "(I)S", "lowByte", "getLowByte", "lowInt", "getLowInt", "lowShort", "getLowShort", "reverseByteOrder", "Lkotlin/UInt;", "reverseByteOrder-WZ4Q5Ns", "(I)I", "Lkotlin/ULong;", "reverseByteOrder-VKZWuLQ", "(J)J", "Lkotlin/UShort;", "reverseByteOrder-xj2QHRw", "(S)S", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ByteOrderKt {
    public static final byte getHighByte(short s) {
        return (byte) (s >>> 8);
    }

    public static final int getHighInt(long j) {
        return (int) (j >>> 32);
    }

    public static final short getHighShort(int i) {
        return (short) (i >>> 16);
    }

    public static final byte getLowByte(short s) {
        return (byte) (s & 255);
    }

    public static final int getLowInt(long j) {
        return (int) (j & 4294967295L);
    }

    public static final short getLowShort(int i) {
        return (short) (i & 65535);
    }

    /* JADX INFO: renamed from: reverseByteOrder-xj2QHRw, reason: not valid java name */
    public static final short m7627reverseByteOrderxj2QHRw(short s) {
        return UShort.m8187constructorimpl(Short.reverseBytes(s));
    }

    /* JADX INFO: renamed from: reverseByteOrder-WZ4Q5Ns, reason: not valid java name */
    public static final int m7626reverseByteOrderWZ4Q5Ns(int i) {
        return UInt.m8001constructorimpl(Integer.reverseBytes(i));
    }

    /* JADX INFO: renamed from: reverseByteOrder-VKZWuLQ, reason: not valid java name */
    public static final long m7625reverseByteOrderVKZWuLQ(long j) {
        return ULong.m8080constructorimpl(Long.reverseBytes(j));
    }
}
