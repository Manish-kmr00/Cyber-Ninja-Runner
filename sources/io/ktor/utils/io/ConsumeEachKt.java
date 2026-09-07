package io.ktor.utils.io;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.Buffer;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: ConsumeEach.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aQ\u0010\u0000\u001a\u00020\u0001*\u00020\u00022:\u0010\u0003\u001a6\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\t0\u0004j\u0002`\u000bH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\f*j\u0010\r\"2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\t0\u000422\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\t0\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"consumeEachBufferRange", "", "Lio/ktor/utils/io/ByteReadChannel;", "visitor", "Lkotlin/Function2;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "buffer", "", "last", "Lio/ktor/utils/io/ConsumeEachBufferVisitor;", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ConsumeEachBufferVisitor", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ConsumeEachKt {

    /* JADX INFO: renamed from: io.ktor.utils.io.ConsumeEachKt$consumeEachBufferRange$1, reason: invalid class name */
    /* JADX INFO: compiled from: ConsumeEach.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
    @DebugMetadata(c = "io.ktor.utils.io.ConsumeEachKt", f = "ConsumeEach.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2}, l = {46, 50, 53}, m = "consumeEachBufferRange", n = {"$this$consumeEachBufferRange", "visitor", "continueFlag", "lastChunkReported", "$this$read_u24default$iv", "$this$consumeEachBufferRange", "visitor", "continueFlag", "lastChunkReported", "$this$read_u24default$iv", "buffer$iv", "bytesRead$iv", "cause$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConsumeEachKt.consumeEachBufferRange(null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00b4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:29:0x00be  */
    /* JADX WARN: Code duplicated, block: B:33:0x00d7 A[Catch: all -> 0x013e, TryCatch #1 {all -> 0x013e, blocks: (B:31:0x00c5, B:33:0x00d7, B:35:0x00e3, B:37:0x00ed, B:41:0x00f6, B:34:0x00dd), top: B:63:0x00c5 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00dd A[Catch: all -> 0x013e, TryCatch #1 {all -> 0x013e, blocks: (B:31:0x00c5, B:33:0x00d7, B:35:0x00e3, B:37:0x00ed, B:41:0x00f6, B:34:0x00dd), top: B:63:0x00c5 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00ed A[Catch: all -> 0x013e, TryCatch #1 {all -> 0x013e, blocks: (B:31:0x00c5, B:33:0x00d7, B:35:0x00e3, B:37:0x00ed, B:41:0x00f6, B:34:0x00dd), top: B:63:0x00c5 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:43:0x0124 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:44:0x0125  */
    /* JADX WARN: Code duplicated, block: B:47:0x012c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0125 -> B:45:0x0128). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object consumeEachBufferRange(io.ktor.utils.io.ByteReadChannel r18, kotlin.jvm.functions.Function2<? super java.nio.ByteBuffer, ? super java.lang.Boolean, java.lang.Boolean> r19, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            Method dump skipped, instruction units count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ConsumeEachKt.consumeEachBufferRange(io.ktor.utils.io.ByteReadChannel, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object consumeEachBufferRange$$forInline(ByteReadChannel byteReadChannel, Function2<? super ByteBuffer, ? super Boolean, Boolean> function2, Continuation<? super Unit> continuation) {
        ByteBuffer byteBufferM7645getEmptySK3TCg8;
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        do {
            booleanRef.element = false;
            InlineMarker.mark(0);
            Object objRequestBuffer = ReadSessionKt.requestBuffer(byteReadChannel, 1, continuation);
            InlineMarker.mark(1);
            Buffer empty = (Buffer) objRequestBuffer;
            if (empty == null) {
                empty = Buffer.INSTANCE.getEmpty();
            }
            try {
                Memory memoryM7628boximpl = Memory.m7628boximpl(empty.getMemory());
                Long lValueOf = Long.valueOf(empty.getReadPosition());
                long jLongValue = Long.valueOf(empty.getWritePosition()).longValue();
                long jLongValue2 = lValueOf.longValue();
                Memory memory = memoryM7628boximpl;
                ByteBuffer byteBufferM7644unboximpl = memoryM7628boximpl.m7644unboximpl();
                if (jLongValue > jLongValue2) {
                    byteBufferM7645getEmptySK3TCg8 = Memory.m7640slice87lwejk(byteBufferM7644unboximpl, jLongValue2, jLongValue - jLongValue2);
                } else {
                    byteBufferM7645getEmptySK3TCg8 = Memory.INSTANCE.m7645getEmptySK3TCg8();
                }
                booleanRef2.element = byteBufferM7645getEmptySK3TCg8.remaining() == byteReadChannel.get_availableForRead() && byteReadChannel.isClosedForWrite();
                booleanRef.element = function2.invoke(byteBufferM7645getEmptySK3TCg8, Boolean.valueOf(booleanRef2.element)).booleanValue();
                int iIntValue = Integer.valueOf(byteBufferM7645getEmptySK3TCg8.position()).intValue();
                InlineMarker.mark(0);
                ReadSessionKt.completeReadingFromBuffer(byteReadChannel, empty, iIntValue, continuation);
                InlineMarker.mark(1);
                Integer.valueOf(iIntValue);
                if (booleanRef2.element && byteReadChannel.isClosedForRead()) {
                    break;
                }
            } catch (Throwable th) {
                InlineMarker.mark(0);
                ReadSessionKt.completeReadingFromBuffer(byteReadChannel, empty, 0, continuation);
                InlineMarker.mark(1);
                throw th;
            }
        } while (booleanRef.element);
        return Unit.INSTANCE;
    }
}
