package com.ogury.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OguryError.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/ogury/core/OguryError;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "code", "", "message", "", "<init>", "(ILjava/lang/String;)V", "getCode", "()I", "sdk-core_prodRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class OguryError extends Exception {
    private final int code;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OguryError(int i, String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }
}
