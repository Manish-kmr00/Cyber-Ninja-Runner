package com.yandex.div.evaluable.function;

import kotlin.Metadata;

/* JADX INFO: compiled from: ArrayFunctions.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/yandex/div/evaluable/function/ArrayGetNumber;", "Lcom/yandex/div/evaluable/function/ArrayNumber;", "()V", "isMethod", "", "()Z", "name", "", "getName", "()Ljava/lang/String;", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ArrayGetNumber extends ArrayNumber {
    public static final ArrayGetNumber INSTANCE = new ArrayGetNumber();
    private static final String name = "getNumber";
    private static final boolean isMethod = true;

    private ArrayGetNumber() {
    }

    @Override // com.yandex.div.evaluable.Function
    public String getName() {
        return name;
    }

    @Override // com.yandex.div.evaluable.function.ArrayFunction
    /* JADX INFO: renamed from: isMethod */
    public boolean getIsMethod() {
        return isMethod;
    }
}
