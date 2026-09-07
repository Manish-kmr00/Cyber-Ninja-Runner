package com.yandex.div.json;

import com.json.cc;
import com.yandex.div.data.EntityTemplate;
import com.yandex.div.json.JSONSerializable;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: compiled from: JsonTemplate.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003J\u001d\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¢\u0006\u0002\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/json/JsonTemplate;", "T", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/EntityTemplate;", "resolve", cc.o, "Lcom/yandex/div/json/ParsingEnvironment;", "data", "Lorg/json/JSONObject;", "(Lcom/yandex/div/json/ParsingEnvironment;Lorg/json/JSONObject;)Lcom/yandex/div/json/JSONSerializable;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface JsonTemplate<T extends JSONSerializable> extends EntityTemplate<T> {
    T resolve(ParsingEnvironment env, JSONObject data);
}
