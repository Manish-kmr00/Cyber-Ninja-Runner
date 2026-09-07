package com.smaato.sdk.interstitial;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SmaatoSplashActivity extends Activity {
    EventListener splashActivityEventListener = new AnonymousClass1();

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.v);
        p0.startActivity(p1);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.v, me);
        return super.dispatchTouchEvent(me);
    }

    protected abstract String getAdSpaceId();

    protected EventListener getEventListener() {
        return null;
    }

    protected abstract Class<? extends Activity> getNextActivity();

    /* JADX INFO: renamed from: com.smaato.sdk.interstitial.SmaatoSplashActivity$1, reason: invalid class name */
    class AnonymousClass1 implements EventListener {
        AnonymousClass1() {
        }

        @Override // com.smaato.sdk.interstitial.EventListener
        public void onAdLoaded(InterstitialAd interstitialAd) {
            SmaatoSplashActivity.this.findViewById(R.id.smaato_sdk_interstitial_loading).setVisibility(8);
            interstitialAd.showAdInternal(SmaatoSplashActivity.this);
        }

        @Override // com.smaato.sdk.interstitial.EventListener
        public void onAdFailedToLoad(final InterstitialRequestError interstitialRequestError) {
            SmaatoSplashActivity.this.findViewById(R.id.smaato_sdk_interstitial_loading).setVisibility(8);
            Objects.onNotNull(SmaatoSplashActivity.this.getEventListener(), new Consumer() { // from class: com.smaato.sdk.interstitial.SmaatoSplashActivity$1$$ExternalSyntheticLambda6
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((EventListener) obj).onAdFailedToLoad(interstitialRequestError);
                }
            });
            SmaatoSplashActivity.this.gotoNextActivity();
        }

        @Override // com.smaato.sdk.interstitial.EventListener
        public void onAdError(final InterstitialAd interstitialAd, final InterstitialError interstitialError) {
            SmaatoSplashActivity.this.findViewById(R.id.smaato_sdk_interstitial_loading).setVisibility(8);
            Objects.onNotNull(SmaatoSplashActivity.this.getEventListener(), new Consumer() { // from class: com.smaato.sdk.interstitial.SmaatoSplashActivity$1$$ExternalSyntheticLambda1
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((EventListener) obj).onAdError(interstitialAd, interstitialError);
                }
            });
            SmaatoSplashActivity.this.gotoNextActivity();
        }

        @Override // com.smaato.sdk.interstitial.EventListener
        public void onAdOpened(final InterstitialAd interstitialAd) {
            Objects.onNotNull(SmaatoSplashActivity.this.getEventListener(), new Consumer() { // from class: com.smaato.sdk.interstitial.SmaatoSplashActivity$1$$ExternalSyntheticLambda5
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((EventListener) obj).onAdOpened(interstitialAd);
                }
            });
        }

        @Override // com.smaato.sdk.interstitial.EventListener
        public void onAdClosed(final InterstitialAd interstitialAd) {
            Objects.onNotNull(SmaatoSplashActivity.this.getEventListener(), new Consumer() { // from class: com.smaato.sdk.interstitial.SmaatoSplashActivity$1$$ExternalSyntheticLambda4
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((EventListener) obj).onAdClosed(interstitialAd);
                }
            });
            SmaatoSplashActivity.this.gotoNextActivity();
        }

        @Override // com.smaato.sdk.interstitial.EventListener
        public void onAdClicked(final InterstitialAd interstitialAd) {
            Objects.onNotNull(SmaatoSplashActivity.this.getEventListener(), new Consumer() { // from class: com.smaato.sdk.interstitial.SmaatoSplashActivity$1$$ExternalSyntheticLambda2
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((EventListener) obj).onAdClicked(interstitialAd);
                }
            });
        }

        @Override // com.smaato.sdk.interstitial.EventListener
        public void onAdImpression(final InterstitialAd interstitialAd) {
            Objects.onNotNull(SmaatoSplashActivity.this.getEventListener(), new Consumer() { // from class: com.smaato.sdk.interstitial.SmaatoSplashActivity$1$$ExternalSyntheticLambda3
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((EventListener) obj).onAdImpression(interstitialAd);
                }
            });
        }

        @Override // com.smaato.sdk.interstitial.EventListener
        public void onAdTTLExpired(final InterstitialAd interstitialAd) {
            Objects.onNotNull(SmaatoSplashActivity.this.getEventListener(), new Consumer() { // from class: com.smaato.sdk.interstitial.SmaatoSplashActivity$1$$ExternalSyntheticLambda0
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((EventListener) obj).onAdTTLExpired(interstitialAd);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoNextActivity() {
        safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(this, new Intent(this, getNextActivity()));
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.smaato_sdk_interstitial_splash_activity);
        findViewById(R.id.smaato_sdk_interstitial_loading).setVisibility(0);
        Interstitial.loadAd(getAdSpaceId(), this.splashActivityEventListener, null, true);
    }
}
