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

/* JADX INFO: compiled from: DivVisibilityAction.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 02\u00020\u00012\u00020\u00022\u00020\u0003:\u00010B©\u0001\b\u0007\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0002\u0010\u0017Jª\u0001\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00072\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0007J \u0010)\u001a\u00020\b2\b\u0010*\u001a\u0004\u0018\u00010\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,J\b\u0010.\u001a\u00020\u0019H\u0016J\b\u0010/\u001a\u00020\u000eH\u0016R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u001dR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001c\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001c\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/yandex/div2/DivVisibilityAction;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "Lcom/yandex/div2/DivSightAction;", "downloadCallbacks", "Lcom/yandex/div2/DivDownloadCallbacks;", "isEnabled", "Lcom/yandex/div/json/expressions/Expression;", "", "logId", "", "logLimit", "", "payload", "Lorg/json/JSONObject;", "referer", "Landroid/net/Uri;", "scopeId", "typed", "Lcom/yandex/div2/DivActionTyped;", "url", "visibilityDuration", "visibilityPercentage", "(Lcom/yandex/div2/DivDownloadCallbacks;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lorg/json/JSONObject;Lcom/yandex/div/json/expressions/Expression;Ljava/lang/String;Lcom/yandex/div2/DivActionTyped;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;)V", "_hash", "", "Ljava/lang/Integer;", "getDownloadCallbacks", "()Lcom/yandex/div2/DivDownloadCallbacks;", "()Lcom/yandex/div/json/expressions/Expression;", "getLogId", "getLogLimit", "getPayload", "()Lorg/json/JSONObject;", "getReferer", "getScopeId", "()Ljava/lang/String;", "getTyped", "()Lcom/yandex/div2/DivActionTyped;", "getUrl", "copy", "equals", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivVisibilityAction implements JSONSerializable, Hashable, DivSightAction {
    private Integer _hash;
    private final DivDownloadCallbacks downloadCallbacks;
    private final Expression<Boolean> isEnabled;
    private final Expression<String> logId;
    private final Expression<Long> logLimit;
    private final JSONObject payload;
    private final Expression<Uri> referer;
    private final String scopeId;
    private final DivActionTyped typed;
    private final Expression<Uri> url;
    public final Expression<Long> visibilityDuration;
    public final Expression<Long> visibilityPercentage;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Expression<Boolean> IS_ENABLED_DEFAULT_VALUE = Expression.INSTANCE.constant(true);
    private static final Expression<Long> LOG_LIMIT_DEFAULT_VALUE = Expression.INSTANCE.constant(1L);
    private static final Expression<Long> VISIBILITY_DURATION_DEFAULT_VALUE = Expression.INSTANCE.constant(800L);
    private static final Expression<Long> VISIBILITY_PERCENTAGE_DEFAULT_VALUE = Expression.INSTANCE.constant(50L);
    private static final Function2<ParsingEnvironment, JSONObject, DivVisibilityAction> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivVisibilityAction>() { // from class: com.yandex.div2.DivVisibilityAction$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivVisibilityAction invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivVisibilityAction.INSTANCE.fromJson(env, it);
        }
    };

    @JvmStatic
    public static final DivVisibilityAction fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivVisibilityAction(DivDownloadCallbacks divDownloadCallbacks, Expression<Boolean> isEnabled, Expression<String> logId, Expression<Long> logLimit, JSONObject jSONObject, Expression<Uri> expression, String str, DivActionTyped divActionTyped, Expression<Uri> expression2, Expression<Long> visibilityDuration, Expression<Long> visibilityPercentage) {
        Intrinsics.checkNotNullParameter(isEnabled, "isEnabled");
        Intrinsics.checkNotNullParameter(logId, "logId");
        Intrinsics.checkNotNullParameter(logLimit, "logLimit");
        Intrinsics.checkNotNullParameter(visibilityDuration, "visibilityDuration");
        Intrinsics.checkNotNullParameter(visibilityPercentage, "visibilityPercentage");
        this.downloadCallbacks = divDownloadCallbacks;
        this.isEnabled = isEnabled;
        this.logId = logId;
        this.logLimit = logLimit;
        this.payload = jSONObject;
        this.referer = expression;
        this.scopeId = str;
        this.typed = divActionTyped;
        this.url = expression2;
        this.visibilityDuration = visibilityDuration;
        this.visibilityPercentage = visibilityPercentage;
    }

    @Override // com.yandex.div2.DivSightAction
    public DivDownloadCallbacks getDownloadCallbacks() {
        return this.downloadCallbacks;
    }

    public /* synthetic */ DivVisibilityAction(DivDownloadCallbacks divDownloadCallbacks, Expression expression, Expression expression2, Expression expression3, JSONObject jSONObject, Expression expression4, String str, DivActionTyped divActionTyped, Expression expression5, Expression expression6, Expression expression7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : divDownloadCallbacks, (i & 2) != 0 ? IS_ENABLED_DEFAULT_VALUE : expression, expression2, (i & 8) != 0 ? LOG_LIMIT_DEFAULT_VALUE : expression3, (i & 16) != 0 ? null : jSONObject, (i & 32) != 0 ? null : expression4, (i & 64) != 0 ? null : str, (i & 128) != 0 ? null : divActionTyped, (i & 256) != 0 ? null : expression5, (i & 512) != 0 ? VISIBILITY_DURATION_DEFAULT_VALUE : expression6, (i & 1024) != 0 ? VISIBILITY_PERCENTAGE_DEFAULT_VALUE : expression7);
    }

    @Override // com.yandex.div2.DivSightAction
    public Expression<Boolean> isEnabled() {
        return this.isEnabled;
    }

    @Override // com.yandex.div2.DivSightAction
    public Expression<String> getLogId() {
        return this.logId;
    }

    @Override // com.yandex.div2.DivSightAction
    public Expression<Long> getLogLimit() {
        return this.logLimit;
    }

    @Override // com.yandex.div2.DivSightAction
    public JSONObject getPayload() {
        return this.payload;
    }

    @Override // com.yandex.div2.DivSightAction
    public Expression<Uri> getReferer() {
        return this.referer;
    }

    @Override // com.yandex.div2.DivSightAction
    public String getScopeId() {
        return this.scopeId;
    }

    @Override // com.yandex.div2.DivSightAction
    public DivActionTyped getTyped() {
        return this.typed;
    }

    @Override // com.yandex.div2.DivSightAction
    public Expression<Uri> getUrl() {
        return this.url;
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
        DivDownloadCallbacks downloadCallbacks = getDownloadCallbacks();
        int iHash = iHashCode + (downloadCallbacks != null ? downloadCallbacks.hash() : 0) + isEnabled().hashCode() + getLogId().hashCode() + getLogLimit().hashCode();
        JSONObject payload = getPayload();
        int iHashCode2 = iHash + (payload != null ? payload.hashCode() : 0);
        Expression<Uri> referer = getReferer();
        int iHashCode3 = iHashCode2 + (referer != null ? referer.hashCode() : 0);
        String scopeId = getScopeId();
        int iHashCode4 = iHashCode3 + (scopeId != null ? scopeId.hashCode() : 0);
        DivActionTyped typed = getTyped();
        int iHash2 = iHashCode4 + (typed != null ? typed.hash() : 0);
        Expression<Uri> url = getUrl();
        int iHashCode5 = iHash2 + (url != null ? url.hashCode() : 0) + this.visibilityDuration.hashCode() + this.visibilityPercentage.hashCode();
        this._hash = Integer.valueOf(iHashCode5);
        return iHashCode5;
    }

    public final boolean equals(DivVisibilityAction other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        boolean zEquals;
        boolean zEquals2;
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null) {
            return false;
        }
        DivDownloadCallbacks downloadCallbacks = getDownloadCallbacks();
        if (downloadCallbacks != null) {
            zEquals = downloadCallbacks.equals(other.getDownloadCallbacks(), resolver, otherResolver);
        } else {
            zEquals = other.getDownloadCallbacks() == null;
        }
        if (!zEquals || isEnabled().evaluate(resolver).booleanValue() != other.isEnabled().evaluate(otherResolver).booleanValue() || !Intrinsics.areEqual(getLogId().evaluate(resolver), other.getLogId().evaluate(otherResolver)) || getLogLimit().evaluate(resolver).longValue() != other.getLogLimit().evaluate(otherResolver).longValue() || !Intrinsics.areEqual(getPayload(), other.getPayload())) {
            return false;
        }
        Expression<Uri> referer = getReferer();
        Uri uriEvaluate = referer != null ? referer.evaluate(resolver) : null;
        Expression<Uri> referer2 = other.getReferer();
        if (!Intrinsics.areEqual(uriEvaluate, referer2 != null ? referer2.evaluate(otherResolver) : null) || !Intrinsics.areEqual(getScopeId(), other.getScopeId())) {
            return false;
        }
        DivActionTyped typed = getTyped();
        if (typed != null) {
            zEquals2 = typed.equals(other.getTyped(), resolver, otherResolver);
        } else {
            zEquals2 = other.getTyped() == null;
        }
        if (!zEquals2) {
            return false;
        }
        Expression<Uri> url = getUrl();
        Uri uriEvaluate2 = url != null ? url.evaluate(resolver) : null;
        Expression<Uri> url2 = other.getUrl();
        return Intrinsics.areEqual(uriEvaluate2, url2 != null ? url2.evaluate(otherResolver) : null) && this.visibilityDuration.evaluate(resolver).longValue() == other.visibilityDuration.evaluate(otherResolver).longValue() && this.visibilityPercentage.evaluate(resolver).longValue() == other.visibilityPercentage.evaluate(otherResolver).longValue();
    }

    public final DivVisibilityAction copy(DivDownloadCallbacks downloadCallbacks, Expression<Boolean> isEnabled, Expression<String> logId, Expression<Long> logLimit, JSONObject payload, Expression<Uri> referer, String scopeId, DivActionTyped typed, Expression<Uri> url, Expression<Long> visibilityDuration, Expression<Long> visibilityPercentage) {
        Intrinsics.checkNotNullParameter(isEnabled, "isEnabled");
        Intrinsics.checkNotNullParameter(logId, "logId");
        Intrinsics.checkNotNullParameter(logLimit, "logLimit");
        Intrinsics.checkNotNullParameter(visibilityDuration, "visibilityDuration");
        Intrinsics.checkNotNullParameter(visibilityPercentage, "visibilityPercentage");
        return new DivVisibilityAction(downloadCallbacks, isEnabled, logId, logLimit, payload, referer, scopeId, typed, url, visibilityDuration, visibilityPercentage);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivVisibilityActionJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivVisibilityAction.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u0014R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/yandex/div2/DivVisibilityAction$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivVisibilityAction;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "IS_ENABLED_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "LOG_LIMIT_DEFAULT_VALUE", "", "VISIBILITY_DURATION_DEFAULT_VALUE", "VISIBILITY_PERCENTAGE_DEFAULT_VALUE", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivVisibilityAction fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivVisibilityActionJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivVisibilityAction> getCREATOR() {
            return DivVisibilityAction.CREATOR;
        }
    }
}
