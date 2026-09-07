package com.bytedance.sdk.openadsdk.component.reward.top;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public interface pA<T extends View> {
    void clickSkip();

    void clickSound();

    View getCloseButton();

    void setListener(Og og);

    void setShowDislike(boolean z);

    void setShowSkip(boolean z);

    void setShowSound(boolean z);

    void setSkipEnable(boolean z);

    void setSkipInvisiable();

    void setSkipText(CharSequence charSequence);

    void setSoundMute(boolean z);

    void setTime(CharSequence charSequence, CharSequence charSequence2);

    void showCloseButton();

    void showCountDownText();

    void showSkipButton();
}
