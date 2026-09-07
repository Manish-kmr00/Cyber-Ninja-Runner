package com.yandex.mobile.ads.impl;

import android.os.Build;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class w32 implements t82 {
    @Override // com.yandex.mobile.ads.impl.t82
    public final String a() {
        String property;
        String property2 = null;
        try {
            property = System.getProperty("http.agent");
        } catch (Exception unused) {
            op0.b(new Object[0]);
            property = null;
        }
        if (property != null && property.length() != 0) {
            return property;
        }
        StringBuilder sb = new StringBuilder(64);
        sb.append("Dalvik/");
        try {
            property2 = System.getProperty("java.vm.version");
        } catch (Exception unused2) {
            op0.b(new Object[0]);
        }
        if (property2 == null || property2.length() == 0) {
            property2 = "1.0.0";
        }
        sb.append(property2);
        sb.append(" (Linux; U; Android ");
        String str = Build.VERSION.RELEASE;
        if (str.length() == 0) {
            str = "1.0";
        }
        sb.append(str);
        if (Intrinsics.areEqual("REL", Build.VERSION.CODENAME)) {
            String str2 = Build.MODEL;
            Intrinsics.checkNotNull(str2);
            if (str2.length() > 0) {
                sb.append("; ");
                sb.append(str2);
            }
        }
        String str3 = Build.ID;
        Intrinsics.checkNotNull(str3);
        if (str3.length() > 0) {
            sb.append(" Build/");
            sb.append(str3);
        }
        sb.append(")");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
