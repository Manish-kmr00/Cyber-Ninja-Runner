package com.moloco.sdk.internal.publisher.nativead.model;

import android.net.Uri;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, c.a> f6242a;
    public final Map<Integer, c.b> b;
    public final Map<Integer, c.C0551c> c;
    public final Map<Integer, c.d> d;
    public final List<Pair<b.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>> e;
    public final Lazy f;

    public static final class a extends Lambda implements Function0<Map<Integer, ? extends c>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map<Integer, c> invoke() {
            return MapsKt.plus(MapsKt.plus(MapsKt.plus(d.this.f6242a, d.this.b), d.this.c), d.this.d);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(Map<Integer, c.a> data, Map<Integer, c.b> images, Map<Integer, c.C0551c> titles, Map<Integer, c.d> videos, List<? extends Pair<? extends b.a, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>> failedAssets) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(images, "images");
        Intrinsics.checkNotNullParameter(titles, "titles");
        Intrinsics.checkNotNullParameter(videos, "videos");
        Intrinsics.checkNotNullParameter(failedAssets, "failedAssets");
        this.f6242a = data;
        this.b = images;
        this.c = titles;
        this.d = videos;
        this.e = failedAssets;
        this.f = LazyKt.lazy(new a());
    }

    public final Map<Integer, c.a> a() {
        return this.f6242a;
    }

    public final Map<Integer, c.b> b() {
        return this.b;
    }

    public final Map<Integer, c.C0551c> c() {
        return this.c;
    }

    public final Map<Integer, c.d> d() {
        return this.d;
    }

    public final List<Pair<b.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>> e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Intrinsics.areEqual(this.f6242a, dVar.f6242a) && Intrinsics.areEqual(this.b, dVar.b) && Intrinsics.areEqual(this.c, dVar.c) && Intrinsics.areEqual(this.d, dVar.d) && Intrinsics.areEqual(this.e, dVar.e);
    }

    public final Map<Integer, c> f() {
        return (Map) this.f.getValue();
    }

    public int hashCode() {
        return (((((((this.f6242a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "PreparedNativeAssets(data=" + this.f6242a + ", images=" + this.b + ", titles=" + this.c + ", videos=" + this.d + ", failedAssets=" + this.e + ')';
    }

    public final d a(Map<Integer, c.a> data, Map<Integer, c.b> images, Map<Integer, c.C0551c> titles, Map<Integer, c.d> videos, List<? extends Pair<? extends b.a, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>> failedAssets) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(images, "images");
        Intrinsics.checkNotNullParameter(titles, "titles");
        Intrinsics.checkNotNullParameter(videos, "videos");
        Intrinsics.checkNotNullParameter(failedAssets, "failedAssets");
        return new d(data, images, titles, videos, failedAssets);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ d a(d dVar, Map map, Map map2, Map map3, Map map4, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            map = dVar.f6242a;
        }
        if ((i & 2) != 0) {
            map2 = dVar.b;
        }
        Map map5 = map2;
        if ((i & 4) != 0) {
            map3 = dVar.c;
        }
        Map map6 = map3;
        if ((i & 8) != 0) {
            map4 = dVar.d;
        }
        Map map7 = map4;
        if ((i & 16) != 0) {
            list = dVar.e;
        }
        return dVar.a(map, map5, map6, map7, list);
    }

    public final Uri b(int i) {
        c.b bVar = this.b.get(Integer.valueOf(i));
        if (bVar != null) {
            return bVar.d();
        }
        return null;
    }

    public final String c(int i) {
        c.C0551c c0551c = this.c.get(Integer.valueOf(i));
        if (c0551c != null) {
            return c0551c.d();
        }
        return null;
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a d(int i) {
        c.d dVar = this.d.get(Integer.valueOf(i));
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public final String a(int i) {
        c.a aVar = this.f6242a.get(Integer.valueOf(i));
        if (aVar != null) {
            return aVar.d();
        }
        return null;
    }
}
