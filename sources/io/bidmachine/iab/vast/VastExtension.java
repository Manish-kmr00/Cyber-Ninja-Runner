package io.bidmachine.iab.vast;

import io.bidmachine.iab.utils.IabElementStyle;
import io.bidmachine.iab.vast.tags.CompanionTag;
import io.bidmachine.iab.vast.tags.PostBannerTag;

/* JADX INFO: loaded from: classes6.dex */
public interface VastExtension {
    Integer getAssetsBackgroundColor();

    Integer getAssetsColor();

    IabElementStyle getCloseStyle();

    Float getCloseTimeSec();

    CompanionTag getCompanionTag();

    IabElementStyle getCountDownStyle();

    IabElementStyle getCtaStyle();

    Integer getForceOrientation();

    IabElementStyle getLoadingStyle();

    IabElementStyle getMuteStyle();

    PostBannerTag getPostBannerTag();

    IabElementStyle getProgressStyle();

    IabElementStyle getRepeatStyle();

    IabElementStyle getVideoStyle();

    Boolean isAutoRotate();

    boolean isMuted();

    boolean isR1();

    boolean isR2();

    boolean isVideoClickable();
}
