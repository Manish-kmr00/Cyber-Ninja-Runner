package com.smaato.sdk.core.remoteconfig;

import com.smaato.sdk.core.SmaatoSdk;
import com.smaato.sdk.core.remoteconfig.global.ConfigButtonDelays;
import com.smaato.sdk.core.remoteconfig.global.ConfigButtonSizes;
import com.smaato.sdk.core.remoteconfig.global.ConfigFeatures;
import com.smaato.sdk.core.remoteconfig.global.GenericConfig;
import com.smaato.sdk.core.remoteconfig.global.GenericConfigProvider;
import com.smaato.sdk.core.remoteconfig.publisher.ButtonDelays;
import com.smaato.sdk.core.remoteconfig.publisher.ButtonSizes;
import com.smaato.sdk.core.remoteconfig.publisher.Configuration;
import com.smaato.sdk.core.remoteconfig.publisher.ConfigurationProvider;
import com.smaato.sdk.core.util.Objects;

/* JADX INFO: loaded from: classes12.dex */
public class ButtonConfigurations {
    private final GenericConfigProvider genericConfigProvider;
    private final ConfigurationProvider publisherConfigProvider;

    public ButtonConfigurations(GenericConfigProvider genericConfigProvider, ConfigurationProvider configurationProvider) {
        this.genericConfigProvider = genericConfigProvider;
        this.publisherConfigProvider = configurationProvider;
    }

    public GenericConfig getGenericConfig() {
        return this.genericConfigProvider.getConfiguration();
    }

    public Configuration getPublisherConfig() {
        return this.publisherConfigProvider.getConfiguration((String) Objects.requireNonNull(SmaatoSdk.getPublisherId()));
    }

    public int getButtonSize(String str) {
        ConfigButtonSizes configButtonSizes = getGenericConfig().getConfigButtonSizes();
        if (isValidBundleId(str) && isButtonSizeFeatureEnabled()) {
            return getPublisherConfig().getButtonSizes().isButtonSizeEnabled(ButtonSizes.ButtonSize.SMALL) ? configButtonSizes.getSmallInDp() : configButtonSizes.getMidInDp();
        }
        return configButtonSizes.getMidInDp();
    }

    public int getVideoAdSkipButtonDelay(String str) {
        return getButtonDelay(str, getGenericConfig().getConfigButtonDelays().getVideoAdDelay(), getPublisherConfig().getButtonDelays().getVideoAdDelaySeconds());
    }

    public int getDisplayAdCloseButtonDelay(String str) {
        return getButtonDelay(str, getGenericConfig().getConfigButtonDelays().getDisplayAdDelay(), getPublisherConfig().getButtonDelays().getDisplayAdDelaySeconds());
    }

    private int getButtonDelay(String str, ConfigButtonDelays.DelayOptions delayOptions, int i) {
        ButtonDelays buttonDelays = getPublisherConfig().getButtonDelays();
        if (isValidBundleId(str) && isButtonDelayFeatureEnabled()) {
            if (buttonDelays.isButtonDelayEnabled(ButtonDelays.ButtonDelay.LARGE)) {
                return delayOptions.getLargeInSec();
            }
            if (buttonDelays.isButtonDelayEnabled(ButtonDelays.ButtonDelay.MID)) {
                return delayOptions.getMidInSec();
            }
        }
        return buttonDelays.isButtonDelayEnabled(ButtonDelays.ButtonDelay.MID) ? delayOptions.getMidInSec() : i;
    }

    private boolean isValidBundleId(String str) {
        return (str == null || str.isEmpty()) ? false : true;
    }

    private boolean isButtonSizeFeatureEnabled() {
        return getGenericConfig().getConfigFeatures().isFeatureEnabled(ConfigFeatures.Feature.BUTTON_SIZE);
    }

    private boolean isButtonDelayFeatureEnabled() {
        return getGenericConfig().getConfigFeatures().isFeatureEnabled(ConfigFeatures.Feature.BUTTON_DELAY);
    }
}
