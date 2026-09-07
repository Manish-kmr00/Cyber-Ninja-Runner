package com.chartboost.sdk.impl;

import android.content.Context;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.internal.Model.CBError;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.ktor.http.ContentDisposition;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B;\u0012\u0006\u00104\u001a\u000202\u0012\u0006\u00107\u001a\u000205\u0012\u0018\b\u0002\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020908j\u0002`:\u0012\b\b\u0002\u0010?\u001a\u00020=¢\u0006\u0004\bM\u0010NJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J1\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0006\u0010\u000fJ)\u0010\u0006\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0006\u0010\u0013J\u0017\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0006\u0010\u0015J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0006\u001a\u00060\u0010j\u0002`\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0006\u0010\u001bJ1\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0006\u0010 J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0006\u0010\"J)\u0010\u0006\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b\u0006\u0010%J\u0019\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b'\u0010(J\u0013\u0010\u0017\u001a\u00020\u0016*\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010)J\u0013\u0010'\u001a\u00020\u0016*\u00020\u0016H\u0002¢\u0006\u0004\b'\u0010)J\u001b\u0010\u0006\u001a\u00020\u0016*\u00020&2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0006\u0010*J\u000f\u0010'\u001a\u00020\u0005H\u0002¢\u0006\u0004\b'\u0010+J\u0017\u0010,\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0016H\u0002¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0016H\u0002¢\u0006\u0004\b.\u0010-J\u000f\u0010,\u001a\u00020\u0005H\u0002¢\u0006\u0004\b,\u0010+J!\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00162\b\b\u0002\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b\u0006\u00101R\u0014\u00104\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u00103R\u0014\u00107\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u00106R$\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020908j\u0002`:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010;R\u0014\u0010?\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010>R'\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010A\u001a\u0004\b\u0006\u0010BR'\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010A\u001a\u0004\b\u0017\u0010BR\u0018\u0010H\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010K¨\u0006O"}, d2 = {"Lcom/chartboost/sdk/impl/rb;", "Lcom/chartboost/sdk/impl/qb;", "Lcom/chartboost/sdk/impl/tb$a;", "Landroid/content/Context;", "context", "", "a", "(Landroid/content/Context;)V", "", "url", ContentDisposition.Parameters.FileName, "", "showImmediately", "Lcom/chartboost/sdk/impl/l0;", "callback", "(Ljava/lang/String;Ljava/lang/String;ZLcom/chartboost/sdk/impl/l0;)V", "", "repeat", "forceDownload", "(Ljava/lang/String;IZ)V", "videoFilename", "(Ljava/lang/String;)Z", "Lcom/chartboost/sdk/impl/gb;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Ljava/lang/String;)Lcom/chartboost/sdk/impl/gb;", "asset", "Lcom/chartboost/sdk/internal/video/repository/DownloadState;", "(Lcom/chartboost/sdk/impl/gb;)I", "videoFileName", "", "expectedContentSize", "adUnitVideoPrecacheTempCallback", "(Ljava/lang/String;Ljava/lang/String;JLcom/chartboost/sdk/impl/l0;)V", "uri", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/chartboost/sdk/internal/Model/CBError;", "error", "(Ljava/lang/String;Ljava/lang/String;Lcom/chartboost/sdk/internal/Model/CBError;)V", "Ljava/io/File;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "(Ljava/lang/String;)Ljava/io/File;", "(Lcom/chartboost/sdk/impl/gb;)Lcom/chartboost/sdk/impl/gb;", "(Ljava/io/File;Ljava/lang/String;)Lcom/chartboost/sdk/impl/gb;", "()V", "d", "(Lcom/chartboost/sdk/impl/gb;)V", "e", "Lcom/chartboost/sdk/impl/d4;", "reason", "(Lcom/chartboost/sdk/impl/gb;Lcom/chartboost/sdk/impl/d4;)V", "Lcom/chartboost/sdk/impl/kb;", "Lcom/chartboost/sdk/impl/kb;", "policy", "Lcom/chartboost/sdk/impl/s4;", "Lcom/chartboost/sdk/impl/s4;", "downloadManager", "Lkotlin/Function1;", "Lcom/chartboost/sdk/impl/w4;", "Lcom/chartboost/sdk/internal/video/repository/exoplayer/FileCachingFactory;", "Lkotlin/jvm/functions/Function1;", "fileCachingFactory", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/Lazy;", "()Ljava/util/concurrent/ConcurrentHashMap;", "filenameToAsset", InneractiveMediationDefs.GENDER_FEMALE, "urlToCallback", "g", "Lcom/chartboost/sdk/impl/w4;", "fileCaching", "Lkotlinx/coroutines/Job;", "h", "Lkotlinx/coroutines/Job;", "retryJob", "<init>", "(Lcom/chartboost/sdk/impl/kb;Lcom/chartboost/sdk/impl/s4;Lkotlin/jvm/functions/Function1;Lkotlinx/coroutines/CoroutineDispatcher;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class rb implements qb, tb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final kb policy;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final s4 downloadManager;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final Function1<Context, w4> fileCachingFactory;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final CoroutineDispatcher dispatcher;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final Lazy filenameToAsset;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final Lazy urlToCallback;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public w4 fileCaching;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public Job retryJob;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/content/Context;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/chartboost/sdk/impl/x4;", "a", "(Landroid/content/Context;)Lcom/chartboost/sdk/impl/x4;"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function1<Context, x4> {
        public static final a b = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final x4 invoke(Context c) {
            Intrinsics.checkNotNullParameter(c, "c");
            return new x4(c, null, null, null, 14, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/chartboost/sdk/impl/gb;", "a", "()Ljava/util/concurrent/ConcurrentHashMap;"}, k = 3, mv = {1, 8, 0})
    public static final class b extends Lambda implements Function0<ConcurrentHashMap<String, gb>> {
        public static final b b = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ConcurrentHashMap<String, gb> invoke() {
            return new ConcurrentHashMap<>();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.chartboost.sdk.internal.video.repository.exoplayer.VideoRepositoryExoplayer$retryNonForcedDownloadAfterTimeWindowEnds$1", f = "VideoRepositoryExoplayer.kt", i = {}, l = {163}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int b;

        public c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return rb.this.new c(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                long jI = rb.this.policy.i();
                this.b = 1;
                if (DelayKt.delay(jI, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            rb.this.retryJob = null;
            try {
                qb.a.a(rb.this, null, 0, false, 7, null);
            } catch (IllegalStateException e) {
                b7.b("Cannot start download", e);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/chartboost/sdk/impl/l0;", "a", "()Ljava/util/concurrent/ConcurrentHashMap;"}, k = 3, mv = {1, 8, 0})
    public static final class d extends Lambda implements Function0<ConcurrentHashMap<String, l0>> {
        public static final d b = new d();

        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ConcurrentHashMap<String, l0> invoke() {
            return new ConcurrentHashMap<>();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public rb(kb policy, s4 downloadManager, Function1<? super Context, ? extends w4> fileCachingFactory, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(policy, "policy");
        Intrinsics.checkNotNullParameter(downloadManager, "downloadManager");
        Intrinsics.checkNotNullParameter(fileCachingFactory, "fileCachingFactory");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.policy = policy;
        this.downloadManager = downloadManager;
        this.fileCachingFactory = fileCachingFactory;
        this.dispatcher = dispatcher;
        this.filenameToAsset = LazyKt.lazy(b.b);
        this.urlToCallback = LazyKt.lazy(d.b);
    }

    public final ConcurrentHashMap<String, l0> b() {
        return (ConcurrentHashMap) this.urlToCallback.getValue();
    }

    @Override // com.chartboost.sdk.impl.qb
    public gb b(String filename) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        return a().get(filename);
    }

    @Override // com.chartboost.sdk.impl.qb
    public void a(String url, String filename, boolean showImmediately, l0 callback) {
        gb gbVarA;
        gb gbVarB;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(filename, "filename");
        b7.a("downloadVideoFile() - url: " + url + ", filename: " + filename + ", showImmediately: " + showImmediately + ", callback: " + callback, (Throwable) null, 2, (Object) null);
        if (callback != null) {
            b().put(url, callback);
        }
        File fileC = c(filename);
        if (fileC == null || (gbVarA = a(fileC, url)) == null || (gbVarB = b(gbVarA)) == null || c(gbVarB) == null) {
            b7.a("downloadVideoFile() - cache file is null", (Throwable) null, 2, (Object) null);
        }
        qb.a.a(this, filename, 0, showImmediately, 2, null);
    }

    public /* synthetic */ rb(kb kbVar, s4 s4Var, Function1 function1, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kbVar, s4Var, (i & 4) != 0 ? a.b : function1, (i & 8) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    public final File c(String filename) {
        w4 w4Var = this.fileCaching;
        if (w4Var != null) {
            return w4Var.a(filename);
        }
        return null;
    }

    public final void d() {
        if (this.retryJob == null) {
            this.retryJob = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.dispatcher), null, null, new c(null), 3, null);
        }
    }

    public final ConcurrentHashMap<String, gb> a() {
        return (ConcurrentHashMap) this.filenameToAsset.getValue();
    }

    public final void e(gb asset) {
        d4 d4Var;
        if (this.policy.g()) {
            d();
            d4Var = d4.MAX_COUNT_TIME_WINDOW;
        } else {
            d4Var = d4.NONE;
        }
        a(asset, d4Var);
    }

    public final void d(gb asset) {
        b7.a("startForcedDownload() - " + asset, (Throwable) null, 2, (Object) null);
        this.policy.a();
        this.downloadManager.a(asset);
    }

    public final void c() {
        d4 d4Var;
        if (this.policy.g()) {
            d();
            d4Var = d4.MAX_COUNT_TIME_WINDOW;
        } else {
            d4Var = d4.NONE;
        }
        if (d4Var == d4.NONE) {
            this.policy.a();
        }
        this.downloadManager.a(d4Var);
    }

    public final gb b(gb gbVar) {
        a().put(gbVar.getFilename(), gbVar);
        return gbVar;
    }

    @Override // com.chartboost.sdk.impl.qb
    public int a(gb asset) {
        if (asset != null) {
            return c9.a(this.downloadManager.d(asset.getFilename()));
        }
        return 0;
    }

    @Override // com.chartboost.sdk.impl.qb
    public void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        b7.a("initialize()", (Throwable) null, 2, (Object) null);
        this.fileCaching = this.fileCachingFactory.invoke(context);
        s4 s4Var = this.downloadManager;
        s4Var.a();
        s4Var.a(this);
        s4Var.b();
    }

    public final gb c(gb gbVar) {
        b7.a("queueDownload() - asset: " + gbVar, (Throwable) null, 2, (Object) null);
        a(gbVar, d4.STOPPED_QUEUE);
        return gbVar;
    }

    @Override // com.chartboost.sdk.impl.qb
    public boolean a(String videoFilename) {
        Intrinsics.checkNotNullParameter(videoFilename, "videoFilename");
        return this.downloadManager.a(videoFilename);
    }

    @Override // com.chartboost.sdk.impl.tb.a
    public void a(String uri, String videoFileName, CBError error) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(videoFileName, "videoFileName");
        b7.a("onError() - uri " + uri + ", videoFileName " + videoFileName + ", error " + error, (Throwable) null, 2, (Object) null);
        b().remove(uri);
    }

    @Override // com.chartboost.sdk.impl.tb.a
    public void a(String uri, String videoFileName) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(videoFileName, "videoFileName");
        b7.a("onSuccess() - uri " + uri + ", videoFileName " + videoFileName, (Throwable) null, 2, (Object) null);
        b().remove(uri);
        qb.a.a(this, null, 0, false, 7, null);
    }

    public final void a(gb asset, d4 reason) {
        b7.a("sendDownloadToDownloadManager() - " + asset, (Throwable) null, 2, (Object) null);
        if (reason == d4.NONE) {
            this.policy.a();
        }
        this.downloadManager.a(asset, reason);
    }

    @Override // com.chartboost.sdk.impl.qb
    public void a(String filename, int repeat, boolean forceDownload) {
        Unit unit;
        gb gbVar;
        b7.a("startDownloadIfPossible() - filename " + filename + ", forceDownload " + forceDownload, (Throwable) null, 2, (Object) null);
        if (filename == null || (gbVar = a().get(filename)) == null) {
            unit = null;
        } else {
            b7.a("startDownloadIfPossible() - asset: " + gbVar, (Throwable) null, 2, (Object) null);
            if (forceDownload) {
                d(gbVar);
            } else {
                e(gbVar);
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            b7.a("startDownloadIfPossible() - null asset, resume next download in Download Manager index", (Throwable) null, 2, (Object) null);
            c();
        }
    }

    @Override // com.chartboost.sdk.impl.tb.a
    public void a(String url, String videoFileName, long expectedContentSize, l0 adUnitVideoPrecacheTempCallback) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(videoFileName, "videoFileName");
        b7.a("tempFileIsReady() - url " + url + ", videoFileName " + videoFileName, (Throwable) null, 2, (Object) null);
        if (adUnitVideoPrecacheTempCallback == null) {
            adUnitVideoPrecacheTempCallback = b().get(url);
        }
        if (adUnitVideoPrecacheTempCallback != null) {
            adUnitVideoPrecacheTempCallback.a(url);
        }
    }

    public final gb a(File file, String str) {
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        gb gbVar = new gb(str, name, file, file.getParentFile(), 0L, null, 0L, 112, null);
        file.setLastModified(gbVar.getCreationDate());
        return gbVar;
    }
}
