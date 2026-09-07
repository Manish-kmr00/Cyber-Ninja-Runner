package com.smaato.sdk.video.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: loaded from: classes5.dex */
public class AnimationHelper {
    private final long animationDurationMillis;

    public AnimationHelper(long j) {
        this.animationDurationMillis = j;
    }

    public void showWithAnim(View view) {
        view.setAlpha(0.0f);
        view.setVisibility(0);
        view.animate().alpha(1.0f).setDuration(this.animationDurationMillis).start();
    }

    public void hideWithAnim(final View view) {
        view.animate().alpha(0.0f).setDuration(this.animationDurationMillis).setListener(new AnimatorListenerAdapter() { // from class: com.smaato.sdk.video.utils.AnimationHelper.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setVisibility(8);
            }
        }).start();
    }
}
