package io.ktor.utils.io.bits;

import io.ktor.utils.io.core.internal.NumbersKt;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MemoryPrimitives.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\r\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0007H\u0086\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\b\u001a\"\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a\"\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0007H\u0086\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\r\u001a\"\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011\u001a\"\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0007H\u0086\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0012\u001a*\u0010\u0013\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0001H\u0086\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a*\u0010\u0013\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0001H\u0086\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0018\u001a*\u0010\u0019\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\nH\u0086\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001b\u001a*\u0010\u0019\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\nH\u0086\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001c\u001a*\u0010\u001d\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000fH\u0086\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u001a*\u0010\u001d\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000fH\u0086\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010 \u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006!"}, d2 = {"loadUIntAt", "Lkotlin/UInt;", "Lio/ktor/utils/io/bits/Memory;", "offset", "", "loadUIntAt-eY85DW0", "(Ljava/nio/ByteBuffer;I)I", "", "(Ljava/nio/ByteBuffer;J)I", "loadULongAt", "Lkotlin/ULong;", "loadULongAt-eY85DW0", "(Ljava/nio/ByteBuffer;I)J", "(Ljava/nio/ByteBuffer;J)J", "loadUShortAt", "Lkotlin/UShort;", "loadUShortAt-eY85DW0", "(Ljava/nio/ByteBuffer;I)S", "(Ljava/nio/ByteBuffer;J)S", "storeUIntAt", "", "value", "storeUIntAt-c9EmHqw", "(Ljava/nio/ByteBuffer;II)V", "(Ljava/nio/ByteBuffer;JI)V", "storeULongAt", "storeULongAt-zwzI6Wg", "(Ljava/nio/ByteBuffer;IJ)V", "(Ljava/nio/ByteBuffer;JJ)V", "storeUShortAt", "storeUShortAt-4ET0KQI", "(Ljava/nio/ByteBuffer;IS)V", "(Ljava/nio/ByteBuffer;JS)V", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MemoryPrimitivesKt {
    /* JADX INFO: renamed from: loadUShortAt-eY85DW0, reason: not valid java name */
    public static final short m7685loadUShortAteY85DW0(ByteBuffer loadUShortAt, int i) {
        Intrinsics.checkNotNullParameter(loadUShortAt, "$this$loadUShortAt");
        return UShort.m8187constructorimpl(loadUShortAt.getShort(i));
    }

    /* JADX INFO: renamed from: loadUShortAt-eY85DW0, reason: not valid java name */
    public static final short m7686loadUShortAteY85DW0(ByteBuffer loadUShortAt, long j) {
        Intrinsics.checkNotNullParameter(loadUShortAt, "$this$loadUShortAt");
        if (j < 2147483647L) {
            return UShort.m8187constructorimpl(loadUShortAt.getShort((int) j));
        }
        NumbersKt.failLongToIntConversion(j, "offset");
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: storeUShortAt-4ET0KQI, reason: not valid java name */
    public static final void m7691storeUShortAt4ET0KQI(ByteBuffer storeUShortAt, int i, short s) {
        Intrinsics.checkNotNullParameter(storeUShortAt, "$this$storeUShortAt");
        storeUShortAt.putShort(i, s);
    }

    /* JADX INFO: renamed from: storeUShortAt-4ET0KQI, reason: not valid java name */
    public static final void m7692storeUShortAt4ET0KQI(ByteBuffer storeUShortAt, long j, short s) {
        Intrinsics.checkNotNullParameter(storeUShortAt, "$this$storeUShortAt");
        if (j >= 2147483647L) {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
        storeUShortAt.putShort((int) j, s);
    }

    /* JADX INFO: renamed from: loadUIntAt-eY85DW0, reason: not valid java name */
    public static final int m7681loadUIntAteY85DW0(ByteBuffer loadUIntAt, int i) {
        Intrinsics.checkNotNullParameter(loadUIntAt, "$this$loadUIntAt");
        return UInt.m8001constructorimpl(loadUIntAt.getInt(i));
    }

    /* JADX INFO: renamed from: loadUIntAt-eY85DW0, reason: not valid java name */
    public static final int m7682loadUIntAteY85DW0(ByteBuffer loadUIntAt, long j) {
        Intrinsics.checkNotNullParameter(loadUIntAt, "$this$loadUIntAt");
        if (j < 2147483647L) {
            return UInt.m8001constructorimpl(loadUIntAt.getInt((int) j));
        }
        NumbersKt.failLongToIntConversion(j, "offset");
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: storeUIntAt-c9EmHqw, reason: not valid java name */
    public static final void m7687storeUIntAtc9EmHqw(ByteBuffer storeUIntAt, int i, int i2) {
        Intrinsics.checkNotNullParameter(storeUIntAt, "$this$storeUIntAt");
        storeUIntAt.putInt(i, i2);
    }

    /* JADX INFO: renamed from: storeUIntAt-c9EmHqw, reason: not valid java name */
    public static final void m7688storeUIntAtc9EmHqw(ByteBuffer storeUIntAt, long j, int i) {
        Intrinsics.checkNotNullParameter(storeUIntAt, "$this$storeUIntAt");
        if (j >= 2147483647L) {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
        storeUIntAt.putInt((int) j, i);
    }

    /* JADX INFO: renamed from: loadULongAt-eY85DW0, reason: not valid java name */
    public static final long m7683loadULongAteY85DW0(ByteBuffer loadULongAt, int i) {
        Intrinsics.checkNotNullParameter(loadULongAt, "$this$loadULongAt");
        return ULong.m8080constructorimpl(loadULongAt.getLong(i));
    }

    /* JADX INFO: renamed from: loadULongAt-eY85DW0, reason: not valid java name */
    public static final long m7684loadULongAteY85DW0(ByteBuffer loadULongAt, long j) {
        Intrinsics.checkNotNullParameter(loadULongAt, "$this$loadULongAt");
        if (j < 2147483647L) {
            return ULong.m8080constructorimpl(loadULongAt.getLong((int) j));
        }
        NumbersKt.failLongToIntConversion(j, "offset");
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: storeULongAt-zwzI6Wg, reason: not valid java name */
    public static final void m7689storeULongAtzwzI6Wg(ByteBuffer storeULongAt, int i, long j) {
        Intrinsics.checkNotNullParameter(storeULongAt, "$this$storeULongAt");
        storeULongAt.putLong(i, j);
    }

    /* JADX INFO: renamed from: storeULongAt-zwzI6Wg, reason: not valid java name */
    public static final void m7690storeULongAtzwzI6Wg(ByteBuffer storeULongAt, long j, long j2) {
        Intrinsics.checkNotNullParameter(storeULongAt, "$this$storeULongAt");
        if (j >= 2147483647L) {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
        storeULongAt.putLong((int) j, j2);
    }
}
