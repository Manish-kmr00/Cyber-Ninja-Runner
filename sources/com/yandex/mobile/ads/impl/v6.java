package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonObjectBuilder;

/* JADX INFO: loaded from: classes4.dex */
final class v6 extends Lambda implements Function1<JsonObjectBuilder, Unit> {
    final /* synthetic */ Map.Entry<String, c7> b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    v6(Map.Entry<String, c7> entry) {
        super(1);
        this.b = entry;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(JsonObjectBuilder jsonObjectBuilder) {
        JsonObjectBuilder putJsonObject = jsonObjectBuilder;
        Intrinsics.checkNotNullParameter(putJsonObject, "$this$putJsonObject");
        JsonElementBuildersKt.put(putJsonObject, "usagePercent", Integer.valueOf(this.b.getValue().b()));
        JsonElementBuildersKt.put(putJsonObject, "isDisabled", Boolean.valueOf(this.b.getValue().a()));
        return Unit.INSTANCE;
    }
}
