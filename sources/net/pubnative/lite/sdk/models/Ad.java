package net.pubnative.lite.sdk.models;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import net.pubnative.lite.sdk.source.pnapi.R;
import net.pubnative.lite.sdk.utils.AdExperienceManager;
import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import net.pubnative.lite.sdk.views.PNAPIContentInfoView;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class Ad extends JsonModel implements Serializable, Comparable<Ad> {
    public static final String CONTENT_INFO_ICON_URL = "https://cdn.pubnative.net/static/adserver/contentinfo.png";
    public static final String CONTENT_INFO_LINK_URL = "https://pubnative.net/content-info";
    public static final String CONTENT_INFO_TEXT = "Learn about this ad";
    private static final String DATA_CONTENTINFO_ICON_KEY = "icon";
    private static final String DATA_CONTENTINFO_LINK_KEY = "link";
    private static final String DATA_POINTS_NUMBER_KEY = "number";
    private static final String DATA_TEXT_KEY = "text";
    public static final Integer HTML_REWARDED_DEFAULT_SKIP_OFFSET = 3;
    private static final int MIN_POINTS = 10;
    private static final String PN_IMPRESSION_QUERY_PARAM = "t";
    private static final String PN_IMPRESSION_URL = "got.pubnative.net";
    private static final String TAG = "Ad";
    private String adSourceName;

    @BindField
    public int assetgroupid;

    @BindField
    public List<AdData> assets;

    @BindField
    public List<AdData> beacons;
    private boolean hasEndCard;

    @BindField
    public String link;

    @BindField
    public List<AdData> meta;
    private String sessiondId;
    private String zoneId;

    public enum AdType {
        HTML,
        VIDEO
    }

    public interface Beacon {
        public static final String CLICK = "click";
        public static final String COMPANION_AD_EVENT = "companion_ad_event";
        public static final String CUSTOM_CTA_CLICK = "custom_cta_click";
        public static final String CUSTOM_CTA_ENDCARD_CLICK = "custom_cta_endcard_click";
        public static final String CUSTOM_CTA_SHOW = "custom_cta_show";
        public static final String CUSTOM_ENDCARD_EVENT = "custom_endcard_event";
        public static final String CUSTOM_END_CARD_CLICK = "custom_endcard_click";
        public static final String CUSTOM_END_CARD_IMPRESSION = "custom_endcard_impression";
        public static final String IMPRESSION = "impression";
        public static final String SDK_EVENT = "sdk_event";
    }

    public Ad() {
        this.hasEndCard = false;
    }

    public Ad(JSONObject jSONObject) throws Exception {
        this.hasEndCard = false;
        fromJson(jSONObject);
    }

    public Ad(int i, String str, AdType adType) {
        AdData adData;
        this.hasEndCard = false;
        this.assetgroupid = i;
        this.assets = new ArrayList();
        if (adType == AdType.VIDEO) {
            adData = new AdData(APIAsset.VAST, APIAsset.VAST, str);
        } else {
            adData = new AdData("html", APIAsset.HTML_BANNER, str);
        }
        this.assets.add(adData);
    }

    public AdData getAsset(String str) {
        return find(str, this.assets);
    }

    public AdData getMeta(String str) {
        return find(str, this.meta);
    }

    public List<AdData> getBeacons(String str) {
        return findAll(str, this.beacons);
    }

    protected AdData find(String str, List<AdData> list) {
        if (list != null) {
            for (AdData adData : list) {
                if (str.equals(adData.type)) {
                    return adData;
                }
            }
        }
        return null;
    }

    protected List<AdData> findAll(String str, List<AdData> list) {
        ArrayList arrayList = null;
        if (list != null) {
            for (AdData adData : list) {
                if (str.equals(adData.type)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(adData);
                }
            }
        }
        return arrayList;
    }

    public String getAssetUrl(String str) {
        AdData asset = getAsset(str);
        if (asset != null) {
            return asset.getURL();
        }
        return null;
    }

    public String getAssetHtml(String str) {
        AdData asset = getAsset(str);
        if (asset != null) {
            return asset.getHtml();
        }
        return null;
    }

    public int getAssetWidth(String str) {
        AdData asset = getAsset(str);
        if (asset != null) {
            return asset.getWidth();
        }
        return -1;
    }

    public int getAssetHeight(String str) {
        AdData asset = getAsset(str);
        if (asset != null) {
            return asset.getHeight();
        }
        return -1;
    }

    public String getVast() {
        AdData asset = getAsset(APIAsset.VAST);
        if (asset != null) {
            return asset.getStringField(APIAsset.VAST);
        }
        return null;
    }

    public View getContentInfo(Context context, PNAPIContentInfoView.ContentInfoListener contentInfoListener) {
        boolean z;
        String stringField = (String) getRemoteConfig(RemoteConfig.CONTENT_INFO_URL);
        String stringField2 = (String) getRemoteConfig(RemoteConfig.CONTENT_INFO_ICON_URL);
        String text = (String) getRemoteConfig(RemoteConfig.CONTENT_INFO_TEXT);
        final ContentInfoIconAction contentInfoIconAction = getContentInfoIconAction();
        ContentInfoDisplay contentInfoDisplay = getContentInfoDisplay();
        AdData meta = getMeta(APIMeta.CONTENT_INFO);
        if (TextUtils.isEmpty(stringField)) {
            if (meta != null && !TextUtils.isEmpty(meta.getStringField("link"))) {
                stringField = meta.getStringField("link");
            } else {
                stringField = CONTENT_INFO_LINK_URL;
            }
        }
        if (TextUtils.isEmpty(stringField2)) {
            if (meta != null && !TextUtils.isEmpty(meta.getStringField("icon"))) {
                stringField2 = meta.getStringField("icon");
            } else {
                stringField2 = CONTENT_INFO_ICON_URL;
            }
            z = false;
        } else {
            z = true;
        }
        if (TextUtils.isEmpty(text)) {
            if (meta != null && !TextUtils.isEmpty(meta.getText())) {
                text = meta.getText();
            } else {
                text = CONTENT_INFO_TEXT;
            }
        }
        PNAPIContentInfoView pNAPIContentInfoView = new PNAPIContentInfoView(context, getContentInfoIconXPosition());
        pNAPIContentInfoView.setIconUrl(stringField2, false, z);
        pNAPIContentInfoView.setIconClickUrl(stringField);
        pNAPIContentInfoView.setContextText(text);
        pNAPIContentInfoView.setContentInfoListener(contentInfoListener);
        pNAPIContentInfoView.setContentInfoDisplay(contentInfoDisplay);
        pNAPIContentInfoView.setOnClickListener(new View.OnClickListener() { // from class: net.pubnative.lite.sdk.models.Ad$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ad.lambda$getContentInfo$0(contentInfoIconAction, view);
            }
        });
        return pNAPIContentInfoView;
    }

    static /* synthetic */ void lambda$getContentInfo$0(ContentInfoIconAction contentInfoIconAction, View view) {
        if (contentInfoIconAction == ContentInfoIconAction.OPEN) {
            ((PNAPIContentInfoView) view).openLink();
        } else {
            ((PNAPIContentInfoView) view).openLayout();
        }
    }

    public FrameLayout getContentInfoContainer(Context context, PNAPIContentInfoView.ContentInfoListener contentInfoListener) {
        return getContentInfoContainer(context, null, contentInfoListener);
    }

    public FrameLayout getContentInfoContainer(Context context, ContentInfo contentInfo, PNAPIContentInfoView.ContentInfoListener contentInfoListener) {
        int i;
        String str;
        int i2;
        String str2;
        View customContentInfo = getCustomContentInfo(context, contentInfo, contentInfoListener);
        if (customContentInfo == null) {
            customContentInfo = getContentInfo(context, contentInfoListener);
        }
        if (customContentInfo == null) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (getContentInfoIconXPosition() != null && getContentInfoIconXPosition() == ContentInfoIconXPosition.RIGHT) {
            i = GravityCompat.END;
            str = "right";
        } else {
            i = GravityCompat.START;
            str = "left";
        }
        if (getContentInfoIconYPosition() != null && getContentInfoIconYPosition() == ContentInfoIconYPosition.BOTTOM) {
            i2 = 80;
            str2 = "bottom";
        } else {
            i2 = 48;
            str2 = ViewHierarchyConstants.DIMENSION_TOP_KEY;
        }
        layoutParams.gravity = i | i2;
        frameLayout.setContentDescription(context.getResources().getString(R.string.content_info_icon) + " - " + str2 + " " + str);
        frameLayout.setLayoutParams(layoutParams);
        frameLayout.addView(customContentInfo);
        return frameLayout;
    }

    private PNAPIContentInfoView getCustomContentInfo(Context context, ContentInfo contentInfo, PNAPIContentInfoView.ContentInfoListener contentInfoListener) {
        if (contentInfo == null || TextUtils.isEmpty(contentInfo.getIconUrl())) {
            return null;
        }
        PNAPIContentInfoView pNAPIContentInfoView = new PNAPIContentInfoView(context, getContentInfoIconXPosition());
        pNAPIContentInfoView.setIconId(R.id.ic_context_icon_custom);
        pNAPIContentInfoView.setIconUrl(contentInfo.getIconUrl());
        pNAPIContentInfoView.setIconClickUrl(contentInfo.getLinkUrl());
        pNAPIContentInfoView.setIconClickTrackers(contentInfo.getClickTrackers());
        if (TextUtils.isEmpty(contentInfo.getText())) {
            pNAPIContentInfoView.setContextText(CONTENT_INFO_TEXT);
        } else {
            pNAPIContentInfoView.setContextText(contentInfo.getText());
        }
        if (contentInfo.getWidth() != -1 && contentInfo.getHeight() != -1) {
            pNAPIContentInfoView.setDpDimensions(contentInfo);
        }
        final ContentInfoIconAction contentInfoIconAction = getContentInfoIconAction();
        pNAPIContentInfoView.setContentInfoDisplay(getContentInfoDisplay());
        pNAPIContentInfoView.setContentInfoListener(contentInfoListener);
        pNAPIContentInfoView.setOnClickListener(new View.OnClickListener() { // from class: net.pubnative.lite.sdk.models.Ad$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ad.lambda$getCustomContentInfo$1(contentInfoIconAction, view);
            }
        });
        return pNAPIContentInfoView;
    }

    static /* synthetic */ void lambda$getCustomContentInfo$1(ContentInfoIconAction contentInfoIconAction, View view) {
        if (contentInfoIconAction == ContentInfoIconAction.OPEN) {
            ((PNAPIContentInfoView) view).openLink();
        } else {
            ((PNAPIContentInfoView) view).openLayout();
        }
    }

    private PNAPIContentInfoView getDefaultContentInfo(Context context, boolean z, PNAPIContentInfoView.ContentInfoListener contentInfoListener) {
        final PNAPIContentInfoView pNAPIContentInfoView = new PNAPIContentInfoView(context, getContentInfoIconXPosition());
        pNAPIContentInfoView.setIconUrl(CONTENT_INFO_ICON_URL, true);
        pNAPIContentInfoView.setIconClickUrl(CONTENT_INFO_LINK_URL);
        pNAPIContentInfoView.setContextText(CONTENT_INFO_TEXT);
        pNAPIContentInfoView.setContentInfoListener(contentInfoListener);
        final ContentInfoIconAction contentInfoIconAction = getContentInfoIconAction();
        pNAPIContentInfoView.setContentInfoDisplay(getContentInfoDisplay());
        pNAPIContentInfoView.setOnClickListener(new View.OnClickListener() { // from class: net.pubnative.lite.sdk.models.Ad$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ad.lambda$getDefaultContentInfo$2(pNAPIContentInfoView, view);
            }
        });
        pNAPIContentInfoView.setOnClickListener(new View.OnClickListener() { // from class: net.pubnative.lite.sdk.models.Ad$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ad.lambda$getDefaultContentInfo$3(contentInfoIconAction, view);
            }
        });
        return pNAPIContentInfoView;
    }

    static /* synthetic */ void lambda$getDefaultContentInfo$2(PNAPIContentInfoView pNAPIContentInfoView, View view) {
        if (TextUtils.isEmpty(pNAPIContentInfoView.getIconClickURL())) {
            return;
        }
        ((PNAPIContentInfoView) view).openLink();
    }

    static /* synthetic */ void lambda$getDefaultContentInfo$3(ContentInfoIconAction contentInfoIconAction, View view) {
        if (contentInfoIconAction == ContentInfoIconAction.OPEN) {
            ((PNAPIContentInfoView) view).openLink();
        } else {
            ((PNAPIContentInfoView) view).openLayout();
        }
    }

    public String getContentInfoIconUrl() {
        String str = (String) getRemoteConfig(RemoteConfig.CONTENT_INFO_ICON_URL);
        return !TextUtils.isEmpty(str) ? str : getMeta(APIMeta.CONTENT_INFO).getStringField("icon");
    }

    public String getContentInfoClickUrl() {
        String str = (String) getRemoteConfig(RemoteConfig.CONTENT_INFO_URL);
        return !TextUtils.isEmpty(str) ? str : getMeta(APIMeta.CONTENT_INFO).getStringField("link");
    }

    public Integer getECPM() {
        AdData meta = getMeta(APIMeta.POINTS);
        if (meta == null) {
            return 10;
        }
        Integer intField = meta.getIntField("number");
        return Integer.valueOf(intField != null ? intField.intValue() : 10);
    }

    public String getCreativeId() {
        AdData meta = getMeta(APIMeta.CREATIVE_ID);
        if (meta == null) {
            return "";
        }
        String stringField = meta.getStringField("text");
        return TextUtils.isEmpty(stringField) ? "" : stringField;
    }

    public String getImpressionId() {
        List<AdData> beacons = getBeacons("impression");
        String str = "";
        if (beacons != null) {
            boolean z = false;
            for (int i = 0; i < beacons.size() && !z; i++) {
                AdData adData = beacons.get(i);
                if (!TextUtils.isEmpty(adData.getURL())) {
                    Uri uri = Uri.parse(adData.getURL());
                    if (uri.getAuthority().equals(PN_IMPRESSION_URL)) {
                        String queryParameter = uri.getQueryParameter("t");
                        if (!TextUtils.isEmpty(queryParameter)) {
                            z = true;
                            str = queryParameter;
                        }
                    }
                }
            }
        }
        return str;
    }

    public String getSessionId() {
        String impressionId = getImpressionId();
        if (impressionId != null && !impressionId.isEmpty()) {
            return impressionId;
        }
        if (this.sessiondId == null) {
            this.sessiondId = String.valueOf(UUID.randomUUID());
        }
        return this.sessiondId;
    }

    public String getCampaignId() {
        AdData meta = getMeta(APIMeta.CAMPAIGN_ID);
        if (meta == null) {
            return "";
        }
        String stringField = meta.getStringField("text");
        return TextUtils.isEmpty(stringField) ? "" : stringField;
    }

    public String getBundleId() {
        AdData meta = getMeta("bundleid");
        if (meta == null) {
            return "";
        }
        String stringField = meta.getStringField("text");
        return TextUtils.isEmpty(stringField) ? "" : stringField;
    }

    public String getAdExperience() {
        AdData meta = getMeta(APIMeta.AD_EXPERIENCE);
        if (meta == null) {
            return "";
        }
        String stringField = meta.getStringField("text");
        return (TextUtils.isEmpty(stringField) || !(stringField.equalsIgnoreCase(AdExperience.BRAND) || stringField.equalsIgnoreCase(AdExperience.PERFORMANCE))) ? "" : stringField;
    }

    public <T> T getRemoteConfig(RemoteConfig remoteConfig) {
        JSONObject jSONObjectField;
        AdData meta = getMeta(APIMeta.REMOTE_CONFIGS);
        T t = null;
        if (meta != null && meta.hasField("jsondata").booleanValue() && (jSONObjectField = meta.getJSONObjectField("jsondata")) != null && jSONObjectField.has(remoteConfig.fieldName)) {
            try {
                if (remoteConfig.type == String.class) {
                    t = (T) jSONObjectField.getString(remoteConfig.fieldName);
                } else if (remoteConfig.type == Integer.class) {
                    t = (T) Integer.valueOf(jSONObjectField.getInt(remoteConfig.fieldName));
                } else if (remoteConfig.type == Double.class) {
                    t = (T) Double.valueOf(jSONObjectField.getDouble(remoteConfig.fieldName));
                } else if (remoteConfig.type == Boolean.class) {
                    t = (T) Boolean.valueOf(jSONObjectField.getBoolean(remoteConfig.fieldName));
                }
            } catch (Exception unused) {
            }
        }
        return t;
    }

    public RemoteConfigsDebug getRemoteConfigDebug() {
        AdData meta = getMeta(APIMeta.REMOTE_CONFIGS_DEBUG);
        if (meta != null && meta.hasField("jsondata").booleanValue()) {
            try {
                return new RemoteConfigsDebug(meta.getJSONObjectField("jsondata"));
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public String getConfigId() {
        List<Integer> configIds;
        RemoteConfigsDebug remoteConfigDebug = getRemoteConfigDebug();
        if (remoteConfigDebug != null && (configIds = remoteConfigDebug.getConfigIds()) != null && configIds.size() > 0) {
            return configIds.get(0).toString();
        }
        return "";
    }

    public Boolean isEndCardEnabled() {
        if (isPerformanceAd()) {
            return isPcEndCardEnabled();
        }
        return (Boolean) getRemoteConfig(RemoteConfig.END_CARD_ENABLED);
    }

    public Boolean isCustomEndCardEnabled() {
        return (Boolean) getRemoteConfig(RemoteConfig.CUSTOM_END_CARD_ENABLED);
    }

    public String getAudioState() {
        return (String) getRemoteConfig(RemoteConfig.AUDIO_STATE);
    }

    public Integer getEndCardCloseDelay() {
        if (isPerformanceAd()) {
            return getPcEndCardCloseDelay();
        }
        if (isBrandAd()) {
            return getBcEndCardCloseDelay();
        }
        Integer num = (Integer) getRemoteConfig(RemoteConfig.END_CARD_CLOSE_DELAY);
        if (num == null || num.intValue() < 0) {
            return null;
        }
        return num;
    }

    public Integer getNativeCloseButtonDelay() {
        return (Integer) getRemoteConfig(RemoteConfig.NATIVE_CLOSE_BUTTON_DELAY);
    }

    public Boolean needCloseInterAfterFinish() {
        return (Boolean) getRemoteConfig(RemoteConfig.CLOSE_INTER_AFTER_FINISH);
    }

    public Boolean needCloseRewardAfterFinish() {
        return (Boolean) getRemoteConfig(RemoteConfig.CLOSE_REWARD_AFTER_FINISH);
    }

    public Boolean getFullScreenClickability() {
        return (Boolean) getRemoteConfig(RemoteConfig.FULL_SCREEN_CLICKABILITY);
    }

    public Boolean getMraidExpand() {
        return (Boolean) getRemoteConfig(RemoteConfig.MRAID_EXPAND);
    }

    public String getContentInfoText() {
        String str = (String) getRemoteConfig(RemoteConfig.CONTENT_INFO_TEXT);
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        AdData meta = getMeta(APIMeta.CONTENT_INFO);
        if (!TextUtils.isEmpty(meta.getText())) {
            return meta.getText();
        }
        return CONTENT_INFO_TEXT;
    }

    public String getImpressionTrackingMethod() {
        return (String) getRemoteConfig(RemoteConfig.IMP_TRACKING_METHOD);
    }

    public Integer getImpressionMinVisibleTime() {
        Integer num = (Integer) getRemoteConfig(RemoteConfig.IMP_TRACKING_VISIBLE_TIME);
        if (num == null || num.intValue() < 0) {
            return null;
        }
        return num;
    }

    public Double getImpressionVisiblePercent() {
        Double d = (Double) getRemoteConfig(RemoteConfig.IMP_TRACKING_VISIBLE_PERCENT);
        if (d == null || d.doubleValue() < 0.0d) {
            return null;
        }
        return d;
    }

    public ContentInfoIconAction getContentInfoIconAction() {
        String str = (String) getRemoteConfig(RemoteConfig.CONTENT_INFO_ICON_CLICK_ACTION);
        if (TextUtils.isEmpty(str)) {
            return ContentInfoIconAction.EXPAND;
        }
        return ContentInfoIconAction.fromString(str);
    }

    public Integer getHtmlSkipOffset() {
        if (isPerformanceAd()) {
            return getPcHtmlSkipOffset();
        }
        return getSkipOffset(RemoteConfig.HTML_SKIP_OFFSET);
    }

    public Integer getVideoSkipOffset() {
        if (isPerformanceAd()) {
            return getPcVideoSkipOffset();
        }
        if (isBrandAd()) {
            return getBcVideoSkipOffset();
        }
        return getSkipOffset(RemoteConfig.VIDEO_SKIP_OFFSET);
    }

    public Integer getMraidRewardedSkipOffset() {
        if (isPerformanceAd()) {
            return getPcMraidRewardedSkipOffset();
        }
        return getSkipOffset(RemoteConfig.REWARDED_HTML_SKIP_OFFSET);
    }

    public Integer getVideoRewardedSkipOffset() {
        if (isPerformanceAd()) {
            return getPcVideoRewardedSkipOffset();
        }
        if (isBrandAd()) {
            return getBcVideoRewardedSkipOffset();
        }
        return getSkipOffset(RemoteConfig.REWARDED_VIDEO_SKIP_OFFSET);
    }

    private Integer getSkipOffset(RemoteConfig remoteConfig) {
        return (Integer) getRemoteConfig(remoteConfig);
    }

    public ContentInfoIconYPosition getContentInfoIconYPosition() {
        return ContentInfoIconYPosition.getDefaultYPosition();
    }

    public ContentInfoIconXPosition getContentInfoIconXPosition() {
        return ContentInfoIconXPosition.getDefaultXPosition();
    }

    public ContentInfoDisplay getContentInfoDisplay() {
        String str = (String) getRemoteConfig(RemoteConfig.CONTENT_INFO_DISPLAY);
        if (TextUtils.isEmpty(str)) {
            return ContentInfoDisplay.SYSTEM_BROWSER;
        }
        return ContentInfoDisplay.fromString(str);
    }

    public BuyerSignals getBuyerSignals() {
        AdData meta = getMeta(APIMeta.PA_BUYER_SIGNALS);
        if (meta != null && meta.hasField("jsondata").booleanValue()) {
            try {
                return new BuyerSignals(meta.getJSONObjectField("jsondata"));
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public void setZoneId(String str) {
        this.zoneId = str;
    }

    public String getZoneId() {
        return this.zoneId;
    }

    public void setAdSourceName(String str) {
        this.adSourceName = str;
    }

    public String getAdSourceName() {
        return this.adSourceName;
    }

    public void setHasEndCard(boolean z) {
        this.hasEndCard = z;
    }

    public boolean hasEndCard() {
        return this.hasEndCard;
    }

    public EndCardData getCustomEndCard() {
        AdData asset = getAsset(APIAsset.CUSTOM_END_CARD);
        if (asset != null) {
            return new EndCardData(EndCardData.Type.HTML_RESOURCE, asset.getStringField("html"), true);
        }
        return null;
    }

    public boolean hasCustomEndCard() {
        return getAsset(APIAsset.CUSTOM_END_CARD) != null;
    }

    public CustomCTAData getCustomCta(Context context) {
        AdData asset = getAsset("custom_cta");
        if (asset == null || TextUtils.isEmpty(asset.getStringField("icon"))) {
            return null;
        }
        return new CustomCTAData(asset.getStringField("icon"), context.getResources().getString(R.string.custom_cta_button));
    }

    public boolean hasCustomCTA() {
        return getAsset("custom_cta") != null;
    }

    public CustomEndCardDisplay getCustomEndCardDisplay() {
        return CustomEndCardDisplay.fromString((String) getRemoteConfig(RemoteConfig.CUSTOM_END_CARD_DISPLAY));
    }

    public Boolean isCustomCTAEnabled() {
        return (Boolean) getRemoteConfig(RemoteConfig.CUSTOM_CTA_ENABLED);
    }

    public String getCustomCTAType() {
        return (String) getRemoteConfig(RemoteConfig.CUSTOM_CTA_TYPE);
    }

    public Boolean isTopicsAPIEnabled() {
        return (Boolean) getRemoteConfig(RemoteConfig.TOPICS_API_ENABLED);
    }

    public Boolean isAtomEnabled() {
        return (Boolean) getRemoteConfig(RemoteConfig.ATOM_ENABLED);
    }

    private Boolean isPcEndCardEnabled() {
        return (Boolean) getRemoteConfig(RemoteConfig.PC_END_CARD_ENABLED);
    }

    private Integer getPcHtmlSkipOffset() {
        return getSkipOffset(RemoteConfig.PC_HTML_SKIP_OFFSET);
    }

    private Integer getPcVideoSkipOffset() {
        return getSkipOffset(RemoteConfig.PC_VIDEO_SKIP_OFFSET);
    }

    private Integer getPcMraidRewardedSkipOffset() {
        return getSkipOffset(RemoteConfig.PC_REWARDED_HTML_SKIP_OFFSET);
    }

    private Integer getPcVideoRewardedSkipOffset() {
        return getSkipOffset(RemoteConfig.PC_REWARDED_VIDEO_SKIP_OFFSET);
    }

    private Integer getPcEndCardCloseDelay() {
        Integer num = (Integer) getRemoteConfig(RemoteConfig.PC_END_CARD_CLOSE_DELAY);
        if (num == null || num.intValue() < 0) {
            return null;
        }
        return num;
    }

    public Boolean isIconSizeReduced() {
        return (Boolean) getRemoteConfig(RemoteConfig.PC_REDUCED_ICON_SIZES);
    }

    private Integer getBcVideoSkipOffset() {
        return getSkipOffset(RemoteConfig.BC_VIDEO_SKIP_OFFSET);
    }

    private Integer getBcVideoRewardedSkipOffset() {
        return getSkipOffset(RemoteConfig.BC_REWARDED_VIDEO_SKIP_OFFSET);
    }

    private Integer getBcEndCardCloseDelay() {
        Integer num = (Integer) getRemoteConfig(RemoteConfig.BC_END_CARD_CLOSE_DELAY);
        if (num == null || num.intValue() < 0) {
            return null;
        }
        return num;
    }

    public boolean hasHiddenUxControls() {
        Boolean bool = (Boolean) getRemoteConfig(RemoteConfig.BC_HIDE_CONTROLS);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean isBrandAd() {
        return AdExperienceManager.isBrandAd(Integer.valueOf(this.assetgroupid), getAdExperience());
    }

    public boolean isPerformanceAd() {
        return AdExperienceManager.isPerformanceAd(Integer.valueOf(this.assetgroupid), getAdExperience());
    }

    public Integer getCustomCTADelay() {
        return (Integer) getRemoteConfig(RemoteConfig.CUSTOM_CTA_DELAY);
    }

    public String getNavigationMode() {
        return (String) getRemoteConfig(RemoteConfig.NAVIGATION_MODE);
    }

    public Boolean isLandingPage() {
        return (Boolean) getRemoteConfig(RemoteConfig.LANDING_PAGE);
    }

    @Override // java.lang.Comparable
    public int compareTo(Ad ad) {
        return (ad.getECPM() != null ? ad.getECPM().intValue() : 0) - (getECPM() != null ? getECPM().intValue() : 0);
    }
}
