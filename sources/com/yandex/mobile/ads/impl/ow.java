package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class ow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9865a;
    private final String b;
    private final boolean c;
    private final String d;
    private final String e;
    private final String f;
    private final a g;
    private final List<String> h;

    public ow(String name, String str, boolean z, String str2, String str3, String str4, a adapterStatus, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(adapterStatus, "adapterStatus");
        this.f9865a = name;
        this.b = str;
        this.c = z;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = adapterStatus;
        this.h = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ow)) {
            return false;
        }
        ow owVar = (ow) obj;
        return Intrinsics.areEqual(this.f9865a, owVar.f9865a) && Intrinsics.areEqual(this.b, owVar.b) && this.c == owVar.c && Intrinsics.areEqual(this.d, owVar.d) && Intrinsics.areEqual(this.e, owVar.e) && Intrinsics.areEqual(this.f, owVar.f) && Intrinsics.areEqual(this.g, owVar.g) && Intrinsics.areEqual(this.h, owVar.h);
    }

    public final int hashCode() {
        int iHashCode = this.f9865a.hashCode() * 31;
        String str = this.b;
        int iA = a7.a(this.c, (iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31);
        String str2 = this.d;
        int iHashCode2 = (iA + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.e;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f;
        int iHashCode4 = (this.g.hashCode() + ((iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31)) * 31;
        List<String> list = this.h;
        return iHashCode4 + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        return "DebugPanelAdapterData(name=" + this.f9865a + ", logoUrl=" + this.b + ", adapterIntegrationStatus=" + this.c + ", adapterVersion=" + this.d + ", latestAdapterVersion=" + this.e + ", sdkVersion=" + this.f + ", adapterStatus=" + this.g + ", formats=" + this.h + ")";
    }

    public final String e() {
        return this.f9865a;
    }

    public final String d() {
        return this.b;
    }

    public final String b() {
        return this.d;
    }

    public final String c() {
        return this.e;
    }

    public final String f() {
        return this.f;
    }

    public final a a() {
        return this.g;
    }

    public interface a {

        /* JADX INFO: renamed from: com.yandex.mobile.ads.impl.ow$a$a, reason: collision with other inner class name */
        public static final class C0753a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0753a f9866a = new C0753a();

            private C0753a() {
            }
        }

        public static final class b implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final oz0 f9867a;

            public b() {
                oz0 error = oz0.INVALID_MEDIATION_ADAPTER_VERSION;
                Intrinsics.checkNotNullParameter(error, "error");
                this.f9867a = error;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof b) && this.f9867a == ((b) obj).f9867a;
            }

            public final int hashCode() {
                return this.f9867a.hashCode();
            }

            public final String toString() {
                return "InvalidIntegration(error=" + this.f9867a + ")";
            }

            public final oz0 a() {
                return this.f9867a;
            }
        }

        public static final class c implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f9868a = new c();

            private c() {
            }
        }
    }
}
