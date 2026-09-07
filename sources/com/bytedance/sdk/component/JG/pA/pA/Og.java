package com.bytedance.sdk.component.JG.pA.pA;

import android.text.TextUtils;
import com.bytedance.sdk.component.JG.pA.omh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public class Og extends pA {
    private final Queue<String> KZx;
    private final KZx Og;
    private final ZZv pA;

    public Og() {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.KZx = concurrentLinkedQueue;
        this.pA = new JG(concurrentLinkedQueue);
        this.Og = new KZx();
    }

    @Override // com.bytedance.sdk.component.JG.pA.pA.ZZv
    public synchronized void pA(com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar, int i) {
        ZZv zZv;
        KZx kZx;
        if (i != 5) {
            if (omh.SD().oX().pA(omh.SD().JG()) && (zZv = this.pA) != null && pAVar != null) {
                zZv.pA(pAVar, i);
            }
            kZx = this.Og;
            if (kZx != null && pAVar != null) {
                kZx.pA(pAVar, i);
            }
        } else {
            kZx = this.Og;
            if (kZx != null) {
                kZx.pA(pAVar, i);
            }
        }
        throw th;
    }

    @Override // com.bytedance.sdk.component.JG.pA.pA.ZZv
    public synchronized void pA(int i, List<com.bytedance.sdk.component.JG.pA.ZZv.pA> list) {
        Iterator<com.bytedance.sdk.component.JG.pA.ZZv.pA> it = list.iterator();
        while (it.hasNext()) {
            this.KZx.remove(it.next().KZx());
        }
        ZZv zZv = this.pA;
        if (zZv != null) {
            zZv.pA(i, list);
        }
        KZx kZx = this.Og;
        if (kZx != null) {
            kZx.pA(i, list);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.JG.pA.pA.ZZv
    public synchronized List<com.bytedance.sdk.component.JG.pA.ZZv.pA> pA(int i, int i2, List<String> list) {
        List list2;
        List<com.bytedance.sdk.component.JG.pA.ZZv.pA> listPA = this.pA.pA(i, i2, list);
        if (listPA != null && listPA.size() != 0) {
            listPA.size();
            if (i == 1 || i == 2) {
                list2 = listPA;
                List<com.bytedance.sdk.component.JG.pA.ZZv.pA> listOg = this.Og.Og((com.bytedance.sdk.component.JG.pA.ZZv.pA) listPA.get(0), listPA.size());
                list2 = listPA;
                if (listOg != null && listOg.size() != 0) {
                    list2 = listPA;
                    listOg.size();
                    HashMap map = new HashMap();
                    for (com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar : listOg) {
                        map.put(pAVar.KZx(), pAVar);
                    }
                    ArrayList arrayList = new ArrayList(this.KZx);
                    for (com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar2 : listOg) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            if (TextUtils.equals(pAVar2.KZx(), (String) it.next())) {
                                map.remove(pAVar2.KZx());
                                break;
                            }
                        }
                    }
                    for (com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar3 : listPA) {
                        map.put(pAVar3.KZx(), pAVar3);
                    }
                    listPA.clear();
                    Iterator it2 = map.keySet().iterator();
                    while (it2.hasNext()) {
                        listPA.add(map.get((String) it2.next()));
                    }
                    listOg.clear();
                    list2 = listPA;
                }
            }
        } else {
            ArrayList<String> arrayList2 = new ArrayList(this.KZx);
            if (list != null && !list.isEmpty()) {
                arrayList2.addAll(list);
            }
            List<com.bytedance.sdk.component.JG.pA.ZZv.pA> listPA2 = this.Og.pA(i, i2, arrayList2);
            if (listPA2 != null && listPA2.size() != 0) {
                HashMap map2 = new HashMap();
                for (com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar4 : listPA2) {
                    map2.put(pAVar4.KZx(), pAVar4);
                }
                arrayList2.size();
                if (arrayList2.size() != 0) {
                    for (String str : arrayList2) {
                        if (map2.get(str) != null) {
                            map2.remove(str);
                        }
                    }
                }
                listPA2.clear();
                Iterator it3 = map2.keySet().iterator();
                while (it3.hasNext()) {
                    listPA2.add(map2.get((String) it3.next()));
                }
            }
            list2 = listPA2;
        }
        if (list2 != null && !list2.isEmpty()) {
            Iterator it4 = list2.iterator();
            while (it4.hasNext()) {
                this.KZx.offer(((com.bytedance.sdk.component.JG.pA.ZZv.pA) it4.next()).KZx());
            }
            return list2;
        }
        return new ArrayList();
    }

    @Override // com.bytedance.sdk.component.JG.pA.pA.ZZv
    public synchronized boolean pA(int i, boolean z) {
        if (this.pA.pA(i, z)) {
            com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.lT(), 1);
            return true;
        }
        if ((i != 1 && i != 2) || !this.Og.pA(i, z)) {
            return false;
        }
        com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.rB(), 1);
        return true;
    }

    @Override // com.bytedance.sdk.component.JG.pA.pA.ZZv
    public void pA(int i, long j) {
        this.Og.pA(i, j);
        this.pA.pA(i, j);
    }
}
