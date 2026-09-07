package com.yandex.div2;

import android.net.Uri;
import com.json.cc;
import com.yandex.div.data.Hashable;
import com.yandex.div.json.JSONSerializable;
import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.serialization.BuiltInParserKt;
import com.yandex.div.serialization.ParsingContext;
import io.bidmachine.unified.UnifiedMediationParams;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivImageBackground.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 Bw\b\u0007\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004¢\u0006\u0002\u0010\u0013Jx\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00042\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00042\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004J \u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bJ\b\u0010\u001d\u001a\u00020\u0015H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/yandex/div2/DivImageBackground;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "alpha", "Lcom/yandex/div/json/expressions/Expression;", "", "contentAlignmentHorizontal", "Lcom/yandex/div2/DivAlignmentHorizontal;", "contentAlignmentVertical", "Lcom/yandex/div2/DivAlignmentVertical;", "filters", "", "Lcom/yandex/div2/DivFilter;", UnifiedMediationParams.KEY_IMAGE_URL, "Landroid/net/Uri;", "preloadRequired", "", "scale", "Lcom/yandex/div2/DivImageScale;", "(Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivImageBackground implements JSONSerializable, Hashable {
    public static final String TYPE = "image";
    private Integer _hash;
    public final Expression<Double> alpha;
    public final Expression<DivAlignmentHorizontal> contentAlignmentHorizontal;
    public final Expression<DivAlignmentVertical> contentAlignmentVertical;
    public final List<DivFilter> filters;
    public final Expression<Uri> imageUrl;
    public final Expression<Boolean> preloadRequired;
    public final Expression<DivImageScale> scale;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Expression<Double> ALPHA_DEFAULT_VALUE = Expression.INSTANCE.constant(Double.valueOf(1.0d));
    private static final Expression<DivAlignmentHorizontal> CONTENT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE = Expression.INSTANCE.constant(DivAlignmentHorizontal.CENTER);
    private static final Expression<DivAlignmentVertical> CONTENT_ALIGNMENT_VERTICAL_DEFAULT_VALUE = Expression.INSTANCE.constant(DivAlignmentVertical.CENTER);
    private static final Expression<Boolean> PRELOAD_REQUIRED_DEFAULT_VALUE = Expression.INSTANCE.constant(false);
    private static final Expression<DivImageScale> SCALE_DEFAULT_VALUE = Expression.INSTANCE.constant(DivImageScale.FILL);
    private static final Function2<ParsingEnvironment, JSONObject, DivImageBackground> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivImageBackground>() { // from class: com.yandex.div2.DivImageBackground$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivImageBackground invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivImageBackground.INSTANCE.fromJson(env, it);
        }
    };

    @JvmStatic
    public static final DivImageBackground fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DivImageBackground(Expression<Double> alpha, Expression<DivAlignmentHorizontal> contentAlignmentHorizontal, Expression<DivAlignmentVertical> contentAlignmentVertical, List<? extends DivFilter> list, Expression<Uri> imageUrl, Expression<Boolean> preloadRequired, Expression<DivImageScale> scale) {
        Intrinsics.checkNotNullParameter(alpha, "alpha");
        Intrinsics.checkNotNullParameter(contentAlignmentHorizontal, "contentAlignmentHorizontal");
        Intrinsics.checkNotNullParameter(contentAlignmentVertical, "contentAlignmentVertical");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(preloadRequired, "preloadRequired");
        Intrinsics.checkNotNullParameter(scale, "scale");
        this.alpha = alpha;
        this.contentAlignmentHorizontal = contentAlignmentHorizontal;
        this.contentAlignmentVertical = contentAlignmentVertical;
        this.filters = list;
        this.imageUrl = imageUrl;
        this.preloadRequired = preloadRequired;
        this.scale = scale;
    }

    public /* synthetic */ DivImageBackground(Expression expression, Expression expression2, Expression expression3, List list, Expression expression4, Expression expression5, Expression expression6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ALPHA_DEFAULT_VALUE : expression, (i & 2) != 0 ? CONTENT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE : expression2, (i & 4) != 0 ? CONTENT_ALIGNMENT_VERTICAL_DEFAULT_VALUE : expression3, (i & 8) != 0 ? null : list, expression4, (i & 32) != 0 ? PRELOAD_REQUIRED_DEFAULT_VALUE : expression5, (i & 64) != 0 ? SCALE_DEFAULT_VALUE : expression6);
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + this.alpha.hashCode() + this.contentAlignmentHorizontal.hashCode() + this.contentAlignmentVertical.hashCode();
        List<DivFilter> list = this.filters;
        int iHash = 0;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                iHash += ((DivFilter) it.next()).hash();
            }
        }
        int iHashCode2 = iHashCode + iHash + this.imageUrl.hashCode() + this.preloadRequired.hashCode() + this.scale.hashCode();
        this._hash = Integer.valueOf(iHashCode2);
        return iHashCode2;
    }

    public final boolean equals(DivImageBackground other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null || this.alpha.evaluate(resolver).doubleValue() != other.alpha.evaluate(otherResolver).doubleValue() || this.contentAlignmentHorizontal.evaluate(resolver) != other.contentAlignmentHorizontal.evaluate(otherResolver) || this.contentAlignmentVertical.evaluate(resolver) != other.contentAlignmentVertical.evaluate(otherResolver)) {
            return false;
        }
        List<DivFilter> list = this.filters;
        if (list != null) {
            List<DivFilter> list2 = other.filters;
            if (list2 == null || list.size() != list2.size()) {
                return false;
            }
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (!((DivFilter) obj).equals(list2.get(i), resolver, otherResolver)) {
                    return false;
                }
                i = i2;
            }
        } else if (other.filters != null) {
            return false;
        }
        return Intrinsics.areEqual(this.imageUrl.evaluate(resolver), other.imageUrl.evaluate(otherResolver)) && this.preloadRequired.evaluate(resolver).booleanValue() == other.preloadRequired.evaluate(otherResolver).booleanValue() && this.scale.evaluate(resolver) == other.scale.evaluate(otherResolver);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivImageBackground copy$default(DivImageBackground divImageBackground, Expression expression, Expression expression2, Expression expression3, List list, Expression expression4, Expression expression5, Expression expression6, int i, Object obj) {
        if ((i & 1) != 0) {
            expression = divImageBackground.alpha;
        }
        if ((i & 2) != 0) {
            expression2 = divImageBackground.contentAlignmentHorizontal;
        }
        Expression expression7 = expression2;
        if ((i & 4) != 0) {
            expression3 = divImageBackground.contentAlignmentVertical;
        }
        Expression expression8 = expression3;
        if ((i & 8) != 0) {
            list = divImageBackground.filters;
        }
        List list2 = list;
        if ((i & 16) != 0) {
            expression4 = divImageBackground.imageUrl;
        }
        Expression expression9 = expression4;
        if ((i & 32) != 0) {
            expression5 = divImageBackground.preloadRequired;
        }
        Expression expression10 = expression5;
        if ((i & 64) != 0) {
            expression6 = divImageBackground.scale;
        }
        return divImageBackground.copy(expression, expression7, expression8, list2, expression9, expression10, expression6);
    }

    public final DivImageBackground copy(Expression<Double> alpha, Expression<DivAlignmentHorizontal> contentAlignmentHorizontal, Expression<DivAlignmentVertical> contentAlignmentVertical, List<? extends DivFilter> filters, Expression<Uri> imageUrl, Expression<Boolean> preloadRequired, Expression<DivImageScale> scale) {
        Intrinsics.checkNotNullParameter(alpha, "alpha");
        Intrinsics.checkNotNullParameter(contentAlignmentHorizontal, "contentAlignmentHorizontal");
        Intrinsics.checkNotNullParameter(contentAlignmentVertical, "contentAlignmentVertical");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(preloadRequired, "preloadRequired");
        Intrinsics.checkNotNullParameter(scale, "scale");
        return new DivImageBackground(alpha, contentAlignmentHorizontal, contentAlignmentVertical, filters, imageUrl, preloadRequired, scale);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivImageBackgroundJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivImageBackground.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\rH\u0087\u0002¢\u0006\u0002\b\u001aR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/yandex/div2/DivImageBackground$Companion;", "", "()V", "ALPHA_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "CONTENT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE", "Lcom/yandex/div2/DivAlignmentHorizontal;", "CONTENT_ALIGNMENT_VERTICAL_DEFAULT_VALUE", "Lcom/yandex/div2/DivAlignmentVertical;", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivImageBackground;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "PRELOAD_REQUIRED_DEFAULT_VALUE", "", "SCALE_DEFAULT_VALUE", "Lcom/yandex/div2/DivImageScale;", "TYPE", "", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivImageBackground fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivImageBackgroundJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivImageBackground> getCREATOR() {
            return DivImageBackground.CREATOR;
        }
    }
}
