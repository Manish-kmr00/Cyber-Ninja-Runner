package com.moloco.sdk.publisher;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\bH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/moloco/sdk/publisher/BannerActivitySample;", "Landroid/app/Activity;", "()V", "banner", "Lcom/moloco/sdk/publisher/Banner;", "bannerContainer", "Landroid/widget/FrameLayout;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "persistentState", "Landroid/os/PersistableBundle;", "onDestroy", "moloco-sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class BannerActivitySample extends Activity {
    private Banner banner;
    private final FrameLayout bannerContainer = new FrameLayout(this);

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.D, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(this.bannerContainer);
        Moloco.createBanner$default("MOLOCO_ADUNIT_ID", null, new Function2<Banner, MolocoAdError.AdCreateError, Unit>() { // from class: com.moloco.sdk.publisher.BannerActivitySample.onCreate.1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Banner banner, MolocoAdError.AdCreateError adCreateError) {
                invoke2(banner, adCreateError);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Banner banner, MolocoAdError.AdCreateError adCreateError) {
                if (banner == null) {
                    BannerActivitySample.this.finish();
                    return;
                }
                BannerActivitySample.this.banner = banner;
                BannerActivitySample.this.bannerContainer.addView(banner);
                banner.setAdShowListener(new BannerAdShowListener() { // from class: com.moloco.sdk.publisher.BannerActivitySample.onCreate.1.1
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
                banner.load("bid response", new AdLoad.Listener() { // from class: com.moloco.sdk.publisher.BannerActivitySample.onCreate.1.2
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
                banner.isLoaded();
                banner.load("an_another_bid_response", null);
                BannerActivitySample.this.bannerContainer.removeView(banner);
                banner.load("", null);
                banner.load("some_other_bid_response", null);
                BannerActivitySample.this.bannerContainer.addView(banner);
            }
        }, 2, null);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Banner banner = this.banner;
        Banner banner2 = null;
        if (banner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("banner");
            banner = null;
        }
        banner.destroy();
        Banner banner3 = this.banner;
        if (banner3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("banner");
            banner3 = null;
        }
        ViewParent parent = banner3.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            Banner banner4 = this.banner;
            if (banner4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("banner");
            } else {
                banner2 = banner4;
            }
            viewGroup.removeView(banner2);
        }
    }
}
