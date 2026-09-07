package com.yandex.div.logging;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Severity.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/yandex/div/logging/Severity;", "", "(Ljava/lang/String;I)V", "isAtLeast", "", "minLevel", "ERROR", "WARNING", "INFO", "DEBUG", "VERBOSE", "logging_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public enum Severity {
    ERROR,
    WARNING,
    INFO,
    DEBUG,
    VERBOSE;

    public final boolean isAtLeast(Severity minLevel) {
        Intrinsics.checkNotNullParameter(minLevel, "minLevel");
        return ordinal() >= minLevel.ordinal();
    }
}
