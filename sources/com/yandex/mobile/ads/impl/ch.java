package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class ch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final sg f8604a;

    public final ArrayList a(JSONObject jsonNative, wj base64EncodingParameters) throws JSONException, p61 {
        Intrinsics.checkNotNullParameter(jsonNative, "jsonNative");
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = jsonNative.getJSONArray(POBNativeConstants.NATIVE_ASSETS);
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            boolean z = jSONObject.getBoolean("required");
            try {
                sg sgVar = this.f8604a;
                Intrinsics.checkNotNull(jSONObject);
                arrayList.add(sgVar.a(jSONObject, base64EncodingParameters));
            } catch (Throwable th) {
                if (z) {
                    throw th;
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ch(Context context, lp1 lp1Var, sr0 sr0Var, int i) {
        sr0Var = (i & 4) != 0 ? new sr0(lp1Var) : sr0Var;
        this(context, lp1Var, sr0Var, new sg(context, lp1Var, sr0Var));
    }

    public ch(Context context, lp1 reporter, sr0 linkJsonParser, sg assetJsonParser) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(linkJsonParser, "linkJsonParser");
        Intrinsics.checkNotNullParameter(assetJsonParser, "assetJsonParser");
        this.f8604a = assetJsonParser;
    }
}
