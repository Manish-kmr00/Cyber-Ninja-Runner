package com.yandex.mobile.ads.impl;

import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
public final class aw0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8444a;
    private final String b;
    private final b c;
    private final String d;
    private final String e;
    private final Float f;
    private final int g;
    private final int h;
    private final int i;
    private final String j;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.aw0$b[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.aw0$b[]) from 0x001a: INVOKE (r0v1 com.yandex.mobile.ads.impl.aw0$b[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
        EF7("streaming"),
        /* JADX INFO: Fake field, exist only in values array */
        EF17("progressive");

        private final String b;

        static {
            EnumEntriesKt.enumEntries(bVarArr);
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) c.clone();
        }

        private b(String str) {
            super(str, i);
            this.b = str;
        }

        public final String a() {
            return this.b;
        }
    }

    public aw0(String uri, String str, b bVar, String str2, String str3, Float f, int i, int i2, int i3, String str4) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.f8444a = uri;
        this.b = str;
        this.c = bVar;
        this.d = str2;
        this.e = str3;
        this.f = f;
        this.g = i;
        this.h = i2;
        this.i = i3;
        this.j = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof aw0)) {
            return false;
        }
        aw0 aw0Var = (aw0) obj;
        return Intrinsics.areEqual(this.f8444a, aw0Var.f8444a) && Intrinsics.areEqual(this.b, aw0Var.b) && this.c == aw0Var.c && Intrinsics.areEqual(this.d, aw0Var.d) && Intrinsics.areEqual(this.e, aw0Var.e) && Intrinsics.areEqual((Object) this.f, (Object) aw0Var.f) && this.g == aw0Var.g && this.h == aw0Var.h && this.i == aw0Var.i && Intrinsics.areEqual(this.j, aw0Var.j);
    }

    public final int hashCode() {
        int iHashCode = this.f8444a.hashCode() * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        b bVar = this.c;
        int iHashCode3 = (iHashCode2 + (bVar == null ? 0 : bVar.hashCode())) * 31;
        String str2 = this.d;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.e;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Float f = this.f;
        int iA = wx1.a(this.i, wx1.a(this.h, wx1.a(this.g, (iHashCode5 + (f == null ? 0 : f.hashCode())) * 31, 31), 31), 31);
        String str4 = this.j;
        return iA + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        return "MediaFile(uri=" + this.f8444a + ", id=" + this.b + ", deliveryMethod=" + this.c + ", mimeType=" + this.d + ", codec=" + this.e + ", vmafMetric=" + this.f + ", height=" + this.g + ", width=" + this.h + ", bitrate=" + this.i + ", apiFramework=" + this.j + ")";
    }

    public final String f() {
        return this.f8444a;
    }

    public final String e() {
        return this.d;
    }

    public final String c() {
        return this.e;
    }

    public final Float g() {
        return this.f;
    }

    public final int d() {
        return this.g;
    }

    public final int h() {
        return this.h;
    }

    public final int b() {
        return this.i;
    }

    public final String a() {
        return this.j;
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8445a;
        private String b;
        private b c;
        private String d;
        private String e;
        private Float f;
        private int g;
        private int h;
        private int i;
        private String j;

        public a(String uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            this.f8445a = uri;
        }

        public final a d(String str) {
            for (b bVar : b.values()) {
                if (Intrinsics.areEqual(bVar.a(), str)) {
                    this.c = bVar;
                    return this;
                }
            }
            bVar = null;
            this.c = bVar;
            return this;
        }

        public final a f(String str) {
            this.b = str;
            return this;
        }

        public final a i(String str) {
            Integer intOrNull;
            if (str != null && (intOrNull = StringsKt.toIntOrNull(str)) != null) {
                this.h = intOrNull.intValue();
            }
            return this;
        }

        public final a e(String str) {
            Integer intOrNull;
            if (str != null && (intOrNull = StringsKt.toIntOrNull(str)) != null) {
                this.g = intOrNull.intValue();
            }
            return this;
        }

        public final a b(String str) {
            Integer intOrNull;
            if (str != null && (intOrNull = StringsKt.toIntOrNull(str)) != null) {
                this.i = intOrNull.intValue();
            }
            return this;
        }

        public final a a(String str) {
            this.j = str;
            return this;
        }

        public final aw0 a() {
            return new aw0(this.f8445a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
        }

        public final a c(String str) {
            this.e = str;
            return this;
        }

        public final a h(String str) {
            this.f = str != null ? StringsKt.toFloatOrNull(str) : null;
            return this;
        }

        public final a g(String str) {
            this.d = str;
            return this;
        }
    }
}
