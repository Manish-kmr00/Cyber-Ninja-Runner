package com.pubmatic.sdk.nativead;

import android.view.View;

/* JADX INFO: loaded from: classes13.dex */
public interface POBNativeAdViewListener {
    void onAssetClicked(View view, int i);

    void onNonAssetClicked(View view, String str);

    void onRecordClick(View view);

    void onRecordImpression(View view);
}
