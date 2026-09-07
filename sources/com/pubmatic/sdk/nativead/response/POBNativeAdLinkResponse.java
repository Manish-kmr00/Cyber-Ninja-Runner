package com.pubmatic.sdk.nativead.response;

import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class POBNativeAdLinkResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7703a;
    private final List b;
    private final String c;

    public POBNativeAdLinkResponse(String str, List<String> list, String str2) {
        this.f7703a = str;
        this.b = list;
        this.c = str2;
    }

    public List<String> getClickTrackers() {
        return this.b;
    }

    public String getFallbackURL() {
        return this.c;
    }

    public String getUrl() {
        return this.f7703a;
    }

    public String toString() {
        return "Url: " + this.f7703a + "\nClick Trackers: " + getClickTrackers() + "\nFallback Url: " + this.c;
    }
}
