package io.ktor.utils.io;

import com.json.mediationsdk.utils.IronSourceConstants;
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

/* JADX INFO: compiled from: WriterSession.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0002\u001a#\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a%\u0010\b\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0006H\u0081@ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\u001d\u0010\u000e\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0001H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a\u001f\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0081@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001ao\u0010\u0012\u001a\u00020\u0006*\u00020\n2\b\b\u0002\u0010\u0005\u001a\u00020\u00062K\u0010\u0013\u001aG\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00060\u0014H\u0086Hø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a\u000e\u0010\u001d\u001a\u0004\u0018\u00010\u0004*\u00020\nH\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"writeBufferFallback", "Lio/ktor/utils/io/core/Buffer;", "writeBufferSuspend", "session", "Lio/ktor/utils/io/WriterSuspendSession;", "desiredSpace", "", "(Lio/ktor/utils/io/WriterSuspendSession;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "completeWriting", "", "Lio/ktor/utils/io/ByteWriteChannel;", "buffer", "written", "(Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/utils/io/core/Buffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "completeWritingFallback", "(Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/utils/io/core/Buffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestWriteBuffer", "(Lio/ktor/utils/io/ByteWriteChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "write", "block", "Lkotlin/Function3;", "Lio/ktor/utils/io/bits/Memory;", "Lkotlin/ParameterName;", "name", "freeSpace", "", "startOffset", "endExclusive", "(Lio/ktor/utils/io/ByteWriteChannel;ILkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeSessionFor", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class WriterSessionKt {

    /* JADX INFO: renamed from: io.ktor.utils.io.WriterSessionKt$completeWritingFallback$1, reason: invalid class name */
    /* JADX INFO: compiled from: WriterSession.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.WriterSessionKt", f = "WriterSession.kt", i = {0}, l = {IronSourceConstants.TROUBLESHOOTING_AD_QUALITY_SDK_FAILED_TO_INITIALIZE_EVENT}, m = "completeWritingFallback", n = {"buffer"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WriterSessionKt.completeWritingFallback(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.WriterSessionKt$write$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WriterSession.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
    @DebugMetadata(c = "io.ktor.utils.io.WriterSessionKt", f = "WriterSession.kt", i = {0, 0}, l = {22, 29, 29}, m = "write", n = {"$this$write", "block"}, s = {"L$0", "L$1"})
    static final class C48451 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C48451(Continuation<? super C48451> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WriterSessionKt.write(null, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.WriterSessionKt$writeBufferSuspend$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WriterSession.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.WriterSessionKt", f = "WriterSession.kt", i = {0, 0}, l = {93}, m = "writeBufferSuspend", n = {"session", "desiredSpace"}, s = {"L$0", "I$0"})
    static final class C48461 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C48461(Continuation<? super C48461> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WriterSessionKt.writeBufferSuspend(null, 0, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object write(ByteWriteChannel byteWriteChannel, int i, Function3<? super Memory, ? super Long, ? super Long, Integer> function3, Continuation<? super Integer> continuation) throws Throwable {
        C48451 c48451;
        Buffer empty;
        int iIntValue;
        Throwable th;
        Integer num;
        if (continuation instanceof C48451) {
            c48451 = (C48451) continuation;
            if ((c48451.label & Integer.MIN_VALUE) != 0) {
                c48451.label -= Integer.MIN_VALUE;
            } else {
                c48451 = new C48451(continuation);
            }
        } else {
            c48451 = new C48451(continuation);
        }
        Object objRequestWriteBuffer = c48451.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c48451.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objRequestWriteBuffer);
                c48451.L$0 = byteWriteChannel;
                c48451.L$1 = function3;
                c48451.label = 1;
                objRequestWriteBuffer = requestWriteBuffer(byteWriteChannel, i, c48451);
                if (objRequestWriteBuffer == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    if (i2 == 2) {
                        num = (Integer) c48451.L$0;
                        ResultKt.throwOnFailure(objRequestWriteBuffer);
                        InlineMarker.finallyEnd(1);
                        return num;
                    }
                    if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    th = (Throwable) c48451.L$0;
                    ResultKt.throwOnFailure(objRequestWriteBuffer);
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
                function3 = (Function3) c48451.L$1;
                byteWriteChannel = (ByteWriteChannel) c48451.L$0;
                ResultKt.throwOnFailure(objRequestWriteBuffer);
            }
            iIntValue = function3.invoke(Memory.m7628boximpl(empty.getMemory()), Boxing.boxLong(empty.getWritePosition()), Boxing.boxLong(empty.getLimit())).intValue();
            empty.commitWritten(iIntValue);
            Integer numBoxInt = Boxing.boxInt(iIntValue);
            InlineMarker.finallyStart(1);
            c48451.L$0 = numBoxInt;
            c48451.L$1 = null;
            c48451.label = 2;
            if (completeWriting(byteWriteChannel, empty, iIntValue, c48451) == coroutine_suspended) {
                return coroutine_suspended;
            }
            num = numBoxInt;
            InlineMarker.finallyEnd(1);
            return num;
        } catch (Throwable th2) {
            InlineMarker.finallyStart(1);
            c48451.L$0 = th2;
            c48451.L$1 = null;
            c48451.label = 3;
            if (completeWriting(byteWriteChannel, empty, iIntValue, c48451) == coroutine_suspended) {
                return coroutine_suspended;
            }
            th = th2;
        }
        empty = (Buffer) objRequestWriteBuffer;
        if (empty == null) {
            empty = Buffer.INSTANCE.getEmpty();
        }
        iIntValue = 0;
    }

    private static final Object write$$forInline(ByteWriteChannel byteWriteChannel, int i, Function3<? super Memory, ? super Long, ? super Long, Integer> function3, Continuation<? super Integer> continuation) throws Throwable {
        int iIntValue;
        InlineMarker.mark(0);
        Object objRequestWriteBuffer = requestWriteBuffer(byteWriteChannel, i, continuation);
        InlineMarker.mark(1);
        Buffer empty = (Buffer) objRequestWriteBuffer;
        if (empty == null) {
            empty = Buffer.INSTANCE.getEmpty();
        }
        try {
            iIntValue = function3.invoke(Memory.m7628boximpl(empty.getMemory()), Long.valueOf(empty.getWritePosition()), Long.valueOf(empty.getLimit())).intValue();
            try {
                empty.commitWritten(iIntValue);
                Integer numValueOf = Integer.valueOf(iIntValue);
                InlineMarker.finallyStart(1);
                InlineMarker.mark(0);
                completeWriting(byteWriteChannel, empty, iIntValue, continuation);
                InlineMarker.mark(1);
                InlineMarker.finallyEnd(1);
                return numValueOf;
            } catch (Throwable th) {
                th = th;
                InlineMarker.finallyStart(1);
                InlineMarker.mark(0);
                completeWriting(byteWriteChannel, empty, iIntValue, continuation);
                InlineMarker.mark(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            iIntValue = 0;
        }
    }

    public static /* synthetic */ Object write$default(ByteWriteChannel byteWriteChannel, int i, Function3 function3, Continuation continuation, int i2, Object obj) throws Throwable {
        int iIntValue;
        if ((i2 & 1) != 0) {
            i = 1;
        }
        InlineMarker.mark(0);
        Object objRequestWriteBuffer = requestWriteBuffer(byteWriteChannel, i, continuation);
        InlineMarker.mark(1);
        Buffer empty = (Buffer) objRequestWriteBuffer;
        if (empty == null) {
            empty = Buffer.INSTANCE.getEmpty();
        }
        try {
            iIntValue = ((Number) function3.invoke(Memory.m7628boximpl(empty.getMemory()), Long.valueOf(empty.getWritePosition()), Long.valueOf(empty.getLimit()))).intValue();
            try {
                empty.commitWritten(iIntValue);
                Integer numValueOf = Integer.valueOf(iIntValue);
                InlineMarker.finallyStart(1);
                InlineMarker.mark(0);
                completeWriting(byteWriteChannel, empty, iIntValue, continuation);
                InlineMarker.mark(1);
                InlineMarker.finallyEnd(1);
                return numValueOf;
            } catch (Throwable th) {
                th = th;
                InlineMarker.finallyStart(1);
                InlineMarker.mark(0);
                completeWriting(byteWriteChannel, empty, iIntValue, continuation);
                InlineMarker.mark(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            iIntValue = 0;
        }
    }

    public static final Object requestWriteBuffer(ByteWriteChannel byteWriteChannel, int i, Continuation<? super Buffer> continuation) {
        WriterSuspendSession writerSuspendSessionWriteSessionFor = writeSessionFor(byteWriteChannel);
        if (writerSuspendSessionWriteSessionFor != null) {
            ChunkBuffer chunkBufferRequest = writerSuspendSessionWriteSessionFor.request(i);
            return chunkBufferRequest != null ? chunkBufferRequest : writeBufferSuspend(writerSuspendSessionWriteSessionFor, i, continuation);
        }
        return writeBufferFallback();
    }

    public static final Object completeWriting(ByteWriteChannel byteWriteChannel, Buffer buffer, int i, Continuation<? super Unit> continuation) throws Throwable {
        if (byteWriteChannel instanceof HasWriteSession) {
            ((HasWriteSession) byteWriteChannel).endWriteSession(i);
            return Unit.INSTANCE;
        }
        Object objCompleteWritingFallback = completeWritingFallback(byteWriteChannel, buffer, continuation);
        return objCompleteWritingFallback == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCompleteWritingFallback : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object completeWritingFallback(ByteWriteChannel byteWriteChannel, Buffer buffer, Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (buffer instanceof ChunkBuffer) {
                anonymousClass1.L$0 = buffer;
                anonymousClass1.label = 1;
                if (byteWriteChannel.writeFully(buffer, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                throw new UnsupportedOperationException("Only ChunkBuffer instance is supported.");
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            buffer = (Buffer) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        ((ChunkBuffer) buffer).release(ChunkBuffer.INSTANCE.getPool());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object writeBufferSuspend(WriterSuspendSession writerSuspendSession, int i, Continuation<? super Buffer> continuation) throws Throwable {
        C48461 c48461;
        if (continuation instanceof C48461) {
            c48461 = (C48461) continuation;
            if ((c48461.label & Integer.MIN_VALUE) != 0) {
                c48461.label -= Integer.MIN_VALUE;
            } else {
                c48461 = new C48461(continuation);
            }
        } else {
            c48461 = new C48461(continuation);
        }
        Object obj = c48461.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c48461.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            c48461.L$0 = writerSuspendSession;
            c48461.I$0 = i;
            c48461.label = 1;
            if (writerSuspendSession.tryAwait(i, c48461) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = c48461.I$0;
            writerSuspendSession = (WriterSuspendSession) c48461.L$0;
            ResultKt.throwOnFailure(obj);
        }
        ChunkBuffer chunkBufferRequest = writerSuspendSession.request(i);
        return chunkBufferRequest != null ? chunkBufferRequest : writerSuspendSession.request(1);
    }

    private static final Buffer writeBufferFallback() {
        ChunkBuffer chunkBufferBorrow = ChunkBuffer.INSTANCE.getPool().borrow();
        ChunkBuffer chunkBuffer = chunkBufferBorrow;
        chunkBuffer.resetForWrite();
        chunkBuffer.reserveEndGap(8);
        return chunkBufferBorrow;
    }

    private static final WriterSuspendSession writeSessionFor(ByteWriteChannel byteWriteChannel) {
        if (byteWriteChannel instanceof HasWriteSession) {
            return ((HasWriteSession) byteWriteChannel).beginWriteSession();
        }
        return null;
    }
}
