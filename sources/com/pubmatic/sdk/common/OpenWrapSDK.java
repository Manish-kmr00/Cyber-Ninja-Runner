package com.pubmatic.sdk.common;

import android.content.Context;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.models.POBApplicationInfo;
import com.pubmatic.sdk.common.models.POBDSAComplianceStatus;
import com.pubmatic.sdk.common.models.POBExternalUserId;
import com.pubmatic.sdk.common.models.POBLocation;
import com.pubmatic.sdk.common.models.POBUserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class OpenWrapSDK {
    public static final String KEY_SELECTED_REWARD = "selected_reward";

    public enum LogLevel {
        All(0),
        Verbose(1),
        Debug(2),
        Info(3),
        Warn(4),
        Error(5),
        Off(6);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f7544a;

        LogLevel(int i) {
            this.f7544a = i;
        }

        public int getLevel() {
            return this.f7544a;
        }
    }

    public static void addExternalUserId(POBExternalUserId pOBExternalUserId) {
        POBInstanceProvider.getSdkConfig().addExternalUserId(pOBExternalUserId);
    }

    public static void allowAdvertisingId(boolean z) {
        POBInstanceProvider.getSdkConfig().allowAdvertisingId(z);
    }

    public static void allowLocationAccess(boolean z) {
        POBInstanceProvider.getSdkConfig().allowLocationAccess(z);
    }

    public static POBApplicationInfo getApplicationInfo() {
        return POBInstanceProvider.getSdkConfig().getApplicationInfo();
    }

    public static POBDSAComplianceStatus getDSAComplianceStatus() {
        return POBInstanceProvider.getSdkConfig().getDsaComplianceStatus();
    }

    public static List<POBExternalUserId> getExternalUserIds() {
        Map<String, List<POBExternalUserId>> externalUserIds = POBInstanceProvider.getSdkConfig().getExternalUserIds();
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, List<POBExternalUserId>>> it = externalUserIds.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getValue());
        }
        return arrayList;
    }

    public static POBUserInfo getUserInfo() {
        return POBInstanceProvider.getSdkConfig().getUserInfo();
    }

    public static String getVersion() {
        return "4.5.1";
    }

    public static void initialize(Context context, OpenWrapSDKConfig openWrapSDKConfig, OpenWrapSDKInitializer.Listener listener) {
        OpenWrapSDKInitializerImpl.INSTANCE.initialize(context, openWrapSDKConfig, listener);
    }

    public static void removeAllExternalUserIds() {
        POBInstanceProvider.getSdkConfig().removeAllExternalUserIds();
    }

    public static void removeExternalUserIds(String str) {
        POBInstanceProvider.getSdkConfig().removeExternalUserIds(str);
    }

    public static void setApplicationInfo(POBApplicationInfo pOBApplicationInfo) {
        POBInstanceProvider.getSdkConfig().setApplicationInfo(pOBApplicationInfo);
    }

    public static void setCoppa(boolean z) {
        POBInstanceProvider.getSdkConfig().setCoppa(z);
    }

    public static void setDSAComplianceStatus(POBDSAComplianceStatus pOBDSAComplianceStatus) {
        POBInstanceProvider.getSdkConfig().setDSAComplianceStatus(pOBDSAComplianceStatus);
    }

    public static void setLocation(POBLocation pOBLocation) {
        POBInstanceProvider.getSdkConfig().setLocation(pOBLocation);
    }

    public static void setLogLevel(LogLevel logLevel) {
        POBLog.setLogLevel(logLevel);
    }

    public static void setSSLEnabled(boolean z) {
        POBInstanceProvider.getSdkConfig().setRequestSecureCreative(z);
    }

    public static void setUseInternalBrowser(boolean z) {
        POBInstanceProvider.getSdkConfig().setUseInternalBrowser(z);
    }

    public static void setUserInfo(POBUserInfo pOBUserInfo) {
        POBInstanceProvider.getSdkConfig().setUserInfo(pOBUserInfo);
    }
}
