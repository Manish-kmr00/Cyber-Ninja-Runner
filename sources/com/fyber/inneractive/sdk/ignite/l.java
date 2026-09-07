package com.fyber.inneractive.sdk.ignite;

import android.content.Context;
import com.digitalturbine.ignite.authenticator.IgniteManager;

/* JADX INFO: loaded from: classes11.dex */
public final class l extends IgniteManager {
    public l(Context context, k kVar, com.fyber.inneractive.sdk.ignite.events.wrappers.a aVar, boolean z, boolean z2, boolean z3, h hVar) {
        super(kVar, aVar);
        com.digitalturbine.ignite.authenticator.decorator.e eVar = new com.digitalturbine.ignite.authenticator.decorator.e(context);
        this.f1221a = (z && z2) ? new com.digitalturbine.ignite.authenticator.decorator.h(new com.digitalturbine.ignite.authenticator.decorator.g(eVar, hVar), true, z3, hVar, this) : z ? new com.digitalturbine.ignite.authenticator.decorator.h(eVar, false, z3, hVar, this) : z2 ? new com.digitalturbine.ignite.authenticator.decorator.g(eVar, hVar) : new com.digitalturbine.ignite.authenticator.decorator.i(eVar, hVar);
    }
}
