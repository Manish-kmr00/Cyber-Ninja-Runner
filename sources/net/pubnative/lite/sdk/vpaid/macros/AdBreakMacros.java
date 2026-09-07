package net.pubnative.lite.sdk.vpaid.macros;

/* JADX INFO: loaded from: classes12.dex */
public class AdBreakMacros {
    private static final String MACRO_AD_CATEGORIES = "[ADCATEGORIES]";
    private static final String MACRO_AD_COUNT = "[ADCOUNT]";
    private static final String MACRO_AD_TYPE = "[ADTYPE]";
    private static final String MACRO_BLOCKED_AD_CATEGORIES = "[BLOCKEDADCATEGORIES]";
    private static final String MACRO_BREAK_MAX_ADS = "[BREAKMAXADS]";
    private static final String MACRO_BREAK_MAX_AD_LENGTH = "[BREAKMAXADLENGTH]";
    private static final String MACRO_BREAK_MAX_DURATION = "[BREAKMAXDURATION]";
    private static final String MACRO_BREAK_MIN_AD_LENGTH = "[BREAKMINADLENGTH]";
    private static final String MACRO_BREAK_MIN_DURATION = "[BREAKMINDURATION]";
    private static final String MACRO_BREAK_POSITION = "[BREAKPOSITION]";
    private static final String MACRO_CONTENT_PLAY_HEAD = "[CONTENTPLAYHEAD]";
    private static final String MACRO_MEDIA_PLAY_HEAD = "[MEDIAPLAYHEAD]";
    private static final String MACRO_PLACEMENT_TYPE = "[PLACEMENTTYPE]";
    private static final String MACRO_TRANSACTION_ID = "[TRANSACTIONID]";
    private static final String MACRO_UNIVERSAL_AD_ID = "[UNIVERSALADID]";

    public String processUrl(String str) {
        return str;
    }

    private String getContentPlayHead() {
        return String.valueOf(-1);
    }

    private String getMediaPlayHead() {
        return String.valueOf(-1);
    }

    private String getBreakPosition() {
        return String.valueOf(-1);
    }

    private String getBlockedAdCategories() {
        return String.valueOf(-1);
    }

    private String getAdCategories() {
        return String.valueOf(-1);
    }

    private String getAdCount() {
        return String.valueOf(-1);
    }

    private String getTransactionId() {
        return String.valueOf(-1);
    }

    private String getPlacementType() {
        return String.valueOf(-1);
    }

    private String getAdType() {
        return String.valueOf(-1);
    }

    private String getUniversalAdId() {
        return String.valueOf(-1);
    }

    private String getBreakMaxDuration() {
        return String.valueOf(-1);
    }

    private String getBreakMinDuration() {
        return String.valueOf(-1);
    }

    private String getBreakMaxAds() {
        return String.valueOf(-1);
    }

    private String getBreakMinLength() {
        return String.valueOf(-1);
    }

    private String getBreakMaxLength() {
        return String.valueOf(-1);
    }
}
