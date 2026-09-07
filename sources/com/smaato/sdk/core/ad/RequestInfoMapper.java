package com.smaato.sdk.core.ad;

import com.smaato.sdk.core.AdContentRating;

/* JADX INFO: loaded from: classes4.dex */
public final class RequestInfoMapper {
    public Integer mapToApiValue(GeoType geoType) {
        int i = AnonymousClass1.$SwitchMap$com$smaato$sdk$core$ad$GeoType[geoType.ordinal()];
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 2;
        }
        if (i == 3) {
            return 3;
        }
        throw new IllegalArgumentException(String.format("Unexpected %s: %s", "GeoType", geoType));
    }

    /* JADX INFO: renamed from: com.smaato.sdk.core.ad.RequestInfoMapper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$smaato$sdk$core$AdContentRating;
        static final /* synthetic */ int[] $SwitchMap$com$smaato$sdk$core$ad$GeoType;

        static {
            int[] iArr = new int[AdContentRating.values().length];
            $SwitchMap$com$smaato$sdk$core$AdContentRating = iArr;
            try {
                iArr[AdContentRating.MAX_AD_CONTENT_RATING_G.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$AdContentRating[AdContentRating.MAX_AD_CONTENT_RATING_PG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$AdContentRating[AdContentRating.MAX_AD_CONTENT_RATING_T.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$AdContentRating[AdContentRating.MAX_AD_CONTENT_RATING_MA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[GeoType.values().length];
            $SwitchMap$com$smaato$sdk$core$ad$GeoType = iArr2;
            try {
                iArr2[GeoType.GPS.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$ad$GeoType[GeoType.IP_ADDRESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$ad$GeoType[GeoType.USER_PROVIDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public String mapToApiValue(AdContentRating adContentRating) {
        int i = AnonymousClass1.$SwitchMap$com$smaato$sdk$core$AdContentRating[adContentRating.ordinal()];
        if (i == 1) {
            return "G";
        }
        if (i == 2) {
            return "PG";
        }
        if (i == 3) {
            return "T";
        }
        if (i == 4) {
            return "MA";
        }
        throw new IllegalArgumentException(String.format("Unexpected %s: %s", "AdContentRating", adContentRating));
    }
}
