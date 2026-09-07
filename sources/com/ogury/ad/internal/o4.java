package com.ogury.ad.internal;

import android.graphics.Rect;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class o4 {
    public static String a(String command, String message) {
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(message, "message");
        return "ogySdkMraidGateway.callErrorListeners(\"" + message + "\", \"" + command + "\")";
    }

    public static String b(String forceOrientation, boolean z) {
        Intrinsics.checkNotNullParameter(forceOrientation, "forceOrientation");
        return "ogySdkMraidGateway.updateOrientationProperties({allowOrientationChange: " + z + ", forceOrientation: \"" + forceOrientation + "\"})";
    }

    public static String c(int i, int i2) {
        return "ogySdkMraidGateway.updateScreenSize({width: " + i + ", height: " + i2 + "})";
    }

    public static String a(int i) {
        return "ogySdkMraidGateway.updateAudioVolume(" + i + ")";
    }

    public static String b(String placementType) {
        Intrinsics.checkNotNullParameter(placementType, "placementType");
        return "ogySdkMraidGateway.updatePlacementType(\"" + placementType + "\")";
    }

    public static String c(int i, int i2, int i3, int i4) {
        return "ogySdkMraidGateway.updateResizeProperties({width: " + i + ", height: " + i2 + ", offsetX: " + i3 + ", offsetY: " + i4 + ", customClosePosition: \"right\", allowOffscreen: false})";
    }

    public static String a(String orientation, boolean z) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return "ogySdkMraidGateway.updateCurrentAppOrientation({orientation: \"" + orientation + "\", locked: " + z + "})";
    }

    public static String b(int i, int i2) {
        return "ogySdkMraidGateway.updateMaxSize({width: " + i + ", height: " + i2 + "})";
    }

    public static String c(String state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return "ogySdkMraidGateway.updateState(\"" + state + "\")";
    }

    public static String a(boolean z) {
        return "ogySdkMraidGateway.updateViewability(" + z + ")";
    }

    public static String b(int i, int i2, int i3, int i4) {
        return "ogySdkMraidGateway.updateDefaultPosition({x: " + i3 + ", y: " + i4 + ", width: " + i + ", height: " + i2 + "})";
    }

    public static String a(int i, int i2, int i3, int i4) {
        return "ogySdkMraidGateway.updateCurrentPosition({x: " + i3 + ", y: " + i4 + ", width: " + i + ", height: " + i2 + "})";
    }

    public static String b(String callbackId, String result) {
        Intrinsics.checkNotNullParameter(callbackId, "callbackId");
        Intrinsics.checkNotNullParameter(result, "result");
        return "ogySdkMraidGateway.callPendingMethodCallback(\"" + callbackId + "\", null, " + result + ")";
    }

    public static String a(int i, int i2) {
        return "ogySdkMraidGateway.updateExpandProperties({width: " + i + ", height: " + i2 + ", useCustomClose: false, isModal: true})";
    }

    public static String a(e adExposure) {
        String str;
        Intrinsics.checkNotNullParameter(adExposure, "adExposure");
        StringBuilder sb = new StringBuilder();
        for (Rect rect : adExposure.b()) {
            if (sb.length() > 0) {
                sb.append(StringUtils.COMMA);
            }
            sb.append("{x: " + j7.b(rect.left) + ", y: " + j7.b(rect.top) + ", width: " + j7.b(rect.width()) + ", height: " + j7.b(rect.height()) + "}");
        }
        Rect rectC = adExposure.c();
        if (rectC != null) {
            str = "visibleRectangle: {x: " + j7.b(rectC.left) + ", y: " + j7.b(rectC.top) + ", width: " + j7.b(rectC.width()) + ", height: " + j7.b(rectC.height()) + "}";
        } else {
            str = "visibleRectangle: null";
        }
        return "ogySdkMraidGateway.updateExposure({exposedPercentage: " + adExposure.a() + ", " + str + ", occlusionRectangles: [" + ((Object) sb) + "]})";
    }

    public static String a(String event, boolean z, boolean z2, String webViewId, String url, String str) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(webViewId, "webViewId");
        Intrinsics.checkNotNullParameter(url, "url");
        return "ogySdkMraidGateway.callEventListeners(\"ogyOnNavigation\", {event: \"" + event + "\", canGoBack: " + z2 + ", canGoForward: " + z + ", webviewId: \"" + webViewId + "\", url: \"" + url + "\", \"pageTitle\": \"" + str + "\"})";
    }

    public static String a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return "ogySdkMraidGateway.callEventListeners(\"ogyOnOpenedUrl\", {url: \"" + url + "\"})";
    }
}
