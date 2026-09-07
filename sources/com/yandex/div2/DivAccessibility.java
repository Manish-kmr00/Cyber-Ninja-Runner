package com.yandex.div2;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import com.json.b9;
import com.json.cc;
import com.pubmatic.sdk.common.models.POBProfileInfo;
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

/* JADX INFO: compiled from: DivAccessibility.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0003\u001c\u001d\u001eBy\b\u0007\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0004\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJx\u0010\u0013\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00042\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\b\u0002\u0010\r\u001a\u00020\u000eJ \u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017J\b\u0010\u0019\u001a\u00020\u0011H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0018\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/yandex/div2/DivAccessibility;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "description", "Lcom/yandex/div/json/expressions/Expression;", "", ViewHierarchyConstants.HINT_KEY, "isChecked", "", b9.a.t, "Lcom/yandex/div2/DivAccessibility$Mode;", "muteAfterAction", "stateDescription", "type", "Lcom/yandex/div2/DivAccessibility$Type;", "(Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivAccessibility$Type;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "Mode", "Type", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivAccessibility implements JSONSerializable, Hashable {
    private Integer _hash;
    public final Expression<String> description;
    public final Expression<String> hint;
    public final Expression<Boolean> isChecked;
    public final Expression<Mode> mode;
    public final Expression<Boolean> muteAfterAction;
    public final Expression<String> stateDescription;
    public final Type type;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Expression<Mode> MODE_DEFAULT_VALUE = Expression.INSTANCE.constant(Mode.DEFAULT);
    private static final Expression<Boolean> MUTE_AFTER_ACTION_DEFAULT_VALUE = Expression.INSTANCE.constant(false);
    private static final Type TYPE_DEFAULT_VALUE = Type.AUTO;
    private static final Function2<ParsingEnvironment, JSONObject, DivAccessibility> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivAccessibility>() { // from class: com.yandex.div2.DivAccessibility$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivAccessibility invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivAccessibility.INSTANCE.fromJson(env, it);
        }
    };

    public DivAccessibility() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    @JvmStatic
    public static final DivAccessibility fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivAccessibility(Expression<String> expression, Expression<String> expression2, Expression<Boolean> expression3, Expression<Mode> mode, Expression<Boolean> muteAfterAction, Expression<String> expression4, Type type) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(muteAfterAction, "muteAfterAction");
        Intrinsics.checkNotNullParameter(type, "type");
        this.description = expression;
        this.hint = expression2;
        this.isChecked = expression3;
        this.mode = mode;
        this.muteAfterAction = muteAfterAction;
        this.stateDescription = expression4;
        this.type = type;
    }

    public /* synthetic */ DivAccessibility(Expression expression, Expression expression2, Expression expression3, Expression expression4, Expression expression5, Expression expression6, Type type, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : expression, (i & 2) != 0 ? null : expression2, (i & 4) != 0 ? null : expression3, (i & 8) != 0 ? MODE_DEFAULT_VALUE : expression4, (i & 16) != 0 ? MUTE_AFTER_ACTION_DEFAULT_VALUE : expression5, (i & 32) == 0 ? expression6 : null, (i & 64) != 0 ? TYPE_DEFAULT_VALUE : type);
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
        Expression<String> expression = this.description;
        int iHashCode2 = iHashCode + (expression != null ? expression.hashCode() : 0);
        Expression<String> expression2 = this.hint;
        int iHashCode3 = iHashCode2 + (expression2 != null ? expression2.hashCode() : 0);
        Expression<Boolean> expression3 = this.isChecked;
        int iHashCode4 = iHashCode3 + (expression3 != null ? expression3.hashCode() : 0) + this.mode.hashCode() + this.muteAfterAction.hashCode();
        Expression<String> expression4 = this.stateDescription;
        int iHashCode5 = iHashCode4 + (expression4 != null ? expression4.hashCode() : 0) + this.type.hashCode();
        this._hash = Integer.valueOf(iHashCode5);
        return iHashCode5;
    }

    public final boolean equals(DivAccessibility other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null) {
            return false;
        }
        Expression<String> expression = this.description;
        String strEvaluate = expression != null ? expression.evaluate(resolver) : null;
        Expression<String> expression2 = other.description;
        if (!Intrinsics.areEqual(strEvaluate, expression2 != null ? expression2.evaluate(otherResolver) : null)) {
            return false;
        }
        Expression<String> expression3 = this.hint;
        String strEvaluate2 = expression3 != null ? expression3.evaluate(resolver) : null;
        Expression<String> expression4 = other.hint;
        if (!Intrinsics.areEqual(strEvaluate2, expression4 != null ? expression4.evaluate(otherResolver) : null)) {
            return false;
        }
        Expression<Boolean> expression5 = this.isChecked;
        Boolean boolEvaluate = expression5 != null ? expression5.evaluate(resolver) : null;
        Expression<Boolean> expression6 = other.isChecked;
        if (!Intrinsics.areEqual(boolEvaluate, expression6 != null ? expression6.evaluate(otherResolver) : null) || this.mode.evaluate(resolver) != other.mode.evaluate(otherResolver) || this.muteAfterAction.evaluate(resolver).booleanValue() != other.muteAfterAction.evaluate(otherResolver).booleanValue()) {
            return false;
        }
        Expression<String> expression7 = this.stateDescription;
        String strEvaluate3 = expression7 != null ? expression7.evaluate(resolver) : null;
        Expression<String> expression8 = other.stateDescription;
        return Intrinsics.areEqual(strEvaluate3, expression8 != null ? expression8.evaluate(otherResolver) : null) && this.type == other.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivAccessibility copy$default(DivAccessibility divAccessibility, Expression expression, Expression expression2, Expression expression3, Expression expression4, Expression expression5, Expression expression6, Type type, int i, Object obj) {
        if ((i & 1) != 0) {
            expression = divAccessibility.description;
        }
        if ((i & 2) != 0) {
            expression2 = divAccessibility.hint;
        }
        Expression expression7 = expression2;
        if ((i & 4) != 0) {
            expression3 = divAccessibility.isChecked;
        }
        Expression expression8 = expression3;
        if ((i & 8) != 0) {
            expression4 = divAccessibility.mode;
        }
        Expression expression9 = expression4;
        if ((i & 16) != 0) {
            expression5 = divAccessibility.muteAfterAction;
        }
        Expression expression10 = expression5;
        if ((i & 32) != 0) {
            expression6 = divAccessibility.stateDescription;
        }
        Expression expression11 = expression6;
        if ((i & 64) != 0) {
            type = divAccessibility.type;
        }
        return divAccessibility.copy(expression, expression7, expression8, expression9, expression10, expression11, type);
    }

    public final DivAccessibility copy(Expression<String> description, Expression<String> hint, Expression<Boolean> isChecked, Expression<Mode> mode, Expression<Boolean> muteAfterAction, Expression<String> stateDescription, Type type) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(muteAfterAction, "muteAfterAction");
        Intrinsics.checkNotNullParameter(type, "type");
        return new DivAccessibility(description, hint, isChecked, mode, muteAfterAction, stateDescription, type);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivAccessibilityJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivAccessibility.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u0014R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/yandex/div2/DivAccessibility$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivAccessibility;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "MODE_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivAccessibility$Mode;", "MUTE_AFTER_ACTION_DEFAULT_VALUE", "", "TYPE_DEFAULT_VALUE", "Lcom/yandex/div2/DivAccessibility$Type;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivAccessibility fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivAccessibilityJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivAccessibility> getCREATOR() {
            return DivAccessibility.CREATOR;
        }
    }

    /* JADX INFO: compiled from: DivAccessibility.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/yandex/div2/DivAccessibility$Type;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "NONE", "BUTTON", ShareConstants.IMAGE_URL, "TEXT", "EDIT_TEXT", "HEADER", "TAB_BAR", "LIST", "SELECT", "CHECKBOX", "RADIO", "AUTO", "Converter", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum Type {
        NONE("none"),
        BUTTON("button"),
        IMAGE("image"),
        TEXT("text"),
        EDIT_TEXT("edit_text"),
        HEADER("header"),
        TAB_BAR("tab_bar"),
        LIST("list"),
        SELECT("select"),
        CHECKBOX("checkbox"),
        RADIO("radio"),
        AUTO("auto");

        private final String value;

        /* JADX INFO: renamed from: Converter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final Function1<Type, String> TO_STRING = new Function1<Type, String>() { // from class: com.yandex.div2.DivAccessibility$Type$Converter$TO_STRING$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(DivAccessibility.Type value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return DivAccessibility.Type.INSTANCE.toString(value);
            }
        };
        public static final Function1<String, Type> FROM_STRING = new Function1<String, Type>() { // from class: com.yandex.div2.DivAccessibility$Type$Converter$FROM_STRING$1
            @Override // kotlin.jvm.functions.Function1
            public final DivAccessibility.Type invoke(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return DivAccessibility.Type.INSTANCE.fromString(value);
            }
        };

        Type(String str) {
            this.value = str;
        }

        /* JADX INFO: renamed from: com.yandex.div2.DivAccessibility$Type$Converter, reason: from kotlin metadata */
        /* JADX INFO: compiled from: DivAccessibility.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0006R\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div2/DivAccessibility$Type$Converter;", "", "()V", "FROM_STRING", "Lkotlin/Function1;", "", "Lcom/yandex/div2/DivAccessibility$Type;", "TO_STRING", "fromString", "value", "toString", "obj", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final String toString(Type obj) {
                Intrinsics.checkNotNullParameter(obj, "obj");
                return obj.value;
            }

            public final Type fromString(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                if (Intrinsics.areEqual(value, Type.NONE.value)) {
                    return Type.NONE;
                }
                if (Intrinsics.areEqual(value, Type.BUTTON.value)) {
                    return Type.BUTTON;
                }
                if (Intrinsics.areEqual(value, Type.IMAGE.value)) {
                    return Type.IMAGE;
                }
                if (Intrinsics.areEqual(value, Type.TEXT.value)) {
                    return Type.TEXT;
                }
                if (Intrinsics.areEqual(value, Type.EDIT_TEXT.value)) {
                    return Type.EDIT_TEXT;
                }
                if (Intrinsics.areEqual(value, Type.HEADER.value)) {
                    return Type.HEADER;
                }
                if (Intrinsics.areEqual(value, Type.TAB_BAR.value)) {
                    return Type.TAB_BAR;
                }
                if (Intrinsics.areEqual(value, Type.LIST.value)) {
                    return Type.LIST;
                }
                if (Intrinsics.areEqual(value, Type.SELECT.value)) {
                    return Type.SELECT;
                }
                if (Intrinsics.areEqual(value, Type.CHECKBOX.value)) {
                    return Type.CHECKBOX;
                }
                if (Intrinsics.areEqual(value, Type.RADIO.value)) {
                    return Type.RADIO;
                }
                if (Intrinsics.areEqual(value, Type.AUTO.value)) {
                    return Type.AUTO;
                }
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: DivAccessibility.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivAccessibility$Mode;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "DEFAULT", "MERGE", "EXCLUDE", "Converter", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum Mode {
        DEFAULT("default"),
        MERGE("merge"),
        EXCLUDE(POBProfileInfo.COUNTRY_FILTERING_BLOCK_MODE);

        private final String value;

        /* JADX INFO: renamed from: Converter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final Function1<Mode, String> TO_STRING = new Function1<Mode, String>() { // from class: com.yandex.div2.DivAccessibility$Mode$Converter$TO_STRING$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(DivAccessibility.Mode value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return DivAccessibility.Mode.INSTANCE.toString(value);
            }
        };
        public static final Function1<String, Mode> FROM_STRING = new Function1<String, Mode>() { // from class: com.yandex.div2.DivAccessibility$Mode$Converter$FROM_STRING$1
            @Override // kotlin.jvm.functions.Function1
            public final DivAccessibility.Mode invoke(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return DivAccessibility.Mode.INSTANCE.fromString(value);
            }
        };

        Mode(String str) {
            this.value = str;
        }

        /* JADX INFO: renamed from: com.yandex.div2.DivAccessibility$Mode$Converter, reason: from kotlin metadata */
        /* JADX INFO: compiled from: DivAccessibility.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0006R\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div2/DivAccessibility$Mode$Converter;", "", "()V", "FROM_STRING", "Lkotlin/Function1;", "", "Lcom/yandex/div2/DivAccessibility$Mode;", "TO_STRING", "fromString", "value", "toString", "obj", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final String toString(Mode obj) {
                Intrinsics.checkNotNullParameter(obj, "obj");
                return obj.value;
            }

            public final Mode fromString(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                if (Intrinsics.areEqual(value, Mode.DEFAULT.value)) {
                    return Mode.DEFAULT;
                }
                if (Intrinsics.areEqual(value, Mode.MERGE.value)) {
                    return Mode.MERGE;
                }
                if (Intrinsics.areEqual(value, Mode.EXCLUDE.value)) {
                    return Mode.EXCLUDE;
                }
                return null;
            }
        }
    }
}
