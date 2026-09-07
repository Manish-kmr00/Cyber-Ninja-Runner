package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.MediaItem;

/* JADX INFO: loaded from: classes11.dex */
public interface DrmSessionManagerProvider {
    DrmSessionManager get(MediaItem mediaItem);
}
