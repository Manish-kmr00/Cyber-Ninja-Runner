package com.smaato.sdk.video.vast.widget;

import android.graphics.Rect;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.Consumer;

/* JADX INFO: loaded from: classes12.dex */
public class SurfaceViewVastSurfaceHolder implements VastSurfaceHolder {
    private VastSurfaceHolder.OnSurfaceAvailableListener onSurfaceAvailableListener;
    private VastSurfaceHolder.OnSurfaceChangedListener onSurfaceChangedListener;
    private VastSurfaceHolder.OnSurfaceDestroyedListener onSurfaceDestroyedListener;
    private final SurfaceView surfaceView;

    SurfaceViewVastSurfaceHolder(SurfaceView surfaceView) {
        this.surfaceView = surfaceView;
        surfaceView.getHolder().addCallback(new AnonymousClass1());
    }

    /* JADX INFO: renamed from: com.smaato.sdk.video.vast.widget.SurfaceViewVastSurfaceHolder$1, reason: invalid class name */
    class AnonymousClass1 implements SurfaceHolder.Callback {
        AnonymousClass1() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(final SurfaceHolder surfaceHolder) {
            Objects.onNotNull(SurfaceViewVastSurfaceHolder.this.onSurfaceAvailableListener, new Consumer() { // from class: com.smaato.sdk.video.vast.widget.SurfaceViewVastSurfaceHolder$1$$ExternalSyntheticLambda1
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    SurfaceViewVastSurfaceHolder.AnonymousClass1.lambda$surfaceCreated$0(surfaceHolder, (VastSurfaceHolder.OnSurfaceAvailableListener) obj);
                }
            });
        }

        static /* synthetic */ void lambda$surfaceCreated$0(SurfaceHolder surfaceHolder, VastSurfaceHolder.OnSurfaceAvailableListener onSurfaceAvailableListener) {
            Surface surface = surfaceHolder.getSurface();
            if (surface != null) {
                Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
                onSurfaceAvailableListener.onSurfaceAvailable(surface, surfaceFrame.width(), surfaceFrame.height());
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(final SurfaceHolder surfaceHolder, int i, final int i2, final int i3) {
            Objects.onNotNull(SurfaceViewVastSurfaceHolder.this.onSurfaceChangedListener, new Consumer() { // from class: com.smaato.sdk.video.vast.widget.SurfaceViewVastSurfaceHolder$1$$ExternalSyntheticLambda0
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    SurfaceViewVastSurfaceHolder.AnonymousClass1.lambda$surfaceChanged$1(surfaceHolder, i2, i3, (VastSurfaceHolder.OnSurfaceChangedListener) obj);
                }
            });
        }

        static /* synthetic */ void lambda$surfaceChanged$1(SurfaceHolder surfaceHolder, int i, int i2, VastSurfaceHolder.OnSurfaceChangedListener onSurfaceChangedListener) {
            Surface surface = surfaceHolder.getSurface();
            if (surface != null) {
                onSurfaceChangedListener.onSurfaceChanged(surface, i, i2);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(final SurfaceHolder surfaceHolder) {
            Objects.onNotNull(SurfaceViewVastSurfaceHolder.this.onSurfaceDestroyedListener, new Consumer() { // from class: com.smaato.sdk.video.vast.widget.SurfaceViewVastSurfaceHolder$1$$ExternalSyntheticLambda2
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    SurfaceViewVastSurfaceHolder.AnonymousClass1.lambda$surfaceDestroyed$2(surfaceHolder, (VastSurfaceHolder.OnSurfaceDestroyedListener) obj);
                }
            });
        }

        static /* synthetic */ void lambda$surfaceDestroyed$2(SurfaceHolder surfaceHolder, VastSurfaceHolder.OnSurfaceDestroyedListener onSurfaceDestroyedListener) {
            Surface surface = surfaceHolder.getSurface();
            if (surface != null) {
                onSurfaceDestroyedListener.onSurfaceDestroyed(surface);
            }
        }
    }

    @Override // com.smaato.sdk.video.vast.widget.VastSurfaceHolder
    public View getView() {
        return this.surfaceView;
    }

    @Override // com.smaato.sdk.video.vast.widget.VastSurfaceHolder
    public Surface getSurface() {
        return this.surfaceView.getHolder().getSurface();
    }

    @Override // com.smaato.sdk.video.vast.widget.VastSurfaceHolder
    public void setOnSurfaceAvailableListener(VastSurfaceHolder.OnSurfaceAvailableListener onSurfaceAvailableListener) {
        this.onSurfaceAvailableListener = onSurfaceAvailableListener;
    }

    @Override // com.smaato.sdk.video.vast.widget.VastSurfaceHolder
    public void setOnSurfaceChangedListener(VastSurfaceHolder.OnSurfaceChangedListener onSurfaceChangedListener) {
        this.onSurfaceChangedListener = onSurfaceChangedListener;
    }

    @Override // com.smaato.sdk.video.vast.widget.VastSurfaceHolder
    public void setOnSurfaceDestroyedListener(VastSurfaceHolder.OnSurfaceDestroyedListener onSurfaceDestroyedListener) {
        this.onSurfaceDestroyedListener = onSurfaceDestroyedListener;
    }
}
