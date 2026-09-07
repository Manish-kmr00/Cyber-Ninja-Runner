package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import org.json.JSONObject;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.gf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4143gf implements ProtobufConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4093ef f11570a = new C4093ef();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C3993af fromModel(C4118ff c4118ff) {
        C3993af c3993af = new C3993af();
        if (!TextUtils.isEmpty(c4118ff.f11551a)) {
            c3993af.f11463a = c4118ff.f11551a;
        }
        c3993af.b = c4118ff.b.toString();
        c3993af.c = c4118ff.c;
        c3993af.d = c4118ff.d;
        c3993af.e = this.f11570a.fromModel(c4118ff.e).intValue();
        return c3993af;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4118ff toModel(C3993af c3993af) {
        JSONObject jSONObject;
        String str = c3993af.f11463a;
        String str2 = c3993af.b;
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Throwable unused) {
                jSONObject = new JSONObject();
            }
        } else {
            jSONObject = new JSONObject();
        }
        return new C4118ff(str, jSONObject, c3993af.c, c3993af.d, this.f11570a.toModel(Integer.valueOf(c3993af.e)));
    }
}
