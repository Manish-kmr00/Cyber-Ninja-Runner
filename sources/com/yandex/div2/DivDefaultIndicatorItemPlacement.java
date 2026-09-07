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

/* JADX INFO: compiled from: DivDefaultIndicatorItemPlacement.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0001\u0013B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004J \u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/yandex/div2/DivDefaultIndicatorItemPlacement;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "spaceBetweenCenters", "Lcom/yandex/div2/DivFixedSize;", "(Lcom/yandex/div2/DivFixedSize;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivDefaultIndicatorItemPlacement implements JSONSerializable, Hashable {
    public static final String TYPE = "default";
    private Integer _hash;
    public final DivFixedSize spaceBetweenCenters;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final DivFixedSize SPACE_BETWEEN_CENTERS_DEFAULT_VALUE = new DivFixedSize(0 == true ? 1 : 0, Expression.INSTANCE.constant(15L), 1, 0 == true ? 1 : 0);
    private static final Function2<ParsingEnvironment, JSONObject, DivDefaultIndicatorItemPlacement> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivDefaultIndicatorItemPlacement>() { // from class: com.yandex.div2.DivDefaultIndicatorItemPlacement$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivDefaultIndicatorItemPlacement invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivDefaultIndicatorItemPlacement.INSTANCE.fromJson(env, it);
        }
    };

    public DivDefaultIndicatorItemPlacement() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @JvmStatic
    public static final DivDefaultIndicatorItemPlacement fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivDefaultIndicatorItemPlacement(DivFixedSize spaceBetweenCenters) {
        Intrinsics.checkNotNullParameter(spaceBetweenCenters, "spaceBetweenCenters");
        this.spaceBetweenCenters = spaceBetweenCenters;
    }

    public /* synthetic */ DivDefaultIndicatorItemPlacement(DivFixedSize divFixedSize, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SPACE_BETWEEN_CENTERS_DEFAULT_VALUE : divFixedSize);
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + this.spaceBetweenCenters.hash();
        this._hash = Integer.valueOf(iHashCode);
        return iHashCode;
    }

    public final boolean equals(DivDefaultIndicatorItemPlacement other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null) {
            return false;
        }
        return this.spaceBetweenCenters.equals(other.spaceBetweenCenters, resolver, otherResolver);
    }

    public static /* synthetic */ DivDefaultIndicatorItemPlacement copy$default(DivDefaultIndicatorItemPlacement divDefaultIndicatorItemPlacement, DivFixedSize divFixedSize, int i, Object obj) {
        if ((i & 1) != 0) {
            divFixedSize = divDefaultIndicatorItemPlacement.spaceBetweenCenters;
        }
        return divDefaultIndicatorItemPlacement.copy(divFixedSize);
    }

    public final DivDefaultIndicatorItemPlacement copy(DivFixedSize spaceBetweenCenters) {
        Intrinsics.checkNotNullParameter(spaceBetweenCenters, "spaceBetweenCenters");
        return new DivDefaultIndicatorItemPlacement(spaceBetweenCenters);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivDefaultIndicatorItemPlacementJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivDefaultIndicatorItemPlacement.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u0011R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/yandex/div2/DivDefaultIndicatorItemPlacement$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivDefaultIndicatorItemPlacement;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "SPACE_BETWEEN_CENTERS_DEFAULT_VALUE", "Lcom/yandex/div2/DivFixedSize;", "TYPE", "", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivDefaultIndicatorItemPlacement fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivDefaultIndicatorItemPlacementJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivDefaultIndicatorItemPlacement> getCREATOR() {
            return DivDefaultIndicatorItemPlacement.CREATOR;
        }
    }
}
