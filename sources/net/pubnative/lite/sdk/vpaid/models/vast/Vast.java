package net.pubnative.lite.sdk.vpaid.models.vast;

import java.util.List;
import net.pubnative.lite.sdk.vpaid.xml.Attribute;
import net.pubnative.lite.sdk.vpaid.xml.Tag;

/* JADX INFO: loaded from: classes11.dex */
public class Vast {

    @Tag("Ad")
    private List<Ad> ads;

    @Tag("Error")
    private List<Error> errors;

    @Tag
    private Status status;

    @Attribute
    private String version;

    public String getVersion() {
        return this.version;
    }

    public List<Ad> getAds() {
        return this.ads;
    }

    public Status getStatus() {
        return this.status;
    }

    public List<Error> getErrors() {
        return this.errors;
    }
}
