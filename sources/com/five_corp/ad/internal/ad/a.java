package com.five_corp.ad.internal.ad;

import com.five_corp.ad.CreativeType;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class a {
    public final com.five_corp.ad.internal.ad.beacon.f A;
    public final ArrayList B;
    public final String C;
    public final ArrayList D;
    public final d E;
    public final int F;
    public final int G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CreativeType f1266a;
    public final String b;
    public final Long c;
    public final c d;
    public final Long e;
    public final Integer f;
    public final q g;
    public final m h;
    public final r i;
    public final String j;
    public final s k;
    public final Long l;
    public final s m;
    public final s n;
    public final s o;
    public final j p;
    public final String q;
    public final String r;
    public final String s;
    public final String t;
    public final String u;
    public final ArrayList v;
    public final ArrayList w;
    public final List x;
    public final com.five_corp.ad.internal.ad.beacon.j y;
    public final com.five_corp.ad.internal.ad.beacon.f z;

    public a(CreativeType creativeType, String str, Long l, c cVar, Long l2, Integer num, int i, int i2, q qVar, m mVar, r rVar, String str2, s sVar, Long l3, s sVar2, s sVar3, s sVar4, j jVar, String str3, String str4, String str5, String str6, String str7, ArrayList arrayList, ArrayList arrayList2, List list, com.five_corp.ad.internal.ad.beacon.j jVar2, com.five_corp.ad.internal.ad.beacon.f fVar, com.five_corp.ad.internal.ad.beacon.f fVar2, ArrayList arrayList3, String str8, ArrayList arrayList4, d dVar) {
        this.f1266a = creativeType;
        this.b = str;
        this.c = l;
        this.d = cVar;
        this.e = l2;
        this.f = num;
        this.F = i;
        this.G = i2;
        this.g = qVar;
        this.h = mVar;
        this.i = rVar;
        this.j = str2;
        this.k = sVar;
        this.l = l3;
        this.m = sVar2;
        this.n = sVar3;
        this.o = sVar4;
        this.p = jVar;
        this.q = str3;
        this.r = str4;
        this.s = str5;
        this.t = str6;
        this.u = str7;
        this.v = arrayList;
        this.w = arrayList2;
        this.x = list;
        this.y = jVar2;
        this.z = fVar;
        this.A = fVar2;
        this.B = arrayList3;
        this.C = str8;
        this.D = arrayList4;
        this.E = dVar;
    }

    public static com.five_corp.ad.internal.ad.format_config.a a(a aVar, String str) {
        if (aVar != null && str != null) {
            Integer numValueOf = null;
            for (t tVar : aVar.v) {
                if (str.equals(tVar.f1311a)) {
                    numValueOf = Integer.valueOf(tVar.b);
                }
            }
            if (numValueOf == null) {
                return null;
            }
            for (com.five_corp.ad.internal.ad.format_config.a aVar2 : aVar.w) {
                if (numValueOf.equals(Integer.valueOf(aVar2.f1289a))) {
                    return aVar2;
                }
            }
        }
        return null;
    }

    public final boolean a() {
        return this.f1266a == CreativeType.MOVIE && this.F == 2 && this.g != null;
    }
}
