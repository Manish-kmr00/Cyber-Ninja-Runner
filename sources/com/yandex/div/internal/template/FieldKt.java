package com.yandex.div.internal.template;

import com.json.cc;
import com.yandex.div.internal.parser.JsonParser;
import com.yandex.div.internal.parser.ListValidator;
import com.yandex.div.json.JSONSerializable;
import com.yandex.div.json.JsonTemplate;
import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.ParsingException;
import com.yandex.div.json.ParsingExceptionKt;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: Field.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u001a&\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001al\u0010\u0005\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b27\u0010\f\u001a3\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u0002H\u00020\rj\b\u0012\u0004\u0012\u0002H\u0002`\u0010¢\u0006\u0002\u0010\u0011\u001a9\u0010\u0012\u001a\u0002H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0013*\b\u0012\u0004\u0012\u0002H\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0002\u0010\u0015\u001a\u0083\u0001\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0017\"\b\b\u0000\u0010\u0002*\u00020\u0018*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00170\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2C\u0010\f\u001a?\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00170\rj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0017`\u0010\u001a\u0083\u0001\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u001a\"\b\b\u0000\u0010\u0002*\u00020\u0018*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u001a0\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2C\u0010\f\u001a?\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u001a0\rj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u001a`\u0010\u001a\u0091\u0001\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u001c\"\u0004\b\u0000\u0010\u0002*\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00020\u001c0\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00020\u001e2C\u0010\f\u001a?\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u001c0\rj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u001c`\u0010\u001ar\u0010\u001f\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2;\u0010\f\u001a7\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0006\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\rj\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0010¢\u0006\u0002\u0010\u0011\u001a3\u0010 \u001a\u0004\u0018\u0001H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0013*\b\u0012\u0004\u0012\u0002H\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0002\u0010!\u001a\u0089\u0001\u0010\"\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0017\"\b\b\u0000\u0010\u0002*\u00020\u0018*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00170\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2G\u0010\f\u001aC\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0006\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00170\rj\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0017`\u0010\u001a\u0089\u0001\u0010#\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u001a\"\b\b\u0000\u0010\u0002*\u00020\u0018*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u001a0\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2G\u0010\f\u001aC\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0006\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u001a0\rj\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u001a`\u0010\u001a\u0097\u0001\u0010$\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u001c\"\u0004\b\u0000\u0010\u0002*\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00020\u001c0\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00020\u001e2G\u0010\f\u001aC\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0006\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u001c0\rj\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u001c`\u0010\u001a~\u0010%\u001a\u0004\u0018\u0001H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0013*\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00140\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2;\u0010\f\u001a7\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0006\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\rj\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0010¢\u0006\u0002\u0010&\u001a¡\u0001\u0010'\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u001c\"\b\b\u0000\u0010\u0002*\u00020\u0013*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00140\u001c0\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00020\u001e2G\u0010\f\u001aC\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0006\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u001c0\rj\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u001c`\u0010\u001ax\u0010(\u001a\u0002H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0013*\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00140\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b27\u0010\f\u001a3\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u0002H\u00020\rj\b\u0012\u0004\u0012\u0002H\u0002`\u0010¢\u0006\u0002\u0010&\u001a\u009b\u0001\u0010)\u001a\b\u0012\u0004\u0012\u0002H\u00020\u001c\"\b\b\u0000\u0010\u0002*\u00020\u0013*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00140\u001c0\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00020\u001e2C\u0010\f\u001a?\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u001c0\rj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u001c`\u0010*^\u0010*\u001a\u0004\b\u0000\u0010\u0002\")\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u0002H\u00020\r2)\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u0002H\u00020\r¨\u0006+"}, d2 = {"clone", "Lcom/yandex/div/internal/template/Field;", "T", "overridable", "", "resolve", cc.o, "Lcom/yandex/div/json/ParsingEnvironment;", "key", "", "data", "Lorg/json/JSONObject;", "reader", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Lcom/yandex/div/internal/template/Reader;", "(Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/json/ParsingEnvironment;Ljava/lang/String;Lorg/json/JSONObject;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "resolveDependency", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/json/JsonTemplate;", "(Lcom/yandex/div/json/JsonTemplate;Lcom/yandex/div/json/ParsingEnvironment;Ljava/lang/String;Lorg/json/JSONObject;)Lcom/yandex/div/json/JSONSerializable;", "resolveExpression", "Lcom/yandex/div/json/expressions/Expression;", "", "resolveExpressionList", "Lcom/yandex/div/json/expressions/ExpressionList;", "resolveList", "", "validator", "Lcom/yandex/div/internal/parser/ListValidator;", "resolveOptional", "resolveOptionalDependency", "(Lcom/yandex/div/json/JsonTemplate;Lcom/yandex/div/json/ParsingEnvironment;Lorg/json/JSONObject;)Lcom/yandex/div/json/JSONSerializable;", "resolveOptionalExpression", "resolveOptionalExpressionList", "resolveOptionalList", "resolveOptionalTemplate", "(Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/json/ParsingEnvironment;Ljava/lang/String;Lorg/json/JSONObject;Lkotlin/jvm/functions/Function3;)Lcom/yandex/div/json/JSONSerializable;", "resolveOptionalTemplateList", "resolveTemplate", "resolveTemplateList", "Reader", "div-data_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class FieldKt {
    public static final <T> T resolve(Field<T> field, ParsingEnvironment env, String key, JSONObject data, Function3<? super String, ? super JSONObject, ? super ParsingEnvironment, ? extends T> reader) {
        Intrinsics.checkNotNullParameter(field, "<this>");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(reader, "reader");
        if (field.overridable && data.has(key)) {
            return reader.invoke(key, data, env);
        }
        if (field instanceof Field.Value) {
            return ((Field.Value) field).value;
        }
        if (field instanceof Field.Reference) {
            return reader.invoke(((Field.Reference) field).reference, data, env);
        }
        throw ParsingExceptionKt.missingValue(data, key);
    }

    public static final <T> T resolveOptional(Field<T> field, ParsingEnvironment env, String key, JSONObject data, Function3<? super String, ? super JSONObject, ? super ParsingEnvironment, ? extends T> reader) {
        Intrinsics.checkNotNullParameter(field, "<this>");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(reader, "reader");
        if (field.overridable && data.has(key)) {
            return reader.invoke(key, data, env);
        }
        if (field instanceof Field.Value) {
            return ((Field.Value) field).value;
        }
        if (field instanceof Field.Reference) {
            return reader.invoke(((Field.Reference) field).reference, data, env);
        }
        return null;
    }

    public static /* synthetic */ List resolveList$default(Field field, ParsingEnvironment parsingEnvironment, String str, JSONObject jSONObject, ListValidator listValidator, Function3 function3, int i, Object obj) {
        if ((i & 8) != 0) {
            listValidator = JsonParser.alwaysValidList();
            Intrinsics.checkNotNullExpressionValue(listValidator, "alwaysValidList()");
        }
        return resolveList(field, parsingEnvironment, str, jSONObject, listValidator, function3);
    }

    public static final <T> List<T> resolveList(Field<? extends List<? extends T>> field, ParsingEnvironment env, String key, JSONObject data, ListValidator<T> validator, Function3<? super String, ? super JSONObject, ? super ParsingEnvironment, ? extends List<? extends T>> reader) {
        List<? extends T> listInvoke;
        Intrinsics.checkNotNullParameter(field, "<this>");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(reader, "reader");
        if (field.overridable && data.has(key)) {
            listInvoke = reader.invoke(key, data, env);
        } else if (field instanceof Field.Value) {
            listInvoke = (List) ((Field.Value) field).value;
        } else {
            if (!(field instanceof Field.Reference)) {
                throw ParsingExceptionKt.missingValue(data, key);
            }
            listInvoke = reader.invoke(((Field.Reference) field).reference, data, env);
        }
        if (validator.isValid(listInvoke)) {
            return listInvoke;
        }
        throw ParsingExceptionKt.invalidValue(data, key, listInvoke);
    }

    public static /* synthetic */ List resolveOptionalList$default(Field field, ParsingEnvironment parsingEnvironment, String str, JSONObject jSONObject, ListValidator listValidator, Function3 function3, int i, Object obj) {
        if ((i & 8) != 0) {
            listValidator = JsonParser.alwaysValidList();
            Intrinsics.checkNotNullExpressionValue(listValidator, "alwaysValidList()");
        }
        return resolveOptionalList(field, parsingEnvironment, str, jSONObject, listValidator, function3);
    }

    public static final <T> List<T> resolveOptionalList(Field<? extends List<? extends T>> field, ParsingEnvironment env, String key, JSONObject data, ListValidator<T> validator, Function3<? super String, ? super JSONObject, ? super ParsingEnvironment, ? extends List<? extends T>> reader) {
        List<? extends T> listInvoke;
        Intrinsics.checkNotNullParameter(field, "<this>");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(reader, "reader");
        if (field.overridable && data.has(key)) {
            listInvoke = reader.invoke(key, data, env);
        } else if (field instanceof Field.Value) {
            listInvoke = (List) ((Field.Value) field).value;
        } else {
            listInvoke = field instanceof Field.Reference ? reader.invoke(((Field.Reference) field).reference, data, env) : null;
        }
        if (listInvoke == null) {
            return null;
        }
        if (validator.isValid(listInvoke)) {
            return (List<T>) listInvoke;
        }
        env.getLogger().logError(ParsingExceptionKt.invalidValue(data, key, listInvoke));
        return null;
    }

    public static final <T extends JSONSerializable> T resolveTemplate(Field<? extends JsonTemplate<T>> field, ParsingEnvironment env, String key, JSONObject data, Function3<? super String, ? super JSONObject, ? super ParsingEnvironment, ? extends T> reader) {
        Intrinsics.checkNotNullParameter(field, "<this>");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(reader, "reader");
        if (field.overridable && data.has(key)) {
            return reader.invoke(key, data, env);
        }
        if (field instanceof Field.Value) {
            return (T) resolveDependency((JsonTemplate) ((Field.Value) field).value, env, key, data);
        }
        if (field instanceof Field.Reference) {
            return reader.invoke(((Field.Reference) field).reference, data, env);
        }
        throw ParsingExceptionKt.missingValue(data, key);
    }

    public static final <T extends JSONSerializable> T resolveOptionalTemplate(Field<? extends JsonTemplate<T>> field, ParsingEnvironment env, String key, JSONObject data, Function3<? super String, ? super JSONObject, ? super ParsingEnvironment, ? extends T> reader) {
        Intrinsics.checkNotNullParameter(field, "<this>");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(reader, "reader");
        if (field.overridable && data.has(key)) {
            return reader.invoke(key, data, env);
        }
        if (field instanceof Field.Value) {
            return (T) resolveOptionalDependency((JsonTemplate) ((Field.Value) field).value, env, data);
        }
        if (field instanceof Field.Reference) {
            return reader.invoke(((Field.Reference) field).reference, data, env);
        }
        return null;
    }

    public static /* synthetic */ List resolveTemplateList$default(Field field, ParsingEnvironment parsingEnvironment, String str, JSONObject jSONObject, ListValidator listValidator, Function3 function3, int i, Object obj) {
        if ((i & 8) != 0) {
            listValidator = JsonParser.alwaysValidList();
            Intrinsics.checkNotNullExpressionValue(listValidator, "alwaysValidList()");
        }
        return resolveTemplateList(field, parsingEnvironment, str, jSONObject, listValidator, function3);
    }

    public static final <T extends JSONSerializable> List<T> resolveTemplateList(Field<? extends List<? extends JsonTemplate<T>>> field, ParsingEnvironment env, String key, JSONObject data, ListValidator<T> validator, Function3<? super String, ? super JSONObject, ? super ParsingEnvironment, ? extends List<? extends T>> reader) {
        List<? extends T> listInvoke;
        Intrinsics.checkNotNullParameter(field, "<this>");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(reader, "reader");
        if (field.overridable && data.has(key)) {
            listInvoke = reader.invoke(key, data, env);
        } else if (!(field instanceof Field.Value)) {
            if (!(field instanceof Field.Reference)) {
                throw ParsingExceptionKt.missingValue(data, key);
            }
            listInvoke = reader.invoke(((Field.Reference) field).reference, data, env);
        } else {
            Iterable iterable = (Iterable) ((Field.Value) field).value;
            ArrayList arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                JSONSerializable jSONSerializableResolveOptionalDependency = resolveOptionalDependency((JsonTemplate) it.next(), env, data);
                if (jSONSerializableResolveOptionalDependency != null) {
                    arrayList.add(jSONSerializableResolveOptionalDependency);
                }
            }
            listInvoke = arrayList;
        }
        if (validator.isValid(listInvoke)) {
            return listInvoke;
        }
        throw ParsingExceptionKt.invalidValue(data, key, listInvoke);
    }

    public static /* synthetic */ List resolveOptionalTemplateList$default(Field field, ParsingEnvironment parsingEnvironment, String str, JSONObject jSONObject, ListValidator listValidator, Function3 function3, int i, Object obj) {
        if ((i & 8) != 0) {
            listValidator = JsonParser.alwaysValidList();
            Intrinsics.checkNotNullExpressionValue(listValidator, "alwaysValidList()");
        }
        return resolveOptionalTemplateList(field, parsingEnvironment, str, jSONObject, listValidator, function3);
    }

    public static final <T extends JSONSerializable> List<T> resolveOptionalTemplateList(Field<? extends List<? extends JsonTemplate<T>>> field, ParsingEnvironment env, String key, JSONObject data, ListValidator<T> validator, Function3<? super String, ? super JSONObject, ? super ParsingEnvironment, ? extends List<? extends T>> reader) {
        List<? extends T> listInvoke;
        Intrinsics.checkNotNullParameter(field, "<this>");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(reader, "reader");
        if (field.overridable && data.has(key)) {
            listInvoke = reader.invoke(key, data, env);
        } else if (!(field instanceof Field.Value)) {
            listInvoke = field instanceof Field.Reference ? reader.invoke(((Field.Reference) field).reference, data, env) : null;
        } else {
            Iterable iterable = (Iterable) ((Field.Value) field).value;
            ArrayList arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                JSONSerializable jSONSerializableResolveOptionalDependency = resolveOptionalDependency((JsonTemplate) it.next(), env, data);
                if (jSONSerializableResolveOptionalDependency != null) {
                    arrayList.add(jSONSerializableResolveOptionalDependency);
                }
            }
            listInvoke = arrayList;
        }
        if (listInvoke == null) {
            return null;
        }
        if (validator.isValid(listInvoke)) {
            return (List<T>) listInvoke;
        }
        env.getLogger().logError(ParsingExceptionKt.invalidValue(data, key, listInvoke));
        return null;
    }

    public static final <T extends JSONSerializable> T resolveDependency(JsonTemplate<T> jsonTemplate, ParsingEnvironment env, String key, JSONObject data) {
        Intrinsics.checkNotNullParameter(jsonTemplate, "<this>");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            return (T) jsonTemplate.resolve(env, data);
        } catch (ParsingException e) {
            throw ParsingExceptionKt.dependencyFailed(data, key, e);
        }
    }

    public static final <T extends JSONSerializable> T resolveOptionalDependency(JsonTemplate<T> jsonTemplate, ParsingEnvironment env, JSONObject data) {
        Intrinsics.checkNotNullParameter(jsonTemplate, "<this>");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            return (T) jsonTemplate.resolve(env, data);
        } catch (ParsingException e) {
            env.getLogger().logError(e);
            return null;
        }
    }

    public static final <T> Field<T> clone(Field<T> field, boolean z) {
        if (field == null || Intrinsics.areEqual(field, Field.Null.INSTANCE) || Intrinsics.areEqual(field, Field.Placeholder.INSTANCE)) {
            return Field.INSTANCE.nullField(z);
        }
        if (field instanceof Field.Value) {
            return new Field.Value(z, ((Field.Value) field).value);
        }
        if (field instanceof Field.Reference) {
            return new Field.Reference(z, ((Field.Reference) field).reference);
        }
        throw new IllegalStateException("Unknown field type");
    }

    public static final <T> Expression<T> resolveExpression(Field<Expression<T>> field, ParsingEnvironment env, String key, JSONObject data, Function3<? super String, ? super JSONObject, ? super ParsingEnvironment, ? extends Expression<T>> reader) {
        Intrinsics.checkNotNullParameter(field, "<this>");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(reader, "reader");
        if (field.overridable && data.has(key)) {
            return reader.invoke(key, data, env);
        }
        if (field instanceof Field.Value) {
            return (Expression) ((Field.Value) field).value;
        }
        if (field instanceof Field.Reference) {
            return reader.invoke(((Field.Reference) field).reference, data, env);
        }
        throw ParsingExceptionKt.missingValue(data, key);
    }

    public static final <T> ExpressionList<T> resolveExpressionList(Field<ExpressionList<T>> field, ParsingEnvironment env, String key, JSONObject data, Function3<? super String, ? super JSONObject, ? super ParsingEnvironment, ? extends ExpressionList<T>> reader) {
        Intrinsics.checkNotNullParameter(field, "<this>");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(reader, "reader");
        if (field.overridable && data.has(key)) {
            return reader.invoke(key, data, env);
        }
        if (field instanceof Field.Value) {
            return (ExpressionList) ((Field.Value) field).value;
        }
        if (field instanceof Field.Reference) {
            return reader.invoke(((Field.Reference) field).reference, data, env);
        }
        throw ParsingExceptionKt.missingValue(data, key);
    }

    public static final <T> Expression<T> resolveOptionalExpression(Field<Expression<T>> field, ParsingEnvironment env, String key, JSONObject data, Function3<? super String, ? super JSONObject, ? super ParsingEnvironment, ? extends Expression<T>> reader) {
        Intrinsics.checkNotNullParameter(field, "<this>");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(reader, "reader");
        if (field.overridable && data.has(key)) {
            return reader.invoke(key, data, env);
        }
        if (field instanceof Field.Value) {
            return (Expression) ((Field.Value) field).value;
        }
        if (field instanceof Field.Reference) {
            return reader.invoke(((Field.Reference) field).reference, data, env);
        }
        return null;
    }

    public static final <T> ExpressionList<T> resolveOptionalExpressionList(Field<ExpressionList<T>> field, ParsingEnvironment env, String key, JSONObject data, Function3<? super String, ? super JSONObject, ? super ParsingEnvironment, ? extends ExpressionList<T>> reader) {
        Intrinsics.checkNotNullParameter(field, "<this>");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(reader, "reader");
        if (field.overridable && data.has(key)) {
            return reader.invoke(key, data, env);
        }
        if (field instanceof Field.Value) {
            return (ExpressionList) ((Field.Value) field).value;
        }
        if (field instanceof Field.Reference) {
            return reader.invoke(((Field.Reference) field).reference, data, env);
        }
        return null;
    }
}
