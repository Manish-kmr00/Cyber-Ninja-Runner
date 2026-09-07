package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
final class z20 extends Lambda implements Function2<JSONObject, q20, Unit> {
    final /* synthetic */ a30 b;
    final /* synthetic */ List<p20> c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    z20(a30 a30Var, ArrayList arrayList) {
        super(2);
        this.b = a30Var;
        this.c = arrayList;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(JSONObject jSONObject, q20 q20Var) {
        Object obj;
        JSONObject node = jSONObject;
        q20 type = q20Var;
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(type, "type");
        this.b.getClass();
        String str = null;
        if (node.has("view_name")) {
            Intrinsics.checkNotNullParameter(node, "<this>");
            Intrinsics.checkNotNullParameter("view_name", "key");
            try {
                obj = node.get("view_name");
            } catch (JSONException unused) {
                obj = null;
            }
            if (obj instanceof String) {
                str = (String) obj;
            }
        }
        if (str != null) {
            this.c.add(new p20(type, str));
        }
        return Unit.INSTANCE;
    }
}
