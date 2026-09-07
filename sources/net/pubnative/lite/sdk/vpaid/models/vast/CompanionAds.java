package net.pubnative.lite.sdk.vpaid.models.vast;

import java.util.List;
import net.pubnative.lite.sdk.vpaid.xml.Attribute;
import net.pubnative.lite.sdk.vpaid.xml.Tag;

/* JADX INFO: loaded from: classes5.dex */
public class CompanionAds {

    @Tag("Companion")
    private List<Companion> companions;

    @Attribute
    private String required;

    public String getRequired() {
        return this.required;
    }

    public List<Companion> getCompanions() {
        return this.companions;
    }
}
