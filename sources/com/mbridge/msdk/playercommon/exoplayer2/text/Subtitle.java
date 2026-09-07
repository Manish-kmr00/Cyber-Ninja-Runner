package com.mbridge.msdk.playercommon.exoplayer2.text;

import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public interface Subtitle {
    List<Cue> getCues(long j);

    long getEventTime(int i);

    int getEventTimeCount();

    int getNextEventTimeIndex(long j);
}
