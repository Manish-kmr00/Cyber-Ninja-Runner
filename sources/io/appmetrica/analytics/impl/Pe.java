package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class Pe implements ProtobufConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4093ef f11295a;

    public Pe() {
        this(new C4093ef());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4018bf fromModel(Re re) {
        C4018bf c4018bf = new C4018bf();
        if (!TextUtils.isEmpty(re.f11330a)) {
            c4018bf.f11479a = re.f11330a;
        }
        c4018bf.b = re.b.toString();
        c4018bf.c = this.f11295a.fromModel(re.c).intValue();
        return c4018bf;
    }

    public Pe(C4093ef c4093ef) {
        this.f11295a = c4093ef;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Re toModel(C4018bf c4018bf) {
        JSONObject jSONObject;
        String str = c4018bf.f11479a;
        String str2 = c4018bf.b;
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Throwable unused) {
                jSONObject = new JSONObject();
            }
        } else {
            jSONObject = new JSONObject();
        }
        return new Re(str, jSONObject, this.f11295a.toModel(Integer.valueOf(c4018bf.c)));
    }
}
