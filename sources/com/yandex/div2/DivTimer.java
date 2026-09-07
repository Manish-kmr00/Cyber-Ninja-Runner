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

/* JADX INFO: compiled from: DivTimer.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cBa\b\u0007\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000eJb\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\nJ \u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/yandex/div2/DivTimer;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "duration", "Lcom/yandex/div/json/expressions/Expression;", "", "endActions", "", "Lcom/yandex/div2/DivAction;", "id", "", "tickActions", "tickInterval", "valueVariable", "(Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Ljava/lang/String;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivTimer implements JSONSerializable, Hashable {
    private Integer _hash;
    public final Expression<Long> duration;
    public final List<DivAction> endActions;
    public final String id;
    public final List<DivAction> tickActions;
    public final Expression<Long> tickInterval;
    public final String valueVariable;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Expression<Long> DURATION_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);
    private static final Function2<ParsingEnvironment, JSONObject, DivTimer> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivTimer>() { // from class: com.yandex.div2.DivTimer$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivTimer invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivTimer.INSTANCE.fromJson(env, it);
        }
    };

    @JvmStatic
    public static final DivTimer fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivTimer(Expression<Long> duration, List<DivAction> list, String id, List<DivAction> list2, Expression<Long> expression, String str) {
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(id, "id");
        this.duration = duration;
        this.endActions = list;
        this.id = id;
        this.tickActions = list2;
        this.tickInterval = expression;
        this.valueVariable = str;
    }

    public /* synthetic */ DivTimer(Expression expression, List list, String str, List list2, Expression expression2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? DURATION_DEFAULT_VALUE : expression, (i & 2) != 0 ? null : list, str, (i & 8) != 0 ? null : list2, (i & 16) != 0 ? null : expression2, (i & 32) != 0 ? null : str2);
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        int iHash;
        int iHash2;
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + this.duration.hashCode();
        List<DivAction> list = this.endActions;
        if (list != null) {
            Iterator<T> it = list.iterator();
            iHash = 0;
            while (it.hasNext()) {
                iHash += ((DivAction) it.next()).hash();
            }
        } else {
            iHash = 0;
        }
        int iHashCode2 = iHashCode + iHash + this.id.hashCode();
        List<DivAction> list2 = this.tickActions;
        if (list2 != null) {
            Iterator<T> it2 = list2.iterator();
            iHash2 = 0;
            while (it2.hasNext()) {
                iHash2 += ((DivAction) it2.next()).hash();
            }
        } else {
            iHash2 = 0;
        }
        int i = iHashCode2 + iHash2;
        Expression<Long> expression = this.tickInterval;
        int iHashCode3 = i + (expression != null ? expression.hashCode() : 0);
        String str = this.valueVariable;
        int iHashCode4 = iHashCode3 + (str != null ? str.hashCode() : 0);
        this._hash = Integer.valueOf(iHashCode4);
        return iHashCode4;
    }

    public final boolean equals(DivTimer other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null || this.duration.evaluate(resolver).longValue() != other.duration.evaluate(otherResolver).longValue()) {
            return false;
        }
        List<DivAction> list = this.endActions;
        if (list != null) {
            List<DivAction> list2 = other.endActions;
            if (list2 == null || list.size() != list2.size()) {
                return false;
            }
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (!((DivAction) obj).equals(list2.get(i), resolver, otherResolver)) {
                    return false;
                }
                i = i2;
            }
        } else if (other.endActions != null) {
            return false;
        }
        if (!Intrinsics.areEqual(this.id, other.id)) {
            return false;
        }
        List<DivAction> list3 = this.tickActions;
        if (list3 != null) {
            List<DivAction> list4 = other.tickActions;
            if (list4 == null || list3.size() != list4.size()) {
                return false;
            }
            int i3 = 0;
            for (Object obj2 : list3) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (!((DivAction) obj2).equals(list4.get(i3), resolver, otherResolver)) {
                    return false;
                }
                i3 = i4;
            }
        } else if (other.tickActions != null) {
            return false;
        }
        Expression<Long> expression = this.tickInterval;
        Long lEvaluate = expression != null ? expression.evaluate(resolver) : null;
        Expression<Long> expression2 = other.tickInterval;
        return Intrinsics.areEqual(lEvaluate, expression2 != null ? expression2.evaluate(otherResolver) : null) && Intrinsics.areEqual(this.valueVariable, other.valueVariable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivTimer copy$default(DivTimer divTimer, Expression expression, List list, String str, List list2, Expression expression2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            expression = divTimer.duration;
        }
        if ((i & 2) != 0) {
            list = divTimer.endActions;
        }
        List list3 = list;
        if ((i & 4) != 0) {
            str = divTimer.id;
        }
        String str3 = str;
        if ((i & 8) != 0) {
            list2 = divTimer.tickActions;
        }
        List list4 = list2;
        if ((i & 16) != 0) {
            expression2 = divTimer.tickInterval;
        }
        Expression expression3 = expression2;
        if ((i & 32) != 0) {
            str2 = divTimer.valueVariable;
        }
        return divTimer.copy(expression, list3, str3, list4, expression3, str2);
    }

    public final DivTimer copy(Expression<Long> duration, List<DivAction> endActions, String id, List<DivAction> tickActions, Expression<Long> tickInterval, String valueVariable) {
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(id, "id");
        return new DivTimer(duration, endActions, id, tickActions, tickInterval, valueVariable);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivTimerJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivTimer.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u0010R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/yandex/div2/DivTimer$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTimer;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "DURATION_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivTimer fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivTimerJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivTimer> getCREATOR() {
            return DivTimer.CREATOR;
        }
    }
}
