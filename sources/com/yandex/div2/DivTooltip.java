package com.yandex.div2;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.json.b9;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivTooltip.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0002%&B\u0085\u0001\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0007\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016¢\u0006\u0002\u0010\u0018J\u008a\u0001\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00072\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016J \u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 J\b\u0010\"\u001a\u00020\u001aH\u0016J\b\u0010#\u001a\u00020$H\u0016R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/yandex/div2/DivTooltip;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "animationIn", "Lcom/yandex/div2/DivAnimation;", "animationOut", "closeByTapOutside", "Lcom/yandex/div/json/expressions/Expression;", "", "div", "Lcom/yandex/div2/Div;", "duration", "", "id", "", b9.a.t, "Lcom/yandex/div2/DivTooltipMode;", "offset", "Lcom/yandex/div2/DivPoint;", b9.h.L, "Lcom/yandex/div2/DivTooltip$Position;", "tapOutsideActions", "", "Lcom/yandex/div2/DivAction;", "(Lcom/yandex/div2/DivAnimation;Lcom/yandex/div2/DivAnimation;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/Div;Lcom/yandex/div/json/expressions/Expression;Ljava/lang/String;Lcom/yandex/div2/DivTooltipMode;Lcom/yandex/div2/DivPoint;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "Position", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivTooltip implements JSONSerializable, Hashable {
    private Integer _hash;
    public final DivAnimation animationIn;
    public final DivAnimation animationOut;
    public final Expression<Boolean> closeByTapOutside;
    public final Div div;
    public final Expression<Long> duration;
    public final String id;
    public final DivTooltipMode mode;
    public final DivPoint offset;
    public final Expression<Position> position;
    public final List<DivAction> tapOutsideActions;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Expression<Boolean> CLOSE_BY_TAP_OUTSIDE_DEFAULT_VALUE = Expression.INSTANCE.constant(true);
    private static final Expression<Long> DURATION_DEFAULT_VALUE = Expression.INSTANCE.constant(5000L);
    private static final DivTooltipMode.Modal MODE_DEFAULT_VALUE = new DivTooltipMode.Modal(new DivTooltipModeModal());
    private static final Function2<ParsingEnvironment, JSONObject, DivTooltip> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivTooltip>() { // from class: com.yandex.div2.DivTooltip$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivTooltip invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivTooltip.INSTANCE.fromJson(env, it);
        }
    };

    @JvmStatic
    public static final DivTooltip fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivTooltip(DivAnimation divAnimation, DivAnimation divAnimation2, Expression<Boolean> closeByTapOutside, Div div, Expression<Long> duration, String id, DivTooltipMode mode, DivPoint divPoint, Expression<Position> position, List<DivAction> list) {
        Intrinsics.checkNotNullParameter(closeByTapOutside, "closeByTapOutside");
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(position, "position");
        this.animationIn = divAnimation;
        this.animationOut = divAnimation2;
        this.closeByTapOutside = closeByTapOutside;
        this.div = div;
        this.duration = duration;
        this.id = id;
        this.mode = mode;
        this.offset = divPoint;
        this.position = position;
        this.tapOutsideActions = list;
    }

    public /* synthetic */ DivTooltip(DivAnimation divAnimation, DivAnimation divAnimation2, Expression expression, Div div, Expression expression2, String str, DivTooltipMode divTooltipMode, DivPoint divPoint, Expression expression3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : divAnimation, (i & 2) != 0 ? null : divAnimation2, (i & 4) != 0 ? CLOSE_BY_TAP_OUTSIDE_DEFAULT_VALUE : expression, div, (i & 16) != 0 ? DURATION_DEFAULT_VALUE : expression2, str, (i & 64) != 0 ? MODE_DEFAULT_VALUE : divTooltipMode, (i & 128) != 0 ? null : divPoint, expression3, (i & 512) != 0 ? null : list);
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
        DivAnimation divAnimation = this.animationIn;
        int iHash = 0;
        int iHash2 = iHashCode + (divAnimation != null ? divAnimation.hash() : 0);
        DivAnimation divAnimation2 = this.animationOut;
        int iHash3 = iHash2 + (divAnimation2 != null ? divAnimation2.hash() : 0) + this.closeByTapOutside.hashCode() + this.div.hash() + this.duration.hashCode() + this.id.hashCode() + this.mode.hash();
        DivPoint divPoint = this.offset;
        int iHash4 = iHash3 + (divPoint != null ? divPoint.hash() : 0) + this.position.hashCode();
        List<DivAction> list = this.tapOutsideActions;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                iHash += ((DivAction) it.next()).hash();
            }
        }
        int i = iHash4 + iHash;
        this._hash = Integer.valueOf(i);
        return i;
    }

    public final boolean equals(DivTooltip other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        boolean zEquals;
        boolean zEquals2;
        boolean zEquals3;
        boolean z;
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null) {
            return false;
        }
        DivAnimation divAnimation = this.animationIn;
        if (divAnimation != null) {
            zEquals = divAnimation.equals(other.animationIn, resolver, otherResolver);
        } else {
            zEquals = other.animationIn == null;
        }
        if (!zEquals) {
            return false;
        }
        DivAnimation divAnimation2 = this.animationOut;
        if (divAnimation2 != null) {
            zEquals2 = divAnimation2.equals(other.animationOut, resolver, otherResolver);
        } else {
            zEquals2 = other.animationOut == null;
        }
        if (!zEquals2 || this.closeByTapOutside.evaluate(resolver).booleanValue() != other.closeByTapOutside.evaluate(otherResolver).booleanValue() || !this.div.equals(other.div, resolver, otherResolver) || this.duration.evaluate(resolver).longValue() != other.duration.evaluate(otherResolver).longValue() || !Intrinsics.areEqual(this.id, other.id) || !this.mode.equals(other.mode, resolver, otherResolver)) {
            return false;
        }
        DivPoint divPoint = this.offset;
        if (divPoint != null) {
            zEquals3 = divPoint.equals(other.offset, resolver, otherResolver);
        } else {
            zEquals3 = other.offset == null;
        }
        if (!zEquals3 || this.position.evaluate(resolver) != other.position.evaluate(otherResolver)) {
            return false;
        }
        List<DivAction> list = this.tapOutsideActions;
        List<DivAction> list2 = other.tapOutsideActions;
        if (list == null) {
            z = list2 == null;
        } else {
            if (list2 == null) {
                return false;
            }
            if (list.size() == list2.size()) {
                Iterator<T> it = list.iterator();
                int i = 0;
                while (true) {
                    if (it.hasNext()) {
                        Object next = it.next();
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivAction) next).equals(list2.get(i), resolver, otherResolver)) {
                            i = i2;
                        }
                    }
                }
            }
        }
        return z;
    }

    public final DivTooltip copy(DivAnimation animationIn, DivAnimation animationOut, Expression<Boolean> closeByTapOutside, Div div, Expression<Long> duration, String id, DivTooltipMode mode, DivPoint offset, Expression<Position> position, List<DivAction> tapOutsideActions) {
        Intrinsics.checkNotNullParameter(closeByTapOutside, "closeByTapOutside");
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(position, "position");
        return new DivTooltip(animationIn, animationOut, closeByTapOutside, div, duration, id, mode, offset, position, tapOutsideActions);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivTooltipJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivTooltip.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u0014R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/yandex/div2/DivTooltip$Companion;", "", "()V", "CLOSE_BY_TAP_OUTSIDE_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTooltip;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "DURATION_DEFAULT_VALUE", "", "MODE_DEFAULT_VALUE", "Lcom/yandex/div2/DivTooltipMode$Modal;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivTooltip fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivTooltipJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivTooltip> getCREATOR() {
            return DivTooltip.CREATOR;
        }
    }

    /* JADX INFO: compiled from: DivTooltip.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/yandex/div2/DivTooltip$Position;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "LEFT", "TOP_LEFT", "TOP", "TOP_RIGHT", "RIGHT", "BOTTOM_RIGHT", "BOTTOM", "BOTTOM_LEFT", "CENTER", "Converter", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum Position {
        LEFT("left"),
        TOP_LEFT(b9.e.c),
        TOP(ViewHierarchyConstants.DIMENSION_TOP_KEY),
        TOP_RIGHT("top-right"),
        RIGHT("right"),
        BOTTOM_RIGHT(b9.e.d),
        BOTTOM("bottom"),
        BOTTOM_LEFT(b9.e.e),
        CENTER("center");

        private final String value;

        /* JADX INFO: renamed from: Converter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final Function1<Position, String> TO_STRING = new Function1<Position, String>() { // from class: com.yandex.div2.DivTooltip$Position$Converter$TO_STRING$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(DivTooltip.Position value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return DivTooltip.Position.INSTANCE.toString(value);
            }
        };
        public static final Function1<String, Position> FROM_STRING = new Function1<String, Position>() { // from class: com.yandex.div2.DivTooltip$Position$Converter$FROM_STRING$1
            @Override // kotlin.jvm.functions.Function1
            public final DivTooltip.Position invoke(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return DivTooltip.Position.INSTANCE.fromString(value);
            }
        };

        Position(String str) {
            this.value = str;
        }

        /* JADX INFO: renamed from: com.yandex.div2.DivTooltip$Position$Converter, reason: from kotlin metadata */
        /* JADX INFO: compiled from: DivTooltip.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0006R\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div2/DivTooltip$Position$Converter;", "", "()V", "FROM_STRING", "Lkotlin/Function1;", "", "Lcom/yandex/div2/DivTooltip$Position;", "TO_STRING", "fromString", "value", "toString", "obj", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final String toString(Position obj) {
                Intrinsics.checkNotNullParameter(obj, "obj");
                return obj.value;
            }

            public final Position fromString(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                if (Intrinsics.areEqual(value, Position.LEFT.value)) {
                    return Position.LEFT;
                }
                if (Intrinsics.areEqual(value, Position.TOP_LEFT.value)) {
                    return Position.TOP_LEFT;
                }
                if (Intrinsics.areEqual(value, Position.TOP.value)) {
                    return Position.TOP;
                }
                if (Intrinsics.areEqual(value, Position.TOP_RIGHT.value)) {
                    return Position.TOP_RIGHT;
                }
                if (Intrinsics.areEqual(value, Position.RIGHT.value)) {
                    return Position.RIGHT;
                }
                if (Intrinsics.areEqual(value, Position.BOTTOM_RIGHT.value)) {
                    return Position.BOTTOM_RIGHT;
                }
                if (Intrinsics.areEqual(value, Position.BOTTOM.value)) {
                    return Position.BOTTOM;
                }
                if (Intrinsics.areEqual(value, Position.BOTTOM_LEFT.value)) {
                    return Position.BOTTOM_LEFT;
                }
                if (Intrinsics.areEqual(value, Position.CENTER.value)) {
                    return Position.CENTER;
                }
                return null;
            }
        }
    }
}
