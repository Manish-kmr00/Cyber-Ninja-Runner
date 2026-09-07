package com.yandex.div2;

import com.json.cc;
import com.yandex.div.data.Hashable;
import com.yandex.div.json.JSONSerializable;
import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.serialization.BuiltInParserKt;
import com.yandex.div.serialization.ParsingContext;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivFixedLengthInputMask.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u001c\u001dB;\b\u0007\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0002\u0010\rJ@\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\bJ \u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/yandex/div2/DivFixedLengthInputMask;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "Lcom/yandex/div2/DivInputMaskBase;", "alwaysVisible", "Lcom/yandex/div/json/expressions/Expression;", "", "pattern", "", "patternElements", "", "Lcom/yandex/div2/DivFixedLengthInputMask$PatternElement;", "rawTextVariable", "(Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Ljava/lang/String;)V", "_hash", "", "Ljava/lang/Integer;", "getRawTextVariable", "()Ljava/lang/String;", "copy", "equals", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "PatternElement", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivFixedLengthInputMask implements JSONSerializable, Hashable, DivInputMaskBase {
    public static final String TYPE = "fixed_length";
    private Integer _hash;
    public final Expression<Boolean> alwaysVisible;
    public final Expression<String> pattern;
    public final List<PatternElement> patternElements;
    private final String rawTextVariable;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Expression<Boolean> ALWAYS_VISIBLE_DEFAULT_VALUE = Expression.INSTANCE.constant(false);
    private static final Function2<ParsingEnvironment, JSONObject, DivFixedLengthInputMask> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivFixedLengthInputMask>() { // from class: com.yandex.div2.DivFixedLengthInputMask$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivFixedLengthInputMask invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivFixedLengthInputMask.INSTANCE.fromJson(env, it);
        }
    };

    @JvmStatic
    public static final DivFixedLengthInputMask fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivFixedLengthInputMask(Expression<Boolean> alwaysVisible, Expression<String> pattern, List<PatternElement> patternElements, String rawTextVariable) {
        Intrinsics.checkNotNullParameter(alwaysVisible, "alwaysVisible");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Intrinsics.checkNotNullParameter(patternElements, "patternElements");
        Intrinsics.checkNotNullParameter(rawTextVariable, "rawTextVariable");
        this.alwaysVisible = alwaysVisible;
        this.pattern = pattern;
        this.patternElements = patternElements;
        this.rawTextVariable = rawTextVariable;
    }

    public /* synthetic */ DivFixedLengthInputMask(Expression expression, Expression expression2, List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ALWAYS_VISIBLE_DEFAULT_VALUE : expression, expression2, list, str);
    }

    @Override // com.yandex.div2.DivInputMaskBase
    public String getRawTextVariable() {
        return this.rawTextVariable;
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + this.alwaysVisible.hashCode() + this.pattern.hashCode();
        Iterator<T> it = this.patternElements.iterator();
        int iHash = 0;
        while (it.hasNext()) {
            iHash += ((PatternElement) it.next()).hash();
        }
        int iHashCode2 = iHashCode + iHash + getRawTextVariable().hashCode();
        this._hash = Integer.valueOf(iHashCode2);
        return iHashCode2;
    }

    public final boolean equals(DivFixedLengthInputMask other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null || this.alwaysVisible.evaluate(resolver).booleanValue() != other.alwaysVisible.evaluate(otherResolver).booleanValue() || !Intrinsics.areEqual(this.pattern.evaluate(resolver), other.pattern.evaluate(otherResolver))) {
            return false;
        }
        List<PatternElement> list = this.patternElements;
        List<PatternElement> list2 = other.patternElements;
        if (list.size() != list2.size()) {
            return false;
        }
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (!((PatternElement) obj).equals(list2.get(i), resolver, otherResolver)) {
                return false;
            }
            i = i2;
        }
        return Intrinsics.areEqual(getRawTextVariable(), other.getRawTextVariable());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivFixedLengthInputMask copy$default(DivFixedLengthInputMask divFixedLengthInputMask, Expression expression, Expression expression2, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            expression = divFixedLengthInputMask.alwaysVisible;
        }
        if ((i & 2) != 0) {
            expression2 = divFixedLengthInputMask.pattern;
        }
        if ((i & 4) != 0) {
            list = divFixedLengthInputMask.patternElements;
        }
        if ((i & 8) != 0) {
            str = divFixedLengthInputMask.getRawTextVariable();
        }
        return divFixedLengthInputMask.copy(expression, expression2, list, str);
    }

    public final DivFixedLengthInputMask copy(Expression<Boolean> alwaysVisible, Expression<String> pattern, List<PatternElement> patternElements, String rawTextVariable) {
        Intrinsics.checkNotNullParameter(alwaysVisible, "alwaysVisible");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Intrinsics.checkNotNullParameter(patternElements, "patternElements");
        Intrinsics.checkNotNullParameter(rawTextVariable, "rawTextVariable");
        return new DivFixedLengthInputMask(alwaysVisible, pattern, patternElements, rawTextVariable);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivFixedLengthInputMaskJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivFixedLengthInputMask.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u0012R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/yandex/div2/DivFixedLengthInputMask$Companion;", "", "()V", "ALWAYS_VISIBLE_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivFixedLengthInputMask;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "TYPE", "", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivFixedLengthInputMask fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivFixedLengthInputMaskJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivFixedLengthInputMask> getCREATOR() {
            return DivFixedLengthInputMask.CREATOR;
        }
    }

    /* JADX INFO: compiled from: DivFixedLengthInputMask.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0016B7\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0002\u0010\bJ8\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J \u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/yandex/div2/DivFixedLengthInputMask$PatternElement;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "key", "Lcom/yandex/div/json/expressions/Expression;", "", "placeholder", "regex", "(Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class PatternElement implements JSONSerializable, Hashable {
        private Integer _hash;
        public final Expression<String> key;
        public final Expression<String> placeholder;
        public final Expression<String> regex;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Expression<String> PLACEHOLDER_DEFAULT_VALUE = Expression.INSTANCE.constant("_");
        private static final Function2<ParsingEnvironment, JSONObject, PatternElement> CREATOR = new Function2<ParsingEnvironment, JSONObject, PatternElement>() { // from class: com.yandex.div2.DivFixedLengthInputMask$PatternElement$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivFixedLengthInputMask.PatternElement invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return DivFixedLengthInputMask.PatternElement.INSTANCE.fromJson(env, it);
            }
        };

        @JvmStatic
        public static final PatternElement fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
            return INSTANCE.fromJson(parsingEnvironment, jSONObject);
        }

        public PatternElement(Expression<String> key, Expression<String> placeholder, Expression<String> expression) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(placeholder, "placeholder");
            this.key = key;
            this.placeholder = placeholder;
            this.regex = expression;
        }

        public /* synthetic */ PatternElement(Expression expression, Expression expression2, Expression expression3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(expression, (i & 2) != 0 ? PLACEHOLDER_DEFAULT_VALUE : expression2, (i & 4) != 0 ? null : expression3);
        }

        @Override // com.yandex.div.data.Hashable
        public int hash() {
            Integer num = this._hash;
            if (num != null) {
                return num.intValue();
            }
            int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + this.key.hashCode() + this.placeholder.hashCode();
            Expression<String> expression = this.regex;
            int iHashCode2 = iHashCode + (expression != null ? expression.hashCode() : 0);
            this._hash = Integer.valueOf(iHashCode2);
            return iHashCode2;
        }

        public final boolean equals(PatternElement other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
            if (other == null || !Intrinsics.areEqual(this.key.evaluate(resolver), other.key.evaluate(otherResolver)) || !Intrinsics.areEqual(this.placeholder.evaluate(resolver), other.placeholder.evaluate(otherResolver))) {
                return false;
            }
            Expression<String> expression = this.regex;
            String strEvaluate = expression != null ? expression.evaluate(resolver) : null;
            Expression<String> expression2 = other.regex;
            return Intrinsics.areEqual(strEvaluate, expression2 != null ? expression2.evaluate(otherResolver) : null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PatternElement copy$default(PatternElement patternElement, Expression expression, Expression expression2, Expression expression3, int i, Object obj) {
            if ((i & 1) != 0) {
                expression = patternElement.key;
            }
            if ((i & 2) != 0) {
                expression2 = patternElement.placeholder;
            }
            if ((i & 4) != 0) {
                expression3 = patternElement.regex;
            }
            return patternElement.copy(expression, expression2, expression3);
        }

        public final PatternElement copy(Expression<String> key, Expression<String> placeholder, Expression<String> regex) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(placeholder, "placeholder");
            return new PatternElement(key, placeholder, regex);
        }

        @Override // com.yandex.div.json.JSONSerializable
        public JSONObject writeToJSON() {
            return BuiltInParserKt.getBuiltInParserComponent().getDivFixedLengthInputMaskPatternElementJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
        }

        /* JADX INFO: compiled from: DivFixedLengthInputMask.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u0010R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/yandex/div2/DivFixedLengthInputMask$PatternElement$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivFixedLengthInputMask$PatternElement;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "PLACEHOLDER_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final PatternElement fromJson(ParsingEnvironment env, JSONObject json) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(json, "json");
                return BuiltInParserKt.getBuiltInParserComponent().getDivFixedLengthInputMaskPatternElementJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
            }

            public final Function2<ParsingEnvironment, JSONObject, PatternElement> getCREATOR() {
                return PatternElement.CREATOR;
            }
        }
    }
}
