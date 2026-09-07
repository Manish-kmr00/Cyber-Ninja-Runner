package com.digitalturbine.ignite.authenticator.decorator;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f1228a;
    public final /* synthetic */ e b;

    public c(e eVar, d dVar) {
        this.b = eVar;
        this.f1228a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.digitalturbine.ignite.authenticator.entities.a aVarA;
        e eVar = this.b;
        if (eVar.a()) {
            try {
                aVarA = com.digitalturbine.ignite.authenticator.parsers.a.a(new JSONObject(eVar.j.version()));
            } catch (Exception e) {
                com.digitalturbine.ignite.authenticator.events.b.a(com.digitalturbine.ignite.authenticator.events.d.ONE_DT_GENERAL_ERROR, e);
                com.digitalturbine.ignite.authenticator.logger.a.b("%s: resolveIgniteServiceVersion : unable to resolve version : %s", "IgniteAuthenticationComponent", e.toString());
                aVarA = new com.digitalturbine.ignite.authenticator.entities.a(false, "");
            }
        } else {
            aVarA = new com.digitalturbine.ignite.authenticator.entities.a(false, "");
        }
        eVar.i = aVarA;
        com.digitalturbine.ignite.authenticator.utils.concurency.c.b.post(this.f1228a);
    }
}
