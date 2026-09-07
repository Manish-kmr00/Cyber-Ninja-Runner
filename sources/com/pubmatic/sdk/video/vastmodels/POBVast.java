package com.pubmatic.sdk.video.vastmodels;

import com.pubmatic.sdk.video.xmlserialiser.POBNodeBuilder;
import com.pubmatic.sdk.video.xmlserialiser.POBXMLNodeListener;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class POBVast implements POBXMLNodeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f7863a;
    private String b;

    @Override // com.pubmatic.sdk.video.xmlserialiser.POBXMLNodeListener
    public void build(POBNodeBuilder pOBNodeBuilder) {
        this.b = pOBNodeBuilder.getAttributeValue("version");
        this.f7863a = new ArrayList();
        if (pOBNodeBuilder.getNode("/VAST/Ad") == null) {
            POBVastAd pOBVastAd = new POBVastAd();
            pOBVastAd.build(pOBNodeBuilder);
            this.f7863a.add(pOBVastAd);
            return;
        }
        POBVastAd pOBVastAd2 = (POBVastAd) pOBNodeBuilder.getNodeObject("/VAST/Ad[1]/InLine", POBVastAd.class);
        if (pOBVastAd2 != null) {
            this.f7863a.add(pOBVastAd2);
            return;
        }
        POBVastAd pOBVastAd3 = (POBVastAd) pOBNodeBuilder.getNodeObject("/VAST/Ad[1]/Wrapper", POBVastAd.class);
        if (pOBVastAd3 != null) {
            this.f7863a.add(pOBVastAd3);
        }
    }

    public List<POBVastAd> getAds() {
        return this.f7863a;
    }

    public String getVersion() {
        return this.b;
    }
}
