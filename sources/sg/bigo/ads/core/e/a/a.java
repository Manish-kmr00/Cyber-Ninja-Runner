package sg.bigo.ads.core.e.a;

import java.util.Arrays;
import java.util.Map;
import sg.bigo.ads.api.core.r;
import sg.bigo.ads.common.utils.k;

/* JADX INFO: loaded from: classes5.dex */
public final class a extends b {
    public a(r rVar, d[] dVarArr, d[] dVarArr2, d[] dVarArr3, d[] dVarArr4, Map<String, String> map) {
        super(rVar);
        this.f13558a.addAll(Arrays.asList(dVarArr));
        this.b.addAll(Arrays.asList(dVarArr2));
        this.c.addAll(Arrays.asList(dVarArr3));
        this.d.addAll(Arrays.asList(dVarArr4));
        for (Map.Entry<String, String> entry : map.entrySet()) {
            a(entry.getKey(), entry.getValue());
        }
    }

    public final void a(Map<String, String> map) {
        if (k.a(map)) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            a(entry.getKey(), entry.getValue());
        }
    }
}
