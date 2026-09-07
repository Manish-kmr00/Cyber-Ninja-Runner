package com.pubmatic.sdk.video.vastmodels;

import com.pubmatic.sdk.common.viewability.POBVerificationScriptResource;
import com.pubmatic.sdk.video.xmlserialiser.POBNodeBuilder;
import com.pubmatic.sdk.video.xmlserialiser.POBXMLNodeListener;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class POBAdVerification implements POBXMLNodeListener, POBVerificationScriptResource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f7854a;
    private List b;
    private List c;
    private String d;
    private String e;

    @Override // com.pubmatic.sdk.video.xmlserialiser.POBXMLNodeListener
    public void build(POBNodeBuilder pOBNodeBuilder) {
        this.d = pOBNodeBuilder.getAttributeValue("vendor");
        this.f7854a = pOBNodeBuilder.getStringList("JavaScriptResource");
        this.c = pOBNodeBuilder.getObjectList("TrackingEvents/Tracking", POBTracking.class);
        this.b = pOBNodeBuilder.getStringList("ExecutableResource");
        this.e = pOBNodeBuilder.getNodeValue("VerificationParameters");
    }

    public List<String> getExecutableResource() {
        return this.b;
    }

    @Override // com.pubmatic.sdk.common.viewability.POBVerificationScriptResource
    public List<String> getJavaScriptResource() {
        return this.f7854a;
    }

    public List<POBTracking> getTrackingEvents() {
        return this.c;
    }

    @Override // com.pubmatic.sdk.common.viewability.POBVerificationScriptResource
    public String getVendorKey() {
        return this.d;
    }

    @Override // com.pubmatic.sdk.common.viewability.POBVerificationScriptResource
    public String getVerificationParameter() {
        return this.e;
    }
}
