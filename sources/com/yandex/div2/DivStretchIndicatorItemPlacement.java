package com.yandex.div2;

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

/* JADX INFO: compiled from: DivStretchIndicatorItemPlacement.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0016B!\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ \u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J \u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/yandex/div2/DivStretchIndicatorItemPlacement;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "itemSpacing", "Lcom/yandex/div2/DivFixedSize;", "maxVisibleItems", "Lcom/yandex/div/json/expressions/Expression;", "", "(Lcom/yandex/div2/DivFixedSize;Lcom/yandex/div/json/expressions/Expression;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivStretchIndicatorItemPlacement implements JSONSerializable, Hashable {
    public static final String TYPE = "stretch";
    private Integer _hash;
    public final DivFixedSize itemSpacing;
    public final Expression<Long> maxVisibleItems;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final DivFixedSize ITEM_SPACING_DEFAULT_VALUE = new DivFixedSize(0 == true ? 1 : 0, Expression.INSTANCE.constant(5L), 1, 0 == true ? 1 : 0);
    private static final Expression<Long> MAX_VISIBLE_ITEMS_DEFAULT_VALUE = Expression.INSTANCE.constant(10L);
    private static final Function2<ParsingEnvironment, JSONObject, DivStretchIndicatorItemPlacement> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivStretchIndicatorItemPlacement>() { // from class: com.yandex.div2.DivStretchIndicatorItemPlacement$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivStretchIndicatorItemPlacement invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivStretchIndicatorItemPlacement.INSTANCE.fromJson(env, it);
        }
    };

    public DivStretchIndicatorItemPlacement() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @JvmStatic
    public static final DivStretchIndicatorItemPlacement fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivStretchIndicatorItemPlacement(DivFixedSize itemSpacing, Expression<Long> maxVisibleItems) {
        Intrinsics.checkNotNullParameter(itemSpacing, "itemSpacing");
        Intrinsics.checkNotNullParameter(maxVisibleItems, "maxVisibleItems");
        this.itemSpacing = itemSpacing;
        this.maxVisibleItems = maxVisibleItems;
    }

    public /* synthetic */ DivStretchIndicatorItemPlacement(DivFixedSize divFixedSize, Expression expression, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ITEM_SPACING_DEFAULT_VALUE : divFixedSize, (i & 2) != 0 ? MAX_VISIBLE_ITEMS_DEFAULT_VALUE : expression);
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + this.itemSpacing.hash() + this.maxVisibleItems.hashCode();
        this._hash = Integer.valueOf(iHashCode);
        return iHashCode;
    }

    public final boolean equals(DivStretchIndicatorItemPlacement other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        return other != null && this.itemSpacing.equals(other.itemSpacing, resolver, otherResolver) && this.maxVisibleItems.evaluate(resolver).longValue() == other.maxVisibleItems.evaluate(otherResolver).longValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivStretchIndicatorItemPlacement copy$default(DivStretchIndicatorItemPlacement divStretchIndicatorItemPlacement, DivFixedSize divFixedSize, Expression expression, int i, Object obj) {
        if ((i & 1) != 0) {
            divFixedSize = divStretchIndicatorItemPlacement.itemSpacing;
        }
        if ((i & 2) != 0) {
            expression = divStretchIndicatorItemPlacement.maxVisibleItems;
        }
        return divStretchIndicatorItemPlacement.copy(divFixedSize, expression);
    }

    public final DivStretchIndicatorItemPlacement copy(DivFixedSize itemSpacing, Expression<Long> maxVisibleItems) {
        Intrinsics.checkNotNullParameter(itemSpacing, "itemSpacing");
        Intrinsics.checkNotNullParameter(maxVisibleItems, "maxVisibleItems");
        return new DivStretchIndicatorItemPlacement(itemSpacing, maxVisibleItems);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivStretchIndicatorItemPlacementJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivStretchIndicatorItemPlacement.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u0014R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/yandex/div2/DivStretchIndicatorItemPlacement$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivStretchIndicatorItemPlacement;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "ITEM_SPACING_DEFAULT_VALUE", "Lcom/yandex/div2/DivFixedSize;", "MAX_VISIBLE_ITEMS_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "TYPE", "", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivStretchIndicatorItemPlacement fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivStretchIndicatorItemPlacementJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivStretchIndicatorItemPlacement> getCREATOR() {
            return DivStretchIndicatorItemPlacement.CREATOR;
        }
    }
}
