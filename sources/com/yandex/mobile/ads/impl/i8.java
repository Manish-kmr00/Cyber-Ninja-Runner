package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r5v1 com.yandex.mobile.ads.impl.i8[], still in use, count: 1, list:
  (r5v1 com.yandex.mobile.ads.impl.i8[]) from 0x0024: INVOKE (r5v1 com.yandex.mobile.ads.impl.i8[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
/* JADX INFO: loaded from: classes2.dex */
final class i8 {
    d,
    e,
    f;

    public static final a b;
    private static final Map<String, Integer> c;

    static {
        i8 i8Var = d;
        i8 i8Var2 = e;
        i8 i8Var3 = f;
        EnumEntriesKt.enumEntries(i8VarArr);
        b = new a(0);
        Intrinsics.checkNotNullParameter("values_dimen_%s", "template");
        Pair pair = TuplesKt.to(a.a("values_dimen_%s", i8Var.name()), 48);
        Intrinsics.checkNotNullParameter("values_dimen_%s_sw600dp", "template");
        Pair pair2 = TuplesKt.to(a.a("values_dimen_%s_sw600dp", i8Var.name()), 56);
        Intrinsics.checkNotNullParameter("values_dimen_%s", "template");
        Pair pair3 = TuplesKt.to(a.a("values_dimen_%s", i8Var2.name()), 15);
        Intrinsics.checkNotNullParameter("values_dimen_%s_sw600dp", "template");
        Pair pair4 = TuplesKt.to(a.a("values_dimen_%s_sw600dp", i8Var2.name()), 17);
        Intrinsics.checkNotNullParameter("values_dimen_%s", "template");
        Pair pair5 = TuplesKt.to(a.a("values_dimen_%s", i8Var3.name()), 19);
        Intrinsics.checkNotNullParameter("values_dimen_%s_sw600dp", "template");
        c = MapsKt.mutableMapOf(pair, pair2, pair3, pair4, pair5, TuplesKt.to(a.a("values_dimen_%s_sw600dp", i8Var3.name()), 23));
    }

    public static i8 valueOf(String str) {
        return (i8) Enum.valueOf(i8.class, str);
    }

    public static i8[] values() {
        return (i8[]) g.clone();
    }

    public final int a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            a aVar = b;
            String resourceId = b(context);
            aVar.getClass();
            Intrinsics.checkNotNullParameter(resourceId, "resourceId");
            Integer num = c.get(a.a("values_dimen_%s", resourceId));
            if (num != null) {
                return num.intValue();
            }
        } catch (Exception unused) {
        }
        try {
            a aVar2 = b;
            String resourceId2 = name();
            aVar2.getClass();
            Intrinsics.checkNotNullParameter(resourceId2, "resourceId");
            Integer num2 = c.get(a.a("values_dimen_%s", resourceId2));
            if (num2 != null) {
                return num2.intValue();
            }
            return 0;
        } catch (Exception unused2) {
            return 0;
        }
    }

    public final String b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        StringBuilder sb = new StringBuilder(name());
        int i = oh2.b;
        Intrinsics.checkNotNullParameter(context, "context");
        if (RangesKt.coerceAtMost(oh2.c(context), oh2.b(context)) >= 600) {
            sb.append("_sw600dp");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private i8() {
        super(str, i);
    }

    @Override // java.lang.Enum
    public final String toString() {
        return name();
    }

    public static final class a {
        public static String a(String template, String resource) {
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(resource, "resource");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(Locale.US, template, Arrays.copyOf(new Object[]{resource}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }

        private a() {
        }

        public /* synthetic */ a(int i) {
            this();
        }
    }
}
