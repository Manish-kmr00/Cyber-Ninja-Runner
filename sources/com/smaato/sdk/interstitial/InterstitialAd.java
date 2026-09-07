package com.smaato.sdk.interstitial;

import android.app.Activity;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes10.dex */
public abstract class InterstitialAd extends InterstitialAdBase {
    protected int backgroundColor = ViewCompat.MEASURED_STATE_MASK;

    protected abstract void showAdInternal(Activity activity);

    public void setBackgroundColor(int i) {
        this.backgroundColor = i;
    }

    public final void showAd(Activity activity) {
        showAdInternal(activity);
    }
}
