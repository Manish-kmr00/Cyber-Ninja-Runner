package com.fyber.inneractive.sdk.player.controller;

import android.media.AudioManager;
import com.fyber.inneractive.sdk.config.C3082l;
import com.fyber.inneractive.sdk.config.C3085o;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.T;
import com.fyber.inneractive.sdk.config.U;
import com.fyber.inneractive.sdk.config.V;
import com.fyber.inneractive.sdk.config.enums.Skip;
import com.fyber.inneractive.sdk.config.enums.TapAction;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.player.enums.VideoClickOrigin;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.h0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes13.dex */
public final class g extends z implements com.fyber.inneractive.sdk.flow.storepromo.loader.b {
    public final boolean A;
    public final boolean y;
    public boolean z;

    public g(com.fyber.inneractive.sdk.player.f fVar, com.fyber.inneractive.sdk.player.ui.i iVar, U u, com.fyber.inneractive.sdk.config.global.r rVar, boolean z, boolean z2, String str) {
        com.fyber.inneractive.sdk.flow.storepromo.b bVar;
        super(fVar, iVar, u, rVar, z, str);
        this.y = false;
        this.z = false;
        com.fyber.inneractive.sdk.player.f fVar2 = this.f1971a;
        if (fVar2 != null && (bVar = ((com.fyber.inneractive.sdk.player.n) fVar2).v) != null) {
            bVar.e = this;
        }
        this.y = false;
        this.A = z2;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z, com.fyber.inneractive.sdk.player.ui.n
    public final void a() {
        if (!this.h) {
            e();
            return;
        }
        if (this.d.h()) {
            return;
        }
        this.d.a(false);
        Runnable runnable = this.j;
        if (runnable != null) {
            this.d.removeCallbacks(runnable);
            this.j = null;
        }
        y();
        x();
        this.k = false;
        this.h = true;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z, com.fyber.inneractive.sdk.player.controller.InterfaceC3151b
    public final void b(boolean z) {
        super.b(z);
        if (this.y) {
            this.d.m();
            this.d.g(false);
            this.f = 0;
        }
        w();
        this.d.e(false);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void e() {
        int ringerMode;
        int streamVolume;
        q qVar;
        super.e();
        com.fyber.inneractive.sdk.player.f fVar = this.f1971a;
        if (fVar != null && fVar.f2210a != null && !this.z) {
            try {
                AudioManager audioManager = (AudioManager) this.d.getContext().getSystemService("audio");
                ringerMode = audioManager.getRingerMode();
                try {
                    streamVolume = audioManager.getStreamVolume(2);
                } catch (Throwable unused) {
                    streamVolume = 0;
                }
            } catch (Throwable unused2) {
                ringerMode = 0;
            }
            if ((!this.y && ((T) this.b).f.d.booleanValue()) || this.A || m()) {
                e(false);
            } else if (streamVolume > 0 && ringerMode == 2) {
                IAlog.a("%s setting default volume. unmuting player", IAlog.a(this));
                com.fyber.inneractive.sdk.player.f fVar2 = this.f1971a;
                if (fVar2 != null && (qVar = fVar2.f2210a) != null) {
                    qVar.d(false);
                }
                this.d.setMuteButtonState(false);
            }
            this.d.setMuteButtonState(m());
            this.z = true;
        }
        g(false);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final int h() {
        return IAConfigManager.O.u.b.a("VideoFullscreenBufferingTimeout", 12, 1) * 1000;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x002b  */
    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final int l() {
        com.fyber.inneractive.sdk.config.global.features.c cVar;
        int iIntValue;
        int i;
        V v;
        com.fyber.inneractive.sdk.config.global.r rVar = this.c;
        if (rVar != null) {
            com.fyber.inneractive.sdk.config.global.features.c cVar2 = (com.fyber.inneractive.sdk.config.global.features.c) rVar.a(com.fyber.inneractive.sdk.config.global.features.c.class);
            cVar2.getClass();
            if (new ArrayList(cVar2.c.values()).size() > 0) {
                cVar = (com.fyber.inneractive.sdk.config.global.features.c) this.c.a(com.fyber.inneractive.sdk.config.global.features.c.class);
            } else {
                cVar = null;
            }
        } else {
            cVar = null;
        }
        if (cVar != null) {
            Integer numA = cVar.a("skip_time_sec");
            iIntValue = numA != null ? numA.intValue() : 5;
            if (iIntValue < 0 || iIntValue > 8) {
                iIntValue = 5;
            }
        } else {
            iIntValue = -1;
        }
        C3085o c3085o = IAConfigManager.O.u.b;
        U u = this.b;
        Skip skip = this.w;
        boolean zIsCurrentUserAChild = InneractiveAdManager.isCurrentUserAChild();
        C3082l c3082lA = c3085o.a("vast_configuration");
        c3082lA.getClass();
        try {
            i = c3082lA.f1711a.containsKey("skip_d") ? Integer.parseInt((String) c3082lA.f1711a.get("skip_d")) : -1;
        } catch (Exception unused) {
        }
        int iMax = Math.max(i, -1);
        if (skip == null && u != null && (v = ((T) u).f) != null) {
            skip = v.h;
        }
        if (zIsCurrentUserAChild) {
            if (iIntValue > -1 && iIntValue <= 8) {
                return iIntValue;
            }
            if (iMax <= -1 || iMax > 8) {
                int iIntValue2 = skip.value().intValue();
                if (iIntValue2 <= -1 || iIntValue2 > 8) {
                    return 5;
                }
                return skip.value().intValue();
            }
        } else if (iMax <= -1 || iMax > 5) {
            if (skip == Skip.DEFAULT) {
                return 99999;
            }
            return skip.value().intValue();
        }
        return iMax;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void n() {
        this.r = true;
        IAlog.a("%s onBufferingTimeout reached. Skipping to end card", IAlog.a(this));
        f(false);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void o() {
        F f = this.g;
        if (f != null) {
            f.i();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void q() {
        this.d.g(true);
        w();
        g();
        e();
        g(true);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void s() {
        super.s();
        if (this.y) {
            this.d.m();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final boolean v() {
        return !this.y;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void y() {
        q qVar;
        super.y();
        com.fyber.inneractive.sdk.player.f fVar = this.f1971a;
        if (fVar == null || (qVar = fVar.f2210a) == null || qVar.e != com.fyber.inneractive.sdk.player.enums.b.Completed || !this.y) {
            return;
        }
        this.d.m();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z, com.fyber.inneractive.sdk.player.ui.n
    public final void a(boolean z) {
        q qVar;
        com.fyber.inneractive.sdk.player.f fVar = this.f1971a;
        if (fVar != null && (qVar = fVar.f2210a) != null) {
            com.fyber.inneractive.sdk.player.enums.b bVar = qVar.e;
            if (z && bVar != com.fyber.inneractive.sdk.player.enums.b.Completed && !this.d.h()) {
                g(false);
            } else if (!z && bVar == com.fyber.inneractive.sdk.player.enums.b.Paused && this.d.h()) {
                int iB = qVar.b();
                int iC = qVar.c();
                if (iB > 0 && iB <= iC) {
                    qVar.a(iB - 1, false);
                    qVar.a(iB, false);
                }
            }
        }
        super.a(z);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void b(h0 h0Var) {
        com.fyber.inneractive.sdk.player.ui.t tVar;
        TapAction tapAction = ((T) this.b).f.i;
        if (tapAction == TapAction.CTR) {
            a(false, VideoClickOrigin.VIDEO, h0Var);
            return;
        }
        if (tapAction != TapAction.FULLSCREEN && tapAction != TapAction.DO_NOTHING) {
            IAlog.a("% sonVideoClicked called, but we recieved an unknown tap action %s", IAlog.a(this), tapAction);
            return;
        }
        if (((com.fyber.inneractive.sdk.config.global.features.w) this.c.a(com.fyber.inneractive.sdk.config.global.features.w.class)).d().equals(com.fyber.inneractive.sdk.config.global.features.u.OPEN) || ((this.t != com.fyber.inneractive.sdk.ignite.m.NONE && IAConfigManager.O.E.n()) || ((tVar = this.d) != null && tVar.a()))) {
            a(false, VideoClickOrigin.VIDEO, h0Var);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.storepromo.loader.b
    public final void a(h0 h0Var) {
        a(11, h0Var);
    }
}
