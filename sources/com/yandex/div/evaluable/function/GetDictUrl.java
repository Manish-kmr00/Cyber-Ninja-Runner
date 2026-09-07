package com.yandex.div.evaluable.function;

import kotlin.Metadata;

/* JADX INFO: compiled from: DictFunctions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div/evaluable/function/GetDictUrl;", "Lcom/yandex/div/evaluable/function/UrlFromDict;", "()V", "name", "", "getName", "()Ljava/lang/String;", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class GetDictUrl extends UrlFromDict {
    public static final GetDictUrl INSTANCE = new GetDictUrl();
    private static final String name = "getDictUrl";

    private GetDictUrl() {
    }

    @Override // com.yandex.div.evaluable.Function
    public String getName() {
        return name;
    }
}
