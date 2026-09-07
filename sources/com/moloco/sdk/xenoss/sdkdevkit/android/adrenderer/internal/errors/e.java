package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6553a;

        static {
            int[] iArr = new int[d.values().length];
            try {
                iArr[d.MRAID_WEBVIEW_CLIENT_UNRECOVERABLE_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[d.MRAID_WEBVIEW_CLIENT_RENDER_PROCESS_GONE_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[d.MRAID_WEBVIEW_LOAD_DATA_WITH_BASE_URL_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[d.MRAID_WEBVIEW_PAGE_DIDNT_LOAD_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[d.MRAID_WEBVIEW_INTERNAL_TIMEOUT_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[d.MRAID_FULLSCREEN_WEBVIEW_CLIENT_UNRECOVERABLE_ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[d.MRAID_FULLSCREEN_WEBVIEW_CLIENT_RENDER_PROCESS_GONE_ERROR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[d.MRAID_FULLSCREEN_WEBVIEW_LOAD_DATA_WITH_BASE_URL_ERROR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[d.MRAID_FULLSCREEN_WEBVIEW_PAGE_DIDNT_LOAD_ERROR.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[d.MRAID_FULLSCREEN_AD_ACTIVITY_SHOW_FAILED_ERROR.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[d.MRAID_BANNER_WEBVIEW_CLIENT_UNRECOVERABLE_ERROR.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[d.MRAID_BANNER_WEBVIEW_CLIENT_RENDER_PROCESS_GONE_ERROR.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[d.MRAID_BANNER_WEBVIEW_LOAD_DATA_WITH_BASE_URL_ERROR.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[d.MRAID_BANNER_WEBVIEW_PAGE_DIDNT_LOAD_ERROR.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            f6553a = iArr;
        }
    }

    public static final d a(d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        switch (a.f6553a[dVar.ordinal()]) {
            case 1:
                return d.MRAID_BANNER_WEBVIEW_CLIENT_UNRECOVERABLE_ERROR;
            case 2:
                return d.MRAID_BANNER_WEBVIEW_CLIENT_RENDER_PROCESS_GONE_ERROR;
            case 3:
                return d.MRAID_BANNER_WEBVIEW_LOAD_DATA_WITH_BASE_URL_ERROR;
            case 4:
                return d.MRAID_BANNER_WEBVIEW_PAGE_DIDNT_LOAD_ERROR;
            case 5:
                return d.MRAID_WEBVIEW_INTERNAL_TIMEOUT_ERROR;
            case 6:
                return d.MRAID_BANNER_WEBVIEW_CLIENT_UNRECOVERABLE_ERROR;
            case 7:
                return d.MRAID_BANNER_WEBVIEW_CLIENT_RENDER_PROCESS_GONE_ERROR;
            case 8:
                return d.MRAID_BANNER_WEBVIEW_LOAD_DATA_WITH_BASE_URL_ERROR;
            case 9:
                return d.MRAID_BANNER_WEBVIEW_PAGE_DIDNT_LOAD_ERROR;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                return dVar;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final d b(d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        switch (a.f6553a[dVar.ordinal()]) {
            case 1:
                return d.MRAID_FULLSCREEN_WEBVIEW_CLIENT_UNRECOVERABLE_ERROR;
            case 2:
                return d.MRAID_FULLSCREEN_WEBVIEW_CLIENT_RENDER_PROCESS_GONE_ERROR;
            case 3:
                return d.MRAID_FULLSCREEN_WEBVIEW_LOAD_DATA_WITH_BASE_URL_ERROR;
            case 4:
                return d.MRAID_FULLSCREEN_WEBVIEW_PAGE_DIDNT_LOAD_ERROR;
            case 5:
                return d.MRAID_WEBVIEW_INTERNAL_TIMEOUT_ERROR;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return dVar;
            case 11:
                return d.MRAID_FULLSCREEN_WEBVIEW_CLIENT_UNRECOVERABLE_ERROR;
            case 12:
                return d.MRAID_FULLSCREEN_WEBVIEW_CLIENT_RENDER_PROCESS_GONE_ERROR;
            case 13:
                return d.MRAID_FULLSCREEN_WEBVIEW_LOAD_DATA_WITH_BASE_URL_ERROR;
            case 14:
                return d.MRAID_FULLSCREEN_WEBVIEW_PAGE_DIDNT_LOAD_ERROR;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
