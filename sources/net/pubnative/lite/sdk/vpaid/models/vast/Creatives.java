package net.pubnative.lite.sdk.vpaid.models.vast;

import java.util.List;
import net.pubnative.lite.sdk.vpaid.xml.Tag;

/* JADX INFO: loaded from: classes13.dex */
public class Creatives {

    @Tag("Creative")
    private List<Creative> creatives;

    public List<Creative> getCreatives() {
        return this.creatives;
    }
}
