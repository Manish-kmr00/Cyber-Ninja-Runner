package com.fyber.inneractive.sdk.external;

import com.fyber.inneractive.sdk.flow.T;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes13.dex */
public class InneractiveNativeVideoContentController extends T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference f1757a;

    public interface Renderer {
        void pauseVideo();

        void playVideo();
    }

    @Override // com.fyber.inneractive.sdk.flow.H
    public boolean canControl(InneractiveAdSpot inneractiveAdSpot) {
        return inneractiveAdSpot.getAdContent().isVideoAd();
    }

    public void pauseVideo() {
        if (((Renderer) AbstractC3256u.a(this.f1757a)) != null) {
            ((Renderer) this.f1757a.get()).pauseVideo();
        }
    }

    public void playVideo() {
        Renderer renderer = (Renderer) AbstractC3256u.a(this.f1757a);
        if (renderer != null) {
            renderer.playVideo();
        }
    }

    public void setControlledRenderer(Renderer renderer) {
        this.f1757a = new WeakReference(renderer);
    }
}
