package com.yandex.mobile.ads.impl;

import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.pk1[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.pk1[]) from 0x001a: INVOKE (r0v1 com.yandex.mobile.ads.impl.pk1[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
@Serializable
public final class pk1 {
    c,
    d;

    public static final b Companion;
    private static final Lazy<KSerializer<Object>> b;

    static {
        EnumEntriesKt.enumEntries(pk1VarArr);
        Companion = new b(0);
        b = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.yandex.mobile.ads.impl.pk1.a
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return EnumsKt.createAnnotatedEnumSerializer("com.monetization.ads.base.model.mediation.prefetch.PrefetchedMediationResultStatus", pk1.values(), new String[]{"success", "error"}, new Annotation[][]{null, null}, null);
            }
        });
    }

    public static pk1 valueOf(String str) {
        return (pk1) Enum.valueOf(pk1.class, str);
    }

    public static pk1[] values() {
        return (pk1[]) e.clone();
    }

    private pk1() {
        super(str, i);
    }

    public static final class b {
        public final KSerializer<pk1> serializer() {
            return (KSerializer) pk1.b.getValue();
        }

        private b() {
        }

        public /* synthetic */ b(int i) {
            this();
        }
    }
}
