package io.ktor.utils.io;

import com.json.mediationsdk.utils.IronSourceConstants;
import io.ktor.utils.io.internal.UtilsKt;
import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Delimited.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a-\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0001H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a\u001d\u0010\n\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a\u001d\u0010\r\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a\u0014\u0010\u000e\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u001c\u0010\u0010\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u001a\u0014\u0010\u0011\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"readUntilDelimiter", "", "Lio/ktor/utils/io/ByteReadChannel;", "delimiter", "Ljava/nio/ByteBuffer;", "dst", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readUntilDelimiterSuspend", "copied0", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "skipDelimiter", "", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "skipDelimiterSuspend", "startsWithDelimiter", "Lio/ktor/utils/io/LookAheadSession;", "tryCopyUntilDelimiter", "tryEnsureDelimiter", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DelimitedKt {

    /* JADX INFO: renamed from: io.ktor.utils.io.DelimitedKt$readUntilDelimiterSuspend$1, reason: invalid class name */
    /* JADX INFO: compiled from: Delimited.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.DelimitedKt", f = "Delimited.kt", i = {0, 0, 0}, l = {IronSourceConstants.TROUBLESHOOTING_AD_QUALITY_SDK_INITIALIZED_SUCCESSFULLY_EVENT, 113}, m = "readUntilDelimiterSuspend", n = {"$this$readUntilDelimiterSuspend", "dst", "endFound"}, s = {"L$0", "L$1", "L$2"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DelimitedKt.readUntilDelimiterSuspend(null, null, null, 0, this);
        }
    }

    public static final Object readUntilDelimiter(ByteReadChannel byteReadChannel, final ByteBuffer byteBuffer, final ByteBuffer byteBuffer2, Continuation<? super Integer> continuation) {
        int i;
        if (!byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (byteBuffer == byteBuffer2) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        byteReadChannel.lookAhead(new Function1<LookAheadSession, Unit>() { // from class: io.ktor.utils.io.DelimitedKt.readUntilDelimiter.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LookAheadSession lookAheadSession) {
                invoke2(lookAheadSession);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LookAheadSession lookAhead) {
                Intrinsics.checkNotNullParameter(lookAhead, "$this$lookAhead");
                do {
                    int iTryCopyUntilDelimiter = DelimitedKt.tryCopyUntilDelimiter(lookAhead, byteBuffer, byteBuffer2);
                    if (iTryCopyUntilDelimiter == 0) {
                        return;
                    }
                    if (iTryCopyUntilDelimiter < 0) {
                        booleanRef.element = true;
                        iTryCopyUntilDelimiter = -iTryCopyUntilDelimiter;
                    }
                    intRef.element += iTryCopyUntilDelimiter;
                    if (!byteBuffer2.hasRemaining()) {
                        return;
                    }
                } while (!booleanRef.element);
            }
        });
        if (intRef.element == 0 && byteReadChannel.isClosedForRead()) {
            i = -1;
        } else if (!byteBuffer2.hasRemaining() || booleanRef.element) {
            i = intRef.element;
        } else {
            return readUntilDelimiterSuspend(byteReadChannel, byteBuffer, byteBuffer2, intRef.element, continuation);
        }
        return Boxing.boxInt(i);
    }

    public static final Object skipDelimiter(ByteReadChannel byteReadChannel, final ByteBuffer byteBuffer, Continuation<? super Unit> continuation) {
        if (!byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        byteReadChannel.lookAhead(new Function1<LookAheadSession, Unit>() { // from class: io.ktor.utils.io.DelimitedKt.skipDelimiter.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LookAheadSession lookAheadSession) {
                invoke2(lookAheadSession);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LookAheadSession lookAhead) {
                Intrinsics.checkNotNullParameter(lookAhead, "$this$lookAhead");
                booleanRef.element = DelimitedKt.tryEnsureDelimiter(lookAhead, byteBuffer) == byteBuffer.remaining();
            }
        });
        if (!booleanRef.element) {
            Object objSkipDelimiterSuspend = skipDelimiterSuspend(byteReadChannel, byteBuffer, continuation);
            return objSkipDelimiterSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSkipDelimiterSuspend : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.DelimitedKt$skipDelimiterSuspend$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Delimited.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/LookAheadSuspendSession;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.DelimitedKt$skipDelimiterSuspend$2", f = "Delimited.kt", i = {0}, l = {66}, m = "invokeSuspend", n = {"$this$lookAheadSuspend"}, s = {"L$0"})
    static final class C48422 extends SuspendLambda implements Function2<LookAheadSuspendSession, Continuation<? super Unit>, Object> {
        final /* synthetic */ ByteBuffer $delimiter;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C48422(ByteBuffer byteBuffer, Continuation<? super C48422> continuation) {
            super(2, continuation);
            this.$delimiter = byteBuffer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C48422 c48422 = new C48422(this.$delimiter, continuation);
            c48422.L$0 = obj;
            return c48422;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(LookAheadSuspendSession lookAheadSuspendSession, Continuation<? super Unit> continuation) {
            return ((C48422) create(lookAheadSuspendSession, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            LookAheadSuspendSession lookAheadSuspendSession;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LookAheadSuspendSession lookAheadSuspendSession2 = (LookAheadSuspendSession) this.L$0;
                this.L$0 = lookAheadSuspendSession2;
                this.label = 1;
                if (lookAheadSuspendSession2.awaitAtLeast(this.$delimiter.remaining(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                lookAheadSuspendSession = lookAheadSuspendSession2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lookAheadSuspendSession = (LookAheadSuspendSession) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            if (DelimitedKt.tryEnsureDelimiter(lookAheadSuspendSession, this.$delimiter) != this.$delimiter.remaining()) {
                throw new IOException("Broken delimiter occurred");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object skipDelimiterSuspend(ByteReadChannel byteReadChannel, ByteBuffer byteBuffer, Continuation<? super Unit> continuation) {
        Object objLookAheadSuspend = byteReadChannel.lookAheadSuspend(new C48422(byteBuffer, null), continuation);
        return objLookAheadSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objLookAheadSuspend : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public static final Object readUntilDelimiterSuspend(ByteReadChannel byteReadChannel, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, Continuation<? super Integer> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        ByteReadChannel byteReadChannel2;
        ByteBuffer byteBuffer3;
        Ref.BooleanRef booleanRef;
        int iIntValue;
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
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object objLookAheadSuspend = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = anonymousClass2.label;
        if (i3 != 0) {
            if (i3 == 1) {
                booleanRef = (Ref.BooleanRef) anonymousClass2.L$2;
                byteBuffer3 = (ByteBuffer) anonymousClass2.L$1;
                byteReadChannel2 = (ByteReadChannel) anonymousClass2.L$0;
                ResultKt.throwOnFailure(objLookAheadSuspend);
            } else {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i2 = anonymousClass2.I$0;
                ResultKt.throwOnFailure(objLookAheadSuspend);
            }
            iIntValue = RangesKt.coerceAtLeast(((Number) objLookAheadSuspend).intValue(), 0) + i2;
            return Boxing.boxInt(iIntValue);
        }
        ResultKt.throwOnFailure(objLookAheadSuspend);
        if (byteBuffer == byteBuffer2) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (i < 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        DelimitedKt$readUntilDelimiterSuspend$copied$1 delimitedKt$readUntilDelimiterSuspend$copied$1 = new DelimitedKt$readUntilDelimiterSuspend$copied$1(i, byteBuffer, byteBuffer2, booleanRef2, byteReadChannel, null);
        anonymousClass2.L$0 = byteReadChannel;
        anonymousClass2.L$1 = byteBuffer2;
        anonymousClass2.L$2 = booleanRef2;
        anonymousClass2.label = 1;
        objLookAheadSuspend = byteReadChannel.lookAheadSuspend(delimitedKt$readUntilDelimiterSuspend$copied$1, anonymousClass2);
        if (objLookAheadSuspend == coroutine_suspended) {
            return coroutine_suspended;
        }
        byteReadChannel2 = byteReadChannel;
        byteBuffer3 = byteBuffer2;
        booleanRef = booleanRef2;
        iIntValue = ((Number) objLookAheadSuspend).intValue();
        if (iIntValue > 0 && byteReadChannel2.isClosedForWrite() && !booleanRef.element) {
            anonymousClass2.L$0 = null;
            anonymousClass2.L$1 = null;
            anonymousClass2.L$2 = null;
            anonymousClass2.I$0 = iIntValue;
            anonymousClass2.label = 2;
            Object available = byteReadChannel2.readAvailable(byteBuffer3, anonymousClass2);
            if (available == coroutine_suspended) {
                return coroutine_suspended;
            }
            i2 = iIntValue;
            objLookAheadSuspend = available;
            iIntValue = RangesKt.coerceAtLeast(((Number) objLookAheadSuspend).intValue(), 0) + i2;
        } else if (iIntValue == 0 && byteReadChannel2.isClosedForRead()) {
            iIntValue = -1;
        }
        return Boxing.boxInt(iIntValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int tryCopyUntilDelimiter(LookAheadSession lookAheadSession, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int iPutAtMost$default;
        boolean z = false;
        ByteBuffer byteBufferRequest = lookAheadSession.request(0, 1);
        if (byteBufferRequest == null) {
            return 0;
        }
        int iIndexOfPartial = UtilsKt.indexOfPartial(byteBufferRequest, byteBuffer);
        if (iIndexOfPartial != -1) {
            int iMin = Math.min(byteBufferRequest.remaining() - iIndexOfPartial, byteBuffer.remaining());
            int iRemaining = byteBuffer.remaining() - iMin;
            if (iRemaining == 0) {
                iPutAtMost$default = UtilsKt.putLimited(byteBuffer2, byteBufferRequest, byteBufferRequest.position() + iIndexOfPartial);
            } else {
                ByteBuffer remembered = byteBufferRequest.duplicate();
                ByteBuffer byteBufferRequest2 = lookAheadSession.request(iIndexOfPartial + iMin, 1);
                if (byteBufferRequest2 == null) {
                    Intrinsics.checkNotNullExpressionValue(remembered, "remembered");
                    iPutAtMost$default = UtilsKt.putLimited(byteBuffer2, remembered, remembered.position() + iIndexOfPartial);
                } else if (UtilsKt.startsWith(byteBufferRequest2, byteBuffer, iMin)) {
                    if (byteBufferRequest2.remaining() >= iRemaining) {
                        Intrinsics.checkNotNullExpressionValue(remembered, "remembered");
                        iPutAtMost$default = UtilsKt.putLimited(byteBuffer2, remembered, remembered.position() + iIndexOfPartial);
                    } else {
                        Intrinsics.checkNotNullExpressionValue(remembered, "remembered");
                        iPutAtMost$default = UtilsKt.putLimited(byteBuffer2, remembered, remembered.position() + iIndexOfPartial);
                    }
                } else {
                    Intrinsics.checkNotNullExpressionValue(remembered, "remembered");
                    iPutAtMost$default = UtilsKt.putLimited(byteBuffer2, remembered, remembered.position() + iIndexOfPartial + 1);
                }
            }
            z = true;
        } else {
            iPutAtMost$default = UtilsKt.putAtMost$default(byteBuffer2, byteBufferRequest, 0, 2, null);
        }
        lookAheadSession.mo7895consumed(iPutAtMost$default);
        return z ? -iPutAtMost$default : iPutAtMost$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int tryEnsureDelimiter(LookAheadSession lookAheadSession, ByteBuffer byteBuffer) throws IOException {
        int iStartsWithDelimiter = startsWithDelimiter(lookAheadSession, byteBuffer);
        if (iStartsWithDelimiter == -1) {
            throw new IOException("Failed to skip delimiter: actual bytes differ from delimiter bytes");
        }
        if (iStartsWithDelimiter < byteBuffer.remaining()) {
            return iStartsWithDelimiter;
        }
        lookAheadSession.mo7895consumed(byteBuffer.remaining());
        return byteBuffer.remaining();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int startsWithDelimiter(LookAheadSession lookAheadSession, ByteBuffer byteBuffer) {
        ByteBuffer byteBufferRequest = lookAheadSession.request(0, 1);
        if (byteBufferRequest == null) {
            return 0;
        }
        int iIndexOfPartial = UtilsKt.indexOfPartial(byteBufferRequest, byteBuffer);
        if (iIndexOfPartial != 0) {
            return -1;
        }
        int iMin = Math.min(byteBufferRequest.remaining() - iIndexOfPartial, byteBuffer.remaining());
        int iRemaining = byteBuffer.remaining() - iMin;
        if (iRemaining > 0) {
            ByteBuffer byteBufferRequest2 = lookAheadSession.request(iIndexOfPartial + iMin, iRemaining);
            if (byteBufferRequest2 == null) {
                return iMin;
            }
            if (!UtilsKt.startsWith(byteBufferRequest2, byteBuffer, iMin)) {
                return -1;
            }
        }
        return byteBuffer.remaining();
    }
}
