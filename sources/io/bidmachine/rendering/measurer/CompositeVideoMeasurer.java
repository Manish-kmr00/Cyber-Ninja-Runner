package io.bidmachine.rendering.measurer;

import android.view.View;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class CompositeVideoMeasurer extends BaseCompositeMeasurer<VideoMeasurer, View> implements VideoMeasurer {
    public CompositeVideoMeasurer(List<VideoMeasurer> measurerList) {
        super(measurerList);
    }

    @Override // io.bidmachine.rendering.measurer.VideoMeasurer
    public void onMediaCompleted() {
        Iterator it = this.f12396a.iterator();
        while (it.hasNext()) {
            ((VideoMeasurer) it.next()).onMediaCompleted();
        }
    }

    @Override // io.bidmachine.rendering.measurer.VideoMeasurer
    public void onMediaFirstQuartile() {
        Iterator it = this.f12396a.iterator();
        while (it.hasNext()) {
            ((VideoMeasurer) it.next()).onMediaFirstQuartile();
        }
    }

    @Override // io.bidmachine.rendering.measurer.VideoMeasurer
    public void onMediaMidpoint() {
        Iterator it = this.f12396a.iterator();
        while (it.hasNext()) {
            ((VideoMeasurer) it.next()).onMediaMidpoint();
        }
    }

    @Override // io.bidmachine.rendering.measurer.VideoMeasurer
    public void onMediaPaused() {
        Iterator it = this.f12396a.iterator();
        while (it.hasNext()) {
            ((VideoMeasurer) it.next()).onMediaPaused();
        }
    }

    @Override // io.bidmachine.rendering.measurer.VideoMeasurer
    public void onMediaResumed() {
        Iterator it = this.f12396a.iterator();
        while (it.hasNext()) {
            ((VideoMeasurer) it.next()).onMediaResumed();
        }
    }

    @Override // io.bidmachine.rendering.measurer.VideoMeasurer
    public void onMediaSkipped() {
        Iterator it = this.f12396a.iterator();
        while (it.hasNext()) {
            ((VideoMeasurer) it.next()).onMediaSkipped();
        }
    }

    @Override // io.bidmachine.rendering.measurer.VideoMeasurer
    public void onMediaStarted(float durationMs, float volume) {
        Iterator it = this.f12396a.iterator();
        while (it.hasNext()) {
            ((VideoMeasurer) it.next()).onMediaStarted(durationMs, volume);
        }
    }

    @Override // io.bidmachine.rendering.measurer.VideoMeasurer
    public void onMediaThirdQuartile() {
        Iterator it = this.f12396a.iterator();
        while (it.hasNext()) {
            ((VideoMeasurer) it.next()).onMediaThirdQuartile();
        }
    }

    @Override // io.bidmachine.rendering.measurer.VideoMeasurer
    public void onMediaVolumeChanged(float volume) {
        Iterator it = this.f12396a.iterator();
        while (it.hasNext()) {
            ((VideoMeasurer) it.next()).onMediaVolumeChanged(volume);
        }
    }
}
