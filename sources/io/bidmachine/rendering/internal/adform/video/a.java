package io.bidmachine.rendering.internal.adform.video;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import io.bidmachine.rendering.internal.adform.video.player.d;
import io.bidmachine.rendering.internal.l;
import io.bidmachine.rendering.internal.m;
import io.bidmachine.rendering.internal.o;
import io.bidmachine.rendering.internal.repository.c;
import io.bidmachine.rendering.measurer.VideoMeasurer;
import io.bidmachine.rendering.model.AdElementParams;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.model.MediaSource;
import io.bidmachine.rendering.utils.UiUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes11.dex */
public class a extends io.bidmachine.rendering.internal.adform.a implements o {
    private final VideoMeasurer i;
    io.bidmachine.rendering.internal.adform.video.player.b j;

    /* JADX INFO: renamed from: io.bidmachine.rendering.internal.adform.video.a$a, reason: collision with other inner class name */
    class C0783a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicBoolean f12334a = new AtomicBoolean(false);

        public C0783a() {
        }

        @Override // io.bidmachine.rendering.internal.adform.video.player.d
        public void a(io.bidmachine.rendering.internal.adform.video.player.b bVar, boolean z) {
            io.bidmachine.rendering.internal.event.a aVarP = a.this.p();
            if (z) {
                aVarP.f();
            } else {
                aVarP.c();
            }
        }

        @Override // io.bidmachine.rendering.internal.adform.video.player.d
        public void b(io.bidmachine.rendering.internal.adform.video.player.b bVar) {
            a();
            if (a.this.i != null) {
                a.this.i.onMediaResumed();
            }
            a.this.p().b();
        }

        @Override // io.bidmachine.rendering.internal.adform.video.player.d
        public void c(io.bidmachine.rendering.internal.adform.video.player.b bVar) {
            if (a.this.i != null) {
                a.this.i.onMediaPaused();
            }
            a.this.p().h();
        }

        @Override // io.bidmachine.rendering.internal.adform.video.player.d
        public void d(io.bidmachine.rendering.internal.adform.video.player.b bVar) {
            if (a.this.i != null) {
                a.this.i.onMediaSkipped();
            }
            a.this.p().e();
        }

        @Override // io.bidmachine.rendering.internal.adform.video.player.d
        public void e(io.bidmachine.rendering.internal.adform.video.player.b bVar) {
            if (a.this.i != null) {
                a.this.i.onMediaThirdQuartile();
            }
            a.this.p().d();
        }

        @Override // io.bidmachine.rendering.internal.adform.video.player.d
        public void f(io.bidmachine.rendering.internal.adform.video.player.b bVar) {
            if (a.this.i != null) {
                a.this.i.onViewReady(bVar.o());
            }
            a.this.r().b(a.this);
        }

        @Override // io.bidmachine.rendering.internal.adform.video.player.d
        public void g(io.bidmachine.rendering.internal.adform.video.player.b bVar) {
            if (a.this.i != null) {
                a.this.i.onMediaStarted(bVar.g(), bVar.getVolume());
            }
            a.this.p().m();
        }

        @Override // io.bidmachine.rendering.internal.adform.video.player.d
        public void h(io.bidmachine.rendering.internal.adform.video.player.b bVar) {
            if (a.this.i != null) {
                a.this.i.onMediaMidpoint();
            }
            a.this.p().j();
        }

        @Override // io.bidmachine.rendering.internal.adform.video.player.d
        public void i(io.bidmachine.rendering.internal.adform.video.player.b bVar) {
            if (this.f12334a.compareAndSet(false, true)) {
                if (a.this.i != null) {
                    a.this.i.onMediaCompleted();
                }
                a.this.p().a();
            }
        }

        @Override // io.bidmachine.rendering.internal.adform.video.player.d
        public void a(io.bidmachine.rendering.internal.adform.video.player.b bVar, Error error) {
            a.this.b(error);
            i(bVar);
        }

        @Override // io.bidmachine.rendering.internal.adform.video.player.d
        public void b(io.bidmachine.rendering.internal.adform.video.player.b bVar, Error error) {
            a.this.a(error);
        }

        @Override // io.bidmachine.rendering.internal.adform.video.player.d
        public void a(io.bidmachine.rendering.internal.adform.video.player.b bVar, long j) {
            a.this.p().a(bVar.g(), j);
        }

        void a() {
            if (a.this.i != null) {
                a.this.i.onShown();
            }
            a.this.r().a(a.this);
        }

        @Override // io.bidmachine.rendering.internal.adform.video.player.d
        public void a(io.bidmachine.rendering.internal.adform.video.player.b bVar) {
            if (a.this.i != null) {
                a.this.i.onMediaFirstQuartile();
            }
            a.this.p().l();
        }

        @Override // io.bidmachine.rendering.internal.adform.video.player.d
        public void a(io.bidmachine.rendering.internal.adform.video.player.b bVar, float f) {
            if (a.this.i != null) {
                a.this.i.onMediaVolumeChanged(f);
            }
        }
    }

    class b implements c {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(Uri uri) {
            try {
                io.bidmachine.rendering.internal.adform.video.player.b bVar = a.this.j;
                if (bVar != null) {
                    bVar.a(uri);
                    a.this.j.prepare();
                }
            } catch (Throwable th) {
                m.b(th);
                a.this.a(Error.create(th));
            }
        }

        @Override // io.bidmachine.rendering.internal.repository.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(final Uri uri) {
            UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.internal.adform.video.a$b$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(uri);
                }
            });
        }

        @Override // io.bidmachine.rendering.internal.repository.c
        public void onError(Error error) {
            a.this.a(error);
        }
    }

    public a(Context context, io.bidmachine.rendering.internal.repository.a aVar, AdElementParams adElementParams, io.bidmachine.rendering.internal.adform.c cVar, io.bidmachine.rendering.internal.event.a aVar2, VideoMeasurer videoMeasurer) {
        super(context, aVar, adElementParams, cVar, aVar2);
        this.i = videoMeasurer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A() {
        io.bidmachine.rendering.internal.adform.video.player.b bVar = this.j;
        if (bVar != null) {
            bVar.play();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B() {
        io.bidmachine.rendering.internal.adform.video.player.b bVar = this.j;
        if (bVar != null) {
            bVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C() {
        io.bidmachine.rendering.internal.adform.video.player.b bVar = this.j;
        if (bVar != null) {
            bVar.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x() {
        io.bidmachine.rendering.internal.adform.video.player.b bVar = this.j;
        if (bVar != null) {
            bVar.a();
            this.j = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y() {
        io.bidmachine.rendering.internal.adform.video.player.b bVar = this.j;
        if (bVar != null) {
            bVar.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z() {
        io.bidmachine.rendering.internal.adform.video.player.b bVar = this.j;
        if (bVar != null) {
            bVar.pause();
        }
    }

    @Override // io.bidmachine.rendering.internal.a
    public void d() {
        UiUtils.onUiThread(new l() { // from class: io.bidmachine.rendering.internal.adform.video.a$$ExternalSyntheticLambda6
            @Override // io.bidmachine.rendering.utils.SafeRunnable
            public final void onRun() {
                this.f$0.z();
            }
        });
    }

    @Override // io.bidmachine.rendering.internal.a
    public void e() {
        UiUtils.onUiThread(new l() { // from class: io.bidmachine.rendering.internal.adform.video.a$$ExternalSyntheticLambda1
            @Override // io.bidmachine.rendering.utils.SafeRunnable
            public final void onRun() {
                this.f$0.A();
            }
        });
    }

    @Override // io.bidmachine.rendering.internal.u, io.bidmachine.rendering.internal.s
    public void f() {
        UiUtils.onUiThread(new l() { // from class: io.bidmachine.rendering.internal.adform.video.a$$ExternalSyntheticLambda5
            @Override // io.bidmachine.rendering.utils.SafeRunnable
            public final void onRun() {
                this.f$0.B();
            }
        });
    }

    @Override // io.bidmachine.rendering.internal.u, io.bidmachine.rendering.internal.o
    public void j() {
        UiUtils.onUiThread(new l() { // from class: io.bidmachine.rendering.internal.adform.video.a$$ExternalSyntheticLambda8
            @Override // io.bidmachine.rendering.utils.SafeRunnable
            public final void onRun() {
                this.f$0.C();
            }
        });
    }

    @Override // io.bidmachine.rendering.internal.a
    public View k() {
        io.bidmachine.rendering.internal.adform.video.player.b bVar = this.j;
        if (bVar != null) {
            return bVar.o();
        }
        return null;
    }

    @Override // io.bidmachine.rendering.internal.u, io.bidmachine.rendering.internal.o
    public void l() {
        UiUtils.onUiThread(new l() { // from class: io.bidmachine.rendering.internal.adform.video.a$$ExternalSyntheticLambda4
            @Override // io.bidmachine.rendering.utils.SafeRunnable
            public final void onRun() {
                this.f$0.y();
            }
        });
    }

    @Override // io.bidmachine.rendering.internal.adform.a
    public void u() {
        super.u();
        VideoMeasurer videoMeasurer = this.i;
        if (videoMeasurer != null) {
            videoMeasurer.onClicked();
        }
    }

    @Override // io.bidmachine.rendering.internal.adform.a
    protected void v() {
        VideoMeasurer videoMeasurer = this.i;
        if (videoMeasurer != null) {
            videoMeasurer.destroy(new l() { // from class: io.bidmachine.rendering.internal.adform.video.a$$ExternalSyntheticLambda2
                @Override // io.bidmachine.rendering.utils.SafeRunnable
                public final void onRun() {
                    this.f$0.w();
                }
            });
        } else {
            w();
        }
    }

    void w() {
        UiUtils.onUiThread(new l() { // from class: io.bidmachine.rendering.internal.adform.video.a$$ExternalSyntheticLambda7
            @Override // io.bidmachine.rendering.utils.SafeRunnable
            public final void onRun() {
                this.f$0.x();
            }
        });
    }

    @Override // io.bidmachine.rendering.internal.a
    public void c() {
        String source = i().getSource();
        if (TextUtils.isEmpty(source)) {
            a(new Error("Source is null or empty"));
            return;
        }
        MediaSource mediaSourceFromUrl = MediaSource.fromUrl(source);
        final String customParam = mediaSourceFromUrl.getDeliveryType() == MediaSource.DeliveryType.STREAM ? "exo" : i().getCustomParam("player");
        UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.internal.adform.video.a$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(customParam);
            }
        });
        t().a(s(), mediaSourceFromUrl, new b());
    }

    @Override // io.bidmachine.rendering.internal.a
    public void a(final ViewGroup viewGroup) {
        UiUtils.onUiThread(new l() { // from class: io.bidmachine.rendering.internal.adform.video.a$$ExternalSyntheticLambda3
            @Override // io.bidmachine.rendering.utils.SafeRunnable
            public final void onRun() {
                this.f$0.b(viewGroup);
            }
        });
    }

    @Override // io.bidmachine.rendering.internal.u, io.bidmachine.rendering.internal.h
    public void b() {
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Error error) {
        VideoMeasurer videoMeasurer = this.i;
        if (videoMeasurer != null) {
            videoMeasurer.onError(error);
        }
        r().c(this, error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str) {
        try {
            io.bidmachine.rendering.internal.adform.video.player.b bVarA = io.bidmachine.rendering.internal.adform.video.player.c.a(s(), str);
            this.j = bVarA;
            bVarA.a(new C0783a());
            VideoMeasurer videoMeasurer = this.i;
            if (videoMeasurer != null) {
                videoMeasurer.onViewCreated(this.j.o());
            }
        } catch (Throwable th) {
            m.b(th);
            a(Error.create(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(ViewGroup viewGroup) {
        io.bidmachine.rendering.internal.adform.video.player.b bVar;
        VideoMeasurer videoMeasurer = this.i;
        if (videoMeasurer == null || (bVar = this.j) == null) {
            return;
        }
        videoMeasurer.onViewAddedToContainer(bVar.o(), viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Error error) {
        VideoMeasurer videoMeasurer = this.i;
        if (videoMeasurer != null) {
            videoMeasurer.onError(error);
        }
        r().a(this, error);
    }
}
