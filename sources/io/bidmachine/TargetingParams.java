package io.bidmachine;

import android.location.Location;
import android.text.TextUtils;
import com.explorestack.protobuf.adcom.Context;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.models.ITargetingParams;
import io.bidmachine.models.RequestParams;
import io.bidmachine.protobuf.sdk.App;
import io.bidmachine.utils.Gender;
import io.bidmachine.utils.ProtoUtils;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class TargetingParams extends RequestParams<TargetingParams> implements ITargetingParams<TargetingParams> {
    static final String DATA_ID_EXTERNAL_USER_ID = "external_user_ids";
    private Integer birthdayYear;
    private BlockedParams blockedParams;
    private String city;
    private String country;
    private Location deviceLocation;
    private List<ExternalUserId> externalUserIdList;
    private String framework;
    private Gender gender;
    private Boolean isPaid;
    private String[] keywords;
    private String storeCategory;
    private String[] storeSubCategories;
    private String storeUrl;
    private String userId;
    private String zip;

    @Override // io.bidmachine.models.ITargetingParams
    public /* bridge */ /* synthetic */ TargetingParams setExternalUserIds(List list) {
        return setExternalUserIds((List<ExternalUserId>) list);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ITargetingParams
    public TargetingParams setUserId(String str) {
        this.userId = str;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ITargetingParams
    public TargetingParams setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ITargetingParams
    public TargetingParams setBirthdayYear(Integer num) {
        if (num == null || Utils.isYearValid(num.intValue())) {
            this.birthdayYear = num;
        } else {
            Logger.e("Birthday Year should be 4-digit integer, more or equal 1900 and less or equal than current year");
        }
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ITargetingParams
    public TargetingParams setKeywords(String... strArr) {
        this.keywords = strArr;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ITargetingParams
    public TargetingParams setDeviceLocation(Location location) {
        this.deviceLocation = location;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ITargetingParams
    public TargetingParams setCountry(String str) {
        this.country = str;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ITargetingParams
    public TargetingParams setCity(String str) {
        this.city = str;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ITargetingParams
    public TargetingParams setZip(String str) {
        this.zip = str;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ITargetingParams
    public TargetingParams setStoreUrl(String str) {
        this.storeUrl = str;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ITargetingParams
    public TargetingParams setStoreCategory(String str) {
        this.storeCategory = str;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ITargetingParams
    public TargetingParams setStoreSubCategories(String... strArr) {
        this.storeSubCategories = strArr;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ITargetingParams
    public TargetingParams setFramework(String str) {
        this.framework = str;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ITargetingParams
    public TargetingParams setPaid(Boolean bool) {
        this.isPaid = bool;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ITargetingParams
    public TargetingParams setExternalUserIds(List<ExternalUserId> list) {
        this.externalUserIdList = list;
        return this;
    }

    @Override // io.bidmachine.models.IBlockedParams
    public TargetingParams addBlockedApplication(String str) {
        prepareBlockParams();
        this.blockedParams.addBlockedApplication(str);
        return this;
    }

    @Override // io.bidmachine.models.IBlockedParams
    public TargetingParams addBlockedAdvertiserIABCategory(String str) {
        prepareBlockParams();
        this.blockedParams.addBlockedAdvertiserIABCategory(str);
        return this;
    }

    @Override // io.bidmachine.models.IBlockedParams
    public TargetingParams addBlockedAdvertiserDomain(String str) {
        prepareBlockParams();
        this.blockedParams.addBlockedAdvertiserDomain(str);
        return this;
    }

    @Override // io.bidmachine.models.RequestParams
    public void merge(TargetingParams targetingParams) {
        this.userId = (String) Utils.oneOf(this.userId, targetingParams.userId);
        this.gender = (Gender) Utils.oneOf(this.gender, targetingParams.gender);
        this.birthdayYear = (Integer) Utils.oneOf(this.birthdayYear, targetingParams.birthdayYear);
        this.keywords = (String[]) Utils.oneOf(this.keywords, targetingParams.keywords);
        this.country = (String) Utils.oneOf(this.country, targetingParams.country);
        this.city = (String) Utils.oneOf(this.city, targetingParams.city);
        this.zip = (String) Utils.oneOf(this.zip, targetingParams.zip);
        this.deviceLocation = (Location) Utils.oneOf(this.deviceLocation, targetingParams.deviceLocation);
        this.storeUrl = (String) Utils.oneOf(this.storeUrl, targetingParams.storeUrl);
        this.storeCategory = (String) Utils.oneOf(this.storeCategory, targetingParams.storeCategory);
        this.storeSubCategories = (String[]) Utils.oneOf(this.storeSubCategories, targetingParams.storeSubCategories);
        this.framework = (String) Utils.oneOf(this.framework, targetingParams.framework);
        this.isPaid = (Boolean) Utils.oneOf(this.isPaid, targetingParams.isPaid);
        this.externalUserIdList = (List) Utils.oneOf(this.externalUserIdList, targetingParams.externalUserIdList);
        if (targetingParams.blockedParams != null) {
            if (this.blockedParams == null) {
                this.blockedParams = new BlockedParams();
            }
            this.blockedParams.merge(targetingParams.blockedParams);
        }
    }

    void build(Context.App.Builder builder) {
        String str = this.storeUrl;
        if (str != null) {
            builder.setStoreurl(str);
        }
        Boolean bool = this.isPaid;
        builder.setPaid(bool != null && bool.booleanValue());
    }

    void fillAppExtension(final App.Builder builder) {
        String str = this.storeCategory;
        Objects.requireNonNull(builder);
        Utils.ifNotNull(str, new Executable() { // from class: io.bidmachine.TargetingParams$$ExternalSyntheticLambda0
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                builder.setStorecat((String) obj);
            }
        });
        Utils.ifNotNull(this.storeSubCategories, new Executable() { // from class: io.bidmachine.TargetingParams$$ExternalSyntheticLambda1
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                TargetingParams.lambda$fillAppExtension$0(builder, (String[]) obj);
            }
        });
        String str2 = this.framework;
        Objects.requireNonNull(builder);
        Utils.ifNotNull(str2, new Executable() { // from class: io.bidmachine.TargetingParams$$ExternalSyntheticLambda2
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                builder.setFmwname((String) obj);
            }
        });
    }

    static /* synthetic */ void lambda$fillAppExtension$0(App.Builder builder, String[] strArr) {
        for (String str : strArr) {
            builder.addStoresubcat(str);
        }
    }

    void build(Context.User.Builder builder) {
        String str = this.userId;
        if (str != null) {
            builder.setId(str);
        }
        Integer num = this.birthdayYear;
        if (num != null) {
            builder.setYob(num.intValue());
        }
        Gender gender = this.gender;
        if (gender != null) {
            builder.setGender(gender.getOrtbValue());
        }
        String[] strArr = this.keywords;
        if (strArr != null && strArr.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (String str2 : this.keywords) {
                if (sb.length() > 0) {
                    sb.append(StringUtils.COMMA);
                }
                sb.append(str2);
            }
            builder.setKeywords(sb.toString());
        }
        Context.Geo.Builder builderNewBuilder = Context.Geo.newBuilder();
        build(builderNewBuilder);
        ProtoUtils.fillGeoBuilder(builderNewBuilder, null, false);
        builder.setGeo(builderNewBuilder);
        List<ExternalUserId> list = this.externalUserIdList;
        if (list == null || list.size() <= 0) {
            return;
        }
        Context.Data.Builder id = Context.Data.newBuilder().setId(DATA_ID_EXTERNAL_USER_ID);
        for (ExternalUserId externalUserId : this.externalUserIdList) {
            String sourceId = externalUserId.getSourceId();
            String value = externalUserId.getValue();
            if (!TextUtils.isEmpty(sourceId) && !TextUtils.isEmpty(value)) {
                id.addSegment(Context.Data.Segment.newBuilder().setId(sourceId).setValue(value));
            }
        }
        builder.addData(id);
    }

    void build(Context.Geo.Builder builder) {
        String str = this.country;
        if (str != null) {
            builder.setCountry(str);
        }
        String str2 = this.city;
        if (str2 != null) {
            builder.setCity(str2);
        }
        String str3 = this.zip;
        if (str3 != null) {
            builder.setZip(str3);
        }
    }

    BlockedParams getBlockedParams() {
        return this.blockedParams;
    }

    String getUserId() {
        return this.userId;
    }

    Gender getGender() {
        return this.gender;
    }

    Integer getBirthdayYear() {
        return this.birthdayYear;
    }

    String[] getKeywords() {
        return this.keywords;
    }

    Location getDeviceLocation() {
        return this.deviceLocation;
    }

    String getCountry() {
        return this.country;
    }

    String getCity() {
        return this.city;
    }

    String getZip() {
        return this.zip;
    }

    String getStoreUrl() {
        return this.storeUrl;
    }

    String getStoreCategory() {
        return this.storeCategory;
    }

    String[] getStoreSubCategories() {
        return this.storeSubCategories;
    }

    String getFramework() {
        return this.framework;
    }

    Boolean getPaid() {
        return this.isPaid;
    }

    List<ExternalUserId> getExternalUserIdList() {
        return this.externalUserIdList;
    }

    private void prepareBlockParams() {
        if (this.blockedParams == null) {
            this.blockedParams = new BlockedParams();
        }
    }
}
