package com.yandex.mobile.ads.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class e80 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d80 f8773a;

    public /* synthetic */ e80() {
        this(new d80());
    }

    public final LinkedHashMap a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            Iterator<String> itKeys = jSONObject.keys();
            if (itKeys.hasNext()) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!jSONObject.isNull(next)) {
                        Object obj = jSONObject.get(next);
                        if (obj instanceof JSONObject) {
                            JSONObject jsonObject = (JSONObject) obj;
                            this.f8773a.getClass();
                            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                            c80 c80Var = (Intrinsics.areEqual(jsonObject.optString("type"), "parcelable") && Intrinsics.areEqual(sq0.a("value", jsonObject), "null")) ? c80.f8577a : null;
                            if (c80Var != null) {
                                Intrinsics.checkNotNull(next);
                                linkedHashMap.put(next, c80Var);
                            }
                        } else {
                            Intrinsics.checkNotNull(next);
                            Intrinsics.checkNotNull(obj);
                            linkedHashMap.put(next, obj);
                        }
                    }
                }
                return linkedHashMap;
            }
        }
        return null;
    }

    public e80(d80 extrasParcelableParser) {
        Intrinsics.checkNotNullParameter(extrasParcelableParser, "extrasParcelableParser");
        this.f8773a = extrasParcelableParser;
    }
}
