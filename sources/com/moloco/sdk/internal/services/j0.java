package com.moloco.sdk.internal.services;

import kotlin.Deprecated;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes11.dex */
public final class j0 implements i0 {
    @Override // com.moloco.sdk.internal.services.i0
    public long a() {
        return System.currentTimeMillis();
    }

    @Override // com.moloco.sdk.internal.services.i0
    @Deprecated(message = "Use currentTime() instead", replaceWith = @ReplaceWith(expression = "currentTime()", imports = {}))
    public long invoke() {
        return System.currentTimeMillis();
    }
}
