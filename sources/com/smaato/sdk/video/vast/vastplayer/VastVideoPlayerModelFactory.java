package com.smaato.sdk.video.vast.vastplayer;

import com.smaato.sdk.core.linkhandler.LinkHandler;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.video.ad.VideoAdViewFactory;
import com.smaato.sdk.video.vast.model.VastScenario;
import com.smaato.sdk.video.vast.tracking.VastBeaconTrackerCreator;
import com.smaato.sdk.video.vast.tracking.VastErrorTracker;
import com.smaato.sdk.video.vast.tracking.VastEventTrackerCreator;

/* JADX INFO: loaded from: classes13.dex */
class VastVideoPlayerModelFactory {
    private final boolean isInitiallyMuted;
    private final LinkHandler linkHandler;
    private final VastBeaconTrackerCreator vastBeaconTrackerCreator;
    private final VastEventTrackerCreator vastEventTrackerCreator;

    VastVideoPlayerModelFactory(LinkHandler linkHandler, VastEventTrackerCreator vastEventTrackerCreator, VastBeaconTrackerCreator vastBeaconTrackerCreator, boolean z) {
        this.linkHandler = (LinkHandler) Objects.requireNonNull(linkHandler);
        this.vastEventTrackerCreator = (VastEventTrackerCreator) Objects.requireNonNull(vastEventTrackerCreator);
        this.vastBeaconTrackerCreator = (VastBeaconTrackerCreator) Objects.requireNonNull(vastBeaconTrackerCreator);
        this.isInitiallyMuted = z;
    }

    VastVideoPlayerModel createVastVideoPlayerModel(Logger logger, VastScenario vastScenario, VastErrorTracker vastErrorTracker, boolean z, VideoAdViewFactory.VideoPlayerListener videoPlayerListener) {
        ComponentClickHandler componentClickHandler = new ComponentClickHandler(logger, this.linkHandler, vastScenario.vastMediaFileScenario.videoClicks);
        return new VastVideoPlayerModel(vastErrorTracker, this.vastEventTrackerCreator.createEventTracker(vastScenario), this.vastBeaconTrackerCreator.createBeaconTracker(vastScenario), componentClickHandler, this.isInitiallyMuted, z, videoPlayerListener);
    }
}
