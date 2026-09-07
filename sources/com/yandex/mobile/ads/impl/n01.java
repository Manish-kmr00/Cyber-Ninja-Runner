package com.yandex.mobile.ads.impl;

import com.android.volley.toolbox.HttpClientStack;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.n01[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.n01[]) from 0x0056: INVOKE (r0v1 com.yandex.mobile.ads.impl.n01[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
/* JADX INFO: loaded from: classes7.dex */
public final class n01 {
    d("GET"),
    e("POST"),
    f(com.safedk.android.a.g.f),
    g("DELETE"),
    h("HEAD"),
    i("OPTIONS"),
    j("TRACE"),
    k(HttpClientStack.HttpPatch.METHOD_NAME);

    public static final a c;
    private final String b;

    static {
        EnumEntriesKt.enumEntries(n01VarArr);
        c = new a(0);
    }

    public static n01 valueOf(String str) {
        return (n01) Enum.valueOf(n01.class, str);
    }

    public static n01[] values() {
        return (n01[]) l.clone();
    }

    private n01(String str) {
        super(str, i);
        this.b = str;
    }

    public final String a() {
        return this.b;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(int i) {
            this();
        }
    }
}
