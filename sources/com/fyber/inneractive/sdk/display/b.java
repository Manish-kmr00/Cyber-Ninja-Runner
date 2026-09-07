package com.fyber.inneractive.sdk.display;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.flow.N;
import com.fyber.inneractive.sdk.interfaces.e;
import com.fyber.inneractive.sdk.interfaces.f;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes13.dex */
public final class b extends a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InneractiveAdSpot f1731a;
    public f b;

    @Override // com.fyber.inneractive.sdk.display.a
    public final void a(Activity activity, InneractiveAdSpot inneractiveAdSpot, String str) {
        InneractiveAdSpot spot;
        if (TextUtils.isEmpty(str) || (spot = InneractiveAdSpotManager.get().getSpot(str)) == null || spot.getAdContent() == null) {
            spot = null;
        }
        this.f1731a = spot;
        if (spot != null) {
            InneractiveUnitController selectedUnitController = spot.getSelectedUnitController();
            if (selectedUnitController instanceof InneractiveFullscreenAdActivity.FullScreenRendererProvider) {
                f fullscreenRenderer = ((InneractiveFullscreenAdActivity.FullScreenRendererProvider) selectedUnitController).getFullscreenRenderer();
                this.b = fullscreenRenderer;
                if (fullscreenRenderer != null) {
                    ((N) fullscreenRenderer).initialize(this.f1731a);
                    try {
                        this.b.a(this, activity);
                    } catch (Resources.NotFoundException e) {
                        IAlog.f("Interstitial Activity: %s", e.getMessage());
                    } catch (InneractiveUnitController.AdDisplayError e2) {
                        IAlog.f("Interstitial Activity: %s", e2.getMessage());
                    }
                }
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.e
    public final void destroy() {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.e
    public final void disableCloseButton() {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.e
    public final void dismissAd(boolean z) {
        f fVar = this.b;
        if (fVar != null) {
            fVar.destroy();
            this.b = null;
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.e
    public final View getCloseButton() {
        return null;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.e
    public final ViewGroup getLayout() {
        return null;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.e
    public final boolean isCloseButtonDisplay() {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.e
    public final void secondEndCardWasDisplayed() {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.e
    public final void setActivityOrientation(boolean z, Orientation orientation) {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.e
    public final void showCloseButton(boolean z, int i, int i2) {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.e
    public final void showCloseCountdown() {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.e
    public final void updateCloseCountdown(int i) {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.e
    public final boolean wasDismissedByUser() {
        return false;
    }
}
