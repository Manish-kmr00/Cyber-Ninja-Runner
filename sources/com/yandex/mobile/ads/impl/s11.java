package com.yandex.mobile.ads.impl;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class s11 {
    /* JADX WARN: Code duplicated, block: B:15:0x0037  */
    /* JADX WARN: Code duplicated, block: B:8:0x0028  */
    public static ya2 a() {
        int i;
        int i2;
        int i3 = 0;
        String[] strArr = (String[]) StringsKt.split$default((CharSequence) "7.12.1", new String[]{"."}, false, 0, 6, (Object) null).toArray(new String[0]);
        if (strArr.length > 0) {
            String str = strArr[0];
            int i4 = oa.b;
            if (str != null) {
                try {
                    i = Integer.parseInt(str);
                } catch (NumberFormatException unused) {
                    i = 0;
                }
            } else {
                i = 0;
            }
        } else {
            i = 0;
        }
        if (strArr.length > 1) {
            String str2 = strArr[1];
            int i5 = oa.b;
            if (str2 != null) {
                try {
                    i2 = Integer.parseInt(str2);
                } catch (NumberFormatException unused2) {
                    i2 = 0;
                }
            } else {
                i2 = 0;
            }
        } else {
            i2 = 0;
        }
        if (strArr.length > 2) {
            String str3 = strArr[2];
            int i6 = oa.b;
            if (str3 != null) {
                try {
                    i3 = Integer.parseInt(str3);
                } catch (NumberFormatException unused3) {
                }
            }
        }
        return new ya2(i, i2, i3);
    }
}
