package com.yandex.div2;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.json.cc;
import com.yandex.div.data.Hashable;
import com.yandex.div.json.JSONSerializable;
import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.serialization.BuiltInParserKt;
import com.yandex.div.serialization.ParsingContext;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivAbsoluteEdgeInsets.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017BG\b\u0007\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\tJF\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J \u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/yandex/div2/DivAbsoluteEdgeInsets;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "bottom", "Lcom/yandex/div/json/expressions/Expression;", "", "left", "right", ViewHierarchyConstants.DIMENSION_TOP_KEY, "(Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivAbsoluteEdgeInsets implements JSONSerializable, Hashable {
    private Integer _hash;
    public final Expression<Long> bottom;
    public final Expression<Long> left;
    public final Expression<Long> right;
    public final Expression<Long> top;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Expression<Long> BOTTOM_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);
    private static final Expression<Long> LEFT_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);
    private static final Expression<Long> RIGHT_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);
    private static final Expression<Long> TOP_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);
    private static final Function2<ParsingEnvironment, JSONObject, DivAbsoluteEdgeInsets> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivAbsoluteEdgeInsets>() { // from class: com.yandex.div2.DivAbsoluteEdgeInsets$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivAbsoluteEdgeInsets invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivAbsoluteEdgeInsets.INSTANCE.fromJson(env, it);
        }
    };

    public DivAbsoluteEdgeInsets() {
        this(null, null, null, null, 15, null);
    }

    @JvmStatic
    public static final DivAbsoluteEdgeInsets fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivAbsoluteEdgeInsets(Expression<Long> bottom, Expression<Long> left, Expression<Long> right, Expression<Long> top) {
        Intrinsics.checkNotNullParameter(bottom, "bottom");
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(right, "right");
        Intrinsics.checkNotNullParameter(top, "top");
        this.bottom = bottom;
        this.left = left;
        this.right = right;
        this.top = top;
    }

    public /* synthetic */ DivAbsoluteEdgeInsets(Expression expression, Expression expression2, Expression expression3, Expression expression4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? BOTTOM_DEFAULT_VALUE : expression, (i & 2) != 0 ? LEFT_DEFAULT_VALUE : expression2, (i & 4) != 0 ? RIGHT_DEFAULT_VALUE : expression3, (i & 8) != 0 ? TOP_DEFAULT_VALUE : expression4);
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + this.bottom.hashCode() + this.left.hashCode() + this.right.hashCode() + this.top.hashCode();
        this._hash = Integer.valueOf(iHashCode);
        return iHashCode;
    }

    public final boolean equals(DivAbsoluteEdgeInsets other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        return other != null && this.bottom.evaluate(resolver).longValue() == other.bottom.evaluate(otherResolver).longValue() && this.left.evaluate(resolver).longValue() == other.left.evaluate(otherResolver).longValue() && this.right.evaluate(resolver).longValue() == other.right.evaluate(otherResolver).longValue() && this.top.evaluate(resolver).longValue() == other.top.evaluate(otherResolver).longValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivAbsoluteEdgeInsets copy$default(DivAbsoluteEdgeInsets divAbsoluteEdgeInsets, Expression expression, Expression expression2, Expression expression3, Expression expression4, int i, Object obj) {
        if ((i & 1) != 0) {
            expression = divAbsoluteEdgeInsets.bottom;
        }
        if ((i & 2) != 0) {
            expression2 = divAbsoluteEdgeInsets.left;
        }
        if ((i & 4) != 0) {
            expression3 = divAbsoluteEdgeInsets.right;
        }
        if ((i & 8) != 0) {
            expression4 = divAbsoluteEdgeInsets.top;
        }
        return divAbsoluteEdgeInsets.copy(expression, expression2, expression3, expression4);
    }

    public final DivAbsoluteEdgeInsets copy(Expression<Long> bottom, Expression<Long> left, Expression<Long> right, Expression<Long> top) {
        Intrinsics.checkNotNullParameter(bottom, "bottom");
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(right, "right");
        Intrinsics.checkNotNullParameter(top, "top");
        return new DivAbsoluteEdgeInsets(bottom, left, right, top);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivAbsoluteEdgeInsetsJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivAbsoluteEdgeInsets.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u0013R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/yandex/div2/DivAbsoluteEdgeInsets$Companion;", "", "()V", "BOTTOM_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivAbsoluteEdgeInsets;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "LEFT_DEFAULT_VALUE", "RIGHT_DEFAULT_VALUE", "TOP_DEFAULT_VALUE", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivAbsoluteEdgeInsets fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivAbsoluteEdgeInsetsJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivAbsoluteEdgeInsets> getCREATOR() {
            return DivAbsoluteEdgeInsets.CREATOR;
        }
    }
}
