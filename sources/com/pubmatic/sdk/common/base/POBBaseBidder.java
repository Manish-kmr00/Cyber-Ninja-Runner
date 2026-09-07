package com.pubmatic.sdk.common.base;

import com.pubmatic.sdk.common.base.POBAdDescriptor;
import java.util.Set;

/* JADX INFO: loaded from: classes8.dex */
public abstract class POBBaseBidder<T extends POBAdDescriptor> implements POBBidding<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7554a;
    protected POBBidderListener<T> bidderListener;

    public interface CountryFilterConfig {
        String getCountryFilteringMode();

        Set<String> getFilteringCountries();
    }

    @Override // com.pubmatic.sdk.common.base.POBBidding
    public String getIdentifier() {
        return this.f7554a;
    }

    @Override // com.pubmatic.sdk.common.base.POBBidding
    public void setBidderListener(POBBidderListener<T> pOBBidderListener) {
        this.bidderListener = pOBBidderListener;
    }

    public void setCountryFilterConfig(CountryFilterConfig countryFilterConfig) {
    }

    public void setIdentifier(String str) {
        this.f7554a = str;
    }
}
