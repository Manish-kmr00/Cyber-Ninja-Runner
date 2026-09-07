package com.bytedance.sdk.component.pA;

import android.net.Uri;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes14.dex */
class vZF {
    private final BF KZx = aBv.pA;
    private BSW.pA ML;
    private final Set<String> Og;
    private final TX ZZv;
    private final Set<String> pA;

    vZF(TX tx, Set<String> set, Set<String> set2) {
        this.ZZv = tx;
        if (set == null || set.isEmpty()) {
            this.pA = new LinkedHashSet();
        } else {
            this.pA = new LinkedHashSet(set);
        }
        if (set2 == null || set2.isEmpty()) {
            this.Og = new LinkedHashSet();
        } else {
            this.Og = new LinkedHashSet(set2);
        }
    }

    final synchronized WQf pA(boolean z, String str, Og og) throws TX.pA {
        WQf wQfOg;
        BSW.pA pAVar;
        Uri uri = Uri.parse(str);
        String host = uri.getHost();
        if (host == null) {
            return null;
        }
        WQf wQf = this.Og.contains(og.pA()) ? WQf.PUBLIC : null;
        for (String str2 : this.pA) {
            if (uri.getHost().equals(str2) || host.endsWith(".".concat(String.valueOf(str2)))) {
                wQf = WQf.PRIVATE;
                break;
            }
        }
        if (wQf == null && (pAVar = this.ML) != null && pAVar.pA(str)) {
            if (this.ML.pA(str, og.pA())) {
                return null;
            }
            wQf = WQf.PRIVATE;
        }
        if (z) {
            wQfOg = pA(str, og);
        } else {
            wQfOg = Og(str, og);
        }
        return wQfOg != null ? wQfOg : wQf;
    }

    final synchronized WQf pA(String str, Og og) throws TX.pA {
        return pA(str, og, true);
    }

    final synchronized WQf Og(String str, Og og) {
        return pA(str, og, false);
    }

    void pA(BSW.pA pAVar) {
        this.ML = pAVar;
    }

    void pA(BF.pA pAVar) {
        if (this.KZx != null) {
            throw null;
        }
    }

    void Og(BF.pA pAVar) {
        if (this.KZx != null) {
            throw null;
        }
    }

    private WQf pA(String str, Og og, boolean z) {
        if (!z || this.ZZv == null) {
            return null;
        }
        throw null;
    }
}
