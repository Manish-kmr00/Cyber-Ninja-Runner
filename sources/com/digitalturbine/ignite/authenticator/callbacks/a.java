package com.digitalturbine.ignite.authenticator.callbacks;

import com.digitalturbine.ignite.authenticator.events.d;
import com.digitalturbine.ignite.cl.aidl.IIgniteServiceCallback;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends IIgniteServiceCallback.Stub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.digitalturbine.ignite.authenticator.decorator.a f1225a;

    public a(com.digitalturbine.ignite.authenticator.decorator.a aVar) {
        this.f1225a = aVar;
    }

    @Override // com.digitalturbine.ignite.cl.aidl.IIgniteServiceCallback
    public final void onError(String str) {
        this.f1225a.a(str);
    }

    @Override // com.digitalturbine.ignite.cl.aidl.IIgniteServiceCallback
    public final void onProgress(String str) {
    }

    @Override // com.digitalturbine.ignite.cl.aidl.IIgniteServiceCallback
    public final void onScheduled(String str) {
    }

    @Override // com.digitalturbine.ignite.cl.aidl.IIgniteServiceCallback
    public final void onStart(String str) {
    }

    @Override // com.digitalturbine.ignite.cl.aidl.IIgniteServiceCallback
    public final void onSuccess(String str) {
        String string;
        try {
            string = new JSONObject(str).getJSONObject("data").getString("token");
        } catch (Exception e) {
            com.digitalturbine.ignite.authenticator.events.b.a(d.ONE_DT_GENERAL_ERROR, e);
            com.digitalturbine.ignite.authenticator.logger.a.b("%s : resolveClientToken : %s", "IgniteAuthenticationCallback", e.toString());
            string = null;
        }
        this.f1225a.c(string);
    }
}
