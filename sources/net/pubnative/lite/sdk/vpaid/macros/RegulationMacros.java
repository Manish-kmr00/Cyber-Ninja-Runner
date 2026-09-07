package net.pubnative.lite.sdk.vpaid.macros;

import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import net.pubnative.lite.sdk.DeviceInfo;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.UserDataManager;

/* JADX INFO: loaded from: classes9.dex */
public class RegulationMacros {
    private static final String MACRO_GDPR_CONSENT = "[GDPRCONSENT]";
    private static final String MACRO_LIMIT_AD_TRACKING = "[LIMITADTRACKING]";
    private static final String MACRO_REGULATIONS = "[REGULATIONS]";
    private final DeviceInfo mDeviceInfo;
    private final UserDataManager mUserDataManager;

    public RegulationMacros() {
        this(HyBid.getDeviceInfo(), HyBid.getUserDataManager());
    }

    RegulationMacros(DeviceInfo deviceInfo, UserDataManager userDataManager) {
        this.mDeviceInfo = deviceInfo;
        this.mUserDataManager = userDataManager;
    }

    public String processUrl(String str) {
        return str.replace(MACRO_LIMIT_AD_TRACKING, getLimitAdTracking()).replace(MACRO_REGULATIONS, getRegulations()).replace(MACRO_GDPR_CONSENT, getGdprConsent());
    }

    private String getLimitAdTracking() {
        DeviceInfo deviceInfo = this.mDeviceInfo;
        if (deviceInfo != null) {
            return deviceInfo.limitTracking() ? "1" : "0";
        }
        return String.valueOf(-1);
    }

    private String getRegulations() {
        StringBuilder sb = new StringBuilder();
        UserDataManager userDataManager = this.mUserDataManager;
        if (userDataManager != null) {
            if (userDataManager.gdprApplies() || !TextUtils.isEmpty(this.mUserDataManager.getIABGDPRConsentString())) {
                sb.append("gdpr");
            }
            if (HyBid.isCoppaEnabled()) {
                if (sb.length() > 0) {
                    sb.append(StringUtils.COMMA);
                }
                sb.append("coppa");
            }
        }
        String string = sb.toString();
        return TextUtils.isEmpty(string) ? String.valueOf(-1) : string;
    }

    private String getGdprConsent() {
        UserDataManager userDataManager = this.mUserDataManager;
        if (userDataManager != null && !TextUtils.isEmpty(userDataManager.getIABGDPRConsentString())) {
            return this.mUserDataManager.getIABGDPRConsentString();
        }
        return String.valueOf(-1);
    }
}
