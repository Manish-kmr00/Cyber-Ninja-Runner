package io.bidmachine.protobuf;

import com.explorestack.protobuf.ByteString;
import com.explorestack.protobuf.MessageOrBuilder;
import com.explorestack.protobuf.adcom.Ad;
import io.bidmachine.protobuf.rendering.Rendering;
import io.bidmachine.protobuf.rendering.RenderingOrBuilder;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public interface AdExtensionOrBuilder extends MessageOrBuilder {
    boolean containsCustomParams(String str);

    AdCacheControl getAdCacheControl();

    int getAdCacheControlValue();

    int getAdCacheMaxAge();

    boolean getAdFlexibleSize();

    int getAdMarkupLoadingTimeout();

    AdExtension.ControlAsset getCloseButton();

    AdExtension.ControlAssetOrBuilder getCloseButtonOrBuilder();

    int getCompanionSkipoffset();

    AdExtension.ControlAsset getCountdown();

    AdExtension.ControlAssetOrBuilder getCountdownOrBuilder();

    @Deprecated
    CreativeExtension getCreativeExtension();

    @Deprecated
    CreativeExtensionOrBuilder getCreativeExtensionOrBuilder();

    CreativeLoadingMethod getCreativeLoadingMethod();

    int getCreativeLoadingMethodValue();

    int getCreativeLoadingTimeout();

    boolean getCridMonitoringEnabled();

    @Deprecated
    Map<String, String> getCustomParams();

    int getCustomParamsCount();

    Map<String, String> getCustomParamsMap();

    String getCustomParamsOrDefault(String str, String str2);

    String getCustomParamsOrThrow(String str);

    Ad.Event getEvent(int i);

    AdExtension.EventConfiguration getEventConfiguration();

    AdExtension.EventConfigurationOrBuilder getEventConfigurationOrBuilder();

    int getEventCount();

    List<Ad.Event> getEventList();

    Ad.EventOrBuilder getEventOrBuilder(int i);

    List<? extends Ad.EventOrBuilder> getEventOrBuilderList();

    boolean getIgnoresSafeAreaLayoutGuide();

    @Deprecated
    int getLoadSkipoffset();

    boolean getMraidCreativeValidationRequired();

    float getPlaceholderTimeout();

    @Deprecated
    boolean getPreload();

    boolean getPreloadAd();

    AdExtension.ControlAsset getProgress();

    int getProgressDuration();

    AdExtension.ControlAssetOrBuilder getProgressOrBuilder();

    boolean getR1();

    int getR1Delay();

    boolean getR2();

    Rendering getRenderingConfiguration();

    RenderingOrBuilder getRenderingConfigurationOrBuilder();

    int getSkipoffset();

    String getStoreUrl();

    ByteString getStoreUrlBytes();

    boolean getUseEmbeddedBrowser();

    boolean getUseNativeClose();

    float getViewabilityDurationThreshold();

    boolean getViewabilityIgnoreOverlap();

    boolean getViewabilityIgnoreWindowFocus();

    float getViewabilityPixelThreshold();

    int getViewabilityTimeThreshold();

    boolean hasCloseButton();

    boolean hasCountdown();

    @Deprecated
    boolean hasCreativeExtension();

    boolean hasEventConfiguration();

    boolean hasProgress();

    boolean hasRenderingConfiguration();
}
