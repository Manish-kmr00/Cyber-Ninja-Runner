package io.bidmachine.protobuf;

import com.explorestack.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes10.dex */
public interface WaterfallOrBuilder extends MessageOrBuilder {
    Waterfall.PayloadCase getPayloadCase();

    Waterfall.Result getRequest();

    Waterfall.ResultOrBuilder getRequestOrBuilder();

    Waterfall.Configuration getResponse();

    Waterfall.ConfigurationOrBuilder getResponseOrBuilder();

    boolean hasRequest();

    boolean hasResponse();
}
