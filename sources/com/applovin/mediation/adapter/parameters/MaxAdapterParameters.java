package com.applovin.mediation.adapter.parameters;

import android.os.Bundle;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public interface MaxAdapterParameters {
    String getAdUnitId();

    String getConsentString();

    Bundle getCustomParameters();

    Map<String, Object> getLocalExtraParameters();

    Bundle getServerParameters();

    Boolean hasUserConsent();

    @Deprecated
    Boolean isAgeRestrictedUser();

    Boolean isDoNotSell();

    boolean isTesting();
}
