package com.chartboost.sdk.internal.video.repository.exoplayer;

import android.app.Notification;
import com.chartboost.sdk.impl.s4;
import com.chartboost.sdk.impl.v3;
import com.chartboost.sdk.impl.y2;
import com.google.android.exoplayer2.offline.Download;
import com.google.android.exoplayer2.offline.DownloadManager;
import com.google.android.exoplayer2.offline.DownloadService;
import com.google.android.exoplayer2.scheduler.Scheduler;
import com.google.android.exoplayer2.ui.DownloadNotificationHelper;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\t\u0010\nJ%\u0010\u0011\u001a\u00020\u00102\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0017\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/chartboost/sdk/internal/video/repository/exoplayer/VideoRepositoryDownloadService;", "Lcom/google/android/exoplayer2/offline/DownloadService;", "", "onCreate", "()V", "Lcom/google/android/exoplayer2/offline/DownloadManager;", "getDownloadManager", "()Lcom/google/android/exoplayer2/offline/DownloadManager;", "Lcom/google/android/exoplayer2/scheduler/Scheduler;", "getScheduler", "()Lcom/google/android/exoplayer2/scheduler/Scheduler;", "", "Lcom/google/android/exoplayer2/offline/Download;", "downloads", "", "notMetRequirements", "Landroid/app/Notification;", "getForegroundNotification", "(Ljava/util/List;I)Landroid/app/Notification;", "Lcom/chartboost/sdk/impl/s4;", "a", "Lkotlin/Lazy;", "()Lcom/chartboost/sdk/impl/s4;", "exoPlayerDownloadManager", "Lcom/google/android/exoplayer2/ui/DownloadNotificationHelper;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/google/android/exoplayer2/ui/DownloadNotificationHelper;", "downloadNotificationHelper", "<init>", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class VideoRepositoryDownloadService extends DownloadService {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Lazy exoPlayerDownloadManager;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public DownloadNotificationHelper downloadNotificationHelper;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/s4;", "a", "()Lcom/chartboost/sdk/impl/s4;"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function0<s4> {
        public static final a b = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final s4 invoke() {
            return y2.b.d().e();
        }
    }

    public VideoRepositoryDownloadService() {
        super(0);
        this.exoPlayerDownloadManager = LazyKt.lazy(a.b);
    }

    @Override // com.google.android.exoplayer2.offline.DownloadService
    public DownloadManager getDownloadManager() {
        s4 s4VarA = a();
        s4VarA.a();
        return s4VarA.d();
    }

    @Override // com.google.android.exoplayer2.offline.DownloadService
    public Notification getForegroundNotification(List<Download> downloads, int notMetRequirements) {
        Intrinsics.checkNotNullParameter(downloads, "downloads");
        DownloadNotificationHelper downloadNotificationHelper = this.downloadNotificationHelper;
        if (downloadNotificationHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadNotificationHelper");
            downloadNotificationHelper = null;
        }
        Notification notificationBuildProgressNotification = downloadNotificationHelper.buildProgressNotification(this, 0, null, null, CollectionsKt.emptyList(), 0);
        Intrinsics.checkNotNullExpressionValue(notificationBuildProgressNotification, "downloadNotificationHelp…         0,\n            )");
        return notificationBuildProgressNotification;
    }

    @Override // com.google.android.exoplayer2.offline.DownloadService
    public Scheduler getScheduler() {
        return v3.a(this, 0, 2, (Object) null);
    }

    @Override // com.google.android.exoplayer2.offline.DownloadService, android.app.Service
    public void onCreate() {
        y2.b.a(this);
        super.onCreate();
        this.downloadNotificationHelper = new DownloadNotificationHelper(this, "chartboost");
    }

    public final s4 a() {
        return (s4) this.exoPlayerDownloadManager.getValue();
    }
}
