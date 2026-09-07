package com.bytedance.sdk.component.adexpress.dynamic.ZZv;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;

/* JADX INFO: loaded from: classes.dex */
public class ML {
    public static final Map<String, Integer> pA;
    private String JG;
    private String KZx;
    private JG ML;
    private String Og;
    private JG ZZv;

    static {
        HashMap map = new HashMap();
        pA = map;
        map.put("root", 8);
        map.put("footer", 6);
        map.put("empty", 6);
        map.put("title", 0);
        map.put("subtitle", 0);
        map.put("source", 0);
        map.put("score-count", 0);
        map.put("text_star", 0);
        map.put("text", 0);
        map.put("tag-group", 17);
        map.put("app-version", 0);
        map.put("development-name", 0);
        map.put("privacy-detail", 23);
        map.put("image", 1);
        map.put("image-wide", 1);
        map.put("image-square", 1);
        map.put("image-long", 1);
        map.put("image-splash", 1);
        map.put("image-cover", 1);
        map.put("app-icon", 1);
        map.put("icon-download", 1);
        map.put("logoad", 4);
        map.put("logounion", 5);
        map.put("logo-union", 9);
        map.put("dislike", 3);
        map.put("close", 3);
        map.put("close-fill", 3);
        map.put("webview-close", 22);
        map.put("feedback-dislike", 12);
        map.put("button", 2);
        map.put("downloadWithIcon", 2);
        map.put("downloadButton", 2);
        map.put("fillButton", 2);
        map.put("laceButton", 2);
        map.put("cardButton", 2);
        map.put("colourMixtureButton", 2);
        map.put("arrowButton", 1);
        map.put("download-progress-button", 2);
        map.put("vessel", 6);
        map.put("image-group", 6);
        map.put("custom-component-vessel", 6);
        map.put("carousel", 24);
        map.put("carousel-vessel", 26);
        map.put("leisure-interact", 25);
        map.put("video-hd", 7);
        map.put("video", 7);
        map.put("video-vd", 7);
        map.put("video-sq", 7);
        map.put("muted", 10);
        map.put("star", 11);
        map.put("skip-countdowns", 19);
        map.put("skip-with-countdowns-skip-btn", 21);
        map.put("skip-with-countdowns-video-countdown", 13);
        map.put("skip-with-countdowns-skip-countdown", 20);
        map.put("skip-with-time", 14);
        map.put("skip-with-time-countdown", 13);
        map.put("skip-with-time-skip-btn", 15);
        map.put(EventConstants.SKIP, 27);
        map.put("timedown", 13);
        map.put("icon", 16);
        map.put("scoreCountWithIcon", 6);
        map.put("split-line", 18);
        map.put("creative-playable-bait", 0);
        map.put("score-count-type-2", 0);
        map.put("lottie", 28);
    }

    public int pA() {
        if (TextUtils.isEmpty(this.Og)) {
            return 0;
        }
        if (this.Og.equals("logo")) {
            String str = this.Og + this.KZx;
            this.Og = str;
            if (str.contains("logoad")) {
                return 4;
            }
            if (this.Og.contains("logounion")) {
                return 5;
            }
        }
        Map<String, Integer> map = pA;
        if (map.get(this.Og) != null) {
            return map.get(this.Og).intValue();
        }
        return -1;
    }

    public String Og() {
        return this.Og;
    }

    public void pA(String str) {
        this.Og = str;
    }

    public String KZx() {
        return this.KZx;
    }

    public void Og(String str) {
        this.KZx = str;
    }

    public void KZx(String str) {
        this.JG = str;
    }

    public String ZZv() {
        return this.JG;
    }

    public JG ML() {
        return this.ZZv;
    }

    public int JG() {
        return this.ZZv.Qj();
    }

    public void pA(JG jg) {
        this.ZZv = jg;
    }

    public void Og(JG jg) {
        this.ML = jg;
    }

    public JG SD() {
        return this.ML;
    }

    public String toString() {
        return "DynamicLayoutBrick{type='" + this.Og + "', data='" + this.KZx + "', value=" + this.ZZv + ", themeValue=" + this.ML + ", dataExtraInfo='" + this.JG + "'}";
    }
}
