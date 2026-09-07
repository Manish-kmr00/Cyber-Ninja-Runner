package io.ktor.utils.io.jvm.nio;

import com.json.fe;
import io.ktor.utils.io.ByteWriteChannel;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SelectableChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: Reading.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"copyTo", "", "Ljava/nio/channels/Pipe;", "ch", "Lio/ktor/utils/io/ByteWriteChannel;", "limit", "(Ljava/nio/channels/Pipe;Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/nio/channels/ReadableByteChannel;", "(Ljava/nio/channels/ReadableByteChannel;Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ReadingKt {

    /* JADX INFO: renamed from: io.ktor.utils.io.jvm.nio.ReadingKt$copyTo$1, reason: invalid class name */
    /* JADX INFO: compiled from: Reading.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.jvm.nio.ReadingKt", f = "Reading.kt", i = {0, 0, 0, 0, 0, 0}, l = {42}, m = "copyTo", n = {"ch", "copied", fe.s1, "copy", "limit", "needFlush"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0", "I$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReadingKt.copyTo((ReadableByteChannel) null, (ByteWriteChannel) null, 0L, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00a0 -> B:31:0x00a3). Please report as a decompilation issue!!! */
    public static final Object copyTo(final ReadableByteChannel readableByteChannel, ByteWriteChannel byteWriteChannel, final long j, Continuation<? super Long> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        final Ref.BooleanRef booleanRef;
        Function1<ByteBuffer, Unit> function1;
        int i;
        Ref.LongRef longRef;
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
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (j < 0) {
                throw new IllegalArgumentException(("Limit shouldn't be negative: " + j).toString());
            }
            if ((readableByteChannel instanceof SelectableChannel) && !((SelectableChannel) readableByteChannel).isBlocking()) {
                throw new IllegalArgumentException("Non-blocking channels are not supported");
            }
            final Ref.LongRef longRef2 = new Ref.LongRef();
            booleanRef = new Ref.BooleanRef();
            function1 = new Function1<ByteBuffer, Unit>() { // from class: io.ktor.utils.io.jvm.nio.ReadingKt$copyTo$copy$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ByteBuffer byteBuffer) throws IOException {
                    invoke2(byteBuffer);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ByteBuffer bb) throws IOException {
                    Intrinsics.checkNotNullParameter(bb, "bb");
                    long j2 = j - longRef2.element;
                    if (j2 < bb.remaining()) {
                        int iLimit = bb.limit();
                        bb.limit(bb.position() + ((int) j2));
                        int i3 = readableByteChannel.read(bb);
                        if (i3 == -1) {
                            booleanRef.element = true;
                        } else {
                            longRef2.element += (long) i3;
                        }
                        bb.limit(iLimit);
                        return;
                    }
                    int i4 = readableByteChannel.read(bb);
                    if (i4 == -1) {
                        booleanRef.element = true;
                    } else {
                        longRef2.element += (long) i4;
                    }
                }
            };
            i = !byteWriteChannel.getAutoFlush() ? 1 : 0;
            longRef = longRef2;
            if (longRef.element >= j && !booleanRef.element) {
                anonymousClass1.L$0 = byteWriteChannel;
                anonymousClass1.L$1 = longRef;
                anonymousClass1.L$2 = booleanRef;
                anonymousClass1.L$3 = function1;
                anonymousClass1.J$0 = j;
                anonymousClass1.I$0 = i;
                anonymousClass1.label = 1;
                if (byteWriteChannel.write(1, function1, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                return Boxing.boxLong(longRef.element);
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = anonymousClass1.I$0;
            long j2 = anonymousClass1.J$0;
            Function1<ByteBuffer, Unit> function2 = (Function1) anonymousClass1.L$3;
            booleanRef = (Ref.BooleanRef) anonymousClass1.L$2;
            longRef = (Ref.LongRef) anonymousClass1.L$1;
            ByteWriteChannel byteWriteChannel2 = (ByteWriteChannel) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            function1 = function2;
            j = j2;
            byteWriteChannel = byteWriteChannel2;
        }
        if (i != 0) {
            byteWriteChannel.flush();
        }
        if (longRef.element >= j) {
        }
        return Boxing.boxLong(longRef.element);
    }

    public static /* synthetic */ Object copyTo$default(ReadableByteChannel readableByteChannel, ByteWriteChannel byteWriteChannel, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MAX_VALUE;
        }
        return copyTo(readableByteChannel, byteWriteChannel, j, (Continuation<? super Long>) continuation);
    }

    public static final Object copyTo(Pipe pipe, ByteWriteChannel byteWriteChannel, long j, Continuation<? super Long> continuation) {
        Pipe.SourceChannel sourceChannelSource = pipe.source();
        Intrinsics.checkNotNullExpressionValue(sourceChannelSource, "source()");
        return copyTo(sourceChannelSource, byteWriteChannel, j, continuation);
    }

    public static /* synthetic */ Object copyTo$default(Pipe pipe, ByteWriteChannel byteWriteChannel, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MAX_VALUE;
        }
        return copyTo(pipe, byteWriteChannel, j, (Continuation<? super Long>) continuation);
    }
}
