package com.chartboost.sdk.impl;

import com.chartboost.sdk.privacy.model.DataUseConsent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class l5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p8 f1066a;

    public l5(p8 p8Var) {
        this.f1066a = p8Var;
    }

    public List<DataUseConsent> a(o9.b bVar) {
        HashMap<String, DataUseConsent> mapA = this.f1066a.a();
        List<DataUseConsent> listA = a(mapA);
        ArrayList arrayList = new ArrayList();
        HashSet<String> hashSetB = b(bVar);
        if (hashSetB != null) {
            for (DataUseConsent dataUseConsent : listA) {
                if (a(hashSetB, dataUseConsent)) {
                    arrayList.add(dataUseConsent);
                }
            }
        } else {
            if (mapA.containsKey("us_privacy")) {
                arrayList.add(mapA.get("us_privacy"));
            }
            if (mapA.containsKey("coppa")) {
                arrayList.add(mapA.get("coppa"));
            }
            if (mapA.containsKey("lgpd")) {
                arrayList.add(mapA.get("lgpd"));
            }
        }
        return arrayList;
    }

    public final HashSet<String> b(o9.b bVar) {
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    public final boolean a(HashSet<String> hashSet, DataUseConsent dataUseConsent) {
        if (hashSet.contains(dataUseConsent.getPrivacyStandard())) {
            return true;
        }
        b7.b("DataUseConsent " + dataUseConsent.getPrivacyStandard() + " is not whitelisted.", null);
        return false;
    }

    public final List<DataUseConsent> a(HashMap<String, DataUseConsent> map) {
        HashMap map2 = new HashMap(map);
        map2.remove("gdpr");
        return new ArrayList(map2.values());
    }
}
