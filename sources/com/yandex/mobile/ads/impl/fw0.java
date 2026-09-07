package com.yandex.mobile.ads.impl;

import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes9.dex */
public final class fw0 implements jm {
    public static final jm.a<fw0> h;
    public final String b;
    public final g c;
    public final e d;
    public final iw0 e;
    public final c f;
    public final h g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f8930a;
        private Uri b;
        private String f;
        private b.a c = new b.a();
        private d.a d = new d.a();
        private List<p22> e = Collections.emptyList();
        private hk0<j> g = hk0.h();
        private e.a h = new e.a();
        private h i = h.d;

        public final a b(String str) {
            str.getClass();
            this.f8930a = str;
            return this;
        }

        public final fw0 a() {
            g gVar;
            d.a aVar = this.d;
            aVar.getClass();
            Uri uri = this.b;
            if (uri != null) {
                aVar.getClass();
                gVar = new g(uri, null, null, this.e, this.f, this.g, null);
            } else {
                gVar = null;
            }
            String str = this.f8930a;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            b.a aVar2 = this.c;
            aVar2.getClass();
            return new fw0(str2, new c(aVar2), gVar, this.h.a(), iw0.H, this.i);
        }

        public final a a(String str) {
            this.f = str;
            return this;
        }

        public final a a(List<p22> list) {
            List<p22> listEmptyList;
            if (list != null && !list.isEmpty()) {
                listEmptyList = Collections.unmodifiableList(new ArrayList(list));
            } else {
                listEmptyList = Collections.emptyList();
            }
            this.e = listEmptyList;
            return this;
        }

        public final a a(Uri uri) {
            this.b = uri;
            return this;
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f8935a;
        public final String b;
        public final d c;
        public final List<p22> d;
        public final String e;
        public final hk0<j> f;
        public final Object g;

        /* JADX WARN: Multi-variable type inference failed */
        private f(Uri uri, String str, d dVar, List list, String str2, hk0 hk0Var, Object obj) {
            this.f8935a = uri;
            this.b = str;
            this.c = dVar;
            this.d = list;
            this.e = str2;
            this.f = hk0Var;
            hk0.a aVarG = hk0.g();
            for (int i = 0; i < hk0Var.size(); i++) {
                aVarG.b(((j) hk0Var.get(i)).a().a());
            }
            aVarG.a();
            this.g = obj;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.f8935a.equals(fVar.f8935a) && x82.a(this.b, fVar.b) && x82.a(this.c, fVar.c) && x82.a((Object) null, (Object) null) && this.d.equals(fVar.d) && x82.a(this.e, fVar.e) && this.f.equals(fVar.f) && x82.a(this.g, fVar.g);
        }

        public final int hashCode() {
            int iHashCode = this.f8935a.hashCode() * 31;
            String str = this.b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            d dVar = this.c;
            int iHashCode3 = (this.d.hashCode() + ((iHashCode2 + (dVar == null ? 0 : dVar.hashCode())) * 961)) * 31;
            String str2 = this.e;
            int iHashCode4 = (this.f.hashCode() + ((iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31)) * 31;
            Object obj = this.g;
            return iHashCode4 + (obj != null ? obj.hashCode() : 0);
        }
    }

    @Deprecated
    public static final class g extends f {
        private g(Uri uri, String str, d dVar, List list, String str2, hk0 hk0Var, Object obj) {
            super(uri, str, dVar, list, str2, hk0Var, obj);
        }
    }

    static {
        new d.a();
        Collections.emptyList();
        hk0.h();
        e.a aVar = new e.a();
        h hVar = h.d;
        aVar.a();
        iw0 iw0Var = iw0.H;
        h = new jm.a() { // from class: com.yandex.mobile.ads.impl.fw0$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.jm.a
            public final jm fromBundle(Bundle bundle) {
                return fw0.a(bundle);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static fw0 a(Bundle bundle) {
        String string = bundle.getString(Integer.toString(0, 36), "");
        string.getClass();
        Bundle bundle2 = bundle.getBundle(Integer.toString(1, 36));
        e eVar = bundle2 == null ? e.g : (e) e.h.fromBundle(bundle2);
        Bundle bundle3 = bundle.getBundle(Integer.toString(2, 36));
        iw0 iw0Var = bundle3 == null ? iw0.H : (iw0) iw0.I.fromBundle(bundle3);
        Bundle bundle4 = bundle.getBundle(Integer.toString(3, 36));
        c cVar = bundle4 == null ? c.h : (c) b.g.fromBundle(bundle4);
        Bundle bundle5 = bundle.getBundle(Integer.toString(4, 36));
        return new fw0(string, cVar, null, eVar, iw0Var, bundle5 == null ? h.d : (h) h.e.fromBundle(bundle5));
    }

    public static fw0 a(String str) {
        g gVar;
        b.a aVar = new b.a();
        new d.a();
        List listEmptyList = Collections.emptyList();
        hk0 hk0VarH = hk0.h();
        h hVar = h.d;
        Uri uri = str == null ? null : Uri.parse(str);
        if (uri != null) {
            gVar = new g(uri, null, null, listEmptyList, null, hk0VarH, null);
        } else {
            gVar = null;
        }
        return new fw0("", new c(aVar), gVar, new e(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, -3.4028235E38f, -3.4028235E38f), iw0.H, hVar);
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UUID f8932a;
        public final Uri b;
        public final ik0<String, String> c;
        public final boolean d;
        public final boolean e;
        public final boolean f;
        public final hk0<Integer> g;
        private final byte[] h;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private ik0<String, String> f8933a;
            private hk0<Integer> b;

            @Deprecated
            private a() {
                this.f8933a = ik0.g();
                this.b = hk0.h();
            }
        }

        private d(a aVar) {
            aVar.getClass();
            aVar.getClass();
            this.f8932a = (UUID) hg.a((Object) null);
            aVar.getClass();
            this.b = null;
            this.c = aVar.f8933a;
            aVar.getClass();
            this.d = false;
            aVar.getClass();
            this.f = false;
            aVar.getClass();
            this.e = false;
            this.g = aVar.b;
            aVar.getClass();
            this.h = null;
        }

        public final byte[] a() {
            byte[] bArr = this.h;
            if (bArr != null) {
                return Arrays.copyOf(bArr, bArr.length);
            }
            return null;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f8932a.equals(dVar.f8932a) && x82.a(this.b, dVar.b) && x82.a(this.c, dVar.c) && this.d == dVar.d && this.f == dVar.f && this.e == dVar.e && this.g.equals(dVar.g) && Arrays.equals(this.h, dVar.h);
        }

        public final int hashCode() {
            int iHashCode = this.f8932a.hashCode() * 31;
            Uri uri = this.b;
            return Arrays.hashCode(this.h) + ((this.g.hashCode() + ((((((((this.c.hashCode() + ((iHashCode + (uri != null ? uri.hashCode() : 0)) * 31)) * 31) + (this.d ? 1 : 0)) * 31) + (this.f ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31)) * 31);
        }
    }

    public static final class e implements jm {
        public static final e g = new e(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, -3.4028235E38f, -3.4028235E38f);
        public static final jm.a<e> h = new jm.a() { // from class: com.yandex.mobile.ads.impl.fw0$e$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.jm.a
            public final jm fromBundle(Bundle bundle) {
                return fw0.e.a(bundle);
            }
        };
        public final long b;
        public final long c;
        public final long d;
        public final float e;
        public final float f;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private long f8934a = -9223372036854775807L;
            private long b = -9223372036854775807L;
            private long c = -9223372036854775807L;
            private float d = -3.4028235E38f;
            private float e = -3.4028235E38f;

            public final e a() {
                return new e(this.f8934a, this.b, this.c, this.d, this.e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static e a(Bundle bundle) {
            return new e(bundle.getLong(Integer.toString(0, 36), -9223372036854775807L), bundle.getLong(Integer.toString(1, 36), -9223372036854775807L), bundle.getLong(Integer.toString(2, 36), -9223372036854775807L), bundle.getFloat(Integer.toString(3, 36), -3.4028235E38f), bundle.getFloat(Integer.toString(4, 36), -3.4028235E38f));
        }

        @Deprecated
        public e(long j, long j2, long j3, float f, float f2) {
            this.b = j;
            this.c = j2;
            this.d = j3;
            this.e = f;
            this.f = f2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return this.b == eVar.b && this.c == eVar.c && this.d == eVar.d && this.e == eVar.e && this.f == eVar.f;
        }

        public final int hashCode() {
            long j = this.b;
            long j2 = this.c;
            int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.d;
            int i2 = (i + ((int) ((j3 >>> 32) ^ j3))) * 31;
            float f = this.e;
            int iFloatToIntBits = (i2 + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31;
            float f2 = this.f;
            return iFloatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0);
        }
    }

    public static class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f8937a;
        public final String b;
        public final String c;
        public final int d;
        public final int e;
        public final String f;
        public final String g;

        public final a a() {
            return new a();
        }

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private Uri f8938a;
            private String b;
            private String c;
            private int d;
            private int e;
            private String f;
            private String g;

            /* JADX INFO: Access modifiers changed from: private */
            public i a() {
                return new i(this);
            }

            private a(j jVar) {
                this.f8938a = jVar.f8937a;
                this.b = jVar.b;
                this.c = jVar.c;
                this.d = jVar.d;
                this.e = jVar.e;
                this.f = jVar.f;
                this.g = jVar.g;
            }
        }

        private j(a aVar) {
            this.f8937a = aVar.f8938a;
            this.b = aVar.b;
            this.c = aVar.c;
            this.d = aVar.d;
            this.e = aVar.e;
            this.f = aVar.f;
            this.g = aVar.g;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            return this.f8937a.equals(jVar.f8937a) && x82.a(this.b, jVar.b) && x82.a(this.c, jVar.c) && this.d == jVar.d && this.e == jVar.e && x82.a(this.f, jVar.f) && x82.a(this.g, jVar.g);
        }

        public final int hashCode() {
            int iHashCode = this.f8937a.hashCode() * 31;
            String str = this.b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.c;
            int iHashCode3 = (((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.d) * 31) + this.e) * 31;
            String str3 = this.f;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.g;
            return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
        }
    }

    @Deprecated
    public static final class i extends j {
        private i(j.a aVar) {
            super(aVar);
        }
    }

    public static class b implements jm {
        public static final jm.a<c> g = new jm.a() { // from class: com.yandex.mobile.ads.impl.fw0$b$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.jm.a
            public final jm fromBundle(Bundle bundle) {
                return fw0.b.a(bundle);
            }
        };
        public final long b;
        public final long c;
        public final boolean d;
        public final boolean e;
        public final boolean f;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private long f8931a;
            private long b = Long.MIN_VALUE;
            private boolean c;
            private boolean d;
            private boolean e;
        }

        private b(a aVar) {
            this.b = aVar.f8931a;
            this.c = aVar.b;
            this.d = aVar.c;
            this.e = aVar.d;
            this.f = aVar.e;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.b == bVar.b && this.c == bVar.c && this.d == bVar.d && this.e == bVar.e && this.f == bVar.f;
        }

        public final int hashCode() {
            long j = this.b;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            long j2 = this.c;
            return ((((((i + ((int) ((j2 >>> 32) ^ j2))) * 31) + (this.d ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31) + (this.f ? 1 : 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static c a(Bundle bundle) {
            a aVar = new a();
            long j = bundle.getLong(Integer.toString(0, 36), 0L);
            if (j >= 0) {
                aVar.f8931a = j;
                long j2 = bundle.getLong(Integer.toString(1, 36), Long.MIN_VALUE);
                if (j2 != Long.MIN_VALUE && j2 < 0) {
                    throw new IllegalArgumentException();
                }
                aVar.b = j2;
                aVar.c = bundle.getBoolean(Integer.toString(2, 36), false);
                aVar.d = bundle.getBoolean(Integer.toString(3, 36), false);
                aVar.e = bundle.getBoolean(Integer.toString(4, 36), false);
                return new c(aVar);
            }
            throw new IllegalArgumentException();
        }
    }

    @Deprecated
    public static final class c extends b {
        public static final c h = new c(new b.a());

        private c(b.a aVar) {
            super(aVar);
        }
    }

    public static final class h implements jm {
        public static final h d = new h(new a());
        public static final jm.a<h> e = new jm.a() { // from class: com.yandex.mobile.ads.impl.fw0$h$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.jm.a
            public final jm fromBundle(Bundle bundle) {
                return fw0.h.a(bundle);
            }
        };
        public final Uri b;
        public final String c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private Uri f8936a;
            private String b;
            private Bundle c;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static h a(Bundle bundle) {
            a aVar = new a();
            aVar.f8936a = (Uri) bundle.getParcelable(Integer.toString(0, 36));
            aVar.b = bundle.getString(Integer.toString(1, 36));
            aVar.c = bundle.getBundle(Integer.toString(2, 36));
            return new h(aVar);
        }

        private h(a aVar) {
            this.b = aVar.f8936a;
            this.c = aVar.b;
            Bundle unused = aVar.c;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return x82.a(this.b, hVar.b) && x82.a(this.c, hVar.c);
        }

        public final int hashCode() {
            Uri uri = this.b;
            int iHashCode = (uri == null ? 0 : uri.hashCode()) * 31;
            String str = this.c;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }
    }

    private fw0(String str, c cVar, g gVar, e eVar, iw0 iw0Var, h hVar) {
        this.b = str;
        this.c = gVar;
        this.d = eVar;
        this.e = iw0Var;
        this.f = cVar;
        this.g = hVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fw0)) {
            return false;
        }
        fw0 fw0Var = (fw0) obj;
        return x82.a(this.b, fw0Var.b) && this.f.equals(fw0Var.f) && x82.a(this.c, fw0Var.c) && x82.a(this.d, fw0Var.d) && x82.a(this.e, fw0Var.e) && x82.a(this.g, fw0Var.g);
    }

    public final int hashCode() {
        int iHashCode = this.b.hashCode() * 31;
        g gVar = this.c;
        return this.g.hashCode() + ((this.e.hashCode() + ((this.f.hashCode() + ((this.d.hashCode() + ((iHashCode + (gVar != null ? gVar.hashCode() : 0)) * 31)) * 31)) * 31)) * 31);
    }
}
