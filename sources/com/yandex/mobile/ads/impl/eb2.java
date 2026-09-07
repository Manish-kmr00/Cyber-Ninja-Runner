package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class eb2 implements bg2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f8782a;
    private final List<ru> b;
    private final Map<String, List<String>> c;
    private final mb2 d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final rh2 j;
    private final Integer k;
    private final String l;
    private final mk2 m;
    private final List<oa2> n;
    private final Map<String, List<String>> o;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f8783a;
        private final jd2 b;
        private mk2 c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private rh2 i;
        private Integer j;
        private String k;
        private final ArrayList l;
        private final ArrayList m;
        private final LinkedHashMap n;
        private mb2 o;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(Context context, boolean z) {
            this(z, new jd2(context));
            Intrinsics.checkNotNullParameter(context, "context");
        }

        public final void b(String impression) {
            Intrinsics.checkNotNullParameter(impression, "impression");
            LinkedHashMap linkedHashMap = this.n;
            Object arrayList = linkedHashMap.get("impression");
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put("impression", arrayList);
            }
            ((List) arrayList).add(impression);
        }

        public final a a(List list) {
            ArrayList arrayList = this.m;
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
            arrayList.addAll(list);
            return this;
        }

        public final a a(ArrayList arrayList) {
            this.l.addAll(arrayList);
            return this;
        }

        public final void a(String error) {
            Intrinsics.checkNotNullParameter(error, "error");
            LinkedHashMap linkedHashMap = this.n;
            Object arrayList = linkedHashMap.get("error");
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put("error", arrayList);
            }
            ((List) arrayList).add(error);
        }

        public final a h(String str) {
            this.h = str;
            return this;
        }

        public final a c(String str) {
            this.d = str;
            return this;
        }

        public final a d(String str) {
            this.e = str;
            return this;
        }

        public final a e(String str) {
            this.f = str;
            return this;
        }

        public final a g(String str) {
            this.g = str;
            return this;
        }

        public final a f(String str) {
            this.k = str;
            return this;
        }

        private a(boolean z, jd2 jd2Var) {
            this.f8783a = z;
            this.b = jd2Var;
            this.l = new ArrayList();
            this.m = new ArrayList();
            MapsKt.emptyMap();
            this.n = new LinkedHashMap();
            this.o = new mb2.a().a();
        }

        public final a a(Map<String, ? extends List<String>> map) {
            if (map == null) {
                map = MapsKt.emptyMap();
            }
            for (Map.Entry<String, ? extends List<String>> entry : map.entrySet()) {
                String key = entry.getKey();
                List<String> value = entry.getValue();
                if (value == null) {
                    value = CollectionsKt.emptyList();
                }
                for (String str : CollectionsKt.filterNotNull(value)) {
                    LinkedHashMap linkedHashMap = this.n;
                    Object arrayList = linkedHashMap.get(key);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        linkedHashMap.put(key, arrayList);
                    }
                    ((List) arrayList).add(str);
                }
            }
            return this;
        }

        public final eb2 a() {
            return new eb2(this.f8783a, this.l, this.n, this.o, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.c, this.m, this.b.a(this.n, this.i));
        }

        public final void a(Integer num) {
            this.j = num;
        }

        public final a a(mb2 videoAdExtensions) {
            Intrinsics.checkNotNullParameter(videoAdExtensions, "videoAdExtensions");
            this.o = videoAdExtensions;
            return this;
        }

        public final a a(rh2 viewableImpression) {
            Intrinsics.checkNotNullParameter(viewableImpression, "viewableImpression");
            this.i = viewableImpression;
            return this;
        }

        public final a a(mk2 mk2Var) {
            this.c = mk2Var;
            return this;
        }
    }

    public eb2(boolean z, ArrayList creatives, LinkedHashMap rawTrackingEvents, mb2 videoAdExtensions, String str, String str2, String str3, String str4, String str5, rh2 rh2Var, Integer num, String str6, mk2 mk2Var, ArrayList adVerifications, Map trackingEvents) {
        Intrinsics.checkNotNullParameter(creatives, "creatives");
        Intrinsics.checkNotNullParameter(rawTrackingEvents, "rawTrackingEvents");
        Intrinsics.checkNotNullParameter(videoAdExtensions, "videoAdExtensions");
        Intrinsics.checkNotNullParameter(adVerifications, "adVerifications");
        Intrinsics.checkNotNullParameter(trackingEvents, "trackingEvents");
        this.f8782a = z;
        this.b = creatives;
        this.c = rawTrackingEvents;
        this.d = videoAdExtensions;
        this.e = str;
        this.f = str2;
        this.g = str3;
        this.h = str4;
        this.i = str5;
        this.j = rh2Var;
        this.k = num;
        this.l = str6;
        this.m = mk2Var;
        this.n = adVerifications;
        this.o = trackingEvents;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eb2)) {
            return false;
        }
        eb2 eb2Var = (eb2) obj;
        return this.f8782a == eb2Var.f8782a && Intrinsics.areEqual(this.b, eb2Var.b) && Intrinsics.areEqual(this.c, eb2Var.c) && Intrinsics.areEqual(this.d, eb2Var.d) && Intrinsics.areEqual(this.e, eb2Var.e) && Intrinsics.areEqual(this.f, eb2Var.f) && Intrinsics.areEqual(this.g, eb2Var.g) && Intrinsics.areEqual(this.h, eb2Var.h) && Intrinsics.areEqual(this.i, eb2Var.i) && Intrinsics.areEqual(this.j, eb2Var.j) && Intrinsics.areEqual(this.k, eb2Var.k) && Intrinsics.areEqual(this.l, eb2Var.l) && Intrinsics.areEqual(this.m, eb2Var.m) && Intrinsics.areEqual(this.n, eb2Var.n) && Intrinsics.areEqual(this.o, eb2Var.o);
    }

    public final int hashCode() {
        int iHashCode = (this.d.hashCode() + ((this.c.hashCode() + aa.a(this.b, Boolean.hashCode(this.f8782a) * 31, 31)) * 31)) * 31;
        String str = this.e;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.g;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.h;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.i;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        rh2 rh2Var = this.j;
        int iHashCode7 = (iHashCode6 + (rh2Var == null ? 0 : rh2Var.hashCode())) * 31;
        Integer num = this.k;
        int iHashCode8 = (iHashCode7 + (num == null ? 0 : num.hashCode())) * 31;
        String str6 = this.l;
        int iHashCode9 = (iHashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        mk2 mk2Var = this.m;
        return this.o.hashCode() + aa.a(this.n, (iHashCode9 + (mk2Var != null ? mk2Var.hashCode() : 0)) * 31, 31);
    }

    public final String toString() {
        return "VideoAd(isWrapper=" + this.f8782a + ", creatives=" + this.b + ", rawTrackingEvents=" + this.c + ", videoAdExtensions=" + this.d + ", adSystem=" + this.e + ", adTitle=" + this.f + ", description=" + this.g + ", survey=" + this.h + ", vastAdTagUri=" + this.i + ", viewableImpression=" + this.j + ", sequence=" + this.k + ", id=" + this.l + ", wrapperConfiguration=" + this.m + ", adVerifications=" + this.n + ", trackingEvents=" + this.o + ")";
    }

    public final boolean o() {
        return this.f8782a;
    }

    public final List<ru> e() {
        return this.b;
    }

    public final Map<String, List<String>> h() {
        return this.c;
    }

    public final mb2 l() {
        return this.d;
    }

    public final String b() {
        return this.e;
    }

    public final String c() {
        return this.f;
    }

    public final String f() {
        return this.g;
    }

    public final String j() {
        return this.h;
    }

    public final String k() {
        return this.i;
    }

    public final rh2 m() {
        return this.j;
    }

    public final Integer i() {
        return this.k;
    }

    public final String g() {
        return this.l;
    }

    public final mk2 n() {
        return this.m;
    }

    public final List<oa2> d() {
        return this.n;
    }

    @Override // com.yandex.mobile.ads.impl.bg2
    public final Map<String, List<String>> a() {
        return this.o;
    }
}
