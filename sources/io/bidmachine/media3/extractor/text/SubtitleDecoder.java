package io.bidmachine.media3.extractor.text;

import io.bidmachine.media3.decoder.Decoder;

/* JADX INFO: loaded from: classes12.dex */
public interface SubtitleDecoder extends Decoder<SubtitleInputBuffer, SubtitleOutputBuffer, SubtitleDecoderException> {
    void setPositionUs(long j);
}
