package com.smaato.sdk.video.vast.buildlight;

import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.collections.Lists;
import com.smaato.sdk.core.util.fi.NullableFunction;
import com.smaato.sdk.video.fi.NonNullConsumer;
import com.smaato.sdk.video.vast.exceptions.wrapper.GeneralWrapperErrorException;
import com.smaato.sdk.video.vast.model.VastTree;
import com.smaato.sdk.video.vast.model.Wrapper;
import com.smaato.sdk.video.vast.parser.ParseError;
import com.smaato.sdk.video.vast.parser.ParseResult;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class WrapperResolver {
    private final InLineChecker inLineChecker;
    private final int maxDepth;
    private final WrapperAdContainerPicker wrapperAdContainerPicker;
    private final WrapperLoader wrapperLoader;

    public WrapperResolver(int i, WrapperLoader wrapperLoader, InLineChecker inLineChecker, WrapperAdContainerPicker wrapperAdContainerPicker) {
        if (i < 0) {
            throw new IllegalArgumentException("Cannot construct WrapperResolver: maxDepth can't be negative");
        }
        this.inLineChecker = inLineChecker;
        this.wrapperAdContainerPicker = wrapperAdContainerPicker;
        this.maxDepth = i;
        this.wrapperLoader = wrapperLoader;
    }

    void resolveWrappers(final Logger logger, final VastTree vastTree, boolean z, final int i, final NonNullConsumer<VastResult<VastTree>> nonNullConsumer) {
        VastResult.Builder result = new VastResult.Builder().setResult(vastTree);
        if (vastTree.ads.isEmpty()) {
            result.setErrors(Collections.singleton(303));
            nonNullConsumer.accept(result.build());
            logger.debug(LogDomain.VIDEO, "NO Ad, Response has Empty Vast Tag", new Object[0]);
            return;
        }
        if (this.inLineChecker.hasInLine(vastTree.ads)) {
            nonNullConsumer.accept(result.build());
            return;
        }
        if (!z) {
            result.setErrors(Collections.singleton(303));
            nonNullConsumer.accept(result.build());
            return;
        }
        final AdContainer<Wrapper> adContainerPickWrapperContainer = this.wrapperAdContainerPicker.pickWrapperContainer(vastTree.ads);
        if (adContainerPickWrapperContainer == null) {
            result.setErrors(Collections.singleton(303));
            nonNullConsumer.accept(result.build());
        } else if (i > this.maxDepth) {
            result.setErrors(Collections.singleton(302));
            nonNullConsumer.accept(result.build());
        } else {
            this.wrapperLoader.loadWrapper(logger, adContainerPickWrapperContainer.model.vastAdTagUri, new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.buildlight.WrapperResolver$$ExternalSyntheticLambda3
                @Override // com.smaato.sdk.video.fi.NonNullConsumer
                public final void accept(Object obj) {
                    this.f$0.m5715x17c9390c(logger, adContainerPickWrapperContainer, i, nonNullConsumer, vastTree, (ParseResult) obj);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$resolveWrappers$1$com-smaato-sdk-video-vast-buildlight-WrapperResolver, reason: not valid java name */
    /* synthetic */ void m5715x17c9390c(Logger logger, final AdContainer adContainer, int i, final NonNullConsumer nonNullConsumer, final VastTree vastTree, ParseResult parseResult) {
        checkLoadResultAndResolveIfNeeded(logger, adContainer, parseResult, i, new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.buildlight.WrapperResolver$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.video.fi.NonNullConsumer
            public final void accept(Object obj) {
                this.f$0.m5714xfdadba6d(nonNullConsumer, vastTree, adContainer, (VastResult) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$resolveWrappers$0$com-smaato-sdk-video-vast-buildlight-WrapperResolver, reason: not valid java name */
    /* synthetic */ void m5714xfdadba6d(NonNullConsumer nonNullConsumer, VastTree vastTree, AdContainer adContainer, VastResult vastResult) {
        nonNullConsumer.accept(mergeWrapperResolvedResult(vastResult, vastTree, adContainer));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private VastResult mergeWrapperResolvedResult(VastResult vastResult, VastTree vastTree, AdContainer adContainer) {
        VastResult.Builder builder = new VastResult.Builder();
        HashSet hashSet = new HashSet(vastResult.errors);
        builder.setErrors(hashSet);
        VastTree vastTree2 = (VastTree) vastResult.value;
        if (vastTree2 == null) {
            hashSet.add(303);
            builder.setResult(vastTree);
        } else {
            builder.setResult(ResolvedWrapperMergeUtils.mergeParsedResultWithParents(vastTree2, vastTree, adContainer));
        }
        return builder.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void checkLoadResultAndResolveIfNeeded(Logger logger, AdContainer adContainer, final ParseResult parseResult, int i, final NonNullConsumer nonNullConsumer) {
        final VastResult.Builder builder = new VastResult.Builder();
        final HashSet hashSet = new HashSet();
        builder.setErrors(hashSet);
        if (!parseResult.errors.isEmpty()) {
            hashSet.addAll(Lists.mapLazy(parseResult.errors, new NullableFunction() { // from class: com.smaato.sdk.video.vast.buildlight.WrapperResolver$$ExternalSyntheticLambda0
                @Override // com.smaato.sdk.core.util.fi.NullableFunction
                public final Object apply(Object obj) {
                    return WrapperResolver.lambda$checkLoadResultAndResolveIfNeeded$2((ParseError) obj);
                }
            }));
            hashSet.remove(null);
        }
        Result result = parseResult.value;
        if (result == 0) {
            if (!parseResult.errors.isEmpty()) {
                hashSet.add(100);
            }
            nonNullConsumer.accept(builder.build());
            return;
        }
        resolveWrappers(logger, (VastTree) result, ((Wrapper) adContainer.model).followAdditionalWrappers, i + 1, new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.buildlight.WrapperResolver$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.video.fi.NonNullConsumer
            public final void accept(Object obj) {
                WrapperResolver.lambda$checkLoadResultAndResolveIfNeeded$3(hashSet, builder, parseResult, nonNullConsumer, (VastResult) obj);
            }
        });
    }

    static /* synthetic */ Integer lambda$checkLoadResultAndResolveIfNeeded$2(ParseError parseError) {
        return (parseError == null ? null : parseError.exception) instanceof GeneralWrapperErrorException ? 300 : null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$checkLoadResultAndResolveIfNeeded$3(Set set, VastResult.Builder builder, ParseResult parseResult, NonNullConsumer nonNullConsumer, VastResult vastResult) {
        set.addAll(vastResult.errors);
        Result result = vastResult.value;
        if (result != 0) {
            builder.setResult((VastTree) result);
        } else {
            builder.setResult((VastTree) parseResult.value);
        }
        nonNullConsumer.accept(builder.build());
    }
}
