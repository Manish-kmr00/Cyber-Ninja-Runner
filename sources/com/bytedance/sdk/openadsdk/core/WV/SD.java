package com.bytedance.sdk.openadsdk.core.WV;

import android.util.Pair;
import android.view.View;
import com.iab.omid.library.bytedance2.adsession.AdEvents;
import com.iab.omid.library.bytedance2.adsession.AdSession;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.bytedance2.adsession.media.Position;
import com.iab.omid.library.bytedance2.adsession.media.VastProperties;
import java.util.Set;

/* JADX INFO: loaded from: classes13.dex */
public class SD {
    private final AdEvents JG;
    protected String KZx;
    private final AdSession ML;
    protected VastProperties ZZv;
    private boolean SD = false;
    protected boolean pA = false;
    protected int Og = 0;

    void Og(int i) {
    }

    void pA(float f, boolean z) {
    }

    public void pA(boolean z) {
    }

    public void pA(boolean z, float f) {
    }

    public SD(AdSession adSession, AdEvents adEvents, View view) {
        this.ML = adSession;
        this.JG = adEvents;
        this.KZx = adSession.getAdSessionId();
        pA(view);
    }

    void pA(View view) {
        AdSession adSession;
        if (view == null || (adSession = this.ML) == null) {
            return;
        }
        adSession.registerAdView(view);
    }

    public void pA(View view, FriendlyObstructionPurpose friendlyObstructionPurpose) {
        AdSession adSession = this.ML;
        if (adSession != null) {
            adSession.addFriendlyObstruction(view, friendlyObstructionPurpose, null);
        }
    }

    boolean pA() {
        return this.pA;
    }

    public void pA(int i) {
        int i2;
        if (this.ML == null || this.JG == null || !ML.KZx()) {
            return;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4 || (i2 = this.Og) == 0 || i2 == 4) {
                        return;
                    }
                    this.ML.finish();
                    this.pA = false;
                } else {
                    if (this.SD) {
                        return;
                    }
                    int i3 = this.Og;
                    if (i3 != 1 && i3 != 2) {
                        return;
                    }
                    this.JG.impressionOccurred();
                    this.SD = true;
                }
            } else {
                if (this.Og != 0) {
                    return;
                }
                this.ML.start();
                if (this.ZZv == null) {
                    this.ZZv = VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE);
                }
                this.JG.loaded(this.ZZv);
                this.pA = true;
                this.ZZv = null;
            }
        } else {
            if (this.Og != 0) {
                return;
            }
            this.ML.start();
            this.JG.loaded();
            this.pA = true;
        }
        this.Og = i;
    }

    void Og() {
        pA(1);
    }

    void KZx() {
        pA(4);
    }

    public void ZZv() {
        pA(3);
    }

    public void pA(Set<Pair<View, FriendlyObstructionPurpose>> set) {
        for (Pair<View, FriendlyObstructionPurpose> pair : set) {
            pA((View) pair.first, (FriendlyObstructionPurpose) pair.second);
        }
    }
}
