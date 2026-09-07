package coil.intercept;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.ComponentRegistry;
import coil.EventListener;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.decode.Decoder;
import coil.decode.ImageSource;
import coil.fetch.DrawableResult;
import coil.fetch.FetchResult;
import coil.fetch.Fetcher;
import coil.fetch.SourceResult;
import coil.memory.MemoryCache;
import coil.memory.MemoryCacheService;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.request.Options;
import coil.request.RequestService;
import coil.request.SuccessResult;
import coil.size.Scale;
import coil.size.Size;
import coil.transform.Transformation;
import coil.util.Bitmaps;
import coil.util.DrawableUtils;
import coil.util.Logger;
import coil.util.Utils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import com.vungle.ads.internal.protos.Sdk;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: EngineInterceptor.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 02\u00020\u0001:\u000201B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ&\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002JA\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010 J1\u0010!\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010#J9\u0010$\u001a\u00020%2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0019\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010+J3\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0081@ø\u0001\u0000¢\u0006\u0004\b.\u0010/R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00062"}, d2 = {"Lcoil/intercept/EngineInterceptor;", "Lcoil/intercept/Interceptor;", "imageLoader", "Lcoil/ImageLoader;", "requestService", "Lcoil/request/RequestService;", "logger", "Lcoil/util/Logger;", "(Lcoil/ImageLoader;Lcoil/request/RequestService;Lcoil/util/Logger;)V", "memoryCacheService", "Lcoil/memory/MemoryCacheService;", "convertDrawableToBitmap", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Lcoil/request/Options;", "transformations", "", "Lcoil/transform/Transformation;", "decode", "Lcoil/intercept/EngineInterceptor$ExecuteResult;", "fetchResult", "Lcoil/fetch/SourceResult;", "components", "Lcoil/ComponentRegistry;", "request", "Lcoil/request/ImageRequest;", "mappedData", "", "eventListener", "Lcoil/EventListener;", "(Lcoil/fetch/SourceResult;Lcoil/ComponentRegistry;Lcoil/request/ImageRequest;Ljava/lang/Object;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execute", "_options", "(Lcoil/request/ImageRequest;Ljava/lang/Object;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", RemoteConfigComponent.FETCH_FILE_NAME, "Lcoil/fetch/FetchResult;", "(Lcoil/ComponentRegistry;Lcoil/request/ImageRequest;Ljava/lang/Object;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "intercept", "Lcoil/request/ImageResult;", "chain", "Lcoil/intercept/Interceptor$Chain;", "(Lcoil/intercept/Interceptor$Chain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transform", "result", "transform$coil_base_release", "(Lcoil/intercept/EngineInterceptor$ExecuteResult;Lcoil/request/ImageRequest;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ExecuteResult", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EngineInterceptor implements Interceptor {
    private static final String TAG = "EngineInterceptor";
    private final ImageLoader imageLoader;
    private final Logger logger;
    private final MemoryCacheService memoryCacheService;
    private final RequestService requestService;

    /* JADX INFO: renamed from: coil.intercept.EngineInterceptor$decode$1, reason: invalid class name */
    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "coil.intercept.EngineInterceptor", f = "EngineInterceptor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {199}, m = "decode", n = {"this", "fetchResult", "components", "request", "mappedData", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "eventListener", "decoder", "searchIndex"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EngineInterceptor.this.decode(null, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: coil.intercept.EngineInterceptor$execute$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "coil.intercept.EngineInterceptor", f = "EngineInterceptor.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE, 126, 144}, m = "execute", n = {"this", "request", "mappedData", "eventListener", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "components", "fetchResult", "this", "request", "eventListener", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "fetchResult"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class C11971 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C11971(Continuation<? super C11971> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EngineInterceptor.this.execute(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: coil.intercept.EngineInterceptor$fetch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "coil.intercept.EngineInterceptor", f = "EngineInterceptor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {165}, m = RemoteConfigComponent.FETCH_FILE_NAME, n = {"this", "components", "request", "mappedData", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "eventListener", "fetcher", "searchIndex"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"})
    static final class C11981 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C11981(Continuation<? super C11981> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EngineInterceptor.this.fetch(null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: coil.intercept.EngineInterceptor$intercept$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "coil.intercept.EngineInterceptor", f = "EngineInterceptor.kt", i = {0, 0}, l = {73}, m = "intercept", n = {"this", "chain"}, s = {"L$0", "L$1"})
    static final class C11991 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C11991(Continuation<? super C11991> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EngineInterceptor.this.intercept(null, this);
        }
    }

    public EngineInterceptor(ImageLoader imageLoader, RequestService requestService, Logger logger) {
        this.imageLoader = imageLoader;
        this.requestService = requestService;
        this.logger = logger;
        this.memoryCacheService = new MemoryCacheService(imageLoader, requestService, logger);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // coil.intercept.Interceptor
    public Object intercept(Interceptor.Chain chain, Continuation<? super ImageResult> continuation) throws Throwable {
        C11991 c11991;
        EngineInterceptor engineInterceptor;
        if (continuation instanceof C11991) {
            c11991 = (C11991) continuation;
            if ((c11991.label & Integer.MIN_VALUE) != 0) {
                c11991.label -= Integer.MIN_VALUE;
            } else {
                c11991 = new C11991(continuation);
            }
        } else {
            c11991 = new C11991(continuation);
        }
        Object objWithContext = c11991.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11991.label;
        if (i != 0) {
            if (i == 1) {
                chain = (Interceptor.Chain) c11991.L$1;
                engineInterceptor = (EngineInterceptor) c11991.L$0;
                try {
                    ResultKt.throwOnFailure(objWithContext);
                } catch (Throwable th) {
                    th = th;
                    if (!(th instanceof CancellationException)) {
                        throw th;
                    }
                    return engineInterceptor.requestService.errorResult(chain.getRequest(), th);
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(objWithContext);
        try {
            ImageRequest request = chain.getRequest();
            Object data = request.getData();
            Size size = chain.getSize();
            EventListener eventListener = Utils.getEventListener(chain);
            Options options = this.requestService.options(request, size);
            Scale scale = options.getScale();
            eventListener.mapStart(request, data);
            Object map = this.imageLoader.getComponents().map(data, options);
            eventListener.mapEnd(request, map);
            MemoryCache.Key keyNewCacheKey = this.memoryCacheService.newCacheKey(request, map, options, eventListener);
            MemoryCache.Value cacheValue = keyNewCacheKey != null ? this.memoryCacheService.getCacheValue(request, keyNewCacheKey, size, scale) : null;
            if (cacheValue != null) {
                return this.memoryCacheService.newResult(chain, request, keyNewCacheKey, cacheValue);
            }
            CoroutineDispatcher fetcherDispatcher = request.getFetcherDispatcher();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(request, map, options, eventListener, keyNewCacheKey, chain, null);
            c11991.L$0 = this;
            c11991.L$1 = chain;
            c11991.label = 1;
            objWithContext = BuildersKt.withContext(fetcherDispatcher, anonymousClass2, c11991);
            return objWithContext == coroutine_suspended ? coroutine_suspended : objWithContext;
        } catch (Throwable th2) {
            th = th2;
            engineInterceptor = this;
            if (!(th instanceof CancellationException)) {
                throw th;
            }
            return engineInterceptor.requestService.errorResult(chain.getRequest(), th);
        }
    }

    /* JADX INFO: renamed from: coil.intercept.EngineInterceptor$intercept$2, reason: invalid class name */
    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcoil/request/SuccessResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "coil.intercept.EngineInterceptor$intercept$2", f = "EngineInterceptor.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SuccessResult>, Object> {
        final /* synthetic */ MemoryCache.Key $cacheKey;
        final /* synthetic */ Interceptor.Chain $chain;
        final /* synthetic */ EventListener $eventListener;
        final /* synthetic */ Object $mappedData;
        final /* synthetic */ Options $options;
        final /* synthetic */ ImageRequest $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ImageRequest imageRequest, Object obj, Options options, EventListener eventListener, MemoryCache.Key key, Interceptor.Chain chain, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$request = imageRequest;
            this.$mappedData = obj;
            this.$options = options;
            this.$eventListener = eventListener;
            this.$cacheKey = key;
            this.$chain = chain;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EngineInterceptor.this.new AnonymousClass2(this.$request, this.$mappedData, this.$options, this.$eventListener, this.$cacheKey, this.$chain, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SuccessResult> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = EngineInterceptor.this.execute(this.$request, this.$mappedData, this.$options, this.$eventListener, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ExecuteResult executeResult = (ExecuteResult) obj;
            return new SuccessResult(executeResult.getDrawable(), this.$request, executeResult.getDataSource(), EngineInterceptor.this.memoryCacheService.setCacheValue(this.$cacheKey, this.$request, executeResult) ? this.$cacheKey : null, executeResult.getDiskCacheKey(), executeResult.getIsSampled(), Utils.isPlaceholderCached(this.$chain));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:47:0x015c A[Catch: all -> 0x0219, TRY_LEAVE, TryCatch #2 {all -> 0x0219, blocks: (B:45:0x0152, B:47:0x015c, B:54:0x01a0, B:56:0x01a4, B:77:0x0213, B:78:0x0218, B:27:0x00a6, B:29:0x00b2, B:30:0x00e0, B:32:0x00e6, B:41:0x0115, B:34:0x00ec, B:36:0x00fb, B:37:0x0102, B:39:0x0108, B:40:0x010f), top: B:93:0x00a6 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x018f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:50:0x0190  */
    /* JADX WARN: Code duplicated, block: B:54:0x01a0 A[Catch: all -> 0x0219, TRY_ENTER, TryCatch #2 {all -> 0x0219, blocks: (B:45:0x0152, B:47:0x015c, B:54:0x01a0, B:56:0x01a4, B:77:0x0213, B:78:0x0218, B:27:0x00a6, B:29:0x00b2, B:30:0x00e0, B:32:0x00e6, B:41:0x0115, B:34:0x00ec, B:36:0x00fb, B:37:0x0102, B:39:0x0108, B:40:0x010f), top: B:93:0x00a6 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x01a4 A[Catch: all -> 0x0219, TRY_LEAVE, TryCatch #2 {all -> 0x0219, blocks: (B:45:0x0152, B:47:0x015c, B:54:0x01a0, B:56:0x01a4, B:77:0x0213, B:78:0x0218, B:27:0x00a6, B:29:0x00b2, B:30:0x00e0, B:32:0x00e6, B:41:0x0115, B:34:0x00ec, B:36:0x00fb, B:37:0x0102, B:39:0x0108, B:40:0x010f), top: B:93:0x00a6 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:61:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:63:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:68:0x01f9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:77:0x0213 A[Catch: all -> 0x0219, TRY_ENTER, TryCatch #2 {all -> 0x0219, blocks: (B:45:0x0152, B:47:0x015c, B:54:0x01a0, B:56:0x01a4, B:77:0x0213, B:78:0x0218, B:27:0x00a6, B:29:0x00b2, B:30:0x00e0, B:32:0x00e6, B:41:0x0115, B:34:0x00ec, B:36:0x00fb, B:37:0x0102, B:39:0x0108, B:40:0x010f), top: B:93:0x00a6 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:83:0x0221  */
    /* JADX WARN: Code duplicated, block: B:85:0x0226  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13, types: [T, coil.ComponentRegistry] */
    /* JADX WARN: Type inference failed for: r1v20, types: [T, coil.request.Options] */
    /* JADX WARN: Type inference failed for: r1v6, types: [T, coil.ComponentRegistry] */
    public final Object execute(ImageRequest imageRequest, Object obj, Options options, EventListener eventListener, Continuation<? super ExecuteResult> continuation) throws Throwable {
        C11971 c11971;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Object obj2;
        EventListener eventListener2;
        Ref.ObjectRef objectRef3;
        Ref.ObjectRef objectRef4;
        Ref.ObjectRef objectRef5;
        ImageRequest imageRequest2;
        EngineInterceptor engineInterceptor;
        T t;
        FetchResult fetchResult;
        ExecuteResult executeResult;
        ImageRequest imageRequest3;
        EngineInterceptor engineInterceptor2;
        Object objWithContext;
        EventListener eventListener3;
        ImageRequest imageRequest4;
        EngineInterceptor engineInterceptor3;
        SourceResult sourceResult;
        ImageSource source;
        T t2;
        SourceResult sourceResult2;
        Object objTransform$coil_base_release;
        ImageSource source2;
        Object obj3;
        Object obj4;
        Bitmap bitmap;
        if (continuation instanceof C11971) {
            c11971 = (C11971) continuation;
            if ((c11971.label & Integer.MIN_VALUE) != 0) {
                c11971.label -= Integer.MIN_VALUE;
            } else {
                c11971 = new C11971(continuation);
            }
        } else {
            c11971 = new C11971(continuation);
        }
        C11971 c11972 = c11971;
        Object obj5 = c11972.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11972.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj5);
            Ref.ObjectRef objectRef6 = new Ref.ObjectRef();
            objectRef6.element = options;
            Ref.ObjectRef objectRef7 = new Ref.ObjectRef();
            objectRef7.element = this.imageLoader.getComponents();
            objectRef = new Ref.ObjectRef();
            try {
                if (!this.requestService.allowHardwareWorkerThread((Options) objectRef6.element)) {
                    Options options2 = (Options) objectRef6.element;
                    objectRef6.element = options2.copy((32765 & 1) != 0 ? options2.context : null, (32765 & 2) != 0 ? options2.config : Bitmap.Config.ARGB_8888, (32765 & 4) != 0 ? options2.colorSpace : null, (32765 & 8) != 0 ? options2.size : null, (32765 & 16) != 0 ? options2.scale : null, (32765 & 32) != 0 ? options2.allowInexactSize : false, (32765 & 64) != 0 ? options2.allowRgb565 : false, (32765 & 128) != 0 ? options2.premultipliedAlpha : false, (32765 & 256) != 0 ? options2.diskCacheKey : null, (32765 & 512) != 0 ? options2.headers : null, (32765 & 1024) != 0 ? options2.tags : null, (32765 & 2048) != 0 ? options2.parameters : null, (32765 & 4096) != 0 ? options2.memoryCachePolicy : null, (32765 & 8192) != 0 ? options2.diskCachePolicy : null, (32765 & 16384) != 0 ? options2.networkCachePolicy : null);
                }
                if (imageRequest.getFetcherFactory() != null || imageRequest.getDecoderFactory() != null) {
                    ComponentRegistry.Builder builderNewBuilder = ((ComponentRegistry) objectRef7.element).newBuilder();
                    Pair<Fetcher.Factory<?>, Class<?>> fetcherFactory = imageRequest.getFetcherFactory();
                    if (fetcherFactory != null) {
                        builderNewBuilder.getFetcherFactories$coil_base_release().add(0, fetcherFactory);
                    }
                    Decoder.Factory decoderFactory = imageRequest.getDecoderFactory();
                    if (decoderFactory != null) {
                        builderNewBuilder.getDecoderFactories$coil_base_release().add(0, decoderFactory);
                    }
                    objectRef7.element = builderNewBuilder.build();
                }
                ComponentRegistry componentRegistry = (ComponentRegistry) objectRef7.element;
                Options options3 = (Options) objectRef6.element;
                c11972.L$0 = this;
                c11972.L$1 = imageRequest;
                c11972.L$2 = obj;
                c11972.L$3 = eventListener;
                c11972.L$4 = objectRef6;
                c11972.L$5 = objectRef7;
                c11972.L$6 = objectRef;
                c11972.L$7 = objectRef;
                c11972.label = 1;
                Object objFetch = fetch(componentRegistry, imageRequest, obj, options3, eventListener, c11972);
                if (objFetch == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj2 = obj;
                eventListener2 = eventListener;
                objectRef3 = objectRef6;
                objectRef4 = objectRef7;
                objectRef5 = objectRef;
                imageRequest2 = imageRequest;
                engineInterceptor = this;
                t = objFetch;
                objectRef5.element = t;
                fetchResult = (FetchResult) objectRef.element;
                if (fetchResult instanceof SourceResult) {
                    CoroutineDispatcher decoderDispatcher = imageRequest2.getDecoderDispatcher();
                    EngineInterceptor$execute$executeResult$1 engineInterceptor$execute$executeResult$1 = new EngineInterceptor$execute$executeResult$1(engineInterceptor, objectRef, objectRef4, imageRequest2, obj2, objectRef3, eventListener2, null);
                    c11972.L$0 = engineInterceptor;
                    c11972.L$1 = imageRequest2;
                    c11972.L$2 = eventListener2;
                    c11972.L$3 = objectRef3;
                    c11972.L$4 = objectRef;
                    c11972.L$5 = null;
                    c11972.L$6 = null;
                    c11972.L$7 = null;
                    c11972.label = 2;
                    objWithContext = BuildersKt.withContext(decoderDispatcher, engineInterceptor$execute$executeResult$1, c11972);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eventListener3 = eventListener2;
                    imageRequest4 = imageRequest2;
                    engineInterceptor3 = engineInterceptor;
                    objectRef2 = objectRef;
                    obj3 = objWithContext;
                    executeResult = (ExecuteResult) obj3;
                    objectRef = objectRef2;
                    engineInterceptor2 = engineInterceptor3;
                    eventListener2 = eventListener3;
                    imageRequest3 = imageRequest4;
                } else {
                    if (fetchResult instanceof DrawableResult) {
                        throw new NoWhenBranchMatchedException();
                    }
                    executeResult = new ExecuteResult(((DrawableResult) objectRef.element).getDrawable(), ((DrawableResult) objectRef.element).getIsSampled(), ((DrawableResult) objectRef.element).getDataSource(), null);
                    imageRequest3 = imageRequest2;
                    engineInterceptor2 = engineInterceptor;
                }
                Ref.ObjectRef objectRef8 = objectRef3;
                ExecuteResult executeResult2 = executeResult;
                t2 = objectRef.element;
                if (t2 instanceof SourceResult) {
                    sourceResult2 = (SourceResult) t2;
                } else {
                    sourceResult2 = null;
                }
                if (sourceResult2 != null) {
                    Utils.closeQuietly(source2);
                }
                Options options4 = (Options) objectRef8.element;
                c11972.L$0 = null;
                c11972.L$1 = null;
                c11972.L$2 = null;
                c11972.L$3 = null;
                c11972.L$4 = null;
                c11972.L$5 = null;
                c11972.L$6 = null;
                c11972.L$7 = null;
                c11972.label = 3;
                objTransform$coil_base_release = engineInterceptor2.transform$coil_base_release(executeResult2, imageRequest3, options4, eventListener2, c11972);
                obj4 = objTransform$coil_base_release;
                if (objTransform$coil_base_release == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (Throwable th) {
                th = th;
                objectRef2 = objectRef;
                T t3 = objectRef2.element;
                if (t3 instanceof SourceResult) {
                }
                if (sourceResult != null) {
                    Utils.closeQuietly(source);
                }
                throw th;
            }
        } else if (i == 1) {
            objectRef5 = (Ref.ObjectRef) c11972.L$7;
            Ref.ObjectRef objectRef9 = (Ref.ObjectRef) c11972.L$6;
            Ref.ObjectRef objectRef10 = (Ref.ObjectRef) c11972.L$5;
            Ref.ObjectRef objectRef11 = (Ref.ObjectRef) c11972.L$4;
            eventListener2 = (EventListener) c11972.L$3;
            Object obj6 = c11972.L$2;
            imageRequest2 = (ImageRequest) c11972.L$1;
            engineInterceptor = (EngineInterceptor) c11972.L$0;
            try {
                ResultKt.throwOnFailure(obj5);
                objectRef = objectRef9;
                objectRef4 = objectRef10;
                objectRef3 = objectRef11;
                obj2 = obj6;
                t = obj5;
                objectRef5.element = t;
                fetchResult = (FetchResult) objectRef.element;
                if (fetchResult instanceof SourceResult) {
                    CoroutineDispatcher decoderDispatcher2 = imageRequest2.getDecoderDispatcher();
                    EngineInterceptor$execute$executeResult$1 engineInterceptor$execute$executeResult$2 = new EngineInterceptor$execute$executeResult$1(engineInterceptor, objectRef, objectRef4, imageRequest2, obj2, objectRef3, eventListener2, null);
                    c11972.L$0 = engineInterceptor;
                    c11972.L$1 = imageRequest2;
                    c11972.L$2 = eventListener2;
                    c11972.L$3 = objectRef3;
                    c11972.L$4 = objectRef;
                    c11972.L$5 = null;
                    c11972.L$6 = null;
                    c11972.L$7 = null;
                    c11972.label = 2;
                    objWithContext = BuildersKt.withContext(decoderDispatcher2, engineInterceptor$execute$executeResult$2, c11972);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eventListener3 = eventListener2;
                    imageRequest4 = imageRequest2;
                    engineInterceptor3 = engineInterceptor;
                    objectRef2 = objectRef;
                    obj3 = objWithContext;
                    executeResult = (ExecuteResult) obj3;
                    objectRef = objectRef2;
                    engineInterceptor2 = engineInterceptor3;
                    eventListener2 = eventListener3;
                    imageRequest3 = imageRequest4;
                } else {
                    if (fetchResult instanceof DrawableResult) {
                        throw new NoWhenBranchMatchedException();
                    }
                    executeResult = new ExecuteResult(((DrawableResult) objectRef.element).getDrawable(), ((DrawableResult) objectRef.element).getIsSampled(), ((DrawableResult) objectRef.element).getDataSource(), null);
                    imageRequest3 = imageRequest2;
                    engineInterceptor2 = engineInterceptor;
                }
                Ref.ObjectRef objectRef12 = objectRef3;
                ExecuteResult executeResult3 = executeResult;
                t2 = objectRef.element;
                if (t2 instanceof SourceResult) {
                    sourceResult2 = (SourceResult) t2;
                } else {
                    sourceResult2 = null;
                }
                if (sourceResult2 != null) {
                    Utils.closeQuietly(source2);
                }
                Options options5 = (Options) objectRef12.element;
                c11972.L$0 = null;
                c11972.L$1 = null;
                c11972.L$2 = null;
                c11972.L$3 = null;
                c11972.L$4 = null;
                c11972.L$5 = null;
                c11972.L$6 = null;
                c11972.L$7 = null;
                c11972.label = 3;
                objTransform$coil_base_release = engineInterceptor2.transform$coil_base_release(executeResult3, imageRequest3, options5, eventListener2, c11972);
                obj4 = objTransform$coil_base_release;
                if (objTransform$coil_base_release == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (Throwable th2) {
                th = th2;
                objectRef2 = objectRef9;
                T t4 = objectRef2.element;
                if (t4 instanceof SourceResult) {
                }
                if (sourceResult != null && (source = sourceResult.getSource()) != null) {
                    Utils.closeQuietly(source);
                }
                throw th;
            }
        } else if (i == 2) {
            objectRef2 = (Ref.ObjectRef) c11972.L$4;
            objectRef3 = (Ref.ObjectRef) c11972.L$3;
            eventListener3 = (EventListener) c11972.L$2;
            imageRequest4 = (ImageRequest) c11972.L$1;
            engineInterceptor3 = (EngineInterceptor) c11972.L$0;
            try {
                ResultKt.throwOnFailure(obj5);
                obj3 = obj5;
                executeResult = (ExecuteResult) obj3;
                objectRef = objectRef2;
                engineInterceptor2 = engineInterceptor3;
                eventListener2 = eventListener3;
                imageRequest3 = imageRequest4;
                Ref.ObjectRef objectRef13 = objectRef3;
                ExecuteResult executeResult4 = executeResult;
                t2 = objectRef.element;
                if (t2 instanceof SourceResult) {
                    sourceResult2 = (SourceResult) t2;
                } else {
                    sourceResult2 = null;
                }
                if (sourceResult2 != null && (source2 = sourceResult2.getSource()) != null) {
                    Utils.closeQuietly(source2);
                }
                Options options6 = (Options) objectRef13.element;
                c11972.L$0 = null;
                c11972.L$1 = null;
                c11972.L$2 = null;
                c11972.L$3 = null;
                c11972.L$4 = null;
                c11972.L$5 = null;
                c11972.L$6 = null;
                c11972.L$7 = null;
                c11972.label = 3;
                objTransform$coil_base_release = engineInterceptor2.transform$coil_base_release(executeResult4, imageRequest3, options6, eventListener2, c11972);
                obj4 = objTransform$coil_base_release;
                if (objTransform$coil_base_release == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (Throwable th3) {
                th = th3;
                T t5 = objectRef2.element;
                sourceResult = t5 instanceof SourceResult ? (SourceResult) t5 : null;
                if (sourceResult != null) {
                    Utils.closeQuietly(source);
                }
                throw th;
            }
        } else {
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj5);
            obj4 = obj5;
        }
        ExecuteResult executeResult5 = (ExecuteResult) obj4;
        Drawable drawable = executeResult5.getDrawable();
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        if (bitmapDrawable != null && (bitmap = bitmapDrawable.getBitmap()) != null) {
            bitmap.prepareToDraw();
        }
        return executeResult5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x0065  */
    /* JADX WARN: Code duplicated, block: B:19:0x0091 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x0092  */
    /* JADX WARN: Code duplicated, block: B:24:0x009d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x009e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0092 -> B:21:0x0096). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object fetch(coil.ComponentRegistry r10, coil.request.ImageRequest r11, java.lang.Object r12, coil.request.Options r13, coil.EventListener r14, kotlin.coroutines.Continuation<? super coil.fetch.FetchResult> r15) {
        /*
            Method dump skipped, instruction units count: 209
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor.fetch(coil.ComponentRegistry, coil.request.ImageRequest, java.lang.Object, coil.request.Options, coil.EventListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x007e  */
    /* JADX WARN: Code duplicated, block: B:19:0x00ac A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:23:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:25:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:26:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:28:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:31:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00ad -> B:21:0x00b5). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object decode(coil.fetch.SourceResult r18, coil.ComponentRegistry r19, coil.request.ImageRequest r20, java.lang.Object r21, coil.request.Options r22, coil.EventListener r23, kotlin.coroutines.Continuation<? super coil.intercept.EngineInterceptor.ExecuteResult> r24) {
        /*
            Method dump skipped, instruction units count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor.decode(coil.fetch.SourceResult, coil.ComponentRegistry, coil.request.ImageRequest, java.lang.Object, coil.request.Options, coil.EventListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object transform$coil_base_release(ExecuteResult executeResult, ImageRequest imageRequest, Options options, EventListener eventListener, Continuation<? super ExecuteResult> continuation) {
        List<Transformation> transformations = imageRequest.getTransformations();
        if (transformations.isEmpty()) {
            return executeResult;
        }
        if (!(executeResult.getDrawable() instanceof BitmapDrawable) && !imageRequest.getAllowConversionToBitmap()) {
            Logger logger = this.logger;
            if (logger != null && logger.getLevel() <= 4) {
                logger.log(TAG, 4, "allowConversionToBitmap=false, skipping transformations for type " + executeResult.getDrawable().getClass().getCanonicalName() + '.', null);
            }
            return executeResult;
        }
        return BuildersKt.withContext(imageRequest.getTransformationDispatcher(), new EngineInterceptor$transform$3(this, executeResult, options, transformations, eventListener, imageRequest, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap convertDrawableToBitmap(Drawable drawable, Options options, List<? extends Transformation> transformations) {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Bitmap.Config safeConfig = Bitmaps.getSafeConfig(bitmap);
            if (ArraysKt.contains(Utils.getVALID_TRANSFORMATION_CONFIGS(), safeConfig)) {
                return bitmap;
            }
            Logger logger = this.logger;
            if (logger != null && logger.getLevel() <= 4) {
                logger.log(TAG, 4, "Converting bitmap with config " + safeConfig + " to apply transformations: " + transformations + '.', null);
            }
        } else {
            Logger logger2 = this.logger;
            if (logger2 != null && logger2.getLevel() <= 4) {
                logger2.log(TAG, 4, "Converting drawable of type " + drawable.getClass().getCanonicalName() + " to apply transformations: " + transformations + '.', null);
            }
        }
        return DrawableUtils.INSTANCE.convertToBitmap(drawable, options.getConfig(), options.getSize(), options.getScale(), options.getAllowInexactSize());
    }

    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ0\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcoil/intercept/EngineInterceptor$ExecuteResult;", "", "drawable", "Landroid/graphics/drawable/Drawable;", "isSampled", "", "dataSource", "Lcoil/decode/DataSource;", "diskCacheKey", "", "(Landroid/graphics/drawable/Drawable;ZLcoil/decode/DataSource;Ljava/lang/String;)V", "getDataSource", "()Lcoil/decode/DataSource;", "getDiskCacheKey", "()Ljava/lang/String;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "()Z", "copy", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ExecuteResult {
        private final DataSource dataSource;
        private final String diskCacheKey;
        private final Drawable drawable;
        private final boolean isSampled;

        public ExecuteResult(Drawable drawable, boolean z, DataSource dataSource, String str) {
            this.drawable = drawable;
            this.isSampled = z;
            this.dataSource = dataSource;
            this.diskCacheKey = str;
        }

        public final Drawable getDrawable() {
            return this.drawable;
        }

        /* JADX INFO: renamed from: isSampled, reason: from getter */
        public final boolean getIsSampled() {
            return this.isSampled;
        }

        public final DataSource getDataSource() {
            return this.dataSource;
        }

        public final String getDiskCacheKey() {
            return this.diskCacheKey;
        }

        public static /* synthetic */ ExecuteResult copy$default(ExecuteResult executeResult, Drawable drawable, boolean z, DataSource dataSource, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                drawable = executeResult.drawable;
            }
            if ((i & 2) != 0) {
                z = executeResult.isSampled;
            }
            if ((i & 4) != 0) {
                dataSource = executeResult.dataSource;
            }
            if ((i & 8) != 0) {
                str = executeResult.diskCacheKey;
            }
            return executeResult.copy(drawable, z, dataSource, str);
        }

        public final ExecuteResult copy(Drawable drawable, boolean isSampled, DataSource dataSource, String diskCacheKey) {
            return new ExecuteResult(drawable, isSampled, dataSource, diskCacheKey);
        }
    }
}
