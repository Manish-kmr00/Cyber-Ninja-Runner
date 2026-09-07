package com.moloco.sdk.publisher;

import android.content.Context;
import android.widget.FrameLayout;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.publisher.init.MolocoInitParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\b\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\b\u0010\n\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\b\u0010\u000e\u001a\u00020\u0001H\u0002¨\u0006\u000f"}, d2 = {"MolocoCreateBanner", "", "frameLayout", "Landroid/widget/FrameLayout;", "MolocoCreateBannerTablet", "MolocoCreateInterstitialAd", "MolocoCreateMREC", "MolocoCreateNativeAd", "adUnitId", "", "MolocoCreateRewardedInterstitialAd", "MolocoInitializeSample", "appContext", "Landroid/content/Context;", "MolocoIsInitializedSample", "moloco-sdk_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MolocoSamplesKt {
    private static final void MolocoCreateBanner(final FrameLayout frameLayout) {
        Moloco.createBanner$default("MOLOCO_ADUNIT_ID", null, new Function2<Banner, MolocoAdError.AdCreateError, Unit>() { // from class: com.moloco.sdk.publisher.MolocoSamplesKt.MolocoCreateBanner.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                if (banner != null) {
                    banner.load("bid_response", null);
                    frameLayout.addView(banner);
                    banner.destroy();
                    frameLayout.removeView(banner);
                }
            }
        }, 2, null);
    }

    private static final void MolocoCreateBannerTablet(final FrameLayout frameLayout) {
        Moloco.createBannerTablet$default("MOLOCO_ADUNIT_ID", null, new Function2<Banner, MolocoAdError.AdCreateError, Unit>() { // from class: com.moloco.sdk.publisher.MolocoSamplesKt.MolocoCreateBannerTablet.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                if (banner != null) {
                    banner.load("bid_response", null);
                    frameLayout.addView(banner);
                    banner.destroy();
                    frameLayout.removeView(banner);
                }
            }
        }, 2, null);
    }

    private static final void MolocoCreateInterstitialAd() {
        Moloco.createInterstitial$default("MOLOCO_ADUNIT_ID", null, new Function2<InterstitialAd, MolocoAdError.AdCreateError, Unit>() { // from class: com.moloco.sdk.publisher.MolocoSamplesKt.MolocoCreateInterstitialAd.1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(InterstitialAd interstitialAd, MolocoAdError.AdCreateError adCreateError) {
                invoke2(interstitialAd, adCreateError);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InterstitialAd interstitialAd, MolocoAdError.AdCreateError adCreateError) {
                if (interstitialAd != null) {
                    interstitialAd.load("bid_response", null);
                    interstitialAd.show(null);
                    interstitialAd.destroy();
                }
            }
        }, 2, null);
    }

    private static final void MolocoCreateMREC(final FrameLayout frameLayout) {
        Moloco.createMREC$default("MOLOCO_ADUNIT_ID", null, new Function2<Banner, MolocoAdError.AdCreateError, Unit>() { // from class: com.moloco.sdk.publisher.MolocoSamplesKt.MolocoCreateMREC.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                if (banner != null) {
                    banner.load("bid_response", null);
                    frameLayout.addView(banner);
                    banner.destroy();
                    frameLayout.removeView(banner);
                }
            }
        }, 2, null);
    }

    private static final void MolocoCreateNativeAd(String str) {
        Moloco.createNativeAd$default("MOLOCO_ADUNIT_ID", null, new Function2<NativeAd, MolocoAdError.AdCreateError, Unit>() { // from class: com.moloco.sdk.publisher.MolocoSamplesKt.MolocoCreateNativeAd.1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(NativeAd nativeAd, MolocoAdError.AdCreateError adCreateError) {
                invoke2(nativeAd, adCreateError);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NativeAd nativeAd, MolocoAdError.AdCreateError adCreateError) {
                if (nativeAd != null) {
                    nativeAd.load("bid_response", null);
                }
            }
        }, 2, null);
    }

    private static final void MolocoCreateRewardedInterstitialAd() {
        Moloco.createRewardedInterstitial$default("MOLOCO_ADUNIT_ID", null, new Function2<RewardedInterstitialAd, MolocoAdError.AdCreateError, Unit>() { // from class: com.moloco.sdk.publisher.MolocoSamplesKt.MolocoCreateRewardedInterstitialAd.1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(RewardedInterstitialAd rewardedInterstitialAd, MolocoAdError.AdCreateError adCreateError) {
                invoke2(rewardedInterstitialAd, adCreateError);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RewardedInterstitialAd rewardedInterstitialAd, MolocoAdError.AdCreateError adCreateError) {
                if (rewardedInterstitialAd != null) {
                    rewardedInterstitialAd.load("bid_response", null);
                    rewardedInterstitialAd.show(null);
                    rewardedInterstitialAd.destroy();
                }
            }
        }, 2, null);
    }

    private static final void MolocoInitializeSample(final Context context) {
        Moloco.initialize(new MolocoInitParams(context, "YOUR_APP_KEY", new MediationInfo("<YourMediationName>")), new MolocoInitializationListener() { // from class: com.moloco.sdk.publisher.MolocoSamplesKt.MolocoInitializeSample.1
            @Override // com.moloco.sdk.publisher.MolocoInitializationListener
            public final void onMolocoInitializationStatus(MolocoInitStatus molocoInitStatus) {
                Intrinsics.checkNotNullParameter(molocoInitStatus, "molocoInitStatus");
                if (molocoInitStatus.getInitialization() == Initialization.SUCCESS) {
                    Moloco.getBidToken(context, new MolocoBidTokenListener() { // from class: com.moloco.sdk.publisher.MolocoSamplesKt$MolocoInitializeSample$1$onMolocoInitializationStatus$1
                        @Override // com.moloco.sdk.publisher.MolocoBidTokenListener
                        public final void onBidTokenResult(String bidToken, MolocoAdError.ErrorType errorType) {
                            Intrinsics.checkNotNullParameter(bidToken, "bidToken");
                        }
                    });
                } else {
                    MolocoLogger.error$default(MolocoLogger.INSTANCE, "app", molocoInitStatus.getDescription(), null, false, 12, null);
                }
            }
        });
    }

    private static final void MolocoIsInitializedSample() {
        Moloco.isInitialized();
    }
}
