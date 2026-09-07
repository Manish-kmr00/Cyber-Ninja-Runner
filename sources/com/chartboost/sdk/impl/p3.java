package com.chartboost.sdk.impl;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\u0005\u001a\u0004\u0018\u00010\t*\u0004\u0018\u00010\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\u0005\u0010\n\u001a\u0013\u0010\f\u001a\u00020\u000b*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0013\u0010\u000e\u001a\u00020\u000b*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u000e\u0010\r\u001a\u0013\u0010\u000f\u001a\u00020\u000b*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u000f\u0010\r\u001a\u0013\u0010\u0011\u001a\u00020\u0010*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0013\u0010\u0014\u001a\u00020\u0013*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001f\u0010\u0005\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0005\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroid/content/Context;", "Landroid/net/ConnectivityManager;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Landroid/content/Context;)Landroid/net/ConnectivityManager;", "Landroid/net/NetworkInfo;", "a", "(Landroid/content/Context;)Landroid/net/NetworkInfo;", "Landroid/net/Network;", "network", "Landroid/net/NetworkCapabilities;", "(Landroid/content/Context;Landroid/net/Network;)Landroid/net/NetworkCapabilities;", "", "d", "(Landroid/content/Context;)Z", "e", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "", InneractiveMediationDefs.GENDER_FEMALE, "(Landroid/content/Context;)I", "Lcom/chartboost/sdk/impl/m7;", "g", "(Landroid/content/Context;)Lcom/chartboost/sdk/impl/m7;", "type", "subType", "(II)Lcom/chartboost/sdk/impl/m7;", "ChartboostMonetization-9.8.3_productionRelease"}, k = 2, mv = {1, 8, 0})
public final class p3 {
    public static final ConnectivityManager b(Context context) {
        Object objM7904constructorimpl;
        if (context == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Object systemService = context.getSystemService("connectivity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            objM7904constructorimpl = Result.m7904constructorimpl((ConnectivityManager) systemService);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
        if (thM7907exceptionOrNullimpl != null) {
            b7.a("Cannot retrieve connectivity manager", thM7907exceptionOrNullimpl);
        }
        return (ConnectivityManager) (Result.m7910isFailureimpl(objM7904constructorimpl) ? null : objM7904constructorimpl);
    }

    public static final NetworkInfo a(Context context) {
        ConnectivityManager connectivityManagerB;
        Object objM7904constructorimpl;
        if (context == null || (connectivityManagerB = b(context)) == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(connectivityManagerB.getActiveNetworkInfo());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
        if (thM7907exceptionOrNullimpl != null) {
            b7.a("Cannot retrieve active network info", thM7907exceptionOrNullimpl);
        }
        return (NetworkInfo) (Result.m7910isFailureimpl(objM7904constructorimpl) ? null : objM7904constructorimpl);
    }

    public static final boolean d(Context context) {
        NetworkInfo networkInfoA = a(context);
        NetworkCapabilities networkCapabilitiesA = a(context, null, 1, null);
        if (networkCapabilitiesA != null) {
            return networkCapabilitiesA.hasCapability(16);
        }
        return networkInfoA != null && networkInfoA.isConnected();
    }

    public static final boolean e(Context context) {
        NetworkInfo networkInfoA = a(context);
        return networkInfoA != null && networkInfoA.isConnected() && networkInfoA.getType() == 1;
    }

    public static final boolean c(Context context) {
        NetworkInfo networkInfoA = a(context);
        return networkInfoA != null && networkInfoA.isConnected() && networkInfoA.getType() == 0;
    }

    public static final NetworkCapabilities a(Context context, Network network) {
        ConnectivityManager connectivityManagerB;
        Object objM7904constructorimpl;
        if (context == null || (connectivityManagerB = b(context)) == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            if (network == null) {
                network = connectivityManagerB.getActiveNetwork();
            }
            objM7904constructorimpl = Result.m7904constructorimpl(connectivityManagerB.getNetworkCapabilities(network));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
        if (thM7907exceptionOrNullimpl != null) {
            b7.a("Cannot retrieve network capabilities", thM7907exceptionOrNullimpl);
        }
        return (NetworkCapabilities) (Result.m7910isFailureimpl(objM7904constructorimpl) ? null : objM7904constructorimpl);
    }

    public static final int f(Context context) {
        NetworkInfo networkInfoA = a(context);
        if (networkInfoA == null || !networkInfoA.isConnected()) {
            return 0;
        }
        return networkInfoA.getSubtype();
    }

    public static final m7 g(Context context) {
        m7 m7VarA;
        NetworkInfo networkInfoA = a(context);
        if (networkInfoA != null) {
            if (networkInfoA.isConnected()) {
                m7VarA = a(networkInfoA.getType(), networkInfoA.getSubtype());
            } else {
                m7VarA = m7.UNKNOWN;
            }
            if (m7VarA != null) {
                return m7VarA;
            }
        }
        return m7.UNKNOWN;
    }

    public static /* synthetic */ NetworkCapabilities a(Context context, Network network, int i, Object obj) {
        if ((i & 1) != 0) {
            network = null;
        }
        return a(context, network);
    }

    public static final m7 a(int i, int i2) {
        if (i != 0) {
            if (i != 1) {
                return m7.UNKNOWN;
            }
            return m7.WIFI;
        }
        if (i2 != 20) {
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return m7.CELLULAR_2G;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return m7.CELLULAR_3G;
                case 13:
                    return m7.CELLULAR_4G;
                default:
                    return m7.CELLULAR_UNKNOWN;
            }
        }
        return m7.CELLULAR_5G;
    }
}
