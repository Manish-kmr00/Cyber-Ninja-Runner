package com.yandex.div2;

import android.net.Uri;
import com.json.cc;
import com.yandex.div.internal.template.Field;
import com.yandex.div.json.JSONSerializable;
import com.yandex.div.json.JsonTemplate;
import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.serialization.BuiltInParserKt;
import com.yandex.div.serialization.ParsingContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivActionSubmitTemplate.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002\u001a\u001bBQ\b\u0016\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0005\u0012\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0005\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0005¢\u0006\u0002\u0010\u000eB-\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0000\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016R\u001c\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/yandex/div2/DivActionSubmitTemplate;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/json/JsonTemplate;", "Lcom/yandex/div2/DivActionSubmit;", "containerId", "Lcom/yandex/div/internal/template/Field;", "Lcom/yandex/div/json/expressions/Expression;", "", "onFailActions", "", "Lcom/yandex/div2/DivActionTemplate;", "onSuccessActions", "request", "Lcom/yandex/div2/DivActionSubmitTemplate$RequestTemplate;", "(Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;)V", cc.o, "Lcom/yandex/div/json/ParsingEnvironment;", "parent", "topLevel", "", "json", "Lorg/json/JSONObject;", "(Lcom/yandex/div/json/ParsingEnvironment;Lcom/yandex/div2/DivActionSubmitTemplate;ZLorg/json/JSONObject;)V", "resolve", "data", "writeToJSON", "Companion", "RequestTemplate", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivActionSubmitTemplate implements JSONSerializable, JsonTemplate<DivActionSubmit> {
    public static final String TYPE = "submit";
    public final Field<Expression<String>> containerId;
    public final Field<List<DivActionTemplate>> onFailActions;
    public final Field<List<DivActionTemplate>> onSuccessActions;
    public final Field<RequestTemplate> request;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function2<ParsingEnvironment, JSONObject, DivActionSubmitTemplate> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivActionSubmitTemplate>() { // from class: com.yandex.div2.DivActionSubmitTemplate$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivActionSubmitTemplate invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return new DivActionSubmitTemplate(env, null, false, it, 6, null);
        }
    };

    public DivActionSubmitTemplate(Field<Expression<String>> containerId, Field<List<DivActionTemplate>> onFailActions, Field<List<DivActionTemplate>> onSuccessActions, Field<RequestTemplate> request) {
        Intrinsics.checkNotNullParameter(containerId, "containerId");
        Intrinsics.checkNotNullParameter(onFailActions, "onFailActions");
        Intrinsics.checkNotNullParameter(onSuccessActions, "onSuccessActions");
        Intrinsics.checkNotNullParameter(request, "request");
        this.containerId = containerId;
        this.onFailActions = onFailActions;
        this.onSuccessActions = onSuccessActions;
        this.request = request;
    }

    public /* synthetic */ DivActionSubmitTemplate(ParsingEnvironment parsingEnvironment, DivActionSubmitTemplate divActionSubmitTemplate, boolean z, JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(parsingEnvironment, (i & 2) != 0 ? null : divActionSubmitTemplate, (i & 4) != 0 ? false : z, jSONObject);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DivActionSubmitTemplate(ParsingEnvironment env, DivActionSubmitTemplate divActionSubmitTemplate, boolean z, JSONObject json) {
        this((Field<Expression<String>>) Field.INSTANCE.nullField(false), (Field<List<DivActionTemplate>>) Field.INSTANCE.nullField(false), (Field<List<DivActionTemplate>>) Field.INSTANCE.nullField(false), (Field<RequestTemplate>) Field.INSTANCE.nullField(false));
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(json, "json");
        throw new UnsupportedOperationException("Do not use this constructor directly.");
    }

    @Override // com.yandex.div.json.JsonTemplate
    public DivActionSubmit resolve(ParsingEnvironment env, JSONObject data) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        return BuiltInParserKt.getBuiltInParserComponent().getDivActionSubmitJsonTemplateResolver().getValue().resolve((ParsingContext) env, this, data);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivActionSubmitJsonTemplateParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivActionSubmitTemplate.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div2/DivActionSubmitTemplate$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivActionSubmitTemplate;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "TYPE", "", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function2<ParsingEnvironment, JSONObject, DivActionSubmitTemplate> getCREATOR() {
            return DivActionSubmitTemplate.CREATOR;
        }
    }

    /* JADX INFO: compiled from: DivActionSubmitTemplate.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002\u0019\u001aBC\b\u0016\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0005\u0012\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\u0005¢\u0006\u0002\u0010\rB-\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0000\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016R\u001c\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/yandex/div2/DivActionSubmitTemplate$RequestTemplate;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/json/JsonTemplate;", "Lcom/yandex/div2/DivActionSubmit$Request;", "headers", "Lcom/yandex/div/internal/template/Field;", "", "Lcom/yandex/div2/DivActionSubmitTemplate$RequestTemplate$HeaderTemplate;", "method", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivActionSubmit$Request$Method;", "url", "Landroid/net/Uri;", "(Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;)V", cc.o, "Lcom/yandex/div/json/ParsingEnvironment;", "parent", "topLevel", "", "json", "Lorg/json/JSONObject;", "(Lcom/yandex/div/json/ParsingEnvironment;Lcom/yandex/div2/DivActionSubmitTemplate$RequestTemplate;ZLorg/json/JSONObject;)V", "resolve", "data", "writeToJSON", "Companion", "HeaderTemplate", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class RequestTemplate implements JSONSerializable, JsonTemplate<DivActionSubmit.Request> {
        public final Field<List<HeaderTemplate>> headers;
        public final Field<Expression<DivActionSubmit.Request.Method>> method;
        public final Field<Expression<Uri>> url;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Expression<DivActionSubmit.Request.Method> METHOD_DEFAULT_VALUE = Expression.INSTANCE.constant(DivActionSubmit.Request.Method.POST);
        private static final Function2<ParsingEnvironment, JSONObject, RequestTemplate> CREATOR = new Function2<ParsingEnvironment, JSONObject, RequestTemplate>() { // from class: com.yandex.div2.DivActionSubmitTemplate$RequestTemplate$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivActionSubmitTemplate.RequestTemplate invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return new DivActionSubmitTemplate.RequestTemplate(env, null, false, it, 6, null);
            }
        };

        public RequestTemplate(Field<List<HeaderTemplate>> headers, Field<Expression<DivActionSubmit.Request.Method>> method, Field<Expression<Uri>> url) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            Intrinsics.checkNotNullParameter(method, "method");
            Intrinsics.checkNotNullParameter(url, "url");
            this.headers = headers;
            this.method = method;
            this.url = url;
        }

        public /* synthetic */ RequestTemplate(ParsingEnvironment parsingEnvironment, RequestTemplate requestTemplate, boolean z, JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(parsingEnvironment, (i & 2) != 0 ? null : requestTemplate, (i & 4) != 0 ? false : z, jSONObject);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public RequestTemplate(ParsingEnvironment env, RequestTemplate requestTemplate, boolean z, JSONObject json) {
            this(Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false));
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            throw new UnsupportedOperationException("Do not use this constructor directly.");
        }

        @Override // com.yandex.div.json.JsonTemplate
        public DivActionSubmit.Request resolve(ParsingEnvironment env, JSONObject data) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(data, "data");
            return BuiltInParserKt.getBuiltInParserComponent().getDivActionSubmitRequestJsonTemplateResolver().getValue().resolve((ParsingContext) env, this, data);
        }

        @Override // com.yandex.div.json.JSONSerializable
        public JSONObject writeToJSON() {
            return BuiltInParserKt.getBuiltInParserComponent().getDivActionSubmitRequestJsonTemplateParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
        }

        /* JADX INFO: compiled from: DivActionSubmitTemplate.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivActionSubmitTemplate$RequestTemplate$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivActionSubmitTemplate$RequestTemplate;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "METHOD_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivActionSubmit$Request$Method;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Function2<ParsingEnvironment, JSONObject, RequestTemplate> getCREATOR() {
                return RequestTemplate.CREATOR;
            }
        }

        /* JADX INFO: compiled from: DivActionSubmitTemplate.kt */
        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0015B/\b\u0016\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\u0002\u0010\tB-\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0000\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016R\u001c\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/yandex/div2/DivActionSubmitTemplate$RequestTemplate$HeaderTemplate;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/json/JsonTemplate;", "Lcom/yandex/div2/DivActionSubmit$Request$Header;", "name", "Lcom/yandex/div/internal/template/Field;", "Lcom/yandex/div/json/expressions/Expression;", "", "value", "(Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;)V", cc.o, "Lcom/yandex/div/json/ParsingEnvironment;", "parent", "topLevel", "", "json", "Lorg/json/JSONObject;", "(Lcom/yandex/div/json/ParsingEnvironment;Lcom/yandex/div2/DivActionSubmitTemplate$RequestTemplate$HeaderTemplate;ZLorg/json/JSONObject;)V", "resolve", "data", "writeToJSON", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class HeaderTemplate implements JSONSerializable, JsonTemplate<DivActionSubmit.Request.Header> {
            public final Field<Expression<String>> name;
            public final Field<Expression<String>> value;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final Function2<ParsingEnvironment, JSONObject, HeaderTemplate> CREATOR = new Function2<ParsingEnvironment, JSONObject, HeaderTemplate>() { // from class: com.yandex.div2.DivActionSubmitTemplate$RequestTemplate$HeaderTemplate$Companion$CREATOR$1
                @Override // kotlin.jvm.functions.Function2
                public final DivActionSubmitTemplate.RequestTemplate.HeaderTemplate invoke(ParsingEnvironment env, JSONObject it) {
                    Intrinsics.checkNotNullParameter(env, "env");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new DivActionSubmitTemplate.RequestTemplate.HeaderTemplate(env, null, false, it, 6, null);
                }
            };

            public HeaderTemplate(Field<Expression<String>> name, Field<Expression<String>> value) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(value, "value");
                this.name = name;
                this.value = value;
            }

            public /* synthetic */ HeaderTemplate(ParsingEnvironment parsingEnvironment, HeaderTemplate headerTemplate, boolean z, JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(parsingEnvironment, (i & 2) != 0 ? null : headerTemplate, (i & 4) != 0 ? false : z, jSONObject);
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public HeaderTemplate(ParsingEnvironment env, HeaderTemplate headerTemplate, boolean z, JSONObject json) {
                this(Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false));
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(json, "json");
                throw new UnsupportedOperationException("Do not use this constructor directly.");
            }

            @Override // com.yandex.div.json.JsonTemplate
            public DivActionSubmit.Request.Header resolve(ParsingEnvironment env, JSONObject data) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(data, "data");
                return BuiltInParserKt.getBuiltInParserComponent().getDivActionSubmitRequestHeaderJsonTemplateResolver().getValue().resolve((ParsingContext) env, this, data);
            }

            @Override // com.yandex.div.json.JSONSerializable
            public JSONObject writeToJSON() {
                return BuiltInParserKt.getBuiltInParserComponent().getDivActionSubmitRequestHeaderJsonTemplateParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
            }

            /* JADX INFO: compiled from: DivActionSubmitTemplate.kt */
            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/yandex/div2/DivActionSubmitTemplate$RequestTemplate$HeaderTemplate$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivActionSubmitTemplate$RequestTemplate$HeaderTemplate;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final Function2<ParsingEnvironment, JSONObject, HeaderTemplate> getCREATOR() {
                    return HeaderTemplate.CREATOR;
                }
            }
        }
    }
}
