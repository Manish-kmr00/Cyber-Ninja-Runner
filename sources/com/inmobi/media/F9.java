package com.inmobi.media;

import android.content.Context;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class F9 extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final F9 f3071a = new F9();

    public F9() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        G9.f3081a.getClass();
        Context contextD = C3517pb.d();
        JSONObject jSONObject = null;
        if (contextD != null) {
            if (G9.c == null) {
                G9.c = new A9(contextD, "pub_signals_store");
            }
            A9 a9 = G9.c;
            if (a9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prefDao");
                a9 = null;
            }
            String strA = a9.a("saved_signals");
            if (strA != null) {
                jSONObject = new JSONObject(strA);
            }
        }
        return jSONObject == null ? new JSONObject() : jSONObject;
    }
}
