package com.yandex.div.internal.parser;

import com.json.cc;
import com.yandex.div.json.JSONSerializable;
import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.ParsingErrorLogger;
import com.yandex.div.json.ParsingException;
import com.yandex.div.json.ParsingExceptionKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: JsonParserInternals.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001ab\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\b2\u0006\u0010\t\u001a\u00020\n2&\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\fj\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u000fH\u0001\u001a+\u0010\u0010\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\u0002H\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0081\bø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001ad\u0010\u0015\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\b2\u0006\u0010\t\u001a\u00020\n2&\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\fj\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u000fH\u0001\u001a\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u0003*\u00020\r2\u0006\u0010\u0017\u001a\u00020\u000eH\u0001\u001a\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u001a\u001c\u0010\u0018\u001a\u00020\r\"\b\b\u0000\u0010\u0002*\u00020\u0019*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0001\u001a{\u0010\u001a\u001a\u0004\u0018\u0001H\u001b\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u001b*\u00020\u0019*B\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b( \u0012\u0004\u0012\u0002H\u001b0\fj\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u001b`!2\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\"\u001a\u0002H\u00022\u0006\u0010\t\u001a\u00020\nH\u0001¢\u0006\u0002\u0010#*v\u0010$\u001a\u0004\b\u0000\u0010\u0002\u001a\u0004\b\u0001\u0010\u001b\"2\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b( \u0012\u0004\u0012\u0002H\u001b0\f22\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b( \u0012\u0004\u0012\u0002H\u001b0\f*6\b\u0000\u0010%\u001a\u0004\b\u0000\u0010\u0002\"\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002H\u00020\f2\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002H\u00020\f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006&"}, d2 = {"getList", "", "T", "", "Lorg/json/JSONObject;", "key", "", "validator", "Lcom/yandex/div/internal/parser/ListValidator;", "logger", "Lcom/yandex/div/json/ParsingErrorLogger;", "itemReader", "Lkotlin/Function2;", "Lorg/json/JSONArray;", "", "Lcom/yandex/div/internal/parser/ItemReader;", "onNull", "block", "Lkotlin/Function0;", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "optList", "optSafe", "index", "toJsonArray", "Lcom/yandex/div/json/JSONSerializable;", "tryCreate", "R", "Lcom/yandex/div/json/ParsingEnvironment;", "Lkotlin/ParameterName;", "name", cc.o, "value", "Lcom/yandex/div/internal/parser/Creator;", "arg", "(Lkotlin/jvm/functions/Function2;Lcom/yandex/div/json/ParsingEnvironment;Ljava/lang/Object;Lcom/yandex/div/json/ParsingErrorLogger;)Lcom/yandex/div/json/JSONSerializable;", "Creator", "ItemReader", "div-data_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class JsonParserInternalsKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R extends JSONSerializable> R tryCreate(Function2<? super ParsingEnvironment, ? super T, ? extends R> function2, ParsingEnvironment env, T t, ParsingErrorLogger logger) {
        Intrinsics.checkNotNullParameter(function2, "<this>");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(logger, "logger");
        try {
            return function2.invoke(env, t);
        } catch (ParsingException e) {
            logger.logError(e);
            return null;
        }
    }

    public static final Object optSafe(JSONObject jSONObject, String key) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Object objOpt = jSONObject.opt(key);
        if (Intrinsics.areEqual(objOpt, JSONObject.NULL)) {
            return null;
        }
        return objOpt;
    }

    public static final Object optSafe(JSONArray jSONArray, int i) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        Object objOpt = jSONArray.opt(i);
        if (Intrinsics.areEqual(objOpt, JSONObject.NULL)) {
            return null;
        }
        return objOpt;
    }

    public static final <T> List<T> getList(JSONObject jSONObject, String key, ListValidator<T> validator, ParsingErrorLogger logger, Function2<? super JSONArray, ? super Integer, ? extends T> itemReader) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(itemReader, "itemReader");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(key);
        if (jSONArrayOptJSONArray == null) {
            throw ParsingExceptionKt.missingValue(jSONObject, key);
        }
        int length = jSONArrayOptJSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            T tInvoke = itemReader.invoke(jSONArrayOptJSONArray, Integer.valueOf(i));
            if (tInvoke != null) {
                arrayList.add(tInvoke);
            }
        }
        if (validator.isValid(arrayList)) {
            return arrayList;
        }
        throw ParsingExceptionKt.invalidValue(jSONObject, key, arrayList);
    }

    public static final <T> List<T> optList(JSONObject jSONObject, String key, ListValidator<T> validator, ParsingErrorLogger logger, Function2<? super JSONArray, ? super Integer, ? extends T> itemReader) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(itemReader, "itemReader");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(key);
        if (jSONArrayOptJSONArray == null) {
            return null;
        }
        int length = jSONArrayOptJSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            T tInvoke = itemReader.invoke(jSONArrayOptJSONArray, Integer.valueOf(i));
            if (tInvoke != null) {
                arrayList.add(tInvoke);
            }
        }
        if (validator.isValid(arrayList)) {
            return arrayList;
        }
        logger.logError(ParsingExceptionKt.invalidValue(jSONObject, key, arrayList));
        return null;
    }

    public static final <T extends JSONSerializable> JSONArray toJsonArray(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(((JSONSerializable) it.next()).writeToJSON());
        }
        return jSONArray;
    }

    public static final <T> T onNull(T t, Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (t == null) {
            block.invoke();
        }
        return t;
    }
}
