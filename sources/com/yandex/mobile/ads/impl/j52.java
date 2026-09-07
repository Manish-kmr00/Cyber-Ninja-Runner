package com.yandex.mobile.ads.impl;

import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.j52[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.j52[]) from 0x0042: INVOKE (r0v1 com.yandex.mobile.ads.impl.j52[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
	at java.base/java.util.ArrayList.forEach(Unknown Source)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes9.dex */
public final class j52 {
    d("TLSv1.3"),
    e("TLSv1.2"),
    f("TLSv1.1"),
    g("TLSv1"),
    h("SSLv3");

    public static final a c;
    private final String b;

    static {
        EnumEntriesKt.enumEntries(j52VarArr);
        c = new a(0);
    }

    public static j52 valueOf(String str) {
        return (j52) Enum.valueOf(j52.class, str);
    }

    public static j52[] values() {
        return (j52[]) i.clone();
    }

    private j52(String str) {
        super(str, i);
        this.b = str;
    }

    public final String a() {
        return this.b;
    }

    public static final class a {
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @JvmStatic
        public static j52 a(String javaName) {
            Intrinsics.checkNotNullParameter(javaName, "javaName");
            int iHashCode = javaName.hashCode();
            if (iHashCode != 79201641) {
                if (iHashCode != 79923350) {
                    switch (iHashCode) {
                        case -503070503:
                            if (javaName.equals("TLSv1.1")) {
                                return j52.f;
                            }
                            break;
                        case -503070502:
                            if (javaName.equals("TLSv1.2")) {
                                return j52.e;
                            }
                            break;
                        case -503070501:
                            if (javaName.equals("TLSv1.3")) {
                                return j52.d;
                            }
                            break;
                    }
                } else if (javaName.equals("TLSv1")) {
                    return j52.g;
                }
            } else if (javaName.equals("SSLv3")) {
                return j52.h;
            }
            throw new IllegalArgumentException("Unexpected TLS version: " + javaName);
        }

        private a() {
        }

        public /* synthetic */ a(int i) {
            this();
        }
    }
}
