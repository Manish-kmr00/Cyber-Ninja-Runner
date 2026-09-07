package com.smaato.sdk.core.openmeasurement;

import android.content.Context;
import com.smaato.sdk.core.di.DiRegistry;

/* JADX INFO: loaded from: classes13.dex */
public interface ViewabilityPlugin {
    DiRegistry diRegistry();

    String getName();

    void init(Context context);
}
