package com.bykv.vk.openvk.pA.pA.Og.pA.pA;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class pA implements com.bykv.vk.openvk.pA.pA.pA.pA.Og {
    private String pA = "video_reward_full";
    private String Og = "video_brand";
    private String KZx = "video_splash";
    private String ZZv = "video_default";
    private String ML = null;
    private String JG = null;
    private String SD = null;
    private String omh = null;
    private String Bzk = null;

    @Override // com.bykv.vk.openvk.pA.pA.pA.pA.Og
    public void pA(String str) {
        this.ML = str;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.pA.Og
    public String KZx() {
        if (this.Bzk == null) {
            this.Bzk = this.ML + File.separator + this.ZZv;
            File file = new File(this.Bzk);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.Bzk;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.pA.Og
    public String pA() {
        if (this.JG == null) {
            this.JG = this.ML + File.separator + this.pA;
            File file = new File(this.JG);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.JG;
    }

    public String ML() {
        if (this.SD == null) {
            this.SD = this.ML + File.separator + this.Og;
            File file = new File(this.SD);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.SD;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.pA.Og
    public String Og() {
        if (this.omh == null) {
            this.omh = this.ML + File.separator + this.KZx;
            File file = new File(this.omh);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.omh;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.pA.Og
    public synchronized void ZZv() {
        Set<String> setSD = null;
        for (com.bykv.vk.openvk.pA.pA.pA.pA.pA pAVar : JG()) {
            File[] fileArrPA = pAVar.pA();
            if (fileArrPA != null && fileArrPA.length >= pAVar.Og()) {
                if (setSD == null) {
                    setSD = SD();
                }
                int iOg = pAVar.Og() - 2;
                if (iOg < 0) {
                    iOg = 0;
                }
                pA(pAVar.pA(), iOg, setSD);
            }
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.pA.Og
    public boolean pA(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx) {
        if (TextUtils.isEmpty(kZx.Og()) || TextUtils.isEmpty(kZx.Sn())) {
            return false;
        }
        return new File(kZx.Og(), kZx.Sn()).exists();
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.pA.Og
    public long Og(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx) {
        if (TextUtils.isEmpty(kZx.Og()) || TextUtils.isEmpty(kZx.Sn())) {
            return 0L;
        }
        return com.bykv.vk.openvk.pA.pA.Og.ML.Og.pA(kZx.Og(), kZx.Sn());
    }

    private static void pA(File[] fileArr, int i, Set<String> set) {
        if (i >= 0 && fileArr != null) {
            try {
                if (fileArr.length > i) {
                    List listAsList = Arrays.asList(fileArr);
                    Collections.sort(listAsList, new Comparator<File>() { // from class: com.bykv.vk.openvk.pA.pA.Og.pA.pA.pA.1
                        @Override // java.util.Comparator
                        /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
                        public int compare(File file, File file2) {
                            long jLastModified = file2.lastModified() - file.lastModified();
                            if (jLastModified == 0) {
                                return 0;
                            }
                            return jLastModified < 0 ? -1 : 1;
                        }
                    });
                    while (i < listAsList.size()) {
                        File file = (File) listAsList.get(i);
                        if (set != null && !set.contains(file.getAbsolutePath())) {
                            ((File) listAsList.get(i)).delete();
                        }
                        i++;
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private List<com.bykv.vk.openvk.pA.pA.pA.pA.pA> JG() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.bykv.vk.openvk.pA.pA.pA.pA.pA(new File(pA()).listFiles(), com.bykv.vk.openvk.pA.pA.Og.pA.KZx()));
        arrayList.add(new com.bykv.vk.openvk.pA.pA.pA.pA.pA(new File(Og()).listFiles(), com.bykv.vk.openvk.pA.pA.Og.pA.Og()));
        arrayList.add(new com.bykv.vk.openvk.pA.pA.pA.pA.pA(new File(ML()).listFiles(), com.bykv.vk.openvk.pA.pA.Og.pA.ZZv()));
        arrayList.add(new com.bykv.vk.openvk.pA.pA.pA.pA.pA(new File(KZx()).listFiles(), com.bykv.vk.openvk.pA.pA.Og.pA.ML()));
        return arrayList;
    }

    private Set<String> SD() {
        HashSet hashSet = new HashSet();
        for (com.bykv.vk.openvk.pA.pA.Og.pA.pA pAVar : com.bykv.vk.openvk.pA.pA.Og.pA.pA.pA.values()) {
            if (pAVar != null && pAVar.pA() != null) {
                com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZxPA = pAVar.pA();
                hashSet.add(com.bykv.vk.openvk.pA.pA.Og.ML.Og.Og(kZxPA.Og(), kZxPA.Sn()).getAbsolutePath());
                hashSet.add(com.bykv.vk.openvk.pA.pA.Og.ML.Og.KZx(kZxPA.Og(), kZxPA.Sn()).getAbsolutePath());
            }
        }
        for (com.bykv.vk.openvk.pA.pA.Og.pA.Og.Og og : com.bykv.vk.openvk.pA.pA.Og.pA.Og.KZx.pA.values()) {
            if (og != null && og.pA() != null) {
                com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZxPA2 = og.pA();
                hashSet.add(com.bykv.vk.openvk.pA.pA.Og.ML.Og.Og(kZxPA2.Og(), kZxPA2.Sn()).getAbsolutePath());
                hashSet.add(com.bykv.vk.openvk.pA.pA.Og.ML.Og.KZx(kZxPA2.Og(), kZxPA2.Sn()).getAbsolutePath());
            }
        }
        return hashSet;
    }
}
