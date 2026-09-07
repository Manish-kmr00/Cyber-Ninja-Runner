package com.smaato.sdk.core.mvvm.model.csm;

import com.smaato.sdk.core.ad.AdType;
import com.smaato.sdk.core.mvvm.model.AdResponse;
import com.smaato.sdk.core.mvvm.model.AdResponseParser;
import com.smaato.sdk.core.util.HeaderValueUtils;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes10.dex */
public class SomaCsmResponseParser extends AdResponseParser {
    public SomaCsmResponseParser(HeaderValueUtils headerValueUtils) {
        super(AdType.IMAGE, headerValueUtils);
    }

    @Override // com.smaato.sdk.core.mvvm.model.AdResponseParser
    protected AdResponse parseResponse(AdResponse.Builder builder, String str, long j) throws IOException {
        throw new CsmException(str, createCsmParameters(builder));
    }

    private CsmParameters createCsmParameters(AdResponse.Builder builder) {
        AdResponse adResponseBuild = builder.setAdType(AdType.IMAGE).setWidth(0).setHeight(0).setImpressionTrackingUrls(new ArrayList()).setClickTrackingUrls(new ArrayList()).build();
        return new CsmParameters(adResponseBuild.getSessionId(), adResponseBuild.getSci(), adResponseBuild.getImpressionCountingType(), adResponseBuild.getTtlMs(), adResponseBuild.getBundleId());
    }
}
