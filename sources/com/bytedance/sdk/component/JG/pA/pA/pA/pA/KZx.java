package com.bytedance.sdk.component.JG.pA.pA.pA.pA;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public abstract class KZx {
    private final Context pA;
    protected final List<com.bytedance.sdk.component.JG.pA.ZZv.pA> Og = new ArrayList();
    private boolean KZx = false;
    private final Runnable ZZv = new Runnable() { // from class: com.bytedance.sdk.component.JG.pA.pA.pA.pA.KZx.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (KZx.this) {
                if (KZx.this.Og.isEmpty()) {
                    KZx.this.KZx = false;
                    return;
                }
                ArrayList arrayList = new ArrayList(KZx.this.Og);
                KZx.this.Og.clear();
                KZx.this.KZx = false;
                KZx.this.ZZv(arrayList);
            }
        }
    };

    public abstract String Og();

    public KZx(Context context) {
        this.pA = context;
    }

    private void pA() {
        if (this.KZx) {
            return;
        }
        com.bytedance.sdk.component.JG.pA.SD.pA.pA().postDelayed(this.ZZv, com.bytedance.sdk.component.JG.pA.SD.pA.Og());
        this.KZx = true;
    }

    protected void KZx(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            Iterator<com.bytedance.sdk.component.JG.pA.ZZv.pA> it = this.Og.iterator();
            while (it.hasNext()) {
                com.bytedance.sdk.component.JG.pA.ZZv.pA next = it.next();
                if (next != null) {
                    String strKZx = next.KZx();
                    if (!TextUtils.isEmpty(strKZx) && list.contains(strKZx)) {
                        it.remove();
                    }
                }
            }
        } catch (Throwable th) {
            Og();
            th.getMessage();
        }
    }

    public synchronized void pA(com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar) {
        if (pAVar.SD() != null && !TextUtils.isEmpty(pAVar.KZx())) {
            this.Og.add(pAVar);
            pA();
        }
    }

    public Context ML() {
        return this.pA;
    }

    public void ZZv(List<com.bytedance.sdk.component.JG.pA.ZZv.pA> list) {
        com.bytedance.sdk.component.JG.pA.pA.pA.KZx.pA(ML(), Og(), list);
    }
}
