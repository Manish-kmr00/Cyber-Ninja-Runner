package com.yandex.div2;

import com.google.android.exoplayer2.source.rtsp.RtspHeaders;
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

/* JADX INFO: compiled from: DivAppearanceTransition.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0005\u0014\u0015\u0016\u0017\u0018B\u0007\b\u0004¢\u0006\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0001\u0004\u0019\u001a\u001b\u001c¨\u0006\u001d"}, d2 = {"Lcom/yandex/div2/DivAppearanceTransition;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "()V", "_hash", "", "Ljava/lang/Integer;", "_propertiesHash", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "propertiesHash", "value", "", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "Fade", RtspHeaders.SCALE, "Set", "Slide", "Lcom/yandex/div2/DivAppearanceTransition$Fade;", "Lcom/yandex/div2/DivAppearanceTransition$Scale;", "Lcom/yandex/div2/DivAppearanceTransition$Set;", "Lcom/yandex/div2/DivAppearanceTransition$Slide;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class DivAppearanceTransition implements JSONSerializable, Hashable {
    private Integer _hash;
    private Integer _propertiesHash;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function2<ParsingEnvironment, JSONObject, DivAppearanceTransition> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivAppearanceTransition>() { // from class: com.yandex.div2.DivAppearanceTransition$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivAppearanceTransition invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivAppearanceTransition.INSTANCE.fromJson(env, it);
        }
    };

    public /* synthetic */ DivAppearanceTransition(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final DivAppearanceTransition fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) throws ParsingException {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    /* JADX INFO: compiled from: DivAppearanceTransition.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivAppearanceTransition$Set;", "Lcom/yandex/div2/DivAppearanceTransition;", "value", "Lcom/yandex/div2/DivAppearanceSetTransition;", "(Lcom/yandex/div2/DivAppearanceSetTransition;)V", "getValue", "()Lcom/yandex/div2/DivAppearanceSetTransition;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Set extends DivAppearanceTransition {
        private final DivAppearanceSetTransition value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Set(DivAppearanceSetTransition value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivAppearanceSetTransition getValue() {
            return this.value;
        }
    }

    private DivAppearanceTransition() {
    }

    /* JADX INFO: compiled from: DivAppearanceTransition.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivAppearanceTransition$Fade;", "Lcom/yandex/div2/DivAppearanceTransition;", "value", "Lcom/yandex/div2/DivFadeTransition;", "(Lcom/yandex/div2/DivFadeTransition;)V", "getValue", "()Lcom/yandex/div2/DivFadeTransition;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Fade extends DivAppearanceTransition {
        private final DivFadeTransition value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Fade(DivFadeTransition value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivFadeTransition getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivAppearanceTransition.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivAppearanceTransition$Scale;", "Lcom/yandex/div2/DivAppearanceTransition;", "value", "Lcom/yandex/div2/DivScaleTransition;", "(Lcom/yandex/div2/DivScaleTransition;)V", "getValue", "()Lcom/yandex/div2/DivScaleTransition;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Scale extends DivAppearanceTransition {
        private final DivScaleTransition value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Scale(DivScaleTransition value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivScaleTransition getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivAppearanceTransition.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivAppearanceTransition$Slide;", "Lcom/yandex/div2/DivAppearanceTransition;", "value", "Lcom/yandex/div2/DivSlideTransition;", "(Lcom/yandex/div2/DivSlideTransition;)V", "getValue", "()Lcom/yandex/div2/DivSlideTransition;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Slide extends DivAppearanceTransition {
        private final DivSlideTransition value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Slide(DivSlideTransition value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivSlideTransition getValue() {
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
        if (this instanceof Set) {
            iPropertiesHash = ((Set) this).getValue().propertiesHash();
        } else if (this instanceof Fade) {
            iPropertiesHash = ((Fade) this).getValue().propertiesHash();
        } else if (this instanceof Scale) {
            iPropertiesHash = ((Scale) this).getValue().propertiesHash();
        } else {
            if (!(this instanceof Slide)) {
                throw new NoWhenBranchMatchedException();
            }
            iPropertiesHash = ((Slide) this).getValue().propertiesHash();
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
        if (this instanceof Set) {
            iHash = ((Set) this).getValue().hash();
        } else if (this instanceof Fade) {
            iHash = ((Fade) this).getValue().hash();
        } else if (this instanceof Scale) {
            iHash = ((Scale) this).getValue().hash();
        } else {
            if (!(this instanceof Slide)) {
                throw new NoWhenBranchMatchedException();
            }
            iHash = ((Slide) this).getValue().hash();
        }
        int i = iHashCode + iHash;
        this._hash = Integer.valueOf(i);
        return i;
    }

    public final boolean equals(DivAppearanceTransition other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null) {
            return false;
        }
        if (this instanceof Set) {
            DivAppearanceSetTransition value = ((Set) this).getValue();
            Object objValue = other.value();
            return value.equals(objValue instanceof DivAppearanceSetTransition ? (DivAppearanceSetTransition) objValue : null, resolver, otherResolver);
        }
        if (this instanceof Fade) {
            DivFadeTransition value2 = ((Fade) this).getValue();
            Object objValue2 = other.value();
            return value2.equals(objValue2 instanceof DivFadeTransition ? (DivFadeTransition) objValue2 : null, resolver, otherResolver);
        }
        if (this instanceof Scale) {
            DivScaleTransition value3 = ((Scale) this).getValue();
            Object objValue3 = other.value();
            return value3.equals(objValue3 instanceof DivScaleTransition ? (DivScaleTransition) objValue3 : null, resolver, otherResolver);
        }
        if (!(this instanceof Slide)) {
            throw new NoWhenBranchMatchedException();
        }
        DivSlideTransition value4 = ((Slide) this).getValue();
        Object objValue4 = other.value();
        return value4.equals(objValue4 instanceof DivSlideTransition ? (DivSlideTransition) objValue4 : null, resolver, otherResolver);
    }

    public final Object value() {
        if (this instanceof Set) {
            return ((Set) this).getValue();
        }
        if (this instanceof Fade) {
            return ((Fade) this).getValue();
        }
        if (this instanceof Scale) {
            return ((Scale) this).getValue();
        }
        if (this instanceof Slide) {
            return ((Slide) this).getValue();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivAppearanceTransitionJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivAppearanceTransition.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\rR#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivAppearanceTransition$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivAppearanceTransition;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivAppearanceTransition fromJson(ParsingEnvironment env, JSONObject json) throws ParsingException {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivAppearanceTransitionJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivAppearanceTransition> getCREATOR() {
            return DivAppearanceTransition.CREATOR;
        }
    }
}
