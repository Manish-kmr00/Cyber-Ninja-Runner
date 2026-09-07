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
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivVideoSource.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0002\u001a\u001bBA\b\u0007\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\u0002\u0010\fJD\u0010\u0010\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004J \u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u0018\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/yandex/div2/DivVideoSource;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "bitrate", "Lcom/yandex/div/json/expressions/Expression;", "", "mimeType", "", "resolution", "Lcom/yandex/div2/DivVideoSource$Resolution;", "url", "Landroid/net/Uri;", "(Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivVideoSource$Resolution;Lcom/yandex/div/json/expressions/Expression;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "Resolution", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivVideoSource implements JSONSerializable, Hashable {
    public static final String TYPE = "video_source";
    private Integer _hash;
    public final Expression<Long> bitrate;
    public final Expression<String> mimeType;
    public final Resolution resolution;
    public final Expression<Uri> url;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function2<ParsingEnvironment, JSONObject, DivVideoSource> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivVideoSource>() { // from class: com.yandex.div2.DivVideoSource$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivVideoSource invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivVideoSource.INSTANCE.fromJson(env, it);
        }
    };

    @JvmStatic
    public static final DivVideoSource fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivVideoSource(Expression<Long> expression, Expression<String> mimeType, Resolution resolution, Expression<Uri> url) {
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        Intrinsics.checkNotNullParameter(url, "url");
        this.bitrate = expression;
        this.mimeType = mimeType;
        this.resolution = resolution;
        this.url = url;
    }

    public /* synthetic */ DivVideoSource(Expression expression, Expression expression2, Resolution resolution, Expression expression3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : expression, expression2, (i & 4) != 0 ? null : resolution, expression3);
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
        Expression<Long> expression = this.bitrate;
        int iHashCode2 = iHashCode + (expression != null ? expression.hashCode() : 0) + this.mimeType.hashCode();
        Resolution resolution = this.resolution;
        int iHash = iHashCode2 + (resolution != null ? resolution.hash() : 0) + this.url.hashCode();
        this._hash = Integer.valueOf(iHash);
        return iHash;
    }

    public final boolean equals(DivVideoSource other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        boolean zEquals;
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null) {
            return false;
        }
        Expression<Long> expression = this.bitrate;
        Long lEvaluate = expression != null ? expression.evaluate(resolver) : null;
        Expression<Long> expression2 = other.bitrate;
        if (!Intrinsics.areEqual(lEvaluate, expression2 != null ? expression2.evaluate(otherResolver) : null) || !Intrinsics.areEqual(this.mimeType.evaluate(resolver), other.mimeType.evaluate(otherResolver))) {
            return false;
        }
        Resolution resolution = this.resolution;
        if (resolution != null) {
            zEquals = resolution.equals(other.resolution, resolver, otherResolver);
        } else {
            zEquals = other.resolution == null;
        }
        return zEquals && Intrinsics.areEqual(this.url.evaluate(resolver), other.url.evaluate(otherResolver));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivVideoSource copy$default(DivVideoSource divVideoSource, Expression expression, Expression expression2, Resolution resolution, Expression expression3, int i, Object obj) {
        if ((i & 1) != 0) {
            expression = divVideoSource.bitrate;
        }
        if ((i & 2) != 0) {
            expression2 = divVideoSource.mimeType;
        }
        if ((i & 4) != 0) {
            resolution = divVideoSource.resolution;
        }
        if ((i & 8) != 0) {
            expression3 = divVideoSource.url;
        }
        return divVideoSource.copy(expression, expression2, resolution, expression3);
    }

    public final DivVideoSource copy(Expression<Long> bitrate, Expression<String> mimeType, Resolution resolution, Expression<Uri> url) {
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        Intrinsics.checkNotNullParameter(url, "url");
        return new DivVideoSource(bitrate, mimeType, resolution, url);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivVideoSourceJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivVideoSource.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u000fR#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/yandex/div2/DivVideoSource$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivVideoSource;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "TYPE", "", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivVideoSource fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivVideoSourceJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivVideoSource> getCREATOR() {
            return DivVideoSource.CREATOR;
        }
    }

    /* JADX INFO: compiled from: DivVideoSource.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u0015B#\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0007J&\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J \u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J\b\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/yandex/div2/DivVideoSource$Resolution;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "height", "Lcom/yandex/div/json/expressions/Expression;", "", "width", "(Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Resolution implements JSONSerializable, Hashable {
        public static final String TYPE = "resolution";
        private Integer _hash;
        public final Expression<Long> height;
        public final Expression<Long> width;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Function2<ParsingEnvironment, JSONObject, Resolution> CREATOR = new Function2<ParsingEnvironment, JSONObject, Resolution>() { // from class: com.yandex.div2.DivVideoSource$Resolution$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivVideoSource.Resolution invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return DivVideoSource.Resolution.INSTANCE.fromJson(env, it);
            }
        };

        @JvmStatic
        public static final Resolution fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
            return INSTANCE.fromJson(parsingEnvironment, jSONObject);
        }

        public Resolution(Expression<Long> height, Expression<Long> width) {
            Intrinsics.checkNotNullParameter(height, "height");
            Intrinsics.checkNotNullParameter(width, "width");
            this.height = height;
            this.width = width;
        }

        @Override // com.yandex.div.data.Hashable
        public int hash() {
            Integer num = this._hash;
            if (num != null) {
                return num.intValue();
            }
            int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + this.height.hashCode() + this.width.hashCode();
            this._hash = Integer.valueOf(iHashCode);
            return iHashCode;
        }

        public final boolean equals(Resolution other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
            return other != null && this.height.evaluate(resolver).longValue() == other.height.evaluate(otherResolver).longValue() && this.width.evaluate(resolver).longValue() == other.width.evaluate(otherResolver).longValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Resolution copy$default(Resolution resolution, Expression expression, Expression expression2, int i, Object obj) {
            if ((i & 1) != 0) {
                expression = resolution.height;
            }
            if ((i & 2) != 0) {
                expression2 = resolution.width;
            }
            return resolution.copy(expression, expression2);
        }

        public final Resolution copy(Expression<Long> height, Expression<Long> width) {
            Intrinsics.checkNotNullParameter(height, "height");
            Intrinsics.checkNotNullParameter(width, "width");
            return new Resolution(height, width);
        }

        @Override // com.yandex.div.json.JSONSerializable
        public JSONObject writeToJSON() {
            return BuiltInParserKt.getBuiltInParserComponent().getDivVideoSourceResolutionJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
        }

        /* JADX INFO: compiled from: DivVideoSource.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u000fR#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/yandex/div2/DivVideoSource$Resolution$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivVideoSource$Resolution;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "TYPE", "", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Resolution fromJson(ParsingEnvironment env, JSONObject json) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(json, "json");
                return BuiltInParserKt.getBuiltInParserComponent().getDivVideoSourceResolutionJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
            }

            public final Function2<ParsingEnvironment, JSONObject, Resolution> getCREATOR() {
                return Resolution.CREATOR;
            }
        }
    }
}
