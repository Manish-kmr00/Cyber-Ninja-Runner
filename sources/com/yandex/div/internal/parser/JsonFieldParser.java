package com.yandex.div.internal.parser;

import com.yandex.div.internal.template.Field;
import com.yandex.div.internal.template.FieldKt;
import com.yandex.div.json.ParsingException;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionList;
import com.yandex.div.serialization.Deserializer;
import com.yandex.div.serialization.ParsingContext;
import com.yandex.div.serialization.Serializer;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class JsonFieldParser {
    private static final ValueValidator<String> IS_NOT_EMPTY = new ValueValidator() { // from class: com.yandex.div.internal.parser.JsonFieldParser$$ExternalSyntheticLambda0
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return JsonFieldParser.lambda$static$0((String) obj);
        }
    };

    static /* synthetic */ boolean lambda$static$0(String str) {
        return !str.isEmpty();
    }

    public static <V> Field<V> readField(ParsingContext parsingContext, JSONObject jSONObject, String str, boolean z, Field<V> field) {
        return readField(parsingContext, jSONObject, str, z, field, JsonParsers.doNotConvert(), JsonParsers.alwaysValid());
    }

    public static <R, V> Field<V> readField(ParsingContext parsingContext, JSONObject jSONObject, String str, boolean z, Field<V> field, Function1<R, V> function1) {
        return readField(parsingContext, jSONObject, str, z, field, function1, JsonParsers.alwaysValid());
    }

    public static <V> Field<V> readField(ParsingContext parsingContext, JSONObject jSONObject, String str, boolean z, Field<V> field, ValueValidator<V> valueValidator) {
        return readField(parsingContext, jSONObject, str, z, field, JsonParsers.doNotConvert(), valueValidator);
    }

    public static <R, V> Field<V> readField(ParsingContext parsingContext, JSONObject jSONObject, String str, boolean z, Field<V> field, Function1<R, V> function1, ValueValidator<V> valueValidator) {
        try {
            return new Field.Value(z, JsonPropertyParser.read(parsingContext, jSONObject, str, function1, valueValidator));
        } catch (ParsingException e) {
            JsonTemplateParserKt.suppressMissingValueOrThrow(e);
            Field<V> fieldReferenceOrFallback = referenceOrFallback(z, readReference(parsingContext, jSONObject, str), field);
            if (fieldReferenceOrFallback != null) {
                return fieldReferenceOrFallback;
            }
            throw e;
        }
    }

    public static <V> Field<V> readField(ParsingContext parsingContext, JSONObject jSONObject, String str, boolean z, Field<V> field, Lazy<Deserializer<JSONObject, V>> lazy) {
        try {
            return new Field.Value(z, JsonPropertyParser.read(parsingContext, jSONObject, str, lazy));
        } catch (ParsingException e) {
            JsonTemplateParserKt.suppressMissingValueOrThrow(e);
            Field<V> fieldReferenceOrFallback = referenceOrFallback(z, readReference(parsingContext, jSONObject, str), field);
            if (fieldReferenceOrFallback != null) {
                return fieldReferenceOrFallback;
            }
            throw e;
        }
    }

    public static <V> Field<V> readOptionalField(ParsingContext parsingContext, JSONObject jSONObject, String str, boolean z, Field<V> field) {
        return readOptionalField(parsingContext, jSONObject, str, z, field, JsonParsers.doNotConvert(), JsonParsers.alwaysValid());
    }

    public static <R, V> Field<V> readOptionalField(ParsingContext parsingContext, JSONObject jSONObject, String str, boolean z, Field<V> field, Function1<R, V> function1) {
        return readOptionalField(parsingContext, jSONObject, str, z, field, function1, JsonParsers.alwaysValid());
    }

    public static <V> Field<V> readOptionalField(ParsingContext parsingContext, JSONObject jSONObject, String str, boolean z, Field<V> field, ValueValidator<V> valueValidator) {
        return readOptionalField(parsingContext, jSONObject, str, z, field, JsonParsers.doNotConvert(), valueValidator);
    }

    public static <R, V> Field<V> readOptionalField(ParsingContext parsingContext, JSONObject jSONObject, String str, boolean z, Field<V> field, Function1<R, V> function1, ValueValidator<V> valueValidator) {
        Object optional = JsonPropertyParser.readOptional(parsingContext, jSONObject, str, function1, valueValidator);
        if (optional != null) {
            return new Field.Value(z, optional);
        }
        String reference = readReference(parsingContext, jSONObject, str);
        if (reference != null) {
            return new Field.Reference(z, reference);
        }
        if (field != null) {
            return FieldKt.clone(field, z);
        }
        return Field.INSTANCE.nullField(z);
    }

    public static <V> Field<V> readOptionalField(ParsingContext parsingContext, JSONObject jSONObject, String str, boolean z, Field<V> field, Lazy<Deserializer<JSONObject, V>> lazy) {
        Object optional = JsonPropertyParser.readOptional(parsingContext, jSONObject, str, lazy);
        if (optional != null) {
            return new Field.Value(z, optional);
        }
        String reference = readReference(parsingContext, jSONObject, str);
        if (reference != null) {
            return new Field.Reference(z, reference);
        }
        if (field != null) {
            return FieldKt.clone(field, z);
        }
        return Field.INSTANCE.nullField(z);
    }

    public static <V> Field<Expression<V>> readFieldWithExpression(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, boolean z, Field<Expression<V>> field) {
        return readFieldWithExpression(parsingContext, jSONObject, str, typeHelper, z, field, JsonParsers.doNotConvert(), JsonParsers.alwaysValid());
    }

    public static <R, V> Field<Expression<V>> readFieldWithExpression(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, boolean z, Field<Expression<V>> field, Function1<R, V> function1) {
        return readFieldWithExpression(parsingContext, jSONObject, str, typeHelper, z, field, function1, JsonParsers.alwaysValid());
    }

    public static <V> Field<Expression<V>> readFieldWithExpression(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, boolean z, Field<Expression<V>> field, ValueValidator<V> valueValidator) {
        return readFieldWithExpression(parsingContext, jSONObject, str, typeHelper, z, field, JsonParsers.doNotConvert(), valueValidator);
    }

    public static <R, V> Field<Expression<V>> readFieldWithExpression(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, boolean z, Field<Expression<V>> field, Function1<R, V> function1, ValueValidator<V> valueValidator) {
        try {
            return new Field.Value(z, JsonExpressionParser.readExpression(parsingContext, jSONObject, str, typeHelper, function1, valueValidator));
        } catch (ParsingException e) {
            JsonTemplateParserKt.suppressMissingValueOrThrow(e);
            Field<Expression<V>> fieldReferenceOrFallback = referenceOrFallback(z, readReference(parsingContext, jSONObject, str), field);
            if (fieldReferenceOrFallback != null) {
                return fieldReferenceOrFallback;
            }
            throw e;
        }
    }

    public static Field<Expression<String>> readOptionalFieldWithExpression(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<String> typeHelper, boolean z, Field<Expression<String>> field) {
        return readOptionalFieldWithExpression(parsingContext, jSONObject, str, typeHelper, z, field, JsonParsers.doNotConvert(), JsonParsers.alwaysValidString());
    }

    public static <R, V> Field<Expression<V>> readOptionalFieldWithExpression(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, boolean z, Field<Expression<V>> field, Function1<R, V> function1) {
        return readOptionalFieldWithExpression(parsingContext, jSONObject, str, typeHelper, z, field, function1, JsonParsers.alwaysValid());
    }

    public static <V> Field<Expression<V>> readOptionalFieldWithExpression(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, boolean z, Field<Expression<V>> field, ValueValidator<V> valueValidator) {
        return readOptionalFieldWithExpression(parsingContext, jSONObject, str, typeHelper, z, field, JsonParsers.doNotConvert(), valueValidator);
    }

    public static <R, V> Field<Expression<V>> readOptionalFieldWithExpression(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, boolean z, Field<Expression<V>> field, Function1<R, V> function1, ValueValidator<V> valueValidator) {
        Expression optionalExpression = JsonExpressionParser.readOptionalExpression(parsingContext, jSONObject, str, typeHelper, function1, valueValidator, null);
        if (optionalExpression != null) {
            return new Field.Value(z, optionalExpression);
        }
        String reference = readReference(parsingContext, jSONObject, str);
        if (reference != null) {
            return new Field.Reference(z, reference);
        }
        if (field != null) {
            return FieldKt.clone(field, z);
        }
        return Field.INSTANCE.nullField(z);
    }

    public static <R, V> Field<List<V>> readListField(ParsingContext parsingContext, JSONObject jSONObject, String str, boolean z, Field<List<V>> field, Function1<R, V> function1) {
        return readListField(parsingContext, jSONObject, str, z, field, function1, JsonParsers.alwaysValidList(), JsonParsers.alwaysValid());
    }

    public static <R, V> Field<List<V>> readListField(ParsingContext parsingContext, JSONObject jSONObject, String str, boolean z, Field<List<V>> field, Function1<R, V> function1, ListValidator<V> listValidator) {
        return readListField(parsingContext, jSONObject, str, z, field, function1, listValidator, JsonParsers.alwaysValid());
    }

    public static <R, V> Field<List<V>> readListField(ParsingContext parsingContext, JSONObject jSONObject, String str, boolean z, Field<List<V>> field, Function1<R, V> function1, ListValidator<V> listValidator, ValueValidator<V> valueValidator) {
        try {
            return new Field.Value(z, JsonPropertyParser.readList(parsingContext, jSONObject, str, function1, listValidator, valueValidator));
        } catch (ParsingException e) {
            JsonTemplateParserKt.suppressMissingValueOrThrow(e);
            Field<List<V>> fieldReferenceOrFallback = referenceOrFallback(z, readReference(parsingContext, jSONObject, str), field);
            if (fieldReferenceOrFallback != null) {
                return fieldReferenceOrFallback;
            }
            throw e;
        }
    }

    public static <V> Field<List<V>> readListField(ParsingContext parsingContext, JSONObject jSONObject, String str, boolean z, Field<List<V>> field, Lazy<Deserializer<JSONObject, V>> lazy) {
        try {
            return new Field.Value(z, JsonPropertyParser.readList(parsingContext, jSONObject, str, lazy));
        } catch (ParsingException e) {
            JsonTemplateParserKt.suppressMissingValueOrThrow(e);
            Field<List<V>> fieldReferenceOrFallback = referenceOrFallback(z, readReference(parsingContext, jSONObject, str), field);
            if (fieldReferenceOrFallback != null) {
                return fieldReferenceOrFallback;
            }
            throw e;
        }
    }

    public static <V> Field<List<V>> readListField(ParsingContext parsingContext, JSONObject jSONObject, String str, boolean z, Field<List<V>> field, Lazy<Deserializer<JSONObject, V>> lazy, ListValidator<V> listValidator) {
        try {
            return new Field.Value(z, JsonPropertyParser.readList(parsingContext, jSONObject, str, lazy, listValidator));
        } catch (ParsingException e) {
            JsonTemplateParserKt.suppressMissingValueOrThrow(e);
            Field<List<V>> fieldReferenceOrFallback = referenceOrFallback(z, readReference(parsingContext, jSONObject, str), field);
            if (fieldReferenceOrFallback != null) {
                return fieldReferenceOrFallback;
            }
            throw e;
        }
    }

    public static <R, V> Field<List<V>> readOptionalListField(ParsingContext parsingContext, JSONObject jSONObject, String str, boolean z, Field<List<V>> field, Function1<R, V> function1) {
        return readOptionalListField(parsingContext, jSONObject, str, z, field, function1, JsonParsers.alwaysValidList(), JsonParsers.alwaysValid());
    }

    public static <R, V> Field<List<V>> readOptionalListField(ParsingContext parsingContext, JSONObject jSONObject, String str, boolean z, Field<List<V>> field, Function1<R, V> function1, ListValidator<V> listValidator) {
        return readOptionalListField(parsingContext, jSONObject, str, z, field, function1, listValidator, JsonParsers.alwaysValid());
    }

    public static <V> Field<List<V>> readOptionalListField(ParsingContext parsingContext, JSONObject jSONObject, String str, boolean z, Field<List<V>> field, ListValidator<V> listValidator, ValueValidator<V> valueValidator) {
        return readOptionalListField(parsingContext, jSONObject, str, z, field, JsonParsers.doNotConvert(), listValidator, valueValidator);
    }

    public static <R, V> Field<List<V>> readOptionalListField(ParsingContext parsingContext, JSONObject jSONObject, String str, boolean z, Field<List<V>> field, Function1<R, V> function1, ListValidator<V> listValidator, ValueValidator<V> valueValidator) {
        List optionalList = JsonPropertyParser.readOptionalList(parsingContext, jSONObject, str, function1, listValidator, valueValidator);
        if (optionalList != null) {
            return new Field.Value(z, optionalList);
        }
        String reference = readReference(parsingContext, jSONObject, str);
        if (reference != null) {
            return new Field.Reference(z, reference);
        }
        if (field != null) {
            return FieldKt.clone(field, z);
        }
        return Field.INSTANCE.nullField(z);
    }

    public static <V> Field<List<V>> readOptionalListField(ParsingContext parsingContext, JSONObject jSONObject, String str, boolean z, Field<List<V>> field, Lazy<Deserializer<JSONObject, V>> lazy) {
        List optionalList = JsonPropertyParser.readOptionalList(parsingContext, jSONObject, str, lazy);
        if (optionalList != null) {
            return new Field.Value(z, optionalList);
        }
        String reference = readReference(parsingContext, jSONObject, str);
        if (reference != null) {
            return new Field.Reference(z, reference);
        }
        if (field != null) {
            return FieldKt.clone(field, z);
        }
        return Field.INSTANCE.nullField(z);
    }

    public static <V> Field<List<V>> readOptionalListField(ParsingContext parsingContext, JSONObject jSONObject, String str, boolean z, Field<List<V>> field, Lazy<Deserializer<JSONObject, V>> lazy, ListValidator<V> listValidator) {
        List optionalList = JsonPropertyParser.readOptionalList(parsingContext, jSONObject, str, lazy, listValidator);
        if (optionalList != null) {
            return new Field.Value(z, optionalList);
        }
        String reference = readReference(parsingContext, jSONObject, str);
        if (reference != null) {
            return new Field.Reference(z, reference);
        }
        if (field != null) {
            return FieldKt.clone(field, z);
        }
        return Field.INSTANCE.nullField(z);
    }

    public static <R, V> Field<ExpressionList<V>> readExpressionListField(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, boolean z, Field<ExpressionList<V>> field, Function1<R, V> function1) {
        return readExpressionListField(parsingContext, jSONObject, str, typeHelper, z, field, function1, JsonParsers.alwaysValidList(), JsonParsers.alwaysValid());
    }

    public static <R, V> Field<ExpressionList<V>> readExpressionListField(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, boolean z, Field<ExpressionList<V>> field, Function1<R, V> function1, ListValidator<V> listValidator) {
        return readExpressionListField(parsingContext, jSONObject, str, typeHelper, z, field, function1, listValidator, JsonParsers.alwaysValid());
    }

    public static <V> Field<ExpressionList<V>> readExpressionListField(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, boolean z, Field<ExpressionList<V>> field, ListValidator<V> listValidator) {
        return readExpressionListField(parsingContext, jSONObject, str, typeHelper, z, field, JsonParsers.doNotConvert(), listValidator, JsonParsers.alwaysValid());
    }

    public static <V> Field<ExpressionList<V>> readExpressionListField(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, boolean z, Field<ExpressionList<V>> field, ListValidator<V> listValidator, ValueValidator<V> valueValidator) {
        return readExpressionListField(parsingContext, jSONObject, str, typeHelper, z, field, JsonParsers.doNotConvert(), listValidator, valueValidator);
    }

    public static <R, V> Field<ExpressionList<V>> readExpressionListField(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, boolean z, Field<ExpressionList<V>> field, Function1<R, V> function1, ListValidator<V> listValidator, ValueValidator<V> valueValidator) {
        ExpressionList optionalExpressionList = JsonExpressionParser.readOptionalExpressionList(parsingContext, jSONObject, str, typeHelper, function1, listValidator, valueValidator);
        if (optionalExpressionList != null) {
            return new Field.Value(z, optionalExpressionList);
        }
        String reference = readReference(parsingContext, jSONObject, str);
        if (reference != null) {
            return new Field.Reference(z, reference);
        }
        if (field != null) {
            return FieldKt.clone(field, z);
        }
        return Field.INSTANCE.nullField(z);
    }

    public static <R, V> Field<ExpressionList<V>> readOptionalExpressionListField(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, boolean z, Field<ExpressionList<V>> field, Function1<R, V> function1) {
        return readOptionalExpressionListField(parsingContext, jSONObject, str, typeHelper, z, field, function1, JsonParsers.alwaysValidList(), JsonParsers.alwaysValid());
    }

    public static <R, V> Field<ExpressionList<V>> readOptionalExpressionListField(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, boolean z, Field<ExpressionList<V>> field, Function1<R, V> function1, ListValidator<V> listValidator) {
        return readOptionalExpressionListField(parsingContext, jSONObject, str, typeHelper, z, field, function1, listValidator, JsonParsers.alwaysValid());
    }

    public static <V> Field<ExpressionList<V>> readOptionalExpressionListField(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, boolean z, Field<ExpressionList<V>> field, ListValidator<V> listValidator) {
        return readOptionalExpressionListField(parsingContext, jSONObject, str, typeHelper, z, field, JsonParsers.doNotConvert(), listValidator, JsonParsers.alwaysValid());
    }

    public static <V> Field<ExpressionList<V>> readOptionalExpressionListField(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, boolean z, Field<ExpressionList<V>> field, ListValidator<V> listValidator, ValueValidator<V> valueValidator) {
        return readOptionalExpressionListField(parsingContext, jSONObject, str, typeHelper, z, field, JsonParsers.doNotConvert(), listValidator, valueValidator);
    }

    public static <R, V> Field<ExpressionList<V>> readOptionalExpressionListField(ParsingContext parsingContext, JSONObject jSONObject, String str, TypeHelper<V> typeHelper, boolean z, Field<ExpressionList<V>> field, Function1<R, V> function1, ListValidator<V> listValidator, ValueValidator<V> valueValidator) {
        ExpressionList optionalExpressionList = JsonExpressionParser.readOptionalExpressionList(parsingContext, jSONObject, str, typeHelper, function1, listValidator, valueValidator);
        if (optionalExpressionList != null) {
            return new Field.Value(z, optionalExpressionList);
        }
        String reference = readReference(parsingContext, jSONObject, str);
        if (reference != null) {
            return new Field.Reference(z, reference);
        }
        if (field != null) {
            return FieldKt.clone(field, z);
        }
        return Field.INSTANCE.nullField(z);
    }

    public static String readReference(ParsingContext parsingContext, JSONObject jSONObject, String str) {
        return (String) JsonPropertyParser.readOptional(parsingContext, jSONObject, "$" + str, IS_NOT_EMPTY);
    }

    public static <V> Field<V> referenceOrFallback(boolean z, String str, Field<V> field) {
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

    public static <V> void writeField(ParsingContext parsingContext, JSONObject jSONObject, String str, Field<V> field) {
        writeField(parsingContext, jSONObject, str, field, JsonParsers.doNotConvert());
    }

    public static <R, V> void writeField(ParsingContext parsingContext, JSONObject jSONObject, String str, Field<V> field, Function1<V, R> function1) {
        if (field instanceof Field.Value) {
            JsonPropertyParser.write(parsingContext, jSONObject, str, ((Field.Value) field).value, (Function1<T, R>) function1);
        } else if (field instanceof Field.Reference) {
            JsonPropertyParser.write(parsingContext, jSONObject, "$" + str, ((Field.Reference) field).reference);
        }
    }

    public static <V> void writeField(ParsingContext parsingContext, JSONObject jSONObject, String str, Field<V> field, Lazy<Serializer<JSONObject, V>> lazy) {
        if (field instanceof Field.Value) {
            JsonPropertyParser.write(parsingContext, jSONObject, str, ((Field.Value) field).value, (Lazy<Serializer<JSONObject, T>>) lazy);
        } else if (field instanceof Field.Reference) {
            JsonPropertyParser.write(parsingContext, jSONObject, "$" + str, ((Field.Reference) field).reference);
        }
    }

    public static <V> void writeListField(ParsingContext parsingContext, JSONObject jSONObject, String str, Field<List<V>> field) {
        writeListField(parsingContext, jSONObject, str, field, JsonParsers.doNotConvert());
    }

    public static <R, V> void writeListField(ParsingContext parsingContext, JSONObject jSONObject, String str, Field<List<V>> field, Function1<V, R> function1) {
        if (field instanceof Field.Value) {
            JsonPropertyParser.writeList(parsingContext, jSONObject, str, (List) ((Field.Value) field).value, function1);
        } else if (field instanceof Field.Reference) {
            JsonPropertyParser.write(parsingContext, jSONObject, "$" + str, ((Field.Reference) field).reference);
        }
    }

    public static <V> void writeListField(ParsingContext parsingContext, JSONObject jSONObject, String str, Field<List<V>> field, Lazy<Serializer<JSONObject, V>> lazy) {
        if (field instanceof Field.Value) {
            JsonPropertyParser.writeList(parsingContext, jSONObject, str, (List) ((Field.Value) field).value, lazy);
        } else if (field instanceof Field.Reference) {
            JsonPropertyParser.write(parsingContext, jSONObject, "$" + str, ((Field.Reference) field).reference);
        }
    }

    public static <V> void writeExpressionField(ParsingContext parsingContext, JSONObject jSONObject, String str, Field<Expression<V>> field) {
        writeExpressionField(parsingContext, jSONObject, str, field, JsonParsers.doNotConvert());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R, V> void writeExpressionField(ParsingContext parsingContext, JSONObject jSONObject, String str, Field<Expression<V>> field, Function1<V, R> function1) {
        if (field instanceof Field.Value) {
            JsonExpressionParser.writeExpression(parsingContext, jSONObject, str, (Expression) ((Field.Value) field).value, function1);
        } else if (field instanceof Field.Reference) {
            JsonPropertyParser.write(parsingContext, jSONObject, "$" + str, ((Field.Reference) field).reference);
        }
    }

    public static <V> void writeExpressionListField(ParsingContext parsingContext, JSONObject jSONObject, String str, Field<ExpressionList<V>> field) {
        writeExpressionListField(parsingContext, jSONObject, str, field, JsonParsers.doNotConvert());
    }

    public static <R, V> void writeExpressionListField(ParsingContext parsingContext, JSONObject jSONObject, String str, Field<ExpressionList<V>> field, Function1<V, R> function1) {
        if (field instanceof Field.Value) {
            JsonExpressionParser.writeExpressionList(parsingContext, jSONObject, str, (ExpressionList) ((Field.Value) field).value, function1);
        } else if (field instanceof Field.Reference) {
            JsonPropertyParser.write(parsingContext, jSONObject, "$" + str, ((Field.Reference) field).reference);
        }
    }
}
