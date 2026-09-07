package com.smaato.sdk.core.linkhandler;

import android.net.Uri;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SmaDeepLink {
    public static final String SMAATO_DEEPLINK_SCHEME = "smadl";
    public List<String> fallbackTrackerUrls;
    public String fallbackUrl;
    public List<String> primaryTrackerUrls;
    public String primaryUrl;

    public SmaDeepLink(String str) {
        Uri uri = Uri.parse(str);
        if (uri == null || !SMAATO_DEEPLINK_SCHEME.equals(uri.getScheme()) || !"navigate".equals(uri.getHost())) {
            throw new IllegalArgumentException("Smaato Deeplink should start with smadl://navigate?");
        }
        List<String> queryParameters = uri.getQueryParameters("primaryUrl");
        List<String> queryParameters2 = uri.getQueryParameters("fallbackUrl");
        if (queryParameters.size() != 1) {
            throw new IllegalArgumentException("Smaato Deeplink must contain exactly one primaryUrl");
        }
        if (queryParameters2.size() > 1) {
            throw new IllegalArgumentException("Smaato Deeplink can contain at most one fallbackUrl");
        }
        this.primaryUrl = queryParameters.get(0);
        if (queryParameters2.size() > 0) {
            this.fallbackUrl = queryParameters2.get(0);
        }
        this.primaryTrackerUrls = uri.getQueryParameters("primaryTracker");
        this.fallbackTrackerUrls = uri.getQueryParameters("fallbackTracker");
    }
}
