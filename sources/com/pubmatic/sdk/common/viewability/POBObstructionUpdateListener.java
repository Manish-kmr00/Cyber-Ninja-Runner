package com.pubmatic.sdk.common.viewability;

import android.view.View;

/* JADX INFO: loaded from: classes5.dex */
public interface POBObstructionUpdateListener {

    public enum POBFriendlyObstructionPurpose {
        VIDEO_CONTROLS,
        CLOSE_AD,
        NOT_VISIBLE,
        OTHER
    }

    void addFriendlyObstructions(View view, POBFriendlyObstructionPurpose pOBFriendlyObstructionPurpose);

    void removeFriendlyObstructions(View view);
}
