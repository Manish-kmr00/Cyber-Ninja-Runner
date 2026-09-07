package com.inmobi.media;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.u7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractC3583u7 {
    public static byte a(String referencedCreativeString) {
        Intrinsics.checkNotNullParameter(referencedCreativeString, "referencedCreativeString");
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = referencedCreativeString.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        int length = lowerCase.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) lowerCase.charAt(!z ? i : length), 32) <= 0;
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
        String strA = Q6.a(length, 1, lowerCase, i);
        int iHashCode = strA.hashCode();
        if (iHashCode != -1412832500) {
            if (iHashCode != 0) {
                if (iHashCode == 112202875 && strA.equals("video")) {
                    return (byte) 1;
                }
            } else if (strA.equals("")) {
                return (byte) 1;
            }
        } else if (strA.equals(com.playon.bridge.Ad.COMPANION)) {
            return (byte) 2;
        }
        return (byte) 0;
    }
}
