package com.pubmatic.sdk.video.vastmodels;

import com.pubmatic.sdk.common.utility.POBUtils;
import com.pubmatic.sdk.video.xmlserialiser.POBNodeBuilder;
import com.pubmatic.sdk.video.xmlserialiser.POBXMLNodeListener;
import com.smaato.sdk.video.vast.model.MediaFile;

/* JADX INFO: loaded from: classes7.dex */
public class POBMediaFile implements POBXMLNodeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7858a;
    private String b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    private boolean g = true;
    private String h;
    private String i;

    @Override // com.pubmatic.sdk.video.xmlserialiser.POBXMLNodeListener
    public void build(POBNodeBuilder pOBNodeBuilder) {
        this.f7858a = pOBNodeBuilder.getAttributeValue("delivery");
        this.b = pOBNodeBuilder.getAttributeValue("type");
        this.c = POBUtils.getIntegerValue(pOBNodeBuilder.getAttributeValue("bitrate"));
        this.d = POBUtils.getIntegerValue(pOBNodeBuilder.getAttributeValue("width"));
        this.e = POBUtils.getIntegerValue(pOBNodeBuilder.getAttributeValue("height"));
        this.f = POBUtils.getBooleanValue(pOBNodeBuilder.getAttributeValue("scalable"));
        String attributeValue = pOBNodeBuilder.getAttributeValue("maintainAspectRatio");
        if (attributeValue != null && !attributeValue.isEmpty()) {
            this.g = POBUtils.getBooleanValue(attributeValue);
        }
        this.h = pOBNodeBuilder.getNodeValue();
        this.i = pOBNodeBuilder.getAttributeValue(MediaFile.FILE_SIZE);
    }

    public int getBitrate() {
        return this.c;
    }

    public String getDelivery() {
        return this.f7858a;
    }

    public String getFileSize() {
        return this.i;
    }

    public int getHeight() {
        return this.e;
    }

    public boolean getMaintainAspectRatio() {
        return this.g;
    }

    public String getMediaFileURL() {
        return this.h;
    }

    public boolean getScalable() {
        return this.f;
    }

    public String getType() {
        return this.b;
    }

    public int getWidth() {
        return this.d;
    }

    public String toString() {
        return "Type: " + this.b + ", bitrate: " + this.c + ", w: " + this.d + ", h: " + this.e + ", URL: " + this.h;
    }
}
