package com.bytedance.sdk.component.adexpress.dynamic.animation.pA;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes11.dex */
public class KZx {
    private static volatile KZx pA;

    private KZx() {
    }

    public static KZx pA() {
        if (pA == null) {
            synchronized (KZx.class) {
                if (pA == null) {
                    pA = new KZx();
                }
            }
        }
        return pA;
    }

    public ZZv pA(View view, com.bytedance.sdk.component.adexpress.dynamic.ZZv.pA pAVar) {
        if (pAVar == null) {
            return null;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).setClipChildren(false);
        }
        if (view.getParent().getParent() != null) {
            ((ViewGroup) view.getParent().getParent()).setClipChildren(false);
        }
        if ("scale".equals(pAVar.Bzk())) {
            return new BSW(view, pAVar);
        }
        if ("translate".equals(pAVar.Bzk())) {
            return new DX(view, pAVar);
        }
        if ("ripple".equals(pAVar.Bzk())) {
            return new omh(view, pAVar);
        }
        if ("marquee".equals(pAVar.Bzk())) {
            return new SD(view, pAVar);
        }
        if ("waggle".equals(pAVar.Bzk())) {
            return new oX(view, pAVar);
        }
        if ("shine".equals(pAVar.Bzk())) {
            return new WV(view, pAVar);
        }
        if ("swing".equals(pAVar.Bzk())) {
            return new Sn(view, pAVar);
        }
        if ("fade".equals(pAVar.Bzk())) {
            return new pA(view, pAVar);
        }
        if ("rubIn".equals(pAVar.Bzk())) {
            return new SGo(view, pAVar);
        }
        if ("rotate".equals(pAVar.Bzk())) {
            return new Bzk(view, pAVar);
        }
        if ("cutIn".equals(pAVar.Bzk())) {
            return new JG(view, pAVar);
        }
        if ("stretch".equals(pAVar.Bzk())) {
            return new Wx(view, pAVar);
        }
        if ("bounce".equals(pAVar.Bzk())) {
            return new ML(view, pAVar);
        }
        return null;
    }
}
