package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class Ni extends Gg {
    public Ni(C4282m5 c4282m5) {
        super(c4282m5);
        c4282m5.b().a();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0038  */
    @Override // io.appmetrica.analytics.impl.Gg
    public final boolean a(C3984a6 c3984a6) {
        Object objRemove;
        for (Map.Entry entry : c3984a6.p.entrySet()) {
            C4322nk c4322nk = this.f11164a.u;
            String str = (String) entry.getKey();
            byte[] bArr = (byte[]) entry.getValue();
            if (bArr != null) {
                c4322nk.getClass();
                if (bArr.length == 0) {
                    objRemove = c4322nk.b.remove(str);
                } else {
                    objRemove = c4322nk.b.put(str, bArr);
                }
            } else {
                objRemove = c4322nk.b.remove(str);
            }
            C4421rk c4421rk = c4322nk.f11689a;
            Map<String, byte[]> map = c4322nk.b;
            IBinaryDataHelper iBinaryDataHelper = c4421rk.d;
            String str2 = c4421rk.f11754a;
            C4397qk c4397qk = c4421rk.c;
            C4347ok c4347okFromModel = c4421rk.b.fromModel(map);
            c4397qk.getClass();
            iBinaryDataHelper.insert(str2, MessageNano.toByteArray(c4347okFromModel));
        }
        return true;
    }
}
