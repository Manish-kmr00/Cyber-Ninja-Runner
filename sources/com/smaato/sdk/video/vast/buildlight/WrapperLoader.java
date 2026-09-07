package com.smaato.sdk.video.vast.buildlight;

import android.text.TextUtils;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.network.Call;
import com.smaato.sdk.core.network.Callback;
import com.smaato.sdk.core.network.HttpClient;
import com.smaato.sdk.core.network.Request;
import com.smaato.sdk.core.network.Response;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.video.fi.NonNullConsumer;
import com.smaato.sdk.video.vast.exceptions.wrapper.GeneralWrapperErrorException;
import com.smaato.sdk.video.vast.model.VastTree;
import com.smaato.sdk.video.vast.model.Wrapper;
import com.smaato.sdk.video.vast.parser.ParseResult;
import com.smaato.sdk.video.vast.parser.VastResponseParser;

/* JADX INFO: loaded from: classes12.dex */
public class WrapperLoader {
    private final HttpClient httpClient;
    private final VastResponseParser vastResponseParser;

    public WrapperLoader(VastResponseParser vastResponseParser, HttpClient httpClient) {
        this.vastResponseParser = (VastResponseParser) Objects.requireNonNull(vastResponseParser);
        this.httpClient = (HttpClient) Objects.requireNonNull(httpClient);
    }

    void loadWrapper(final Logger logger, final String str, final NonNullConsumer<ParseResult<VastTree>> nonNullConsumer) {
        if (str == null || TextUtils.isEmpty(str)) {
            nonNullConsumer.accept(ParseResult.error(Wrapper.VAST_AD_TAG_URI, new GeneralWrapperErrorException("Cannot resolve wrapper: vastAdTagUri is missing")));
        } else {
            this.httpClient.newCall(Request.get(str)).enqueue(new Callback() { // from class: com.smaato.sdk.video.vast.buildlight.WrapperLoader.1
                @Override // com.smaato.sdk.core.network.Callback
                public void onResponse(Call call, Response response) {
                    if (response.responseCode() == 200) {
                        WrapperLoader.this.vastResponseParser.parseVastResponse(logger, response.body().source(), response.encoding(), nonNullConsumer);
                        return;
                    }
                    String str2 = String.format("Failed to load Vast url: %s response code: %d", str, Integer.valueOf(response.responseCode()));
                    logger.error(LogDomain.VAST, str2, new Object[0]);
                    nonNullConsumer.accept(ParseResult.error("Wrapper", new GeneralWrapperErrorException(str2)));
                }

                @Override // com.smaato.sdk.core.network.Callback
                public void onFailure(Call call, Exception exc) {
                    String str2 = String.format("Failed to load Vast url: %s due to error: %s", str, exc);
                    logger.error(LogDomain.VAST, str2, new Object[0]);
                    nonNullConsumer.accept(ParseResult.error("Wrapper", new GeneralWrapperErrorException(str2)));
                }
            });
        }
    }
}
