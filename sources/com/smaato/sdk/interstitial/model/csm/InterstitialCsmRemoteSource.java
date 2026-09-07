package com.smaato.sdk.interstitial.model.csm;

import android.app.Activity;
import com.smaato.sdk.core.csm.CsmAdResponse;
import com.smaato.sdk.core.csm.CsmAdResponseParser;
import com.smaato.sdk.core.lifecycle.ActivityProvider;
import com.smaato.sdk.core.mvvm.model.AdResponse;
import com.smaato.sdk.core.mvvm.model.csm.CsmParameters;
import com.smaato.sdk.core.mvvm.model.csm.CsmRemoteSource;
import com.smaato.sdk.core.mvvm.model.soma.SomaAdRequest;
import com.smaato.sdk.core.network.SomaException;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.interstitial.model.InterstitialAdRequest;
import com.smaato.sdk.interstitial.model.soma.InterstitialSomaRemoteSource;
import java.io.IOException;

/* JADX INFO: loaded from: classes8.dex */
public class InterstitialCsmRemoteSource extends CsmRemoteSource {
    private final CsmAdResponseParser csmAdResponseParser;
    private final InterstitialSomaRemoteSource interstitialSomaRemoteSource;

    public InterstitialCsmRemoteSource(CsmAdResponseParser csmAdResponseParser, InterstitialSomaRemoteSource interstitialSomaRemoteSource) {
        this.csmAdResponseParser = csmAdResponseParser;
        this.interstitialSomaRemoteSource = interstitialSomaRemoteSource;
    }

    @Override // com.smaato.sdk.core.mvvm.model.csm.CsmRemoteSource
    public void loadAd(String str, SomaAdRequest somaAdRequest, Consumer<AdResponse> consumer, Consumer<Throwable> consumer2, CsmParameters csmParameters) throws IOException {
        if (somaAdRequest instanceof InterstitialAdRequest) {
            try {
                CsmAdResponse response = this.csmAdResponseParser.parseResponse(str);
                Activity currentActivity = ActivityProvider.get().getCurrentActivity();
                if (currentActivity == null) {
                    throw new SomaException(SomaException.Type.BAD_REQUEST, "No current activity available");
                }
                new InterstitialCsmAdLoader(getSortedNetworkList(response), response.getPassback(), (InterstitialAdRequest) somaAdRequest, csmParameters, consumer, consumer2, this.interstitialSomaRemoteSource, currentActivity).loadAd();
            } catch (Exception unused) {
                throw new SomaException(SomaException.Type.BAD_RESPONSE, "Could not parse csm ad response");
            }
        }
    }
}
