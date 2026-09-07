package io.ktor.client.plugins.cache.storage;

import com.json.b9;
import io.ktor.http.Url;
import io.ktor.util.collections.ConcurrentMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileCacheStorage.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J/\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\n\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J!\u0010\u0004\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lio/ktor/client/plugins/cache/storage/CachingCacheStorage;", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "delegate", "(Lio/ktor/client/plugins/cache/storage/CacheStorage;)V", b9.h.U, "Lio/ktor/util/collections/ConcurrentMap;", "Lio/ktor/http/Url;", "", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "find", "url", "varyKeys", "", "", "(Lio/ktor/http/Url;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findAll", "(Lio/ktor/http/Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "data", "(Lio/ktor/http/Url;Lio/ktor/client/plugins/cache/storage/CachedResponseData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CachingCacheStorage implements CacheStorage {
    private final CacheStorage delegate;
    private final ConcurrentMap<Url, Set<CachedResponseData>> store;

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.CachingCacheStorage$find$1, reason: invalid class name */
    /* JADX INFO: compiled from: FileCacheStorage.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.CachingCacheStorage", f = "FileCacheStorage.kt", i = {0, 0, 0}, l = {43}, m = "find", n = {"this", "url", "varyKeys"}, s = {"L$0", "L$1", "L$2"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CachingCacheStorage.this.find(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.CachingCacheStorage$findAll$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileCacheStorage.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.CachingCacheStorage", f = "FileCacheStorage.kt", i = {0, 0}, l = {53}, m = "findAll", n = {"this", "url"}, s = {"L$0", "L$1"})
    static final class C46601 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C46601(Continuation<? super C46601> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CachingCacheStorage.this.findAll(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.CachingCacheStorage$store$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileCacheStorage.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.CachingCacheStorage", f = "FileCacheStorage.kt", i = {0, 0}, l = {37, 38}, m = b9.h.U, n = {"this", "url"}, s = {"L$0", "L$1"})
    static final class C46611 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C46611(Continuation<? super C46611> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CachingCacheStorage.this.store(null, null, this);
        }
    }

    public CachingCacheStorage(CacheStorage delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        this.store = new ConcurrentMap<>(0, 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object store(Url url, CachedResponseData cachedResponseData, Continuation<? super Unit> continuation) throws Throwable {
        C46611 c46611;
        CachingCacheStorage cachingCacheStorage;
        Map map;
        if (continuation instanceof C46611) {
            c46611 = (C46611) continuation;
            if ((c46611.label & Integer.MIN_VALUE) != 0) {
                c46611.label -= Integer.MIN_VALUE;
            } else {
                c46611 = new C46611(continuation);
            }
        } else {
            c46611 = new C46611(continuation);
        }
        Object obj = c46611.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c46611.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CacheStorage cacheStorage = this.delegate;
            c46611.L$0 = this;
            c46611.L$1 = url;
            c46611.label = 1;
            if (cacheStorage.store(url, cachedResponseData, c46611) == coroutine_suspended) {
                return coroutine_suspended;
            }
            cachingCacheStorage = this;
        } else {
            if (i == 1) {
                url = (Url) c46611.L$1;
                cachingCacheStorage = (CachingCacheStorage) c46611.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                url = (Url) c46611.L$1;
                map = (Map) c46611.L$0;
                ResultKt.throwOnFailure(obj);
            }
            map.put(url, obj);
            return Unit.INSTANCE;
        }
        ConcurrentMap<Url, Set<CachedResponseData>> concurrentMap = cachingCacheStorage.store;
        CacheStorage cacheStorage2 = cachingCacheStorage.delegate;
        c46611.L$0 = concurrentMap;
        c46611.L$1 = url;
        c46611.label = 2;
        Object objFindAll = cacheStorage2.findAll(url, c46611);
        if (objFindAll == coroutine_suspended) {
            return coroutine_suspended;
        }
        obj = objFindAll;
        map = concurrentMap;
        map.put(url, obj);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x008c  */
    /* JADX WARN: Code duplicated, block: B:28:0x009a  */
    /* JADX WARN: Code duplicated, block: B:31:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ca A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:? A[LOOP:0: B:23:0x0086->B:39:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:? A[LOOP:1: B:29:0x00a2->B:40:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object find(Url url, Map<String, String> map, Continuation<? super CachedResponseData> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        CachingCacheStorage cachingCacheStorage;
        Url url2;
        Map<String, String> map2;
        Map map3;
        CachedResponseData cachedResponseData;
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
            if (this.store.containsKey(url)) {
                cachingCacheStorage = this;
            } else {
                ConcurrentMap<Url, Set<CachedResponseData>> concurrentMap = this.store;
                CacheStorage cacheStorage = this.delegate;
                anonymousClass1.L$0 = this;
                anonymousClass1.L$1 = url;
                anonymousClass1.L$2 = map;
                anonymousClass1.L$3 = concurrentMap;
                anonymousClass1.L$4 = url;
                anonymousClass1.label = 1;
                Object objFindAll = cacheStorage.findAll(url, anonymousClass1);
                if (objFindAll == coroutine_suspended) {
                    return coroutine_suspended;
                }
                url2 = url;
                map2 = map;
                map3 = concurrentMap;
                obj = objFindAll;
                cachingCacheStorage = this;
            }
            for (Object obj2 : (Set) MapsKt.getValue(cachingCacheStorage.store, url)) {
                cachedResponseData = (CachedResponseData) obj2;
                if (map.isEmpty()) {
                    return obj2;
                }
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (!Intrinsics.areEqual(cachedResponseData.getVaryKeys().get(entry.getKey()), entry.getValue())) {
                    }
                }
                return obj2;
            }
            return null;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        url = (Url) anonymousClass1.L$4;
        map3 = (Map) anonymousClass1.L$3;
        map2 = (Map) anonymousClass1.L$2;
        url2 = (Url) anonymousClass1.L$1;
        cachingCacheStorage = (CachingCacheStorage) anonymousClass1.L$0;
        ResultKt.throwOnFailure(obj);
        map3.put(url, obj);
        map = map2;
        url = url2;
        while (r6.hasNext()) {
            cachedResponseData = (CachedResponseData) obj2;
            if (map.isEmpty()) {
                return obj2;
            }
            while (r1.hasNext()) {
                if (!Intrinsics.areEqual(cachedResponseData.getVaryKeys().get(entry.getKey()), entry.getValue())) {
                }
            }
            return obj2;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object findAll(Url url, Continuation<? super Set<CachedResponseData>> continuation) throws Throwable {
        C46601 c46601;
        CachingCacheStorage cachingCacheStorage;
        Url url2;
        Map map;
        if (continuation instanceof C46601) {
            c46601 = (C46601) continuation;
            if ((c46601.label & Integer.MIN_VALUE) != 0) {
                c46601.label -= Integer.MIN_VALUE;
            } else {
                c46601 = new C46601(continuation);
            }
        } else {
            c46601 = new C46601(continuation);
        }
        Object obj = c46601.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c46601.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.store.containsKey(url)) {
                cachingCacheStorage = this;
            } else {
                ConcurrentMap<Url, Set<CachedResponseData>> concurrentMap = this.store;
                CacheStorage cacheStorage = this.delegate;
                c46601.L$0 = this;
                c46601.L$1 = url;
                c46601.L$2 = concurrentMap;
                c46601.L$3 = url;
                c46601.label = 1;
                Object objFindAll = cacheStorage.findAll(url, c46601);
                if (objFindAll == coroutine_suspended) {
                    return coroutine_suspended;
                }
                url2 = url;
                map = concurrentMap;
                obj = objFindAll;
                cachingCacheStorage = this;
            }
            return MapsKt.getValue(cachingCacheStorage.store, url);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        url = (Url) c46601.L$3;
        map = (Map) c46601.L$2;
        url2 = (Url) c46601.L$1;
        cachingCacheStorage = (CachingCacheStorage) c46601.L$0;
        ResultKt.throwOnFailure(obj);
        map.put(url, obj);
        url = url2;
        return MapsKt.getValue(cachingCacheStorage.store, url);
    }
}
