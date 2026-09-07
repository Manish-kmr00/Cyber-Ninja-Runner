package com.fyber.inneractive.sdk.config.cellular;

import android.content.Context;
import com.fyber.inneractive.sdk.util.a0;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f1687a;
    public final CopyOnWriteArrayList c = new CopyOnWriteArrayList();
    public a0 b = a0.UNKNOWN;

    public a(Context context) {
        this.f1687a = e.a(context);
    }

    @Override // com.fyber.inneractive.sdk.config.cellular.h
    public final void a(a0 a0Var) {
        this.b = a0Var;
        for (h hVar : this.c) {
            if (hVar != null) {
                hVar.a(this.b);
            }
        }
    }
}
