package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
public final class ab2 {
    public static za2 a(String versionNameStr) {
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(versionNameStr, "versionNameStr");
        int length = versionNameStr.length();
        for (int i = 0; i < length; i++) {
            if (versionNameStr.charAt(i) == '-') {
                versionNameStr = versionNameStr.substring(0, i);
                Intrinsics.checkNotNullExpressionValue(versionNameStr, "substring(...)");
                break;
            }
        }
        List listSplit$default = StringsKt.split$default((CharSequence) versionNameStr, new char[]{'.'}, false, 0, 6, (Object) null);
        String str = (String) CollectionsKt.getOrNull(listSplit$default, 0);
        if (str == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) {
            return null;
        }
        int iIntValue = intOrNull.intValue();
        Integer intOrNull2 = StringsKt.toIntOrNull((String) (1 <= CollectionsKt.getLastIndex(listSplit$default) ? listSplit$default.get(1) : "0"));
        if (intOrNull2 == null) {
            return null;
        }
        int iIntValue2 = intOrNull2.intValue();
        Integer intOrNull3 = StringsKt.toIntOrNull((String) (2 <= CollectionsKt.getLastIndex(listSplit$default) ? listSplit$default.get(2) : "0"));
        if (intOrNull3 != null) {
            return new za2(iIntValue, iIntValue2, intOrNull3.intValue());
        }
        return null;
    }
}
