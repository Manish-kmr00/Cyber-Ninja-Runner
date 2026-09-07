package net.pubnative.lite.sdk.vpaid.models.vpaid;

/* JADX INFO: loaded from: classes9.dex */
public class CreativeParams {
    private String creativeData;
    private final int desiredBitrate;
    private String environmentVars;
    private final int height;
    private final String viewMode;
    private final int width;

    public CreativeParams(int i, int i2, String str, int i3) {
        this.width = i;
        this.height = i2;
        this.viewMode = "'" + str + "'";
        this.desiredBitrate = i3;
    }

    public void setAdParameters(String str) {
        this.creativeData = str;
    }

    public void setEnvironmentVars(String str) {
        this.environmentVars = str;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String getViewMode() {
        return this.viewMode;
    }

    public int getDesiredBitrate() {
        return this.desiredBitrate;
    }

    public String getCreativeData() {
        return this.creativeData;
    }

    public String getEnvironmentVars() {
        return this.environmentVars;
    }
}
