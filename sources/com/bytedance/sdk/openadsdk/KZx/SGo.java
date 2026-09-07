package com.bytedance.sdk.openadsdk.KZx;

import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.utils.xy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class SGo {
    private String BSW;
    private String DX;
    protected IListenerManager JG;
    private String Sn;
    private String WV;
    private String Wx;
    private FilterWord XT;
    private int aBv;
    private int oX;
    public static FilterWord pA = new FilterWord("", "");
    public static int Og = 1;
    public static int KZx = 2;
    public static int ZZv = 3;
    public static int ML = 4;
    private final Set<KZx> SD = new HashSet();
    private final Set<Og> omh = new HashSet();
    private final Set<ZZv> Bzk = new HashSet();
    private final Set<pA> SGo = new HashSet();

    public interface KZx {
        void pA(FilterWord filterWord);
    }

    public interface Og {
        void pA(int i);
    }

    public interface ZZv {
        void pA(String str);
    }

    public interface pA {
        void pA(List<FilterWord> list);
    }

    public void pA() {
        this.SD.clear();
        this.omh.clear();
        this.Bzk.clear();
        this.SGo.clear();
    }

    public void pA(String str) {
        this.BSW = str;
    }

    public void Og(String str) {
        this.WV = str;
    }

    public void pA(FilterWord filterWord) {
        this.XT = filterWord;
        SGo();
    }

    public FilterWord Og() {
        return this.XT;
    }

    public boolean KZx() {
        FilterWord filterWord = this.XT;
        return (filterWord == null || filterWord.equals(pA)) ? false : true;
    }

    private void SGo() {
        Iterator<KZx> it = this.SD.iterator();
        while (it.hasNext()) {
            it.next().pA(this.XT);
        }
    }

    public void pA(KZx kZx) {
        this.SD.add(kZx);
    }

    public void pA(Og og) {
        this.omh.add(og);
    }

    public void pA(ZZv zZv) {
        this.Bzk.add(zZv);
    }

    public void pA(pA pAVar) {
        this.SGo.add(pAVar);
    }

    public void ZZv() {
        if (!KZx() && !TextUtils.isEmpty(this.Sn)) {
            this.XT = new FilterWord("0:00", this.Sn);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.XT);
        if (!TextUtils.isEmpty(this.BSW)) {
            if (TextUtils.isEmpty(this.Sn)) {
                com.bytedance.sdk.openadsdk.KZx.Og.pA().pA(this.BSW, arrayList, this.WV);
            } else {
                com.bytedance.sdk.openadsdk.KZx.Og.pA().pA(this.BSW, arrayList, this.DX, this.Sn, this.WV);
            }
        }
        if (!TextUtils.isEmpty(this.Wx)) {
            if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
                ML("onItemClickClosed");
            } else {
                com.bytedance.sdk.openadsdk.core.KZx.ZZv.pA pAVarML = com.bytedance.sdk.openadsdk.core.Bzk.Og().ML(this.Wx);
                if (pAVarML != null) {
                    pAVarML.pA();
                    com.bytedance.sdk.openadsdk.core.Bzk.Og().JG(this.Wx);
                }
            }
        }
        Iterator<Og> it = this.omh.iterator();
        while (it.hasNext()) {
            it.next().pA(Og);
        }
        pA(pA);
        KZx("");
    }

    public void ML() {
        Iterator<Og> it = this.omh.iterator();
        while (it.hasNext()) {
            it.next().pA(KZx);
        }
    }

    public void JG() {
        Iterator<Og> it = this.omh.iterator();
        while (it.hasNext()) {
            it.next().pA(ML);
        }
    }

    public void pA(List<FilterWord> list) {
        Iterator<pA> it = this.SGo.iterator();
        while (it.hasNext()) {
            it.next().pA(list);
        }
    }

    private void ML(final String str) {
        xy.KZx(new com.bytedance.sdk.component.omh.omh("Reward_executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.KZx.SGo.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (TextUtils.isEmpty(SGo.this.Wx)) {
                        return;
                    }
                    SGo.this.pA(6).executeDisLikeClosedCallback(SGo.this.Wx, str);
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.WV.pA("TTDislikeManager", "executeRewardVideoCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    protected IListenerManager pA(int i) {
        if (this.JG == null) {
            this.JG = com.bytedance.sdk.openadsdk.multipro.aidl.pA.pA.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.pA.pA().pA(i));
        }
        return this.JG;
    }

    public static void pA(final int i, final String str, final com.bytedance.sdk.openadsdk.core.KZx.ZZv.pA pAVar) {
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            xy.KZx(new com.bytedance.sdk.component.omh.omh("DislikeClosed_registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.KZx.SGo.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.pA pAVarPA = com.bytedance.sdk.openadsdk.multipro.aidl.pA.pA();
                    if (i != 6 || pAVar == null) {
                        return;
                    }
                    try {
                        com.bytedance.sdk.openadsdk.multipro.aidl.Og.Og og = new com.bytedance.sdk.openadsdk.multipro.aidl.Og.Og(str, pAVar);
                        IListenerManager iListenerManagerAsInterface = com.bytedance.sdk.openadsdk.multipro.aidl.pA.ZZv.asInterface(pAVarPA.pA(6));
                        if (iListenerManagerAsInterface != null) {
                            iListenerManagerAsInterface.registerDisLikeClosedListener(str, og);
                        }
                    } catch (RemoteException e) {
                        com.bytedance.sdk.component.utils.WV.pA("TTDislikeManager", e.getMessage());
                    }
                }
            }, 5);
        }
    }

    public static void pA(final int i, final String str) {
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            xy.KZx(new com.bytedance.sdk.component.omh.omh("DislikeClosed_unregisterMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.KZx.SGo.3
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.pA pAVarPA = com.bytedance.sdk.openadsdk.multipro.aidl.pA.pA();
                    if (i == 6) {
                        try {
                            IListenerManager iListenerManagerAsInterface = com.bytedance.sdk.openadsdk.multipro.aidl.pA.ZZv.asInterface(pAVarPA.pA(6));
                            if (iListenerManagerAsInterface != null) {
                                iListenerManagerAsInterface.unregisterDisLikeClosedListener(str);
                            }
                        } catch (RemoteException unused) {
                        }
                    }
                }
            }, 5);
        }
    }

    public void KZx(String str) {
        this.Sn = str;
        Iterator<ZZv> it = this.Bzk.iterator();
        while (it.hasNext()) {
            it.next().pA(this.Sn);
        }
    }

    public String SD() {
        return this.Sn;
    }

    public void ZZv(String str) {
        this.DX = str;
    }

    public void pA(int i, int i2) {
        this.oX = i;
        this.aBv = i2;
    }

    public int omh() {
        return this.oX;
    }

    public boolean Bzk() {
        return this.oX < this.aBv;
    }
}
