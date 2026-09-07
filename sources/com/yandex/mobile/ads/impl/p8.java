package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class p8 {
    public static f a(Map headers) {
        Set set;
        Long lValueOf;
        Intrinsics.checkNotNullParameter(headers, "headers");
        String strA = kf0.a(headers, sh0.s);
        String strOptString = "";
        if (strA == null) {
            strA = "";
        }
        String strA2 = kf0.a(headers, sh0.W);
        if (strA2 == null) {
            set = SetsKt.emptySet();
        } else {
            try {
                strOptString = new JSONObject(strA2).optString("test_ids", "");
            } catch (Throwable unused) {
                op0.d(new Object[0]);
            }
            String str = strOptString;
            Intrinsics.checkNotNull(str);
            List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{";"}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList();
            Iterator it = listSplit$default.iterator();
            while (it.hasNext()) {
                try {
                    lValueOf = Long.valueOf(Long.parseLong((String) it.next()));
                } catch (Throwable unused2) {
                    lValueOf = null;
                }
                if (lValueOf != null) {
                    arrayList.add(lValueOf);
                }
            }
            set = CollectionsKt.toSet(arrayList);
        }
        return new f(strA, set);
    }
}
