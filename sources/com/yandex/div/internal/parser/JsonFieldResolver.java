package com.yandex.div.internal.parser;

import com.yandex.div.data.EntityTemplate;
import com.yandex.div.internal.template.Field;
import com.yandex.div.json.ParsingException;
import com.yandex.div.json.ParsingExceptionKt;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionList;
import com.yandex.div.serialization.Deserializer;
import com.yandex.div.serialization.ParsingContext;
import com.yandex.div.serialization.TemplateResolver;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class JsonFieldResolver {
    public static <V> V resolve(ParsingContext parsingContext, Field<V> field, JSONObject jSONObject, String str) {
        return (V) resolve(parsingContext, field, jSONObject, str, JsonParsers.doNotConvert(), JsonParsers.alwaysValid());
    }

    public static <R, V> V resolve(ParsingContext parsingContext, Field<V> field, JSONObject jSONObject, String str, Function1<R, V> function1) {
        return (V) resolve(parsingContext, field, jSONObject, str, function1, JsonParsers.alwaysValid());
    }

    public static <V> V resolve(ParsingContext parsingContext, Field<V> field, JSONObject jSONObject, String str, ValueValidator<V> valueValidator) {
        return (V) resolve(parsingContext, field, jSONObject, str, JsonParsers.doNotConvert(), valueValidator);
    }

    public static <R, V> V resolve(ParsingContext parsingContext, Field<V> field, JSONObject jSONObject, String str, Function1<R, V> function1, ValueValidator<V> valueValidator) {
        if (field.overridable && jSONObject.has(str)) {
            return (V) JsonPropertyParser.read(parsingContext, jSONObject, str, function1, valueValidator);
        }
        if (field.type == 2) {
            return (V) ((Field.Value) field).value;
        }
        if (field.type == 3) {
            return (V) JsonPropertyParser.read(parsingContext, jSONObject, ((Field.Reference) field).reference, function1, valueValidator);
        }
        throw ParsingExceptionKt.missingValue(jSONObject, str);
    }

    public static <T extends EntityTemplate<V>, V> V resolve(ParsingContext parsingContext, Field<T> field, JSONObject jSONObject, String str, Lazy<TemplateResolver<JSONObject, T, V>> lazy, Lazy<Deserializer<JSONObject, V>> lazy2) {
        if (field.overridable && jSONObject.has(str)) {
            return (V) JsonPropertyParser.read(parsingContext, jSONObject, str, lazy2);
        }
        if (field.type == 2) {
            return (V) resolveDependency(parsingContext, (EntityTemplate) ((Field.Value) field).value, jSONObject, str, lazy.getValue());
        }
        if (field.type == 3) {
            return (V) JsonPropertyParser.read(parsingContext, jSONObject, ((Field.Reference) field).reference, lazy2);
        }
        throw ParsingExceptionKt.missingValue(jSONObject, str);
    }

    public static <V> V resolveOptional(ParsingContext parsingContext, Field<V> field, JSONObject jSONObject, String str) {
        return (V) resolveOptional(parsingContext, field, jSONObject, str, JsonParsers.doNotConvert(), JsonParsers.alwaysValid());
    }

    public static <R, V> V resolveOptional(ParsingContext parsingContext, Field<V> field, JSONObject jSONObject, String str, Function1<R, V> function1) {
        return (V) resolveOptional(parsingContext, field, jSONObject, str, function1, JsonParsers.alwaysValid());
    }

    public static <V> V resolveOptional(ParsingContext parsingContext, Field<V> field, JSONObject jSONObject, String str, ValueValidator<V> valueValidator) {
        return (V) resolveOptional(parsingContext, field, jSONObject, str, JsonParsers.doNotConvert(), valueValidator);
    }

    public static <R, V> V resolveOptional(ParsingContext parsingContext, Field<V> field, JSONObject jSONObject, String str, Function1<R, V> function1, ValueValidator<V> valueValidator) {
        if (field.overridable && jSONObject.has(str)) {
            return (V) JsonPropertyParser.readOptional(parsingContext, jSONObject, str, function1, valueValidator);
        }
        if (field.type == 2) {
            return (V) ((Field.Value) field).value;
        }
        if (field.type == 3) {
            return (V) JsonPropertyParser.readOptional(parsingContext, jSONObject, ((Field.Reference) field).reference, function1, valueValidator);
        }
        return null;
    }

    public static <T extends EntityTemplate<V>, V> V resolveOptional(ParsingContext parsingContext, Field<T> field, JSONObject jSONObject, String str, Lazy<TemplateResolver<JSONObject, T, V>> lazy, Lazy<Deserializer<JSONObject, V>> lazy2) {
        if (field.overridable && jSONObject.has(str)) {
            return (V) JsonPropertyParser.readOptional(parsingContext, jSONObject, str, lazy2);
        }
        if (field.type == 2) {
            return (V) resolveOptionalDependency(parsingContext, (EntityTemplate) ((Field.Value) field).value, jSONObject, lazy.getValue());
        }
        if (field.type == 3) {
            return (V) JsonPropertyParser.readOptional(parsingContext, jSONObject, ((Field.Reference) field).reference, lazy2);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <V> Expression<V> resolveExpression(ParsingContext parsingContext, Field<Expression<V>> field, JSONObject jSONObject, String str, TypeHelper<V> typeHelper) {
        if (field.overridable && jSONObject.has(str)) {
            return JsonExpressionParser.readExpression(parsingContext, jSONObject, str, typeHelper);
        }
        if (field.type == 2) {
            return (Expression) ((Field.Value) field).value;
        }
        if (field.type == 3) {
            return JsonExpressionParser.readExpression(parsingContext, jSONObject, ((Field.Reference) field).reference, typeHelper);
        }
        throw ParsingExceptionKt.missingValue(jSONObject, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R, V> Expression<V> resolveExpression(ParsingContext parsingContext, Field<Expression<V>> field, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, Function1<R, V> function1) {
        if (field.overridable && jSONObject.has(str)) {
            return JsonExpressionParser.readExpression(parsingContext, jSONObject, str, typeHelper, function1);
        }
        if (field.type == 2) {
            return (Expression) ((Field.Value) field).value;
        }
        if (field.type == 3) {
            return JsonExpressionParser.readExpression(parsingContext, jSONObject, ((Field.Reference) field).reference, typeHelper, function1);
        }
        throw ParsingExceptionKt.missingValue(jSONObject, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <V> Expression<V> resolveExpression(ParsingContext parsingContext, Field<Expression<V>> field, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, ValueValidator<V> valueValidator) {
        if (field.overridable && jSONObject.has(str)) {
            return JsonExpressionParser.readExpression(parsingContext, jSONObject, str, typeHelper, valueValidator);
        }
        if (field.type == 2) {
            return (Expression) ((Field.Value) field).value;
        }
        if (field.type == 3) {
            return JsonExpressionParser.readExpression(parsingContext, jSONObject, ((Field.Reference) field).reference, typeHelper, valueValidator);
        }
        throw ParsingExceptionKt.missingValue(jSONObject, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R, V> Expression<V> resolveExpression(ParsingContext parsingContext, Field<Expression<V>> field, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, Function1<R, V> function1, ValueValidator<V> valueValidator) {
        if (field.overridable && jSONObject.has(str)) {
            return JsonExpressionParser.readExpression(parsingContext, jSONObject, str, typeHelper, function1, valueValidator);
        }
        if (field.type == 2) {
            return (Expression) ((Field.Value) field).value;
        }
        if (field.type == 3) {
            return JsonExpressionParser.readExpression(parsingContext, jSONObject, ((Field.Reference) field).reference, typeHelper, function1, valueValidator);
        }
        throw ParsingExceptionKt.missingValue(jSONObject, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <V> Expression<V> resolveOptionalExpression(ParsingContext parsingContext, Field<Expression<V>> field, JSONObject jSONObject, String str, TypeHelper<V> typeHelper) {
        if (field.overridable && jSONObject.has(str)) {
            return JsonExpressionParser.readOptionalExpression(parsingContext, jSONObject, str, typeHelper, JsonParsers.doNotConvert());
        }
        if (field.type == 2) {
            return (Expression) ((Field.Value) field).value;
        }
        if (field.type == 3) {
            return JsonExpressionParser.readOptionalExpression(parsingContext, jSONObject, ((Field.Reference) field).reference, typeHelper, JsonParsers.doNotConvert());
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <V> Expression<V> resolveOptionalExpression(ParsingContext parsingContext, Field<Expression<V>> field, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, Expression<V> expression) {
        if (field.overridable && jSONObject.has(str)) {
            return JsonExpressionParser.readOptionalExpression(parsingContext, jSONObject, str, typeHelper, JsonParsers.doNotConvert(), expression);
        }
        if (field.type == 2) {
            return (Expression) ((Field.Value) field).value;
        }
        if (field.type == 3) {
            return JsonExpressionParser.readOptionalExpression(parsingContext, jSONObject, ((Field.Reference) field).reference, typeHelper, JsonParsers.doNotConvert(), expression);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R, V> Expression<V> resolveOptionalExpression(ParsingContext parsingContext, Field<Expression<V>> field, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, Function1<R, V> function1) {
        if (field.overridable && jSONObject.has(str)) {
            return JsonExpressionParser.readOptionalExpression(parsingContext, jSONObject, str, typeHelper, function1);
        }
        if (field.type == 2) {
            return (Expression) ((Field.Value) field).value;
        }
        if (field.type == 3) {
            return JsonExpressionParser.readOptionalExpression(parsingContext, jSONObject, ((Field.Reference) field).reference, typeHelper, function1);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R, V> Expression<V> resolveOptionalExpression(ParsingContext parsingContext, Field<Expression<V>> field, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, Function1<R, V> function1, Expression<V> expression) {
        if (field.overridable && jSONObject.has(str)) {
            return JsonExpressionParser.readOptionalExpression(parsingContext, jSONObject, str, typeHelper, function1, expression);
        }
        if (field.type == 2) {
            return (Expression) ((Field.Value) field).value;
        }
        if (field.type == 3) {
            return JsonExpressionParser.readOptionalExpression(parsingContext, jSONObject, ((Field.Reference) field).reference, typeHelper, function1, expression);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <V> Expression<V> resolveOptionalExpression(ParsingContext parsingContext, Field<Expression<V>> field, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, ValueValidator<V> valueValidator) {
        if (field.overridable && jSONObject.has(str)) {
            return JsonExpressionParser.readOptionalExpression(parsingContext, jSONObject, str, typeHelper, valueValidator);
        }
        if (field.type == 2) {
            return (Expression) ((Field.Value) field).value;
        }
        if (field.type == 3) {
            return JsonExpressionParser.readOptionalExpression(parsingContext, jSONObject, ((Field.Reference) field).reference, typeHelper, valueValidator);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <V> Expression<V> resolveOptionalExpression(ParsingContext parsingContext, Field<Expression<V>> field, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, ValueValidator<V> valueValidator, Expression<V> expression) {
        if (field.overridable && jSONObject.has(str)) {
            return JsonExpressionParser.readOptionalExpression(parsingContext, jSONObject, str, typeHelper, valueValidator, expression);
        }
        if (field.type == 2) {
            return (Expression) ((Field.Value) field).value;
        }
        if (field.type == 3) {
            return JsonExpressionParser.readOptionalExpression(parsingContext, jSONObject, ((Field.Reference) field).reference, typeHelper, valueValidator, expression);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R, V> Expression<V> resolveOptionalExpression(ParsingContext parsingContext, Field<Expression<V>> field, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, Function1<R, V> function1, ValueValidator<V> valueValidator) {
        if (field.overridable && jSONObject.has(str)) {
            return JsonExpressionParser.readOptionalExpression(parsingContext, jSONObject, str, typeHelper, function1, valueValidator, null);
        }
        if (field.type == 2) {
            return (Expression) ((Field.Value) field).value;
        }
        if (field.type == 3) {
            return JsonExpressionParser.readOptionalExpression(parsingContext, jSONObject, ((Field.Reference) field).reference, typeHelper, function1, valueValidator, null);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R, V> Expression<V> resolveOptionalExpression(ParsingContext parsingContext, Field<Expression<V>> field, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, Function1<R, V> function1, ValueValidator<V> valueValidator, Expression<V> expression) {
        if (field.overridable && jSONObject.has(str)) {
            return JsonExpressionParser.readOptionalExpression(parsingContext, jSONObject, str, typeHelper, function1, valueValidator, expression);
        }
        if (field.type == 2) {
            return (Expression) ((Field.Value) field).value;
        }
        if (field.type == 3) {
            return JsonExpressionParser.readOptionalExpression(parsingContext, jSONObject, ((Field.Reference) field).reference, typeHelper, function1, valueValidator, expression);
        }
        return null;
    }

    public static <R, V> List<V> resolveList(ParsingContext parsingContext, Field<List<V>> field, JSONObject jSONObject, String str, Function1<R, V> function1) {
        return resolveList(parsingContext, field, jSONObject, str, function1, JsonParsers.alwaysValidList(), JsonParsers.alwaysValid());
    }

    public static <R, V> List<V> resolveList(ParsingContext parsingContext, Field<List<V>> field, JSONObject jSONObject, String str, Function1<R, V> function1, ListValidator<V> listValidator) {
        return resolveList(parsingContext, field, jSONObject, str, function1, listValidator, JsonParsers.alwaysValid());
    }

    public static <V> List<V> resolveList(ParsingContext parsingContext, Field<List<V>> field, JSONObject jSONObject, String str, ListValidator<V> listValidator) {
        return resolveList(parsingContext, field, jSONObject, str, JsonParsers.doNotConvert(), listValidator, JsonParsers.alwaysValid());
    }

    public static <V> List<V> resolveList(ParsingContext parsingContext, Field<List<V>> field, JSONObject jSONObject, String str, ListValidator<V> listValidator, ValueValidator<V> valueValidator) {
        return resolveList(parsingContext, field, jSONObject, str, JsonParsers.doNotConvert(), listValidator, valueValidator);
    }

    public static <R, V> List<V> resolveList(ParsingContext parsingContext, Field<List<V>> field, JSONObject jSONObject, String str, Function1<R, V> function1, ListValidator<V> listValidator, ValueValidator<V> valueValidator) {
        if (field.overridable && jSONObject.has(str)) {
            return JsonPropertyParser.readList(parsingContext, jSONObject, str, function1, listValidator, valueValidator);
        }
        if (field.type == 2) {
            return (List) ((Field.Value) field).value;
        }
        if (field.type == 3) {
            return JsonPropertyParser.readList(parsingContext, jSONObject, ((Field.Reference) field).reference, function1, listValidator, valueValidator);
        }
        throw ParsingExceptionKt.missingValue(jSONObject, str);
    }

    public static <T extends EntityTemplate<V>, V> List<V> resolveList(ParsingContext parsingContext, Field<List<T>> field, JSONObject jSONObject, String str, Lazy<TemplateResolver<JSONObject, T, V>> lazy, Lazy<Deserializer<JSONObject, V>> lazy2) {
        if (field.overridable && jSONObject.has(str)) {
            return JsonPropertyParser.readList(parsingContext, jSONObject, str, lazy2);
        }
        if (field.type == 2) {
            List list = (List) ((Field.Value) field).value;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            TemplateResolver<JSONObject, T, V> value = lazy.getValue();
            for (int i = 0; i < size; i++) {
                Object objResolveOptionalDependency = resolveOptionalDependency(parsingContext, (EntityTemplate) list.get(i), jSONObject, value);
                if (objResolveOptionalDependency != null) {
                    arrayList.add(objResolveOptionalDependency);
                }
            }
            return arrayList;
        }
        if (field.type == 3) {
            return JsonPropertyParser.readList(parsingContext, jSONObject, ((Field.Reference) field).reference, lazy2);
        }
        throw ParsingExceptionKt.missingValue(jSONObject, str);
    }

    public static <T extends EntityTemplate<V>, V> List<V> resolveList(ParsingContext parsingContext, Field<List<T>> field, JSONObject jSONObject, String str, Lazy<TemplateResolver<JSONObject, T, V>> lazy, Lazy<Deserializer<JSONObject, V>> lazy2, ListValidator<V> listValidator) {
        if (field.overridable && jSONObject.has(str)) {
            return JsonPropertyParser.readList(parsingContext, jSONObject, str, lazy2, listValidator);
        }
        if (field.type == 2) {
            List list = (List) ((Field.Value) field).value;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            TemplateResolver<JSONObject, T, V> value = lazy.getValue();
            for (int i = 0; i < size; i++) {
                Object objResolveOptionalDependency = resolveOptionalDependency(parsingContext, (EntityTemplate) list.get(i), jSONObject, value);
                if (objResolveOptionalDependency != null) {
                    arrayList.add(objResolveOptionalDependency);
                }
            }
            if (listValidator.isValid(arrayList)) {
                return arrayList;
            }
            throw ParsingExceptionKt.invalidValue(jSONObject, str, arrayList);
        }
        if (field.type == 3) {
            return JsonPropertyParser.readList(parsingContext, jSONObject, ((Field.Reference) field).reference, lazy2, listValidator);
        }
        throw ParsingExceptionKt.missingValue(jSONObject, str);
    }

    public static <R, V> List<V> resolveOptionalList(ParsingContext parsingContext, Field<List<V>> field, JSONObject jSONObject, String str, Function1<R, V> function1) {
        return resolveOptionalList(parsingContext, field, jSONObject, str, function1, JsonParsers.alwaysValidList(), JsonParsers.alwaysValid());
    }

    public static <R, V> List<V> resolveOptionalList(ParsingContext parsingContext, Field<List<V>> field, JSONObject jSONObject, String str, Function1<R, V> function1, ListValidator<V> listValidator) {
        return resolveOptionalList(parsingContext, field, jSONObject, str, function1, listValidator, JsonParsers.alwaysValid());
    }

    public static <V> List<V> resolveOptionalList(ParsingContext parsingContext, Field<List<V>> field, JSONObject jSONObject, String str, ListValidator<V> listValidator) {
        return resolveOptionalList(parsingContext, field, jSONObject, str, JsonParsers.doNotConvert(), listValidator, JsonParsers.alwaysValid());
    }

    public static <V> List<V> resolveOptionalList(ParsingContext parsingContext, Field<List<V>> field, JSONObject jSONObject, String str, ListValidator<V> listValidator, ValueValidator<V> valueValidator) {
        return resolveOptionalList(parsingContext, field, jSONObject, str, JsonParsers.doNotConvert(), listValidator, valueValidator);
    }

    public static <R, V> List<V> resolveOptionalList(ParsingContext parsingContext, Field<List<V>> field, JSONObject jSONObject, String str, Function1<R, V> function1, ListValidator<V> listValidator, ValueValidator<V> valueValidator) {
        if (field.overridable && jSONObject.has(str)) {
            return JsonPropertyParser.readOptionalList(parsingContext, jSONObject, str, function1, listValidator, valueValidator);
        }
        if (field.type == 2) {
            return (List) ((Field.Value) field).value;
        }
        if (field.type == 3) {
            return JsonPropertyParser.readOptionalList(parsingContext, jSONObject, ((Field.Reference) field).reference, function1, listValidator, valueValidator);
        }
        return null;
    }

    public static <T extends EntityTemplate<V>, V> List<V> resolveOptionalList(ParsingContext parsingContext, Field<List<T>> field, JSONObject jSONObject, String str, Lazy<TemplateResolver<JSONObject, T, V>> lazy, Lazy<Deserializer<JSONObject, V>> lazy2) {
        if (field.overridable && jSONObject.has(str)) {
            return JsonPropertyParser.readOptionalList(parsingContext, jSONObject, str, lazy2);
        }
        if (field.type == 2) {
            List list = (List) ((Field.Value) field).value;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            TemplateResolver<JSONObject, T, V> value = lazy.getValue();
            for (int i = 0; i < size; i++) {
                Object objResolveOptionalDependency = resolveOptionalDependency(parsingContext, (EntityTemplate) list.get(i), jSONObject, value);
                if (objResolveOptionalDependency != null) {
                    arrayList.add(objResolveOptionalDependency);
                }
            }
            return arrayList;
        }
        if (field.type == 3) {
            return JsonPropertyParser.readOptionalList(parsingContext, jSONObject, ((Field.Reference) field).reference, lazy2);
        }
        return null;
    }

    public static <T extends EntityTemplate<V>, V> List<V> resolveOptionalList(ParsingContext parsingContext, Field<List<T>> field, JSONObject jSONObject, String str, Lazy<TemplateResolver<JSONObject, T, V>> lazy, Lazy<Deserializer<JSONObject, V>> lazy2, ListValidator<V> listValidator) {
        if (field.overridable && jSONObject.has(str)) {
            return JsonPropertyParser.readOptionalList(parsingContext, jSONObject, str, lazy2, listValidator);
        }
        if (field.type == 2) {
            List list = (List) ((Field.Value) field).value;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            TemplateResolver<JSONObject, T, V> value = lazy.getValue();
            for (int i = 0; i < size; i++) {
                Object objResolveOptionalDependency = resolveOptionalDependency(parsingContext, (EntityTemplate) list.get(i), jSONObject, value);
                if (objResolveOptionalDependency != null) {
                    arrayList.add(objResolveOptionalDependency);
                }
            }
            if (listValidator.isValid(arrayList)) {
                return arrayList;
            }
            parsingContext.getLogger().logError(ParsingExceptionKt.invalidValue(jSONObject, str, arrayList));
            return null;
        }
        if (field.type == 3) {
            return JsonPropertyParser.readOptionalList(parsingContext, jSONObject, ((Field.Reference) field).reference, lazy2, listValidator);
        }
        return null;
    }

    public static <V> ExpressionList<V> resolveExpressionList(ParsingContext parsingContext, Field<ExpressionList<V>> field, JSONObject jSONObject, String str, TypeHelper<V> typeHelper) {
        return resolveExpressionList(parsingContext, field, jSONObject, str, typeHelper, JsonParsers.doNotConvert(), JsonParsers.alwaysValidList(), JsonParsers.alwaysValid());
    }

    public static <R, V> ExpressionList<V> resolveExpressionList(ParsingContext parsingContext, Field<ExpressionList<V>> field, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, Function1<R, V> function1) {
        return resolveExpressionList(parsingContext, field, jSONObject, str, typeHelper, function1, JsonParsers.alwaysValidList(), JsonParsers.alwaysValid());
    }

    public static <R, V> ExpressionList<V> resolveExpressionList(ParsingContext parsingContext, Field<ExpressionList<V>> field, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, Function1<R, V> function1, ListValidator<V> listValidator) {
        return resolveExpressionList(parsingContext, field, jSONObject, str, typeHelper, function1, listValidator, JsonParsers.alwaysValid());
    }

    public static <V> ExpressionList<V> resolveExpressionList(ParsingContext parsingContext, Field<ExpressionList<V>> field, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, ListValidator<V> listValidator) {
        return resolveExpressionList(parsingContext, field, jSONObject, str, typeHelper, JsonParsers.doNotConvert(), listValidator, JsonParsers.alwaysValid());
    }

    public static <R, V> ExpressionList<V> resolveExpressionList(ParsingContext parsingContext, Field<ExpressionList<V>> field, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, Function1<R, V> function1, ListValidator<V> listValidator, ValueValidator<V> valueValidator) {
        if (field.overridable && jSONObject.has(str)) {
            return JsonExpressionParser.readExpressionList(parsingContext, jSONObject, str, typeHelper, function1, listValidator, valueValidator);
        }
        if (field.type == 2) {
            return (ExpressionList) ((Field.Value) field).value;
        }
        if (field.type == 3) {
            return JsonExpressionParser.readExpressionList(parsingContext, jSONObject, ((Field.Reference) field).reference, typeHelper, function1, listValidator, valueValidator);
        }
        throw ParsingExceptionKt.missingValue(jSONObject, str);
    }

    public static <V> ExpressionList<V> resolveOptionalExpressionList(ParsingContext parsingContext, Field<ExpressionList<V>> field, JSONObject jSONObject, String str, TypeHelper<V> typeHelper) {
        return resolveOptionalExpressionList(parsingContext, field, jSONObject, str, typeHelper, JsonParsers.doNotConvert(), JsonParsers.alwaysValidList(), JsonParsers.alwaysValid());
    }

    public static <R, V> ExpressionList<V> resolveOptionalExpressionList(ParsingContext parsingContext, Field<ExpressionList<V>> field, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, Function1<R, V> function1) {
        return resolveOptionalExpressionList(parsingContext, field, jSONObject, str, typeHelper, function1, JsonParsers.alwaysValidList(), JsonParsers.alwaysValid());
    }

    public static <R, V> ExpressionList<V> resolveOptionalExpressionList(ParsingContext parsingContext, Field<ExpressionList<V>> field, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, Function1<R, V> function1, ListValidator<V> listValidator) {
        return resolveOptionalExpressionList(parsingContext, field, jSONObject, str, typeHelper, function1, listValidator, JsonParsers.alwaysValid());
    }

    public static <V> ExpressionList<V> resolveOptionalExpressionList(ParsingContext parsingContext, Field<ExpressionList<V>> field, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, ListValidator<V> listValidator) {
        return resolveOptionalExpressionList(parsingContext, field, jSONObject, str, typeHelper, JsonParsers.doNotConvert(), listValidator, JsonParsers.alwaysValid());
    }

    public static <V> ExpressionList<V> resolveOptionalExpressionList(ParsingContext parsingContext, Field<ExpressionList<V>> field, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, ListValidator<V> listValidator, ValueValidator<V> valueValidator) {
        return resolveOptionalExpressionList(parsingContext, field, jSONObject, str, typeHelper, JsonParsers.doNotConvert(), listValidator, valueValidator);
    }

    public static <R, V> ExpressionList<V> resolveOptionalExpressionList(ParsingContext parsingContext, Field<ExpressionList<V>> field, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, Function1<R, V> function1, ListValidator<V> listValidator, ValueValidator<V> valueValidator) {
        if (field.overridable && jSONObject.has(str)) {
            return JsonExpressionParser.readOptionalExpressionList(parsingContext, jSONObject, str, typeHelper, function1, listValidator, valueValidator);
        }
        if (field.type == 2) {
            return (ExpressionList) ((Field.Value) field).value;
        }
        if (field.type == 3) {
            return JsonExpressionParser.readOptionalExpressionList(parsingContext, jSONObject, ((Field.Reference) field).reference, typeHelper, function1, listValidator, valueValidator);
        }
        return null;
    }

    private static <T extends EntityTemplate<V>, V> V resolveDependency(ParsingContext parsingContext, T t, JSONObject jSONObject, String str, TemplateResolver<JSONObject, T, V> templateResolver) {
        try {
            return templateResolver.resolve(parsingContext, t, jSONObject);
        } catch (ParsingException e) {
            throw ParsingExceptionKt.dependencyFailed(jSONObject, str, e);
        }
    }

    private static <T extends EntityTemplate<V>, V> V resolveOptionalDependency(ParsingContext parsingContext, T t, JSONObject jSONObject, TemplateResolver<JSONObject, T, V> templateResolver) {
        try {
            return templateResolver.resolve(parsingContext, t, jSONObject);
        } catch (ParsingException e) {
            parsingContext.getLogger().logError(e);
            return null;
        }
    }
}
