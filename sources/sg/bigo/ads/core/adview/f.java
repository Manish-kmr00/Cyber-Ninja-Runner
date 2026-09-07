package sg.bigo.ads.core.adview;

import android.content.Context;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageView;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.VideoController;
import sg.bigo.ads.api.a.i;
import sg.bigo.ads.api.core.n;
import sg.bigo.ads.api.core.o;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.common.view.AdImageView;
import sg.bigo.ads.core.f.a.p;

/* JADX INFO: loaded from: classes5.dex */
public final class f extends c implements MediaView.a {
    public sg.bigo.ads.core.player.b.f b;
    public AdImageView c;
    public Boolean d;
    public Boolean e;
    public VideoController f;
    public boolean g;
    private boolean h;

    static class a implements VideoController {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final sg.bigo.ads.core.player.b.f f13511a;
        private VideoController.VideoLifeCallback b;
        private VideoController.d c;
        private VideoController.c d;
        private VideoController.a e;

        a(sg.bigo.ads.core.player.b.f fVar) {
            this.f13511a = fVar;
        }

        @Override // sg.bigo.ads.api.VideoController
        public final VideoController.a getBackupLoadCallback() {
            return this.e;
        }

        @Override // sg.bigo.ads.api.VideoController
        public final VideoController.c getLoadHTMLCallback() {
            return this.d;
        }

        @Override // sg.bigo.ads.api.VideoController
        public final VideoController.d getProgressChangeListener() {
            return this.c;
        }

        @Override // sg.bigo.ads.api.VideoController
        public final VideoController.VideoLifeCallback getVideoLifeCallback() {
            return this.b;
        }

        @Override // sg.bigo.ads.api.VideoController
        public final boolean isMuted() {
            sg.bigo.ads.core.player.d unused = sg.bigo.ads.core.player.d.a.f13717a;
            return this.f13511a.c();
        }

        @Override // sg.bigo.ads.api.VideoController
        public final boolean isPaused() {
            sg.bigo.ads.core.player.d unused = sg.bigo.ads.core.player.d.a.f13717a;
            return this.f13511a.getPlayStatus() == 3;
        }

        @Override // sg.bigo.ads.api.VideoController
        public final boolean isPlaying() {
            sg.bigo.ads.core.player.d unused = sg.bigo.ads.core.player.d.a.f13717a;
            return this.f13511a.r();
        }

        @Override // sg.bigo.ads.api.VideoController
        public final void mute(boolean z) {
            sg.bigo.ads.core.player.d unused = sg.bigo.ads.core.player.d.a.f13717a;
            this.f13511a.setMute(z);
        }

        @Override // sg.bigo.ads.api.VideoController
        public final void notifyBackupResourceReady() {
            sg.bigo.ads.core.player.d unused = sg.bigo.ads.core.player.d.a.f13717a;
            sg.bigo.ads.core.player.b.f fVar = this.f13511a;
            if (fVar instanceof sg.bigo.ads.core.player.b.e) {
                ((sg.bigo.ads.core.player.b.e) fVar).l();
            }
        }

        @Override // sg.bigo.ads.api.VideoController
        public final void notifyPlayViewRegister() {
            sg.bigo.ads.core.player.d.a.f13717a.a(this.f13511a);
        }

        @Override // sg.bigo.ads.api.VideoController
        public final void notifyResourceReady() {
            sg.bigo.ads.core.player.d unused = sg.bigo.ads.core.player.d.a.f13717a;
            sg.bigo.ads.core.player.b.f fVar = this.f13511a;
            if (fVar instanceof sg.bigo.ads.core.player.b.e) {
                ((sg.bigo.ads.core.player.b.e) fVar).m();
            }
        }

        @Override // sg.bigo.ads.api.VideoController
        public final void pause() {
            sg.bigo.ads.core.player.d unused = sg.bigo.ads.core.player.d.a.f13717a;
            this.f13511a.s();
        }

        @Override // sg.bigo.ads.api.VideoController
        public final void play() {
            sg.bigo.ads.core.player.d unused = sg.bigo.ads.core.player.d.a.f13717a;
            this.f13511a.e(true);
        }

        @Override // sg.bigo.ads.api.VideoController
        public final void setBackupLoadCallback(VideoController.a aVar) {
            this.e = aVar;
        }

        @Override // sg.bigo.ads.api.VideoController
        public final void setLoadHTMLCallback(VideoController.c cVar) {
            this.d = cVar;
        }

        @Override // sg.bigo.ads.api.VideoController
        public final void setProgressChangeListener(VideoController.d dVar) {
            this.c = dVar;
        }

        @Override // sg.bigo.ads.api.VideoController
        public final void setVideoLifeCallback(VideoController.VideoLifeCallback videoLifeCallback) {
            this.b = videoLifeCallback;
        }
    }

    public f(sg.bigo.ads.api.a<?> aVar) {
        super(aVar);
        this.b = null;
        this.c = null;
        this.d = Boolean.TRUE;
        this.e = Boolean.TRUE;
        this.h = true;
        this.g = true;
    }

    private boolean b(int i, int i2) {
        AdImageView adImageView = this.c;
        if (adImageView != null) {
            return u.a(i, i2, adImageView);
        }
        sg.bigo.ads.core.player.b.f fVar = this.b;
        if (fVar != null) {
            return u.a(i, i2, fVar);
        }
        return false;
    }

    @Override // sg.bigo.ads.core.adview.c
    protected final void a(View view) {
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        }
        u.a(view, this.f13501a, null, -1);
    }

    public final void a(String str) {
        sg.bigo.ads.core.player.b.e eVar = new sg.bigo.ads.core.player.b.e(this.f13501a.getContext(), 0, 0, sg.bigo.ads.api.c.b.b(1), null);
        eVar.setClickable(this.h);
        a(eVar);
        eVar.setPlayInfo$505cff1c(str);
        this.f = new a(eVar);
        this.b = eVar;
    }

    public final void a(o oVar, sg.bigo.ads.common.p.g gVar) {
        AdImageView adImageView;
        ImageView.ScaleType scaleType;
        AdImageView adImageView2;
        FrameLayout.LayoutParams layoutParams;
        sg.bigo.ads.api.c.b bVarB = sg.bigo.ads.api.c.b.b(oVar.x());
        if (this.c == null) {
            this.c = new AdImageView(this.f13501a.getContext());
        }
        int i = bVarB.f13096a;
        if (i == 1) {
            adImageView = this.c;
            scaleType = ImageView.ScaleType.FIT_CENTER;
            adImageView.setScaleType(scaleType);
        } else if (i != 2) {
            if (i == 3) {
                adImageView2 = this.c;
                layoutParams = new FrameLayout.LayoutParams(-1, -2, 17);
            } else if (i == 4) {
                adImageView2 = this.c;
                layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
            }
            adImageView2.setLayoutParams(layoutParams);
            adImageView = this.c;
            scaleType = ImageView.ScaleType.FIT_CENTER;
            adImageView.setScaleType(scaleType);
        } else {
            adImageView = this.c;
            scaleType = ImageView.ScaleType.CENTER_CROP;
            adImageView.setScaleType(scaleType);
        }
        String strAS = oVar.aS();
        a(this.c);
        this.c.setBlurBorder(this.g);
        this.c.a(gVar);
        if (i.f13093a.n().a(9) && URLUtil.isHttpUrl(strAS) && gVar != null) {
            gVar.a(1305, "Invalid http url", "");
        } else {
            this.c.a(strAS, oVar.al());
        }
    }

    public final void a(sg.bigo.ads.core.a.a aVar, p pVar, sg.bigo.ads.core.g.c cVar) {
        sg.bigo.ads.api.c.b bVarB = sg.bigo.ads.api.c.b.b(aVar.x());
        n nVarAU = aVar.aU();
        int i = pVar.x;
        int i2 = pVar.w;
        if (nVarAU != null && nVarAU.c > 0) {
            if (nVarAU.f13112a > 0) {
                i = nVarAU.f13112a;
            }
            if (nVarAU.b > 0) {
                i2 = nVarAU.b;
            }
        }
        Context context = this.f13501a.getContext();
        sg.bigo.ads.core.player.b.e eVar = new sg.bigo.ads.core.player.b.e(context, i, i2, bVarB, aVar);
        eVar.setClickable(this.h);
        a(eVar);
        eVar.setPlayInfo$505cff1c(aVar.c(this.f13501a.getContext()));
        eVar.setOnEventListener(cVar);
        this.f = new a(eVar);
        this.b = eVar;
    }

    @Override // sg.bigo.ads.api.MediaView.a
    public final void a(sg.bigo.ads.core.player.b.b bVar) {
        sg.bigo.ads.core.player.b.f fVar = this.b;
        if (fVar instanceof sg.bigo.ads.core.player.b.e) {
            ((sg.bigo.ads.core.player.b.e) fVar).setIVideoPlayerViewListener(bVar);
        }
    }

    public final void a(sg.bigo.ads.core.player.b.d dVar) {
        dVar.setVPAIDClickable(this.h);
        a((View) dVar);
        this.f = new a(dVar);
        this.b = dVar;
    }

    @Override // sg.bigo.ads.api.MediaView.a
    public final void a(boolean z) {
        sg.bigo.ads.core.player.b.f fVar = this.b;
        if (fVar != null) {
            fVar.setClickable(z);
        } else {
            this.h = z;
        }
    }

    @Override // sg.bigo.ads.api.MediaView.a
    public final boolean a() {
        sg.bigo.ads.core.player.b.f fVar = this.b;
        return fVar != null ? fVar.isClickable() : this.h;
    }

    @Override // sg.bigo.ads.core.adview.c
    public final boolean a(int i, int i2) {
        int i3;
        boolean zB = b(i, i2);
        if ((super.a(i, i2) && (b(i, i2) ^ true)) && this.d.booleanValue()) {
            i3 = 9;
        } else {
            if (!zB || !this.e.booleanValue()) {
                return false;
            }
            i3 = 5;
        }
        a(i3);
        return true;
    }

    @Override // sg.bigo.ads.api.MediaView.a
    public final void b() {
        sg.bigo.ads.core.player.b.f fVar = this.b;
        if (fVar != null) {
            fVar.performClick();
        }
    }

    public final int c() {
        AdImageView adImageView = this.c;
        if (adImageView == null || adImageView.getDrawable() == null) {
            return 0;
        }
        return this.c.getDrawable().getIntrinsicHeight();
    }

    public final int d() {
        AdImageView adImageView = this.c;
        if (adImageView == null || adImageView.getDrawable() == null) {
            return 0;
        }
        return this.c.getDrawable().getIntrinsicWidth();
    }
}
