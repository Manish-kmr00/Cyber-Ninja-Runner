package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public abstract class L8 {
    public static String a(String valueTypeString) {
        Intrinsics.checkNotNullParameter(valueTypeString, "valueTypeString");
        int length = valueTypeString.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) valueTypeString.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String strA = Q6.a(length, 1, valueTypeString, i);
        int iHashCode = strA.hashCode();
        if (iHashCode != -1900324833) {
            if (iHashCode != -835221992) {
                if (iHashCode != 116079) {
                    if (iHashCode == 3213227 && strA.equals("html")) {
                        return "HTML";
                    }
                } else if (strA.equals("url")) {
                    return "URL";
                }
            } else if (strA.equals("reference_iframe")) {
                return "REF_IFRAME";
            }
        } else if (strA.equals("reference_html")) {
            return "REF_HTML";
        }
        return "UNKNOWN";
    }
}
