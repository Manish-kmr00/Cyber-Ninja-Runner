package com.chartboost.sdk.impl;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0004\u001a\u0011\u0010\u0003\u001a\u00020\u0007*\u00020\u0006¢\u0006\u0004\b\u0003\u0010\b\u001a\u0011\u0010\u0003\u001a\u00020\n*\u00020\t¢\u0006\u0004\b\u0003\u0010\u000b\u001a\u0019\u0010\u0003\u001a\u00020\r*\u00020\f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0003\u0010\u000f\u001a#\u0010\u0003\u001a\u00020\u0012*\u00020\f2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0003\u0010\u0013¨\u0006\u0014"}, d2 = {"T", "Lorg/json/JSONArray;", "", "a", "(Lorg/json/JSONArray;)Ljava/util/List;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/chartboost/sdk/impl/ba;", "Lcom/chartboost/sdk/impl/ca;", "(Lcom/chartboost/sdk/impl/ba;)Lcom/chartboost/sdk/impl/ca;", "Lcom/chartboost/sdk/impl/h2;", "Lcom/chartboost/sdk/impl/v8;", "(Lcom/chartboost/sdk/impl/h2;)Lcom/chartboost/sdk/impl/v8;", "Landroid/content/pm/PackageManager;", "", "packageName", "(Landroid/content/pm/PackageManager;Ljava/lang/String;)Ljava/lang/String;", "", "flags", "Landroid/content/pm/PackageInfo;", "(Landroid/content/pm/PackageManager;Ljava/lang/String;I)Landroid/content/pm/PackageInfo;", "ChartboostMonetization-9.8.3_productionRelease"}, k = 5, mv = {1, 8, 0}, xs = "com/chartboost/sdk/internal/Model/Extensions")
public final /* synthetic */ class c5 {
    public static final <T> List<T> a(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        IntRange intRangeUntil = RangesKt.until(0, jSONArray.length());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            arrayList.add(jSONArray.get(((IntIterator) it).nextInt()));
        }
        return arrayList;
    }

    public static final <T> List<T> b(JSONArray jSONArray) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        IntRange intRangeUntil = RangesKt.until(0, jSONArray.length());
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            Object obj = jSONArray.get(((IntIterator) it).nextInt());
            if (obj == null) {
                obj = null;
            }
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final PackageInfo a(PackageManager packageManager, String packageName, int i) throws PackageManager.NameNotFoundException {
        Intrinsics.checkNotNullParameter(packageManager, "<this>");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (Build.VERSION.SDK_INT >= 33) {
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(i));
            Intrinsics.checkNotNullExpressionValue(packageInfo, "{\n        getPackageInfo…of(flags.toLong()))\n    }");
            return packageInfo;
        }
        PackageInfo packageInfo2 = packageManager.getPackageInfo(packageName, i);
        Intrinsics.checkNotNullExpressionValue(packageInfo2, "{\n        getPackageInfo(packageName, flags)\n    }");
        return packageInfo2;
    }

    public static final String a(PackageManager packageManager, String packageName) {
        Intrinsics.checkNotNullParameter(packageManager, "<this>");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        try {
            String str = b5.getPackageInfoCompat(packageManager, packageName, 128).versionName;
            Intrinsics.checkNotNullExpressionValue(str, "{\n        getPackageInfo…A_DATA).versionName\n    }");
            return str;
        } catch (Exception e) {
            b7.b("Exception raised getting package manager object", e);
            return "";
        }
    }

    public static final ca a(ba baVar) {
        Intrinsics.checkNotNullParameter(baVar, "<this>");
        return new ca(baVar.a(), baVar.b(), baVar.c());
    }

    public static final v8 a(h2 h2Var) {
        Intrinsics.checkNotNullParameter(h2Var, "<this>");
        return new v8(Integer.valueOf(h2Var.a()), Integer.valueOf(h2Var.c().getValue()), h2Var.b(), h2Var.f());
    }
}
