package io.ktor.websocket.serialization;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.ktor.serialization.WebsocketContentConverter;
import io.ktor.serialization.WebsocketDeserializeException;
import io.ktor.util.InternalAPI;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.util.reflect.TypeInfoJvmKt;
import io.ktor.websocket.Frame;
import io.ktor.websocket.WebSocketSession;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: compiled from: WebsocketChannelSerialization.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a3\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\t\u001a3\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a;\u0010\r\u001a\u00020\u000e\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a;\u0010\r\u001a\u00020\u000e*\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"receiveDeserializedBase", "", "T", "Lio/ktor/websocket/WebSocketSession;", "converter", "Lio/ktor/serialization/WebsocketContentConverter;", "charset", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "(Lio/ktor/websocket/WebSocketSession;Lio/ktor/serialization/WebsocketContentConverter;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "typeInfo", "Lio/ktor/util/reflect/TypeInfo;", "(Lio/ktor/websocket/WebSocketSession;Lio/ktor/util/reflect/TypeInfo;Lio/ktor/serialization/WebsocketContentConverter;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendSerializedBase", "", "data", "(Lio/ktor/websocket/WebSocketSession;Ljava/lang/Object;Lio/ktor/serialization/WebsocketContentConverter;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/ktor/websocket/WebSocketSession;Ljava/lang/Object;Lio/ktor/util/reflect/TypeInfo;Lio/ktor/serialization/WebsocketContentConverter;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-websocket-serialization"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class WebsocketChannelSerializationKt {

    /* JADX INFO: renamed from: io.ktor.websocket.serialization.WebsocketChannelSerializationKt$receiveDeserializedBase$2, reason: invalid class name */
    /* JADX INFO: compiled from: WebsocketChannelSerialization.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.serialization.WebsocketChannelSerializationKt", f = "WebsocketChannelSerialization.kt", i = {0, 0, 0, 1, 1}, l = {95, 104}, m = "receiveDeserializedBase", n = {"typeInfo", "converter", "charset", "typeInfo", TypedValues.AttributesType.S_FRAME}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
    static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebsocketChannelSerializationKt.receiveDeserializedBase(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.websocket.serialization.WebsocketChannelSerializationKt$sendSerializedBase$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WebsocketChannelSerialization.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.serialization.WebsocketChannelSerializationKt", f = "WebsocketChannelSerialization.kt", i = {0}, l = {50, 55}, m = "sendSerializedBase", n = {"$this$sendSerializedBase"}, s = {"L$0"})
    static final class C48642 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C48642(Continuation<? super C48642> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebsocketChannelSerializationKt.sendSerializedBase(null, null, null, null, null, this);
        }
    }

    @InternalAPI
    public static final /* synthetic */ <T> Object sendSerializedBase(WebSocketSession webSocketSession, Object obj, WebsocketContentConverter websocketContentConverter, Charset charset, Continuation<? super Unit> continuation) throws Throwable {
        Intrinsics.reifiedOperationMarker(6, "T");
        Type javaType = TypesJVMKt.getJavaType((KType) null);
        Intrinsics.reifiedOperationMarker(4, "T");
        TypeInfo typeInfoTypeInfoImpl = TypeInfoJvmKt.typeInfoImpl(javaType, Reflection.getOrCreateKotlinClass(Object.class), null);
        InlineMarker.mark(0);
        sendSerializedBase(webSocketSession, obj, typeInfoTypeInfoImpl, websocketContentConverter, charset, continuation);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @InternalAPI
    public static final Object sendSerializedBase(WebSocketSession webSocketSession, Object obj, TypeInfo typeInfo, WebsocketContentConverter websocketContentConverter, Charset charset, Continuation<? super Unit> continuation) throws Throwable {
        C48642 c48642;
        if (continuation instanceof C48642) {
            c48642 = (C48642) continuation;
            if ((c48642.label & Integer.MIN_VALUE) != 0) {
                c48642.label -= Integer.MIN_VALUE;
            } else {
                c48642 = new C48642(continuation);
            }
        } else {
            c48642 = new C48642(continuation);
        }
        Object objSerializeNullable = c48642.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c48642.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objSerializeNullable);
            c48642.L$0 = webSocketSession;
            c48642.label = 1;
            objSerializeNullable = websocketContentConverter.serializeNullable(charset, typeInfo, obj, c48642);
            if (objSerializeNullable == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i == 1) {
                webSocketSession = (WebSocketSession) c48642.L$0;
                ResultKt.throwOnFailure(objSerializeNullable);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objSerializeNullable);
            }
            return Unit.INSTANCE;
        }
        SendChannel<Frame> outgoing = webSocketSession.getOutgoing();
        c48642.L$0 = null;
        c48642.label = 2;
        if (outgoing.send((Frame) objSerializeNullable, c48642) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @InternalAPI
    public static final /* synthetic */ <T> Object receiveDeserializedBase(WebSocketSession webSocketSession, WebsocketContentConverter websocketContentConverter, Charset charset, Continuation<Object> continuation) throws Throwable {
        Intrinsics.reifiedOperationMarker(6, "T");
        Type javaType = TypesJVMKt.getJavaType((KType) null);
        Intrinsics.reifiedOperationMarker(4, "T");
        TypeInfo typeInfoTypeInfoImpl = TypeInfoJvmKt.typeInfoImpl(javaType, Reflection.getOrCreateKotlinClass(Object.class), null);
        InlineMarker.mark(0);
        Object objReceiveDeserializedBase = receiveDeserializedBase(webSocketSession, typeInfoTypeInfoImpl, websocketContentConverter, charset, continuation);
        InlineMarker.mark(1);
        return objReceiveDeserializedBase;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0094 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x0095 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:29:0x0097  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    @InternalAPI
    public static final Object receiveDeserializedBase(WebSocketSession webSocketSession, TypeInfo typeInfo, WebsocketContentConverter websocketContentConverter, Charset charset, Continuation<Object> continuation) throws Throwable {
        AnonymousClass2 anonymousClass2;
        TypeInfo typeInfo2;
        WebsocketContentConverter websocketContentConverter2;
        Charset charset2;
        TypeInfo typeInfo3;
        Frame frame;
        KType kotlinType;
        if (continuation instanceof AnonymousClass2) {
            anonymousClass2 = (AnonymousClass2) continuation;
            if ((anonymousClass2.label & Integer.MIN_VALUE) != 0) {
                anonymousClass2.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass2 = new AnonymousClass2(continuation);
            }
        } else {
            anonymousClass2 = new AnonymousClass2(continuation);
        }
        Object objReceive = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objReceive);
            ReceiveChannel<Frame> incoming = webSocketSession.getIncoming();
            typeInfo2 = typeInfo;
            anonymousClass2.L$0 = typeInfo2;
            websocketContentConverter2 = websocketContentConverter;
            anonymousClass2.L$1 = websocketContentConverter2;
            charset2 = charset;
            anonymousClass2.L$2 = charset2;
            anonymousClass2.label = 1;
            objReceive = incoming.receive(anonymousClass2);
            if (objReceive == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i == 1) {
                Charset charset3 = (Charset) anonymousClass2.L$2;
                websocketContentConverter2 = (WebsocketContentConverter) anonymousClass2.L$1;
                TypeInfo typeInfo4 = (TypeInfo) anonymousClass2.L$0;
                ResultKt.throwOnFailure(objReceive);
                charset2 = charset3;
                typeInfo2 = typeInfo4;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Frame frame2 = (Frame) anonymousClass2.L$1;
                typeInfo3 = (TypeInfo) anonymousClass2.L$0;
                ResultKt.throwOnFailure(objReceive);
                frame = frame2;
            }
            if (typeInfo3.getType().isInstance(objReceive)) {
                return objReceive;
            }
            if (objReceive == null) {
                kotlinType = typeInfo3.getKotlinType();
                if (kotlinType == null && kotlinType.isMarkedNullable()) {
                    return null;
                }
                throw new WebsocketDeserializeException("Frame has null content", null, frame, 2, null);
            }
            throw new WebsocketDeserializeException("Can't deserialize value: expected value of type " + typeInfo3.getType().getSimpleName() + ", got " + Reflection.getOrCreateKotlinClass(objReceive.getClass()).getSimpleName(), null, frame, 2, null);
        }
        Frame frame3 = (Frame) objReceive;
        if (!websocketContentConverter2.isApplicable(frame3)) {
            throw new WebsocketDeserializeException("Converter doesn't support frame type " + frame3.getFrameType().name(), null, frame3, 2, null);
        }
        anonymousClass2.L$0 = typeInfo2;
        anonymousClass2.L$1 = frame3;
        anonymousClass2.L$2 = null;
        anonymousClass2.label = 2;
        objReceive = websocketContentConverter2.deserialize(charset2, typeInfo2, frame3, anonymousClass2);
        if (objReceive == coroutine_suspended) {
            return coroutine_suspended;
        }
        typeInfo3 = typeInfo2;
        frame = frame3;
        if (typeInfo3.getType().isInstance(objReceive)) {
            return objReceive;
        }
        if (objReceive == null) {
            kotlinType = typeInfo3.getKotlinType();
            if (kotlinType == null) {
            }
            throw new WebsocketDeserializeException("Frame has null content", null, frame, 2, null);
        }
        throw new WebsocketDeserializeException("Can't deserialize value: expected value of type " + typeInfo3.getType().getSimpleName() + ", got " + Reflection.getOrCreateKotlinClass(objReceive.getClass()).getSimpleName(), null, frame, 2, null);
    }
}
