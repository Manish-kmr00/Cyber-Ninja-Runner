package com.smaato.sdk.iahb;

import com.smaato.sdk.core.api.ExpirationTimestampFactory;
import com.smaato.sdk.core.di.ClassFactory;
import com.smaato.sdk.core.di.DiConstructor;
import com.smaato.sdk.core.di.DiRegistry;
import com.smaato.sdk.core.framework.SimpleModuleInterface;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.ub.UbCache;
import com.smaato.sdk.core.util.HeaderValueUtils;
import com.smaato.sdk.core.util.fi.Consumer;

/* JADX INFO: loaded from: classes12.dex */
public class IahbModuleInterface implements SimpleModuleInterface {
    @Override // com.smaato.sdk.core.framework.BaseModuleInterface
    public String version() {
        return "22.7.2";
    }

    @Override // com.smaato.sdk.core.framework.BaseModuleInterface
    public String moduleDiName() {
        return "IahbModuleInterface";
    }

    @Override // com.smaato.sdk.core.framework.BaseModuleInterface
    public DiRegistry moduleDiRegistry() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.iahb.IahbModuleInterface$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                IahbModuleInterface.lambda$moduleDiRegistry$2((DiRegistry) obj);
            }
        });
    }

    static /* synthetic */ void lambda$moduleDiRegistry$2(DiRegistry diRegistry) {
        diRegistry.registerSingletonFactory(IahbJsonAdapter.class, new ClassFactory() { // from class: com.smaato.sdk.iahb.IahbModuleInterface$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return IahbModuleInterface.lambda$moduleDiRegistry$0(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(IahbInteractor.class, new ClassFactory() { // from class: com.smaato.sdk.iahb.IahbModuleInterface$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return IahbModuleInterface.lambda$moduleDiRegistry$1(diConstructor);
            }
        });
    }

    static /* synthetic */ IahbJsonAdapter lambda$moduleDiRegistry$0(DiConstructor diConstructor) {
        return new IahbJsonAdapter((Logger) diConstructor.get(Logger.class));
    }

    static /* synthetic */ IahbInteractor lambda$moduleDiRegistry$1(DiConstructor diConstructor) {
        return new IahbInteractor((UbCache) diConstructor.get(UbCache.class), (IahbJsonAdapter) diConstructor.get(IahbJsonAdapter.class), (ExpirationTimestampFactory) diConstructor.get(ExpirationTimestampFactory.class), (HeaderValueUtils) diConstructor.get(HeaderValueUtils.class), (Logger) diConstructor.get(Logger.class));
    }
}
