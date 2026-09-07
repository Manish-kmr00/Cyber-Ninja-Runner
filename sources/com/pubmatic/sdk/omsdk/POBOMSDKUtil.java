package com.pubmatic.sdk.omsdk;

import android.webkit.URLUtil;
import com.iab.omid.library.pubmatic.adsession.VerificationScriptResource;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.pubmatic.sdk.common.viewability.POBVerificationScriptResource;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class POBOMSDKUtil {
    public static final String TAG = "OMSDK";

    public static List<VerificationScriptResource> getVerificationScriptResourceList(List<? extends POBVerificationScriptResource> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (POBVerificationScriptResource pOBVerificationScriptResource : list) {
                List<String> javaScriptResource = pOBVerificationScriptResource.getJavaScriptResource();
                if (javaScriptResource != null) {
                    for (String str : javaScriptResource) {
                        if (URLUtil.isValidUrl(str)) {
                            try {
                                URL url = new URL(str);
                                arrayList.add((POBUtils.isNullOrEmpty(pOBVerificationScriptResource.getVendorKey()) || POBUtils.isNullOrEmpty(pOBVerificationScriptResource.getVerificationParameter())) ? VerificationScriptResource.createVerificationScriptResourceWithoutParameters(url) : VerificationScriptResource.createVerificationScriptResourceWithParameters(pOBVerificationScriptResource.getVendorKey(), url, pOBVerificationScriptResource.getVerificationParameter()));
                            } catch (Exception unused) {
                                POBLog.warn(TAG, POBOMSDKLogConstants.MSG_OMSDK_URL_EXCEPTION, str);
                            }
                        }
                    }
                } else {
                    POBLog.debug(TAG, POBOMSDKLogConstants.MSG_OMSDK_URL_NOT_AVAILABLE, new Object[0]);
                }
            }
        }
        return arrayList;
    }
}
