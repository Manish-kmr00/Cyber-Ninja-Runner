package com.smaato.sdk.video.vast.model;

import com.smaato.sdk.video.vast.exceptions.VastElementMissingException;
import com.smaato.sdk.video.vast.utils.VastModels;

/* JADX INFO: loaded from: classes12.dex */
public class JavaScriptResource {
    public static final String API_FRAMEWORK = "apiFramework";
    public static final String BROWSER_OPTIONAL = "browserOptional";
    public static final String NAME = "JavaScriptResource";
    public static final String URI = "uri";
    public final String apiFramework;
    public final boolean browserOptional;
    public final String uri;

    public JavaScriptResource(String str, String str2, boolean z) {
        this.uri = str;
        this.apiFramework = str2;
        this.browserOptional = z;
    }

    public static class Builder {
        private String apiFramework;
        private boolean browserOptional;
        private String uri;

        public Builder setUri(String str) {
            this.uri = str;
            return this;
        }

        public Builder setApiFramework(String str) {
            this.apiFramework = str;
            return this;
        }

        public Builder setBrowserOptional(String str) {
            this.browserOptional = Boolean.valueOf(str).booleanValue();
            return this;
        }

        public JavaScriptResource build() throws VastElementMissingException {
            VastModels.requireNonNull(this.uri, "Cannot build JavaScriptResource: uri is missing");
            VastModels.requireNonNull(this.apiFramework, "Cannot build JavaScriptResource: apiFramework is missing");
            return new JavaScriptResource(this.uri, this.apiFramework, this.browserOptional);
        }
    }
}
