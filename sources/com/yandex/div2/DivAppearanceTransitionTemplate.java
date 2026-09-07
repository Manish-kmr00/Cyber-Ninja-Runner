package com.yandex.div2;

import com.google.android.exoplayer2.source.rtsp.RtspHeaders;
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

/* JADX INFO: compiled from: DivAppearanceTransitionTemplate.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00112\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0005\u0011\u0012\u0013\u0014\u0015B\u0007\b\u0004¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\rH\u0016R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0001\u0004\u0016\u0017\u0018\u0019¨\u0006\u001a"}, d2 = {"Lcom/yandex/div2/DivAppearanceTransitionTemplate;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/json/JsonTemplate;", "Lcom/yandex/div2/DivAppearanceTransition;", "()V", "type", "", "getType", "()Ljava/lang/String;", "resolve", cc.o, "Lcom/yandex/div/json/ParsingEnvironment;", "data", "Lorg/json/JSONObject;", "value", "", "writeToJSON", "Companion", "Fade", RtspHeaders.SCALE, "Set", "Slide", "Lcom/yandex/div2/DivAppearanceTransitionTemplate$Fade;", "Lcom/yandex/div2/DivAppearanceTransitionTemplate$Scale;", "Lcom/yandex/div2/DivAppearanceTransitionTemplate$Set;", "Lcom/yandex/div2/DivAppearanceTransitionTemplate$Slide;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class DivAppearanceTransitionTemplate implements JSONSerializable, JsonTemplate<DivAppearanceTransition> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function2<ParsingEnvironment, JSONObject, DivAppearanceTransitionTemplate> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivAppearanceTransitionTemplate>() { // from class: com.yandex.div2.DivAppearanceTransitionTemplate$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivAppearanceTransitionTemplate invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivAppearanceTransitionTemplate.Companion.invoke$default(DivAppearanceTransitionTemplate.INSTANCE, env, false, it, 2, null);
        }
    };

    public /* synthetic */ DivAppearanceTransitionTemplate(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: DivAppearanceTransitionTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivAppearanceTransitionTemplate$Set;", "Lcom/yandex/div2/DivAppearanceTransitionTemplate;", "value", "Lcom/yandex/div2/DivAppearanceSetTransitionTemplate;", "(Lcom/yandex/div2/DivAppearanceSetTransitionTemplate;)V", "getValue", "()Lcom/yandex/div2/DivAppearanceSetTransitionTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Set extends DivAppearanceTransitionTemplate {
        private final DivAppearanceSetTransitionTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Set(DivAppearanceSetTransitionTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivAppearanceSetTransitionTemplate getValue() {
            return this.value;
        }
    }

    private DivAppearanceTransitionTemplate() {
    }

    /* JADX INFO: compiled from: DivAppearanceTransitionTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivAppearanceTransitionTemplate$Fade;", "Lcom/yandex/div2/DivAppearanceTransitionTemplate;", "value", "Lcom/yandex/div2/DivFadeTransitionTemplate;", "(Lcom/yandex/div2/DivFadeTransitionTemplate;)V", "getValue", "()Lcom/yandex/div2/DivFadeTransitionTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Fade extends DivAppearanceTransitionTemplate {
        private final DivFadeTransitionTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Fade(DivFadeTransitionTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivFadeTransitionTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivAppearanceTransitionTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivAppearanceTransitionTemplate$Scale;", "Lcom/yandex/div2/DivAppearanceTransitionTemplate;", "value", "Lcom/yandex/div2/DivScaleTransitionTemplate;", "(Lcom/yandex/div2/DivScaleTransitionTemplate;)V", "getValue", "()Lcom/yandex/div2/DivScaleTransitionTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Scale extends DivAppearanceTransitionTemplate {
        private final DivScaleTransitionTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Scale(DivScaleTransitionTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivScaleTransitionTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivAppearanceTransitionTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivAppearanceTransitionTemplate$Slide;", "Lcom/yandex/div2/DivAppearanceTransitionTemplate;", "value", "Lcom/yandex/div2/DivSlideTransitionTemplate;", "(Lcom/yandex/div2/DivSlideTransitionTemplate;)V", "getValue", "()Lcom/yandex/div2/DivSlideTransitionTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Slide extends DivAppearanceTransitionTemplate {
        private final DivSlideTransitionTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Slide(DivSlideTransitionTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivSlideTransitionTemplate getValue() {
            return this.value;
        }
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
        return BuiltInParserKt.getBuiltInParserComponent().getDivAppearanceTransitionJsonTemplateParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    @Override // com.yandex.div.json.JsonTemplate
    public DivAppearanceTransition resolve(ParsingEnvironment env, JSONObject data) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        return BuiltInParserKt.getBuiltInParserComponent().getDivAppearanceTransitionJsonTemplateResolver().getValue().resolve((ParsingContext) env, this, data);
    }

    public final String getType() {
        if (this instanceof Set) {
            return "set";
        }
        if (this instanceof Fade) {
            return "fade";
        }
        if (this instanceof Scale) {
            return "scale";
        }
        if (this instanceof Slide) {
            return "slide";
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: compiled from: DivAppearanceTransitionTemplate.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0086\u0002R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/yandex/div2/DivAppearanceTransitionTemplate$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivAppearanceTransitionTemplate;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "invoke", cc.o, "topLevel", "", "json", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ DivAppearanceTransitionTemplate invoke$default(Companion companion, ParsingEnvironment parsingEnvironment, boolean z, JSONObject jSONObject, int i, Object obj) throws ParsingException {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.invoke(parsingEnvironment, z, jSONObject);
        }

        public final DivAppearanceTransitionTemplate invoke(ParsingEnvironment env, boolean topLevel, JSONObject json) throws ParsingException {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivAppearanceTransitionJsonTemplateParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivAppearanceTransitionTemplate> getCREATOR() {
            return DivAppearanceTransitionTemplate.CREATOR;
        }
    }
}
