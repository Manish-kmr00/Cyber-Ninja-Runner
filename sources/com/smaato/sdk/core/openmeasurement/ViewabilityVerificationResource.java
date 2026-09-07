package com.smaato.sdk.core.openmeasurement;

import com.smaato.sdk.core.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public final class ViewabilityVerificationResource {
    private final String apiFramework;
    private String jsScriptUrl;
    private final boolean noBrowser;
    private final String parameters;
    private final String vendor;

    public ViewabilityVerificationResource(String str, String str2, String str3, String str4, boolean z) {
        this.jsScriptUrl = "";
        this.vendor = (String) Objects.requireNonNull(str);
        this.jsScriptUrl = (String) Objects.requireNonNull(str2);
        this.apiFramework = (String) Objects.requireNonNull(str3);
        this.parameters = str4;
        this.noBrowser = z;
    }

    public String getVendor() {
        return this.vendor;
    }

    public String getParameters() {
        return this.parameters;
    }

    public String getJsScriptUrl() {
        return this.jsScriptUrl;
    }

    public String getApiFramework() {
        return this.apiFramework;
    }

    public boolean isNoBrowser() {
        return this.noBrowser;
    }
}
