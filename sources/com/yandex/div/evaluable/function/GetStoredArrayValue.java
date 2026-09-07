package com.yandex.div.evaluable.function;

import com.yandex.div.evaluable.EvaluableType;
import kotlin.Metadata;
import org.json.JSONArray;

/* JADX INFO: compiled from: StoredValueFunctions.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/yandex/div/evaluable/function/GetStoredArrayValue;", "Lcom/yandex/div/evaluable/function/GetStoredComplexValue;", "Lorg/json/JSONArray;", "()V", "name", "", "getName", "()Ljava/lang/String;", "resultType", "Lcom/yandex/div/evaluable/EvaluableType;", "getResultType", "()Lcom/yandex/div/evaluable/EvaluableType;", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class GetStoredArrayValue extends GetStoredComplexValue<JSONArray> {
    public static final GetStoredArrayValue INSTANCE = new GetStoredArrayValue();
    private static final String name = "getStoredArrayValue";
    private static final EvaluableType resultType = EvaluableType.ARRAY;

    private GetStoredArrayValue() {
    }

    @Override // com.yandex.div.evaluable.Function
    public String getName() {
        return name;
    }

    @Override // com.yandex.div.evaluable.Function
    public EvaluableType getResultType() {
        return resultType;
    }
}
