package com.pubmatic.sdk.common.models;

import android.content.Context;
import android.location.Address;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.pubmatic.sdk.common.POBInstanceProvider;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.utility.POBAdvertisingIdClient;
import com.pubmatic.sdk.common.utility.POBLocationDetector;
import com.pubmatic.sdk.common.utility.POBUtils;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes5.dex */
public class POBDeviceInfo {
    private int b;
    private String c;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private final Context o;
    private float p;
    private String q;
    private String r;
    private String s;
    public int screenHeight;
    public int screenWidth;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7580a = "POBDeviceInfo";
    private String d = null;
    private Boolean e = null;

    public enum DEVICE_ID_TYPE {
        ANDROID_ID("3"),
        ADVERTISING_ID("9");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f7581a;

        DEVICE_ID_TYPE(String str) {
            this.f7581a = str;
        }

        public String getValue() {
            return this.f7581a;
        }
    }

    public POBDeviceInfo(Context context) {
        this.f = null;
        this.m = null;
        this.o = context;
        updateAdvertisingIdInfo();
        this.c = a(context);
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            try {
                if (telephonyManager.getPhoneType() != 2) {
                    String networkOperator = telephonyManager.getNetworkOperator();
                    if (!TextUtils.isEmpty(networkOperator)) {
                        this.q = "" + Integer.parseInt(networkOperator.substring(0, 3)) + "-" + Integer.parseInt(networkOperator.substring(3));
                    }
                    String networkCountryIso = telephonyManager.getNetworkCountryIso();
                    this.r = networkCountryIso != null ? networkCountryIso.toUpperCase(Locale.ENGLISH) : null;
                }
                a();
                this.f = telephonyManager.getNetworkOperatorName();
            } catch (Exception e) {
                POBLog.warn("POBDeviceInfo", "Unable to fetch carrier name from TelephonyManager or ISO3 or ISO2 country code. Error: %s", e.getMessage());
            }
        }
        this.g = Locale.getDefault().getLanguage();
        this.h = Build.MANUFACTURER;
        this.i = Build.MODEL;
        this.j = Build.DEVICE;
        this.k = "Android";
        this.l = Build.VERSION.RELEASE;
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                this.screenWidth = displayMetrics.widthPixels;
                this.screenHeight = displayMetrics.heightPixels;
                this.m = displayMetrics.widthPixels + VastAttributes.HORIZONTAL_POSITION + displayMetrics.heightPixels;
            }
        } catch (Exception e2) {
            POBLog.warn("POBDeviceInfo", "Unable to fetch screen resolution. Error: %s", e2.getMessage());
        }
        this.n = new SimpleDateFormat("ZZZZZ", Locale.getDefault()).format(Calendar.getInstance(TimeZone.getTimeZone("GMT"), Locale.getDefault()).getTime());
        this.p = this.o.getResources().getDisplayMetrics().density;
        this.b = POBUtils.getTimeOffsetInMinutes();
    }

    private String a(Context context) {
        String string;
        try {
            string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
            POBLog.warn("POBDeviceInfo", "Unable to fetch Device ID. Error: %s", e.getMessage());
            string = null;
        }
        return string == null ? "" : string;
    }

    public String getAcceptLanguage() {
        return this.g;
    }

    public String getAdvertisingID() {
        return this.d;
    }

    public String getAndroidId() {
        return this.c;
    }

    public DEVICE_ID_TYPE getAndroidIdType(boolean z) {
        return z ? DEVICE_ID_TYPE.ADVERTISING_ID : DEVICE_ID_TYPE.ANDROID_ID;
    }

    public String getCarrierName() {
        return this.f;
    }

    public String getCurrentTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(Calendar.getInstance().getTime());
    }

    public String getCurrentTimeZone() {
        return this.n;
    }

    public String getHardwareVersion() {
        return this.j;
    }

    public String getISOAlpha2CountryCode() {
        return this.r;
    }

    public String getISOAlpha3CountryCode() {
        return this.s;
    }

    public Boolean getLmtEnabled() {
        return this.e;
    }

    public String getMake() {
        return this.h;
    }

    public String getMccmnc() {
        return this.q;
    }

    public String getModel() {
        return this.i;
    }

    public int getOrientation() {
        return this.o.getResources().getConfiguration().orientation;
    }

    public String getOsName() {
        return this.k;
    }

    public String getOsVersion() {
        return this.l;
    }

    public float getPxratio() {
        return this.p;
    }

    public int getScreenHeight() {
        return this.screenHeight;
    }

    public String getScreenResolution() {
        return this.m;
    }

    public int getScreenWidth() {
        return this.screenWidth;
    }

    public int getTimeZoneOffsetInMinutes() {
        return this.b;
    }

    public String getUserAgent() {
        return POBInstanceProvider.getCacheManager(this.o).fetchUserAgent();
    }

    public void updateAdvertisingIdInfo() {
        POBAdvertisingIdClient pOBAdvertisingIdClient = POBAdvertisingIdClient.getInstance(this.o);
        pOBAdvertisingIdClient.updateAAID();
        String storedAdvertisingId = pOBAdvertisingIdClient.getStoredAdvertisingId();
        this.d = storedAdvertisingId;
        if (storedAdvertisingId != null) {
            this.e = Boolean.valueOf(pOBAdvertisingIdClient.getStoredLMTState());
        }
    }

    private void a() {
        Address address;
        String str = this.r;
        if (str != null) {
            this.s = a(str);
        }
        if (!TextUtils.isEmpty(this.s) || (address = new POBLocationDetector(this.o).getAddress()) == null) {
            return;
        }
        String countryCode = address.getCountryCode();
        if (TextUtils.isEmpty(countryCode)) {
            return;
        }
        this.s = a(countryCode);
    }

    private String a(String str) {
        try {
            return new Locale(Locale.ENGLISH.getLanguage(), str).getISO3Country();
        } catch (MissingResourceException unused) {
            POBLog.warn("POBDeviceInfo", "Unable to get ISO 3 country code from ISO2 for input value as %s", str);
            return null;
        }
    }
}
