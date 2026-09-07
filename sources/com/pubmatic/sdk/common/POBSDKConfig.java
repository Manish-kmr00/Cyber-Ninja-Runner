package com.pubmatic.sdk.common;

import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.models.POBApplicationInfo;
import com.pubmatic.sdk.common.models.POBDSAComplianceStatus;
import com.pubmatic.sdk.common.models.POBExternalUserId;
import com.pubmatic.sdk.common.models.POBLocation;
import com.pubmatic.sdk.common.models.POBUserInfo;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.pubmatic.sdk.omsdk.POBOMSDKUtil;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class POBSDKConfig {
    private Boolean d;
    private POBLocation e;
    private POBUserInfo h;
    private POBApplicationInfo i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f7553a = true;
    private long b = 600000;
    private boolean c = false;
    private boolean f = true;
    private boolean g = true;
    private POBDSAComplianceStatus k = POBDSAComplianceStatus.NOT_REQUIRED;
    private final Map j = Collections.synchronizedMap(new HashMap());

    POBSDKConfig() {
    }

    public void addExternalUserId(POBExternalUserId pOBExternalUserId) {
        if (pOBExternalUserId == null || POBUtils.isNullOrEmpty(pOBExternalUserId.getId()) || POBUtils.isNullOrEmpty(pOBExternalUserId.getSource())) {
            POBLog.warn("POBSDKConfig", POBCommonConstants.MSG_INVALID_DATA, "External User Id");
            return;
        }
        String source = pOBExternalUserId.getSource();
        if (!this.j.containsKey(source)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(pOBExternalUserId);
            this.j.put(source, arrayList);
            return;
        }
        List<POBExternalUserId> list = (List) this.j.get(source);
        if (list != null) {
            for (POBExternalUserId pOBExternalUserId2 : list) {
                if (pOBExternalUserId2 != null && pOBExternalUserId2.getId().equals(pOBExternalUserId.getId())) {
                    POBLog.warn("POBSDKConfig", POBCommonConstants.MSG_DUPLICATE_FIELD, "External User Id", "partner Id");
                    return;
                }
            }
            list.add(pOBExternalUserId);
            this.j.put(source, list);
        }
    }

    public void allowAdvertisingId(boolean z) {
        this.g = z;
    }

    public void allowLocationAccess(boolean z) {
        this.f7553a = z;
    }

    public POBApplicationInfo getApplicationInfo() {
        return this.i;
    }

    public POBDSAComplianceStatus getDsaComplianceStatus() {
        return this.k;
    }

    public Map<String, List<POBExternalUserId>> getExternalUserIds() {
        return this.j;
    }

    public POBLocation getLocation() {
        return this.e;
    }

    public long getLocationDetectionDurationInMillis() {
        return this.b;
    }

    public <T> T getMeasurementProvider(String str) {
        try {
            return (T) Class.forName(str).getConstructor(null).newInstance(null);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            POBLog.error(POBOMSDKUtil.TAG, "%s", e.getMessage());
            return null;
        }
    }

    public POBUserInfo getUserInfo() {
        return this.h;
    }

    public boolean isAllowAdvertisingId() {
        return this.g;
    }

    public Boolean isCoppa() {
        return this.d;
    }

    public boolean isLocationAccessAllowed() {
        return this.f7553a;
    }

    public boolean isRequestSecureCreative() {
        return this.f;
    }

    public boolean isUseInternalBrowser() {
        return this.c;
    }

    public void removeAllExternalUserIds() {
        this.j.clear();
    }

    public void removeExternalUserIds(String str) {
        if (str != null) {
            this.j.remove(str);
        }
    }

    public void setApplicationInfo(POBApplicationInfo pOBApplicationInfo) {
        this.i = pOBApplicationInfo;
    }

    public void setCoppa(boolean z) {
        this.d = Boolean.valueOf(z);
    }

    public void setDSAComplianceStatus(POBDSAComplianceStatus pOBDSAComplianceStatus) {
        if (pOBDSAComplianceStatus != null) {
            this.k = pOBDSAComplianceStatus;
        } else {
            POBLog.warn("POBSDKConfig", POBCommonConstants.MSG_INVALID_DATA, "DSA Transparency Info");
        }
    }

    public void setLocation(POBLocation pOBLocation) {
        this.e = pOBLocation;
    }

    public void setLocationDetectionDurationInMillis(long j) {
        this.b = j;
    }

    public void setRequestSecureCreative(boolean z) {
        this.f = z;
    }

    public void setUseInternalBrowser(boolean z) {
        this.c = z;
    }

    public void setUserInfo(POBUserInfo pOBUserInfo) {
        this.h = pOBUserInfo;
    }
}
