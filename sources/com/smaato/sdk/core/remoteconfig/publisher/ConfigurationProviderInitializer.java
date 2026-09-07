package com.smaato.sdk.core.remoteconfig.publisher;

import com.smaato.sdk.core.AndroidsInjector;
import com.smaato.sdk.core.SmaatoSdk;
import com.smaato.sdk.core.framework.SdkInitialisationObserver;
import com.smaato.sdk.core.util.diinjection.Inject;

/* JADX INFO: loaded from: classes8.dex */
public class ConfigurationProviderInitializer implements SdkInitialisationObserver {

    @Inject
    private static volatile ConfigurationProvider configurationProvider;

    @Override // com.smaato.sdk.core.framework.SdkInitialisationObserver
    public void onInitialised() {
        String publisherId = SmaatoSdk.getPublisherId();
        if (configurationProvider == null) {
            AndroidsInjector.injectStatic(ConfigurationProviderInitializer.class);
        }
        if (configurationProvider == null || publisherId == null) {
            return;
        }
        configurationProvider.fetchConfiguration(publisherId);
    }
}
