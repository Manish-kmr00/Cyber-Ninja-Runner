package com.digitalturbine.ignite.authenticator.events;

import com.json.mediationsdk.utils.IronSourceConstants;

/* JADX INFO: loaded from: classes13.dex */
public enum d {
    ENCRYPTION_EXCEPTION(1100),
    RAW_ONE_DT_ERROR(1101),
    ONE_DT_PARSE_ERROR(IronSourceConstants.RV_API_HAS_AVAILABILITY_FALSE),
    ONE_DT_AUTHENTICATION_ERROR(1103),
    ONE_DT_BROADCAST_ERROR(IronSourceConstants.RV_CHECK_PLACEMENT_CAPPED),
    ONE_DT_REQUEST_ERROR(1105),
    ONE_DT_GENERAL_ERROR(1106);

    int mVal;

    d(int i) {
        this.mVal = i;
    }

    public final int a() {
        return this.mVal;
    }
}
