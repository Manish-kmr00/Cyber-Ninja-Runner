package com.smaato.sdk.video.vast.model;

import com.smaato.sdk.video.vast.exceptions.VastElementMissingException;
import com.smaato.sdk.video.vast.utils.VastModels;

/* JADX INFO: loaded from: classes12.dex */
public class AdParameters {
    public static final String NAME = "AdParameters";
    public static final String XML_ENCODED = "xmlEncoded";
    public final String parameters;
    public final Boolean xmlEncoded;

    AdParameters(String str, Boolean bool) {
        this.parameters = str;
        this.xmlEncoded = bool;
    }

    public static class Builder {
        private String parameters;
        private Boolean xmlEncoded;

        public Builder setParameters(String str) {
            this.parameters = str;
            return this;
        }

        public Builder setXmlEncoded(Boolean bool) {
            this.xmlEncoded = bool;
            return this;
        }

        public AdParameters build() throws VastElementMissingException {
            VastModels.requireNonNull(this.parameters, "Cannot build AdParameters: parameters are missing");
            return new AdParameters(this.parameters, this.xmlEncoded);
        }
    }
}
