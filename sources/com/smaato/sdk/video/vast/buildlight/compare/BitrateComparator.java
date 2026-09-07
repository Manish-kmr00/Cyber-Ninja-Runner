package com.smaato.sdk.video.vast.buildlight.compare;

import com.smaato.sdk.video.vast.model.MediaFile;
import java.util.Comparator;

/* JADX INFO: loaded from: classes13.dex */
public class BitrateComparator implements Comparator<MediaFile> {
    private final int desiredBitrate;
    private final boolean isConnectionFast;

    public BitrateComparator(int i, boolean z) {
        this.desiredBitrate = i;
        this.isConnectionFast = z;
    }

    @Override // java.util.Comparator
    public int compare(MediaFile mediaFile, MediaFile mediaFile2) {
        if ((mediaFile == null) ^ (mediaFile2 == null)) {
            return mediaFile == null ? 1 : -1;
        }
        if (mediaFile == null) {
            return 0;
        }
        Integer num = mediaFile.bitrate;
        float fIntValue = num == null ? 0.0f : num.intValue();
        Integer num2 = mediaFile2.bitrate;
        float fIntValue2 = num2 != null ? num2.intValue() : 0.0f;
        if (this.isConnectionFast) {
            return Float.compare(Math.abs(this.desiredBitrate - fIntValue), Math.abs(this.desiredBitrate - fIntValue2));
        }
        return Float.compare(fIntValue, fIntValue2);
    }
}
