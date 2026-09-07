package com.yandex.mobile.ads.impl;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes12.dex */
final class bd1 {
    static void a(np1<?> np1Var, a aVar) throws ki2 {
        gr1 gr1VarH = np1Var.h();
        int iJ = np1Var.j();
        try {
            gr1VarH.a(aVar.b);
            np1Var.a(aVar.f8496a + "-retry [timeout=" + iJ + com.ironsource.b9.i.e);
        } catch (ki2 e) {
            np1Var.a(aVar.f8496a + "-timeout-giveup [timeout=" + iJ + com.ironsource.b9.i.e);
            throw e;
        }
    }

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8496a;
        private final ki2 b;

        private a(String str, ki2 ki2Var) {
            this.f8496a = str;
            this.b = ki2Var;
        }
    }

    static tc1 a(np1<?> np1Var, long j, List<hf0> list) {
        sm.a aVarC = np1Var.c();
        if (aVarC == null) {
            return new tc1(304, (byte[]) null, true, j, list);
        }
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            Iterator<hf0> it = list.iterator();
            while (it.hasNext()) {
                treeSet.add(it.next().a());
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List<hf0> list2 = aVarC.h;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (hf0 hf0Var : aVarC.h) {
                    if (!treeSet.contains(hf0Var.a())) {
                        arrayList.add(hf0Var);
                    }
                }
            }
        } else if (!aVarC.g.isEmpty()) {
            for (Map.Entry<String, String> entry : aVarC.g.entrySet()) {
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new hf0(entry.getKey(), entry.getValue()));
                }
            }
        }
        return new tc1(304, aVarC.f10218a, true, j, (List<hf0>) arrayList);
    }

    static byte[] a(InputStream inputStream, int i, om omVar) throws Throwable {
        byte[] bArrA;
        gj1 gj1Var = new gj1(omVar, i);
        try {
            bArrA = omVar.a(1024);
            while (true) {
                try {
                    int i2 = inputStream.read(bArrA);
                    if (i2 == -1) {
                        break;
                    }
                    gj1Var.write(bArrA, 0, i2);
                } catch (Throwable th) {
                    th = th;
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                        boolean z = li2.f9524a;
                        op0.e(new Object[0]);
                    }
                    omVar.a(bArrA);
                    gj1Var.close();
                    throw th;
                }
            }
            byte[] byteArray = gj1Var.toByteArray();
            try {
                inputStream.close();
            } catch (IOException unused2) {
                boolean z2 = li2.f9524a;
                op0.e(new Object[0]);
            }
            omVar.a(bArrA);
            gj1Var.close();
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            bArrA = null;
        }
    }

    static a a(np1<?> np1Var, IOException iOException, long j, zh0 zh0Var, byte[] bArr) throws ki2 {
        if (iOException instanceof SocketTimeoutException) {
            return new a("socket", new e52());
        }
        if (iOException instanceof MalformedURLException) {
            throw new RuntimeException("Bad URL " + np1Var.l(), iOException);
        }
        if (zh0Var != null) {
            int iD = zh0Var.d();
            Object[] objArr = {Integer.valueOf(iD), np1Var.l()};
            boolean z = li2.f9524a;
            op0.b(objArr);
            if (bArr != null) {
                tc1 tc1Var = new tc1(iD, bArr, false, SystemClock.elapsedRealtime() - j, zh0Var.c());
                if (iD == 401 || iD == 403) {
                    return new a("auth", new zh(tc1Var));
                }
                if (iD >= 400 && iD <= 499) {
                    throw new dp(tc1Var);
                }
                if (iD >= 500 && iD <= 599 && np1Var.v()) {
                    return new a(com.json.hm.f3752a, new gx1(tc1Var));
                }
                throw new gx1(tc1Var);
            }
            return new a("network", new qc1());
        }
        if (np1Var.u()) {
            return new a("connection", new jd1());
        }
        throw new jd1(iOException);
    }

    static void a(long j, np1<?> np1Var, byte[] bArr, int i) {
        if (li2.f9524a || j > 3000) {
            op0.a(np1Var, Long.valueOf(j), bArr != null ? Integer.valueOf(bArr.length) : "null", Integer.valueOf(i), Integer.valueOf(np1Var.h().b()));
        }
    }
}
