package com.amazon.aps.ads.model;

import com.json.b9;
import com.json.mediationsdk.l;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import kotlin.Metadata;

/* JADX INFO: compiled from: ApsAdFormat.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/amazon/aps/ads/model/ApsAdFormat;", "", "(Ljava/lang/String;I)V", b9.v, "", "BANNER", BrandSafetyUtils.o, l.d, "BANNER_SMART", "INTERSTITIAL", "REWARDED_VIDEO", "INSTREAM_VIDEO", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum ApsAdFormat {
    BANNER,
    MREC,
    LEADERBOARD,
    BANNER_SMART,
    INTERSTITIAL,
    REWARDED_VIDEO,
    INSTREAM_VIDEO;

    /* JADX INFO: compiled from: ApsAdFormat.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ApsAdFormat.values().length];
            iArr[ApsAdFormat.BANNER.ordinal()] = 1;
            iArr[ApsAdFormat.BANNER_SMART.ordinal()] = 2;
            iArr[ApsAdFormat.MREC.ordinal()] = 3;
            iArr[ApsAdFormat.LEADERBOARD.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final boolean isBanner() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        return i == 1 || i == 2 || i == 3 || i == 4;
    }
}
