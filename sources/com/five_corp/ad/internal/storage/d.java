package com.five_corp.ad.internal.storage;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.five_corp.ad.internal.D;
import com.five_corp.ad.internal.ad.s;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f1528a;
    public final p b;
    public final com.five_corp.ad.internal.system.c c;
    public final com.five_corp.ad.internal.logger.a d;
    public final Object e = new Object();
    public final HashMap f = new HashMap();
    public final HashMap g = new HashMap();

    public d(j jVar, p pVar, com.five_corp.ad.internal.system.c cVar, com.five_corp.ad.internal.logger.a aVar) {
        this.f1528a = jVar;
        this.b = pVar;
        this.c = cVar;
        this.d = aVar;
    }

    public final com.five_corp.ad.internal.cache.o a(String str, boolean z, boolean z2) {
        b bVar = this.f1528a.f1534a;
        a aVar = new a(bVar, str, bVar.b);
        Pattern pattern = p.b;
        a aVar2 = new a(bVar, str + ".success", bVar.b);
        Looper looperA = this.c.a();
        Handler handler = looperA != null ? new Handler(looperA) : null;
        if (z2) {
            handler.post(new c(aVar));
        }
        return new com.five_corp.ad.internal.cache.o(handler, aVar, aVar2, z);
    }

    public final com.five_corp.ad.internal.cache.o b(s sVar) {
        Pattern pattern = p.b;
        String strA = D.a(sVar.f1310a);
        HashMap map = sVar.c ? this.f : this.g;
        com.five_corp.ad.internal.cache.o oVar = (com.five_corp.ad.internal.cache.o) map.get(strA);
        if (oVar != null) {
            return oVar;
        }
        int iNextInt = this.b.f1539a.nextInt(1073741824);
        String str = sVar.c ? "res5" : "res6";
        String strA2 = D.a(sVar.f1310a);
        String str2 = String.format("%08X", Integer.valueOf(iNextInt));
        Matcher matcher = p.b.matcher(sVar.f1310a);
        com.five_corp.ad.internal.cache.o oVarA = a(str + "=" + strA2 + "=" + str2 + (!matcher.find() ? "" : matcher.group(1)), false, true);
        map.put(strA, oVarA);
        return oVarA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v39, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r0v46, types: [com.five_corp.ad.internal.util.f] */
    /* JADX WARN: Type inference failed for: r0v48, types: [com.five_corp.ad.internal.util.f] */
    /* JADX WARN: Type inference failed for: r0v49 */
    /* JADX WARN: Type inference failed for: r0v50 */
    /* JADX WARN: Type inference failed for: r0v52, types: [com.five_corp.ad.internal.util.f] */
    /* JADX WARN: Type inference failed for: r0v54, types: [com.five_corp.ad.internal.util.f] */
    /* JADX WARN: Type inference failed for: r0v72 */
    /* JADX WARN: Type inference failed for: r0v73 */
    /* JADX WARN: Type inference failed for: r0v74 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v41, types: [com.five_corp.ad.internal.util.f] */
    /* JADX WARN: Type inference failed for: r1v48 */
    /* JADX WARN: Type inference failed for: r1v49 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.BufferedInputStream] */
    public final com.five_corp.ad.internal.util.g b(String str) throws Throwable {
        int i;
        com.five_corp.ad.internal.util.g gVar;
        BufferedInputStream bufferedInputStream;
        ?? fVar;
        com.five_corp.ad.internal.util.f fVar2;
        com.five_corp.ad.internal.util.g gVarB = this.f1528a.f1534a.b();
        if (!gVarB.f1560a) {
            return gVarB;
        }
        com.five_corp.ad.internal.util.f fVarB = this.f1528a.f1534a.b("storage.id");
        ?? r4 = 0;
        if (fVarB.f1560a) {
            if (!((Boolean) fVarB.c).booleanValue()) {
                fVar2 = new com.five_corp.ad.internal.util.f(true, null, Boolean.TRUE);
            } else {
                b bVar = this.f1528a.f1534a;
                com.five_corp.ad.internal.util.f fVarC = bVar.c("storage.id");
                if (!fVarC.f1560a) {
                    fVar = new com.five_corp.ad.internal.util.f(false, fVarC.b, null);
                } else {
                    int iIntValue = ((Integer) fVarC.c).intValue();
                    ?? fVar3 = bVar.f1526a;
                    File file = new File((File) fVar3, "storage.id");
                    try {
                        try {
                            try {
                                byte[] bArr = new byte[iIntValue];
                                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                                int i2 = 0;
                                int i3 = 0;
                                while (true) {
                                    if (i2 >= iIntValue || i3 >= 16) {
                                        try {
                                            bufferedInputStream.close();
                                        } catch (IOException e) {
                                            Log.getStackTraceString(e);
                                        }
                                        if (i2 < iIntValue) {
                                            fVar = new com.five_corp.ad.internal.util.f(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.W2, null, null, null), null);
                                            break;
                                        }
                                        fVar3 = new com.five_corp.ad.internal.util.f(true, null, new e(iIntValue, bArr));
                                        fVar = fVar3;
                                        break;
                                    }
                                    try {
                                        int i4 = bufferedInputStream.read(bArr, i2, iIntValue - i2);
                                        if (i4 < 0) {
                                            com.five_corp.ad.internal.util.f fVar4 = new com.five_corp.ad.internal.util.f(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.X2, null, null, null), null);
                                            try {
                                                bufferedInputStream.close();
                                            } catch (IOException e2) {
                                                Log.getStackTraceString(e2);
                                            }
                                            fVar = fVar4;
                                            break;
                                        }
                                        i2 += i4;
                                        i3++;
                                    } catch (IOException e3) {
                                        e = e3;
                                        fVar3 = new com.five_corp.ad.internal.util.f(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.V2, "File path: " + file.getAbsolutePath(), e, null), null);
                                        if (bufferedInputStream != null) {
                                            bufferedInputStream.close();
                                            fVar3 = fVar3;
                                        }
                                        fVar = fVar3;
                                        break;
                                    } catch (OutOfMemoryError e4) {
                                        e = e4;
                                        fVar3 = new com.five_corp.ad.internal.util.f(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.i3, "File path: " + file.getAbsolutePath(), e, null), null);
                                        if (bufferedInputStream != null) {
                                            bufferedInputStream.close();
                                            fVar3 = fVar3;
                                        }
                                        fVar = fVar3;
                                        break;
                                    } catch (SecurityException e5) {
                                        e = e5;
                                        fVar3 = new com.five_corp.ad.internal.util.f(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.U2, "File path: " + file.getAbsolutePath(), e, null), null);
                                        if (bufferedInputStream != null) {
                                            bufferedInputStream.close();
                                            fVar3 = fVar3;
                                        }
                                        fVar = fVar3;
                                        break;
                                    }
                                }
                            } catch (IOException e6) {
                                e = e6;
                                bufferedInputStream = null;
                            } catch (OutOfMemoryError e7) {
                                e = e7;
                                bufferedInputStream = null;
                            } catch (SecurityException e8) {
                                e = e8;
                                bufferedInputStream = null;
                            } catch (Throwable th) {
                                th = th;
                                if (r4 != 0) {
                                    try {
                                        r4.close();
                                    } catch (IOException e9) {
                                        Log.getStackTraceString(e9);
                                    }
                                }
                                throw th;
                            }
                        } catch (IOException e10) {
                            Log.getStackTraceString(e10);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        r4 = "storage.id";
                    }
                }
                if (!fVar.f1560a) {
                    fVar2 = new com.five_corp.ad.internal.util.f(false, fVar.b, null);
                } else {
                    e eVar = (e) fVar.c;
                    fVar2 = new com.five_corp.ad.internal.util.f(true, null, Boolean.valueOf(!new String(eVar.f1529a, 0, eVar.b).equals(str)));
                }
            }
            fVarB = fVar2;
        }
        if (!fVarB.f1560a) {
            return new com.five_corp.ad.internal.util.g(false, fVarB.b);
        }
        if (((Boolean) fVarB.c).booleanValue()) {
            com.five_corp.ad.internal.util.f fVarA = this.f1528a.f1534a.a();
            if (!fVarA.f1560a) {
                gVar = new com.five_corp.ad.internal.util.g(false, fVarA.b);
            } else {
                Iterator it = ((List) fVarA.c).iterator();
                while (it.hasNext()) {
                    a((String) it.next());
                }
                gVar = new com.five_corp.ad.internal.util.g(true, null);
            }
            if (!gVar.f1560a) {
                return gVar;
            }
            com.five_corp.ad.internal.util.g gVarA = this.f1528a.f1534a.a("storage.id", str.getBytes());
            if (!gVarA.f1560a) {
                return gVarA;
            }
        }
        com.five_corp.ad.internal.util.f fVarA2 = this.f1528a.f1534a.a();
        if (!fVarA2.f1560a) {
            return new com.five_corp.ad.internal.util.g(false, fVarA2.b);
        }
        List<String> list = (List) fVarA2.c;
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        ArrayList<String> arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList();
        ArrayList<String> arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (String str2 : list) {
            Pattern pattern = p.b;
            if (str2.equals("storage.id")) {
                i = 2;
            } else if (str2.endsWith(".success")) {
                i = 5;
            } else if (!str2.startsWith("res5") || str2.endsWith(".success") || p.a(str2) == null) {
                i = (!str2.startsWith("res6") || str2.endsWith(".success") || p.a(str2) == null) ? 1 : 4;
            } else {
                i = 3;
            }
            int iA = com.five_corp.ad.e.a(i);
            if (iA == 0) {
                arrayList4.add(str2);
            } else if (iA == 2) {
                String strA = p.a(str2);
                if (hashSet.contains(strA)) {
                    a(str2);
                } else {
                    arrayList.add(str2);
                    hashSet.add(strA);
                }
            } else if (iA == 3) {
                String strA2 = p.a(str2);
                if (hashSet2.contains(strA2)) {
                    a(str2);
                } else {
                    arrayList2.add(str2);
                    hashSet2.add(strA2);
                }
            } else if (iA == 4) {
                arrayList3.add(str2);
            }
        }
        for (String str3 : arrayList3) {
            Pattern pattern2 = p.b;
            String strSubstring = str3.substring(0, str3.length() - 8);
            if (!arrayList.contains(strSubstring) && !arrayList2.contains(strSubstring)) {
                a(str3);
            }
        }
        Iterator it2 = arrayList4.iterator();
        while (it2.hasNext()) {
            a((String) it2.next());
        }
        synchronized (this.e) {
            for (String str4 : arrayList) {
                Pattern pattern3 = p.b;
                this.f.put(p.a(str4), a(str4, arrayList3.contains(str4 + ".success"), false));
            }
            for (String str5 : arrayList2) {
                Pattern pattern4 = p.b;
                this.g.put(p.a(str5), a(str5, arrayList3.contains(str5 + ".success"), false));
            }
        }
        return new com.five_corp.ad.internal.util.g(true, null);
    }

    public final void a(HashSet hashSet) {
        HashSet hashSet2 = new HashSet();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            s sVar = (s) it.next();
            Pattern pattern = p.b;
            hashSet2.add(D.a(sVar.f1310a));
        }
        synchronized (this.e) {
            Iterator it2 = this.g.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                if (!hashSet2.contains(entry.getKey())) {
                    ((com.five_corp.ad.internal.cache.o) entry.getValue()).a();
                    it2.remove();
                }
            }
        }
    }

    public final void a(String str) {
        com.five_corp.ad.internal.util.g gVarA = this.f1528a.f1534a.a(str);
        if (gVarA.f1560a) {
            return;
        }
        this.d.a(gVarA.b.b(), 5);
    }

    public final com.five_corp.ad.internal.cache.o a(s sVar) {
        com.five_corp.ad.internal.cache.o oVarB;
        synchronized (this.e) {
            oVarB = b(sVar);
        }
        return oVarB;
    }

    public final HashMap a(ArrayList arrayList) {
        HashMap map;
        synchronized (this.e) {
            map = new HashMap();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                s sVar = (s) it.next();
                map.put(sVar, b(sVar));
            }
        }
        return map;
    }
}
