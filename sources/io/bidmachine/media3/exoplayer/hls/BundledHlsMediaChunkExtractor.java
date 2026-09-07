package io.bidmachine.media3.exoplayer.hls;

import io.bidmachine.media3.common.Format;
import io.bidmachine.media3.common.util.Assertions;
import io.bidmachine.media3.common.util.TimestampAdjuster;
import io.bidmachine.media3.extractor.Extractor;
import io.bidmachine.media3.extractor.ExtractorInput;
import io.bidmachine.media3.extractor.ExtractorOutput;
import io.bidmachine.media3.extractor.PositionHolder;
import io.bidmachine.media3.extractor.mp3.Mp3Extractor;
import io.bidmachine.media3.extractor.mp4.FragmentedMp4Extractor;
import io.bidmachine.media3.extractor.text.SubtitleParser;
import io.bidmachine.media3.extractor.ts.Ac3Extractor;
import io.bidmachine.media3.extractor.ts.Ac4Extractor;
import io.bidmachine.media3.extractor.ts.AdtsExtractor;
import io.bidmachine.media3.extractor.ts.TsExtractor;
import java.io.IOException;

/* JADX INFO: loaded from: classes7.dex */
public final class BundledHlsMediaChunkExtractor implements HlsMediaChunkExtractor {
    private static final PositionHolder POSITION_HOLDER = new PositionHolder();
    final Extractor extractor;
    private final Format multivariantPlaylistFormat;
    private final boolean parseSubtitlesDuringExtraction;
    private final SubtitleParser.Factory subtitleParserFactory;
    private final TimestampAdjuster timestampAdjuster;

    public BundledHlsMediaChunkExtractor(Extractor extractor, Format format, TimestampAdjuster timestampAdjuster) {
        this(extractor, format, timestampAdjuster, SubtitleParser.Factory.UNSUPPORTED, false);
    }

    BundledHlsMediaChunkExtractor(Extractor extractor, Format format, TimestampAdjuster timestampAdjuster, SubtitleParser.Factory factory, boolean z) {
        this.extractor = extractor;
        this.multivariantPlaylistFormat = format;
        this.timestampAdjuster = timestampAdjuster;
        this.subtitleParserFactory = factory;
        this.parseSubtitlesDuringExtraction = z;
    }

    @Override // io.bidmachine.media3.exoplayer.hls.HlsMediaChunkExtractor
    public void init(ExtractorOutput extractorOutput) {
        this.extractor.init(extractorOutput);
    }

    @Override // io.bidmachine.media3.exoplayer.hls.HlsMediaChunkExtractor
    public boolean read(ExtractorInput extractorInput) throws IOException {
        return this.extractor.read(extractorInput, POSITION_HOLDER) == 0;
    }

    @Override // io.bidmachine.media3.exoplayer.hls.HlsMediaChunkExtractor
    public boolean isPackedAudioExtractor() {
        Extractor underlyingImplementation = this.extractor.getUnderlyingImplementation();
        return (underlyingImplementation instanceof AdtsExtractor) || (underlyingImplementation instanceof Ac3Extractor) || (underlyingImplementation instanceof Ac4Extractor) || (underlyingImplementation instanceof Mp3Extractor);
    }

    @Override // io.bidmachine.media3.exoplayer.hls.HlsMediaChunkExtractor
    public boolean isReusable() {
        Extractor underlyingImplementation = this.extractor.getUnderlyingImplementation();
        return (underlyingImplementation instanceof TsExtractor) || (underlyingImplementation instanceof FragmentedMp4Extractor);
    }

    @Override // io.bidmachine.media3.exoplayer.hls.HlsMediaChunkExtractor
    public HlsMediaChunkExtractor recreate() {
        Extractor mp3Extractor;
        Assertions.checkState(!isReusable());
        Assertions.checkState(this.extractor.getUnderlyingImplementation() == this.extractor, "Can't recreate wrapped extractors. Outer type: " + this.extractor.getClass());
        Extractor extractor = this.extractor;
        if (extractor instanceof WebvttExtractor) {
            mp3Extractor = new WebvttExtractor(this.multivariantPlaylistFormat.language, this.timestampAdjuster, this.subtitleParserFactory, this.parseSubtitlesDuringExtraction);
        } else if (extractor instanceof AdtsExtractor) {
            mp3Extractor = new AdtsExtractor();
        } else if (extractor instanceof Ac3Extractor) {
            mp3Extractor = new Ac3Extractor();
        } else if (extractor instanceof Ac4Extractor) {
            mp3Extractor = new Ac4Extractor();
        } else if (extractor instanceof Mp3Extractor) {
            mp3Extractor = new Mp3Extractor();
        } else {
            throw new IllegalStateException("Unexpected extractor type for recreation: " + this.extractor.getClass().getSimpleName());
        }
        return new BundledHlsMediaChunkExtractor(mp3Extractor, this.multivariantPlaylistFormat, this.timestampAdjuster, this.subtitleParserFactory, this.parseSubtitlesDuringExtraction);
    }

    @Override // io.bidmachine.media3.exoplayer.hls.HlsMediaChunkExtractor
    public void onTruncatedSegmentParsed() {
        this.extractor.seek(0L, 0L);
    }
}
