package io.ktor.client.plugins.websocket;

import com.amazon.device.ads.DTBMetricsConfiguration;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLParserKt;
import io.ktor.http.URLProtocol;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.util.reflect.TypeInfoJvmKt;
import io.ktor.websocket.WebSocketSessionKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: compiled from: builders.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u001a'\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006\u001aW\u0010\u0007\u001a\u00020\u0001*\u00020\b2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0087\u0001\u0010\u0007\u001a\u00020\u0001*\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001aa\u0010\u0007\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00142\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001a.\u0010\u001b\u001a\u00020\r*\u00020\b2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a^\u0010\u001b\u001a\u00020\r*\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0019\b\u0002\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001d\u001a8\u0010\u001b\u001a\u00020\r*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00142\u0019\b\u0002\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001aW\u0010\u001f\u001a\u00020\u0001*\u00020\b2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0087\u0001\u0010\u001f\u001a\u00020\u0001*\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001aa\u0010\u001f\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00142\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001aW\u0010 \u001a\u00020\u0001*\u00020\b2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0087\u0001\u0010 \u001a\u00020\u0001*\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001aa\u0010 \u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00142\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"WebSockets", "", "Lio/ktor/client/HttpClientConfig;", DTBMetricsConfiguration.CONFIG_DIR, "Lkotlin/Function1;", "Lio/ktor/client/plugins/websocket/WebSockets$Config;", "Lkotlin/ExtensionFunctionType;", "webSocket", "Lio/ktor/client/HttpClient;", "request", "Lio/ktor/client/request/HttpRequestBuilder;", "block", "Lkotlin/Function2;", "Lio/ktor/client/plugins/websocket/DefaultClientWebSocketSession;", "Lkotlin/coroutines/Continuation;", "", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "method", "Lio/ktor/http/HttpMethod;", "host", "", "port", "", "path", "(Lio/ktor/client/HttpClient;Lio/ktor/http/HttpMethod;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urlString", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "webSocketSession", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/ktor/client/HttpClient;Lio/ktor/http/HttpMethod;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ws", "wss", "ktor-client-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BuildersKt {

    /* JADX INFO: renamed from: io.ktor.client.plugins.websocket.BuildersKt$webSocket$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: builders.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.websocket.BuildersKt", f = "builders.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4}, l = {242, 245, 101, 103, 103, 251, 251}, m = "webSocket", n = {"block", "this_$iv", "block", "this_$iv", "response$iv", "this_$iv", "response$iv", "it", "this_$iv", "response$iv", "it", "this_$iv", "response$iv", "it"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    static final class C46691 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C46691(Continuation<? super C46691> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BuildersKt.webSocket(null, null, null, this);
        }
    }

    public static final void WebSockets(HttpClientConfig<?> httpClientConfig, final Function1<? super WebSockets.Config, Unit> config) {
        Intrinsics.checkNotNullParameter(httpClientConfig, "<this>");
        Intrinsics.checkNotNullParameter(config, "config");
        httpClientConfig.install(WebSockets.INSTANCE, new Function1<WebSockets.Config, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt.WebSockets.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WebSockets.Config config2) {
                invoke2(config2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(WebSockets.Config install) {
                Intrinsics.checkNotNullParameter(install, "$this$install");
                config.invoke(install);
            }
        });
    }

    public static final Object webSocketSession(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super DefaultClientWebSocketSession> continuation) {
        HttpClientPluginKt.plugin(httpClient, WebSockets.INSTANCE);
        CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.url(new Function2<URLBuilder, URLBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$statement$1$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(URLBuilder uRLBuilder, URLBuilder uRLBuilder2) {
                invoke2(uRLBuilder, uRLBuilder2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(URLBuilder url, URLBuilder it) {
                Intrinsics.checkNotNullParameter(url, "$this$url");
                Intrinsics.checkNotNullParameter(it, "it");
                url.setProtocol(URLProtocol.INSTANCE.getWS());
                url.setPort(url.getProtocol().getDefaultPort());
            }
        });
        function1.invoke(httpRequestBuilder);
        BuildersKt__Builders_commonKt.launch$default(httpClient, null, null, new AnonymousClass2(new HttpStatement(httpRequestBuilder, httpClient), completableDeferredCompletableDeferred$default, null), 3, null);
        return completableDeferredCompletableDeferred$default.await(continuation);
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$2, reason: invalid class name */
    /* JADX INFO: compiled from: builders.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$2", f = "builders.kt", i = {0, 1, 1, 2, 2}, l = {240, 243, 49, 249, 249}, m = "invokeSuspend", n = {"this_$iv", "this_$iv", "response$iv", "this_$iv", "response$iv"}, s = {"L$0", "L$0", "L$2", "L$0", "L$1"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CompletableDeferred<DefaultClientWebSocketSession> $sessionDeferred;
        final /* synthetic */ HttpStatement $statement;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(HttpStatement httpStatement, CompletableDeferred<DefaultClientWebSocketSession> completableDeferred, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$statement = httpStatement;
            this.$sessionDeferred = completableDeferred;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$statement, this.$sessionDeferred, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:44:0x00ab A[Catch: all -> 0x0052, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0052, blocks: (B:23:0x004e, B:44:0x00ab, B:52:0x00e4, B:53:0x00eb), top: B:67:0x004e }] */
        /* JADX WARN: Code duplicated, block: B:46:0x00d3 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:47:0x00d4  */
        /* JADX WARN: Code duplicated, block: B:51:0x00e3 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:52:0x00e4 A[Catch: all -> 0x0052, TRY_ENTER, TryCatch #0 {all -> 0x0052, blocks: (B:23:0x004e, B:44:0x00ab, B:52:0x00e4, B:53:0x00eb), top: B:67:0x004e }] */
        /* JADX WARN: Code duplicated, block: B:58:0x00ff A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:59:0x0100  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            CompletableDeferred<DefaultClientWebSocketSession> completableDeferred;
            HttpStatement httpStatement;
            HttpResponse httpResponse;
            HttpStatement httpStatement2;
            HttpResponse httpResponse2;
            Throwable th;
            CompletableDeferred<DefaultClientWebSocketSession> completableDeferred2;
            final CompletableDeferred completableDeferredCompletableDeferred$default;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    try {
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            HttpStatement httpStatement3 = this.$statement;
                            completableDeferred = this.$sessionDeferred;
                            this.L$0 = httpStatement3;
                            this.L$1 = completableDeferred;
                            this.label = 1;
                            Object objExecuteUnsafe = httpStatement3.executeUnsafe(this);
                            if (objExecuteUnsafe == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            httpStatement = httpStatement3;
                            obj = objExecuteUnsafe;
                        } else {
                            if (i != 1) {
                                if (i != 2) {
                                    if (i == 3) {
                                        httpResponse2 = (HttpResponse) this.L$1;
                                        httpStatement2 = (HttpStatement) this.L$0;
                                        try {
                                            ResultKt.throwOnFailure(obj);
                                            this.L$0 = Unit.INSTANCE;
                                            this.L$1 = null;
                                            this.label = 4;
                                            if (httpStatement2.cleanup(httpResponse2, this) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            this.L$0 = th;
                                            this.L$1 = null;
                                            this.L$2 = null;
                                            this.label = 5;
                                            if (httpStatement2.cleanup(httpResponse2, this) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            throw th;
                                        }
                                    } else {
                                        if (i != 4) {
                                            if (i != 5) {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            Throwable th3 = (Throwable) this.L$0;
                                            ResultKt.throwOnFailure(obj);
                                            throw th3;
                                        }
                                        ResultKt.throwOnFailure(obj);
                                    }
                                    return Unit.INSTANCE;
                                }
                                httpResponse2 = (HttpResponse) this.L$2;
                                completableDeferred2 = (CompletableDeferred) this.L$1;
                                httpStatement = (HttpStatement) this.L$0;
                                try {
                                    ResultKt.throwOnFailure(obj);
                                    if (obj != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type io.ktor.client.plugins.websocket.DefaultClientWebSocketSession");
                                    }
                                    DefaultClientWebSocketSession defaultClientWebSocketSession = (DefaultClientWebSocketSession) obj;
                                    AnonymousClass2 anonymousClass2 = this;
                                    completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                                    completableDeferred2.complete(defaultClientWebSocketSession);
                                    defaultClientWebSocketSession.getOutgoing().invokeOnClose(new Function1<Throwable, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$2$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th4) {
                                            invoke2(th4);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(Throwable th4) {
                                            if (th4 != null) {
                                                completableDeferredCompletableDeferred$default.completeExceptionally(th4);
                                            } else {
                                                completableDeferredCompletableDeferred$default.complete(Unit.INSTANCE);
                                            }
                                        }
                                    });
                                    this.L$0 = httpStatement;
                                    this.L$1 = httpResponse2;
                                    this.L$2 = null;
                                    this.label = 3;
                                    if (completableDeferredCompletableDeferred$default.await(this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    httpStatement2 = httpStatement;
                                    this.L$0 = Unit.INSTANCE;
                                    this.L$1 = null;
                                    this.label = 4;
                                    if (httpStatement2.cleanup(httpResponse2, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    return Unit.INSTANCE;
                                } catch (Throwable th4) {
                                    th = th4;
                                    httpStatement2 = httpStatement;
                                    this.L$0 = th;
                                    this.L$1 = null;
                                    this.L$2 = null;
                                    this.label = 5;
                                    if (httpStatement2.cleanup(httpResponse2, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    throw th;
                                }
                            }
                            completableDeferred = (CompletableDeferred) this.L$1;
                            httpStatement = (HttpStatement) this.L$0;
                            ResultKt.throwOnFailure(obj);
                        }
                        HttpClientCall call = httpResponse.getCall();
                        KType kTypeTypeOf = Reflection.typeOf(DefaultClientWebSocketSession.class);
                        TypeInfo typeInfoTypeInfoImpl = TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(kTypeTypeOf), Reflection.getOrCreateKotlinClass(DefaultClientWebSocketSession.class), kTypeTypeOf);
                        this.L$0 = httpStatement;
                        this.L$1 = completableDeferred;
                        this.L$2 = httpResponse;
                        this.label = 2;
                        Object objBodyNullable = call.bodyNullable(typeInfoTypeInfoImpl, this);
                        if (objBodyNullable == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        CompletableDeferred<DefaultClientWebSocketSession> completableDeferred3 = completableDeferred;
                        httpResponse2 = httpResponse;
                        obj = objBodyNullable;
                        completableDeferred2 = completableDeferred3;
                        if (obj != null) {
                            throw new NullPointerException("null cannot be cast to non-null type io.ktor.client.plugins.websocket.DefaultClientWebSocketSession");
                        }
                        DefaultClientWebSocketSession defaultClientWebSocketSession2 = (DefaultClientWebSocketSession) obj;
                        AnonymousClass2 anonymousClass3 = this;
                        completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                        completableDeferred2.complete(defaultClientWebSocketSession2);
                        defaultClientWebSocketSession2.getOutgoing().invokeOnClose(new Function1<Throwable, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$2$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                                invoke2(th5);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable th5) {
                                if (th5 != null) {
                                    completableDeferredCompletableDeferred$default.completeExceptionally(th5);
                                } else {
                                    completableDeferredCompletableDeferred$default.complete(Unit.INSTANCE);
                                }
                            }
                        });
                        this.L$0 = httpStatement;
                        this.L$1 = httpResponse2;
                        this.L$2 = null;
                        this.label = 3;
                        if (completableDeferredCompletableDeferred$default.await(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        httpStatement2 = httpStatement;
                        this.L$0 = Unit.INSTANCE;
                        this.L$1 = null;
                        this.label = 4;
                        if (httpStatement2.cleanup(httpResponse2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th5) {
                        httpStatement2 = httpStatement;
                        httpResponse2 = httpResponse;
                        th = th5;
                        this.L$0 = th;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.label = 5;
                        if (httpStatement2.cleanup(httpResponse2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        throw th;
                    }
                    httpResponse = (HttpResponse) obj;
                } catch (CancellationException e) {
                    throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
                }
            } catch (Throwable th6) {
                this.$sessionDeferred.completeExceptionally(th6);
            }
        }
    }

    public static /* synthetic */ Object webSocketSession$default(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            httpMethod = HttpMethod.INSTANCE.getGet();
        }
        HttpMethod httpMethod2 = httpMethod;
        String str3 = (i & 2) != 0 ? null : str;
        Integer num2 = (i & 4) != 0 ? null : num;
        String str4 = (i & 8) != 0 ? null : str2;
        if ((i & 16) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt.webSocketSession.4
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        return webSocketSession(httpClient, httpMethod2, str3, num2, str4, function1, continuation);
    }

    public static final Object webSocketSession(HttpClient httpClient, final HttpMethod httpMethod, final String str, final Integer num, final String str2, final Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super DefaultClientWebSocketSession> continuation) {
        return webSocketSession(httpClient, new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt.webSocketSession.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                invoke2(httpRequestBuilder);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HttpRequestBuilder webSocketSession) {
                Intrinsics.checkNotNullParameter(webSocketSession, "$this$webSocketSession");
                webSocketSession.setMethod(httpMethod);
                HttpRequestKt.url$default(webSocketSession, "ws", str, num, str2, null, 16, null);
                function1.invoke(webSocketSession);
            }
        }, continuation);
    }

    public static /* synthetic */ Object webSocketSession$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt.webSocketSession.7
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        return webSocketSession(httpClient, str, function1, continuation);
    }

    public static final Object webSocketSession(HttpClient httpClient, final String str, final Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super DefaultClientWebSocketSession> continuation) {
        return webSocketSession(httpClient, new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt.webSocketSession.8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                invoke2(httpRequestBuilder);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HttpRequestBuilder webSocketSession) {
                Intrinsics.checkNotNullParameter(webSocketSession, "$this$webSocketSession");
                URLParserKt.takeFrom(webSocketSession.getUrl(), str);
                function1.invoke(webSocketSession);
            }
        }, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00fb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:48:0x0101 A[Catch: all -> 0x0094, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0094, blocks: (B:19:0x0050, B:67:0x015d, B:68:0x0164, B:22:0x0063, B:56:0x012a, B:53:0x0117, B:64:0x0148, B:30:0x0090, B:48:0x0101, B:69:0x0165, B:70:0x016c), top: B:80:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x0115 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:52:0x0116  */
    /* JADX WARN: Code duplicated, block: B:55:0x0129 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:59:0x0142 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:66:0x015c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:69:0x0165 A[Catch: all -> 0x0094, TryCatch #0 {all -> 0x0094, blocks: (B:19:0x0050, B:67:0x015d, B:68:0x0164, B:22:0x0063, B:56:0x012a, B:53:0x0117, B:64:0x0148, B:30:0x0090, B:48:0x0101, B:69:0x0165, B:70:0x016c), top: B:80:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.Object, kotlin.jvm.functions.Function2<? super io.ktor.client.plugins.websocket.DefaultClientWebSocketSession, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r10v1, types: [io.ktor.client.statement.HttpResponse] */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [io.ktor.client.statement.HttpStatement] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14, types: [io.ktor.client.statement.HttpStatement] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v13, types: [kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r8v43 */
    public static final Object webSocket(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) throws Throwable {
        C46691 c46691;
        ?? r10;
        HttpResponse httpResponse;
        HttpResponse httpResponse2;
        ?? r8;
        ?? r2;
        DefaultClientWebSocketSession defaultClientWebSocketSession;
        DefaultClientWebSocketSession defaultClientWebSocketSession2;
        DefaultClientWebSocketSession defaultClientWebSocketSession3;
        ?? r3;
        ?? r4;
        ?? r5;
        if (continuation instanceof C46691) {
            c46691 = (C46691) continuation;
            if ((c46691.label & Integer.MIN_VALUE) != 0) {
                c46691.label -= Integer.MIN_VALUE;
            } else {
                c46691 = new C46691(continuation);
            }
        } else {
            c46691 = new C46691(continuation);
        }
        Object objExecuteUnsafe = c46691.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r6 = c46691.label;
        try {
            try {
                switch (r6) {
                    case 0:
                        ResultKt.throwOnFailure(objExecuteUnsafe);
                        HttpClientPluginKt.plugin(httpClient, WebSockets.INSTANCE);
                        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                        httpRequestBuilder.url(new Function2<URLBuilder, URLBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt$webSocket$session$1$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(URLBuilder uRLBuilder, URLBuilder uRLBuilder2) {
                                invoke2(uRLBuilder, uRLBuilder2);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(URLBuilder url, URLBuilder it) {
                                Intrinsics.checkNotNullParameter(url, "$this$url");
                                Intrinsics.checkNotNullParameter(it, "it");
                                url.setProtocol(URLProtocol.INSTANCE.getWS());
                            }
                        });
                        function1.invoke(httpRequestBuilder);
                        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                        c46691.L$0 = function2;
                        c46691.L$1 = httpStatement;
                        c46691.label = 1;
                        objExecuteUnsafe = httpStatement.executeUnsafe(c46691);
                        if (objExecuteUnsafe == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        r6 = httpStatement;
                        r10 = function2;
                        httpResponse = (HttpResponse) objExecuteUnsafe;
                        try {
                            HttpClientCall call = httpResponse.getCall();
                            KType kTypeTypeOf = Reflection.typeOf(DefaultClientWebSocketSession.class);
                            TypeInfo typeInfoTypeInfoImpl = TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(kTypeTypeOf), Reflection.getOrCreateKotlinClass(DefaultClientWebSocketSession.class), kTypeTypeOf);
                            c46691.L$0 = r10;
                            c46691.L$1 = r6;
                            c46691.L$2 = httpResponse;
                            c46691.label = 2;
                            objExecuteUnsafe = call.bodyNullable(typeInfoTypeInfoImpl, c46691);
                            if (objExecuteUnsafe == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ?? r7 = r10;
                            httpResponse2 = httpResponse;
                            r8 = r7;
                            if (objExecuteUnsafe == null) {
                                r2 = r6;
                                throw new NullPointerException("null cannot be cast to non-null type io.ktor.client.plugins.websocket.DefaultClientWebSocketSession");
                            }
                            r2 = r6;
                            defaultClientWebSocketSession = (DefaultClientWebSocketSession) objExecuteUnsafe;
                            try {
                                c46691.L$0 = r2;
                                c46691.L$1 = httpResponse2;
                                c46691.L$2 = defaultClientWebSocketSession;
                                c46691.label = 3;
                                if (r8.invoke(defaultClientWebSocketSession, c46691) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                defaultClientWebSocketSession3 = defaultClientWebSocketSession;
                                r4 = r2;
                                c46691.L$0 = r4;
                                c46691.L$1 = httpResponse2;
                                c46691.L$2 = defaultClientWebSocketSession3;
                                c46691.label = 4;
                                r5 = r4;
                                if (WebSocketSessionKt.close$default(defaultClientWebSocketSession3, null, c46691, 1, null) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) defaultClientWebSocketSession3.getIncoming(), (CancellationException) null, 1, (Object) null);
                                c46691.L$0 = Unit.INSTANCE;
                                c46691.L$1 = null;
                                c46691.L$2 = null;
                                c46691.label = 6;
                                if (r5.cleanup(httpResponse2, c46691) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return Unit.INSTANCE;
                            } catch (Throwable th) {
                                th = th;
                                defaultClientWebSocketSession2 = defaultClientWebSocketSession;
                                r3 = r2;
                                c46691.L$0 = r3;
                                c46691.L$1 = httpResponse2;
                                c46691.L$2 = defaultClientWebSocketSession2;
                                c46691.L$3 = th;
                                c46691.label = 5;
                                if (WebSocketSessionKt.close$default(defaultClientWebSocketSession2, null, c46691, 1, null) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) defaultClientWebSocketSession2.getIncoming(), (CancellationException) null, 1, (Object) null);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            function2 = httpResponse;
                            th = th2;
                            c46691.L$0 = th;
                            c46691.L$1 = null;
                            c46691.L$2 = null;
                            c46691.L$3 = null;
                            c46691.label = 7;
                            if (r6.cleanup(function2, c46691) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            throw th;
                        }
                    case 1:
                        HttpStatement httpStatement2 = (HttpStatement) c46691.L$1;
                        Function2 function3 = (Function2) c46691.L$0;
                        ResultKt.throwOnFailure(objExecuteUnsafe);
                        r6 = httpStatement2;
                        r10 = function3;
                        httpResponse = (HttpResponse) objExecuteUnsafe;
                        HttpClientCall call2 = httpResponse.getCall();
                        KType kTypeTypeOf2 = Reflection.typeOf(DefaultClientWebSocketSession.class);
                        TypeInfo typeInfoTypeInfoImpl2 = TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(kTypeTypeOf2), Reflection.getOrCreateKotlinClass(DefaultClientWebSocketSession.class), kTypeTypeOf2);
                        c46691.L$0 = r10;
                        c46691.L$1 = r6;
                        c46691.L$2 = httpResponse;
                        c46691.label = 2;
                        objExecuteUnsafe = call2.bodyNullable(typeInfoTypeInfoImpl2, c46691);
                        if (objExecuteUnsafe == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ?? r9 = r10;
                        httpResponse2 = httpResponse;
                        r8 = r9;
                        if (objExecuteUnsafe == null) {
                            r2 = r6;
                            throw new NullPointerException("null cannot be cast to non-null type io.ktor.client.plugins.websocket.DefaultClientWebSocketSession");
                        }
                        r2 = r6;
                        defaultClientWebSocketSession = (DefaultClientWebSocketSession) objExecuteUnsafe;
                        c46691.L$0 = r2;
                        c46691.L$1 = httpResponse2;
                        c46691.L$2 = defaultClientWebSocketSession;
                        c46691.label = 3;
                        if (r8.invoke(defaultClientWebSocketSession, c46691) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        defaultClientWebSocketSession3 = defaultClientWebSocketSession;
                        r4 = r2;
                        c46691.L$0 = r4;
                        c46691.L$1 = httpResponse2;
                        c46691.L$2 = defaultClientWebSocketSession3;
                        c46691.label = 4;
                        r5 = r4;
                        if (WebSocketSessionKt.close$default(defaultClientWebSocketSession3, null, c46691, 1, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) defaultClientWebSocketSession3.getIncoming(), (CancellationException) null, 1, (Object) null);
                        c46691.L$0 = Unit.INSTANCE;
                        c46691.L$1 = null;
                        c46691.L$2 = null;
                        c46691.label = 6;
                        if (r5.cleanup(httpResponse2, c46691) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 2:
                        httpResponse2 = (HttpResponse) c46691.L$2;
                        HttpStatement httpStatement3 = (HttpStatement) c46691.L$1;
                        Function2 function4 = (Function2) c46691.L$0;
                        ResultKt.throwOnFailure(objExecuteUnsafe);
                        r2 = httpStatement3;
                        r8 = function4;
                        if (objExecuteUnsafe == null) {
                            r2 = r6;
                            throw new NullPointerException("null cannot be cast to non-null type io.ktor.client.plugins.websocket.DefaultClientWebSocketSession");
                        }
                        r2 = r6;
                        defaultClientWebSocketSession = (DefaultClientWebSocketSession) objExecuteUnsafe;
                        c46691.L$0 = r2;
                        c46691.L$1 = httpResponse2;
                        c46691.L$2 = defaultClientWebSocketSession;
                        c46691.label = 3;
                        if (r8.invoke(defaultClientWebSocketSession, c46691) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        defaultClientWebSocketSession3 = defaultClientWebSocketSession;
                        r4 = r2;
                        c46691.L$0 = r4;
                        c46691.L$1 = httpResponse2;
                        c46691.L$2 = defaultClientWebSocketSession3;
                        c46691.label = 4;
                        r5 = r4;
                        if (WebSocketSessionKt.close$default(defaultClientWebSocketSession3, null, c46691, 1, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) defaultClientWebSocketSession3.getIncoming(), (CancellationException) null, 1, (Object) null);
                        c46691.L$0 = Unit.INSTANCE;
                        c46691.L$1 = null;
                        c46691.L$2 = null;
                        c46691.label = 6;
                        if (r5.cleanup(httpResponse2, c46691) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 3:
                        defaultClientWebSocketSession3 = (DefaultClientWebSocketSession) c46691.L$2;
                        HttpResponse httpResponse3 = (HttpResponse) c46691.L$1;
                        HttpStatement httpStatement4 = (HttpStatement) c46691.L$0;
                        try {
                            ResultKt.throwOnFailure(objExecuteUnsafe);
                            r4 = httpStatement4;
                            httpResponse2 = httpResponse3;
                            c46691.L$0 = r4;
                            c46691.L$1 = httpResponse2;
                            c46691.L$2 = defaultClientWebSocketSession3;
                            c46691.label = 4;
                            r5 = r4;
                            if (WebSocketSessionKt.close$default(defaultClientWebSocketSession3, null, c46691, 1, null) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) defaultClientWebSocketSession3.getIncoming(), (CancellationException) null, 1, (Object) null);
                            c46691.L$0 = Unit.INSTANCE;
                            c46691.L$1 = null;
                            c46691.L$2 = null;
                            c46691.label = 6;
                            if (r5.cleanup(httpResponse2, c46691) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        } catch (Throwable th3) {
                            r3 = httpStatement4;
                            httpResponse2 = httpResponse3;
                            defaultClientWebSocketSession2 = defaultClientWebSocketSession3;
                            th = th3;
                            c46691.L$0 = r3;
                            c46691.L$1 = httpResponse2;
                            c46691.L$2 = defaultClientWebSocketSession2;
                            c46691.L$3 = th;
                            c46691.label = 5;
                            if (WebSocketSessionKt.close$default(defaultClientWebSocketSession2, null, c46691, 1, null) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) defaultClientWebSocketSession2.getIncoming(), (CancellationException) null, 1, (Object) null);
                            throw th;
                        }
                    case 4:
                        defaultClientWebSocketSession3 = (DefaultClientWebSocketSession) c46691.L$2;
                        httpResponse2 = (HttpResponse) c46691.L$1;
                        HttpStatement httpStatement5 = (HttpStatement) c46691.L$0;
                        ResultKt.throwOnFailure(objExecuteUnsafe);
                        r5 = httpStatement5;
                        ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) defaultClientWebSocketSession3.getIncoming(), (CancellationException) null, 1, (Object) null);
                        c46691.L$0 = Unit.INSTANCE;
                        c46691.L$1 = null;
                        c46691.L$2 = null;
                        c46691.label = 6;
                        if (r5.cleanup(httpResponse2, c46691) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 5:
                        th = (Throwable) c46691.L$3;
                        defaultClientWebSocketSession2 = (DefaultClientWebSocketSession) c46691.L$2;
                        ResultKt.throwOnFailure(objExecuteUnsafe);
                        ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) defaultClientWebSocketSession2.getIncoming(), (CancellationException) null, 1, (Object) null);
                        throw th;
                    case 6:
                        ResultKt.throwOnFailure(objExecuteUnsafe);
                        return Unit.INSTANCE;
                    case 7:
                        th = (Throwable) c46691.L$0;
                        ResultKt.throwOnFailure(objExecuteUnsafe);
                        throw th;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (CancellationException e) {
                throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static final Object webSocket(HttpClient httpClient, final HttpMethod httpMethod, final String str, final Integer num, final String str2, final Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) throws Throwable {
        Object objWebSocket = webSocket(httpClient, new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt.webSocket.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                invoke2(httpRequestBuilder);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HttpRequestBuilder webSocket) {
                Intrinsics.checkNotNullParameter(webSocket, "$this$webSocket");
                webSocket.setMethod(httpMethod);
                HttpRequestKt.url$default(webSocket, "ws", str, num, str2, null, 16, null);
                function1.invoke(webSocket);
            }
        }, function2, continuation);
        return objWebSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWebSocket : Unit.INSTANCE;
    }

    public static /* synthetic */ Object webSocket$default(HttpClient httpClient, String str, Function1 function1, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt.webSocket.7
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        return webSocket(httpClient, str, function1, function2, continuation);
    }

    public static final Object webSocket(HttpClient httpClient, final String str, final Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) throws Throwable {
        Object objWebSocket = webSocket(httpClient, HttpMethod.INSTANCE.getGet(), null, null, null, new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt.webSocket.8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                invoke2(httpRequestBuilder);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HttpRequestBuilder webSocket) {
                Intrinsics.checkNotNullParameter(webSocket, "$this$webSocket");
                webSocket.getUrl().setProtocol(URLProtocol.INSTANCE.getWS());
                webSocket.getUrl().setPort(UtilsKt.getPort(webSocket));
                URLParserKt.takeFrom(webSocket.getUrl(), str);
                function1.invoke(webSocket);
            }
        }, function2, continuation);
        return objWebSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWebSocket : Unit.INSTANCE;
    }

    public static final Object ws(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) throws Throwable {
        Object objWebSocket = webSocket(httpClient, httpMethod, str, num, str2, function1, function2, continuation);
        return objWebSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWebSocket : Unit.INSTANCE;
    }

    public static final Object ws(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) throws Throwable {
        Object objWebSocket = webSocket(httpClient, function1, function2, continuation);
        return objWebSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWebSocket : Unit.INSTANCE;
    }

    public static /* synthetic */ Object ws$default(HttpClient httpClient, String str, Function1 function1, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt.ws.5
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        return ws(httpClient, str, function1, function2, continuation);
    }

    public static final Object ws(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) throws Throwable {
        Object objWebSocket = webSocket(httpClient, str, function1, function2, continuation);
        return objWebSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWebSocket : Unit.INSTANCE;
    }

    public static final Object wss(HttpClient httpClient, final Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) throws Throwable {
        Object objWebSocket = webSocket(httpClient, new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt.wss.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                invoke2(httpRequestBuilder);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HttpRequestBuilder webSocket) {
                Intrinsics.checkNotNullParameter(webSocket, "$this$webSocket");
                webSocket.getUrl().setProtocol(URLProtocol.INSTANCE.getWSS());
                webSocket.getUrl().setPort(webSocket.getUrl().getProtocol().getDefaultPort());
                function1.invoke(webSocket);
            }
        }, function2, continuation);
        return objWebSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWebSocket : Unit.INSTANCE;
    }

    public static /* synthetic */ Object wss$default(HttpClient httpClient, String str, Function1 function1, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt.wss.4
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        return wss(httpClient, str, function1, function2, continuation);
    }

    public static final Object wss(HttpClient httpClient, final String str, final Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) throws Throwable {
        Object objWss = wss(httpClient, new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt.wss.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                invoke2(httpRequestBuilder);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HttpRequestBuilder wss) {
                Intrinsics.checkNotNullParameter(wss, "$this$wss");
                URLParserKt.takeFrom(wss.getUrl(), str);
                function1.invoke(wss);
            }
        }, function2, continuation);
        return objWss == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWss : Unit.INSTANCE;
    }

    public static final Object wss(HttpClient httpClient, HttpMethod httpMethod, String str, final Integer num, String str2, final Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) throws Throwable {
        Object objWebSocket = webSocket(httpClient, httpMethod, str, num, str2, new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt.wss.8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                invoke2(httpRequestBuilder);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HttpRequestBuilder webSocket) {
                Intrinsics.checkNotNullParameter(webSocket, "$this$webSocket");
                webSocket.getUrl().setProtocol(URLProtocol.INSTANCE.getWSS());
                if (num != null) {
                    webSocket.getUrl().setPort(num.intValue());
                }
                function1.invoke(webSocket);
            }
        }, function2, continuation);
        return objWebSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWebSocket : Unit.INSTANCE;
    }
}
