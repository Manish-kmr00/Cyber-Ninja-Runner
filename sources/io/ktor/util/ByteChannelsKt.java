package io.ktor.util;

import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteChannelKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelKt;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.CloseableJVMKt;
import io.ktor.utils.io.core.StringsKt;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: compiled from: ByteChannels.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u001a\u001a\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006\u001a\u001e\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t*\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b\u001a\u0015\u0010\f\u001a\u00020\r*\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"CHUNK_BUFFER_SIZE", "", "copyToBoth", "", "Lio/ktor/utils/io/ByteReadChannel;", "first", "Lio/ktor/utils/io/ByteWriteChannel;", "second", "split", "Lkotlin/Pair;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "toByteArray", "", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-utils"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ByteChannelsKt {
    private static final long CHUNK_BUFFER_SIZE = 4096;

    /* JADX INFO: renamed from: io.ktor.util.ByteChannelsKt$toByteArray$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteChannels.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.ByteChannelsKt", f = "ByteChannels.kt", i = {}, l = {91}, m = "toByteArray", n = {}, s = {})
    static final class C47411 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C47411(Continuation<? super C47411> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelsKt.toByteArray(null, this);
        }
    }

    public static final Pair<ByteReadChannel, ByteReadChannel> split(ByteReadChannel byteReadChannel, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        final ByteChannel ByteChannel = ByteChannelKt.ByteChannel(true);
        final ByteChannel ByteChannel2 = ByteChannelKt.ByteChannel(true);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C47391(byteReadChannel, ByteChannel, ByteChannel2, null), 3, null).invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: io.ktor.util.ByteChannelsKt.split.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                if (th == null) {
                    return;
                }
                ByteChannel.cancel(th);
                ByteChannel2.cancel(th);
            }
        });
        return TuplesKt.to(ByteChannel, ByteChannel2);
    }

    /* JADX INFO: renamed from: io.ktor.util.ByteChannelsKt$split$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteChannels.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.ByteChannelsKt$split$1", f = "ByteChannels.kt", i = {0, 0, 1, 1}, l = {27, 31}, m = "invokeSuspend", n = {"$this$launch", "buffer", "$this$launch", "buffer"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class C47391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ByteChannel $first;
        final /* synthetic */ ByteChannel $second;
        final /* synthetic */ ByteReadChannel $this_split;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C47391(ByteReadChannel byteReadChannel, ByteChannel byteChannel, ByteChannel byteChannel2, Continuation<? super C47391> continuation) {
            super(2, continuation);
            this.$this_split = byteReadChannel;
            this.$first = byteChannel;
            this.$second = byteChannel2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C47391 c47391 = new C47391(this.$this_split, this.$first, this.$second, continuation);
            c47391.L$0 = obj;
            return c47391;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C47391) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x004c A[Catch: all -> 0x0030, TryCatch #0 {all -> 0x0030, blocks: (B:7:0x0016, B:17:0x0044, B:19:0x004c, B:23:0x0060, B:27:0x00ac, B:31:0x00ca, B:12:0x002b), top: B:39:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:21:0x005d A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:22:0x005e  */
        /* JADX WARN: Code duplicated, block: B:25:0x00a9 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:26:0x00aa  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v5, types: [byte[], java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v6, types: [byte[], java.lang.Object] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00aa -> B:17:0x0044). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instruction units count: 252
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.ByteChannelsKt.C47391.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: io.ktor.util.ByteChannelsKt$split$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: ByteChannels.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "io.ktor.util.ByteChannelsKt$split$1$1", f = "ByteChannels.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
        static final class C07971 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ byte[] $buffer;
            final /* synthetic */ ByteChannel $first;
            final /* synthetic */ int $read;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C07971(ByteChannel byteChannel, byte[] bArr, int i, Continuation<? super C07971> continuation) {
                super(2, continuation);
                this.$first = byteChannel;
                this.$buffer = bArr;
                this.$read = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C07971(this.$first, this.$buffer, this.$read, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C07971) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (this.$first.writeFully(this.$buffer, 0, this.$read, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: io.ktor.util.ByteChannelsKt$split$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: ByteChannels.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "io.ktor.util.ByteChannelsKt$split$1$2", f = "ByteChannels.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ byte[] $buffer;
            final /* synthetic */ int $read;
            final /* synthetic */ ByteChannel $second;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(ByteChannel byteChannel, byte[] bArr, int i, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$second = byteChannel;
                this.$buffer = bArr;
                this.$read = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$second, this.$buffer, this.$read, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (this.$second.writeFully(this.$buffer, 0, this.$read, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: io.ktor.util.ByteChannelsKt$copyToBoth$1, reason: invalid class name */
    /* JADX INFO: compiled from: ByteChannels.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.ByteChannelsKt$copyToBoth$1", f = "ByteChannels.kt", i = {1, 1, 1, 2, 2}, l = {61, 63, 64}, m = "invokeSuspend", n = {"$this$use$iv", "it", "closed$iv", "$this$use$iv", "closed$iv"}, s = {"L$0", "L$4", "I$0", "L$0", "I$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ByteWriteChannel $first;
        final /* synthetic */ ByteWriteChannel $second;
        final /* synthetic */ ByteReadChannel $this_copyToBoth;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, ByteWriteChannel byteWriteChannel2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_copyToBoth = byteReadChannel;
            this.$first = byteWriteChannel;
            this.$second = byteWriteChannel2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$this_copyToBoth, this.$first, this.$second, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x006b A[Catch: all -> 0x005d, TryCatch #5 {all -> 0x005d, blocks: (B:44:0x00e4, B:24:0x0063, B:26:0x006b, B:28:0x0073, B:30:0x007b, B:33:0x0095, B:53:0x00f4, B:54:0x00f5, B:57:0x00fe, B:19:0x0059, B:51:0x00f2, B:50:0x00ef, B:47:0x00ea, B:34:0x009e, B:43:0x00d7), top: B:74:0x0059, inners: #1, #4 }] */
        /* JADX WARN: Code duplicated, block: B:37:0x00ba A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:40:0x00d3 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:56:0x00fd  */
        /* JADX WARN: Code duplicated, block: B:57:0x00fe A[Catch: all -> 0x005d, TRY_LEAVE, TryCatch #5 {all -> 0x005d, blocks: (B:44:0x00e4, B:24:0x0063, B:26:0x006b, B:28:0x0073, B:30:0x007b, B:33:0x0095, B:53:0x00f4, B:54:0x00f5, B:57:0x00fe, B:19:0x0059, B:51:0x00f2, B:50:0x00ef, B:47:0x00ea, B:34:0x009e, B:43:0x00d7), top: B:74:0x0059, inners: #1, #4 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00d1 -> B:41:0x00d4). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Throwable th;
            Closeable closeable;
            ByteWriteChannel byteWriteChannel;
            ByteWriteChannel byteWriteChannel2;
            ByteReadChannel byteReadChannel;
            ByteReadPacket byteReadPacket;
            int i;
            ByteReadPacket byteReadPacketCopy;
            ByteReadPacket byteReadPacketCopy2;
            Throwable closedCause;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.$this_copyToBoth.isClosedForRead()) {
                }
                closedCause = this.$this_copyToBoth.getClosedCause();
                if (closedCause == null) {
                    return Unit.INSTANCE;
                }
                throw closedCause;
            }
            if (i2 == 1) {
                try {
                    ResultKt.throwOnFailure(obj);
                    closeable = (Closeable) obj;
                    byteWriteChannel = this.$first;
                    byteWriteChannel2 = this.$second;
                    byteReadChannel = this.$this_copyToBoth;
                    byteReadPacket = (ByteReadPacket) closeable;
                    byteReadPacketCopy2 = byteReadPacket.copy();
                    this.L$0 = closeable;
                    this.L$1 = byteWriteChannel;
                    this.L$2 = byteWriteChannel2;
                    this.L$3 = byteReadChannel;
                    this.L$4 = byteReadPacket;
                    i = 0;
                    this.I$0 = 0;
                    this.label = 2;
                    if (byteWriteChannel.writePacket(byteReadPacketCopy2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    byteReadPacketCopy = byteReadPacket.copy();
                    this.L$0 = closeable;
                    this.L$1 = byteWriteChannel;
                    this.L$2 = byteWriteChannel2;
                    this.L$3 = byteReadChannel;
                    this.L$4 = null;
                    this.I$0 = i;
                    this.label = 3;
                    if (byteWriteChannel2.writePacket(byteReadPacketCopy, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Unit unit = Unit.INSTANCE;
                    closeable.close();
                    if (this.$this_copyToBoth.isClosedForRead()) {
                    }
                    closedCause = this.$this_copyToBoth.getClosedCause();
                    if (closedCause == null) {
                        return Unit.INSTANCE;
                    }
                    throw closedCause;
                } catch (Throwable th2) {
                    try {
                        this.$first.close(th2);
                        this.$second.close(th2);
                    } finally {
                        ByteWriteChannelKt.close(this.$first);
                        ByteWriteChannelKt.close(this.$second);
                    }
                }
            } else {
                if (i2 == 2) {
                    int i3 = this.I$0;
                    ByteReadPacket byteReadPacket2 = (ByteReadPacket) this.L$4;
                    ByteReadChannel byteReadChannel2 = (ByteReadChannel) this.L$3;
                    ByteWriteChannel byteWriteChannel3 = (ByteWriteChannel) this.L$2;
                    ByteWriteChannel byteWriteChannel4 = (ByteWriteChannel) this.L$1;
                    Closeable closeable2 = (Closeable) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        byteReadPacket = byteReadPacket2;
                        byteWriteChannel2 = byteWriteChannel3;
                        closeable = closeable2;
                        i = i3;
                        byteReadChannel = byteReadChannel2;
                        byteWriteChannel = byteWriteChannel4;
                    } catch (Throwable th3) {
                        th = th3;
                        byteReadChannel = byteReadChannel2;
                        byteWriteChannel2 = byteWriteChannel3;
                        byteWriteChannel = byteWriteChannel4;
                        closeable = closeable2;
                        byteReadChannel.cancel(th);
                        byteWriteChannel.close(th);
                        Boxing.boxBoolean(byteWriteChannel2.close(th));
                        closeable.close();
                        if (this.$this_copyToBoth.isClosedForRead()) {
                        }
                        closedCause = this.$this_copyToBoth.getClosedCause();
                        if (closedCause == null) {
                            return Unit.INSTANCE;
                        }
                        throw closedCause;
                    }
                    byteReadPacketCopy = byteReadPacket.copy();
                    this.L$0 = closeable;
                    this.L$1 = byteWriteChannel;
                    this.L$2 = byteWriteChannel2;
                    this.L$3 = byteReadChannel;
                    this.L$4 = null;
                    this.I$0 = i;
                    this.label = 3;
                    if (byteWriteChannel2.writePacket(byteReadPacketCopy, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    byteReadChannel = (ByteReadChannel) this.L$3;
                    byteWriteChannel2 = (ByteWriteChannel) this.L$2;
                    byteWriteChannel = (ByteWriteChannel) this.L$1;
                    closeable = (Closeable) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th4) {
                        th = th4;
                        byteReadChannel.cancel(th);
                        byteWriteChannel.close(th);
                        Boxing.boxBoolean(byteWriteChannel2.close(th));
                        closeable.close();
                        if (this.$this_copyToBoth.isClosedForRead()) {
                        }
                        closedCause = this.$this_copyToBoth.getClosedCause();
                        if (closedCause == null) {
                            return Unit.INSTANCE;
                        }
                        throw closedCause;
                    }
                }
                Unit unit2 = Unit.INSTANCE;
                closeable.close();
                if (this.$this_copyToBoth.isClosedForRead() && (!this.$first.isClosedForWrite() || !this.$second.isClosedForWrite())) {
                    try {
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.L$4 = null;
                        this.label = 1;
                        obj = this.$this_copyToBoth.readRemaining(4096L, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        closeable = (Closeable) obj;
                        byteWriteChannel = this.$first;
                        byteWriteChannel2 = this.$second;
                        byteReadChannel = this.$this_copyToBoth;
                        byteReadPacket = (ByteReadPacket) closeable;
                        byteReadPacketCopy2 = byteReadPacket.copy();
                        this.L$0 = closeable;
                        this.L$1 = byteWriteChannel;
                        this.L$2 = byteWriteChannel2;
                        this.L$3 = byteReadChannel;
                        this.L$4 = byteReadPacket;
                        i = 0;
                        this.I$0 = 0;
                        this.label = 2;
                        if (byteWriteChannel.writePacket(byteReadPacketCopy2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        byteReadPacketCopy = byteReadPacket.copy();
                        this.L$0 = closeable;
                        this.L$1 = byteWriteChannel;
                        this.L$2 = byteWriteChannel2;
                        this.L$3 = byteReadChannel;
                        this.L$4 = null;
                        this.I$0 = i;
                        this.label = 3;
                        if (byteWriteChannel2.writePacket(byteReadPacketCopy, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Unit unit3 = Unit.INSTANCE;
                        closeable.close();
                        if (this.$this_copyToBoth.isClosedForRead()) {
                        }
                        closedCause = this.$this_copyToBoth.getClosedCause();
                        if (closedCause == null) {
                            return Unit.INSTANCE;
                        }
                        throw closedCause;
                    } catch (Throwable th5) {
                        try {
                            closeable.close();
                        } catch (Throwable th6) {
                            CloseableJVMKt.addSuppressedInternal(th5, th6);
                        }
                        throw th5;
                    }
                }
                closedCause = this.$this_copyToBoth.getClosedCause();
                if (closedCause == null) {
                    return Unit.INSTANCE;
                }
                throw closedCause;
            }
        }
    }

    public static final void copyToBoth(ByteReadChannel byteReadChannel, final ByteWriteChannel first, final ByteWriteChannel second) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getUnconfined(), null, new AnonymousClass1(byteReadChannel, first, second, null), 2, null).invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: io.ktor.util.ByteChannelsKt.copyToBoth.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                if (th == null) {
                    return;
                }
                first.close(th);
                second.close(th);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object toByteArray(ByteReadChannel byteReadChannel, Continuation<? super byte[]> continuation) throws Throwable {
        C47411 c47411;
        if (continuation instanceof C47411) {
            c47411 = (C47411) continuation;
            if ((c47411.label & Integer.MIN_VALUE) != 0) {
                c47411.label -= Integer.MIN_VALUE;
            } else {
                c47411 = new C47411(continuation);
            }
        } else {
            c47411 = new C47411(continuation);
        }
        C47411 c47412 = c47411;
        Object remaining$default = c47412.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c47412.label;
        if (i == 0) {
            ResultKt.throwOnFailure(remaining$default);
            c47412.label = 1;
            remaining$default = ByteReadChannel.DefaultImpls.readRemaining$default(byteReadChannel, 0L, c47412, 1, null);
            if (remaining$default == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(remaining$default);
        }
        return StringsKt.readBytes$default((ByteReadPacket) remaining$default, 0, 1, null);
    }
}
