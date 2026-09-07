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
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivCollectionItemBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0002\u0019\u001aB-\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ0\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ \u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\b\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/yandex/div2/DivCollectionItemBuilder;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "data", "Lcom/yandex/div/json/expressions/Expression;", "Lorg/json/JSONArray;", "dataElementName", "", "prototypes", "", "Lcom/yandex/div2/DivCollectionItemBuilder$Prototype;", "(Lcom/yandex/div/json/expressions/Expression;Ljava/lang/String;Ljava/util/List;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "Prototype", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivCollectionItemBuilder implements JSONSerializable, Hashable {
    private Integer _hash;
    public final Expression<JSONArray> data;
    public final String dataElementName;
    public final List<Prototype> prototypes;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String DATA_ELEMENT_NAME_DEFAULT_VALUE = "it";
    private static final Function2<ParsingEnvironment, JSONObject, DivCollectionItemBuilder> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivCollectionItemBuilder>() { // from class: com.yandex.div2.DivCollectionItemBuilder$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivCollectionItemBuilder invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivCollectionItemBuilder.INSTANCE.fromJson(env, it);
        }
    };

    @JvmStatic
    public static final DivCollectionItemBuilder fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivCollectionItemBuilder(Expression<JSONArray> data, String dataElementName, List<Prototype> prototypes) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(dataElementName, "dataElementName");
        Intrinsics.checkNotNullParameter(prototypes, "prototypes");
        this.data = data;
        this.dataElementName = dataElementName;
        this.prototypes = prototypes;
    }

    public /* synthetic */ DivCollectionItemBuilder(Expression expression, String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(expression, (i & 2) != 0 ? DATA_ELEMENT_NAME_DEFAULT_VALUE : str, list);
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + this.data.hashCode() + this.dataElementName.hashCode();
        Iterator<T> it = this.prototypes.iterator();
        int iHash = 0;
        while (it.hasNext()) {
            iHash += ((Prototype) it.next()).hash();
        }
        int i = iHashCode + iHash;
        this._hash = Integer.valueOf(i);
        return i;
    }

    public final boolean equals(DivCollectionItemBuilder other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null || !Intrinsics.areEqual(this.data.evaluate(resolver), other.data.evaluate(otherResolver)) || !Intrinsics.areEqual(this.dataElementName, other.dataElementName)) {
            return false;
        }
        List<Prototype> list = this.prototypes;
        List<Prototype> list2 = other.prototypes;
        if (list.size() != list2.size()) {
            return false;
        }
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (!((Prototype) obj).equals(list2.get(i), resolver, otherResolver)) {
                return false;
            }
            i = i2;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivCollectionItemBuilder copy$default(DivCollectionItemBuilder divCollectionItemBuilder, Expression expression, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            expression = divCollectionItemBuilder.data;
        }
        if ((i & 2) != 0) {
            str = divCollectionItemBuilder.dataElementName;
        }
        if ((i & 4) != 0) {
            list = divCollectionItemBuilder.prototypes;
        }
        return divCollectionItemBuilder.copy(expression, str, list);
    }

    public final DivCollectionItemBuilder copy(Expression<JSONArray> data, String dataElementName, List<Prototype> prototypes) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(dataElementName, "dataElementName");
        Intrinsics.checkNotNullParameter(prototypes, "prototypes");
        return new DivCollectionItemBuilder(data, dataElementName, prototypes);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivCollectionItemBuilderJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivCollectionItemBuilder.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u000fR#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/yandex/div2/DivCollectionItemBuilder$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivCollectionItemBuilder;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "DATA_ELEMENT_NAME_DEFAULT_VALUE", "", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivCollectionItemBuilder fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivCollectionItemBuilderJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivCollectionItemBuilder> getCREATOR() {
            return DivCollectionItemBuilder.CREATOR;
        }
    }

    /* JADX INFO: compiled from: DivCollectionItemBuilder.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0002\u0010\nJ2\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006J \u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0014\u001a\u00020\fH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/yandex/div2/DivCollectionItemBuilder$Prototype;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "div", "Lcom/yandex/div2/Div;", "id", "Lcom/yandex/div/json/expressions/Expression;", "", "selector", "", "(Lcom/yandex/div2/Div;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Prototype implements JSONSerializable, Hashable {
        private Integer _hash;
        public final Div div;
        public final Expression<String> id;
        public final Expression<Boolean> selector;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Expression<Boolean> SELECTOR_DEFAULT_VALUE = Expression.INSTANCE.constant(true);
        private static final Function2<ParsingEnvironment, JSONObject, Prototype> CREATOR = new Function2<ParsingEnvironment, JSONObject, Prototype>() { // from class: com.yandex.div2.DivCollectionItemBuilder$Prototype$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivCollectionItemBuilder.Prototype invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return DivCollectionItemBuilder.Prototype.INSTANCE.fromJson(env, it);
            }
        };

        @JvmStatic
        public static final Prototype fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
            return INSTANCE.fromJson(parsingEnvironment, jSONObject);
        }

        public Prototype(Div div, Expression<String> expression, Expression<Boolean> selector) {
            Intrinsics.checkNotNullParameter(div, "div");
            Intrinsics.checkNotNullParameter(selector, "selector");
            this.div = div;
            this.id = expression;
            this.selector = selector;
        }

        public /* synthetic */ Prototype(Div div, Expression expression, Expression expression2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(div, (i & 2) != 0 ? null : expression, (i & 4) != 0 ? SELECTOR_DEFAULT_VALUE : expression2);
        }

        @Override // com.yandex.div.data.Hashable
        public int hash() {
            Integer num = this._hash;
            if (num != null) {
                return num.intValue();
            }
            int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + this.div.hash();
            Expression<String> expression = this.id;
            int iHashCode2 = iHashCode + (expression != null ? expression.hashCode() : 0) + this.selector.hashCode();
            this._hash = Integer.valueOf(iHashCode2);
            return iHashCode2;
        }

        public final boolean equals(Prototype other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
            if (other == null || !this.div.equals(other.div, resolver, otherResolver)) {
                return false;
            }
            Expression<String> expression = this.id;
            String strEvaluate = expression != null ? expression.evaluate(resolver) : null;
            Expression<String> expression2 = other.id;
            return Intrinsics.areEqual(strEvaluate, expression2 != null ? expression2.evaluate(otherResolver) : null) && this.selector.evaluate(resolver).booleanValue() == other.selector.evaluate(otherResolver).booleanValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Prototype copy$default(Prototype prototype, Div div, Expression expression, Expression expression2, int i, Object obj) {
            if ((i & 1) != 0) {
                div = prototype.div;
            }
            if ((i & 2) != 0) {
                expression = prototype.id;
            }
            if ((i & 4) != 0) {
                expression2 = prototype.selector;
            }
            return prototype.copy(div, expression, expression2);
        }

        public final Prototype copy(Div div, Expression<String> id, Expression<Boolean> selector) {
            Intrinsics.checkNotNullParameter(div, "div");
            Intrinsics.checkNotNullParameter(selector, "selector");
            return new Prototype(div, id, selector);
        }

        @Override // com.yandex.div.json.JSONSerializable
        public JSONObject writeToJSON() {
            return BuiltInParserKt.getBuiltInParserComponent().getDivCollectionItemBuilderPrototypeJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
        }

        /* JADX INFO: compiled from: DivCollectionItemBuilder.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u0010R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/yandex/div2/DivCollectionItemBuilder$Prototype$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivCollectionItemBuilder$Prototype;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "SELECTOR_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Prototype fromJson(ParsingEnvironment env, JSONObject json) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(json, "json");
                return BuiltInParserKt.getBuiltInParserComponent().getDivCollectionItemBuilderPrototypeJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
            }

            public final Function2<ParsingEnvironment, JSONObject, Prototype> getCREATOR() {
                return Prototype.CREATOR;
            }
        }
    }
}
