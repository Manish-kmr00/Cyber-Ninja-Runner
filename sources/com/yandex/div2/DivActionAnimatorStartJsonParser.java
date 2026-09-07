package com.yandex.div2;

import com.yandex.div.internal.parser.JsonExpressionParser;
import com.yandex.div.internal.parser.JsonFieldParser;
import com.yandex.div.internal.parser.JsonFieldResolver;
import com.yandex.div.internal.parser.JsonPropertyParser;
import com.yandex.div.internal.parser.ParsingConvertersKt;
import com.yandex.div.internal.parser.TypeHelper;
import com.yandex.div.internal.parser.TypeHelpersKt;
import com.yandex.div.internal.parser.ValueValidator;
import com.yandex.div.internal.template.Field;
import com.yandex.div.json.ParsingException;
import com.yandex.div.serialization.Parser;
import com.yandex.div.serialization.ParsingContext;
import com.yandex.div.serialization.ParsingContextKt;
import com.yandex.div.serialization.TemplateParser;
import com.yandex.div.serialization.TemplateResolver;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivActionAnimatorStartJsonParser.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivActionAnimatorStartJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "Companion", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivActionAnimatorStartJsonParser {
    private final JsonParserComponent component;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final TypeHelper<DivAnimationDirection> TYPE_HELPER_DIRECTION = TypeHelper.INSTANCE.from(ArraysKt.first(DivAnimationDirection.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivActionAnimatorStartJsonParser$Companion$TYPE_HELPER_DIRECTION$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivAnimationDirection);
        }
    });

    @Deprecated
    public static final TypeHelper<DivAnimationInterpolator> TYPE_HELPER_INTERPOLATOR = TypeHelper.INSTANCE.from(ArraysKt.first(DivAnimationInterpolator.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivActionAnimatorStartJsonParser$Companion$TYPE_HELPER_INTERPOLATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivAnimationInterpolator);
        }
    });

    @Deprecated
    public static final ValueValidator<Long> DURATION_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivActionAnimatorStartJsonParser$$ExternalSyntheticLambda0
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivActionAnimatorStartJsonParser.DURATION_VALIDATOR$lambda$0(((Long) obj).longValue());
        }
    };

    @Deprecated
    public static final ValueValidator<Long> START_DELAY_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivActionAnimatorStartJsonParser$$ExternalSyntheticLambda1
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivActionAnimatorStartJsonParser.START_DELAY_VALIDATOR$lambda$1(((Long) obj).longValue());
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DURATION_VALIDATOR$lambda$0(long j) {
        return j >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean START_DELAY_VALIDATOR$lambda$1(long j) {
        return j >= 0;
    }

    public DivActionAnimatorStartJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivActionAnimatorStartJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivActionAnimatorStartJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivActionAnimatorStart;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivActionAnimatorStart> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivActionAnimatorStart deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            Object obj = JsonPropertyParser.read(context, data, "animator_id");
            Intrinsics.checkNotNullExpressionValue(obj, "read(context, data, \"animator_id\")");
            return new DivActionAnimatorStart((String) obj, JsonExpressionParser.readOptionalExpression(context, data, "direction", DivActionAnimatorStartJsonParser.TYPE_HELPER_DIRECTION, DivAnimationDirection.FROM_STRING), JsonExpressionParser.readOptionalExpression(context, data, "duration", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivActionAnimatorStartJsonParser.DURATION_VALIDATOR), (DivTypedValue) JsonPropertyParser.readOptional(context, data, "end_value", this.component.getDivTypedValueJsonEntityParser()), JsonExpressionParser.readOptionalExpression(context, data, "interpolator", DivActionAnimatorStartJsonParser.TYPE_HELPER_INTERPOLATOR, DivAnimationInterpolator.FROM_STRING), (DivCount) JsonPropertyParser.readOptional(context, data, "repeat_count", this.component.getDivCountJsonEntityParser()), JsonExpressionParser.readOptionalExpression(context, data, "start_delay", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivActionAnimatorStartJsonParser.START_DELAY_VALIDATOR), (DivTypedValue) JsonPropertyParser.readOptional(context, data, "start_value", this.component.getDivTypedValueJsonEntityParser()));
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivActionAnimatorStart value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonPropertyParser.write(context, jSONObject, "animator_id", value.animatorId);
            JsonExpressionParser.writeExpression(context, jSONObject, "direction", value.direction, DivAnimationDirection.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "duration", value.duration);
            JsonPropertyParser.write(context, jSONObject, "end_value", value.endValue, this.component.getDivTypedValueJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "interpolator", value.interpolator, DivAnimationInterpolator.TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "repeat_count", value.repeatCount, this.component.getDivCountJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "start_delay", value.startDelay);
            JsonPropertyParser.write(context, jSONObject, "start_value", value.startValue, this.component.getDivTypedValueJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "type", "animator_start");
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivActionAnimatorStartJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivActionAnimatorStartJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/TemplateParser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivActionAnimatorStartTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "parent", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements TemplateParser<JSONObject, DivActionAnimatorStartTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateDeserializer
        public DivActionAnimatorStartTemplate deserialize(ParsingContext context, DivActionAnimatorStartTemplate parent, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            boolean allowPropertyOverride = context.getAllowPropertyOverride();
            ParsingContext parsingContextRestrictPropertyOverride = ParsingContextKt.restrictPropertyOverride(context);
            Field field = JsonFieldParser.readField(parsingContextRestrictPropertyOverride, data, "animator_id", allowPropertyOverride, parent != null ? parent.animatorId : null);
            Intrinsics.checkNotNullExpressionValue(field, "readField(context, data,…ride, parent?.animatorId)");
            Field optionalFieldWithExpression = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "direction", DivActionAnimatorStartJsonParser.TYPE_HELPER_DIRECTION, allowPropertyOverride, parent != null ? parent.direction : null, DivAnimationDirection.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression, "readOptionalFieldWithExp…ionDirection.FROM_STRING)");
            Field optionalFieldWithExpression2 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "duration", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.duration : null, ParsingConvertersKt.NUMBER_TO_INT, DivActionAnimatorStartJsonParser.DURATION_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression2, "readOptionalFieldWithExp…_INT, DURATION_VALIDATOR)");
            Field optionalField = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "end_value", allowPropertyOverride, parent != null ? parent.endValue : null, this.component.getDivTypedValueJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField, "readOptionalField(contex…dValueJsonTemplateParser)");
            Field optionalFieldWithExpression3 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "interpolator", DivActionAnimatorStartJsonParser.TYPE_HELPER_INTERPOLATOR, allowPropertyOverride, parent != null ? parent.interpolator : null, DivAnimationInterpolator.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression3, "readOptionalFieldWithExp…Interpolator.FROM_STRING)");
            Field optionalField2 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "repeat_count", allowPropertyOverride, parent != null ? parent.repeatCount : null, this.component.getDivCountJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField2, "readOptionalField(contex…vCountJsonTemplateParser)");
            Field optionalFieldWithExpression4 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "start_delay", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.startDelay : null, ParsingConvertersKt.NUMBER_TO_INT, DivActionAnimatorStartJsonParser.START_DELAY_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression4, "readOptionalFieldWithExp…T, START_DELAY_VALIDATOR)");
            Field optionalField3 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "start_value", allowPropertyOverride, parent != null ? parent.startValue : null, this.component.getDivTypedValueJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField3, "readOptionalField(contex…dValueJsonTemplateParser)");
            return new DivActionAnimatorStartTemplate(field, optionalFieldWithExpression, optionalFieldWithExpression2, optionalField, optionalFieldWithExpression3, optionalField2, optionalFieldWithExpression4, optionalField3);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivActionAnimatorStartTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonFieldParser.writeField(context, jSONObject, "animator_id", value.animatorId);
            JsonFieldParser.writeExpressionField(context, jSONObject, "direction", value.direction, DivAnimationDirection.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "duration", value.duration);
            JsonFieldParser.writeField(context, jSONObject, "end_value", value.endValue, this.component.getDivTypedValueJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "interpolator", value.interpolator, DivAnimationInterpolator.TO_STRING);
            JsonFieldParser.writeField(context, jSONObject, "repeat_count", value.repeatCount, this.component.getDivCountJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "start_delay", value.startDelay);
            JsonFieldParser.writeField(context, jSONObject, "start_value", value.startValue, this.component.getDivTypedValueJsonTemplateParser());
            JsonPropertyParser.write(context, jSONObject, "type", "animator_start");
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivActionAnimatorStartJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivActionAnimatorStartJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivActionAnimatorStartTemplate;", "Lcom/yandex/div2/DivActionAnimatorStart;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivActionAnimatorStartTemplate, DivActionAnimatorStart> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivActionAnimatorStart resolve(ParsingContext context, DivActionAnimatorStartTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            Object objResolve = JsonFieldResolver.resolve(context, template.animatorId, data, "animator_id");
            Intrinsics.checkNotNullExpressionValue(objResolve, "resolve(context, templat…rId, data, \"animator_id\")");
            return new DivActionAnimatorStart((String) objResolve, JsonFieldResolver.resolveOptionalExpression(context, template.direction, data, "direction", DivActionAnimatorStartJsonParser.TYPE_HELPER_DIRECTION, DivAnimationDirection.FROM_STRING), JsonFieldResolver.resolveOptionalExpression(context, template.duration, data, "duration", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivActionAnimatorStartJsonParser.DURATION_VALIDATOR), (DivTypedValue) JsonFieldResolver.resolveOptional(context, template.endValue, data, "end_value", this.component.getDivTypedValueJsonTemplateResolver(), this.component.getDivTypedValueJsonEntityParser()), JsonFieldResolver.resolveOptionalExpression(context, template.interpolator, data, "interpolator", DivActionAnimatorStartJsonParser.TYPE_HELPER_INTERPOLATOR, DivAnimationInterpolator.FROM_STRING), (DivCount) JsonFieldResolver.resolveOptional(context, template.repeatCount, data, "repeat_count", this.component.getDivCountJsonTemplateResolver(), this.component.getDivCountJsonEntityParser()), JsonFieldResolver.resolveOptionalExpression(context, template.startDelay, data, "start_delay", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivActionAnimatorStartJsonParser.START_DELAY_VALIDATOR), (DivTypedValue) JsonFieldResolver.resolveOptional(context, template.startValue, data, "start_value", this.component.getDivTypedValueJsonTemplateResolver(), this.component.getDivTypedValueJsonEntityParser()));
        }
    }

    /* JADX INFO: compiled from: DivActionAnimatorStartJsonParser.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div2/DivActionAnimatorStartJsonParser$Companion;", "", "()V", "DURATION_VALIDATOR", "Lcom/yandex/div/internal/parser/ValueValidator;", "", "START_DELAY_VALIDATOR", "TYPE_HELPER_DIRECTION", "Lcom/yandex/div/internal/parser/TypeHelper;", "Lcom/yandex/div2/DivAnimationDirection;", "TYPE_HELPER_INTERPOLATOR", "Lcom/yandex/div2/DivAnimationInterpolator;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
