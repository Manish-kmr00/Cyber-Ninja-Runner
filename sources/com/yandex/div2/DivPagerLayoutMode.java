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

/* JADX INFO: compiled from: DivPagerLayoutMode.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0004\u0014\u0015\u0016\u0017B\u0007\b\u0004¢\u0006\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0001\u0003\u0018\u0019\u001a¨\u0006\u001b"}, d2 = {"Lcom/yandex/div2/DivPagerLayoutMode;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "()V", "_hash", "", "Ljava/lang/Integer;", "_propertiesHash", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "propertiesHash", "value", "", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "NeighbourPageSize", "PageContentSize", "PageSize", "Lcom/yandex/div2/DivPagerLayoutMode$NeighbourPageSize;", "Lcom/yandex/div2/DivPagerLayoutMode$PageContentSize;", "Lcom/yandex/div2/DivPagerLayoutMode$PageSize;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class DivPagerLayoutMode implements JSONSerializable, Hashable {
    private Integer _hash;
    private Integer _propertiesHash;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function2<ParsingEnvironment, JSONObject, DivPagerLayoutMode> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivPagerLayoutMode>() { // from class: com.yandex.div2.DivPagerLayoutMode$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivPagerLayoutMode invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivPagerLayoutMode.INSTANCE.fromJson(env, it);
        }
    };

    public /* synthetic */ DivPagerLayoutMode(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final DivPagerLayoutMode fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) throws ParsingException {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    /* JADX INFO: compiled from: DivPagerLayoutMode.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivPagerLayoutMode$PageSize;", "Lcom/yandex/div2/DivPagerLayoutMode;", "value", "Lcom/yandex/div2/DivPageSize;", "(Lcom/yandex/div2/DivPageSize;)V", "getValue", "()Lcom/yandex/div2/DivPageSize;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class PageSize extends DivPagerLayoutMode {
        private final DivPageSize value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PageSize(DivPageSize value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivPageSize getValue() {
            return this.value;
        }
    }

    private DivPagerLayoutMode() {
    }

    /* JADX INFO: compiled from: DivPagerLayoutMode.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivPagerLayoutMode$NeighbourPageSize;", "Lcom/yandex/div2/DivPagerLayoutMode;", "value", "Lcom/yandex/div2/DivNeighbourPageSize;", "(Lcom/yandex/div2/DivNeighbourPageSize;)V", "getValue", "()Lcom/yandex/div2/DivNeighbourPageSize;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class NeighbourPageSize extends DivPagerLayoutMode {
        private final DivNeighbourPageSize value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NeighbourPageSize(DivNeighbourPageSize value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivNeighbourPageSize getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivPagerLayoutMode.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivPagerLayoutMode$PageContentSize;", "Lcom/yandex/div2/DivPagerLayoutMode;", "value", "Lcom/yandex/div2/DivPageContentSize;", "(Lcom/yandex/div2/DivPageContentSize;)V", "getValue", "()Lcom/yandex/div2/DivPageContentSize;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class PageContentSize extends DivPagerLayoutMode {
        private final DivPageContentSize value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PageContentSize(DivPageContentSize value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivPageContentSize getValue() {
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
        if (this instanceof PageSize) {
            iPropertiesHash = ((PageSize) this).getValue().propertiesHash();
        } else if (this instanceof NeighbourPageSize) {
            iPropertiesHash = ((NeighbourPageSize) this).getValue().propertiesHash();
        } else {
            if (!(this instanceof PageContentSize)) {
                throw new NoWhenBranchMatchedException();
            }
            iPropertiesHash = ((PageContentSize) this).getValue().propertiesHash();
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
        if (this instanceof PageSize) {
            iHash = ((PageSize) this).getValue().hash();
        } else if (this instanceof NeighbourPageSize) {
            iHash = ((NeighbourPageSize) this).getValue().hash();
        } else {
            if (!(this instanceof PageContentSize)) {
                throw new NoWhenBranchMatchedException();
            }
            iHash = ((PageContentSize) this).getValue().hash();
        }
        int i = iHashCode + iHash;
        this._hash = Integer.valueOf(i);
        return i;
    }

    public final boolean equals(DivPagerLayoutMode other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null) {
            return false;
        }
        if (this instanceof PageSize) {
            DivPageSize value = ((PageSize) this).getValue();
            Object objValue = other.value();
            return value.equals(objValue instanceof DivPageSize ? (DivPageSize) objValue : null, resolver, otherResolver);
        }
        if (this instanceof NeighbourPageSize) {
            DivNeighbourPageSize value2 = ((NeighbourPageSize) this).getValue();
            Object objValue2 = other.value();
            return value2.equals(objValue2 instanceof DivNeighbourPageSize ? (DivNeighbourPageSize) objValue2 : null, resolver, otherResolver);
        }
        if (!(this instanceof PageContentSize)) {
            throw new NoWhenBranchMatchedException();
        }
        DivPageContentSize value3 = ((PageContentSize) this).getValue();
        Object objValue3 = other.value();
        return value3.equals(objValue3 instanceof DivPageContentSize ? (DivPageContentSize) objValue3 : null, resolver, otherResolver);
    }

    public final Object value() {
        if (this instanceof PageSize) {
            return ((PageSize) this).getValue();
        }
        if (this instanceof NeighbourPageSize) {
            return ((NeighbourPageSize) this).getValue();
        }
        if (this instanceof PageContentSize) {
            return ((PageContentSize) this).getValue();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivPagerLayoutModeJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivPagerLayoutMode.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\rR#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivPagerLayoutMode$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivPagerLayoutMode;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivPagerLayoutMode fromJson(ParsingEnvironment env, JSONObject json) throws ParsingException {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivPagerLayoutModeJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivPagerLayoutMode> getCREATOR() {
            return DivPagerLayoutMode.CREATOR;
        }
    }
}
