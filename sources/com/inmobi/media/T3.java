package com.inmobi.media;

import com.smaato.sdk.richmedia.mraid.bridge.MraidJsMethods;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class T3 {
    public static final /* synthetic */ int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3199a;
    public boolean b;
    public boolean c;

    public T3() {
        JSONObject jSONObject = new JSONObject();
        try {
            C3579u3 c3579u3D = AbstractC3565t3.d();
            jSONObject.put("width", c3579u3D.f3441a);
            jSONObject.put("height", c3579u3D.b);
            jSONObject.put(MraidJsMethods.USE_CUSTOM_CLOSE, this.b);
            jSONObject.put("isModal", true);
        } catch (JSONException unused) {
            Intrinsics.checkNotNullExpressionValue("T3", "TAG");
        }
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this.f3199a = string;
    }
}
