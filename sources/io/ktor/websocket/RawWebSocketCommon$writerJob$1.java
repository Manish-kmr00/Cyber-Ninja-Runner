package io.ktor.websocket;

import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RawWebSocketCommon.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.RawWebSocketCommon$writerJob$1", f = "RawWebSocketCommon.kt", i = {1}, l = {TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER, 60}, m = "invokeSuspend", n = {"message"}, s = {"L$0"})
final class RawWebSocketCommon$writerJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ RawWebSocketCommon this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RawWebSocketCommon$writerJob$1(RawWebSocketCommon rawWebSocketCommon, Continuation<? super RawWebSocketCommon$writerJob$1> continuation) {
        super(2, continuation);
        this.this$0 = rawWebSocketCommon;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RawWebSocketCommon$writerJob$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RawWebSocketCommon$writerJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x0044 A[Catch: all -> 0x0023, ChannelWriteException -> 0x0026, Merged into TryCatch #0 {all -> 0x00f1, ChannelWriteException -> 0x0026, all -> 0x0023, blocks: (B:35:0x009e, B:37:0x00c0, B:7:0x0013, B:27:0x0062, B:18:0x002c, B:21:0x0040, B:23:0x0044, B:30:0x007b, B:32:0x007f, B:33:0x0085, B:34:0x009d, B:29:0x006f, B:11:0x001f), top: B:49:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0060 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x0061  */
    /* JADX WARN: Code duplicated, block: B:30:0x007b A[Catch: all -> 0x0023, ChannelWriteException -> 0x0026, Merged into TryCatch #0 {all -> 0x00f1, ChannelWriteException -> 0x0026, all -> 0x0023, blocks: (B:35:0x009e, B:37:0x00c0, B:7:0x0013, B:27:0x0062, B:18:0x002c, B:21:0x0040, B:23:0x0044, B:30:0x007b, B:32:0x007f, B:33:0x0085, B:34:0x009d, B:29:0x006f, B:11:0x001f), top: B:49:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:32:0x007f A[Catch: all -> 0x0023, ChannelWriteException -> 0x0026, Merged into TryCatch #0 {all -> 0x00f1, ChannelWriteException -> 0x0026, all -> 0x0023, blocks: (B:35:0x009e, B:37:0x00c0, B:7:0x0013, B:27:0x0062, B:18:0x002c, B:21:0x0040, B:23:0x0044, B:30:0x007b, B:32:0x007f, B:33:0x0085, B:34:0x009d, B:29:0x006f, B:11:0x001f), top: B:49:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0085 A[Catch: all -> 0x0023, ChannelWriteException -> 0x0026, Merged into TryCatch #0 {all -> 0x00f1, ChannelWriteException -> 0x0026, all -> 0x0023, blocks: (B:35:0x009e, B:37:0x00c0, B:7:0x0013, B:27:0x0062, B:18:0x002c, B:21:0x0040, B:23:0x0044, B:30:0x007b, B:32:0x007f, B:33:0x0085, B:34:0x009d, B:29:0x006f, B:11:0x001f), top: B:49:0x000b }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0061 -> B:27:0x0062). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x007f -> B:18:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:20:0x003f
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instruction units count: 267
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.RawWebSocketCommon$writerJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
