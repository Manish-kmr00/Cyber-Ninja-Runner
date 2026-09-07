package com.inmobi.media;

import android.util.SparseArray;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.inmobi.media.n1[], still in use, count: 1, list:
  (r0v1 com.inmobi.media.n1[]) from 0x002a: INVOKE (r0v1 com.inmobi.media.n1[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
/* JADX INFO: renamed from: com.inmobi.media.n1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class EnumC3479n1 {
    d("UNKNOWN"),
    e("PLAYING"),
    /* JADX INFO: Fake field, exist only in values array */
    EF25("PAUSED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF33("COMPLETED");

    public static final C3463m1 b;
    public static final SparseArray c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3378a;

    static {
        EnumEntriesKt.enumEntries(new EnumC3479n1[]{r0, r1, new EnumC3479n1("PAUSED"), new EnumC3479n1("COMPLETED")});
        b = new C3463m1();
        c = new SparseArray();
        for (EnumC3479n1 enumC3479n1 : values()) {
            c.put(enumC3479n1.f3378a, enumC3479n1);
        }
    }

    public EnumC3479n1(String str) {
        super(str, i);
        this.f3378a = i;
    }

    public static EnumC3479n1 valueOf(String str) {
        return (EnumC3479n1) Enum.valueOf(EnumC3479n1.class, str);
    }

    public static EnumC3479n1[] values() {
        return (EnumC3479n1[]) f.clone();
    }
}
