package net.pubnative.lite.sdk.vpaid.models.vast;

import java.util.List;
import net.pubnative.lite.sdk.vpaid.xml.Attribute;
import net.pubnative.lite.sdk.vpaid.xml.Tag;

/* JADX INFO: loaded from: classes9.dex */
public class Verification {

    @Tag("ExecutableResource")
    private List<ExecutableResource> executableResources;

    @Tag("JavaScriptResource")
    private List<JavaScriptResource> javaScriptResources;

    @Tag
    private TrackingEvents trackingEvents;

    @Attribute
    private String vendor;

    @Tag
    private VerificationParameters verificationParameters;

    public String getVendor() {
        return this.vendor;
    }

    public List<JavaScriptResource> getJavaScriptResources() {
        return this.javaScriptResources;
    }

    public List<ExecutableResource> getExecutableResources() {
        return this.executableResources;
    }

    public TrackingEvents getTrackingEvents() {
        return this.trackingEvents;
    }

    public VerificationParameters getVerificationParameters() {
        return this.verificationParameters;
    }
}
