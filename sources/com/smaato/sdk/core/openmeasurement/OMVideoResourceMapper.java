package com.smaato.sdk.core.openmeasurement;

import com.iab.omid.library.smaato.adsession.VerificationScriptResource;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.TextUtils;
import com.smaato.sdk.core.util.fi.Function;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public final class OMVideoResourceMapper implements Function<List<ViewabilityVerificationResource>, List<VerificationScriptResource>> {
    private final String frameworkName;

    public OMVideoResourceMapper(String str) {
        this.frameworkName = (String) Objects.requireNonNull(str);
    }

    @Override // com.smaato.sdk.core.util.fi.Function
    public List<VerificationScriptResource> apply(List<ViewabilityVerificationResource> list) {
        URL url;
        ArrayList arrayList = new ArrayList();
        for (ViewabilityVerificationResource viewabilityVerificationResource : list) {
            if (viewabilityVerificationResource.getApiFramework().equals(this.frameworkName) && viewabilityVerificationResource.isNoBrowser() && (url = parseUrl(viewabilityVerificationResource.getJsScriptUrl())) != null) {
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
