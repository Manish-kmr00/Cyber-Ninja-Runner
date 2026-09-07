package com.smaato.sdk.core.remoteconfig.global;

import com.smaato.sdk.core.AndroidsInjector;
import com.smaato.sdk.core.framework.SdkInitialisationObserver;
import com.smaato.sdk.core.util.diinjection.Inject;

/* JADX INFO: loaded from: classes14.dex */
public class GenericConfigProviderInitializer implements SdkInitialisationObserver {

    @Inject
    private static volatile GenericConfigProvider genericConfigProvider;

    @Override // com.smaato.sdk.core.framework.SdkInitialisationObserver
    public void onInitialised() {
        if (genericConfigProvider == null) {
            AndroidsInjector.injectStatic(GenericConfigProviderInitializer.class);
        }
        genericConfigProvider.fetchConfiguration();
    }
}
