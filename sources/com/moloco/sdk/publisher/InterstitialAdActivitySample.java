package com.moloco.sdk.publisher;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MotionEvent;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/moloco/sdk/publisher/InterstitialAdActivitySample;", "Landroid/app/Activity;", "()V", "interstitialAd", "Lcom/moloco/sdk/publisher/InterstitialAd;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "persistentState", "Landroid/os/PersistableBundle;", "onDestroy", "moloco-sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class InterstitialAdActivitySample extends Activity {
    private InterstitialAd interstitialAd;

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.D, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Moloco.createInterstitial$default("MOLOCO_ADUNIT_ID", null, new Function2<InterstitialAd, MolocoAdError.AdCreateError, Unit>() { // from class: com.moloco.sdk.publisher.InterstitialAdActivitySample.onCreate.1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(InterstitialAd interstitialAd, MolocoAdError.AdCreateError adCreateError) {
                invoke2(interstitialAd, adCreateError);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InterstitialAd interstitialAd, MolocoAdError.AdCreateError adCreateError) {
                if (interstitialAd == null) {
                    InterstitialAdActivitySample.this.finish();
                    return;
                }
                InterstitialAdActivitySample.this.interstitialAd = interstitialAd;
                interstitialAd.load("bid response", new AdLoad.Listener() { // from class: com.moloco.sdk.publisher.InterstitialAdActivitySample.onCreate.1.1
                    @Override // com.moloco.sdk.publisher.AdLoad.Listener
                    public void onAdLoadFailed(MolocoAdError molocoAdError) {
                        Intrinsics.checkNotNullParameter(molocoAdError, "molocoAdError");
                        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
                    }

                    @Override // com.moloco.sdk.publisher.AdLoad.Listener
                    public void onAdLoadSuccess(MolocoAd molocoAd) {
                        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
                        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
                    }
                });
                interstitialAd.isLoaded();
                interstitialAd.show(new InterstitialAdShowListener() { // from class: com.moloco.sdk.publisher.InterstitialAdActivitySample.onCreate.1.2
                    @Override // com.moloco.sdk.publisher.AdShowListener
                    public void onAdClicked(MolocoAd molocoAd) {
                        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
                        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
                    }

                    @Override // com.moloco.sdk.publisher.AdShowListener
                    public void onAdHidden(MolocoAd molocoAd) {
                        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
                        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
                    }

                    @Override // com.moloco.sdk.publisher.AdShowListener
                    public void onAdShowFailed(MolocoAdError molocoAdError) {
                        Intrinsics.checkNotNullParameter(molocoAdError, "molocoAdError");
                        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
                    }

                    @Override // com.moloco.sdk.publisher.AdShowListener
                    public void onAdShowSuccess(MolocoAd molocoAd) {
                        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
                        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
                    }
                });
                interstitialAd.load("an_another_bid_response", null);
            }
        }, 2, null);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        InterstitialAd interstitialAd = this.interstitialAd;
        if (interstitialAd == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interstitialAd");
            interstitialAd = null;
        }
        interstitialAd.destroy();
    }
}
