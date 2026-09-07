package io.ktor.utils.io;

import io.ktor.utils.io.core.ByteOrder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ChannelLittleEndian.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u0002H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001d\u0010\b\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\n\u001a\u00020\t*\u00020\u0002H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001d\u0010\u000b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\r\u001a\u00020\f*\u00020\u0002H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001d\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\u0010\u001a\u00020\u000f*\u00020\u0002H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001d\u0010\u0011\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\u0013\u001a\u00020\u0012*\u00020\u0002H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a<\u0010\u0014\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u0015*\u0002H\u00152\u0006\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u00150\u0017¢\u0006\u0002\b\u0018H\u0081\bø\u0001\u0001¢\u0006\u0002\u0010\u0019\u001a<\u0010\u001a\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u0015*\u00020\u00022\u0006\u0010\u001b\u001a\u0002H\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u00150\u0017¢\u0006\u0002\b\u0018H\u0081\bø\u0001\u0001¢\u0006\u0002\u0010\u001c\u001a9\u0010\u001a\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u0015*\u00020\u001d2\u0006\u0010\u001b\u001a\u0002H\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u00150\u0017¢\u0006\u0002\b\u0018H\u0082\b¢\u0006\u0002\u0010\u001e\u001a%\u0010\u001f\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010!\u001a\u001d\u0010\"\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010#\u001a%\u0010$\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010%\u001a\u001d\u0010&\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010'\u001a%\u0010(\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010)\u001a\u001d\u0010*\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010+\u001a%\u0010,\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010-\u001a\u001d\u0010.\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u000fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010/\u001a%\u00100\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u00101\u001a\u001d\u00102\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u0012H\u0086@ø\u0001\u0000¢\u0006\u0002\u00103\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u00064"}, d2 = {"readDouble", "", "Lio/ktor/utils/io/ByteReadChannel;", "byteOrder", "Lio/ktor/utils/io/core/ByteOrder;", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/core/ByteOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readDoubleLittleEndian", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFloat", "", "readFloatLittleEndian", "readInt", "", "readIntLittleEndian", "readLong", "", "readLongLittleEndian", "readShort", "", "readShortLittleEndian", "reverseIfNeeded", "T", "reverseBlock", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lio/ktor/utils/io/core/ByteOrder;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "toLittleEndian", "value", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteWriteChannel;", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeDouble", "", "(Lio/ktor/utils/io/ByteWriteChannel;DLio/ktor/utils/io/core/ByteOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeDoubleLittleEndian", "(Lio/ktor/utils/io/ByteWriteChannel;DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFloat", "(Lio/ktor/utils/io/ByteWriteChannel;FLio/ktor/utils/io/core/ByteOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFloatLittleEndian", "(Lio/ktor/utils/io/ByteWriteChannel;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeInt", "(Lio/ktor/utils/io/ByteWriteChannel;ILio/ktor/utils/io/core/ByteOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeIntLittleEndian", "(Lio/ktor/utils/io/ByteWriteChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeLong", "(Lio/ktor/utils/io/ByteWriteChannel;JLio/ktor/utils/io/core/ByteOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeLongLittleEndian", "(Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeShort", "(Lio/ktor/utils/io/ByteWriteChannel;SLio/ktor/utils/io/core/ByteOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeShortLittleEndian", "(Lio/ktor/utils/io/ByteWriteChannel;SLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ChannelLittleEndianKt {

    /* JADX INFO: compiled from: ChannelLittleEndian.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ByteOrder.values().length];
            try {
                iArr[ByteOrder.BIG_ENDIAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ChannelLittleEndianKt$readDouble$1, reason: invalid class name */
    /* JADX INFO: compiled from: ChannelLittleEndian.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
    @DebugMetadata(c = "io.ktor.utils.io.ChannelLittleEndianKt", f = "ChannelLittleEndian.kt", i = {0}, l = {23}, m = "readDouble", n = {"byteOrder"}, s = {"L$0"})
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
            return ChannelLittleEndianKt.readDouble(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ChannelLittleEndianKt$readDoubleLittleEndian$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ChannelLittleEndian.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
    @DebugMetadata(c = "io.ktor.utils.io.ChannelLittleEndianKt", f = "ChannelLittleEndian.kt", i = {}, l = {43}, m = "readDoubleLittleEndian", n = {}, s = {})
    static final class C48321 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C48321(Continuation<? super C48321> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelLittleEndianKt.readDoubleLittleEndian(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ChannelLittleEndianKt$readFloat$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ChannelLittleEndian.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
    @DebugMetadata(c = "io.ktor.utils.io.ChannelLittleEndianKt", f = "ChannelLittleEndian.kt", i = {0}, l = {19}, m = "readFloat", n = {"byteOrder"}, s = {"L$0"})
    static final class C48331 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C48331(Continuation<? super C48331> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelLittleEndianKt.readFloat(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ChannelLittleEndianKt$readFloatLittleEndian$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ChannelLittleEndian.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
    @DebugMetadata(c = "io.ktor.utils.io.ChannelLittleEndianKt", f = "ChannelLittleEndian.kt", i = {}, l = {39}, m = "readFloatLittleEndian", n = {}, s = {})
    static final class C48341 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C48341(Continuation<? super C48341> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelLittleEndianKt.readFloatLittleEndian(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ChannelLittleEndianKt$readInt$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ChannelLittleEndian.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
    @DebugMetadata(c = "io.ktor.utils.io.ChannelLittleEndianKt", f = "ChannelLittleEndian.kt", i = {0}, l = {11}, m = "readInt", n = {"byteOrder"}, s = {"L$0"})
    static final class C48351 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C48351(Continuation<? super C48351> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelLittleEndianKt.readInt(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ChannelLittleEndianKt$readIntLittleEndian$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ChannelLittleEndian.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
    @DebugMetadata(c = "io.ktor.utils.io.ChannelLittleEndianKt", f = "ChannelLittleEndian.kt", i = {}, l = {31}, m = "readIntLittleEndian", n = {}, s = {})
    static final class C48361 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C48361(Continuation<? super C48361> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelLittleEndianKt.readIntLittleEndian(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ChannelLittleEndianKt$readLong$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ChannelLittleEndian.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
    @DebugMetadata(c = "io.ktor.utils.io.ChannelLittleEndianKt", f = "ChannelLittleEndian.kt", i = {0}, l = {15}, m = "readLong", n = {"byteOrder"}, s = {"L$0"})
    static final class C48371 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C48371(Continuation<? super C48371> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelLittleEndianKt.readLong(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ChannelLittleEndianKt$readLongLittleEndian$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ChannelLittleEndian.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
    @DebugMetadata(c = "io.ktor.utils.io.ChannelLittleEndianKt", f = "ChannelLittleEndian.kt", i = {}, l = {35}, m = "readLongLittleEndian", n = {}, s = {})
    static final class C48381 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C48381(Continuation<? super C48381> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelLittleEndianKt.readLongLittleEndian(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ChannelLittleEndianKt$readShort$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ChannelLittleEndian.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
    @DebugMetadata(c = "io.ktor.utils.io.ChannelLittleEndianKt", f = "ChannelLittleEndian.kt", i = {0}, l = {7}, m = "readShort", n = {"byteOrder"}, s = {"L$0"})
    static final class C48391 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C48391(Continuation<? super C48391> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelLittleEndianKt.readShort(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ChannelLittleEndianKt$readShortLittleEndian$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ChannelLittleEndian.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
    @DebugMetadata(c = "io.ktor.utils.io.ChannelLittleEndianKt", f = "ChannelLittleEndian.kt", i = {}, l = {27}, m = "readShortLittleEndian", n = {}, s = {})
    static final class C48401 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C48401(Continuation<? super C48401> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelLittleEndianKt.readShortLittleEndian(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object readShort(ByteReadChannel byteReadChannel, ByteOrder byteOrder, Continuation<? super Short> continuation) throws Throwable {
        C48391 c48391;
        if (continuation instanceof C48391) {
            c48391 = (C48391) continuation;
            if ((c48391.label & Integer.MIN_VALUE) != 0) {
                c48391.label -= Integer.MIN_VALUE;
            } else {
                c48391 = new C48391(continuation);
            }
        } else {
            c48391 = new C48391(continuation);
        }
        Object obj = c48391.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c48391.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c48391.L$0 = byteOrder;
            c48391.label = 1;
            obj = byteReadChannel.readShort(c48391);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            byteOrder = (ByteOrder) c48391.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 1 ? obj : Boxing.boxShort(Short.reverseBytes(((Number) obj).shortValue()));
    }

    private static final Object readShort$$forInline(ByteReadChannel byteReadChannel, ByteOrder byteOrder, Continuation<? super Short> continuation) {
        InlineMarker.mark(0);
        Object obj = byteReadChannel.readShort(continuation);
        InlineMarker.mark(1);
        return WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 1 ? obj : Short.valueOf(Short.reverseBytes(((Number) obj).shortValue()));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object readInt(ByteReadChannel byteReadChannel, ByteOrder byteOrder, Continuation<? super Integer> continuation) throws Throwable {
        C48351 c48351;
        if (continuation instanceof C48351) {
            c48351 = (C48351) continuation;
            if ((c48351.label & Integer.MIN_VALUE) != 0) {
                c48351.label -= Integer.MIN_VALUE;
            } else {
                c48351 = new C48351(continuation);
            }
        } else {
            c48351 = new C48351(continuation);
        }
        Object obj = c48351.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c48351.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c48351.L$0 = byteOrder;
            c48351.label = 1;
            obj = byteReadChannel.readInt(c48351);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            byteOrder = (ByteOrder) c48351.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 1 ? obj : Boxing.boxInt(Integer.reverseBytes(((Number) obj).intValue()));
    }

    private static final Object readInt$$forInline(ByteReadChannel byteReadChannel, ByteOrder byteOrder, Continuation<? super Integer> continuation) {
        InlineMarker.mark(0);
        Object obj = byteReadChannel.readInt(continuation);
        InlineMarker.mark(1);
        return WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 1 ? obj : Integer.valueOf(Integer.reverseBytes(((Number) obj).intValue()));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object readLong(ByteReadChannel byteReadChannel, ByteOrder byteOrder, Continuation<? super Long> continuation) throws Throwable {
        C48371 c48371;
        if (continuation instanceof C48371) {
            c48371 = (C48371) continuation;
            if ((c48371.label & Integer.MIN_VALUE) != 0) {
                c48371.label -= Integer.MIN_VALUE;
            } else {
                c48371 = new C48371(continuation);
            }
        } else {
            c48371 = new C48371(continuation);
        }
        Object obj = c48371.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c48371.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c48371.L$0 = byteOrder;
            c48371.label = 1;
            obj = byteReadChannel.readLong(c48371);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            byteOrder = (ByteOrder) c48371.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 1 ? obj : Boxing.boxLong(Long.reverseBytes(((Number) obj).longValue()));
    }

    private static final Object readLong$$forInline(ByteReadChannel byteReadChannel, ByteOrder byteOrder, Continuation<? super Long> continuation) {
        InlineMarker.mark(0);
        Object obj = byteReadChannel.readLong(continuation);
        InlineMarker.mark(1);
        return WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 1 ? obj : Long.valueOf(Long.reverseBytes(((Number) obj).longValue()));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object readFloat(ByteReadChannel byteReadChannel, ByteOrder byteOrder, Continuation<? super Float> continuation) throws Throwable {
        C48331 c48331;
        if (continuation instanceof C48331) {
            c48331 = (C48331) continuation;
            if ((c48331.label & Integer.MIN_VALUE) != 0) {
                c48331.label -= Integer.MIN_VALUE;
            } else {
                c48331 = new C48331(continuation);
            }
        } else {
            c48331 = new C48331(continuation);
        }
        Object obj = c48331.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c48331.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c48331.L$0 = byteOrder;
            c48331.label = 1;
            obj = byteReadChannel.readFloat(c48331);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            byteOrder = (ByteOrder) c48331.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 1 ? obj : Boxing.boxFloat(Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(((Number) obj).floatValue()))));
    }

    private static final Object readFloat$$forInline(ByteReadChannel byteReadChannel, ByteOrder byteOrder, Continuation<? super Float> continuation) {
        InlineMarker.mark(0);
        Object obj = byteReadChannel.readFloat(continuation);
        InlineMarker.mark(1);
        return WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 1 ? obj : Float.valueOf(Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(((Number) obj).floatValue()))));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object readDouble(ByteReadChannel byteReadChannel, ByteOrder byteOrder, Continuation<? super Double> continuation) throws Throwable {
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
            anonymousClass1.L$0 = byteOrder;
            anonymousClass1.label = 1;
            obj = byteReadChannel.readDouble(anonymousClass1);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            byteOrder = (ByteOrder) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 1 ? obj : Boxing.boxDouble(Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(((Number) obj).doubleValue()))));
    }

    private static final Object readDouble$$forInline(ByteReadChannel byteReadChannel, ByteOrder byteOrder, Continuation<? super Double> continuation) {
        InlineMarker.mark(0);
        Object obj = byteReadChannel.readDouble(continuation);
        InlineMarker.mark(1);
        return WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 1 ? obj : Double.valueOf(Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(((Number) obj).doubleValue()))));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object readShortLittleEndian(ByteReadChannel byteReadChannel, Continuation<? super Short> continuation) throws Throwable {
        C48401 c48401;
        if (continuation instanceof C48401) {
            c48401 = (C48401) continuation;
            if ((c48401.label & Integer.MIN_VALUE) != 0) {
                c48401.label -= Integer.MIN_VALUE;
            } else {
                c48401 = new C48401(continuation);
            }
        } else {
            c48401 = new C48401(continuation);
        }
        Object obj = c48401.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c48401.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c48401.label = 1;
            obj = byteReadChannel.readShort(c48401);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxShort(Short.reverseBytes(((Number) obj).shortValue()));
    }

    private static final Object readShortLittleEndian$$forInline(ByteReadChannel byteReadChannel, Continuation<? super Short> continuation) {
        InlineMarker.mark(0);
        Object obj = byteReadChannel.readShort(continuation);
        InlineMarker.mark(1);
        return Short.valueOf(Short.reverseBytes(((Number) obj).shortValue()));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object readIntLittleEndian(ByteReadChannel byteReadChannel, Continuation<? super Integer> continuation) throws Throwable {
        C48361 c48361;
        if (continuation instanceof C48361) {
            c48361 = (C48361) continuation;
            if ((c48361.label & Integer.MIN_VALUE) != 0) {
                c48361.label -= Integer.MIN_VALUE;
            } else {
                c48361 = new C48361(continuation);
            }
        } else {
            c48361 = new C48361(continuation);
        }
        Object obj = c48361.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c48361.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c48361.label = 1;
            obj = byteReadChannel.readInt(c48361);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxInt(Integer.reverseBytes(((Number) obj).intValue()));
    }

    private static final Object readIntLittleEndian$$forInline(ByteReadChannel byteReadChannel, Continuation<? super Integer> continuation) {
        InlineMarker.mark(0);
        Object obj = byteReadChannel.readInt(continuation);
        InlineMarker.mark(1);
        return Integer.valueOf(Integer.reverseBytes(((Number) obj).intValue()));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object readLongLittleEndian(ByteReadChannel byteReadChannel, Continuation<? super Long> continuation) throws Throwable {
        C48381 c48381;
        if (continuation instanceof C48381) {
            c48381 = (C48381) continuation;
            if ((c48381.label & Integer.MIN_VALUE) != 0) {
                c48381.label -= Integer.MIN_VALUE;
            } else {
                c48381 = new C48381(continuation);
            }
        } else {
            c48381 = new C48381(continuation);
        }
        Object obj = c48381.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c48381.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c48381.label = 1;
            obj = byteReadChannel.readLong(c48381);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxLong(Long.reverseBytes(((Number) obj).longValue()));
    }

    private static final Object readLongLittleEndian$$forInline(ByteReadChannel byteReadChannel, Continuation<? super Long> continuation) {
        InlineMarker.mark(0);
        Object obj = byteReadChannel.readLong(continuation);
        InlineMarker.mark(1);
        return Long.valueOf(Long.reverseBytes(((Number) obj).longValue()));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object readFloatLittleEndian(ByteReadChannel byteReadChannel, Continuation<? super Float> continuation) throws Throwable {
        C48341 c48341;
        if (continuation instanceof C48341) {
            c48341 = (C48341) continuation;
            if ((c48341.label & Integer.MIN_VALUE) != 0) {
                c48341.label -= Integer.MIN_VALUE;
            } else {
                c48341 = new C48341(continuation);
            }
        } else {
            c48341 = new C48341(continuation);
        }
        Object obj = c48341.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c48341.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c48341.label = 1;
            obj = byteReadChannel.readFloat(c48341);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxFloat(Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(((Number) obj).floatValue()))));
    }

    private static final Object readFloatLittleEndian$$forInline(ByteReadChannel byteReadChannel, Continuation<? super Float> continuation) {
        InlineMarker.mark(0);
        Object obj = byteReadChannel.readFloat(continuation);
        InlineMarker.mark(1);
        return Float.valueOf(Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(((Number) obj).floatValue()))));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object readDoubleLittleEndian(ByteReadChannel byteReadChannel, Continuation<? super Double> continuation) throws Throwable {
        C48321 c48321;
        if (continuation instanceof C48321) {
            c48321 = (C48321) continuation;
            if ((c48321.label & Integer.MIN_VALUE) != 0) {
                c48321.label -= Integer.MIN_VALUE;
            } else {
                c48321 = new C48321(continuation);
            }
        } else {
            c48321 = new C48321(continuation);
        }
        Object obj = c48321.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c48321.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c48321.label = 1;
            obj = byteReadChannel.readDouble(c48321);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxDouble(Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(((Number) obj).doubleValue()))));
    }

    private static final Object readDoubleLittleEndian$$forInline(ByteReadChannel byteReadChannel, Continuation<? super Double> continuation) {
        InlineMarker.mark(0);
        Object obj = byteReadChannel.readDouble(continuation);
        InlineMarker.mark(1);
        return Double.valueOf(Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(((Number) obj).doubleValue()))));
    }

    public static final <T> T toLittleEndian(ByteReadChannel byteReadChannel, T t, Function1<? super T, ? extends T> reverseBlock) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        Intrinsics.checkNotNullParameter(reverseBlock, "reverseBlock");
        return reverseBlock.invoke(t);
    }

    private static final <T> T toLittleEndian(ByteWriteChannel byteWriteChannel, T t, Function1<? super T, ? extends T> function1) {
        return function1.invoke(t);
    }

    public static final <T> T reverseIfNeeded(T t, ByteOrder byteOrder, Function1<? super T, ? extends T> reverseBlock) {
        Intrinsics.checkNotNullParameter(byteOrder, "byteOrder");
        Intrinsics.checkNotNullParameter(reverseBlock, "reverseBlock");
        return WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 1 ? t : reverseBlock.invoke(t);
    }

    public static final Object writeShort(ByteWriteChannel byteWriteChannel, short s, ByteOrder byteOrder, Continuation<? super Unit> continuation) {
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1) {
            s = Short.reverseBytes(s);
        }
        Object objWriteShort = byteWriteChannel.writeShort(s, continuation);
        return objWriteShort == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteShort : Unit.INSTANCE;
    }

    public static final Object writeInt(ByteWriteChannel byteWriteChannel, int i, ByteOrder byteOrder, Continuation<? super Unit> continuation) {
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1) {
            i = Integer.reverseBytes(i);
        }
        Object objWriteInt = byteWriteChannel.writeInt(i, continuation);
        return objWriteInt == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteInt : Unit.INSTANCE;
    }

    public static final Object writeLong(ByteWriteChannel byteWriteChannel, long j, ByteOrder byteOrder, Continuation<? super Unit> continuation) {
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1) {
            j = Long.reverseBytes(j);
        }
        Object objWriteLong = byteWriteChannel.writeLong(j, continuation);
        return objWriteLong == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteLong : Unit.INSTANCE;
    }

    public static final Object writeFloat(ByteWriteChannel byteWriteChannel, float f, ByteOrder byteOrder, Continuation<? super Unit> continuation) {
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1) {
            f = Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(f)));
        }
        Object objWriteFloat = byteWriteChannel.writeFloat(f, continuation);
        return objWriteFloat == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteFloat : Unit.INSTANCE;
    }

    public static final Object writeDouble(ByteWriteChannel byteWriteChannel, double d, ByteOrder byteOrder, Continuation<? super Unit> continuation) {
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1) {
            d = Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(d)));
        }
        Object objWriteDouble = byteWriteChannel.writeDouble(d, continuation);
        return objWriteDouble == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteDouble : Unit.INSTANCE;
    }

    public static final Object writeShortLittleEndian(ByteWriteChannel byteWriteChannel, short s, Continuation<? super Unit> continuation) {
        Object objWriteShort = byteWriteChannel.writeShort(Short.reverseBytes(s), continuation);
        return objWriteShort == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteShort : Unit.INSTANCE;
    }

    public static final Object writeIntLittleEndian(ByteWriteChannel byteWriteChannel, int i, Continuation<? super Unit> continuation) {
        Object objWriteInt = byteWriteChannel.writeInt(Integer.reverseBytes(i), continuation);
        return objWriteInt == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteInt : Unit.INSTANCE;
    }

    public static final Object writeLongLittleEndian(ByteWriteChannel byteWriteChannel, long j, Continuation<? super Unit> continuation) {
        Object objWriteLong = byteWriteChannel.writeLong(Long.reverseBytes(j), continuation);
        return objWriteLong == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteLong : Unit.INSTANCE;
    }

    public static final Object writeFloatLittleEndian(ByteWriteChannel byteWriteChannel, float f, Continuation<? super Unit> continuation) {
        Object objWriteFloat = byteWriteChannel.writeFloat(Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(f))), continuation);
        return objWriteFloat == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteFloat : Unit.INSTANCE;
    }

    public static final Object writeDoubleLittleEndian(ByteWriteChannel byteWriteChannel, double d, Continuation<? super Unit> continuation) {
        Object objWriteDouble = byteWriteChannel.writeDouble(Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(d))), continuation);
        return objWriteDouble == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteDouble : Unit.INSTANCE;
    }
}
