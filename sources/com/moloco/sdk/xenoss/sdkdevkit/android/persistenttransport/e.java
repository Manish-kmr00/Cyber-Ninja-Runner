package com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport;

import android.util.Patterns;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.moloco.sdk.internal.MolocoLogger;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.reflect.TypeInfoJvmKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes8.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7193a = "HttpRequestClient";
    public static final long b = 5000;
    public static final int c = 5;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.HttpRequestClientKt", f = "HttpRequestClient.kt", i = {}, l = {34}, m = "sendGetRequest", n = {}, s = {})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f7194a;
        public int b;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f7194a = obj;
            this.b |= Integer.MIN_VALUE;
            return e.a(null, null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.HttpRequestClientKt$sendGetRequest$2", f = "HttpRequestClient.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7195a;
        public final /* synthetic */ HttpClient b;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(HttpClient httpClient, String str, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = httpClient;
            this.c = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f7195a;
            boolean z = true;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HttpClient httpClient = this.b;
                String str = this.c;
                HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                HttpRequestKt.url(httpRequestBuilder, str);
                com.moloco.sdk.xenoss.sdkdevkit.android.core.a.a(httpRequestBuilder, 5000L);
                httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
                HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                this.f7195a = 1;
                obj = httpStatement.execute(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            HttpStatusCode status = ((HttpResponse) obj).getStatus();
            HttpStatusCode.Companion companion = HttpStatusCode.INSTANCE;
            if (!Intrinsics.areEqual(status, companion.getOK()) && !Intrinsics.areEqual(status, companion.getNoContent())) {
                z = false;
            }
            return Boxing.boxBoolean(z);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.HttpRequestClientKt", f = "HttpRequestClient.kt", i = {}, l = {46}, m = "sendPostRequest", n = {}, s = {})
    public static final class c extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f7196a;
        public int b;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f7196a = obj;
            this.b |= Integer.MIN_VALUE;
            return e.a(null, null, null, null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.HttpRequestClientKt$sendPostRequest$2", f = "HttpRequestClient.kt", i = {}, l = {IronSourceConstants.TROUBLESHOOTING_AD_QUALITY_SDK_INITIALIZED_SUCCESSFULLY_EVENT}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7197a;
        public final /* synthetic */ HttpClient b;
        public final /* synthetic */ String c;
        public final /* synthetic */ byte[] d;
        public final /* synthetic */ ContentType e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(HttpClient httpClient, String str, byte[] bArr, ContentType contentType, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = httpClient;
            this.c = str;
            this.d = bArr;
            this.e = contentType;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, this.c, this.d, this.e, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f7197a;
            boolean z = true;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HttpClient httpClient = this.b;
                String str = this.c;
                byte[] bArr = this.d;
                ContentType contentType = this.e;
                HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                HttpRequestKt.url(httpRequestBuilder, str);
                if (bArr == null) {
                    httpRequestBuilder.setBody(NullBody.INSTANCE);
                    KType kTypeTypeOf = Reflection.typeOf(byte[].class);
                    httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(kTypeTypeOf), Reflection.getOrCreateKotlinClass(byte[].class), kTypeTypeOf));
                } else if (bArr instanceof OutgoingContent) {
                    httpRequestBuilder.setBody(bArr);
                    httpRequestBuilder.setBodyType(null);
                } else {
                    httpRequestBuilder.setBody(bArr);
                    KType kTypeTypeOf2 = Reflection.typeOf(byte[].class);
                    httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(kTypeTypeOf2), Reflection.getOrCreateKotlinClass(byte[].class), kTypeTypeOf2));
                }
                HttpMessagePropertiesKt.contentType(httpRequestBuilder, contentType);
                com.moloco.sdk.xenoss.sdkdevkit.android.core.a.a(httpRequestBuilder, 5000L);
                httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
                HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                this.f7197a = 1;
                obj = httpStatement.execute(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            HttpStatusCode status = ((HttpResponse) obj).getStatus();
            MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, "HttpClient", "Response status: " + status + " for url: " + this.c, false, 4, null);
            HttpStatusCode.Companion companion = HttpStatusCode.INSTANCE;
            if (!Intrinsics.areEqual(status, companion.getOK()) && !Intrinsics.areEqual(status, companion.getNoContent())) {
                z = false;
            }
            return Boxing.boxBoolean(z);
        }
    }

    public static final boolean a(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        boolean zMatches = Patterns.WEB_URL.matcher(str).matches();
        if (!zMatches) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, f7193a, "URL is invalid. " + str, null, false, 12, null);
        }
        return zMatches;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object a(HttpClient httpClient, String str, Continuation<? super Boolean> continuation) throws Throwable {
        a aVar;
        boolean zBooleanValue;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.b;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.b = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object objWithContext = aVar.f7194a;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.b;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objWithContext);
                CoroutineContext io2 = com.moloco.sdk.internal.scheduling.b.a().getIo();
                b bVar = new b(httpClient, str, null);
                aVar.b = 1;
                objWithContext = BuildersKt.withContext(io2, bVar, aVar);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objWithContext);
            }
            zBooleanValue = ((Boolean) objWithContext).booleanValue();
        } catch (Exception unused) {
            zBooleanValue = false;
        }
        return Boxing.boxBoolean(zBooleanValue);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object a(HttpClient httpClient, String str, byte[] bArr, ContentType contentType, Continuation<? super Boolean> continuation) throws Throwable {
        c cVar;
        boolean zBooleanValue;
        if (continuation instanceof c) {
            cVar = (c) continuation;
            int i = cVar.b;
            if ((i & Integer.MIN_VALUE) != 0) {
                cVar.b = i - Integer.MIN_VALUE;
            } else {
                cVar = new c(continuation);
            }
        } else {
            cVar = new c(continuation);
        }
        Object objWithContext = cVar.f7196a;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = cVar.b;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objWithContext);
                CoroutineContext io2 = com.moloco.sdk.internal.scheduling.b.a().getIo();
                d dVar = new d(httpClient, str, bArr, contentType, null);
                cVar.b = 1;
                objWithContext = BuildersKt.withContext(io2, dVar, cVar);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objWithContext);
            }
            zBooleanValue = ((Boolean) objWithContext).booleanValue();
        } catch (Exception unused) {
            zBooleanValue = false;
        }
        return Boxing.boxBoolean(zBooleanValue);
    }
}
