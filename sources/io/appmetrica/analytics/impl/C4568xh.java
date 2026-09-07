package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.CounterConfiguration;
import org.json.JSONObject;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.xh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public class C4568xh extends C4007b4 {
    protected I8 c;
    protected C4217jf d;
    public boolean e;
    public String f;

    public C4568xh(C4367pf c4367pf, CounterConfiguration counterConfiguration) {
        this(c4367pf, counterConfiguration, null);
    }

    public final void a(Tk tk) {
        this.c = new I8(tk);
    }

    public final Bundle c() {
        Bundle bundle = new Bundle();
        this.b.toBundle(bundle);
        C4367pf c4367pf = this.f11474a;
        synchronized (c4367pf) {
            bundle.putParcelable("PROCESS_CFG_OBJ", c4367pf);
        }
        return bundle;
    }

    public final String d() {
        I8 i8 = this.c;
        if (i8.f11191a.isEmpty()) {
            return null;
        }
        return new JSONObject(i8.f11191a).toString();
    }

    public final synchronized String e() {
        return this.f;
    }

    public boolean f() {
        return this.e;
    }

    public C4568xh(C4367pf c4367pf, CounterConfiguration counterConfiguration, String str) {
        super(c4367pf, counterConfiguration);
        this.e = true;
        this.f = str;
    }
}
