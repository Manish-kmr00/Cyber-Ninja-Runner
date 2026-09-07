package com.yandex.div.internal.parser;

import com.yandex.div.internal.template.Field;
import com.yandex.div.internal.template.FieldKt;
import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.ParsingErrorLogger;
import com.yandex.div.json.ParsingException;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class JsonTemplateParser {
    private static final ValueValidator<String> IS_NOT_EMPTY = new ValueValidator() { // from class: com.yandex.div.internal.parser.JsonTemplateParser$$ExternalSyntheticLambda0
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return JsonTemplateParser.lambda$static$0((String) obj);
        }
    };

    static /* synthetic */ boolean lambda$static$0(String str) {
        return !str.isEmpty();
    }

    public static <T> Field<T> readOptionalField(JSONObject jSONObject, String str, boolean z, Field<T> field, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        return readOptionalField(jSONObject, str, z, field, JsonParser.doNotConvert(), JsonParser.alwaysValid(), parsingErrorLogger, parsingEnvironment);
    }

    public static <T> Field<T> readOptionalField(JSONObject jSONObject, String str, boolean z, Field<T> field, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        return readOptionalField(jSONObject, str, z, field, JsonParser.doNotConvert(), valueValidator, parsingErrorLogger, parsingEnvironment);
    }

    public static <R, T> Field<T> readOptionalField(JSONObject jSONObject, String str, boolean z, Field<T> field, Function1<R, T> function1, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        return readOptionalField(jSONObject, str, z, field, function1, JsonParser.alwaysValid(), parsingErrorLogger, parsingEnvironment);
    }

    public static <R, T> Field<T> readOptionalField(JSONObject jSONObject, String str, boolean z, Field<T> field, Function1<R, T> function1, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        Object optional = JsonParser.readOptional(jSONObject, str, function1, valueValidator, parsingErrorLogger, parsingEnvironment);
        if (optional != null) {
            return new Field.Value(z, optional);
        }
        String reference = readReference(jSONObject, str, parsingErrorLogger, parsingEnvironment);
        if (reference != null) {
            return new Field.Reference(z, reference);
        }
        if (field != null) {
            return FieldKt.clone(field, z);
        }
        return Field.INSTANCE.nullField(z);
    }

    public static <T> Field<T> readOptionalField(JSONObject jSONObject, String str, boolean z, Field<T> field, Function2<ParsingEnvironment, JSONObject, T> function2, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        return readOptionalField(jSONObject, str, z, field, function2, JsonParser.alwaysValid(), parsingErrorLogger, parsingEnvironment);
    }

    public static <T> Field<T> readOptionalField(JSONObject jSONObject, String str, boolean z, Field<T> field, Function2<ParsingEnvironment, JSONObject, T> function2, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        Object optional = JsonParser.readOptional(jSONObject, str, function2, valueValidator, parsingErrorLogger, parsingEnvironment);
        if (optional != null) {
            return new Field.Value(z, optional);
        }
        String reference = readReference(jSONObject, str, parsingErrorLogger, parsingEnvironment);
        if (reference != null) {
            return new Field.Reference(z, reference);
        }
        if (field != null) {
            return FieldKt.clone(field, z);
        }
        return Field.INSTANCE.nullField(z);
    }

    public static <T> Field<T> readField(JSONObject jSONObject, String str, boolean z, Field<T> field, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        return readField(jSONObject, str, z, field, JsonParser.doNotConvert(), JsonParser.alwaysValid(), parsingErrorLogger, parsingEnvironment);
    }

    public static <T> Field<T> readField(JSONObject jSONObject, String str, boolean z, Field<T> field, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        return readField(jSONObject, str, z, field, JsonParser.doNotConvert(), valueValidator, parsingErrorLogger, parsingEnvironment);
    }

    public static <R, T> Field<T> readField(JSONObject jSONObject, String str, boolean z, Field<T> field, Function1<R, T> function1, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        return readField(jSONObject, str, z, field, function1, JsonParser.alwaysValid(), parsingErrorLogger, parsingEnvironment);
    }

    public static <R, T> Field<T> readField(JSONObject jSONObject, String str, boolean z, Field<T> field, Function1<R, T> function1, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        try {
            return new Field.Value(z, JsonParser.read(jSONObject, str, function1, valueValidator, parsingErrorLogger, parsingEnvironment));
        } catch (ParsingException e) {
            JsonTemplateParserKt.suppressMissingValueOrThrow(e);
            Field<T> fieldReferenceOrFallback = referenceOrFallback(z, readReference(jSONObject, str, parsingErrorLogger, parsingEnvironment), field);
            if (fieldReferenceOrFallback != null) {
                return fieldReferenceOrFallback;
            }
            throw e;
        }
    }

    public static <T> Field<T> readField(JSONObject jSONObject, String str, boolean z, Field<T> field, Function2<ParsingEnvironment, JSONObject, T> function2, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        return readField(jSONObject, str, z, field, function2, JsonParser.alwaysValid(), parsingErrorLogger, parsingEnvironment);
    }

    public static <T> Field<T> readField(JSONObject jSONObject, String str, boolean z, Field<T> field, Function2<ParsingEnvironment, JSONObject, T> function2, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        try {
            return new Field.Value(z, JsonParser.read(jSONObject, str, function2, valueValidator, parsingErrorLogger, parsingEnvironment));
        } catch (ParsingException e) {
            JsonTemplateParserKt.suppressMissingValueOrThrow(e);
            Field<T> fieldReferenceOrFallback = referenceOrFallback(z, readReference(jSONObject, str, parsingErrorLogger, parsingEnvironment), field);
            if (fieldReferenceOrFallback != null) {
                return fieldReferenceOrFallback;
            }
            throw e;
        }
    }

    public static String readReference(JSONObject jSONObject, String str, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        return (String) JsonParser.readOptional(jSONObject, "$" + str, IS_NOT_EMPTY, parsingErrorLogger, parsingEnvironment);
    }

    public static <R, T> Field<Expression<T>> readOptionalFieldWithExpression(JSONObject jSONObject, String str, boolean z, Field<Expression<T>> field, Function1<R, T> function1, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, TypeHelper<T> typeHelper) {
        return readOptionalFieldWithExpression(jSONObject, str, z, field, function1, JsonParser.alwaysValid(), parsingErrorLogger, parsingEnvironment, typeHelper);
    }

    public static Field<Expression<String>> readOptionalFieldWithExpression(JSONObject jSONObject, String str, boolean z, Field<Expression<String>> field, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, TypeHelper<String> typeHelper) {
        return readOptionalFieldWithExpression(jSONObject, str, z, field, JsonParser.doNotConvert(), JsonParser.alwaysValidString(), parsingErrorLogger, parsingEnvironment, typeHelper);
    }

    public static <T> Field<Expression<T>> readOptionalFieldWithExpression(JSONObject jSONObject, String str, boolean z, Field<Expression<T>> field, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, TypeHelper<T> typeHelper) {
        return readOptionalFieldWithExpression(jSONObject, str, z, field, JsonParser.doNotConvert(), valueValidator, parsingErrorLogger, parsingEnvironment, typeHelper);
    }

    public static <R, T> Field<Expression<T>> readOptionalFieldWithExpression(JSONObject jSONObject, String str, boolean z, Field<Expression<T>> field, Function1<R, T> function1, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, TypeHelper<T> typeHelper) {
        Expression optionalExpression = JsonParser.readOptionalExpression(jSONObject, str, function1, valueValidator, parsingErrorLogger, parsingEnvironment, null, typeHelper);
        if (optionalExpression != null) {
            return new Field.Value(z, optionalExpression);
        }
        String reference = readReference(jSONObject, str, parsingErrorLogger, parsingEnvironment);
        if (reference != null) {
            return new Field.Reference(z, reference);
        }
        if (field != null) {
            return FieldKt.clone(field, z);
        }
        return Field.INSTANCE.nullField(z);
    }

    public static <R, T> Field<List<T>> readListField(JSONObject jSONObject, String str, boolean z, Field<List<T>> field, Function1<R, T> function1, ListValidator<T> listValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        try {
            return new Field.Value(z, JsonParser.readList(jSONObject, str, function1, listValidator, JsonParser.alwaysValid(), parsingErrorLogger, parsingEnvironment));
        } catch (ParsingException e) {
            JsonTemplateParserKt.suppressMissingValueOrThrow(e);
            Field<List<T>> fieldReferenceOrFallback = referenceOrFallback(z, readReference(jSONObject, str, parsingErrorLogger, parsingEnvironment), field);
            if (fieldReferenceOrFallback != null) {
                return fieldReferenceOrFallback;
            }
            throw e;
        }
    }

    public static <R, T> Field<ExpressionList<T>> readExpressionListField(JSONObject jSONObject, String str, boolean z, Field<ExpressionList<T>> field, Function1<R, T> function1, ListValidator<T> listValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, TypeHelper<T> typeHelper) {
        ExpressionList optionalExpressionList = JsonParser.readOptionalExpressionList(jSONObject, str, function1, listValidator, JsonParser.alwaysValid(), parsingErrorLogger, parsingEnvironment, typeHelper);
        if (optionalExpressionList != null) {
            return new Field.Value(z, optionalExpressionList);
        }
        String reference = readReference(jSONObject, str, parsingErrorLogger, parsingEnvironment);
        if (reference != null) {
            return new Field.Reference(z, reference);
        }
        if (field != null) {
            return FieldKt.clone(field, z);
        }
        return Field.INSTANCE.nullField(z);
    }

    public static <T> Field<ExpressionList<T>> readExpressionListField(JSONObject jSONObject, String str, boolean z, Field<ExpressionList<T>> field, ListValidator<T> listValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, TypeHelper<T> typeHelper) {
        return readExpressionListField(jSONObject, str, z, field, JsonParser.doNotConvert(), listValidator, parsingErrorLogger, parsingEnvironment, typeHelper);
    }

    public static <T> Field<ExpressionList<T>> readExpressionListField(JSONObject jSONObject, String str, boolean z, Field<ExpressionList<T>> field, ListValidator<T> listValidator, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, TypeHelper<T> typeHelper) {
        ExpressionList optionalExpressionList = JsonParser.readOptionalExpressionList(jSONObject, str, JsonParser.doNotConvert(), listValidator, valueValidator, parsingErrorLogger, parsingEnvironment, typeHelper);
        if (optionalExpressionList != null) {
            return new Field.Value(z, optionalExpressionList);
        }
        String reference = readReference(jSONObject, str, parsingErrorLogger, parsingEnvironment);
        if (reference != null) {
            return new Field.Reference(z, reference);
        }
        if (field != null) {
            return FieldKt.clone(field, z);
        }
        return Field.INSTANCE.nullField(z);
    }

    public static <R, T> Field<List<T>> readOptionalListField(JSONObject jSONObject, String str, boolean z, Field<List<T>> field, Function1<R, T> function1, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        return readOptionalListField(jSONObject, str, z, field, function1, JsonParser.alwaysValidList(), JsonParser.alwaysValid(), parsingErrorLogger, parsingEnvironment);
    }

    public static <R, T> Field<List<T>> readOptionalListField(JSONObject jSONObject, String str, boolean z, Field<List<T>> field, Function1<R, T> function1, ListValidator<T> listValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        return readOptionalListField(jSONObject, str, z, field, function1, listValidator, JsonParser.alwaysValid(), parsingErrorLogger, parsingEnvironment);
    }

    public static <R, T> Field<List<T>> readOptionalListField(JSONObject jSONObject, String str, boolean z, Field<List<T>> field, Function1<R, T> function1, ListValidator<T> listValidator, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        List optionalList = JsonParser.readOptionalList(jSONObject, str, function1, listValidator, valueValidator, parsingErrorLogger, parsingEnvironment);
        if (optionalList != null) {
            return new Field.Value(z, optionalList);
        }
        String reference = readReference(jSONObject, str, parsingErrorLogger, parsingEnvironment);
        if (reference != null) {
            return new Field.Reference(z, reference);
        }
        if (field != null) {
            return FieldKt.clone(field, z);
        }
        return Field.INSTANCE.nullField(z);
    }

    public static <R, T> Field<List<T>> readOptionalListField(JSONObject jSONObject, String str, boolean z, Field<List<T>> field, Function2<ParsingEnvironment, R, T> function2, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        return readOptionalListField(jSONObject, str, z, field, function2, JsonParser.alwaysValidList(), parsingErrorLogger, parsingEnvironment);
    }

    public static <R, T> Field<List<T>> readOptionalListField(JSONObject jSONObject, String str, boolean z, Field<List<T>> field, Function2<ParsingEnvironment, R, T> function2, ListValidator<T> listValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        List optionalList = JsonParser.readOptionalList(jSONObject, str, function2, listValidator, parsingErrorLogger, parsingEnvironment);
        if (optionalList != null) {
            return new Field.Value(z, optionalList);
        }
        String reference = readReference(jSONObject, str, parsingErrorLogger, parsingEnvironment);
        if (reference != null) {
            return new Field.Reference(z, reference);
        }
        if (field != null) {
            return FieldKt.clone(field, z);
        }
        return Field.INSTANCE.nullField(z);
    }

    public static <T> Field<List<T>> readOptionalListField(JSONObject jSONObject, String str, boolean z, Field<List<T>> field, ListValidator<T> listValidator, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        List optionalList = JsonParser.readOptionalList(jSONObject, str, JsonParser.doNotConvert(), listValidator, valueValidator, parsingErrorLogger, parsingEnvironment);
        if (optionalList != null) {
            return new Field.Value(z, optionalList);
        }
        String reference = readReference(jSONObject, str, parsingErrorLogger, parsingEnvironment);
        if (reference != null) {
            return new Field.Reference(z, reference);
        }
        if (field != null) {
            return FieldKt.clone(field, z);
        }
        return Field.INSTANCE.nullField(z);
    }

    public static <R, T> Field<ExpressionList<T>> readOptionalExpressionListField(JSONObject jSONObject, String str, boolean z, Field<ExpressionList<T>> field, Function1<R, T> function1, ListValidator<T> listValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, TypeHelper<T> typeHelper) {
        return readExpressionListField(jSONObject, str, z, field, function1, listValidator, parsingErrorLogger, parsingEnvironment, typeHelper);
    }

    public static <T> Field<ExpressionList<T>> readOptionalExpressionListField(JSONObject jSONObject, String str, boolean z, Field<ExpressionList<T>> field, ListValidator<T> listValidator, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, TypeHelper<T> typeHelper) {
        ExpressionList optionalExpressionList = JsonParser.readOptionalExpressionList(jSONObject, str, JsonParser.doNotConvert(), listValidator, valueValidator, parsingErrorLogger, parsingEnvironment, typeHelper);
        if (optionalExpressionList != null) {
            return new Field.Value(z, optionalExpressionList);
        }
        String reference = readReference(jSONObject, str, parsingErrorLogger, parsingEnvironment);
        if (reference != null) {
            return new Field.Reference(z, reference);
        }
        if (field != null) {
            return FieldKt.clone(field, z);
        }
        return Field.INSTANCE.nullField(z);
    }

    public static <T> Field<List<T>> readListField(JSONObject jSONObject, String str, boolean z, Field<List<T>> field, Function2<ParsingEnvironment, JSONObject, T> function2, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        return readListField(jSONObject, str, z, field, function2, JsonParser.alwaysValidList(), JsonParser.alwaysValid(), parsingErrorLogger, parsingEnvironment);
    }

    public static <T> Field<List<T>> readListField(JSONObject jSONObject, String str, boolean z, Field<List<T>> field, Function2<ParsingEnvironment, JSONObject, T> function2, ListValidator<T> listValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        return readListField(jSONObject, str, z, field, function2, listValidator, JsonParser.alwaysValid(), parsingErrorLogger, parsingEnvironment);
    }

    public static <T> Field<List<T>> readListField(JSONObject jSONObject, String str, boolean z, Field<List<T>> field, Function2<ParsingEnvironment, JSONObject, T> function2, ListValidator<T> listValidator, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment) {
        try {
            return new Field.Value(z, JsonParser.readList(jSONObject, str, function2, listValidator, valueValidator, parsingErrorLogger, parsingEnvironment));
        } catch (ParsingException e) {
            JsonTemplateParserKt.suppressMissingValueOrThrow(e);
            Field<List<T>> fieldReferenceOrFallback = referenceOrFallback(z, readReference(jSONObject, str, parsingErrorLogger, parsingEnvironment), field);
            if (fieldReferenceOrFallback != null) {
                return fieldReferenceOrFallback;
            }
            throw e;
        }
    }

    public static <T> Field<T> referenceOrFallback(boolean z, String str, Field<T> field) {
        if (str != null) {
            return new Field.Reference(z, str);
        }
        if (field != null) {
            return FieldKt.clone(field, z);
        }
        if (z) {
            return Field.INSTANCE.nullField(z);
        }
        return null;
    }

    public static <R, T> Field<Expression<T>> readFieldWithExpression(JSONObject jSONObject, String str, boolean z, Field<Expression<T>> field, Function1<R, T> function1, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, TypeHelper<T> typeHelper) {
        return readFieldWithExpression(jSONObject, str, z, field, function1, JsonParser.alwaysValid(), parsingErrorLogger, parsingEnvironment, typeHelper);
    }

    public static <T> Field<Expression<T>> readFieldWithExpression(JSONObject jSONObject, String str, boolean z, Field<Expression<T>> field, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, TypeHelper<T> typeHelper) {
        return readFieldWithExpression(jSONObject, str, z, field, JsonParser.doNotConvert(), JsonParser.alwaysValid(), parsingErrorLogger, parsingEnvironment, typeHelper);
    }

    public static <T> Field<Expression<T>> readFieldWithExpression(JSONObject jSONObject, String str, boolean z, Field<Expression<T>> field, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, TypeHelper<T> typeHelper) {
        return readFieldWithExpression(jSONObject, str, z, field, JsonParser.doNotConvert(), valueValidator, parsingErrorLogger, parsingEnvironment, typeHelper);
    }

    public static <R, T> Field<Expression<T>> readFieldWithExpression(JSONObject jSONObject, String str, boolean z, Field<Expression<T>> field, Function1<R, T> function1, ValueValidator<T> valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, TypeHelper<T> typeHelper) {
        try {
            return new Field.Value(z, JsonParser.readExpression(jSONObject, str, function1, valueValidator, parsingErrorLogger, parsingEnvironment, typeHelper));
        } catch (ParsingException e) {
            JsonTemplateParserKt.suppressMissingValueOrThrow(e);
            Field<Expression<T>> fieldReferenceOrFallback = referenceOrFallback(z, readReference(jSONObject, str, parsingErrorLogger, parsingEnvironment), field);
            if (fieldReferenceOrFallback != null) {
                return fieldReferenceOrFallback;
            }
            throw e;
        }
    }
}
