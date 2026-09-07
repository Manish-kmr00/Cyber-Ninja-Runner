package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class Rn implements Qn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final H8 f11338a;

    public Rn() {
        this(new H8());
    }

    @Override // io.appmetrica.analytics.impl.Qn
    public final byte[] a(R8 r8, C4045ch c4045ch) {
        if (!((C4282m5) c4045ch.l).A() && !TextUtils.isEmpty(r8.b)) {
            try {
                JSONObject jSONObject = new JSONObject(r8.b);
                jSONObject.remove("preloadInfo");
                r8.b = jSONObject.toString();
            } catch (Throwable unused) {
            }
        }
        return this.f11338a.a(r8, c4045ch);
    }

    public Rn(H8 h8) {
        this.f11338a = h8;
    }
}
