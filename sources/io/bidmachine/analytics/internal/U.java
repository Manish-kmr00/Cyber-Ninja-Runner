package io.bidmachine.analytics.internal;

import kotlin.collections.MapsKt;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public abstract class U {
    public static final T a(Q q) {
        byte[] bytes;
        JSONObject jSONObjectA;
        String string;
        byte[] bytes2 = q.a().isEmpty() ? new byte[0] : s0.a(q.a()).toString().getBytes(Charsets.UTF_8);
        String strC = q.c();
        String strD = q.d();
        String strE = q.e();
        long jF = q.f();
        q0 q0VarB = q.b();
        if (q0VarB == null || (jSONObjectA = r0.a(q0VarB)) == null || (string = jSONObjectA.toString()) == null || (bytes = string.getBytes(Charsets.UTF_8)) == null) {
            bytes = new byte[0];
        }
        return new T(strC, strD, strE, jF, bytes2, bytes);
    }

    public static final Q a(T t) {
        return new Q(t.c(), t.d(), t.e(), t.f(), t.a().length == 0 ? MapsKt.emptyMap() : s0.a(new JSONObject(new String(t.a(), Charsets.UTF_8))), t.b().length == 0 ? null : r0.a(new JSONObject(new String(t.b(), Charsets.UTF_8))));
    }
}
