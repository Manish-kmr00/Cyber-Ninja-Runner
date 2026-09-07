package com.smaato.sdk.video.vast.widget;

import android.view.Surface;
import android.view.View;

/* JADX INFO: loaded from: classes6.dex */
public interface VastSurfaceHolder {

    public interface OnSurfaceAvailableListener {
        void onSurfaceAvailable(Surface surface, int i, int i2);
    }

    public interface OnSurfaceChangedListener {
        void onSurfaceChanged(Surface surface, int i, int i2);
    }

    public interface OnSurfaceDestroyedListener {
        void onSurfaceDestroyed(Surface surface);
    }

    Surface getSurface();

    View getView();

    void setOnSurfaceAvailableListener(OnSurfaceAvailableListener onSurfaceAvailableListener);

    void setOnSurfaceChangedListener(OnSurfaceChangedListener onSurfaceChangedListener);

    void setOnSurfaceDestroyedListener(OnSurfaceDestroyedListener onSurfaceDestroyedListener);
}
