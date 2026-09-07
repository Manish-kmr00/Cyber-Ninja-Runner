package com.chartboost.sdk.impl;

import android.content.Context;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.offline.DownloadManager;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheEvictor;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001Bý\u0001\u0012\b\b\u0002\u0010\u0011\u001a\u00020\f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0012\u0012\u0018\b\u0002\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00190\u0018j\u0002`\u001a\u0012*\b\u0002\u0010'\u001a$\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0\u001fj\u0002`#\u0012\u001e\b\u0002\u0010/\u001a\u0018\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*0(j\u0002`+\u0012\b\b\u0002\u00105\u001a\u000200\u00120\b\u0002\u0010<\u001a*\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020806j\u0002`9\u0012\u0014\b\u0002\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020 0\u0018\u0012\u000e\b\u0002\u0010C\u001a\b\u0012\u0004\u0012\u00020?0>\u0012\u0018\b\u0002\u0010F\u001a\u0012\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020D0\u0018j\u0002`E¢\u0006\u0004\bG\u0010HJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R'\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00190\u0018j\u0002`\u001a8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR9\u0010'\u001a$\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0\u001fj\u0002`#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\u0013\u0010&R-\u0010/\u001a\u0018\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*0(j\u0002`+8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b\r\u0010.R\u0017\u00105\u001a\u0002008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R?\u0010<\u001a*\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020806j\u0002`98\u0006¢\u0006\f\n\u0004\b\u001c\u0010:\u001a\u0004\b,\u0010;R#\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020 0\u00188\u0006¢\u0006\f\n\u0004\b3\u0010\u001b\u001a\u0004\b$\u0010\u001dR\u001d\u0010C\u001a\b\u0012\u0004\u0012\u00020?0>8\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\b@\u0010BR'\u0010F\u001a\u0012\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020D0\u0018j\u0002`E8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u001b\u001a\u0004\b1\u0010\u001d¨\u0006I"}, d2 = {"Lcom/chartboost/sdk/impl/t4;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/content/Context;", "a", "Landroid/content/Context;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Landroid/content/Context;", "context", "Lcom/chartboost/sdk/impl/kb;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/chartboost/sdk/impl/kb;", "j", "()Lcom/chartboost/sdk/impl/kb;", "videoCachePolicy", "Lkotlin/Function1;", "Lcom/chartboost/sdk/impl/w4;", "Lcom/chartboost/sdk/internal/video/repository/exoplayer/FileCachingFactory;", "Lkotlin/jvm/functions/Function1;", "g", "()Lkotlin/jvm/functions/Function1;", "fileCachingFactory", "Lkotlin/Function4;", "Lcom/google/android/exoplayer2/database/DatabaseProvider;", "Lcom/chartboost/sdk/impl/v2$b;", "Lcom/google/android/exoplayer2/upstream/cache/Cache;", "Lcom/chartboost/sdk/internal/video/repository/exoplayer/CacheFactory;", "d", "Lkotlin/jvm/functions/Function4;", "()Lkotlin/jvm/functions/Function4;", "cacheFactory", "Lkotlin/Function2;", "Lcom/google/android/exoplayer2/upstream/HttpDataSource$Factory;", "Lcom/google/android/exoplayer2/upstream/cache/CacheDataSource$Factory;", "Lcom/chartboost/sdk/internal/video/repository/exoplayer/CacheDataSourceFactoryFactory;", "e", "Lkotlin/jvm/functions/Function2;", "()Lkotlin/jvm/functions/Function2;", "cacheDataSourceFactoryFactory", "Lcom/google/android/exoplayer2/upstream/DefaultHttpDataSource$Factory;", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/google/android/exoplayer2/upstream/DefaultHttpDataSource$Factory;", "h", "()Lcom/google/android/exoplayer2/upstream/DefaultHttpDataSource$Factory;", "httpDataSourceFactory", "Lkotlin/Function5;", "Lcom/google/android/exoplayer2/offline/DownloadManager$Listener;", "Lcom/google/android/exoplayer2/offline/DownloadManager;", "Lcom/chartboost/sdk/internal/video/repository/exoplayer/DownloadManagerFactory;", "Lkotlin/jvm/functions/Function5;", "()Lkotlin/jvm/functions/Function5;", "downloadManagerFactory", "databaseProviderFactory", "Lkotlin/Function0;", "", "i", "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", "setCookieHandler", "Lcom/chartboost/sdk/impl/e5;", "Lcom/chartboost/sdk/internal/video/repository/exoplayer/FakePrecacheFilesManagerFactory;", "fakePrecacheFilesManagerFactory", "<init>", "(Landroid/content/Context;Lcom/chartboost/sdk/impl/kb;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function2;Lcom/google/android/exoplayer2/upstream/DefaultHttpDataSource$Factory;Lkotlin/jvm/functions/Function5;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final /* data */ class t4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final kb videoCachePolicy;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final Function1<Context, w4> fileCachingFactory;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Function4<w4, kb, DatabaseProvider, v2.b, Cache> cacheFactory;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final Function2<Cache, HttpDataSource.Factory, CacheDataSource.Factory> cacheDataSourceFactoryFactory;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final DefaultHttpDataSource.Factory httpDataSourceFactory;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final Function5<Context, DatabaseProvider, Cache, HttpDataSource.Factory, DownloadManager.Listener, DownloadManager> downloadManagerFactory;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final Function1<Context, DatabaseProvider> databaseProviderFactory;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final Function0<Unit> setCookieHandler;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final Function1<w4, e5> fakePrecacheFilesManagerFactory;

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

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lcom/chartboost/sdk/impl/w4;", "fc", "Lcom/chartboost/sdk/impl/kb;", "vcp", "Lcom/google/android/exoplayer2/database/DatabaseProvider;", ApsMetricsDataMap.APSMETRICS_FIELD_PLATFORM, "Lcom/chartboost/sdk/impl/v2$b;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/google/android/exoplayer2/upstream/cache/Cache;", "a", "(Lcom/chartboost/sdk/impl/w4;Lcom/chartboost/sdk/impl/kb;Lcom/google/android/exoplayer2/database/DatabaseProvider;Lcom/chartboost/sdk/impl/v2$b;)Lcom/google/android/exoplayer2/upstream/cache/Cache;"}, k = 3, mv = {1, 8, 0})
    public static final class b extends Lambda implements Function4<w4, kb, DatabaseProvider, v2.b, Cache> {
        public static final b b = new b();

        public b() {
            super(4);
        }

        @Override // kotlin.jvm.functions.Function4
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Cache invoke(w4 fc, kb vcp, DatabaseProvider dp, v2.b c) {
            Intrinsics.checkNotNullParameter(fc, "fc");
            Intrinsics.checkNotNullParameter(vcp, "vcp");
            Intrinsics.checkNotNullParameter(dp, "dp");
            Intrinsics.checkNotNullParameter(c, "c");
            return v3.a(fc, dp, vcp, c, (CacheEvictor) null, 16, (Object) null);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class c extends FunctionReferenceImpl implements Function2<Cache, HttpDataSource.Factory, CacheDataSource.Factory> {
        public static final c b = new c();

        public c() {
            super(2, v3.class, "cacheDataSourceFactory", "cacheDataSourceFactory(Lcom/google/android/exoplayer2/upstream/cache/Cache;Lcom/google/android/exoplayer2/upstream/HttpDataSource$Factory;)Lcom/google/android/exoplayer2/upstream/cache/CacheDataSource$Factory;", 1);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CacheDataSource.Factory invoke(Cache p0, HttpDataSource.Factory p1) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            return v3.a(p0, p1);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Landroid/content/Context;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/google/android/exoplayer2/database/DatabaseProvider;", ApsMetricsDataMap.APSMETRICS_FIELD_PLATFORM, "Lcom/google/android/exoplayer2/upstream/cache/Cache;", DownloadCommon.DOWNLOAD_REPORT_CANCEL, "Lcom/google/android/exoplayer2/upstream/HttpDataSource$Factory;", "hf", "Lcom/google/android/exoplayer2/offline/DownloadManager$Listener;", "l", "Lcom/google/android/exoplayer2/offline/DownloadManager;", "a", "(Landroid/content/Context;Lcom/google/android/exoplayer2/database/DatabaseProvider;Lcom/google/android/exoplayer2/upstream/cache/Cache;Lcom/google/android/exoplayer2/upstream/HttpDataSource$Factory;Lcom/google/android/exoplayer2/offline/DownloadManager$Listener;)Lcom/google/android/exoplayer2/offline/DownloadManager;"}, k = 3, mv = {1, 8, 0})
    public static final class d extends Lambda implements Function5<Context, DatabaseProvider, Cache, HttpDataSource.Factory, DownloadManager.Listener, DownloadManager> {
        public static final d b = new d();

        public d() {
            super(5);
        }

        @Override // kotlin.jvm.functions.Function5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final DownloadManager invoke(Context c, DatabaseProvider dp, Cache ca, HttpDataSource.Factory hf, DownloadManager.Listener l) {
            Intrinsics.checkNotNullParameter(c, "c");
            Intrinsics.checkNotNullParameter(dp, "dp");
            Intrinsics.checkNotNullParameter(ca, "ca");
            Intrinsics.checkNotNullParameter(hf, "hf");
            Intrinsics.checkNotNullParameter(l, "l");
            return v3.a(c, dp, ca, hf, l, 0, 0, 96, null);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class e extends FunctionReferenceImpl implements Function1<Context, DatabaseProvider> {
        public static final e b = new e();

        public e() {
            super(1, v3.class, "databaseProvider", "databaseProvider(Landroid/content/Context;)Lcom/google/android/exoplayer2/database/DatabaseProvider;", 1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final DatabaseProvider invoke(Context p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return v3.a(p0);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/chartboost/sdk/impl/w4;", "fc", "Lcom/chartboost/sdk/impl/e5;", "a", "(Lcom/chartboost/sdk/impl/w4;)Lcom/chartboost/sdk/impl/e5;"}, k = 3, mv = {1, 8, 0})
    public static final class g extends Lambda implements Function1<w4, e5> {
        public static final g b = new g();

        public g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e5 invoke(w4 fc) {
            Intrinsics.checkNotNullParameter(fc, "fc");
            return new e5(fc);
        }
    }

    public t4() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof t4)) {
            return false;
        }
        t4 t4Var = (t4) other;
        return Intrinsics.areEqual(this.context, t4Var.context) && Intrinsics.areEqual(this.videoCachePolicy, t4Var.videoCachePolicy) && Intrinsics.areEqual(this.fileCachingFactory, t4Var.fileCachingFactory) && Intrinsics.areEqual(this.cacheFactory, t4Var.cacheFactory) && Intrinsics.areEqual(this.cacheDataSourceFactoryFactory, t4Var.cacheDataSourceFactoryFactory) && Intrinsics.areEqual(this.httpDataSourceFactory, t4Var.httpDataSourceFactory) && Intrinsics.areEqual(this.downloadManagerFactory, t4Var.downloadManagerFactory) && Intrinsics.areEqual(this.databaseProviderFactory, t4Var.databaseProviderFactory) && Intrinsics.areEqual(this.setCookieHandler, t4Var.setCookieHandler) && Intrinsics.areEqual(this.fakePrecacheFilesManagerFactory, t4Var.fakePrecacheFilesManagerFactory);
    }

    public int hashCode() {
        return (((((((((((((((((this.context.hashCode() * 31) + this.videoCachePolicy.hashCode()) * 31) + this.fileCachingFactory.hashCode()) * 31) + this.cacheFactory.hashCode()) * 31) + this.cacheDataSourceFactoryFactory.hashCode()) * 31) + this.httpDataSourceFactory.hashCode()) * 31) + this.downloadManagerFactory.hashCode()) * 31) + this.databaseProviderFactory.hashCode()) * 31) + this.setCookieHandler.hashCode()) * 31) + this.fakePrecacheFilesManagerFactory.hashCode();
    }

    public String toString() {
        return "ExoPlayerDownloadManagerDependencies(context=" + this.context + ", videoCachePolicy=" + this.videoCachePolicy + ", fileCachingFactory=" + this.fileCachingFactory + ", cacheFactory=" + this.cacheFactory + ", cacheDataSourceFactoryFactory=" + this.cacheDataSourceFactoryFactory + ", httpDataSourceFactory=" + this.httpDataSourceFactory + ", downloadManagerFactory=" + this.downloadManagerFactory + ", databaseProviderFactory=" + this.databaseProviderFactory + ", setCookieHandler=" + this.setCookieHandler + ", fakePrecacheFilesManagerFactory=" + this.fakePrecacheFilesManagerFactory + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t4(Context context, kb videoCachePolicy, Function1<? super Context, ? extends w4> fileCachingFactory, Function4<? super w4, ? super kb, ? super DatabaseProvider, ? super v2.b, ? extends Cache> cacheFactory, Function2<? super Cache, ? super HttpDataSource.Factory, CacheDataSource.Factory> cacheDataSourceFactoryFactory, DefaultHttpDataSource.Factory httpDataSourceFactory, Function5<? super Context, ? super DatabaseProvider, ? super Cache, ? super HttpDataSource.Factory, ? super DownloadManager.Listener, DownloadManager> downloadManagerFactory, Function1<? super Context, ? extends DatabaseProvider> databaseProviderFactory, Function0<Unit> setCookieHandler, Function1<? super w4, e5> fakePrecacheFilesManagerFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(videoCachePolicy, "videoCachePolicy");
        Intrinsics.checkNotNullParameter(fileCachingFactory, "fileCachingFactory");
        Intrinsics.checkNotNullParameter(cacheFactory, "cacheFactory");
        Intrinsics.checkNotNullParameter(cacheDataSourceFactoryFactory, "cacheDataSourceFactoryFactory");
        Intrinsics.checkNotNullParameter(httpDataSourceFactory, "httpDataSourceFactory");
        Intrinsics.checkNotNullParameter(downloadManagerFactory, "downloadManagerFactory");
        Intrinsics.checkNotNullParameter(databaseProviderFactory, "databaseProviderFactory");
        Intrinsics.checkNotNullParameter(setCookieHandler, "setCookieHandler");
        Intrinsics.checkNotNullParameter(fakePrecacheFilesManagerFactory, "fakePrecacheFilesManagerFactory");
        this.context = context;
        this.videoCachePolicy = videoCachePolicy;
        this.fileCachingFactory = fileCachingFactory;
        this.cacheFactory = cacheFactory;
        this.cacheDataSourceFactoryFactory = cacheDataSourceFactoryFactory;
        this.httpDataSourceFactory = httpDataSourceFactory;
        this.downloadManagerFactory = downloadManagerFactory;
        this.databaseProviderFactory = databaseProviderFactory;
        this.setCookieHandler = setCookieHandler;
        this.fakePrecacheFilesManagerFactory = fakePrecacheFilesManagerFactory;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final kb getVideoCachePolicy() {
        return this.videoCachePolicy;
    }

    public final Function1<Context, w4> g() {
        return this.fileCachingFactory;
    }

    public final Function4<w4, kb, DatabaseProvider, v2.b, Cache> b() {
        return this.cacheFactory;
    }

    public final Function2<Cache, HttpDataSource.Factory, CacheDataSource.Factory> a() {
        return this.cacheDataSourceFactoryFactory;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final DefaultHttpDataSource.Factory getHttpDataSourceFactory() {
        return this.httpDataSourceFactory;
    }

    public final Function5<Context, DatabaseProvider, Cache, HttpDataSource.Factory, DownloadManager.Listener, DownloadManager> e() {
        return this.downloadManagerFactory;
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class f extends FunctionReferenceImpl implements Function0<Unit> {
        public static final f b = new f();

        public f() {
            super(0, v3.class, "setCookieHandler", "setCookieHandler()V", 1);
        }

        public final void a() {
            v3.a();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public final Function1<Context, DatabaseProvider> d() {
        return this.databaseProviderFactory;
    }

    public final Function0<Unit> i() {
        return this.setCookieHandler;
    }

    public final Function1<w4, e5> f() {
        return this.fakePrecacheFilesManagerFactory;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ t4(Context context, kb kbVar, Function1 function1, Function4 function4, Function2 function2, DefaultHttpDataSource.Factory factory, Function5 function5, Function1 function3, Function0 function0, Function1 function6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Context applicationContext;
        if ((i & 1) != 0) {
            applicationContext = y2.b.a().getContext().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "ChartboostDependencyCont…ontext.applicationContext");
        } else {
            applicationContext = context;
        }
        this(applicationContext, (i & 2) != 0 ? y2.b.d().l() : kbVar, (i & 4) != 0 ? a.b : function1, (i & 8) != 0 ? b.b : function4, (i & 16) != 0 ? c.b : function2, (i & 32) != 0 ? new DefaultHttpDataSource.Factory() : factory, (i & 64) != 0 ? d.b : function5, (i & 128) != 0 ? e.b : function3, (i & 256) != 0 ? f.b : function0, (i & 512) != 0 ? g.b : function6);
    }
}
