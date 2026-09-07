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

/* JADX INFO: compiled from: DivActionScrollDestination.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0005\u0014\u0015\u0016\u0017\u0018B\u0007\b\u0004¢\u0006\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0001\u0004\u0019\u001a\u001b\u001c¨\u0006\u001d"}, d2 = {"Lcom/yandex/div2/DivActionScrollDestination;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "()V", "_hash", "", "Ljava/lang/Integer;", "_propertiesHash", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "propertiesHash", "value", "", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "End", "Index", "Offset", "Start", "Lcom/yandex/div2/DivActionScrollDestination$End;", "Lcom/yandex/div2/DivActionScrollDestination$Index;", "Lcom/yandex/div2/DivActionScrollDestination$Offset;", "Lcom/yandex/div2/DivActionScrollDestination$Start;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class DivActionScrollDestination implements JSONSerializable, Hashable {
    private Integer _hash;
    private Integer _propertiesHash;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function2<ParsingEnvironment, JSONObject, DivActionScrollDestination> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivActionScrollDestination>() { // from class: com.yandex.div2.DivActionScrollDestination$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivActionScrollDestination invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivActionScrollDestination.INSTANCE.fromJson(env, it);
        }
    };

    public /* synthetic */ DivActionScrollDestination(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final DivActionScrollDestination fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) throws ParsingException {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    /* JADX INFO: compiled from: DivActionScrollDestination.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionScrollDestination$Offset;", "Lcom/yandex/div2/DivActionScrollDestination;", "value", "Lcom/yandex/div2/OffsetDestination;", "(Lcom/yandex/div2/OffsetDestination;)V", "getValue", "()Lcom/yandex/div2/OffsetDestination;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Offset extends DivActionScrollDestination {
        private final OffsetDestination value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Offset(OffsetDestination value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final OffsetDestination getValue() {
            return this.value;
        }
    }

    private DivActionScrollDestination() {
    }

    /* JADX INFO: compiled from: DivActionScrollDestination.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionScrollDestination$Index;", "Lcom/yandex/div2/DivActionScrollDestination;", "value", "Lcom/yandex/div2/IndexDestination;", "(Lcom/yandex/div2/IndexDestination;)V", "getValue", "()Lcom/yandex/div2/IndexDestination;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Index extends DivActionScrollDestination {
        private final IndexDestination value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Index(IndexDestination value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final IndexDestination getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionScrollDestination.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionScrollDestination$Start;", "Lcom/yandex/div2/DivActionScrollDestination;", "value", "Lcom/yandex/div2/StartDestination;", "(Lcom/yandex/div2/StartDestination;)V", "getValue", "()Lcom/yandex/div2/StartDestination;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Start extends DivActionScrollDestination {
        private final StartDestination value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Start(StartDestination value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final StartDestination getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionScrollDestination.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionScrollDestination$End;", "Lcom/yandex/div2/DivActionScrollDestination;", "value", "Lcom/yandex/div2/EndDestination;", "(Lcom/yandex/div2/EndDestination;)V", "getValue", "()Lcom/yandex/div2/EndDestination;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class End extends DivActionScrollDestination {
        private final EndDestination value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public End(EndDestination value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final EndDestination getValue() {
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
        if (this instanceof Offset) {
            iPropertiesHash = ((Offset) this).getValue().propertiesHash();
        } else if (this instanceof Index) {
            iPropertiesHash = ((Index) this).getValue().propertiesHash();
        } else if (this instanceof Start) {
            iPropertiesHash = ((Start) this).getValue().propertiesHash();
        } else {
            if (!(this instanceof End)) {
                throw new NoWhenBranchMatchedException();
            }
            iPropertiesHash = ((End) this).getValue().propertiesHash();
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
        if (this instanceof Offset) {
            iHash = ((Offset) this).getValue().hash();
        } else if (this instanceof Index) {
            iHash = ((Index) this).getValue().hash();
        } else if (this instanceof Start) {
            iHash = ((Start) this).getValue().hash();
        } else {
            if (!(this instanceof End)) {
                throw new NoWhenBranchMatchedException();
            }
            iHash = ((End) this).getValue().hash();
        }
        int i = iHashCode + iHash;
        this._hash = Integer.valueOf(i);
        return i;
    }

    public final boolean equals(DivActionScrollDestination other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null) {
            return false;
        }
        if (this instanceof Offset) {
            OffsetDestination value = ((Offset) this).getValue();
            Object objValue = other.value();
            return value.equals(objValue instanceof OffsetDestination ? (OffsetDestination) objValue : null, resolver, otherResolver);
        }
        if (this instanceof Index) {
            IndexDestination value2 = ((Index) this).getValue();
            Object objValue2 = other.value();
            return value2.equals(objValue2 instanceof IndexDestination ? (IndexDestination) objValue2 : null, resolver, otherResolver);
        }
        if (this instanceof Start) {
            StartDestination value3 = ((Start) this).getValue();
            Object objValue3 = other.value();
            return value3.equals(objValue3 instanceof StartDestination ? (StartDestination) objValue3 : null, resolver, otherResolver);
        }
        if (!(this instanceof End)) {
            throw new NoWhenBranchMatchedException();
        }
        EndDestination value4 = ((End) this).getValue();
        Object objValue4 = other.value();
        return value4.equals(objValue4 instanceof EndDestination ? (EndDestination) objValue4 : null, resolver, otherResolver);
    }

    public final Object value() {
        if (this instanceof Offset) {
            return ((Offset) this).getValue();
        }
        if (this instanceof Index) {
            return ((Index) this).getValue();
        }
        if (this instanceof Start) {
            return ((Start) this).getValue();
        }
        if (this instanceof End) {
            return ((End) this).getValue();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivActionScrollDestinationJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivActionScrollDestination.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\rR#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivActionScrollDestination$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivActionScrollDestination;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivActionScrollDestination fromJson(ParsingEnvironment env, JSONObject json) throws ParsingException {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivActionScrollDestinationJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivActionScrollDestination> getCREATOR() {
            return DivActionScrollDestination.CREATOR;
        }
    }
}
