package com.smaato.sdk.banner.model.csm;

import android.content.Context;
import com.smaato.sdk.banner.model.BannerAdRequest;
import com.smaato.sdk.banner.model.soma.BannerSomaRemoteSource;
import com.smaato.sdk.core.csm.CsmAdResponse;
import com.smaato.sdk.core.csm.CsmAdResponseParser;
import com.smaato.sdk.core.mvvm.model.AdResponse;
import com.smaato.sdk.core.mvvm.model.csm.CsmParameters;
import com.smaato.sdk.core.mvvm.model.csm.CsmRemoteSource;
import com.smaato.sdk.core.mvvm.model.soma.SomaAdRequest;
import com.smaato.sdk.core.network.SomaException;
import com.smaato.sdk.core.util.fi.Consumer;
import java.io.IOException;

/* JADX INFO: loaded from: classes8.dex */
public class BannerCsmRemoteSource extends CsmRemoteSource {
    private final BannerSomaRemoteSource bannerSomaRemoteSource;
    private final Context context;
    private final CsmAdResponseParser csmAdResponseParser;

    public BannerCsmRemoteSource(CsmAdResponseParser csmAdResponseParser, BannerSomaRemoteSource bannerSomaRemoteSource, Context context) {
        this.csmAdResponseParser = csmAdResponseParser;
        this.bannerSomaRemoteSource = bannerSomaRemoteSource;
        this.context = context;
    }

    @Override // com.smaato.sdk.core.mvvm.model.csm.CsmRemoteSource
    public void loadAd(String str, SomaAdRequest somaAdRequest, Consumer<AdResponse> consumer, Consumer<Throwable> consumer2, CsmParameters csmParameters) throws IOException {
        if (somaAdRequest instanceof BannerAdRequest) {
            BannerAdRequest bannerAdRequest = (BannerAdRequest) somaAdRequest;
            try {
                CsmAdResponse response = this.csmAdResponseParser.parseResponse(str);
                new BannerCsmAdLoader(getSortedNetworkList(response), response.getPassback(), bannerAdRequest, csmParameters, consumer, consumer2, this.bannerSomaRemoteSource, this.context).loadAd();
            } catch (Exception unused) {
                throw new SomaException(SomaException.Type.BAD_RESPONSE, "Could not parse csm ad response");
            }
        }
    }
}
