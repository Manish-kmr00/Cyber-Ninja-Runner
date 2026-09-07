package net.pubnative.lite.sdk.vpaid.models.vast;

import java.util.List;
import net.pubnative.lite.sdk.vpaid.xml.Tag;

/* JADX INFO: loaded from: classes12.dex */
public class Extensions {

    @Tag("Extension")
    private List<Extension> extensionList;

    public List<Extension> getExtensions() {
        return this.extensionList;
    }
}
