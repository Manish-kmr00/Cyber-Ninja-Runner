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

/* JADX INFO: compiled from: DivDrawable.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0002\u0014\u0015B\u0007\b\u0004¢\u0006\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0001\u0001\u0016¨\u0006\u0017"}, d2 = {"Lcom/yandex/div2/DivDrawable;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "()V", "_hash", "", "Ljava/lang/Integer;", "_propertiesHash", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "propertiesHash", "value", "", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "Shape", "Lcom/yandex/div2/DivDrawable$Shape;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class DivDrawable implements JSONSerializable, Hashable {
    private Integer _hash;
    private Integer _propertiesHash;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function2<ParsingEnvironment, JSONObject, DivDrawable> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivDrawable>() { // from class: com.yandex.div2.DivDrawable$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivDrawable invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivDrawable.INSTANCE.fromJson(env, it);
        }
    };

    public /* synthetic */ DivDrawable(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final DivDrawable fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) throws ParsingException {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    /* JADX INFO: compiled from: DivDrawable.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivDrawable$Shape;", "Lcom/yandex/div2/DivDrawable;", "value", "Lcom/yandex/div2/DivShapeDrawable;", "(Lcom/yandex/div2/DivShapeDrawable;)V", "getValue", "()Lcom/yandex/div2/DivShapeDrawable;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Shape extends DivDrawable {
        private final DivShapeDrawable value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Shape(DivShapeDrawable value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivShapeDrawable getValue() {
            return this.value;
        }
    }

    private DivDrawable() {
    }

    @Override // com.yandex.div.data.Hashable
    public int propertiesHash() {
        Integer num = this._propertiesHash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
        if (!(this instanceof Shape)) {
            throw new NoWhenBranchMatchedException();
        }
        int iPropertiesHash = iHashCode + ((Shape) this).getValue().propertiesHash();
        this._propertiesHash = Integer.valueOf(iPropertiesHash);
        return iPropertiesHash;
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
        if (!(this instanceof Shape)) {
            throw new NoWhenBranchMatchedException();
        }
        int iHash = iHashCode + ((Shape) this).getValue().hash();
        this._hash = Integer.valueOf(iHash);
        return iHash;
    }

    public final boolean equals(DivDrawable other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null) {
            return false;
        }
        if (!(this instanceof Shape)) {
            throw new NoWhenBranchMatchedException();
        }
        DivShapeDrawable value = ((Shape) this).getValue();
        Object objValue = other.value();
        return value.equals(objValue instanceof DivShapeDrawable ? (DivShapeDrawable) objValue : null, resolver, otherResolver);
    }

    public final Object value() {
        if (this instanceof Shape) {
            return ((Shape) this).getValue();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivDrawableJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivDrawable.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\rR#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivDrawable$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivDrawable;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivDrawable fromJson(ParsingEnvironment env, JSONObject json) throws ParsingException {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivDrawableJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivDrawable> getCREATOR() {
            return DivDrawable.CREATOR;
        }
    }
}
