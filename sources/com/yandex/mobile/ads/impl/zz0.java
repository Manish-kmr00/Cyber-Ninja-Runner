package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class zz0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final nz0 f10867a;

    public zz0(nz0 mediationNetworkValidator) {
        Intrinsics.checkNotNullParameter(mediationNetworkValidator, "mediationNetworkValidator");
        this.f10867a = mediationNetworkValidator;
    }

    private static void a(ArrayList arrayList, String str) {
        int iMax = Math.max(4, 44 - str.length());
        int i = iMax / 2;
        String strRepeat = StringsKt.repeat("-", i);
        String strRepeat2 = StringsKt.repeat("-", (iMax % 2) + i);
        String strRepeat3 = StringsKt.repeat(" ", 1);
        arrayList.add(new a(strRepeat + strRepeat3 + str + strRepeat3 + strRepeat2, a.EnumC0762a.b));
    }

    private static void a(ArrayList arrayList, List list, String str, boolean z) {
        a.EnumC0762a enumC0762a;
        String str2;
        String str3;
        if (z) {
            enumC0762a = a.EnumC0762a.b;
            str2 = "ADAPTERS";
            str3 = "INTEGRATED SUCCESSFULLY";
        } else {
            enumC0762a = a.EnumC0762a.c;
            str2 = "MISSING ADAPTERS";
            str3 = "NOT INTEGRATED";
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(((mz0.c) it.next()).a());
        }
        arrayList.add(new a(CollectionsKt.joinToString$default(arrayList2, null, str2.concat(": "), null, 0, null, null, 61, null), enumC0762a));
        arrayList.add(new a(str + ": " + str3, enumC0762a));
    }

    private static void a(ArrayList arrayList, String str, String str2) {
        if (str != null && !StringsKt.isBlank(str)) {
            arrayList.add(new a("SDK Version: " + str, a.EnumC0762a.b));
        }
        if (str2 == null || StringsKt.isBlank(str2)) {
            return;
        }
        arrayList.add(new a("ADAPTERS Version: " + str2, a.EnumC0762a.b));
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10868a;
        private final EnumC0762a b;

        /* JADX WARN: Enum visitor error
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.zz0$a$a[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.zz0$a$a[]) from 0x001a: INVOKE (r0v1 com.yandex.mobile.ads.impl.zz0$a$a[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
        /* JADX INFO: renamed from: com.yandex.mobile.ads.impl.zz0$a$a, reason: collision with other inner class name */
        public static final class EnumC0762a {
            b,
            c;

            static {
                EnumEntriesKt.enumEntries(enumC0762aArr);
            }

            public static EnumC0762a valueOf(String str) {
                return (EnumC0762a) Enum.valueOf(EnumC0762a.class, str);
            }

            public static EnumC0762a[] values() {
                return (EnumC0762a[]) d.clone();
            }

            private EnumC0762a() {
                super(str, i);
            }
        }

        public a(String message, EnumC0762a type) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(type, "type");
            this.f10868a = message;
            this.b = type;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.f10868a, aVar.f10868a) && this.b == aVar.b;
        }

        public final int hashCode() {
            return this.b.hashCode() + (this.f10868a.hashCode() * 31);
        }

        public final String toString() {
            return "MediationNetworkMessage(message=" + this.f10868a + ", type=" + this.b + ")";
        }

        public final String a() {
            return this.f10868a;
        }

        public final EnumC0762a b() {
            return this.b;
        }
    }

    public final ArrayList a(ArrayList networks) {
        Intrinsics.checkNotNullParameter(networks, "networks");
        ArrayList arrayList = new ArrayList();
        Iterator it = networks.iterator();
        while (it.hasNext()) {
            mz0 mz0Var = (mz0) it.next();
            a(arrayList, mz0Var.c());
            String strD = mz0Var.d();
            String strB = ((mz0.c) CollectionsKt.first((List) mz0Var.b())).b();
            this.f10867a.getClass();
            boolean zA = nz0.a(mz0Var);
            if (zA) {
                a(arrayList, strD, strB);
            }
            a(arrayList, mz0Var.b(), mz0Var.c(), zA);
        }
        return arrayList;
    }
}
