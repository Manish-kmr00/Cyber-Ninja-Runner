package com.smaato.sdk.core.ub;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public abstract class UbId {

    public static abstract class Builder {
        public abstract Builder adSpaceId(String str);

        public abstract UbId build();

        public abstract Builder sessionId(String str);
    }

    public abstract String adSpaceId();

    public abstract String sessionId();

    UbId() {
    }

    public static UbId create(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String[] strArrSplit = str2.split(":");
        if (strArrSplit.length != 2) {
            return null;
        }
        String str3 = strArrSplit[0];
        String str4 = strArrSplit[1];
        if (!TextUtils.isEmpty(str4) && str.equalsIgnoreCase(str3)) {
            return builder().adSpaceId(str).sessionId(str4).build();
        }
        return null;
    }

    public static Builder builder() {
        return new AutoValue_UbId.Builder();
    }

    public String toString() {
        return adSpaceId() + ":" + sessionId();
    }
}
