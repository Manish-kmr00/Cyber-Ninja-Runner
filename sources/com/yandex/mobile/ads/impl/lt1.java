package com.yandex.mobile.ads.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
final class lt1 extends x32 {
    private long b;
    private long[] c;
    private long[] d;

    public lt1() {
        super(new o40());
        this.b = -9223372036854775807L;
        this.c = new long[0];
        this.d = new long[0];
    }

    public final long a() {
        return this.b;
    }

    protected final boolean a(long j, wf1 wf1Var) {
        if (wf1Var.t() != 2) {
            return false;
        }
        int iZ = wf1Var.z();
        int iD = wf1Var.d();
        wf1Var.f(iZ);
        if (!"onMetaData".equals(new String(wf1Var.c(), iD, iZ)) || wf1Var.a() == 0 || wf1Var.t() != 8) {
            return false;
        }
        HashMap<String, Object> mapA = a(wf1Var);
        Object obj = mapA.get("duration");
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            if (dDoubleValue > 0.0d) {
                this.b = (long) (dDoubleValue * 1000000.0d);
            }
        }
        Object obj2 = mapA.get("keyframes");
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get("filepositions");
            Object obj4 = map.get("times");
            if ((obj3 instanceof List) && (obj4 instanceof List)) {
                List list = (List) obj3;
                List list2 = (List) obj4;
                int size = list2.size();
                this.c = new long[size];
                this.d = new long[size];
                for (int i = 0; i < size; i++) {
                    Object obj5 = list.get(i);
                    Object obj6 = list2.get(i);
                    if ((obj6 instanceof Double) && (obj5 instanceof Double)) {
                        this.c[i] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                        this.d[i] = ((Double) obj5).longValue();
                    } else {
                        this.c = new long[0];
                        this.d = new long[0];
                        break;
                    }
                }
            }
        }
        return false;
    }

    public final long[] c() {
        return this.c;
    }

    public final long[] b() {
        return this.d;
    }

    private static Serializable a(int i, wf1 wf1Var) {
        if (i == 8) {
            return a(wf1Var);
        }
        if (i == 10) {
            int iX = wf1Var.x();
            ArrayList arrayList = new ArrayList(iX);
            for (int i2 = 0; i2 < iX; i2++) {
                Serializable serializableA = a(wf1Var.t(), wf1Var);
                if (serializableA != null) {
                    arrayList.add(serializableA);
                }
            }
            return arrayList;
        }
        if (i == 11) {
            Date date = new Date((long) Double.longBitsToDouble(wf1Var.p()));
            wf1Var.f(2);
            return date;
        }
        if (i == 0) {
            return Double.valueOf(Double.longBitsToDouble(wf1Var.p()));
        }
        if (i == 1) {
            return Boolean.valueOf(wf1Var.t() == 1);
        }
        if (i == 2) {
            int iZ = wf1Var.z();
            int iD = wf1Var.d();
            wf1Var.f(iZ);
            return new String(wf1Var.c(), iD, iZ);
        }
        if (i != 3) {
            return null;
        }
        HashMap map = new HashMap();
        while (true) {
            int iZ2 = wf1Var.z();
            int iD2 = wf1Var.d();
            wf1Var.f(iZ2);
            String str = new String(wf1Var.c(), iD2, iZ2);
            int iT = wf1Var.t();
            if (iT == 9) {
                return map;
            }
            Serializable serializableA2 = a(iT, wf1Var);
            if (serializableA2 != null) {
                map.put(str, serializableA2);
            }
        }
    }

    private static HashMap<String, Object> a(wf1 wf1Var) {
        int iX = wf1Var.x();
        HashMap<String, Object> map = new HashMap<>(iX);
        for (int i = 0; i < iX; i++) {
            int iZ = wf1Var.z();
            int iD = wf1Var.d();
            wf1Var.f(iZ);
            String str = new String(wf1Var.c(), iD, iZ);
            Serializable serializableA = a(wf1Var.t(), wf1Var);
            if (serializableA != null) {
                map.put(str, serializableA);
            }
        }
        return map;
    }
}
