package net.pubnative.lite.sdk.vpaid.models.vast;

import net.pubnative.lite.sdk.vpaid.xml.Attribute;
import net.pubnative.lite.sdk.vpaid.xml.Tag;

/* JADX INFO: loaded from: classes12.dex */
public class Ad {

    @Attribute
    private String adType;

    @Attribute
    private String conditionalAd;

    @Attribute
    private String id;

    @Tag
    private InLine inLine;

    @Attribute
    private String sequence;

    @Tag
    private Wrapper wrapper;

    public String getId() {
        return this.id;
    }

    public String getSequence() {
        return this.sequence;
    }

    public String getConditionalAd() {
        return this.conditionalAd;
    }

    public String getAdType() {
        return this.adType;
    }

    public InLine getInLine() {
        return this.inLine;
    }

    public Wrapper getWrapper() {
        return this.wrapper;
    }
}
