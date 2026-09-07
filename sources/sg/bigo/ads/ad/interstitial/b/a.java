package sg.bigo.ads.ad.interstitial.b;

import sg.bigo.ads.ad.interstitial.w;
import sg.bigo.ads.api.VideoController;
import sg.bigo.ads.common.utils.n;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public sg.bigo.ads.ad.b.c f12648a;
    public w b;
    public n f;
    public InterfaceC0828a g;
    public boolean d = false;
    boolean e = false;
    public boolean h = true;
    public int c = 1;

    /* JADX INFO: renamed from: sg.bigo.ads.ad.interstitial.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0828a {
        void a(boolean z, boolean z2);

        void ah();

        void ai();

        void b(long j);
    }

    static class b implements VideoController.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final VideoController.d f12652a;

        private b(VideoController.d dVar) {
            this.f12652a = dVar;
        }

        /* synthetic */ b(VideoController.d dVar, byte b) {
            this(dVar);
        }

        @Override // sg.bigo.ads.api.VideoController.d
        public void a(int i, int i2) {
            VideoController.d dVar = this.f12652a;
            if (dVar != null) {
                dVar.a(i, i2);
            }
        }
    }

    static class c implements VideoController.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final VideoController.b f12653a;

        private c(VideoController.b bVar) {
            this.f12653a = bVar;
        }

        /* synthetic */ c(VideoController.b bVar, byte b) {
            this(bVar);
        }

        @Override // sg.bigo.ads.api.VideoController.b
        public final void a() {
            VideoController.b bVar = this.f12653a;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // sg.bigo.ads.api.VideoController.b
        public final void b() {
            VideoController.b bVar = this.f12653a;
            if (bVar != null) {
                bVar.b();
            }
        }

        @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
        public void onMuteChange(boolean z) {
            VideoController.b bVar = this.f12653a;
            if (bVar != null) {
                bVar.onMuteChange(z);
            }
        }

        @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
        public void onVideoEnd() {
            VideoController.b bVar = this.f12653a;
            if (bVar != null) {
                bVar.onVideoEnd();
            }
        }

        @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
        public void onVideoPause() {
            VideoController.b bVar = this.f12653a;
            if (bVar != null) {
                bVar.onVideoPause();
            }
        }

        @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
        public void onVideoPlay() {
            VideoController.b bVar = this.f12653a;
            if (bVar != null) {
                bVar.onVideoPlay();
            }
        }

        @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
        public void onVideoStart() {
            VideoController.b bVar = this.f12653a;
            if (bVar != null) {
                bVar.onVideoStart();
            }
        }
    }

    static /* synthetic */ void a(a aVar) {
        if (!aVar.a()) {
            if (aVar.d) {
                aVar.b();
                return;
            } else {
                sg.bigo.ads.common.t.a.a(0, "CountdownHelper", "invalid status, isCountdownIgnoreVideoProgress=" + aVar.a() + ", mVideoEnd=" + aVar.d);
                return;
            }
        }
        if (aVar.e) {
            aVar.b();
            return;
        }
        sg.bigo.ads.ad.b.c cVar = aVar.f12648a;
        VideoController videoController = cVar != null ? cVar.getVideoController() : null;
        if (videoController == null || videoController.isPlaying()) {
            return;
        }
        videoController.play();
    }

    private void b() {
        InterfaceC0828a interfaceC0828a = this.g;
        if (interfaceC0828a != null) {
            interfaceC0828a.a(a(), this.d);
        }
    }

    public final void a(boolean z) {
        if (z && !a()) {
            InterfaceC0828a interfaceC0828a = this.g;
            if (interfaceC0828a != null) {
                interfaceC0828a.ah();
                return;
            }
            return;
        }
        if (z || !a()) {
            return;
        }
        n nVar = this.f;
        if (nVar != null && nVar.e()) {
            this.f.c();
        }
        InterfaceC0828a interfaceC0828a2 = this.g;
        if (interfaceC0828a2 != null) {
            interfaceC0828a2.ah();
        }
    }

    public final boolean a() {
        return this.c == 2;
    }

    public final void b(boolean z) {
        if (z && !a()) {
            InterfaceC0828a interfaceC0828a = this.g;
            if (interfaceC0828a != null) {
                interfaceC0828a.ai();
                return;
            }
            return;
        }
        if (z || !a()) {
            return;
        }
        n nVar = this.f;
        if (nVar != null) {
            nVar.d();
        }
        InterfaceC0828a interfaceC0828a2 = this.g;
        if (interfaceC0828a2 != null) {
            interfaceC0828a2.ai();
        }
    }
}
