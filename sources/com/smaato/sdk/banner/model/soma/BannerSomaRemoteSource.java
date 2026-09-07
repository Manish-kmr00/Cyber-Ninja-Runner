package com.smaato.sdk.banner.model.soma;

import android.net.Uri;
import com.adjust.sdk.Constants;
import com.smaato.sdk.banner.ad.BannerAdSize;
import com.smaato.sdk.banner.model.BannerAdRequest;
import com.smaato.sdk.core.ad.AdDimension;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.mvvm.model.soma.SomaAdRequest;
import com.smaato.sdk.core.mvvm.model.soma.SomaRemoteSource;
import com.smaato.sdk.core.network.HttpClient;
import com.smaato.sdk.core.network.Request;
import com.smaato.sdk.core.util.HeaderValueUtils;

/* JADX INFO: loaded from: classes8.dex */
public class BannerSomaRemoteSource extends SomaRemoteSource {
    public BannerSomaRemoteSource(HttpClient httpClient, String str, HeaderValueUtils headerValueUtils, Logger logger) {
        super(httpClient, str, headerValueUtils, logger);
    }

    @Override // com.smaato.sdk.core.mvvm.model.soma.SomaRemoteSource
    protected Request buildSomaHttpRequest(SomaAdRequest somaAdRequest) {
        Request requestBuildSomaHttpRequest = super.buildSomaHttpRequest(somaAdRequest);
        Uri.Builder builderBuildUpon = requestBuildSomaHttpRequest.uri().buildUpon();
        if (!(somaAdRequest instanceof BannerAdRequest)) {
            return requestBuildSomaHttpRequest;
        }
        BannerAdSize bannerAdSize = ((BannerAdRequest) somaAdRequest).getBannerAdSize();
        if (bannerAdSize != null) {
            builderBuildUpon.appendQueryParameter("dimension", mapAdDimensionToApiValue(bannerAdSize.adDimension));
        }
        return requestBuildSomaHttpRequest.buildUpon().uri(builderBuildUpon.build()).build();
    }

    /* JADX INFO: renamed from: com.smaato.sdk.banner.model.soma.BannerSomaRemoteSource$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$smaato$sdk$core$ad$AdDimension;

        static {
            int[] iArr = new int[AdDimension.values().length];
            $SwitchMap$com$smaato$sdk$core$ad$AdDimension = iArr;
            try {
                iArr[AdDimension.XX_LARGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$ad$AdDimension[AdDimension.X_LARGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$ad$AdDimension[AdDimension.LARGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$ad$AdDimension[AdDimension.MEDIUM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$ad$AdDimension[AdDimension.SMALL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$ad$AdDimension[AdDimension.MEDIUM_RECTANGLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$ad$AdDimension[AdDimension.SKYSCRAPER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$ad$AdDimension[AdDimension.LEADERBOARD.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$ad$AdDimension[AdDimension.FULLSCREEN_PORTRAIT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$ad$AdDimension[AdDimension.FULLSCREEN_LANDSCAPE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$ad$AdDimension[AdDimension.FULLSCREEN_PORTRAIT_TABLET.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$ad$AdDimension[AdDimension.FULLSCREEN_LANDSCAPE_TABLET.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    protected String mapAdDimensionToApiValue(AdDimension adDimension) {
        switch (AnonymousClass1.$SwitchMap$com$smaato$sdk$core$ad$AdDimension[adDimension.ordinal()]) {
            case 1:
                return "xxlarge";
            case 2:
                return Constants.XLARGE;
            case 3:
                return Constants.LARGE;
            case 4:
                return "medium";
            case 5:
                return Constants.SMALL;
            case 6:
                return "medrect";
            case 7:
                return "sky";
            case 8:
                return "leader";
            case 9:
                return "full_320x480";
            case 10:
                return "full_480x320";
            case 11:
                return "full_768x1024";
            case 12:
                return "full_1024x768";
            default:
                throw new IllegalArgumentException(String.format("Unexpected %s: %s", AdDimension.class.getSimpleName(), adDimension));
        }
    }
}
