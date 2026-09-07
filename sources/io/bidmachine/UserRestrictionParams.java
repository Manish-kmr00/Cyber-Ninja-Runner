package io.bidmachine;

import android.text.TextUtils;
import com.explorestack.protobuf.Any;
import com.explorestack.protobuf.adcom.Context;
import io.bidmachine.core.Utils;
import io.bidmachine.models.DataRestrictions;
import io.bidmachine.models.IUserRestrictionsParams;
import io.bidmachine.protobuf.RegsCcpaExtension;
import io.bidmachine.protobuf.sdk.User;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
final class UserRestrictionParams implements IUserRestrictionsParams<UserRestrictionParams>, DataRestrictions {
    private String gdprConsentString;
    private List<Integer> gppIds;
    private String gppString;
    private Boolean hasConsent;
    private Boolean hasCoppa;
    private Boolean subjectToGDPR;
    private String usPrivacyString;

    UserRestrictionParams() {
    }

    @Override // io.bidmachine.models.IUserRestrictionsParams
    public /* bridge */ /* synthetic */ UserRestrictionParams setGPP(String str, List list) {
        return setGPP(str, (List<Integer>) list);
    }

    void build(Context.Regs.Builder builder) {
        builder.setCoppa(hasCoppa());
        builder.setGdpr(subjectToGDPR());
        String uSPrivacyString = getUSPrivacyString();
        if (!TextUtils.isEmpty(uSPrivacyString)) {
            builder.addExtProto(Any.pack(RegsCcpaExtension.newBuilder().setUsPrivacy(uSPrivacyString).build()));
        }
        String gPPString = getGPPString();
        if (!TextUtils.isEmpty(gPPString)) {
            builder.setGpp(gPPString);
        }
        List<Integer> gPPIds = getGPPIds();
        if (Utils.isEmpty(gPPIds)) {
            return;
        }
        builder.addAllGppSid(gPPIds);
    }

    void build(Context.User.Builder builder) {
        builder.setConsent(getIABGDPRString());
    }

    void fill(User.Builder builder) {
        builder.setCoppa(hasCoppa());
        builder.setGdpr(subjectToGDPR());
        builder.setConsent(getIABGDPRString());
        String uSPrivacyString = getUSPrivacyString();
        if (!TextUtils.isEmpty(uSPrivacyString)) {
            builder.setCcpa(uSPrivacyString);
        }
        String gPPString = getGPPString();
        if (!TextUtils.isEmpty(gPPString)) {
            builder.setGpp(gPPString);
        }
        List<Integer> gPPIds = getGPPIds();
        if (Utils.isEmpty(gPPIds)) {
            return;
        }
        builder.addAllGppSid(gPPIds);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.IUserRestrictionsParams
    public UserRestrictionParams setConsentConfig(boolean z, String str) {
        this.gdprConsentString = str;
        this.hasConsent = Boolean.valueOf(z);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.IUserRestrictionsParams
    public UserRestrictionParams setSubjectToGDPR(Boolean bool) {
        this.subjectToGDPR = bool;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.IUserRestrictionsParams
    public UserRestrictionParams setCoppa(Boolean bool) {
        this.hasCoppa = bool;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.IUserRestrictionsParams
    public UserRestrictionParams setUSPrivacyString(String str) {
        this.usPrivacyString = str;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.IUserRestrictionsParams
    public UserRestrictionParams setGPP(String str, List<Integer> list) {
        this.gppString = str;
        this.gppIds = list;
        return this;
    }

    private boolean subjectToGDPR() {
        IABSharedPreference iabSharedPreference = BidMachineImpl.get().getIabSharedPreference();
        Boolean bool = (Boolean) Utils.oneOf(this.subjectToGDPR, iabSharedPreference.getTcfGdprApplies(), iabSharedPreference.getSubjectToGDPR());
        return bool != null && bool.booleanValue();
    }

    private String getGDPRString() {
        IABSharedPreference iabSharedPreference = BidMachineImpl.get().getIabSharedPreference();
        return (String) Utils.oneOf(this.gdprConsentString, iabSharedPreference.getTcfTcString(), iabSharedPreference.getGDPRConsentString());
    }

    @Override // io.bidmachine.models.DataRestrictions
    public boolean hasConsent() {
        Boolean bool = this.hasConsent;
        return bool != null && bool.booleanValue();
    }

    boolean hasFusedConsent() {
        return hasConsent() || !TextUtils.isEmpty(getGDPRString());
    }

    private boolean hasCoppa() {
        Boolean bool = this.hasCoppa;
        return bool != null && bool.booleanValue();
    }

    @Override // io.bidmachine.models.DataRestrictions
    public boolean canSendGeoPosition() {
        return (hasCoppa() || isUserGdprProtected()) ? false : true;
    }

    @Override // io.bidmachine.models.DataRestrictions
    public boolean canSendUserInfo() {
        return (hasCoppa() || isUserGdprProtected()) ? false : true;
    }

    @Override // io.bidmachine.models.DataRestrictions
    public boolean canSendDeviceInfo() {
        return !hasCoppa();
    }

    @Override // io.bidmachine.models.DataRestrictions
    public boolean canSendIfa() {
        return (hasCoppa() || isUserGdprProtected()) ? false : true;
    }

    @Override // io.bidmachine.models.DataRestrictions
    public boolean canSendBmIfv() {
        return !hasCoppa();
    }

    @Override // io.bidmachine.models.DataRestrictions
    public boolean isUserInGdprScope() {
        return subjectToGDPR();
    }

    @Override // io.bidmachine.models.DataRestrictions
    public boolean isUserHasConsent() {
        return hasFusedConsent();
    }

    @Override // io.bidmachine.models.DataRestrictions
    public boolean isUserGdprProtected() {
        return subjectToGDPR() && !hasFusedConsent();
    }

    @Override // io.bidmachine.models.DataRestrictions
    public boolean isUserAgeRestricted() {
        return hasCoppa();
    }

    @Override // io.bidmachine.models.DataRestrictions
    public String getUSPrivacyString() {
        return (String) Utils.oneOf(this.usPrivacyString, BidMachineImpl.get().getIabSharedPreference().getUSPrivacyString());
    }

    @Override // io.bidmachine.models.DataRestrictions
    public boolean isUserInCcpaScope() {
        String uSPrivacyString = getUSPrivacyString();
        return uSPrivacyString != null && uSPrivacyString.length() == 4 && uSPrivacyString.charAt(0) == '1' && !uSPrivacyString.contains("---");
    }

    @Override // io.bidmachine.models.DataRestrictions
    public boolean isUserHasCcpaConsent() {
        String uSPrivacyString = getUSPrivacyString();
        if (uSPrivacyString != null && uSPrivacyString.length() == 4 && uSPrivacyString.charAt(0) == '1') {
            return uSPrivacyString.charAt(2) == 'N' || uSPrivacyString.charAt(2) == 'n';
        }
        return false;
    }

    @Override // io.bidmachine.models.DataRestrictions
    public String getIABGDPRString() {
        String gDPRString = getGDPRString();
        if (!TextUtils.isEmpty(gDPRString)) {
            return gDPRString;
        }
        if (hasConsent()) {
            return "1";
        }
        return "0";
    }

    @Override // io.bidmachine.models.DataRestrictions
    public String getGPPString() {
        return (String) Utils.oneOf(this.gppString, BidMachineImpl.get().getIabSharedPreference().getGPPString());
    }

    @Override // io.bidmachine.models.DataRestrictions
    public List<Integer> getGPPIds() {
        return (List) Utils.oneOf(this.gppIds, BidMachineImpl.get().getIabSharedPreference().getGPPIds());
    }
}
