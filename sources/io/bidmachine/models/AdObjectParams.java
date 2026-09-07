package io.bidmachine.models;

import com.explorestack.protobuf.Value;
import com.explorestack.protobuf.adcom.Ad;
import io.bidmachine.TrackEventType;
import io.bidmachine.core.Utils;
import io.bidmachine.core.VisibilityParams;
import io.bidmachine.protobuf.AdExtension;
import io.bidmachine.protobuf.rendering.Rendering;
import io.bidmachine.unified.AdObjectMediationParams;
import io.bidmachine.unified.UnifiedMediationParams;
import io.bidmachine.utils.ProtoUtils;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public abstract class AdObjectParams {
    private final VisibilityParams visibilityParams = new VisibilityParams();
    private final Map<TrackEventType, List<String>> trackUrls = new EnumMap(TrackEventType.class);
    private final AdObjectMediationParams unifiedMediationParams = new AdObjectMediationParams();

    public abstract boolean isValid();

    public AdObjectParams(Ad ad) {
        AdExtension adExtensionFindFirstAdExtension = ProtoUtils.findFirstAdExtension(ad);
        if (adExtensionFindFirstAdExtension != null) {
            prepareExtensions(adExtensionFindFirstAdExtension);
        }
        prepareExtensions(ad.getExt().getFieldsMap());
    }

    public VisibilityParams getVisibilityParams() {
        return this.visibilityParams;
    }

    public List<String> getTrackUrls(TrackEventType trackEventType) {
        return this.trackUrls.get(trackEventType);
    }

    public UnifiedMediationParams getMediationParams() {
        return this.unifiedMediationParams;
    }

    public Map<String, Object> getData() {
        return this.unifiedMediationParams.getParams();
    }

    protected void prepareExtensions(AdExtension adExtension) {
        this.visibilityParams.setTimeThresholdSec(Utils.getOrDefault(adExtension.getViewabilityTimeThreshold(), AdExtension.getDefaultInstance().getViewabilityTimeThreshold(), 1L));
        this.visibilityParams.setPixelThreshold(Utils.getOrDefault(adExtension.getViewabilityPixelThreshold(), AdExtension.getDefaultInstance().getViewabilityPixelThreshold(), 1.0f));
        this.visibilityParams.setIgnoreWindowFocus(adExtension.getViewabilityIgnoreWindowFocus());
        this.visibilityParams.setIgnoreOverlap(adExtension.getViewabilityIgnoreOverlap());
        prepareEvents(adExtension.getEventList());
        getData().put(UnifiedMediationParams.KEY_VIEWABILITY_TIME_THRESHOLD_SEC, Integer.valueOf(adExtension.getViewabilityTimeThreshold()));
        getData().put(UnifiedMediationParams.KEY_VIEWABILITY_PIXEL_THRESHOLD, Float.valueOf(adExtension.getViewabilityPixelThreshold()));
        getData().put(UnifiedMediationParams.KEY_VIEWABILITY_IGNORE_WINDOW_FOCUS, Boolean.valueOf(adExtension.getViewabilityIgnoreWindowFocus()));
        getData().put(UnifiedMediationParams.KEY_VIEWABILITY_IGNORE_OVERLAP, Boolean.valueOf(adExtension.getViewabilityIgnoreOverlap()));
        getData().put(UnifiedMediationParams.KEY_USE_NATIVE_CLOSE, Boolean.valueOf(adExtension.getUseNativeClose()));
        getData().put(UnifiedMediationParams.KEY_CACHE_CONTROL, adExtension.getCreativeLoadingMethod());
        getData().put(UnifiedMediationParams.KEY_PLACEHOLDER_TIMEOUT_SEC, Float.valueOf(adExtension.getPlaceholderTimeout()));
        getData().put(UnifiedMediationParams.KEY_SKIP_OFFSET, Integer.valueOf(adExtension.getSkipoffset()));
        getData().put(UnifiedMediationParams.KEY_COMPANION_SKIP_OFFSET, Integer.valueOf(adExtension.getCompanionSkipoffset()));
        getData().put(UnifiedMediationParams.KEY_R1, Boolean.valueOf(adExtension.getR1()));
        getData().put(UnifiedMediationParams.KEY_R2, Boolean.valueOf(adExtension.getR2()));
        getData().put(UnifiedMediationParams.KEY_STORE_URL, adExtension.getStoreUrl());
        getData().put(UnifiedMediationParams.KEY_PROGRESS_DURATION, Integer.valueOf(adExtension.getProgressDuration()));
        AdExtension.ControlAsset closeButton = adExtension.getCloseButton();
        if (closeButton != null && closeButton != AdExtension.ControlAsset.getDefaultInstance()) {
            getData().put(UnifiedMediationParams.KEY_CLOSE_BUTTON_CONTROL_ASSET, closeButton);
        }
        AdExtension.ControlAsset countdown = adExtension.getCountdown();
        if (countdown != null && countdown != AdExtension.ControlAsset.getDefaultInstance()) {
            getData().put(UnifiedMediationParams.KEY_COUNTDOWN_CONTROL_ASSET, countdown);
        }
        AdExtension.ControlAsset progress = adExtension.getProgress();
        if (progress != null && progress != AdExtension.ControlAsset.getDefaultInstance()) {
            getData().put(UnifiedMediationParams.KEY_PROGRESS_CONTROL_ASSET, progress);
        }
        Rendering renderingConfiguration = adExtension.getRenderingConfiguration();
        if (renderingConfiguration == null || renderingConfiguration == Rendering.getDefaultInstance()) {
            return;
        }
        getData().put(UnifiedMediationParams.KEY_RENDERING_CONFIGURATION, renderingConfiguration);
    }

    protected void prepareExtensions(Map<String, Value> map) {
        Value value = map.get(UnifiedMediationParams.KEY_OM_SDK_ENABLED);
        if (value != null) {
            getData().put(UnifiedMediationParams.KEY_OM_SDK_ENABLED, Boolean.valueOf(value.getBoolValue()));
        }
    }

    protected void prepareEvents(List<Ad.Event> list) {
        ProtoUtils.prepareEvents(this.trackUrls, list);
    }

    protected void addEvent(TrackEventType trackEventType, String str) {
        ProtoUtils.addEvent(this.trackUrls, trackEventType, str);
    }
}
