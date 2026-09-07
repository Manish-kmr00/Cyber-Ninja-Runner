package com.pubmatic.sdk.video.vastmodels;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.pubmatic.sdk.common.viewability.POBVerificationScriptResource;
import com.pubmatic.sdk.video.POBVideoLogConstants;
import com.pubmatic.sdk.video.xmlserialiser.POBNodeBuilder;
import com.pubmatic.sdk.video.xmlserialiser.POBXMLNodeListener;
import com.smaato.sdk.video.vast.model.InLine;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes4.dex */
public class POBVastAd implements POBXMLNodeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private POBVastAdType f7864a = POBVastAdType.NO_ADS;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private int g;
    private int h;
    private List i;
    private String j;
    private List k;
    private List l;
    private List m;
    private List n;
    private POBVastCreative o;
    private List p;
    private POBVastAd q;
    private List r;

    public enum POBVastAdParameter {
        IMPRESSIONS,
        ERRORS,
        VIEWABLE_IMPRESSIONS,
        NOT_VIEWABLE_IMPRESSIONS,
        VIEW_UNDETERMINED_IMPRESSIONS,
        CLICKTRACKING,
        PROGRESS_TRACKING_EVENT,
        COMPANIONS,
        CLICK_THROUGH,
        ICON
    }

    public enum POBVastAdType {
        INLINE,
        WRAPPER,
        NO_ADS
    }

    class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ POBVastCreative.POBEventTypes f7867a;

        a(POBVastCreative.POBEventTypes pOBEventTypes) {
            this.f7867a = pOBEventTypes;
        }

        @Override // com.pubmatic.sdk.video.vastmodels.POBVastAd.g
        public List a(POBVastAd pOBVastAd) {
            if (pOBVastAd.getCreative() != null) {
                return pOBVastAd.getCreative().getTrackingEventUrls(this.f7867a);
            }
            return null;
        }
    }

    class b implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ POBVastAdParameter f7868a;

        b(POBVastAdParameter pOBVastAdParameter) {
            this.f7868a = pOBVastAdParameter;
        }

        @Override // com.pubmatic.sdk.video.vastmodels.POBVastAd.g
        public List a(POBVastAd pOBVastAd) {
            return pOBVastAd.a(pOBVastAd, this.f7868a);
        }
    }

    class c implements g {
        c() {
        }

        @Override // com.pubmatic.sdk.video.vastmodels.POBVastAd.g
        public List a(POBVastAd pOBVastAd) {
            return pOBVastAd.getCompanions();
        }
    }

    class d implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ POBVastAdParameter f7870a;

        d(POBVastAdParameter pOBVastAdParameter) {
            this.f7870a = pOBVastAdParameter;
        }

        @Override // com.pubmatic.sdk.video.vastmodels.POBVastAd.g
        public List a(POBVastAd pOBVastAd) {
            List listB = pOBVastAd.b(pOBVastAd, this.f7870a);
            if (listB != null) {
                return new ArrayList(listB);
            }
            return null;
        }
    }

    class e implements g {
        e() {
        }

        @Override // com.pubmatic.sdk.video.vastmodels.POBVastAd.g
        public List a(POBVastAd pOBVastAd) {
            if (pOBVastAd.getAdVerification() != null) {
                return new ArrayList(pOBVastAd.getAdVerification());
            }
            return null;
        }
    }

    static /* synthetic */ class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7872a;

        static {
            int[] iArr = new int[POBVastAdParameter.values().length];
            f7872a = iArr;
            try {
                iArr[POBVastAdParameter.CLICK_THROUGH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7872a[POBVastAdParameter.ICON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7872a[POBVastAdParameter.IMPRESSIONS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7872a[POBVastAdParameter.ERRORS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7872a[POBVastAdParameter.VIEWABLE_IMPRESSIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7872a[POBVastAdParameter.NOT_VIEWABLE_IMPRESSIONS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7872a[POBVastAdParameter.VIEW_UNDETERMINED_IMPRESSIONS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f7872a[POBVastAdParameter.CLICKTRACKING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f7872a[POBVastAdParameter.PROGRESS_TRACKING_EVENT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f7872a[POBVastAdParameter.COMPANIONS.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    private interface g {
        List a(POBVastAd pOBVastAd);
    }

    private Object c(POBVastAd pOBVastAd, POBVastAdParameter pOBVastAdParameter) {
        List<POBIcon> iconList;
        POBVastCreative creative = pOBVastAd.getCreative();
        int i = f.f7872a[pOBVastAdParameter.ordinal()];
        if (i != 1) {
            if (i == 2 && creative != null && creative.getVastCreativeType() == POBVastCreative.CreativeType.LINEAR && (iconList = ((POBLinear) creative).getIconList()) != null && iconList.size() > 0) {
                return iconList.get(0);
            }
        } else if (creative != null) {
            return creative.getClickThroughURL();
        }
        return null;
    }

    @Override // com.pubmatic.sdk.video.xmlserialiser.POBXMLNodeListener
    public void build(POBNodeBuilder pOBNodeBuilder) {
        String nodeValue;
        if (pOBNodeBuilder.getNodeName() != null) {
            if (pOBNodeBuilder.getNodeName().equals("InLine")) {
                this.f7864a = POBVastAdType.INLINE;
            } else if (pOBNodeBuilder.getNodeName().equals("Wrapper")) {
                this.f7864a = POBVastAdType.WRAPPER;
            }
        }
        try {
            Node node = pOBNodeBuilder.getNode("/VAST/Ad");
            if (node != null && (nodeValue = node.getAttributes().getNamedItem("sequence").getNodeValue()) != null) {
                this.h = Integer.parseInt(nodeValue);
            }
        } catch (Exception unused) {
            POBLog.error("POBVastAd", POBVideoLogConstants.MSG_AD_SEQUENCE_NOT_FOUND, new Object[0]);
        }
        if (this.h < 1) {
            this.h = -1;
        }
        this.b = pOBNodeBuilder.getNodeValue("AdSystem");
        this.c = pOBNodeBuilder.getNodeValue("AdTitle");
        this.d = pOBNodeBuilder.getNodeValue(InLine.AD_SERVING_ID);
        this.e = pOBNodeBuilder.getNodeValue("Description");
        this.f = pOBNodeBuilder.getNodeValue(k.l);
        this.g = POBUtils.getIntegerValue(pOBNodeBuilder.getNodeValue("Expires"));
        this.i = pOBNodeBuilder.getStringList("Error");
        this.j = pOBNodeBuilder.getNodeValue("VASTAdTagURI");
        this.k = pOBNodeBuilder.getStringList("Impression");
        this.l = pOBNodeBuilder.getStringList("ViewableImpression/Viewable");
        this.m = pOBNodeBuilder.getStringList("ViewableImpression/NotViewable");
        this.n = pOBNodeBuilder.getStringList("ViewableImpression/ViewUndetermined");
        POBVastCreative pOBVastCreative = (POBVastCreative) pOBNodeBuilder.getNodeObject("Creatives/Creative/Linear", POBLinear.class);
        this.o = pOBVastCreative;
        if (pOBVastCreative == null) {
            this.o = (POBVastCreative) pOBNodeBuilder.getNodeObject("Creatives/Creative/NonLinearAds/NonLinear", POBNonLinear.class);
        }
        this.p = pOBNodeBuilder.getObjectList("Creatives/Creative/CompanionAds/Companion", POBCompanion.class);
        List objectList = pOBNodeBuilder.getObjectList("AdVerifications/Verification", POBAdVerification.class);
        this.r = objectList;
        if (objectList == null || objectList.isEmpty()) {
            this.r = pOBNodeBuilder.getObjectList("Extensions/Extension/AdVerifications/Verification", POBAdVerification.class);
        }
    }

    public int getAdSequence() {
        return this.h;
    }

    public String getAdServingId() {
        return this.d;
    }

    public String getAdSystem() {
        return this.b;
    }

    public String getAdTitle() {
        return this.c;
    }

    public POBVastAdType getAdType() {
        return this.f7864a;
    }

    public List<POBAdVerification> getAdVerification() {
        return this.r;
    }

    public String getClosestClickThroughURL() {
        return (String) a(POBVastAdParameter.CLICK_THROUGH);
    }

    public POBIcon getClosestIcon() {
        return (POBIcon) a(POBVastAdParameter.ICON);
    }

    public List<POBCompanion> getCombinedCompanions() {
        return a(this, new c());
    }

    public List<String> getCombinedList(POBVastAdParameter pOBVastAdParameter) {
        return a(this, new b(pOBVastAdParameter));
    }

    public List<POBXMLNodeListener> getCombinedObjectList(POBVastAdParameter pOBVastAdParameter) {
        return a(this, new d(pOBVastAdParameter));
    }

    public List<String> getCombinedTrackingEventList(POBVastCreative.POBEventTypes pOBEventTypes) {
        return a(this, new a(pOBEventTypes));
    }

    public List<POBVerificationScriptResource> getCombinedVerificationList() {
        return a(this, new e());
    }

    public List<POBCompanion> getCompanions() {
        return this.p;
    }

    public POBVastCreative getCreative() {
        return this.o;
    }

    public String getDescription() {
        return this.e;
    }

    public List<String> getErrorURLs() {
        return this.i;
    }

    public int getExpires() {
        return this.g;
    }

    public List<String> getImpressions() {
        return this.k;
    }

    public List<String> getNotViewableImpressions() {
        return this.m;
    }

    public String getPricing() {
        return this.f;
    }

    public String getVASTAdTagURI() {
        return this.j;
    }

    public List<String> getViewUndeterminedImpressions() {
        return this.n;
    }

    public List<String> getViewableImpressions() {
        return this.l;
    }

    public POBVastAd getWrapper() {
        return this.q;
    }

    public void setWrapper(POBVastAd pOBVastAd) {
        this.q = pOBVastAd;
    }

    private Object a(POBVastAdParameter pOBVastAdParameter) {
        for (POBVastAd wrapper = this; wrapper != null; wrapper = wrapper.getWrapper()) {
            Object objC = c(wrapper, pOBVastAdParameter);
            if (objC != null) {
                return objC;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List b(POBVastAd pOBVastAd, POBVastAdParameter pOBVastAdParameter) {
        int i = f.f7872a[pOBVastAdParameter.ordinal()];
        if (i != 9) {
            if (i != 10) {
                return null;
            }
            return pOBVastAd.getCompanions();
        }
        if (pOBVastAd.getCreative() != null) {
            return pOBVastAd.getCreative().getTrackingEvents(POBVastCreative.POBEventTypes.PROGRESS);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List a(POBVastAd pOBVastAd, POBVastAdParameter pOBVastAdParameter) {
        switch (f.f7872a[pOBVastAdParameter.ordinal()]) {
            case 3:
                return pOBVastAd.getImpressions();
            case 4:
                return pOBVastAd.getErrorURLs();
            case 5:
                return pOBVastAd.getViewableImpressions();
            case 6:
                return pOBVastAd.getNotViewableImpressions();
            case 7:
                return pOBVastAd.getViewUndeterminedImpressions();
            case 8:
                ArrayList arrayList = new ArrayList();
                POBVastCreative creative = pOBVastAd.getCreative();
                if (creative != null && creative.getClickTrackers() != null) {
                    arrayList.addAll(creative.getClickTrackers());
                }
                return arrayList;
            default:
                return null;
        }
    }

    private List a(POBVastAd pOBVastAd, g gVar) {
        ArrayList arrayList = new ArrayList();
        while (pOBVastAd != null) {
            List listA = gVar.a(pOBVastAd);
            if (listA != null) {
                arrayList.addAll(listA);
            }
            pOBVastAd = pOBVastAd.getWrapper();
        }
        return arrayList;
    }
}
