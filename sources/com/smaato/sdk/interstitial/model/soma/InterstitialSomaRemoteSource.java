package com.smaato.sdk.interstitial.model.soma;

import android.net.Uri;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.mvvm.model.soma.SomaAdRequest;
import com.smaato.sdk.core.mvvm.model.soma.SomaRemoteSource;
import com.smaato.sdk.core.network.HttpClient;
import com.smaato.sdk.core.network.Request;
import com.smaato.sdk.core.util.HeaderValueUtils;
import com.smaato.sdk.interstitial.model.InterstitialAdRequest;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class InterstitialSomaRemoteSource extends SomaRemoteSource {
    public InterstitialSomaRemoteSource(HttpClient httpClient, String str, HeaderValueUtils headerValueUtils, Logger logger) {
        super(httpClient, str, headerValueUtils, logger);
    }

    @Override // com.smaato.sdk.core.mvvm.model.soma.SomaRemoteSource
    protected Request buildSomaHttpRequest(SomaAdRequest somaAdRequest) {
        Request requestBuildSomaHttpRequest = super.buildSomaHttpRequest(somaAdRequest);
        if (!(somaAdRequest instanceof InterstitialAdRequest)) {
            return requestBuildSomaHttpRequest;
        }
        InterstitialAdRequest interstitialAdRequest = (InterstitialAdRequest) somaAdRequest;
        Uri uriAddUriParameter = addUriParameter(addUriParameter(addUriParameter(addUriParameter(requestBuildSomaHttpRequest.uri(), "videotype", interstitialAdRequest.getVideoType()), "dimension", interstitialAdRequest.getFullscreenDimension()), "width", Integer.toString(interstitialAdRequest.getDisplayWidthInDp())), "height", Integer.toString(interstitialAdRequest.getDisplayHeightInDp()));
        if (interstitialAdRequest.getIsSplash()) {
            uriAddUriParameter = setAdFormatParameterToSplash(uriAddUriParameter);
        }
        if (interstitialAdRequest.getRichMediaIsRewarded()) {
            uriAddUriParameter = addUriParameter(uriAddUriParameter, "playableSupported", "1");
        }
        return requestBuildSomaHttpRequest.buildUpon().uri(uriAddUriParameter).build();
    }

    private static Uri setAdFormatParameterToSplash(Uri uri) {
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        Uri.Builder builderClearQuery = uri.buildUpon().clearQuery();
        for (String str : queryParameterNames) {
            builderClearQuery.appendQueryParameter(str, str.equals("format") ? "splash" : uri.getQueryParameter(str));
        }
        return builderClearQuery.build();
    }

    private static Uri addUriParameter(Uri uri, String str, String str2) {
        return uri.buildUpon().appendQueryParameter(str, str2).build();
    }
}
