package net.pubnative.lite.sdk.views.endcard;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import java.util.List;
import java.util.Map;
import net.pubnative.lite.sdk.analytics.Reporting;
import net.pubnative.lite.sdk.core.R;
import net.pubnative.lite.sdk.models.EndCardData;
import net.pubnative.lite.sdk.models.SkipOffset;
import net.pubnative.lite.sdk.mraid.MRAIDBanner;
import net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener;
import net.pubnative.lite.sdk.mraid.MRAIDView;
import net.pubnative.lite.sdk.mraid.MRAIDViewListener;
import net.pubnative.lite.sdk.network.PNHttpClient;
import net.pubnative.lite.sdk.utils.SkipOffsetManager;
import net.pubnative.lite.sdk.utils.ViewUtils;
import net.pubnative.lite.sdk.views.CustomImageView;
import net.pubnative.lite.sdk.vpaid.CloseButtonListener;
import net.pubnative.lite.sdk.vpaid.helpers.SimpleTimer;
import net.pubnative.lite.sdk.vpaid.utils.ImageUtils;

/* JADX INFO: loaded from: classes6.dex */
public class HyBidEndCardView extends FrameLayout {
    private String endCardType;
    private EndCardViewListener endcardViewListener;
    private GestureDetector gestureDetector;
    private boolean hasReducedClose;
    private FrameLayout htmlEndCardContainer;
    private Boolean isCustomEndCard;
    private boolean isViewShowingCloseButton;
    private boolean isViewShowingSkipButton;
    private SimpleTimer mCloseEndcardTimer;
    private ImageView mCloseView;
    private MRAIDBanner mHtmlEndCardView;
    private SimpleTimer mSkipEndcardTimer;
    private ImageView mSkipView;
    private MRAIDNativeFeatureListener mraidNativeFeatureListener;
    private final MRAIDViewListener mraidViewListener;
    private SkipOffset skipOffset;
    private ImageView staticEndCardView;

    public interface EndCardViewListener {
        void onClick(String str, Boolean bool, String str2);

        void onClose(Boolean bool);

        void onLoadFail(Boolean bool);

        void onLoadSuccess(Boolean bool);

        void onShow(Boolean bool, String str);

        void onSkip();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.C, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public HyBidEndCardView(Context context) {
        super(context);
        this.isViewShowingCloseButton = false;
        this.isViewShowingSkipButton = false;
        this.endCardType = "";
        this.skipOffset = new SkipOffset(SkipOffsetManager.getDefaultEndcardSkipOffset().intValue(), false);
        this.isCustomEndCard = false;
        this.hasReducedClose = false;
        this.mraidViewListener = new MRAIDViewListener() { // from class: net.pubnative.lite.sdk.views.endcard.HyBidEndCardView.1
            @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
            public void mraidShowCloseButton() {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
            public void mraidViewClose(MRAIDView mRAIDView) {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
            public void mraidViewExpand(MRAIDView mRAIDView) {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
            public boolean mraidViewResize(MRAIDView mRAIDView, int i, int i2, int i3, int i4) {
                return false;
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
            public void onExpandedAdClosed() {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
            public void mraidViewLoaded(MRAIDView mRAIDView) {
                if (HyBidEndCardView.this.endcardViewListener != null) {
                    HyBidEndCardView.this.endcardViewListener.onLoadSuccess(HyBidEndCardView.this.isCustomEndCard);
                    HyBidEndCardView.this.endcardViewListener.onShow(HyBidEndCardView.this.isCustomEndCard, HyBidEndCardView.this.endCardType);
                }
                HyBidEndCardView.this.mHtmlEndCardView.getViewTreeObserver().addOnDrawListener(new ViewTreeObserverOnDrawListenerC08031());
            }

            /* JADX INFO: renamed from: net.pubnative.lite.sdk.views.endcard.HyBidEndCardView$1$1, reason: invalid class name and collision with other inner class name */
            class ViewTreeObserverOnDrawListenerC08031 implements ViewTreeObserver.OnDrawListener {
                ViewTreeObserverOnDrawListenerC08031() {
                }

                @Override // android.view.ViewTreeObserver.OnDrawListener
                public void onDraw() {
                    if (HyBidEndCardView.this.htmlEndCardContainer != null) {
                        HyBidEndCardView.this.htmlEndCardContainer.post(new Runnable() { // from class: net.pubnative.lite.sdk.views.endcard.HyBidEndCardView$1$1$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.m9828xa390ed90();
                            }
                        });
                    }
                    if (HyBidEndCardView.this.mHtmlEndCardView == null || HyBidEndCardView.this.mHtmlEndCardView.getMeasuredHeight() >= 50) {
                        return;
                    }
                    HyBidEndCardView.this.mHtmlEndCardView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                }

                /* JADX INFO: renamed from: lambda$onDraw$0$net-pubnative-lite-sdk-views-endcard-HyBidEndCardView$1$1, reason: not valid java name */
                /* synthetic */ void m9828xa390ed90() {
                    if (HyBidEndCardView.this.htmlEndCardContainer != null) {
                        HyBidEndCardView.this.htmlEndCardContainer.getViewTreeObserver().removeOnDrawListener(this);
                    }
                }
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
            public void mraidViewError(MRAIDView mRAIDView) {
                HyBidEndCardView.this.endcardViewListener.onLoadFail(HyBidEndCardView.this.isCustomEndCard);
            }
        };
        this.mraidNativeFeatureListener = new MRAIDNativeFeatureListener() { // from class: net.pubnative.lite.sdk.views.endcard.HyBidEndCardView.2
            @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
            public void mraidNativeFeatureCallTel(String str) {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
            public void mraidNativeFeatureCreateCalendarEvent(String str) {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
            public void mraidNativeFeaturePlayVideo(String str) {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
            public void mraidNativeFeatureSendSms(String str) {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
            public void mraidNativeFeatureStorePicture(String str) {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
            public void mraidNativeFeatureOpenBrowser(String str) {
                if (HyBidEndCardView.this.endcardViewListener != null) {
                    HyBidEndCardView.this.endcardViewListener.onClick(str, HyBidEndCardView.this.isCustomEndCard, HyBidEndCardView.this.endCardType);
                }
            }
        };
        initUi();
        initControlViews();
    }

    public HyBidEndCardView(Context context, boolean z) {
        super(context);
        this.isViewShowingCloseButton = false;
        this.isViewShowingSkipButton = false;
        this.endCardType = "";
        this.skipOffset = new SkipOffset(SkipOffsetManager.getDefaultEndcardSkipOffset().intValue(), false);
        this.isCustomEndCard = false;
        this.hasReducedClose = false;
        this.mraidViewListener = new MRAIDViewListener() { // from class: net.pubnative.lite.sdk.views.endcard.HyBidEndCardView.1
            @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
            public void mraidShowCloseButton() {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
            public void mraidViewClose(MRAIDView mRAIDView) {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
            public void mraidViewExpand(MRAIDView mRAIDView) {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
            public boolean mraidViewResize(MRAIDView mRAIDView, int i, int i2, int i3, int i4) {
                return false;
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
            public void onExpandedAdClosed() {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
            public void mraidViewLoaded(MRAIDView mRAIDView) {
                if (HyBidEndCardView.this.endcardViewListener != null) {
                    HyBidEndCardView.this.endcardViewListener.onLoadSuccess(HyBidEndCardView.this.isCustomEndCard);
                    HyBidEndCardView.this.endcardViewListener.onShow(HyBidEndCardView.this.isCustomEndCard, HyBidEndCardView.this.endCardType);
                }
                HyBidEndCardView.this.mHtmlEndCardView.getViewTreeObserver().addOnDrawListener(new ViewTreeObserverOnDrawListenerC08031());
            }

            /* JADX INFO: renamed from: net.pubnative.lite.sdk.views.endcard.HyBidEndCardView$1$1, reason: invalid class name and collision with other inner class name */
            class ViewTreeObserverOnDrawListenerC08031 implements ViewTreeObserver.OnDrawListener {
                ViewTreeObserverOnDrawListenerC08031() {
                }

                @Override // android.view.ViewTreeObserver.OnDrawListener
                public void onDraw() {
                    if (HyBidEndCardView.this.htmlEndCardContainer != null) {
                        HyBidEndCardView.this.htmlEndCardContainer.post(new Runnable() { // from class: net.pubnative.lite.sdk.views.endcard.HyBidEndCardView$1$1$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.m9828xa390ed90();
                            }
                        });
                    }
                    if (HyBidEndCardView.this.mHtmlEndCardView == null || HyBidEndCardView.this.mHtmlEndCardView.getMeasuredHeight() >= 50) {
                        return;
                    }
                    HyBidEndCardView.this.mHtmlEndCardView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                }

                /* JADX INFO: renamed from: lambda$onDraw$0$net-pubnative-lite-sdk-views-endcard-HyBidEndCardView$1$1, reason: not valid java name */
                /* synthetic */ void m9828xa390ed90() {
                    if (HyBidEndCardView.this.htmlEndCardContainer != null) {
                        HyBidEndCardView.this.htmlEndCardContainer.getViewTreeObserver().removeOnDrawListener(this);
                    }
                }
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
            public void mraidViewError(MRAIDView mRAIDView) {
                HyBidEndCardView.this.endcardViewListener.onLoadFail(HyBidEndCardView.this.isCustomEndCard);
            }
        };
        this.mraidNativeFeatureListener = new MRAIDNativeFeatureListener() { // from class: net.pubnative.lite.sdk.views.endcard.HyBidEndCardView.2
            @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
            public void mraidNativeFeatureCallTel(String str) {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
            public void mraidNativeFeatureCreateCalendarEvent(String str) {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
            public void mraidNativeFeaturePlayVideo(String str) {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
            public void mraidNativeFeatureSendSms(String str) {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
            public void mraidNativeFeatureStorePicture(String str) {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
            public void mraidNativeFeatureOpenBrowser(String str) {
                if (HyBidEndCardView.this.endcardViewListener != null) {
                    HyBidEndCardView.this.endcardViewListener.onClick(str, HyBidEndCardView.this.isCustomEndCard, HyBidEndCardView.this.endCardType);
                }
            }
        };
        this.hasReducedClose = z;
        initUi();
        initControlViews();
    }

    public HyBidEndCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isViewShowingCloseButton = false;
        this.isViewShowingSkipButton = false;
        this.endCardType = "";
        this.skipOffset = new SkipOffset(SkipOffsetManager.getDefaultEndcardSkipOffset().intValue(), false);
        this.isCustomEndCard = false;
        this.hasReducedClose = false;
        this.mraidViewListener = new MRAIDViewListener() { // from class: net.pubnative.lite.sdk.views.endcard.HyBidEndCardView.1
            @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
            public void mraidShowCloseButton() {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
            public void mraidViewClose(MRAIDView mRAIDView) {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
            public void mraidViewExpand(MRAIDView mRAIDView) {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
            public boolean mraidViewResize(MRAIDView mRAIDView, int i, int i2, int i3, int i4) {
                return false;
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
            public void onExpandedAdClosed() {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
            public void mraidViewLoaded(MRAIDView mRAIDView) {
                if (HyBidEndCardView.this.endcardViewListener != null) {
                    HyBidEndCardView.this.endcardViewListener.onLoadSuccess(HyBidEndCardView.this.isCustomEndCard);
                    HyBidEndCardView.this.endcardViewListener.onShow(HyBidEndCardView.this.isCustomEndCard, HyBidEndCardView.this.endCardType);
                }
                HyBidEndCardView.this.mHtmlEndCardView.getViewTreeObserver().addOnDrawListener(new ViewTreeObserverOnDrawListenerC08031());
            }

            /* JADX INFO: renamed from: net.pubnative.lite.sdk.views.endcard.HyBidEndCardView$1$1, reason: invalid class name and collision with other inner class name */
            class ViewTreeObserverOnDrawListenerC08031 implements ViewTreeObserver.OnDrawListener {
                ViewTreeObserverOnDrawListenerC08031() {
                }

                @Override // android.view.ViewTreeObserver.OnDrawListener
                public void onDraw() {
                    if (HyBidEndCardView.this.htmlEndCardContainer != null) {
                        HyBidEndCardView.this.htmlEndCardContainer.post(new Runnable() { // from class: net.pubnative.lite.sdk.views.endcard.HyBidEndCardView$1$1$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.m9828xa390ed90();
                            }
                        });
                    }
                    if (HyBidEndCardView.this.mHtmlEndCardView == null || HyBidEndCardView.this.mHtmlEndCardView.getMeasuredHeight() >= 50) {
                        return;
                    }
                    HyBidEndCardView.this.mHtmlEndCardView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                }

                /* JADX INFO: renamed from: lambda$onDraw$0$net-pubnative-lite-sdk-views-endcard-HyBidEndCardView$1$1, reason: not valid java name */
                /* synthetic */ void m9828xa390ed90() {
                    if (HyBidEndCardView.this.htmlEndCardContainer != null) {
                        HyBidEndCardView.this.htmlEndCardContainer.getViewTreeObserver().removeOnDrawListener(this);
                    }
                }
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
            public void mraidViewError(MRAIDView mRAIDView) {
                HyBidEndCardView.this.endcardViewListener.onLoadFail(HyBidEndCardView.this.isCustomEndCard);
            }
        };
        this.mraidNativeFeatureListener = new MRAIDNativeFeatureListener() { // from class: net.pubnative.lite.sdk.views.endcard.HyBidEndCardView.2
            @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
            public void mraidNativeFeatureCallTel(String str) {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
            public void mraidNativeFeatureCreateCalendarEvent(String str) {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
            public void mraidNativeFeaturePlayVideo(String str) {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
            public void mraidNativeFeatureSendSms(String str) {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
            public void mraidNativeFeatureStorePicture(String str) {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
            public void mraidNativeFeatureOpenBrowser(String str) {
                if (HyBidEndCardView.this.endcardViewListener != null) {
                    HyBidEndCardView.this.endcardViewListener.onClick(str, HyBidEndCardView.this.isCustomEndCard, HyBidEndCardView.this.endCardType);
                }
            }
        };
        initUi();
        initControlViews();
    }

    public HyBidEndCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isViewShowingCloseButton = false;
        this.isViewShowingSkipButton = false;
        this.endCardType = "";
        this.skipOffset = new SkipOffset(SkipOffsetManager.getDefaultEndcardSkipOffset().intValue(), false);
        this.isCustomEndCard = false;
        this.hasReducedClose = false;
        this.mraidViewListener = new MRAIDViewListener() { // from class: net.pubnative.lite.sdk.views.endcard.HyBidEndCardView.1
            @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
            public void mraidShowCloseButton() {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
            public void mraidViewClose(MRAIDView mRAIDView) {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
            public void mraidViewExpand(MRAIDView mRAIDView) {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
            public boolean mraidViewResize(MRAIDView mRAIDView, int i2, int i3, int i4, int i5) {
                return false;
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
            public void onExpandedAdClosed() {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
            public void mraidViewLoaded(MRAIDView mRAIDView) {
                if (HyBidEndCardView.this.endcardViewListener != null) {
                    HyBidEndCardView.this.endcardViewListener.onLoadSuccess(HyBidEndCardView.this.isCustomEndCard);
                    HyBidEndCardView.this.endcardViewListener.onShow(HyBidEndCardView.this.isCustomEndCard, HyBidEndCardView.this.endCardType);
                }
                HyBidEndCardView.this.mHtmlEndCardView.getViewTreeObserver().addOnDrawListener(new ViewTreeObserverOnDrawListenerC08031());
            }

            /* JADX INFO: renamed from: net.pubnative.lite.sdk.views.endcard.HyBidEndCardView$1$1, reason: invalid class name and collision with other inner class name */
            class ViewTreeObserverOnDrawListenerC08031 implements ViewTreeObserver.OnDrawListener {
                ViewTreeObserverOnDrawListenerC08031() {
                }

                @Override // android.view.ViewTreeObserver.OnDrawListener
                public void onDraw() {
                    if (HyBidEndCardView.this.htmlEndCardContainer != null) {
                        HyBidEndCardView.this.htmlEndCardContainer.post(new Runnable() { // from class: net.pubnative.lite.sdk.views.endcard.HyBidEndCardView$1$1$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.m9828xa390ed90();
                            }
                        });
                    }
                    if (HyBidEndCardView.this.mHtmlEndCardView == null || HyBidEndCardView.this.mHtmlEndCardView.getMeasuredHeight() >= 50) {
                        return;
                    }
                    HyBidEndCardView.this.mHtmlEndCardView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                }

                /* JADX INFO: renamed from: lambda$onDraw$0$net-pubnative-lite-sdk-views-endcard-HyBidEndCardView$1$1, reason: not valid java name */
                /* synthetic */ void m9828xa390ed90() {
                    if (HyBidEndCardView.this.htmlEndCardContainer != null) {
                        HyBidEndCardView.this.htmlEndCardContainer.getViewTreeObserver().removeOnDrawListener(this);
                    }
                }
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
            public void mraidViewError(MRAIDView mRAIDView) {
                HyBidEndCardView.this.endcardViewListener.onLoadFail(HyBidEndCardView.this.isCustomEndCard);
            }
        };
        this.mraidNativeFeatureListener = new MRAIDNativeFeatureListener() { // from class: net.pubnative.lite.sdk.views.endcard.HyBidEndCardView.2
            @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
            public void mraidNativeFeatureCallTel(String str) {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
            public void mraidNativeFeatureCreateCalendarEvent(String str) {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
            public void mraidNativeFeaturePlayVideo(String str) {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
            public void mraidNativeFeatureSendSms(String str) {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
            public void mraidNativeFeatureStorePicture(String str) {
            }

            @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
            public void mraidNativeFeatureOpenBrowser(String str) {
                if (HyBidEndCardView.this.endcardViewListener != null) {
                    HyBidEndCardView.this.endcardViewListener.onClick(str, HyBidEndCardView.this.isCustomEndCard, HyBidEndCardView.this.endCardType);
                }
            }
        };
        initUi();
        initControlViews();
    }

    private void initControlViews() {
        if (!isValidContext()) {
            EndCardViewListener endCardViewListener = this.endcardViewListener;
            if (endCardViewListener != null) {
                endCardViewListener.onLoadFail(this.isCustomEndCard);
                return;
            }
            return;
        }
        int iConvertDpToPixel = (int) ViewUtils.convertDpToPixel(30.0f, getContext());
        if (this.hasReducedClose) {
            iConvertDpToPixel = (int) ViewUtils.convertDpToPixel(20.0f, getContext());
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iConvertDpToPixel, iConvertDpToPixel);
        layoutParams.gravity = GravityCompat.START;
        int iConvertDpToPixel2 = (int) ViewUtils.convertDpToPixel(8.0f, getContext());
        layoutParams.setMargins(iConvertDpToPixel2, iConvertDpToPixel2, 0, 0);
        ImageView imageView = new ImageView(getContext());
        this.mSkipView = imageView;
        if (this.hasReducedClose) {
            imageView.setId(R.id.end_card_skip_view_small);
        } else {
            imageView.setId(R.id.end_card_skip_view);
        }
        this.mSkipView.setLayoutParams(layoutParams);
        this.mSkipView.setImageResource(R.mipmap.skip);
        this.mSkipView.setVisibility(8);
        this.mSkipView.setOnClickListener(new View.OnClickListener() { // from class: net.pubnative.lite.sdk.views.endcard.HyBidEndCardView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m9824xedb464f4(view);
            }
        });
        ImageView imageView2 = new ImageView(getContext());
        this.mCloseView = imageView2;
        if (this.hasReducedClose) {
            imageView2.setId(R.id.button_fullscreen_close_small);
        } else {
            imageView2.setId(R.id.button_fullscreen_close);
        }
        this.mCloseView.setLayoutParams(layoutParams);
        this.mCloseView.setImageResource(R.mipmap.close);
        this.mCloseView.setVisibility(8);
        this.mCloseView.setOnClickListener(new View.OnClickListener() { // from class: net.pubnative.lite.sdk.views.endcard.HyBidEndCardView$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m9825x1708ba35(view);
            }
        });
        addView(this.mSkipView);
        addView(this.mCloseView);
    }

    /* JADX INFO: renamed from: lambda$initControlViews$0$net-pubnative-lite-sdk-views-endcard-HyBidEndCardView, reason: not valid java name */
    /* synthetic */ void m9824xedb464f4(View view) {
        EndCardViewListener endCardViewListener = this.endcardViewListener;
        if (endCardViewListener != null) {
            endCardViewListener.onSkip();
        }
    }

    /* JADX INFO: renamed from: lambda$initControlViews$1$net-pubnative-lite-sdk-views-endcard-HyBidEndCardView, reason: not valid java name */
    /* synthetic */ void m9825x1708ba35(View view) {
        EndCardViewListener endCardViewListener = this.endcardViewListener;
        if (endCardViewListener != null) {
            endCardViewListener.onClose(this.isCustomEndCard);
        }
    }

    public void setSkipOffset(SkipOffset skipOffset) {
        this.skipOffset = skipOffset;
    }

    public void setEndCardViewListener(EndCardViewListener endCardViewListener) {
        this.endcardViewListener = endCardViewListener;
    }

    private void initUi() {
        if (!isValidContext()) {
            EndCardViewListener endCardViewListener = this.endcardViewListener;
            if (endCardViewListener != null) {
                endCardViewListener.onLoadFail(this.isCustomEndCard);
                return;
            }
            return;
        }
        setVisibility(8);
        setBackgroundColor(0);
        try {
            this.gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: net.pubnative.lite.sdk.views.endcard.HyBidEndCardView.3
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    return true;
                }
            });
        } catch (Exception unused) {
        }
    }

    private ImageView createStaticEndCardView() {
        if (!isValidContext()) {
            return null;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        CustomImageView customImageView = new CustomImageView(getContext());
        customImageView.setLayoutParams(layoutParams);
        customImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        customImageView.setVisibility(8);
        customImageView.setOnClickListener(new View.OnClickListener() { // from class: net.pubnative.lite.sdk.views.endcard.HyBidEndCardView$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m9823x532c5801(view);
            }
        });
        this.endCardType = "static";
        return customImageView;
    }

    /* JADX INFO: renamed from: lambda$createStaticEndCardView$2$net-pubnative-lite-sdk-views-endcard-HyBidEndCardView, reason: not valid java name */
    /* synthetic */ void m9823x532c5801(View view) {
        EndCardViewListener endCardViewListener = this.endcardViewListener;
        if (endCardViewListener != null) {
            endCardViewListener.onClick(null, this.isCustomEndCard, this.endCardType);
        }
    }

    private FrameLayout createHtmlEndCardContainer() {
        if (!isValidContext()) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setVisibility(8);
        frameLayout.setBackgroundColor(0);
        return frameLayout;
    }

    public void show(final EndCardData endCardData, String str) {
        EndCardViewListener endCardViewListener;
        removeExistingEndcardViews();
        setVisibility(0);
        if (endCardData != null) {
            this.isCustomEndCard = endCardData.isCustom();
            configUi(endCardData);
            clearEndCardViews();
            if (endCardData.getType() == EndCardData.Type.STATIC_RESOURCE) {
                ImageView imageViewCreateStaticEndCardView = createStaticEndCardView();
                this.staticEndCardView = imageViewCreateStaticEndCardView;
                if (imageViewCreateStaticEndCardView == null) {
                    EndCardViewListener endCardViewListener2 = this.endcardViewListener;
                    if (endCardViewListener2 != null) {
                        endCardViewListener2.onLoadFail(this.isCustomEndCard);
                        return;
                    }
                    return;
                }
                addView(imageViewCreateStaticEndCardView);
                this.staticEndCardView.setVisibility(0);
                ImageUtils.setScaledImage(this.staticEndCardView, str);
                EndCardViewListener endCardViewListener3 = this.endcardViewListener;
                if (endCardViewListener3 != null) {
                    endCardViewListener3.onLoadSuccess(this.isCustomEndCard);
                    this.endcardViewListener.onShow(endCardData.isCustom(), this.endCardType);
                }
                this.endCardType = "static";
                return;
            }
            if (TextUtils.isEmpty(endCardData.getContent())) {
                return;
            }
            FrameLayout frameLayoutCreateHtmlEndCardContainer = createHtmlEndCardContainer();
            this.htmlEndCardContainer = frameLayoutCreateHtmlEndCardContainer;
            if (frameLayoutCreateHtmlEndCardContainer == null) {
                EndCardViewListener endCardViewListener4 = this.endcardViewListener;
                if (endCardViewListener4 != null) {
                    endCardViewListener4.onLoadFail(this.isCustomEndCard);
                    return;
                }
                return;
            }
            addView(frameLayoutCreateHtmlEndCardContainer);
            this.htmlEndCardContainer.setVisibility(0);
            if (endCardData.getType() == EndCardData.Type.IFRAME_RESOURCE) {
                this.endCardType = Reporting.Key.END_CARD_IFRAME;
                if (!isValidContext() && (endCardViewListener = this.endcardViewListener) != null) {
                    endCardViewListener.onLoadFail(this.isCustomEndCard);
                }
                PNHttpClient.makeRequest(getContext(), endCardData.getContent(), null, null, true, new PNHttpClient.Listener() { // from class: net.pubnative.lite.sdk.views.endcard.HyBidEndCardView.4
                    @Override // net.pubnative.lite.sdk.network.PNHttpClient.Listener
                    public void onFailure(Throwable th) {
                    }

                    @Override // net.pubnative.lite.sdk.network.PNHttpClient.Listener
                    public void onSuccess(String str2, Map<String, List<String>> map) {
                        if (TextUtils.isEmpty(str2)) {
                            return;
                        }
                        HyBidEndCardView.this.renderHtmlEndcard(str2, endCardData.isCustom().booleanValue());
                    }
                });
                return;
            }
            this.endCardType = "html";
            renderHtmlEndcard(endCardData.getContent(), endCardData.isCustom().booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renderHtmlEndcard(String str, boolean z) {
        if (!isValidContext()) {
            this.endcardViewListener.onLoadFail(this.isCustomEndCard);
            return;
        }
        MRAIDBanner mRAIDBanner = new MRAIDBanner(getContext(), "", str, false, false, new String[0], this.mraidViewListener, this.mraidNativeFeatureListener, null);
        this.mHtmlEndCardView = mRAIDBanner;
        mRAIDBanner.setSkipOffset(Integer.valueOf(this.skipOffset.getOffset()));
        this.mHtmlEndCardView.setUseCustomClose(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, z ? -1 : -2);
        layoutParams.gravity = 16;
        this.mHtmlEndCardView.setLayoutParams(layoutParams);
        FrameLayout frameLayout = this.htmlEndCardContainer;
        if (frameLayout != null) {
            frameLayout.addView(this.mHtmlEndCardView);
            EndCardViewListener endCardViewListener = this.endcardViewListener;
            if (endCardViewListener != null) {
                endCardViewListener.onLoadSuccess(this.isCustomEndCard);
                this.endcardViewListener.onShow(this.isCustomEndCard, this.endCardType);
                return;
            }
            return;
        }
        EndCardViewListener endCardViewListener2 = this.endcardViewListener;
        if (endCardViewListener2 != null) {
            endCardViewListener2.onLoadFail(this.isCustomEndCard);
        }
    }

    private void removeExistingEndcardViews() {
        ImageView imageView = this.staticEndCardView;
        if (imageView != null) {
            removeView(imageView);
            this.staticEndCardView = null;
        }
        FrameLayout frameLayout = this.htmlEndCardContainer;
        if (frameLayout != null) {
            removeView(frameLayout);
            this.htmlEndCardContainer = null;
        }
    }

    private void configUi(EndCardData endCardData) {
        if (endCardData == null) {
            return;
        }
        if (endCardData.isCustom().booleanValue()) {
            setBackgroundColor(0);
        } else {
            setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
    }

    public void show(String str) {
        clearEndCardViews();
        ImageView imageViewCreateStaticEndCardView = createStaticEndCardView();
        this.staticEndCardView = imageViewCreateStaticEndCardView;
        if (imageViewCreateStaticEndCardView == null) {
            this.endcardViewListener.onLoadFail(this.isCustomEndCard);
            return;
        }
        addView(imageViewCreateStaticEndCardView);
        this.staticEndCardView.setVisibility(0);
        ImageUtils.setScaledImage(this.staticEndCardView, str);
    }

    public void hide() {
        clearEndCardViews();
        setVisibility(8);
    }

    public void hideSkipButton() {
        this.mSkipView.setVisibility(8);
    }

    public synchronized void showSkipButton() {
        if (!this.isViewShowingSkipButton) {
            this.mCloseView.setVisibility(4);
            startSkipOffsetTimer(new Runnable() { // from class: net.pubnative.lite.sdk.views.endcard.HyBidEndCardView$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m9827x326f2924();
                }
            });
            this.isViewShowingSkipButton = true;
        }
    }

    /* JADX INFO: renamed from: lambda$showSkipButton$3$net-pubnative-lite-sdk-views-endcard-HyBidEndCardView, reason: not valid java name */
    /* synthetic */ void m9827x326f2924() {
        this.mSkipView.setVisibility(0);
        this.mSkipView.bringToFront();
    }

    public synchronized void showCloseButton(final CloseButtonListener closeButtonListener) {
        if (!this.isViewShowingCloseButton) {
            this.mSkipView.setVisibility(4);
            startCloseTimer(new Runnable() { // from class: net.pubnative.lite.sdk.views.endcard.HyBidEndCardView$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m9826x247565aa(closeButtonListener);
                }
            });
            this.isViewShowingCloseButton = true;
        }
    }

    /* JADX INFO: renamed from: lambda$showCloseButton$4$net-pubnative-lite-sdk-views-endcard-HyBidEndCardView, reason: not valid java name */
    /* synthetic */ void m9826x247565aa(CloseButtonListener closeButtonListener) {
        this.mCloseView.setVisibility(0);
        this.mCloseView.bringToFront();
        closeButtonListener.onCloseButtonVisible();
    }

    public synchronized void startSkipOffsetTimer(final Runnable runnable) {
        int offset = this.skipOffset.getOffset();
        if (offset >= 0) {
            SimpleTimer simpleTimer = new SimpleTimer(((long) offset) * 1000, new SimpleTimer.Listener() { // from class: net.pubnative.lite.sdk.views.endcard.HyBidEndCardView.5
                @Override // net.pubnative.lite.sdk.vpaid.helpers.SimpleTimer.Listener
                public void onTick(long j) {
                }

                @Override // net.pubnative.lite.sdk.vpaid.helpers.SimpleTimer.Listener
                public void onFinish() {
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                    if (HyBidEndCardView.this.mSkipEndcardTimer != null) {
                        HyBidEndCardView.this.mSkipEndcardTimer.cancel();
                        HyBidEndCardView.this.mSkipEndcardTimer = null;
                    }
                    HyBidEndCardView.this.isViewShowingSkipButton = false;
                }
            });
            this.mSkipEndcardTimer = simpleTimer;
            simpleTimer.start();
        } else {
            runnable.run();
        }
    }

    public synchronized void startCloseTimer(final Runnable runnable) {
        int offset = this.skipOffset.getOffset();
        if (offset >= 0) {
            SimpleTimer simpleTimer = new SimpleTimer(((long) offset) * 1000, new SimpleTimer.Listener() { // from class: net.pubnative.lite.sdk.views.endcard.HyBidEndCardView.6
                @Override // net.pubnative.lite.sdk.vpaid.helpers.SimpleTimer.Listener
                public void onTick(long j) {
                }

                @Override // net.pubnative.lite.sdk.vpaid.helpers.SimpleTimer.Listener
                public void onFinish() {
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                    if (HyBidEndCardView.this.mCloseEndcardTimer != null) {
                        HyBidEndCardView.this.mCloseEndcardTimer.cancel();
                        HyBidEndCardView.this.mCloseEndcardTimer = null;
                    }
                    HyBidEndCardView.this.isViewShowingCloseButton = false;
                }
            });
            this.mCloseEndcardTimer = simpleTimer;
            simpleTimer.start();
        } else {
            runnable.run();
        }
    }

    public void pause() {
        SimpleTimer simpleTimer = this.mSkipEndcardTimer;
        if (simpleTimer != null) {
            simpleTimer.pause();
        }
        SimpleTimer simpleTimer2 = this.mCloseEndcardTimer;
        if (simpleTimer2 != null) {
            simpleTimer2.pause();
        }
        MRAIDBanner mRAIDBanner = this.mHtmlEndCardView;
        if (mRAIDBanner != null) {
            mRAIDBanner.pause();
        }
    }

    public void resume() {
        SimpleTimer simpleTimer = this.mSkipEndcardTimer;
        if (simpleTimer != null) {
            simpleTimer.resume();
        }
        SimpleTimer simpleTimer2 = this.mCloseEndcardTimer;
        if (simpleTimer2 != null) {
            simpleTimer2.resume();
        }
        MRAIDBanner mRAIDBanner = this.mHtmlEndCardView;
        if (mRAIDBanner != null) {
            mRAIDBanner.resume();
        }
    }

    private void clearEndCardViews() {
        FrameLayout frameLayout = this.htmlEndCardContainer;
        if (frameLayout != null) {
            removeView(frameLayout);
            this.htmlEndCardContainer = null;
        }
        ImageView imageView = this.staticEndCardView;
        if (imageView != null) {
            removeView(imageView);
            this.staticEndCardView.setImageDrawable(null);
            this.staticEndCardView = null;
            MRAIDBanner mRAIDBanner = this.mHtmlEndCardView;
            if (mRAIDBanner != null) {
                mRAIDBanner.destroy();
            }
        }
    }

    public void destroy() {
        SimpleTimer simpleTimer = this.mSkipEndcardTimer;
        if (simpleTimer != null) {
            simpleTimer.cancel();
        }
        SimpleTimer simpleTimer2 = this.mCloseEndcardTimer;
        if (simpleTimer2 != null) {
            simpleTimer2.cancel();
        }
        clearEndCardViews();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector = this.gestureDetector;
        if (gestureDetector != null && gestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.onTouchEvent(motionEvent);
    }

    private boolean isValidContext() {
        return getContext() != null;
    }
}
