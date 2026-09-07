package com.ogury.ad.internal;

import android.net.Uri;
import java.util.List;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
public interface l7 {

    public static final class a {
        public static /* synthetic */ void a(l7 l7Var, c cVar, b bVar, String str, int i) {
            if ((i & 32) != 0) {
                str = null;
            }
            l7Var.a(cVar, bVar, null, null, null, str);
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.ogury.ad.internal.l7$b[], still in use, count: 1, list:
  (r0v1 com.ogury.ad.internal.l7$b[]) from 0x0040: INVOKE (r0v1 com.ogury.ad.internal.l7$b[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
    public static final class b {
        TIMEOUT,
        WEBVIEW_NULL,
        HTML_EMBEDDING_ERROR,
        OTHER,
        UNLOAD,
        /* JADX INFO: Fake field, exist only in values array */
        UNKNOWN;

        static {
            EnumEntriesKt.enumEntries(bVarArr);
        }

        public b() {
            super(str, i);
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f.clone();
        }
    }

    void a(c cVar);

    void a(c cVar, b bVar, List<? extends w9.a> list, Long l, Long l2, String str);

    void a(c cVar, boolean z, Uri uri);

    void b(c cVar);
}
