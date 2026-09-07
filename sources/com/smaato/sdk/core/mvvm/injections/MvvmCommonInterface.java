package com.smaato.sdk.core.mvvm.injections;

import com.smaato.sdk.core.di.ClassFactory;
import com.smaato.sdk.core.di.DiConstructor;
import com.smaato.sdk.core.di.DiRegistry;
import com.smaato.sdk.core.framework.SimpleModuleInterface;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.mvvm.model.csm.SomaCsmResponseParser;
import com.smaato.sdk.core.mvvm.model.imagead.ImageAdResponseParser;
import com.smaato.sdk.core.mvvm.model.om.OMTrackingRemoteSource;
import com.smaato.sdk.core.mvvm.model.video.HexEncoder;
import com.smaato.sdk.core.mvvm.model.video.Md5Digester;
import com.smaato.sdk.core.mvvm.model.video.VideoWrappedInRichMediaAdResponseParser;
import com.smaato.sdk.core.mvvm.view.ViewDelegateStorage;
import com.smaato.sdk.core.util.HeaderValueUtils;
import com.smaato.sdk.core.util.fi.Consumer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes13.dex */
public class MvvmCommonInterface implements SimpleModuleInterface {
    private static final String MODULE_NAME = "MvvmCommonInterface";

    @Override // com.smaato.sdk.core.framework.BaseModuleInterface
    public String version() {
        return "22.7.2";
    }

    @Override // com.smaato.sdk.core.framework.BaseModuleInterface
    public String moduleDiName() {
        return MODULE_NAME;
    }

    @Override // com.smaato.sdk.core.framework.BaseModuleInterface
    public DiRegistry moduleDiRegistry() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.core.mvvm.injections.MvvmCommonInterface$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                MvvmCommonInterface.lambda$moduleDiRegistry$7((DiRegistry) obj);
            }
        });
    }

    static /* synthetic */ void lambda$moduleDiRegistry$7(DiRegistry diRegistry) {
        diRegistry.registerSingletonFactory(ImageAdResponseParser.class, new ClassFactory() { // from class: com.smaato.sdk.core.mvvm.injections.MvvmCommonInterface$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return MvvmCommonInterface.lambda$moduleDiRegistry$0(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(ViewDelegateStorage.class, new ClassFactory() { // from class: com.smaato.sdk.core.mvvm.injections.MvvmCommonInterface$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return MvvmCommonInterface.lambda$moduleDiRegistry$1(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(OMTrackingRemoteSource.class, new ClassFactory() { // from class: com.smaato.sdk.core.mvvm.injections.MvvmCommonInterface$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return MvvmCommonInterface.lambda$moduleDiRegistry$2(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(SomaCsmResponseParser.class, new ClassFactory() { // from class: com.smaato.sdk.core.mvvm.injections.MvvmCommonInterface$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return MvvmCommonInterface.lambda$moduleDiRegistry$3(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(VideoWrappedInRichMediaAdResponseParser.class, new ClassFactory() { // from class: com.smaato.sdk.core.mvvm.injections.MvvmCommonInterface$$ExternalSyntheticLambda5
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return MvvmCommonInterface.lambda$moduleDiRegistry$4(diConstructor);
            }
        });
        diRegistry.registerFactory(Md5Digester.class, new ClassFactory() { // from class: com.smaato.sdk.core.mvvm.injections.MvvmCommonInterface$$ExternalSyntheticLambda6
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return MvvmCommonInterface.lambda$moduleDiRegistry$5(diConstructor);
            }
        });
        diRegistry.registerFactory(HexEncoder.class, new ClassFactory() { // from class: com.smaato.sdk.core.mvvm.injections.MvvmCommonInterface$$ExternalSyntheticLambda7
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return MvvmCommonInterface.lambda$moduleDiRegistry$6(diConstructor);
            }
        });
    }

    static /* synthetic */ ImageAdResponseParser lambda$moduleDiRegistry$0(DiConstructor diConstructor) {
        return new ImageAdResponseParser((HeaderValueUtils) diConstructor.get(HeaderValueUtils.class), (Logger) diConstructor.get(Logger.class));
    }

    static /* synthetic */ ViewDelegateStorage lambda$moduleDiRegistry$1(DiConstructor diConstructor) {
        return new ViewDelegateStorage();
    }

    static /* synthetic */ OMTrackingRemoteSource lambda$moduleDiRegistry$2(DiConstructor diConstructor) {
        return new OMTrackingRemoteSource((Logger) diConstructor.get(Logger.class));
    }

    static /* synthetic */ SomaCsmResponseParser lambda$moduleDiRegistry$3(DiConstructor diConstructor) {
        return new SomaCsmResponseParser((HeaderValueUtils) diConstructor.get(HeaderValueUtils.class));
    }

    static /* synthetic */ VideoWrappedInRichMediaAdResponseParser lambda$moduleDiRegistry$4(DiConstructor diConstructor) {
        return new VideoWrappedInRichMediaAdResponseParser((HeaderValueUtils) diConstructor.get(HeaderValueUtils.class));
    }

    static /* synthetic */ Md5Digester lambda$moduleDiRegistry$5(DiConstructor diConstructor) {
        return new Md5Digester(Charset.forName("UTF-8"), (HexEncoder) diConstructor.get(HexEncoder.class));
    }

    static /* synthetic */ HexEncoder lambda$moduleDiRegistry$6(DiConstructor diConstructor) {
        return new HexEncoder();
    }
}
