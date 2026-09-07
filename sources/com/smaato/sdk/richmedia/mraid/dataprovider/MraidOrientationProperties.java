package com.smaato.sdk.richmedia.mraid.dataprovider;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.richmedia.util.DeviceUtils;

/* JADX INFO: loaded from: classes13.dex */
public final class MraidOrientationProperties {
    public final boolean allowOrientationChange;
    public final DeviceUtils.ScreenOrientation forceOrientation;

    public MraidOrientationProperties(boolean z, DeviceUtils.ScreenOrientation screenOrientation) {
        this.allowOrientationChange = z;
        this.forceOrientation = (DeviceUtils.ScreenOrientation) Objects.requireNonNull(screenOrientation);
    }

    public static MraidOrientationProperties createDefault() {
        return new MraidOrientationProperties(true, DeviceUtils.ScreenOrientation.UNKNOWN);
    }
}
