package net.pubnative.lite.sdk.utils;

import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.vpaid.models.vast.Vast;
import net.pubnative.lite.sdk.vpaid.xml.XmlParser;

/* JADX INFO: loaded from: classes7.dex */
public class MarkupUtils {
    public static boolean isVastXml(String str) {
        try {
            Vast vast = (Vast) XmlParser.parse(str, Vast.class);
            if (vast != null) {
                return (vast.getAds() == null && vast.getErrors() == null && vast.getStatus() == null && vast.getVersion() == null) ? false : true;
            }
            return false;
        } catch (Exception e) {
            HyBid.reportException(e);
            Logger.e("MarkupUtils", e.getMessage());
            return false;
        }
    }
}
