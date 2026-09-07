package io.ktor.websocket;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.json.b9;
import io.ktor.http.ContentDisposition;
import io.ktor.util.cio.ChannelIOException;
import io.ktor.utils.io.core.BytePacketBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ClosedReceiveChannelException;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: compiled from: DefaultWebSocketSession.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\b\u0000\u0018\u0000 e2\u00020g2\u00020\u0001:\u0001eB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\fH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0010J\u0017\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\u001d\u0010\u001d\u001a\u00020\u001c2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u001cH\u0002¢\u0006\u0004\b!\u0010\"J)\u0010'\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%H\u0082@ø\u0001\u0000¢\u0006\u0004\b'\u0010(J!\u0010,\u001a\u00020\f2\u0010\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030*0)H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\fH\u0017¢\u0006\u0004\b.\u0010 J\u000f\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b0\u00101R\u001e\u00103\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030*028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\"\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020#0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010>\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u001a\u0010A\u001a\u00020@8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u001e\u0010G\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030*0)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\n0H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020\n0K8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bL\u0010MR$\u0010S\u001a\u00020/2\u0006\u0010O\u001a\u00020/8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bP\u00101\"\u0004\bQ\u0010RR$\u0010X\u001a\u00020\u00032\u0006\u0010O\u001a\u00020\u00038V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001a\u0010[\u001a\b\u0012\u0004\u0012\u00020\n0\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bY\u0010ZR\u001a\u0010\\\u001a\b\u0012\u0004\u0012\u00020\n0H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010JR*\u0010^\u001a\u00020\u00032\u0006\u0010]\u001a\u00020\u00038\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010U\"\u0004\ba\u0010WR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010bR*\u0010\u0005\u001a\u00020\u00032\u0006\u0010]\u001a\u00020\u00038\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010_\u001a\u0004\bc\u0010U\"\u0004\bd\u0010W\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006f"}, d2 = {"Lio/ktor/websocket/DefaultWebSocketSessionImpl;", "Lio/ktor/websocket/WebSocketSession;", "raw", "", "pingInterval", "timeoutMillis", "<init>", "(Lio/ktor/websocket/WebSocketSession;JJ)V", "Lio/ktor/utils/io/core/BytePacketBuilder;", "packet", "Lio/ktor/websocket/Frame;", TypedValues.AttributesType.S_FRAME, "", "checkMaxFrameSize", "(Lio/ktor/utils/io/core/BytePacketBuilder;Lio/ktor/websocket/Frame;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "message", "goingAway", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "outgoingProcessorLoop", "processIncomingExtensions", "(Lio/ktor/websocket/Frame;)Lio/ktor/websocket/Frame;", "processOutgoingExtensions", "Lkotlinx/coroutines/channels/SendChannel;", "Lio/ktor/websocket/Frame$Ping;", "ponger", "Lkotlinx/coroutines/Job;", "runIncomingProcessor", "(Lkotlinx/coroutines/channels/SendChannel;)Lkotlinx/coroutines/Job;", "runOrCancelPinger", "()V", "runOutgoingProcessor", "()Lkotlinx/coroutines/Job;", "Lio/ktor/websocket/CloseReason;", "reason", "", "exception", "sendCloseSequence", "(Lio/ktor/websocket/CloseReason;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lio/ktor/websocket/WebSocketExtension;", "negotiatedExtensions", "start", "(Ljava/util/List;)V", "terminate", "", "tryClose", "()Z", "", "_extensions", "Ljava/util/List;", "Lkotlinx/coroutines/Deferred;", "closeReason", "Lkotlinx/coroutines/Deferred;", "getCloseReason", "()Lkotlinx/coroutines/Deferred;", "Lkotlinx/coroutines/CompletableDeferred;", "closeReasonRef", "Lkotlinx/coroutines/CompletableDeferred;", "Lkotlinx/coroutines/CompletableJob;", "context", "Lkotlinx/coroutines/CompletableJob;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "getExtensions", "()Ljava/util/List;", "extensions", "Lkotlinx/coroutines/channels/Channel;", "filtered", "Lkotlinx/coroutines/channels/Channel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "getIncoming", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "incoming", "value", "getMasking", "setMasking", "(Z)V", "masking", "getMaxFrameSize", "()J", "setMaxFrameSize", "(J)V", "maxFrameSize", "getOutgoing", "()Lkotlinx/coroutines/channels/SendChannel;", "outgoing", "outgoingToBeProcessed", "newValue", "pingIntervalMillis", "J", "getPingIntervalMillis", "setPingIntervalMillis", "Lio/ktor/websocket/WebSocketSession;", "getTimeoutMillis", "setTimeoutMillis", "Companion", "ktor-websockets", "Lio/ktor/websocket/DefaultWebSocketSession;"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultWebSocketSessionImpl implements DefaultWebSocketSession, WebSocketSession {
    private final List<WebSocketExtension<?>> _extensions;
    private final Deferred<CloseReason> closeReason;
    private final CompletableDeferred<CloseReason> closeReasonRef;
    private volatile /* synthetic */ int closed;
    private final CompletableJob context;
    private final CoroutineContext coroutineContext;
    private final Channel<Frame> filtered;
    private final Channel<Frame> outgoingToBeProcessed;
    private long pingIntervalMillis;
    volatile /* synthetic */ Object pinger;
    private final WebSocketSession raw;
    private volatile /* synthetic */ int started;
    private long timeoutMillis;
    private static final Frame.Pong EmptyPong = new Frame.Pong(new byte[0], NonDisposableHandle.INSTANCE);
    static final /* synthetic */ AtomicReferenceFieldUpdater pinger$FU = AtomicReferenceFieldUpdater.newUpdater(DefaultWebSocketSessionImpl.class, Object.class, "pinger");
    private static final /* synthetic */ AtomicIntegerFieldUpdater closed$FU = AtomicIntegerFieldUpdater.newUpdater(DefaultWebSocketSessionImpl.class, "closed");
    private static final /* synthetic */ AtomicIntegerFieldUpdater started$FU = AtomicIntegerFieldUpdater.newUpdater(DefaultWebSocketSessionImpl.class, b9.h.d0);

    /* JADX INFO: renamed from: io.ktor.websocket.DefaultWebSocketSessionImpl$checkMaxFrameSize$1, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultWebSocketSession.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl", f = "DefaultWebSocketSession.kt", i = {0}, l = {327}, m = "checkMaxFrameSize", n = {ContentDisposition.Parameters.Size}, s = {"I$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultWebSocketSessionImpl.this.checkMaxFrameSize(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.websocket.DefaultWebSocketSessionImpl$outgoingProcessorLoop$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultWebSocketSession.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl", f = "DefaultWebSocketSession.kt", i = {0, 2}, l = {252, 256, 266}, m = "outgoingProcessorLoop", n = {"this", "this"}, s = {"L$0", "L$0"})
    static final class C48541 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C48541(Continuation<? super C48541> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultWebSocketSessionImpl.this.outgoingProcessorLoop(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.websocket.DefaultWebSocketSessionImpl$sendCloseSequence$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultWebSocketSession.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl", f = "DefaultWebSocketSession.kt", i = {0, 0, 0}, l = {281}, m = "sendCloseSequence", n = {"this", "exception", "reasonToSend"}, s = {"L$0", "L$1", "L$2"})
    static final class C48571 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C48571(Continuation<? super C48571> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultWebSocketSessionImpl.this.sendCloseSequence(null, null, this);
        }
    }

    public DefaultWebSocketSessionImpl(WebSocketSession raw, long j, long j2) {
        Intrinsics.checkNotNullParameter(raw, "raw");
        this.raw = raw;
        this.pinger = null;
        CompletableDeferred<CloseReason> completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.closeReasonRef = completableDeferredCompletableDeferred$default;
        this.filtered = ChannelKt.Channel$default(8, null, null, 6, null);
        this.outgoingToBeProcessed = ChannelKt.Channel$default(UtilsKt.getOUTGOING_CHANNEL_CAPACITY(), null, null, 6, null);
        this.closed = 0;
        CompletableJob completableJobJob = JobKt.Job((Job) raw.getCoroutineContext().get(Job.INSTANCE));
        this.context = completableJobJob;
        this._extensions = new ArrayList();
        this.started = 0;
        this.coroutineContext = raw.getCoroutineContext().plus(completableJobJob).plus(new CoroutineName("ws-default"));
        this.pingIntervalMillis = j;
        this.timeoutMillis = j2;
        this.closeReason = completableDeferredCompletableDeferred$default;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public Object send(Frame frame, Continuation<? super Unit> continuation) {
        return DefaultWebSocketSession.DefaultImpls.send(this, frame, continuation);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public ReceiveChannel<Frame> getIncoming() {
        return this.filtered;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public SendChannel<Frame> getOutgoing() {
        return this.outgoingToBeProcessed;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public List<WebSocketExtension<?>> getExtensions() {
        return this._extensions;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public boolean getMasking() {
        return this.raw.getMasking();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMasking(boolean z) {
        this.raw.setMasking(z);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public long getMaxFrameSize() {
        return this.raw.getMaxFrameSize();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMaxFrameSize(long j) {
        this.raw.setMaxFrameSize(j);
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public long getPingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public void setPingIntervalMillis(long j) {
        this.pingIntervalMillis = j;
        runOrCancelPinger();
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public long getTimeoutMillis() {
        return this.timeoutMillis;
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public void setTimeoutMillis(long j) {
        this.timeoutMillis = j;
        runOrCancelPinger();
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public Deferred<CloseReason> getCloseReason() {
        return this.closeReason;
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public void start(List<? extends WebSocketExtension<?>> negotiatedExtensions) {
        Intrinsics.checkNotNullParameter(negotiatedExtensions, "negotiatedExtensions");
        if (!started$FU.compareAndSet(this, 0, 1)) {
            throw new IllegalStateException(("WebSocket session " + this + " is already started.").toString());
        }
        DefaultWebSocketSessionKt.getLOGGER().trace("Starting default WebSocketSession(" + this + ") with negotiated extensions: " + CollectionsKt.joinToString$default(negotiatedExtensions, null, null, null, 0, null, null, 63, null));
        this._extensions.addAll(negotiatedExtensions);
        runOrCancelPinger();
        runIncomingProcessor(PingPongKt.ponger(this, getOutgoing()));
        runOutgoingProcessor();
    }

    public static /* synthetic */ Object goingAway$default(DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "Server is going down";
        }
        return defaultWebSocketSessionImpl.goingAway(str, continuation);
    }

    public final Object goingAway(String str, Continuation<? super Unit> continuation) {
        Object objSendCloseSequence$default = sendCloseSequence$default(this, new CloseReason(CloseReason.Codes.GOING_AWAY, str), null, continuation, 2, null);
        return objSendCloseSequence$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSendCloseSequence$default : Unit.INSTANCE;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public Object flush(Continuation<? super Unit> continuation) {
        Object objFlush = this.raw.flush(continuation);
        return objFlush == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFlush : Unit.INSTANCE;
    }

    @Override // io.ktor.websocket.WebSocketSession
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use cancel() instead.", replaceWith = @ReplaceWith(expression = "cancel()", imports = {"kotlinx.coroutines.cancel"}))
    public void terminate() {
        Job.DefaultImpls.cancel$default((Job) this.context, (CancellationException) null, 1, (Object) null);
        CoroutineScopeKt.cancel$default(this.raw, null, 1, null);
    }

    private final Job runIncomingProcessor(SendChannel<? super Frame.Ping> ponger) {
        return BuildersKt__Builders_commonKt.launch$default(this, DefaultWebSocketSessionKt.IncomingProcessorCoroutineName.plus(Dispatchers.getUnconfined()), null, new C48551(ponger, null), 2, null);
    }

    /* JADX INFO: renamed from: io.ktor.websocket.DefaultWebSocketSessionImpl$runIncomingProcessor$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultWebSocketSession.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl$runIncomingProcessor$1", f = "DefaultWebSocketSession.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7}, l = {352, 172, 226, 178, 179, 181, 196, 211, 226, 226, 226, 226}, m = "invokeSuspend", n = {"$this$launch", "firstFrame", "frameBody", "closeFramePresented", "$this$consume$iv$iv", "frameBody", "closeFramePresented", "$this$consume$iv$iv", "$this$launch", "firstFrame", "frameBody", "closeFramePresented", "$this$consume$iv$iv", "$this$launch", "firstFrame", "frameBody", "closeFramePresented", "$this$consume$iv$iv", "$this$launch", "firstFrame", "frameBody", "closeFramePresented", "$this$consume$iv$iv", TypedValues.AttributesType.S_FRAME, "$this$launch", "firstFrame", "frameBody", "closeFramePresented", "$this$consume$iv$iv", "$this$launch", "firstFrame", "frameBody", "closeFramePresented", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$6", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$6", "L$0", "L$1", "L$2", "L$3", "L$6", "L$0", "L$1", "L$2", "L$3", "L$6", "L$8", "L$0", "L$1", "L$2", "L$3", "L$6", "L$0", "L$1", "L$2", "L$3", "L$6"})
    static final class C48551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SendChannel<Frame.Ping> $ponger;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C48551(SendChannel<? super Frame.Ping> sendChannel, Continuation<? super C48551> continuation) {
            super(2, continuation);
            this.$ponger = sendChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C48551 c48551 = DefaultWebSocketSessionImpl.this.new C48551(this.$ponger, continuation);
            c48551.L$0 = obj;
            return c48551;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C48551) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:37:0x0172 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:38:0x0173  */
        /* JADX WARN: Code duplicated, block: B:41:0x0186 A[Catch: all -> 0x012b, TryCatch #3 {all -> 0x012b, blocks: (B:9:0x0045, B:39:0x017e, B:41:0x0186, B:43:0x01b4, B:45:0x01be, B:47:0x01cc, B:48:0x01d0, B:51:0x01ee, B:62:0x023f, B:64:0x0243, B:66:0x0249, B:69:0x0263, B:70:0x0266, B:72:0x026a, B:76:0x0291, B:100:0x03bb, B:18:0x00bb, B:21:0x00e0, B:25:0x00fe, B:28:0x0124), top: B:151:0x000c }] */
        /* JADX WARN: Code duplicated, block: B:62:0x023f A[Catch: all -> 0x012b, TRY_ENTER, TryCatch #3 {all -> 0x012b, blocks: (B:9:0x0045, B:39:0x017e, B:41:0x0186, B:43:0x01b4, B:45:0x01be, B:47:0x01cc, B:48:0x01d0, B:51:0x01ee, B:62:0x023f, B:64:0x0243, B:66:0x0249, B:69:0x0263, B:70:0x0266, B:72:0x026a, B:76:0x0291, B:100:0x03bb, B:18:0x00bb, B:21:0x00e0, B:25:0x00fe, B:28:0x0124), top: B:151:0x000c }] */
        /* JADX WARN: Code duplicated, block: B:70:0x0266 A[Catch: all -> 0x012b, TryCatch #3 {all -> 0x012b, blocks: (B:9:0x0045, B:39:0x017e, B:41:0x0186, B:43:0x01b4, B:45:0x01be, B:47:0x01cc, B:48:0x01d0, B:51:0x01ee, B:62:0x023f, B:64:0x0243, B:66:0x0249, B:69:0x0263, B:70:0x0266, B:72:0x026a, B:76:0x0291, B:100:0x03bb, B:18:0x00bb, B:21:0x00e0, B:25:0x00fe, B:28:0x0124), top: B:151:0x000c }] */
        /* JADX WARN: Code duplicated, block: B:72:0x026a A[Catch: all -> 0x012b, TryCatch #3 {all -> 0x012b, blocks: (B:9:0x0045, B:39:0x017e, B:41:0x0186, B:43:0x01b4, B:45:0x01be, B:47:0x01cc, B:48:0x01d0, B:51:0x01ee, B:62:0x023f, B:64:0x0243, B:66:0x0249, B:69:0x0263, B:70:0x0266, B:72:0x026a, B:76:0x0291, B:100:0x03bb, B:18:0x00bb, B:21:0x00e0, B:25:0x00fe, B:28:0x0124), top: B:151:0x000c }] */
        /* JADX WARN: Code duplicated, block: B:74:0x0283 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:76:0x0291 A[Catch: all -> 0x012b, TRY_LEAVE, TryCatch #3 {all -> 0x012b, blocks: (B:9:0x0045, B:39:0x017e, B:41:0x0186, B:43:0x01b4, B:45:0x01be, B:47:0x01cc, B:48:0x01d0, B:51:0x01ee, B:62:0x023f, B:64:0x0243, B:66:0x0249, B:69:0x0263, B:70:0x0266, B:72:0x026a, B:76:0x0291, B:100:0x03bb, B:18:0x00bb, B:21:0x00e0, B:25:0x00fe, B:28:0x0124), top: B:151:0x000c }] */
        /* JADX WARN: Code duplicated, block: B:78:0x02b0 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:79:0x02b1  */
        /* JADX WARN: Code duplicated, block: B:82:0x02c1 A[Catch: all -> 0x0094, TryCatch #0 {all -> 0x0094, blocks: (B:80:0x02bb, B:82:0x02c1, B:84:0x02c5, B:85:0x02c7, B:87:0x02cb, B:88:0x02d4, B:89:0x02fc, B:91:0x0300, B:96:0x0330, B:13:0x008f), top: B:147:0x008f }] */
        /* JADX WARN: Code duplicated, block: B:84:0x02c5 A[Catch: all -> 0x0094, TryCatch #0 {all -> 0x0094, blocks: (B:80:0x02bb, B:82:0x02c1, B:84:0x02c5, B:85:0x02c7, B:87:0x02cb, B:88:0x02d4, B:89:0x02fc, B:91:0x0300, B:96:0x0330, B:13:0x008f), top: B:147:0x008f }] */
        /* JADX WARN: Code duplicated, block: B:87:0x02cb A[Catch: all -> 0x0094, TryCatch #0 {all -> 0x0094, blocks: (B:80:0x02bb, B:82:0x02c1, B:84:0x02c5, B:85:0x02c7, B:87:0x02cb, B:88:0x02d4, B:89:0x02fc, B:91:0x0300, B:96:0x0330, B:13:0x008f), top: B:147:0x008f }] */
        /* JADX WARN: Code duplicated, block: B:88:0x02d4 A[Catch: all -> 0x0094, TryCatch #0 {all -> 0x0094, blocks: (B:80:0x02bb, B:82:0x02c1, B:84:0x02c5, B:85:0x02c7, B:87:0x02cb, B:88:0x02d4, B:89:0x02fc, B:91:0x0300, B:96:0x0330, B:13:0x008f), top: B:147:0x008f }] */
        /* JADX WARN: Code duplicated, block: B:89:0x02fc A[Catch: all -> 0x0094, TryCatch #0 {all -> 0x0094, blocks: (B:80:0x02bb, B:82:0x02c1, B:84:0x02c5, B:85:0x02c7, B:87:0x02cb, B:88:0x02d4, B:89:0x02fc, B:91:0x0300, B:96:0x0330, B:13:0x008f), top: B:147:0x008f }] */
        /* JADX WARN: Code duplicated, block: B:91:0x0300 A[Catch: all -> 0x0094, TryCatch #0 {all -> 0x0094, blocks: (B:80:0x02bb, B:82:0x02c1, B:84:0x02c5, B:85:0x02c7, B:87:0x02cb, B:88:0x02d4, B:89:0x02fc, B:91:0x0300, B:96:0x0330, B:13:0x008f), top: B:147:0x008f }] */
        /* JADX WARN: Code duplicated, block: B:93:0x0324 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:94:0x0325  */
        /* JADX WARN: Code duplicated, block: B:96:0x0330 A[Catch: all -> 0x0094, TRY_LEAVE, TryCatch #0 {all -> 0x0094, blocks: (B:80:0x02bb, B:82:0x02c1, B:84:0x02c5, B:85:0x02c7, B:87:0x02cb, B:88:0x02d4, B:89:0x02fc, B:91:0x0300, B:96:0x0330, B:13:0x008f), top: B:147:0x008f }] */
        /* JADX WARN: Code duplicated, block: B:98:0x03b6 A[RETURN] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v47, types: [T, io.ktor.websocket.Frame] */
        /* JADX WARN: Type inference failed for: r0v82 */
        /* JADX WARN: Type inference failed for: r0v99 */
        /* JADX WARN: Type inference failed for: r4v32, types: [T, io.ktor.utils.io.core.BytePacketBuilder] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0247 -> B:75:0x0284). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x0281 -> B:75:0x0284). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r32) {
            /*
                Method dump skipped, instruction units count: 1322
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.DefaultWebSocketSessionImpl.C48551.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final Job runOutgoingProcessor() {
        return BuildersKt.launch(this, DefaultWebSocketSessionKt.OutgoingProcessorCoroutineName.plus(Dispatchers.getUnconfined()), CoroutineStart.UNDISPATCHED, new C48561(null));
    }

    /* JADX INFO: renamed from: io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultWebSocketSession.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1", f = "DefaultWebSocketSession.kt", i = {}, l = {236, 247, 247, 247, 240, 247, 247, 244, 247, 247}, m = "invokeSuspend", n = {}, s = {})
    static final class C48561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C48561(Continuation<? super C48561> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DefaultWebSocketSessionImpl.this.new C48561(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C48561) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x0061 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                try {
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure(obj);
                            this.label = 1;
                            if (DefaultWebSocketSessionImpl.this.outgoingProcessorLoop(this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) DefaultWebSocketSessionImpl.this.outgoingToBeProcessed, (CancellationException) null, 1, (Object) null);
                            this.label = 2;
                            if (WebSocketSessionKt.close$default(DefaultWebSocketSessionImpl.this.raw, null, this, 1, null) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        case 1:
                            ResultKt.throwOnFailure(obj);
                            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) DefaultWebSocketSessionImpl.this.outgoingToBeProcessed, (CancellationException) null, 1, (Object) null);
                            this.label = 2;
                            if (WebSocketSessionKt.close$default(DefaultWebSocketSessionImpl.this.raw, null, this, 1, null) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        case 2:
                        case 3:
                        case 4:
                        case 6:
                        case 7:
                        case 9:
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        case 5:
                            ResultKt.throwOnFailure(obj);
                            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) DefaultWebSocketSessionImpl.this.outgoingToBeProcessed, (CancellationException) null, 1, (Object) null);
                            this.label = 6;
                            if (WebSocketSessionKt.close$default(DefaultWebSocketSessionImpl.this.raw, null, this, 1, null) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        case 8:
                            ResultKt.throwOnFailure(obj);
                            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) DefaultWebSocketSessionImpl.this.outgoingToBeProcessed, (CancellationException) null, 1, (Object) null);
                            this.label = 9;
                            if (WebSocketSessionKt.close$default(DefaultWebSocketSessionImpl.this.raw, null, this, 1, null) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        case 10:
                            Throwable th = (Throwable) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            throw th;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } catch (ChannelIOException unused) {
                    ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) DefaultWebSocketSessionImpl.this.outgoingToBeProcessed, (CancellationException) null, 1, (Object) null);
                    this.label = 7;
                    if (WebSocketSessionKt.close$default(DefaultWebSocketSessionImpl.this.raw, null, this, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (CancellationException unused2) {
                    this.label = 5;
                    if (DefaultWebSocketSessionImpl.sendCloseSequence$default(DefaultWebSocketSessionImpl.this, new CloseReason(CloseReason.Codes.NORMAL, ""), null, this, 2, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (ClosedReceiveChannelException unused3) {
                    ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) DefaultWebSocketSessionImpl.this.outgoingToBeProcessed, (CancellationException) null, 1, (Object) null);
                    this.label = 4;
                    if (WebSocketSessionKt.close$default(DefaultWebSocketSessionImpl.this.raw, null, this, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (ClosedSendChannelException unused4) {
                    ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) DefaultWebSocketSessionImpl.this.outgoingToBeProcessed, (CancellationException) null, 1, (Object) null);
                    this.label = 3;
                    if (WebSocketSessionKt.close$default(DefaultWebSocketSessionImpl.this.raw, null, this, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (Throwable th2) {
                    DefaultWebSocketSessionImpl.this.outgoingToBeProcessed.cancel(ExceptionsKt.CancellationException("Failed to send frame", th2));
                    this.label = 8;
                    if (WebSocketSessionKt.closeExceptionally(DefaultWebSocketSessionImpl.this.raw, th2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } catch (Throwable th3) {
                ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) DefaultWebSocketSessionImpl.this.outgoingToBeProcessed, (CancellationException) null, 1, (Object) null);
                this.L$0 = th3;
                this.label = 10;
                if (WebSocketSessionKt.close$default(DefaultWebSocketSessionImpl.this.raw, null, this, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                throw th3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:21:0x006a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x006b  */
    /* JADX WARN: Code duplicated, block: B:25:0x0078  */
    /* JADX WARN: Code duplicated, block: B:30:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:32:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:33:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:35:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:38:0x00d9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x00da  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00da -> B:19:0x005e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object outgoingProcessorLoop(kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.DefaultWebSocketSessionImpl.outgoingProcessorLoop(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:33:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:40:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object sendCloseSequence(CloseReason closeReason, Throwable th, Continuation<? super Unit> continuation) throws Throwable {
        C48571 c48571;
        DefaultWebSocketSessionImpl defaultWebSocketSessionImpl;
        if (continuation instanceof C48571) {
            c48571 = (C48571) continuation;
            if ((c48571.label & Integer.MIN_VALUE) != 0) {
                c48571.label -= Integer.MIN_VALUE;
            } else {
                c48571 = new C48571(continuation);
            }
        } else {
            c48571 = new C48571(continuation);
        }
        Object obj = c48571.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c48571.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            closeReason = (CloseReason) c48571.L$2;
            th = (Throwable) c48571.L$1;
            defaultWebSocketSessionImpl = (DefaultWebSocketSessionImpl) c48571.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                defaultWebSocketSessionImpl.closeReasonRef.complete(closeReason);
                if (th != null) {
                    defaultWebSocketSessionImpl.outgoingToBeProcessed.close(th);
                    defaultWebSocketSessionImpl.filtered.close(th);
                }
                return Unit.INSTANCE;
            } catch (Throwable th2) {
                th = th2;
                defaultWebSocketSessionImpl.closeReasonRef.complete(closeReason);
                if (th != null) {
                    defaultWebSocketSessionImpl.outgoingToBeProcessed.close(th);
                    defaultWebSocketSessionImpl.filtered.close(th);
                }
                throw th;
            }
        }
        ResultKt.throwOnFailure(obj);
        if (!tryClose()) {
            return Unit.INSTANCE;
        }
        DefaultWebSocketSessionKt.getLOGGER().trace("Sending Close Sequence for session " + this + " with reason " + closeReason + " and exception " + th);
        this.context.complete();
        if (closeReason == null) {
            closeReason = new CloseReason(CloseReason.Codes.NORMAL, "");
        }
        try {
            runOrCancelPinger();
            if (closeReason.getCode() != CloseReason.Codes.CLOSED_ABNORMALLY.getCode()) {
                SendChannel<Frame> outgoing = this.raw.getOutgoing();
                Frame.Close close = new Frame.Close(closeReason);
                c48571.L$0 = this;
                c48571.L$1 = th;
                c48571.L$2 = closeReason;
                c48571.label = 1;
                if (outgoing.send(close, c48571) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            defaultWebSocketSessionImpl = this;
            defaultWebSocketSessionImpl.closeReasonRef.complete(closeReason);
            if (th != null) {
                defaultWebSocketSessionImpl.outgoingToBeProcessed.close(th);
                defaultWebSocketSessionImpl.filtered.close(th);
            }
            return Unit.INSTANCE;
        } catch (Throwable th3) {
            th = th3;
            defaultWebSocketSessionImpl = this;
            defaultWebSocketSessionImpl.closeReasonRef.complete(closeReason);
            if (th != null) {
                defaultWebSocketSessionImpl.outgoingToBeProcessed.close(th);
                defaultWebSocketSessionImpl.filtered.close(th);
            }
            throw th;
        }
    }

    static /* synthetic */ Object sendCloseSequence$default(DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, CloseReason closeReason, Throwable th, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        return defaultWebSocketSessionImpl.sendCloseSequence(closeReason, th, continuation);
    }

    private final boolean tryClose() {
        return closed$FU.compareAndSet(this, 0, 1);
    }

    private final void runOrCancelPinger() {
        long pingIntervalMillis = getPingIntervalMillis();
        SendChannel<Frame.Pong> sendChannelPinger = (this.closed == 0 && pingIntervalMillis > 0) ? PingPongKt.pinger(this, this.raw.getOutgoing(), pingIntervalMillis, getTimeoutMillis(), new DefaultWebSocketSessionImpl$runOrCancelPinger$newPinger$1(this, null)) : null;
        SendChannel sendChannel = (SendChannel) pinger$FU.getAndSet(this, sendChannelPinger);
        if (sendChannel != null) {
            SendChannel.DefaultImpls.close$default(sendChannel, null, 1, null);
        }
        if (sendChannelPinger != null) {
            ChannelResult.m9429isSuccessimpl(sendChannelPinger.mo9408trySendJP2dKIU(EmptyPong));
        }
        if (this.closed == 0 || sendChannelPinger == null) {
            return;
        }
        runOrCancelPinger();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object checkMaxFrameSize(BytePacketBuilder bytePacketBuilder, Frame frame, Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        int i;
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
            int length = frame.getData().length + (bytePacketBuilder != null ? bytePacketBuilder.getSize() : 0);
            if (length > getMaxFrameSize()) {
                if (bytePacketBuilder != null) {
                    bytePacketBuilder.release();
                }
                CloseReason closeReason = new CloseReason(CloseReason.Codes.TOO_BIG, "Frame is too big: " + length + ". Max size is " + getMaxFrameSize());
                anonymousClass1.I$0 = length;
                anonymousClass1.label = 1;
                if (WebSocketSessionKt.close(this, closeReason, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i = length;
            } else {
                return Unit.INSTANCE;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = anonymousClass1.I$0;
            ResultKt.throwOnFailure(obj);
        }
        throw new FrameTooBigException(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Frame processIncomingExtensions(Frame frame) {
        Iterator<T> it = getExtensions().iterator();
        while (it.hasNext()) {
            frame = ((WebSocketExtension) it.next()).processIncomingFrame(frame);
        }
        return frame;
    }

    private final Frame processOutgoingExtensions(Frame frame) {
        Iterator<T> it = getExtensions().iterator();
        while (it.hasNext()) {
            frame = ((WebSocketExtension) it.next()).processOutgoingFrame(frame);
        }
        return frame;
    }
}
