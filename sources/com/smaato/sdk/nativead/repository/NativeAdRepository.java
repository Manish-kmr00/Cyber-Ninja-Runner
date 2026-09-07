package com.smaato.sdk.nativead.repository;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import com.smaato.sdk.core.ad.AdFormat;
import com.smaato.sdk.core.api.ApiParams;
import com.smaato.sdk.core.gdpr.SomaGdprDataSource;
import com.smaato.sdk.core.linkhandler.LinkHandler;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.mvvm.model.AdResponse;
import com.smaato.sdk.core.mvvm.model.AdResponseParser;
import com.smaato.sdk.core.mvvm.model.csm.CsmRemoteSource;
import com.smaato.sdk.core.mvvm.model.om.OMTrackingRemoteSource;
import com.smaato.sdk.core.mvvm.model.soma.SomaAdRequest;
import com.smaato.sdk.core.mvvm.model.soma.SomaRemoteSource;
import com.smaato.sdk.core.mvvm.model.ub.UbRemoteSource;
import com.smaato.sdk.core.mvvm.repository.SmaatoSdkRepository;
import com.smaato.sdk.core.network.NetworkStateMonitor;
import com.smaato.sdk.core.simplehttp.SimpleHttpClient;
import com.smaato.sdk.core.util.Threads;
import com.smaato.sdk.core.util.fi.BiConsumer;
import com.smaato.sdk.core.violationreporter.AdQualityViolationReporter;
import com.smaato.sdk.nativead.model.NativeAdComponents;
import com.smaato.sdk.nativead.model.NativeSomaAdRequest;
import com.smaato.sdk.nativead.model.utils.IconImagesLoader;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public class NativeAdRepository extends SmaatoSdkRepository {
    private final IconImagesLoader iconImagesLoader;
    private final Logger logger;
    private final SimpleHttpClient simpleHttpClient;

    public NativeAdRepository(SomaRemoteSource somaRemoteSource, UbRemoteSource ubRemoteSource, CsmRemoteSource csmRemoteSource, SomaGdprDataSource somaGdprDataSource, NetworkStateMonitor networkStateMonitor, LinkHandler linkHandler, SimpleHttpClient simpleHttpClient, AdQualityViolationReporter adQualityViolationReporter, OMTrackingRemoteSource oMTrackingRemoteSource, Map<AdFormat, AdResponseParser> map, ApiParams apiParams, IconImagesLoader iconImagesLoader, Logger logger) {
        super(somaRemoteSource, ubRemoteSource, csmRemoteSource, somaGdprDataSource, networkStateMonitor, linkHandler, simpleHttpClient, adQualityViolationReporter, oMTrackingRemoteSource, map, apiParams, logger);
        this.iconImagesLoader = iconImagesLoader;
        this.simpleHttpClient = simpleHttpClient;
        this.logger = logger;
    }

    @Override // com.smaato.sdk.core.mvvm.repository.SmaatoSdkRepository
    protected AdResponse loadAdFromSoma(SomaAdRequest somaAdRequest) throws IOException {
        return loadIconAndImagesIfRequested(somaAdRequest, super.loadAdFromSoma(somaAdRequest));
    }

    @Override // com.smaato.sdk.core.mvvm.repository.SmaatoSdkRepository
    protected AdResponse loadAdFromUbCache(SomaAdRequest somaAdRequest) throws IOException {
        AdResponse adResponseLoadAdFromUbCache = super.loadAdFromUbCache(somaAdRequest);
        if (adResponseLoadAdFromUbCache == null) {
            return null;
        }
        return loadIconAndImagesIfRequested(somaAdRequest, adResponseLoadAdFromUbCache);
    }

    public void launchAsUncheckedIntent(String str) {
        this.linkHandler.launchAsUncheckedIntent(str);
    }

    public BiConsumer<Uri, ImageView> getImageLoader() {
        return new BiConsumer() { // from class: com.smaato.sdk.nativead.repository.NativeAdRepository$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.BiConsumer
            public final void accept(Object obj, Object obj2) {
                this.f$0.m5623x5c109972((Uri) obj, (ImageView) obj2);
            }
        };
    }

    /* JADX INFO: renamed from: lambda$getImageLoader$2$com-smaato-sdk-nativead-repository-NativeAdRepository, reason: not valid java name */
    /* synthetic */ void m5623x5c109972(final Uri uri, final ImageView imageView) {
        Threads.runOnBackgroundThread(new Runnable() { // from class: com.smaato.sdk.nativead.repository.NativeAdRepository$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5622x32bc4431(uri, imageView);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$getImageLoader$1$com-smaato-sdk-nativead-repository-NativeAdRepository, reason: not valid java name */
    /* synthetic */ void m5622x32bc4431(Uri uri, final ImageView imageView) {
        try {
            final Bitmap bitmap = this.simpleHttpClient.readBitmap(uri.toString());
            Threads.runOnUi(new Runnable() { // from class: com.smaato.sdk.nativead.repository.NativeAdRepository$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    imageView.setImageBitmap(bitmap);
                }
            });
        } catch (Exception e) {
            this.logger.error(LogDomain.NETWORK, "Could not load image " + uri, e);
        }
    }

    private AdResponse loadIconAndImagesIfRequested(SomaAdRequest somaAdRequest, AdResponse adResponse) {
        if (!(somaAdRequest instanceof NativeSomaAdRequest) || !(adResponse.getNativeObject() instanceof NativeAdComponents)) {
            return adResponse;
        }
        NativeAdComponents nativeAdComponentsLoadIconAndImages = (NativeAdComponents) adResponse.getNativeObject();
        if (!((NativeSomaAdRequest) somaAdRequest).shouldReturnUrlsForImageAssets()) {
            nativeAdComponentsLoadIconAndImages = this.iconImagesLoader.loadIconAndImages(nativeAdComponentsLoadIconAndImages);
        }
        return adResponse.buildUpon().setNativeObject(nativeAdComponentsLoadIconAndImages).build();
    }
}
