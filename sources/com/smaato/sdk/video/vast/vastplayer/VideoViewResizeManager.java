package com.smaato.sdk.video.vast.vastplayer;

import com.smaato.sdk.core.util.Size;
import com.smaato.sdk.video.vast.model.MediaFile;

/* JADX INFO: loaded from: classes10.dex */
public class VideoViewResizeManager {
    private final Size mediaFileSize;

    VideoViewResizeManager(Size size) {
        this.mediaFileSize = size;
    }

    public static VideoViewResizeManager create(MediaFile mediaFile) {
        Float f = mediaFile.width;
        int iRound = f == null ? 0 : Math.round(f.floatValue());
        Float f2 = mediaFile.height;
        int iRound2 = f2 != null ? Math.round(f2.floatValue()) : 0;
        if (iRound == 0 || iRound2 == 0) {
            iRound = 16;
            iRound2 = 9;
        }
        return new VideoViewResizeManager(new Size(iRound, iRound2));
    }

    public void resizeToContainerSizes(VideoPlayerView videoPlayerView, int i, int i2, int i3, int i4) {
        boolean z = (i3 == 0 || i4 == 0) ? false : true;
        if (!z) {
            i3 = this.mediaFileSize.width;
        }
        if (!z) {
            i4 = this.mediaFileSize.height;
        }
        float f = i3;
        float f2 = i4;
        float f3 = i;
        float f4 = i2;
        if (f3 / f4 > f / f2) {
            i = Math.round(f * (f4 / f2));
        } else {
            i2 = Math.round(f2 * (f3 / f));
        }
        videoPlayerView.setVideoSize(i, i2);
    }
}
