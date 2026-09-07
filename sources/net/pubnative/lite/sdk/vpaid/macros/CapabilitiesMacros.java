package net.pubnative.lite.sdk.vpaid.macros;

import com.iab.omid.library.pubnativenet.adsession.Partner;
import java.util.Locale;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.utils.EncodingUtils;
import net.pubnative.lite.sdk.viewability.ViewabilityManager;

/* JADX INFO: loaded from: classes14.dex */
public class CapabilitiesMacros {
    private static final String MACRO_API_FRAMEWORKS = "[APIFRAMEWORKS]";
    private static final String MACRO_CLICK_TYPE = "[CLICKTYPE]";
    private static final String MACRO_EXTENSIONS = "[EXTENSIONS]";
    private static final String MACRO_MEDIA_MIME = "[MEDIAMIME]";
    private static final String MACRO_OMID_PARTNER = "[OMIDPARTNER]";
    private static final String MACRO_PLAYER_CAPABILITIES = "[PLAYERCAPABILITIES]";
    private static final String MACRO_VAST_VERSIONS = "[VASTVERSIONS]";
    private static final String MACRO_VERIFICATION_VENDORS = "[VERIFICATIONVENDORS]";
    private final String mOmidPartner;
    private final String mPlayerCapabilities;
    private final String mSupportedApiFrameworks;
    private final String mSupportedVastVersions;

    public CapabilitiesMacros() {
        this(HyBid.getViewabilityManager());
    }

    CapabilitiesMacros(ViewabilityManager viewabilityManager) {
        this.mSupportedVastVersions = "1,2,3,4,5,6,7,8,11,12,13,14";
        this.mSupportedApiFrameworks = "3,5,6,7,";
        this.mPlayerCapabilities = "skip,mute,autoplay,mautoplay";
        if (viewabilityManager != null && viewabilityManager.getPartner() != null) {
            Partner partner = viewabilityManager.getPartner();
            this.mOmidPartner = EncodingUtils.urlEncode(String.format(Locale.ENGLISH, "%s/%s", partner.getName(), partner.getVersion()));
        } else {
            this.mOmidPartner = String.valueOf(-1);
        }
    }

    public String processUrl(String str) {
        return str.replace(MACRO_VAST_VERSIONS, getVastVersions()).replace(MACRO_API_FRAMEWORKS, getApiFrameworks()).replace(MACRO_EXTENSIONS, getExtensions()).replace(MACRO_VERIFICATION_VENDORS, getVerificationVendors()).replace(MACRO_OMID_PARTNER, getOmidPartner()).replace(MACRO_PLAYER_CAPABILITIES, getPlayerCapabilities()).replace(MACRO_CLICK_TYPE, getClickType());
    }

    private String getVastVersions() {
        return this.mSupportedVastVersions;
    }

    private String getApiFrameworks() {
        return this.mSupportedApiFrameworks;
    }

    private String getExtensions() {
        return "AdVerifications";
    }

    private String getVerificationVendors() {
        return "iabtechlab.com-omid";
    }

    private String getOmidPartner() {
        return this.mOmidPartner;
    }

    private String getMediaMime() {
        return String.valueOf(-1);
    }

    private String getPlayerCapabilities() {
        return this.mPlayerCapabilities;
    }

    private String getClickType() {
        return "1";
    }
}
