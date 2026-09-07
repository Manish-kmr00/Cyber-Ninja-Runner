package com.pubmatic.sdk.openwrap.core;

import com.pubmatic.sdk.common.POBAdFormat;
import com.pubmatic.sdk.common.base.POBAdRequest;
import com.pubmatic.sdk.common.utility.POBUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes10.dex */
public class POBRequest implements POBAdRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final POBImpression[] f7733a;
    private final int b;
    private final String c;
    private int d = 5;
    private boolean e;
    private Integer f;
    private boolean g;
    private final POBAdFormat h;
    private Boolean i;
    private String j;

    public enum API {
        VPAID1(1),
        VPAID2(2),
        MRAID1(3),
        ORMMA(4),
        MRAID2(5),
        MRAID3(6),
        OMSDK(7);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f7734a;

        API(int i) {
            this.f7734a = i;
        }

        public int getValue() {
            return this.f7734a;
        }
    }

    public enum AdPosition {
        UNKNOWN(0),
        ABOVE_THE_FOLD(1),
        BELOW_THE_FOLD(3),
        HEADER(4),
        FOOTER(5),
        SIDEBAR(6),
        FULL_SCREEN(7);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f7735a;

        AdPosition(int i) {
            this.f7735a = i;
        }

        public int getValue() {
            return this.f7735a;
        }
    }

    private POBRequest(String str, int i, POBAdFormat pOBAdFormat, POBImpression... pOBImpressionArr) {
        this.c = str;
        this.b = i;
        this.h = pOBAdFormat;
        this.f7733a = pOBImpressionArr;
    }

    public static POBRequest createInstance(String str, int i, POBAdFormat pOBAdFormat, POBImpression... pOBImpressionArr) {
        if (POBUtils.isNullOrEmpty(str) || POBUtils.isNull(pOBImpressionArr) || pOBImpressionArr.length <= 0) {
            return null;
        }
        return new POBRequest(str, i, pOBAdFormat, pOBImpressionArr);
    }

    boolean a() {
        return this.e;
    }

    public void enableDebugState(boolean z) {
        this.g = z;
    }

    public void enableReturnAllBidStatus(boolean z) {
        this.e = z;
    }

    public void enableTestMode(boolean z) {
        this.i = Boolean.valueOf(z);
    }

    public String getAdServerUrl() {
        return this.j;
    }

    public POBImpression[] getImpressions() {
        POBImpression[] pOBImpressionArr = this.f7733a;
        if (pOBImpressionArr == null || pOBImpressionArr.length <= 0) {
            return null;
        }
        return (POBImpression[]) Arrays.copyOf(pOBImpressionArr, pOBImpressionArr.length);
    }

    public int getNetworkTimeout() {
        return this.d;
    }

    public POBAdFormat getPlacementType() {
        return this.h;
    }

    public int getProfileId() {
        return this.b;
    }

    public String getPubId() {
        return this.c;
    }

    public Boolean getTestMode() {
        return this.i;
    }

    @Deprecated
    public Integer getVersionId() {
        return this.f;
    }

    public boolean isDebugStateEnabled() {
        return this.g;
    }

    public void setAdServerUrl(String str) {
        this.j = str;
    }

    public void setNetworkTimeout(int i) {
        if (i > 0) {
            this.d = i;
        }
    }

    @Deprecated
    public void setVersionId(Integer num) {
        this.f = num;
    }

    public String getAdUnitId() {
        POBImpression[] impressions = getImpressions();
        return (impressions == null || impressions.length <= 0) ? "" : impressions[0].getAdUnitId();
    }
}
