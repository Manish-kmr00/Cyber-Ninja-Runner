package com.yandex.mobile.ads.impl;

import java.util.Locale;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class pa2 extends RuntimeException {
    private final oa2 b;
    private final a c;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.pa2$a[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.pa2$a[]) from 0x0023: INVOKE (r0v1 com.yandex.mobile.ads.impl.pa2$a[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
    public static final class a {
        /* JADX INFO: Fake field, exist only in values array */
        EF0("VERIFICATION_REJECTED"),
        c("VERIFICATION_NOT_SUPPORTED"),
        d("ERROR_RESOURCE_LOAD");

        private final int b;

        static {
            EnumEntriesKt.enumEntries(aVarArr);
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) e.clone();
        }

        private a(String str) {
            super(str, i);
            this.b = i;
        }

        public final int a() {
            return this.b;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public pa2(oa2 verification, a reason) {
        Intrinsics.checkNotNullParameter(verification, "verification");
        Intrinsics.checkNotNullParameter(reason, "reason");
        String strName = reason.name();
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = strName.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        super("Verification not executed with reason = " + lowerCase);
        this.b = verification;
        this.c = reason;
    }

    public final oa2 b() {
        return this.b;
    }

    public final a a() {
        return this.c;
    }
}
