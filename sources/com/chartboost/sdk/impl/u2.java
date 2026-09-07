package com.chartboost.sdk.impl;

import android.content.Context;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.callbacks.StartCallback;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b\u001f\u0010 J%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\r\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/chartboost/sdk/impl/u2;", "", "", RemoteConfigConstants.RequestFieldKey.APP_ID, "appSignature", "Lcom/chartboost/sdk/callbacks/StartCallback;", "onStarted", "", "a", "(Ljava/lang/String;Ljava/lang/String;Lcom/chartboost/sdk/callbacks/StartCallback;)V", "()Ljava/lang/String;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()V", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Ljava/util/concurrent/ScheduledExecutorService;", "Ljava/util/concurrent/ScheduledExecutorService;", "backgroundExecutor", "Lcom/chartboost/sdk/impl/p9;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/chartboost/sdk/impl/p9;", "sdkInitializer", "Lcom/chartboost/sdk/impl/o1;", "d", "Lcom/chartboost/sdk/impl/o1;", "tokenGenerator", "Lcom/chartboost/sdk/impl/w1;", "e", "Lcom/chartboost/sdk/impl/w1;", "identity", "<init>", "(Landroid/content/Context;Ljava/util/concurrent/ScheduledExecutorService;Lcom/chartboost/sdk/impl/p9;Lcom/chartboost/sdk/impl/o1;Lcom/chartboost/sdk/impl/w1;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class u2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final ScheduledExecutorService backgroundExecutor;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final p9 sdkInitializer;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final o1 tokenGenerator;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final w1 identity;

    public u2(Context context, ScheduledExecutorService backgroundExecutor, p9 sdkInitializer, o1 tokenGenerator, w1 identity) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(backgroundExecutor, "backgroundExecutor");
        Intrinsics.checkNotNullParameter(sdkInitializer, "sdkInitializer");
        Intrinsics.checkNotNullParameter(tokenGenerator, "tokenGenerator");
        Intrinsics.checkNotNullParameter(identity, "identity");
        this.context = context;
        this.backgroundExecutor = backgroundExecutor;
        this.sdkInitializer = sdkInitializer;
        this.tokenGenerator = tokenGenerator;
        this.identity = identity;
    }

    public final String a() {
        return this.tokenGenerator.a();
    }

    public final void a(final String appId, final String appSignature, final StartCallback onStarted) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appSignature, "appSignature");
        Intrinsics.checkNotNullParameter(onStarted, "onStarted");
        this.backgroundExecutor.execute(new Runnable() { // from class: com.chartboost.sdk.impl.u2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                u2.a(this.f$0, appId, appSignature, onStarted);
            }
        });
    }

    public final void b() {
        try {
            Thread.sleep(100L);
            this.identity.h();
        } catch (Exception e) {
            b7.a("startIdentity error " + e, (Throwable) null, 2, (Object) null);
        }
    }

    public static final void a(u2 this$0, String appId, String appSignature, StartCallback onStarted) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appId, "$appId");
        Intrinsics.checkNotNullParameter(appSignature, "$appSignature");
        Intrinsics.checkNotNullParameter(onStarted, "$onStarted");
        this$0.b();
        ab.b.a(this$0.context);
        this$0.sdkInitializer.a(appId, appSignature, onStarted);
    }
}
