package io.bidmachine.media3.extractor.mp3;

import io.bidmachine.media3.extractor.SeekMap;

/* JADX INFO: loaded from: classes3.dex */
interface Seeker extends SeekMap {
    int getAverageBitrate();

    long getDataEndPosition();

    long getTimeUs(long j);

    public static class UnseekableSeeker extends SeekMap.Unseekable implements Seeker {
        @Override // io.bidmachine.media3.extractor.mp3.Seeker
        public int getAverageBitrate() {
            return -2147483647;
        }

        @Override // io.bidmachine.media3.extractor.mp3.Seeker
        public long getDataEndPosition() {
            return -1L;
        }

        @Override // io.bidmachine.media3.extractor.mp3.Seeker
        public long getTimeUs(long j) {
            return 0L;
        }

        public UnseekableSeeker() {
            super(-9223372036854775807L);
        }
    }
}
