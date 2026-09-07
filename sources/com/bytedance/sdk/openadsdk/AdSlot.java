package com.bytedance.sdk.openadsdk;

import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.vk.openvk.pA.pA.pA.SD.Og;
import com.bytedance.sdk.component.utils.WV;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class AdSlot {
    public static final int TYPE_BANNER = 1;
    public static final int TYPE_CACHED_SPLASH = 4;
    public static final int TYPE_FEED = 5;
    public static final int TYPE_FULL_SCREEN_VIDEO = 8;
    public static final int TYPE_INTERACTION_AD = 2;
    public static final int TYPE_OPEN_AD = 3;
    public static final int TYPE_REWARD_VIDEO = 7;
    private int BF;
    private String BSW;
    private int Bzk;
    private String DX;
    private int JG;
    private int KZx;
    private float ML;
    private int Og;
    private boolean SD;
    private String SGo;
    private int Sd;
    private boolean Sn;
    private Bundle TV;
    private int TX;
    private JSONArray WQf;
    private int WV;
    private boolean Wx;
    private String XT;
    private float ZZv;
    private String aBv;
    private String du;
    private boolean eG;
    private String oX;
    private String omh;
    private String pA;
    private Map<String, Object> roi;
    private int vZF;
    private String yFO;

    public static int getPosition(int i) {
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return (i == 3 || i == 4 || i == 7 || i == 8) ? 5 : 3;
        }
        return 4;
    }

    private AdSlot() {
        this.Wx = true;
        this.Sn = false;
        this.vZF = 0;
        this.Sd = 0;
        this.TX = 0;
    }

    public void setUserData(String str) {
        this.yFO = str;
    }

    public String getUserData() {
        return this.yFO;
    }

    public String getCodeId() {
        return this.pA;
    }

    public boolean isAutoPlay() {
        return this.Wx;
    }

    public boolean isExpressAd() {
        return this.Sn;
    }

    public String getBidAdm() {
        return this.DX;
    }

    public int getImgAcceptedWidth() {
        return this.Og;
    }

    public int getImgAcceptedHeight() {
        return this.KZx;
    }

    public float getExpressViewAcceptedWidth() {
        return this.ZZv;
    }

    public float getExpressViewAcceptedHeight() {
        return this.ML;
    }

    public boolean isSupportDeepLink() {
        return this.SD;
    }

    public int getAdCount() {
        return this.JG;
    }

    public void setAdCount(int i) {
        this.JG = i;
    }

    @Deprecated
    public String getRewardName() {
        return this.omh;
    }

    @Deprecated
    public int getRewardAmount() {
        return this.Bzk;
    }

    public String getMediaExtra() {
        return this.SGo;
    }

    public String getUserID() {
        return this.BSW;
    }

    public int getNativeAdType() {
        return this.WV;
    }

    public void setNativeAdType(int i) {
        this.WV = i;
    }

    public String getAdId() {
        return this.oX;
    }

    public String getCreativeId() {
        return this.aBv;
    }

    public String getExt() {
        return this.XT;
    }

    public int getIsRotateBanner() {
        return this.vZF;
    }

    public void setIsRotateBanner(int i) {
        this.vZF = i;
    }

    public int getRotateTime() {
        return this.Sd;
    }

    public void setRotateTime(int i) {
        this.Sd = i;
    }

    public int getRotateOrder() {
        return this.TX;
    }

    public void setRotateOrder(int i) {
        this.TX = i;
    }

    public void setDurationSlotType(int i) {
        this.BF = i;
    }

    public int getDurationSlotType() {
        return this.BF;
    }

    public Map<String, Object> getRequestExtraMap() {
        return this.roi;
    }

    public JSONArray getBiddingTokens() {
        return this.WQf;
    }

    public void setBiddingTokens(JSONArray jSONArray) {
        this.WQf = jSONArray;
    }

    public Bundle getNetworkExtrasBundle() {
        return this.TV;
    }

    public String getLinkId() {
        return this.du;
    }

    public void setPreload(boolean z) {
        this.eG = z;
    }

    public boolean isPreload() {
        return this.eG;
    }

    public String toString() {
        return super.toString();
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.pA);
            jSONObject.put("mAdCount", this.JG);
            jSONObject.put("mIsAutoPlay", this.Wx);
            jSONObject.put("mImgAcceptedWidth", this.Og);
            jSONObject.put("mImgAcceptedHeight", this.KZx);
            jSONObject.put("mExpressViewAcceptedWidth", this.ZZv);
            jSONObject.put("mExpressViewAcceptedHeight", this.ML);
            jSONObject.put("mSupportDeepLink", this.SD);
            jSONObject.put("mRewardName", this.omh);
            jSONObject.put("mRewardAmount", this.Bzk);
            jSONObject.put("mMediaExtra", this.SGo);
            jSONObject.put("mUserID", this.BSW);
            jSONObject.put("mNativeAdType", this.WV);
            jSONObject.put("mIsExpressAd", this.Sn);
            jSONObject.put("mAdId", this.oX);
            jSONObject.put("mCreativeId", this.aBv);
            jSONObject.put("mExt", this.XT);
            jSONObject.put("mBidAdm", this.DX);
            jSONObject.put("mUserData", this.yFO);
            jSONObject.put("mDurationSlotType", this.BF);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static AdSlot getSlot(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Builder builder = new Builder();
        try {
            int iOptInt = jSONObject.optInt("mImgAcceptedWidth", 640);
            int iOptInt2 = jSONObject.optInt("mImgAcceptedHeight", 320);
            double dOptDouble = jSONObject.optDouble("mExpressViewAcceptedWidth", 0.0d);
            double dOptDouble2 = jSONObject.optDouble("mExpressViewAcceptedHeight", 0.0d);
            builder.setCodeId(jSONObject.optString("mCodeId", null));
            builder.setAdCount(jSONObject.optInt("mAdCount", 1));
            builder.setIsAutoPlay(jSONObject.optBoolean("mIsAutoPlay"));
            builder.setImageAcceptedSize(iOptInt, iOptInt2);
            builder.setExpressViewAcceptedSize(Double.valueOf(dOptDouble).floatValue(), Double.valueOf(dOptDouble2).floatValue());
            builder.setSupportDeepLink(jSONObject.optBoolean("mSupportDeepLink", false));
            builder.setRewardName(jSONObject.optString("mRewardName", null));
            builder.setRewardAmount(jSONObject.optInt("mRewardAmount"));
            builder.setMediaExtra(jSONObject.optString("mMediaExtra", null));
            builder.setUserID(jSONObject.optString("mUserID", null));
            builder.setNativeAdType(jSONObject.optInt("mNativeAdType"));
            builder.isExpressAd(jSONObject.optBoolean("mIsExpressAd"));
            builder.withBid(jSONObject.optString("mBidAdm"));
            builder.setAdId(jSONObject.optString("mAdId"));
            builder.setCreativeId(jSONObject.optString("mCreativeId"));
            builder.setExt(jSONObject.optString("mExt"));
            builder.setMediaExtra(jSONObject.optString("mMediaExtra"));
        } catch (Exception unused) {
        }
        AdSlot adSlotBuild = builder.build();
        adSlotBuild.setDurationSlotType(jSONObject.optInt("mDurationSlotType"));
        return adSlotBuild;
    }

    public static class Builder {
        private int BF;
        private float BSW;
        private String DX;
        private int SGo;
        private Bundle Sd;
        private String Sn;
        private String TX;
        private float WV;
        private boolean Wx;
        private String XT;
        private String aBv;
        private String oX;
        private String omh;
        private String pA;
        private int Og = 640;
        private int KZx = 320;
        private final boolean ZZv = true;
        private int ML = 1;
        private final String JG = "";
        private final int SD = 0;
        private String Bzk = "defaultUser";
        private boolean yFO = true;
        private Map<String, Object> vZF = null;

        @Deprecated
        public Builder setRewardAmount(int i) {
            return this;
        }

        @Deprecated
        public Builder setRewardName(String str) {
            return this;
        }

        @Deprecated
        public Builder setSupportDeepLink(boolean z) {
            return this;
        }

        public Builder setAdId(String str) {
            this.DX = str;
            return this;
        }

        public Builder setCreativeId(String str) {
            this.oX = str;
            return this;
        }

        public Builder setExt(String str) {
            this.aBv = str;
            return this;
        }

        public Builder setIsAutoPlay(boolean z) {
            this.yFO = z;
            return this;
        }

        public Builder setCodeId(String str) {
            this.pA = str;
            return this;
        }

        public Builder isExpressAd(boolean z) {
            this.Wx = z;
            return this;
        }

        public Builder setImageAcceptedSize(int i, int i2) {
            this.Og = i;
            this.KZx = i2;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f, float f2) {
            this.BSW = f;
            this.WV = f2;
            return this;
        }

        public Builder setDurationSlotType(int i) {
            this.BF = i;
            return this;
        }

        public Builder setAdCount(int i) {
            if (i <= 0) {
                i = 1;
            }
            if (i > 20) {
                i = 20;
            }
            this.ML = i;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.omh = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.Bzk = str;
            return this;
        }

        public Builder setNativeAdType(int i) {
            this.SGo = i;
            return this;
        }

        public Builder withBid(String str) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            if (WV.ZZv()) {
                Og.pA(str);
            }
            this.Sn = str;
            return this;
        }

        public Builder setUserData(String str) {
            this.XT = str;
            return this;
        }

        public Builder setRequestExtraMap(Map<String, Object> map) {
            this.vZF = map;
            return this;
        }

        public Builder setNetworkExtrasBundle(Bundle bundle) {
            this.Sd = bundle;
            return this;
        }

        public Builder setLinkId(String str) {
            this.TX = str;
            return this;
        }

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.pA = this.pA;
            adSlot.JG = this.ML;
            adSlot.SD = true;
            adSlot.Og = this.Og;
            adSlot.KZx = this.KZx;
            float f = this.BSW;
            if (f <= 0.0f) {
                adSlot.ZZv = this.Og;
                adSlot.ML = this.KZx;
            } else {
                adSlot.ZZv = f;
                adSlot.ML = this.WV;
            }
            adSlot.omh = "";
            adSlot.Bzk = 0;
            adSlot.SGo = this.omh;
            adSlot.BSW = this.Bzk;
            adSlot.WV = this.SGo;
            adSlot.Wx = this.yFO;
            adSlot.Sn = this.Wx;
            adSlot.DX = this.Sn;
            adSlot.oX = this.DX;
            adSlot.aBv = this.oX;
            adSlot.XT = this.aBv;
            adSlot.yFO = this.XT;
            adSlot.roi = this.vZF;
            adSlot.du = this.TX;
            adSlot.BF = this.BF;
            return adSlot;
        }
    }
}
