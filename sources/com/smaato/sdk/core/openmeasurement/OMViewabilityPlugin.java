package com.smaato.sdk.core.openmeasurement;

import android.app.Application;
import android.content.Context;
import com.iab.omid.library.smaato.Omid;
import com.iab.omid.library.smaato.adsession.Partner;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.smaato.sdk.core.di.ClassFactory;
import com.smaato.sdk.core.di.DiConstructor;
import com.smaato.sdk.core.di.DiRegistry;
import com.smaato.sdk.core.log.DiLogLayer;
import com.smaato.sdk.core.util.AssetUtils;
import com.smaato.sdk.core.util.Threads;
import com.smaato.sdk.core.util.fi.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class OMViewabilityPlugin implements ViewabilityPlugin {
    public static final String OMID_JS_DI_NAME = "OMID_JS";

    @Override // com.smaato.sdk.core.openmeasurement.ViewabilityPlugin
    public void init(final Context context) {
        Threads.runOnUi(new Runnable() { // from class: com.smaato.sdk.core.openmeasurement.OMViewabilityPlugin$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                Omid.activate(context);
            }
        });
    }

    @Override // com.smaato.sdk.core.openmeasurement.ViewabilityPlugin
    public String getName() {
        return CampaignEx.KEY_OMID;
    }

    @Override // com.smaato.sdk.core.openmeasurement.ViewabilityPlugin
    public DiRegistry diRegistry() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.core.openmeasurement.OMViewabilityPlugin$$ExternalSyntheticLambda5
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                OMViewabilityPlugin.lambda$diRegistry$5((DiRegistry) obj);
            }
        });
    }

    static /* synthetic */ void lambda$diRegistry$5(DiRegistry diRegistry) {
        diRegistry.registerSingletonFactory(Partner.class, new ClassFactory() { // from class: com.smaato.sdk.core.openmeasurement.OMViewabilityPlugin$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return Partner.createPartner("Smaato", "22.7.2");
            }
        });
        diRegistry.registerFactory(OMVideoResourceMapper.class, new ClassFactory() { // from class: com.smaato.sdk.core.openmeasurement.OMViewabilityPlugin$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return OMViewabilityPlugin.lambda$diRegistry$2(diConstructor);
            }
        });
        diRegistry.registerFactory(OMImageResourceMapper.class, new ClassFactory() { // from class: com.smaato.sdk.core.openmeasurement.OMViewabilityPlugin$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return OMViewabilityPlugin.lambda$diRegistry$3(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory("OMID_JS", String.class, new ClassFactory() { // from class: com.smaato.sdk.core.openmeasurement.OMViewabilityPlugin$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return AssetUtils.getFileFromAssets((Context) diConstructor.get(Application.class), DiLogLayer.getLoggerFrom(diConstructor), POBCommonConstants.INTERNAL_SERVICE_FILE_NAME);
            }
        });
    }

    static /* synthetic */ OMVideoResourceMapper lambda$diRegistry$2(DiConstructor diConstructor) {
        return new OMVideoResourceMapper(CampaignEx.KEY_OMID);
    }

    static /* synthetic */ OMImageResourceMapper lambda$diRegistry$3(DiConstructor diConstructor) {
        return new OMImageResourceMapper();
    }
}
