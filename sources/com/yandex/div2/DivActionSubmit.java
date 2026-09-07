package com.yandex.div2;

import android.net.Uri;
import com.android.volley.toolbox.HttpClientStack;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.json.cc;
import com.safedk.android.a.g;
import com.yandex.div.core.DivActionHandler;
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

/* JADX INFO: compiled from: DivActionSubmit.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0002\u001a\u001bBA\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJD\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bJ \u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/yandex/div2/DivActionSubmit;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "containerId", "Lcom/yandex/div/json/expressions/Expression;", "", "onFailActions", "", "Lcom/yandex/div2/DivAction;", "onSuccessActions", "request", "Lcom/yandex/div2/DivActionSubmit$Request;", "(Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Ljava/util/List;Lcom/yandex/div2/DivActionSubmit$Request;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "Request", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivActionSubmit implements JSONSerializable, Hashable {
    public static final String TYPE = "submit";
    private Integer _hash;
    public final Expression<String> containerId;
    public final List<DivAction> onFailActions;
    public final List<DivAction> onSuccessActions;
    public final Request request;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function2<ParsingEnvironment, JSONObject, DivActionSubmit> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivActionSubmit>() { // from class: com.yandex.div2.DivActionSubmit$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivActionSubmit invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivActionSubmit.INSTANCE.fromJson(env, it);
        }
    };

    @JvmStatic
    public static final DivActionSubmit fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivActionSubmit(Expression<String> containerId, List<DivAction> list, List<DivAction> list2, Request request) {
        Intrinsics.checkNotNullParameter(containerId, "containerId");
        Intrinsics.checkNotNullParameter(request, "request");
        this.containerId = containerId;
        this.onFailActions = list;
        this.onSuccessActions = list2;
        this.request = request;
    }

    public /* synthetic */ DivActionSubmit(Expression expression, List list, List list2, Request request, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(expression, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : list2, request);
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        int iHash;
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + this.containerId.hashCode();
        List<DivAction> list = this.onFailActions;
        int iHash2 = 0;
        if (list != null) {
            Iterator<T> it = list.iterator();
            iHash = 0;
            while (it.hasNext()) {
                iHash += ((DivAction) it.next()).hash();
            }
        } else {
            iHash = 0;
        }
        int i = iHashCode + iHash;
        List<DivAction> list2 = this.onSuccessActions;
        if (list2 != null) {
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                iHash2 += ((DivAction) it2.next()).hash();
            }
        }
        int iHash3 = i + iHash2 + this.request.hash();
        this._hash = Integer.valueOf(iHash3);
        return iHash3;
    }

    public final boolean equals(DivActionSubmit other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null || !Intrinsics.areEqual(this.containerId.evaluate(resolver), other.containerId.evaluate(otherResolver))) {
            return false;
        }
        List<DivAction> list = this.onFailActions;
        if (list != null) {
            List<DivAction> list2 = other.onFailActions;
            if (list2 == null || list.size() != list2.size()) {
                return false;
            }
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (!((DivAction) obj).equals(list2.get(i), resolver, otherResolver)) {
                    return false;
                }
                i = i2;
            }
        } else if (other.onFailActions != null) {
            return false;
        }
        List<DivAction> list3 = this.onSuccessActions;
        if (list3 != null) {
            List<DivAction> list4 = other.onSuccessActions;
            if (list4 == null || list3.size() != list4.size()) {
                return false;
            }
            int i3 = 0;
            for (Object obj2 : list3) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (!((DivAction) obj2).equals(list4.get(i3), resolver, otherResolver)) {
                    return false;
                }
                i3 = i4;
            }
        } else if (other.onSuccessActions != null) {
            return false;
        }
        return this.request.equals(other.request, resolver, otherResolver);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivActionSubmit copy$default(DivActionSubmit divActionSubmit, Expression expression, List list, List list2, Request request, int i, Object obj) {
        if ((i & 1) != 0) {
            expression = divActionSubmit.containerId;
        }
        if ((i & 2) != 0) {
            list = divActionSubmit.onFailActions;
        }
        if ((i & 4) != 0) {
            list2 = divActionSubmit.onSuccessActions;
        }
        if ((i & 8) != 0) {
            request = divActionSubmit.request;
        }
        return divActionSubmit.copy(expression, list, list2, request);
    }

    public final DivActionSubmit copy(Expression<String> containerId, List<DivAction> onFailActions, List<DivAction> onSuccessActions, Request request) {
        Intrinsics.checkNotNullParameter(containerId, "containerId");
        Intrinsics.checkNotNullParameter(request, "request");
        return new DivActionSubmit(containerId, onFailActions, onSuccessActions, request);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivActionSubmitJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivActionSubmit.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u000fR#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/yandex/div2/DivActionSubmit$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivActionSubmit;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "TYPE", "", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivActionSubmit fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivActionSubmitJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivActionSubmit> getCREATOR() {
            return DivActionSubmit.CREATOR;
        }
    }

    /* JADX INFO: compiled from: DivActionSubmit.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0003\u0019\u001a\u001bB7\b\u0007\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\u0010\u000bJ8\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007J \u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\b\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0018\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/yandex/div2/DivActionSubmit$Request;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "headers", "", "Lcom/yandex/div2/DivActionSubmit$Request$Header;", "method", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivActionSubmit$Request$Method;", "url", "Landroid/net/Uri;", "(Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "Header", "Method", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Request implements JSONSerializable, Hashable {
        private Integer _hash;
        public final List<Header> headers;
        public final Expression<Method> method;
        public final Expression<Uri> url;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Expression<Method> METHOD_DEFAULT_VALUE = Expression.INSTANCE.constant(Method.POST);
        private static final Function2<ParsingEnvironment, JSONObject, Request> CREATOR = new Function2<ParsingEnvironment, JSONObject, Request>() { // from class: com.yandex.div2.DivActionSubmit$Request$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivActionSubmit.Request invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return DivActionSubmit.Request.INSTANCE.fromJson(env, it);
            }
        };

        @JvmStatic
        public static final Request fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
            return INSTANCE.fromJson(parsingEnvironment, jSONObject);
        }

        public Request(List<Header> list, Expression<Method> method, Expression<Uri> url) {
            Intrinsics.checkNotNullParameter(method, "method");
            Intrinsics.checkNotNullParameter(url, "url");
            this.headers = list;
            this.method = method;
            this.url = url;
        }

        public /* synthetic */ Request(List list, Expression expression, Expression expression2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list, (i & 2) != 0 ? METHOD_DEFAULT_VALUE : expression, expression2);
        }

        @Override // com.yandex.div.data.Hashable
        public int hash() {
            Integer num = this._hash;
            if (num != null) {
                return num.intValue();
            }
            int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
            List<Header> list = this.headers;
            int iHash = 0;
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    iHash += ((Header) it.next()).hash();
                }
            }
            int iHashCode2 = iHashCode + iHash + this.method.hashCode() + this.url.hashCode();
            this._hash = Integer.valueOf(iHashCode2);
            return iHashCode2;
        }

        public final boolean equals(Request other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
            if (other == null) {
                return false;
            }
            List<Header> list = this.headers;
            if (list != null) {
                List<Header> list2 = other.headers;
                if (list2 == null || list.size() != list2.size()) {
                    return false;
                }
                int i = 0;
                for (Object obj : list) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    if (!((Header) obj).equals(list2.get(i), resolver, otherResolver)) {
                        return false;
                    }
                    i = i2;
                }
            } else if (other.headers != null) {
                return false;
            }
            return this.method.evaluate(resolver) == other.method.evaluate(otherResolver) && Intrinsics.areEqual(this.url.evaluate(resolver), other.url.evaluate(otherResolver));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Request copy$default(Request request, List list, Expression expression, Expression expression2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = request.headers;
            }
            if ((i & 2) != 0) {
                expression = request.method;
            }
            if ((i & 4) != 0) {
                expression2 = request.url;
            }
            return request.copy(list, expression, expression2);
        }

        public final Request copy(List<Header> headers, Expression<Method> method, Expression<Uri> url) {
            Intrinsics.checkNotNullParameter(method, "method");
            Intrinsics.checkNotNullParameter(url, "url");
            return new Request(headers, method, url);
        }

        @Override // com.yandex.div.json.JSONSerializable
        public JSONObject writeToJSON() {
            return BuiltInParserKt.getBuiltInParserComponent().getDivActionSubmitRequestJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
        }

        /* JADX INFO: compiled from: DivActionSubmit.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u0010R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/yandex/div2/DivActionSubmit$Request$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivActionSubmit$Request;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "METHOD_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivActionSubmit$Request$Method;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Request fromJson(ParsingEnvironment env, JSONObject json) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(json, "json");
                return BuiltInParserKt.getBuiltInParserComponent().getDivActionSubmitRequestJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
            }

            public final Function2<ParsingEnvironment, JSONObject, Request> getCREATOR() {
                return Request.CREATOR;
            }
        }

        /* JADX INFO: compiled from: DivActionSubmit.kt */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u0015B#\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0007J&\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J \u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J\b\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/yandex/div2/DivActionSubmit$Request$Header;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "name", "Lcom/yandex/div/json/expressions/Expression;", "", "value", "(Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Header implements JSONSerializable, Hashable {
            private Integer _hash;
            public final Expression<String> name;
            public final Expression<String> value;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final Function2<ParsingEnvironment, JSONObject, Header> CREATOR = new Function2<ParsingEnvironment, JSONObject, Header>() { // from class: com.yandex.div2.DivActionSubmit$Request$Header$Companion$CREATOR$1
                @Override // kotlin.jvm.functions.Function2
                public final DivActionSubmit.Request.Header invoke(ParsingEnvironment env, JSONObject it) {
                    Intrinsics.checkNotNullParameter(env, "env");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return DivActionSubmit.Request.Header.INSTANCE.fromJson(env, it);
                }
            };

            @JvmStatic
            public static final Header fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
                return INSTANCE.fromJson(parsingEnvironment, jSONObject);
            }

            public Header(Expression<String> name, Expression<String> value) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(value, "value");
                this.name = name;
                this.value = value;
            }

            @Override // com.yandex.div.data.Hashable
            public int hash() {
                Integer num = this._hash;
                if (num != null) {
                    return num.intValue();
                }
                int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + this.name.hashCode() + this.value.hashCode();
                this._hash = Integer.valueOf(iHashCode);
                return iHashCode;
            }

            public final boolean equals(Header other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
                Intrinsics.checkNotNullParameter(resolver, "resolver");
                Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
                return other != null && Intrinsics.areEqual(this.name.evaluate(resolver), other.name.evaluate(otherResolver)) && Intrinsics.areEqual(this.value.evaluate(resolver), other.value.evaluate(otherResolver));
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Header copy$default(Header header, Expression expression, Expression expression2, int i, Object obj) {
                if ((i & 1) != 0) {
                    expression = header.name;
                }
                if ((i & 2) != 0) {
                    expression2 = header.value;
                }
                return header.copy(expression, expression2);
            }

            public final Header copy(Expression<String> name, Expression<String> value) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(value, "value");
                return new Header(name, value);
            }

            @Override // com.yandex.div.json.JSONSerializable
            public JSONObject writeToJSON() {
                return BuiltInParserKt.getBuiltInParserComponent().getDivActionSubmitRequestHeaderJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
            }

            /* JADX INFO: compiled from: DivActionSubmit.kt */
            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\rR#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivActionSubmit$Request$Header$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivActionSubmit$Request$Header;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                @JvmStatic
                public final Header fromJson(ParsingEnvironment env, JSONObject json) {
                    Intrinsics.checkNotNullParameter(env, "env");
                    Intrinsics.checkNotNullParameter(json, "json");
                    return BuiltInParserKt.getBuiltInParserComponent().getDivActionSubmitRequestHeaderJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
                }

                public final Function2<ParsingEnvironment, JSONObject, Header> getCREATOR() {
                    return Header.CREATOR;
                }
            }
        }

        /* JADX INFO: compiled from: DivActionSubmit.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivActionSubmit$Request$Method;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "GET", "POST", g.f, HttpClientStack.HttpPatch.METHOD_NAME, "DELETE", "HEAD", "OPTIONS", "Converter", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public enum Method {
            GET("get"),
            POST("post"),
            PUT("put"),
            PATCH(DivActionHandler.DivActionReason.PATCH),
            DELETE("delete"),
            HEAD("head"),
            OPTIONS(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);

            private final String value;

            /* JADX INFO: renamed from: Converter, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            public static final Function1<Method, String> TO_STRING = new Function1<Method, String>() { // from class: com.yandex.div2.DivActionSubmit$Request$Method$Converter$TO_STRING$1
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(DivActionSubmit.Request.Method value) {
                    Intrinsics.checkNotNullParameter(value, "value");
                    return DivActionSubmit.Request.Method.INSTANCE.toString(value);
                }
            };
            public static final Function1<String, Method> FROM_STRING = new Function1<String, Method>() { // from class: com.yandex.div2.DivActionSubmit$Request$Method$Converter$FROM_STRING$1
                @Override // kotlin.jvm.functions.Function1
                public final DivActionSubmit.Request.Method invoke(String value) {
                    Intrinsics.checkNotNullParameter(value, "value");
                    return DivActionSubmit.Request.Method.INSTANCE.fromString(value);
                }
            };

            Method(String str) {
                this.value = str;
            }

            /* JADX INFO: renamed from: com.yandex.div2.DivActionSubmit$Request$Method$Converter, reason: from kotlin metadata */
            /* JADX INFO: compiled from: DivActionSubmit.kt */
            @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0006R\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div2/DivActionSubmit$Request$Method$Converter;", "", "()V", "FROM_STRING", "Lkotlin/Function1;", "", "Lcom/yandex/div2/DivActionSubmit$Request$Method;", "TO_STRING", "fromString", "value", "toString", "obj", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final String toString(Method obj) {
                    Intrinsics.checkNotNullParameter(obj, "obj");
                    return obj.value;
                }

                public final Method fromString(String value) {
                    Intrinsics.checkNotNullParameter(value, "value");
                    if (Intrinsics.areEqual(value, Method.GET.value)) {
                        return Method.GET;
                    }
                    if (Intrinsics.areEqual(value, Method.POST.value)) {
                        return Method.POST;
                    }
                    if (Intrinsics.areEqual(value, Method.PUT.value)) {
                        return Method.PUT;
                    }
                    if (Intrinsics.areEqual(value, Method.PATCH.value)) {
                        return Method.PATCH;
                    }
                    if (Intrinsics.areEqual(value, Method.DELETE.value)) {
                        return Method.DELETE;
                    }
                    if (Intrinsics.areEqual(value, Method.HEAD.value)) {
                        return Method.HEAD;
                    }
                    if (Intrinsics.areEqual(value, Method.OPTIONS.value)) {
                        return Method.OPTIONS;
                    }
                    return null;
                }
            }
        }
    }
}
