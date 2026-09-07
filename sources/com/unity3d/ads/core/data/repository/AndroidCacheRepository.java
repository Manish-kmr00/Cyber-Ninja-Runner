package com.unity3d.ads.core.data.repository;

import android.content.Context;
import com.json.uc;
import com.unity3d.ads.core.data.datasource.CacheDataSource;
import com.unity3d.ads.core.data.model.CacheError;
import com.unity3d.ads.core.data.model.CacheResult;
import com.unity3d.ads.core.data.model.CacheSource;
import com.unity3d.ads.core.data.model.CachedFile;
import com.unity3d.ads.core.domain.GetCacheDirectory;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.unity3d.ads.core.domain.work.DownloadPriorityQueue;
import com.unity3d.ads.core.extensions.FileExtensionsKt;
import com.unity3d.ads.core.extensions.StringExtensionsKt;
import com.unity3d.services.UnityAdsConstants;
import com.unity3d.services.core.network.domain.CleanupDirectory;
import gatewayprotocol.v1.NativeConfigurationOuterClass;
import io.ktor.http.ContentDisposition;
import java.io.File;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.json.JSONArray;

/* JADX INFO: compiled from: AndroidCacheRepository.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0017H\u0002J\u0011\u0010\"\u001a\u00020 H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0016H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u0013H\u0002J\b\u0010)\u001a\u00020\u0016H\u0002J\u0011\u0010*\u001a\u00020+H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010#J3\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u00162\b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u000203H\u0096@ø\u0001\u0000¢\u0006\u0002\u00104J\u000e\u00105\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u0016J\b\u00106\u001a\u00020\u0013H\u0002J\u0010\u00107\u001a\u00020%2\u0006\u0010!\u001a\u00020\u0017H\u0016J\u0010\u00108\u001a\u00020-2\u0006\u0010&\u001a\u00020\u0016H\u0016R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u001b0\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00069"}, d2 = {"Lcom/unity3d/ads/core/data/repository/AndroidCacheRepository;", "Lcom/unity3d/ads/core/data/repository/CacheRepository;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getCacheDirectory", "Lcom/unity3d/ads/core/domain/GetCacheDirectory;", "localCacheDataSource", "Lcom/unity3d/ads/core/data/datasource/CacheDataSource;", "remoteCacheDataSource", "context", "Landroid/content/Context;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "cleanupDirectory", "Lcom/unity3d/services/core/network/domain/CleanupDirectory;", "downloadPriorityQueue", "Lcom/unity3d/ads/core/domain/work/DownloadPriorityQueue;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/unity3d/ads/core/domain/GetCacheDirectory;Lcom/unity3d/ads/core/data/datasource/CacheDataSource;Lcom/unity3d/ads/core/data/datasource/CacheDataSource;Landroid/content/Context;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/services/core/network/domain/CleanupDirectory;Lcom/unity3d/ads/core/domain/work/DownloadPriorityQueue;)V", "cacheDir", "Ljava/io/File;", "cachedFiles", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/unity3d/ads/core/data/model/CachedFile;", "getCachedFiles", "()Ljava/util/concurrent/ConcurrentHashMap;", "neededFiles", "", "getNeededFiles", "scope", "Lkotlinx/coroutines/CoroutineScope;", "addFileToCache", "", "cachedFile", "clearCache", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doesFileExist", "", uc.c.b, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCacheDirBase", "getCacheDirPath", "getCacheSize", "", "getFile", "Lcom/unity3d/ads/core/data/model/CacheResult;", "url", "objectId", "headers", "Lorg/json/JSONArray;", HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, "", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONArray;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFilename", "initCacheDir", "removeFile", "retrieveFile", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidCacheRepository implements CacheRepository {
    private final File cacheDir;
    private final ConcurrentHashMap<String, CachedFile> cachedFiles;
    private final CleanupDirectory cleanupDirectory;
    private final Context context;
    private final DownloadPriorityQueue downloadPriorityQueue;
    private final GetCacheDirectory getCacheDirectory;
    private final CacheDataSource localCacheDataSource;
    private final ConcurrentHashMap<String, Set<String>> neededFiles;
    private final CacheDataSource remoteCacheDataSource;
    private final CoroutineScope scope;
    private final SessionRepository sessionRepository;

    public AndroidCacheRepository(CoroutineDispatcher ioDispatcher, GetCacheDirectory getCacheDirectory, CacheDataSource localCacheDataSource, CacheDataSource remoteCacheDataSource, Context context, SessionRepository sessionRepository, CleanupDirectory cleanupDirectory, DownloadPriorityQueue downloadPriorityQueue) {
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        Intrinsics.checkNotNullParameter(getCacheDirectory, "getCacheDirectory");
        Intrinsics.checkNotNullParameter(localCacheDataSource, "localCacheDataSource");
        Intrinsics.checkNotNullParameter(remoteCacheDataSource, "remoteCacheDataSource");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(cleanupDirectory, "cleanupDirectory");
        Intrinsics.checkNotNullParameter(downloadPriorityQueue, "downloadPriorityQueue");
        this.getCacheDirectory = getCacheDirectory;
        this.localCacheDataSource = localCacheDataSource;
        this.remoteCacheDataSource = remoteCacheDataSource;
        this.context = context;
        this.sessionRepository = sessionRepository;
        this.cleanupDirectory = cleanupDirectory;
        this.downloadPriorityQueue = downloadPriorityQueue;
        this.scope = CoroutineScopeKt.plus(CoroutineScopeKt.plus(CoroutineScopeKt.CoroutineScope(ioDispatcher), new CoroutineName("CacheRepository")), NonCancellable.INSTANCE);
        this.cachedFiles = new ConcurrentHashMap<>();
        this.neededFiles = new ConcurrentHashMap<>();
        this.cacheDir = initCacheDir();
    }

    public final ConcurrentHashMap<String, CachedFile> getCachedFiles() {
        return this.cachedFiles;
    }

    public final ConcurrentHashMap<String, Set<String>> getNeededFiles() {
        return this.neededFiles;
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidCacheRepository$getFile$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AndroidCacheRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/unity3d/ads/core/data/model/CacheResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.data.repository.AndroidCacheRepository$getFile$2", f = "AndroidCacheRepository.kt", i = {0, 1}, l = {55, 63, 79}, m = "invokeSuspend", n = {ContentDisposition.Parameters.FileName, "fileResult"}, s = {"L$0", "L$0"})
    static final class C37172 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CacheResult>, Object> {
        final /* synthetic */ String $objectId;
        final /* synthetic */ int $priority;
        final /* synthetic */ String $url;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C37172(String str, int i, String str2, Continuation<? super C37172> continuation) {
            super(2, continuation);
            this.$url = str;
            this.$priority = i;
            this.$objectId = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AndroidCacheRepository.this.new C37172(this.$url, this.$priority, this.$objectId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super CacheResult> continuation) {
            return ((C37172) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:24:0x00cd A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:26:? A[RETURN, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String filename;
            Object file;
            MutableStateFlow MutableStateFlow;
            Object objFirst;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                filename = AndroidCacheRepository.this.getFilename(this.$url);
                this.L$0 = filename;
                this.label = 1;
                file = AndroidCacheRepository.this.localCacheDataSource.getFile(AndroidCacheRepository.this.cacheDir, filename, this.$url, Boxing.boxInt(this.$priority), this);
                if (file == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i == 1) {
                    filename = (String) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    file = obj;
                } else {
                    if (i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    MutableStateFlow = (MutableStateFlow) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                this.L$0 = null;
                this.label = 3;
                objFirst = FlowKt.first(FlowKt.filterNotNull(MutableStateFlow), this);
                if (objFirst == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objFirst;
            }
            String str = filename;
            CacheResult cacheResult = (CacheResult) file;
            if (cacheResult instanceof CacheResult.Success) {
                AndroidCacheRepository androidCacheRepository = AndroidCacheRepository.this;
                CachedFile cachedFile = ((CacheResult.Success) cacheResult).getCachedFile();
                androidCacheRepository.addFileToCache(cachedFile.copy((254 & 1) != 0 ? cachedFile.objectId : this.$objectId, (254 & 2) != 0 ? cachedFile.url : null, (254 & 4) != 0 ? cachedFile.name : null, (254 & 8) != 0 ? cachedFile.file : null, (254 & 16) != 0 ? cachedFile.extension : null, (254 & 32) != 0 ? cachedFile.contentLength : 0L, (254 & 64) != 0 ? cachedFile.protocol : null, (254 & 128) != 0 ? cachedFile.priority : 0));
                return cacheResult;
            }
            MutableStateFlow = StateFlowKt.MutableStateFlow(null);
            this.L$0 = MutableStateFlow;
            this.label = 2;
            if (AndroidCacheRepository.this.downloadPriorityQueue.invoke(this.$priority, new AnonymousClass1(AndroidCacheRepository.this, str, this.$url, this.$priority, this.$objectId, MutableStateFlow, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            this.L$0 = null;
            this.label = 3;
            objFirst = FlowKt.first(FlowKt.filterNotNull(MutableStateFlow), this);
            if (objFirst == coroutine_suspended) {
                return coroutine_suspended;
            }
            return objFirst;
        }

        /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidCacheRepository$getFile$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: AndroidCacheRepository.kt */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.unity3d.ads.core.data.repository.AndroidCacheRepository$getFile$2$1", f = "AndroidCacheRepository.kt", i = {}, l = {65, 72}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            final /* synthetic */ MutableStateFlow<CacheResult> $fileResult;
            final /* synthetic */ String $filename;
            final /* synthetic */ String $objectId;
            final /* synthetic */ int $priority;
            final /* synthetic */ String $url;
            int label;
            final /* synthetic */ AndroidCacheRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(AndroidCacheRepository androidCacheRepository, String str, String str2, int i, String str3, MutableStateFlow<CacheResult> mutableStateFlow, Continuation<? super AnonymousClass1> continuation) {
                super(1, continuation);
                this.this$0 = androidCacheRepository;
                this.$filename = str;
                this.$url = str2;
                this.$priority = i;
                this.$objectId = str3;
                this.$fileResult = mutableStateFlow;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$filename, this.$url, this.$priority, this.$objectId, this.$fileResult, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:25:0x00a1  */
            /* JADX WARN: Code duplicated, block: B:32:? A[LOOP:0: B:27:0x00c0->B:32:?, LOOP_END, SYNTHETIC] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                CacheResult cacheResult;
                MutableStateFlow<CacheResult> mutableStateFlow;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = this.this$0.localCacheDataSource.getFile(this.this$0.cacheDir, this.$filename, this.$url, Boxing.boxInt(this.$priority), this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    cacheResult = (CacheResult) obj;
                    if (cacheResult instanceof CacheResult.Success) {
                        AndroidCacheRepository androidCacheRepository = this.this$0;
                        CachedFile cachedFile = ((CacheResult.Success) cacheResult).getCachedFile();
                        androidCacheRepository.addFileToCache(cachedFile.copy((254 & 1) != 0 ? cachedFile.objectId : this.$objectId, (254 & 2) != 0 ? cachedFile.url : null, (254 & 4) != 0 ? cachedFile.name : null, (254 & 8) != 0 ? cachedFile.file : null, (254 & 16) != 0 ? cachedFile.extension : null, (254 & 32) != 0 ? cachedFile.contentLength : 0L, (254 & 64) != 0 ? cachedFile.protocol : null, (254 & 128) != 0 ? cachedFile.priority : 0));
                    }
                    mutableStateFlow = this.$fileResult;
                    while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), cacheResult)) {
                    }
                    return Unit.INSTANCE;
                }
                CacheResult cacheResult2 = (CacheResult) obj;
                if (!(cacheResult2 instanceof CacheResult.Success)) {
                    this.label = 2;
                    obj = this.this$0.remoteCacheDataSource.getFile(this.this$0.cacheDir, this.$filename, this.$url, Boxing.boxInt(this.$priority), this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    cacheResult = (CacheResult) obj;
                    if (cacheResult instanceof CacheResult.Success) {
                        AndroidCacheRepository androidCacheRepository2 = this.this$0;
                        CachedFile cachedFile2 = ((CacheResult.Success) cacheResult).getCachedFile();
                        androidCacheRepository2.addFileToCache(cachedFile2.copy((254 & 1) != 0 ? cachedFile2.objectId : this.$objectId, (254 & 2) != 0 ? cachedFile2.url : null, (254 & 4) != 0 ? cachedFile2.name : null, (254 & 8) != 0 ? cachedFile2.file : null, (254 & 16) != 0 ? cachedFile2.extension : null, (254 & 32) != 0 ? cachedFile2.contentLength : 0L, (254 & 64) != 0 ? cachedFile2.protocol : null, (254 & 128) != 0 ? cachedFile2.priority : 0));
                    }
                    mutableStateFlow = this.$fileResult;
                    while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), cacheResult)) {
                    }
                    return Unit.INSTANCE;
                }
                AndroidCacheRepository androidCacheRepository3 = this.this$0;
                CachedFile cachedFile3 = ((CacheResult.Success) cacheResult2).getCachedFile();
                androidCacheRepository3.addFileToCache(cachedFile3.copy((254 & 1) != 0 ? cachedFile3.objectId : this.$objectId, (254 & 2) != 0 ? cachedFile3.url : null, (254 & 4) != 0 ? cachedFile3.name : null, (254 & 8) != 0 ? cachedFile3.file : null, (254 & 16) != 0 ? cachedFile3.extension : null, (254 & 32) != 0 ? cachedFile3.contentLength : 0L, (254 & 64) != 0 ? cachedFile3.protocol : null, (254 & 128) != 0 ? cachedFile3.priority : 0));
                MutableStateFlow<CacheResult> mutableStateFlow2 = this.$fileResult;
                while (!mutableStateFlow2.compareAndSet(mutableStateFlow2.getValue(), cacheResult2)) {
                }
                return Unit.INSTANCE;
            }
        }
    }

    @Override // com.unity3d.ads.core.data.repository.CacheRepository
    public Object getFile(String str, String str2, JSONArray jSONArray, int i, Continuation<? super CacheResult> continuation) {
        return BuildersKt.withContext(this.scope.getCoroutineContext(), new C37172(str, i, str2, null), continuation);
    }

    @Override // com.unity3d.ads.core.data.repository.CacheRepository
    public CacheResult retrieveFile(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        CachedFile cachedFile = this.cachedFiles.get(fileName);
        if (cachedFile != null) {
            return new CacheResult.Success(cachedFile, CacheSource.LOCAL);
        }
        return new CacheResult.Failure(CacheError.FILE_NOT_FOUND, CacheSource.LOCAL);
    }

    @Override // com.unity3d.ads.core.data.repository.CacheRepository
    public boolean removeFile(CachedFile cachedFile) {
        Intrinsics.checkNotNullParameter(cachedFile, "cachedFile");
        this.cachedFiles.remove(cachedFile.getName());
        Set<String> set = this.neededFiles.get(cachedFile.getName());
        if (set != null) {
            set.remove(cachedFile.getObjectId());
        }
        File file = cachedFile.getFile();
        if (file != null) {
            if (!file.exists()) {
                file = null;
            }
            if (file != null) {
                return file.delete();
            }
        }
        return false;
    }

    @Override // com.unity3d.ads.core.data.repository.CacheRepository
    public Object doesFileExist(String str, Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(this.cachedFiles.containsKey(str));
    }

    public final String getFilename(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return StringExtensionsKt.getSHA256Hash(url);
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidCacheRepository$clearCache$2, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidCacheRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.data.repository.AndroidCacheRepository$clearCache$2", f = "AndroidCacheRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AndroidCacheRepository.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (!AndroidCacheRepository.this.sessionRepository.getNativeConfiguration().hasCachedAssetsConfiguration()) {
                    File[] fileArrListFiles = AndroidCacheRepository.this.cacheDir.listFiles();
                    if (fileArrListFiles == null) {
                        return null;
                    }
                    for (File file : fileArrListFiles) {
                        file.delete();
                    }
                    return Unit.INSTANCE;
                }
                NativeConfigurationOuterClass.CachedAssetsConfiguration cachedAssetsConfiguration = AndroidCacheRepository.this.sessionRepository.getNativeConfiguration().getCachedAssetsConfiguration();
                AndroidCacheRepository.this.cleanupDirectory.invoke(AndroidCacheRepository.this.cacheDir, cachedAssetsConfiguration.getMaxCachedAssetSizeMb(), cachedAssetsConfiguration.getMaxCachedAssetAgeMs());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.unity3d.ads.core.data.repository.CacheRepository
    public Object clearCache(Continuation<? super Unit> continuation) {
        return BuildersKt.withContext(this.scope.getCoroutineContext(), new AnonymousClass2(null), continuation);
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidCacheRepository$getCacheSize$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AndroidCacheRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.data.repository.AndroidCacheRepository$getCacheSize$2", f = "AndroidCacheRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C37162 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
        int label;

        C37162(Continuation<? super C37162> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AndroidCacheRepository.this.new C37162(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Long> continuation) {
            return ((C37162) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return Boxing.boxLong(FileExtensionsKt.getDirectorySize(AndroidCacheRepository.this.cacheDir));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.unity3d.ads.core.data.repository.CacheRepository
    public Object getCacheSize(Continuation<? super Long> continuation) {
        return BuildersKt.withContext(this.scope.getCoroutineContext(), new C37162(null), continuation);
    }

    private final File initCacheDir() {
        File fileInvoke = this.getCacheDirectory.invoke(getCacheDirBase(), getCacheDirPath());
        fileInvoke.mkdirs();
        return fileInvoke;
    }

    private final File getCacheDirBase() {
        File cacheDir = this.context.getCacheDir();
        Intrinsics.checkNotNullExpressionValue(cacheDir, "context.cacheDir");
        return cacheDir;
    }

    private final String getCacheDirPath() {
        return UnityAdsConstants.DefaultUrls.CACHE_DIR_NAME;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addFileToCache(CachedFile cachedFile) {
        this.cachedFiles.put(cachedFile.getName(), cachedFile);
        LinkedHashSet linkedHashSet = this.neededFiles.get(cachedFile.getName());
        if (linkedHashSet == null) {
            linkedHashSet = new LinkedHashSet();
        }
        linkedHashSet.add(cachedFile.getObjectId());
        this.neededFiles.put(cachedFile.getName(), linkedHashSet);
    }
}
