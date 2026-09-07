package com.pubmatic.sdk.video.vastmodels;

import com.pubmatic.sdk.common.utility.POBUtils;
import com.pubmatic.sdk.video.xmlserialiser.POBNodeBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class POBLinear extends POBVastCreative {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f7857a;
    private List b;
    private String c;
    private List d;
    private List e;
    private String f;
    private double g = -1.0d;

    @Override // com.pubmatic.sdk.video.xmlserialiser.POBXMLNodeListener
    public void build(POBNodeBuilder pOBNodeBuilder) {
        this.f = pOBNodeBuilder.getNodeValue("../UniversalAdId");
        String nodeValue = pOBNodeBuilder.getNodeValue("Duration");
        if (nodeValue != null) {
            this.f7857a = POBUtils.getSeconds(nodeValue);
        }
        this.b = pOBNodeBuilder.getObjectList("TrackingEvents/Tracking", POBTracking.class);
        this.mClickThroughURL = pOBNodeBuilder.getNodeValue("VideoClicks/ClickThrough");
        this.mClickTrackers = pOBNodeBuilder.getStringList("VideoClicks/ClickTracking");
        this.c = pOBNodeBuilder.getNodeValue("VideoClicks/CustomClick");
        this.d = pOBNodeBuilder.getObjectList("MediaFiles/MediaFile", POBMediaFile.class);
        this.e = pOBNodeBuilder.getObjectList("Icons/Icon", POBIcon.class);
        String attributeValue = pOBNodeBuilder.getAttributeValue("skipoffset");
        if (attributeValue == null) {
            this.g = -1.0d;
            return;
        }
        double dConvertToSeconds = POBUtils.convertToSeconds(nodeValue, attributeValue);
        this.g = dConvertToSeconds;
        this.g = Math.max(0.0d, dConvertToSeconds);
    }

    public String getCustomClick() {
        return this.c;
    }

    public double getDuration() {
        return this.f7857a;
    }

    public List<POBIcon> getIconList() {
        return this.e;
    }

    public List<POBMediaFile> getMediaFiles() {
        return this.d;
    }

    public double getSkipOffset() {
        return this.g;
    }

    @Override // com.pubmatic.sdk.video.vastmodels.POBVastCreative
    public List<POBTracking> getTrackingEvents() {
        return this.b;
    }

    public String getUniversalAdId() {
        return this.f;
    }

    @Override // com.pubmatic.sdk.video.vastmodels.POBVastCreative
    public POBVastCreative.CreativeType getVastCreativeType() {
        return POBVastCreative.CreativeType.LINEAR;
    }
}
