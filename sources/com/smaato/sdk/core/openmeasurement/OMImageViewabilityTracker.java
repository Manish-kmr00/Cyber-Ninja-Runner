package com.smaato.sdk.core.openmeasurement;

import android.util.Log;
import android.view.View;
import com.iab.omid.library.smaato.Omid;
import com.iab.omid.library.smaato.adsession.AdEvents;
import com.iab.omid.library.smaato.adsession.AdSession;
import com.iab.omid.library.smaato.adsession.AdSessionConfiguration;
import com.iab.omid.library.smaato.adsession.AdSessionContext;
import com.iab.omid.library.smaato.adsession.CreativeType;
import com.iab.omid.library.smaato.adsession.ImpressionType;
import com.iab.omid.library.smaato.adsession.Owner;
import com.iab.omid.library.smaato.adsession.Partner;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.smaato.sdk.core.AndroidsInjector;
import com.smaato.sdk.core.util.Threads;
import com.smaato.sdk.core.util.diinjection.Inject;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public class OMImageViewabilityTracker extends BaseOMViewabilityTracker {

    @Inject
    private OMImageResourceMapper resourceMapper;

    public OMImageViewabilityTracker() {
        AndroidsInjector.inject(this);
    }

    public void registerAdView(final View view, Map<String, List<ViewabilityVerificationResource>> map) {
        Threads.runOnUi(new Runnable() { // from class: com.smaato.sdk.core.openmeasurement.OMImageViewabilityTracker$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                OMImageViewabilityTracker.lambda$registerAdView$0(view);
            }
        });
        AdSessionConfiguration adSessionConfigurationCreateAdSessionConfiguration = AdSessionConfiguration.createAdSessionConfiguration(CreativeType.NATIVE_DISPLAY, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, Owner.NONE, false);
        List<ViewabilityVerificationResource> listEmptyList = map.get(CampaignEx.KEY_OMID);
        Partner partner = this.partner;
        String str = this.omidJsServiceContent;
        OMImageResourceMapper oMImageResourceMapper = this.resourceMapper;
        if (listEmptyList == null) {
            listEmptyList = Collections.emptyList();
        }
        AdSession adSessionCreateAdSession = AdSession.createAdSession(adSessionConfigurationCreateAdSessionConfiguration, AdSessionContext.createNativeAdSessionContext(partner, str, oMImageResourceMapper.apply(listEmptyList), null, ""));
        this.adSession = adSessionCreateAdSession;
        adSessionCreateAdSession.registerAdView(view);
        Log.i("OMTracker", "OM Viewabiltiy registerAdView");
        this.adEvents = AdEvents.createAdEvents(this.adSession);
    }

    static /* synthetic */ void lambda$registerAdView$0(View view) {
        if (Omid.isActive()) {
            return;
        }
        Omid.activate(view.getContext());
    }
}
