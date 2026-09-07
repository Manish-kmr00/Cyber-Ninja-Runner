package com.digitalturbine.ignite.authenticator.handlers;

import com.digitalturbine.ignite.authenticator.callbacks.b;
import com.digitalturbine.ignite.authenticator.decorator.h;
import com.digitalturbine.ignite.cl.aidl.IIgniteServiceAPI;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f1234a;
    public b b = new b(this);
    public IIgniteServiceAPI c;

    public a(IIgniteServiceAPI iIgniteServiceAPI, h hVar) {
        this.f1234a = hVar;
        this.c = iIgniteServiceAPI;
    }
}
