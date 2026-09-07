package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes10.dex */
public interface zy1 {

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.zy1$a[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.zy1$a[]) from 0x0034: INVOKE (r0v1 com.yandex.mobile.ads.impl.zy1$a[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
        c("fixed"),
        d("flexible"),
        /* JADX INFO: Fake field, exist only in values array */
        EF2("screen"),
        e("sticky");

        private final String b;

        static {
            EnumEntriesKt.enumEntries(aVarArr);
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f.clone();
        }

        private a(String str) {
            super(str, i);
            this.b = str;
        }

        public final String a() {
            return this.b;
        }
    }

    int a(Context context);

    a a();

    int b(Context context);

    int c(Context context);

    int d(Context context);

    int getHeight();

    int getWidth();
}
