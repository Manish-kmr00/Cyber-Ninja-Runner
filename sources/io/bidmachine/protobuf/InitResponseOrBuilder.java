package io.bidmachine.protobuf;

import com.explorestack.protobuf.ByteString;
import com.explorestack.protobuf.MessageOrBuilder;
import com.explorestack.protobuf.adcom.Ad;
import io.bidmachine.protobuf.sdk.Configuration;
import io.bidmachine.protobuf.sdk.ConfigurationOrBuilder;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public interface InitResponseOrBuilder extends MessageOrBuilder {
    boolean containsAdCachePlacementControl(String str);

    AdCacheControl getAdCacheControl();

    int getAdCacheControlValue();

    int getAdCacheMaxAge();

    @Deprecated
    Map<String, AdCachePlacementControl> getAdCachePlacementControl();

    int getAdCachePlacementControlCount();

    Map<String, AdCachePlacementControl> getAdCachePlacementControlMap();

    AdCachePlacementControl getAdCachePlacementControlOrDefault(String str, AdCachePlacementControl adCachePlacementControl);

    AdCachePlacementControl getAdCachePlacementControlOrThrow(String str);

    AdNetwork getAdNetworks(int i);

    int getAdNetworksCount();

    List<AdNetwork> getAdNetworksList();

    int getAdNetworksLoadingTimeout();

    AdNetworkOrBuilder getAdNetworksOrBuilder(int i);

    List<? extends AdNetworkOrBuilder> getAdNetworksOrBuilderList();

    int getAdRequestTmax();

    String getEndpoint();

    ByteString getEndpointBytes();

    Ad.Event getEvent(int i);

    AdExtension.EventConfiguration getEventConfiguration();

    AdExtension.EventConfigurationOrBuilder getEventConfigurationOrBuilder();

    int getEventCount();

    List<Ad.Event> getEventList();

    Ad.EventOrBuilder getEventOrBuilder(int i);

    List<? extends Ad.EventOrBuilder> getEventOrBuilderList();

    Extras getExtras();

    ExtrasOrBuilder getExtrasOrBuilder();

    SdkAnalyticConfig getSdkAnalyticConfig();

    SdkAnalyticConfigOrBuilder getSdkAnalyticConfigOrBuilder();

    Configuration getSdkAnalyticConfigV2();

    ConfigurationOrBuilder getSdkAnalyticConfigV2OrBuilder();

    int getSessionResetAfter();

    boolean getShowWithoutInternet();

    TokenConfiguration getTokenConfigurations(int i);

    int getTokenConfigurationsCount();

    List<TokenConfiguration> getTokenConfigurationsList();

    TokenConfigurationOrBuilder getTokenConfigurationsOrBuilder(int i);

    List<? extends TokenConfigurationOrBuilder> getTokenConfigurationsOrBuilderList();

    boolean hasEventConfiguration();

    boolean hasExtras();

    boolean hasSdkAnalyticConfig();

    boolean hasSdkAnalyticConfigV2();
}
