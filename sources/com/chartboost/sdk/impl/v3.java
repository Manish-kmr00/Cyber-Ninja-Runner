package com.chartboost.sdk.impl;

import android.content.Context;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.database.DefaultDatabaseProvider;
import com.google.android.exoplayer2.offline.DownloadManager;
import com.google.android.exoplayer2.scheduler.PlatformScheduler;
import com.google.android.exoplayer2.scheduler.Scheduler;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheEvictor;
import com.google.android.exoplayer2.upstream.cache.SimpleCache;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.io.File;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a9\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001f\u0010\u0010\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0010\u0010\u0016\u001aK\u0010\u0010\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001aH\u0000¢\u0006\u0004\b\u0010\u0010\u001e\u001a\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0010\u0010\u001f\u001a\u000f\u0010\u0010\u001a\u00020 H\u0000¢\u0006\u0004\b\u0010\u0010!\u001a#\u0010\u0010\u001a\u00020$2\b\b\u0002\u0010\"\u001a\u00020\u001a2\b\b\u0002\u0010#\u001a\u00020\u001aH\u0000¢\u0006\u0004\b\u0010\u0010%\u001a\u0013\u0010\u0010\u001a\u00020'*\u00020&H\u0000¢\u0006\u0004\b\u0010\u0010(\u001a#\u0010\u0010\u001a\u0004\u0018\u00010*2\u0006\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010)\u001a\u00020\u001aH\u0001¢\u0006\u0004\b\u0010\u0010+¨\u0006,"}, d2 = {"Landroid/content/Context;", "Ljava/io/File;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Landroid/content/Context;)Ljava/io/File;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/chartboost/sdk/impl/w4;", "fileCaching", "Lcom/google/android/exoplayer2/database/DatabaseProvider;", "databaseProvider", "Lcom/chartboost/sdk/impl/kb;", "cachePolicy", "Lcom/chartboost/sdk/impl/v2$b;", "evictorCallback", "Lcom/google/android/exoplayer2/upstream/cache/CacheEvictor;", "evictor", "Lcom/google/android/exoplayer2/upstream/cache/Cache;", "a", "(Lcom/chartboost/sdk/impl/w4;Lcom/google/android/exoplayer2/database/DatabaseProvider;Lcom/chartboost/sdk/impl/kb;Lcom/chartboost/sdk/impl/v2$b;Lcom/google/android/exoplayer2/upstream/cache/CacheEvictor;)Lcom/google/android/exoplayer2/upstream/cache/Cache;", Reporting.EventType.CACHE, "Lcom/google/android/exoplayer2/upstream/HttpDataSource$Factory;", "httpDataSourceFactory", "Lcom/google/android/exoplayer2/upstream/cache/CacheDataSource$Factory;", "(Lcom/google/android/exoplayer2/upstream/cache/Cache;Lcom/google/android/exoplayer2/upstream/HttpDataSource$Factory;)Lcom/google/android/exoplayer2/upstream/cache/CacheDataSource$Factory;", "context", "Lcom/google/android/exoplayer2/offline/DownloadManager$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "threadPoolSize", "maxParallelDownloads", "Lcom/google/android/exoplayer2/offline/DownloadManager;", "(Landroid/content/Context;Lcom/google/android/exoplayer2/database/DatabaseProvider;Lcom/google/android/exoplayer2/upstream/cache/Cache;Lcom/google/android/exoplayer2/upstream/HttpDataSource$Factory;Lcom/google/android/exoplayer2/offline/DownloadManager$Listener;II)Lcom/google/android/exoplayer2/offline/DownloadManager;", "(Landroid/content/Context;)Lcom/google/android/exoplayer2/database/DatabaseProvider;", "", "()V", "minBufferMs", "maxBufferMs", "Lcom/google/android/exoplayer2/LoadControl;", "(II)Lcom/google/android/exoplayer2/LoadControl;", "Lcom/google/android/exoplayer2/upstream/DataSource$Factory;", "Lcom/google/android/exoplayer2/source/MediaSource$Factory;", "(Lcom/google/android/exoplayer2/upstream/DataSource$Factory;)Lcom/google/android/exoplayer2/source/MediaSource$Factory;", "jobId", "Lcom/google/android/exoplayer2/scheduler/Scheduler;", "(Landroid/content/Context;I)Lcom/google/android/exoplayer2/scheduler/Scheduler;", "ChartboostMonetization-9.8.3_productionRelease"}, k = 2, mv = {1, 8, 0})
public final class v3 {
    public static final Cache a(w4 fileCaching, DatabaseProvider databaseProvider, kb cachePolicy, v2.b evictorCallback, CacheEvictor evictor) {
        Intrinsics.checkNotNullParameter(fileCaching, "fileCaching");
        Intrinsics.checkNotNullParameter(databaseProvider, "databaseProvider");
        Intrinsics.checkNotNullParameter(cachePolicy, "cachePolicy");
        Intrinsics.checkNotNullParameter(evictorCallback, "evictorCallback");
        Intrinsics.checkNotNullParameter(evictor, "evictor");
        return new SimpleCache(fileCaching.b(), evictor, databaseProvider);
    }

    public static final File b(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        File file = new g5(context.getCacheDir()).h;
        Intrinsics.checkNotNullExpressionValue(file, "FileCacheLocations(cacheDir).precacheDir");
        return file;
    }

    public static final File c(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        File file = new g5(context.getCacheDir()).i;
        Intrinsics.checkNotNullExpressionValue(file, "FileCacheLocations(cacheDir).precacheQueueDir");
        return file;
    }

    public static /* synthetic */ Cache a(w4 w4Var, DatabaseProvider databaseProvider, kb kbVar, v2.b bVar, CacheEvictor cacheEvictor, int i, Object obj) {
        if ((i & 16) != 0) {
            cacheEvictor = new v2(kbVar.getMaxBytes(), bVar, null, 4, null);
        }
        return a(w4Var, databaseProvider, kbVar, bVar, cacheEvictor);
    }

    public static final CacheDataSource.Factory a(Cache cache, HttpDataSource.Factory httpDataSourceFactory) {
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(httpDataSourceFactory, "httpDataSourceFactory");
        CacheDataSource.Factory cacheWriteDataSinkFactory = new CacheDataSource.Factory().setCache(cache).setUpstreamDataSourceFactory(httpDataSourceFactory).setCacheWriteDataSinkFactory(null);
        Intrinsics.checkNotNullExpressionValue(cacheWriteDataSinkFactory, "Factory()\n        .setCa…riteDataSinkFactory(null)");
        return cacheWriteDataSinkFactory;
    }

    public static final DatabaseProvider a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new DefaultDatabaseProvider(new z4(context, null, null, 0, 14, null));
    }

    public static final DownloadManager a(Context context, DatabaseProvider databaseProvider, Cache cache, HttpDataSource.Factory httpDataSourceFactory, DownloadManager.Listener listener, int i, int i2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(databaseProvider, "databaseProvider");
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(httpDataSourceFactory, "httpDataSourceFactory");
        Intrinsics.checkNotNullParameter(listener, "listener");
        DownloadManager downloadManager = new DownloadManager(context, databaseProvider, cache, httpDataSourceFactory, Executors.newFixedThreadPool(i));
        downloadManager.setMaxParallelDownloads(i2);
        downloadManager.addListener(listener);
        return downloadManager;
    }

    public static /* synthetic */ DownloadManager a(Context context, DatabaseProvider databaseProvider, Cache cache, HttpDataSource.Factory factory, DownloadManager.Listener listener, int i, int i2, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            i = 2;
        }
        int i4 = i;
        if ((i3 & 64) != 0) {
            i2 = 1;
        }
        return a(context, databaseProvider, cache, factory, listener, i4, i2);
    }

    public static /* synthetic */ LoadControl a(int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 500;
        }
        if ((i3 & 2) != 0) {
            i2 = 50000;
        }
        return a(i, i2);
    }

    public static final Scheduler a(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Util.SDK_INT >= 21) {
            return new PlatformScheduler(context, i);
        }
        return null;
    }

    public static /* synthetic */ Scheduler a(Context context, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 1;
        }
        return a(context, i);
    }

    public static final MediaSource.Factory a(DataSource.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<this>");
        return new DefaultMediaSourceFactory(factory);
    }

    public static final void a() {
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ORIGINAL_SERVER);
        CookieHandler.setDefault(cookieManager);
    }

    public static final LoadControl a(int i, int i2) {
        DefaultLoadControl defaultLoadControlBuild = new DefaultLoadControl.Builder().setBufferDurationsMs(i, i2, i, i).build();
        Intrinsics.checkNotNullExpressionValue(defaultLoadControlBuild, "Builder()\n        .setBu…fferMs,\n        ).build()");
        return defaultLoadControlBuild;
    }
}
