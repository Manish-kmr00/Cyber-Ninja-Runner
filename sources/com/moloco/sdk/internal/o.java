package com.moloco.sdk.internal;

/* JADX INFO: loaded from: classes12.dex */
public enum o implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c {
    AD_LOAD_LIMIT_REACHED,
    BID_LOAD_ERROR_CANNOT_PROCESS_BID_RESPONSE,
    BID_LOAD_ERROR_CANNOT_PARSE_BID_RESPONSE,
    AD_SHOW_ERROR_NOT_LOADED,
    AD_SHOW_ERROR_ALREADY_DISPLAYING;

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c
    public String a() {
        return name();
    }
}
