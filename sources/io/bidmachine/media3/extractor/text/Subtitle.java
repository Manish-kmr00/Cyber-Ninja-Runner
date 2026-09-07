package io.bidmachine.media3.extractor.text;

import io.bidmachine.media3.common.text.Cue;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public interface Subtitle {
    List<Cue> getCues(long j);

    long getEventTime(int i);

    int getEventTimeCount();

    int getNextEventTimeIndex(long j);
}
