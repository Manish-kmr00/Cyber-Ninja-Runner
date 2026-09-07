package com.smaato.sdk.core.datacollector;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.json.b9;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.network.NetworkStateMonitor;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.TextUtils;
import com.smaato.sdk.core.util.fi.Function;
import com.smaato.sdk.core.util.reflection.Reflections;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.Locale;

/* JADX INFO: loaded from: classes7.dex */
class SystemInfoProvider {
    private final Context context;
    private GoogleAdvertisingClientInfo googleAdvertisingClientInfo;
    private final Logger logger;
    private final NetworkStateMonitor networkStateMonitor;
    private final TelephonyManager telephonyManager;
    private final UserAgentProvider userAgentProvider;

    SystemInfoProvider(Logger logger, Context context, NetworkStateMonitor networkStateMonitor, TelephonyManager telephonyManager, UserAgentProvider userAgentProvider) {
        this.logger = (Logger) Objects.requireNonNull(logger, "Parameter logger cannot be null for SystemInfoProvider::new");
        this.context = (Context) Objects.requireNonNull(context, "Parameter context cannot be null for SystemInfoProvider::new");
        this.networkStateMonitor = (NetworkStateMonitor) Objects.requireNonNull(networkStateMonitor, "Parameter networkStateMonitor cannot be null for SystemInfoProvider::new");
        this.telephonyManager = (TelephonyManager) Objects.requireNonNull(telephonyManager, "Parameter telephonyManager cannot be null for SystemInfoProvider::new");
        this.userAgentProvider = (UserAgentProvider) Objects.requireNonNull(userAgentProvider, "Parameter userAgentProvider cannot be null for SystemInfoProvider::new");
    }

    public SystemInfo getSystemInfoSnapshot() {
        String simOperatorName = this.telephonyManager.getSimOperatorName();
        String simOperator = this.telephonyManager.getSimOperator();
        GoogleAdvertisingClientInfo googleAdvertisingClientInfo = this.googleAdvertisingClientInfo;
        if (googleAdvertisingClientInfo == null && isAdMobAvailable()) {
            googleAdvertisingClientInfo = getGoogleAdvertisingClientInfo();
            this.googleAdvertisingClientInfo = googleAdvertisingClientInfo;
        }
        String str = (String) Objects.transformOrNull(googleAdvertisingClientInfo, new Function() { // from class: com.smaato.sdk.core.datacollector.SystemInfoProvider$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Function
            public final Object apply(Object obj) {
                return ((GoogleAdvertisingClientInfo) obj).getAdvertisingId();
            }
        });
        Boolean bool = (Boolean) Objects.transformOrNull(googleAdvertisingClientInfo, new Function() { // from class: com.smaato.sdk.core.datacollector.SystemInfoProvider$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Function
            public final Object apply(Object obj) {
                return Boolean.valueOf(((GoogleAdvertisingClientInfo) obj).isLimitAdTrackingEnabled());
            }
        });
        String str2 = Build.MODEL;
        if (str2 == null) {
            str2 = b9.i.l;
        }
        return new SystemInfo(simOperatorName, simOperator, getGoogleAdvertisingIdOrAndroidId(str), bool, str2, this.networkStateMonitor.getNetworkConnectionType(), this.userAgentProvider.get(), this.context.getPackageName(), getLanguage());
    }

    private String getGoogleAdvertisingIdOrAndroidId(String str) {
        if (str == null) {
            try {
                if ("Amazon".equals(BuildManufacturerProvider.getBuildManufacturer())) {
                    return getAdIdIfManufacturerIsAmazon();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    private GoogleAdvertisingClientInfo getGoogleAdvertisingClientInfo() {
        return new GoogleAdvertisingClientInfo(this.logger, this.context);
    }

    private boolean isAdMobAvailable() {
        return Reflections.isClassInClasspath("com.google.android.gms.ads.identifier.AdvertisingIdClient");
    }

    private String getLanguage() {
        Locale locale;
        if (this.context.getResources() != null) {
            locale = this.context.getResources().getConfiguration().getLocales().get(0);
        } else {
            locale = Locale.getDefault();
        }
        String language = locale.getLanguage();
        return !TextUtils.isEmpty(language) ? language : Locale.getDefault().getLanguage();
    }

    private String getAdIdIfManufacturerIsAmazon() {
        if ("Amazon".equals(BuildManufacturerProvider.getBuildManufacturer())) {
            ContentResolver contentResolver = this.context.getContentResolver();
            if (Settings.Secure.getInt(contentResolver, CommonUrlParts.LIMIT_AD_TRACKING, 2) == 0) {
                return Settings.Secure.getString(contentResolver, "advertising_id");
            }
        }
        return null;
    }
}
