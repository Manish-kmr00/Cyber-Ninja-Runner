package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ru implements bg2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<aw0> f10140a;
    private final List<ji0> b;
    private final List<e62> c;
    private final uu d;
    private final String e;
    private final lz1 f;
    private final String g;
    private final int h;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ArrayList f10141a = new ArrayList();
        private final ArrayList b = new ArrayList();
        private final ArrayList c = new ArrayList();
        private uu d;
        private String e;
        private lz1 f;
        private String g;
        private int h;

        public final a a(List list) {
            ArrayList arrayList = this.b;
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
            arrayList.addAll(list);
            return this;
        }

        public final a b(List list) {
            ArrayList arrayList = this.f10141a;
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
            arrayList.addAll(list);
            return this;
        }

        public final void a(e62 trackingEvent) {
            Intrinsics.checkNotNullParameter(trackingEvent, "trackingEvent");
            this.c.add(trackingEvent);
        }

        public final a b(String str) {
            this.g = str;
            return this;
        }

        public final a c(List<e62> list) {
            ArrayList arrayList = this.c;
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
            arrayList.addAll(list);
            return this;
        }

        public final a a(String str) {
            this.e = str;
            return this;
        }

        public final void a(uu creativeExtensions) {
            Intrinsics.checkNotNullParameter(creativeExtensions, "creativeExtensions");
            this.d = creativeExtensions;
        }

        public final a a(int i) {
            this.h = i;
            return this;
        }

        public final a a(lz1 lz1Var) {
            this.f = lz1Var;
            return this;
        }

        public final ru a() {
            return new ru(this.f10141a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        }
    }

    public ru(ArrayList mediaFiles, ArrayList icons, ArrayList trackingEventsList, uu uuVar, String str, lz1 lz1Var, String str2, int i) {
        Intrinsics.checkNotNullParameter(mediaFiles, "mediaFiles");
        Intrinsics.checkNotNullParameter(icons, "icons");
        Intrinsics.checkNotNullParameter(trackingEventsList, "trackingEventsList");
        this.f10140a = mediaFiles;
        this.b = icons;
        this.c = trackingEventsList;
        this.d = uuVar;
        this.e = str;
        this.f = lz1Var;
        this.g = str2;
        this.h = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ru)) {
            return false;
        }
        ru ruVar = (ru) obj;
        return Intrinsics.areEqual(this.f10140a, ruVar.f10140a) && Intrinsics.areEqual(this.b, ruVar.b) && Intrinsics.areEqual(this.c, ruVar.c) && Intrinsics.areEqual(this.d, ruVar.d) && Intrinsics.areEqual(this.e, ruVar.e) && Intrinsics.areEqual(this.f, ruVar.f) && Intrinsics.areEqual(this.g, ruVar.g) && this.h == ruVar.h;
    }

    public final int hashCode() {
        int iA = aa.a(this.c, aa.a(this.b, this.f10140a.hashCode() * 31, 31), 31);
        uu uuVar = this.d;
        int iHashCode = (iA + (uuVar == null ? 0 : uuVar.hashCode())) * 31;
        String str = this.e;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        lz1 lz1Var = this.f;
        int iHashCode3 = (iHashCode2 + (lz1Var == null ? 0 : lz1Var.hashCode())) * 31;
        String str2 = this.g;
        return Integer.hashCode(this.h) + ((iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "Creative(mediaFiles=" + this.f10140a + ", icons=" + this.b + ", trackingEventsList=" + this.c + ", creativeExtensions=" + this.d + ", clickThroughUrl=" + this.e + ", skipOffset=" + this.f + ", id=" + this.g + ", durationMillis=" + this.h + ")";
    }

    public final List<aw0> g() {
        return this.f10140a;
    }

    public final List<ji0> e() {
        return this.b;
    }

    public final List<e62> i() {
        return this.c;
    }

    public final uu c() {
        return this.d;
    }

    public final String b() {
        return this.e;
    }

    public final lz1 h() {
        return this.f;
    }

    public final String f() {
        return this.g;
    }

    public final int d() {
        return this.h;
    }

    @Override // com.yandex.mobile.ads.impl.bg2
    public final Map<String, List<String>> a() {
        List<e62> list = this.c;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (e62 e62Var : list) {
            String strA = e62Var.a();
            Object arrayList = linkedHashMap.get(strA);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(strA, arrayList);
            }
            ((List) arrayList).add(e62Var.c());
        }
        return linkedHashMap;
    }
}
