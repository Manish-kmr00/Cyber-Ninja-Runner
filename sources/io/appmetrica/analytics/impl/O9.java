package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.Map;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class O9 extends Gg {
    public final P9 b;

    public O9(C4282m5 c4282m5, TimeProvider timeProvider) {
        super(c4282m5);
        this.b = new P9(c4282m5, timeProvider);
    }

    @Override // io.appmetrica.analytics.impl.Gg
    public final boolean a(C3984a6 c3984a6) {
        long jOptLong;
        P9 p9 = this.b;
        I9 i9 = p9.f11294a.s().C;
        Long lValueOf = i9 != null ? Long.valueOf(i9.f11192a) : null;
        if (lValueOf != null) {
            Un un = p9.f11294a.t;
            synchronized (un) {
                jOptLong = un.f11384a.a().optLong("external_attribution_window_start", -1L);
            }
            if (jOptLong < 0) {
                jOptLong = p9.b.currentTimeMillis();
                p9.f11294a.t.a(jOptLong);
            }
            if (p9.b.currentTimeMillis() - jOptLong <= lValueOf.longValue()) {
                H9 h9 = (H9) MessageNano.mergeFrom(new H9(), c3984a6.getValueBytes());
                int i = h9.f11174a;
                String str = new String(h9.b, Charsets.UTF_8);
                String str2 = this.b.f11294a.c.j().get(Integer.valueOf(i));
                if (str2 != null) {
                    try {
                        if (JsonUtils.isEqualTo(new JSONObject(str), new JSONObject(str2))) {
                            this.f11164a.m.info("Ignoring attribution of type `" + R9.a(i) + "` with value `" + str + "` since it is not new", new Object[0]);
                            return true;
                        }
                    } catch (Throwable unused) {
                    }
                }
                P9 p10 = this.b;
                Map<Integer, String> mapJ = p10.f11294a.c.j();
                mapJ.put(Integer.valueOf(i), str);
                p10.f11294a.c.a(mapJ);
                this.f11164a.m.info("Handling attribution of type `" + R9.a(i) + '`', new Object[0]);
                return false;
            }
        }
        this.f11164a.m.info("Ignoring attribution since out of collecting interval", new Object[0]);
        return true;
    }
}
