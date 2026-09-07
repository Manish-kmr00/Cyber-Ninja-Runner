package com.fyber.inneractive.sdk.external;

import com.fyber.inneractive.sdk.flow.S;
import com.fyber.inneractive.sdk.flow.T;
import com.fyber.inneractive.sdk.renderers.u;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class InneractiveAdViewVideoContentController extends T {
    @Override // com.fyber.inneractive.sdk.flow.H
    public boolean canControl(InneractiveAdSpot inneractiveAdSpot) {
        return inneractiveAdSpot.getAdContent() instanceof S;
    }

    public void pauseVideo() {
    }

    public void playVideo() {
    }

    public void setControlledRenderer(u uVar) {
        new WeakReference(uVar);
    }
}
