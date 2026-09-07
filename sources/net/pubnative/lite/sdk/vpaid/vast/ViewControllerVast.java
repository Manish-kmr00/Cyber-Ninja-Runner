package net.pubnative.lite.sdk.vpaid.vast;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.iab.omid.library.pubnativenet.adsession.FriendlyObstructionPurpose;
import net.pubnative.lite.sdk.CountdownStyle;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.InterstitialActionBehaviour;
import net.pubnative.lite.sdk.core.R;
import net.pubnative.lite.sdk.models.CustomCTAData;
import net.pubnative.lite.sdk.models.EndCardData;
import net.pubnative.lite.sdk.models.SkipOffset;
import net.pubnative.lite.sdk.utils.Logger;
import net.pubnative.lite.sdk.utils.ScreenDimensionsUtils;
import net.pubnative.lite.sdk.utils.SkipOffsetManager;
import net.pubnative.lite.sdk.utils.ViewUtils;
import net.pubnative.lite.sdk.views.cta.HyBidCTAView;
import net.pubnative.lite.sdk.views.endcard.HyBidEndCardView;
import net.pubnative.lite.sdk.vpaid.AdCloseButtonListener;
import net.pubnative.lite.sdk.vpaid.CloseButtonListener;
import net.pubnative.lite.sdk.vpaid.InvalidCTAUrlListener;
import net.pubnative.lite.sdk.vpaid.VastActivityInteractor;
import net.pubnative.lite.sdk.vpaid.VideoAdController;
import net.pubnative.lite.sdk.vpaid.VideoAdView;
import net.pubnative.lite.sdk.vpaid.VideoVisibilityManager;
import net.pubnative.lite.sdk.vpaid.helpers.BitmapHelper;
import net.pubnative.lite.sdk.vpaid.response.AdParams;
import net.pubnative.lite.sdk.vpaid.utils.Utils;
import net.pubnative.lite.sdk.vpaid.widget.CountDownView;
import net.pubnative.lite.sdk.vpaid.widget.CountDownViewFactory;
import net.pubnative.lite.sdk.vpaid.widget.LinearCountDownView;

/* JADX INFO: loaded from: classes9.dex */
public class ViewControllerVast implements View.OnClickListener {
    private static final CountdownStyle COUNTDOWN_STYLE_DEFAULT = CountdownStyle.PIE_CHART;
    private static final InterstitialActionBehaviour INTERSTITIAL_CLICK_BEHAVIOUR_DEFAULT = InterstitialActionBehaviour.HB_CREATIVE;
    private static final String LOG_TAG = "ViewControllerVast";
    private HyBidCTAView ctaView;
    VastActivityInteractor interactor;
    private final VideoAdController mAdController;
    private VideoAdView mBannerView;
    private FrameLayout mControlsLayout;
    private CustomCTAData mCustomCTAData;
    private Integer mCustomCTADelay;
    private HyBidEndCardView mEndCardView;
    private final boolean mHasHiddenUx;
    private boolean mHasReducedCloseButton;
    private final boolean mIsBrandAd;
    private final boolean mIsFullscreen;
    private HyBidEndCardView mLastCustomEndCardView;
    private LinearCountDownView mLinearCountdownView;
    private boolean mMuteState;
    private ImageView mMuteView;
    private View mOpenUrlLayout;
    private final Integer mRemoteEndCardCloseDelay;
    private CountDownView mSkipCountdownView;
    private View mSkipView;
    private Surface mSurface;
    private View mUxLayout;
    private FrameLayout mVideoPlayerLayout;
    private TextureView mVideoPlayerLayoutTexture;
    AdCloseButtonListener mcloseButtonListener;
    private InterstitialActionBehaviour remoteConfigInterstitialClickBehaviour;
    private final VideoAdView.VisibilityListener mCreateVisibilityListener = new VideoAdView.VisibilityListener() { // from class: net.pubnative.lite.sdk.vpaid.vast.ViewControllerVast.1
        @Override // net.pubnative.lite.sdk.vpaid.VideoAdView.VisibilityListener
        public void onVisibilityChanged(int i) {
            try {
                if (i == 0) {
                    ViewControllerVast.this.mAdController.setVideoVisible(true);
                    ViewControllerVast.this.videoVisibilityManager.reportChange(VideoVisibilityManager.VideoAdStatus.RESUMED);
                } else {
                    ViewControllerVast.this.mAdController.setVideoVisible(false);
                    ViewControllerVast.this.videoVisibilityManager.reportChange(VideoVisibilityManager.VideoAdStatus.PAUSED);
                }
            } catch (Exception e) {
                HyBid.reportException(e);
                Logger.e(ViewControllerVast.LOG_TAG, "ViewControllerVast.createVisibilityListener: Log: " + Log.getStackTraceString(e));
            }
        }
    };
    private final TextureView.SurfaceTextureListener mCreateTextureListener = new TextureView.SurfaceTextureListener() { // from class: net.pubnative.lite.sdk.vpaid.vast.ViewControllerVast.2
        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            ViewControllerVast.this.mSurface = new Surface(surfaceTexture);
        }
    };
    VideoVisibilityManager videoVisibilityManager = VideoVisibilityManager.getInstance();

    public ViewControllerVast(VideoAdController videoAdController, boolean z, Integer num, Boolean bool, boolean z2, AdCloseButtonListener adCloseButtonListener, CustomCTAData customCTAData, Integer num2, boolean z3, boolean z4) {
        this.remoteConfigInterstitialClickBehaviour = null;
        this.mHasReducedCloseButton = false;
        this.mCustomCTAData = null;
        this.mCustomCTADelay = 0;
        this.mAdController = videoAdController;
        this.mIsFullscreen = z;
        this.mcloseButtonListener = adCloseButtonListener;
        this.mCustomCTAData = customCTAData;
        this.mCustomCTADelay = num2;
        this.mIsBrandAd = z3;
        this.mHasHiddenUx = z4;
        this.mRemoteEndCardCloseDelay = num;
        if (bool != null) {
            if (bool.booleanValue()) {
                this.remoteConfigInterstitialClickBehaviour = InterstitialActionBehaviour.HB_CREATIVE;
            } else {
                this.remoteConfigInterstitialClickBehaviour = InterstitialActionBehaviour.HB_ACTION_BUTTON;
            }
        }
        this.mHasReducedCloseButton = z2;
        this.interactor = VastActivityInteractor.getInstance();
    }

    public void buildVideoAdView(VideoAdView videoAdView) {
        if (this.interactor.isActivityVisible() || !this.mIsFullscreen) {
            Context context = videoAdView.getContext();
            this.mBannerView = videoAdView;
            videoAdView.setVisibilityListener(this.mCreateVisibilityListener);
            videoAdView.removeAllViews();
            this.mControlsLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.controls, (ViewGroup) videoAdView, false);
            this.mOpenUrlLayout = LayoutInflater.from(context).inflate(R.layout.open_url, (ViewGroup) videoAdView, false);
            this.mUxLayout = this.mControlsLayout.findViewById(R.id.uxLayout);
            initCustomCta(context);
            boolean z = this.mIsFullscreen;
            if (z && this.mIsBrandAd) {
                View view = this.mOpenUrlLayout;
                if (view != null) {
                    view.setVisibility(0);
                }
                if (this.mHasHiddenUx) {
                    this.mBannerView.setOnClickListener(new View.OnClickListener() { // from class: net.pubnative.lite.sdk.vpaid.vast.ViewControllerVast$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            this.f$0.m9915x3b93300(view2);
                        }
                    });
                    this.mUxLayout.setVisibility(4);
                }
            } else {
                final InterstitialActionBehaviour interstitialActionBehaviour = this.remoteConfigInterstitialClickBehaviour;
                if (interstitialActionBehaviour == null) {
                    interstitialActionBehaviour = INTERSTITIAL_CLICK_BEHAVIOUR_DEFAULT;
                }
                if (this.mCustomCTAData != null && z) {
                    View view2 = this.mOpenUrlLayout;
                    if (view2 != null) {
                        view2.setVisibility(8);
                    }
                    this.mBannerView.setOnClickListener(new View.OnClickListener() { // from class: net.pubnative.lite.sdk.vpaid.vast.ViewControllerVast$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view3) {
                            this.f$0.m9916x1dd4b19f(view3);
                        }
                    });
                    showCTAButton(this.mCustomCTAData, this.mCustomCTADelay, new InvalidCTAUrlListener() { // from class: net.pubnative.lite.sdk.vpaid.vast.ViewControllerVast$$ExternalSyntheticLambda2
                        @Override // net.pubnative.lite.sdk.vpaid.InvalidCTAUrlListener
                        public final void invalidCTAUrl() {
                            this.f$0.m9917x37f0303e(interstitialActionBehaviour);
                        }
                    });
                } else {
                    m9917x37f0303e(interstitialActionBehaviour);
                }
            }
            this.mVideoPlayerLayout = (FrameLayout) this.mControlsLayout.findViewById(R.id.videoPlayerLayout);
            if (hasCTAExtension(this.mAdController.getAdParams())) {
                RelativeLayout relativeLayout = new RelativeLayout(this.mVideoPlayerLayout.getContext());
                TextureView textureView = new TextureView(relativeLayout.getContext());
                this.mVideoPlayerLayoutTexture = textureView;
                textureView.setId(R.id.textureView);
                relativeLayout.addView(this.mVideoPlayerLayoutTexture, new RelativeLayout.LayoutParams(-1, -1));
                this.mVideoPlayerLayout.addView(relativeLayout, 0, new FrameLayout.LayoutParams(-1, -1));
            } else {
                TextureView textureView2 = new TextureView(this.mVideoPlayerLayout.getContext());
                this.mVideoPlayerLayoutTexture = textureView2;
                textureView2.setId(R.id.textureView);
                this.mVideoPlayerLayout.addView(this.mVideoPlayerLayoutTexture, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            HyBidEndCardView hyBidEndCardView = new HyBidEndCardView(context, this.mHasReducedCloseButton);
            this.mEndCardView = hyBidEndCardView;
            hyBidEndCardView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.mEndCardView.setVisibility(8);
            HyBidEndCardView hyBidEndCardView2 = new HyBidEndCardView(context, this.mHasReducedCloseButton);
            this.mLastCustomEndCardView = hyBidEndCardView2;
            hyBidEndCardView2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.mLastCustomEndCardView.setVisibility(8);
            this.mOpenUrlLayout.findViewById(R.id.openURL).setOnClickListener(this);
            CountDownView countDownViewCreateCountdownView = new CountDownViewFactory().createCountdownView(context, COUNTDOWN_STYLE_DEFAULT, this.mControlsLayout);
            this.mSkipCountdownView = countDownViewCreateCountdownView;
            this.mControlsLayout.addView(countDownViewCreateCountdownView);
            this.mLinearCountdownView = (LinearCountDownView) this.mControlsLayout.findViewById(R.id.linear_count_down);
            TextureView textureView3 = this.mVideoPlayerLayoutTexture;
            if (textureView3 != null) {
                textureView3.setSurfaceTextureListener(this.mCreateTextureListener);
            }
            ImageView imageView = (ImageView) this.mControlsLayout.findViewById(R.id.muteView);
            this.mMuteView = imageView;
            imageView.setOnClickListener(this);
            if (this.mIsBrandAd && this.mHasHiddenUx) {
                ImageView imageView2 = this.mMuteView;
                if (imageView2 != null) {
                    imageView2.setVisibility(4);
                }
                hideCountdown(true);
                hideMute(true);
            }
            this.mSkipView = this.mControlsLayout.findViewById(R.id.skipView);
            if (this.mHasReducedCloseButton) {
                int iConvertDpToPixel = (int) ViewUtils.convertDpToPixel(20.0f, context);
                int iConvertDpToPixel2 = (int) ViewUtils.convertDpToPixel(8.0f, context);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iConvertDpToPixel, iConvertDpToPixel);
                layoutParams.setMargins(iConvertDpToPixel2, iConvertDpToPixel2, 0, 0);
                this.mSkipView.setId(R.id.skipView_small);
                this.mSkipView.setLayoutParams(layoutParams);
                this.mSkipView.setPadding(0, 0, 0, 0);
                this.mSkipView.requestLayout();
            }
            Bitmap bitmap = BitmapHelper.toBitmap(this.mSkipView.getContext(), HyBid.getSkipXmlResource(), Integer.valueOf(R.mipmap.skip));
            if (bitmap != null) {
                ((ImageView) this.mSkipView).setImageBitmap(bitmap);
            } else {
                View view3 = this.mSkipView;
                ((ImageView) view3).setImageBitmap(BitmapHelper.decodeResource(view3.getContext(), Integer.valueOf(R.mipmap.skip)));
            }
            this.mSkipView.setOnClickListener(this);
            this.mAdController.addViewabilityFriendlyObstruction(this.mControlsLayout, FriendlyObstructionPurpose.VIDEO_CONTROLS, "Video controls");
            videoAdView.addView(this.mControlsLayout);
            videoAdView.addView(this.mEndCardView);
            videoAdView.addView(this.mLastCustomEndCardView);
            videoAdView.addView(this.ctaView);
            videoAdView.addView(this.mOpenUrlLayout);
        }
    }

    /* JADX INFO: renamed from: lambda$buildVideoAdView$0$net-pubnative-lite-sdk-vpaid-vast-ViewControllerVast, reason: not valid java name */
    /* synthetic */ void m9915x3b93300(View view) {
        changeUxVisibility();
    }

    /* JADX INFO: renamed from: lambda$buildVideoAdView$1$net-pubnative-lite-sdk-vpaid-vast-ViewControllerVast, reason: not valid java name */
    /* synthetic */ void m9916x1dd4b19f(View view) {
        validateOpenURLClicked(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: showHideLearnMore, reason: merged with bridge method [inline-methods] */
    public void m9917x37f0303e(InterstitialActionBehaviour interstitialActionBehaviour) {
        if (interstitialActionBehaviour == InterstitialActionBehaviour.HB_CREATIVE) {
            this.mBannerView.setOnClickListener(new View.OnClickListener() { // from class: net.pubnative.lite.sdk.vpaid.vast.ViewControllerVast$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m9918xeb563f32(view);
                }
            });
            View view = this.mOpenUrlLayout;
            if (view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        View view2 = this.mOpenUrlLayout;
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }

    /* JADX INFO: renamed from: lambda$showHideLearnMore$3$net-pubnative-lite-sdk-vpaid-vast-ViewControllerVast, reason: not valid java name */
    /* synthetic */ void m9918xeb563f32(View view) {
        validateOpenURLClicked(false);
    }

    private void initCustomCta(Context context) {
        this.ctaView = new HyBidCTAView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int iAsIntPixels = ViewUtils.asIntPixels(6.0f, context);
        int i = (new ScreenDimensionsUtils().getScreenDimensionsToPoint(context).y * 10) / 100;
        layoutParams.setMargins(iAsIntPixels, i, iAsIntPixels, i);
        layoutParams.gravity = 85;
        this.ctaView.setLayoutParams(layoutParams);
        this.ctaView.setContentDescription("ctaView");
    }

    private boolean hasCTAExtension(AdParams adParams) {
        return (adParams == null || TextUtils.isEmpty(adParams.getCtaExtensionHtml())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void validateOpenURLClicked(Boolean bool) {
        this.mAdController.getViewabilityAdSession().fireClick();
        this.mAdController.openUrl(null, false, bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void validateEndCardOpenURLClicked(String str) {
        this.mAdController.openUrl(str, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void validateCustomEndCardOpenURLClicked() {
        this.mAdController.openUrl(null, true, false);
    }

    public void adjustLayoutParams(int i, int i2) {
        if (this.mControlsLayout == null) {
            Logger.e(LOG_TAG, "ViewControllerVast.adjustLayoutParams: Log: mControlsLayout is null");
        } else {
            this.mVideoPlayerLayout.setLayoutParams(Utils.calculateNewLayoutParams((FrameLayout.LayoutParams) this.mVideoPlayerLayout.getLayoutParams(), i, i2, this.mBannerView.getWidth(), this.mBannerView.getHeight(), Utils.StretchOption.NO_STRETCH));
        }
    }

    public void postDelayed(Runnable runnable, long j) {
        VideoAdView videoAdView = this.mBannerView;
        if (videoAdView != null) {
            videoAdView.postDelayed(runnable, j);
        }
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    public void setProgress(int i, int i2) {
        LinearCountDownView linearCountDownView = this.mLinearCountdownView;
        if (linearCountDownView != null) {
            linearCountDownView.setProgress(i2 - i, i2);
        }
    }

    public void setSkipProgress(int i, int i2) {
        CountDownView countDownView = this.mSkipCountdownView;
        if (countDownView != null) {
            countDownView.setProgress(i2 - i, i2);
        }
    }

    public void endSkip(Boolean bool, Boolean bool2) {
        CountDownView countDownView = this.mSkipCountdownView;
        if (countDownView != null) {
            countDownView.setVisibility(8);
            if (bool.booleanValue()) {
                showCloseButton();
            } else if (!bool2.booleanValue()) {
                showCloseButton();
            } else {
                showSkipButton();
            }
        }
    }

    public void resetProgress() {
        LinearCountDownView linearCountDownView = this.mLinearCountdownView;
        if (linearCountDownView != null) {
            linearCountDownView.reset();
        }
    }

    public boolean isMute() {
        return this.mMuteState;
    }

    public void showEndCard(EndCardData endCardData, String str, Boolean bool, CloseButtonListener closeButtonListener) {
        HyBidEndCardView hyBidEndCardView = this.mEndCardView;
        if (hyBidEndCardView != null) {
            hyBidEndCardView.setEndCardViewListener(new HyBidEndCardView.EndCardViewListener() { // from class: net.pubnative.lite.sdk.vpaid.vast.ViewControllerVast.3
                @Override // net.pubnative.lite.sdk.views.endcard.HyBidEndCardView.EndCardViewListener
                public void onClick(String str2, Boolean bool2, String str3) {
                    if (bool2.booleanValue()) {
                        ViewControllerVast.this.validateCustomEndCardOpenURLClicked();
                        ViewControllerVast.this.mAdController.onCustomEndCardClick(str3);
                    } else {
                        ViewControllerVast.this.validateEndCardOpenURLClicked(str2);
                        ViewControllerVast.this.mAdController.onDefaultEndCardClick(str3);
                    }
                }

                @Override // net.pubnative.lite.sdk.views.endcard.HyBidEndCardView.EndCardViewListener
                public void onSkip() {
                    ViewControllerVast.this.skipEndCard();
                }

                @Override // net.pubnative.lite.sdk.views.endcard.HyBidEndCardView.EndCardViewListener
                public void onClose(Boolean bool2) {
                    if (ViewControllerVast.this.mAdController != null) {
                        ViewControllerVast.this.mAdController.onEndCardClosed(bool2);
                    }
                    ViewControllerVast.this.closeSelf();
                }

                @Override // net.pubnative.lite.sdk.views.endcard.HyBidEndCardView.EndCardViewListener
                public void onShow(Boolean bool2, String str2) {
                    if (ViewControllerVast.this.mOpenUrlLayout != null) {
                        ViewControllerVast.this.mOpenUrlLayout.setVisibility(8);
                    }
                    if (bool2.booleanValue()) {
                        ViewControllerVast.this.mAdController.onCustomEndCardShow(str2);
                        ViewControllerVast.this.mEndCardView.bringToFront();
                        if (ViewControllerVast.this.ctaView != null) {
                            ViewControllerVast.this.ctaView.hide();
                            return;
                        }
                        return;
                    }
                    ViewControllerVast.this.mAdController.onDefaultEndCardShow(str2);
                    if (ViewControllerVast.this.ctaView != null) {
                        ViewControllerVast.this.ctaView.show();
                    }
                }

                @Override // net.pubnative.lite.sdk.views.endcard.HyBidEndCardView.EndCardViewListener
                public void onLoadSuccess(Boolean bool2) {
                    if (ViewControllerVast.this.mAdController != null) {
                        ViewControllerVast.this.mAdController.onEndCardLoadSuccess(bool2);
                    }
                }

                @Override // net.pubnative.lite.sdk.views.endcard.HyBidEndCardView.EndCardViewListener
                public void onLoadFail(Boolean bool2) {
                    if (ViewControllerVast.this.mAdController != null) {
                        ViewControllerVast.this.mAdController.onEndCardLoadFail(bool2);
                    }
                }
            });
            this.mEndCardView.setSkipOffset(getEndCardCloseDelay());
            this.mEndCardView.show(endCardData, str);
            if (this.mIsFullscreen) {
                if (bool.booleanValue()) {
                    this.mEndCardView.showCloseButton(closeButtonListener);
                } else {
                    this.mEndCardView.showSkipButton();
                }
            }
        }
    }

    public void showLastCustomEndCard(EndCardData endCardData, String str, CloseButtonListener closeButtonListener) {
        HyBidEndCardView hyBidEndCardView = this.mLastCustomEndCardView;
        if (hyBidEndCardView != null) {
            hyBidEndCardView.setEndCardViewListener(new HyBidEndCardView.EndCardViewListener() { // from class: net.pubnative.lite.sdk.vpaid.vast.ViewControllerVast.4
                @Override // net.pubnative.lite.sdk.views.endcard.HyBidEndCardView.EndCardViewListener
                public void onClick(String str2, Boolean bool, String str3) {
                    ViewControllerVast.this.validateCustomEndCardOpenURLClicked();
                    if (bool.booleanValue()) {
                        ViewControllerVast.this.mAdController.onCustomEndCardClick(str3);
                    } else {
                        ViewControllerVast.this.mAdController.onDefaultEndCardClick(str3);
                    }
                }

                @Override // net.pubnative.lite.sdk.views.endcard.HyBidEndCardView.EndCardViewListener
                public void onSkip() {
                    ViewControllerVast.this.skipEndCard();
                }

                @Override // net.pubnative.lite.sdk.views.endcard.HyBidEndCardView.EndCardViewListener
                public void onClose(Boolean bool) {
                    if (ViewControllerVast.this.mAdController != null) {
                        ViewControllerVast.this.mAdController.onEndCardClosed(bool);
                    }
                    ViewControllerVast.this.closeSelf();
                }

                @Override // net.pubnative.lite.sdk.views.endcard.HyBidEndCardView.EndCardViewListener
                public void onShow(Boolean bool, String str2) {
                    if (ViewControllerVast.this.mOpenUrlLayout != null) {
                        ViewControllerVast.this.mOpenUrlLayout.setVisibility(8);
                    }
                    if (bool.booleanValue()) {
                        ViewControllerVast.this.mAdController.onCustomEndCardShow(str2);
                        ViewControllerVast.this.mLastCustomEndCardView.bringToFront();
                        if (ViewControllerVast.this.ctaView != null) {
                            ViewControllerVast.this.ctaView.hide();
                            return;
                        }
                        return;
                    }
                    ViewControllerVast.this.mAdController.onDefaultEndCardShow(str2);
                    if (ViewControllerVast.this.ctaView != null) {
                        ViewControllerVast.this.ctaView.show();
                    }
                }

                @Override // net.pubnative.lite.sdk.views.endcard.HyBidEndCardView.EndCardViewListener
                public void onLoadSuccess(Boolean bool) {
                    if (ViewControllerVast.this.mAdController != null) {
                        ViewControllerVast.this.mAdController.onEndCardLoadSuccess(bool);
                    }
                }

                @Override // net.pubnative.lite.sdk.views.endcard.HyBidEndCardView.EndCardViewListener
                public void onLoadFail(Boolean bool) {
                    if (ViewControllerVast.this.mAdController != null) {
                        ViewControllerVast.this.mAdController.onEndCardLoadFail(bool);
                    }
                }
            });
            this.mLastCustomEndCardView.setSkipOffset(getEndCardCloseDelay());
            this.mEndCardView.hideSkipButton();
            this.mLastCustomEndCardView.show(endCardData, str);
            if (this.mIsFullscreen) {
                this.mLastCustomEndCardView.showCloseButton(closeButtonListener);
            }
        }
    }

    public void showCTAButton(CustomCTAData customCTAData, Integer num, final InvalidCTAUrlListener invalidCTAUrlListener) {
        if (this.ctaView == null || TextUtils.isEmpty(customCTAData.getIconURL())) {
            VideoAdController videoAdController = this.mAdController;
            if (videoAdController != null) {
                videoAdController.onCustomCTALoadFail();
                return;
            }
            return;
        }
        this.ctaView.setListener(new HyBidCTAView.CTAViewListener() { // from class: net.pubnative.lite.sdk.vpaid.vast.ViewControllerVast.5
            @Override // net.pubnative.lite.sdk.views.cta.HyBidCTAView.CTAViewListener
            public void onClick() {
                if (ViewControllerVast.this.mAdController != null) {
                    ViewControllerVast.this.mAdController.onCustomCTAClick(ViewControllerVast.this.isEndCard());
                }
                ViewControllerVast.this.validateOpenURLClicked(true);
            }

            @Override // net.pubnative.lite.sdk.views.cta.HyBidCTAView.CTAViewListener
            public void onShow() {
                if (ViewControllerVast.this.mAdController != null) {
                    ViewControllerVast.this.mAdController.onCustomCTAShow();
                }
            }

            @Override // net.pubnative.lite.sdk.views.cta.HyBidCTAView.CTAViewListener
            public void onFail() {
                if (ViewControllerVast.this.mAdController != null) {
                    ViewControllerVast.this.mAdController.onCustomCTALoadFail();
                }
            }

            @Override // net.pubnative.lite.sdk.views.cta.HyBidCTAView.CTAViewListener
            public void onInvalidCTAIconUrl() {
                if (ViewControllerVast.this.mAdController != null) {
                    ViewControllerVast.this.mAdController.onCustomCTALoadFail();
                }
                InvalidCTAUrlListener invalidCTAUrlListener2 = invalidCTAUrlListener;
                if (invalidCTAUrlListener2 != null) {
                    invalidCTAUrlListener2.invalidCTAUrl();
                }
            }
        });
        if (customCTAData.getBitmap() != null) {
            this.ctaView.show(customCTAData.getBitmap(), customCTAData.getLabel(), num);
        } else {
            this.ctaView.show(customCTAData.getIconURL(), customCTAData.getLabel(), num);
        }
    }

    public void showSkipButton() {
        View view = this.mSkipView;
        if (view != null) {
            if (this.mIsBrandAd) {
                if (this.mUxLayout.getVisibility() == 0) {
                    this.mSkipView.setVisibility(0);
                    this.mSkipView.setClickable(true);
                    return;
                } else {
                    this.mSkipView.setVisibility(4);
                    this.mSkipView.setClickable(false);
                    return;
                }
            }
            view.setVisibility(0);
            this.mSkipView.setClickable(true);
        }
    }

    private void hideMute(boolean z) {
        ImageView imageView = this.mMuteView;
        if (imageView == null || imageView.getVisibility() == 8) {
            return;
        }
        if (z) {
            this.mMuteView.setVisibility(4);
        } else {
            this.mMuteView.setVisibility(0);
        }
    }

    private void hideSkip(boolean z) {
        View view = this.mSkipView;
        if (view == null || view.getVisibility() == 8) {
            return;
        }
        if (z) {
            this.mSkipView.setVisibility(4);
            this.mSkipView.setClickable(false);
        } else {
            this.mSkipView.setVisibility(0);
            this.mSkipView.setClickable(true);
        }
    }

    public void showCloseButton() {
        AdCloseButtonListener adCloseButtonListener = this.mcloseButtonListener;
        if (adCloseButtonListener != null) {
            adCloseButtonListener.showButton();
        }
    }

    public void hideCloseButton() {
        AdCloseButtonListener adCloseButtonListener = this.mcloseButtonListener;
        if (adCloseButtonListener != null) {
            adCloseButtonListener.hideButton();
        }
    }

    public VideoAdView getVideoView() {
        return this.mBannerView;
    }

    public void hideSkipButton() {
        View view = this.mSkipView;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void hideTimerAndMuteButton() {
        LinearCountDownView linearCountDownView = this.mLinearCountdownView;
        if (linearCountDownView != null) {
            linearCountDownView.setVisibility(8);
        }
        ImageView imageView = this.mMuteView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public boolean isEndCard() {
        HyBidEndCardView hyBidEndCardView = this.mEndCardView;
        return (hyBidEndCardView == null || hyBidEndCardView.getVisibility() == 8) ? false : true;
    }

    public void dismiss() {
        VideoAdView videoAdView = this.mBannerView;
        if (videoAdView != null) {
            videoAdView.removeAllViews();
        }
    }

    public void destroy() {
        HyBidEndCardView hyBidEndCardView = this.mEndCardView;
        if (hyBidEndCardView != null) {
            hyBidEndCardView.destroy();
        }
        HyBidCTAView hyBidCTAView = this.ctaView;
        if (hyBidCTAView != null) {
            hyBidCTAView.destroy();
        }
        HyBidEndCardView hyBidEndCardView2 = this.mLastCustomEndCardView;
        if (hyBidEndCardView2 != null) {
            hyBidEndCardView2.destroy();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.close_view) {
            closeSelf();
            return;
        }
        if (view.getId() == R.id.skipView || view.getId() == R.id.progressSkipView || view.getId() == R.id.skipView_small) {
            skipVideo();
        } else if (view.getId() == R.id.muteView) {
            muteVideo();
        } else if (view.getId() == R.id.openURL) {
            validateOpenURLClicked(false);
        }
    }

    private void skipVideo() {
        this.mAdController.skipVideo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void skipEndCard() {
        this.mAdController.skipEndCard();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeSelf() {
        this.mAdController.closeSelf();
    }

    private void replayVideo() {
        this.mEndCardView.hide();
        this.mVideoPlayerLayout.setVisibility(0);
        this.mAdController.playAd();
    }

    public void pauseEndCardCloseButtonTimer() {
        HyBidEndCardView hyBidEndCardView = this.mEndCardView;
        if (hyBidEndCardView != null) {
            hyBidEndCardView.pause();
        }
        HyBidEndCardView hyBidEndCardView2 = this.mLastCustomEndCardView;
        if (hyBidEndCardView2 != null) {
            hyBidEndCardView2.pause();
        }
    }

    public void pause() {
        HyBidCTAView hyBidCTAView = this.ctaView;
        if (hyBidCTAView != null) {
            hyBidCTAView.pause();
        }
    }

    public void resume() {
        HyBidCTAView hyBidCTAView = this.ctaView;
        if (hyBidCTAView != null) {
            hyBidCTAView.resume();
        }
    }

    public void resumeEndCardCloseButtonTimer() {
        HyBidEndCardView hyBidEndCardView = this.mEndCardView;
        if (hyBidEndCardView != null) {
            hyBidEndCardView.resume();
        }
        HyBidEndCardView hyBidEndCardView2 = this.mLastCustomEndCardView;
        if (hyBidEndCardView2 != null) {
            hyBidEndCardView2.resume();
        }
    }

    public void muteVideo() {
        boolean z = !this.mMuteState;
        this.mMuteState = z;
        this.mAdController.setVolume(z);
        ImageView imageView = this.mMuteView;
        if (imageView != null) {
            if (this.mMuteState) {
                imageView.setImageResource(R.mipmap.mute);
                this.mMuteView.setContentDescription("muteButton");
            } else {
                imageView.setImageResource(R.mipmap.unmute);
                this.mMuteView.setContentDescription("unmuteButton");
            }
        }
    }

    public TextureView getTexture() {
        return this.mVideoPlayerLayoutTexture;
    }

    private SkipOffset getEndCardCloseDelay() {
        Integer num = this.mRemoteEndCardCloseDelay;
        if (num != null) {
            if (num.intValue() > SkipOffsetManager.getMaximumEndcardCloseDelay().intValue()) {
                return new SkipOffset(SkipOffsetManager.getMaximumEndcardCloseDelay().intValue(), true);
            }
            return new SkipOffset(this.mRemoteEndCardCloseDelay.intValue(), true);
        }
        return new SkipOffset(SkipOffsetManager.getDefaultEndcardSkipOffset().intValue(), false);
    }

    private void hideCountdown(boolean z) {
        CountDownView countDownView = this.mSkipCountdownView;
        if (countDownView == null || countDownView.getVisibility() == 8) {
            return;
        }
        if (z) {
            this.mSkipCountdownView.setVisibility(4);
        } else {
            this.mSkipCountdownView.setVisibility(0);
        }
    }

    private void changeUxVisibility() {
        View view = this.mUxLayout;
        if (view != null) {
            if (view.getVisibility() == 0) {
                this.mUxLayout.setVisibility(4);
                hideCountdown(true);
                hideMute(true);
                hideSkip(true);
                return;
            }
            this.mUxLayout.setVisibility(0);
            hideCountdown(false);
            hideMute(false);
            hideSkip(false);
        }
    }
}
