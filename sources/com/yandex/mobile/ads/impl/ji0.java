package com.yandex.mobile.ads.impl;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class ji0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9320a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f9321a;

        public final a a(String str) {
            return this;
        }

        public final a d(String str) {
            b bVar;
            b[] bVarArrValues = b.values();
            int length = bVarArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    bVar = null;
                    break;
                }
                bVar = bVarArrValues[i];
                if (Intrinsics.areEqual(bVar.a(), str)) {
                    break;
                }
                i++;
            }
            if (bVar == null) {
                bVar = b.c;
            }
            if (bVar == b.c) {
                ud2.b(str);
            }
            return this;
        }

        public final a g(String str) {
            c[] cVarArrValues = c.values();
            int length = cVarArrValues.length;
            for (int i = 0; i < length && !Intrinsics.areEqual(cVarArrValues[i].a(), str); i++) {
            }
            return this;
        }

        public final void h(String str) {
        }

        public final a i(String str) {
            d dVar;
            d[] dVarArrValues = d.values();
            int length = dVarArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    dVar = null;
                    break;
                }
                dVar = dVarArrValues[i];
                if (Intrinsics.areEqual(dVar.a(), str)) {
                    break;
                }
                i++;
            }
            if (dVar == null) {
                dVar = d.c;
            }
            if (dVar == d.c) {
                ud2.b(str);
            }
            return this;
        }

        public final ji0 a() {
            return new ji0(this.f9321a, 0);
        }

        public final a f(String str) {
            this.f9321a = str;
            return this;
        }

        public final a j(String str) {
            ud2.b(str);
            return this;
        }

        public final a c(String str) {
            ud2.b(str);
            return this;
        }

        public final a e(String str) {
            ud2.a(str);
            return this;
        }

        public final a b(String str) {
            ud2.a(str);
            return this;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.ji0$b[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.ji0$b[]) from 0x0026: INVOKE (r0v1 com.yandex.mobile.ads.impl.ji0$b[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
        /* JADX INFO: Fake field, exist only in values array */
        EF0("left"),
        /* JADX INFO: Fake field, exist only in values array */
        EF1("right"),
        c("leftOffset");

        private final String b;

        static {
            EnumEntriesKt.enumEntries(bVarArr);
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) d.clone();
        }

        private b(String str) {
            super(str, i);
            this.b = str;
        }

        public final String a() {
            return this.b;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.ji0$c[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.ji0$c[]) from 0x0024: INVOKE (r0v1 com.yandex.mobile.ads.impl.ji0$c[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
    public static final class c {
        /* JADX INFO: Fake field, exist only in values array */
        EF7("StaticResource"),
        /* JADX INFO: Fake field, exist only in values array */
        EF17("IFrameResource"),
        /* JADX INFO: Fake field, exist only in values array */
        EF27("HTMLResource");

        public static final a c;
        private final String b;

        static {
            EnumEntriesKt.enumEntries(cVarArr);
            c = new a(0);
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) d.clone();
        }

        private c(String str) {
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

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.ji0$d[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.ji0$d[]) from 0x0028: INVOKE (r0v1 com.yandex.mobile.ads.impl.ji0$d[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
    public static final class d {
        /* JADX INFO: Fake field, exist only in values array */
        EF0(ViewHierarchyConstants.DIMENSION_TOP_KEY),
        /* JADX INFO: Fake field, exist only in values array */
        EF1("bottom"),
        c("topOffset");

        private final String b;

        static {
            EnumEntriesKt.enumEntries(dVarArr);
        }

        public static d valueOf(String str) {
            return (d) Enum.valueOf(d.class, str);
        }

        public static d[] values() {
            return (d[]) d.clone();
        }

        private d(String str) {
            super(str, i);
            this.b = str;
        }

        public final String a() {
            return this.b;
        }
    }

    private ji0(String str) {
        this.f9320a = str;
    }

    public /* synthetic */ ji0(String str, int i) {
        this(str);
    }

    public final String a() {
        return this.f9320a;
    }
}
