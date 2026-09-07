package com.yandex.div.internal.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: compiled from: JsonNode.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/yandex/div/internal/util/JsonArray;", "Lcom/yandex/div/internal/util/JsonNode;", "value", "Lorg/json/JSONArray;", "(Lorg/json/JSONArray;)V", "getValue", "()Lorg/json/JSONArray;", "dump", "", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class JsonArray extends JsonNode {
    private final JSONArray value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonArray(JSONArray value) {
        super(null);
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
    }

    public final JSONArray getValue() {
        return this.value;
    }

    @Override // com.yandex.div.internal.util.JsonNode
    public String dump() {
        String string = this.value.toString();
        Intrinsics.checkNotNullExpressionValue(string, "value.toString()");
        return string;
    }
}
