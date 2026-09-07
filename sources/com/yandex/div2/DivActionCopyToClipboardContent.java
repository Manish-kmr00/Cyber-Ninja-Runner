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

/* JADX INFO: compiled from: DivActionCopyToClipboardContent.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0003\u0014\u0015\u0016B\u0007\b\u0004¢\u0006\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0001\u0002\u0017\u0018¨\u0006\u0019"}, d2 = {"Lcom/yandex/div2/DivActionCopyToClipboardContent;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "()V", "_hash", "", "Ljava/lang/Integer;", "_propertiesHash", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "propertiesHash", "value", "", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "ContentTextCase", "ContentUrlCase", "Lcom/yandex/div2/DivActionCopyToClipboardContent$ContentTextCase;", "Lcom/yandex/div2/DivActionCopyToClipboardContent$ContentUrlCase;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class DivActionCopyToClipboardContent implements JSONSerializable, Hashable {
    private Integer _hash;
    private Integer _propertiesHash;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function2<ParsingEnvironment, JSONObject, DivActionCopyToClipboardContent> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivActionCopyToClipboardContent>() { // from class: com.yandex.div2.DivActionCopyToClipboardContent$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivActionCopyToClipboardContent invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivActionCopyToClipboardContent.INSTANCE.fromJson(env, it);
        }
    };

    public /* synthetic */ DivActionCopyToClipboardContent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final DivActionCopyToClipboardContent fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) throws ParsingException {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    /* JADX INFO: compiled from: DivActionCopyToClipboardContent.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionCopyToClipboardContent$ContentTextCase;", "Lcom/yandex/div2/DivActionCopyToClipboardContent;", "value", "Lcom/yandex/div2/ContentText;", "(Lcom/yandex/div2/ContentText;)V", "getValue", "()Lcom/yandex/div2/ContentText;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ContentTextCase extends DivActionCopyToClipboardContent {
        private final ContentText value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ContentTextCase(ContentText value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final ContentText getValue() {
            return this.value;
        }
    }

    private DivActionCopyToClipboardContent() {
    }

    /* JADX INFO: compiled from: DivActionCopyToClipboardContent.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionCopyToClipboardContent$ContentUrlCase;", "Lcom/yandex/div2/DivActionCopyToClipboardContent;", "value", "Lcom/yandex/div2/ContentUrl;", "(Lcom/yandex/div2/ContentUrl;)V", "getValue", "()Lcom/yandex/div2/ContentUrl;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ContentUrlCase extends DivActionCopyToClipboardContent {
        private final ContentUrl value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ContentUrlCase(ContentUrl value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final ContentUrl getValue() {
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
        if (this instanceof ContentTextCase) {
            iPropertiesHash = ((ContentTextCase) this).getValue().propertiesHash();
        } else {
            if (!(this instanceof ContentUrlCase)) {
                throw new NoWhenBranchMatchedException();
            }
            iPropertiesHash = ((ContentUrlCase) this).getValue().propertiesHash();
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
        if (this instanceof ContentTextCase) {
            iHash = ((ContentTextCase) this).getValue().hash();
        } else {
            if (!(this instanceof ContentUrlCase)) {
                throw new NoWhenBranchMatchedException();
            }
            iHash = ((ContentUrlCase) this).getValue().hash();
        }
        int i = iHashCode + iHash;
        this._hash = Integer.valueOf(i);
        return i;
    }

    public final boolean equals(DivActionCopyToClipboardContent other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null) {
            return false;
        }
        if (this instanceof ContentTextCase) {
            ContentText value = ((ContentTextCase) this).getValue();
            Object objValue = other.value();
            return value.equals(objValue instanceof ContentText ? (ContentText) objValue : null, resolver, otherResolver);
        }
        if (!(this instanceof ContentUrlCase)) {
            throw new NoWhenBranchMatchedException();
        }
        ContentUrl value2 = ((ContentUrlCase) this).getValue();
        Object objValue2 = other.value();
        return value2.equals(objValue2 instanceof ContentUrl ? (ContentUrl) objValue2 : null, resolver, otherResolver);
    }

    public final Object value() {
        if (this instanceof ContentTextCase) {
            return ((ContentTextCase) this).getValue();
        }
        if (this instanceof ContentUrlCase) {
            return ((ContentUrlCase) this).getValue();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivActionCopyToClipboardContentJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivActionCopyToClipboardContent.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\rR#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivActionCopyToClipboardContent$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivActionCopyToClipboardContent;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivActionCopyToClipboardContent fromJson(ParsingEnvironment env, JSONObject json) throws ParsingException {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivActionCopyToClipboardContentJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivActionCopyToClipboardContent> getCREATOR() {
            return DivActionCopyToClipboardContent.CREATOR;
        }
    }
}
