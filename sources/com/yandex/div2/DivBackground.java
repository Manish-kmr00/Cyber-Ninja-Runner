package com.yandex.div2;

import com.json.cc;
import com.yandex.div.data.Hashable;
import com.yandex.div.json.JSONSerializable;
import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.ParsingException;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.serialization.BuiltInParserKt;
import com.yandex.div.serialization.ParsingContext;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivBackground.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0006\u0014\u0015\u0016\u0017\u0018\u0019B\u0007\b\u0004¢\u0006\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0001\u0005\u001a\u001b\u001c\u001d\u001e¨\u0006\u001f"}, d2 = {"Lcom/yandex/div2/DivBackground;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "()V", "_hash", "", "Ljava/lang/Integer;", "_propertiesHash", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "propertiesHash", "value", "", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "Image", "LinearGradient", "NinePatch", "RadialGradient", "Solid", "Lcom/yandex/div2/DivBackground$Image;", "Lcom/yandex/div2/DivBackground$LinearGradient;", "Lcom/yandex/div2/DivBackground$NinePatch;", "Lcom/yandex/div2/DivBackground$RadialGradient;", "Lcom/yandex/div2/DivBackground$Solid;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class DivBackground implements JSONSerializable, Hashable {
    private Integer _hash;
    private Integer _propertiesHash;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function2<ParsingEnvironment, JSONObject, DivBackground> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivBackground>() { // from class: com.yandex.div2.DivBackground$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivBackground invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivBackground.INSTANCE.fromJson(env, it);
        }
    };

    public /* synthetic */ DivBackground(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final DivBackground fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) throws ParsingException {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    /* JADX INFO: compiled from: DivBackground.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivBackground$LinearGradient;", "Lcom/yandex/div2/DivBackground;", "value", "Lcom/yandex/div2/DivLinearGradient;", "(Lcom/yandex/div2/DivLinearGradient;)V", "getValue", "()Lcom/yandex/div2/DivLinearGradient;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class LinearGradient extends DivBackground {
        private final DivLinearGradient value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LinearGradient(DivLinearGradient value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivLinearGradient getValue() {
            return this.value;
        }
    }

    private DivBackground() {
    }

    /* JADX INFO: compiled from: DivBackground.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivBackground$RadialGradient;", "Lcom/yandex/div2/DivBackground;", "value", "Lcom/yandex/div2/DivRadialGradient;", "(Lcom/yandex/div2/DivRadialGradient;)V", "getValue", "()Lcom/yandex/div2/DivRadialGradient;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class RadialGradient extends DivBackground {
        private final DivRadialGradient value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RadialGradient(DivRadialGradient value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivRadialGradient getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivBackground.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivBackground$Image;", "Lcom/yandex/div2/DivBackground;", "value", "Lcom/yandex/div2/DivImageBackground;", "(Lcom/yandex/div2/DivImageBackground;)V", "getValue", "()Lcom/yandex/div2/DivImageBackground;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Image extends DivBackground {
        private final DivImageBackground value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Image(DivImageBackground value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivImageBackground getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivBackground.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivBackground$Solid;", "Lcom/yandex/div2/DivBackground;", "value", "Lcom/yandex/div2/DivSolidBackground;", "(Lcom/yandex/div2/DivSolidBackground;)V", "getValue", "()Lcom/yandex/div2/DivSolidBackground;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Solid extends DivBackground {
        private final DivSolidBackground value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Solid(DivSolidBackground value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivSolidBackground getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivBackground.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivBackground$NinePatch;", "Lcom/yandex/div2/DivBackground;", "value", "Lcom/yandex/div2/DivNinePatchBackground;", "(Lcom/yandex/div2/DivNinePatchBackground;)V", "getValue", "()Lcom/yandex/div2/DivNinePatchBackground;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class NinePatch extends DivBackground {
        private final DivNinePatchBackground value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NinePatch(DivNinePatchBackground value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivNinePatchBackground getValue() {
            return this.value;
        }
    }

    @Override // com.yandex.div.data.Hashable
    public int propertiesHash() {
        int iPropertiesHash;
        Integer num = this._propertiesHash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
        if (this instanceof LinearGradient) {
            iPropertiesHash = ((LinearGradient) this).getValue().propertiesHash();
        } else if (this instanceof RadialGradient) {
            iPropertiesHash = ((RadialGradient) this).getValue().propertiesHash();
        } else if (this instanceof Image) {
            iPropertiesHash = ((Image) this).getValue().propertiesHash();
        } else if (this instanceof Solid) {
            iPropertiesHash = ((Solid) this).getValue().propertiesHash();
        } else {
            if (!(this instanceof NinePatch)) {
                throw new NoWhenBranchMatchedException();
            }
            iPropertiesHash = ((NinePatch) this).getValue().propertiesHash();
        }
        int i = iHashCode + iPropertiesHash;
        this._propertiesHash = Integer.valueOf(i);
        return i;
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        int iHash;
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
        if (this instanceof LinearGradient) {
            iHash = ((LinearGradient) this).getValue().hash();
        } else if (this instanceof RadialGradient) {
            iHash = ((RadialGradient) this).getValue().hash();
        } else if (this instanceof Image) {
            iHash = ((Image) this).getValue().hash();
        } else if (this instanceof Solid) {
            iHash = ((Solid) this).getValue().hash();
        } else {
            if (!(this instanceof NinePatch)) {
                throw new NoWhenBranchMatchedException();
            }
            iHash = ((NinePatch) this).getValue().hash();
        }
        int i = iHashCode + iHash;
        this._hash = Integer.valueOf(i);
        return i;
    }

    public final boolean equals(DivBackground other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null) {
            return false;
        }
        if (this instanceof LinearGradient) {
            DivLinearGradient value = ((LinearGradient) this).getValue();
            Object objValue = other.value();
            return value.equals(objValue instanceof DivLinearGradient ? (DivLinearGradient) objValue : null, resolver, otherResolver);
        }
        if (this instanceof RadialGradient) {
            DivRadialGradient value2 = ((RadialGradient) this).getValue();
            Object objValue2 = other.value();
            return value2.equals(objValue2 instanceof DivRadialGradient ? (DivRadialGradient) objValue2 : null, resolver, otherResolver);
        }
        if (this instanceof Image) {
            DivImageBackground value3 = ((Image) this).getValue();
            Object objValue3 = other.value();
            return value3.equals(objValue3 instanceof DivImageBackground ? (DivImageBackground) objValue3 : null, resolver, otherResolver);
        }
        if (this instanceof Solid) {
            DivSolidBackground value4 = ((Solid) this).getValue();
            Object objValue4 = other.value();
            return value4.equals(objValue4 instanceof DivSolidBackground ? (DivSolidBackground) objValue4 : null, resolver, otherResolver);
        }
        if (!(this instanceof NinePatch)) {
            throw new NoWhenBranchMatchedException();
        }
        DivNinePatchBackground value5 = ((NinePatch) this).getValue();
        Object objValue5 = other.value();
        return value5.equals(objValue5 instanceof DivNinePatchBackground ? (DivNinePatchBackground) objValue5 : null, resolver, otherResolver);
    }

    public final Object value() {
        if (this instanceof LinearGradient) {
            return ((LinearGradient) this).getValue();
        }
        if (this instanceof RadialGradient) {
            return ((RadialGradient) this).getValue();
        }
        if (this instanceof Image) {
            return ((Image) this).getValue();
        }
        if (this instanceof Solid) {
            return ((Solid) this).getValue();
        }
        if (this instanceof NinePatch) {
            return ((NinePatch) this).getValue();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivBackgroundJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivBackground.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\rR#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivBackground$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivBackground;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivBackground fromJson(ParsingEnvironment env, JSONObject json) throws ParsingException {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivBackgroundJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivBackground> getCREATOR() {
            return DivBackground.CREATOR;
        }
    }
}
