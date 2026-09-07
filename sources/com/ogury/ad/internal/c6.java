package com.ogury.ad.internal;

import com.iab.omid.library.ogury.adsession.AdSessionConfiguration;
import com.iab.omid.library.ogury.adsession.AdSessionContext;
import com.iab.omid.library.ogury.adsession.CreativeType;
import com.iab.omid.library.ogury.adsession.ImpressionType;
import com.iab.omid.library.ogury.adsession.Owner;
import com.iab.omid.library.ogury.adsession.Partner;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class c6 {
    public static d6 a(d5 adWebView, boolean z) {
        Partner partnerCreatePartner;
        AdSessionContext adSessionContextCreateHtmlAdSessionContext;
        Intrinsics.checkNotNullParameter(adWebView, "adWebView");
        d6 d6Var = new d6();
        AdSessionConfiguration adSessionConfigurationCreateAdSessionConfiguration = null;
        try {
            partnerCreatePartner = Partner.createPartner("Ogury", "5.0.1");
        } catch (IllegalArgumentException error) {
            Intrinsics.checkNotNullParameter(error, "error");
            partnerCreatePartner = null;
        }
        if (partnerCreatePartner == null) {
            return null;
        }
        try {
            adSessionContextCreateHtmlAdSessionContext = AdSessionContext.createHtmlAdSessionContext(partnerCreatePartner, adWebView, "", null);
        } catch (IllegalArgumentException error2) {
            Intrinsics.checkNotNullParameter(error2, "error");
            adSessionContextCreateHtmlAdSessionContext = null;
        }
        d6Var.f7281a = adSessionContextCreateHtmlAdSessionContext;
        ImpressionType impressionType = ImpressionType.DEFINED_BY_JAVASCRIPT;
        CreativeType creativeType = CreativeType.DEFINED_BY_JAVASCRIPT;
        Owner owner = Owner.JAVASCRIPT;
        Owner owner2 = Owner.NONE;
        if (z) {
            owner2 = owner;
        }
        try {
            adSessionConfigurationCreateAdSessionConfiguration = AdSessionConfiguration.createAdSessionConfiguration(creativeType, impressionType, owner, owner2, false);
        } catch (IllegalArgumentException error3) {
            Intrinsics.checkNotNullParameter(error3, "error");
        }
        d6Var.b = adSessionConfigurationCreateAdSessionConfiguration;
        return d6Var;
    }
}
