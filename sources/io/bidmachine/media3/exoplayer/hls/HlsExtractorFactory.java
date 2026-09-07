package io.bidmachine.media3.exoplayer.hls;

import android.net.Uri;
import io.bidmachine.media3.common.Format;
import io.bidmachine.media3.common.util.TimestampAdjuster;
import io.bidmachine.media3.exoplayer.analytics.PlayerId;
import io.bidmachine.media3.extractor.ExtractorInput;
import io.bidmachine.media3.extractor.text.SubtitleParser;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public interface HlsExtractorFactory {
    public static final HlsExtractorFactory DEFAULT = new DefaultHlsExtractorFactory();

    HlsMediaChunkExtractor createExtractor(Uri uri, Format format, List<Format> list, TimestampAdjuster timestampAdjuster, Map<String, List<String>> map, ExtractorInput extractorInput, PlayerId playerId) throws IOException;

    default HlsExtractorFactory experimentalParseSubtitlesDuringExtraction(boolean z) {
        return this;
    }

    default Format getOutputTextFormat(Format format) {
        return format;
    }

    default HlsExtractorFactory setSubtitleParserFactory(SubtitleParser.Factory factory) {
        return this;
    }
}
