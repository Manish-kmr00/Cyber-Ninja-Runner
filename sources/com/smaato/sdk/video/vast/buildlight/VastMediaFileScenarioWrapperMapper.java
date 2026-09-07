package com.smaato.sdk.video.vast.buildlight;

import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.video.vast.model.Linear;
import com.smaato.sdk.video.vast.model.VastIconScenario;
import com.smaato.sdk.video.vast.model.VastRawMediaFileScenario;
import com.smaato.sdk.video.vast.model.VastScenarioCreativeData;
import com.smaato.sdk.video.vast.utils.VastVideoPlayerTimeConverterUtils;

/* JADX INFO: loaded from: classes12.dex */
public class VastMediaFileScenarioWrapperMapper {
    private final VastIconScenarioPicker vastIconScenarioPicker;

    public VastMediaFileScenarioWrapperMapper(VastIconScenarioPicker vastIconScenarioPicker) {
        this.vastIconScenarioPicker = (VastIconScenarioPicker) Objects.requireNonNull(vastIconScenarioPicker, "Parameter vastIconScenarioPicker should not be null for VastMediaFileScenarioMapper::new");
    }

    public VastRawMediaFileScenario mapMediaFileScenario(Logger logger, Linear linear, VastScenarioCreativeData vastScenarioCreativeData) {
        Objects.requireNonNull(logger);
        Objects.requireNonNull(vastScenarioCreativeData);
        VastIconScenario vastIconScenarioPickIconScenario = this.vastIconScenarioPicker.pickIconScenario(logger, linear.icons, false);
        long jConvertDurationStringToMilliseconds = VastVideoPlayerTimeConverterUtils.convertDurationStringToMilliseconds(linear.duration, logger);
        return new VastRawMediaFileScenario.Builder().setVastScenarioCreativeData(vastScenarioCreativeData).setVastIconScenario(vastIconScenarioPickIconScenario).setTrackingEvents(linear.trackingEvents).setVideoClicks(linear.videoClicks).setAdParameters(linear.adParameters).setSkipOffset(VastVideoPlayerTimeConverterUtils.convertOffsetStringToMilliseconds(linear.skipOffset, jConvertDurationStringToMilliseconds, logger)).setDuration(jConvertDurationStringToMilliseconds).build();
    }
}
