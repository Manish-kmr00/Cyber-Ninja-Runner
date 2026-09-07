package sg.bigo.ads.common.m;

import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f13215a = {1, 3, 4, 2, 7, 9, 10};
    private static final int[] b = {2, 7, 9, 10};

    public static boolean a() {
        String str;
        String strValueOf;
        String strConcat;
        if (b()) {
            String strB = b.b();
            if (!q.a((CharSequence) strB)) {
                if (strB.length() < 11) {
                    strConcat = "purposeConsents length < 11, so return false";
                } else {
                    int[] iArr = f13215a;
                    int length = iArr.length;
                    int i = 0;
                    while (true) {
                        if (i < length) {
                            int i2 = iArr[i];
                            if (strB.charAt(i2 - 1) == '0') {
                                str = "purposeConsents return false ,the checkBit is: ";
                                strValueOf = String.valueOf(i2);
                            } else {
                                i++;
                            }
                        }
                        strConcat = str.concat(strValueOf);
                    }
                }
                sg.bigo.ads.common.t.a.a(0, 3, "GdprHelper", strConcat);
                return false;
            }
            sg.bigo.ads.common.t.a.a(0, 3, "GdprHelper", "purposeConsents is empty, so return true");
            String strD = b.d();
            if (!q.a((CharSequence) strD)) {
                if (strD.length() < 11) {
                    strConcat = "purposeLegitimateInterests length < 11, so return false";
                } else {
                    for (int i3 : b) {
                        if (strD.charAt(i3 - 1) == '0') {
                            str = "purposeLegitimateInterests return false ,the checkBit is: ";
                            strValueOf = String.valueOf(i3);
                            strConcat = str.concat(strValueOf);
                        }
                    }
                }
                sg.bigo.ads.common.t.a.a(0, 3, "GdprHelper", strConcat);
                return false;
            }
            sg.bigo.ads.common.t.a.a(0, 3, "GdprHelper", "purposeLegitimateInterests is empty, so return true");
        }
        return true;
    }

    public static boolean b() {
        return b.c() == 1;
    }
}
