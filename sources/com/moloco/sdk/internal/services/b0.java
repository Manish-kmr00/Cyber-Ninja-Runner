package com.moloco.sdk.internal.services;

import kotlin.Deprecated;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes10.dex */
public interface b0 {
    boolean a();

    Integer b();

    a0 c();

    Integer d();

    @Deprecated(message = "Use networkInfo()", replaceWith = @ReplaceWith(expression = "networkInfo()", imports = {}))
    a0 invoke();
}
