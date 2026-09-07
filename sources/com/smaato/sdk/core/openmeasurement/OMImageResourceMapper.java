package com.smaato.sdk.core.openmeasurement;

import com.iab.omid.library.smaato.adsession.VerificationScriptResource;
import com.smaato.sdk.core.util.TextUtils;
import com.smaato.sdk.core.util.fi.Function;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class OMImageResourceMapper implements Function<List<ViewabilityVerificationResource>, List<VerificationScriptResource>> {
    @Override // com.smaato.sdk.core.util.fi.Function
    public List<VerificationScriptResource> apply(List<ViewabilityVerificationResource> list) {
        ArrayList arrayList = new ArrayList();
        for (ViewabilityVerificationResource viewabilityVerificationResource : list) {
            URL url = parseUrl(viewabilityVerificationResource.getJsScriptUrl());
            if (url != null) {
                arrayList.add(createOmScriptResource(viewabilityVerificationResource.getVendor(), url, viewabilityVerificationResource.getParameters()));
            }
        }
        return arrayList;
    }

    private URL parseUrl(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    private VerificationScriptResource createOmScriptResource(String str, URL url, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return VerificationScriptResource.createVerificationScriptResourceWithoutParameters(url);
        }
        return VerificationScriptResource.createVerificationScriptResourceWithParameters(str, url, str2);
    }
}
