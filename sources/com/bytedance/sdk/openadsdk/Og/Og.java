package com.bytedance.sdk.openadsdk.Og;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes7.dex */
public class Og extends pA {
    private int KZx;
    private int Og;
    private volatile boolean ZZv;

    public Og(int i, int i2) {
        this.Og = 15;
        this.KZx = 3;
        if (i <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.Og = i;
        this.KZx = i2;
    }

    public Og(int i, int i2, boolean z) {
        this.Og = 15;
        this.KZx = 3;
        if (i <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.Og = i;
        this.KZx = i2;
        this.ZZv = z;
    }

    @Override // com.bytedance.sdk.openadsdk.Og.pA
    protected boolean pA(long j, int i) {
        return i <= this.Og;
    }

    @Override // com.bytedance.sdk.openadsdk.Og.pA
    protected boolean pA(File file, long j, int i) {
        return i <= this.KZx;
    }

    @Override // com.bytedance.sdk.openadsdk.Og.pA
    protected void pA(List<File> list) {
        if (this.ZZv) {
            ZZv(list);
            this.ZZv = false;
        } else {
            KZx(list);
        }
    }

    private void KZx(List<File> list) {
        long jOg = Og(list);
        int size = list.size();
        if (pA(jOg, size)) {
            return;
        }
        for (File file : list) {
            long length = file.length();
            if (file.delete()) {
                size--;
                jOg -= length;
            }
            if (pA(file, jOg, size)) {
                return;
            }
        }
    }

    private void ZZv(List<File> list) {
        long jOg;
        int size;
        boolean zPA;
        if (list != null) {
            try {
                if (list.size() == 0 || (zPA = pA((jOg = Og(list)), (size = list.size())))) {
                    return;
                }
                TreeMap treeMap = new TreeMap();
                for (File file : list) {
                    treeMap.put(Long.valueOf(file.lastModified()), file);
                }
                for (Map.Entry entry : treeMap.entrySet()) {
                    if (entry != null && !zPA) {
                        ((Long) entry.getKey()).longValue();
                        File file2 = (File) entry.getValue();
                        long length = file2.length();
                        if (file2.delete()) {
                            size--;
                            jOg -= length;
                        }
                        if (pA(file2, jOg, size)) {
                            return;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
