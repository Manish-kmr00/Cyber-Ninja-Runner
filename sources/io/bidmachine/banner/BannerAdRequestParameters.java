package io.bidmachine.banner;

import com.explorestack.protobuf.adcom.Placement;
import io.bidmachine.AdRequestParameters;
import io.bidmachine.AdsFormat;
import io.bidmachine.utils.ProtoUtils;

/* JADX INFO: loaded from: classes10.dex */
public class BannerAdRequestParameters extends AdRequestParameters {
    private final BannerSize bannerSize;

    public BannerAdRequestParameters(BannerSize bannerSize) {
        super(defineAdsFormat(bannerSize));
        this.bannerSize = bannerSize;
    }

    public BannerSize getBannerSize() {
        return this.bannerSize;
    }

    @Override // io.bidmachine.AdRequestParameters
    public boolean isPlacementObjectValid(Placement placement) throws Throwable {
        return ProtoUtils.isBannerPlacement(placement, this.bannerSize);
    }

    @Override // io.bidmachine.AdRequestParameters
    public boolean isParametersMatched(AdRequestParameters adRequestParameters) {
        return super.isParametersMatched(adRequestParameters) && (adRequestParameters instanceof BannerAdRequestParameters) && isParametersMatchedInternal((BannerAdRequestParameters) adRequestParameters);
    }

    private boolean isParametersMatchedInternal(BannerAdRequestParameters bannerAdRequestParameters) {
        return this.bannerSize == bannerAdRequestParameters.bannerSize;
    }

    /* JADX INFO: renamed from: io.bidmachine.banner.BannerAdRequestParameters$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$bidmachine$banner$BannerSize;

        static {
            int[] iArr = new int[BannerSize.values().length];
            $SwitchMap$io$bidmachine$banner$BannerSize = iArr;
            try {
                iArr[BannerSize.Size_320x50.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$bidmachine$banner$BannerSize[BannerSize.Size_728x90.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$bidmachine$banner$BannerSize[BannerSize.Size_300x250.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static AdsFormat defineAdsFormat(BannerSize bannerSize) {
        int i = AnonymousClass1.$SwitchMap$io$bidmachine$banner$BannerSize[bannerSize.ordinal()];
        if (i == 1) {
            return AdsFormat.Banner_320x50;
        }
        if (i == 2) {
            return AdsFormat.Banner_728x90;
        }
        if (i == 3) {
            return AdsFormat.Banner_300x250;
        }
        return AdsFormat.Banner;
    }
}
