package com.smaato.sdk.nativead.model.soma;

import com.json.b9;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.mvvm.model.soma.SomaAdRequest;
import com.smaato.sdk.core.mvvm.model.soma.SomaRemoteSource;
import com.smaato.sdk.core.network.HttpClient;
import com.smaato.sdk.core.network.Request;
import com.smaato.sdk.core.util.HeaderValueUtils;
import com.smaato.sdk.nativead.model.NativeSomaAdRequest;
import com.smaato.sdk.nativead.model.utils.IconImagesLoader;

/* JADX INFO: loaded from: classes13.dex */
public class NativeSomaRemoteSource extends SomaRemoteSource {
    IconImagesLoader iconImagesLoader;

    public NativeSomaRemoteSource(HttpClient httpClient, String str, HeaderValueUtils headerValueUtils, IconImagesLoader iconImagesLoader, Logger logger) {
        super(httpClient, str, headerValueUtils, logger);
        this.iconImagesLoader = iconImagesLoader;
    }

    @Override // com.smaato.sdk.core.mvvm.model.soma.SomaRemoteSource
    protected Request buildSomaHttpRequest(SomaAdRequest somaAdRequest) {
        Request requestBuildSomaHttpRequest = super.buildSomaHttpRequest(somaAdRequest);
        if (!(somaAdRequest instanceof NativeSomaAdRequest)) {
            return requestBuildSomaHttpRequest;
        }
        return requestBuildSomaHttpRequest.buildUpon().uri(requestBuildSomaHttpRequest.uri().buildUpon().appendQueryParameter(b9.h.J0, ((NativeSomaAdRequest) somaAdRequest).shouldFetchPrivacy() ? "true" : "false").build()).build();
    }
}
