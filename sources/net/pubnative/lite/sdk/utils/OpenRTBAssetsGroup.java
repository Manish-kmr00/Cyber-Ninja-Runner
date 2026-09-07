package net.pubnative.lite.sdk.utils;

import net.pubnative.lite.sdk.models.Ad;
import net.pubnative.lite.sdk.models.request.Imp;

/* JADX INFO: loaded from: classes14.dex */
public final class OpenRTBAssetsGroup {
    public static Integer get(Imp imp, Integer num, Integer num2, Ad.AdType adType, boolean z) {
        if (adType == Ad.AdType.VIDEO) {
            return getVastGroupId(z);
        }
        return Integer.valueOf(getBannerGroupId(z, imp, num, num2));
    }

    private static int getBannerGroupId(boolean z, Imp imp, Integer num, Integer num2) {
        int i = 10;
        if (imp != null) {
            num = imp.getBanner().getW();
            num2 = imp.getBanner().getH();
        } else if (num == null || num2 == null) {
            return 10;
        }
        if (z) {
            return 21;
        }
        if (num.intValue() == 300 && num2.intValue() == 50) {
            i = 12;
        }
        if (num.intValue() == 300 && num2.intValue() == 250) {
            i = 8;
        }
        int i2 = (num.intValue() == 320 && num2.intValue() == 480) ? 21 : i;
        if (num.intValue() == 1024 && num2.intValue() == 768) {
            i2 = 22;
        }
        if (num.intValue() == 768 && num2.intValue() == 1024) {
            i2 = 23;
        }
        if (num.intValue() == 728 && num2.intValue() == 98) {
            i2 = 24;
        }
        if (num.intValue() == 160 && num2.intValue() == 600) {
            i2 = 25;
        }
        if (num.intValue() == 250 && num2.intValue() == 250) {
            i2 = 26;
        }
        if (num.intValue() == 300 && num2.intValue() == 600) {
            i2 = 27;
        }
        if (num.intValue() == 320 && num2.intValue() == 100) {
            i2 = 28;
        }
        if (num.intValue() == 480 && num2.intValue() == 320) {
            return 29;
        }
        return i2;
    }

    private static Integer getVastGroupId(boolean z) {
        if (z) {
            return 15;
        }
        return 4;
    }
}
