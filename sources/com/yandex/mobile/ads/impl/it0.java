package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class it0 {
    public static String a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (String) a(context, jt0.f.a());
    }

    public static ArrayList b(Context context) {
        List listSplit$default;
        Intrinsics.checkNotNullParameter(context, "context");
        String str = (String) a(context, jt0.g.a());
        if (str != null && (listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{StringUtils.COMMA}, false, 0, 6, (Object) null)) != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : listSplit$default) {
                if (!StringsKt.isBlank((String) obj)) {
                    arrayList.add(obj);
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
        }
        return null;
    }

    public static Boolean c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (Boolean) a(context, jt0.d.a());
    }

    public static boolean d(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Boolean bool = (Boolean) a(context, jt0.h.a());
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public static boolean e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Boolean bool = (Boolean) a(context, jt0.c.a());
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public static Boolean f(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (Boolean) a(context, jt0.e.a());
    }

    public static boolean g(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Boolean bool = (Boolean) a(context, jt0.i.a());
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private static Object a(Context context, String str) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        Object obj;
        try {
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            } catch (Throwable unused) {
                op0.c(new Object[0]);
                applicationInfo = null;
            }
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey(str) || (obj = bundle.get(str)) == null) {
                return null;
            }
            return obj;
        } catch (Throwable unused2) {
            op0.c(new Object[0]);
            return null;
        }
    }
}
