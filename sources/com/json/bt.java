package com.json;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/ironsource/bt;", "Lcom/ironsource/lm;", "Lcom/ironsource/vs;", "Lcom/ironsource/v;", "input", "a", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class bt implements lm<vs, v> {
    @Override // com.json.lm
    public v a(vs input) {
        ig adProvider;
        String strC;
        String strG;
        String strI;
        String advertiserBundleId;
        Intrinsics.checkNotNullParameter(input, "input");
        ct ctVarB = input.b();
        o0 adInternalInfo = input.getAdInternalInfo();
        String str = (adInternalInfo == null || (advertiserBundleId = adInternalInfo.getAdvertiserBundleId()) == null) ? "0" : advertiserBundleId;
        o0 adInternalInfo2 = input.getAdInternalInfo();
        String str2 = (adInternalInfo2 == null || (strI = adInternalInfo2.i()) == null) ? "0" : strI;
        o0 adInternalInfo3 = input.getAdInternalInfo();
        String str3 = (adInternalInfo3 == null || (strG = adInternalInfo3.g()) == null) ? "0" : strG;
        o0 adInternalInfo4 = input.getAdInternalInfo();
        if (adInternalInfo4 == null || (adProvider = adInternalInfo4.getAdProvider()) == null) {
            adProvider = ig.UnknownProvider;
        }
        ig igVar = adProvider;
        o0 adInternalInfo5 = input.getAdInternalInfo();
        if (adInternalInfo5 == null || (strC = adInternalInfo5.c()) == null) {
            strC = "0";
        }
        return new v(ctVarB, str, str2, str3, igVar, strC);
    }
}
