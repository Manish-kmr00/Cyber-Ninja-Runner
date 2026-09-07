package com.pubmatic.sdk.openwrap.core.signal;

import android.content.Context;
import com.amazon.device.ads.DTBMetricsConfiguration;
import com.pubmatic.sdk.common.POBAdFormat;
import com.pubmatic.sdk.common.POBAdSize;
import com.pubmatic.sdk.common.POBInstanceProvider;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.pubmatic.sdk.openwrap.core.POBBanner;
import com.pubmatic.sdk.openwrap.core.POBRequest;
import com.pubmatic.sdk.openwrap.core.POBVideo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/pubmatic/sdk/openwrap/core/signal/POBALMAXSignalGenerator;", "Lcom/pubmatic/sdk/openwrap/core/signal/POBSignalGeneration;", "()V", "generateSignal", "", "context", "Landroid/content/Context;", DTBMetricsConfiguration.CONFIG_DIR, "Lcom/pubmatic/sdk/openwrap/core/signal/POBSignalConfig;", "openwrapcore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class POBALMAXSignalGenerator implements POBSignalGeneration {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[POBAdFormat.values().length];
            iArr[POBAdFormat.BANNER.ordinal()] = 1;
            iArr[POBAdFormat.MREC.ordinal()] = 2;
            iArr[POBAdFormat.INTERSTITIAL.ordinal()] = 3;
            iArr[POBAdFormat.REWARDEDAD.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.pubmatic.sdk.openwrap.core.signal.POBSignalGeneration
    public String generateSignal(Context context, POBSignalConfig config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        POBAdFormat adFormat = config.getAdFormat();
        POBAdFormat pOBAdFormat = POBAdFormat.REWARDEDAD;
        POBALMAXImpression pOBALMAXImpression = new POBALMAXImpression(adFormat == pOBAdFormat, config.getAdFormat() == POBAdFormat.INTERSTITIAL || config.getAdFormat() == pOBAdFormat);
        String gpid = config.getGpid();
        if (gpid != null) {
            pOBALMAXImpression.setGpid(gpid);
        }
        int i = WhenMappings.$EnumSwitchMapping$0[config.getAdFormat().ordinal()];
        if (i == 1) {
            pOBALMAXImpression.setBanner(new POBBanner());
        } else if (i == 2) {
            pOBALMAXImpression.setBanner(new POBBanner());
            POBVideo.Placement placement = POBVideo.Placement.IN_BANNER;
            POBVideo.Plcmt plcmt = POBVideo.Plcmt.STANDALONE;
            POBVideo.Linearity linearity = POBVideo.Linearity.LINEAR;
            POBAdSize BANNER_SIZE_300x250 = POBAdSize.BANNER_SIZE_300x250;
            Intrinsics.checkNotNullExpressionValue(BANNER_SIZE_300x250, "BANNER_SIZE_300x250");
            pOBALMAXImpression.setVideo(new POBALMAXVideo(placement, plcmt, linearity, BANNER_SIZE_300x250));
        } else if (i == 3) {
            POBAdSize interstitialAdSize = POBUtils.getInterstitialAdSize(context.getApplicationContext());
            pOBALMAXImpression.setAdPosition(POBRequest.AdPosition.FULL_SCREEN);
            pOBALMAXImpression.setBanner(new POBBanner());
            POBVideo.Placement placement2 = POBVideo.Placement.INTERSTITIAL;
            POBVideo.Plcmt plcmt2 = POBVideo.Plcmt.INTERSTITIAL;
            POBVideo.Linearity linearity2 = POBVideo.Linearity.LINEAR;
            Intrinsics.checkNotNullExpressionValue(interstitialAdSize, "interstitialAdSize");
            pOBALMAXImpression.setVideo(new POBALMAXVideo(placement2, plcmt2, linearity2, interstitialAdSize));
        } else if (i == 4) {
            POBAdSize interstitialAdSize2 = POBUtils.getInterstitialAdSize(context.getApplicationContext());
            pOBALMAXImpression.setAdPosition(POBRequest.AdPosition.FULL_SCREEN);
            POBVideo.Placement placement3 = POBVideo.Placement.INTERSTITIAL;
            POBVideo.Plcmt plcmt3 = POBVideo.Plcmt.INTERSTITIAL;
            POBVideo.Linearity linearity3 = POBVideo.Linearity.LINEAR;
            Intrinsics.checkNotNullExpressionValue(interstitialAdSize2, "interstitialAdSize");
            pOBALMAXImpression.setVideo(new POBALMAXVideo(placement3, plcmt3, linearity3, interstitialAdSize2));
        }
        POBALMAXSignalBuilder pOBALMAXSignalBuilder = new POBALMAXSignalBuilder(context);
        pOBALMAXSignalBuilder.setRequest(POBALMAXRequestFactory.getRequest(config.getAdFormat(), pOBALMAXImpression));
        pOBALMAXSignalBuilder.setDeviceInfo(POBInstanceProvider.getDeviceInfo(context));
        return pOBALMAXSignalBuilder.build();
    }
}
