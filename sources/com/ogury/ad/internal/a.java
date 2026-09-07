package com.ogury.ad.internal;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a {
    public static List a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            ArrayList arrayList = new ArrayList();
            Iterator it = ArrayIteratorKt.iterator(context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities);
            while (it.hasNext()) {
                String name = ((ActivityInfo) it.next()).name;
                Intrinsics.checkNotNullExpressionValue(name, "name");
                Activity activity = null;
                try {
                    Object objNewInstance = Class.forName(name).getConstructor(null).newInstance(null);
                    if (objNewInstance instanceof Activity) {
                        activity = (Activity) objNewInstance;
                    }
                } catch (Exception unused) {
                    u3.f7411a.getClass();
                }
                if (activity != null) {
                    arrayList.add(activity);
                }
            }
            return arrayList;
        } catch (Exception unused2) {
            u3.f7411a.getClass();
            return CollectionsKt.emptyList();
        }
    }
}
