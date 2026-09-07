package com.smaato.sdk.core.mvvm.model.video;

import com.smaato.sdk.core.ad.AdType;
import com.smaato.sdk.core.mvvm.model.AdResponse;
import com.smaato.sdk.core.mvvm.model.AdResponseParser;
import com.smaato.sdk.core.util.HeaderValueUtils;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public class VideoWrappedInRichMediaAdResponseParser extends AdResponseParser {
    public VideoWrappedInRichMediaAdResponseParser(HeaderValueUtils headerValueUtils) {
        super(AdType.VIDEO, headerValueUtils);
    }

    @Override // com.smaato.sdk.core.mvvm.model.AdResponseParser
    protected AdResponse parseResponse(AdResponse.Builder builder, String str, long j) throws IOException {
        return builder.setVastObject(str).setWidth(0).setHeight(0).setImpressionTrackingUrls(new ArrayList()).setClickTrackingUrls(new ArrayList()).build();
    }
}
