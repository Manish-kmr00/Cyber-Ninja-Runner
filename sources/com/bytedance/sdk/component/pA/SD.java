package com.bytedance.sdk.component.pA;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;

/* JADX INFO: loaded from: classes10.dex */
class SD implements BF.pA {
    private final boolean Bzk;
    private final vZF Og;
    private final Wx SD;
    private final com.bytedance.sdk.component.pA.pA SGo;
    private final boolean omh;
    private final omh pA;
    private final Map<String, Og> KZx = new HashMap();
    private final Map<String, ZZv.Og> ZZv = new HashMap();
    private final List<oX> ML = new ArrayList();
    private final Set<ZZv> JG = new HashSet();

    SD(SGo sGo, com.bytedance.sdk.component.pA.pA pAVar, TX tx) {
        this.SGo = pAVar;
        this.pA = sGo.ZZv;
        vZF vzf = new vZF(tx, sGo.WV, sGo.Wx);
        this.Og = vzf;
        vzf.pA(this);
        vzf.pA(sGo.oX);
        this.SD = sGo.Bzk;
        this.omh = sGo.omh;
        this.Bzk = sGo.DX;
    }

    pA pA(oX oXVar, JG jg) throws Exception {
        Og og = this.KZx.get(oXVar.ZZv);
        if (og != null) {
            try {
                WQf wQfOg = Og(jg.Og, og);
                jg.ZZv = wQfOg;
                if (wQfOg == null) {
                    new StringBuilder("Permission denied, call: ").append(oXVar);
                    throw new XT(-1);
                }
                if (og instanceof ML) {
                    new StringBuilder("Processing stateless call: ").append(oXVar);
                    return pA(oXVar, (ML) og, jg);
                }
                if (og instanceof KZx) {
                    new StringBuilder("Processing raw call: ").append(oXVar);
                    return pA(oXVar, (KZx) og, wQfOg);
                }
            } catch (TX.pA unused) {
                new StringBuilder("No remote permission config fetched, call pending: ").append(oXVar);
                this.ML.add(oXVar);
                return new pA(false, TV.pA());
            }
        }
        ZZv.Og og2 = this.ZZv.get(oXVar.ZZv);
        if (og2 != null) {
            ZZv zZvPA = og2.pA();
            zZvPA.pA(oXVar.ZZv);
            WQf wQfOg2 = Og(jg.Og, zZvPA);
            jg.ZZv = wQfOg2;
            if (wQfOg2 == null) {
                new StringBuilder("Permission denied, call: ").append(oXVar);
                zZvPA.ZZv();
                throw new XT(-1);
            }
            new StringBuilder("Processing stateful call: ").append(oXVar);
            return pA(oXVar, zZvPA, jg);
        }
        new StringBuilder("Received call: ").append(oXVar);
        return null;
    }

    void pA(String str, ML<?, ?> ml) {
        ml.pA(str);
        this.KZx.put(str, ml);
    }

    void pA(String str, ZZv.Og og) {
        this.ZZv.put(str, og);
    }

    void pA() {
        Iterator<ZZv> it = this.JG.iterator();
        while (it.hasNext()) {
            it.next().ML();
        }
        this.JG.clear();
        this.KZx.clear();
        this.ZZv.clear();
        this.Og.Og(this);
    }

    private pA pA(oX oXVar, ML ml, JG jg) throws Exception {
        return new pA(true, TV.pA(this.pA.pA(ml.pA(pA(oXVar.ML, (Og) ml), jg))));
    }

    private pA pA(final oX oXVar, final ZZv zZv, JG jg) throws Exception {
        this.JG.add(zZv);
        zZv.pA(pA(oXVar.ML, zZv), jg, new ZZv.pA() { // from class: com.bytedance.sdk.component.pA.SD.1
            @Override // com.bytedance.sdk.component.pA.ZZv.pA
            public void pA(Object obj) {
                if (SD.this.SGo == null) {
                    return;
                }
                SD.this.SGo.Og(TV.pA(SD.this.pA.pA(obj)), oXVar);
                SD.this.JG.remove(zZv);
            }

            @Override // com.bytedance.sdk.component.pA.ZZv.pA
            public void pA(Throwable th) {
                if (SD.this.SGo == null) {
                    return;
                }
                SD.this.SGo.Og(TV.pA(th), oXVar);
                SD.this.JG.remove(zZv);
            }
        });
        return new pA(false, TV.pA());
    }

    private pA pA(final oX oXVar, KZx kZx, WQf wQf) throws Exception {
        new yFO(oXVar.ZZv, wQf, new yFO.pA() { // from class: com.bytedance.sdk.component.pA.SD.2
        });
        return new pA(false, TV.pA());
    }

    private Object pA(String str, Og og) throws JSONException {
        return this.pA.pA(str, pA(og)[0]);
    }

    private WQf Og(String str, Og og) {
        if (this.Bzk) {
            return WQf.PRIVATE;
        }
        return this.Og.pA(this.omh, str, og);
    }

    private static Type[] pA(Object obj) {
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        if (genericSuperclass == null) {
            throw new IllegalStateException("Method is not parameterized?!");
        }
        return ((ParameterizedType) genericSuperclass).getActualTypeArguments();
    }

    static final class pA {
        String Og;
        boolean pA;

        private pA(boolean z, String str) {
            this.pA = z;
            this.Og = str;
        }
    }
}
