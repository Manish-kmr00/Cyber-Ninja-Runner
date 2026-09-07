package io.bidmachine.ads.networks.adaptiverendering.measurer;

import android.content.Context;
import android.text.TextUtils;
import com.iab.omid.library.appodeal.adsession.VerificationScriptResource;
import io.bidmachine.core.Logger;
import io.bidmachine.rendering.measurer.HtmlMeasurer;
import io.bidmachine.rendering.measurer.MeasurerFactory;
import io.bidmachine.rendering.measurer.VideoMeasurer;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class AdMeasurerFactory implements MeasurerFactory {
    static final String JAVA_SCRIPT_RESOURCE_URL = "java_script_resource_url";
    static final String OM = "om";
    static final String SKIP_OFFSET = "skip_offset";
    static final String VENDOR = "vendor";
    static final String VERIFICATIONS = "verifications";
    static final String VERIFICATION_PARAMETERS = "verification_parameters";

    @Override // io.bidmachine.rendering.measurer.MeasurerFactory
    public HtmlMeasurer createHtmlMeasurer(Context context, String str, Map<String, String> map) {
        if (str.equalsIgnoreCase(OM)) {
            return new OMHtmlMeasurer();
        }
        return null;
    }

    @Override // io.bidmachine.rendering.measurer.MeasurerFactory
    public VideoMeasurer createVideoMeasurer(Context context, String str, Map<String, String> map) {
        List<VerificationScriptResource> verificationScriptResourceList;
        if (!str.equalsIgnoreCase(OM) || map == null || map.isEmpty() || (verificationScriptResourceList = getVerificationScriptResourceList(map)) == null || verificationScriptResourceList.isEmpty()) {
            return null;
        }
        return new OMVideoMeasurer(verificationScriptResourceList, getSkipOffsetSec(map));
    }

    static List<VerificationScriptResource> getVerificationScriptResourceList(Map<String, String> map) {
        String str = map.get("verifications");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    addVerificationScriptResource(arrayList, jSONObjectOptJSONObject.optString(JAVA_SCRIPT_RESOURCE_URL), jSONObjectOptJSONObject.optString("vendor"), jSONObjectOptJSONObject.optString("verification_parameters"));
                }
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    static void addVerificationScriptResource(List<VerificationScriptResource> list, String str, String str2, String str3) {
        VerificationScriptResource verificationScriptResourceCreateVerificationScriptResourceWithoutParameters;
        try {
            URL url = new URL(str);
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                verificationScriptResourceCreateVerificationScriptResourceWithoutParameters = VerificationScriptResource.createVerificationScriptResourceWithParameters(str2, url, str3);
            } else {
                verificationScriptResourceCreateVerificationScriptResourceWithoutParameters = VerificationScriptResource.createVerificationScriptResourceWithoutParameters(url);
            }
            list.add(verificationScriptResourceCreateVerificationScriptResourceWithoutParameters);
        } catch (Throwable th) {
            Logger.w(th);
        }
    }

    static Float getSkipOffsetSec(Map<String, String> map) {
        String str = map.get(SKIP_OFFSET);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Float.valueOf(Long.parseLong(str) / 1000.0f);
        } catch (Throwable unused) {
            return null;
        }
    }
}
