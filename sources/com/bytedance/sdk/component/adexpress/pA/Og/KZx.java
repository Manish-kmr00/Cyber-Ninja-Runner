package com.bytedance.sdk.component.adexpress.pA.Og;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.component.utils.eG;
import com.json.cc;
import com.safedk.android.internal.partials.PangleFilesBridge;
import com.smaato.sdk.core.dns.DnsName;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public abstract class KZx {
    public abstract File pA();

    protected boolean pA(Map<String, com.bytedance.sdk.component.adexpress.pA.KZx.pA> map) {
        if (map == null || map.size() == 0) {
            return false;
        }
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVar = map.get(it.next());
            if (pAVar != null && !pA(pAVar.JG())) {
                return false;
            }
        }
        return true;
    }

    protected boolean pA(List<com.bytedance.sdk.component.adexpress.pA.KZx.pA.C0204pA> list) {
        if (list == null || list.size() <= 0 || pA() == null) {
            return false;
        }
        for (com.bytedance.sdk.component.adexpress.pA.KZx.pA.C0204pA c0204pA : list) {
            String strPA = com.bytedance.sdk.component.utils.ML.pA(c0204pA.pA());
            if (TextUtils.isEmpty(strPA)) {
                return false;
            }
            File file = new File(pA(), strPA);
            String strPA2 = com.bytedance.sdk.component.utils.ML.pA(file);
            if (!file.exists() || !file.isFile() || c0204pA.Og() == null || !c0204pA.Og().equals(strPA2)) {
                return false;
            }
        }
        return true;
    }

    protected boolean pA(com.bytedance.sdk.component.adexpress.pA.KZx.pA.Og og) {
        if (og == null || pA() == null) {
            return false;
        }
        List<Pair<String, String>> listOg = og.Og();
        if (listOg == null || listOg.size() <= 0) {
            return true;
        }
        Iterator<Pair<String, String>> it = listOg.iterator();
        while (it.hasNext()) {
            File file = new File(pA(), (String) it.next().first);
            if (!file.exists() || !file.isFile()) {
                return false;
            }
        }
        return true;
    }

    public List<com.bytedance.sdk.component.adexpress.pA.KZx.pA.C0204pA> pA(com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVar, com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVar2) {
        Map<String, com.bytedance.sdk.component.adexpress.pA.KZx.pA> mapPA = pAVar.pA();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (mapPA.size() == 0) {
            if (pAVar2 != null && pAVar2.pA().size() != 0) {
                Map<String, com.bytedance.sdk.component.adexpress.pA.KZx.pA> mapPA2 = pAVar2.pA();
                Iterator<String> it = mapPA2.keySet().iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVar3 = mapPA2.get(it.next());
                    if (pAVar3 != null) {
                        arrayList.addAll(pAVar3.JG());
                    }
                }
            }
        } else if (pAVar2 == null || pAVar2.pA().size() == 0) {
            if (mapPA.size() != 0) {
                Iterator<String> it2 = mapPA.keySet().iterator();
                while (it2.hasNext()) {
                    com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVar4 = mapPA.get(it2.next());
                    if (pAVar4 != null) {
                        arrayList2.addAll(pAVar4.JG());
                    }
                }
            }
        } else {
            Map<String, com.bytedance.sdk.component.adexpress.pA.KZx.pA> mapPA3 = pAVar2.pA();
            for (String str : mapPA.keySet()) {
                com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVar5 = mapPA.get(str);
                com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVar6 = mapPA3.get(str);
                if (pAVar6 == null && pAVar5 != null) {
                    arrayList2.addAll(pAVar5.JG());
                } else if (pAVar5 == null && pAVar6 != null) {
                    arrayList.addAll(pAVar6.JG());
                } else if (pAVar5 != null) {
                    for (com.bytedance.sdk.component.adexpress.pA.KZx.pA.C0204pA c0204pA : pAVar5.JG()) {
                        if (c0204pA != null && !pAVar6.JG().contains(c0204pA) && c0204pA.Og() != null && c0204pA.pA() != null) {
                            arrayList2.add(c0204pA);
                        }
                    }
                    for (com.bytedance.sdk.component.adexpress.pA.KZx.pA.C0204pA c0204pA2 : pAVar6.JG()) {
                        if (c0204pA2 != null && !pAVar5.JG().contains(c0204pA2)) {
                            arrayList.add(c0204pA2);
                        }
                    }
                }
            }
        }
        if (pA(arrayList2, arrayList3)) {
            return arrayList;
        }
        return null;
    }

    private boolean pA(List<com.bytedance.sdk.component.adexpress.pA.KZx.pA.C0204pA> list, List<com.bytedance.sdk.component.adexpress.pA.KZx.pA.C0204pA> list2) {
        for (com.bytedance.sdk.component.adexpress.pA.KZx.pA.C0204pA c0204pA : list) {
            String strPA = c0204pA.pA();
            String strPA2 = com.bytedance.sdk.component.utils.ML.pA(strPA);
            File file = new File(pA(), strPA2);
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
            com.bytedance.sdk.component.SD.Og.pA pAVarJG = com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().KZx().JG();
            pAVarJG.Og(strPA);
            pAVarJG.pA(pA().getAbsolutePath(), strPA2);
            com.bytedance.sdk.component.SD.Og ogPA = pAVarJG.pA();
            list2.add(c0204pA);
            if (ogPA == null || !ogPA.JG() || ogPA.ML() == null || !ogPA.ML().exists()) {
                KZx(list2);
                return false;
            }
        }
        return true;
    }

    public List<com.bytedance.sdk.component.adexpress.pA.KZx.pA.C0204pA> Og(com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVar, com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVar2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (pAVar2 == null || pAVar2.JG().isEmpty()) {
            arrayList2.addAll(pAVar.JG());
        } else if (pAVar.JG().isEmpty()) {
            arrayList.addAll(pAVar2.JG());
        } else {
            for (com.bytedance.sdk.component.adexpress.pA.KZx.pA.C0204pA c0204pA : pAVar.JG()) {
                if (!pAVar2.JG().contains(c0204pA) && c0204pA != null && c0204pA.pA() != null && c0204pA.Og() != null) {
                    arrayList2.add(c0204pA);
                }
            }
            for (com.bytedance.sdk.component.adexpress.pA.KZx.pA.C0204pA c0204pA2 : pAVar2.JG()) {
                if (!pAVar.JG().contains(c0204pA2)) {
                    arrayList.add(c0204pA2);
                }
            }
        }
        if (pA(arrayList2, arrayList3)) {
            return arrayList;
        }
        return null;
    }

    public void Og(List<com.bytedance.sdk.component.adexpress.pA.KZx.pA.C0204pA> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<com.bytedance.sdk.component.adexpress.pA.KZx.pA.C0204pA> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(pA(), com.bytedance.sdk.component.utils.ML.pA(it.next().pA()));
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public boolean pA(String str) {
        File file = new File(pA().getAbsoluteFile(), com.bytedance.sdk.component.utils.ML.pA(str) + ".zip");
        com.bytedance.sdk.component.SD.Og.pA pAVarJG = com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().KZx().JG();
        pAVarJG.Og(str);
        pAVarJG.pA(file.getParent(), file.getName());
        com.bytedance.sdk.component.SD.Og ogPA = pAVarJG.pA();
        if (ogPA.JG() && ogPA.ML() != null && ogPA.ML().exists()) {
            File fileML = ogPA.ML();
            try {
                eG.pA(fileML.getAbsolutePath(), file.getParent());
                if (!fileML.exists()) {
                    return true;
                }
                fileML.delete();
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public void pA(int i) {
        if (com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().ZZv() != null) {
            com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().ZZv().pA(i);
        }
    }

    public void KZx(List<com.bytedance.sdk.component.adexpress.pA.KZx.pA.C0204pA> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<com.bytedance.sdk.component.adexpress.pA.KZx.pA.C0204pA> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(pA(), com.bytedance.sdk.component.utils.ML.pA(it.next().pA()));
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public static void pA(File file, com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVar, String str) {
        if (pAVar == null) {
            return;
        }
        String strBzk = pAVar.Bzk();
        if (TextUtils.isEmpty(strBzk)) {
            return;
        }
        File file2 = new File(file, str);
        File file3 = new File(file2 + ".tmp");
        if (file3.exists()) {
            file3.delete();
        }
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStreamFileOutputStreamCtor = PangleFilesBridge.fileOutputStreamCtor(file3);
            try {
                fileOutputStreamFileOutputStreamCtor.write(strBzk.getBytes(cc.N));
                if (file2.exists()) {
                    file2.delete();
                }
                file3.renameTo(file2);
                try {
                    fileOutputStreamFileOutputStreamCtor.close();
                } catch (IOException unused) {
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStreamFileOutputStreamCtor;
                try {
                    WV.pA("PlayComponentEngineCacheManager", "version save error3", th);
                } finally {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean KZx(com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVar, com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVar2) {
        if (pAVar != null) {
            try {
                if (!TextUtils.isEmpty(pAVar.KZx())) {
                    if (pAVar2 == null) {
                        return false;
                    }
                    if (pA(pAVar.KZx(), pAVar2.KZx())) {
                        return true;
                    }
                    Map<String, com.bytedance.sdk.component.adexpress.pA.KZx.pA> mapPA = pAVar.pA();
                    Map<String, com.bytedance.sdk.component.adexpress.pA.KZx.pA> mapPA2 = pAVar2.pA();
                    if (mapPA.isEmpty()) {
                        return !mapPA2.isEmpty();
                    }
                    if (mapPA2.isEmpty()) {
                        return false;
                    }
                    return pA(mapPA, mapPA2);
                }
            } catch (Throwable th) {
                th.getMessage();
                return false;
            }
        }
        return true;
    }

    private static boolean pA(Map<String, com.bytedance.sdk.component.adexpress.pA.KZx.pA> map, Map<String, com.bytedance.sdk.component.adexpress.pA.KZx.pA> map2) {
        if (map.size() != map2.size()) {
            return true;
        }
        for (String str : map2.keySet()) {
            com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVar = map.get(str);
            if (pAVar == null) {
                return true;
            }
            com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVar2 = map2.get(str);
            if (pAVar2 == null) {
                return false;
            }
            if (pA(pAVar.KZx(), pAVar2.KZx())) {
                return true;
            }
        }
        return false;
    }

    private static boolean pA(String str, String str2) {
        String[] strArrSplit = str2.split(DnsName.ESCAPED_DOT);
        String[] strArrSplit2 = str.split(DnsName.ESCAPED_DOT);
        int iMin = Math.min(strArrSplit.length, strArrSplit2.length);
        for (int i = 0; i < iMin; i++) {
            int length = strArrSplit[i].length() - strArrSplit2[i].length();
            if (length == 0) {
                int iCompareTo = strArrSplit[i].compareTo(strArrSplit2[i]);
                if (iCompareTo > 0) {
                    return true;
                }
                if (iCompareTo < 0) {
                    return false;
                }
                if (i == iMin - 1) {
                    return strArrSplit.length > strArrSplit2.length;
                }
            } else if (length > 0) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public static boolean pA(com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVar, String str) {
        if (pAVar == null) {
            return true;
        }
        try {
            if (TextUtils.isEmpty(pAVar.KZx())) {
                return true;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return pA(pAVar.KZx(), str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void Og(File file, com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVar, String str) {
        if (pAVar == null || file == null) {
            return;
        }
        try {
            new File(file, str).delete();
        } catch (Throwable unused) {
        }
        if (pAVar.JG() != null) {
            Iterator<com.bytedance.sdk.component.adexpress.pA.KZx.pA.C0204pA> it = pAVar.JG().iterator();
            while (it.hasNext()) {
                try {
                    new File(file, com.bytedance.sdk.component.utils.ML.pA(it.next().pA())).delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }
}
