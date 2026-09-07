package com.yandex.mobile.ads.impl;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes10.dex */
final class k42 {
    private static final Pattern b = Pattern.compile("\\s+");
    private static final jk0<String> c = jk0.a("auto", "none");
    private static final jk0<String> d = jk0.a("dot", "sesame", "circle");
    private static final jk0<String> e = jk0.a("filled", "open");
    private static final jk0<String> f = jk0.a("after", "before", "outside");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9378a;

    private k42(int i, int i2, int i3) {
        this.f9378a = i;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x006d  */
    /* JADX WARN: Code duplicated, block: B:67:0x0114  */
    /* JADX WARN: Code duplicated, block: B:68:0x0119  */
    /* JADX WARN: Code duplicated, block: B:71:0x0125  */
    /* JADX WARN: Code duplicated, block: B:73:0x012a  */
    /* JADX WARN: Code duplicated, block: B:79:0x013a  */
    /* JADX WARN: Code duplicated, block: B:81:0x0142  */
    /* JADX WARN: Code duplicated, block: B:82:0x0144  */
    /* JADX WARN: Code duplicated, block: B:84:0x014a  */
    /* JADX WARN: Code duplicated, block: B:86:0x014d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x014f  */
    /* JADX WARN: Code duplicated, block: B:88:0x0151  */
    public static k42 a(String str) {
        byte b2;
        int i;
        int i2;
        k kVar;
        Object next;
        String str2;
        int iHashCode;
        if (str == null) {
            return null;
        }
        String strB = fg.b(str.trim());
        if (strB.isEmpty()) {
            return null;
        }
        jk0 jk0VarA = jk0.a(TextUtils.split(strB, b));
        k kVar2 = (k) px1.a((jk0) f, jk0VarA).iterator();
        String str3 = (String) (kVar2.hasNext() ? kVar2.next() : "outside");
        int iHashCode2 = str3.hashCode();
        int i3 = -1;
        int i4 = 2;
        if (iHashCode2 != -1392885889) {
            if (iHashCode2 != -1106037339) {
                if (iHashCode2 == 92734940 && str3.equals("after")) {
                    b2 = 0;
                } else {
                    b2 = -1;
                }
            } else if (str3.equals("outside")) {
                b2 = 1;
            } else {
                b2 = -1;
            }
        } else if (str3.equals("before")) {
            b2 = 2;
        } else {
            b2 = -1;
        }
        if (b2 != 0) {
            i = b2 != 1 ? 1 : -2;
        } else {
            i = 2;
        }
        px1.d dVarA = px1.a((jk0) c, jk0VarA);
        if (!dVarA.isEmpty()) {
            String str4 = (String) ((k) dVarA.iterator()).next();
            int iHashCode3 = str4.hashCode();
            if (iHashCode3 == 3005871) {
                str4.equals("auto");
            } else if (iHashCode3 == 3387192 && str4.equals("none")) {
                i3 = 0;
            }
            return new k42(i3, 0, i);
        }
        px1.d dVarA2 = px1.a((jk0) e, jk0VarA);
        px1.d dVarA3 = px1.a((jk0) d, jk0VarA);
        if (dVarA2.isEmpty() && dVarA3.isEmpty()) {
            return new k42(-1, 0, i);
        }
        k kVar3 = (k) dVarA2.iterator();
        String str5 = (String) (kVar3.hasNext() ? kVar3.next() : "filled");
        int iHashCode4 = str5.hashCode();
        if (iHashCode4 != -1274499742) {
            if (iHashCode4 == 3417674 && str5.equals("open")) {
                i2 = 2;
            }
            kVar = (k) dVarA3.iterator();
            if (kVar.hasNext()) {
                next = kVar.next();
            } else {
                next = "circle";
            }
            str2 = (String) next;
            iHashCode = str2.hashCode();
            if (iHashCode != -1360216880) {
                if (iHashCode != -905816648) {
                    if (iHashCode == 99657 && str2.equals("dot")) {
                        i3 = 0;
                    }
                } else if (str2.equals("sesame")) {
                    i3 = 1;
                }
            } else if (str2.equals("circle")) {
                i3 = 2;
            }
            if (i3 != 0) {
                if (i3 != 1) {
                    i4 = 1;
                } else {
                    i4 = 3;
                }
            }
            return new k42(i4, i2, i);
        }
        str5.equals("filled");
        i2 = 1;
        kVar = (k) dVarA3.iterator();
        if (kVar.hasNext()) {
            next = kVar.next();
        } else {
            next = "circle";
        }
        str2 = (String) next;
        iHashCode = str2.hashCode();
        if (iHashCode != -1360216880) {
            if (iHashCode != -905816648) {
                if (iHashCode == 99657) {
                    i3 = 0;
                }
            } else if (str2.equals("sesame")) {
                i3 = 1;
            }
        } else if (str2.equals("circle")) {
            i3 = 2;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                i4 = 1;
            } else {
                i4 = 3;
            }
        }
        return new k42(i4, i2, i);
    }
}
