package io.ktor.client.statement;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.call.SavedCallKt;
import io.ktor.client.engine.HttpClientEngineCapabilityKt;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.util.reflect.TypeInfoJvmKt;
import io.ktor.utils.io.ByteReadChannelKt;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: HttpStatement.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u000b\u001a\u0002H\f\"\u0006\b\u0000\u0010\f\u0018\u0001H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\rJT\u0010\u000b\u001a\u0002H\u000e\"\u0006\b\u0000\u0010\f\u0018\u0001\"\u0004\b\u0001\u0010\u000e23\b\u0004\u0010\u000f\u001a-\b\u0001\u0012\u0013\u0012\u0011H\f¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0011\u0010\u0018\u001a\u00020\u0019H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\rJJ\u0010\u0018\u001a\u0002H\f\"\u0004\b\u0000\u0010\f21\u0010\u000f\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0011\u0010\u001a\u001a\u00020\u0019H\u0081@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0015\u0010\u001d\u001a\u00020\u0017*\u00020\u0019H\u0081@ø\u0001\u0000¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lio/ktor/client/statement/HttpStatement;", "", "builder", "Lio/ktor/client/request/HttpRequestBuilder;", "client", "Lio/ktor/client/HttpClient;", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/client/HttpClient;)V", "getClient$annotations", "()V", "getClient", "()Lio/ktor/client/HttpClient;", "body", "T", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "R", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "response", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkCapabilities", "", "execute", "Lio/ktor/client/statement/HttpResponse;", "executeUnsafe", "toString", "", "cleanup", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HttpStatement {
    private final HttpRequestBuilder builder;
    private final HttpClient client;

    /* JADX INFO: renamed from: io.ktor.client.statement.HttpStatement$cleanup$1, reason: invalid class name */
    /* JADX INFO: compiled from: HttpStatement.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", i = {}, l = {126}, m = "cleanup", n = {}, s = {})
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
            return HttpStatement.this.cleanup(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.statement.HttpStatement$execute$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HttpStatement.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", i = {0, 0, 1, 1}, l = {47, 50, 52, 52}, m = "execute", n = {"this", "block", "this", "response"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class C47321<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C47321(Continuation<? super C47321> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpStatement.this.execute(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.statement.HttpStatement$executeUnsafe$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HttpStatement.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", i = {}, l = {108}, m = "executeUnsafe", n = {}, s = {})
    static final class C47331 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C47331(Continuation<? super C47331> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpStatement.this.executeUnsafe(this);
        }
    }

    public static /* synthetic */ void getClient$annotations() {
    }

    public HttpStatement(HttpRequestBuilder builder, HttpClient client) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(client, "client");
        this.builder = builder;
        this.client = client;
        checkCapabilities();
    }

    public final HttpClient getClient() {
        return this.client;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0093 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x0094  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final <T> Object execute(Function2<? super HttpResponse, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) throws Throwable {
        C47321 c47321;
        HttpStatement httpStatement;
        HttpResponse httpResponse;
        HttpResponse httpResponse2;
        if (continuation instanceof C47321) {
            c47321 = (C47321) continuation;
            if ((c47321.label & Integer.MIN_VALUE) != 0) {
                c47321.label -= Integer.MIN_VALUE;
            } else {
                c47321 = new C47321(continuation);
            }
        } else {
            c47321 = new C47321(continuation);
        }
        Object objExecuteUnsafe = c47321.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c47321.label;
        try {
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(objExecuteUnsafe);
                    c47321.L$0 = this;
                    c47321.L$1 = function2;
                    c47321.label = 1;
                    objExecuteUnsafe = executeUnsafe(c47321);
                    if (objExecuteUnsafe == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    httpStatement = this;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3) {
                                Object obj = c47321.L$0;
                                ResultKt.throwOnFailure(objExecuteUnsafe);
                                return obj;
                            }
                            if (i != 4) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            th = (Throwable) c47321.L$0;
                            ResultKt.throwOnFailure(objExecuteUnsafe);
                            throw th;
                        }
                        httpResponse2 = (HttpResponse) c47321.L$1;
                        httpStatement = (HttpStatement) c47321.L$0;
                        try {
                            ResultKt.throwOnFailure(objExecuteUnsafe);
                            c47321.L$0 = objExecuteUnsafe;
                            c47321.L$1 = null;
                            c47321.label = 3;
                            if (httpStatement.cleanup(httpResponse2, c47321) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return objExecuteUnsafe;
                        } catch (Throwable th) {
                            httpResponse = httpResponse2;
                            th = th;
                            c47321.L$0 = th;
                            c47321.L$1 = null;
                            c47321.label = 4;
                            if (httpStatement.cleanup(httpResponse, c47321) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            throw th;
                        }
                    }
                    function2 = (Function2) c47321.L$1;
                    httpStatement = (HttpStatement) c47321.L$0;
                    ResultKt.throwOnFailure(objExecuteUnsafe);
                }
                c47321.L$0 = httpStatement;
                c47321.L$1 = httpResponse;
                c47321.label = 2;
                Object objInvoke = function2.invoke(httpResponse, c47321);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objExecuteUnsafe = objInvoke;
                httpResponse2 = httpResponse;
                c47321.L$0 = objExecuteUnsafe;
                c47321.L$1 = null;
                c47321.label = 3;
                if (httpStatement.cleanup(httpResponse2, c47321) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objExecuteUnsafe;
            } catch (Throwable th2) {
                th = th2;
                c47321.L$0 = th;
                c47321.L$1 = null;
                c47321.label = 4;
                if (httpStatement.cleanup(httpResponse, c47321) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                throw th;
            }
            httpResponse = (HttpResponse) objExecuteUnsafe;
        } catch (CancellationException e) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.statement.HttpStatement$execute$4, reason: invalid class name */
    /* JADX INFO: compiled from: HttpStatement.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lio/ktor/client/statement/HttpResponse;", "it"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.HttpStatement$execute$4", f = "HttpStatement.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<HttpResponse, Continuation<? super HttpResponse>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(continuation);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(HttpResponse httpResponse, Continuation<? super HttpResponse> continuation) {
            return ((AnonymousClass4) create(httpResponse, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = SavedCallKt.save(((HttpResponse) this.L$0).getCall(), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return ((HttpClientCall) obj).getResponse();
        }
    }

    public final Object execute(Continuation<? super HttpResponse> continuation) {
        return execute(new AnonymousClass4(null), continuation);
    }

    public final /* synthetic */ <T> Object body(Continuation<? super T> continuation) throws Throwable {
        try {
            InlineMarker.mark(3);
            InlineMarker.mark(0);
            Object objExecuteUnsafe = executeUnsafe(null);
            InlineMarker.mark(1);
            HttpResponse httpResponse = (HttpResponse) objExecuteUnsafe;
            try {
                InlineMarker.mark(3);
                HttpClientCall call = httpResponse.getCall();
                Intrinsics.reifiedOperationMarker(6, "T");
                Type javaType = TypesJVMKt.getJavaType((KType) null);
                Intrinsics.reifiedOperationMarker(4, "T");
                TypeInfo typeInfoTypeInfoImpl = TypeInfoJvmKt.typeInfoImpl(javaType, Reflection.getOrCreateKotlinClass(Object.class), null);
                InlineMarker.mark(0);
                Object objBodyNullable = call.bodyNullable(typeInfoTypeInfoImpl, null);
                InlineMarker.mark(1);
                Intrinsics.reifiedOperationMarker(1, "T");
                Object obj = objBodyNullable;
                return objBodyNullable;
            } finally {
                InlineMarker.finallyStart(1);
                HttpResponseKt.complete(httpResponse);
                InlineMarker.finallyEnd(1);
            }
        } catch (CancellationException e) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
        }
    }

    public final /* synthetic */ <T, R> Object body(Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) throws Throwable {
        try {
            InlineMarker.mark(3);
            InlineMarker.mark(0);
            Object objExecuteUnsafe = executeUnsafe(null);
            InlineMarker.mark(1);
            HttpResponse httpResponse = (HttpResponse) objExecuteUnsafe;
            try {
                InlineMarker.mark(3);
                HttpClientCall call = httpResponse.getCall();
                Intrinsics.reifiedOperationMarker(6, "T");
                Type javaType = TypesJVMKt.getJavaType((KType) null);
                Intrinsics.reifiedOperationMarker(4, "T");
                TypeInfo typeInfoTypeInfoImpl = TypeInfoJvmKt.typeInfoImpl(javaType, Reflection.getOrCreateKotlinClass(Object.class), null);
                InlineMarker.mark(0);
                Object objBodyNullable = call.bodyNullable(typeInfoTypeInfoImpl, null);
                InlineMarker.mark(1);
                Intrinsics.reifiedOperationMarker(1, "T");
                Object obj = objBodyNullable;
                InlineMarker.mark(3);
                return function2.invoke(objBodyNullable, null);
            } finally {
                InlineMarker.finallyStart(1);
                InlineMarker.mark(3);
                InlineMarker.mark(0);
                cleanup(httpResponse, null);
                InlineMarker.mark(1);
                InlineMarker.finallyEnd(1);
            }
        } catch (CancellationException e) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object executeUnsafe(Continuation<? super HttpResponse> continuation) throws Throwable {
        C47331 c47331;
        if (continuation instanceof C47331) {
            c47331 = (C47331) continuation;
            if ((c47331.label & Integer.MIN_VALUE) != 0) {
                c47331.label -= Integer.MIN_VALUE;
            } else {
                c47331 = new C47331(continuation);
            }
        } else {
            c47331 = new C47331(continuation);
        }
        Object objExecute$ktor_client_core = c47331.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c47331.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objExecute$ktor_client_core);
                HttpRequestBuilder httpRequestBuilderTakeFromWithExecutionContext = new HttpRequestBuilder().takeFromWithExecutionContext(this.builder);
                HttpClient httpClient = this.client;
                c47331.label = 1;
                objExecute$ktor_client_core = httpClient.execute$ktor_client_core(httpRequestBuilderTakeFromWithExecutionContext, c47331);
                if (objExecute$ktor_client_core == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objExecute$ktor_client_core);
            }
            return ((HttpClientCall) objExecute$ktor_client_core).getResponse();
        } catch (CancellationException e) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object cleanup(HttpResponse httpResponse, Continuation<? super Unit> continuation) throws Throwable {
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
            CoroutineContext.Element element = httpResponse.getCoroutineContext().get(Job.INSTANCE);
            Intrinsics.checkNotNull(element);
            CompletableJob completableJob = (CompletableJob) element;
            completableJob.complete();
            try {
                ByteReadChannelKt.cancel(httpResponse.getContent());
            } catch (Throwable unused) {
            }
            anonymousClass1.L$0 = completableJob;
            anonymousClass1.label = 1;
            if (completableJob.join(anonymousClass1) == coroutine_suspended) {
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

    private final void checkCapabilities() {
        Set setKeySet;
        Map map = (Map) this.builder.getAttributes().getOrNull(HttpClientEngineCapabilityKt.getENGINE_CAPABILITIES_KEY());
        if (map == null || (setKeySet = map.keySet()) == null) {
            return;
        }
        ArrayList<HttpClientPlugin> arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (obj instanceof HttpClientPlugin) {
                arrayList.add(obj);
            }
        }
        for (HttpClientPlugin httpClientPlugin : arrayList) {
            if (HttpClientPluginKt.pluginOrNull(this.client, httpClientPlugin) == null) {
                throw new IllegalArgumentException(("Consider installing " + httpClientPlugin + " plugin because the request requires it to be installed").toString());
            }
        }
    }

    public String toString() {
        return "HttpStatement[" + this.builder.getUrl() + AbstractJsonLexerKt.END_LIST;
    }
}
