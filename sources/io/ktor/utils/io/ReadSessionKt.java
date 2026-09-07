package io.ktor.utils.io;

import com.vungle.ads.internal.protos.Sdk;
import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ReadSession.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0081@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001ao\u0010\b\u001a\u00020\u0006*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00062K\u0010\n\u001aG\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00060\u000bH\u0086Hø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a\u000e\u0010\u0014\u001a\u0004\u0018\u00010\u0015*\u00020\u0002H\u0002\u001a\u001f\u0010\u0016\u001a\u0004\u0018\u00010\u0004*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0081@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a\u001d\u0010\u0018\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a\u001f\u0010\u001a\u001a\u0004\u0018\u00010\u0004*\u00020\u00152\u0006\u0010\t\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"completeReadingFromBuffer", "", "Lio/ktor/utils/io/ByteReadChannel;", "buffer", "Lio/ktor/utils/io/core/Buffer;", "bytesRead", "", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/core/Buffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "read", "desiredSize", "block", "Lkotlin/Function3;", "Lio/ktor/utils/io/bits/Memory;", "Lkotlin/ParameterName;", "name", "source", "", "start", "endExclusive", "(Lio/ktor/utils/io/ByteReadChannel;ILkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readSessionFor", "Lio/ktor/utils/io/SuspendableReadSession;", "requestBuffer", "(Lio/ktor/utils/io/ByteReadChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestBufferFallback", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "requestBufferSuspend", "(Lio/ktor/utils/io/SuspendableReadSession;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ReadSessionKt {

    /* JADX INFO: renamed from: io.ktor.utils.io.ReadSessionKt$read$1, reason: invalid class name */
    /* JADX INFO: compiled from: ReadSession.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
    @DebugMetadata(c = "io.ktor.utils.io.ReadSessionKt", f = "ReadSession.kt", i = {0, 0, 1, 1, 1, 2}, l = {24, 28, 31}, m = "read", n = {"$this$read", "block", "$this$read", "buffer", "bytesRead", "cause"}, s = {"L$0", "L$1", "L$0", "L$1", "I$0", "L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
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
            return ReadSessionKt.read(null, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ReadSessionKt$requestBufferFallback$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReadSession.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ReadSessionKt", f = "ReadSession.kt", i = {0}, l = {Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE}, m = "requestBufferFallback", n = {"chunk"}, s = {"L$0"})
    static final class C48431 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C48431(Continuation<? super C48431> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReadSessionKt.requestBufferFallback(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ReadSessionKt$requestBufferSuspend$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReadSession.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ReadSessionKt", f = "ReadSession.kt", i = {0}, l = {Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE}, m = "requestBufferSuspend", n = {"$this$requestBufferSuspend"}, s = {"L$0"})
    static final class C48441 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C48441(Continuation<? super C48441> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReadSessionKt.requestBufferSuspend(null, 0, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00c4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object read(ByteReadChannel byteReadChannel, int i, Function3<? super Memory, ? super Long, ? super Long, Integer> function3, Continuation<? super Integer> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Buffer empty;
        ByteReadChannel byteReadChannel2;
        Throwable th;
        int i2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objRequestBuffer = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = anonymousClass1.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(objRequestBuffer);
                anonymousClass1.L$0 = byteReadChannel;
                anonymousClass1.L$1 = function3;
                anonymousClass1.label = 1;
                objRequestBuffer = requestBuffer(byteReadChannel, i, anonymousClass1);
                if (objRequestBuffer == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Throwable th2 = (Throwable) anonymousClass1.L$0;
                        ResultKt.throwOnFailure(objRequestBuffer);
                        throw th2;
                    }
                    i2 = anonymousClass1.I$0;
                    empty = (Buffer) anonymousClass1.L$1;
                    byteReadChannel2 = (ByteReadChannel) anonymousClass1.L$0;
                    try {
                        ResultKt.throwOnFailure(objRequestBuffer);
                        return Boxing.boxInt(i2);
                    } catch (Throwable th3) {
                        th = th3;
                        anonymousClass1.L$0 = th;
                        anonymousClass1.L$1 = null;
                        anonymousClass1.label = 3;
                        if (completeReadingFromBuffer(byteReadChannel2, empty, 0, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        throw th;
                    }
                }
                function3 = (Function3) anonymousClass1.L$1;
                byteReadChannel = (ByteReadChannel) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objRequestBuffer);
            }
            int iIntValue = function3.invoke(Memory.m7628boximpl(empty.getMemory()), Boxing.boxLong(empty.getReadPosition()), Boxing.boxLong(empty.getWritePosition())).intValue();
            anonymousClass1.L$0 = byteReadChannel;
            anonymousClass1.L$1 = empty;
            anonymousClass1.I$0 = iIntValue;
            anonymousClass1.label = 2;
            if (completeReadingFromBuffer(byteReadChannel, empty, iIntValue, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            byteReadChannel2 = byteReadChannel;
            i2 = iIntValue;
            return Boxing.boxInt(i2);
        } catch (Throwable th4) {
            byteReadChannel2 = byteReadChannel;
            th = th4;
            anonymousClass1.L$0 = th;
            anonymousClass1.L$1 = null;
            anonymousClass1.label = 3;
            if (completeReadingFromBuffer(byteReadChannel2, empty, 0, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            throw th;
        }
        Buffer buffer = (Buffer) objRequestBuffer;
        empty = buffer == null ? Buffer.INSTANCE.getEmpty() : buffer;
    }

    private static final Object read$$forInline(ByteReadChannel byteReadChannel, int i, Function3<? super Memory, ? super Long, ? super Long, Integer> function3, Continuation<? super Integer> continuation) {
        InlineMarker.mark(0);
        Object objRequestBuffer = requestBuffer(byteReadChannel, i, continuation);
        InlineMarker.mark(1);
        Buffer empty = (Buffer) objRequestBuffer;
        if (empty == null) {
            empty = Buffer.INSTANCE.getEmpty();
        }
        try {
            int iIntValue = function3.invoke(Memory.m7628boximpl(empty.getMemory()), Long.valueOf(empty.getReadPosition()), Long.valueOf(empty.getWritePosition())).intValue();
            InlineMarker.mark(0);
            completeReadingFromBuffer(byteReadChannel, empty, iIntValue, continuation);
            return Integer.valueOf(iIntValue);
        } finally {
            InlineMarker.mark(0);
            completeReadingFromBuffer(byteReadChannel, empty, 0, continuation);
            InlineMarker.mark(1);
        }
    }

    public static /* synthetic */ Object read$default(ByteReadChannel byteReadChannel, int i, Function3 function3, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        InlineMarker.mark(0);
        Object objRequestBuffer = requestBuffer(byteReadChannel, i, continuation);
        InlineMarker.mark(1);
        Buffer empty = (Buffer) objRequestBuffer;
        if (empty == null) {
            empty = Buffer.INSTANCE.getEmpty();
        }
        try {
            int iIntValue = ((Number) function3.invoke(Memory.m7628boximpl(empty.getMemory()), Long.valueOf(empty.getReadPosition()), Long.valueOf(empty.getWritePosition()))).intValue();
            InlineMarker.mark(0);
            completeReadingFromBuffer(byteReadChannel, empty, iIntValue, continuation);
            return Integer.valueOf(iIntValue);
        } finally {
            InlineMarker.mark(0);
            completeReadingFromBuffer(byteReadChannel, empty, 0, continuation);
            InlineMarker.mark(1);
        }
    }

    public static final Object requestBuffer(ByteReadChannel byteReadChannel, int i, Continuation<? super Buffer> continuation) {
        SuspendableReadSession suspendableReadSessionStartReadSession;
        if (byteReadChannel instanceof SuspendableReadSession) {
            suspendableReadSessionStartReadSession = (SuspendableReadSession) byteReadChannel;
        } else {
            suspendableReadSessionStartReadSession = byteReadChannel instanceof HasReadSession ? ((HasReadSession) byteReadChannel).startReadSession() : null;
        }
        if (suspendableReadSessionStartReadSession != null) {
            ChunkBuffer chunkBufferRequest = suspendableReadSessionStartReadSession.request(RangesKt.coerceAtMost(i, 8));
            return chunkBufferRequest != null ? chunkBufferRequest : requestBufferSuspend(suspendableReadSessionStartReadSession, i, continuation);
        }
        return requestBufferFallback(byteReadChannel, i, continuation);
    }

    public static final Object completeReadingFromBuffer(ByteReadChannel byteReadChannel, Buffer buffer, int i, Continuation<? super Unit> continuation) {
        if (i < 0) {
            throw new IllegalStateException(("bytesRead shouldn't be negative: " + i).toString());
        }
        SuspendableReadSession sessionFor = readSessionFor(byteReadChannel);
        if (sessionFor != null) {
            sessionFor.discard(i);
            if (byteReadChannel instanceof HasReadSession) {
                ((HasReadSession) byteReadChannel).endReadSession();
            }
            return Unit.INSTANCE;
        }
        if ((buffer instanceof ChunkBuffer) && buffer != ChunkBuffer.INSTANCE.getEmpty()) {
            ((ChunkBuffer) buffer).release(ChunkBuffer.INSTANCE.getPool());
            Object objDiscard = byteReadChannel.discard(i, continuation);
            return objDiscard == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDiscard : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object requestBufferSuspend(SuspendableReadSession suspendableReadSession, int i, Continuation<? super Buffer> continuation) throws Throwable {
        C48441 c48441;
        if (continuation instanceof C48441) {
            c48441 = (C48441) continuation;
            if ((c48441.label & Integer.MIN_VALUE) != 0) {
                c48441.label -= Integer.MIN_VALUE;
            } else {
                c48441 = new C48441(continuation);
            }
        } else {
            c48441 = new C48441(continuation);
        }
        Object obj = c48441.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c48441.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            c48441.L$0 = suspendableReadSession;
            c48441.label = 1;
            if (suspendableReadSession.await(i, c48441) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            suspendableReadSession = (SuspendableReadSession) c48441.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return suspendableReadSession.request(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public static final Object requestBufferFallback(ByteReadChannel byteReadChannel, int i, Continuation<? super ChunkBuffer> continuation) throws Throwable {
        C48431 c48431;
        ChunkBuffer chunkBuffer;
        if (continuation instanceof C48431) {
            c48431 = (C48431) continuation;
            if ((c48431.label & Integer.MIN_VALUE) != 0) {
                c48431.label -= Integer.MIN_VALUE;
            } else {
                c48431 = new C48431(continuation);
            }
        } else {
            c48431 = new C48431(continuation);
        }
        C48431 c48432 = c48431;
        Object obj = c48432.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c48432.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            ChunkBuffer chunkBufferBorrow = ChunkBuffer.INSTANCE.getPool().borrow();
            ChunkBuffer chunkBuffer2 = chunkBufferBorrow;
            long limit = chunkBuffer2.getLimit() - chunkBuffer2.getWritePosition();
            c48432.L$0 = chunkBufferBorrow;
            c48432.label = 1;
            Object objMo7618peekTolBXzO7A = byteReadChannel.mo7618peekTolBXzO7A(chunkBufferBorrow.getMemory(), chunkBufferBorrow.getWritePosition(), 0L, i, limit, c48432);
            if (objMo7618peekTolBXzO7A == coroutine_suspended) {
                return coroutine_suspended;
            }
            chunkBuffer = chunkBufferBorrow;
            obj = objMo7618peekTolBXzO7A;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            chunkBuffer = (ChunkBuffer) c48432.L$0;
            ResultKt.throwOnFailure(obj);
        }
        chunkBuffer.commitWritten((int) ((Number) obj).longValue());
        return chunkBuffer;
    }

    private static final SuspendableReadSession readSessionFor(ByteReadChannel byteReadChannel) {
        if (byteReadChannel instanceof HasReadSession) {
            return ((HasReadSession) byteReadChannel).startReadSession();
        }
        return null;
    }
}
