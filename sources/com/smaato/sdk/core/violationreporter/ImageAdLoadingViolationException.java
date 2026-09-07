package com.smaato.sdk.core.violationreporter;

import com.smaato.sdk.core.util.Objects;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class ImageAdLoadingViolationException extends Exception {
    public final String adQualityViolationType;
    public String adSpaceId;
    public String bundle;
    public final List<String> clickTrackingUrls;
    public final String clickUrl;
    public String client;
    public final String originalUrl;
    public String publisherId;
    public Map<String, List<String>> responseHeaders;
    public final String violatedUrl;

    public ImageAdLoadingViolationException(String str, Map<String, List<String>> map, String str2, String str3, String str4, String str5, String str6, List<String> list, String str7, String str8) {
        this.adQualityViolationType = (String) Objects.requireNonNull(str);
        this.responseHeaders = map;
        this.publisherId = str2;
        this.adSpaceId = str3;
        this.bundle = str4;
        this.client = str5;
        this.clickUrl = str6;
        this.clickTrackingUrls = list;
        this.violatedUrl = (String) Objects.requireNonNull(str7);
        this.originalUrl = (String) Objects.requireNonNull(str8);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "ImageAdLoadingViolationException{adQualityViolationType=" + this.adQualityViolationType + ", publisherId=" + this.publisherId + ", adSpaceId=" + this.adSpaceId + ", bundle=" + this.bundle + ", client=" + this.client + ", clickUrl=" + this.clickUrl + ", violatedUrl='" + this.violatedUrl + "', originalUrl='" + this.originalUrl + "'}";
    }
}
