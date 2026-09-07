package com.smaato.sdk.core.locationaware;

import android.app.Application;
import android.content.Context;
import com.smaato.sdk.core.di.ClassFactory;
import com.smaato.sdk.core.di.CoreDiNames;
import com.smaato.sdk.core.di.DiConstructor;
import com.smaato.sdk.core.di.DiRegistry;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.fi.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public final class DiLocationAware {
    public static DiRegistry createRegistry() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.core.locationaware.DiLocationAware$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                DiLocationAware.lambda$createRegistry$6((DiRegistry) obj);
            }
        });
    }

    static /* synthetic */ void lambda$createRegistry$6(DiRegistry diRegistry) {
        diRegistry.registerSingletonFactory(SimInfo.class, new ClassFactory() { // from class: com.smaato.sdk.core.locationaware.DiLocationAware$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiLocationAware.lambda$createRegistry$0(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(TzSettings.class, new ClassFactory() { // from class: com.smaato.sdk.core.locationaware.DiLocationAware$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiLocationAware.lambda$createRegistry$1(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(DnsLookup.class, new ClassFactory() { // from class: com.smaato.sdk.core.locationaware.DiLocationAware$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiLocationAware.lambda$createRegistry$2(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(ConsentCountryChecker.class, new ClassFactory() { // from class: com.smaato.sdk.core.locationaware.DiLocationAware$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiLocationAware.lambda$createRegistry$3(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(CoreDiNames.LOCATION_AWARE_GDPR, LocationAware.class, new ClassFactory() { // from class: com.smaato.sdk.core.locationaware.DiLocationAware$$ExternalSyntheticLambda5
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiLocationAware.lambda$createRegistry$4(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(CoreDiNames.LOCATION_AWARE_LGPD, LocationAware.class, new ClassFactory() { // from class: com.smaato.sdk.core.locationaware.DiLocationAware$$ExternalSyntheticLambda6
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiLocationAware.lambda$createRegistry$5(diConstructor);
            }
        });
    }

    static /* synthetic */ SimInfo lambda$createRegistry$0(DiConstructor diConstructor) {
        return new SimInfoImpl((Context) diConstructor.get(Application.class));
    }

    static /* synthetic */ TzSettings lambda$createRegistry$1(DiConstructor diConstructor) {
        return new TzSettingsImpl((Context) diConstructor.get(Application.class));
    }

    static /* synthetic */ DnsLookup lambda$createRegistry$2(DiConstructor diConstructor) {
        return new DnsLookupImpl((Logger) diConstructor.get(Logger.class));
    }

    static /* synthetic */ ConsentCountryChecker lambda$createRegistry$3(DiConstructor diConstructor) {
        return new ConsentCountryChecker((Context) diConstructor.get(Application.class), (SimInfo) diConstructor.get(SimInfo.class), (TzSettings) diConstructor.get(TzSettings.class), (DnsLookup) diConstructor.get(DnsLookup.class), (Logger) diConstructor.get(Logger.class));
    }

    static /* synthetic */ LocationAware lambda$createRegistry$4(DiConstructor diConstructor) {
        return new LocationAwareGdprImpl((ConsentCountryChecker) diConstructor.get(ConsentCountryChecker.class), false);
    }

    static /* synthetic */ LocationAware lambda$createRegistry$5(DiConstructor diConstructor) {
        return new LocationAwareLgpdImpl((ConsentCountryChecker) diConstructor.get(ConsentCountryChecker.class), false);
    }
}
