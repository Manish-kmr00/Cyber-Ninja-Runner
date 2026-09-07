package com.smaato.sdk.video.vast.vastplayer;

import android.text.TextUtils;
import com.smaato.sdk.core.linkhandler.LinkHandler;
import com.smaato.sdk.core.linkhandler.LinkHandler$$ExternalSyntheticLambda4;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.video.vast.model.VastBeacon;
import com.smaato.sdk.video.vast.model.VideoClicks;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes10.dex */
class ComponentClickHandler {
    private final LinkHandler linkHandler;
    private final AtomicReference linkHandlingInProgress = new AtomicReference(Boolean.FALSE);
    private final Logger logger;
    private final VideoClicks videoClicks;

    ComponentClickHandler(Logger logger, LinkHandler linkHandler, VideoClicks videoClicks) {
        this.linkHandler = (LinkHandler) Objects.requireNonNull(linkHandler);
        this.logger = (Logger) Objects.requireNonNull(logger);
        this.videoClicks = videoClicks;
    }

    void handleClick(final String str, final Runnable runnable, final Runnable runnable2) {
        if (TextUtils.isEmpty(str)) {
            VideoClicks videoClicks = this.videoClicks;
            VastBeacon vastBeacon = videoClicks == null ? null : videoClicks.clickThrough;
            str = vastBeacon == null ? null : vastBeacon.uri;
        }
        if (!((Boolean) this.linkHandlingInProgress.get()).booleanValue()) {
            this.linkHandlingInProgress.set(Boolean.TRUE);
            this.linkHandler.m5551x29a88085(str, new Runnable() { // from class: com.smaato.sdk.video.vast.vastplayer.ComponentClickHandler$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5728xa632e04(runnable);
                }
            }, new Runnable() { // from class: com.smaato.sdk.video.vast.vastplayer.ComponentClickHandler$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5729x1066f963(runnable2, str);
                }
            });
        } else {
            Objects.onNotNull(runnable2, new LinkHandler$$ExternalSyntheticLambda4());
        }
    }

    /* JADX INFO: renamed from: lambda$handleClick$0$com-smaato-sdk-video-vast-vastplayer-ComponentClickHandler, reason: not valid java name */
    /* synthetic */ void m5728xa632e04(Runnable runnable) {
        this.linkHandlingInProgress.set(Boolean.FALSE);
        runnable.run();
    }

    /* JADX INFO: renamed from: lambda$handleClick$1$com-smaato-sdk-video-vast-vastplayer-ComponentClickHandler, reason: not valid java name */
    /* synthetic */ void m5729x1066f963(Runnable runnable, String str) {
        this.linkHandlingInProgress.set(Boolean.FALSE);
        Objects.onNotNull(runnable, new LinkHandler$$ExternalSyntheticLambda4());
        this.logger.error(LogDomain.VAST, "Seems to be an invalid URL: " + str, new Object[0]);
    }
}
