package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class h {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6556a;

        static {
            int[] iArr = new int[g.values().length];
            try {
                iArr[g.STATIC_AD_UNKNOWN_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[g.STATIC_AD_WEBVIEW_DATA_WITH_DEFAULT_BASE_URL_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[g.STATIC_AD_WEBVIEW_RECEIVED_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[g.STATIC_AD_WEBVIEW_RENDER_PROCESS_GONE_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f6556a = iArr;
        }
    }

    public static final i a(g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        int i = a.f6556a[gVar.ordinal()];
        if (i == 1) {
            return i.STATIC_BANNER_AD_UNKNOWN_ERROR;
        }
        if (i == 2) {
            return i.STATIC_BANNER_AD_WEBVIEW_DATA_WITH_DEFAULT_BASE_URL_ERROR;
        }
        if (i == 3) {
            return i.STATIC_BANNER_AD_WEBVIEW_RECEIVED_ERROR;
        }
        if (i == 4) {
            return i.STATIC_BANNER_AD_WEBVIEW_RENDER_PROCESS_GONE_ERROR;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final j b(g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        int i = a.f6556a[gVar.ordinal()];
        if (i == 1) {
            return j.STATIC_FULLSCREEN_AD_UNKNOWN_ERROR;
        }
        if (i == 2) {
            return j.STATIC_FULLSCREEN_AD_WEBVIEW_DATA_WITH_DEFAULT_BASE_URL_ERROR;
        }
        if (i == 3) {
            return j.STATIC_FULLSCREEN_AD_WEBVIEW_RECEIVED_ERROR;
        }
        if (i == 4) {
            return j.STATIC_FULLSCREEN_AD_WEBVIEW_RENDER_PROCESS_GONE_ERROR;
        }
        throw new NoWhenBranchMatchedException();
    }
}
