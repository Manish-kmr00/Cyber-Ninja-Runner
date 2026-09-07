package com.pubmatic.sdk.video.vastmodels;

import com.pubmatic.sdk.common.utility.POBUtils;
import com.pubmatic.sdk.video.xmlserialiser.POBNodeBuilder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class POBNonLinear extends POBVastCreative {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7859a;
    private int b;
    private int c;
    private int d;
    private String e;
    private boolean f;
    private boolean g = true;
    private List h;
    private String i;
    private List j;
    private List k;
    private String l;

    @Override // com.pubmatic.sdk.video.xmlserialiser.POBXMLNodeListener
    public void build(POBNodeBuilder pOBNodeBuilder) {
        this.f7859a = POBUtils.getIntegerValue(pOBNodeBuilder.getAttributeValue("width"));
        this.b = POBUtils.getIntegerValue(pOBNodeBuilder.getAttributeValue("height"));
        this.c = POBUtils.getIntegerValue(pOBNodeBuilder.getAttributeValue("expandedWidth"));
        this.d = POBUtils.getIntegerValue(pOBNodeBuilder.getAttributeValue("expandedHeight"));
        this.e = pOBNodeBuilder.getAttributeValue("minSuggestedDuration");
        this.f = POBUtils.getBooleanValue(pOBNodeBuilder.getAttributeValue("scalable"));
        String attributeValue = pOBNodeBuilder.getAttributeValue("maintainAspectRatio");
        if (attributeValue != null && !attributeValue.isEmpty()) {
            this.g = POBUtils.getBooleanValue(attributeValue);
        }
        this.h = pOBNodeBuilder.getObjectList("TrackingEvents/Tracking", POBTracking.class);
        this.i = pOBNodeBuilder.getNodeValue("NonLinearClickThrough");
        this.j = pOBNodeBuilder.getStringList("NonLinearClickTracking");
        this.k = new ArrayList();
        POBResource pOBResource = (POBResource) pOBNodeBuilder.getNodeObject("StaticResource", POBResource.class);
        if (pOBResource != null) {
            this.k.add(pOBResource);
        }
        POBResource pOBResource2 = (POBResource) pOBNodeBuilder.getNodeObject("HTMLResource", POBResource.class);
        if (pOBResource2 != null) {
            this.k.add(pOBResource2);
        }
        POBResource pOBResource3 = (POBResource) pOBNodeBuilder.getNodeObject("IFrameResource", POBResource.class);
        if (pOBResource3 != null) {
            this.k.add(pOBResource3);
        }
        this.l = pOBNodeBuilder.getNodeValue("../../UniversalAdId");
    }

    @Override // com.pubmatic.sdk.video.vastmodels.POBVastCreative
    public String getClickThroughURL() {
        return this.i;
    }

    @Override // com.pubmatic.sdk.video.vastmodels.POBVastCreative, com.pubmatic.sdk.common.base.POBAdDescriptor
    public List<String> getClickTrackers() {
        return this.j;
    }

    public int getExpandedHeight() {
        return this.d;
    }

    public int getExpandedWidth() {
        return this.c;
    }

    public int getHeight() {
        return this.b;
    }

    public boolean getMaintainAspectRatio() {
        return this.g;
    }

    public String getMinSuggestedDuration() {
        return this.e;
    }

    public List<POBResource> getResource() {
        return this.k;
    }

    public boolean getScalable() {
        return this.f;
    }

    @Override // com.pubmatic.sdk.video.vastmodels.POBVastCreative
    public List<POBTracking> getTrackingEvents() {
        return this.h;
    }

    public String getUniversalAdId() {
        return this.l;
    }

    @Override // com.pubmatic.sdk.video.vastmodels.POBVastCreative
    public POBVastCreative.CreativeType getVastCreativeType() {
        return POBVastCreative.CreativeType.NONLINEAR;
    }

    public int getWidth() {
        return this.f7859a;
    }
}
