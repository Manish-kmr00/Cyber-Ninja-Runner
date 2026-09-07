package com.smaato.sdk.core.mvvm.model.csm;

import com.smaato.sdk.core.csm.CsmAdResponse;
import com.smaato.sdk.core.csm.Network;
import com.smaato.sdk.core.mvvm.model.AdResponse;
import com.smaato.sdk.core.mvvm.model.soma.SomaAdRequest;
import com.smaato.sdk.core.network.SomaException;
import com.smaato.sdk.core.util.fi.Consumer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public abstract class CsmRemoteSource {
    public abstract void loadAd(String str, SomaAdRequest somaAdRequest, Consumer<AdResponse> consumer, Consumer<Throwable> consumer2, CsmParameters csmParameters) throws IOException;

    protected List<Network> getSortedNetworkList(CsmAdResponse csmAdResponse) throws IOException {
        if (csmAdResponse.getNetworks().isEmpty()) {
            throw new SomaException(SomaException.Type.BAD_RESPONSE, "List of csm networks is empty");
        }
        ArrayList arrayList = new ArrayList(csmAdResponse.getNetworks());
        Collections.sort(arrayList, new Comparator() { // from class: com.smaato.sdk.core.mvvm.model.csm.CsmRemoteSource$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Integer.compare(((Network) obj).getPriority(), ((Network) obj2).getPriority());
            }
        });
        return arrayList;
    }
}
