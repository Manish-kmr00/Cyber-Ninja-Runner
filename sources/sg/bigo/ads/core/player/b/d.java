package sg.bigo.ads.core.player.b;

import android.content.Context;
import sg.bigo.ads.core.f.a.p;

/* JADX INFO: loaded from: classes11.dex */
public final class d extends f implements sg.bigo.ads.core.g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final sg.bigo.ads.core.g.a.a f13701a;
    private int g;
    private boolean h;
    private boolean i;
    private int j;
    private boolean k;
    private final sg.bigo.ads.core.g.e l;
    private boolean m;

    public d(Context context, int i, int i2, sg.bigo.ads.api.c.b bVar, sg.bigo.ads.core.a.a aVar) {
        super(context, bVar, aVar);
        this.g = 0;
        this.h = false;
        this.i = false;
        this.k = false;
        sg.bigo.ads.core.g.e eVar = new sg.bigo.ads.core.g.e() { // from class: sg.bigo.ads.core.player.b.d.1
            @Override // sg.bigo.ads.core.g.e
            public final void a() {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdImpression");
                d.this.a("AdVPAIDImpression", (Object) null, (int[]) null);
            }

            @Override // sg.bigo.ads.core.g.e
            public final void a(float f) {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdVolumeChange, volume=".concat(String.valueOf(f)));
                d.this.i = f <= 0.0f;
                d dVar = d.this;
                dVar.b(dVar.i);
                d dVar2 = d.this;
                dVar2.a("AdVolumeChange", new int[]{dVar2.i ? 0 : 100});
            }

            @Override // sg.bigo.ads.core.g.e
            public final void a(int i3) {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdDurationChange, duration=".concat(String.valueOf(i3)));
                d.this.j = i3;
            }

            @Override // sg.bigo.ads.core.g.e
            public final void a(int i3, int i4) {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdSizeChange, w=" + i3 + ", h=" + i4);
                d.this.a("AdSizeChange", (int[]) null);
            }

            @Override // sg.bigo.ads.core.g.e
            public final void a(String str) {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdError, message=".concat(String.valueOf(str)));
                d.this.a("AdError", str, new int[]{-1, -1});
            }

            @Override // sg.bigo.ads.core.g.e
            public final void a(String str, String str2, boolean z) {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdClickThru, url=" + str + ", id=" + str2 + ", playerHandles=" + z);
                d.a(d.this, str, z);
            }

            @Override // sg.bigo.ads.core.g.e
            public final void a(boolean z) {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdExpandedChange, expanded=".concat(String.valueOf(z)));
            }

            @Override // sg.bigo.ads.core.g.e
            public final void b() {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdVideoStart");
                d.this.a("AdVideoStart", (Object) null, (int[]) null);
            }

            @Override // sg.bigo.ads.core.g.e
            public final void b(int i3) {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdRemainingTimeChange, remaining=".concat(String.valueOf(i3)));
            }

            @Override // sg.bigo.ads.core.g.e
            public final void b(String str) {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdLog, message=".concat(String.valueOf(str)));
            }

            @Override // sg.bigo.ads.core.g.e
            public final void b(boolean z) {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdInteraction, adLinear=".concat(String.valueOf(z)));
            }

            @Override // sg.bigo.ads.core.g.e
            public final void c() {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdVideoFirstQuartile");
                d.this.a("AdVideoFirstQuartile", (Object) null, (int[]) null);
            }

            @Override // sg.bigo.ads.core.g.e
            public final void c(String str) {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdInteraction, id=".concat(String.valueOf(str)));
            }

            @Override // sg.bigo.ads.core.g.e
            public final void d() {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdVideoMidpoint");
                d.this.a("AdVideoMidpoint", (Object) null, (int[]) null);
            }

            @Override // sg.bigo.ads.core.g.e
            public final void e() {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdVideoThirdQuartile");
                d.this.a("AdVideoThirdQuartile", (Object) null, (int[]) null);
            }

            @Override // sg.bigo.ads.core.g.e
            public final void f() {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdVideoComplete");
                d.this.g = 5;
                d.this.m = true;
                d dVar = d.this;
                dVar.setPlayOrPauseViewHidden(dVar.d.b);
                d.this.c(true);
                d.this.d(false);
                d.this.a("AdVideoComplete", (int[]) null);
            }

            @Override // sg.bigo.ads.core.g.e
            public final void g() {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdSkippableStateChange");
            }

            @Override // sg.bigo.ads.core.g.e
            public final void h() {
                d dVar;
                float f;
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdLoaded");
                d.this.g = 1;
                d.this.h = true;
                if (d.this.d.d) {
                    dVar = d.this;
                    f = 0.0f;
                } else {
                    dVar = d.this;
                    f = 1.0f;
                }
                dVar.setAdVolume(f);
                if (d.this.n()) {
                    d.this.b(18);
                    d.this.setStatPrepareEventOnce(false);
                }
                if (d.this.k) {
                    d.b(d.this);
                    d.this.b();
                } else if (!d.this.f && !d.this.m) {
                    d.this.d(true);
                }
                d.this.a("AdLoaded", (Object) null, (int[]) null);
            }

            @Override // sg.bigo.ads.core.g.e
            public final void i() {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdPlaying");
                d.this.g = 2;
                d.this.a("AdVideoPlaying", (int[]) null);
            }

            @Override // sg.bigo.ads.core.g.e
            public final void j() {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onStartAd");
                d.this.g = 2;
                d.this.m = false;
                d.this.a("AdVideoPlaying", (int[]) null);
            }

            @Override // sg.bigo.ads.core.g.e
            public final void k() {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onStopAd");
                d.this.g = 4;
                d.this.a("AdStopped", (int[]) null);
            }

            @Override // sg.bigo.ads.core.g.e
            public final void l() {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onSkipAd");
                d.this.b(10);
                d.this.a("AdSkipped", (int[]) null);
            }

            @Override // sg.bigo.ads.core.g.e
            public final void m() {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdPaused");
                d.this.g = 3;
                d.this.a("AdVideoPaused", (int[]) null);
            }

            @Override // sg.bigo.ads.core.g.e
            public final void n() {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdUserAcceptInvitation");
            }

            @Override // sg.bigo.ads.core.g.e
            public final void o() {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdUserMinimize");
            }

            @Override // sg.bigo.ads.core.g.e
            public final void p() {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "onAdUserClose");
                d.this.a("AdClosed", (int[]) null);
            }
        };
        this.l = eVar;
        this.m = bVar.e;
        p pVarBo = aVar.bo();
        sg.bigo.ads.core.f.a.a.a aVar2 = pVarBo != null ? pVarBo.B : null;
        sg.bigo.ads.core.g.a.a aVar3 = new sg.bigo.ads.core.g.a.a(context, this, aVar.b(context), i, i2, sg.bigo.ads.api.core.b.b(aVar.x()) ? sg.bigo.ads.core.g.f.FULLSCREEN : sg.bigo.ads.core.g.f.NORMAL, aVar2 != null ? aVar2.a().trim() : "", sg.bigo.ads.api.core.b.d(aVar.x()) ? 3 : bVar.f13096a, aVar.bn());
        this.f13701a = aVar3;
        aVar3.b.setVPAIDEvenListener(eVar);
        aVar3.c = new sg.bigo.ads.core.g.a.a.InterfaceC0895a() { // from class: sg.bigo.ads.core.player.b.d.2
            @Override // sg.bigo.ads.core.g.a.a.InterfaceC0895a
            public final void a() {
                sg.bigo.ads.common.t.a.b("VPAIDPlayView", "onVPAIDPlayerDestroy");
                d.this.h = false;
                d.this.d(false);
                if (d.this.m) {
                    return;
                }
                d.this.f = false;
            }
        };
    }

    static /* synthetic */ void a(d dVar, String str, boolean z) {
        if (sg.bigo.ads.core.g.d.d(str)) {
            sg.bigo.ads.api.core.c.b bVarN = dVar.e != null ? dVar.e.N() : null;
            if (bVarN != null) {
                bVarN.a(str);
            }
        }
        dVar.a("AdVPAIDClickThru", dVar.f13701a.b.getClickPoints(), new int[]{z ? 1 : 0});
    }

    static /* synthetic */ boolean b(d dVar) {
        dVar.k = false;
        return false;
    }

    @Override // sg.bigo.ads.api.c.a
    public final void a() {
        this.f13701a.b.a("window.vpaidwrapper.pauseAd()");
        this.k = false;
    }

    @Override // sg.bigo.ads.core.player.b.f
    protected final void a(boolean z) {
        super.a(z);
        if (!this.h) {
            this.k = z;
            return;
        }
        sg.bigo.ads.core.g.a.b bVar = this.f13701a.b;
        bVar.d.a(3);
        bVar.a("window.vpaidwrapper.startAd()");
        if (!sg.bigo.ads.common.aa.b.a(getContext())) {
            sg.bigo.ads.common.t.a.b("VPAIDPlayView", "screen is off, start ad cancel");
        } else {
            setPlayOrPauseViewHidden(true);
            d(true);
        }
    }

    @Override // sg.bigo.ads.core.player.b.a
    public final void b() {
        if (this.f || this.m) {
            if (this.m) {
                sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "tryStartAd, video is completed play, unregister it from list");
                d(false);
                return;
            }
            return;
        }
        sg.bigo.ads.common.t.a.a(0, 3, "VPAIDPlayView", "try start play video ad");
        if (this.g == 1) {
            a(false);
        } else {
            this.f13701a.b.a("window.vpaidwrapper.resumeAd()");
        }
    }

    @Override // sg.bigo.ads.core.player.b.a
    public final boolean c() {
        return this.i;
    }

    @Override // sg.bigo.ads.core.player.b.a
    public final void d() {
        d(false);
    }

    @Override // sg.bigo.ads.core.player.b.f
    protected final boolean e() {
        return this.h;
    }

    public final String getAdCompanions() {
        return this.f13701a.b.getAdCompanions();
    }

    public final int getAdDuration() {
        return this.f13701a.b.getAdDuration();
    }

    public final boolean getAdExpanded() {
        return this.f13701a.b.getAdExpanded();
    }

    public final int getAdHeight() {
        return this.f13701a.b.getAdHeight();
    }

    public final boolean getAdIcons() {
        return this.f13701a.b.getAdIcons();
    }

    public final boolean getAdLinear() {
        return this.f13701a.b.getAdLinear();
    }

    public final int getAdRemainingTime() {
        return this.f13701a.b.getAdRemainingTime();
    }

    public final boolean getAdSkippableState() {
        return this.f13701a.b.getAdSkippableState();
    }

    public final float getAdVolume() {
        return this.f13701a.b.getAdVolume();
    }

    public final int getAdWidth() {
        return this.f13701a.b.getAdWidth();
    }

    @Override // sg.bigo.ads.core.player.b.a
    public final int getPlayStatus() {
        return this.g;
    }

    public final void setAdVolume(float f) {
        this.f13701a.b.setAdVolume(f);
    }

    @Override // sg.bigo.ads.core.player.b.a
    public final void setMute(boolean z) {
        setAdVolume(z ? 0.0f : 1.0f);
    }

    public final void setVPAIDClickable(boolean z) {
        this.f13701a.b.setVPAIDClickable(z);
    }
}
