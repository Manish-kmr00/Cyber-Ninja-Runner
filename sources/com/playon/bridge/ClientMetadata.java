package com.playon.bridge;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.BatteryManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import com.playon.bridge.common.Log;
import com.playon.bridge.common.SdkInitializationListener;
import com.playon.bridge.common.util.PluginUtils;
import com.pubmatic.sdk.rewardedad.POBRewardedAdEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes7.dex */
public class ClientMetadata {
    private static final String DEVICE_BATTERY_CHARGED = "charged";
    private static final String DEVICE_BATTERY_CHARGING = "charging";
    private static final String DEVICE_BATTERY_NOTCHARGING = "notcharging";
    private static final String DEVICE_BATTERY_UNKNOWN = "unknown";
    private static final String DEVICE_ORIENTATION_LANDSCAPE = "l";
    private static final String DEVICE_ORIENTATION_PORTRAIT = "p";
    private static final String DEVICE_ORIENTATION_UNKNOWN = "u";
    protected static final String TAG = Log.makeTag(POBRewardedAdEvent.KEY_IDENTIFER);
    private String mAppName;
    private final String mAppPackageName;
    private final String mAppVersion;
    private final ConnectivityManager mConnectivityManager;
    private final Context mContext;
    private final String mDeviceManufacturer;
    private final String mDeviceModel;
    private final String mDeviceOsVersion;
    private final String mDeviceProduct;
    private String mIsoCountryCode;
    private String mNetworkOperator;
    private String mNetworkOperatorForUrl;
    private String mNetworkOperatorName;
    private String mSimIsoCountryCode;
    private String mSimOperator;
    private String mSimOperatorName;

    public enum PlayOnNetworkType {
        UNKNOWN(0),
        ETHERNET(1),
        WIFI(2),
        MOBILE(3),
        GG(4),
        GGG(5),
        GGGG(6),
        GGGGG(7);

        private final int mId;

        PlayOnNetworkType(int i) {
            this.mId = i;
        }

        @Override // java.lang.Enum
        public String toString() {
            return Integer.toString(this.mId);
        }

        public int getId() {
            return this.mId;
        }
    }

    public ClientMetadata(Context context, SdkInitializationListener sdkInitializationListener) {
        ApplicationInfo applicationInfo;
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.mConnectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity");
        this.mDeviceManufacturer = Build.MANUFACTURER;
        this.mDeviceModel = Build.MODEL;
        this.mDeviceProduct = Build.PRODUCT;
        this.mDeviceOsVersion = Build.VERSION.RELEASE;
        this.mAppVersion = getAppVersionFromContext(applicationContext);
        PackageManager packageManager = applicationContext.getPackageManager();
        String packageName = applicationContext.getPackageName();
        this.mAppPackageName = packageName;
        try {
            applicationInfo = packageManager.getApplicationInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            applicationInfo = null;
        }
        if (applicationInfo != null) {
            this.mAppName = (String) packageManager.getApplicationLabel(applicationInfo);
        }
        TelephonyManager telephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
        if (telephonyManager != null) {
            this.mNetworkOperatorForUrl = telephonyManager.getNetworkOperator();
            this.mNetworkOperator = telephonyManager.getNetworkOperator();
            if (telephonyManager.getPhoneType() == 2 && telephonyManager.getSimState() == 5) {
                this.mNetworkOperatorForUrl = telephonyManager.getSimOperator();
                this.mSimOperator = telephonyManager.getSimOperator();
            }
            if (PlayOnManager.getInstance().getPersonalInfo().canCollectPersonalInformation()) {
                this.mIsoCountryCode = telephonyManager.getNetworkCountryIso();
                this.mSimIsoCountryCode = telephonyManager.getSimCountryIso();
            } else {
                this.mIsoCountryCode = "";
                this.mSimIsoCountryCode = "";
            }
            try {
                this.mNetworkOperatorName = telephonyManager.getNetworkOperatorName();
                if (telephonyManager.getSimState() == 5) {
                    this.mSimOperatorName = telephonyManager.getSimOperatorName();
                }
            } catch (SecurityException unused2) {
                this.mNetworkOperatorName = null;
                this.mSimOperatorName = null;
            }
        }
        if (sdkInitializationListener != null) {
            sdkInitializationListener.onInitializationFinished();
        }
    }

    public void repopulateCountryData() {
        TelephonyManager telephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
        if (!PlayOnManager.getInstance().getPersonalInfo().canCollectPersonalInformation() || telephonyManager == null) {
            return;
        }
        this.mIsoCountryCode = telephonyManager.getNetworkCountryIso();
        this.mSimIsoCountryCode = telephonyManager.getSimCountryIso();
    }

    private static String getAppVersionFromContext(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            Log.d(TAG, "Failed to retrieve PackageInfo#versionName.");
            return null;
        }
    }

    public String getOrientationString() {
        int i = this.mContext.getResources().getConfiguration().orientation;
        if (i == 1) {
            return "p";
        }
        if (i != 2) {
            return "u";
        }
        return "l";
    }

    public PlayOnNetworkType getActiveNetworkType() {
        if (!PluginUtils.isPermissionGranted(this.mContext, "android.permission.ACCESS_NETWORK_STATE")) {
            return PlayOnNetworkType.UNKNOWN;
        }
        NetworkInfo activeNetworkInfo = this.mConnectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return PlayOnNetworkType.UNKNOWN;
        }
        for (Network network : this.mConnectivityManager.getAllNetworks()) {
            NetworkCapabilities networkCapabilities = this.mConnectivityManager.getNetworkCapabilities(network);
            if (networkCapabilities != null && networkCapabilities.hasTransport(3)) {
                return PlayOnNetworkType.ETHERNET;
            }
        }
        NetworkInfo networkInfo = this.mConnectivityManager.getNetworkInfo(1);
        if (networkInfo != null && networkInfo.isConnected()) {
            return PlayOnNetworkType.WIFI;
        }
        NetworkInfo networkInfo2 = this.mConnectivityManager.getNetworkInfo(0);
        if (networkInfo2 != null && networkInfo2.isConnected()) {
            int subtype = networkInfo2.getSubtype();
            if (subtype != 20) {
                switch (subtype) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return PlayOnNetworkType.GG;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                        return PlayOnNetworkType.GGG;
                    case 13:
                    case 15:
                        return PlayOnNetworkType.GGGG;
                    default:
                        return PlayOnNetworkType.MOBILE;
                }
            }
            return PlayOnNetworkType.GGGGG;
        }
        return PlayOnNetworkType.UNKNOWN;
    }

    public int getDeviceBatteryLevel() {
        return ((BatteryManager) this.mContext.getSystemService("batterymanager")).getIntProperty(4);
    }

    public float getDeviceVolumeLevel() {
        AudioManager audioManager = (AudioManager) this.mContext.getSystemService("audio");
        return (audioManager.getStreamVolume(3) / audioManager.getStreamMaxVolume(3)) * 100.0f;
    }

    public String getDeviceBatteryState() {
        int intExtra = this.mContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("status", -1);
        if (intExtra == 4) {
            return DEVICE_BATTERY_NOTCHARGING;
        }
        if (intExtra == 5) {
            return DEVICE_BATTERY_CHARGED;
        }
        if (intExtra == 2) {
            return DEVICE_BATTERY_CHARGING;
        }
        return "unknown";
    }

    public String[] getDeviceInputLanguages() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
        List<InputMethodInfo> enabledInputMethodList = inputMethodManager.getEnabledInputMethodList();
        ArrayList arrayList = new ArrayList();
        Iterator<InputMethodInfo> it = enabledInputMethodList.iterator();
        while (it.hasNext()) {
            for (InputMethodSubtype inputMethodSubtype : inputMethodManager.getEnabledInputMethodSubtypeList(it.next(), true)) {
                if (inputMethodSubtype.getMode().equals("keyboard")) {
                    arrayList.add(inputMethodSubtype.getLocale());
                }
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public String[] getDeviceOutputInfo() {
        AudioDeviceInfo[] devices = ((AudioManager) this.mContext.getSystemService("audio")).getDevices(2);
        String[] strArr = new String[devices.length];
        for (int i = 0; i < devices.length; i++) {
            strArr[i] = String.valueOf(devices[i].getType());
        }
        return strArr;
    }

    public String[] getDeviceInputInfo() {
        AudioDeviceInfo[] devices = ((AudioManager) this.mContext.getSystemService("audio")).getDevices(1);
        String[] strArr = new String[devices.length];
        for (int i = 0; i < devices.length; i++) {
            strArr[i] = String.valueOf(devices[i].getType());
        }
        return strArr;
    }

    public float getDensity() {
        return this.mContext.getResources().getDisplayMetrics().density;
    }

    public String getNetworkOperatorForUrl() {
        return this.mNetworkOperatorForUrl;
    }

    public String getNetworkOperator() {
        return this.mNetworkOperator;
    }

    public Locale getDeviceLocale() {
        return this.mContext.getResources().getConfiguration().locale;
    }

    public String getSimOperator() {
        return this.mSimOperator;
    }

    public String getIsoCountryCode() {
        return PlayOnManager.getInstance().getPersonalInfo().canCollectPersonalInformation() ? this.mIsoCountryCode : "";
    }

    public String getSimIsoCountryCode() {
        return PlayOnManager.getInstance().getPersonalInfo().canCollectPersonalInformation() ? this.mSimIsoCountryCode : "";
    }

    public String getNetworkOperatorName() {
        return this.mNetworkOperatorName;
    }

    public String getSimOperatorName() {
        return this.mSimOperatorName;
    }

    public String getDeviceManufacturer() {
        return this.mDeviceManufacturer;
    }

    public String getDeviceModel() {
        return this.mDeviceModel;
    }

    public String getDeviceProduct() {
        return this.mDeviceProduct;
    }

    public String getDeviceOsVersion() {
        return this.mDeviceOsVersion;
    }

    public String getAppVersion() {
        return this.mAppVersion;
    }

    public String getAppPackageName() {
        return this.mAppPackageName;
    }

    public String getAppName() {
        return this.mAppName;
    }

    public String getCurrentLanguage() {
        String strTrim = Locale.getDefault().getLanguage().trim();
        Locale locale = this.mContext.getResources().getConfiguration().locale;
        return (locale == null || locale.getLanguage().trim().isEmpty()) ? strTrim : locale.getLanguage().trim();
    }
}
