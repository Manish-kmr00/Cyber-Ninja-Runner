package io.bidmachine.media3.exoplayer.image;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes9.dex */
public interface ImageOutput {
    public static final ImageOutput NO_OP = new ImageOutput() { // from class: io.bidmachine.media3.exoplayer.image.ImageOutput.1
        @Override // io.bidmachine.media3.exoplayer.image.ImageOutput
        public void onDisabled() {
        }

        @Override // io.bidmachine.media3.exoplayer.image.ImageOutput
        public void onImageAvailable(long j, Bitmap bitmap) {
        }
    };

    void onDisabled();

    void onImageAvailable(long j, Bitmap bitmap);
}
