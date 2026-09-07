package com.json;

import android.content.Context;
import com.json.sdk.service.Connectivity.BroadcastReceiverStrategy;
import com.json.sdk.utils.Logger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public abstract class v8 implements Cif {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private hf f4518a;

    protected v8(JSONObject jSONObject, Context context) {
        this.f4518a = a(jSONObject, context);
        Logger.i("v8", "created ConnectivityAdapter with strategy " + this.f4518a.getClass().getSimpleName());
    }

    private hf a(JSONObject jSONObject, Context context) {
        if (jSONObject.optInt(b9.i.g0) != 1 && c4.c(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return new jn(this);
        }
        return new BroadcastReceiverStrategy(this);
    }

    public JSONObject a(Context context) {
        return this.f4518a.c(context);
    }

    @Override // com.json.Cif
    public void a() {
    }

    @Override // com.json.Cif
    public void a(String str, JSONObject jSONObject) {
    }

    public void b() {
        this.f4518a.a();
    }

    public void b(Context context) {
        this.f4518a.b(context);
    }

    @Override // com.json.Cif
    public void b(String str, JSONObject jSONObject) {
    }

    public void c(Context context) {
        this.f4518a.a(context);
    }
}
