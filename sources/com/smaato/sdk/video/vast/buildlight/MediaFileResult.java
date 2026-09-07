package com.smaato.sdk.video.vast.buildlight;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.collections.Sets;
import com.smaato.sdk.video.vast.model.MediaFile;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public final class MediaFileResult {
    public final Set<Integer> errors;
    public final MediaFile mediaFile;

    private MediaFileResult(Set set, MediaFile mediaFile) {
        this.errors = (Set) Objects.requireNonNull(set);
        this.mediaFile = mediaFile;
    }

    public static class Builder {
        private Set errors;
        private MediaFile mediaFile;

        public Builder setMediaFile(MediaFile mediaFile) {
            this.mediaFile = mediaFile;
            return this;
        }

        public Builder setErrors(Set<Integer> set) {
            this.errors = set;
            return this;
        }

        public MediaFileResult build() {
            return new MediaFileResult(Sets.toImmutableSet(this.errors), this.mediaFile);
        }
    }
}
