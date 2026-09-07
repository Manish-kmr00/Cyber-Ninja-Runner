package com.moloco.sdk.internal.services;

import kotlin.Deprecated;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes10.dex */
public interface i0 {
    long a();

    @Deprecated(message = "Use currentTime() instead", replaceWith = @ReplaceWith(expression = "currentTime()", imports = {}))
    long invoke();
}
