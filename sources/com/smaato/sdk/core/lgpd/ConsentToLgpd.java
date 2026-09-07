package com.smaato.sdk.core.lgpd;

import com.smaato.sdk.core.util.Objects;

/* JADX INFO: loaded from: classes8.dex */
public enum ConsentToLgpd {
    CONSENT_LGPD_ENABLED("1"),
    CONSENT_LGPD_DISABLED("0"),
    CONSENT_LGPD_UNKNOWN("-1");

    public final String id;

    ConsentToLgpd(String str) {
        this.id = (String) Objects.requireNonNull(str);
    }

    public static ConsentToLgpd getValueForString(String str) {
        for (int i = 0; i < values().length; i++) {
            ConsentToLgpd consentToLgpd = values()[i];
            if (consentToLgpd.id.equals(str)) {
                return consentToLgpd;
            }
        }
        return null;
    }

    public String getId() {
        return this.id;
    }
}
