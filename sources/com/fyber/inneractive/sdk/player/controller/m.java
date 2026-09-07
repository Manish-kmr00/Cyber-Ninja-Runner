package com.fyber.inneractive.sdk.player.controller;

import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Iterator;

/* JADX INFO: loaded from: classes13.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.fyber.inneractive.sdk.player.enums.b f1961a;
    public final /* synthetic */ q b;

    public m(q qVar, com.fyber.inneractive.sdk.player.enums.b bVar) {
        this.b = qVar;
        this.f1961a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        q qVar;
        try {
            try {
                Iterator it = this.b.b.iterator();
                while (it.hasNext()) {
                    ((p) it.next()).a(this.f1961a);
                }
                com.fyber.inneractive.sdk.player.enums.b bVar = this.f1961a;
                if (bVar == com.fyber.inneractive.sdk.player.enums.b.Idle || bVar == com.fyber.inneractive.sdk.player.enums.b.Error) {
                    AbstractC3256u.a(this.b.j);
                    qVar = this.b;
                    qVar.j = null;
                    qVar.k = null;
                }
            } catch (Exception e) {
                if (IAlog.f2345a <= 3) {
                    q qVar2 = this.b;
                    qVar2.getClass();
                    IAlog.a("%sonPlayerStateChanged callback threw an exception!", e, IAlog.a(qVar2));
                }
                com.fyber.inneractive.sdk.player.enums.b bVar2 = this.f1961a;
                if (bVar2 != com.fyber.inneractive.sdk.player.enums.b.Idle && bVar2 != com.fyber.inneractive.sdk.player.enums.b.Error) {
                    return;
                }
                AbstractC3256u.a(this.b.j);
                qVar = this.b;
                qVar.j = null;
            }
        } catch (Throwable th) {
            com.fyber.inneractive.sdk.player.enums.b bVar3 = this.f1961a;
            if (bVar3 == com.fyber.inneractive.sdk.player.enums.b.Idle || bVar3 == com.fyber.inneractive.sdk.player.enums.b.Error) {
                AbstractC3256u.a(this.b.j);
                q qVar3 = this.b;
                qVar3.j = null;
                qVar3.k = null;
            }
            throw th;
        }
    }
}
