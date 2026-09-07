package io.ktor.client.engine.android;

import io.ktor.client.network.sockets.TimeoutExceptionsCommonKt;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.request.HttpRequestData;
import io.ktor.util.cio.ByteBufferPoolKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.ReadingKt;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.YieldKt;

/* JADX INFO: compiled from: AndroidURLConnectionUtils.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0002\u001a\u0014\u0010\n\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u0014\u0010\u000e\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0000\u001a7\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u0011*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00110\u0013H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"content", "Lio/ktor/utils/io/ByteReadChannel;", "Ljava/net/HttpURLConnection;", "callContext", "Lkotlin/coroutines/CoroutineContext;", "request", "Lio/ktor/client/request/HttpRequestData;", "isTimeoutException", "", "", "setupRequestTimeoutAttributes", "", "timeoutAttributes", "Lio/ktor/client/plugins/HttpTimeout$HttpTimeoutCapabilityConfiguration;", "setupTimeoutAttributes", "requestData", "timeoutAwareConnection", "T", "block", "Lkotlin/Function1;", "(Ljava/net/HttpURLConnection;Lio/ktor/client/request/HttpRequestData;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-android"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidURLConnectionUtilsKt {

    /* JADX INFO: renamed from: io.ktor.client.engine.android.AndroidURLConnectionUtilsKt$timeoutAwareConnection$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidURLConnectionUtils.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.android.AndroidURLConnectionUtilsKt", f = "AndroidURLConnectionUtils.kt", i = {0, 0}, l = {60}, m = "timeoutAwareConnection", n = {"request", "cause"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1<T> extends ContinuationImpl {
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
            return AndroidURLConnectionUtilsKt.timeoutAwareConnection(null, null, null, this);
        }
    }

    public static final void setupTimeoutAttributes(HttpURLConnection httpURLConnection, HttpRequestData requestData) {
        Intrinsics.checkNotNullParameter(httpURLConnection, "<this>");
        Intrinsics.checkNotNullParameter(requestData, "requestData");
        HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration = (HttpTimeout.HttpTimeoutCapabilityConfiguration) requestData.getCapabilityOrNull(HttpTimeout.INSTANCE);
        if (httpTimeoutCapabilityConfiguration != null) {
            Long l = httpTimeoutCapabilityConfiguration.get_connectTimeoutMillis();
            if (l != null) {
                httpURLConnection.setConnectTimeout(HttpTimeoutKt.convertLongTimeoutToIntWithInfiniteAsZero(l.longValue()));
            }
            Long l2 = httpTimeoutCapabilityConfiguration.get_socketTimeoutMillis();
            if (l2 != null) {
                httpURLConnection.setReadTimeout(HttpTimeoutKt.convertLongTimeoutToIntWithInfiniteAsZero(l2.longValue()));
            }
            setupRequestTimeoutAttributes(httpURLConnection, httpTimeoutCapabilityConfiguration);
        }
    }

    private static final void setupRequestTimeoutAttributes(HttpURLConnection httpURLConnection, HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration) {
        Long l = httpTimeoutCapabilityConfiguration.get_requestTimeoutMillis();
        if (l != null) {
            long jLongValue = l.longValue();
            if (jLongValue != Long.MAX_VALUE) {
                if (httpURLConnection.getConnectTimeout() == 0 || httpURLConnection.getConnectTimeout() > jLongValue) {
                    httpURLConnection.setConnectTimeout(HttpTimeoutKt.convertLongTimeoutToIntWithInfiniteAsZero(jLongValue));
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final <T> Object timeoutAwareConnection(HttpURLConnection httpURLConnection, HttpRequestData httpRequestData, Function1<? super HttpURLConnection, ? extends T> function1, Continuation<? super T> continuation) {
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
            try {
                return function1.invoke(httpURLConnection);
            } catch (Throwable th) {
                th = th;
                anonymousClass1.L$0 = httpRequestData;
                anonymousClass1.L$1 = th;
                anonymousClass1.label = 1;
                if (YieldKt.yield(anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            th = (Throwable) anonymousClass1.L$1;
            httpRequestData = (HttpRequestData) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (isTimeoutException(th)) {
            throw HttpTimeoutKt.ConnectTimeoutException(httpRequestData, th);
        }
        throw th;
    }

    public static final ByteReadChannel content(HttpURLConnection httpURLConnection, CoroutineContext callContext, HttpRequestData request) {
        ByteReadChannel byteReadChannel;
        ByteReadChannel byteReadChannelMapEngineExceptions;
        Intrinsics.checkNotNullParameter(httpURLConnection, "<this>");
        Intrinsics.checkNotNullParameter(callContext, "callContext");
        Intrinsics.checkNotNullParameter(request, "request");
        BufferedInputStream bufferedInputStream = null;
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            if (inputStream != null) {
                bufferedInputStream = inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, 8192);
            }
        } catch (IOException unused) {
            InputStream errorStream = httpURLConnection.getErrorStream();
            if (errorStream != null) {
                bufferedInputStream = errorStream instanceof BufferedInputStream ? (BufferedInputStream) errorStream : new BufferedInputStream(errorStream, 8192);
            }
        }
        return (bufferedInputStream == null || (byteReadChannel = ReadingKt.toByteReadChannel(bufferedInputStream, callContext, ByteBufferPoolKt.getKtorDefaultPool())) == null || (byteReadChannelMapEngineExceptions = TimeoutExceptionsCommonKt.mapEngineExceptions(CoroutineScopeKt.CoroutineScope(callContext), byteReadChannel, request)) == null) ? ByteReadChannel.INSTANCE.getEmpty() : byteReadChannelMapEngineExceptions;
    }

    private static final boolean isTimeoutException(Throwable th) {
        if (!(th instanceof SocketTimeoutException)) {
            if (!(th instanceof ConnectException)) {
                return false;
            }
            String message = th.getMessage();
            if (!(message != null ? StringsKt.contains$default((CharSequence) message, (CharSequence) "timed out", false, 2, (Object) null) : false)) {
                return false;
            }
        }
        return true;
    }
}
