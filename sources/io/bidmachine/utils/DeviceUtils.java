package io.bidmachine.utils;

import android.bluetooth.BluetoothAdapter;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import com.explorestack.protobuf.adcom.ConnectionStatus;
import com.explorestack.protobuf.adcom.ConnectionType;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class DeviceUtils {
    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getBuildId() {
        return Build.ID;
    }

    public static String getModel() {
        return Build.MODEL;
    }

    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    public static int getOrientation(Context context) {
        if (context != null) {
            return context.getResources().getConfiguration().orientation;
        }
        return 0;
    }

    public static Set<String> getInputLanguageSet(Context context) {
        HashSet hashSet = new HashSet();
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
            if (inputMethodManager == null) {
                return hashSet;
            }
            Iterator<InputMethodInfo> it = inputMethodManager.getEnabledInputMethodList().iterator();
            while (it.hasNext()) {
                for (InputMethodSubtype inputMethodSubtype : inputMethodManager.getEnabledInputMethodSubtypeList(it.next(), true)) {
                    if (inputMethodSubtype.getMode().equals("keyboard")) {
                        String languageTag = inputMethodSubtype.getLanguageTag();
                        if (TextUtils.isEmpty(languageTag)) {
                            languageTag = inputMethodSubtype.getLocale();
                        }
                        if (!TextUtils.isEmpty(languageTag)) {
                            int iIndexOf = languageTag.indexOf("_");
                            if (iIndexOf > 0) {
                                languageTag = languageTag.substring(0, iIndexOf);
                            }
                            hashSet.add(languageTag);
                        }
                    }
                }
            }
            String language = Locale.getDefault().getLanguage();
            if (!TextUtils.isEmpty(language)) {
                hashSet.add(language);
            }
        } catch (Exception unused) {
        }
        return hashSet;
    }

    public static Boolean isCharging(Context context) {
        try {
            Intent intentRegisterInternalReceiver = registerInternalReceiver(context, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterInternalReceiver == null) {
                return null;
            }
            int intExtra = intentRegisterInternalReceiver.getIntExtra("plugged", -1);
            boolean z = true;
            if (intExtra != 1 && intExtra != 2 && intExtra != 4) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Intent registerInternalReceiver(Context context, IntentFilter intentFilter) {
        if (Build.VERSION.SDK_INT >= 34) {
            return context.registerReceiver(null, intentFilter, 4);
        }
        return context.registerReceiver(null, intentFilter);
    }

    public static Double getBatteryLevel(Context context) {
        try {
            Intent intentRegisterInternalReceiver = registerInternalReceiver(context, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterInternalReceiver == null) {
                return null;
            }
            int intExtra = intentRegisterInternalReceiver.getIntExtra("level", -1);
            int intExtra2 = intentRegisterInternalReceiver.getIntExtra("scale", -1);
            if (intExtra < 0 || intExtra2 <= 0) {
                return null;
            }
            return Double.valueOf(Math.round((((double) intExtra) / ((double) intExtra2)) * 100.0d) / 100.0d);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Boolean isBatterySaverEnabled(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null) {
            return Boolean.valueOf(powerManager.isPowerSaveMode());
        }
        return null;
    }

    public static boolean isDarkModeEnabled(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static Boolean isAirplaneModeOn(Context context) {
        try {
            return Boolean.valueOf(Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on") != 0);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Boolean isDoNotDisturbOn(Context context) {
        try {
            return Boolean.valueOf(Settings.Global.getInt(context.getContentResolver(), "zen_mode") != 0);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getDeviceName(Context context) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            String string = Settings.Global.getString(contentResolver, "device_name");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            String string2 = Settings.Secure.getString(contentResolver, "bluetooth_name");
            if (!TextUtils.isEmpty(string2)) {
                return string2;
            }
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (!Utils.isPermissionGranted(context, "android.permission.BLUETOOTH_CONNECT") || defaultAdapter == null) {
                return null;
            }
            return defaultAdapter.getName();
        } catch (Exception unused) {
            return null;
        }
    }

    public static Integer getScreenBrightness(Context context) {
        try {
            return Integer.valueOf(Settings.System.getInt(context.getContentResolver(), "screen_brightness"));
        } catch (Exception unused) {
            return null;
        }
    }

    public static Double getScreenBrightnessRatio(Context context) {
        Integer screenBrightness = getScreenBrightness(context);
        if (screenBrightness == null) {
            return null;
        }
        return Double.valueOf(Math.round((((double) screenBrightness.intValue()) / 255.0d) * 100.0d) / 100.0d);
    }

    public static ConnectionType getConnectionType(Context context) {
        NetworkInfo activeNetworkInfo = Utils.getActiveNetworkInfo(context);
        if (activeNetworkInfo == null) {
            return ConnectionType.CONNECTION_TYPE_INVALID;
        }
        int type = activeNetworkInfo.getType();
        if (type == 0) {
            return getMobileNetworkType(activeNetworkInfo);
        }
        if (type == 1) {
            return ConnectionType.CONNECTION_TYPE_WIFI;
        }
        if (type == 9) {
            return ConnectionType.CONNECTION_TYPE_ETHERNET;
        }
        return ConnectionType.CONNECTION_TYPE_INVALID;
    }

    public static ConnectionStatus getProxyStatus(Context context) {
        ConnectivityManager connectivityManager = Utils.getConnectivityManager(context);
        if (connectivityManager == null) {
            return ConnectionStatus.CONNECTION_STATUS_UNDEFINED;
        }
        if (connectivityManager.getDefaultProxy() != null) {
            return ConnectionStatus.CONNECTION_STATUS_ENABLED;
        }
        return ConnectionStatus.CONNECTION_STATUS_DISABLED;
    }

    public static ConnectionStatus getVpnStatus(Context context) {
        NetworkCapabilities activeNetworkCapabilities = Utils.getActiveNetworkCapabilities(context);
        if (activeNetworkCapabilities == null) {
            return ConnectionStatus.CONNECTION_STATUS_UNDEFINED;
        }
        if (activeNetworkCapabilities.hasTransport(4)) {
            return ConnectionStatus.CONNECTION_STATUS_ENABLED;
        }
        return ConnectionStatus.CONNECTION_STATUS_DISABLED;
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        return context.getResources().getDisplayMetrics();
    }

    public static boolean isTablet(Context context) {
        DisplayMetrics displayMetrics = getDisplayMetrics(context);
        double d = displayMetrics.widthPixels / displayMetrics.xdpi;
        double d2 = displayMetrics.heightPixels / displayMetrics.ydpi;
        return Math.sqrt((d * d) + (d2 * d2)) >= 6.6d;
    }

    public static int getScreenDpi(Context context) {
        return getDisplayMetrics(context).densityDpi;
    }

    public static String getPhoneMCCMNC(Context context) {
        String networkOperator;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null || (networkOperator = telephonyManager.getNetworkOperator()) == null || networkOperator.length() < 3) {
                return null;
            }
            return networkOperator.substring(0, 3) + "-" + networkOperator.substring(3);
        } catch (Exception e) {
            Logger.w(e);
            return null;
        }
    }

    public static String getPhoneOperator(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return telephonyManager.getNetworkOperatorName();
            }
            return null;
        } catch (Exception e) {
            Logger.w(e);
            return null;
        }
    }

    private static ConnectionType getMobileNetworkType(NetworkInfo networkInfo) {
        switch (networkInfo.getSubtype()) {
            case 0:
                return ConnectionType.CONNECTION_TYPE_CELLULAR_NETWORK_UNKNOWN;
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return ConnectionType.CONNECTION_TYPE_CELLULAR_NETWORK_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return ConnectionType.CONNECTION_TYPE_CELLULAR_NETWORK_3G;
            case 13:
            case 18:
            case 19:
            default:
                return ConnectionType.CONNECTION_TYPE_CELLULAR_NETWORK_4G;
            case 20:
                return ConnectionType.CONNECTION_TYPE_CELLULAR_NETWORK_5G;
        }
    }

    public static String getSha256Signature(Context context) {
        return getShaSignature(context, "SHA-256");
    }

    public static String getSha1Signature(Context context) {
        return getShaSignature(context, AndroidStaticDeviceInfoDataSource.ALGORITHM_SHA1);
    }

    private static String getShaSignature(Context context, String str) {
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            if (signatureArr.length == 0) {
                return null;
            }
            return Utils.toSignatureHexString(MessageDigest.getInstance(str).digest(signatureArr[0].toByteArray()));
        } catch (Throwable th) {
            Logger.w(th);
            return null;
        }
    }
}
