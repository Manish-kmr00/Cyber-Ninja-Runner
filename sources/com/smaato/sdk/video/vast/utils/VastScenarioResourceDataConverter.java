package com.smaato.sdk.video.vast.utils;

import android.text.TextUtils;
import com.smaato.sdk.video.vast.model.StaticResource;
import com.smaato.sdk.video.vast.model.VastScenarioResourceData;

/* JADX INFO: loaded from: classes10.dex */
public class VastScenarioResourceDataConverter {
    public String getUriFromResources(VastScenarioResourceData vastScenarioResourceData, int i, int i2) {
        String str = i == 0 ? "100%" : i + "px";
        String str2 = i2 != 0 ? i2 + "px" : "100%";
        StaticResource staticResource = vastScenarioResourceData.staticResources;
        if (staticResource != null) {
            return VastScenarioResourceHtmlHelper.wrapStaticResourceWithSizeIntoHtml(staticResource, str, str2);
        }
        if (!TextUtils.isEmpty(vastScenarioResourceData.htmlResources)) {
            String str3 = vastScenarioResourceData.htmlResources;
            return VastScenarioResourceHtmlHelper.wrapHtmlResourceWithSizeIntoHtml(str3 != null ? str3 : "", str, str2);
        }
        if (TextUtils.isEmpty(vastScenarioResourceData.iFrameResources)) {
            return null;
        }
        String str4 = vastScenarioResourceData.iFrameResources;
        return VastScenarioResourceHtmlHelper.wrapIFrameResourceWithSizeIntoHtml(str4 != null ? str4 : "", str, str2);
    }
}
