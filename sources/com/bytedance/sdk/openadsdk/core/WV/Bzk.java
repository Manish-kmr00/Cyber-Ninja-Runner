package com.bytedance.sdk.openadsdk.core.WV;

import android.view.View;
import com.iab.omid.library.bytedance2.adsession.AdEvents;
import com.iab.omid.library.bytedance2.adsession.AdSession;
import com.iab.omid.library.bytedance2.adsession.media.InteractionType;
import com.iab.omid.library.bytedance2.adsession.media.MediaEvents;
import com.iab.omid.library.bytedance2.adsession.media.PlayerState;
import com.iab.omid.library.bytedance2.adsession.media.Position;
import com.iab.omid.library.bytedance2.adsession.media.VastProperties;

/* JADX INFO: loaded from: classes13.dex */
public class Bzk extends SD {
    private boolean JG;
    private final MediaEvents ML;

    public Bzk(AdSession adSession, AdEvents adEvents, View view, MediaEvents mediaEvents) {
        super(adSession, adEvents, view);
        this.ML = mediaEvents;
    }

    @Override // com.bytedance.sdk.openadsdk.core.WV.SD
    public void pA(boolean z, float f) {
        if (z) {
            this.ZZv = VastProperties.createVastPropertiesForSkippableMedia(f, true, Position.STANDALONE);
        } else {
            this.ZZv = VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE);
        }
        pA(2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.WV.SD
    public void pA(float f, boolean z) {
        if (pA()) {
            this.ML.start(f, z ? 0.0f : 1.0f);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.WV.SD
    public void pA(boolean z) {
        this.JG = z;
        Og(12);
    }

    @Override // com.bytedance.sdk.openadsdk.core.WV.SD
    public void Og(int i) {
        if (pA()) {
            switch (i) {
                case 0:
                    this.ML.pause();
                    break;
                case 1:
                    this.ML.resume();
                    break;
                case 2:
                case 14:
                    this.ML.skipped();
                    break;
                case 4:
                    this.ML.bufferStart();
                    break;
                case 5:
                    this.ML.bufferFinish();
                    break;
                case 6:
                    this.ML.firstQuartile();
                    break;
                case 7:
                    this.ML.midpoint();
                    break;
                case 8:
                    this.ML.thirdQuartile();
                    break;
                case 9:
                    this.ML.complete();
                    break;
                case 10:
                    this.ML.playerStateChange(PlayerState.FULLSCREEN);
                    break;
                case 11:
                    this.ML.playerStateChange(PlayerState.NORMAL);
                    break;
                case 12:
                    this.ML.volumeChange(this.JG ? 0.0f : 1.0f);
                    break;
                case 13:
                    this.ML.adUserInteraction(InteractionType.CLICK);
                    break;
            }
        }
    }
}
