package io.bidmachine.util;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Point;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.json.b9;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeviceUtils.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007\u001a\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u0002H\u0007\u001a\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u0002¢\u0006\u0002\u0010\u0007\u001a\u000e\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u0002H\u0007\u001a\n\u0010\n\u001a\u00020\u000b*\u00020\u0002\u001a\u000e\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u0002H\u0007\u001a\n\u0010\u000e\u001a\u00020\u000f*\u00020\u0002\u001a\n\u0010\u0010\u001a\u00020\u0011*\u00020\u0002\u001a\f\u0010\u0012\u001a\u0004\u0018\u00010\r*\u00020\u0002\u001a\f\u0010\u0013\u001a\u0004\u0018\u00010\r*\u00020\u0002\u001a\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0011*\u00020\u0002¢\u0006\u0002\u0010\u0015\u001a\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0006*\u00020\u0002¢\u0006\u0002\u0010\u0007\u001a\n\u0010\u0017\u001a\u00020\u0018*\u00020\u0002\u001a\n\u0010\u0019\u001a\u00020\u0011*\u00020\u0002\u001a\n\u0010\u001a\u001a\u00020\u001b*\u00020\u0002\u001a\u0011\u0010\u001c\u001a\u0004\u0018\u00010\u001d*\u00020\u0002¢\u0006\u0002\u0010\u001e\u001a\u0011\u0010\u001f\u001a\u0004\u0018\u00010\u001d*\u00020\u0002¢\u0006\u0002\u0010\u001e\u001a\u0011\u0010 \u001a\u0004\u0018\u00010\u001d*\u00020\u0002¢\u0006\u0002\u0010\u001e\u001a\n\u0010!\u001a\u00020\u001d*\u00020\u0002\u001a\u0011\u0010\"\u001a\u0004\u0018\u00010\u001d*\u00020\u0002¢\u0006\u0002\u0010\u001e\u001a\n\u0010#\u001a\u00020\u001d*\u00020\u0002\u001a\f\u0010$\u001a\u00020\u001d*\u00020\u0002H\u0007\u001a\u0011\u0010%\u001a\u0004\u0018\u00010\u001d*\u00020\u0002¢\u0006\u0002\u0010\u001e¨\u0006&"}, d2 = {"getActiveNetworkCapabilities", "Landroid/net/NetworkCapabilities;", "Landroid/content/Context;", "getActiveNetworkInfo", "Landroid/net/NetworkInfo;", "getBatteryLevel", "", "(Landroid/content/Context;)Ljava/lang/Double;", "getBluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "getConfiguration", "Landroid/content/res/Configuration;", "getDeviceName", "", "getDisplayMetrics", "Landroid/util/DisplayMetrics;", "getOrientation", "", "getPhoneMCCMNC", "getPhoneOperatorName", "getScreenBrightness", "(Landroid/content/Context;)Ljava/lang/Integer;", "getScreenBrightnessRatio", "getScreenDensity", "", "getScreenOrientation", "getScreenSize", "Landroid/graphics/Point;", "isAirplaneModeOn", "", "(Landroid/content/Context;)Ljava/lang/Boolean;", "isBatterySaverEnabled", b9.i.k0, "isDarkModeEnabled", "isDoNotDisturbOn", "isLandscapeOrientation", "isNetworkAvailable", "isRingMuted", "bidmachine-android-util_d_0_4_0"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class DeviceUtilsKt {
    public static final DisplayMetrics getDisplayMetrics(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "resources.displayMetrics");
        return displayMetrics;
    }

    public static final Configuration getConfiguration(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Configuration configuration = context.getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "resources.configuration");
        return configuration;
    }

    public static final boolean isNetworkAvailable(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        NetworkCapabilities activeNetworkCapabilities = getActiveNetworkCapabilities(context);
        boolean z = false;
        if (activeNetworkCapabilities == null) {
            return false;
        }
        boolean z2 = activeNetworkCapabilities.hasCapability(12) && activeNetworkCapabilities.hasCapability(16);
        if (Build.VERSION.SDK_INT < 28) {
            return z2;
        }
        if (z2 && activeNetworkCapabilities.hasCapability(21) && activeNetworkCapabilities.hasCapability(19)) {
            z = true;
        }
        return z;
    }

    @Deprecated(message = "Use getActiveNetworkCapabilities instead", replaceWith = @ReplaceWith(expression = "Context#getActiveNetworkCapabilities()", imports = {}))
    public static final NetworkInfo getActiveNetworkInfo(Context context) {
        ConnectivityManager connectivityManager;
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (!UtilsKt.isPermissionGranted(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = UtilsKt.getConnectivityManager(context)) == null) {
            return null;
        }
        try {
            return connectivityManager.getActiveNetworkInfo();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final NetworkCapabilities getActiveNetworkCapabilities(Context context) {
        ConnectivityManager connectivityManager;
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (!UtilsKt.isPermissionGranted(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = UtilsKt.getConnectivityManager(context)) == null) {
            return null;
        }
        try {
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(activeNetwork, "it.activeNetwork ?: return null");
            return connectivityManager.getNetworkCapabilities(activeNetwork);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final int getOrientation(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return getConfiguration(context).orientation;
    }

    public static final boolean isLandscapeOrientation(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        int screenOrientation = getScreenOrientation(context);
        return screenOrientation == 0 || screenOrientation == 8 || screenOrientation == 6 || screenOrientation == 11;
    }

    public static final int getScreenOrientation(Context context) {
        Display defaultDisplay;
        Intrinsics.checkNotNullParameter(context, "<this>");
        WindowManager windowManager = UtilsKt.getWindowManager(context);
        Integer numValueOf = (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) ? null : Integer.valueOf(defaultDisplay.getRotation());
        int orientation = getOrientation(context);
        if (orientation == 1) {
            if (numValueOf != null && numValueOf.intValue() == 2) {
                return 9;
            }
            if (numValueOf != null && numValueOf.intValue() == 3) {
                return 9;
            }
            if ((numValueOf == null || numValueOf.intValue() != 0) && numValueOf != null) {
                numValueOf.intValue();
            }
            return 1;
        }
        if (orientation != 2) {
            return 9;
        }
        if ((numValueOf != null && numValueOf.intValue() == 2) || (numValueOf != null && numValueOf.intValue() == 3)) {
            return 8;
        }
        if ((numValueOf != null && numValueOf.intValue() == 0) || numValueOf == null) {
            return 0;
        }
        numValueOf.intValue();
        return 0;
    }

    public static final float getScreenDensity(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return getDisplayMetrics(context).density;
    }

    public static final Point getScreenSize(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        DisplayMetrics displayMetrics = getDisplayMetrics(context);
        return new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public static final Boolean isRingMuted(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        AudioManager audioManager = UtilsKt.getAudioManager(context);
        if (audioManager == null) {
            return null;
        }
        int ringerMode = audioManager.getRingerMode();
        boolean z = true;
        if (ringerMode != 0 && ringerMode != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public static final Boolean isCharging(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            Intent intentRegisterSystemReceiver = UtilsKt.registerSystemReceiver(context, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterSystemReceiver == null) {
                return null;
            }
            int intExtra = intentRegisterSystemReceiver.getIntExtra("plugged", -1);
            boolean z = true;
            if (intExtra != 1 && intExtra != 2 && intExtra != 4) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final Double getBatteryLevel(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            Intent intentRegisterSystemReceiver = UtilsKt.registerSystemReceiver(context, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterSystemReceiver == null) {
                return null;
            }
            int intExtra = intentRegisterSystemReceiver.getIntExtra("level", -1);
            int intExtra2 = intentRegisterSystemReceiver.getIntExtra("scale", -1);
            if (intExtra < 0 || intExtra2 <= 0) {
                return null;
            }
            return Double.valueOf(Math.round((((double) intExtra) / ((double) intExtra2)) * ((double) 100)) / 100.0d);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final Boolean isBatterySaverEnabled(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        PowerManager powerManager = UtilsKt.getPowerManager(context);
        if (powerManager != null) {
            return Boolean.valueOf(powerManager.isPowerSaveMode());
        }
        return null;
    }

    public static final boolean isDarkModeEnabled(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (getConfiguration(context).uiMode & 48) == 32;
    }

    public static final Boolean isAirplaneModeOn(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            return Boolean.valueOf(Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on") != 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final Boolean isDoNotDisturbOn(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            return Boolean.valueOf(Settings.Global.getInt(context.getContentResolver(), "zen_mode") != 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final String getDeviceName(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "device_name");
            if (string != null && string.length() > 0) {
                return string;
            }
            String string2 = Settings.Secure.getString(context.getContentResolver(), "bluetooth_name");
            if (string2 != null && string2.length() > 0) {
                return string2;
            }
            BluetoothAdapter bluetoothAdapter = getBluetoothAdapter(context);
            String name = bluetoothAdapter != null ? bluetoothAdapter.getName() : null;
            if (name != null && name.length() > 0) {
                return name;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static final BluetoothAdapter getBluetoothAdapter(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        BluetoothAdapter defaultAdapter = null;
        try {
            if (UtilsKt.isPermissionGranted(context, "android.permission.BLUETOOTH_CONNECT")) {
                if (Build.VERSION.SDK_INT >= 31) {
                    BluetoothManager bluetoothManager = UtilsKt.getBluetoothManager(context);
                    if (bluetoothManager != null) {
                        defaultAdapter = bluetoothManager.getAdapter();
                    }
                } else {
                    defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                }
            }
        } catch (Exception unused) {
        }
        return defaultAdapter;
    }

    public static final Integer getScreenBrightness(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            return Integer.valueOf(Settings.System.getInt(context.getContentResolver(), "screen_brightness"));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final Double getScreenBrightnessRatio(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Integer screenBrightness = getScreenBrightness(context);
        if (screenBrightness != null) {
            return Double.valueOf(Math.round((((double) screenBrightness.intValue()) / 255.0d) * ((double) 100)) / 100.0d);
        }
        return null;
    }

    public static final String getPhoneMCCMNC(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            TelephonyManager telephonyManager = UtilsKt.getTelephonyManager(context);
            String networkOperator = telephonyManager != null ? telephonyManager.getNetworkOperator() : null;
            if (networkOperator != null && networkOperator.length() >= 3) {
                StringBuilder sb = new StringBuilder();
                String strSubstring = networkOperator.substring(0, 3);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                StringBuilder sbAppend = sb.append(strSubstring).append('-');
                String strSubstring2 = networkOperator.substring(3);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
                return sbAppend.append(strSubstring2).toString();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static final String getPhoneOperatorName(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        TelephonyManager telephonyManager = UtilsKt.getTelephonyManager(context);
        if (telephonyManager != null) {
            return telephonyManager.getNetworkOperatorName();
        }
        return null;
    }
}
