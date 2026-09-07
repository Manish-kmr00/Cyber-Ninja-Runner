package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class jw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9352a;
    private final String b;
    private final List<mx> c;
    private final String d;
    private final String e;
    private final a f;

    public jw(String str, String adapterName, ArrayList parameters, String str2, String str3, a type) {
        Intrinsics.checkNotNullParameter(adapterName, "adapterName");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(type, "type");
        this.f9352a = str;
        this.b = adapterName;
        this.c = parameters;
        this.d = str2;
        this.e = str3;
        this.f = type;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof jw)) {
            return false;
        }
        jw jwVar = (jw) obj;
        return Intrinsics.areEqual(this.f9352a, jwVar.f9352a) && Intrinsics.areEqual(this.b, jwVar.b) && Intrinsics.areEqual(this.c, jwVar.c) && Intrinsics.areEqual(this.d, jwVar.d) && Intrinsics.areEqual(this.e, jwVar.e) && Intrinsics.areEqual(this.f, jwVar.f);
    }

    public final int hashCode() {
        String str = this.f9352a;
        int iA = aa.a(this.c, v3.a(this.b, (str == null ? 0 : str.hashCode()) * 31, 31), 31);
        String str2 = this.d;
        int iHashCode = (iA + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.e;
        return this.f.hashCode() + ((iHashCode + (str3 != null ? str3.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "DebugPanelAdUnitMediationAdapterData(logoUrl=" + this.f9352a + ", adapterName=" + this.b + ", parameters=" + this.c + ", adUnitId=" + this.d + ", networkAdUnitIdName=" + this.e + ", type=" + this.f + ")";
    }

    public final String c() {
        return this.f9352a;
    }

    public final String b() {
        return this.b;
    }

    public final List<mx> e() {
        return this.c;
    }

    public final String a() {
        return this.d;
    }

    public final String d() {
        return this.e;
    }

    public final a f() {
        return this.f;
    }

    public interface a {

        /* JADX INFO: renamed from: com.yandex.mobile.ads.impl.jw$a$a, reason: collision with other inner class name */
        public static final class C0749a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0749a f9353a = new C0749a();

            private C0749a() {
            }
        }

        public static final class b implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final jy f9354a;
            private final List<iy> b;

            public b(jy jyVar, List<iy> cpmFloors) {
                Intrinsics.checkNotNullParameter(cpmFloors, "cpmFloors");
                this.f9354a = jyVar;
                this.b = cpmFloors;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                return Intrinsics.areEqual(this.f9354a, bVar.f9354a) && Intrinsics.areEqual(this.b, bVar.b);
            }

            public final int hashCode() {
                jy jyVar = this.f9354a;
                return this.b.hashCode() + ((jyVar == null ? 0 : jyVar.hashCode()) * 31);
            }

            public final String toString() {
                return "Waterfall(currency=" + this.f9354a + ", cpmFloors=" + this.b + ")";
            }

            public final List<iy> a() {
                return this.b;
            }
        }
    }
}
