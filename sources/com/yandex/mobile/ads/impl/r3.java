package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class r3 extends ki2 {
    public static final /* synthetic */ int d = 0;
    private final x3 c;

    public static final class a {
        /* JADX WARN: Code duplicated, block: B:26:0x0053  */
        /* JADX WARN: Code duplicated, block: B:28:0x0057  */
        /* JADX WARN: Code duplicated, block: B:29:0x005a  */
        /* JADX WARN: Code duplicated, block: B:31:0x005e  */
        /* JADX WARN: Code duplicated, block: B:32:0x0061  */
        /* JADX WARN: Code duplicated, block: B:37:0x006c A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:38:0x006e  */
        /* JADX WARN: Code duplicated, block: B:39:0x0071  */
        public static r3 a(tc1 tc1Var) {
            x3 x3Var;
            int i = tc1Var != null ? tc1Var.f10286a : -1;
            op0.b(Integer.valueOf(i));
            if (204 == i) {
                x3Var = x3.d;
            } else {
                Map<String, String> responseHeaders = tc1Var != null ? tc1Var.c : null;
                Integer numValueOf = tc1Var != null ? Integer.valueOf(tc1Var.f10286a) : null;
                if (numValueOf != null && 400 == numValueOf.intValue() && responseHeaders != null) {
                    sh0 httpHeader = sh0.Y;
                    int i2 = kf0.b;
                    Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
                    Intrinsics.checkNotNullParameter(httpHeader, "httpHeader");
                    String strA = kf0.a(responseHeaders, httpHeader);
                    if (strA != null && Boolean.parseBoolean(strA)) {
                        x3Var = x3.h;
                    } else if (403 == i) {
                        x3Var = x3.g;
                    } else if (404 == i) {
                        x3Var = x3.b;
                    } else if (500 > i && i <= 599) {
                        x3Var = x3.f;
                    } else if (-1 == i) {
                        x3Var = x3.k;
                    } else {
                        x3Var = x3.e;
                    }
                } else if (403 == i) {
                    x3Var = x3.g;
                } else if (404 == i) {
                    x3Var = x3.b;
                } else if (500 > i) {
                    if (-1 == i) {
                        x3Var = x3.k;
                    } else {
                        x3Var = x3.e;
                    }
                } else if (-1 == i) {
                    x3Var = x3.k;
                } else {
                    x3Var = x3.e;
                }
            }
            return new r3(x3Var, tc1Var);
        }

        public static r3 a(ki2 volleyError) {
            x3 x3Var;
            Intrinsics.checkNotNullParameter(volleyError, "volleyError");
            tc1 tc1Var = volleyError.b;
            Integer numValueOf = tc1Var != null ? Integer.valueOf(tc1Var.f10286a) : null;
            if (numValueOf == null) {
                if (volleyError instanceof jd1) {
                    x3Var = x3.k;
                } else if (volleyError instanceof e52) {
                    x3Var = x3.l;
                } else if (volleyError instanceof zh) {
                    x3Var = x3.m;
                } else if (volleyError instanceof dp) {
                    x3Var = x3.n;
                } else {
                    x3Var = volleyError instanceof zf1 ? x3.o : x3.p;
                }
            } else {
                int iIntValue = numValueOf.intValue();
                x3Var = (500 > iIntValue || iIntValue > 599) ? x3.e : x3.f;
            }
            op0.b(numValueOf);
            return new r3(x3Var, tc1Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r3(x3 reason, tc1 tc1Var) {
        super(tc1Var);
        Intrinsics.checkNotNullParameter(reason, "reason");
        this.c = reason;
    }

    public final x3 a() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(r3.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.monetization.ads.base.AdFetchError");
        return this.c == ((r3) obj).c;
    }

    public final int hashCode() {
        return this.c.hashCode();
    }
}
