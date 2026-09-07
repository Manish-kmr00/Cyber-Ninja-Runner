package io.ktor.client.engine.android;

import com.amazon.device.ads.DTBMetricsConfiguration;
import com.json.mediationsdk.utils.IronSourceConstants;
import io.ktor.client.engine.HttpClientEngineBase;
import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.engine.UtilsKt;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.http.HeadersImpl;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteReadChannel;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AndroidClientEngine.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lio/ktor/client/engine/android/AndroidClientEngine;", "Lio/ktor/client/engine/HttpClientEngineBase;", DTBMetricsConfiguration.CONFIG_DIR, "Lio/ktor/client/engine/android/AndroidEngineConfig;", "(Lio/ktor/client/engine/android/AndroidEngineConfig;)V", "getConfig", "()Lio/ktor/client/engine/android/AndroidEngineConfig;", "supportedCapabilities", "", "Lio/ktor/client/engine/HttpClientEngineCapability;", "getSupportedCapabilities", "()Ljava/util/Set;", "execute", "Lio/ktor/client/request/HttpResponseData;", "data", "Lio/ktor/client/request/HttpRequestData;", "(Lio/ktor/client/request/HttpRequestData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProxyAwareConnection", "Ljava/net/HttpURLConnection;", "urlString", "", "ktor-client-android"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidClientEngine extends HttpClientEngineBase {
    private final AndroidEngineConfig config;
    private final Set<HttpClientEngineCapability<?>> supportedCapabilities;

    /* JADX INFO: renamed from: io.ktor.client.engine.android.AndroidClientEngine$execute$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidClientEngine.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.android.AndroidClientEngine", f = "AndroidClientEngine.kt", i = {0, 0, 1, 1, 1}, l = {35, 79, IronSourceConstants.TROUBLESHOOTING_AD_QUALITY_SDK_WAS_ALREADY_INITIALIZED_EVENT}, m = "execute", n = {"this", "data", "data", "callContext", "requestTime"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidClientEngine.this.execute(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidClientEngine(AndroidEngineConfig config) {
        super("ktor-android");
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        this.supportedCapabilities = SetsKt.setOf(HttpTimeout.INSTANCE);
    }

    @Override // io.ktor.client.engine.HttpClientEngine
    public AndroidEngineConfig getConfig() {
        return this.config;
    }

    @Override // io.ktor.client.engine.HttpClientEngineBase, io.ktor.client.engine.HttpClientEngine
    public Set<HttpClientEngineCapability<?>> getSupportedCapabilities() {
        return this.supportedCapabilities;
    }

    /* JADX WARN: Code duplicated, block: B:52:0x019f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Override // io.ktor.client.engine.HttpClientEngine
    public Object execute(HttpRequestData httpRequestData, Continuation<? super HttpResponseData> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        final HttpRequestData httpRequestData2;
        Object objCallContext;
        AndroidClientEngine androidClientEngine;
        final CoroutineContext coroutineContext;
        final GMTDate gMTDateGMTDate$default;
        final HttpURLConnection proxyAwareConnection;
        Unit unit;
        HttpRequestData httpRequestData3;
        CoroutineContext coroutineContext2;
        GMTDate gMTDate;
        HttpURLConnection httpURLConnection;
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
        Object objTimeoutAwareConnection = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i != 0) {
            if (i == 1) {
                HttpRequestData httpRequestData4 = (HttpRequestData) anonymousClass1.L$1;
                androidClientEngine = (AndroidClientEngine) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objTimeoutAwareConnection);
                objCallContext = objTimeoutAwareConnection;
                httpRequestData2 = httpRequestData4;
            } else if (i == 2) {
                httpURLConnection = (HttpURLConnection) anonymousClass1.L$3;
                gMTDate = (GMTDate) anonymousClass1.L$2;
                coroutineContext2 = (CoroutineContext) anonymousClass1.L$1;
                httpRequestData3 = (HttpRequestData) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objTimeoutAwareConnection);
                proxyAwareConnection = httpURLConnection;
                gMTDateGMTDate$default = gMTDate;
                coroutineContext = coroutineContext2;
                httpRequestData2 = httpRequestData3;
                Function1<HttpURLConnection, HttpResponseData> function1 = new Function1<HttpURLConnection, HttpResponseData>() { // from class: io.ktor.client.engine.android.AndroidClientEngine.execute.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX WARN: Code duplicated, block: B:13:0x0073  */
                    @Override // kotlin.jvm.functions.Function1
                    public final HttpResponseData invoke(HttpURLConnection current) throws IOException {
                        HttpStatusCode httpStatusCodeFromValue;
                        String lowerCase;
                        Intrinsics.checkNotNullParameter(current, "current");
                        int responseCode = current.getResponseCode();
                        String responseMessage = current.getResponseMessage();
                        if (responseMessage != null) {
                            httpStatusCodeFromValue = new HttpStatusCode(responseCode, responseMessage);
                        } else {
                            httpStatusCodeFromValue = HttpStatusCode.INSTANCE.fromValue(responseCode);
                        }
                        HttpStatusCode httpStatusCode = httpStatusCodeFromValue;
                        ByteReadChannel byteReadChannelContent = AndroidURLConnectionUtilsKt.content(current, coroutineContext, httpRequestData2);
                        Map<String, List<String>> headerFields = current.getHeaderFields();
                        Intrinsics.checkNotNullExpressionValue(headerFields, "current.headerFields");
                        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(headerFields.size()));
                        Iterator<T> it = headerFields.entrySet().iterator();
                        while (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            String key = (String) entry.getKey();
                            if (key != null) {
                                Intrinsics.checkNotNullExpressionValue(key, "key");
                                Locale locale = Locale.getDefault();
                                Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                                lowerCase = key.toLowerCase(locale);
                                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                                if (lowerCase == null) {
                                    lowerCase = "";
                                }
                            } else {
                                lowerCase = "";
                            }
                            linkedHashMap.put(lowerCase, entry.getValue());
                        }
                        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                            if (!StringsKt.isBlank((CharSequence) entry2.getKey())) {
                                linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                            }
                        }
                        HttpProtocolVersion http_1_1 = HttpProtocolVersion.INSTANCE.getHTTP_1_1();
                        return new HttpResponseData(httpStatusCode, gMTDateGMTDate$default, new HeadersImpl(linkedHashMap2), http_1_1, byteReadChannelContent, coroutineContext);
                    }
                };
                anonymousClass1.L$0 = null;
                anonymousClass1.L$1 = null;
                anonymousClass1.L$2 = null;
                anonymousClass1.L$3 = null;
                anonymousClass1.label = 3;
                objTimeoutAwareConnection = AndroidURLConnectionUtilsKt.timeoutAwareConnection(proxyAwareConnection, httpRequestData2, function1, anonymousClass1);
                if (objTimeoutAwareConnection == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objTimeoutAwareConnection);
            }
            return objTimeoutAwareConnection;
        }
        ResultKt.throwOnFailure(objTimeoutAwareConnection);
        anonymousClass1.L$0 = this;
        httpRequestData2 = httpRequestData;
        anonymousClass1.L$1 = httpRequestData2;
        anonymousClass1.label = 1;
        objCallContext = UtilsKt.callContext(anonymousClass1);
        if (objCallContext == coroutine_suspended) {
            return coroutine_suspended;
        }
        androidClientEngine = this;
        coroutineContext = (CoroutineContext) objCallContext;
        gMTDateGMTDate$default = DateJvmKt.GMTDate$default(null, 1, null);
        String urlString = httpRequestData2.getUrl().getUrlString();
        OutgoingContent body = httpRequestData2.getBody();
        String str = httpRequestData2.getHeaders().get(HttpHeaders.INSTANCE.getContentLength());
        Long lBoxLong = str != null ? Boxing.boxLong(Long.parseLong(str)) : body.getContentLength();
        proxyAwareConnection = androidClientEngine.getProxyAwareConnection(urlString);
        proxyAwareConnection.setConnectTimeout(androidClientEngine.getConfig().getConnectTimeout());
        proxyAwareConnection.setReadTimeout(androidClientEngine.getConfig().getSocketTimeout());
        AndroidURLConnectionUtilsKt.setupTimeoutAttributes(proxyAwareConnection, httpRequestData2);
        if (proxyAwareConnection instanceof HttpsURLConnection) {
            androidClientEngine.getConfig().getSslManager().invoke(proxyAwareConnection);
        }
        proxyAwareConnection.setRequestMethod(httpRequestData2.getMethod().getValue());
        proxyAwareConnection.setUseCaches(false);
        proxyAwareConnection.setInstanceFollowRedirects(false);
        UtilsKt.mergeHeaders(httpRequestData2.getHeaders(), body, new Function2<String, String, Unit>() { // from class: io.ktor.client.engine.android.AndroidClientEngine$execute$connection$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str2, String str3) {
                invoke2(str2, str3);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String key, String value) {
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(value, "value");
                proxyAwareConnection.addRequestProperty(key, value);
            }
        });
        androidClientEngine.getConfig().getRequestConfig().invoke(proxyAwareConnection);
        if (AndroidClientEngineKt.METHODS_WITHOUT_BODY.contains(httpRequestData2.getMethod())) {
            if (!(body instanceof OutgoingContent.NoContent)) {
                throw new IllegalStateException(("Request of type " + httpRequestData2.getMethod() + " couldn't send a body with the [Android] engine.").toString());
            }
        } else {
            if (lBoxLong == null && proxyAwareConnection.getRequestProperty(HttpHeaders.INSTANCE.getTransferEncoding()) == null) {
                proxyAwareConnection.addRequestProperty(HttpHeaders.INSTANCE.getTransferEncoding(), "chunked");
            }
            if (lBoxLong != null) {
                proxyAwareConnection.setFixedLengthStreamingMode(lBoxLong.longValue());
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                proxyAwareConnection.setChunkedStreamingMode(0);
            }
            proxyAwareConnection.setDoOutput(true);
            OutputStream outputStream = proxyAwareConnection.getOutputStream();
            Intrinsics.checkNotNullExpressionValue(outputStream, "outputStream");
            anonymousClass1.L$0 = httpRequestData2;
            anonymousClass1.L$1 = coroutineContext;
            anonymousClass1.L$2 = gMTDateGMTDate$default;
            anonymousClass1.L$3 = proxyAwareConnection;
            anonymousClass1.label = 2;
            if (AndroidClientEngineKt.writeTo(body, outputStream, coroutineContext, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            httpRequestData3 = httpRequestData2;
            coroutineContext2 = coroutineContext;
            gMTDate = gMTDateGMTDate$default;
            httpURLConnection = proxyAwareConnection;
            proxyAwareConnection = httpURLConnection;
            gMTDateGMTDate$default = gMTDate;
            coroutineContext = coroutineContext2;
            httpRequestData2 = httpRequestData3;
        }
        Function1<HttpURLConnection, HttpResponseData> function2 = new Function1<HttpURLConnection, HttpResponseData>() { // from class: io.ktor.client.engine.android.AndroidClientEngine.execute.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Code duplicated, block: B:13:0x0073  */
            @Override // kotlin.jvm.functions.Function1
            public final HttpResponseData invoke(HttpURLConnection current) throws IOException {
                HttpStatusCode httpStatusCodeFromValue;
                String lowerCase;
                Intrinsics.checkNotNullParameter(current, "current");
                int responseCode = current.getResponseCode();
                String responseMessage = current.getResponseMessage();
                if (responseMessage != null) {
                    httpStatusCodeFromValue = new HttpStatusCode(responseCode, responseMessage);
                } else {
                    httpStatusCodeFromValue = HttpStatusCode.INSTANCE.fromValue(responseCode);
                }
                HttpStatusCode httpStatusCode = httpStatusCodeFromValue;
                ByteReadChannel byteReadChannelContent = AndroidURLConnectionUtilsKt.content(current, coroutineContext, httpRequestData2);
                Map<String, List<String>> headerFields = current.getHeaderFields();
                Intrinsics.checkNotNullExpressionValue(headerFields, "current.headerFields");
                LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(headerFields.size()));
                Iterator<T> it = headerFields.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    String key = (String) entry.getKey();
                    if (key != null) {
                        Intrinsics.checkNotNullExpressionValue(key, "key");
                        Locale locale = Locale.getDefault();
                        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                        lowerCase = key.toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                        if (lowerCase == null) {
                            lowerCase = "";
                        }
                    } else {
                        lowerCase = "";
                    }
                    linkedHashMap.put(lowerCase, entry.getValue());
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                    if (!StringsKt.isBlank((CharSequence) entry2.getKey())) {
                        linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                    }
                }
                HttpProtocolVersion http_1_1 = HttpProtocolVersion.INSTANCE.getHTTP_1_1();
                return new HttpResponseData(httpStatusCode, gMTDateGMTDate$default, new HeadersImpl(linkedHashMap2), http_1_1, byteReadChannelContent, coroutineContext);
            }
        };
        anonymousClass1.L$0 = null;
        anonymousClass1.L$1 = null;
        anonymousClass1.L$2 = null;
        anonymousClass1.L$3 = null;
        anonymousClass1.label = 3;
        objTimeoutAwareConnection = AndroidURLConnectionUtilsKt.timeoutAwareConnection(proxyAwareConnection, httpRequestData2, function2, anonymousClass1);
        if (objTimeoutAwareConnection == coroutine_suspended) {
            return coroutine_suspended;
        }
        return objTimeoutAwareConnection;
    }

    private final HttpURLConnection getProxyAwareConnection(String urlString) throws IOException {
        URL url = new URL(urlString);
        Proxy proxy = getConfig().getProxy();
        URLConnection uRLConnectionOpenConnection = proxy != null ? url.openConnection(proxy) : null;
        if (uRLConnectionOpenConnection == null) {
            uRLConnectionOpenConnection = url.openConnection();
            Intrinsics.checkNotNullExpressionValue(uRLConnectionOpenConnection, "url.openConnection()");
        }
        return (HttpURLConnection) uRLConnectionOpenConnection;
    }
}
