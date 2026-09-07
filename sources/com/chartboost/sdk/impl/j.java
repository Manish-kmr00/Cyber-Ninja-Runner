package com.chartboost.sdk.impl;

import com.chartboost.sdk.events.CacheError;
import com.chartboost.sdk.events.ClickError;
import com.chartboost.sdk.events.ShowError;
import com.chartboost.sdk.internal.Model.CBError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u0005¢\u0006\u0004\b\u0003\u0010\u0007\u001a\u001d\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0003\u0010\f¨\u0006\r"}, d2 = {"Lcom/chartboost/sdk/internal/Model/CBError$d;", "error", "Lcom/chartboost/sdk/events/CacheError;", "a", "(Lcom/chartboost/sdk/internal/Model/CBError$d;)Lcom/chartboost/sdk/events/CacheError;", "Lcom/chartboost/sdk/internal/Model/CBError$b;", "Lcom/chartboost/sdk/events/ShowError;", "(Lcom/chartboost/sdk/internal/Model/CBError$b;)Lcom/chartboost/sdk/events/ShowError;", "Lcom/chartboost/sdk/internal/Model/CBError$a;", "", "errorMsg", "Lcom/chartboost/sdk/events/ClickError;", "(Lcom/chartboost/sdk/internal/Model/CBError$a;Ljava/lang/String;)Lcom/chartboost/sdk/events/ClickError;", "ChartboostMonetization-9.8.3_productionRelease"}, k = 2, mv = {1, 8, 0})
public final class j {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1047a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[CBError.b.values().length];
            try {
                iArr[CBError.b.INTERNET_UNAVAILABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CBError.b.NO_AD_FOUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CBError.b.SESSION_NOT_STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CBError.b.IMPRESSION_ALREADY_VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[CBError.b.NO_HOST_ACTIVITY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[CBError.b.USER_CANCELLATION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[CBError.b.VIDEO_UNAVAILABLE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[CBError.b.VIDEO_ID_MISSING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[CBError.b.ERROR_PLAYING_VIDEO.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[CBError.b.ERROR_CREATING_VIEW.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[CBError.b.ERROR_DISPLAYING_VIEW.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[CBError.b.ERROR_LOADING_WEB_VIEW.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[CBError.b.PENDING_IMPRESSION_ERROR.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[CBError.b.WEB_VIEW_PAGE_LOAD_TIMEOUT.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[CBError.b.WEB_VIEW_CLIENT_RECEIVED_ERROR.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[CBError.b.INTERNET_UNAVAILABLE_AT_SHOW.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            f1047a = iArr;
            int[] iArr2 = new int[CBError.a.values().length];
            try {
                iArr2[CBError.a.URI_INVALID.ordinal()] = 1;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr2[CBError.a.URI_UNRECOGNIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused18) {
            }
            b = iArr2;
        }
    }

    public static final ClickError a(CBError.a error, String errorMsg) {
        ClickError.Code code;
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        int i = a.b[error.ordinal()];
        if (i != 1) {
            code = i != 2 ? ClickError.Code.INTERNAL : ClickError.Code.URI_UNRECOGNIZED;
        } else {
            code = ClickError.Code.URI_INVALID;
        }
        return new ClickError(code, new Exception(errorMsg));
    }

    public static final CacheError a(CBError.d error) {
        CacheError.Code code;
        Intrinsics.checkNotNullParameter(error, "error");
        if (error == CBError.b.INTERNET_UNAVAILABLE) {
            code = CacheError.Code.INTERNET_UNAVAILABLE;
        } else if (error == CBError.b.TOO_MANY_CONNECTIONS || error == CBError.b.NETWORK_FAILURE) {
            code = CacheError.Code.NETWORK_FAILURE;
        } else if (error == CBError.b.NO_AD_FOUND) {
            code = CacheError.Code.NO_AD_FOUND;
        } else if (error == CBError.b.SESSION_NOT_STARTED) {
            code = CacheError.Code.SESSION_NOT_STARTED;
        } else if (error == CBError.b.INVALID_RESPONSE) {
            code = CacheError.Code.SERVER_ERROR;
        } else if (error == CBError.b.ASSETS_DOWNLOAD_FAILURE || error == CBError.b.ASSET_PREFETCH_IN_PROGRESS || error == CBError.b.ASSET_MISSING) {
            code = CacheError.Code.ASSET_DOWNLOAD_FAILURE;
        } else {
            code = error == CBError.b.INTERNET_UNAVAILABLE_AT_CACHE ? CacheError.Code.INTERNET_UNAVAILABLE : CacheError.Code.INTERNAL;
        }
        return new CacheError(code, null, 2, null);
    }

    public static final ShowError a(CBError.b error) {
        ShowError.Code code;
        Intrinsics.checkNotNullParameter(error, "error");
        switch (a.f1047a[error.ordinal()]) {
            case 1:
                code = ShowError.Code.INTERNET_UNAVAILABLE;
                break;
            case 2:
                code = ShowError.Code.NO_CACHED_AD;
                break;
            case 3:
                code = ShowError.Code.SESSION_NOT_STARTED;
                break;
            case 4:
                code = ShowError.Code.AD_ALREADY_VISIBLE;
                break;
            case 5:
                code = ShowError.Code.PRESENTATION_FAILURE;
                break;
            case 6:
                code = ShowError.Code.PRESENTATION_FAILURE;
                break;
            case 7:
                code = ShowError.Code.PRESENTATION_FAILURE;
                break;
            case 8:
                code = ShowError.Code.PRESENTATION_FAILURE;
                break;
            case 9:
                code = ShowError.Code.PRESENTATION_FAILURE;
                break;
            case 10:
                code = ShowError.Code.PRESENTATION_FAILURE;
                break;
            case 11:
                code = ShowError.Code.PRESENTATION_FAILURE;
                break;
            case 12:
                code = ShowError.Code.PRESENTATION_FAILURE;
                break;
            case 13:
                code = ShowError.Code.PRESENTATION_FAILURE;
                break;
            case 14:
                code = ShowError.Code.PRESENTATION_FAILURE;
                break;
            case 15:
                code = ShowError.Code.PRESENTATION_FAILURE;
                break;
            case 16:
                code = ShowError.Code.INTERNET_UNAVAILABLE;
                break;
            default:
                code = ShowError.Code.INTERNAL;
                break;
        }
        return new ShowError(code, null, 2, null);
    }
}
