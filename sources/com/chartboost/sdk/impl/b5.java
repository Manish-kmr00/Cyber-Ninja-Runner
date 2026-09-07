package com.chartboost.sdk.impl;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"com/chartboost/sdk/impl/c5"}, d2 = {}, k = 4, mv = {1, 8, 0})
public final class b5 {
    public static final <T> List<T> asList(JSONArray jSONArray) {
        return c5.a(jSONArray);
    }

    public static final <T> List<T> asListSkipNull(JSONArray jSONArray) {
        return c5.b(jSONArray);
    }

    public static final PackageInfo getPackageInfoCompat(PackageManager packageManager, String str, int i) {
        return c5.a(packageManager, str, i);
    }

    public static final String getPackageVersionName(PackageManager packageManager, String str) {
        return c5.a(packageManager, str);
    }

    public static final ca toBodyFields(ba baVar) {
        return c5.a(baVar);
    }

    public static final v8 toReachabilityBodyFields(h2 h2Var) {
        return c5.a(h2Var);
    }
}
