package io.ktor.utils.io.internal;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.ktor.utils.io.ByteChannelSequentialBase;
import io.ktor.utils.io.ByteWriteChannelKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: SequentialCopyTo.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a%\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a%\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"copyToSequentialImpl", "", "Lio/ktor/utils/io/ByteChannelSequentialBase;", "dst", "limit", "(Lio/ktor/utils/io/ByteChannelSequentialBase;Lio/ktor/utils/io/ByteChannelSequentialBase;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyToTail", "joinToImpl", "", "closeOnEnd", "", "(Lio/ktor/utils/io/ByteChannelSequentialBase;Lio/ktor/utils/io/ByteChannelSequentialBase;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SequentialCopyToKt {

    /* JADX INFO: renamed from: io.ktor.utils.io.internal.SequentialCopyToKt$copyToSequentialImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: SequentialCopyTo.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.internal.SequentialCopyToKt", f = "SequentialCopyTo.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {26, 31, 39}, m = "copyToSequentialImpl", n = {"$this$copyToSequentialImpl", "dst", "limit", "remainingLimit", "$this$copyToSequentialImpl", "dst", "limit", "remainingLimit", "$this$copyToSequentialImpl", "dst", "limit", "remainingLimit", "transferred"}, s = {"L$0", "L$1", "J$0", "J$1", "L$0", "L$1", "J$0", "J$1", "L$0", "L$1", "J$0", "J$1", "J$2"})
    static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        long J$1;
        long J$2;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SequentialCopyToKt.copyToSequentialImpl(null, null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.internal.SequentialCopyToKt$copyToTail$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SequentialCopyTo.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.internal.SequentialCopyToKt", f = "SequentialCopyTo.kt", i = {0, 0, 1, 1}, l = {60, 66}, m = "copyToTail", n = {"dst", "lastPiece", "lastPiece", DownloadCommon.DOWNLOAD_REPORT_RETRY_COUNT}, s = {"L$0", "L$1", "L$0", "I$0"})
    static final class C48481 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C48481(Continuation<? super C48481> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SequentialCopyToKt.copyToTail(null, null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.internal.SequentialCopyToKt$joinToImpl$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SequentialCopyTo.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.internal.SequentialCopyToKt", f = "SequentialCopyTo.kt", i = {0, 0}, l = {7}, m = "joinToImpl", n = {"dst", "closeOnEnd"}, s = {"L$0", "Z$0"})
    static final class C48491 extends ContinuationImpl {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C48491(Continuation<? super C48491> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SequentialCopyToKt.joinToImpl(null, null, false, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object joinToImpl(ByteChannelSequentialBase byteChannelSequentialBase, ByteChannelSequentialBase byteChannelSequentialBase2, boolean z, Continuation<? super Unit> continuation) throws Throwable {
        C48491 c48491;
        if (continuation instanceof C48491) {
            c48491 = (C48491) continuation;
            if ((c48491.label & Integer.MIN_VALUE) != 0) {
                c48491.label -= Integer.MIN_VALUE;
            } else {
                c48491 = new C48491(continuation);
            }
        } else {
            c48491 = new C48491(continuation);
        }
        Object obj = c48491.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c48491.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c48491.L$0 = byteChannelSequentialBase2;
            c48491.Z$0 = z;
            c48491.label = 1;
            if (copyToSequentialImpl(byteChannelSequentialBase, byteChannelSequentialBase2, Long.MAX_VALUE, c48491) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z = c48491.Z$0;
            byteChannelSequentialBase2 = (ByteChannelSequentialBase) c48491.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (z) {
            ByteWriteChannelKt.close(byteChannelSequentialBase2);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0090  */
    /* JADX WARN: Code duplicated, block: B:29:0x00a0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:36:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:38:0x00cb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:43:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:44:0x00db  */
    /* JADX WARN: Code duplicated, block: B:46:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:48:0x00f3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:52:0x0100  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00d9 -> B:50:0x00fb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00df -> B:49:0x00f4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00f1 -> B:49:0x00f4). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object copyToSequentialImpl(io.ktor.utils.io.ByteChannelSequentialBase r18, io.ktor.utils.io.ByteChannelSequentialBase r19, long r20, kotlin.coroutines.Continuation<? super java.lang.Long> r22) {
        /*
            Method dump skipped, instruction units count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.internal.SequentialCopyToKt.copyToSequentialImpl(io.ktor.utils.io.ByteChannelSequentialBase, io.ktor.utils.io.ByteChannelSequentialBase, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v9, types: [io.ktor.utils.io.core.internal.ChunkBuffer] */
    public static final Object copyToTail(ByteChannelSequentialBase byteChannelSequentialBase, ByteChannelSequentialBase byteChannelSequentialBase2, long j, Continuation<? super Long> continuation) throws Throwable {
        C48481 c48481;
        ChunkBuffer chunkBufferBorrow;
        Object available;
        ByteChannelSequentialBase byteChannelSequentialBase3;
        int iIntValue;
        if (continuation instanceof C48481) {
            c48481 = (C48481) continuation;
            if ((c48481.label & Integer.MIN_VALUE) != 0) {
                c48481.label -= Integer.MIN_VALUE;
            } else {
                c48481 = new C48481(continuation);
            }
        } else {
            c48481 = new C48481(continuation);
        }
        Object obj = c48481.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c48481.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                chunkBufferBorrow = ChunkBuffer.INSTANCE.getPool().borrow();
                try {
                    chunkBufferBorrow.resetForWrite((int) RangesKt.coerceAtMost(j, chunkBufferBorrow.getCapacity()));
                    c48481.L$0 = byteChannelSequentialBase2;
                    c48481.L$1 = chunkBufferBorrow;
                    c48481.label = 1;
                    available = byteChannelSequentialBase.readAvailable(chunkBufferBorrow, c48481);
                    byteChannelSequentialBase3 = byteChannelSequentialBase2;
                    if (available == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (Throwable th) {
                    th = th;
                    byteChannelSequentialBase2 = chunkBufferBorrow;
                    byteChannelSequentialBase2.release(ChunkBuffer.INSTANCE.getPool());
                    throw th;
                }
            } else {
                if (i == 1) {
                    ChunkBuffer chunkBuffer = (ChunkBuffer) c48481.L$1;
                    ByteChannelSequentialBase byteChannelSequentialBase4 = (ByteChannelSequentialBase) c48481.L$0;
                    ResultKt.throwOnFailure(obj);
                    byteChannelSequentialBase3 = byteChannelSequentialBase4;
                    available = obj;
                    chunkBufferBorrow = chunkBuffer;
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    iIntValue = c48481.I$0;
                    ChunkBuffer chunkBuffer2 = (ChunkBuffer) c48481.L$0;
                    ResultKt.throwOnFailure(obj);
                    byteChannelSequentialBase2 = chunkBuffer2;
                }
                Long lBoxLong = Boxing.boxLong(iIntValue);
                byteChannelSequentialBase2.release(ChunkBuffer.INSTANCE.getPool());
                return lBoxLong;
            }
            iIntValue = ((Number) available).intValue();
            if (iIntValue == -1) {
                chunkBufferBorrow.release(ChunkBuffer.INSTANCE.getPool());
                Long lBoxLong2 = Boxing.boxLong(0L);
                chunkBufferBorrow.release(ChunkBuffer.INSTANCE.getPool());
                return lBoxLong2;
            }
            c48481.L$0 = chunkBufferBorrow;
            c48481.L$1 = null;
            c48481.I$0 = iIntValue;
            c48481.label = 2;
            if (byteChannelSequentialBase3.writeFully(chunkBufferBorrow, c48481) == coroutine_suspended) {
                return coroutine_suspended;
            }
            byteChannelSequentialBase2 = chunkBufferBorrow;
            Long lBoxLong3 = Boxing.boxLong(iIntValue);
            byteChannelSequentialBase2.release(ChunkBuffer.INSTANCE.getPool());
            return lBoxLong3;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
