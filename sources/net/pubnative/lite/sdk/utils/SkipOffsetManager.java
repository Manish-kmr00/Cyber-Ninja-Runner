package net.pubnative.lite.sdk.utils;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes13.dex */
public class SkipOffsetManager {
    private static final int ENDCARD_CLOSE_DELAY_MAXIMUM = 30;
    private static final int ENDCARD_SKIP_OFFSET = 4;
    public static final int INTERSTITIAL_MRAID = 3;
    private static final int INTERSTITIAL_VIDEO_WITHOUT_END_CARD = 15;
    private static final int INTERSTITIAL_VIDEO_WITH_END_CARD = 10;
    private static final int NATIVE_CLOSE_BUTTON_DELAY = 15;
    private static final int REWARDED_HTML_SKIP_OFFSET = 30;
    private static final int REWARDED_VIDEO_DEFAULT = 30;
    private static final int VIDEO_WITHOUT_ENDCARD_SKIP_OFFSET = 15;
    private static final int VIDEO_WITH_ENDCARD_SKIP_OFFSET = 10;
    private static final int globalMaximumSkipOffset = 30;
    private static Boolean isCustomInterstitialVideoSkipOffset = false;
    private static Boolean isCustomInterstitialHTMLSkipOffset = false;

    public static int getMaximumRewardedSkipOffset() {
        return 30;
    }

    public static Integer getNativeCloseButtonDelay(Integer num) {
        if (num == null || num.intValue() < 0 || num.intValue() > 15) {
            return 15;
        }
        return num;
    }

    public static Integer getHTMLSkipOffset(Integer num, Boolean bool) {
        ArrayList arrayList = new ArrayList();
        int i = bool.booleanValue() ? 3 : 30;
        arrayList.add(num);
        Integer numFindSkipOffset = findSkipOffset(arrayList, i);
        if (bool.booleanValue()) {
            isCustomInterstitialHTMLSkipOffset = Boolean.valueOf(numFindSkipOffset.intValue() != 3);
        }
        return numFindSkipOffset;
    }

    public static Integer getVideoSkipOffset(Integer num, Integer num2, Integer num3, Boolean bool, Boolean bool2) {
        int i;
        if (bool2.booleanValue()) {
            i = bool.booleanValue() ? 10 : 15;
        } else {
            i = 30;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(num3);
        arrayList.add(num);
        arrayList.add(num2);
        Integer numFindSkipOffset = findSkipOffset(arrayList, i);
        if (bool2.booleanValue()) {
            isCustomInterstitialVideoSkipOffset = Boolean.valueOf(numFindSkipOffset.intValue() != i);
        }
        return numFindSkipOffset;
    }

    private static Integer findSkipOffset(ArrayList<Integer> arrayList, int i) {
        int iIntValue;
        Iterator<Integer> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                iIntValue = -1;
                break;
            }
            Integer next = it.next();
            if (next != null) {
                SkipOffset skipOffsetIsValidSkipOffset = isValidSkipOffset(next);
                if (skipOffsetIsValidSkipOffset.isValid().booleanValue()) {
                    iIntValue = skipOffsetIsValidSkipOffset.getSkipOffset().intValue();
                    break;
                }
            }
        }
        if (iIntValue != -1) {
            i = iIntValue;
        }
        if (i > 30) {
            i = 30;
        }
        return Integer.valueOf(i);
    }

    public static Boolean isCustomInterstitialHTMLSkipOffset() {
        return isCustomInterstitialHTMLSkipOffset;
    }

    public static Boolean isCustomInterstitialVideoSkipOffset() {
        return isCustomInterstitialVideoSkipOffset;
    }

    public static SkipOffset isValidSkipOffset(Integer num) {
        boolean z;
        if (num == null || num.intValue() < 0) {
            z = false;
        } else {
            z = true;
            if (num.intValue() > 30) {
                num = 30;
            }
        }
        return new SkipOffset(z, num);
    }

    public static Integer getDefaultNativeCloseButtonDelay() {
        return 15;
    }

    public static Integer getDefaultRewardedHtmlSkipOffset() {
        return 30;
    }

    public static Integer getDefaultHtmlInterstitialSkipOffset() {
        return 3;
    }

    public static Integer getDefaultVideoWithEndCardSkipOffset() {
        return 10;
    }

    public static Integer getDefaultVideoWithoutEndCardSkipOffset() {
        return 15;
    }

    public static Integer getDefaultEndcardSkipOffset() {
        return 4;
    }

    public static Integer getMaximumEndcardCloseDelay() {
        return 30;
    }

    private static class SkipOffset {
        private Boolean isValid;
        private Integer skipOffset;

        public SkipOffset(boolean z, Integer num) {
            this.skipOffset = num;
            this.isValid = Boolean.valueOf(z);
        }

        public Integer getSkipOffset() {
            return this.skipOffset;
        }

        public void setSkipOffset(Integer num) {
            this.skipOffset = num;
        }

        public Boolean isValid() {
            return this.isValid;
        }

        public void setValid(Boolean bool) {
            this.isValid = bool;
        }
    }
}
