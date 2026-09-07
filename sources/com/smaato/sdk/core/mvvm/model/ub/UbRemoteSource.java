package com.smaato.sdk.core.mvvm.model.ub;

import com.smaato.sdk.core.ad.AdFormat;
import com.smaato.sdk.core.mvvm.model.AdResponse;
import com.smaato.sdk.core.mvvm.model.AdResponseParser;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public interface UbRemoteSource {
    boolean isUbRequest(String str, String str2);

    AdResponse loadAd(String str, String str2) throws IOException;

    void setAdResponseParsers(Map<AdFormat, AdResponseParser> map);
}
