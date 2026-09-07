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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivSlideTransition.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000  2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002 !BS\b\u0007\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\u000eJR\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J \u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bJ\b\u0010\u001d\u001a\u00020\u0010H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013¨\u0006\""}, d2 = {"Lcom/yandex/div2/DivSlideTransition;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "Lcom/yandex/div2/DivTransitionBase;", "distance", "Lcom/yandex/div2/DivDimension;", "duration", "Lcom/yandex/div/json/expressions/Expression;", "", "edge", "Lcom/yandex/div2/DivSlideTransition$Edge;", "interpolator", "Lcom/yandex/div2/DivAnimationInterpolator;", "startDelay", "(Lcom/yandex/div2/DivDimension;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;)V", "_hash", "", "Ljava/lang/Integer;", "getDuration", "()Lcom/yandex/div/json/expressions/Expression;", "getInterpolator", "getStartDelay", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "Edge", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivSlideTransition implements JSONSerializable, Hashable, DivTransitionBase {
    public static final String TYPE = "slide";
    private Integer _hash;
    public final DivDimension distance;
    private final Expression<Long> duration;
    public final Expression<Edge> edge;
    private final Expression<DivAnimationInterpolator> interpolator;
    private final Expression<Long> startDelay;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Expression<Long> DURATION_DEFAULT_VALUE = Expression.INSTANCE.constant(200L);
    private static final Expression<Edge> EDGE_DEFAULT_VALUE = Expression.INSTANCE.constant(Edge.BOTTOM);
    private static final Expression<DivAnimationInterpolator> INTERPOLATOR_DEFAULT_VALUE = Expression.INSTANCE.constant(DivAnimationInterpolator.EASE_IN_OUT);
    private static final Expression<Long> START_DELAY_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);
    private static final Function2<ParsingEnvironment, JSONObject, DivSlideTransition> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivSlideTransition>() { // from class: com.yandex.div2.DivSlideTransition$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivSlideTransition invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivSlideTransition.INSTANCE.fromJson(env, it);
        }
    };

    public DivSlideTransition() {
        this(null, null, null, null, null, 31, null);
    }

    @JvmStatic
    public static final DivSlideTransition fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivSlideTransition(DivDimension divDimension, Expression<Long> duration, Expression<Edge> edge, Expression<DivAnimationInterpolator> interpolator, Expression<Long> startDelay) {
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(edge, "edge");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        Intrinsics.checkNotNullParameter(startDelay, "startDelay");
        this.distance = divDimension;
        this.duration = duration;
        this.edge = edge;
        this.interpolator = interpolator;
        this.startDelay = startDelay;
    }

    public /* synthetic */ DivSlideTransition(DivDimension divDimension, Expression expression, Expression expression2, Expression expression3, Expression expression4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : divDimension, (i & 2) != 0 ? DURATION_DEFAULT_VALUE : expression, (i & 4) != 0 ? EDGE_DEFAULT_VALUE : expression2, (i & 8) != 0 ? INTERPOLATOR_DEFAULT_VALUE : expression3, (i & 16) != 0 ? START_DELAY_DEFAULT_VALUE : expression4);
    }

    @Override // com.yandex.div2.DivTransitionBase
    public Expression<Long> getDuration() {
        return this.duration;
    }

    @Override // com.yandex.div2.DivTransitionBase
    public Expression<DivAnimationInterpolator> getInterpolator() {
        return this.interpolator;
    }

    @Override // com.yandex.div2.DivTransitionBase
    public Expression<Long> getStartDelay() {
        return this.startDelay;
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
        DivDimension divDimension = this.distance;
        int iHash = iHashCode + (divDimension != null ? divDimension.hash() : 0) + getDuration().hashCode() + this.edge.hashCode() + getInterpolator().hashCode() + getStartDelay().hashCode();
        this._hash = Integer.valueOf(iHash);
        return iHash;
    }

    public final boolean equals(DivSlideTransition other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        boolean zEquals;
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null) {
            return false;
        }
        DivDimension divDimension = this.distance;
        if (divDimension != null) {
            zEquals = divDimension.equals(other.distance, resolver, otherResolver);
        } else {
            zEquals = other.distance == null;
        }
        return zEquals && getDuration().evaluate(resolver).longValue() == other.getDuration().evaluate(otherResolver).longValue() && this.edge.evaluate(resolver) == other.edge.evaluate(otherResolver) && getInterpolator().evaluate(resolver) == other.getInterpolator().evaluate(otherResolver) && getStartDelay().evaluate(resolver).longValue() == other.getStartDelay().evaluate(otherResolver).longValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivSlideTransition copy$default(DivSlideTransition divSlideTransition, DivDimension divDimension, Expression expression, Expression expression2, Expression expression3, Expression expression4, int i, Object obj) {
        if ((i & 1) != 0) {
            divDimension = divSlideTransition.distance;
        }
        if ((i & 2) != 0) {
            expression = divSlideTransition.getDuration();
        }
        Expression expression5 = expression;
        if ((i & 4) != 0) {
            expression2 = divSlideTransition.edge;
        }
        Expression expression6 = expression2;
        if ((i & 8) != 0) {
            expression3 = divSlideTransition.getInterpolator();
        }
        Expression expression7 = expression3;
        if ((i & 16) != 0) {
            expression4 = divSlideTransition.getStartDelay();
        }
        return divSlideTransition.copy(divDimension, expression5, expression6, expression7, expression4);
    }

    public final DivSlideTransition copy(DivDimension distance, Expression<Long> duration, Expression<Edge> edge, Expression<DivAnimationInterpolator> interpolator, Expression<Long> startDelay) {
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(edge, "edge");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        Intrinsics.checkNotNullParameter(startDelay, "startDelay");
        return new DivSlideTransition(distance, duration, edge, interpolator, startDelay);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivSlideTransitionJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivSlideTransition.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u0017R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/yandex/div2/DivSlideTransition$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivSlideTransition;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "DURATION_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "EDGE_DEFAULT_VALUE", "Lcom/yandex/div2/DivSlideTransition$Edge;", "INTERPOLATOR_DEFAULT_VALUE", "Lcom/yandex/div2/DivAnimationInterpolator;", "START_DELAY_DEFAULT_VALUE", "TYPE", "", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivSlideTransition fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivSlideTransitionJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivSlideTransition> getCREATOR() {
            return DivSlideTransition.CREATOR;
        }
    }

    /* JADX INFO: compiled from: DivSlideTransition.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/yandex/div2/DivSlideTransition$Edge;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "LEFT", "TOP", "RIGHT", "BOTTOM", "Converter", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum Edge {
        LEFT("left"),
        TOP(ViewHierarchyConstants.DIMENSION_TOP_KEY),
        RIGHT("right"),
        BOTTOM("bottom");

        private final String value;

        /* JADX INFO: renamed from: Converter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final Function1<Edge, String> TO_STRING = new Function1<Edge, String>() { // from class: com.yandex.div2.DivSlideTransition$Edge$Converter$TO_STRING$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(DivSlideTransition.Edge value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return DivSlideTransition.Edge.INSTANCE.toString(value);
            }
        };
        public static final Function1<String, Edge> FROM_STRING = new Function1<String, Edge>() { // from class: com.yandex.div2.DivSlideTransition$Edge$Converter$FROM_STRING$1
            @Override // kotlin.jvm.functions.Function1
            public final DivSlideTransition.Edge invoke(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return DivSlideTransition.Edge.INSTANCE.fromString(value);
            }
        };

        Edge(String str) {
            this.value = str;
        }

        /* JADX INFO: renamed from: com.yandex.div2.DivSlideTransition$Edge$Converter, reason: from kotlin metadata */
        /* JADX INFO: compiled from: DivSlideTransition.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0006R\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div2/DivSlideTransition$Edge$Converter;", "", "()V", "FROM_STRING", "Lkotlin/Function1;", "", "Lcom/yandex/div2/DivSlideTransition$Edge;", "TO_STRING", "fromString", "value", "toString", "obj", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final String toString(Edge obj) {
                Intrinsics.checkNotNullParameter(obj, "obj");
                return obj.value;
            }

            public final Edge fromString(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                if (Intrinsics.areEqual(value, Edge.LEFT.value)) {
                    return Edge.LEFT;
                }
                if (Intrinsics.areEqual(value, Edge.TOP.value)) {
                    return Edge.TOP;
                }
                if (Intrinsics.areEqual(value, Edge.RIGHT.value)) {
                    return Edge.RIGHT;
                }
                if (Intrinsics.areEqual(value, Edge.BOTTOM.value)) {
                    return Edge.BOTTOM;
                }
                return null;
            }
        }
    }
}
