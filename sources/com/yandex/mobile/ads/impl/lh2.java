package com.yandex.mobile.ads.impl;

import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.lh2[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.lh2[]) from 0x002a: INVOKE (r0v1 com.yandex.mobile.ads.impl.lh2[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
/* JADX INFO: loaded from: classes11.dex */
public final class lh2 implements pq0 {
    c("default"),
    d("loading"),
    e("hidden");

    private final String b;

    static {
        EnumEntriesKt.enumEntries(lh2VarArr);
    }

    public static lh2 valueOf(String str) {
        return (lh2) Enum.valueOf(lh2.class, str);
    }

    public static lh2[] values() {
        return (lh2[]) f.clone();
    }

    private lh2(String str) {
        super(str, i);
        this.b = str;
    }

    @Override // com.yandex.mobile.ads.impl.pq0
    public final String a() {
        String strQuote = JSONObject.quote(this.b);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        return z0.a(new Object[]{strQuote}, 1, "state: %s", "format(...)");
    }
}
