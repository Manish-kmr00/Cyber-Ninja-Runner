package net.pubnative.lite.sdk.analytics.tracker;

/* JADX INFO: loaded from: classes7.dex */
public class ReportingTracker {
    private String js;
    private int responseCode;
    private final String type;
    private String url;

    public ReportingTracker(String str, String str2, int i) {
        this.js = "";
        this.type = str;
        this.url = str2;
        this.responseCode = i;
    }

    public ReportingTracker(String str, String str2) {
        this.url = "";
        this.responseCode = 0;
        this.type = str;
        this.js = str2;
    }

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String getJs() {
        return this.js;
    }

    public int getResponseCode() {
        return this.responseCode;
    }
}
