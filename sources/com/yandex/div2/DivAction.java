package com.yandex.div2;

import android.net.Uri;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.json.cc;
import com.yandex.div.data.Hashable;
import com.yandex.div.json.JSONSerializable;
import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.serialization.BuiltInParserKt;
import com.yandex.div.serialization.ParsingContext;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivAction.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0003$%&B¯\u0001\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006¢\u0006\u0002\u0010\u0018J°\u0001\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00062\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006J \u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 J\b\u0010\"\u001a\u00020\u001aH\u0016J\b\u0010#\u001a\u00020\u0010H\u0016R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/yandex/div2/DivAction;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "downloadCallbacks", "Lcom/yandex/div2/DivDownloadCallbacks;", "isEnabled", "Lcom/yandex/div/json/expressions/Expression;", "", "logId", "", "logUrl", "Landroid/net/Uri;", "menuItems", "", "Lcom/yandex/div2/DivAction$MenuItem;", "payload", "Lorg/json/JSONObject;", "referer", "scopeId", TypedValues.AttributesType.S_TARGET, "Lcom/yandex/div2/DivAction$Target;", "typed", "Lcom/yandex/div2/DivActionTyped;", "url", "(Lcom/yandex/div2/DivDownloadCallbacks;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Lorg/json/JSONObject;Lcom/yandex/div/json/expressions/Expression;Ljava/lang/String;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivActionTyped;Lcom/yandex/div/json/expressions/Expression;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Companion", "MenuItem", "Target", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivAction implements JSONSerializable, Hashable {
    private Integer _hash;
    public final DivDownloadCallbacks downloadCallbacks;
    public final Expression<Boolean> isEnabled;
    public final Expression<String> logId;
    public final Expression<Uri> logUrl;
    public final List<MenuItem> menuItems;
    public final JSONObject payload;
    public final Expression<Uri> referer;
    public final String scopeId;
    public final Expression<Target> target;
    public final DivActionTyped typed;
    public final Expression<Uri> url;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Expression<Boolean> IS_ENABLED_DEFAULT_VALUE = Expression.INSTANCE.constant(true);
    private static final Function2<ParsingEnvironment, JSONObject, DivAction> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivAction>() { // from class: com.yandex.div2.DivAction$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivAction invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivAction.INSTANCE.fromJson(env, it);
        }
    };

    @JvmStatic
    public static final DivAction fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivAction(DivDownloadCallbacks divDownloadCallbacks, Expression<Boolean> isEnabled, Expression<String> logId, Expression<Uri> expression, List<MenuItem> list, JSONObject jSONObject, Expression<Uri> expression2, String str, Expression<Target> expression3, DivActionTyped divActionTyped, Expression<Uri> expression4) {
        Intrinsics.checkNotNullParameter(isEnabled, "isEnabled");
        Intrinsics.checkNotNullParameter(logId, "logId");
        this.downloadCallbacks = divDownloadCallbacks;
        this.isEnabled = isEnabled;
        this.logId = logId;
        this.logUrl = expression;
        this.menuItems = list;
        this.payload = jSONObject;
        this.referer = expression2;
        this.scopeId = str;
        this.target = expression3;
        this.typed = divActionTyped;
        this.url = expression4;
    }

    public /* synthetic */ DivAction(DivDownloadCallbacks divDownloadCallbacks, Expression expression, Expression expression2, Expression expression3, List list, JSONObject jSONObject, Expression expression4, String str, Expression expression5, DivActionTyped divActionTyped, Expression expression6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : divDownloadCallbacks, (i & 2) != 0 ? IS_ENABLED_DEFAULT_VALUE : expression, expression2, (i & 8) != 0 ? null : expression3, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : jSONObject, (i & 64) != 0 ? null : expression4, (i & 128) != 0 ? null : str, (i & 256) != 0 ? null : expression5, (i & 512) != 0 ? null : divActionTyped, (i & 1024) != 0 ? null : expression6);
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        int iHash;
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
        DivDownloadCallbacks divDownloadCallbacks = this.downloadCallbacks;
        int iHash2 = iHashCode + (divDownloadCallbacks != null ? divDownloadCallbacks.hash() : 0) + this.isEnabled.hashCode() + this.logId.hashCode();
        Expression<Uri> expression = this.logUrl;
        int iHashCode2 = iHash2 + (expression != null ? expression.hashCode() : 0);
        List<MenuItem> list = this.menuItems;
        if (list != null) {
            Iterator<T> it = list.iterator();
            iHash = 0;
            while (it.hasNext()) {
                iHash += ((MenuItem) it.next()).hash();
            }
        } else {
            iHash = 0;
        }
        int i = iHashCode2 + iHash;
        JSONObject jSONObject = this.payload;
        int iHashCode3 = i + (jSONObject != null ? jSONObject.hashCode() : 0);
        Expression<Uri> expression2 = this.referer;
        int iHashCode4 = iHashCode3 + (expression2 != null ? expression2.hashCode() : 0);
        String str = this.scopeId;
        int iHashCode5 = iHashCode4 + (str != null ? str.hashCode() : 0);
        Expression<Target> expression3 = this.target;
        int iHashCode6 = iHashCode5 + (expression3 != null ? expression3.hashCode() : 0);
        DivActionTyped divActionTyped = this.typed;
        int iHash3 = iHashCode6 + (divActionTyped != null ? divActionTyped.hash() : 0);
        Expression<Uri> expression4 = this.url;
        int iHashCode7 = iHash3 + (expression4 != null ? expression4.hashCode() : 0);
        this._hash = Integer.valueOf(iHashCode7);
        return iHashCode7;
    }

    public final boolean equals(DivAction other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        boolean zEquals;
        boolean z;
        boolean zEquals2;
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null) {
            return false;
        }
        DivDownloadCallbacks divDownloadCallbacks = this.downloadCallbacks;
        if (divDownloadCallbacks != null) {
            zEquals = divDownloadCallbacks.equals(other.downloadCallbacks, resolver, otherResolver);
        } else {
            zEquals = other.downloadCallbacks == null;
        }
        if (!zEquals || this.isEnabled.evaluate(resolver).booleanValue() != other.isEnabled.evaluate(otherResolver).booleanValue() || !Intrinsics.areEqual(this.logId.evaluate(resolver), other.logId.evaluate(otherResolver))) {
            return false;
        }
        Expression<Uri> expression = this.logUrl;
        Uri uriEvaluate = expression != null ? expression.evaluate(resolver) : null;
        Expression<Uri> expression2 = other.logUrl;
        if (!Intrinsics.areEqual(uriEvaluate, expression2 != null ? expression2.evaluate(otherResolver) : null)) {
            return false;
        }
        List<MenuItem> list = this.menuItems;
        if (list != null) {
            List<MenuItem> list2 = other.menuItems;
            if (list2 == null) {
                return false;
            }
            if (list.size() == list2.size()) {
                Iterator<T> it = list.iterator();
                int i = 0;
                while (true) {
                    if (it.hasNext()) {
                        Object next = it.next();
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((MenuItem) next).equals(list2.get(i), resolver, otherResolver)) {
                            i = i2;
                        }
                    }
                }
            }
        } else {
            z = other.menuItems == null;
        }
        if (!z || !Intrinsics.areEqual(this.payload, other.payload)) {
            return false;
        }
        Expression<Uri> expression3 = this.referer;
        Uri uriEvaluate2 = expression3 != null ? expression3.evaluate(resolver) : null;
        Expression<Uri> expression4 = other.referer;
        if (!Intrinsics.areEqual(uriEvaluate2, expression4 != null ? expression4.evaluate(otherResolver) : null) || !Intrinsics.areEqual(this.scopeId, other.scopeId)) {
            return false;
        }
        Expression<Target> expression5 = this.target;
        Target targetEvaluate = expression5 != null ? expression5.evaluate(resolver) : null;
        Expression<Target> expression6 = other.target;
        if (targetEvaluate != (expression6 != null ? expression6.evaluate(otherResolver) : null)) {
            return false;
        }
        DivActionTyped divActionTyped = this.typed;
        if (divActionTyped != null) {
            zEquals2 = divActionTyped.equals(other.typed, resolver, otherResolver);
        } else {
            zEquals2 = other.typed == null;
        }
        if (!zEquals2) {
            return false;
        }
        Expression<Uri> expression7 = this.url;
        Uri uriEvaluate3 = expression7 != null ? expression7.evaluate(resolver) : null;
        Expression<Uri> expression8 = other.url;
        return Intrinsics.areEqual(uriEvaluate3, expression8 != null ? expression8.evaluate(otherResolver) : null);
    }

    public final DivAction copy(DivDownloadCallbacks downloadCallbacks, Expression<Boolean> isEnabled, Expression<String> logId, Expression<Uri> logUrl, List<MenuItem> menuItems, JSONObject payload, Expression<Uri> referer, String scopeId, Expression<Target> target, DivActionTyped typed, Expression<Uri> url) {
        Intrinsics.checkNotNullParameter(isEnabled, "isEnabled");
        Intrinsics.checkNotNullParameter(logId, "logId");
        return new DivAction(downloadCallbacks, isEnabled, logId, logUrl, menuItems, payload, referer, scopeId, target, typed, url);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivActionJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivAction.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u0010R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/yandex/div2/DivAction$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivAction;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "IS_ENABLED_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivAction fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivActionJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivAction> getCREATOR() {
            return DivAction.CREATOR;
        }
    }

    /* JADX INFO: compiled from: DivAction.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0018B3\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ4\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ \u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J\b\u0010\u0015\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/yandex/div2/DivAction$MenuItem;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "action", "Lcom/yandex/div2/DivAction;", "actions", "", "text", "Lcom/yandex/div/json/expressions/Expression;", "", "(Lcom/yandex/div2/DivAction;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class MenuItem implements JSONSerializable, Hashable {
        private Integer _hash;
        public final DivAction action;
        public final List<DivAction> actions;
        public final Expression<String> text;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Function2<ParsingEnvironment, JSONObject, MenuItem> CREATOR = new Function2<ParsingEnvironment, JSONObject, MenuItem>() { // from class: com.yandex.div2.DivAction$MenuItem$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivAction.MenuItem invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return DivAction.MenuItem.INSTANCE.fromJson(env, it);
            }
        };

        @JvmStatic
        public static final MenuItem fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
            return INSTANCE.fromJson(parsingEnvironment, jSONObject);
        }

        public MenuItem(DivAction divAction, List<DivAction> list, Expression<String> text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.action = divAction;
            this.actions = list;
            this.text = text;
        }

        public /* synthetic */ MenuItem(DivAction divAction, List list, Expression expression, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : divAction, (i & 2) != 0 ? null : list, expression);
        }

        @Override // com.yandex.div.data.Hashable
        public int hash() {
            Integer num = this._hash;
            if (num != null) {
                return num.intValue();
            }
            int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
            DivAction divAction = this.action;
            int iHash = 0;
            int iHash2 = iHashCode + (divAction != null ? divAction.hash() : 0);
            List<DivAction> list = this.actions;
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    iHash += ((DivAction) it.next()).hash();
                }
            }
            int iHashCode2 = iHash2 + iHash + this.text.hashCode();
            this._hash = Integer.valueOf(iHashCode2);
            return iHashCode2;
        }

        public final boolean equals(MenuItem other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
            boolean zEquals;
            boolean z;
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
            if (other == null) {
                return false;
            }
            DivAction divAction = this.action;
            if (divAction != null) {
                zEquals = divAction.equals(other.action, resolver, otherResolver);
            } else {
                zEquals = other.action == null;
            }
            if (!zEquals) {
                return false;
            }
            List<DivAction> list = this.actions;
            if (list != null) {
                List<DivAction> list2 = other.actions;
                if (list2 == null) {
                    return false;
                }
                if (list.size() == list2.size()) {
                    Iterator<T> it = list.iterator();
                    int i = 0;
                    while (true) {
                        if (it.hasNext()) {
                            Object next = it.next();
                            int i2 = i + 1;
                            if (i < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            if (((DivAction) next).equals(list2.get(i), resolver, otherResolver)) {
                                i = i2;
                            }
                        }
                    }
                }
            } else {
                z = other.actions == null;
            }
            return z && Intrinsics.areEqual(this.text.evaluate(resolver), other.text.evaluate(otherResolver));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MenuItem copy$default(MenuItem menuItem, DivAction divAction, List list, Expression expression, int i, Object obj) {
            if ((i & 1) != 0) {
                divAction = menuItem.action;
            }
            if ((i & 2) != 0) {
                list = menuItem.actions;
            }
            if ((i & 4) != 0) {
                expression = menuItem.text;
            }
            return menuItem.copy(divAction, list, expression);
        }

        public final MenuItem copy(DivAction action, List<DivAction> actions, Expression<String> text) {
            Intrinsics.checkNotNullParameter(text, "text");
            return new MenuItem(action, actions, text);
        }

        @Override // com.yandex.div.json.JSONSerializable
        public JSONObject writeToJSON() {
            return BuiltInParserKt.getBuiltInParserComponent().getDivActionMenuItemJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
        }

        /* JADX INFO: compiled from: DivAction.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\rR#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivAction$MenuItem$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivAction$MenuItem;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final MenuItem fromJson(ParsingEnvironment env, JSONObject json) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(json, "json");
                return BuiltInParserKt.getBuiltInParserComponent().getDivActionMenuItemJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
            }

            public final Function2<ParsingEnvironment, JSONObject, MenuItem> getCREATOR() {
                return MenuItem.CREATOR;
            }
        }
    }

    /* JADX INFO: compiled from: DivAction.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/yandex/div2/DivAction$Target;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "SELF", "BLANK", "Converter", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum Target {
        SELF("_self"),
        BLANK("_blank");

        private final String value;

        /* JADX INFO: renamed from: Converter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final Function1<Target, String> TO_STRING = new Function1<Target, String>() { // from class: com.yandex.div2.DivAction$Target$Converter$TO_STRING$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(DivAction.Target value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return DivAction.Target.INSTANCE.toString(value);
            }
        };
        public static final Function1<String, Target> FROM_STRING = new Function1<String, Target>() { // from class: com.yandex.div2.DivAction$Target$Converter$FROM_STRING$1
            @Override // kotlin.jvm.functions.Function1
            public final DivAction.Target invoke(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return DivAction.Target.INSTANCE.fromString(value);
            }
        };

        Target(String str) {
            this.value = str;
        }

        /* JADX INFO: renamed from: com.yandex.div2.DivAction$Target$Converter, reason: from kotlin metadata */
        /* JADX INFO: compiled from: DivAction.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0006R\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div2/DivAction$Target$Converter;", "", "()V", "FROM_STRING", "Lkotlin/Function1;", "", "Lcom/yandex/div2/DivAction$Target;", "TO_STRING", "fromString", "value", "toString", "obj", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final String toString(Target obj) {
                Intrinsics.checkNotNullParameter(obj, "obj");
                return obj.value;
            }

            public final Target fromString(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                if (Intrinsics.areEqual(value, Target.SELF.value)) {
                    return Target.SELF;
                }
                if (Intrinsics.areEqual(value, Target.BLANK.value)) {
                    return Target.BLANK;
                }
                return null;
            }
        }
    }
}
