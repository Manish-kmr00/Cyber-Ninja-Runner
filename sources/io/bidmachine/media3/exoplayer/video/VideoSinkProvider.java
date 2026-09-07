package io.bidmachine.media3.exoplayer.video;

import android.view.Surface;
import io.bidmachine.media3.common.util.Size;

/* JADX INFO: loaded from: classes7.dex */
public interface VideoSinkProvider {
    void clearOutputSurfaceInfo();

    VideoSink getSink();

    VideoFrameReleaseControl getVideoFrameReleaseControl();

    void release();

    void setOutputSurfaceInfo(Surface surface, Size size);
}
