package net.pubnative.lite.sdk.vpaid.models.vast;

import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface VastAdSource {
    AdServingId getAdServingId();

    AdSystem getAdSystem();

    AdVerifications getAdVerifications();

    List<Category> getCategories();

    Creatives getCreatives();

    List<Error> getErrors();

    Extensions getExtensions();

    List<Impression> getImpressions();

    Pricing getPricing();

    ViewableImpression getViewableImpression();
}
