package com.fyber.inneractive.sdk.player.controller;

import android.view.Surface;
import com.fyber.inneractive.sdk.player.exoplayer2.decoder.DecoderCounters;
import com.fyber.inneractive.sdk.player.exoplayer2.video.VideoRendererEventListener;
import com.fyber.inneractive.sdk.util.IAlog;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes13.dex */
public final class B implements VideoRendererEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f1949a;
    public boolean b = false;

    public B(C3155f c3155f) {
        this.f1949a = new WeakReference(c3155f);
    }

    public final String a() {
        C3155f c3155f = (C3155f) this.f1949a.get();
        return c3155f == null ? B.class.getName() : IAlog.a(c3155f);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.video.VideoRendererEventListener
    public final void onDroppedFrames(int i, long j) {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.video.VideoRendererEventListener
    public final void onRenderedFirstFrame(Surface surface) {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.video.VideoRendererEventListener
    public final void onVideoDecoderInitialized(String str, long j, long j2) {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.video.VideoRendererEventListener
    public final void onVideoDisabled(DecoderCounters decoderCounters) {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.video.VideoRendererEventListener
    public final void onVideoEnabled(DecoderCounters decoderCounters) {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.video.VideoRendererEventListener
    public final void onVideoInputFormatChanged(com.fyber.inneractive.sdk.player.exoplayer2.o oVar) {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.video.VideoRendererEventListener
    public final void onVideoSizeChanged(int i, int i2, int i3, float f) {
        C3155f c3155f = (C3155f) this.f1949a.get();
        if (c3155f != null) {
            c3155f.t = i;
            c3155f.u = i2;
        }
    }

    public final void a(int i, boolean z) {
        com.fyber.inneractive.sdk.player.exoplayer2.g gVar;
        IAlog.a("%sonPlayerStateChanged called with pwr = %s state = %d", a(), Boolean.valueOf(z), Integer.valueOf(i));
        C3155f c3155f = (C3155f) this.f1949a.get();
        if (c3155f == null || (gVar = c3155f.s) == null || c3155f.z) {
            return;
        }
        if (i != 3) {
            if (i == 2) {
                if (c3155f.e == com.fyber.inneractive.sdk.player.enums.b.Playing) {
                    c3155f.a(com.fyber.inneractive.sdk.player.enums.b.Buffering);
                    return;
                }
                return;
            } else {
                if (i == 4) {
                    c3155f.a(com.fyber.inneractive.sdk.player.enums.b.Completed);
                    return;
                }
                return;
            }
        }
        if (!z) {
            if (c3155f.e == com.fyber.inneractive.sdk.player.enums.b.Preparing) {
                com.fyber.inneractive.sdk.player.exoplayer2.trackselection.h hVar = gVar.o;
                if (hVar != null && hVar.f2143a > 0) {
                    com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b bVar = hVar.b[0];
                    com.fyber.inneractive.sdk.player.exoplayer2.o oVar = bVar == null ? null : bVar.d[bVar.a()];
                    if (oVar != null) {
                        int i2 = oVar.j;
                        int i3 = oVar.k;
                        c3155f.t = i2;
                        c3155f.u = i3;
                    }
                }
                this.b = true;
                c3155f.a(com.fyber.inneractive.sdk.player.enums.b.Prepared);
                return;
            }
            return;
        }
        c3155f.a(com.fyber.inneractive.sdk.player.enums.b.Playing);
    }
}
