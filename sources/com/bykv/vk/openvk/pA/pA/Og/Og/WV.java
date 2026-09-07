package com.bykv.vk.openvk.pA.pA.Og.Og;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class WV {
    private int JG;
    private final ArrayList<pA> KZx;
    private int ML = -1;
    private final int SD;
    private final int ZZv;
    private static final Set<String> pA = new HashSet();
    private static final Set<String> Og = new HashSet();

    WV(List<String> list) {
        int iIntValue;
        if (list.isEmpty()) {
            throw new IllegalArgumentException("urls can't be empty");
        }
        int size = list.size();
        this.ZZv = size;
        this.KZx = new ArrayList<>(size);
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        for (String str : list) {
            pA pAVar = new pA(str);
            if (pA.contains(str)) {
                arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                arrayList2.add(pAVar);
            } else if (Og.contains(str)) {
                arrayList = arrayList == null ? new ArrayList() : arrayList;
                arrayList.add(pAVar);
            } else {
                this.KZx.add(pAVar);
            }
        }
        if (arrayList != null) {
            this.KZx.addAll(arrayList);
        }
        if (arrayList2 != null) {
            this.KZx.addAll(arrayList2);
        }
        Integer num = ML.Bzk;
        if (num == null || num.intValue() <= 0) {
            iIntValue = this.ZZv >= 2 ? 1 : 2;
        } else {
            iIntValue = num.intValue();
        }
        this.SD = iIntValue;
    }

    WV(String str) {
        ArrayList<pA> arrayList = new ArrayList<>(1);
        this.KZx = arrayList;
        arrayList.add(new pA(str));
        this.ZZv = 1;
        this.SD = 1;
    }

    boolean pA() {
        return this.JG < this.SD;
    }

    pA Og() {
        if (!pA()) {
            throw new NoSuchElementException();
        }
        int i = this.ML + 1;
        if (i >= this.ZZv - 1) {
            this.ML = -1;
            this.JG++;
        } else {
            this.ML = i;
        }
        pA pAVar = this.KZx.get(i);
        pAVar.Og = (this.JG * this.ZZv) + this.ML;
        return pAVar;
    }

    public class pA {
        int Og;
        final String pA;

        pA(String str) {
            this.pA = str;
        }

        void pA() {
            WV.pA.add(this.pA);
        }

        void Og() {
            WV.Og.add(this.pA);
        }

        public String toString() {
            return this.pA;
        }
    }
}
