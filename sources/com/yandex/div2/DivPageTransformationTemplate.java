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

/* JADX INFO: compiled from: DivPageTransformationTemplate.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00112\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0003\u0011\u0012\u0013B\u0007\b\u0004¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\rH\u0016R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0001\u0002\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/yandex/div2/DivPageTransformationTemplate;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/json/JsonTemplate;", "Lcom/yandex/div2/DivPageTransformation;", "()V", "type", "", "getType", "()Ljava/lang/String;", "resolve", cc.o, "Lcom/yandex/div/json/ParsingEnvironment;", "data", "Lorg/json/JSONObject;", "value", "", "writeToJSON", "Companion", "Overlap", "Slide", "Lcom/yandex/div2/DivPageTransformationTemplate$Overlap;", "Lcom/yandex/div2/DivPageTransformationTemplate$Slide;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class DivPageTransformationTemplate implements JSONSerializable, JsonTemplate<DivPageTransformation> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function2<ParsingEnvironment, JSONObject, DivPageTransformationTemplate> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivPageTransformationTemplate>() { // from class: com.yandex.div2.DivPageTransformationTemplate$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivPageTransformationTemplate invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivPageTransformationTemplate.Companion.invoke$default(DivPageTransformationTemplate.INSTANCE, env, false, it, 2, null);
        }
    };

    public /* synthetic */ DivPageTransformationTemplate(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: DivPageTransformationTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivPageTransformationTemplate$Slide;", "Lcom/yandex/div2/DivPageTransformationTemplate;", "value", "Lcom/yandex/div2/DivPageTransformationSlideTemplate;", "(Lcom/yandex/div2/DivPageTransformationSlideTemplate;)V", "getValue", "()Lcom/yandex/div2/DivPageTransformationSlideTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Slide extends DivPageTransformationTemplate {
        private final DivPageTransformationSlideTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Slide(DivPageTransformationSlideTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivPageTransformationSlideTemplate getValue() {
            return this.value;
        }
    }

    private DivPageTransformationTemplate() {
    }

    /* JADX INFO: compiled from: DivPageTransformationTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivPageTransformationTemplate$Overlap;", "Lcom/yandex/div2/DivPageTransformationTemplate;", "value", "Lcom/yandex/div2/DivPageTransformationOverlapTemplate;", "(Lcom/yandex/div2/DivPageTransformationOverlapTemplate;)V", "getValue", "()Lcom/yandex/div2/DivPageTransformationOverlapTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Overlap extends DivPageTransformationTemplate {
        private final DivPageTransformationOverlapTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Overlap(DivPageTransformationOverlapTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivPageTransformationOverlapTemplate getValue() {
            return this.value;
        }
    }

    public final Object value() {
        if (this instanceof Slide) {
            return ((Slide) this).getValue();
        }
        if (this instanceof Overlap) {
            return ((Overlap) this).getValue();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivPageTransformationJsonTemplateParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    @Override // com.yandex.div.json.JsonTemplate
    public DivPageTransformation resolve(ParsingEnvironment env, JSONObject data) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        return BuiltInParserKt.getBuiltInParserComponent().getDivPageTransformationJsonTemplateResolver().getValue().resolve((ParsingContext) env, this, data);
    }

    public final String getType() {
        if (this instanceof Slide) {
            return "slide";
        }
        if (this instanceof Overlap) {
            return "overlap";
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: compiled from: DivPageTransformationTemplate.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0086\u0002R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/yandex/div2/DivPageTransformationTemplate$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivPageTransformationTemplate;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "invoke", cc.o, "topLevel", "", "json", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ DivPageTransformationTemplate invoke$default(Companion companion, ParsingEnvironment parsingEnvironment, boolean z, JSONObject jSONObject, int i, Object obj) throws ParsingException {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.invoke(parsingEnvironment, z, jSONObject);
        }

        public final DivPageTransformationTemplate invoke(ParsingEnvironment env, boolean topLevel, JSONObject json) throws ParsingException {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivPageTransformationJsonTemplateParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivPageTransformationTemplate> getCREATOR() {
            return DivPageTransformationTemplate.CREATOR;
        }
    }
}
