package com.inmobi.media;

import android.util.SparseArray;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v20 com.inmobi.media.I3[], still in use, count: 1, list:
  (r0v20 com.inmobi.media.I3[]) from 0x01aa: INVOKE (r0v20 com.inmobi.media.I3[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
/* JADX INFO: loaded from: classes6.dex */
public final class I3 {
    d("NETWORK_UNAVAILABLE_ERROR"),
    e("UNKNOWN_ERROR"),
    f("NETWORK_IO_ERROR"),
    g("OUT_OF_MEMORY_ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF5("INVALID_ENCRYPTED_RESPONSE_RECEIVED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF6("RESPONSE_EXCEEDS_SPECIFIED_SIZE_LIMIT"),
    h("GZIP_DECOMPRESSION_FAILED"),
    i("BAD_REQUEST"),
    j("GDPR_COMPLIANCE_ENFORCED"),
    k("GENERIC_HTTP_2XX"),
    l("RESPONSE_PARSING_ERROR"),
    m("RETRY_ATTEMPTED"),
    n("NETWORK_UNAVAILABLE_CONTEXT_LOSS"),
    o("NETWORK_UNAVAILABLE_IDLE_MODE"),
    p("NETWORK_UNAVAILABLE_NO_CONNECTION_M_OR_ABOVE"),
    q("NETWORK_UNAVAILABLE_NO_CONNECTION_BELOW_M"),
    r("NETWORK_UNAVAILABLE_EXCEPTION"),
    s("NETWORK_PREPARE_FAIL"),
    t("NETWORK_UNAVAILABLE_CUSTOM_VALIDATOR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("HTTP_NO_CONTENT"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("HTTP_NOT_MODIFIED"),
    u("HTTP_SEE_OTHER"),
    v("HTTP_SERVER_NOT_FOUND"),
    w("HTTP_MOVED_TEMP"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("HTTP_INTERNAL_SERVER_ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("HTTP_NOT_IMPLEMENTED"),
    x("HTTP_BAD_GATEWAY"),
    y("HTTP_SERVER_NOT_AVAILABLE"),
    z("HTTP_GATEWAY_TIMEOUT"),
    /* JADX INFO: Fake field, exist only in values array */
    EF409("HTTP_VERSION_NOT_SUPPORTED");

    public static final H3 b;
    public static final SparseArray c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3094a;

    static {
        EnumEntriesKt.enumEntries(new I3[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r0, r0, r0, r0, r0, r0, r0, r0, r0, r0, r0, r0, r0, r0, r0, r0, new I3("HTTP_VERSION_NOT_SUPPORTED")});
        b = new H3();
        c = new SparseArray();
        for (I3 i3 : values()) {
            c.put(i3.f3094a, i3);
        }
    }

    public I3(String str) {
        super(str, i);
        this.f3094a = i;
    }

    public static I3 valueOf(String str) {
        return (I3) Enum.valueOf(I3.class, str);
    }

    public static I3[] values() {
        return (I3[]) A.clone();
    }
}
