package com.smaato.sdk.video.vast.buildlight;

import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.video.vast.model.Linear;
import com.smaato.sdk.video.vast.model.MediaFile;
import com.smaato.sdk.video.vast.model.VastIconScenario;
import com.smaato.sdk.video.vast.model.VastMediaFileScenario;
import com.smaato.sdk.video.vast.model.VastScenarioCreativeData;
import com.smaato.sdk.video.vast.utils.VastVideoPlayerTimeConverterUtils;

/* JADX INFO: loaded from: classes13.dex */
public class VastMediaFileScenarioMapper {
    private final VastIconScenarioPicker vastIconScenarioPicker;

    public VastMediaFileScenarioMapper(VastIconScenarioPicker vastIconScenarioPicker) {
        this.vastIconScenarioPicker = (VastIconScenarioPicker) Objects.requireNonNull(vastIconScenarioPicker, "Parameter vastIconScenarioPicker should not be null for VastMediaFileScenarioMapper::new");
    }

    VastMediaFileScenario mapMediaFileScenario(Logger logger, MediaFile mediaFile, Linear linear, VastScenarioCreativeData vastScenarioCreativeData) {
        Objects.requireNonNull(linear);
        Objects.requireNonNull(mediaFile);
        Objects.requireNonNull(linear);
        Objects.requireNonNull(vastScenarioCreativeData);
        VastIconScenario vastIconScenarioPickIconScenario = this.vastIconScenarioPicker.pickIconScenario(logger, linear.icons, false);
        long jConvertDurationStringToMilliseconds = VastVideoPlayerTimeConverterUtils.convertDurationStringToMilliseconds(linear.duration, logger);
        return new VastMediaFileScenario.Builder().setVastScenarioCreativeData(vastScenarioCreativeData).setTrackingEvents(linear.trackingEvents).setMediaFile(mediaFile).setVastIconScenario(vastIconScenarioPickIconScenario).setVideoClicks(linear.videoClicks).setAdParameters(linear.adParameters).setSkipOffset(VastVideoPlayerTimeConverterUtils.convertOffsetStringToMilliseconds(linear.skipOffset, jConvertDurationStringToMilliseconds, logger)).setDuration(jConvertDurationStringToMilliseconds).build();
    }
}
