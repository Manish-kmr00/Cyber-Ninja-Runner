package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class fy {

    public static final class f extends fy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8948a;
        private final yx b;
        private final ww c;

        public final String a() {
            return this.f8948a;
        }

        public final yx b() {
            return this.b;
        }

        public final ww c() {
            return this.c;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return Intrinsics.areEqual(this.f8948a, fVar.f8948a) && Intrinsics.areEqual(this.b, fVar.b) && Intrinsics.areEqual(this.c, fVar.c);
        }

        public final int hashCode() {
            String str = this.f8948a;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            yx yxVar = this.b;
            int iHashCode2 = (iHashCode + (yxVar == null ? 0 : yxVar.hashCode())) * 31;
            ww wwVar = this.c;
            return iHashCode2 + (wwVar != null ? wwVar.hashCode() : 0);
        }

        public final String toString() {
            return "KeyValue(title=" + this.f8948a + ", subtitle=" + this.b + ", text=" + this.c + ")";
        }

        public /* synthetic */ f(String str, yx yxVar) {
            this(str, yxVar, null);
        }

        public f(String str, yx yxVar, ww wwVar) {
            super(0);
            this.f8948a = str;
            this.b = yxVar;
            this.c = wwVar;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public f(String title, String text) {
            this(title, new yx(text, 0, null, 0, 14));
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(text, "text");
        }
    }

    private fy() {
    }

    public /* synthetic */ fy(int i) {
        this();
    }

    public boolean a(Object obj) {
        return equals(obj);
    }

    public static final class e extends fy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8947a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String text) {
            super(0);
            Intrinsics.checkNotNullParameter(text, "text");
            this.f8947a = text;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && Intrinsics.areEqual(this.f8947a, ((e) obj).f8947a);
        }

        public final int hashCode() {
            return this.f8947a.hashCode();
        }

        public final String toString() {
            return "Header(text=" + this.f8947a + ")";
        }

        public final String a() {
            return this.f8947a;
        }
    }

    public static final class g extends fy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8949a;
        private final String b;
        private final yx c;
        private final ww d;
        private final String e;
        private final String f;
        private final String g;
        private final List<mx> h;
        private final List<iy> i;
        private final pw j;
        private final String k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String name, String str, yx yxVar, ww infoSecond, String str2, String str3, String str4, List<mx> list, List<iy> list2, pw type, String str5) {
            super(0);
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(infoSecond, "infoSecond");
            Intrinsics.checkNotNullParameter(type, "type");
            this.f8949a = name;
            this.b = str;
            this.c = yxVar;
            this.d = infoSecond;
            this.e = str2;
            this.f = str3;
            this.g = str4;
            this.h = list;
            this.i = list2;
            this.j = type;
            this.k = str5;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return Intrinsics.areEqual(this.f8949a, gVar.f8949a) && Intrinsics.areEqual(this.b, gVar.b) && Intrinsics.areEqual(this.c, gVar.c) && Intrinsics.areEqual(this.d, gVar.d) && Intrinsics.areEqual(this.e, gVar.e) && Intrinsics.areEqual(this.f, gVar.f) && Intrinsics.areEqual(this.g, gVar.g) && Intrinsics.areEqual(this.h, gVar.h) && Intrinsics.areEqual(this.i, gVar.i) && this.j == gVar.j && Intrinsics.areEqual(this.k, gVar.k);
        }

        public final int hashCode() {
            int iHashCode = this.f8949a.hashCode() * 31;
            String str = this.b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            yx yxVar = this.c;
            int iHashCode3 = (this.d.hashCode() + ((iHashCode2 + (yxVar == null ? 0 : yxVar.hashCode())) * 31)) * 31;
            String str2 = this.e;
            int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f;
            int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.g;
            int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
            List<mx> list = this.h;
            int iHashCode7 = (iHashCode6 + (list == null ? 0 : list.hashCode())) * 31;
            List<iy> list2 = this.i;
            int iHashCode8 = (this.j.hashCode() + ((iHashCode7 + (list2 == null ? 0 : list2.hashCode())) * 31)) * 31;
            String str5 = this.k;
            return iHashCode8 + (str5 != null ? str5.hashCode() : 0);
        }

        public final String toString() {
            return "MediationAdapter(name=" + this.f8949a + ", logoUrl=" + this.b + ", infoFirst=" + this.c + ", infoSecond=" + this.d + ", waringMessage=" + this.e + ", adUnitId=" + this.f + ", networkAdUnitIdName=" + this.g + ", parameters=" + this.h + ", cpmFloors=" + this.i + ", type=" + this.j + ", sdk=" + this.k + ")";
        }

        public final String f() {
            return this.f8949a;
        }

        public final String e() {
            return this.b;
        }

        public final yx c() {
            return this.c;
        }

        public final ww d() {
            return this.d;
        }

        public final String j() {
            return this.e;
        }

        public final String a() {
            return this.f;
        }

        public final String g() {
            return this.g;
        }

        public final List<mx> h() {
            return this.h;
        }

        public final List<iy> b() {
            return this.i;
        }

        public final pw i() {
            return this.j;
        }

        public /* synthetic */ g(String str, String str2, yx yxVar, ww wwVar, String str3, String str4, String str5, List list, List list2, pw pwVar, String str6, int i) {
            this(str, str2, yxVar, wwVar, str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : list, (i & 256) != 0 ? null : list2, (i & 512) != 0 ? pw.e : pwVar, (i & 1024) != 0 ? null : str6);
        }
    }

    public static final class d extends fy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f8946a = new d();

        private d() {
            super(0);
        }
    }

    public static final class b extends fy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f8944a = new b();

        private b() {
            super(0);
        }
    }

    public static final class a extends fy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8943a;
        private final String b;
        private final String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String name, String format, String id) {
            super(0);
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(id, "id");
            this.f8943a = name;
            this.b = format;
            this.c = id;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.f8943a, aVar.f8943a) && Intrinsics.areEqual(this.b, aVar.b) && Intrinsics.areEqual(this.c, aVar.c);
        }

        public final int hashCode() {
            return this.c.hashCode() + v3.a(this.b, this.f8943a.hashCode() * 31, 31);
        }

        public final String toString() {
            return "AdUnit(name=" + this.f8943a + ", format=" + this.b + ", id=" + this.c + ")";
        }

        public final String c() {
            return this.f8943a;
        }

        public final String a() {
            return this.b;
        }

        public final String b() {
            return this.c;
        }
    }

    public static final class c extends fy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8945a;
        private final a b;

        /* JADX WARN: Enum visitor error
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.fy$c$a[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.fy$c$a[]) from 0x000d: INVOKE (r0v1 com.yandex.mobile.ads.impl.fy$c$a[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
        public static final class a {
            TEST_MODE;

            static {
                EnumEntriesKt.enumEntries(aVarArr);
            }

            public static a valueOf(String str) {
                return (a) Enum.valueOf(a.class, str);
            }

            public static a[] values() {
                return (a[]) c.clone();
            }

            private a() {
                super("TEST_MODE", 0);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c() {
            super(0);
            a actionType = a.TEST_MODE;
            Intrinsics.checkNotNullParameter("Enable Test mode", "text");
            Intrinsics.checkNotNullParameter(actionType, "actionType");
            this.f8945a = "Enable Test mode";
            this.b = actionType;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return Intrinsics.areEqual(this.f8945a, cVar.f8945a) && this.b == cVar.b;
        }

        public final int hashCode() {
            return this.b.hashCode() + (this.f8945a.hashCode() * 31);
        }

        public final String toString() {
            return "Button(text=" + this.f8945a + ", actionType=" + this.b + ")";
        }

        public final String b() {
            return this.f8945a;
        }

        public final a a() {
            return this.b;
        }
    }

    public static final class h extends fy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8950a;
        private final a b;
        private final boolean c;

        /* JADX WARN: Enum visitor error
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.fy$h$a[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.fy$h$a[]) from 0x000d: INVOKE (r0v1 com.yandex.mobile.ads.impl.fy$h$a[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
        public static final class a {
            DEBUG_ERROR_INDICATOR;

            static {
                EnumEntriesKt.enumEntries(aVarArr);
            }

            public static a valueOf(String str) {
                return (a) Enum.valueOf(a.class, str);
            }

            public static a[] values() {
                return (a[]) c.clone();
            }

            private a() {
                super("DEBUG_ERROR_INDICATOR", 0);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(boolean z) {
            super(0);
            a switchType = a.DEBUG_ERROR_INDICATOR;
            Intrinsics.checkNotNullParameter("Debug Error Indicator", "text");
            Intrinsics.checkNotNullParameter(switchType, "switchType");
            this.f8950a = "Debug Error Indicator";
            this.b = switchType;
            this.c = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return Intrinsics.areEqual(this.f8950a, hVar.f8950a) && this.b == hVar.b && this.c == hVar.c;
        }

        public final int hashCode() {
            return Boolean.hashCode(this.c) + ((this.b.hashCode() + (this.f8950a.hashCode() * 31)) * 31);
        }

        public final String toString() {
            return "Switch(text=" + this.f8950a + ", switchType=" + this.b + ", initialState=" + this.c + ")";
        }

        public final String c() {
            return this.f8950a;
        }

        public final a b() {
            return this.b;
        }

        public final boolean a() {
            return this.c;
        }

        @Override // com.yandex.mobile.ads.impl.fy
        public final boolean a(Object obj) {
            if (obj instanceof h) {
                h hVar = (h) obj;
                if (Intrinsics.areEqual(this.f8950a, hVar.f8950a) && this.b == hVar.b) {
                    return true;
                }
            }
            return false;
        }
    }
}
