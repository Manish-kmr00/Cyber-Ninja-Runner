package com.amazon.aps.ads.util.adview;

import android.R;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ScrollView;
import com.amazon.aps.ads.Aps;
import com.amazon.aps.ads.util.ApsAdExtensionsKt;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import com.amazon.device.ads.AdRegistration;
import com.amazon.device.ads.DTBAdUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApsAdViewUtils.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/amazon/aps/ads/util/adview/ApsAdViewUtils;", "", "()V", "Companion", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ApsAdViewUtils {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    public static final Rect computeAdViewRect(WebView webView, ScrollView scrollView) {
        return INSTANCE.computeAdViewRect(webView, scrollView);
    }

    @JvmStatic
    public static final int computeExposureInScrollView(WebView webView, Rect rect) {
        return INSTANCE.computeExposureInScrollView(webView, rect);
    }

    @JvmStatic
    public static final ScrollView getScrollViewParent(WebView webView) {
        return INSTANCE.getScrollViewParent(webView);
    }

    @JvmStatic
    public static final void initWebView(WebView webView) {
        INSTANCE.initWebView(webView);
    }

    @JvmStatic
    public static final void verifyIsVisible(ApsAdViewBase apsAdViewBase, boolean z, Function2<? super Boolean, ? super Boolean, Unit> function2) {
        INSTANCE.verifyIsVisible(apsAdViewBase, z, function2);
    }

    /* JADX INFO: compiled from: ApsAdViewUtils.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0012\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J2\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000f0\u0015H\u0007¨\u0006\u0016"}, d2 = {"Lcom/amazon/aps/ads/util/adview/ApsAdViewUtils$Companion;", "", "()V", "computeAdViewRect", "Landroid/graphics/Rect;", "webView", "Landroid/webkit/WebView;", "scrollView", "Landroid/widget/ScrollView;", "computeExposureInScrollView", "", "adViewRect", "computeRootContainerRectInRootView", "getScrollViewParent", "initWebView", "", "verifyIsVisible", "Lcom/amazon/aps/ads/util/adview/ApsAdViewBase;", "isAdViewVisible", "", "notifyViewabilityAndSetIsVisible", "Lkotlin/Function2;", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void verifyIsVisible(ApsAdViewBase webView, boolean isAdViewVisible, Function2<? super Boolean, ? super Boolean, Unit> notifyViewabilityAndSetIsVisible) {
            ViewGroup viewGroup;
            Intrinsics.checkNotNullParameter(webView, "webView");
            Intrinsics.checkNotNullParameter(notifyViewabilityAndSetIsVisible, "notifyViewabilityAndSetIsVisible");
            if (webView.getParent() == null || webView.getVisibility() != 0) {
                notifyViewabilityAndSetIsVisible.invoke(false, false);
                return;
            }
            Activity currentActivity = AdRegistration.getCurrentActivity();
            if (currentActivity == null) {
                notifyViewabilityAndSetIsVisible.invoke(false, false);
                return;
            }
            try {
                viewGroup = (ViewGroup) currentActivity.findViewById(R.id.content);
            } catch (RuntimeException e) {
                ApsAdExtensionsKt.logEvent(this, APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to get content view", e);
                viewGroup = null;
            }
            if (viewGroup == null) {
                notifyViewabilityAndSetIsVisible.invoke(false, false);
                return;
            }
            int[] iArr = new int[2];
            viewGroup.getLocationInWindow(iArr);
            int i = iArr[0];
            Rect rect = new Rect(i, iArr[1], viewGroup.getWidth() + i, iArr[1] + viewGroup.getHeight());
            int[] iArr2 = new int[2];
            webView.getLocationInWindow(iArr2);
            int i2 = iArr2[0];
            Rect rect2 = new Rect(i2, iArr2[1], webView.getWidth() + i2, iArr2[1] + webView.getHeight());
            if (!rect.contains(rect2) && !Rect.intersects(rect, rect2)) {
                notifyViewabilityAndSetIsVisible.invoke(false, false);
                return;
            }
            ScrollView scrollViewParent = webView.getScrollViewParent();
            if (scrollViewParent != null) {
                int[] iArr3 = new int[2];
                scrollViewParent.getLocationInWindow(iArr3);
                int i3 = iArr3[0];
                Rect rect3 = new Rect(i3, iArr3[1], scrollViewParent.getWidth() + i3, iArr3[1] + scrollViewParent.getHeight());
                if (!Rect.intersects(rect2, rect3)) {
                    notifyViewabilityAndSetIsVisible.invoke(false, true);
                    ApsAdExtensionsKt.d(this, "SET MRAID Visible false because of scroll ");
                    return;
                } else {
                    if (!Rect.intersects(rect2, rect3) || isAdViewVisible) {
                        return;
                    }
                    notifyViewabilityAndSetIsVisible.invoke(true, Boolean.valueOf(!isAdViewVisible));
                    ApsAdExtensionsKt.d(this, "SET MRAID Visible true because of scroll ");
                    return;
                }
            }
            notifyViewabilityAndSetIsVisible.invoke(true, Boolean.valueOf(!isAdViewVisible));
        }

        @JvmStatic
        public final ScrollView getScrollViewParent(WebView webView) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            ViewGroup viewGroup = webView;
            while (true) {
                ViewParent parent = viewGroup.getParent();
                ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup2 == null) {
                    return null;
                }
                ViewGroup viewGroup3 = viewGroup2;
                if (viewGroup3 instanceof ScrollView) {
                    return (ScrollView) viewGroup3;
                }
                viewGroup = viewGroup3;
            }
        }

        @JvmStatic
        public final Rect computeAdViewRect(WebView webView, ScrollView scrollView) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            Activity activity = DTBAdUtil.getActivity(webView);
            if (activity == null) {
                return null;
            }
            View viewFindViewById = activity.findViewById(R.id.content);
            ViewGroup viewGroup = viewFindViewById instanceof ViewGroup ? (ViewGroup) viewFindViewById : null;
            if (viewGroup == null) {
                return null;
            }
            int[] iArr = new int[2];
            viewGroup.getLocationInWindow(iArr);
            int i = iArr[0];
            Rect rect = new Rect(i, iArr[1], viewGroup.getWidth() + i, iArr[1] + viewGroup.getHeight());
            int[] iArr2 = new int[2];
            webView.getLocationInWindow(iArr2);
            int i2 = iArr2[0];
            Rect rect2 = new Rect(i2, iArr2[1], webView.getWidth() + i2, iArr2[1] + webView.getHeight());
            if (scrollView == null) {
                rect2.intersect(rect);
            } else {
                int[] iArr3 = new int[2];
                scrollView.getLocationInWindow(iArr3);
                int i3 = iArr3[0];
                Rect rect3 = new Rect(i3, iArr3[1], scrollView.getWidth() + i3, iArr3[1] + scrollView.getHeight());
                rect3.intersect(rect);
                rect2.intersect(rect3);
            }
            return rect2;
        }

        @JvmStatic
        public final int computeExposureInScrollView(WebView webView, Rect adViewRect) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            Intrinsics.checkNotNullParameter(adViewRect, "adViewRect");
            float width = webView.getWidth() * webView.getHeight();
            float f = (adViewRect.right - adViewRect.left) * (adViewRect.bottom - adViewRect.top);
            if (width == 0.0f) {
                return 0;
            }
            return (int) ((100 * f) / width);
        }

        public final Rect computeRootContainerRectInRootView(WebView webView) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            Object parent = webView.getParent();
            View view = parent instanceof View ? (View) parent : null;
            Activity activity = view != null ? DTBAdUtil.getActivity(view) : DTBAdUtil.getActivity(webView);
            if (activity == null) {
                return null;
            }
            View viewFindViewById = activity.findViewById(R.id.content);
            ViewGroup viewGroup = viewFindViewById instanceof ViewGroup ? (ViewGroup) viewFindViewById : null;
            if (viewGroup == null) {
                return null;
            }
            int[] iArr = new int[2];
            viewGroup.getLocationInWindow(iArr);
            int i = iArr[0];
            return new Rect(i, iArr[1], viewGroup.getWidth() + i, iArr[1] + viewGroup.getHeight());
        }

        @JvmStatic
        public final void initWebView(WebView webView) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            WebSettings settings = webView.getSettings();
            if (settings == null) {
                return;
            }
            WebView.setWebContentsDebuggingEnabled(Aps.isTestingMode());
            settings.setJavaScriptEnabled(true);
            settings.setAllowContentAccess(true);
            settings.setDomStorageEnabled(true);
            settings.setAppCacheEnabled(true);
            settings.setAllowFileAccess(false);
            settings.setLoadsImagesAutomatically(true);
            settings.setMediaPlaybackRequiresUserGesture(false);
            settings.setBlockNetworkImage(false);
        }
    }

    private ApsAdViewUtils() {
    }
}
