package com.smaato.sdk.video.vast.browser;

import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.network.UrlCreator;
import com.smaato.sdk.core.util.Objects;

/* JADX INFO: loaded from: classes10.dex */
public class VastWebComponentSecurityPolicy {
    private final Boolean isHttpsOnly;
    private final Logger logger;
    private final UrlCreator urlCreator;

    public VastWebComponentSecurityPolicy(Logger logger, String str, UrlCreator urlCreator, Boolean bool) {
        this.logger = (Logger) Objects.requireNonNull(logger);
        this.urlCreator = (UrlCreator) Objects.requireNonNull(urlCreator);
        this.isHttpsOnly = bool;
    }

    public boolean validateUrl(String str) {
        boolean z = true;
        if (!this.urlCreator.isSupportedForNetworking(str)) {
            return true;
        }
        String strExtractScheme = this.urlCreator.extractScheme(str);
        if (!this.urlCreator.isSecureScheme(strExtractScheme) && (!this.urlCreator.isInsecureScheme(strExtractScheme) || this.isHttpsOnly.booleanValue())) {
            z = false;
        }
        if (!z) {
            this.logger.error(LogDomain.VAST, "Invalid url or violation of httpsOnly rule: Url: %s , isHttpsOnly: %s", str, this.isHttpsOnly);
        }
        return z;
    }
}
