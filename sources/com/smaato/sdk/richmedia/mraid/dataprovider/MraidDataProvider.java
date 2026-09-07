package com.smaato.sdk.richmedia.mraid.dataprovider;

import android.content.Context;
import android.graphics.Rect;
import com.smaato.sdk.core.SdkConfiguration;
import com.smaato.sdk.core.ad.RequestInfoMapper;
import com.smaato.sdk.core.ad.RequestInfoProvider;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.Size;
import com.smaato.sdk.core.util.UIUtils;
import com.smaato.sdk.core.util.collections.Lists;
import com.smaato.sdk.core.util.notifier.ChangeSender;
import com.smaato.sdk.core.util.notifier.ChangeSenderUtils;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class MraidDataProvider {
    private final ChangeSender audioVolumeChangeSender;
    private final ChangeSender currentPositionInDpChangeSender;
    private final ChangeSender defaultPositionInDpChangeSender;
    private final ChangeSender exposureChangeSender;
    private final ChangeSender locationPropertiesSender;
    private final ChangeSender maxSizeInDpChangeSender;
    private final ChangeSender orientationChangeSender;
    private final PlacementType placementType;
    private final ChangeSender screenSizeInDpSender;
    private final ChangeSender stateChangeSender;
    private final ChangeSender supportedFeaturesChangeSender;
    private final ChangeSender viewableChange;

    public MraidDataProvider(Context context, PlacementType placementType, MraidStateMachineFactory.State state, RequestInfoProvider requestInfoProvider, SdkConfiguration sdkConfiguration, List<String> list, RequestInfoMapper requestInfoMapper, MusicPlaybackVolume musicPlaybackVolume) {
        Objects.requireNonNull(context);
        Objects.requireNonNull(requestInfoProvider);
        Objects.requireNonNull(sdkConfiguration);
        Objects.requireNonNull(list);
        this.placementType = (PlacementType) Objects.requireNonNull(placementType);
        this.supportedFeaturesChangeSender = ChangeSenderUtils.createUniqueValueChangeSender(Lists.toImmutableList((Collection) list));
        this.exposureChangeSender = ChangeSenderUtils.createUniqueValueChangeSender(MraidExposureProperties.empty());
        this.orientationChangeSender = ChangeSenderUtils.createUniqueValueChangeSender(MraidAppOrientation.from(context));
        this.defaultPositionInDpChangeSender = ChangeSenderUtils.createUniqueValueChangeSender(new Rect());
        this.currentPositionInDpChangeSender = ChangeSenderUtils.createUniqueValueChangeSender(new Rect());
        this.maxSizeInDpChangeSender = ChangeSenderUtils.createUniqueValueChangeSender(new Rect());
        Size displaySizeInDp = UIUtils.getDisplaySizeInDp(context);
        this.screenSizeInDpSender = ChangeSenderUtils.createUniqueValueChangeSender(new Rect(0, 0, displaySizeInDp.width, displaySizeInDp.height));
        this.audioVolumeChangeSender = ChangeSenderUtils.createUniqueValueChangeSender(MraidAudioVolumeLevel.create(musicPlaybackVolume.getCurrentVolume(), musicPlaybackVolume.getMaxVolume()));
        this.stateChangeSender = ChangeSenderUtils.createUniqueValueChangeSender(state);
        this.locationPropertiesSender = ChangeSenderUtils.createUniqueValueChangeSender(MraidLocationProperties.create(requestInfoProvider, sdkConfiguration, requestInfoMapper));
        this.viewableChange = ChangeSenderUtils.createUniqueValueChangeSender(Boolean.FALSE);
    }

    public ChangeSender<MraidAppOrientation> getOrientationChangeSender() {
        return this.orientationChangeSender;
    }

    public ChangeSender<MraidExposureProperties> getExposureChangeSender() {
        return this.exposureChangeSender;
    }

    public ChangeSender<Rect> getDefaultPositionInDpChangeSender() {
        return this.defaultPositionInDpChangeSender;
    }

    public ChangeSender<Rect> getCurrentPositionInDpChangeSender() {
        return this.currentPositionInDpChangeSender;
    }

    public ChangeSender<Rect> getMaxSizeInDpChangeSender() {
        return this.maxSizeInDpChangeSender;
    }

    public ChangeSender<Rect> getScreenSizeInDpSender() {
        return this.screenSizeInDpSender;
    }

    public ChangeSender<MraidAudioVolumeLevel> getAudioVolumeChangeSender() {
        return this.audioVolumeChangeSender;
    }

    public ChangeSender<MraidStateMachineFactory.State> getStateChangeSender() {
        return this.stateChangeSender;
    }

    public ChangeSender<MraidLocationProperties> getLocationPropertiesSender() {
        return this.locationPropertiesSender;
    }

    public PlacementType getPlacementType() {
        return this.placementType;
    }

    public ChangeSender<List<String>> getSupportedFeatures() {
        return this.supportedFeaturesChangeSender;
    }

    public ChangeSender<Boolean> getViewableChangeSender() {
        return this.viewableChange;
    }
}
