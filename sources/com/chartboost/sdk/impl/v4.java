package com.chartboost.sdk.impl;

import android.content.Context;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.source.MediaSource;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0007R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/chartboost/sdk/impl/v4;", "", "Lcom/google/android/exoplayer2/ExoPlayer;", "a", "()Lcom/google/android/exoplayer2/ExoPlayer;", "Lkotlin/Function0;", "Lcom/google/android/exoplayer2/source/MediaSource$Factory;", "Lkotlin/jvm/functions/Function0;", "mediaSourceFactory", "Lcom/google/android/exoplayer2/LoadControl;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "loadControlFactory", "Landroid/content/Context;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Landroid/content/Context;", "context", "Lcom/chartboost/sdk/impl/s4;", "downloadManager", "<init>", "(Landroid/content/Context;Lcom/chartboost/sdk/impl/s4;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class v4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Function0<MediaSource.Factory> mediaSourceFactory;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final Function0<LoadControl> loadControlFactory;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final Context context;

    /* JADX WARN: Multi-variable type inference failed */
    public v4(Context context, s4 downloadManager, Function0<? extends MediaSource.Factory> mediaSourceFactory, Function0<? extends LoadControl> loadControlFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(downloadManager, "downloadManager");
        Intrinsics.checkNotNullParameter(mediaSourceFactory, "mediaSourceFactory");
        Intrinsics.checkNotNullParameter(loadControlFactory, "loadControlFactory");
        this.mediaSourceFactory = mediaSourceFactory;
        this.loadControlFactory = loadControlFactory;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.context = applicationContext;
    }

    public final ExoPlayer a() {
        ExoPlayer exoPlayerBuild = new ExoPlayer.Builder(this.context).setMediaSourceFactory(this.mediaSourceFactory.invoke()).setLoadControl(this.loadControlFactory.invoke()).build();
        Intrinsics.checkNotNullExpressionValue(exoPlayerBuild, "Builder(context)\n       …y())\n            .build()");
        return exoPlayerBuild;
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/google/android/exoplayer2/source/MediaSource$Factory;", "a", "()Lcom/google/android/exoplayer2/source/MediaSource$Factory;"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function0<MediaSource.Factory> {
        public final /* synthetic */ s4 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(s4 s4Var) {
            super(0);
            this.b = s4Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MediaSource.Factory invoke() {
            return v3.a(this.b.c());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/google/android/exoplayer2/LoadControl;", "a", "()Lcom/google/android/exoplayer2/LoadControl;"}, k = 3, mv = {1, 8, 0})
    public static final class b extends Lambda implements Function0<LoadControl> {
        public static final b b = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final LoadControl invoke() {
            return v3.a(0, 0, 3, (Object) null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ v4(Context context, s4 s4Var, Function0 function0, Function0 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        s4Var = (i & 2) != 0 ? y2.b.d().e() : s4Var;
        this(context, s4Var, (i & 4) != 0 ? new a(s4Var) : function0, (i & 8) != 0 ? b.b : function1);
    }
}
