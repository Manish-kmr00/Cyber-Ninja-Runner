package com.amazon.aps.ads.util.adview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.widget.ScrollView;
import com.amazon.aps.ads.metrics.ApsMetricsAdListenerAdapterBase;
import com.amazon.aps.ads.model.ApsAdFormat;
import com.amazon.aps.ads.util.ApsAdExtensionsKt;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.amazon.device.ads.AdRegistration;
import com.amazon.device.ads.DTBActivityListener;
import com.amazon.device.ads.DTBAdMRAIDBannerController;
import com.amazon.device.ads.DTBAdMRAIDController;
import com.amazon.device.ads.DTBAdViewDisplayListener;
import com.amazon.device.ads.DTBTimeTrace;
import com.amazon.device.ads.DtbOmSdkSessionManager;
import com.json.nu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApsAdViewBase.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000f\b&\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010?\u001a\u00020@H\u0016J\u0014\u0010A\u001a\u0004\u0018\u00010B2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u0010\u0010E\u001a\u00020@2\u0006\u0010F\u001a\u00020\u0007H\u0016J\u0010\u0010G\u001a\u00020@2\u0006\u0010F\u001a\u00020\u0007H\u0016J\u0010\u0010H\u001a\u00020\u00162\u0006\u0010I\u001a\u00020BH\u0016J\u001a\u0010H\u001a\u00020@2\b\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010F\u001a\u00020\u0007H\u0014J\n\u0010J\u001a\u0004\u0018\u00010BH\u0016J\b\u0010K\u001a\u00020@H\u0016J\b\u0010L\u001a\u0004\u0018\u00010DJ\b\u0010M\u001a\u00020@H\u0004J\b\u0010N\u001a\u00020@H\u0014J\b\u0010O\u001a\u00020\u0007H\u0014J\u001a\u0010P\u001a\u00020@2\u0006\u0010Q\u001a\u00020\u00072\b\b\u0002\u0010R\u001a\u00020\u0007H\u0014J\b\u0010S\u001a\u00020@H$J\b\u0010T\u001a\u00020@H\u0016J\b\u0010U\u001a\u00020@H\u0016J\u0012\u0010V\u001a\u00020@2\b\u0010W\u001a\u0004\u0018\u00010XH\u0016J\u0018\u0010Y\u001a\u00020@2\u0006\u0010Z\u001a\u00020\u00162\u0006\u0010I\u001a\u00020BH$J\u0010\u0010[\u001a\u00020@2\u0006\u0010I\u001a\u00020BH$J(\u0010\\\u001a\u00020@2\u0006\u0010]\u001a\u00020\u00162\u0006\u0010^\u001a\u00020\u00162\u0006\u0010_\u001a\u00020\u00162\u0006\u0010`\u001a\u00020\u0016H\u0016J\u0010\u0010a\u001a\u00020@2\u0006\u0010b\u001a\u00020\u0007H$J\b\u0010c\u001a\u00020@H$J\u0010\u0010d\u001a\u00020@2\u0006\u0010e\u001a\u00020\u0007H\u0016J\b\u0010f\u001a\u00020@H\u0014R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@DX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R(\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u000f@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0015\u001a\u00020\u00168\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R(\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000f@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u0012\u0010\u001f\u001a\u00020\u00078\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R$\u0010 \u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\n\"\u0004\b!\u0010\fR\u0012\u0010\"\u001a\u00020\u00078\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R$\u0010#\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\n\"\u0004\b$\u0010\fR(\u0010&\u001a\u0004\u0018\u00010%2\b\u0010\u001b\u001a\u0004\u0018\u00010%@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R(\u0010,\u001a\u0004\u0018\u00010+2\b\u0010\u001b\u001a\u0004\u0018\u00010+@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00102\u001a\u0004\u0018\u0001012\b\u0010\u001b\u001a\u0004\u0018\u000101@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0014\u00105\u001a\u0004\u0018\u0001068\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R$\u00108\u001a\u0002072\u0006\u0010\u001b\u001a\u000207@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0012\u0010=\u001a\u0002078\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0012\u0010>\u001a\u0002078\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000¨\u0006g"}, d2 = {"Lcom/amazon/aps/ads/util/adview/ApsAdViewBase;", "Landroid/webkit/WebView;", "Lcom/amazon/aps/ads/util/adview/ApsAdViewConstants;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "adViewScrollEnabled", "getAdViewScrollEnabled", "()Z", "setAdViewScrollEnabled", "(Z)V", "apsAdFormat", "Lcom/amazon/aps/ads/model/ApsAdFormat;", "", "bidId", "getBidId", "()Ljava/lang/String;", "setBidId", "(Ljava/lang/String;)V", "exposurePercent", "", "focusChangeListener", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "<set-?>", "hostname", "getHostname", "setHostname", "ignoreDetachment", "isAdViewVisible", "setAdViewVisible", "isFirstDisplay", "isVideo", "setVideo", "Lcom/amazon/device/ads/DTBAdMRAIDController;", "mraidHandler", "getMraidHandler", "()Lcom/amazon/device/ads/DTBAdMRAIDController;", "setMraidHandler", "(Lcom/amazon/device/ads/DTBAdMRAIDController;)V", "Lcom/amazon/aps/ads/metrics/ApsMetricsAdListenerAdapterBase;", "mraidListenerAdapter", "getMraidListenerAdapter", "()Lcom/amazon/aps/ads/metrics/ApsMetricsAdListenerAdapterBase;", "setMraidListenerAdapter", "(Lcom/amazon/aps/ads/metrics/ApsMetricsAdListenerAdapterBase;)V", "Lcom/amazon/device/ads/DtbOmSdkSessionManager;", "omSdkManager", "getOmSdkManager", "()Lcom/amazon/device/ads/DtbOmSdkSessionManager;", "scrollChangeListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "", "startTime", "getStartTime", "()J", "setStartTime", "(J)V", "timeClicked", "timePressed", "cleanup", "", "computeAdViewRect", "Landroid/graphics/Rect;", "scrollView", "Landroid/widget/ScrollView;", "computeExposure", "enforced", "computeExposureInRootView", "computeExposureInScrollView", "adViewRect", "computeRootContainerRectInRootView", "finalize", "getScrollViewParent", "initLayoutListeners", "initWebView", "isMraidHandlerInitialized", "notifyViewabilityAndSetIsVisible", "flag", "overrideValidation", nu.c, "onAttachedToWindow", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onExposureChange", "exposurePercentage", "onPositionChanged", "onScrollChanged", "l", ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, "oldl", "oldt", "onViewabilityChanged", "isChanged", "setCurrentPositionProperty", "setScrollEnabled", "enabled", "verifyIsVisible", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ApsAdViewBase extends WebView implements ApsAdViewConstants {
    private boolean adViewScrollEnabled;
    protected ApsAdFormat apsAdFormat;
    private String bidId;
    protected int exposurePercent;
    protected ViewTreeObserver.OnGlobalFocusChangeListener focusChangeListener;
    protected ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
    private String hostname;
    protected boolean ignoreDetachment;
    private boolean isAdViewVisible;
    protected boolean isFirstDisplay;
    private boolean isVideo;
    private DTBAdMRAIDController mraidHandler;
    private ApsMetricsAdListenerAdapterBase mraidListenerAdapter;
    private DtbOmSdkSessionManager omSdkManager;
    protected ViewTreeObserver.OnScrollChangedListener scrollChangeListener;
    private long startTime;
    protected long timeClicked;
    protected long timePressed;

    public void cleanup() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.A, this, me);
        return super.dispatchTouchEvent(me);
    }

    protected abstract void onAdOpened();

    protected abstract void onExposureChange(int exposurePercentage, Rect adViewRect);

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    protected abstract void onPositionChanged(Rect adViewRect);

    protected abstract void onViewabilityChanged(boolean isChanged);

    protected abstract void setCurrentPositionProperty();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApsAdViewBase(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isFirstDisplay = true;
        this.exposurePercent = -1;
        this.adViewScrollEnabled = true;
        CookieManager.getInstance().setAcceptCookie(true);
        this.omSdkManager = DtbOmSdkSessionManager.getNewInstance();
    }

    public final DTBAdMRAIDController getMraidHandler() {
        return this.mraidHandler;
    }

    protected final void setMraidHandler(DTBAdMRAIDController dTBAdMRAIDController) {
        this.mraidHandler = dTBAdMRAIDController;
    }

    public final ApsMetricsAdListenerAdapterBase getMraidListenerAdapter() {
        return this.mraidListenerAdapter;
    }

    protected final void setMraidListenerAdapter(ApsMetricsAdListenerAdapterBase apsMetricsAdListenerAdapterBase) {
        this.mraidListenerAdapter = apsMetricsAdListenerAdapterBase;
    }

    public final DtbOmSdkSessionManager getOmSdkManager() {
        return this.omSdkManager;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    protected final void setStartTime(long j) {
        this.startTime = j;
    }

    /* JADX INFO: renamed from: isVideo, reason: from getter */
    public final boolean getIsVideo() {
        return this.isVideo;
    }

    protected final void setVideo(boolean z) {
        this.isVideo = z;
    }

    public final String getHostname() {
        return this.hostname;
    }

    protected final void setHostname(String str) {
        this.hostname = str;
    }

    public final String getBidId() {
        return this.bidId;
    }

    protected final void setBidId(String str) {
        this.bidId = str;
        ApsMetricsAdListenerAdapterBase apsMetricsAdListenerAdapterBase = this.mraidListenerAdapter;
        if (apsMetricsAdListenerAdapterBase == null) {
            return;
        }
        apsMetricsAdListenerAdapterBase.setBidId(str);
    }

    protected final boolean getAdViewScrollEnabled() {
        return this.adViewScrollEnabled;
    }

    protected final void setAdViewScrollEnabled(boolean z) {
        this.adViewScrollEnabled = z;
        setVerticalScrollBarEnabled(z);
        setHorizontalScrollBarEnabled(z);
    }

    /* JADX INFO: renamed from: isAdViewVisible, reason: from getter */
    public final boolean getIsAdViewVisible() {
        return this.isAdViewVisible;
    }

    protected final void setAdViewVisible(boolean z) {
        this.isAdViewVisible = z;
        if (z) {
            return;
        }
        this.exposurePercent = -1;
        if (isMraidHandlerInitialized()) {
            onExposureChange(0, new Rect(0, 0, 0, 0));
        }
    }

    protected boolean isMraidHandlerInitialized() {
        return this.mraidHandler != null;
    }

    protected final void initLayoutListeners() {
        this.globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.amazon.aps.ads.util.adview.ApsAdViewBase$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                ApsAdViewBase.m4369initLayoutListeners$lambda0(this.f$0);
            }
        };
        this.focusChangeListener = new ViewTreeObserver.OnGlobalFocusChangeListener() { // from class: com.amazon.aps.ads.util.adview.ApsAdViewBase$$ExternalSyntheticLambda1
            @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
            public final void onGlobalFocusChanged(View view, View view2) {
                ApsAdViewBase.m4370initLayoutListeners$lambda1(this.f$0, view, view2);
            }
        };
        this.scrollChangeListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.amazon.aps.ads.util.adview.ApsAdViewBase$$ExternalSyntheticLambda2
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                ApsAdViewBase.m4371initLayoutListeners$lambda2(this.f$0);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initLayoutListeners$lambda-0, reason: not valid java name */
    public static final void m4369initLayoutListeners$lambda0(ApsAdViewBase this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.verifyIsVisible();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initLayoutListeners$lambda-1, reason: not valid java name */
    public static final void m4370initLayoutListeners$lambda1(ApsAdViewBase this$0, View view, View view2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.verifyIsVisible();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initLayoutListeners$lambda-2, reason: not valid java name */
    public static final void m4371initLayoutListeners$lambda2(ApsAdViewBase this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.verifyIsVisible();
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int l, int t, int oldl, int oldt) {
        if (this.adViewScrollEnabled) {
            super.onScrollChanged(l, t, oldt, oldl);
        } else {
            scrollTo(0, 0);
        }
    }

    public final ScrollView getScrollViewParent() {
        return ApsAdViewUtils.INSTANCE.getScrollViewParent(this);
    }

    protected void initWebView() {
        ApsAdViewUtils.INSTANCE.initWebView(this);
    }

    public Rect computeAdViewRect(ScrollView scrollView) {
        return ApsAdViewUtils.INSTANCE.computeAdViewRect(this, scrollView);
    }

    public int computeExposureInScrollView(Rect adViewRect) {
        Intrinsics.checkNotNullParameter(adViewRect, "adViewRect");
        return ApsAdViewUtils.INSTANCE.computeExposureInScrollView(this, adViewRect);
    }

    public void setScrollEnabled(boolean enabled) {
        setAdViewScrollEnabled(enabled);
        setVerticalScrollBarEnabled(enabled);
        setHorizontalScrollBarEnabled(enabled);
    }

    public Rect computeRootContainerRectInRootView() {
        return ApsAdViewUtils.INSTANCE.computeRootContainerRectInRootView(this);
    }

    public static /* synthetic */ void notifyViewabilityAndSetIsVisible$default(ApsAdViewBase apsAdViewBase, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: notifyViewabilityAndSetIsVisible");
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        apsAdViewBase.notifyViewabilityAndSetIsVisible(z, z2);
    }

    protected void notifyViewabilityAndSetIsVisible(boolean flag, boolean overrideValidation) {
        if (this.isAdViewVisible || overrideValidation) {
            if (isMraidHandlerInitialized()) {
                onViewabilityChanged(flag);
            }
            setAdViewVisible(flag);
        }
    }

    public void finalize() {
        try {
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver == null) {
                return;
            }
            viewTreeObserver.removeOnGlobalLayoutListener(this.globalLayoutListener);
            viewTreeObserver.removeOnScrollChangedListener(this.scrollChangeListener);
            viewTreeObserver.removeOnGlobalFocusChangeListener(this.focusChangeListener);
        } catch (RuntimeException e) {
            ApsAdExtensionsKt.logEvent(this, APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to execute finalize method", e);
        }
    }

    protected void verifyIsVisible() {
        ApsAdExtensionsKt.d(this, Intrinsics.stringPlus("method verifyIsVisible called: ", Boolean.valueOf(this.isAdViewVisible)));
        ApsAdViewUtils.INSTANCE.verifyIsVisible(this, this.isAdViewVisible, new AnonymousClass1(this));
        if (this.isAdViewVisible) {
            computeExposure(false);
        }
    }

    /* JADX INFO: renamed from: com.amazon.aps.ads.util.adview.ApsAdViewBase$verifyIsVisible$1, reason: invalid class name */
    /* JADX INFO: compiled from: ApsAdViewBase.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<Boolean, Boolean, Unit> {
        AnonymousClass1(Object obj) {
            super(2, obj, ApsAdViewBase.class, "notifyViewabilityAndSetIsVisible", "notifyViewabilityAndSetIsVisible(ZZ)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2) {
            invoke(bool.booleanValue(), bool2.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean z, boolean z2) {
            ((ApsAdViewBase) this.receiver).notifyViewabilityAndSetIsVisible(z, z2);
        }
    }

    public void computeExposureInRootView(boolean enforced) {
        Rect rectComputeRootContainerRectInRootView = computeRootContainerRectInRootView();
        if (rectComputeRootContainerRectInRootView == null) {
            return;
        }
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        int i = iArr[0];
        Rect rect = new Rect(i, iArr[1], getWidth() + i, iArr[1] + getHeight());
        float width = getWidth() * getHeight();
        if (rect.intersect(rectComputeRootContainerRectInRootView)) {
            int i2 = (int) (((((double) ((rect.right - rect.left) * (rect.bottom - rect.top))) * 100.0d) / ((double) width)) + 0.5d);
            if (i2 != this.exposurePercent || enforced) {
                this.exposurePercent = i2;
                onExposureChange(i2, rect);
                return;
            }
            return;
        }
        if (this.exposurePercent != 0 || enforced) {
            this.exposurePercent = 0;
            rect.top = rect.bottom;
            onExposureChange(this.exposurePercent, rect);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        DtbOmSdkSessionManager omSdkManager;
        try {
            super.onDetachedFromWindow();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this.globalLayoutListener);
                viewTreeObserver.removeOnScrollChangedListener(this.scrollChangeListener);
                viewTreeObserver.removeOnGlobalFocusChangeListener(this.focusChangeListener);
            }
            DTBAdMRAIDController dTBAdMRAIDController = this.mraidHandler;
            if (dTBAdMRAIDController != null && (dTBAdMRAIDController instanceof DTBAdMRAIDBannerController) && getOmSdkManager() != null && (omSdkManager = getOmSdkManager()) != null) {
                omSdkManager.stopOmAdSession();
            }
            this.mraidListenerAdapter = null;
        } catch (RuntimeException e) {
            ApsAdExtensionsKt.logEvent(this, APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to execute onDetachedFromWindow method in ApsAdView class", e);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.isFirstDisplay) {
            DTBTimeTrace dTBTimeTrace = DTBTimeTrace.getInstance();
            if (dTBTimeTrace != null && AdRegistration.isTestMode()) {
                dTBTimeTrace.addPhase(DTBTimeTrace.TIMETRACE_AD_DISPLAY_SUCCEEDED);
                dTBTimeTrace.logTrace();
            }
            DTBActivityListener dTBActivityListener = this.mraidHandler;
            if (dTBActivityListener instanceof DTBAdViewDisplayListener) {
                if (dTBActivityListener == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.amazon.device.ads.DTBAdViewDisplayListener");
                }
                ((DTBAdViewDisplayListener) dTBActivityListener).onInitialDisplay();
            }
            this.isFirstDisplay = false;
        }
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        try {
            super.onAttachedToWindow();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(this.globalLayoutListener);
                viewTreeObserver.addOnGlobalFocusChangeListener(this.focusChangeListener);
                viewTreeObserver.addOnScrollChangedListener(this.scrollChangeListener);
            }
            if (isMraidHandlerInitialized()) {
                onAdOpened();
            }
        } catch (RuntimeException e) {
            ApsAdExtensionsKt.logEvent(this, APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to execute onAttachedToWindow method", e);
        }
    }

    protected void computeExposureInScrollView(ScrollView scrollView, boolean enforced) {
        Rect rectComputeAdViewRect = computeAdViewRect(scrollView);
        if (rectComputeAdViewRect == null) {
            return;
        }
        int iComputeExposureInScrollView = computeExposureInScrollView(rectComputeAdViewRect);
        if (iComputeExposureInScrollView != this.exposurePercent || enforced) {
            this.exposurePercent = iComputeExposureInScrollView;
            onExposureChange(iComputeExposureInScrollView, rectComputeAdViewRect);
            setCurrentPositionProperty();
        }
    }

    public void computeExposure(boolean enforced) {
        ScrollView scrollViewParent = getScrollViewParent();
        if (scrollViewParent != null) {
            computeExposureInScrollView(scrollViewParent, enforced);
            return;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        int i = iArr[0];
        Rect rect = new Rect(i, iArr[1], getWidth() + i, iArr[1] + getHeight());
        if (isMraidHandlerInitialized()) {
            computeExposureInRootView(enforced);
            onPositionChanged(rect);
        }
    }
}
