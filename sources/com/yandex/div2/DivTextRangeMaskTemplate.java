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

/* JADX INFO: compiled from: DivTextRangeMaskTemplate.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00112\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0003\u0011\u0012\u0013B\u0007\b\u0004¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\rH\u0016R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0001\u0002\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/yandex/div2/DivTextRangeMaskTemplate;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/json/JsonTemplate;", "Lcom/yandex/div2/DivTextRangeMask;", "()V", "type", "", "getType", "()Ljava/lang/String;", "resolve", cc.o, "Lcom/yandex/div/json/ParsingEnvironment;", "data", "Lorg/json/JSONObject;", "value", "", "writeToJSON", "Companion", "Particles", "Solid", "Lcom/yandex/div2/DivTextRangeMaskTemplate$Particles;", "Lcom/yandex/div2/DivTextRangeMaskTemplate$Solid;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class DivTextRangeMaskTemplate implements JSONSerializable, JsonTemplate<DivTextRangeMask> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function2<ParsingEnvironment, JSONObject, DivTextRangeMaskTemplate> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivTextRangeMaskTemplate>() { // from class: com.yandex.div2.DivTextRangeMaskTemplate$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivTextRangeMaskTemplate invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivTextRangeMaskTemplate.Companion.invoke$default(DivTextRangeMaskTemplate.INSTANCE, env, false, it, 2, null);
        }
    };

    public /* synthetic */ DivTextRangeMaskTemplate(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: DivTextRangeMaskTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTextRangeMaskTemplate$Particles;", "Lcom/yandex/div2/DivTextRangeMaskTemplate;", "value", "Lcom/yandex/div2/DivTextRangeMaskParticlesTemplate;", "(Lcom/yandex/div2/DivTextRangeMaskParticlesTemplate;)V", "getValue", "()Lcom/yandex/div2/DivTextRangeMaskParticlesTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Particles extends DivTextRangeMaskTemplate {
        private final DivTextRangeMaskParticlesTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Particles(DivTextRangeMaskParticlesTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivTextRangeMaskParticlesTemplate getValue() {
            return this.value;
        }
    }

    private DivTextRangeMaskTemplate() {
    }

    /* JADX INFO: compiled from: DivTextRangeMaskTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTextRangeMaskTemplate$Solid;", "Lcom/yandex/div2/DivTextRangeMaskTemplate;", "value", "Lcom/yandex/div2/DivTextRangeMaskSolidTemplate;", "(Lcom/yandex/div2/DivTextRangeMaskSolidTemplate;)V", "getValue", "()Lcom/yandex/div2/DivTextRangeMaskSolidTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Solid extends DivTextRangeMaskTemplate {
        private final DivTextRangeMaskSolidTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Solid(DivTextRangeMaskSolidTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivTextRangeMaskSolidTemplate getValue() {
            return this.value;
        }
    }

    public final Object value() {
        if (this instanceof Particles) {
            return ((Particles) this).getValue();
        }
        if (this instanceof Solid) {
            return ((Solid) this).getValue();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivTextRangeMaskJsonTemplateParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    @Override // com.yandex.div.json.JsonTemplate
    public DivTextRangeMask resolve(ParsingEnvironment env, JSONObject data) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        return BuiltInParserKt.getBuiltInParserComponent().getDivTextRangeMaskJsonTemplateResolver().getValue().resolve((ParsingContext) env, this, data);
    }

    public final String getType() {
        if (this instanceof Particles) {
            return "particles";
        }
        if (this instanceof Solid) {
            return "solid";
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: compiled from: DivTextRangeMaskTemplate.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0086\u0002R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/yandex/div2/DivTextRangeMaskTemplate$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTextRangeMaskTemplate;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "invoke", cc.o, "topLevel", "", "json", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ DivTextRangeMaskTemplate invoke$default(Companion companion, ParsingEnvironment parsingEnvironment, boolean z, JSONObject jSONObject, int i, Object obj) throws ParsingException {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.invoke(parsingEnvironment, z, jSONObject);
        }

        public final DivTextRangeMaskTemplate invoke(ParsingEnvironment env, boolean topLevel, JSONObject json) throws ParsingException {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivTextRangeMaskJsonTemplateParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivTextRangeMaskTemplate> getCREATOR() {
            return DivTextRangeMaskTemplate.CREATOR;
        }
    }
}
