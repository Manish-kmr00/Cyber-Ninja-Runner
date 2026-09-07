package net.pubnative.lite.sdk.vpaid.macros;

/* JADX INFO: loaded from: classes13.dex */
public class PublisherMacros {
    protected static final String MACRO_APP_BUNDLE = "[APPBUNDLE]";
    protected static final String MACRO_DOMAIN = "[DOMAIN]";
    protected static final String MACRO_PAGE_URL = "[PAGEURL]";

    public String processUrl(String str) {
        return str;
    }

    private static String getDomain() {
        return String.valueOf(-1);
    }

    private static String getPageUrl() {
        return String.valueOf(-1);
    }

    private static String getAppBundle() {
        return String.valueOf(-1);
    }
}
