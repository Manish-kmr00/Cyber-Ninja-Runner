package com.fyber.inneractive.sdk.config.global.features;

import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes13.dex */
public abstract class h extends com.fyber.inneractive.sdk.config.global.p {
    public String b;
    public HashMap c = new HashMap();
    public HashMap d = new HashMap();

    public h(String str) {
        this.b = str;
    }

    @Override // com.fyber.inneractive.sdk.config.global.p, com.fyber.inneractive.sdk.config.global.n
    public final String a(String str, String str2) {
        String strB;
        Iterator it = this.d.keySet().iterator();
        do {
            if (!it.hasNext()) {
                strB = null;
                break;
            }
            strB = ((com.fyber.inneractive.sdk.config.global.k) this.d.get((String) it.next())).b(str);
        } while (strB == null);
        if (strB != null) {
            return strB;
        }
        com.fyber.inneractive.sdk.config.global.n nVar = this.f1706a;
        return nVar != null ? nVar.a(str, str2) : str2;
    }

    @Override // com.fyber.inneractive.sdk.config.global.p, com.fyber.inneractive.sdk.config.global.n
    public final String b(String str) {
        return a(str, null);
    }

    public abstract h c();

    /* JADX WARN: Code duplicated, block: B:10:0x0028  */
    /* JADX WARN: Code duplicated, block: B:15:? A[RETURN, SYNTHETIC] */
    @Override // com.fyber.inneractive.sdk.config.global.p, com.fyber.inneractive.sdk.config.global.n
    public final Boolean c(String str) {
        Boolean boolC;
        Iterator it = this.d.keySet().iterator();
        while (it.hasNext()) {
            boolC = ((com.fyber.inneractive.sdk.config.global.k) this.d.get((String) it.next())).c(str);
            if (boolC != null) {
                if (boolC == null) {
                    return super.c(str);
                }
                return boolC;
            }
        }
        boolC = null;
        if (boolC == null) {
            return super.c(str);
        }
        return boolC;
    }

    public final String toString() {
        return String.format("id: %s, params: %s exp: %s", this.b, this.f1706a, this.c);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0028  */
    /* JADX WARN: Code duplicated, block: B:15:? A[RETURN, SYNTHETIC] */
    @Override // com.fyber.inneractive.sdk.config.global.p, com.fyber.inneractive.sdk.config.global.n
    public final Double a() {
        Double dA;
        Iterator it = this.d.keySet().iterator();
        while (it.hasNext()) {
            dA = ((com.fyber.inneractive.sdk.config.global.k) this.d.get((String) it.next())).a();
            if (dA != null) {
                if (dA == null) {
                    return super.a();
                }
                return dA;
            }
        }
        dA = null;
        if (dA == null) {
            return super.a();
        }
        return dA;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0028  */
    /* JADX WARN: Code duplicated, block: B:15:? A[RETURN, SYNTHETIC] */
    @Override // com.fyber.inneractive.sdk.config.global.p, com.fyber.inneractive.sdk.config.global.n
    public final Integer a(String str) {
        Integer numA;
        Iterator it = this.d.keySet().iterator();
        while (it.hasNext()) {
            numA = ((com.fyber.inneractive.sdk.config.global.k) this.d.get((String) it.next())).a(str);
            if (numA != null) {
                if (numA == null) {
                    return super.a(str);
                }
                return numA;
            }
        }
        numA = null;
        if (numA == null) {
            return super.a(str);
        }
        return numA;
    }

    public final void a(h hVar) {
        hVar.b = this.b;
        hVar.f1706a = this.f1706a;
        hVar.c = new HashMap(this.c);
        hVar.d = new HashMap(this.d);
    }
}
