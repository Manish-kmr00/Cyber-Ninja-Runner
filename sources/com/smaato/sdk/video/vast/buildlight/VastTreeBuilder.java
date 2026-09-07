package com.smaato.sdk.video.vast.buildlight;

import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.video.fi.NonNullConsumer;
import com.smaato.sdk.video.vast.model.VastTree;
import com.smaato.sdk.video.vast.parser.ParseResult;
import com.smaato.sdk.video.vast.parser.VastResponseParser;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes12.dex */
public class VastTreeBuilder {
    private final VastResponseParser vastResponseParser;
    private final WrapperResolver wrapperResolver;

    public VastTreeBuilder(VastResponseParser vastResponseParser, WrapperResolver wrapperResolver) {
        this.vastResponseParser = (VastResponseParser) Objects.requireNonNull(vastResponseParser);
        this.wrapperResolver = (WrapperResolver) Objects.requireNonNull(wrapperResolver);
    }

    public void buildVastTree(Logger logger, InputStream inputStream, String str, NonNullConsumer<VastResult<VastTree>> nonNullConsumer) {
        Objects.requireNonNull(logger);
        Objects.requireNonNull(inputStream);
        this.vastResponseParser.parseVastResponse(logger, inputStream, str, getParseResultConsumer(logger, nonNullConsumer));
    }

    private NonNullConsumer getParseResultConsumer(final Logger logger, final NonNullConsumer nonNullConsumer) {
        return new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.buildlight.VastTreeBuilder$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.video.fi.NonNullConsumer
            public final void accept(Object obj) {
                this.f$0.m5713xe58cc26(nonNullConsumer, logger, (ParseResult) obj);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: lambda$getParseResultConsumer$1$com-smaato-sdk-video-vast-buildlight-VastTreeBuilder, reason: not valid java name */
    /* synthetic */ void m5713xe58cc26(final NonNullConsumer nonNullConsumer, Logger logger, ParseResult parseResult) {
        final HashSet hashSet = new HashSet();
        VastTree vastTree = (VastTree) parseResult.value;
        if (vastTree != null) {
            if (vastTree.ads.isEmpty() && !parseResult.errors.isEmpty()) {
                nonNullConsumer.accept(VastResult.error((Set<Integer>) Collections.singleton(100)));
            }
            this.wrapperResolver.resolveWrappers(logger, vastTree, true, 0, new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.buildlight.VastTreeBuilder$$ExternalSyntheticLambda1
                @Override // com.smaato.sdk.video.fi.NonNullConsumer
                public final void accept(Object obj) {
                    VastTreeBuilder.lambda$getParseResultConsumer$0(hashSet, nonNullConsumer, (VastResult) obj);
                }
            });
            return;
        }
        nonNullConsumer.accept(VastResult.error((Set<Integer>) Collections.singleton(100)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$getParseResultConsumer$0(Set set, NonNullConsumer nonNullConsumer, VastResult vastResult) {
        VastResult.Builder builder = new VastResult.Builder();
        set.addAll(vastResult.errors);
        builder.setErrors(set).setResult((VastTree) vastResult.value);
        nonNullConsumer.accept(builder.build());
    }
}
