package com.pubmatic.sdk.video.vastmodels;

import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.common.base.POBAdDescriptor;
import com.pubmatic.sdk.common.models.POBDSATransparencyInfo;
import com.pubmatic.sdk.common.models.POBImpressionCountingMethod;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.pubmatic.sdk.video.POBVideoConstant;
import com.pubmatic.sdk.video.xmlserialiser.POBNodeBuilder;
import com.pubmatic.sdk.video.xmlserialiser.POBXMLNodeListener;
import com.smaato.sdk.video.vast.model.Icon;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class POBIcon implements POBXMLNodeListener, POBAdDescriptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7856a;
    private int b;
    private int c;
    private String d;
    private String e;
    private int f;
    private int g;
    private String h;
    private POBResource i;
    protected String mClickThroughURL;
    protected List<String> mClickTrackers;
    protected List<String> mViewTrackers;

    private String a() {
        POBResource pOBResource = this.i;
        if (pOBResource == null) {
            return null;
        }
        if (pOBResource.getResourceType() == POBResource.a.HTML) {
            return this.i.getResource();
        }
        if (this.i.getResourceType() != POBResource.a.STATIC) {
            return String.format(POBVideoConstant.IFRAME_HTML, this.i.getResource());
        }
        return String.format(POBVideoConstant.ANCHOR_TAG, POBUtils.isNullOrEmpty(this.mClickThroughURL) ? POBCommonConstants.PLACEHOLDER_CLICK_THROUGH : this.mClickThroughURL, String.format(POBVideoConstant.STATIC_HTML, this.i.getResource()));
    }

    @Override // com.pubmatic.sdk.video.xmlserialiser.POBXMLNodeListener
    public void build(POBNodeBuilder pOBNodeBuilder) {
        this.f7856a = pOBNodeBuilder.getAttributeValue(Icon.PROGRAM);
        this.b = POBUtils.getIntegerValue(pOBNodeBuilder.getAttributeValue("width"));
        this.c = POBUtils.getIntegerValue(pOBNodeBuilder.getAttributeValue("height"));
        this.d = pOBNodeBuilder.getAttributeValue(Icon.X_POSITION);
        this.e = pOBNodeBuilder.getAttributeValue(Icon.Y_POSITION);
        String attributeValue = pOBNodeBuilder.getAttributeValue("duration");
        if (attributeValue != null) {
            this.f = (int) POBUtils.getSeconds(attributeValue);
        }
        String attributeValue2 = pOBNodeBuilder.getAttributeValue("offset");
        if (attributeValue2 != null) {
            this.g = (int) POBUtils.getSeconds(attributeValue2);
        }
        this.h = pOBNodeBuilder.getAttributeValue("apiFramework");
        this.mClickThroughURL = pOBNodeBuilder.getNodeValue("IconClicks/IconClickThrough");
        this.mClickTrackers = pOBNodeBuilder.getStringList("IconClicks/IconClickTracking");
        this.mViewTrackers = pOBNodeBuilder.getStringList("IconViewTracking");
        POBResource pOBResource = (POBResource) pOBNodeBuilder.getNodeObject("StaticResource", POBResource.class);
        this.i = pOBResource;
        if (pOBResource == null) {
            POBResource pOBResource2 = (POBResource) pOBNodeBuilder.getNodeObject("HTMLResource", POBResource.class);
            this.i = pOBResource2;
            if (pOBResource2 == null) {
                this.i = (POBResource) pOBNodeBuilder.getNodeObject("IFrameResource", POBResource.class);
            }
        }
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public POBAdDescriptor buildWithRefreshAndExpiryTimeout(int i, int i2) {
        return null;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public boolean enableDsaInfoIcon() {
        return false;
    }

    public String getApiFramework() {
        return this.h;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public String getBundle() {
        return null;
    }

    public String getClickThroughURL() {
        return this.mClickThroughURL;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public List<String> getClickTrackers() {
        return this.mClickTrackers;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public int getContentHeight() {
        return this.c;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public int getContentWidth() {
        return this.b;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public String getCreativeType() {
        return null;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public String getDisplayedOnBehalfOf() {
        return null;
    }

    public int getDuration() {
        return this.f;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public String getId() {
        return null;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public POBImpressionCountingMethod getImpressionCountingMethod() {
        return POBImpressionCountingMethod.ON_LOAD;
    }

    public int getOffset() {
        return this.g;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public String getPaidBy() {
        return null;
    }

    public String getProgram() {
        return this.f7856a;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public JSONObject getRawBid() {
        return null;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public int getRefreshInterval() {
        return 0;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public String getRenderableContent() {
        return a();
    }

    public POBResource getResource() {
        return this.i;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public int getStatus() {
        return 0;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public Map<String, String> getTargetingInfo() {
        return null;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public List<POBDSATransparencyInfo> getTransparencyData() {
        return null;
    }

    public List<String> getViewTrackers() {
        return this.mViewTrackers;
    }

    public String getXPosition() {
        return this.d;
    }

    public String getYPosition() {
        return this.e;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public boolean isCompanion() {
        return false;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public boolean isVideo() {
        return false;
    }
}
