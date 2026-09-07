package com.smaato.sdk.core;

import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;

/* JADX INFO: loaded from: classes13.dex */
public enum Gender {
    FEMALE(InneractiveMediationDefs.GENDER_FEMALE),
    MALE("m"),
    OTHER("o");

    private final String gender;

    Gender(String str) {
        this.gender = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.gender;
    }
}
