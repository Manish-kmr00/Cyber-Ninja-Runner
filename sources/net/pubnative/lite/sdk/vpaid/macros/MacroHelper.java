package net.pubnative.lite.sdk.vpaid.macros;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes11.dex */
public class MacroHelper {
    private final GenericMacros genericMacros = new GenericMacros();
    private final AdBreakMacros adBreakMacros = new AdBreakMacros();
    private final ClientMacros clientMacros = new ClientMacros();
    private final PublisherMacros publisherMacros = new PublisherMacros();
    private final CapabilitiesMacros capabilitiesMacros = new CapabilitiesMacros();
    private final PlayerStateMacros playerStateMacros = new PlayerStateMacros();
    private final ClickMacros clickMacros = new ClickMacros();
    private final ErrorMacros errorMacros = new ErrorMacros();
    private final VerificationMacros verificationMacros = new VerificationMacros();
    private final RegulationMacros regulationMacros = new RegulationMacros();

    public String processUrl(String str) {
        return processUrl(str, "");
    }

    public String processUrl(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return this.regulationMacros.processUrl(this.verificationMacros.processUrl(this.errorMacros.processUrl(this.clickMacros.processUrl(this.playerStateMacros.processUrl(this.capabilitiesMacros.processUrl(this.publisherMacros.processUrl(this.clientMacros.processUrl(this.adBreakMacros.processUrl(this.genericMacros.processUrl(str))))))), str2)));
    }
}
