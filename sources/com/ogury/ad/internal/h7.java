package com.ogury.ad.internal;

import android.app.Activity;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class h7 {
    public static final String a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        String strA = a((Object) activity);
        List listSplit$default = StringsKt.split$default((CharSequence) strA, new char[]{'.'}, false, 0, 6, (Object) null);
        if (listSplit$default.size() <= 2) {
            return strA;
        }
        return listSplit$default.get(0) + "." + listSplit$default.get(1) + ".";
    }

    public static final String a(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        String canonicalName = obj.getClass().getCanonicalName();
        if (canonicalName != null) {
            return canonicalName;
        }
        String name = obj.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return name;
    }
}
