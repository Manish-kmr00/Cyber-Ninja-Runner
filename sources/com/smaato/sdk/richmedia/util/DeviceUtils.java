package com.smaato.sdk.richmedia.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import com.smaato.sdk.core.util.AppMetaData;
import com.smaato.sdk.core.util.Intents;

/* JADX INFO: loaded from: classes9.dex */
public final class DeviceUtils {

    public enum ScreenOrientation {
        PORTRAIT,
        LANDSCAPE,
        UNKNOWN
    }

    private static boolean containsFlag(int i, int i2) {
        return (i & i2) != 0;
    }

    public static boolean isLocationAvailable(AppMetaData appMetaData) {
        return appMetaData.isPermissionGranted("android.permission.ACCESS_COARSE_LOCATION");
    }

    public static boolean isInlineVideoSupported(Context context, WebView webView) {
        if (context instanceof Activity) {
            for (View view = webView; view != null; view = (View) view.getParent()) {
                if (!view.isHardwareAccelerated() || containsFlag(view.getLayerType(), 1)) {
                    return false;
                }
                if (!(view.getParent() instanceof View)) {
                    break;
                }
            }
            Window window = ((Activity) context).getWindow();
            if (window != null) {
                return containsFlag(window.getAttributes().flags, 16777216);
            }
        }
        return false;
    }

    public static boolean isSmsAvailable(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        return Intents.canHandleIntent(context, intent);
    }

    public static boolean isTelAvailable(Context context) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        return Intents.canHandleIntent(context, intent);
    }

    public static ScreenOrientation getScreenOrientation(Context context) {
        int i = context.getResources().getConfiguration().orientation;
        if (i == 1) {
            return ScreenOrientation.PORTRAIT;
        }
        if (i == 2) {
            return ScreenOrientation.LANDSCAPE;
        }
        return ScreenOrientation.UNKNOWN;
    }

    /* JADX INFO: renamed from: com.smaato.sdk.richmedia.util.DeviceUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$smaato$sdk$richmedia$util$DeviceUtils$ScreenOrientation;

        static {
            int[] iArr = new int[ScreenOrientation.values().length];
            $SwitchMap$com$smaato$sdk$richmedia$util$DeviceUtils$ScreenOrientation = iArr;
            try {
                iArr[ScreenOrientation.PORTRAIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$smaato$sdk$richmedia$util$DeviceUtils$ScreenOrientation[ScreenOrientation.LANDSCAPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$smaato$sdk$richmedia$util$DeviceUtils$ScreenOrientation[ScreenOrientation.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static int getActivityInfoOrientation(ScreenOrientation screenOrientation) {
        int i = AnonymousClass1.$SwitchMap$com$smaato$sdk$richmedia$util$DeviceUtils$ScreenOrientation[screenOrientation.ordinal()];
        if (i != 1) {
            return i != 2 ? -1 : 0;
        }
        return 1;
    }

    public static boolean isOrientationLocked(Context context) {
        if (isAutoRotateLocked(context)) {
            return true;
        }
        if (context instanceof Activity) {
            return OrientationLockedCompat.isLocked((Activity) context);
        }
        return false;
    }

    static boolean isAutoRotateLocked(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", 0) == 0;
    }
}
