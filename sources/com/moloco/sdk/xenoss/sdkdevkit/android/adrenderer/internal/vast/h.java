package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class h {
    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a.AbstractC0600a mediaResult) {
        Intrinsics.checkNotNullParameter(mediaResult, "mediaResult");
        if (Intrinsics.areEqual(mediaResult, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a.AbstractC0600a.p.c)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_TMP_FILE_NOT_RENAMED_DISK_ERROR;
        }
        if (Intrinsics.areEqual(mediaResult, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a.AbstractC0600a.C0601a.c)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_NOT_CREATED_DISK_ERROR;
        }
        if (Intrinsics.areEqual(mediaResult, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a.AbstractC0600a.b.c)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_NOT_CREATED_IO_DISK_ERROR;
        }
        if (Intrinsics.areEqual(mediaResult, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a.AbstractC0600a.c.c)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_NOT_CREATED_SECURITY_DISK_ERROR;
        }
        if (Intrinsics.areEqual(mediaResult, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a.AbstractC0600a.d.c)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_NOT_CREATED_UNKNOWN_DISK_ERROR;
        }
        if (Intrinsics.areEqual(mediaResult, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a.AbstractC0600a.f.c)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_HTTP_DISK_IO_ERROR;
        }
        if (Intrinsics.areEqual(mediaResult, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a.AbstractC0600a.g.c)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_HTTP_DISK_SECURITY_ERROR;
        }
        if (Intrinsics.areEqual(mediaResult, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a.AbstractC0600a.r.c)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_UNKNOWN_MEDIA_FETCH_ERROR;
        }
        if (Intrinsics.areEqual(mediaResult, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a.AbstractC0600a.e.c)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_CLIENT_HTTP_ERROR;
        }
        if (Intrinsics.areEqual(mediaResult, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a.AbstractC0600a.h.c)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_SERVER_HTTP_ERROR;
        }
        if (Intrinsics.areEqual(mediaResult, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a.AbstractC0600a.n.c)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_NO_NETWORK_HTTP_ERROR;
        }
        if (Intrinsics.areEqual(mediaResult, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a.AbstractC0600a.k.c)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_INVALID_URL_ERROR;
        }
        if (Intrinsics.areEqual(mediaResult, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a.AbstractC0600a.o.c)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_NOT_FOUND_ERROR;
        }
        if (Intrinsics.areEqual(mediaResult, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a.AbstractC0600a.q.c)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_UNKNOWN_HOST_HTTP_ERROR;
        }
        if (Intrinsics.areEqual(mediaResult, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a.AbstractC0600a.C0602i.c)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_SOCKET_HTTP_ERROR;
        }
        if (Intrinsics.areEqual(mediaResult, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a.AbstractC0600a.j.c)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_HTTP_SSL_ERROR;
        }
        if (Intrinsics.areEqual(mediaResult, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a.AbstractC0600a.m.c)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_TIMEOUT_ERROR;
        }
        if (Intrinsics.areEqual(mediaResult, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a.AbstractC0600a.l.c)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_NUMBER_PARSE_ERROR;
        }
        throw new NoWhenBranchMatchedException();
    }
}
