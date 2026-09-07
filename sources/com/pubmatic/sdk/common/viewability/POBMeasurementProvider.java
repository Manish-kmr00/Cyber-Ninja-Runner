package com.pubmatic.sdk.common.viewability;

import android.content.Context;
import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public interface POBMeasurementProvider extends POBObstructionUpdateListener {

    public interface POBScriptListener {
        public static final int SCRIPT_LOADING_ERROR = 1;

        @Retention(RetentionPolicy.SOURCE)
        public @interface POBScriptError {
        }

        void onFailedToReceiveMeasurementScript(int i);

        void onMeasurementScriptReceived(String str);
    }

    void finishAdSession();

    String omSDKVersion();

    void omidJsServiceScript(Context context, POBScriptListener pOBScriptListener);

    void setTrackView(View view);
}
