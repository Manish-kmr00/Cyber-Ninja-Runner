package net.pubnative.lite.sdk.vpaid.response;

import com.iab.omid.library.pubnativenet.adsession.VerificationScriptResource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.pubnative.lite.sdk.models.AdData;
import net.pubnative.lite.sdk.models.EndCardData;
import net.pubnative.lite.sdk.vpaid.models.vast.AdServingId;
import net.pubnative.lite.sdk.vpaid.models.vast.Category;
import net.pubnative.lite.sdk.vpaid.models.vast.Icon;
import net.pubnative.lite.sdk.vpaid.models.vast.Tracking;

/* JADX INFO: loaded from: classes13.dex */
public class AdParams {
    private Icon adIcon;
    private String adParams;
    private String ctaExtensionHtml;
    private Integer duration;
    private String endCardRedirectUrl;
    private String id;
    private String skipTime;
    private String videoRedirectUrl;
    private boolean vpaid;
    private String vpaidJsUrl;
    private int publisherSkipSeconds = -1;
    private final List<String> videoFileUrlsList = new ArrayList();
    private final List<EndCardData> endCardList = new ArrayList();
    private final List<String> impressions = new ArrayList();
    private final List<String> companionCreativeViewEvents = new ArrayList();
    private final List<String> videoClicks = new ArrayList();
    private final List<String> endCardClicks = new ArrayList();
    private final List<String> ctaExtensionClicks = new ArrayList();
    private final List<Tracking> events = new ArrayList();
    private final List<AdServingId> adServingIds = new ArrayList();
    private final List<Category> adCategories = new ArrayList();
    private final List<VerificationScriptResource> verificationScriptResources = new ArrayList();

    public int getDuration() {
        return this.duration.intValue();
    }

    public void setDuration(Integer num) {
        this.duration = num;
    }

    public void setEndCardRedirectUrl(String str) {
        this.endCardRedirectUrl = str;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getEndCardRedirectUrl() {
        return this.endCardRedirectUrl;
    }

    public boolean isVpaid() {
        return this.vpaid;
    }

    public String getAdParams() {
        return this.adParams;
    }

    public String getVpaidJsUrl() {
        return this.vpaidJsUrl;
    }

    public void setVpaid() {
        this.vpaid = true;
    }

    public void setAdParams(String str) {
        this.adParams = str;
    }

    public void setVpaidJsUrl(String str) {
        this.vpaidJsUrl = str;
    }

    public List<String> getImpressions() {
        return this.impressions;
    }

    public void setImpressions(List<String> list) {
        if (list != null) {
            this.impressions.addAll(list);
        }
    }

    public List<AdData> getCompanionCreativeViewEvents() {
        ArrayList arrayList = new ArrayList();
        if (this.companionCreativeViewEvents.isEmpty()) {
            return arrayList;
        }
        Iterator<String> it = this.companionCreativeViewEvents.iterator();
        while (it.hasNext()) {
            arrayList.add(new AdData("url", "impression", it.next()));
        }
        return arrayList;
    }

    public void setCompanionCreativeViewEvents(List<String> list) {
        if (list != null) {
            this.companionCreativeViewEvents.addAll(list);
        }
    }

    public List<Tracking> getEvents() {
        return this.events;
    }

    public void addEvents(List<Tracking> list) {
        if (list != null) {
            this.events.addAll(list);
        }
    }

    public List<String> getVideoClicks() {
        return this.videoClicks;
    }

    public void setVideoClicks(List<String> list) {
        if (list != null) {
            this.videoClicks.addAll(list);
        }
    }

    public List<String> getCtaExtensionClicks() {
        return this.ctaExtensionClicks;
    }

    public void setCtaExtensionClicks(List<String> list) {
        if (list != null) {
            this.ctaExtensionClicks.addAll(list);
        }
    }

    public List<String> getEndCardClicks() {
        return this.endCardClicks;
    }

    public void setEndCardClicks(List<String> list) {
        if (list != null) {
            this.endCardClicks.addAll(list);
        }
    }

    public String getVideoRedirectUrl() {
        return this.videoRedirectUrl;
    }

    public void setVideoRedirectUrl(String str) {
        this.videoRedirectUrl = str;
    }

    public List<String> getVideoFileUrlsList() {
        return this.videoFileUrlsList;
    }

    public void setVideoFileUrlsList(List<String> list) {
        if (list != null) {
            this.videoFileUrlsList.addAll(list);
        }
    }

    public List<EndCardData> getEndCardList() {
        return this.endCardList;
    }

    public void setEndCardList(List<EndCardData> list) {
        if (list != null) {
            this.endCardList.addAll(list);
        }
    }

    public String getSkipTime() {
        return this.skipTime;
    }

    public void setSkipTime(String str) {
        this.skipTime = str;
    }

    public int getPublisherSkipSeconds() {
        return this.publisherSkipSeconds;
    }

    public void setPublisherSkipSeconds(int i) {
        this.publisherSkipSeconds = i;
    }

    public List<VerificationScriptResource> getVerificationScriptResources() {
        return this.verificationScriptResources;
    }

    public void addVerificationScriptResources(List<VerificationScriptResource> list) {
        if (list != null) {
            this.verificationScriptResources.addAll(list);
        }
    }

    public void addAdServingId(AdServingId adServingId) {
        if (adServingId != null) {
            this.adServingIds.add(adServingId);
        }
    }

    public List<AdServingId> getAdServingIds() {
        return this.adServingIds;
    }

    public void addAdCategories(List<Category> list) {
        if (list != null) {
            this.adCategories.addAll(list);
        }
    }

    public Icon getAdIcon() {
        return this.adIcon;
    }

    public void setAdIcon(Icon icon) {
        this.adIcon = icon;
    }

    public List<Category> getAdCategories() {
        return this.adCategories;
    }

    public String getCtaExtensionHtml() {
        return this.ctaExtensionHtml;
    }

    public void setCtaExtensionHtml(String str) {
        this.ctaExtensionHtml = str;
    }
}
