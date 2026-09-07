package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.yandex.div.core.DivActionHandler;
import com.yandex.div.core.DivViewFacade;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivAction;
import com.yandex.div2.DivSightAction;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class h20 extends DivActionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wr f9053a;
    private final i20 b;
    private final s20 c;
    private final h30 d;
    private final g30 e;

    @Override // com.yandex.div.core.DivActionHandler
    public final boolean handleAction(DivAction action, DivViewFacade view, ExpressionResolver expressionResolver) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
        if (super.handleAction(action, view, expressionResolver)) {
            return true;
        }
        Expression<Uri> expression = action.url;
        return expression != null && a(action.payload, expression.evaluate(expressionResolver), view);
    }

    public /* synthetic */ h20(Context context, o3 o3Var, o8 o8Var, wr wrVar, i20 i20Var, s20 s20Var) {
        this(context, o3Var, o8Var, wrVar, i20Var, s20Var, new h30(new hh1(context, o3Var, s62.d)), new g30(o3Var, o8Var));
    }

    public h20(Context context, o3 adConfiguration, o8<?> adResponse, wr contentCloseListener, i20 delegate, s20 clickHandler, h30 trackingUrlHandler, g30 trackAnalyticsHandler) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(contentCloseListener, "contentCloseListener");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(clickHandler, "clickHandler");
        Intrinsics.checkNotNullParameter(trackingUrlHandler, "trackingUrlHandler");
        Intrinsics.checkNotNullParameter(trackAnalyticsHandler, "trackAnalyticsHandler");
        this.f9053a = contentCloseListener;
        this.b = delegate;
        this.c = clickHandler;
        this.d = trackingUrlHandler;
        this.e = trackAnalyticsHandler;
    }

    @Override // com.yandex.div.core.DivActionHandler
    public final boolean handleAction(DivSightAction action, DivViewFacade view, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        if (super.handleAction(action, view, resolver)) {
            return true;
        }
        Expression<Uri> url = action.getUrl();
        return url != null && a(action.getPayload(), url.evaluate(resolver), view);
    }

    private final boolean a(JSONObject jSONObject, Uri uri, DivViewFacade divViewFacade) {
        if (!Intrinsics.areEqual(uri.getScheme(), "mobileads")) {
            return false;
        }
        String host = uri.getHost();
        if (host != null) {
            int iHashCode = host.hashCode();
            if (iHashCode != 94750088) {
                if (iHashCode != 866535483) {
                    if (iHashCode != 986975867) {
                        if (iHashCode == 1270469668 && host.equals("trackUrl")) {
                            this.d.a(uri);
                            return true;
                        }
                    } else if (host.equals("trackAnalytics")) {
                        this.e.a(uri, jSONObject);
                        return true;
                    }
                } else if (host.equals("closeAd")) {
                    this.f9053a.f();
                    return true;
                }
            } else if (host.equals("click")) {
                s20 s20Var = this.c;
                View view = divViewFacade.getView();
                Intrinsics.checkNotNullExpressionValue(view, "getView(...)");
                s20Var.a(uri, view);
                return true;
            }
        }
        return this.b.a(uri);
    }

    public final void a(uo uoVar) {
        this.c.a(uoVar);
    }
}
