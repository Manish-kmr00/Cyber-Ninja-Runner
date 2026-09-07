package com.json;

import com.json.mediationsdk.logger.IronSourceError;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.ironsourceads.rewarded.RewardedAd;
import com.unity3d.ironsourceads.rewarded.RewardedAdLoaderListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/ironsource/qq;", "Lcom/ironsource/t0;", "Lcom/unity3d/ironsourceads/rewarded/RewardedAd;", "adObject", "", "a", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "error", nu.b, "Lcom/ironsource/uu;", "Lcom/ironsource/uu;", "threadManager", "Lcom/unity3d/ironsourceads/rewarded/RewardedAdLoaderListener;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/unity3d/ironsourceads/rewarded/RewardedAdLoaderListener;", "publisherListener", "<init>", "(Lcom/ironsource/uu;Lcom/unity3d/ironsourceads/rewarded/RewardedAdLoaderListener;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class qq implements t0<RewardedAd> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final uu threadManager;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final RewardedAdLoaderListener publisherListener;

    public qq(uu threadManager, RewardedAdLoaderListener publisherListener) {
        Intrinsics.checkNotNullParameter(threadManager, "threadManager");
        Intrinsics.checkNotNullParameter(publisherListener, "publisherListener");
        this.threadManager = threadManager;
        this.publisherListener = publisherListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(qq this$0, IronSourceError error) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(error, "$error");
        this$0.publisherListener.onRewardedAdLoadFailed(error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(qq this$0, RewardedAd adObject) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adObject, "$adObject");
        this$0.publisherListener.onRewardedAdLoaded(adObject);
    }

    @Override // com.json.t0
    public void a(final RewardedAd adObject) {
        Intrinsics.checkNotNullParameter(adObject, "adObject");
        this.threadManager.a(new Runnable() { // from class: com.ironsource.qq$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                qq.a(this.f$0, adObject);
            }
        });
    }

    @Override // com.json.t0
    public void onAdLoadFailed(final IronSourceError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.threadManager.a(new Runnable() { // from class: com.ironsource.qq$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                qq.a(this.f$0, error);
            }
        });
    }
}
