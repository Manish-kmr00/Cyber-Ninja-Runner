package io.bidmachine.media3.exoplayer.drm;

import io.bidmachine.media3.common.MediaItem;

/* JADX INFO: loaded from: classes8.dex */
public interface DrmSessionManagerProvider {
    DrmSessionManager get(MediaItem mediaItem);
}
