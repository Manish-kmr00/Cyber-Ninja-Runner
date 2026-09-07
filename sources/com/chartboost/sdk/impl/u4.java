package com.chartboost.sdk.impl;

import android.net.Uri;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.internal.Model.CBError;
import com.chartboost.sdk.internal.video.repository.exoplayer.VideoRepositoryDownloadService;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.offline.Download;
import com.google.android.exoplayer2.offline.DownloadManager;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.offline.DownloadService;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\u0012\b\b\u0002\u0010A\u001a\u00020?¢\u0006\u0004\bR\u0010SJ@\u0010\u000f\u001a\u00020\f2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011*\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b\u000f\u0010\u0013J\u0013\u0010\u0015\u001a\u00020\f*\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\f*\u00020\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0016J'\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00122\u000e\u0010\u001b\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001aH\u0002¢\u0006\u0004\b\u000f\u0010\u001cJ\u001b\u0010\u000f\u001a\u00020\u001d*\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001aH\u0002¢\u0006\u0004\b\u000f\u0010\u001eJ\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u001fJ\u0017\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0017\u0010\u001fJ\u0017\u0010 \u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0012H\u0002¢\u0006\u0004\b \u0010\u001fJ\u001b\u0010\u000f\u001a\u00020\f*\u00020\u00122\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b\u000f\u0010#J\u001d\u0010\u0015\u001a\u00020\f*\u00020\u00142\b\b\u0002\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b\u0015\u0010$J\u0019\u0010\u0015\u001a\u00020\f*\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b\u0015\u0010%J\u0013\u0010&\u001a\u00020\f*\u00020\u0012H\u0002¢\u0006\u0004\b&\u0010\u001fJ\u0013\u0010\u000f\u001a\u00020'*\u00020\u0012H\u0002¢\u0006\u0004\b\u000f\u0010(J\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010*J\u000f\u0010 \u001a\u00020+H\u0016¢\u0006\u0004\b \u0010,J\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010-J\u000f\u0010\u0015\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0015\u0010-J\u0017\u0010\u000f\u001a\u00020'2\u0006\u0010.\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010/J\u001f\u0010\u000f\u001a\u00020\f2\u0006\u00100\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\u000f\u0010$J\u0017\u0010\u000f\u001a\u00020\f2\u0006\u00100\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u000f\u0010\u0016J\u001b\u0010 \u001a\u000601j\u0002`22\u0006\u0010.\u001a\u00020\u0007H\u0016¢\u0006\u0004\b \u00103J\u000f\u0010\u0017\u001a\u000204H\u0016¢\u0006\u0004\b\u0017\u00105J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010.\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u00106J\u0017\u0010\u000f\u001a\u00020\f2\u0006\u00107\u001a\u00020!H\u0016¢\u0006\u0004\b\u000f\u00108J/\u0010<\u001a\u00020\f2\u0006\u00109\u001a\u00020+2\u0006\u0010\u0018\u001a\u00020:2\u000e\u0010;\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001aH\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010\u0017\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010>R\u0014\u0010A\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010@R\u0016\u00109\u001a\u00020+8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0015\u0010BR\u0016\u0010D\u001a\u0002048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010CR\u0016\u0010G\u001a\u00020E8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b \u0010FR\u0016\u0010J\u001a\u00020H8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b&\u0010IR\u001c\u0010M\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR*\u0010Q\u001a\u0016\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\b\u0012\u00060\u0004j\u0002`\u00050N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010P¨\u0006T"}, d2 = {"Lcom/chartboost/sdk/impl/u4;", "Lcom/chartboost/sdk/impl/s4;", "Lcom/google/android/exoplayer2/offline/DownloadManager$Listener;", "Lcom/chartboost/sdk/impl/v2$b;", "", "Lcom/chartboost/sdk/internal/video/repository/exoplayer/ExoPlayerDownloadState;", "state", "", "Lcom/chartboost/sdk/internal/video/repository/exoplayer/Url;", "url", "Lkotlin/Function1;", "Lcom/chartboost/sdk/impl/tb$a;", "", "Lkotlin/ExtensionFunctionType;", "block", "a", "(ILjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "", "Lcom/chartboost/sdk/impl/e4;", "(Ljava/util/List;)Ljava/util/List;", "Lcom/chartboost/sdk/impl/gb;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lcom/chartboost/sdk/impl/gb;)V", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "download", "Ljava/lang/Exception;", "Lkotlin/Exception;", "cause", "(Lcom/chartboost/sdk/impl/e4;Ljava/lang/Exception;)V", "Lcom/chartboost/sdk/internal/Model/CBError;", "(Ljava/lang/Exception;)Lcom/chartboost/sdk/internal/Model/CBError;", "(Lcom/chartboost/sdk/impl/e4;)V", "d", "Lcom/chartboost/sdk/impl/d4;", "stopReason", "(Lcom/chartboost/sdk/impl/e4;Lcom/chartboost/sdk/impl/d4;)V", "(Lcom/chartboost/sdk/impl/gb;Lcom/chartboost/sdk/impl/d4;)V", "(Ljava/util/List;)V", "e", "", "(Lcom/chartboost/sdk/impl/e4;)Z", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "(Lcom/chartboost/sdk/impl/tb$a;)V", "Lcom/google/android/exoplayer2/offline/DownloadManager;", "()Lcom/google/android/exoplayer2/offline/DownloadManager;", "()V", "id", "(Ljava/lang/String;)Z", "asset", "", "Lcom/chartboost/sdk/internal/video/repository/exoplayer/Percentage;", "(Ljava/lang/String;)F", "Lcom/google/android/exoplayer2/upstream/DataSource$Factory;", "()Lcom/google/android/exoplayer2/upstream/DataSource$Factory;", "(Ljava/lang/String;)Lcom/chartboost/sdk/impl/e4;", "currentDownloadStopReason", "(Lcom/chartboost/sdk/impl/d4;)V", "downloadManager", "Lcom/google/android/exoplayer2/offline/Download;", "finalException", "onDownloadChanged", "(Lcom/google/android/exoplayer2/offline/DownloadManager;Lcom/google/android/exoplayer2/offline/Download;Ljava/lang/Exception;)V", "(Ljava/lang/String;)V", "Lcom/chartboost/sdk/impl/t4;", "Lcom/chartboost/sdk/impl/t4;", "dependencies", "Lcom/google/android/exoplayer2/offline/DownloadManager;", "Lcom/google/android/exoplayer2/upstream/DataSource$Factory;", "cacheDataSourceFactory", "Lcom/chartboost/sdk/impl/w4;", "Lcom/chartboost/sdk/impl/w4;", "fileCaching", "Lcom/chartboost/sdk/impl/e5;", "Lcom/chartboost/sdk/impl/e5;", "fakePrecacheFilesManager", InneractiveMediationDefs.GENDER_FEMALE, "Ljava/util/List;", "listeners", "", "g", "Ljava/util/Map;", "latestDownloadStateSent", "<init>", "(Lcom/chartboost/sdk/impl/t4;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class u4 implements s4, DownloadManager.Listener, v2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final t4 dependencies;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public DownloadManager downloadManager;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public DataSource.Factory cacheDataSourceFactory;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public w4 fileCaching;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public e5 fakePrecacheFilesManager;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public volatile List<? extends tb.a> listeners;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public volatile Map<String, Integer> latestDownloadStateSent;

    public u4(t4 dependencies) {
        Intrinsics.checkNotNullParameter(dependencies, "dependencies");
        this.dependencies = dependencies;
        this.listeners = CollectionsKt.emptyList();
        this.latestDownloadStateSent = MapsKt.emptyMap();
    }

    @Override // com.chartboost.sdk.impl.s4
    public void a(gb asset, d4 stopReason) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(stopReason, "stopReason");
        b7.a("addDownload() - asset: " + asset + ", stopReason " + stopReason, (Throwable) null, 2, (Object) null);
        b(asset, stopReason);
    }

    @Override // com.chartboost.sdk.impl.s4
    public float d(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        e4 e4VarB = b(id);
        return (e4VarB != null ? e4VarB.c() : 0.0f) / 100.0f;
    }

    @Override // com.google.android.exoplayer2.offline.DownloadManager.Listener
    public void onDownloadChanged(DownloadManager downloadManager, Download download, Exception finalException) throws IOException {
        Intrinsics.checkNotNullParameter(downloadManager, "downloadManager");
        Intrinsics.checkNotNullParameter(download, "download");
        e5 e5Var = null;
        b7.a("onDownloadChanged() - state " + f4.a(download.state) + ", finalException " + finalException, (Throwable) null, 2, (Object) null);
        int i = download.state;
        if (i == 0 || i == 1) {
            e5 e5Var2 = this.fakePrecacheFilesManager;
            if (e5Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fakePrecacheFilesManager");
            } else {
                e5Var = e5Var2;
            }
            e5Var.c(f4.a(download));
            return;
        }
        if (i == 2) {
            c(f4.a(download));
            return;
        }
        if (i == 3) {
            b(f4.a(download));
        } else if (i == 4) {
            a(f4.a(download), finalException);
        } else {
            if (i != 5) {
                return;
            }
            d(f4.a(download));
        }
    }

    public /* synthetic */ u4(t4 t4Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new t4(null, null, null, null, null, null, null, null, null, null, 1023, null) : t4Var);
    }

    @Override // com.chartboost.sdk.impl.s4
    public void b() {
        a(bb.a(d()));
    }

    @Override // com.chartboost.sdk.impl.s4
    public void a(tb.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners = CollectionsKt.plus((Collection<? extends tb.a>) this.listeners, listener);
    }

    @Override // com.chartboost.sdk.impl.s4
    public DataSource.Factory c() {
        DataSource.Factory factory = this.cacheDataSourceFactory;
        if (factory != null) {
            return factory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cacheDataSourceFactory");
        return null;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/chartboost/sdk/impl/tb$a;", "", "a", "(Lcom/chartboost/sdk/impl/tb$a;)V"}, k = 3, mv = {1, 8, 0})
    public static final class b extends Lambda implements Function1<tb.a, Unit> {
        public final /* synthetic */ e4 b;
        public final /* synthetic */ CBError c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(e4 e4Var, CBError cBError) {
            super(1);
            this.b = e4Var;
            this.c = cBError;
        }

        public final void a(tb.a forEachListener) {
            Intrinsics.checkNotNullParameter(forEachListener, "$this$forEachListener");
            forEachListener.a(this.b.f(), this.b.b(), this.c);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(tb.a aVar) {
            a(aVar);
            return Unit.INSTANCE;
        }
    }

    @Override // com.chartboost.sdk.impl.s4
    public DownloadManager d() {
        if (this.downloadManager == null) {
            DatabaseProvider databaseProviderInvoke = this.dependencies.d().invoke(this.dependencies.getContext());
            this.fileCaching = this.dependencies.g().invoke(this.dependencies.getContext());
            Function4<w4, kb, DatabaseProvider, v2.b, Cache> function4B = this.dependencies.b();
            w4 w4Var = this.fileCaching;
            if (w4Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileCaching");
                w4Var = null;
            }
            Cache cacheInvoke = function4B.invoke(w4Var, this.dependencies.getVideoCachePolicy(), databaseProviderInvoke, this);
            this.cacheDataSourceFactory = this.dependencies.a().invoke(cacheInvoke, this.dependencies.getHttpDataSourceFactory());
            Function1<w4, e5> function1F = this.dependencies.f();
            w4 w4Var2 = this.fileCaching;
            if (w4Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileCaching");
                w4Var2 = null;
            }
            this.fakePrecacheFilesManager = function1F.invoke(w4Var2);
            this.downloadManager = this.dependencies.e().invoke(this.dependencies.getContext(), databaseProviderInvoke, cacheInvoke, this.dependencies.getHttpDataSourceFactory(), this);
        }
        DownloadManager downloadManager = this.downloadManager;
        if (downloadManager != null) {
            return downloadManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("downloadManager");
        return null;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/chartboost/sdk/impl/tb$a;", "", "a", "(Lcom/chartboost/sdk/impl/tb$a;)V"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function1<tb.a, Unit> {
        public final /* synthetic */ e4 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e4 e4Var) {
            super(1);
            this.b = e4Var;
        }

        public final void a(tb.a forEachListener) {
            Intrinsics.checkNotNullParameter(forEachListener, "$this$forEachListener");
            forEachListener.a(this.b.f(), this.b.b());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(tb.a aVar) {
            a(aVar);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/chartboost/sdk/impl/tb$a;", "", "a", "(Lcom/chartboost/sdk/impl/tb$a;)V"}, k = 3, mv = {1, 8, 0})
    public static final class c extends Lambda implements Function1<tb.a, Unit> {
        public final /* synthetic */ e4 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(e4 e4Var) {
            super(1);
            this.b = e4Var;
        }

        public final void a(tb.a forEachListener) {
            Intrinsics.checkNotNullParameter(forEachListener, "$this$forEachListener");
            forEachListener.a(this.b.f(), this.b.b(), 0L, null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(tb.a aVar) {
            a(aVar);
            return Unit.INSTANCE;
        }
    }

    public final void b(gb gbVar) {
        this.latestDownloadStateSent = MapsKt.minus(this.latestDownloadStateSent, gbVar.getUrl());
    }

    @Override // com.chartboost.sdk.impl.s4
    public e4 b(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return bb.a(d(), id);
    }

    public final void e(e4 e4Var) {
        try {
            DownloadService.sendRemoveDownload(this.dependencies.getContext(), VideoRepositoryDownloadService.class, e4Var.b(), false);
            e5 e5Var = this.fakePrecacheFilesManager;
            if (e5Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fakePrecacheFilesManager");
                e5Var = null;
            }
            e5Var.d(e4Var);
        } catch (Exception e) {
            b7.b("Error sending remove download", e);
        }
    }

    public final void c(e4 download) throws IOException {
        e5 e5Var = null;
        b7.a("notifyTempFileIsReady() - download " + download + ", listeners: " + this.listeners, (Throwable) null, 2, (Object) null);
        k9.a("Start downloading " + download.f());
        e5 e5Var2 = this.fakePrecacheFilesManager;
        if (e5Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fakePrecacheFilesManager");
        } else {
            e5Var = e5Var2;
        }
        e5Var.e(download);
        a(2, download.f(), new c(download));
    }

    @Override // com.chartboost.sdk.impl.v2.b
    public void c(String url) {
        Object next;
        Intrinsics.checkNotNullParameter(url, "url");
        Iterator<T> it = bb.a(d()).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((e4) next).f(), url));
        e4 e4Var = (e4) next;
        if (e4Var != null) {
            e(e4Var);
        }
    }

    public final List<e4> a(List<e4> list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (a((e4) obj)) {
                arrayList.add(obj);
            }
        }
        b(arrayList);
        return list;
    }

    public final void d(e4 download) {
        e5 e5Var = null;
        b7.a("downloadRemoved() - download " + download + ", listeners: " + this.listeners, (Throwable) null, 2, (Object) null);
        e5 e5Var2 = this.fakePrecacheFilesManager;
        if (e5Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fakePrecacheFilesManager");
        } else {
            e5Var = e5Var2;
        }
        e5Var.d(download);
        this.latestDownloadStateSent = MapsKt.minus(this.latestDownloadStateSent, download.f());
    }

    public final void b(e4 download) {
        b7.a("notifyDownloadCompleted() - download " + download + ", listeners: " + this.listeners, (Throwable) null, 2, (Object) null);
        k9.a("Video downloaded success " + download.f());
        a(3, download.f(), new a(download));
    }

    public final void a(int state, String url, Function1<? super tb.a, Unit> block) {
        for (tb.a aVar : this.listeners) {
            Integer num = this.latestDownloadStateSent.get(url);
            if (num == null || num.intValue() != state) {
                this.latestDownloadStateSent = MapsKt.plus(this.latestDownloadStateSent, TuplesKt.to(url, Integer.valueOf(state)));
                block.invoke(aVar);
            }
        }
    }

    public final void c(gb gbVar) {
        for (e4 e4Var : bb.a(d())) {
            if (!Intrinsics.areEqual(e4Var.b(), gbVar.getFilename())) {
                a(e4Var, d4.FORCED_OUT);
            }
        }
    }

    public final void b(List<e4> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            e((e4) it.next());
        }
    }

    @Override // com.chartboost.sdk.impl.s4
    public synchronized void a() {
        b7.a("initialize()", (Throwable) null, 2, (Object) null);
        this.dependencies.i().invoke();
        d();
    }

    @Override // com.chartboost.sdk.impl.s4
    public boolean a(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        e4 e4VarB = b(id);
        return e4VarB != null && (e4VarB.d() == 3 || e4VarB.d() == 2);
    }

    public final void b(gb gbVar, d4 d4Var) {
        b7.a("VideoAsset.addDownload() - videoAsset " + gbVar + ", stopReason " + d4Var, (Throwable) null, 2, (Object) null);
        if (StringsKt.isBlank(gbVar.getUrl())) {
            return;
        }
        try {
            DownloadService.sendAddDownload(this.dependencies.getContext(), VideoRepositoryDownloadService.class, new DownloadRequest.Builder(gbVar.getFilename(), Uri.parse(gbVar.getUrl())).build(), d4Var.getValue(), false);
        } catch (Exception e) {
            b7.b("Error sending add download", e);
        }
    }

    public final boolean a(e4 e4Var) {
        return this.dependencies.getVideoCachePolicy().a(e4Var.e());
    }

    public final void a(e4 download, Exception cause) {
        CBError cBErrorA = a(cause);
        k9.a("Video downloaded failed " + download.f() + " with error " + cBErrorA.getErrorDesc());
        a(4, download.f(), new b(download, cBErrorA));
    }

    public static /* synthetic */ void a(u4 u4Var, gb gbVar, d4 d4Var, int i, Object obj) {
        if ((i & 1) != 0) {
            d4Var = d4.NONE;
        }
        u4Var.b(gbVar, d4Var);
    }

    public final void a(e4 e4Var, d4 d4Var) {
        b7.a("Download.sendStopReason() - download " + e4Var + ", stopReason " + d4Var, (Throwable) null, 2, (Object) null);
        try {
            DownloadService.sendSetStopReason(this.dependencies.getContext(), VideoRepositoryDownloadService.class, e4Var.b(), d4Var.getValue(), false);
        } catch (Exception e) {
            b7.b("Error sending stop reason", e);
        }
    }

    @Override // com.chartboost.sdk.impl.s4
    public void a(gb asset) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        b7.a("startDownload() - asset: " + asset, (Throwable) null, 2, (Object) null);
        b(asset);
        c(asset);
        a(this, asset, null, 1, null);
    }

    @Override // com.chartboost.sdk.impl.s4
    public void a(d4 currentDownloadStopReason) {
        e4 e4VarA;
        Intrinsics.checkNotNullParameter(currentDownloadStopReason, "currentDownloadStopReason");
        List<Download> currentDownloads = d().getCurrentDownloads();
        Intrinsics.checkNotNullExpressionValue(currentDownloads, "getDownloadManager().currentDownloads");
        Download download = (Download) CollectionsKt.firstOrNull((List) currentDownloads);
        if (download == null || (e4VarA = f4.a(download)) == null) {
            return;
        }
        a(e4VarA, currentDownloadStopReason);
    }

    public final CBError a(Exception exc) {
        if (exc instanceof IOException) {
            return new CBError(CBError.c.NETWORK_FAILURE, p4.a(exc));
        }
        return new CBError(CBError.c.MISCELLANEOUS, p4.a(exc));
    }
}
