package com.bytedance.sdk.openadsdk.core.WV;

import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.WV;
import com.iab.omid.library.bytedance2.adsession.AdEvents;
import com.iab.omid.library.bytedance2.adsession.AdSession;
import com.iab.omid.library.bytedance2.adsession.AdSessionConfiguration;
import com.iab.omid.library.bytedance2.adsession.AdSessionContext;
import com.iab.omid.library.bytedance2.adsession.CreativeType;
import com.iab.omid.library.bytedance2.adsession.ImpressionType;
import com.iab.omid.library.bytedance2.adsession.Owner;
import com.iab.omid.library.bytedance2.adsession.Partner;
import com.iab.omid.library.bytedance2.adsession.VerificationScriptResource;
import com.iab.omid.library.bytedance2.adsession.media.MediaEvents;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class omh {
    public static SD pA(View view, Set<SGo> set) {
        AdSession adSessionPA = pA(CreativeType.VIDEO, set, Owner.NATIVE);
        return new Bzk(adSessionPA, AdEvents.createAdEvents(adSessionPA), view, MediaEvents.createMediaEvents(adSessionPA));
    }

    public static SD pA(WebView webView) {
        Partner partnerPA = ML.pA();
        if (partnerPA == null) {
            throw new IllegalArgumentException("Parameter 'partner' may not be null.");
        }
        AdSession adSessionCreateAdSession = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(CreativeType.HTML_DISPLAY, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, Owner.NONE, false), AdSessionContext.createHtmlAdSessionContext(partnerPA, webView, "", ""));
        return new SD(adSessionCreateAdSession, AdEvents.createAdEvents(adSessionCreateAdSession), webView);
    }

    private static AdSession pA(CreativeType creativeType, Set<SGo> set, Owner owner) {
        List<VerificationScriptResource> listPA = pA(set);
        if (listPA.isEmpty()) {
            WV.Og("verificationScriptResources is empty");
        }
        Partner partnerPA = ML.pA();
        if (partnerPA == null) {
            return null;
        }
        return AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(creativeType, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, owner, false), AdSessionContext.createNativeAdSessionContext(partnerPA, ML.Og(), listPA, "", ""));
    }

    private static List<VerificationScriptResource> pA(Set<SGo> set) {
        ArrayList arrayList = new ArrayList();
        for (SGo sGo : set) {
            try {
                if (TextUtils.isEmpty(sGo.pA()) || TextUtils.isEmpty(sGo.Og())) {
                    arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithoutParameters(sGo.KZx()));
                } else {
                    arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithParameters(sGo.pA(), sGo.KZx(), sGo.Og()));
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }
}
