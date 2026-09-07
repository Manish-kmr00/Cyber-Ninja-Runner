package net.pubnative.lite.sdk.vpaid.models.vast;

import net.pubnative.lite.sdk.vpaid.xml.Attribute;
import net.pubnative.lite.sdk.vpaid.xml.Tag;

/* JADX INFO: loaded from: classes5.dex */
public class Linear {

    @Tag
    private AdParameters adParameters;

    @Tag
    private Duration duration;

    @Tag
    private Icons icons;

    @Tag
    private MediaFiles mediaFiles;

    @Attribute
    private String skipoffset;

    @Tag
    private TrackingEvents trackingEvents;

    @Tag
    private VideoClicks videoClicks;

    public String getSkipOffset() {
        return this.skipoffset;
    }

    public Duration getDuration() {
        return this.duration;
    }

    public MediaFiles getMediaFiles() {
        return this.mediaFiles;
    }

    public AdParameters getAdParameters() {
        return this.adParameters;
    }

    public TrackingEvents getTrackingEvents() {
        return this.trackingEvents;
    }

    public VideoClicks getVideoClicks() {
        return this.videoClicks;
    }

    public Icons getIcons() {
        return this.icons;
    }
}
