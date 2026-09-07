package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.ByteString;

/* JADX INFO: loaded from: classes8.dex */
public final class dh0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final dh0 f8694a = new dh0();
    public static final ByteString b = ByteString.INSTANCE.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    private static final String[] c = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    private static final String[] d = new String[64];
    private static final String[] e;

    static {
        String[] strArr = new String[256];
        for (int i = 0; i < 256; i++) {
            String binaryString = Integer.toBinaryString(i);
            Intrinsics.checkNotNullExpressionValue(binaryString, "toBinaryString(...)");
            strArr[i] = StringsKt.replace$default(y82.a("%8s", binaryString), ' ', '0', false, 4, (Object) null);
        }
        e = strArr;
        String[] strArr2 = d;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i2 = iArr[0];
        strArr2[i2 | 8] = strArr2[i2] + "|PADDED";
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i3 = 0; i3 < 3; i3++) {
            int i4 = iArr2[i3];
            int i5 = iArr[0];
            String[] strArr3 = d;
            int i6 = i5 | i4;
            strArr3[i6] = strArr3[i5] + com.safedk.android.analytics.brandsafety.l.ad + strArr3[i4];
            strArr3[i6 | 8] = strArr3[i5] + com.safedk.android.analytics.brandsafety.l.ad + strArr3[i4] + "|PADDED";
        }
        int length = d.length;
        for (int i7 = 0; i7 < length; i7++) {
            String[] strArr4 = d;
            if (strArr4[i7] == null) {
                strArr4[i7] = e[i7];
            }
        }
    }

    public static String a(int i) {
        String[] strArr = c;
        return i < strArr.length ? strArr[i] : y82.a("0x%02x", Integer.valueOf(i));
    }

    /* JADX WARN: Code duplicated, block: B:35:0x005e  */
    public static String a(boolean z, int i, int i2, int i3, int i4) {
        String strReplace$default;
        String str;
        String strA = a(i3);
        if (i4 == 0) {
            strReplace$default = "";
        } else if (i3 == 2 || i3 == 3) {
            strReplace$default = e[i4];
        } else if (i3 == 4 || i3 == 6) {
            strReplace$default = i4 == 1 ? "ACK" : e[i4];
        } else if (i3 != 7 && i3 != 8) {
            String[] strArr = d;
            if (i4 < strArr.length) {
                str = strArr[i4];
                Intrinsics.checkNotNull(str);
            } else {
                str = e[i4];
            }
            String str2 = str;
            if (i3 == 5 && (i4 & 4) != 0) {
                strReplace$default = StringsKt.replace$default(str2, "HEADERS", "PUSH_PROMISE", false, 4, (Object) null);
            } else {
                strReplace$default = (i3 != 0 || (i4 & 32) == 0) ? str2 : StringsKt.replace$default(str2, "PRIORITY", "COMPRESSED", false, 4, (Object) null);
            }
        } else {
            strReplace$default = e[i4];
        }
        return y82.a("%s 0x%08x %5d %-13s %s", z ? "<<" : ">>", Integer.valueOf(i), Integer.valueOf(i2), strA, strReplace$default);
    }

    private dh0() {
    }
}
