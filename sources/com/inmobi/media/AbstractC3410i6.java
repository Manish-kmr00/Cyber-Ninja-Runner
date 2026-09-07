package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: renamed from: com.inmobi.media.i6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractC3410i6 {
    public static final EnumC3396h6 a(String logLevel) {
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        if (StringsKt.equals(logLevel, "DEBUG", true)) {
            return EnumC3396h6.DEBUG;
        }
        if (StringsKt.equals(logLevel, "ERROR", true)) {
            return EnumC3396h6.ERROR;
        }
        if (StringsKt.equals(logLevel, "INFO", true)) {
            return EnumC3396h6.INFO;
        }
        return StringsKt.equals(logLevel, "STATE", true) ? EnumC3396h6.STATE : EnumC3396h6.ERROR;
    }
}
