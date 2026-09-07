package net.pubnative.lite.sdk;

/* JADX INFO: loaded from: classes11.dex */
public enum CountdownStyle {
    PIE_CHART("net.pubnative.lite.sdk.countdown.pie_chart"),
    TIMER("net.pubnative.lite.sdk.countdown.timer"),
    PROGRESS("net.pubnative.lite.sdk.countdown.progress");

    private final String mId;

    public static CountdownStyle from(String str) {
        CountdownStyle countdownStyle = PIE_CHART;
        if (countdownStyle.getId().equals(str)) {
            return countdownStyle;
        }
        CountdownStyle countdownStyle2 = TIMER;
        if (countdownStyle2.getId().equals(str)) {
            return countdownStyle2;
        }
        CountdownStyle countdownStyle3 = PROGRESS;
        return countdownStyle3.getId().equals(str) ? countdownStyle3 : countdownStyle;
    }

    CountdownStyle(String str) {
        this.mId = str;
    }

    public String getId() {
        return this.mId;
    }
}
