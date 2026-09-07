package com.smaato.sdk.video.vast.vastplayer.system;

import com.smaato.sdk.core.util.Metadata;
import com.smaato.sdk.video.vast.vastplayer.exception.IOVideoPlayerException;
import com.smaato.sdk.video.vast.vastplayer.exception.MalformedVideoPlayerException;
import com.smaato.sdk.video.vast.vastplayer.exception.TimeoutVideoPlayerException;
import com.smaato.sdk.video.vast.vastplayer.exception.UnknownVideoPlayerException;
import com.smaato.sdk.video.vast.vastplayer.exception.UnsupportedVideoPlayerException;
import com.smaato.sdk.video.vast.vastplayer.exception.VideoPlayerException;

/* JADX INFO: loaded from: classes7.dex */
final class MetadataMapperUtils {
    static Metadata mapToMetadata(int i, int i2) {
        return new Metadata.Builder().putInt("what", i).putInt("extra", i2).build();
    }

    static VideoPlayerException mapToVideoPlayerException(Metadata metadata) {
        Integer num = metadata == null ? null : metadata.getInt("what");
        Integer num2 = metadata != null ? metadata.getInt("extra") : null;
        if (num == null) {
            return new UnknownVideoPlayerException();
        }
        if (num.intValue() == 1) {
            return mapExtraToVideoPlayerException(num2);
        }
        return new UnknownVideoPlayerException();
    }

    private static VideoPlayerException mapExtraToVideoPlayerException(Integer num) {
        if (num == null) {
            return new UnknownVideoPlayerException();
        }
        int iIntValue = num.intValue();
        if (iIntValue == -1010) {
            return new UnsupportedVideoPlayerException();
        }
        if (iIntValue == -1007) {
            return new MalformedVideoPlayerException();
        }
        if (iIntValue == -1004) {
            return new IOVideoPlayerException();
        }
        if (iIntValue == -110) {
            return new TimeoutVideoPlayerException();
        }
        return new UnknownVideoPlayerException();
    }
}
