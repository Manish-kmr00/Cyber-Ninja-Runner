package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.c0;
import java.io.File;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes10.dex */
public final class j implements i {
    public static final a k = new a(null);
    public static final String l = "MediaCacheRepository";
    public static final String m = "TEMP";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f6595a;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.d b;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.a c;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f d;
    public final CoroutineScope e;
    public final ConcurrentHashMap<String, Mutex> f;
    public final HashSet<String> g;
    public final ConcurrentHashMap<String, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b> h;
    public final CoroutineScope i;
    public Job j;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }

        public final String a(String str) {
            return str + j.m;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.MediaCacheRepositoryImpl$getMediaFile$2", f = "MediaCacheRepository.kt", i = {0, 1, 1, 1}, l = {373, 161}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "dstFile", "tmpFile"}, s = {"L$0", "L$0", "L$2", "L$3"})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super i.a>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6596a;
        public Object b;
        public Object c;
        public Object d;
        public int e;
        public final /* synthetic */ String f;
        public final /* synthetic */ j g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, j jVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.f = str;
            this.g = jVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super i.a> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.f, this.g, continuation);
        }

        /* JADX WARN: Code duplicated, block: B:59:0x01a3 A[Catch: all -> 0x0034, Exception -> 0x0037, TryCatch #0 {all -> 0x0034, blocks: (B:7:0x002b, B:57:0x019d, B:59:0x01a3, B:61:0x01bb, B:64:0x01e2, B:76:0x01fb), top: B:82:0x0015 }] */
        /* JADX WARN: Code duplicated, block: B:61:0x01bb A[Catch: all -> 0x0034, Exception -> 0x0037, TRY_LEAVE, TryCatch #0 {all -> 0x0034, blocks: (B:7:0x002b, B:57:0x019d, B:59:0x01a3, B:61:0x01bb, B:64:0x01e2, B:76:0x01fb), top: B:82:0x0015 }] */
        /* JADX WARN: Code duplicated, block: B:64:0x01e2 A[Catch: all -> 0x0034, Exception -> 0x0037, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0034, blocks: (B:7:0x002b, B:57:0x019d, B:59:0x01a3, B:61:0x01bb, B:64:0x01e2, B:76:0x01fb), top: B:82:0x0015 }] */
        /* JADX WARN: Code duplicated, block: B:67:0x01eb  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v0 */
        /* JADX WARN: Type inference failed for: r11v1, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r11v5, types: [java.lang.Object, kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r11v8 */
        /* JADX WARN: Type inference failed for: r11v9 */
        /* JADX WARN: Type inference failed for: r6v1 */
        /* JADX WARN: Type inference failed for: r6v2 */
        /* JADX WARN: Type inference failed for: r6v3, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r6v4, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r6v7 */
        /* JADX WARN: Type inference failed for: r6v8 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            ?? r11;
            j jVar;
            String str;
            Object objPutIfAbsent;
            ?? r6;
            File file;
            File file2;
            Object objA;
            ?? r7;
            Object obj2;
            i.a aVar;
            MolocoLogger molocoLogger;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.e;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        if (this.f.length() == 0) {
                            return i.a.AbstractC0600a.k.c;
                        }
                        ConcurrentHashMap concurrentHashMap = this.g.f;
                        String str2 = this.f;
                        Object objMutex$default = concurrentHashMap.get(str2);
                        if (objMutex$default == null && (objPutIfAbsent = concurrentHashMap.putIfAbsent(str2, (objMutex$default = MutexKt.Mutex$default(false, 1, null)))) != null) {
                            objMutex$default = objPutIfAbsent;
                        }
                        Mutex mutex = (Mutex) objMutex$default;
                        Intrinsics.checkNotNullExpressionValue(mutex, "mutex");
                        j jVar2 = this.g;
                        String str3 = this.f;
                        this.f6596a = mutex;
                        this.b = jVar2;
                        this.c = str3;
                        this.e = 1;
                        if (mutex.lock(null, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        jVar = jVar2;
                        str = str3;
                        r11 = mutex;
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            File file3 = (File) this.d;
                            File file4 = (File) this.c;
                            String str4 = (String) this.b;
                            Mutex mutex2 = (Mutex) this.f6596a;
                            try {
                                ResultKt.throwOnFailure(obj);
                                file = file4;
                                file2 = file3;
                                objA = obj;
                                r7 = mutex2;
                                aVar = (i.a) objA;
                                if (aVar instanceof i.a.b) {
                                    r7.unlock(null);
                                    return aVar;
                                }
                                molocoLogger = MolocoLogger.INSTANCE;
                                MolocoLogger.debug$default(molocoLogger, j.l, "Renaming tmp file to dst file", false, 4, null);
                                if (!file2.renameTo(file)) {
                                    i.a.b bVar = new i.a.b(file);
                                    r7.unlock(null);
                                    return bVar;
                                }
                                MolocoLogger.info$default(molocoLogger, j.l, "Renaming to dst file failed, dstFile exists: " + file.exists(), null, false, 12, null);
                                i.a.AbstractC0600a.p pVar = i.a.AbstractC0600a.p.c;
                                r7.unlock(null);
                                return pVar;
                            } catch (Exception e) {
                                e = e;
                                str = str4;
                                r6 = mutex2;
                                MolocoLogger.error$default(MolocoLogger.INSTANCE, j.l, "Failed to fetch media from url: " + str, e, false, 8, null);
                                i.a.AbstractC0600a abstractC0600aA = o.a(e);
                                r6.unlock(null);
                                return abstractC0600aA;
                            }
                        }
                        str = (String) this.c;
                        jVar = (j) this.b;
                        Mutex mutex3 = (Mutex) this.f6596a;
                        ResultKt.throwOnFailure(obj);
                        r11 = mutex3;
                    }
                    v<File, com.moloco.sdk.internal.m> vVarD = jVar.d();
                    if (vVarD instanceof v.a) {
                        MolocoLogger.warn$default(MolocoLogger.INSTANCE, j.l, "Failed to retrieve storageDir with error code: " + ((com.moloco.sdk.internal.m) ((v.a) vVarD).a()).b(), null, false, 12, null);
                        switch (((com.moloco.sdk.internal.m) ((v.a) vVarD).a()).b()) {
                            case 100:
                                obj2 = i.a.AbstractC0600a.c.c;
                                break;
                            case 101:
                                obj2 = i.a.AbstractC0600a.b.c;
                                break;
                            case 102:
                                obj2 = i.a.AbstractC0600a.C0601a.c;
                                break;
                            default:
                                obj2 = i.a.AbstractC0600a.d.c;
                                break;
                        }
                        r11.unlock(null);
                        return obj2;
                    }
                    if (!(vVarD instanceof v.b)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    File file5 = (File) ((v.b) vVarD).a();
                    String strB = c0.b(str);
                    file = new File(file5, strB);
                    if (file.exists()) {
                        if (!jVar.c.a(file)) {
                            MolocoLogger.info$default(MolocoLogger.INSTANCE, j.l, "Found asset in cache: " + str, null, false, 12, null);
                            i.a.b bVar2 = new i.a.b(file);
                            r11.unlock(null);
                            return bVar2;
                        }
                        MolocoLogger.info$default(MolocoLogger.INSTANCE, j.l, "Media file was partially downloaded by ChunkedMediaDownloader. Deleting the file and redownloading", null, false, 12, null);
                        file.delete();
                    }
                    file2 = new File(file5, j.k.a(strB));
                    MolocoLogger.debug$default(MolocoLogger.INSTANCE, j.l, "Asset not found in cache. Downloading to tmp file[already exists == " + file2.exists() + AbstractJsonLexerKt.END_LIST, false, 4, null);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.d dVar = jVar.b;
                    this.f6596a = r11;
                    this.b = str;
                    this.c = file;
                    this.d = file2;
                    this.e = 2;
                    objA = dVar.a(str, file2, this);
                    if (objA == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    r7 = r11;
                    aVar = (i.a) objA;
                    if (aVar instanceof i.a.b) {
                        r7.unlock(null);
                        return aVar;
                    }
                    molocoLogger = MolocoLogger.INSTANCE;
                    MolocoLogger.debug$default(molocoLogger, j.l, "Renaming tmp file to dst file", false, 4, null);
                    if (!file2.renameTo(file)) {
                        i.a.b bVar3 = new i.a.b(file);
                        r7.unlock(null);
                        return bVar3;
                    }
                    MolocoLogger.info$default(molocoLogger, j.l, "Renaming to dst file failed, dstFile exists: " + file.exists(), null, false, 12, null);
                    i.a.AbstractC0600a.p pVar2 = i.a.AbstractC0600a.p.c;
                    r7.unlock(null);
                    return pVar2;
                } catch (Exception e2) {
                    e = e2;
                    r6 = r11;
                    MolocoLogger.error$default(MolocoLogger.INSTANCE, j.l, "Failed to fetch media from url: " + str, e, false, 8, null);
                    i.a.AbstractC0600a abstractC0600aA2 = o.a(e);
                    r6.unlock(null);
                    return abstractC0600aA2;
                } catch (Throwable th) {
                    th = th;
                    r11.unlock(null);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                r11 = coroutine_suspended;
            }
        }
    }

    public static final class c extends Lambda implements Function1<File, Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f6597a = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Long invoke(File it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Long.valueOf(it.length());
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.MediaCacheRepositoryImpl$streamMediaFile$2", f = "MediaCacheRepository.kt", i = {0}, l = {373}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6598a;
        public Object b;
        public Object c;
        public Object d;
        public int e;
        public final /* synthetic */ String f;
        public final /* synthetic */ j g;
        public final /* synthetic */ String h;

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.MediaCacheRepositoryImpl$streamMediaFile$2$1$1", f = "MediaCacheRepository.kt", i = {}, l = {228}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f6599a;
            public final /* synthetic */ j b;
            public final /* synthetic */ String c;
            public final /* synthetic */ File d;
            public final /* synthetic */ String e;
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(j jVar, String str, File file, String str2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b bVar, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = jVar;
                this.c = str;
                this.d = file;
                this.e = str2;
                this.f = bVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, this.c, this.d, this.e, this.f, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f6599a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.a aVar = this.b.c;
                    String str = this.c;
                    File file = this.d;
                    String str2 = this.e;
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b bVar = this.f;
                    this.f6599a = 1;
                    if (aVar.a(str, file, str2, bVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.b.g.remove(this.c);
                this.b.h.remove(this.c);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, j jVar, String str2, Continuation<? super d> continuation) {
            super(2, continuation);
            this.f = str;
            this.g = jVar;
            this.h = str2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.f, this.g, this.h, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Mutex mutex;
            j jVar;
            String str;
            String str2;
            Object objPutIfAbsent;
            Object objPutIfAbsent2;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c c0605c;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.e;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, j.l, "Streaming media for: " + this.f, null, false, 12, null);
                if (this.f.length() == 0) {
                    return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.b(i.a.AbstractC0600a.k.c);
                }
                ConcurrentHashMap concurrentHashMap = this.g.f;
                String str3 = this.f;
                Object objMutex$default = concurrentHashMap.get(str3);
                if (objMutex$default == null && (objPutIfAbsent = concurrentHashMap.putIfAbsent(str3, (objMutex$default = MutexKt.Mutex$default(false, 1, null)))) != null) {
                    objMutex$default = objPutIfAbsent;
                }
                mutex = (Mutex) objMutex$default;
                Intrinsics.checkNotNullExpressionValue(mutex, "mutex");
                j jVar2 = this.g;
                String str4 = this.f;
                String str5 = this.h;
                this.f6598a = mutex;
                this.b = jVar2;
                this.c = str4;
                this.d = str5;
                this.e = 1;
                if (mutex.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                jVar = jVar2;
                str = str4;
                str2 = str5;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                String str6 = (String) this.d;
                String str7 = (String) this.c;
                j jVar3 = (j) this.b;
                mutex = (Mutex) this.f6598a;
                ResultKt.throwOnFailure(obj);
                str2 = str6;
                str = str7;
                jVar = jVar3;
            }
            try {
                v vVarC = jVar.c();
                if (vVarC instanceof v.a) {
                    Object objA = ((v.a) vVarC).a();
                    mutex.unlock(null);
                    return objA;
                }
                if (!(vVarC instanceof v.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                File fileA = jVar.a(str, (File) ((v.b) vVarC).a());
                MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
                MolocoLogger.info$default(molocoLogger, j.l, "Going to download the media file to location: " + fileA.getAbsolutePath(), null, false, 12, null);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b bVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b) jVar.h.get(str);
                if (jVar.g.contains(str)) {
                    MolocoLogger.info$default(molocoLogger, j.l, "Media file is already being downloaded, so returning in progress status for url: " + str, null, false, 12, null);
                    if (bVar == null || (c0605c = bVar.a()) == null) {
                        c0605c = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.C0605c(fileA, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.d.a());
                    }
                    mutex.unlock(null);
                    return c0605c;
                }
                if (jVar.c.b(fileA)) {
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.a aVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.a(fileA);
                    mutex.unlock(null);
                    return aVar;
                }
                MolocoLogger.info$default(molocoLogger, j.l, "Media file needs to be downloaded: " + str, null, false, 12, null);
                jVar.g.add(str);
                ConcurrentHashMap concurrentHashMap2 = jVar.h;
                Object bVar2 = concurrentHashMap2.get(str);
                if (bVar2 == null && (objPutIfAbsent2 = concurrentHashMap2.putIfAbsent(str, (bVar2 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.C0605c(fileA, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.d.a()))))) != null) {
                    bVar2 = objPutIfAbsent2;
                }
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b bVar3 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b) bVar2;
                BuildersKt__Builders_commonKt.launch$default(jVar.e, null, null, new a(jVar, str, fileA, str2, bVar3, null), 3, null);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c cVarA = bVar3.a();
                mutex.unlock(null);
                return cVarA;
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.MediaCacheRepositoryImpl$streamMediaFileStatus$1", f = "MediaCacheRepository.kt", i = {}, l = {249}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<FlowCollector<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c>, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6600a;
        public /* synthetic */ Object b;
        public final /* synthetic */ File c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(File file, Continuation<? super e> continuation) {
            super(2, continuation);
            this.c = file;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(FlowCollector<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> flowCollector, Continuation<? super Unit> continuation) {
            return ((e) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            e eVar = new e(this.c, continuation);
            eVar.b = obj;
            return eVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6600a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = (FlowCollector) this.b;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.a aVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.a(this.c);
                this.f6600a = 1;
                if (flowCollector.emit(aVar, this) == coroutine_suspended) {
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
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.MediaCacheRepositoryImpl$streamMediaFileStatus$cacheDir$1", f = "MediaCacheRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends SuspendLambda implements Function2<FlowCollector<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c>, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6601a;
        public final /* synthetic */ v<File, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.b> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(v<File, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.b> vVar, Continuation<? super f> continuation) {
            super(2, continuation);
            this.b = vVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(FlowCollector<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> flowCollector, Continuation<? super Unit> continuation) {
            return ((f) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new f(this.b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6601a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ((v.a) this.b).a();
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.MediaCacheRepositoryImpl$tryCleanup$newCleanUpJob$1", f = "MediaCacheRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6602a;

        public g(Continuation<? super g> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return j.this.new g(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6602a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            v<File, com.moloco.sdk.internal.m> vVarA = j.this.d.a();
            if (vVarA instanceof v.b) {
                j.this.a((File) ((v.b) vVarA).a());
            } else if (vVarA instanceof v.a) {
                MolocoLogger.error$default(MolocoLogger.INSTANCE, j.l, "Failed to cleanup external cache directory", null, false, 12, null);
            }
            v<File, com.moloco.sdk.internal.m> vVarB = j.this.d.b();
            if (vVarB instanceof v.b) {
                j.this.a((File) ((v.b) vVarB).a());
            } else if (vVarB instanceof v.a) {
                MolocoLogger.error$default(MolocoLogger.INSTANCE, j.l, "Failed to cleanup internal cache directory", null, false, 12, null);
            }
            return Unit.INSTANCE;
        }
    }

    public j(l mediaConfig, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.d legacyMediaDownloader, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.a chunkedMediaDownloader, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f mediaCacheLocationProvider) {
        Intrinsics.checkNotNullParameter(mediaConfig, "mediaConfig");
        Intrinsics.checkNotNullParameter(legacyMediaDownloader, "legacyMediaDownloader");
        Intrinsics.checkNotNullParameter(chunkedMediaDownloader, "chunkedMediaDownloader");
        Intrinsics.checkNotNullParameter(mediaCacheLocationProvider, "mediaCacheLocationProvider");
        this.f6595a = mediaConfig;
        this.b = legacyMediaDownloader;
        this.c = chunkedMediaDownloader;
        this.d = mediaCacheLocationProvider;
        this.e = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getIo());
        this.f = new ConcurrentHashMap<>();
        this.g = new HashSet<>();
        this.h = new ConcurrentHashMap<>();
        this.i = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getIo());
    }

    public final v<File, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.b> c() {
        v<File, com.moloco.sdk.internal.m> vVarD = d();
        if (!(vVarD instanceof v.a)) {
            if (vVarD instanceof v.b) {
                return new v.b(((v.b) vVarD).a());
            }
            throw new NoWhenBranchMatchedException();
        }
        v.a aVar = (v.a) vVarD;
        MolocoLogger.warn$default(MolocoLogger.INSTANCE, l, "Failed to retrieve storageDir with error code: " + ((com.moloco.sdk.internal.m) aVar.a()).b(), null, false, 12, null);
        switch (((com.moloco.sdk.internal.m) aVar.a()).b()) {
            case 100:
                return new v.a(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.b(i.a.AbstractC0600a.c.c));
            case 101:
                return new v.a(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.b(i.a.AbstractC0600a.b.c));
            case 102:
                return new v.a(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.b(i.a.AbstractC0600a.C0601a.c));
            default:
                return new v.a(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.b(i.a.AbstractC0600a.d.c));
        }
    }

    public final v<File, com.moloco.sdk.internal.m> d() {
        v<File, com.moloco.sdk.internal.m> vVarA = this.d.a();
        if (vVarA instanceof v.a) {
            return this.d.b();
        }
        if (vVarA instanceof v.b) {
            return vVarA;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i
    public Flow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> b(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        v<File, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.b> vVarC = c();
        if (vVarC instanceof v.a) {
            return FlowKt.flow(new f(vVarC, null));
        }
        if (vVarC instanceof v.b) {
            File file = (File) ((v.b) vVarC).a();
            MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
            String str = l;
            MolocoLogger.info$default(molocoLogger, str, "Collecting status for media file: " + url, null, false, 12, null);
            File fileA = a(url, file);
            if (fileA.exists() && this.c.b(fileA)) {
                return FlowKt.flow(new e(fileA, null));
            }
            MolocoLogger.info$default(molocoLogger, str, "Media file needs to be downloaded: " + url, null, false, 12, null);
            ConcurrentHashMap<String, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b> concurrentHashMap = this.h;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b bVar = concurrentHashMap.get(url);
            if (bVar == null) {
                MolocoLogger.info$default(molocoLogger, str, "Download has not yet started for: " + url, null, false, 12, null);
                bVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.C0605c(fileA, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.d.a()));
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b bVarPutIfAbsent = concurrentHashMap.putIfAbsent(url, bVar);
                if (bVarPutIfAbsent != null) {
                    bVar = bVarPutIfAbsent;
                }
            }
            return bVar.b();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i
    public Object a(String str, Continuation<? super i.a> continuation) {
        return BuildersKt.withContext(com.moloco.sdk.internal.scheduling.b.a().getIo(), new b(str, this, null), continuation);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i
    public Object a(String str, String str2, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> continuation) {
        return BuildersKt.withContext(com.moloco.sdk.internal.scheduling.b.a().getIo(), new d(str, this, str2, null), continuation);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c a(String url) {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c cVarA;
        Intrinsics.checkNotNullParameter(url, "url");
        v<File, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.b> vVarC = c();
        if (vVarC instanceof v.a) {
            return (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c) ((v.a) vVarC).a();
        }
        if (vVarC instanceof v.b) {
            File fileA = a(url, (File) ((v.b) vVarC).a());
            if (fileA.exists() && this.c.b(fileA)) {
                return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.a(fileA);
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b bVar = this.h.get(url);
            return (bVar == null || (cVarA = bVar.a()) == null) ? new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.C0605c(fileA, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.d.a()) : cVarA;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final File a(String str, File file) {
        return new File(file, c0.b(str));
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i
    public Job a() {
        Job job = this.j;
        if (job != null && job.isActive()) {
            return job;
        }
        Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(this.i, null, null, new g(null), 3, null);
        this.j = jobLaunch$default;
        return jobLaunch$default;
    }

    public final void a(File file) {
        try {
            if (SequencesKt.sumOfLong(SequencesKt.map(FilesKt.walkTopDown(file), c.f6597a)) < this.f6595a.f()) {
                return;
            }
            try {
                FilesKt.deleteRecursively(file);
            } catch (Exception e2) {
                MolocoLogger.error$default(MolocoLogger.INSTANCE, l, e2.toString(), e2, false, 8, null);
            }
        } catch (Exception e3) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, l, e3.toString(), e3, false, 8, null);
        }
    }
}
