package com.smaato.sdk.richmedia.mraid.bridge;

import android.graphics.Rect;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.richmedia.mraid.MraidUtils;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidAudioVolumeLevel;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidExposureProperties;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidStateMachineFactory;
import com.smaato.sdk.richmedia.util.RectUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class MraidJsEvents {
    public static final String AUDIO_VOLUME_CHANGE = "audioVolumeChange";
    public static final String EXPOSURE_CHANGE = "exposureChange";
    private final MraidJsBridge jsBridge;
    private final Logger logger;

    public MraidJsEvents(Logger logger, MraidJsBridge mraidJsBridge) {
        this.logger = (Logger) Objects.requireNonNull(logger);
        this.jsBridge = (MraidJsBridge) Objects.requireNonNull(mraidJsBridge);
    }

    public void fireExposureChangeEvent(MraidExposureProperties mraidExposureProperties) {
        if (mraidExposureProperties.isEmpty()) {
            return;
        }
        this.jsBridge.runScript(MraidUtils.format("window.mraidbridge.fireExposureChangeEvent(%.2f, %s, %s);", Float.valueOf(mraidExposureProperties.exposedPercentage), RectUtils.rectToString(mraidExposureProperties.visibleRectangleInDp), "null"));
    }

    public void fireAudioVolumeChangeEvent(MraidAudioVolumeLevel mraidAudioVolumeLevel) {
        this.jsBridge.runScript(MraidUtils.format("window.mraidbridge.fireAudioVolumeChangeEvent(%s);", mraidAudioVolumeLevel.getAudioVolumeLevel()));
    }

    public void fireErrorEvent(String str, String str2) {
        this.jsBridge.runScript(MraidUtils.format("window.mraidbridge.fireErrorEvent('%s', '%s');", str2, str));
    }

    public void fireStateChangeEvent(MraidStateMachineFactory.State state) {
        try {
            this.jsBridge.runScript(MraidUtils.format("window.mraidbridge.fireStateChangeEvent('%s');", PropertiesUtils.stateToString(state)));
        } catch (IllegalArgumentException e) {
            this.logger.error(LogDomain.MRAID, "Failed to call MRAID's fireStateChangeEvent method, reason: " + e.getMessage(), new Object[0]);
        }
    }

    public void fireSizeChangeEvent(Rect rect) {
        this.jsBridge.runScript(MraidUtils.format("window.mraidbridge.fireSizeChangeEvent(%d, %d);", Integer.valueOf(rect.width()), Integer.valueOf(rect.height())));
    }

    public void fireViewableChangeEvent(boolean z) {
        this.jsBridge.runScript(MraidUtils.format("window.mraidbridge.fireViewableChangeEvent(%b);", Boolean.valueOf(z)));
    }
}
