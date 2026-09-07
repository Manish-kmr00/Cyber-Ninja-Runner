package com.yandex.mobile.ads.impl;

import com.yandex.div.data.DivParsingEnvironment;
import com.yandex.div.json.ParsingErrorLogger;
import com.yandex.div.json.templates.CachingTemplateProvider;
import com.yandex.div2.DivData;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class c20 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final lp1 f8561a;
    private final i30 b;
    private final d20 c;

    public final DivData a(JSONObject card, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(card, "card");
        CachingTemplateProvider cachingTemplateProvider = null;
        byte b = 0;
        try {
            i30 i30Var = this.b;
            ParsingErrorLogger logger = ParsingErrorLogger.LOG;
            Intrinsics.checkNotNullExpressionValue(logger, "LOG");
            i30Var.getClass();
            Intrinsics.checkNotNullParameter(logger, "logger");
            DivParsingEnvironment environment = new DivParsingEnvironment(logger, cachingTemplateProvider, 2, b == true ? 1 : 0);
            if (jSONObject != null) {
                environment.parseTemplates(jSONObject);
            }
            this.c.getClass();
            Intrinsics.checkNotNullParameter(environment, "environment");
            Intrinsics.checkNotNullParameter(card, "card");
            return DivData.INSTANCE.fromJson(environment, card);
        } catch (Throwable th) {
            this.f8561a.reportError("Failed to create DivData", th);
            return null;
        }
    }

    public /* synthetic */ c20(lp1 lp1Var) {
        this(lp1Var, new i30(), new d20());
    }

    public c20(lp1 reporter, i30 divParsingEnvironmentFactory, d20 divDataFactory) {
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(divParsingEnvironmentFactory, "divParsingEnvironmentFactory");
        Intrinsics.checkNotNullParameter(divDataFactory, "divDataFactory");
        this.f8561a = reporter;
        this.b = divParsingEnvironmentFactory;
        this.c = divDataFactory;
    }
}
