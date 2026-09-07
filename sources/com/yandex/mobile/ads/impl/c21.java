package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class c21 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uf1 f8562a;

    public c21(uf1 parentHtmlWebView) {
        Intrinsics.checkNotNullParameter(parentHtmlWebView, "parentHtmlWebView");
        this.f8562a = parentHtmlWebView;
    }

    public final void b(String htmlResponse) {
        Intrinsics.checkNotNullParameter(htmlResponse, "htmlResponse");
        this.f8562a.b(htmlResponse);
    }

    private final void a(String str) {
        this.f8562a.loadUrl("javascript: " + str);
        op0.e(str);
    }

    public final void a(pq0... events) {
        Intrinsics.checkNotNullParameter(events, "events");
        int i = 0;
        if (events.length == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder("fireChangeEvent({");
        int length = events.length;
        String str = "";
        while (i < length) {
            pq0 pq0Var = events[i];
            sb.append(str);
            sb.append(pq0Var.a());
            i++;
            str = ", ";
        }
        sb.append("})");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        a(z0.a(new Object[]{string}, 1, "window.mraidbridge.%s", "format(...)"));
    }

    public final void a(o21 command, String message) {
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(message, "message");
        String str = "notifyErrorEvent(" + JSONObject.quote(command.a()) + ", " + JSONObject.quote(message) + ")";
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        a(z0.a(new Object[]{str}, 1, "window.mraidbridge.%s", "format(...)"));
    }

    public final void a(o21 command) {
        Intrinsics.checkNotNullParameter(command, "command");
        String str = "nativeCallComplete(" + JSONObject.quote(command.a()) + ")";
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        a(z0.a(new Object[]{str}, 1, "window.mraidbridge.%s", "format(...)"));
    }

    public final void a() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        a(z0.a(new Object[]{"notifyReadyEvent();"}, 1, "window.mraidbridge.%s", "format(...)"));
    }
}
