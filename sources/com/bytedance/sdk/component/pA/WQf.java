package com.bytedance.sdk.component.pA;

import io.ktor.client.utils.CacheControl;

/* JADX INFO: loaded from: classes13.dex */
public enum WQf {
    PUBLIC,
    PROTECTED,
    PRIVATE;

    @Override // java.lang.Enum
    public String toString() {
        if (this == PRIVATE) {
            return CacheControl.PRIVATE;
        }
        if (this == PROTECTED) {
            return "protected";
        }
        return "public";
    }
}
