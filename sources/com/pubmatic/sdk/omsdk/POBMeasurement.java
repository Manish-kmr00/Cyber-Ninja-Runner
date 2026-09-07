package com.pubmatic.sdk.omsdk;

import android.content.Context;
import android.view.View;
import com.iab.omid.library.pubmatic.Omid;
import com.iab.omid.library.pubmatic.adsession.AdEvents;
import com.iab.omid.library.pubmatic.adsession.AdSession;
import com.iab.omid.library.pubmatic.adsession.FriendlyObstructionPurpose;
import com.pubmatic.sdk.common.POBInstanceProvider;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.viewability.POBMeasurementProvider;
import com.pubmatic.sdk.common.viewability.POBObstructionUpdateListener;

/* JADX INFO: loaded from: classes.dex */
public abstract class POBMeasurement implements POBMeasurementProvider {
    protected static final String TAG = "OMSDK";
    protected AdEvents adEvents;
    protected AdSession adSession;

    @Override // com.pubmatic.sdk.common.viewability.POBObstructionUpdateListener
    public void addFriendlyObstructions(View view, POBObstructionUpdateListener.POBFriendlyObstructionPurpose pOBFriendlyObstructionPurpose) {
        AdSession adSession = this.adSession;
        if (adSession == null) {
            POBLog.error("OMSDK", "Unable to add obstruction", new Object[0]);
            return;
        }
        try {
            adSession.addFriendlyObstruction(view, FriendlyObstructionPurpose.valueOf(pOBFriendlyObstructionPurpose.name()), null);
        } catch (Exception e) {
            POBLog.error("OMSDK", "Unable to add obstruction: %s", e.getMessage());
        }
    }

    @Override // com.pubmatic.sdk.common.viewability.POBMeasurementProvider
    public void finishAdSession() {
        try {
            AdSession adSession = this.adSession;
            if (adSession != null) {
                adSession.removeAllFriendlyObstructions();
                this.adSession.finish();
                POBLog.debug("OMSDK", "Ad session finished id : %s", this.adSession.getAdSessionId());
                this.adSession = null;
            } else {
                POBLog.error("OMSDK", "Unable to finish Ad session", new Object[0]);
            }
        } catch (Exception e) {
            POBLog.error("OMSDK", "Unable to finish Ad session: %s", e.getMessage());
        }
    }

    @Override // com.pubmatic.sdk.common.viewability.POBMeasurementProvider
    public String omSDKVersion() {
        return Omid.getVersion();
    }

    @Override // com.pubmatic.sdk.common.viewability.POBMeasurementProvider
    public void omidJsServiceScript(Context context, POBMeasurementProvider.POBScriptListener pOBScriptListener) {
        POBInstanceProvider.getCacheManager(context).loadInternalServiceJS(pOBScriptListener);
    }

    @Override // com.pubmatic.sdk.common.viewability.POBObstructionUpdateListener
    public void removeFriendlyObstructions(View view) {
        AdSession adSession = this.adSession;
        if (adSession == null) {
            POBLog.error("OMSDK", "Unable to remove obstruction", new Object[0]);
            return;
        }
        try {
            if (view != null) {
                adSession.removeFriendlyObstruction(view);
            } else {
                adSession.removeAllFriendlyObstructions();
            }
        } catch (Exception e) {
            POBLog.error("OMSDK", "Unable to add obstruction: %s", e.getMessage());
        }
    }

    @Override // com.pubmatic.sdk.common.viewability.POBMeasurementProvider
    public void setTrackView(View view) {
        try {
            if (this.adSession != null) {
                POBLog.debug("OMSDK", "Track view changed", new Object[0]);
                this.adSession.registerAdView(view);
            } else {
                POBLog.error("OMSDK", "Unable to change track view", new Object[0]);
            }
        } catch (Exception e) {
            POBLog.error("OMSDK", "Unable to change track view: %s", e.getMessage());
        }
    }
}
