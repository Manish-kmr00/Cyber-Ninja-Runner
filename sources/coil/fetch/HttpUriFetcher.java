package coil.fetch;

import android.net.Uri;
import android.os.NetworkOnMainThreadException;
import android.webkit.MimeTypeMap;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.decode.ImageSource;
import coil.decode.ImageSources;
import coil.disk.DiskCache;
import coil.network.CacheResponse;
import coil.network.CacheStrategy;
import coil.network.HttpException;
import coil.request.Options;
import coil.util.Calls;
import coil.util.Utils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import com.vungle.ads.internal.protos.Sdk;
import java.io.IOException;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;

/* JADX INFO: compiled from: HttpUriFetcher.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 12\u00020\u0001:\u000212B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0011\u0010\u001a\u001a\u00020\u001bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ!\u0010\u001d\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0001¢\u0006\u0002\b J\u0018\u0010!\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020\u0018H\u0002J\n\u0010$\u001a\u0004\u0018\u00010%H\u0002J.\u0010&\u001a\u0004\u0018\u00010%2\b\u0010'\u001a\u0004\u0018\u00010%2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\f\u0010*\u001a\u00020+*\u00020\u0016H\u0002J\u000e\u0010,\u001a\u0004\u0018\u00010)*\u00020%H\u0002J\f\u0010-\u001a\u00020.*\u00020\u0016H\u0002J\f\u0010/\u001a\u000200*\u00020%H\u0002J\f\u0010/\u001a\u000200*\u00020+H\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00063"}, d2 = {"Lcoil/fetch/HttpUriFetcher;", "Lcoil/fetch/Fetcher;", "url", "", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Lcoil/request/Options;", "callFactory", "Lkotlin/Lazy;", "Lokhttp3/Call$Factory;", "diskCache", "Lcoil/disk/DiskCache;", "respectCacheHeaders", "", "(Ljava/lang/String;Lcoil/request/Options;Lkotlin/Lazy;Lkotlin/Lazy;Z)V", "diskCacheKey", "getDiskCacheKey", "()Ljava/lang/String;", "fileSystem", "Lokio/FileSystem;", "getFileSystem", "()Lokio/FileSystem;", "executeNetworkRequest", "Lokhttp3/Response;", "request", "Lokhttp3/Request;", "(Lokhttp3/Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", RemoteConfigComponent.FETCH_FILE_NAME, "Lcoil/fetch/FetchResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMimeType", "contentType", "Lokhttp3/MediaType;", "getMimeType$coil_base_release", "isCacheable", "response", "newRequest", "readFromDiskCache", "Lcoil/disk/DiskCache$Snapshot;", "writeToDiskCache", "snapshot", "cacheResponse", "Lcoil/network/CacheResponse;", "requireBody", "Lokhttp3/ResponseBody;", "toCacheResponse", "toDataSource", "Lcoil/decode/DataSource;", "toImageSource", "Lcoil/decode/ImageSource;", "Companion", "Factory", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class HttpUriFetcher implements Fetcher {
    private static final String MIME_TYPE_TEXT_PLAIN = "text/plain";
    private final Lazy<Call.Factory> callFactory;
    private final Lazy<DiskCache> diskCache;
    private final Options options;
    private final boolean respectCacheHeaders;
    private final String url;
    private static final CacheControl CACHE_CONTROL_FORCE_NETWORK_NO_CACHE = new CacheControl.Builder().noCache().noStore().build();
    private static final CacheControl CACHE_CONTROL_NO_NETWORK_NO_CACHE = new CacheControl.Builder().noCache().onlyIfCached().build();

    /* JADX INFO: renamed from: coil.fetch.HttpUriFetcher$executeNetworkRequest$1, reason: invalid class name */
    /* JADX INFO: compiled from: HttpUriFetcher.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "coil.fetch.HttpUriFetcher", f = "HttpUriFetcher.kt", i = {}, l = {Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE}, m = "executeNetworkRequest", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpUriFetcher.this.executeNetworkRequest(null, this);
        }
    }

    /* JADX INFO: renamed from: coil.fetch.HttpUriFetcher$fetch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HttpUriFetcher.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "coil.fetch.HttpUriFetcher", f = "HttpUriFetcher.kt", i = {0, 0, 0, 1, 1, 1}, l = {76, 105}, m = RemoteConfigComponent.FETCH_FILE_NAME, n = {"this", "snapshot", "cacheStrategy", "this", "snapshot", "response"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    static final class C11961 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11961(Continuation<? super C11961> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpUriFetcher.this.fetch(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpUriFetcher(String str, Options options, Lazy<? extends Call.Factory> lazy, Lazy<? extends DiskCache> lazy2, boolean z) {
        this.url = str;
        this.options = options;
        this.callFactory = lazy;
        this.diskCache = lazy2;
        this.respectCacheHeaders = z;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x0128 A[Catch: Exception -> 0x019e, TryCatch #0 {Exception -> 0x019e, blocks: (B:68:0x0182, B:52:0x011a, B:54:0x0128, B:56:0x0136, B:57:0x013a, B:59:0x0144, B:61:0x014c, B:63:0x0164), top: B:81:0x011a }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0136 A[Catch: Exception -> 0x019e, TryCatch #0 {Exception -> 0x019e, blocks: (B:68:0x0182, B:52:0x011a, B:54:0x0128, B:56:0x0136, B:57:0x013a, B:59:0x0144, B:61:0x014c, B:63:0x0164), top: B:81:0x011a }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0144 A[Catch: Exception -> 0x019e, TryCatch #0 {Exception -> 0x019e, blocks: (B:68:0x0182, B:52:0x011a, B:54:0x0128, B:56:0x0136, B:57:0x013a, B:59:0x0144, B:61:0x014c, B:63:0x0164), top: B:81:0x011a }] */
    /* JADX WARN: Code duplicated, block: B:61:0x014c A[Catch: Exception -> 0x019e, TryCatch #0 {Exception -> 0x019e, blocks: (B:68:0x0182, B:52:0x011a, B:54:0x0128, B:56:0x0136, B:57:0x013a, B:59:0x0144, B:61:0x014c, B:63:0x0164), top: B:81:0x011a }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0164 A[Catch: Exception -> 0x019e, TRY_LEAVE, TryCatch #0 {Exception -> 0x019e, blocks: (B:68:0x0182, B:52:0x011a, B:54:0x0128, B:56:0x0136, B:57:0x013a, B:59:0x0144, B:61:0x014c, B:63:0x0164), top: B:81:0x011a }] */
    /* JADX WARN: Code duplicated, block: B:65:0x017c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:66:0x017d  */
    /* JADX WARN: Code duplicated, block: B:79:0x01af  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // coil.fetch.Fetcher
    public Object fetch(Continuation<? super FetchResult> continuation) throws Exception {
        C11961 c11961;
        DiskCache.Snapshot snapshot;
        Exception e;
        CacheStrategy cacheStrategyCompute;
        HttpUriFetcher httpUriFetcher;
        DiskCache.Snapshot snapshotWriteToDiskCache;
        CacheStrategy cacheStrategy;
        Response response;
        ResponseBody responseBodyRequireBody;
        Response response2;
        Exception e2;
        Object objExecuteNetworkRequest;
        HttpUriFetcher httpUriFetcher2;
        if (continuation instanceof C11961) {
            c11961 = (C11961) continuation;
            if ((c11961.label & Integer.MIN_VALUE) != 0) {
                c11961.label -= Integer.MIN_VALUE;
            } else {
                c11961 = new C11961(continuation);
            }
        } else {
            c11961 = new C11961(continuation);
        }
        Object obj = c11961.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11961.label;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                response2 = (Response) c11961.L$2;
                snapshotWriteToDiskCache = (DiskCache.Snapshot) c11961.L$1;
                httpUriFetcher2 = (HttpUriFetcher) c11961.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    Response response3 = (Response) obj;
                    ResponseBody responseBodyRequireBody2 = httpUriFetcher2.requireBody(response3);
                    return new SourceResult(httpUriFetcher2.toImageSource(responseBodyRequireBody2), httpUriFetcher2.getMimeType$coil_base_release(httpUriFetcher2.url, responseBodyRequireBody2.getContentType()), httpUriFetcher2.toDataSource(response3));
                } catch (Exception e3) {
                    e2 = e3;
                    Utils.closeQuietly(response2);
                    throw e2;
                }
            }
            CacheStrategy cacheStrategy2 = (CacheStrategy) c11961.L$2;
            snapshot = (DiskCache.Snapshot) c11961.L$1;
            httpUriFetcher = (HttpUriFetcher) c11961.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                cacheStrategy = cacheStrategy2;
                snapshotWriteToDiskCache = snapshot;
                try {
                    response = (Response) obj;
                    responseBodyRequireBody = httpUriFetcher.requireBody(response);
                    try {
                        snapshotWriteToDiskCache = httpUriFetcher.writeToDiskCache(snapshotWriteToDiskCache, cacheStrategy.getNetworkRequest(), response, cacheStrategy.getCacheResponse());
                        if (snapshotWriteToDiskCache != null) {
                            ImageSource imageSource = httpUriFetcher.toImageSource(snapshotWriteToDiskCache);
                            String str = httpUriFetcher.url;
                            CacheResponse cacheResponse = httpUriFetcher.toCacheResponse(snapshotWriteToDiskCache);
                            return new SourceResult(imageSource, httpUriFetcher.getMimeType$coil_base_release(str, cacheResponse != null ? cacheResponse.getContentType() : null), DataSource.NETWORK);
                        }
                        if (responseBodyRequireBody.getContentLength() > 0) {
                            return new SourceResult(httpUriFetcher.toImageSource(responseBodyRequireBody), httpUriFetcher.getMimeType$coil_base_release(httpUriFetcher.url, responseBodyRequireBody.getContentType()), httpUriFetcher.toDataSource(response));
                        }
                        Utils.closeQuietly(response);
                        Request requestNewRequest = httpUriFetcher.newRequest();
                        c11961.L$0 = httpUriFetcher;
                        c11961.L$1 = snapshotWriteToDiskCache;
                        c11961.L$2 = response;
                        c11961.label = 2;
                        objExecuteNetworkRequest = httpUriFetcher.executeNetworkRequest(requestNewRequest, c11961);
                        if (objExecuteNetworkRequest == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        response2 = response;
                        obj = objExecuteNetworkRequest;
                        httpUriFetcher2 = httpUriFetcher;
                        Response response4 = (Response) obj;
                        ResponseBody responseBodyRequireBody3 = httpUriFetcher2.requireBody(response4);
                        return new SourceResult(httpUriFetcher2.toImageSource(responseBodyRequireBody3), httpUriFetcher2.getMimeType$coil_base_release(httpUriFetcher2.url, responseBodyRequireBody3.getContentType()), httpUriFetcher2.toDataSource(response4));
                    } catch (Exception e4) {
                        response2 = response;
                        e2 = e4;
                        Utils.closeQuietly(response2);
                        throw e2;
                    }
                } catch (Exception e5) {
                    e = e5;
                    snapshot = snapshotWriteToDiskCache;
                    if (snapshot != null) {
                        Utils.closeQuietly(snapshot);
                    }
                    throw e;
                }
            } catch (Exception e6) {
                e = e6;
                if (snapshot != null) {
                    Utils.closeQuietly(snapshot);
                }
                throw e;
            }
        }
        ResultKt.throwOnFailure(obj);
        DiskCache.Snapshot fromDiskCache = readFromDiskCache();
        try {
            if (fromDiskCache != null) {
                Long size = getFileSystem().metadata(fromDiskCache.getMetadata()).getSize();
                if (size != null && size.longValue() == 0) {
                    return new SourceResult(toImageSource(fromDiskCache), getMimeType$coil_base_release(this.url, null), DataSource.DISK);
                }
                if (!this.respectCacheHeaders) {
                    ImageSource imageSource2 = toImageSource(fromDiskCache);
                    String str2 = this.url;
                    CacheResponse cacheResponse2 = toCacheResponse(fromDiskCache);
                    return new SourceResult(imageSource2, getMimeType$coil_base_release(str2, cacheResponse2 != null ? cacheResponse2.getContentType() : null), DataSource.DISK);
                }
                cacheStrategyCompute = new CacheStrategy.Factory(newRequest(), toCacheResponse(fromDiskCache)).compute();
                if (cacheStrategyCompute.getNetworkRequest() == null && cacheStrategyCompute.getCacheResponse() != null) {
                    return new SourceResult(toImageSource(fromDiskCache), getMimeType$coil_base_release(this.url, cacheStrategyCompute.getCacheResponse().getContentType()), DataSource.DISK);
                }
            } else {
                cacheStrategyCompute = new CacheStrategy.Factory(newRequest(), null).compute();
            }
            Request networkRequest = cacheStrategyCompute.getNetworkRequest();
            Intrinsics.checkNotNull(networkRequest);
            c11961.L$0 = this;
            c11961.L$1 = fromDiskCache;
            c11961.L$2 = cacheStrategyCompute;
            c11961.label = 1;
            Object objExecuteNetworkRequest2 = executeNetworkRequest(networkRequest, c11961);
            if (objExecuteNetworkRequest2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            httpUriFetcher = this;
            CacheStrategy cacheStrategy3 = cacheStrategyCompute;
            snapshotWriteToDiskCache = fromDiskCache;
            obj = objExecuteNetworkRequest2;
            cacheStrategy = cacheStrategy3;
            response = (Response) obj;
            responseBodyRequireBody = httpUriFetcher.requireBody(response);
            snapshotWriteToDiskCache = httpUriFetcher.writeToDiskCache(snapshotWriteToDiskCache, cacheStrategy.getNetworkRequest(), response, cacheStrategy.getCacheResponse());
            if (snapshotWriteToDiskCache != null) {
                ImageSource imageSource3 = httpUriFetcher.toImageSource(snapshotWriteToDiskCache);
                String str3 = httpUriFetcher.url;
                CacheResponse cacheResponse3 = httpUriFetcher.toCacheResponse(snapshotWriteToDiskCache);
                return new SourceResult(imageSource3, httpUriFetcher.getMimeType$coil_base_release(str3, cacheResponse3 != null ? cacheResponse3.getContentType() : null), DataSource.NETWORK);
            }
            if (responseBodyRequireBody.getContentLength() > 0) {
                return new SourceResult(httpUriFetcher.toImageSource(responseBodyRequireBody), httpUriFetcher.getMimeType$coil_base_release(httpUriFetcher.url, responseBodyRequireBody.getContentType()), httpUriFetcher.toDataSource(response));
            }
            Utils.closeQuietly(response);
            Request requestNewRequest2 = httpUriFetcher.newRequest();
            c11961.L$0 = httpUriFetcher;
            c11961.L$1 = snapshotWriteToDiskCache;
            c11961.L$2 = response;
            c11961.label = 2;
            objExecuteNetworkRequest = httpUriFetcher.executeNetworkRequest(requestNewRequest2, c11961);
            if (objExecuteNetworkRequest == coroutine_suspended) {
                return coroutine_suspended;
            }
            response2 = response;
            obj = objExecuteNetworkRequest;
            httpUriFetcher2 = httpUriFetcher;
            Response response5 = (Response) obj;
            ResponseBody responseBodyRequireBody4 = httpUriFetcher2.requireBody(response5);
            return new SourceResult(httpUriFetcher2.toImageSource(responseBodyRequireBody4), httpUriFetcher2.getMimeType$coil_base_release(httpUriFetcher2.url, responseBodyRequireBody4.getContentType()), httpUriFetcher2.toDataSource(response5));
        } catch (Exception e7) {
            snapshot = fromDiskCache;
            e = e7;
            if (snapshot != null) {
                Utils.closeQuietly(snapshot);
            }
            throw e;
        }
    }

    private final DiskCache.Snapshot readFromDiskCache() {
        if (this.options.getDiskCachePolicy().getReadEnabled()) {
            DiskCache value = this.diskCache.getValue();
            if (value != null) {
                return value.get(getDiskCacheKey());
            }
            return null;
        }
        return null;
    }

    private final DiskCache.Snapshot writeToDiskCache(DiskCache.Snapshot snapshot, Request request, Response response, CacheResponse cacheResponse) {
        DiskCache.Editor editorEdit;
        Unit unit;
        Long lValueOf;
        Unit unit2;
        Throwable th = null;
        if (!isCacheable(request, response)) {
            if (snapshot != null) {
                Utils.closeQuietly(snapshot);
            }
            return null;
        }
        if (snapshot != null) {
            editorEdit = snapshot.closeAndEdit();
        } else {
            DiskCache value = this.diskCache.getValue();
            editorEdit = value != null ? value.edit(getDiskCacheKey()) : null;
        }
        try {
            if (editorEdit == null) {
                return null;
            }
            try {
                if (response.code() == 304 && cacheResponse != null) {
                    Response responseBuild = response.newBuilder().headers(CacheStrategy.INSTANCE.combineHeaders(cacheResponse.getResponseHeaders(), response.headers())).build();
                    BufferedSink bufferedSinkBuffer = Okio.buffer(getFileSystem().sink(editorEdit.getMetadata(), false));
                    try {
                        new CacheResponse(responseBuild).writeTo(bufferedSinkBuffer);
                        unit2 = Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        unit2 = null;
                    }
                    if (bufferedSinkBuffer != null) {
                        try {
                            bufferedSinkBuffer.close();
                        } catch (Throwable th3) {
                            if (th == null) {
                                th = th3;
                            } else {
                                ExceptionsKt.addSuppressed(th, th3);
                            }
                        }
                    }
                    if (th != null) {
                        throw th;
                    }
                    Intrinsics.checkNotNull(unit2);
                } else {
                    BufferedSink bufferedSinkBuffer2 = Okio.buffer(getFileSystem().sink(editorEdit.getMetadata(), false));
                    try {
                        new CacheResponse(response).writeTo(bufferedSinkBuffer2);
                        unit = Unit.INSTANCE;
                        th = null;
                    } catch (Throwable th4) {
                        th = th4;
                        unit = null;
                    }
                    if (bufferedSinkBuffer2 != null) {
                        try {
                            bufferedSinkBuffer2.close();
                        } catch (Throwable th5) {
                            if (th == null) {
                                th = th5;
                            } else {
                                ExceptionsKt.addSuppressed(th, th5);
                            }
                        }
                    }
                    if (th != null) {
                        throw th;
                    }
                    Intrinsics.checkNotNull(unit);
                    BufferedSink bufferedSinkBuffer3 = Okio.buffer(getFileSystem().sink(editorEdit.getData(), false));
                    try {
                        ResponseBody responseBodyBody = response.body();
                        Intrinsics.checkNotNull(responseBodyBody);
                        lValueOf = Long.valueOf(responseBodyBody.getDelegateSource().readAll(bufferedSinkBuffer3));
                    } catch (Throwable th6) {
                        th = th6;
                        lValueOf = null;
                    }
                    if (bufferedSinkBuffer3 != null) {
                        try {
                            bufferedSinkBuffer3.close();
                        } catch (Throwable th7) {
                            if (th == null) {
                                th = th7;
                            } else {
                                ExceptionsKt.addSuppressed(th, th7);
                            }
                        }
                    }
                    if (th != null) {
                        throw th;
                    }
                    Intrinsics.checkNotNull(lValueOf);
                }
                DiskCache.Snapshot snapshotCommitAndGet = editorEdit.commitAndGet();
                Utils.closeQuietly(response);
                return snapshotCommitAndGet;
            } catch (Exception e) {
                Utils.abortQuietly(editorEdit);
                throw e;
            }
        } catch (Throwable th8) {
            Utils.closeQuietly(response);
            throw th8;
        }
    }

    private final Request newRequest() {
        Request.Builder builderHeaders = new Request.Builder().url(this.url).headers(this.options.getHeaders());
        for (Map.Entry<Class<?>, Object> entry : this.options.getTags().asMap().entrySet()) {
            Class<?> key = entry.getKey();
            Intrinsics.checkNotNull(key, "null cannot be cast to non-null type java.lang.Class<kotlin.Any>");
            builderHeaders.tag(key, entry.getValue());
        }
        boolean readEnabled = this.options.getDiskCachePolicy().getReadEnabled();
        boolean readEnabled2 = this.options.getNetworkCachePolicy().getReadEnabled();
        if (!readEnabled2 && readEnabled) {
            builderHeaders.cacheControl(CacheControl.FORCE_CACHE);
        } else if (!readEnabled2 || readEnabled) {
            if (!readEnabled2 && !readEnabled) {
                builderHeaders.cacheControl(CACHE_CONTROL_NO_NETWORK_NO_CACHE);
            }
        } else if (this.options.getDiskCachePolicy().getWriteEnabled()) {
            builderHeaders.cacheControl(CacheControl.FORCE_NETWORK);
        } else {
            builderHeaders.cacheControl(CACHE_CONTROL_FORCE_NETWORK_NO_CACHE);
        }
        return builderHeaders.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object executeNetworkRequest(Request request, Continuation<? super Response> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Response responseExecute;
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
        Object objAwait = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwait);
            if (Utils.isMainThread()) {
                if (this.options.getNetworkCachePolicy().getReadEnabled()) {
                    throw new NetworkOnMainThreadException();
                }
                responseExecute = this.callFactory.getValue().newCall(request).execute();
            } else {
                Call callNewCall = this.callFactory.getValue().newCall(request);
                anonymousClass1.label = 1;
                objAwait = Calls.await(callNewCall, anonymousClass1);
                if (objAwait == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            if (!responseExecute.isSuccessful() || responseExecute.code() == 304) {
                return responseExecute;
            }
            ResponseBody responseBodyBody = responseExecute.body();
            if (responseBodyBody != null) {
                Utils.closeQuietly(responseBodyBody);
            }
            throw new HttpException(responseExecute);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(objAwait);
        responseExecute = (Response) objAwait;
        if (responseExecute.isSuccessful()) {
        }
        return responseExecute;
    }

    public final String getMimeType$coil_base_release(String url, MediaType contentType) {
        String mimeTypeFromUrl;
        String mediaType = contentType != null ? contentType.getMediaType() : null;
        if ((mediaType == null || StringsKt.startsWith$default(mediaType, "text/plain", false, 2, (Object) null)) && (mimeTypeFromUrl = Utils.getMimeTypeFromUrl(MimeTypeMap.getSingleton(), url)) != null) {
            return mimeTypeFromUrl;
        }
        if (mediaType != null) {
            return StringsKt.substringBefore$default(mediaType, ';', (String) null, 2, (Object) null);
        }
        return null;
    }

    private final boolean isCacheable(Request request, Response response) {
        return this.options.getDiskCachePolicy().getWriteEnabled() && (!this.respectCacheHeaders || CacheStrategy.INSTANCE.isCacheable(request, response));
    }

    private final CacheResponse toCacheResponse(DiskCache.Snapshot snapshot) throws Throwable {
        CacheResponse cacheResponse;
        try {
            BufferedSource bufferedSourceBuffer = Okio.buffer(getFileSystem().source(snapshot.getMetadata()));
            try {
                cacheResponse = new CacheResponse(bufferedSourceBuffer);
                th = null;
            } catch (Throwable th) {
                th = th;
                cacheResponse = null;
            }
            if (bufferedSourceBuffer != null) {
                try {
                    bufferedSourceBuffer.close();
                } catch (Throwable th2) {
                    if (th == null) {
                        th = th2;
                    } else {
                        ExceptionsKt.addSuppressed(th, th2);
                    }
                }
            }
            if (th != null) {
                throw th;
            }
            Intrinsics.checkNotNull(cacheResponse);
            return cacheResponse;
        } catch (IOException unused) {
            return null;
        }
    }

    private final ImageSource toImageSource(DiskCache.Snapshot snapshot) {
        return ImageSources.create(snapshot.getData(), getFileSystem(), getDiskCacheKey(), snapshot);
    }

    private final ImageSource toImageSource(ResponseBody responseBody) {
        return ImageSources.create(responseBody.getDelegateSource(), this.options.getContext());
    }

    private final DataSource toDataSource(Response response) {
        return response.networkResponse() != null ? DataSource.NETWORK : DataSource.DISK;
    }

    private final ResponseBody requireBody(Response response) {
        ResponseBody responseBodyBody = response.body();
        if (responseBodyBody != null) {
            return responseBodyBody;
        }
        throw new IllegalStateException("response body == null".toString());
    }

    private final String getDiskCacheKey() {
        String diskCacheKey = this.options.getDiskCacheKey();
        return diskCacheKey == null ? this.url : diskCacheKey;
    }

    private final FileSystem getFileSystem() {
        DiskCache value = this.diskCache.getValue();
        Intrinsics.checkNotNull(value);
        return value.getFileSystem();
    }

    /* JADX INFO: compiled from: HttpUriFetcher.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\"\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0002H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcoil/fetch/HttpUriFetcher$Factory;", "Lcoil/fetch/Fetcher$Factory;", "Landroid/net/Uri;", "callFactory", "Lkotlin/Lazy;", "Lokhttp3/Call$Factory;", "diskCache", "Lcoil/disk/DiskCache;", "respectCacheHeaders", "", "(Lkotlin/Lazy;Lkotlin/Lazy;Z)V", "create", "Lcoil/fetch/Fetcher;", "data", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Lcoil/request/Options;", "imageLoader", "Lcoil/ImageLoader;", "isApplicable", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Factory implements Fetcher.Factory<Uri> {
        private final Lazy<Call.Factory> callFactory;
        private final Lazy<DiskCache> diskCache;
        private final boolean respectCacheHeaders;

        /* JADX WARN: Multi-variable type inference failed */
        public Factory(Lazy<? extends Call.Factory> lazy, Lazy<? extends DiskCache> lazy2, boolean z) {
            this.callFactory = lazy;
            this.diskCache = lazy2;
            this.respectCacheHeaders = z;
        }

        @Override // coil.fetch.Fetcher.Factory
        public Fetcher create(Uri data, Options options, ImageLoader imageLoader) {
            if (isApplicable(data)) {
                return new HttpUriFetcher(data.toString(), options, this.callFactory, this.diskCache, this.respectCacheHeaders);
            }
            return null;
        }

        private final boolean isApplicable(Uri data) {
            return Intrinsics.areEqual(data.getScheme(), "http") || Intrinsics.areEqual(data.getScheme(), "https");
        }
    }
}
