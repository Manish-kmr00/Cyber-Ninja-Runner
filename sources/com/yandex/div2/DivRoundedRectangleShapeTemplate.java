package com.yandex.div2;

import com.json.cc;
import com.yandex.div.internal.template.Field;
import com.yandex.div.json.JSONSerializable;
import com.yandex.div.json.JsonTemplate;
import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.serialization.BuiltInParserKt;
import com.yandex.div.serialization.ParsingContext;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivRoundedRectangleShapeTemplate.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u001aBS\b\u0016\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0005\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0005¢\u0006\u0002\u0010\u000eB-\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0000\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016R\u001c\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/yandex/div2/DivRoundedRectangleShapeTemplate;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/json/JsonTemplate;", "Lcom/yandex/div2/DivRoundedRectangleShape;", "backgroundColor", "Lcom/yandex/div/internal/template/Field;", "Lcom/yandex/div/json/expressions/Expression;", "", "cornerRadius", "Lcom/yandex/div2/DivFixedSizeTemplate;", "itemHeight", "itemWidth", VastAttributes.STROKE_COLOR, "Lcom/yandex/div2/DivStrokeTemplate;", "(Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;)V", cc.o, "Lcom/yandex/div/json/ParsingEnvironment;", "parent", "topLevel", "", "json", "Lorg/json/JSONObject;", "(Lcom/yandex/div/json/ParsingEnvironment;Lcom/yandex/div2/DivRoundedRectangleShapeTemplate;ZLorg/json/JSONObject;)V", "resolve", "data", "writeToJSON", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivRoundedRectangleShapeTemplate implements JSONSerializable, JsonTemplate<DivRoundedRectangleShape> {
    private static final DivFixedSize CORNER_RADIUS_DEFAULT_VALUE;
    private static final DivFixedSize ITEM_HEIGHT_DEFAULT_VALUE;
    private static final DivFixedSize ITEM_WIDTH_DEFAULT_VALUE;
    public static final String TYPE = "rounded_rectangle";
    public final Field<Expression<Integer>> backgroundColor;
    public final Field<DivFixedSizeTemplate> cornerRadius;
    public final Field<DivFixedSizeTemplate> itemHeight;
    public final Field<DivFixedSizeTemplate> itemWidth;
    public final Field<DivStrokeTemplate> stroke;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function2<ParsingEnvironment, JSONObject, DivRoundedRectangleShapeTemplate> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivRoundedRectangleShapeTemplate>() { // from class: com.yandex.div2.DivRoundedRectangleShapeTemplate$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivRoundedRectangleShapeTemplate invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return new DivRoundedRectangleShapeTemplate(env, null, false, it, 6, null);
        }
    };

    public DivRoundedRectangleShapeTemplate(Field<Expression<Integer>> backgroundColor, Field<DivFixedSizeTemplate> cornerRadius, Field<DivFixedSizeTemplate> itemHeight, Field<DivFixedSizeTemplate> itemWidth, Field<DivStrokeTemplate> stroke) {
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(cornerRadius, "cornerRadius");
        Intrinsics.checkNotNullParameter(itemHeight, "itemHeight");
        Intrinsics.checkNotNullParameter(itemWidth, "itemWidth");
        Intrinsics.checkNotNullParameter(stroke, "stroke");
        this.backgroundColor = backgroundColor;
        this.cornerRadius = cornerRadius;
        this.itemHeight = itemHeight;
        this.itemWidth = itemWidth;
        this.stroke = stroke;
    }

    public /* synthetic */ DivRoundedRectangleShapeTemplate(ParsingEnvironment parsingEnvironment, DivRoundedRectangleShapeTemplate divRoundedRectangleShapeTemplate, boolean z, JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(parsingEnvironment, (i & 2) != 0 ? null : divRoundedRectangleShapeTemplate, (i & 4) != 0 ? false : z, jSONObject);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DivRoundedRectangleShapeTemplate(ParsingEnvironment env, DivRoundedRectangleShapeTemplate divRoundedRectangleShapeTemplate, boolean z, JSONObject json) {
        this(Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false));
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(json, "json");
        throw new UnsupportedOperationException("Do not use this constructor directly.");
    }

    @Override // com.yandex.div.json.JsonTemplate
    public DivRoundedRectangleShape resolve(ParsingEnvironment env, JSONObject data) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        return BuiltInParserKt.getBuiltInParserComponent().getDivRoundedRectangleShapeJsonTemplateResolver().getValue().resolve((ParsingContext) env, this, data);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivRoundedRectangleShapeJsonTemplateParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivRoundedRectangleShapeTemplate.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/yandex/div2/DivRoundedRectangleShapeTemplate$Companion;", "", "()V", "CORNER_RADIUS_DEFAULT_VALUE", "Lcom/yandex/div2/DivFixedSize;", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivRoundedRectangleShapeTemplate;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "ITEM_HEIGHT_DEFAULT_VALUE", "ITEM_WIDTH_DEFAULT_VALUE", "TYPE", "", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function2<ParsingEnvironment, JSONObject, DivRoundedRectangleShapeTemplate> getCREATOR() {
            return DivRoundedRectangleShapeTemplate.CREATOR;
        }
    }

    static {
        int i = 1;
        CORNER_RADIUS_DEFAULT_VALUE = new DivFixedSize(0 == true ? 1 : 0, Expression.INSTANCE.constant(5L), i, 0 == true ? 1 : 0);
        ITEM_HEIGHT_DEFAULT_VALUE = new DivFixedSize(0 == true ? 1 : 0, Expression.INSTANCE.constant(10L), i, 0 == true ? 1 : 0);
        ITEM_WIDTH_DEFAULT_VALUE = new DivFixedSize(0 == true ? 1 : 0, Expression.INSTANCE.constant(10L), i, 0 == true ? 1 : 0);
    }
}
