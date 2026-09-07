package io.ktor.utils.io.core;

import com.safedk.android.analytics.brandsafety.FileUploadManager;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.MalformedUTF8InputException;
import io.ktor.utils.io.core.internal.UTF8Kt;
import io.ktor.utils.io.core.internal.UnsafeKt;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Input.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0001\u001a$\u0010\u0007\u001a\u00020\u0004*\u00020\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\tH\u0080\bø\u0001\u0000\u001a\n\u0010\u000b\u001a\u00020\f*\u00020\u0002\u001a\u0014\u0010\r\u001a\u00020\f*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0006H\u0002\u001a$\u0010\u000f\u001a\u00020\u0004*\u00020\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\tH\u0086\bø\u0001\u0000\u001a.\u0010\u0012\u001a\u00020\u0004*\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00060\tH\u0080\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0014"}, d2 = {FileUploadManager.m, "", "Lio/ktor/utils/io/core/Input;", "discardExact", "", "n", "", "forEach", "block", "Lkotlin/Function1;", "", "peekCharUtf8", "", "peekCharUtf8Impl", "first", "takeWhile", "Lio/ktor/utils/io/core/Buffer;", "", "takeWhileSize", "initialSize", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class InputKt {
    public static final long discard(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return input.discard(Long.MAX_VALUE);
    }

    public static final void discardExact(Input input, long j) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        long jDiscard = input.discard(j);
        if (jDiscard != j) {
            throw new IllegalStateException("Only " + jDiscard + " bytes were discarded of " + j + " requested");
        }
    }

    public static final void discardExact(Input input, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        discardExact(input, i);
    }

    public static final void takeWhile(Input input, Function1<? super Buffer, Boolean> block) throws Throwable {
        boolean z;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ChunkBuffer chunkBufferPrepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, 1);
        if (chunkBufferPrepareReadFirstHead == null) {
            return;
        }
        while (true) {
            try {
                if (!block.invoke(chunkBufferPrepareReadFirstHead).booleanValue()) {
                    z = true;
                    break;
                }
                z = false;
                try {
                    ChunkBuffer chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadNextHead(input, chunkBufferPrepareReadFirstHead);
                    if (chunkBufferPrepareReadNextHead == null) {
                        break;
                    } else {
                        chunkBufferPrepareReadFirstHead = chunkBufferPrepareReadNextHead;
                    }
                } catch (Throwable th) {
                    th = th;
                    InlineMarker.finallyStart(1);
                    if (z) {
                        UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
                    }
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                z = true;
            }
        }
        InlineMarker.finallyStart(1);
        if (z) {
            UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
        }
        InlineMarker.finallyEnd(1);
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0094  */
    public static /* synthetic */ void takeWhileSize$default(Input input, int i, Function1 block, int i2, Object obj) throws Throwable {
        boolean z;
        ChunkBuffer chunkBufferPrepareReadNextHead;
        if ((i2 & 1) != 0) {
            i = 1;
        }
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ChunkBuffer chunkBufferPrepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, i);
        if (chunkBufferPrepareReadFirstHead == null) {
            return;
        }
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareReadFirstHead;
                int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
                if (writePosition >= i) {
                    try {
                        i = ((Number) block.invoke(chunkBufferPrepareReadFirstHead)).intValue();
                        InlineMarker.finallyStart(1);
                        ChunkBuffer chunkBuffer2 = chunkBufferPrepareReadFirstHead;
                        writePosition = chunkBuffer2.getWritePosition() - chunkBuffer2.getReadPosition();
                        InlineMarker.finallyEnd(1);
                    } catch (Throwable th) {
                        InlineMarker.finallyStart(1);
                        ChunkBuffer chunkBuffer3 = chunkBufferPrepareReadFirstHead;
                        chunkBuffer3.getWritePosition();
                        chunkBuffer3.getReadPosition();
                        InlineMarker.finallyEnd(1);
                        throw th;
                    }
                }
                z = false;
                if (writePosition == 0) {
                    try {
                        chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadNextHead(input, chunkBufferPrepareReadFirstHead);
                    } catch (Throwable th2) {
                        th = th2;
                        InlineMarker.finallyStart(1);
                        if (z) {
                            UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
                        }
                        InlineMarker.finallyEnd(1);
                        throw th;
                    }
                } else if (writePosition >= i) {
                    ChunkBuffer chunkBuffer4 = chunkBufferPrepareReadFirstHead;
                    if (chunkBuffer4.getCapacity() - chunkBuffer4.getLimit() < 8) {
                        UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
                        chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadFirstHead(input, i);
                    } else {
                        chunkBufferPrepareReadNextHead = chunkBufferPrepareReadFirstHead;
                    }
                } else {
                    UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
                    chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadFirstHead(input, i);
                }
                if (chunkBufferPrepareReadNextHead == null) {
                    break;
                }
                if (i <= 0) {
                    z = true;
                    chunkBufferPrepareReadFirstHead = chunkBufferPrepareReadNextHead;
                    break;
                }
                chunkBufferPrepareReadFirstHead = chunkBufferPrepareReadNextHead;
            } catch (Throwable th3) {
                th = th3;
                z = true;
                InlineMarker.finallyStart(1);
                if (z) {
                    UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
                }
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyStart(1);
        if (z) {
            UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
        }
        InlineMarker.finallyEnd(1);
    }

    public static final void takeWhileSize(Input input, int i, Function1<? super Buffer, Integer> block) throws Throwable {
        boolean z;
        ChunkBuffer chunkBufferPrepareReadNextHead;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ChunkBuffer chunkBufferPrepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, i);
        if (chunkBufferPrepareReadFirstHead == null) {
            return;
        }
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareReadFirstHead;
                int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
                if (writePosition >= i) {
                    try {
                        i = block.invoke(chunkBufferPrepareReadFirstHead).intValue();
                        InlineMarker.finallyStart(1);
                        ChunkBuffer chunkBuffer2 = chunkBufferPrepareReadFirstHead;
                        writePosition = chunkBuffer2.getWritePosition() - chunkBuffer2.getReadPosition();
                        InlineMarker.finallyEnd(1);
                    } catch (Throwable th) {
                        InlineMarker.finallyStart(1);
                        ChunkBuffer chunkBuffer3 = chunkBufferPrepareReadFirstHead;
                        chunkBuffer3.getWritePosition();
                        chunkBuffer3.getReadPosition();
                        InlineMarker.finallyEnd(1);
                        throw th;
                    }
                }
                z = false;
                if (writePosition == 0) {
                    try {
                        chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadNextHead(input, chunkBufferPrepareReadFirstHead);
                    } catch (Throwable th2) {
                        th = th2;
                        InlineMarker.finallyStart(1);
                        if (z) {
                            UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
                        }
                        InlineMarker.finallyEnd(1);
                        throw th;
                    }
                } else if (writePosition >= i) {
                    ChunkBuffer chunkBuffer4 = chunkBufferPrepareReadFirstHead;
                    if (chunkBuffer4.getCapacity() - chunkBuffer4.getLimit() < 8) {
                        UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
                        chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadFirstHead(input, i);
                    } else {
                        chunkBufferPrepareReadNextHead = chunkBufferPrepareReadFirstHead;
                    }
                } else {
                    UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
                    chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadFirstHead(input, i);
                }
                if (chunkBufferPrepareReadNextHead == null) {
                    break;
                }
                if (i <= 0) {
                    z = true;
                    chunkBufferPrepareReadFirstHead = chunkBufferPrepareReadNextHead;
                    break;
                }
                chunkBufferPrepareReadFirstHead = chunkBufferPrepareReadNextHead;
            } catch (Throwable th3) {
                th = th3;
                z = true;
            }
        }
        InlineMarker.finallyStart(1);
        if (z) {
            UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
        }
        InlineMarker.finallyEnd(1);
    }

    public static final char peekCharUtf8(Input input) throws EOFException {
        Intrinsics.checkNotNullParameter(input, "<this>");
        int iTryPeek = input.tryPeek();
        if ((iTryPeek & 128) == 0) {
            return (char) iTryPeek;
        }
        if (iTryPeek == -1) {
            throw new EOFException("Failed to peek a char: end of input");
        }
        return peekCharUtf8Impl(input, iTryPeek);
    }

    private static final char peekCharUtf8Impl(Input input, int i) throws Throwable {
        boolean z;
        int i2;
        ChunkBuffer chunkBufferPrepareReadNextHead;
        boolean z2;
        boolean z3;
        int iByteCountUtf8 = UTF8Kt.byteCountUtf8(i);
        ChunkBuffer chunkBufferPrepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, iByteCountUtf8);
        char cHighSurrogate = '?';
        if (chunkBufferPrepareReadFirstHead == null) {
            z3 = false;
        } else {
            boolean z4 = false;
            while (true) {
                try {
                    ChunkBuffer chunkBuffer = chunkBufferPrepareReadFirstHead;
                    int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
                    if (writePosition >= iByteCountUtf8) {
                        try {
                            ChunkBuffer chunkBuffer2 = chunkBufferPrepareReadFirstHead;
                            ByteBuffer memory = chunkBuffer2.getMemory();
                            int readPosition = chunkBuffer2.getReadPosition();
                            int writePosition2 = chunkBuffer2.getWritePosition();
                            int i3 = readPosition;
                            int i4 = 0;
                            int i5 = 0;
                            int i6 = 0;
                            while (true) {
                                if (i3 < writePosition2) {
                                    byte b = memory.get(i3);
                                    int i7 = b & 255;
                                    i2 = -1;
                                    if ((b & 128) != 0) {
                                        if (i4 == 0) {
                                            int i8 = 128;
                                            for (int i9 = 1; i9 < 7 && (i7 & i8) != 0; i9++) {
                                                i7 &= ~i8;
                                                i8 >>= 1;
                                                i4++;
                                            }
                                            int i10 = i4 - 1;
                                            if (i4 > writePosition2 - i3) {
                                                chunkBuffer2.discardExact(i3 - readPosition);
                                                i2 = i4;
                                                break;
                                            }
                                            i6 = i4;
                                            i5 = i7;
                                            i4 = i10;
                                        } else {
                                            int i11 = (i5 << 6) | (b & 127);
                                            i4--;
                                            if (i4 != 0) {
                                                i5 = i11;
                                            } else if (UTF8Kt.isBmpCodePoint(i11)) {
                                                cHighSurrogate = (char) i11;
                                                chunkBuffer2.discardExact(((i3 - readPosition) - i6) + 1);
                                            } else {
                                                if (!UTF8Kt.isValidCodePoint(i11)) {
                                                    UTF8Kt.malformedCodePoint(i11);
                                                    throw new KotlinNothingValueException();
                                                }
                                                cHighSurrogate = (char) UTF8Kt.highSurrogate(i11);
                                                chunkBuffer2.discardExact(((i3 - readPosition) - i6) + 1);
                                            }
                                        }
                                        i3++;
                                    } else {
                                        if (i4 != 0) {
                                            UTF8Kt.malformedByteCount(i4);
                                            throw new KotlinNothingValueException();
                                        }
                                        cHighSurrogate = (char) i7;
                                        chunkBuffer2.discardExact(i3 - readPosition);
                                    }
                                    z4 = true;
                                    break;
                                }
                                chunkBuffer2.discardExact(writePosition2 - readPosition);
                                i2 = 0;
                                break;
                            }
                            ChunkBuffer chunkBuffer3 = chunkBufferPrepareReadFirstHead;
                            writePosition = chunkBuffer3.getWritePosition() - chunkBuffer3.getReadPosition();
                            iByteCountUtf8 = i2;
                        } catch (Throwable th) {
                            ChunkBuffer chunkBuffer4 = chunkBufferPrepareReadFirstHead;
                            chunkBuffer4.getWritePosition();
                            chunkBuffer4.getReadPosition();
                            throw th;
                        }
                    }
                    if (writePosition == 0) {
                        try {
                            chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadNextHead(input, chunkBufferPrepareReadFirstHead);
                        } catch (Throwable th2) {
                            th = th2;
                            z = false;
                            if (z) {
                                UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
                            }
                            throw th;
                        }
                    } else if (writePosition >= iByteCountUtf8) {
                        ChunkBuffer chunkBuffer5 = chunkBufferPrepareReadFirstHead;
                        if (chunkBuffer5.getCapacity() - chunkBuffer5.getLimit() < 8) {
                            UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
                            chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadFirstHead(input, iByteCountUtf8);
                        } else {
                            chunkBufferPrepareReadNextHead = chunkBufferPrepareReadFirstHead;
                        }
                    } else {
                        UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
                        chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadFirstHead(input, iByteCountUtf8);
                    }
                    if (chunkBufferPrepareReadNextHead == null) {
                        z2 = false;
                        break;
                    }
                    chunkBufferPrepareReadFirstHead = chunkBufferPrepareReadNextHead;
                    if (iByteCountUtf8 <= 0) {
                        z2 = true;
                        break;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    z = true;
                }
            }
            if (z2) {
                UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
            }
            z3 = z4;
        }
        if (z3) {
            return cHighSurrogate;
        }
        throw new MalformedUTF8InputException("No UTF-8 character found");
    }

    public static final void forEach(Input input, Function1<? super Byte, Unit> block) throws Throwable {
        boolean z;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ChunkBuffer chunkBufferPrepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, 1);
        if (chunkBufferPrepareReadFirstHead == null) {
            return;
        }
        do {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareReadFirstHead;
                ByteBuffer memory = chunkBuffer.getMemory();
                int readPosition = chunkBuffer.getReadPosition();
                int writePosition = chunkBuffer.getWritePosition();
                for (int i = readPosition; i < writePosition; i++) {
                    block.invoke(Byte.valueOf(memory.get(i)));
                }
                chunkBuffer.discardExact(writePosition - readPosition);
                try {
                    chunkBufferPrepareReadFirstHead = UnsafeKt.prepareReadNextHead(input, chunkBufferPrepareReadFirstHead);
                } catch (Throwable th) {
                    th = th;
                    z = false;
                    InlineMarker.finallyStart(1);
                    if (z) {
                        UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
                    }
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                z = true;
            }
        } while (chunkBufferPrepareReadFirstHead != null);
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
    }
}
