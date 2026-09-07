package com.smaato.sdk.richmedia.mraid.dataprovider;

import com.smaato.sdk.core.util.Objects;
import java.util.Locale;

/* JADX INFO: loaded from: classes12.dex */
public final class MraidAudioVolumeLevel {
    private final String audioVolumeLevel;

    private MraidAudioVolumeLevel(String str) {
        this.audioVolumeLevel = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MraidAudioVolumeLevel.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.audioVolumeLevel, ((MraidAudioVolumeLevel) obj).audioVolumeLevel);
    }

    public int hashCode() {
        return Objects.hash(this.audioVolumeLevel);
    }

    public String getAudioVolumeLevel() {
        return this.audioVolumeLevel;
    }

    public static MraidAudioVolumeLevel create(int i, int i2) {
        if (i2 == 0) {
            return new MraidAudioVolumeLevel(null);
        }
        return new MraidAudioVolumeLevel(String.format(Locale.US, "%.1f", Float.valueOf((i * 100.0f) / i2)));
    }
}
