package com.smaato.sdk.video.ad;

import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.simplehttp.SimpleHttpClient;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.video.vast.model.VastScenario;
import com.smaato.sdk.video.vast.tracking.VastErrorTracker;
import com.smaato.sdk.video.vast.tracking.macro.MacrosInjectorProviderFunction;
import java.util.Collection;

/* JADX INFO: loaded from: classes12.dex */
public class VastErrorTrackerCreator {
    private final Logger logger;
    private final MacrosInjectorProviderFunction macroInjectorProvider;
    private final SimpleHttpClient simpleHttpClient;

    public VastErrorTrackerCreator(Logger logger, SimpleHttpClient simpleHttpClient, MacrosInjectorProviderFunction macrosInjectorProviderFunction) {
        this.logger = (Logger) Objects.requireNonNull(logger);
        this.macroInjectorProvider = (MacrosInjectorProviderFunction) Objects.requireNonNull(macrosInjectorProviderFunction);
        this.simpleHttpClient = simpleHttpClient;
    }

    VastErrorTracker create(VastScenario vastScenario, Collection<String> collection) {
        return new VastErrorTracker(this.logger, this.simpleHttpClient, this.macroInjectorProvider.apply(vastScenario), collection);
    }
}
