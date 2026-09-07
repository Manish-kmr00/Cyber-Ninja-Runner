package io.bidmachine.interstitial;

import com.explorestack.protobuf.adcom.Placement;
import io.bidmachine.AdContentType;
import io.bidmachine.AdsFormat;
import io.bidmachine.FullScreenAdRequestParameters;
import io.bidmachine.utils.ProtoUtils;

/* JADX INFO: loaded from: classes11.dex */
public class InterstitialAdRequestParameters extends FullScreenAdRequestParameters {
    public InterstitialAdRequestParameters(AdContentType adContentType) {
        super(defineAdsFormat(adContentType), adContentType);
    }

    @Override // io.bidmachine.AdRequestParameters
    public boolean isPlacementObjectValid(Placement placement) throws Throwable {
        return ProtoUtils.isInterstitialPlacement(placement);
    }

    /* JADX INFO: renamed from: io.bidmachine.interstitial.InterstitialAdRequestParameters$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$bidmachine$AdContentType;

        static {
            int[] iArr = new int[AdContentType.values().length];
            $SwitchMap$io$bidmachine$AdContentType = iArr;
            try {
                iArr[AdContentType.Static.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$bidmachine$AdContentType[AdContentType.Video.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static AdsFormat defineAdsFormat(AdContentType adContentType) {
        int i = AnonymousClass1.$SwitchMap$io$bidmachine$AdContentType[adContentType.ordinal()];
        if (i == 1) {
            return AdsFormat.InterstitialStatic;
        }
        if (i == 2) {
            return AdsFormat.InterstitialVideo;
        }
        return AdsFormat.Interstitial;
    }
}
