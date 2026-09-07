package com.pubmatic.sdk.video.vastmodels;

import com.pubmatic.sdk.video.xmlserialiser.POBNodeBuilder;
import com.pubmatic.sdk.video.xmlserialiser.POBXMLNodeListener;

/* JADX INFO: loaded from: classes7.dex */
public class POBTracking implements POBXMLNodeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7862a;
    private String b;
    private String c;

    @Override // com.pubmatic.sdk.video.xmlserialiser.POBXMLNodeListener
    public void build(POBNodeBuilder pOBNodeBuilder) {
        this.f7862a = pOBNodeBuilder.getAttributeValue("event");
        this.b = pOBNodeBuilder.getNodeValue();
        this.c = pOBNodeBuilder.getAttributeValue("offset");
    }

    public String getEvent() {
        return this.f7862a;
    }

    public String getOffset() {
        return this.c;
    }

    public String getUrl() {
        return this.b;
    }
}
