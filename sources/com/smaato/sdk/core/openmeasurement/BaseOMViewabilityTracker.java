package com.smaato.sdk.core.openmeasurement;

import android.util.Log;
import android.view.View;
import com.iab.omid.library.smaato.adsession.AdEvents;
import com.iab.omid.library.smaato.adsession.AdSession;
import com.iab.omid.library.smaato.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.smaato.adsession.Partner;
import com.smaato.sdk.core.AndroidsInjector;
import com.smaato.sdk.core.util.diinjection.Inject;
import com.smaato.sdk.core.util.diinjection.Named;

/* JADX INFO: loaded from: classes9.dex */
public abstract class BaseOMViewabilityTracker implements ViewabilityTracker, AndroidsInjector.InjectionAllowed {
    public static final String CUSTOM_REFERENCE_DATA = "";
    protected AdEvents adEvents;
    protected AdSession adSession;

    @Named("OMID_JS")
    @Inject
    protected String omidJsServiceContent;

    @Inject
    protected Partner partner;

    @Override // com.smaato.sdk.core.openmeasurement.ViewabilityTracker
    public void startTracking() {
        AdSession adSession = this.adSession;
        if (adSession != null) {
            adSession.start();
        }
        Log.i("OMTracker", "startTracking");
    }

    @Override // com.smaato.sdk.core.openmeasurement.ViewabilityTracker
    public void stopTracking() {
        Log.i("OMTracker", "stopTracking");
        AdSession adSession = this.adSession;
        if (adSession != null) {
            adSession.finish();
            this.adSession = null;
            this.adEvents = null;
        }
    }

    @Override // com.smaato.sdk.core.openmeasurement.ViewabilityTracker
    public void trackImpression() {
        Log.i("OMTracker", "trackImpression");
        AdEvents adEvents = this.adEvents;
        if (adEvents != null) {
            adEvents.impressionOccurred();
        }
    }

    @Override // com.smaato.sdk.core.openmeasurement.ViewabilityTracker
    public void trackLoaded() {
        Log.i("OMTracker", "trackLoaded");
        AdEvents adEvents = this.adEvents;
        if (adEvents != null) {
            adEvents.loaded();
        }
    }

    @Override // com.smaato.sdk.core.openmeasurement.ViewabilityTracker
    public void registerFriendlyObstruction(View view) {
        Log.i("OMTracker", "registerFriendlyObstruction");
        AdSession adSession = this.adSession;
        if (adSession != null) {
            adSession.addFriendlyObstruction(view, FriendlyObstructionPurpose.OTHER, null);
        }
    }

    @Override // com.smaato.sdk.core.openmeasurement.ViewabilityTracker
    public void removeFriendlyObstruction(View view) {
        Log.i("OMTracker", "removeFriendlyObstruction");
        AdSession adSession = this.adSession;
        if (adSession != null) {
            adSession.removeFriendlyObstruction(view);
        }
    }
}
