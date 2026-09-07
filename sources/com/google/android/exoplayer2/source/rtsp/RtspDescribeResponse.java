package com.google.android.exoplayer2.source.rtsp;

/* JADX INFO: loaded from: classes7.dex */
final class RtspDescribeResponse {
    public final SessionDescription sessionDescription;
    public final int status;

    public RtspDescribeResponse(int i, SessionDescription sessionDescription) {
        this.status = i;
        this.sessionDescription = sessionDescription;
    }
}
