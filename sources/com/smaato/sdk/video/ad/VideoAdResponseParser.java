package com.smaato.sdk.video.ad;

import android.app.Application;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.smaato.sdk.core.ad.AdType;
import com.smaato.sdk.core.api.ApiParams;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.mvvm.model.AdResponse;
import com.smaato.sdk.core.mvvm.model.AdResponseParser;
import com.smaato.sdk.core.mvvm.model.video.VideoResourceCache;
import com.smaato.sdk.core.util.HeaderValueUtils;
import com.smaato.sdk.core.util.Threads;
import com.smaato.sdk.video.fi.NonNullConsumer;
import com.smaato.sdk.video.vast.buildlight.VastConfigurationSettings;
import com.smaato.sdk.video.vast.buildlight.VastResult;
import com.smaato.sdk.video.vast.buildlight.VastScenarioPicker;
import com.smaato.sdk.video.vast.buildlight.VastScenarioResult;
import com.smaato.sdk.video.vast.buildlight.VastTreeBuilder;
import com.smaato.sdk.video.vast.exceptions.VastElementMissingException;
import com.smaato.sdk.video.vast.model.Delivery;
import com.smaato.sdk.video.vast.model.MediaFile;
import com.smaato.sdk.video.vast.model.VastScenario;
import com.smaato.sdk.video.vast.model.VastTree;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes11.dex */
public class VideoAdResponseParser extends AdResponseParser {
    ApiParams apiParams;
    Application application;
    boolean isClickable;
    boolean isSkippable;
    Logger logger;
    VastScenarioPicker vastScenarioPicker;
    VastTreeBuilder vastTreeBuilder;
    private final VideoResourceCache videoResourceCache;

    public VideoAdResponseParser(HeaderValueUtils headerValueUtils, VastTreeBuilder vastTreeBuilder, VastScenarioPicker vastScenarioPicker, boolean z, boolean z2, VideoResourceCache videoResourceCache, ApiParams apiParams, Application application, Logger logger) {
        super(AdType.VIDEO, headerValueUtils);
        this.vastTreeBuilder = vastTreeBuilder;
        this.vastScenarioPicker = vastScenarioPicker;
        this.isSkippable = z;
        this.isClickable = z2;
        this.videoResourceCache = videoResourceCache;
        this.apiParams = apiParams;
        this.application = application;
        this.logger = logger;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.smaato.sdk.core.mvvm.model.AdResponseParser
    protected AdResponse parseResponse(AdResponse.Builder builder, String str, long j) throws IOException {
        VastResult vastTree = parseVastTree(str);
        HashSet hashSet = new HashSet(vastTree.errors);
        Result result = vastTree.value;
        if (result == 0) {
            throw new AdResponseParser.ParsingException("Failed: VAST parse result is empty", null);
        }
        VastScenarioResult vastScenarioResultMapVastScenario = mapVastScenario((VastTree) result);
        hashSet.addAll(vastScenarioResultMapVastScenario.errors);
        VastScenario vastScenarioPreloadMediaFile = vastScenarioResultMapVastScenario.vastScenario;
        if (vastScenarioPreloadMediaFile != null) {
            vastScenarioPreloadMediaFile = preloadMediaFile(vastScenarioPreloadMediaFile, j);
        }
        return builder.setVastObject(new VastParsingResult(vastScenarioPreloadMediaFile, hashSet, vastScenarioResultMapVastScenario.errorUrls)).setWidth(0).setHeight(0).setImpressionTrackingUrls(new ArrayList()).setClickTrackingUrls(new ArrayList()).build();
    }

    private VastResult parseVastTree(String str) throws AdResponseParser.ParsingException {
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
        final ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
        Threads.runOnBackgroundThread(new Runnable() { // from class: com.smaato.sdk.video.ad.VideoAdResponseParser$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5705xefe6e34d(byteArrayInputStream, arrayBlockingQueue);
            }
        });
        try {
            VastResult vastResult = (VastResult) arrayBlockingQueue.take();
            if (vastResult.value != 0) {
                return vastResult;
            }
            throw new AdResponseParser.ParsingException("Failed to parse VAST file: VAST parse result is empty", null);
        } catch (InterruptedException e) {
            throw new AdResponseParser.ParsingException("Failed to parse VAST file: Parsing thread was interrupted", e);
        }
    }

    /* JADX INFO: renamed from: lambda$parseVastTree$0$com-smaato-sdk-video-ad-VideoAdResponseParser, reason: not valid java name */
    /* synthetic */ void m5705xefe6e34d(InputStream inputStream, final BlockingQueue blockingQueue) {
        VastTreeBuilder vastTreeBuilder = this.vastTreeBuilder;
        Logger logger = this.logger;
        Objects.requireNonNull(blockingQueue);
        vastTreeBuilder.buildVastTree(logger, inputStream, "UTF-8", new NonNullConsumer() { // from class: com.smaato.sdk.video.ad.VideoAdResponseParser$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.video.fi.NonNullConsumer
            public final void accept(Object obj) {
                blockingQueue.add((VastResult) obj);
            }
        });
    }

    private VastScenario preloadMediaFile(VastScenario vastScenario, long j) {
        MediaFile mediaFile = vastScenario.vastMediaFileScenario.mediaFile;
        if (mediaFile.delivery != Delivery.PROGRESSIVE) {
            return vastScenario;
        }
        try {
            return createUpdatedVastScenario(vastScenario, this.videoResourceCache.getResource(mediaFile.url, System.currentTimeMillis() + j).toString());
        } catch (Exception unused) {
            return createUpdatedVastScenario(vastScenario, MediaFile.URL_DOWNLOAD_FAILED);
        }
    }

    private VastScenario createUpdatedVastScenario(VastScenario vastScenario, String str) {
        try {
            return vastScenario.newBuilder().setVastMediaFileScenario(vastScenario.vastMediaFileScenario.newBuilder().setMediaFile(vastScenario.vastMediaFileScenario.mediaFile.newBuilder().setUrl(str).build()).build()).build();
        } catch (VastElementMissingException e) {
            this.logger.error(LogDomain.VIDEO, "Error while updating VastScenario", e);
            return vastScenario;
        }
    }

    private VastScenarioResult mapVastScenario(VastTree vastTree) {
        String connectionType = this.apiParams.getConnectionType();
        int i = this.application.getResources().getDisplayMetrics().widthPixels;
        int i2 = this.application.getResources().getDisplayMetrics().heightPixels;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        if (i == 0) {
            i = displayMetrics.widthPixels;
        }
        if (i2 == 0) {
            i2 = displayMetrics.heightPixels;
        }
        return this.vastScenarioPicker.pickVastScenario(this.logger, vastTree, new VastConfigurationSettings(i, i2, connectionType));
    }
}
