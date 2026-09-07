package com.pubmatic.sdk.video.vastmodels;

import com.pubmatic.sdk.video.xmlserialiser.POBNodeBuilder;
import com.pubmatic.sdk.video.xmlserialiser.POBXMLNodeListener;

/* JADX INFO: loaded from: classes11.dex */
public class POBResource implements POBXMLNodeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f7860a;
    private String b;
    private String c;

    enum a {
        STATIC,
        HTML,
        IFRAME
    }

    @Override // com.pubmatic.sdk.video.xmlserialiser.POBXMLNodeListener
    public void build(POBNodeBuilder pOBNodeBuilder) {
        this.b = pOBNodeBuilder.getAttributeValue("creativeType");
        if (pOBNodeBuilder.getNodeName() != null) {
            String nodeName = pOBNodeBuilder.getNodeName();
            nodeName.hashCode();
            nodeName.hashCode();
            switch (nodeName) {
                case "IFrameResource":
                    this.f7860a = a.IFRAME;
                    break;
                case "StaticResource":
                    this.f7860a = a.STATIC;
                    break;
                case "HTMLResource":
                    this.f7860a = a.HTML;
                    break;
            }
        }
        this.c = pOBNodeBuilder.getNodeValue();
    }

    public String getCreativeType() {
        return this.b;
    }

    public String getResource() {
        return this.c;
    }

    public a getResourceType() {
        return this.f7860a;
    }
}
