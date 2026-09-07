package com.ogury.ad.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import com.adjust.sdk.Constants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7457a;
    public final e9 b;
    public final DisplayMetrics c;
    public final String d;
    public final String e;

    public z(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        e9 timeUtils = new e9();
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(timeUtils, "timeUtils");
        Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
        this.f7457a = context;
        this.b = timeUtils;
        this.c = displayMetrics;
        String MANUFACTURER = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
        this.d = MANUFACTURER;
        String MODEL = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        this.e = MODEL;
    }

    public final String b() {
        int i = this.f7457a.getResources().getConfiguration().screenLayout & 15;
        if (i == 1) {
            return Constants.SMALL;
        }
        if (i == 2) {
            return Constants.NORMAL;
        }
        if (i != 3) {
            return i != 4 ? "unknown" : Constants.XLARGE;
        }
        return Constants.LARGE;
    }

    public final String c() {
        this.b.getClass();
        return e9.b();
    }

    public final String d() {
        switch (this.f7457a.getResources().getConfiguration().uiMode & 15) {
            case 1:
                return Constants.NORMAL;
            case 2:
                return "desk";
            case 3:
                return "car";
            case 4:
                return "television";
            case 5:
                return "appliance";
            case 6:
                return "watch";
            case 7:
                return "vrheadset";
            default:
                return "undefined";
        }
    }

    public final String a() {
        NetworkInfo activeNetworkInfo;
        try {
            Context context = this.f7457a;
            Intrinsics.checkNotNullParameter(context, "<this>");
            Intrinsics.checkNotNullParameter(context, "<this>");
            Intrinsics.checkNotNullParameter("android.permission.ACCESS_NETWORK_STATE", "permission");
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
                Object systemService = context.getSystemService("connectivity");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
                activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
            } else {
                activeNetworkInfo = null;
            }
            if (activeNetworkInfo == null) {
                return "UNKNOWN";
            }
            return a(activeNetworkInfo);
        } catch (Exception unused) {
            u3.f7411a.getClass();
            return "NONE";
        }
    }

    public static String a(NetworkInfo networkInfo) {
        if (l1.a(networkInfo)) {
            String typeName = networkInfo.getTypeName();
            Intrinsics.checkNotNull(typeName);
            return typeName;
        }
        return networkInfo.getTypeName() + " - " + networkInfo.getSubtypeName();
    }

    public final Rect a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        DisplayMetrics displayMetrics = this.c;
        Rect rect = new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        try {
            view.getWindowVisibleDisplayFrame(rect);
        } catch (Exception unused) {
        }
        return rect;
    }
}
