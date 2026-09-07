package com.fyber.inneractive.sdk.player;

import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes12.dex */
public final class p implements com.fyber.inneractive.sdk.player.controller.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.measurement.g f2229a;
    public boolean b = false;
    public boolean c = false;
    public boolean d = false;

    public p(com.fyber.inneractive.sdk.measurement.g gVar) {
        this.f2229a = gVar;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.p
    public final void a(com.fyber.inneractive.sdk.player.enums.b bVar) {
        IAlog.a("MeasurementHelper onPlayerStateChanged=%s mBuffering=%s mPrepared=%s", bVar, String.valueOf(this.b), String.valueOf(this.d));
        if (this.f2229a != null) {
            int i = o.f2228a[bVar.ordinal()];
            if (i == 1) {
                this.d = true;
                return;
            }
            if (i == 2) {
                if (this.d) {
                    com.fyber.inneractive.sdk.measurement.g gVar = this.f2229a;
                    if (gVar.c != null) {
                        IAlog.a("%s bufferStart", "OMVideo");
                        try {
                            gVar.c.bufferStart();
                        } catch (Throwable th) {
                            gVar.a(th);
                        }
                    }
                    this.b = true;
                    return;
                }
                return;
            }
            if (i != 3) {
                if (i == 4) {
                    com.fyber.inneractive.sdk.measurement.g gVar2 = this.f2229a;
                    if (gVar2.c != null) {
                        IAlog.a("%s pause", "OMVideo");
                        try {
                            gVar2.c.pause();
                        } catch (Throwable th2) {
                            gVar2.a(th2);
                        }
                    }
                    this.c = true;
                    return;
                }
                if (i != 5) {
                    return;
                }
                com.fyber.inneractive.sdk.measurement.g gVar3 = this.f2229a;
                if (gVar3.c != null) {
                    IAlog.a("%s complete", "OMVideo");
                    try {
                        gVar3.c.complete();
                        return;
                    } catch (Throwable th3) {
                        gVar3.a(th3);
                        return;
                    }
                }
                return;
            }
            if (this.b) {
                this.b = false;
                com.fyber.inneractive.sdk.measurement.g gVar4 = this.f2229a;
                if (gVar4.c != null) {
                    IAlog.a("%s bufferEnd", "OMVideo");
                    try {
                        gVar4.c.bufferFinish();
                        return;
                    } catch (Throwable th4) {
                        gVar4.a(th4);
                        return;
                    }
                }
                return;
            }
            if (this.c) {
                com.fyber.inneractive.sdk.measurement.g gVar5 = this.f2229a;
                if (gVar5.c != null) {
                    IAlog.a("%s resume", "OMVideo");
                    try {
                        gVar5.c.resume();
                    } catch (Throwable th5) {
                        gVar5.a(th5);
                    }
                }
                this.c = false;
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.p
    public final void a(com.fyber.inneractive.sdk.player.mediaplayer.o oVar) {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.p
    public final void c(boolean z) {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.p
    public final void d() {
    }
}
