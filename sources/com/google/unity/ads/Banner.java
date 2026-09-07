package com.google.unity.ads;

import android.app.Activity;
import android.os.Build;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.BaseAdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes6.dex */
public class Banner {
    protected BaseAdView adView;
    protected boolean hidden;
    private int mHorizontalOffset;
    private View.OnLayoutChangeListener mLayoutChangeListener;
    private int mPositionCode;
    private int mVerticalOffset;
    protected UnityAdListener unityListener;
    protected Activity unityPlayerActivity;

    protected static class Insets {
        int top = 0;
        int bottom = 0;
        int left = 0;
        int right = 0;

        protected Insets() {
        }
    }

    protected Banner() {
    }

    public Banner(Activity activity, UnityAdListener listener) {
        this.unityPlayerActivity = activity;
        this.unityListener = listener;
    }

    public void create(final String publisherId, final AdSize adSize, final int positionCode) {
        this.unityPlayerActivity.runOnUiThread(new Runnable(this) { // from class: com.google.unity.ads.Banner.1
            final /* synthetic */ Banner this$0;

            {
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.this$0.createAdView(publisherId, adSize);
                this.this$0.mHorizontalOffset = 0;
                this.this$0.mVerticalOffset = 0;
                this.this$0.mPositionCode = positionCode;
                this.this$0.hidden = false;
            }
        });
    }

    public void create(final String publisherId, final AdSize adSize, final int positionX, final int positionY) {
        this.unityPlayerActivity.runOnUiThread(new Runnable(this) { // from class: com.google.unity.ads.Banner.2
            final /* synthetic */ Banner this$0;

            {
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.this$0.createAdView(publisherId, adSize);
                this.this$0.mPositionCode = -1;
                this.this$0.mHorizontalOffset = positionX;
                this.this$0.mVerticalOffset = positionY;
                this.this$0.hidden = false;
            }
        });
    }

    protected void createAdView(final String publisherId, final AdSize adSize) {
        AdView adView = new AdView(this.unityPlayerActivity);
        this.adView = adView;
        adView.setBackgroundColor(0);
        this.adView.setAdUnitId(publisherId);
        this.adView.setAdSize(adSize);
        this.adView.setVisibility(8);
        this.adView.setDescendantFocusability(393216);
        this.unityPlayerActivity.addContentView(this.adView, getLayoutParams());
        this.adView.setAdListener(new AdListener() { // from class: com.google.unity.ads.Banner.3
            @Override // com.google.android.gms.ads.AdListener
            public void onAdLoaded() {
                if (Banner.this.unityListener != null) {
                    if (!Banner.this.hidden) {
                        Banner.this.show();
                    }
                    new Thread(new Runnable() { // from class: com.google.unity.ads.Banner.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (Banner.this.unityListener != null) {
                                Banner.this.unityListener.onAdLoaded();
                            }
                        }
                    }).start();
                }
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(final LoadAdError error) {
                if (Banner.this.unityListener != null) {
                    new Thread(new Runnable(this) { // from class: com.google.unity.ads.Banner.3.2
                        final /* synthetic */ AnonymousClass3 this$1;

                        {
                            this.this$1 = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (Banner.this.unityListener != null) {
                                Banner.this.unityListener.onAdFailedToLoad(error);
                            }
                        }
                    }).start();
                }
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdOpened() {
                if (Banner.this.unityListener != null) {
                    new Thread(new Runnable() { // from class: com.google.unity.ads.Banner.3.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (Banner.this.unityListener != null) {
                                Banner.this.unityListener.onAdOpened();
                            }
                        }
                    }).start();
                }
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdClosed() {
                if (Banner.this.unityListener != null) {
                    new Thread(new Runnable() { // from class: com.google.unity.ads.Banner.3.4
                        @Override // java.lang.Runnable
                        public void run() {
                            if (Banner.this.unityListener != null) {
                                Banner.this.unityListener.onAdClosed();
                            }
                        }
                    }).start();
                }
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdImpression() {
                if (Banner.this.unityListener != null) {
                    new Thread(new Runnable() { // from class: com.google.unity.ads.Banner.3.5
                        @Override // java.lang.Runnable
                        public void run() {
                            if (Banner.this.unityListener != null) {
                                Banner.this.unityListener.onAdImpression();
                            }
                        }
                    }).start();
                }
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdClicked() {
                if (Banner.this.unityListener != null) {
                    new Thread(new Runnable() { // from class: com.google.unity.ads.Banner.3.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (Banner.this.unityListener != null) {
                                Banner.this.unityListener.onAdClicked();
                            }
                        }
                    }).start();
                }
            }
        });
        this.adView.setOnPaidEventListener(new OnPaidEventListener() { // from class: com.google.unity.ads.Banner.4
            @Override // com.google.android.gms.ads.OnPaidEventListener
            public void onPaidEvent(final AdValue adValue) {
                if (Banner.this.unityListener != null) {
                    new Thread(new Runnable(this) { // from class: com.google.unity.ads.Banner.4.1
                        final /* synthetic */ AnonymousClass4 this$1;

                        {
                            this.this$1 = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (Banner.this.unityListener != null) {
                                Banner.this.unityListener.onPaidEvent(adValue.getPrecisionType(), adValue.getValueMicros(), adValue.getCurrencyCode());
                            }
                        }
                    }).start();
                }
            }
        });
        setLayoutChangeListener();
    }

    protected void setLayoutChangeListener() {
        this.mLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.google.unity.ads.Banner.5
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                if ((left == oldLeft && right == oldRight && bottom == oldBottom && top == oldTop) || Banner.this.hidden) {
                    return;
                }
                Banner.this.updatePosition();
            }
        };
        this.unityPlayerActivity.getWindow().getDecorView().getRootView().addOnLayoutChangeListener(this.mLayoutChangeListener);
    }

    public void loadAd(final AdRequest request) {
        this.unityPlayerActivity.runOnUiThread(new Runnable(this) { // from class: com.google.unity.ads.Banner.6
            final /* synthetic */ Banner this$0;

            {
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.d(PluginUtils.LOGTAG, "Calling loadAd() on Android");
                this.this$0.adView.loadAd(request);
            }
        });
    }

    public void show() {
        this.unityPlayerActivity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.Banner.7
            @Override // java.lang.Runnable
            public void run() {
                Log.d(PluginUtils.LOGTAG, "Calling show() on Android");
                Banner.this.hidden = false;
                Banner.this.adView.setVisibility(0);
                Banner.this.updatePosition();
                Banner.this.adView.resume();
            }
        });
    }

    public void hide() {
        this.unityPlayerActivity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.Banner.8
            @Override // java.lang.Runnable
            public void run() {
                Log.d(PluginUtils.LOGTAG, "Calling hide() on Android");
                Banner.this.hidden = true;
                Banner.this.adView.setVisibility(8);
                Banner.this.adView.pause();
            }
        });
    }

    public void destroy() {
        this.unityPlayerActivity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.Banner.9
            @Override // java.lang.Runnable
            public void run() {
                Log.d(PluginUtils.LOGTAG, "Calling destroy() on Android");
                if (Banner.this.adView != null) {
                    Banner.this.adView.destroy();
                    ViewParent parent = Banner.this.adView.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(Banner.this.adView);
                    }
                }
            }
        });
        this.unityPlayerActivity.getWindow().getDecorView().getRootView().removeOnLayoutChangeListener(this.mLayoutChangeListener);
    }

    public String getAdUnitId() {
        BaseAdView baseAdView = this.adView;
        if (baseAdView == null) {
            return null;
        }
        return baseAdView.getAdUnitId();
    }

    public float getHeightInPixels() {
        FutureTask futureTask = new FutureTask(new Callable<Integer>() { // from class: com.google.unity.ads.Banner.10
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                return Integer.valueOf(Banner.this.adView.getAdSize().getHeightInPixels(Banner.this.unityPlayerActivity));
            }
        });
        this.unityPlayerActivity.runOnUiThread(futureTask);
        try {
            return ((Integer) futureTask.get()).intValue();
        } catch (InterruptedException e) {
            Log.e(PluginUtils.LOGTAG, String.format("Failed to get ad view height: %s", e.getLocalizedMessage()));
            return -1.0f;
        } catch (ExecutionException e2) {
            Log.e(PluginUtils.LOGTAG, String.format("Failed to get ad view height: %s", e2.getLocalizedMessage()));
            return -1.0f;
        }
    }

    public float getWidthInPixels() {
        FutureTask futureTask = new FutureTask(new Callable<Integer>() { // from class: com.google.unity.ads.Banner.11
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                return Integer.valueOf(Banner.this.adView.getAdSize().getWidthInPixels(Banner.this.unityPlayerActivity));
            }
        });
        this.unityPlayerActivity.runOnUiThread(futureTask);
        try {
            return ((Integer) futureTask.get()).intValue();
        } catch (InterruptedException e) {
            Log.e(PluginUtils.LOGTAG, String.format("Failed to get ad view width: %s", e.getLocalizedMessage()));
            return -1.0f;
        } catch (ExecutionException e2) {
            Log.e(PluginUtils.LOGTAG, String.format("Failed to get ad view width: %s", e2.getLocalizedMessage()));
            return -1.0f;
        }
    }

    public void setPosition(final int positionCode) {
        this.unityPlayerActivity.runOnUiThread(new Runnable(this) { // from class: com.google.unity.ads.Banner.12
            final /* synthetic */ Banner this$0;

            {
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.this$0.mPositionCode = positionCode;
                this.this$0.updatePosition();
            }
        });
    }

    public void setPosition(final int positionX, final int positionY) {
        this.unityPlayerActivity.runOnUiThread(new Runnable(this) { // from class: com.google.unity.ads.Banner.13
            final /* synthetic */ Banner this$0;

            {
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.this$0.mPositionCode = -1;
                this.this$0.mHorizontalOffset = positionX;
                this.this$0.mVerticalOffset = positionY;
                this.this$0.updatePosition();
            }
        });
    }

    public boolean isCollapsible() {
        BaseAdView baseAdView = this.adView;
        if (baseAdView == null) {
            return false;
        }
        return baseAdView.isCollapsible();
    }

    protected FrameLayout.LayoutParams getLayoutParams() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = PluginUtils.getLayoutGravityForPositionCode(this.mPositionCode);
        Insets safeInsets = getSafeInsets();
        int i = safeInsets.left;
        int i2 = safeInsets.top;
        layoutParams.bottomMargin = safeInsets.bottom;
        layoutParams.rightMargin = safeInsets.right;
        if (this.mPositionCode == -1) {
            int iConvertDpToPixel = (int) PluginUtils.convertDpToPixel(this.mHorizontalOffset);
            if (iConvertDpToPixel >= i) {
                i = iConvertDpToPixel;
            }
            int iConvertDpToPixel2 = (int) PluginUtils.convertDpToPixel(this.mVerticalOffset);
            if (iConvertDpToPixel2 >= i2) {
                i2 = iConvertDpToPixel2;
            }
            layoutParams.leftMargin = i;
            layoutParams.topMargin = i2;
        } else {
            layoutParams.leftMargin = i;
            int i3 = this.mPositionCode;
            if (i3 == 0 || i3 == 2 || i3 == 3) {
                layoutParams.topMargin = i2;
            }
        }
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePosition() {
        if (this.adView == null || this.hidden) {
            return;
        }
        this.unityPlayerActivity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.Banner.14
            @Override // java.lang.Runnable
            public void run() {
                Banner.this.adView.setLayoutParams(Banner.this.getLayoutParams());
            }
        });
    }

    private Insets getSafeInsets() {
        Window window;
        WindowInsets rootWindowInsets;
        DisplayCutout displayCutout;
        Insets insets = new Insets();
        if (Build.VERSION.SDK_INT < 28 || (window = this.unityPlayerActivity.getWindow()) == null || (rootWindowInsets = window.getDecorView().getRootWindowInsets()) == null || (displayCutout = rootWindowInsets.getDisplayCutout()) == null) {
            return insets;
        }
        insets.top = displayCutout.getSafeInsetTop();
        insets.left = displayCutout.getSafeInsetLeft();
        insets.bottom = displayCutout.getSafeInsetBottom();
        insets.right = displayCutout.getSafeInsetRight();
        return insets;
    }

    public ResponseInfo getResponseInfo() {
        FutureTask futureTask = new FutureTask(new Callable() { // from class: com.google.unity.ads.Banner$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m5322lambda$getResponseInfo$0$comgoogleunityadsBanner();
            }
        });
        this.unityPlayerActivity.runOnUiThread(futureTask);
        try {
            return (ResponseInfo) futureTask.get();
        } catch (InterruptedException | ExecutionException e) {
            Log.e(PluginUtils.LOGTAG, String.format("Unable to check banner response info: %s", e.getLocalizedMessage()));
            return null;
        }
    }

    /* JADX INFO: renamed from: lambda$getResponseInfo$0$com-google-unity-ads-Banner, reason: not valid java name */
    /* synthetic */ ResponseInfo m5322lambda$getResponseInfo$0$comgoogleunityadsBanner() throws Exception {
        return this.adView.getResponseInfo();
    }
}
