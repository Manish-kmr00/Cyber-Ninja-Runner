package com.pubmatic.sdk.common.viewability;

import android.view.View;
import com.pubmatic.sdk.common.POBDataType;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface POBVideoMeasurementProvider extends POBMeasurementProvider {

    public interface POBOmidSessionListener {
        void onOmidSessionInitialized();
    }

    public enum POBVideoAdErrorType {
        GENERIC,
        VIDEO
    }

    public enum POBVideoPlayerState {
        FULLSCREEN,
        MINIMIZED,
        COLLAPSED,
        NORMAL,
        EXPANDED
    }

    void impressionOccurred();

    void loaded(boolean z, float f);

    void signalAdEvent(POBDataType.POBVideoAdEventType pOBVideoAdEventType);

    void signalError(POBVideoAdErrorType pOBVideoAdErrorType, String str);

    void signalPlayerStateChange(POBVideoPlayerState pOBVideoPlayerState);

    void start(float f, float f2);

    void startAdSession(View view, List<POBVerificationScriptResource> list, POBOmidSessionListener pOBOmidSessionListener);
}
