package io.ktor.websocket;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.safedk.android.analytics.brandsafety.l;
import com.vungle.ads.internal.protos.Sdk;
import io.ktor.util.InternalAPI;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.bits.DefaultAllocator;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.ByteReadPacketExtensionsKt;
import io.ktor.utils.io.core.StringsKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* JADX INFO: compiled from: RawWebSocketCommon.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a%\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a%\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"mask", "Lio/ktor/utils/io/core/ByteReadPacket;", "maskKey", "", "readFrame", "Lio/ktor/websocket/Frame;", "Lio/ktor/utils/io/ByteReadChannel;", "maxFrameSize", "", "lastOpcode", "(Lio/ktor/utils/io/ByteReadChannel;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFrame", "", "Lio/ktor/utils/io/ByteWriteChannel;", TypedValues.AttributesType.S_FRAME, "masking", "", "(Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/websocket/Frame;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-websockets"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RawWebSocketCommonKt {

    /* JADX INFO: renamed from: io.ktor.websocket.RawWebSocketCommonKt$readFrame$1, reason: invalid class name */
    /* JADX INFO: compiled from: RawWebSocketCommon.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.RawWebSocketCommonKt", f = "RawWebSocketCommon.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5}, l = {212, Sdk.SDKError.Reason.INVALID_ADUNIT_BID_PAYLOAD_VALUE, 232, 233, 241, 249}, m = "readFrame", n = {"$this$readFrame", "maxFrameSize", "lastOpcode", "$this$readFrame", "maxFrameSize", "lastOpcode", "flagsAndOpcode", "$this$readFrame", "frameType", "maxFrameSize", "flagsAndOpcode", "maskAndLength", l.Y, "$this$readFrame", "frameType", "maxFrameSize", "flagsAndOpcode", "maskAndLength", l.Y, "$this$readFrame", "frameType", "maxFrameSize", "flagsAndOpcode", l.Y, SessionDescription.ATTR_LENGTH, "frameType", "flagsAndOpcode", l.Y, "maskKey"}, s = {"L$0", "J$0", "I$0", "L$0", "J$0", "I$0", "B$0", "L$0", "L$1", "J$0", "B$0", "B$1", "I$0", "L$0", "L$1", "J$0", "B$0", "B$1", "I$0", "L$0", "L$1", "J$0", "B$0", "I$0", "J$1", "L$0", "B$0", "I$0", "I$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        byte B$0;
        byte B$1;
        int I$0;
        int I$1;
        long J$0;
        long J$1;
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
            return RawWebSocketCommonKt.readFrame(null, 0L, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.websocket.RawWebSocketCommonKt$writeFrame$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RawWebSocketCommon.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.RawWebSocketCommonKt", f = "RawWebSocketCommon.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4}, l = {174, 184, 187, 188, 196, 201}, m = "writeFrame", n = {"$this$writeFrame", TypedValues.AttributesType.S_FRAME, "masking", SessionDescription.ATTR_LENGTH, "$this$writeFrame", TypedValues.AttributesType.S_FRAME, "masking", SessionDescription.ATTR_LENGTH, "formattedLength", "$this$writeFrame", TypedValues.AttributesType.S_FRAME, "masking", "$this$writeFrame", TypedValues.AttributesType.S_FRAME, "masking", "$this$writeFrame", "data", "maskKey"}, s = {"L$0", "L$1", "Z$0", "I$0", "L$0", "L$1", "Z$0", "I$0", "I$1", "L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "I$0"})
    static final class C48591 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C48591(Continuation<? super C48591> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RawWebSocketCommonKt.writeFrame(null, null, false, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:39:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:42:0x00da  */
    /* JADX WARN: Code duplicated, block: B:45:0x00de  */
    /* JADX WARN: Code duplicated, block: B:48:0x00f4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:49:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:51:0x00fb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:55:0x010e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:56:0x010f  */
    /* JADX WARN: Code duplicated, block: B:58:0x011f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:61:0x0126 A[PHI: r2 r5 r12
  0x0126: PHI (r2v22 io.ktor.websocket.Frame) = (r2v19 io.ktor.websocket.Frame), (r2v23 io.ktor.websocket.Frame) binds: [B:51:0x00fb, B:60:0x0123] A[DONT_GENERATE, DONT_INLINE]
  0x0126: PHI (r5v10 io.ktor.utils.io.ByteWriteChannel) = (r5v7 io.ktor.utils.io.ByteWriteChannel), (r5v11 io.ktor.utils.io.ByteWriteChannel) binds: [B:51:0x00fb, B:60:0x0123] A[DONT_GENERATE, DONT_INLINE]
  0x0126: PHI (r12v9 boolean) = (r12v6 boolean), (r12v14 boolean) binds: [B:51:0x00fb, B:60:0x0123] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:63:0x0141  */
    /* JADX WARN: Code duplicated, block: B:65:0x0156 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:66:0x0157  */
    /* JADX WARN: Code duplicated, block: B:68:0x015e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:71:0x016e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:74:0x0172  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @InternalAPI
    public static final Object writeFrame(ByteWriteChannel byteWriteChannel, Frame frame, boolean z, Continuation<? super Unit> continuation) throws Throwable {
        C48591 c48591;
        Frame frame2;
        int i;
        boolean z2;
        int i2;
        int i3;
        ByteWriteChannel byteWriteChannel2;
        int i4;
        Frame frame3;
        boolean z3;
        boolean z4;
        Frame frame4;
        ByteWriteChannel byteWriteChannel3;
        ByteReadPacket ByteReadPacket;
        int iNextInt;
        ByteWriteChannel byteWriteChannel4;
        if (continuation instanceof C48591) {
            c48591 = (C48591) continuation;
            if ((c48591.label & Integer.MIN_VALUE) != 0) {
                c48591.label -= Integer.MIN_VALUE;
            } else {
                c48591 = new C48591(continuation);
            }
        } else {
            c48591 = new C48591(continuation);
        }
        Object obj = c48591.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c48591.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                int length = frame.getData().length;
                byte opcode = (byte) ((frame.getFin() ? 128 : 0) | (frame.getRsv1() ? 64 : 0) | (frame.getRsv2() ? 32 : 0) | (frame.getRsv3() ? 16 : 0) | frame.getFrameType().getOpcode());
                c48591.L$0 = byteWriteChannel;
                c48591.L$1 = frame;
                c48591.Z$0 = z;
                c48591.I$0 = length;
                c48591.label = 1;
                if (byteWriteChannel.writeByte(opcode, c48591) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                frame2 = frame;
                i = length;
                z2 = z;
                if (i < 126) {
                    i2 = i;
                } else if (i <= 65535) {
                    i2 = 126;
                } else {
                    i2 = 127;
                }
                i3 = z2 ? 128 : 0;
                c48591.L$0 = byteWriteChannel;
                c48591.L$1 = frame2;
                c48591.Z$0 = z2;
                c48591.I$0 = i;
                c48591.I$1 = i2;
                c48591.label = 2;
                if (byteWriteChannel.writeByte((byte) (i3 | i2), c48591) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                byteWriteChannel2 = byteWriteChannel;
                i4 = i2;
                frame3 = frame2;
                z3 = z2;
                if (i4 == 126) {
                    c48591.L$0 = byteWriteChannel2;
                    c48591.L$1 = frame3;
                    c48591.Z$0 = z3;
                    c48591.label = 3;
                    if (byteWriteChannel2.writeShort((short) i, c48591) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i4 == 127) {
                        c48591.L$0 = byteWriteChannel2;
                        c48591.L$1 = frame3;
                        c48591.Z$0 = z3;
                        c48591.label = 4;
                        if (byteWriteChannel2.writeLong(i, c48591) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        final byte[] data = frame3.getData();
                        ByteBuffer byteBufferWrap = ByteBuffer.wrap(data, 0, data.length);
                        Intrinsics.checkNotNullExpressionValue(byteBufferWrap, "wrap(array, offset, length)");
                        ByteReadPacket = ByteReadPacketExtensionsKt.ByteReadPacket(byteBufferWrap, new Function1<ByteBuffer, Unit>() { // from class: io.ktor.websocket.RawWebSocketCommonKt$writeFrame$$inlined$ByteReadPacket$default$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(ByteBuffer it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ByteBuffer byteBuffer) {
                                invoke2(byteBuffer);
                                return Unit.INSTANCE;
                            }
                        });
                        if (z3) {
                            iNextInt = Random.INSTANCE.nextInt();
                            c48591.L$0 = byteWriteChannel2;
                            c48591.L$1 = ByteReadPacket;
                            c48591.I$0 = iNextInt;
                            c48591.label = 5;
                            if (byteWriteChannel2.writeInt(iNextInt, c48591) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            byteWriteChannel4 = byteWriteChannel2;
                            ByteReadPacket = mask(ByteReadPacket, iNextInt);
                            byteWriteChannel2 = byteWriteChannel4;
                        } else if (z3) {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    c48591.L$0 = null;
                    c48591.L$1 = null;
                    c48591.label = 6;
                    if (byteWriteChannel2.writePacket(ByteReadPacket, c48591) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                z4 = z3;
                frame4 = frame3;
                byteWriteChannel3 = byteWriteChannel2;
                frame3 = frame4;
                byteWriteChannel2 = byteWriteChannel3;
                z3 = z4;
                final byte[] data2 = frame3.getData();
                ByteBuffer byteBufferWrap2 = ByteBuffer.wrap(data2, 0, data2.length);
                Intrinsics.checkNotNullExpressionValue(byteBufferWrap2, "wrap(array, offset, length)");
                ByteReadPacket = ByteReadPacketExtensionsKt.ByteReadPacket(byteBufferWrap2, new Function1<ByteBuffer, Unit>() { // from class: io.ktor.websocket.RawWebSocketCommonKt$writeFrame$$inlined$ByteReadPacket$default$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ByteBuffer it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ByteBuffer byteBuffer) {
                        invoke2(byteBuffer);
                        return Unit.INSTANCE;
                    }
                });
                if (z3) {
                    iNextInt = Random.INSTANCE.nextInt();
                    c48591.L$0 = byteWriteChannel2;
                    c48591.L$1 = ByteReadPacket;
                    c48591.I$0 = iNextInt;
                    c48591.label = 5;
                    if (byteWriteChannel2.writeInt(iNextInt, c48591) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    byteWriteChannel4 = byteWriteChannel2;
                    ByteReadPacket = mask(ByteReadPacket, iNextInt);
                    byteWriteChannel2 = byteWriteChannel4;
                } else if (z3) {
                    throw new NoWhenBranchMatchedException();
                }
                c48591.L$0 = null;
                c48591.L$1 = null;
                c48591.label = 6;
                if (byteWriteChannel2.writePacket(ByteReadPacket, c48591) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                int i5 = c48591.I$0;
                boolean z5 = c48591.Z$0;
                Frame frame5 = (Frame) c48591.L$1;
                ByteWriteChannel byteWriteChannel5 = (ByteWriteChannel) c48591.L$0;
                ResultKt.throwOnFailure(obj);
                z2 = z5;
                frame2 = frame5;
                i = i5;
                byteWriteChannel = byteWriteChannel5;
                if (i < 126) {
                    i2 = i;
                } else if (i <= 65535) {
                    i2 = 126;
                } else {
                    i2 = 127;
                }
                if (z2) {
                }
                c48591.L$0 = byteWriteChannel;
                c48591.L$1 = frame2;
                c48591.Z$0 = z2;
                c48591.I$0 = i;
                c48591.I$1 = i2;
                c48591.label = 2;
                if (byteWriteChannel.writeByte((byte) (i3 | i2), c48591) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                byteWriteChannel2 = byteWriteChannel;
                i4 = i2;
                frame3 = frame2;
                z3 = z2;
                if (i4 == 126) {
                    c48591.L$0 = byteWriteChannel2;
                    c48591.L$1 = frame3;
                    c48591.Z$0 = z3;
                    c48591.label = 3;
                    if (byteWriteChannel2.writeShort((short) i, c48591) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i4 == 127) {
                        c48591.L$0 = byteWriteChannel2;
                        c48591.L$1 = frame3;
                        c48591.Z$0 = z3;
                        c48591.label = 4;
                        if (byteWriteChannel2.writeLong(i, c48591) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        final byte[] data3 = frame3.getData();
                        ByteBuffer byteBufferWrap3 = ByteBuffer.wrap(data3, 0, data3.length);
                        Intrinsics.checkNotNullExpressionValue(byteBufferWrap3, "wrap(array, offset, length)");
                        ByteReadPacket = ByteReadPacketExtensionsKt.ByteReadPacket(byteBufferWrap3, new Function1<ByteBuffer, Unit>() { // from class: io.ktor.websocket.RawWebSocketCommonKt$writeFrame$$inlined$ByteReadPacket$default$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(ByteBuffer it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ByteBuffer byteBuffer) {
                                invoke2(byteBuffer);
                                return Unit.INSTANCE;
                            }
                        });
                        if (z3) {
                            iNextInt = Random.INSTANCE.nextInt();
                            c48591.L$0 = byteWriteChannel2;
                            c48591.L$1 = ByteReadPacket;
                            c48591.I$0 = iNextInt;
                            c48591.label = 5;
                            if (byteWriteChannel2.writeInt(iNextInt, c48591) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            byteWriteChannel4 = byteWriteChannel2;
                            ByteReadPacket = mask(ByteReadPacket, iNextInt);
                            byteWriteChannel2 = byteWriteChannel4;
                        } else if (z3) {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    c48591.L$0 = null;
                    c48591.L$1 = null;
                    c48591.label = 6;
                    if (byteWriteChannel2.writePacket(ByteReadPacket, c48591) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                z4 = z3;
                frame4 = frame3;
                byteWriteChannel3 = byteWriteChannel2;
                frame3 = frame4;
                byteWriteChannel2 = byteWriteChannel3;
                z3 = z4;
                final byte[] data4 = frame3.getData();
                ByteBuffer byteBufferWrap4 = ByteBuffer.wrap(data4, 0, data4.length);
                Intrinsics.checkNotNullExpressionValue(byteBufferWrap4, "wrap(array, offset, length)");
                ByteReadPacket = ByteReadPacketExtensionsKt.ByteReadPacket(byteBufferWrap4, new Function1<ByteBuffer, Unit>() { // from class: io.ktor.websocket.RawWebSocketCommonKt$writeFrame$$inlined$ByteReadPacket$default$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ByteBuffer it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ByteBuffer byteBuffer) {
                        invoke2(byteBuffer);
                        return Unit.INSTANCE;
                    }
                });
                if (z3) {
                    iNextInt = Random.INSTANCE.nextInt();
                    c48591.L$0 = byteWriteChannel2;
                    c48591.L$1 = ByteReadPacket;
                    c48591.I$0 = iNextInt;
                    c48591.label = 5;
                    if (byteWriteChannel2.writeInt(iNextInt, c48591) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    byteWriteChannel4 = byteWriteChannel2;
                    ByteReadPacket = mask(ByteReadPacket, iNextInt);
                    byteWriteChannel2 = byteWriteChannel4;
                } else if (z3) {
                    throw new NoWhenBranchMatchedException();
                }
                c48591.L$0 = null;
                c48591.L$1 = null;
                c48591.label = 6;
                if (byteWriteChannel2.writePacket(ByteReadPacket, c48591) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 2:
                i4 = c48591.I$1;
                i = c48591.I$0;
                z3 = c48591.Z$0;
                frame3 = (Frame) c48591.L$1;
                byteWriteChannel2 = (ByteWriteChannel) c48591.L$0;
                ResultKt.throwOnFailure(obj);
                if (i4 == 126) {
                    c48591.L$0 = byteWriteChannel2;
                    c48591.L$1 = frame3;
                    c48591.Z$0 = z3;
                    c48591.label = 3;
                    if (byteWriteChannel2.writeShort((short) i, c48591) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i4 == 127) {
                        c48591.L$0 = byteWriteChannel2;
                        c48591.L$1 = frame3;
                        c48591.Z$0 = z3;
                        c48591.label = 4;
                        if (byteWriteChannel2.writeLong(i, c48591) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        final byte[] data5 = frame3.getData();
                        ByteBuffer byteBufferWrap5 = ByteBuffer.wrap(data5, 0, data5.length);
                        Intrinsics.checkNotNullExpressionValue(byteBufferWrap5, "wrap(array, offset, length)");
                        ByteReadPacket = ByteReadPacketExtensionsKt.ByteReadPacket(byteBufferWrap5, new Function1<ByteBuffer, Unit>() { // from class: io.ktor.websocket.RawWebSocketCommonKt$writeFrame$$inlined$ByteReadPacket$default$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(ByteBuffer it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ByteBuffer byteBuffer) {
                                invoke2(byteBuffer);
                                return Unit.INSTANCE;
                            }
                        });
                        if (z3) {
                            iNextInt = Random.INSTANCE.nextInt();
                            c48591.L$0 = byteWriteChannel2;
                            c48591.L$1 = ByteReadPacket;
                            c48591.I$0 = iNextInt;
                            c48591.label = 5;
                            if (byteWriteChannel2.writeInt(iNextInt, c48591) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            byteWriteChannel4 = byteWriteChannel2;
                            ByteReadPacket = mask(ByteReadPacket, iNextInt);
                            byteWriteChannel2 = byteWriteChannel4;
                        } else if (z3) {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    c48591.L$0 = null;
                    c48591.L$1 = null;
                    c48591.label = 6;
                    if (byteWriteChannel2.writePacket(ByteReadPacket, c48591) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                z4 = z3;
                frame4 = frame3;
                byteWriteChannel3 = byteWriteChannel2;
                frame3 = frame4;
                byteWriteChannel2 = byteWriteChannel3;
                z3 = z4;
                final byte[] data6 = frame3.getData();
                ByteBuffer byteBufferWrap6 = ByteBuffer.wrap(data6, 0, data6.length);
                Intrinsics.checkNotNullExpressionValue(byteBufferWrap6, "wrap(array, offset, length)");
                ByteReadPacket = ByteReadPacketExtensionsKt.ByteReadPacket(byteBufferWrap6, new Function1<ByteBuffer, Unit>() { // from class: io.ktor.websocket.RawWebSocketCommonKt$writeFrame$$inlined$ByteReadPacket$default$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ByteBuffer it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ByteBuffer byteBuffer) {
                        invoke2(byteBuffer);
                        return Unit.INSTANCE;
                    }
                });
                if (z3) {
                    iNextInt = Random.INSTANCE.nextInt();
                    c48591.L$0 = byteWriteChannel2;
                    c48591.L$1 = ByteReadPacket;
                    c48591.I$0 = iNextInt;
                    c48591.label = 5;
                    if (byteWriteChannel2.writeInt(iNextInt, c48591) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    byteWriteChannel4 = byteWriteChannel2;
                    ByteReadPacket = mask(ByteReadPacket, iNextInt);
                    byteWriteChannel2 = byteWriteChannel4;
                } else if (z3) {
                    throw new NoWhenBranchMatchedException();
                }
                c48591.L$0 = null;
                c48591.L$1 = null;
                c48591.label = 6;
                if (byteWriteChannel2.writePacket(ByteReadPacket, c48591) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 3:
            case 4:
                z4 = c48591.Z$0;
                frame4 = (Frame) c48591.L$1;
                byteWriteChannel3 = (ByteWriteChannel) c48591.L$0;
                ResultKt.throwOnFailure(obj);
                frame3 = frame4;
                byteWriteChannel2 = byteWriteChannel3;
                z3 = z4;
                final byte[] data7 = frame3.getData();
                ByteBuffer byteBufferWrap7 = ByteBuffer.wrap(data7, 0, data7.length);
                Intrinsics.checkNotNullExpressionValue(byteBufferWrap7, "wrap(array, offset, length)");
                ByteReadPacket = ByteReadPacketExtensionsKt.ByteReadPacket(byteBufferWrap7, new Function1<ByteBuffer, Unit>() { // from class: io.ktor.websocket.RawWebSocketCommonKt$writeFrame$$inlined$ByteReadPacket$default$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ByteBuffer it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ByteBuffer byteBuffer) {
                        invoke2(byteBuffer);
                        return Unit.INSTANCE;
                    }
                });
                if (z3) {
                    iNextInt = Random.INSTANCE.nextInt();
                    c48591.L$0 = byteWriteChannel2;
                    c48591.L$1 = ByteReadPacket;
                    c48591.I$0 = iNextInt;
                    c48591.label = 5;
                    if (byteWriteChannel2.writeInt(iNextInt, c48591) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    byteWriteChannel4 = byteWriteChannel2;
                    ByteReadPacket = mask(ByteReadPacket, iNextInt);
                    byteWriteChannel2 = byteWriteChannel4;
                } else if (z3) {
                    throw new NoWhenBranchMatchedException();
                }
                c48591.L$0 = null;
                c48591.L$1 = null;
                c48591.label = 6;
                if (byteWriteChannel2.writePacket(ByteReadPacket, c48591) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 5:
                iNextInt = c48591.I$0;
                ByteReadPacket = (ByteReadPacket) c48591.L$1;
                byteWriteChannel4 = (ByteWriteChannel) c48591.L$0;
                ResultKt.throwOnFailure(obj);
                ByteReadPacket = mask(ByteReadPacket, iNextInt);
                byteWriteChannel2 = byteWriteChannel4;
                c48591.L$0 = null;
                c48591.L$1 = null;
                c48591.label = 6;
                if (byteWriteChannel2.writePacket(ByteReadPacket, c48591) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 6:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0209  */
    /* JADX WARN: Code duplicated, block: B:103:0x020d  */
    /* JADX WARN: Code duplicated, block: B:106:0x0218  */
    /* JADX WARN: Code duplicated, block: B:107:0x021b  */
    /* JADX WARN: Code duplicated, block: B:110:0x0221  */
    /* JADX WARN: Code duplicated, block: B:111:0x0224  */
    /* JADX WARN: Code duplicated, block: B:114:0x022a  */
    /* JADX WARN: Code duplicated, block: B:115:0x022d  */
    /* JADX WARN: Code duplicated, block: B:120:0x023a  */
    /* JADX WARN: Code duplicated, block: B:122:0x0240  */
    /* JADX WARN: Code duplicated, block: B:23:0x00d2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:27:0x00e5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:32:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:33:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:36:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ff A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:45:0x0114  */
    /* JADX WARN: Code duplicated, block: B:46:0x0116  */
    /* JADX WARN: Code duplicated, block: B:49:0x011d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:55:0x012e  */
    /* JADX WARN: Code duplicated, block: B:57:0x0132  */
    /* JADX WARN: Code duplicated, block: B:58:0x013c  */
    /* JADX WARN: Code duplicated, block: B:60:0x0151 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:61:0x0152  */
    /* JADX WARN: Code duplicated, block: B:63:0x0160  */
    /* JADX WARN: Code duplicated, block: B:65:0x0175 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:66:0x0176  */
    /* JADX WARN: Code duplicated, block: B:71:0x0195  */
    /* JADX WARN: Code duplicated, block: B:78:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:79:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:81:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:83:0x01c2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:84:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:86:0x01d4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:90:0x01de  */
    /* JADX WARN: Code duplicated, block: B:99:0x0201  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @InternalAPI
    public static final Object readFrame(ByteReadChannel byteReadChannel, long j, int i, Continuation<? super Frame> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        long j2;
        int i2;
        Object obj;
        byte bByteValue;
        Object obj2;
        ByteReadChannel byteReadChannel2;
        int i3;
        long j3;
        byte b;
        byte bByteValue2;
        int i4;
        int i5;
        FrameType frameType;
        int i6;
        int i7;
        Object obj3;
        FrameType frameType2;
        byte b2;
        int i8;
        Object obj4;
        byte b3;
        long j4;
        long j5;
        ByteReadChannel byteReadChannel3;
        FrameType frameType3;
        long jShortValue;
        boolean z;
        int i9;
        Object obj5;
        int i10;
        int i11;
        FrameType frameType4;
        ByteReadPacket byteReadPacketMask;
        int i12;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        ByteReadChannel byteReadChannel4 = byteReadChannel;
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
        Object obj6 = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anonymousClass1.label) {
            case 0:
                ResultKt.throwOnFailure(obj6);
                anonymousClass1.L$0 = byteReadChannel4;
                j2 = j;
                anonymousClass1.J$0 = j2;
                i2 = i;
                anonymousClass1.I$0 = i2;
                anonymousClass1.label = 1;
                obj = byteReadChannel4.readByte(anonymousClass1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                bByteValue = ((Number) obj).byteValue();
                anonymousClass1.L$0 = byteReadChannel4;
                anonymousClass1.J$0 = j2;
                anonymousClass1.I$0 = i2;
                anonymousClass1.B$0 = bByteValue;
                anonymousClass1.label = 2;
                obj2 = byteReadChannel4.readByte(anonymousClass1);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                byteReadChannel2 = byteReadChannel4;
                i3 = i2;
                obj6 = obj2;
                j3 = j2;
                b = bByteValue;
                bByteValue2 = ((Number) obj6).byteValue();
                i4 = b & Ascii.SI;
                if (i4 != 0 && i3 == 0) {
                    throw new ProtocolViolationException("Can't continue finished frames");
                }
                if (i4 == 0) {
                    i5 = i3;
                } else {
                    i5 = i4;
                }
                frameType = FrameType.INSTANCE.get(i5);
                if (frameType == null) {
                    throw new IllegalStateException("Unsupported opcode: " + i5);
                }
                if (i4 == 0 && i3 != 0 && !frameType.getControlFrame()) {
                    throw new ProtocolViolationException("Can't start new data frame before finishing previous one");
                }
                if ((b & 128) != 0) {
                    i6 = 1;
                } else {
                    i6 = 0;
                }
                if (!frameType.getControlFrame() && i6 == 0) {
                    throw new ProtocolViolationException("control frames can't be fragmented");
                }
                i7 = bByteValue2 & 127;
                if (i7 == 126) {
                    anonymousClass1.L$0 = byteReadChannel2;
                    anonymousClass1.L$1 = frameType;
                    anonymousClass1.J$0 = j3;
                    anonymousClass1.B$0 = b;
                    anonymousClass1.B$1 = bByteValue2;
                    anonymousClass1.I$0 = i6;
                    anonymousClass1.label = 3;
                    obj3 = byteReadChannel2.readShort(anonymousClass1);
                    if (obj3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    frameType2 = frameType;
                    b2 = bByteValue2;
                    i8 = i6;
                    obj6 = obj3;
                    jShortValue = ((long) ((Number) obj6).shortValue()) & 65535;
                    i6 = i8;
                    bByteValue2 = b2;
                    b3 = b;
                    byteReadChannel3 = byteReadChannel2;
                    frameType3 = frameType2;
                    j4 = j3;
                    j5 = jShortValue;
                } else if (i7 != 127) {
                    long j6 = i7;
                    b3 = b;
                    j4 = j3;
                    j5 = j6;
                    byteReadChannel3 = byteReadChannel2;
                    frameType3 = frameType;
                } else {
                    anonymousClass1.L$0 = byteReadChannel2;
                    anonymousClass1.L$1 = frameType;
                    anonymousClass1.J$0 = j3;
                    anonymousClass1.B$0 = b;
                    anonymousClass1.B$1 = bByteValue2;
                    anonymousClass1.I$0 = i6;
                    anonymousClass1.label = 4;
                    obj4 = byteReadChannel2.readLong(anonymousClass1);
                    if (obj4 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    frameType2 = frameType;
                    b2 = bByteValue2;
                    i8 = i6;
                    obj6 = obj4;
                    jShortValue = ((Number) obj6).longValue();
                    i6 = i8;
                    bByteValue2 = b2;
                    b3 = b;
                    byteReadChannel3 = byteReadChannel2;
                    frameType3 = frameType2;
                    j4 = j3;
                    j5 = jShortValue;
                }
                if (!frameType3.getControlFrame() && j5 > 125) {
                    throw new ProtocolViolationException("control frames can't be larger than 125 bytes");
                }
                if ((bByteValue2 & 128) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    anonymousClass1.L$0 = byteReadChannel3;
                    anonymousClass1.L$1 = frameType3;
                    anonymousClass1.J$0 = j4;
                    anonymousClass1.B$0 = b3;
                    anonymousClass1.I$0 = i6;
                    anonymousClass1.J$1 = j5;
                    anonymousClass1.label = 5;
                    obj5 = byteReadChannel3.readInt(anonymousClass1);
                    if (obj5 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    int i13 = i6;
                    obj6 = obj5;
                    i10 = i13;
                    int iIntValue = ((Number) obj6).intValue();
                    i6 = i10;
                    i9 = iIntValue;
                } else {
                    if (z) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i9 = -1;
                }
                if (j5 <= 2147483647L || j5 > j4) {
                    throw new FrameTooBigException(j5);
                }
                anonymousClass1.L$0 = frameType3;
                anonymousClass1.L$1 = null;
                anonymousClass1.B$0 = b3;
                anonymousClass1.I$0 = i6;
                anonymousClass1.I$1 = i9;
                anonymousClass1.label = 6;
                Object packet = byteReadChannel3.readPacket((int) j5, anonymousClass1);
                if (packet == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i11 = i6;
                obj6 = packet;
                frameType4 = frameType3;
                byteReadPacketMask = (ByteReadPacket) obj6;
                if (i9 != -1) {
                    byteReadPacketMask = mask(byteReadPacketMask, i9);
                }
                Frame.Companion companion = Frame.INSTANCE;
                if (i11 != 0) {
                    z2 = true;
                    i12 = 0;
                } else {
                    i12 = 0;
                    z2 = false;
                }
                byte[] bytes$default = StringsKt.readBytes$default(byteReadPacketMask, i12, 1, null);
                if ((b3 & SignedBytes.MAX_POWER_OF_TWO) != 0) {
                    z3 = 1;
                } else {
                    z3 = i12;
                }
                if ((b3 & 32) != 0) {
                    z4 = 1;
                } else {
                    z4 = i12;
                }
                if ((b3 & Ascii.DLE) != 0) {
                    z5 = 1;
                } else {
                    z5 = i12;
                }
                return companion.byType(z2, frameType4, bytes$default, z3, z4, z5);
            case 1:
                int i14 = anonymousClass1.I$0;
                j2 = anonymousClass1.J$0;
                ByteReadChannel byteReadChannel5 = (ByteReadChannel) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj6);
                i2 = i14;
                byteReadChannel4 = byteReadChannel5;
                obj = obj6;
                bByteValue = ((Number) obj).byteValue();
                anonymousClass1.L$0 = byteReadChannel4;
                anonymousClass1.J$0 = j2;
                anonymousClass1.I$0 = i2;
                anonymousClass1.B$0 = bByteValue;
                anonymousClass1.label = 2;
                obj2 = byteReadChannel4.readByte(anonymousClass1);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                byteReadChannel2 = byteReadChannel4;
                i3 = i2;
                obj6 = obj2;
                j3 = j2;
                b = bByteValue;
                bByteValue2 = ((Number) obj6).byteValue();
                i4 = b & Ascii.SI;
                if (i4 != 0) {
                }
                if (i4 == 0) {
                    i5 = i3;
                } else {
                    i5 = i4;
                }
                frameType = FrameType.INSTANCE.get(i5);
                if (frameType == null) {
                    throw new IllegalStateException("Unsupported opcode: " + i5);
                }
                if (i4 == 0) {
                }
                if ((b & 128) != 0) {
                    i6 = 1;
                } else {
                    i6 = 0;
                }
                if (!frameType.getControlFrame()) {
                }
                i7 = bByteValue2 & 127;
                if (i7 == 126) {
                    anonymousClass1.L$0 = byteReadChannel2;
                    anonymousClass1.L$1 = frameType;
                    anonymousClass1.J$0 = j3;
                    anonymousClass1.B$0 = b;
                    anonymousClass1.B$1 = bByteValue2;
                    anonymousClass1.I$0 = i6;
                    anonymousClass1.label = 3;
                    obj3 = byteReadChannel2.readShort(anonymousClass1);
                    if (obj3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    frameType2 = frameType;
                    b2 = bByteValue2;
                    i8 = i6;
                    obj6 = obj3;
                    jShortValue = ((long) ((Number) obj6).shortValue()) & 65535;
                    i6 = i8;
                    bByteValue2 = b2;
                    b3 = b;
                    byteReadChannel3 = byteReadChannel2;
                    frameType3 = frameType2;
                    j4 = j3;
                    j5 = jShortValue;
                } else if (i7 != 127) {
                    long j7 = i7;
                    b3 = b;
                    j4 = j3;
                    j5 = j7;
                    byteReadChannel3 = byteReadChannel2;
                    frameType3 = frameType;
                } else {
                    anonymousClass1.L$0 = byteReadChannel2;
                    anonymousClass1.L$1 = frameType;
                    anonymousClass1.J$0 = j3;
                    anonymousClass1.B$0 = b;
                    anonymousClass1.B$1 = bByteValue2;
                    anonymousClass1.I$0 = i6;
                    anonymousClass1.label = 4;
                    obj4 = byteReadChannel2.readLong(anonymousClass1);
                    if (obj4 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    frameType2 = frameType;
                    b2 = bByteValue2;
                    i8 = i6;
                    obj6 = obj4;
                    jShortValue = ((Number) obj6).longValue();
                    i6 = i8;
                    bByteValue2 = b2;
                    b3 = b;
                    byteReadChannel3 = byteReadChannel2;
                    frameType3 = frameType2;
                    j4 = j3;
                    j5 = jShortValue;
                }
                if (!frameType3.getControlFrame()) {
                    break;
                }
                if ((bByteValue2 & 128) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    anonymousClass1.L$0 = byteReadChannel3;
                    anonymousClass1.L$1 = frameType3;
                    anonymousClass1.J$0 = j4;
                    anonymousClass1.B$0 = b3;
                    anonymousClass1.I$0 = i6;
                    anonymousClass1.J$1 = j5;
                    anonymousClass1.label = 5;
                    obj5 = byteReadChannel3.readInt(anonymousClass1);
                    if (obj5 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    int i15 = i6;
                    obj6 = obj5;
                    i10 = i15;
                    int iIntValue2 = ((Number) obj6).intValue();
                    i6 = i10;
                    i9 = iIntValue2;
                } else {
                    if (z) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i9 = -1;
                }
                if (j5 <= 2147483647L) {
                    break;
                }
                throw new FrameTooBigException(j5);
            case 2:
                byte b4 = anonymousClass1.B$0;
                i3 = anonymousClass1.I$0;
                long j8 = anonymousClass1.J$0;
                ByteReadChannel byteReadChannel6 = (ByteReadChannel) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj6);
                byteReadChannel2 = byteReadChannel6;
                j3 = j8;
                b = b4;
                bByteValue2 = ((Number) obj6).byteValue();
                i4 = b & Ascii.SI;
                if (i4 != 0) {
                }
                if (i4 == 0) {
                    i5 = i3;
                } else {
                    i5 = i4;
                }
                frameType = FrameType.INSTANCE.get(i5);
                if (frameType == null) {
                    throw new IllegalStateException("Unsupported opcode: " + i5);
                }
                if (i4 == 0) {
                }
                if ((b & 128) != 0) {
                    i6 = 1;
                } else {
                    i6 = 0;
                }
                if (!frameType.getControlFrame()) {
                }
                i7 = bByteValue2 & 127;
                if (i7 == 126) {
                    anonymousClass1.L$0 = byteReadChannel2;
                    anonymousClass1.L$1 = frameType;
                    anonymousClass1.J$0 = j3;
                    anonymousClass1.B$0 = b;
                    anonymousClass1.B$1 = bByteValue2;
                    anonymousClass1.I$0 = i6;
                    anonymousClass1.label = 3;
                    obj3 = byteReadChannel2.readShort(anonymousClass1);
                    if (obj3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    frameType2 = frameType;
                    b2 = bByteValue2;
                    i8 = i6;
                    obj6 = obj3;
                    jShortValue = ((long) ((Number) obj6).shortValue()) & 65535;
                    i6 = i8;
                    bByteValue2 = b2;
                    b3 = b;
                    byteReadChannel3 = byteReadChannel2;
                    frameType3 = frameType2;
                    j4 = j3;
                    j5 = jShortValue;
                } else if (i7 != 127) {
                    long j9 = i7;
                    b3 = b;
                    j4 = j3;
                    j5 = j9;
                    byteReadChannel3 = byteReadChannel2;
                    frameType3 = frameType;
                } else {
                    anonymousClass1.L$0 = byteReadChannel2;
                    anonymousClass1.L$1 = frameType;
                    anonymousClass1.J$0 = j3;
                    anonymousClass1.B$0 = b;
                    anonymousClass1.B$1 = bByteValue2;
                    anonymousClass1.I$0 = i6;
                    anonymousClass1.label = 4;
                    obj4 = byteReadChannel2.readLong(anonymousClass1);
                    if (obj4 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    frameType2 = frameType;
                    b2 = bByteValue2;
                    i8 = i6;
                    obj6 = obj4;
                    jShortValue = ((Number) obj6).longValue();
                    i6 = i8;
                    bByteValue2 = b2;
                    b3 = b;
                    byteReadChannel3 = byteReadChannel2;
                    frameType3 = frameType2;
                    j4 = j3;
                    j5 = jShortValue;
                }
                if (!frameType3.getControlFrame()) {
                    break;
                }
                if ((bByteValue2 & 128) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    anonymousClass1.L$0 = byteReadChannel3;
                    anonymousClass1.L$1 = frameType3;
                    anonymousClass1.J$0 = j4;
                    anonymousClass1.B$0 = b3;
                    anonymousClass1.I$0 = i6;
                    anonymousClass1.J$1 = j5;
                    anonymousClass1.label = 5;
                    obj5 = byteReadChannel3.readInt(anonymousClass1);
                    if (obj5 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    int i16 = i6;
                    obj6 = obj5;
                    i10 = i16;
                    int iIntValue3 = ((Number) obj6).intValue();
                    i6 = i10;
                    i9 = iIntValue3;
                } else {
                    if (z) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i9 = -1;
                }
                if (j5 <= 2147483647L) {
                    break;
                }
                throw new FrameTooBigException(j5);
            case 3:
                i8 = anonymousClass1.I$0;
                b2 = anonymousClass1.B$1;
                b = anonymousClass1.B$0;
                j3 = anonymousClass1.J$0;
                frameType2 = (FrameType) anonymousClass1.L$1;
                byteReadChannel2 = (ByteReadChannel) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj6);
                jShortValue = ((long) ((Number) obj6).shortValue()) & 65535;
                i6 = i8;
                bByteValue2 = b2;
                b3 = b;
                byteReadChannel3 = byteReadChannel2;
                frameType3 = frameType2;
                j4 = j3;
                j5 = jShortValue;
                if (!frameType3.getControlFrame()) {
                    break;
                }
                if ((bByteValue2 & 128) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    anonymousClass1.L$0 = byteReadChannel3;
                    anonymousClass1.L$1 = frameType3;
                    anonymousClass1.J$0 = j4;
                    anonymousClass1.B$0 = b3;
                    anonymousClass1.I$0 = i6;
                    anonymousClass1.J$1 = j5;
                    anonymousClass1.label = 5;
                    obj5 = byteReadChannel3.readInt(anonymousClass1);
                    if (obj5 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    int i17 = i6;
                    obj6 = obj5;
                    i10 = i17;
                    int iIntValue4 = ((Number) obj6).intValue();
                    i6 = i10;
                    i9 = iIntValue4;
                } else {
                    if (z) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i9 = -1;
                }
                if (j5 <= 2147483647L) {
                    break;
                }
                throw new FrameTooBigException(j5);
            case 4:
                i8 = anonymousClass1.I$0;
                b2 = anonymousClass1.B$1;
                b = anonymousClass1.B$0;
                j3 = anonymousClass1.J$0;
                frameType2 = (FrameType) anonymousClass1.L$1;
                byteReadChannel2 = (ByteReadChannel) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj6);
                jShortValue = ((Number) obj6).longValue();
                i6 = i8;
                bByteValue2 = b2;
                b3 = b;
                byteReadChannel3 = byteReadChannel2;
                frameType3 = frameType2;
                j4 = j3;
                j5 = jShortValue;
                if (!frameType3.getControlFrame()) {
                    break;
                }
                if ((bByteValue2 & 128) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    anonymousClass1.L$0 = byteReadChannel3;
                    anonymousClass1.L$1 = frameType3;
                    anonymousClass1.J$0 = j4;
                    anonymousClass1.B$0 = b3;
                    anonymousClass1.I$0 = i6;
                    anonymousClass1.J$1 = j5;
                    anonymousClass1.label = 5;
                    obj5 = byteReadChannel3.readInt(anonymousClass1);
                    if (obj5 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    int i18 = i6;
                    obj6 = obj5;
                    i10 = i18;
                    int iIntValue5 = ((Number) obj6).intValue();
                    i6 = i10;
                    i9 = iIntValue5;
                } else {
                    if (z) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i9 = -1;
                }
                if (j5 <= 2147483647L) {
                    break;
                }
                throw new FrameTooBigException(j5);
            case 5:
                j5 = anonymousClass1.J$1;
                i10 = anonymousClass1.I$0;
                b3 = anonymousClass1.B$0;
                j4 = anonymousClass1.J$0;
                frameType3 = (FrameType) anonymousClass1.L$1;
                byteReadChannel3 = (ByteReadChannel) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj6);
                int iIntValue6 = ((Number) obj6).intValue();
                i6 = i10;
                i9 = iIntValue6;
                if (j5 <= 2147483647L) {
                    break;
                }
                throw new FrameTooBigException(j5);
            case 6:
                i9 = anonymousClass1.I$1;
                i11 = anonymousClass1.I$0;
                b3 = anonymousClass1.B$0;
                FrameType frameType5 = (FrameType) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj6);
                frameType4 = frameType5;
                byteReadPacketMask = (ByteReadPacket) obj6;
                if (i9 != -1) {
                    byteReadPacketMask = mask(byteReadPacketMask, i9);
                }
                Frame.Companion companion2 = Frame.INSTANCE;
                if (i11 != 0) {
                    z2 = true;
                    i12 = 0;
                } else {
                    i12 = 0;
                    z2 = false;
                }
                byte[] bytes$default2 = StringsKt.readBytes$default(byteReadPacketMask, i12, 1, null);
                if ((b3 & SignedBytes.MAX_POWER_OF_TWO) != 0) {
                    z3 = 1;
                } else {
                    z3 = i12;
                }
                if ((b3 & 32) != 0) {
                    z4 = 1;
                } else {
                    z4 = i12;
                }
                if ((b3 & Ascii.DLE) != 0) {
                    z5 = 1;
                } else {
                    z5 = i12;
                }
                return companion2.byType(z2, frameType4, bytes$default2, z3, z4, z5);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private static final ByteReadPacket mask(ByteReadPacket byteReadPacket, int i) {
        DefaultAllocator defaultAllocator = DefaultAllocator.INSTANCE;
        ByteBuffer byteBufferMo7623allocgFvZug = defaultAllocator.mo7623allocgFvZug(4);
        try {
            byteBufferMo7623allocgFvZug.putInt(0, i);
            BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, null);
            try {
                int remaining = (int) byteReadPacket.getRemaining();
                for (int i2 = 0; i2 < remaining; i2++) {
                    bytePacketBuilder.writeByte((byte) (byteReadPacket.readByte() ^ byteBufferMo7623allocgFvZug.get(i2 % 4)));
                }
                ByteReadPacket byteReadPacketBuild = bytePacketBuilder.build();
                defaultAllocator.mo7624free3GNKZMM(byteBufferMo7623allocgFvZug);
                return byteReadPacketBuild;
            } catch (Throwable th) {
                bytePacketBuilder.release();
                throw th;
            }
        } catch (Throwable th2) {
            defaultAllocator.mo7624free3GNKZMM(byteBufferMo7623allocgFvZug);
            throw th2;
        }
    }
}
