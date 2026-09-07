package com.yandex.mobile.ads.impl;

import java.io.IOException;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.im1[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.im1[]) from 0x004e: INVOKE (r0v1 com.yandex.mobile.ads.impl.im1[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
/* JADX INFO: loaded from: classes10.dex */
public final class im1 {
    d("http/1.0"),
    e("http/1.1"),
    f("spdy/3.1"),
    g("h2"),
    h("h2_prior_knowledge"),
    i("quic");

    public static final a c;
    private final String b;

    static {
        EnumEntriesKt.enumEntries(im1VarArr);
        c = new a(0);
    }

    public static im1 valueOf(String str) {
        return (im1) Enum.valueOf(im1.class, str);
    }

    public static im1[] values() {
        return (im1[]) j.clone();
    }

    private im1(String str) {
        super(str, i);
        this.b = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.b;
    }

    public static final class a {
        @JvmStatic
        public static im1 a(String protocol) throws IOException {
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            im1 im1Var = im1.d;
            if (!Intrinsics.areEqual(protocol, im1Var.b)) {
                im1Var = im1.e;
                if (!Intrinsics.areEqual(protocol, im1Var.b)) {
                    im1Var = im1.h;
                    if (!Intrinsics.areEqual(protocol, im1Var.b)) {
                        im1Var = im1.g;
                        if (!Intrinsics.areEqual(protocol, im1Var.b)) {
                            im1Var = im1.f;
                            if (!Intrinsics.areEqual(protocol, im1Var.b)) {
                                im1Var = im1.i;
                                if (!Intrinsics.areEqual(protocol, im1Var.b)) {
                                    throw new IOException("Unexpected protocol: " + protocol);
                                }
                            }
                        }
                    }
                }
            }
            return im1Var;
        }

        private a() {
        }

        public /* synthetic */ a(int i) {
            this();
        }
    }
}
