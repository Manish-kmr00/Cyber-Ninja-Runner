package com.yandex.div2;

import com.json.cc;
import com.yandex.div.internal.template.Field;
import com.yandex.div.json.JSONSerializable;
import com.yandex.div.json.JsonTemplate;
import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionList;
import com.yandex.div.serialization.BuiltInParserKt;
import com.yandex.div.serialization.ParsingContext;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivRadialGradientTemplate.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0019BE\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0005\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\u0002\u0010\rB-\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0000\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/yandex/div2/DivRadialGradientTemplate;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/json/JsonTemplate;", "Lcom/yandex/div2/DivRadialGradient;", "centerX", "Lcom/yandex/div/internal/template/Field;", "Lcom/yandex/div2/DivRadialGradientCenterTemplate;", "centerY", "colors", "Lcom/yandex/div/json/expressions/ExpressionList;", "", "radius", "Lcom/yandex/div2/DivRadialGradientRadiusTemplate;", "(Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;)V", cc.o, "Lcom/yandex/div/json/ParsingEnvironment;", "parent", "topLevel", "", "json", "Lorg/json/JSONObject;", "(Lcom/yandex/div/json/ParsingEnvironment;Lcom/yandex/div2/DivRadialGradientTemplate;ZLorg/json/JSONObject;)V", "resolve", "data", "writeToJSON", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivRadialGradientTemplate implements JSONSerializable, JsonTemplate<DivRadialGradient> {
    private static final DivRadialGradientCenter.Relative CENTER_X_DEFAULT_VALUE;
    private static final DivRadialGradientCenter.Relative CENTER_Y_DEFAULT_VALUE;
    private static final Function2<ParsingEnvironment, JSONObject, DivRadialGradientTemplate> CREATOR;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final DivRadialGradientRadius.Relative RADIUS_DEFAULT_VALUE;
    public static final String TYPE = "radial_gradient";
    public final Field<DivRadialGradientCenterTemplate> centerX;
    public final Field<DivRadialGradientCenterTemplate> centerY;
    public final Field<ExpressionList<Integer>> colors;
    public final Field<DivRadialGradientRadiusTemplate> radius;

    public DivRadialGradientTemplate(Field<DivRadialGradientCenterTemplate> centerX, Field<DivRadialGradientCenterTemplate> centerY, Field<ExpressionList<Integer>> colors, Field<DivRadialGradientRadiusTemplate> radius) {
        Intrinsics.checkNotNullParameter(centerX, "centerX");
        Intrinsics.checkNotNullParameter(centerY, "centerY");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(radius, "radius");
        this.centerX = centerX;
        this.centerY = centerY;
        this.colors = colors;
        this.radius = radius;
    }

    public /* synthetic */ DivRadialGradientTemplate(ParsingEnvironment parsingEnvironment, DivRadialGradientTemplate divRadialGradientTemplate, boolean z, JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(parsingEnvironment, (i & 2) != 0 ? null : divRadialGradientTemplate, (i & 4) != 0 ? false : z, jSONObject);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DivRadialGradientTemplate(ParsingEnvironment env, DivRadialGradientTemplate divRadialGradientTemplate, boolean z, JSONObject json) {
        this((Field<DivRadialGradientCenterTemplate>) Field.INSTANCE.nullField(false), (Field<DivRadialGradientCenterTemplate>) Field.INSTANCE.nullField(false), (Field<ExpressionList<Integer>>) Field.INSTANCE.nullField(false), (Field<DivRadialGradientRadiusTemplate>) Field.INSTANCE.nullField(false));
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(json, "json");
        throw new UnsupportedOperationException("Do not use this constructor directly.");
    }

    @Override // com.yandex.div.json.JsonTemplate
    public DivRadialGradient resolve(ParsingEnvironment env, JSONObject data) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        return BuiltInParserKt.getBuiltInParserComponent().getDivRadialGradientJsonTemplateResolver().getValue().resolve((ParsingContext) env, this, data);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivRadialGradientJsonTemplateParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivRadialGradientTemplate.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/yandex/div2/DivRadialGradientTemplate$Companion;", "", "()V", "CENTER_X_DEFAULT_VALUE", "Lcom/yandex/div2/DivRadialGradientCenter$Relative;", "CENTER_Y_DEFAULT_VALUE", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivRadialGradientTemplate;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "RADIUS_DEFAULT_VALUE", "Lcom/yandex/div2/DivRadialGradientRadius$Relative;", "TYPE", "", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function2<ParsingEnvironment, JSONObject, DivRadialGradientTemplate> getCREATOR() {
            return DivRadialGradientTemplate.CREATOR;
        }
    }

    static {
        Expression.Companion companion = Expression.INSTANCE;
        Double dValueOf = Double.valueOf(0.5d);
        CENTER_X_DEFAULT_VALUE = new DivRadialGradientCenter.Relative(new DivRadialGradientRelativeCenter(companion.constant(dValueOf)));
        CENTER_Y_DEFAULT_VALUE = new DivRadialGradientCenter.Relative(new DivRadialGradientRelativeCenter(Expression.INSTANCE.constant(dValueOf)));
        RADIUS_DEFAULT_VALUE = new DivRadialGradientRadius.Relative(new DivRadialGradientRelativeRadius(Expression.INSTANCE.constant(DivRadialGradientRelativeRadius.Value.FARTHEST_CORNER)));
        CREATOR = new Function2<ParsingEnvironment, JSONObject, DivRadialGradientTemplate>() { // from class: com.yandex.div2.DivRadialGradientTemplate$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivRadialGradientTemplate invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return new DivRadialGradientTemplate(env, null, false, it, 6, null);
            }
        };
    }
}
