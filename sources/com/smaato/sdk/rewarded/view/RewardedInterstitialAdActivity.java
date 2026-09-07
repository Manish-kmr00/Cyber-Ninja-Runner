package com.smaato.sdk.rewarded.view;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.interstitial.view.InterstitialAdActivity;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class RewardedInterstitialAdActivity extends InterstitialAdActivity {
    @Override // com.smaato.sdk.interstitial.view.InterstitialAdActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.v, me);
        return super.dispatchTouchEvent(me);
    }

    public static Intent createIntent(Context context, UUID uuid) {
        Objects.requireNonNull(context);
        Objects.requireNonNull(uuid);
        return new Intent(context, (Class<?>) RewardedInterstitialAdActivity.class).putExtra("KEY_PRESENTER_UUID", uuid).putExtra("KEY_BACKGROUND_COLOR", 0).putExtra("KEY_IS_SPLASH", false).addFlags(268435456);
    }
}
