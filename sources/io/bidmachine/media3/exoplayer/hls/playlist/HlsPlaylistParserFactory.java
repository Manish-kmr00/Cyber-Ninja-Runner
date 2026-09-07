package io.bidmachine.media3.exoplayer.hls.playlist;

import io.bidmachine.media3.exoplayer.upstream.ParsingLoadable;

/* JADX INFO: loaded from: classes6.dex */
public interface HlsPlaylistParserFactory {
    ParsingLoadable.Parser<HlsPlaylist> createPlaylistParser();

    ParsingLoadable.Parser<HlsPlaylist> createPlaylistParser(HlsMultivariantPlaylist hlsMultivariantPlaylist, HlsMediaPlaylist hlsMediaPlaylist);
}
