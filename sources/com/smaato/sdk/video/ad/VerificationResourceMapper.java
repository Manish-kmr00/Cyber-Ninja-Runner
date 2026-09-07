package com.smaato.sdk.video.ad;

import com.smaato.sdk.core.openmeasurement.ViewabilityVerificationResource;
import com.smaato.sdk.core.util.collections.Iterables;
import com.smaato.sdk.core.util.fi.BiFunction;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.core.util.fi.Function;
import com.smaato.sdk.video.vast.model.JavaScriptResource;
import com.smaato.sdk.video.vast.model.Verification;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public final class VerificationResourceMapper implements Function<List<Verification>, Map<String, List<ViewabilityVerificationResource>>> {
    @Override // com.smaato.sdk.core.util.fi.Function
    public Map<String, List<ViewabilityVerificationResource>> apply(List<Verification> list) {
        return (Map) Iterables.reduce(list, new HashMap(), new BiFunction() { // from class: com.smaato.sdk.video.ad.VerificationResourceMapper$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return VerificationResourceMapper.lambda$apply$1((Verification) obj, (HashMap) obj2);
            }
        });
    }

    static /* synthetic */ HashMap lambda$apply$1(final Verification verification, final HashMap map) {
        Iterables.forEach(verification.javaScriptResources, new Consumer() { // from class: com.smaato.sdk.video.ad.VerificationResourceMapper$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                VerificationResourceMapper.lambda$apply$0(map, verification, (JavaScriptResource) obj);
            }
        });
        return map;
    }

    static /* synthetic */ void lambda$apply$0(HashMap map, Verification verification, JavaScriptResource javaScriptResource) {
        String str = javaScriptResource.apiFramework;
        List arrayList = (List) map.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            map.put(str, arrayList);
        }
        arrayList.add(new ViewabilityVerificationResource(verification.vendor, javaScriptResource.uri, javaScriptResource.apiFramework, verification.verificationParameters, javaScriptResource.browserOptional));
    }
}
