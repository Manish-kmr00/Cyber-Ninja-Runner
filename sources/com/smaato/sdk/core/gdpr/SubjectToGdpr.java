package com.smaato.sdk.core.gdpr;

import com.smaato.sdk.core.util.Objects;

/* JADX INFO: loaded from: classes13.dex */
public enum SubjectToGdpr {
    CMP_GDPR_ENABLED("1"),
    CMP_GDPR_DISABLED("0"),
    CMP_GDPR_UNKNOWN("-1");

    public final String id;

    SubjectToGdpr(String str) {
        this.id = (String) Objects.requireNonNull(str);
    }

    public static SubjectToGdpr getValueForString(String str) {
        for (int i = 0; i < values().length; i++) {
            SubjectToGdpr subjectToGdpr = values()[i];
            if (subjectToGdpr.id.equals(str)) {
                return subjectToGdpr;
            }
        }
        return null;
    }

    public String getId() {
        return this.id;
    }
}
