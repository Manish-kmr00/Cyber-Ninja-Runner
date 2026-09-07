package com.smaato.sdk.video.vast.buildlight;

import com.smaato.sdk.video.vast.model.VideoClicks;

/* JADX INFO: loaded from: classes13.dex */
public class VideoClicksMerger {
    public VideoClicks merge(VideoClicks videoClicks, VideoClicks videoClicks2) {
        if (videoClicks == null) {
            return videoClicks2;
        }
        return videoClicks2 == null ? videoClicks : new VideoClicks.Builder().setClickThrough(videoClicks.clickThrough).setClickTrackings(VastScenarioMergeUtils.merge(videoClicks.clickTrackings, videoClicks2.clickTrackings)).setCustomClicks(VastScenarioMergeUtils.merge(videoClicks.customClicks, videoClicks2.customClicks)).build();
    }
}
