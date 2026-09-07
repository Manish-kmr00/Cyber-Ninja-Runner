package com.amazon.device.ads;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.amazon.aps.shared.APSAnalytics;
import com.amazon.aps.shared.ApsMetrics;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import com.json.b9;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.internal.partials.AmazonPublisherServicesNetworkBridge;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import com.smaato.sdk.richmedia.mraid.bridge.MraidJsMethods;
import com.unity3d.ads.adplayer.AndroidWebViewClient;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public class DTBAdMRAIDBannerController extends DTBAdMRAIDController implements DTBMRAIDCloseButtonListener {
    private static final int ANIMATION_DURATION = 500;
    private static List<WeakReference<DTBAdMRAIDBannerController>> bannerControllers = new ArrayList();
    private static AtomicInteger indexDispencer = new AtomicInteger(100);
    private ObjectAnimator animater;
    private float animationProgress;
    public DTBAdBannerListener bannerListener;
    private ViewGroup defaultParent;
    private AnimationPoint endAnimation;
    private ViewGroup expandedBackground;
    private int index;
    private int originalHeight;
    private ViewGroup.LayoutParams originalParams;
    private int originalWidth;
    private float originalX;
    private int originalXPos;
    private float originalY;
    private int originalYPos;
    private AnimationPoint startAnimation;

    public static void safedk_Activity_startActivity_9d898b58165fa4ba0e12c3900a2b8533(Activity p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.A);
        p0.startActivity(p1);
    }

    protected boolean onBackPressed() {
        return false;
    }

    class AnimationPoint {
        int height;
        int width;
        int xPos;
        int yPos;

        AnimationPoint(int i, int i2, int i3, int i4) {
            this.xPos = i;
            this.yPos = i2;
            this.width = i3;
            this.height = i4;
        }
    }

    public void setAnimationProgress(float f) {
        this.animationProgress = f;
    }

    public DTBAdMRAIDBannerController(DTBAdView dTBAdView, DTBAdBannerListener dTBAdBannerListener) {
        super(dTBAdView);
        this.index = indexDispencer.incrementAndGet();
        this.bannerListener = dTBAdBannerListener;
        this.customButtonListener = this;
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController
    public void onPageLoad() {
        try {
            if (!this.pageLoaded) {
                prepareMraid();
                if (DTBMetricsConfiguration.getInstance().isFeatureEnabled("additional_webview_metric")) {
                    ApsMetrics.customEvent("bannerCreativeFinished", getAdView().getBidId(), null);
                }
            }
        } catch (Exception e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to execute onPageLoad for Banner", e);
        }
        this.originalParams = getAdView().getLayoutParams();
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController
    protected String getPlacementType() {
        return POBCommonConstants.BANNER_PLACEMENT_TYPE;
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController
    protected void onMRAIDClose() {
        if (this.state == MraidStateType.RESIZED) {
            moveResizedToDefault();
            return;
        }
        if (this.state == MraidStateType.EXPANDED) {
            moveExpandedToDefault();
        } else if (this.state == MraidStateType.DEFAULT) {
            setState(MraidStateType.HIDDEN);
            commandCompleted("close");
        } else {
            fireErrorEvent("close", "Command is not allowed in a given ad state:" + this.state.toString());
            commandCompleted("close");
        }
    }

    private void moveResizedToDefault() {
        moveResizedToDefault(500, false);
    }

    private void moveResizedToDefault(final int i, final boolean z) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.amazon.device.ads.DTBAdMRAIDBannerController$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m4383x95f8c355(i, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: moveResizedToDefaultImpl, reason: merged with bridge method [inline-methods] */
    public void m4383x95f8c355(int i, final boolean z) {
        AnimationPoint animationPoint = this.startAnimation;
        this.startAnimation = this.endAnimation;
        this.endAnimation = animationPoint;
        animationPoint.height = this.originalHeight;
        this.endAnimation.width = this.originalWidth;
        this.endAnimation.xPos = this.originalXPos;
        this.endAnimation.yPos = this.originalYPos;
        final ViewGroup viewGroup = (ViewGroup) getAdView().getParent();
        if (this.closeIndicatorRegion != null) {
            viewGroup.removeView(this.closeIndicatorRegion);
            this.closeIndicatorRegion = null;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "animationProgress", 0.0f, 1.0f);
        this.animater = objectAnimatorOfFloat;
        objectAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.amazon.device.ads.DTBAdMRAIDBannerController$$ExternalSyntheticLambda18
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.m4384x542b1d34(viewGroup, z, valueAnimator);
            }
        });
        this.animater.setDuration(i);
        this.animater.start();
    }

    /* JADX INFO: renamed from: lambda$moveResizedToDefaultImpl$1$com-amazon-device-ads-DTBAdMRAIDBannerController, reason: not valid java name */
    /* synthetic */ void m4384x542b1d34(ViewGroup viewGroup, boolean z, ValueAnimator valueAnimator) {
        if (updateAdViewLayout(valueAnimator).floatValue() == 1.0f) {
            updateResizedToDefaultListener(viewGroup, z);
        }
    }

    private void moveExpandedToDefault() {
        moveExpandedToDefault(500, false);
    }

    private void moveExpandedToDefault(final int i, final boolean z) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.amazon.device.ads.DTBAdMRAIDBannerController$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m4381x70d963b8(i, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: moveExpandedToDefaultImpl, reason: merged with bridge method [inline-methods] */
    public void m4381x70d963b8(int i, final boolean z) {
        ViewGroup viewGroup;
        AnimationPoint animationPoint = this.startAnimation;
        this.startAnimation = this.endAnimation;
        this.endAnimation = animationPoint;
        final ViewGroup viewGroup2 = (ViewGroup) getAdView().getParent();
        if (this.closeIndicatorRegion != null && (viewGroup = (ViewGroup) this.closeIndicatorRegion.getParent()) != null) {
            viewGroup.removeView(this.closeIndicatorRegion);
            this.closeIndicatorRegion = null;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "animationProgress", 0.0f, 1.0f);
        this.animater = objectAnimatorOfFloat;
        objectAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.amazon.device.ads.DTBAdMRAIDBannerController$$ExternalSyntheticLambda5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.m4382x424b2317(viewGroup2, z, valueAnimator);
            }
        });
        this.animater.setDuration(i);
        this.animater.start();
    }

    /* JADX INFO: renamed from: lambda$moveExpandedToDefaultImpl$3$com-amazon-device-ads-DTBAdMRAIDBannerController, reason: not valid java name */
    /* synthetic */ void m4382x424b2317(ViewGroup viewGroup, boolean z, ValueAnimator valueAnimator) {
        if (updateAdViewLayout(valueAnimator).floatValue() == 1.0f) {
            updateExpandedToDefaultListener(viewGroup, z);
        }
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController
    protected void onMRAIDUnload() {
        if (this.state == MraidStateType.RESIZED) {
            moveResizedToDefault(10, true);
        } else if (this.state == MraidStateType.EXPANDED) {
            moveExpandedToDefault(10, true);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.amazon.device.ads.DTBAdMRAIDBannerController$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m4389x86d5afdb();
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$onMRAIDUnload$4$com-amazon-device-ads-DTBAdMRAIDBannerController, reason: not valid java name */
    /* synthetic */ void m4389x86d5afdb() {
        AmazonPublisherServicesNetworkBridge.webviewLoadUrl(getAdView(), AndroidWebViewClient.BLANK_PAGE);
        commandCompleted(MraidJsMethods.UNLOAD);
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController
    protected void onResize(Map<String, Object> map) {
        if (this.state != MraidStateType.DEFAULT && this.state != MraidStateType.RESIZED) {
            fireErrorEvent("resize", "invalid current state");
            commandCompleted("resize");
            return;
        }
        try {
            final int iIntValue = map.containsKey("offsetX") ? ((Integer) map.get("offsetX")).intValue() : 0;
            final int iIntValue2 = map.containsKey("offsetY") ? ((Integer) map.get("offsetY")).intValue() : 0;
            final int iIntValue3 = ((Integer) map.get("width")).intValue();
            final int iIntValue4 = ((Integer) map.get("height")).intValue();
            final boolean zBooleanValue = ((Boolean) map.get("allowOffscreen")).booleanValue();
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.amazon.device.ads.DTBAdMRAIDBannerController$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m4390x765d2064(iIntValue, iIntValue2, iIntValue3, iIntValue4, zBooleanValue);
                }
            });
        } catch (Exception unused) {
            fireErrorEvent("resize", "invalid input parameters");
            commandCompleted("resize");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:21:0x00b6 A[PHI: r2 r4
  0x00b6: PHI (r2v3 int) = (r2v2 int), (r2v13 int) binds: [B:10:0x00a2, B:19:0x00b1] A[DONT_GENERATE, DONT_INLINE]
  0x00b6: PHI (r4v3 int) = (r4v2 int), (r4v8 int) binds: [B:10:0x00a2, B:19:0x00b1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:36:0x00fc A[PHI: r0 r1
  0x00fc: PHI (r0v7 int) = (r0v6 int), (r0v19 int) binds: [B:23:0x00e4, B:34:0x00f7] A[DONT_GENERATE, DONT_INLINE]
  0x00fc: PHI (r1v5 int) = (r1v4 int), (r1v19 int) binds: [B:23:0x00e4, B:34:0x00f7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: onResizeImpl, reason: merged with bridge method [inline-methods] */
    public void m4390x765d2064(int i, int i2, int i3, int i4, boolean z) {
        int i5;
        int i6;
        int i7;
        int i8;
        ViewGroup rootView = DTBAdUtil.getRootView(getAdView());
        if (rootView == null) {
            fireErrorEvent("resize", "rootview doesn't exist");
            commandCompleted("resize");
            return;
        }
        removeCloseIndicator();
        int[] iArr = new int[2];
        getAdView().getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        rootView.getLocationInWindow(iArr2);
        if (this.defaultParent == null) {
            this.originalX = getAdView().getX();
            this.originalY = getAdView().getY();
            this.originalWidth = getAdView().getWidth();
            this.originalHeight = getAdView().getHeight();
            this.originalXPos = iArr[0] - iArr2[0];
            this.originalYPos = iArr[1] - iArr2[1];
            this.defaultParent = (ViewGroup) getAdView().getParent();
            this.originalParams = getAdView().getLayoutParams();
            getAdView().setIgnoreDetachment();
            this.defaultParent.removeView(getAdView());
        }
        int height = rootView.getHeight();
        int width = rootView.getWidth();
        int iSizeToDevicePixels = this.originalXPos + DTBAdUtil.sizeToDevicePixels(i);
        int iSizeToDevicePixels2 = this.originalYPos + DTBAdUtil.sizeToDevicePixels(i2);
        if (z) {
            i5 = iSizeToDevicePixels;
            i6 = iSizeToDevicePixels2;
        } else {
            int i9 = width - 20;
            if (iSizeToDevicePixels > i9) {
                iSizeToDevicePixels = i9;
            }
            if (iSizeToDevicePixels < 0) {
                iSizeToDevicePixels = 0;
            }
            int i10 = height - 20;
            if (iSizeToDevicePixels2 > i10) {
                iSizeToDevicePixels2 = i10;
            }
            if (iSizeToDevicePixels2 < 0) {
                i5 = iSizeToDevicePixels;
                i6 = 0;
            } else {
                i5 = iSizeToDevicePixels;
                i6 = iSizeToDevicePixels2;
            }
        }
        this.startAnimation = new AnimationPoint(iArr[0] - iArr2[0], iArr[1] - iArr2[1], getAdView().getWidth(), getAdView().getHeight());
        int iSizeToDevicePixels3 = DTBAdUtil.sizeToDevicePixels(i3);
        int iSizeToDevicePixels4 = DTBAdUtil.sizeToDevicePixels(i4);
        if (z) {
            i7 = iSizeToDevicePixels3;
            i8 = iSizeToDevicePixels4;
        } else {
            if (i5 + iSizeToDevicePixels3 >= width) {
                iSizeToDevicePixels3 = width - i5;
            }
            if (iSizeToDevicePixels3 < 0) {
                iSizeToDevicePixels3 = 0;
            }
            if (i6 + iSizeToDevicePixels4 >= height) {
                iSizeToDevicePixels4 = height - i6;
            }
            if (iSizeToDevicePixels4 < 0) {
                i8 = 0;
                i7 = iSizeToDevicePixels3;
            } else {
                i7 = iSizeToDevicePixels3;
                i8 = iSizeToDevicePixels4;
            }
        }
        if (getAdView().getParent() != rootView) {
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(getAdView().getWidth(), getAdView().getHeight());
            marginLayoutParams.leftMargin = this.startAnimation.xPos;
            marginLayoutParams.topMargin = this.startAnimation.yPos;
            rootView.addView(getAdView(), marginLayoutParams);
        }
        this.endAnimation = new AnimationPoint(i5, i6, i7, i8);
        setCurrentPositionProperty(DTBAdUtil.pixelsToDeviceIndependenPixels(i7), DTBAdUtil.pixelsToDeviceIndependenPixels(i8));
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "animationProgress", 0.0f, 1.0f);
        this.animater = objectAnimatorOfFloat;
        final int i11 = i7;
        final int i12 = i8;
        final int i13 = i5;
        final int i14 = i6;
        objectAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.amazon.device.ads.DTBAdMRAIDBannerController$$ExternalSyntheticLambda3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.m4391xb7b32043(i11, i12, i13, i14, valueAnimator);
            }
        });
        this.animater.setDuration(500L);
        this.animater.start();
    }

    /* JADX INFO: renamed from: lambda$onResizeImpl$6$com-amazon-device-ads-DTBAdMRAIDBannerController, reason: not valid java name */
    /* synthetic */ void m4391xb7b32043(int i, int i2, int i3, int i4, ValueAnimator valueAnimator) {
        if (updateAdViewLayout(valueAnimator).floatValue() == 1.0f) {
            fireSizeChange(DTBAdUtil.pixelsToDeviceIndependenPixels(i), DTBAdUtil.pixelsToDeviceIndependenPixels(i2));
            addCloseIndicator(i3 + i, i4);
            commandCompleted("resize");
            setState(MraidStateType.RESIZED);
            this.animater = null;
            getAdView().computeExposure(true);
        }
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController
    protected void expand(final Map<String, Object> map) {
        if (!this.state.equals(MraidStateType.DEFAULT)) {
            fireErrorEvent("expand", "current state does not allow transition to expand");
            commandCompleted("expand");
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.amazon.device.ads.DTBAdMRAIDBannerController$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m4379lambda$expand$7$comamazondeviceadsDTBAdMRAIDBannerController(map);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$expand$7$com-amazon-device-ads-DTBAdMRAIDBannerController, reason: not valid java name */
    /* synthetic */ void m4379lambda$expand$7$comamazondeviceadsDTBAdMRAIDBannerController(Map map) {
        if (((String) map.get("url")) != null) {
            executeTwoPartsExpand(map);
        } else {
            executeOnePartExpand(map);
        }
    }

    private void executeTwoPartsExpand(Map<String, Object> map) {
        String str = (String) map.get("url");
        Activity activity = DTBAdUtil.getActivity(getAdView());
        Intent intent = new Intent(activity, (Class<?>) DTBAdActivity.class);
        if (str != null) {
            intent.putExtra("url", str);
        }
        intent.putExtra("ad_state", "expanded");
        intent.putExtra("cntrl_index", this.index);
        intent.putExtra("two_part_expand", true);
        if (map.get("orientation") != null) {
            intent.putExtra("orientation", (Serializable) map.get("orientation"));
        }
        safedk_Activity_startActivity_9d898b58165fa4ba0e12c3900a2b8533(activity, intent);
        commandCompleted("expand");
        setState(MraidStateType.EXPANDED);
        bannerControllers.add(new WeakReference<>(this));
    }

    private void executeOnePartExpand(Map<String, Object> map) {
        int iSizeToDevicePixels;
        final boolean zBooleanValue;
        int iIntValue;
        int iIntValue2;
        this.originalX = getAdView().getX();
        this.originalY = getAdView().getY();
        ViewGroup rootView = DTBAdUtil.getRootView(getAdView());
        if (rootView == null) {
            fireErrorEvent("expand", "rootview doesn't exist in one part expand");
            commandCompleted("expand");
            return;
        }
        int[] iArr = new int[2];
        getAdView().getLocationInWindow(iArr);
        this.defaultParent = (ViewGroup) getAdView().getParent();
        this.originalParams = getAdView().getLayoutParams();
        getAdView().setIgnoreDetachment();
        this.defaultParent.removeView(getAdView());
        int[] iArr2 = new int[2];
        rootView.getLocationInWindow(iArr2);
        int height = rootView.getHeight();
        final int width = rootView.getWidth();
        this.startAnimation = new AnimationPoint(iArr[0] - iArr2[0], iArr[1] - iArr2[1], getAdView().getWidth(), getAdView().getHeight());
        if (map.containsKey(b9.h.L) && (map.get(b9.h.L) instanceof Map)) {
            Map map2 = (Map) map.get(b9.h.L);
            iSizeToDevicePixels = (!map2.containsKey("width") || (iIntValue2 = ((Integer) map2.get("width")).intValue()) <= 0) ? width : DTBAdUtil.sizeToDevicePixels(iIntValue2);
            if (map2.containsKey("height") && (iIntValue = ((Integer) map2.get("height")).intValue()) > 0) {
                height = DTBAdUtil.sizeToDevicePixels(iIntValue);
            }
            if (map2.containsKey(MraidJsMethods.USE_CUSTOM_CLOSE)) {
                zBooleanValue = ((Boolean) map2.get(MraidJsMethods.USE_CUSTOM_CLOSE)).booleanValue();
            }
            BackgroundView backgroundView = new BackgroundView(getAdView().getContext());
            this.expandedBackground = backgroundView;
            backgroundView.setBackgroundColor(0);
            rootView.addView(backgroundView, -1, -1);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(getAdView().getWidth(), getAdView().getHeight());
            marginLayoutParams.leftMargin = this.startAnimation.xPos;
            marginLayoutParams.topMargin = this.startAnimation.yPos;
            rootView.bringChildToFront(backgroundView);
            backgroundView.addView(getAdView(), marginLayoutParams);
            getAdView().setX(this.startAnimation.xPos);
            getAdView().setY(this.startAnimation.yPos);
            this.endAnimation = new AnimationPoint(0, 0, iSizeToDevicePixels, height);
            setCurrentPositionProperty(DTBAdUtil.pixelsToDeviceIndependenPixels(iSizeToDevicePixels), DTBAdUtil.pixelsToDeviceIndependenPixels(height));
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "animationProgress", 0.0f, 1.0f);
            this.animater = objectAnimatorOfFloat;
            objectAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.amazon.device.ads.DTBAdMRAIDBannerController$$ExternalSyntheticLambda10
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.m4378xeb530dd6(width, zBooleanValue, valueAnimator);
                }
            });
            this.animater.setDuration(500L);
            this.animater.start();
        }
        iSizeToDevicePixels = width;
        zBooleanValue = false;
        BackgroundView backgroundView2 = new BackgroundView(getAdView().getContext());
        this.expandedBackground = backgroundView2;
        backgroundView2.setBackgroundColor(0);
        rootView.addView(backgroundView2, -1, -1);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(getAdView().getWidth(), getAdView().getHeight());
        marginLayoutParams2.leftMargin = this.startAnimation.xPos;
        marginLayoutParams2.topMargin = this.startAnimation.yPos;
        rootView.bringChildToFront(backgroundView2);
        backgroundView2.addView(getAdView(), marginLayoutParams2);
        getAdView().setX(this.startAnimation.xPos);
        getAdView().setY(this.startAnimation.yPos);
        this.endAnimation = new AnimationPoint(0, 0, iSizeToDevicePixels, height);
        setCurrentPositionProperty(DTBAdUtil.pixelsToDeviceIndependenPixels(iSizeToDevicePixels), DTBAdUtil.pixelsToDeviceIndependenPixels(height));
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, "animationProgress", 0.0f, 1.0f);
        this.animater = objectAnimatorOfFloat2;
        objectAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.amazon.device.ads.DTBAdMRAIDBannerController$$ExternalSyntheticLambda10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.m4378xeb530dd6(width, zBooleanValue, valueAnimator);
            }
        });
        this.animater.setDuration(500L);
        this.animater.start();
    }

    /* JADX INFO: renamed from: lambda$executeOnePartExpand$8$com-amazon-device-ads-DTBAdMRAIDBannerController, reason: not valid java name */
    /* synthetic */ void m4378xeb530dd6(int i, boolean z, ValueAnimator valueAnimator) {
        if (updateAdViewLayout(valueAnimator).floatValue() == 1.0f) {
            addCloseIndicator(i, 0, z);
            fireSizeChange(DTBAdUtil.pixelsToDeviceIndependenPixels(this.endAnimation.width), DTBAdUtil.pixelsToDeviceIndependenPixels(this.endAnimation.height));
            setState(MraidStateType.EXPANDED);
            commandCompleted("expand");
            this.animater = null;
            getAdView().computeExposure(true);
            getAdView().setScrollEnabled(true);
        }
    }

    private Float updateAdViewLayout(ValueAnimator valueAnimator) {
        Float f = (Float) valueAnimator.getAnimatedValue();
        ViewGroup.LayoutParams layoutParams = getAdView().getLayoutParams();
        getAdView().setX(this.startAnimation.xPos + ((this.endAnimation.xPos - this.startAnimation.xPos) * f.floatValue()));
        getAdView().setY(this.startAnimation.yPos + ((this.endAnimation.yPos - this.startAnimation.yPos) * f.floatValue()));
        layoutParams.width = (int) (this.startAnimation.width + ((this.endAnimation.width - this.startAnimation.width) * f.floatValue()));
        layoutParams.height = (int) (this.startAnimation.height + ((this.endAnimation.height - this.startAnimation.height) * f.floatValue()));
        getAdView().setLayoutParams(layoutParams);
        getAdView().invalidate();
        return f;
    }

    private void updateResizedToDefaultListener(ViewGroup viewGroup, boolean z) {
        getAdView().setIgnoreDetachment();
        viewGroup.removeView(getAdView());
        this.startAnimation = this.endAnimation;
        if (this.originalParams != null) {
            this.defaultParent.addView(getAdView(), this.originalParams);
            this.defaultParent.requestLayout();
        }
        getAdView().invalidate();
        setCurrentPositionProperty();
        this.defaultParent = null;
        fireSizeChange(DTBAdUtil.pixelsToDeviceIndependenPixels(this.endAnimation.width), DTBAdUtil.pixelsToDeviceIndependenPixels(this.endAnimation.height));
        setState(MraidStateType.DEFAULT);
        this.animater = null;
        commandCompleted("close");
        if (z) {
            new Handler().postDelayed(new Runnable() { // from class: com.amazon.device.ads.DTBAdMRAIDBannerController$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m4396x77b56860();
                }
            }, 500L);
        }
        new Handler().postDelayed(new Runnable() { // from class: com.amazon.device.ads.DTBAdMRAIDBannerController$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m4395x6887b7d2();
            }
        }, 100L);
    }

    /* JADX INFO: renamed from: lambda$updateResizedToDefaultListener$9$com-amazon-device-ads-DTBAdMRAIDBannerController, reason: not valid java name */
    /* synthetic */ void m4396x77b56860() {
        AmazonPublisherServicesNetworkBridge.webviewLoadUrl(getAdView(), AndroidWebViewClient.BLANK_PAGE);
        commandCompleted(MraidJsMethods.UNLOAD);
    }

    /* JADX INFO: renamed from: lambda$updateResizedToDefaultListener$10$com-amazon-device-ads-DTBAdMRAIDBannerController, reason: not valid java name */
    /* synthetic */ void m4395x6887b7d2() {
        getAdView().computeExposure(true);
    }

    private void updateExpandedToDefaultListener(ViewGroup viewGroup, boolean z) {
        getAdView().setIgnoreDetachment();
        viewGroup.removeView(getAdView());
        this.startAnimation = this.endAnimation;
        ViewGroup viewGroup2 = this.expandedBackground;
        if (viewGroup2 != null) {
            ((ViewGroup) viewGroup2.getParent()).removeView(this.expandedBackground);
            this.expandedBackground = null;
            fireSizeChange(DTBAdUtil.pixelsToDeviceIndependenPixels(this.startAnimation.width), DTBAdUtil.pixelsToDeviceIndependenPixels(this.startAnimation.height));
        }
        if (this.originalParams != null) {
            this.defaultParent.addView(getAdView(), this.originalParams);
            this.defaultParent.requestLayout();
        }
        setCurrentPositionProperty();
        setState(MraidStateType.DEFAULT);
        getAdView().setScrollEnabled(false);
        commandCompleted("close");
        this.defaultParent = null;
        this.animater = null;
        if (z) {
            new Handler().postDelayed(new Runnable() { // from class: com.amazon.device.ads.DTBAdMRAIDBannerController$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m4393xd1b23efc();
                }
            }, 500L);
        }
        new Handler().postDelayed(new Runnable() { // from class: com.amazon.device.ads.DTBAdMRAIDBannerController$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m4394xc35be51b();
            }
        }, 100L);
    }

    /* JADX INFO: renamed from: lambda$updateExpandedToDefaultListener$11$com-amazon-device-ads-DTBAdMRAIDBannerController, reason: not valid java name */
    /* synthetic */ void m4393xd1b23efc() {
        AmazonPublisherServicesNetworkBridge.webviewLoadUrl(getAdView(), AndroidWebViewClient.BLANK_PAGE);
        commandCompleted(MraidJsMethods.UNLOAD);
    }

    /* JADX INFO: renamed from: lambda$updateExpandedToDefaultListener$12$com-amazon-device-ads-DTBAdMRAIDBannerController, reason: not valid java name */
    /* synthetic */ void m4394xc35be51b() {
        getAdView().computeExposure(true);
    }

    class ExpandedBannerListener implements DTBAdExpandedListener {
        @Override // com.amazon.device.ads.DTBAdExpandedListener
        public void onAdLoaded(DTBAdView dTBAdView) {
        }

        ExpandedBannerListener() {
        }

        @Override // com.amazon.device.ads.DTBAdExpandedListener
        public void onCreateExpandedController(DTBAdMRAIDExpandedController dTBAdMRAIDExpandedController) {
            dTBAdMRAIDExpandedController.setMasterController(DTBAdMRAIDBannerController.this);
        }
    }

    void openExpanded() {
        setState(MraidStateType.EXPANDED);
    }

    static DTBAdMRAIDBannerController findControllerByIndex(int i) {
        Iterator<WeakReference<DTBAdMRAIDBannerController>> it = bannerControllers.iterator();
        while (it.hasNext()) {
            DTBAdMRAIDBannerController dTBAdMRAIDBannerController = it.next().get();
            if (dTBAdMRAIDBannerController != null && dTBAdMRAIDBannerController.index == i) {
                return dTBAdMRAIDBannerController;
            }
        }
        return null;
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController
    protected void closeExpandedPartTwo() {
        setState(MraidStateType.DEFAULT);
    }

    @Override // com.amazon.device.ads.DTBMRAIDCloseButtonListener
    public void useCustomButtonUpdated() {
        if (this.state != MraidStateType.EXPANDED || this.closeIndicatorRegion == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.amazon.device.ads.DTBAdMRAIDBannerController$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m4397x40888cad();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$useCustomButtonUpdated$13$com-amazon-device-ads-DTBAdMRAIDBannerController, reason: not valid java name */
    /* synthetic */ void m4397x40888cad() {
        this.closeIndicatorRegion.setVisibility(this.useCustomClose ? 4 : 0);
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController
    public void onAdClicked() {
        final DTBAdView dTBAdView = this.adView;
        if (this.bannerListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.amazon.device.ads.DTBAdMRAIDBannerController$$ExternalSyntheticLambda14
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m4385x6b82626(dTBAdView);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$onAdClicked$14$com-amazon-device-ads-DTBAdMRAIDBannerController, reason: not valid java name */
    /* synthetic */ void m4385x6b82626(View view) {
        this.bannerListener.onAdClicked(view);
    }

    class BackgroundView extends LinearLayout {
        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent me) {
            DetectTouchUtils.viewOnTouch(h.A, this, me);
            return super.dispatchTouchEvent(me);
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            if (1 == 0) {
                setMeasuredDimension(0, 0);
            } else {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            }
        }

        BackgroundView(Context context) {
            super(context);
            setOrientation(1);
        }
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController
    public void onAdLeftApplication() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.amazon.device.ads.DTBAdMRAIDBannerController$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m4387x19e030e7();
            }
        });
        ActivityMonitor.getInstance().setActivityListener(this);
    }

    /* JADX INFO: renamed from: lambda$onAdLeftApplication$15$com-amazon-device-ads-DTBAdMRAIDBannerController, reason: not valid java name */
    /* synthetic */ void m4387x19e030e7() {
        this.bannerListener.onAdOpen(this.adView);
        this.bannerListener.onAdLeftApplication(this.adView);
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController
    public void onAdLoaded() {
        if (this.bannerListener == null) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Failed to get bannerListener on OnAdLoaded");
        } else {
            DtbThreadService.executeOnMainThread(new Runnable() { // from class: com.amazon.device.ads.DTBAdMRAIDBannerController$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m4388xcee7060();
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$onAdLoaded$16$com-amazon-device-ads-DTBAdMRAIDBannerController, reason: not valid java name */
    /* synthetic */ void m4388xcee7060() {
        this.bannerListener.onAdLoaded(this.adView);
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController
    public void onAdFailedToLoad() {
        if (this.bannerListener == null) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Failed to get bannerListener on onAdFailedToLoad");
            return;
        }
        if (getDtbOmSdkSessionManager() != null) {
            getDtbOmSdkSessionManager().stopOmAdSession();
        }
        DtbThreadService.executeOnMainThread(new Runnable() { // from class: com.amazon.device.ads.DTBAdMRAIDBannerController$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m4386xe1999158();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onAdFailedToLoad$17$com-amazon-device-ads-DTBAdMRAIDBannerController, reason: not valid java name */
    /* synthetic */ void m4386xe1999158() {
        this.bannerListener.onAdFailed(this.adView);
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController, com.amazon.device.ads.DTBActivityListener
    public void onActivityResumed(Activity activity) {
        this.bannerListener.onAdClosed(this.adView);
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController, com.amazon.device.ads.DTBActivityListener
    public void onActivityDestroyed(Activity activity) {
        if (getDtbOmSdkSessionManager() != null) {
            getDtbOmSdkSessionManager().stopOmAdSession();
        }
        ActivityMonitor.getInstance().setActivityListener(null);
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController
    public void onAdRemoved() {
        ViewGroup viewGroup;
        if (this.adView == null) {
            return;
        }
        super.onAdRemoved();
        removeCloseIndicator();
        ObjectAnimator objectAnimator = this.animater;
        if (objectAnimator != null) {
            objectAnimator.end();
        }
        if (!isVisibleRecyclerOrListView(this.adView.getParent())) {
            this.adView.setVisibility(8);
        }
        if (this.state == MraidStateType.RESIZED) {
            ViewParent parent = this.adView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.adView);
                return;
            }
            return;
        }
        if (this.state == MraidStateType.EXPANDED && (viewGroup = this.expandedBackground) != null && (viewGroup.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.expandedBackground.getParent()).removeView(this.expandedBackground);
        }
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController
    void passLoadError() {
        DtbThreadService.executeOnMainThread(new Runnable() { // from class: com.amazon.device.ads.DTBAdMRAIDBannerController$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m4392xf600342e();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$passLoadError$18$com-amazon-device-ads-DTBAdMRAIDBannerController, reason: not valid java name */
    /* synthetic */ void m4392xf600342e() {
        this.bannerListener.onAdError(this.adView);
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController
    public void impressionFired() {
        DtbThreadService.executeOnMainThread(new Runnable() { // from class: com.amazon.device.ads.DTBAdMRAIDBannerController$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m4380x1734cc41();
            }
        });
        super.impressionFired();
    }

    /* JADX INFO: renamed from: lambda$impressionFired$19$com-amazon-device-ads-DTBAdMRAIDBannerController, reason: not valid java name */
    /* synthetic */ void m4380x1734cc41() {
        this.bannerListener.onImpressionFired(this.adView);
    }

    private boolean isVisibleRecyclerOrListView(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        if (viewParent.toString().toLowerCase().contains("recyclerview") || viewParent.toString().toLowerCase().contains("listview")) {
            return true;
        }
        return isVisibleRecyclerOrListView(viewParent.getParent());
    }
}
