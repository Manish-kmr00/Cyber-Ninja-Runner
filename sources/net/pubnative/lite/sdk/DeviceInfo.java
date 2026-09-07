package net.pubnative.lite.sdk;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Point;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import com.json.x8;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import net.pubnative.lite.sdk.models.request.UserAgent;
import net.pubnative.lite.sdk.utils.HyBidAdvertisingId;
import net.pubnative.lite.sdk.utils.Logger;
import net.pubnative.lite.sdk.utils.PNCrypto;
import net.pubnative.lite.sdk.utils.ScreenDimensionsUtils;
import net.pubnative.lite.sdk.utils.SoundUtils;

/* JADX INFO: loaded from: classes8.dex */
public class DeviceInfo {
    private static final String TAG = "DeviceInfo";
    private String deviceHeight;
    private String deviceWidth;
    private String mAdvertisingId;
    private String mAdvertisingIdMd5;
    private String mAdvertisingIdSha1;
    private final Context mContext;
    private Listener mListener;
    private float pxratio;
    private boolean mLimitTracking = false;
    private boolean mIsCharging = false;
    private boolean mIsChangingReceiverRegistered = false;
    private final BroadcastReceiver mBatteryStatusReceiver = new BroadcastReceiver() { // from class: net.pubnative.lite.sdk.DeviceInfo.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("status", -1);
            DeviceInfo.this.mIsCharging = intExtra == 2 || intExtra == 5;
            if (DeviceInfo.this.mContext != null) {
                DeviceInfo.this.mContext.unregisterReceiver(this);
                DeviceInfo.this.mIsChangingReceiverRegistered = false;
            }
        }
    };
    private final UserAgentProvider mUserAgentProvider = new UserAgentProvider();

    public interface Listener {
        void onInfoLoaded();
    }

    public enum Orientation {
        PORTRAIT("portrait"),
        LANDSCAPE("landscape"),
        NONE("none");

        private final String mOrientation;

        Orientation(String str) {
            this.mOrientation = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.mOrientation;
        }
    }

    public enum Connectivity {
        ETHERNET(x8.e),
        WIFI(x8.b),
        WWAN("wwan"),
        NONE("none");

        private final String mConnectivity;

        Connectivity(String str) {
            this.mConnectivity = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.mConnectivity;
        }
    }

    public DeviceInfo(Context context) {
        this.mContext = context.getApplicationContext();
        getDeviceScreenDimensions();
    }

    public void initialize(Listener listener) {
        this.mListener = listener;
        fetchUserAgent();
        fetchAdvertisingId();
        updateChargingStatus();
    }

    public void updateChargingStatus() {
        if (this.mIsChangingReceiverRegistered) {
            return;
        }
        this.mContext.registerReceiver(this.mBatteryStatusReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        this.mIsChangingReceiverRegistered = true;
    }

    private void fetchAdvertisingId() {
        try {
            new HyBidAdvertisingId(this.mContext).execute(new HyBidAdvertisingId.Listener() { // from class: net.pubnative.lite.sdk.DeviceInfo$$ExternalSyntheticLambda0
                @Override // net.pubnative.lite.sdk.utils.HyBidAdvertisingId.Listener
                public final void onHyBidAdvertisingIdFinish(String str, Boolean bool) {
                    this.f$0.m9523lambda$fetchAdvertisingId$0$netpubnativelitesdkDeviceInfo(str, bool);
                }
            });
        } catch (RejectedExecutionException e) {
            Logger.e(TAG, "fetchAdvertisingId", e);
            Listener listener = this.mListener;
            if (listener != null) {
                listener.onInfoLoaded();
            }
            HyBid.reportException((Exception) e);
        } catch (Exception e2) {
            Logger.e(TAG, "Error executing HyBidAdvertisingId Executor");
            Listener listener2 = this.mListener;
            if (listener2 != null) {
                listener2.onInfoLoaded();
            }
            HyBid.reportException(e2);
        }
    }

    /* JADX INFO: renamed from: lambda$fetchAdvertisingId$0$net-pubnative-lite-sdk-DeviceInfo, reason: not valid java name */
    /* synthetic */ void m9523lambda$fetchAdvertisingId$0$netpubnativelitesdkDeviceInfo(String str, Boolean bool) {
        this.mLimitTracking = bool.booleanValue();
        if (!TextUtils.isEmpty(str)) {
            this.mAdvertisingId = str;
            this.mAdvertisingIdMd5 = PNCrypto.md5(str);
            this.mAdvertisingIdSha1 = PNCrypto.sha1(this.mAdvertisingId);
        } else {
            fetchFireOSAdvertisingId();
        }
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onInfoLoaded();
        }
    }

    private void fetchFireOSAdvertisingId() {
        ContentResolver contentResolver;
        String string;
        try {
            Context context = this.mContext;
            if (context == null || (contentResolver = context.getContentResolver()) == null || Settings.Secure.getInt(contentResolver, CommonUrlParts.LIMIT_AD_TRACKING) != 0 || (string = Settings.Secure.getString(contentResolver, "advertising_id")) == null || string.isEmpty()) {
                return;
            }
            this.mAdvertisingId = string;
            this.mAdvertisingIdMd5 = PNCrypto.md5(string);
            this.mAdvertisingIdSha1 = PNCrypto.sha1(this.mAdvertisingId);
        } catch (Settings.SettingNotFoundException unused) {
        }
    }

    public void fetchUserAgent() {
        this.mUserAgentProvider.initialise(this.mContext);
    }

    public void getDeviceScreenDimensions() {
        Point screenDimensionsToPoint = new ScreenDimensionsUtils().getScreenDimensionsToPoint(this.mContext);
        this.deviceWidth = Integer.toString(screenDimensionsToPoint.x);
        this.deviceHeight = Integer.toString(screenDimensionsToPoint.y);
        Context context = this.mContext;
        if (context != null) {
            this.pxratio = context.getResources().getDisplayMetrics().density;
        }
    }

    public String getAdvertisingId() {
        return this.mAdvertisingId;
    }

    public String getAdvertisingIdMd5() {
        return this.mAdvertisingIdMd5;
    }

    public String getAdvertisingIdSha1() {
        return this.mAdvertisingIdSha1;
    }

    public boolean limitTracking() {
        return this.mLimitTracking;
    }

    public Locale getLocale() {
        Context context = this.mContext;
        if (context != null) {
            return context.getResources().getConfiguration().locale;
        }
        return null;
    }

    public Orientation getOrientation() {
        Context context = this.mContext;
        if (context != null) {
            int i = context.getResources().getConfiguration().orientation;
            if (i == 1) {
                return Orientation.PORTRAIT;
            }
            if (i == 2) {
                return Orientation.LANDSCAPE;
            }
            return Orientation.NONE;
        }
        return Orientation.NONE;
    }

    public String getModel() {
        return Build.MODEL;
    }

    public String getMake() {
        return Build.MANUFACTURER;
    }

    public int getDeviceType() {
        Context context = this.mContext;
        if (context != null) {
            return context.getResources().getBoolean(net.pubnative.lite.sdk.core.R.bool.is_tablet) ? 5 : 4;
        }
        return 1;
    }

    public Integer getConnectionType() {
        NetworkCapabilities networkCapabilities;
        if (hasPermission("android.permission.ACCESS_NETWORK_STATE")) {
            boolean zHasPermission = hasPermission("android.permission.READ_PHONE_STATE");
            Context context = this.mContext;
            if (context != null && context.getSystemService("connectivity") != null) {
                ConnectivityManager connectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
                if (zHasPermission) {
                    Network activeNetwork = connectivityManager.getActiveNetwork();
                    if (activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null) {
                        if (networkCapabilities.hasTransport(1)) {
                            return 2;
                        }
                        if (networkCapabilities.hasTransport(3)) {
                            return 1;
                        }
                        if (networkCapabilities.hasTransport(0)) {
                            TelephonyManager telephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
                            if (telephonyManager != null) {
                                switch (telephonyManager.getDataNetworkType()) {
                                    case 1:
                                    case 2:
                                    case 4:
                                    case 7:
                                    case 11:
                                    case 16:
                                        return 4;
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
                                        return 5;
                                    case 13:
                                    case 18:
                                    case 19:
                                        return 6;
                                    case 20:
                                        return 7;
                                    default:
                                        return 3;
                                }
                            }
                            return 3;
                        }
                    }
                    return null;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    int type = activeNetworkInfo.getType();
                    if (type != 0) {
                        if (type != 1) {
                            return type != 9 ? null : 1;
                        }
                        return 2;
                    }
                    switch (activeNetworkInfo.getSubtype()) {
                        case 0:
                            return 3;
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                        case 16:
                            return 4;
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
                            return 5;
                        case 13:
                        case 18:
                        case 19:
                            return 6;
                        case 20:
                            return 7;
                        default:
                            return null;
                    }
                }
            }
        }
        return null;
    }

    public String getCarrier() {
        TelephonyManager telephonyManager = getTelephonyManager();
        if (telephonyManager != null) {
            return telephonyManager.getNetworkOperatorName();
        }
        return "";
    }

    public String getMccmnc() {
        TelephonyManager telephonyManager = getTelephonyManager();
        if (telephonyManager != null) {
            return telephonyManager.getNetworkOperator();
        }
        return "";
    }

    public String getMccmncsim() {
        TelephonyManager telephonyManager = getTelephonyManager();
        if (telephonyManager != null) {
            return telephonyManager.getSimOperator();
        }
        return "";
    }

    public String getOSVersion() {
        return Build.VERSION.RELEASE;
    }

    public Context getContext() {
        return this.mContext;
    }

    public String getDeviceHeight() {
        return this.deviceHeight;
    }

    public String getDeviceWidth() {
        return this.deviceWidth;
    }

    public String getSoundSetting() {
        return SoundUtils.isSoundMuted(this.mContext) ? "0" : "1";
    }

    public String getUserAgent() {
        UserAgentProvider userAgentProvider = this.mUserAgentProvider;
        return userAgentProvider != null ? userAgentProvider.getUserAgent() : "";
    }

    public UserAgent getStructuredUserAgent() {
        UserAgentProvider userAgentProvider = this.mUserAgentProvider;
        if (userAgentProvider != null) {
            return userAgentProvider.getStructuredUserAgent();
        }
        return null;
    }

    public String getPpi() {
        Context context = this.mContext;
        if (context != null) {
            return String.valueOf((int) context.getResources().getDisplayMetrics().xdpi);
        }
        return "";
    }

    public String getPxratio() {
        return String.valueOf(this.pxratio);
    }

    public boolean hasTrackingPermissions() {
        return hasPermission("android.permission.ACCESS_COARSE_LOCATION") || hasPermission("android.permission.ACCESS_FINE_LOCATION");
    }

    private boolean hasPermission(String str) {
        Context context = this.mContext;
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    private TelephonyManager getTelephonyManager() {
        Context context = this.mContext;
        if (context != null) {
            return (TelephonyManager) context.getSystemService("phone");
        }
        return null;
    }

    public String getLangb() {
        Locale locale = getLocale();
        if (locale != null) {
            return locale.toLanguageTag();
        }
        return null;
    }

    public List<String> getInputLanguages() {
        List<InputMethodInfo> enabledInputMethodList;
        List<InputMethodSubtype> enabledInputMethodSubtypeList;
        String mode;
        String locale;
        ArrayList arrayList = new ArrayList();
        Context context = this.mContext;
        if (context != null) {
            try {
                InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
                if (inputMethodManager != null && (enabledInputMethodList = inputMethodManager.getEnabledInputMethodList()) != null && !enabledInputMethodList.isEmpty()) {
                    for (InputMethodInfo inputMethodInfo : enabledInputMethodList) {
                        if (inputMethodInfo != null && (enabledInputMethodSubtypeList = inputMethodManager.getEnabledInputMethodSubtypeList(inputMethodInfo, true)) != null) {
                            for (InputMethodSubtype inputMethodSubtype : enabledInputMethodSubtypeList) {
                                if (inputMethodSubtype != null && (mode = inputMethodSubtype.getMode()) != null && mode.equals("keyboard") && (locale = inputMethodSubtype.getLocale()) != null && !locale.isEmpty()) {
                                    arrayList.add(locale);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                Logger.e(TAG, "Error getting input languages", e);
            }
        }
        return arrayList;
    }

    public Integer isBatteryCharging() {
        updateChargingStatus();
        return Integer.valueOf(this.mIsCharging ? 1 : 0);
    }

    public Integer getBatteryLevel() {
        BatteryManager batteryManager;
        Context context = this.mContext;
        if (context == null || (batteryManager = (BatteryManager) context.getSystemService("batterymanager")) == null) {
            return null;
        }
        int intProperty = batteryManager.getIntProperty(4);
        if (intProperty >= 85) {
            return 8;
        }
        if (intProperty >= 70) {
            return 7;
        }
        if (intProperty >= 55) {
            return 6;
        }
        if (intProperty >= 40) {
            return 5;
        }
        if (intProperty >= 25) {
            return 4;
        }
        if (intProperty >= 10) {
            return 3;
        }
        if (intProperty >= 5) {
            return 2;
        }
        return intProperty >= 0 ? 1 : null;
    }

    public Integer isPowerSaveMode() {
        PowerManager powerManager = (PowerManager) this.mContext.getSystemService("power");
        if (powerManager == null) {
            return null;
        }
        if (powerManager.isPowerSaveMode()) {
            return 1;
        }
        return 0;
    }

    public Integer getTotalMemoryMb() {
        return Integer.valueOf((int) ((getTotalInternalMemorySize().longValue() / 1024) / 1024));
    }

    public Integer getFreeMemoryMb() {
        return Integer.valueOf((int) ((getAvailableInternalMemorySize().longValue() / 1024) / 1024));
    }

    private Long getAvailableInternalMemorySize() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return Long.valueOf(statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong());
    }

    private Long getTotalInternalMemorySize() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return Long.valueOf(statFs.getBlockCountLong() * statFs.getBlockSizeLong());
    }

    public Integer isDarkMode() {
        Context context = this.mContext;
        if (context != null && context.getResources() != null && this.mContext.getResources().getConfiguration() != null) {
            int i = this.mContext.getResources().getConfiguration().uiMode & 48;
            if (i == 16) {
                return 0;
            }
            if (i == 32) {
                return 1;
            }
        }
        return null;
    }

    public Integer isDndEnabled() {
        try {
            Context context = this.mContext;
            if (context != null && context.getContentResolver() != null) {
                int i = Settings.Global.getInt(this.mContext.getContentResolver(), "zen_mode");
                if (i == 0) {
                    Logger.d(TAG, "DnD : OFF");
                    return 0;
                }
                if (i == 1) {
                    Logger.d(TAG, "DnD : ON - Priority Only");
                    return 1;
                }
                if (i == 2) {
                    Logger.d(TAG, "DnD : ON - Total Silence");
                    return 1;
                }
                if (i != 3) {
                    return null;
                }
                Logger.d(TAG, "DnD : ON - Alarms Only");
                return 1;
            }
            return null;
        } catch (Settings.SettingNotFoundException unused) {
            return null;
        }
    }

    public Integer isAirplaneModeEnabled() {
        return checkAirplaneMode();
    }

    private Integer checkAirplaneMode() {
        if (isAirplaneModeOn()) {
            return 1;
        }
        return 0;
    }

    private boolean isAirplaneModeOn() {
        Context context = this.mContext;
        return (context == null || context.getContentResolver() == null || Settings.System.getInt(this.mContext.getContentResolver(), "airplane_mode_on", 0) == 0) ? false : true;
    }

    public Integer isHeadsetOn() {
        AudioManager audioManager;
        AudioDeviceInfo[] devices;
        if (!hasPermission("android.permission.READ_PHONE_STATE") || (audioManager = (AudioManager) this.mContext.getSystemService("audio")) == null || (devices = audioManager.getDevices(2)) == null) {
            return null;
        }
        for (AudioDeviceInfo audioDeviceInfo : devices) {
            if (audioDeviceInfo.getType() == 3 || audioDeviceInfo.getType() == 4) {
                return 1;
            }
        }
        return 0;
    }
}
