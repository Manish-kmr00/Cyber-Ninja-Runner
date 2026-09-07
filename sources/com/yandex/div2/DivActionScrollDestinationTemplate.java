package com.yandex.div2;

import com.json.cc;
import com.yandex.div.json.JSONSerializable;
import com.yandex.div.json.JsonTemplate;
import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.ParsingException;
import com.yandex.div.serialization.BuiltInParserKt;
import com.yandex.div.serialization.ParsingContext;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivActionScrollDestinationTemplate.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00112\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0005\u0011\u0012\u0013\u0014\u0015B\u0007\b\u0004¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\rH\u0016R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0001\u0004\u0016\u0017\u0018\u0019¨\u0006\u001a"}, d2 = {"Lcom/yandex/div2/DivActionScrollDestinationTemplate;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/json/JsonTemplate;", "Lcom/yandex/div2/DivActionScrollDestination;", "()V", "type", "", "getType", "()Ljava/lang/String;", "resolve", cc.o, "Lcom/yandex/div/json/ParsingEnvironment;", "data", "Lorg/json/JSONObject;", "value", "", "writeToJSON", "Companion", "End", "Index", "Offset", "Start", "Lcom/yandex/div2/DivActionScrollDestinationTemplate$End;", "Lcom/yandex/div2/DivActionScrollDestinationTemplate$Index;", "Lcom/yandex/div2/DivActionScrollDestinationTemplate$Offset;", "Lcom/yandex/div2/DivActionScrollDestinationTemplate$Start;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class DivActionScrollDestinationTemplate implements JSONSerializable, JsonTemplate<DivActionScrollDestination> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function2<ParsingEnvironment, JSONObject, DivActionScrollDestinationTemplate> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivActionScrollDestinationTemplate>() { // from class: com.yandex.div2.DivActionScrollDestinationTemplate$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivActionScrollDestinationTemplate invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivActionScrollDestinationTemplate.Companion.invoke$default(DivActionScrollDestinationTemplate.INSTANCE, env, false, it, 2, null);
        }
    };

    public /* synthetic */ DivActionScrollDestinationTemplate(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: DivActionScrollDestinationTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionScrollDestinationTemplate$Offset;", "Lcom/yandex/div2/DivActionScrollDestinationTemplate;", "value", "Lcom/yandex/div2/OffsetDestinationTemplate;", "(Lcom/yandex/div2/OffsetDestinationTemplate;)V", "getValue", "()Lcom/yandex/div2/OffsetDestinationTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Offset extends DivActionScrollDestinationTemplate {
        private final OffsetDestinationTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Offset(OffsetDestinationTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final OffsetDestinationTemplate getValue() {
            return this.value;
        }
    }

    private DivActionScrollDestinationTemplate() {
    }

    /* JADX INFO: compiled from: DivActionScrollDestinationTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionScrollDestinationTemplate$Index;", "Lcom/yandex/div2/DivActionScrollDestinationTemplate;", "value", "Lcom/yandex/div2/IndexDestinationTemplate;", "(Lcom/yandex/div2/IndexDestinationTemplate;)V", "getValue", "()Lcom/yandex/div2/IndexDestinationTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Index extends DivActionScrollDestinationTemplate {
        private final IndexDestinationTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Index(IndexDestinationTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final IndexDestinationTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionScrollDestinationTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionScrollDestinationTemplate$Start;", "Lcom/yandex/div2/DivActionScrollDestinationTemplate;", "value", "Lcom/yandex/div2/StartDestinationTemplate;", "(Lcom/yandex/div2/StartDestinationTemplate;)V", "getValue", "()Lcom/yandex/div2/StartDestinationTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Start extends DivActionScrollDestinationTemplate {
        private final StartDestinationTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Start(StartDestinationTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final StartDestinationTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionScrollDestinationTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionScrollDestinationTemplate$End;", "Lcom/yandex/div2/DivActionScrollDestinationTemplate;", "value", "Lcom/yandex/div2/EndDestinationTemplate;", "(Lcom/yandex/div2/EndDestinationTemplate;)V", "getValue", "()Lcom/yandex/div2/EndDestinationTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class End extends DivActionScrollDestinationTemplate {
        private final EndDestinationTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public End(EndDestinationTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final EndDestinationTemplate getValue() {
            return this.value;
        }
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
        return BuiltInParserKt.getBuiltInParserComponent().getDivActionScrollDestinationJsonTemplateParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    @Override // com.yandex.div.json.JsonTemplate
    public DivActionScrollDestination resolve(ParsingEnvironment env, JSONObject data) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        return BuiltInParserKt.getBuiltInParserComponent().getDivActionScrollDestinationJsonTemplateResolver().getValue().resolve((ParsingContext) env, this, data);
    }

    public final String getType() {
        if (this instanceof Offset) {
            return "offset";
        }
        if (this instanceof Index) {
            return "index";
        }
        if (this instanceof Start) {
            return "start";
        }
        if (this instanceof End) {
            return "end";
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: compiled from: DivActionScrollDestinationTemplate.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0086\u0002R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/yandex/div2/DivActionScrollDestinationTemplate$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivActionScrollDestinationTemplate;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "invoke", cc.o, "topLevel", "", "json", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ DivActionScrollDestinationTemplate invoke$default(Companion companion, ParsingEnvironment parsingEnvironment, boolean z, JSONObject jSONObject, int i, Object obj) throws ParsingException {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.invoke(parsingEnvironment, z, jSONObject);
        }

        public final DivActionScrollDestinationTemplate invoke(ParsingEnvironment env, boolean topLevel, JSONObject json) throws ParsingException {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivActionScrollDestinationJsonTemplateParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivActionScrollDestinationTemplate> getCREATOR() {
            return DivActionScrollDestinationTemplate.CREATOR;
        }
    }
}
