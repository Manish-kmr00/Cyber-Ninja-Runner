package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class sg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final lp1 f10204a;
    private final sr0 b;
    private final Context c;

    public sg(Context context, lp1 reporter, sr0 linkJsonParser) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(linkJsonParser, "linkJsonParser");
        this.f10204a = reporter;
        this.b = linkJsonParser;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.c = applicationContext;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final ig<?> a(JSONObject jsonAsset, wj base64EncodingParameters) throws JSONException, p61 {
        tg td1Var;
        Intrinsics.checkNotNullParameter(jsonAsset, "jsonAsset");
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        if (!h91.a(jsonAsset, "name", "type", "clickable", "required")) {
            throw new p61("Native Ad json has not required attributes");
        }
        String type = f91.a(jsonAsset, "jsonAsset", "type", "jsonAttribute", "type");
        if (type == null || type.length() == 0 || Intrinsics.areEqual(type, "null")) {
            throw new p61("Native Ad json has not required attributes");
        }
        Intrinsics.checkNotNull(type);
        Intrinsics.checkNotNullParameter(jsonAsset, "jsonAsset");
        Intrinsics.checkNotNullParameter("name", "jsonAttribute");
        String name = jsonAsset.optString("name");
        if (name == null || name.length() == 0 || Intrinsics.areEqual(name, "null")) {
            throw new p61("Native Ad json has not required attributes");
        }
        Intrinsics.checkNotNull(name);
        JSONObject jSONObjectOptJSONObject = jsonAsset.optJSONObject("link");
        rr0 rr0VarA = jSONObjectOptJSONObject == null ? null : this.b.a(jSONObjectOptJSONObject, base64EncodingParameters);
        Context context = this.c;
        lp1 reporter = this.f10204a;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        if (Intrinsics.areEqual(name, "close_button")) {
            td1Var = new sp();
        } else {
            if (!Intrinsics.areEqual(name, "feedback")) {
                switch (type.hashCode()) {
                    case -1034364087:
                        if (type.equals("number")) {
                            td1Var = new td1(new kr1());
                        }
                        break;
                    case -891985903:
                        if (type.equals("string")) {
                            td1Var = new z22();
                        }
                        break;
                    case -410956671:
                        if (type.equals("container")) {
                            td1Var = new c50();
                        }
                        break;
                    case 100313435:
                        if (type.equals("image")) {
                            td1Var = new xj0();
                        }
                        break;
                    case 103772132:
                        if (type.equals("media")) {
                            td1Var = new bx0(context, reporter, base64EncodingParameters, new kw0(h92.a(base64EncodingParameters.b())), new qe2(context, reporter, base64EncodingParameters), new mj0(), new ak0());
                        }
                        break;
                }
                op0.b(new Object[0]);
                throw new p61("Native Ad json has not required attributes");
            }
            td1Var = new ya0(new xj0());
        }
        return new ig<>(name, type, td1Var.a(jsonAsset), rr0VarA, jsonAsset.getBoolean("clickable"), jsonAsset.getBoolean("required"));
    }
}
