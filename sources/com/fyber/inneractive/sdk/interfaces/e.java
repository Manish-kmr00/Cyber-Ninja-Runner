package com.fyber.inneractive.sdk.interfaces;

import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.config.enums.Orientation;

/* JADX INFO: loaded from: classes11.dex */
public interface e {
    void destroy();

    void disableCloseButton();

    void dismissAd(boolean z);

    View getCloseButton();

    ViewGroup getLayout();

    boolean isCloseButtonDisplay();

    void secondEndCardWasDisplayed();

    void setActivityOrientation(boolean z, Orientation orientation);

    void showCloseButton(boolean z, int i, int i2);

    void showCloseCountdown();

    void updateCloseCountdown(int i);

    boolean wasDismissedByUser();
}
