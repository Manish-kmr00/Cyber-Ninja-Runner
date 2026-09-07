package net.pubnative.lite.sdk.viewability;

import android.text.TextUtils;
import com.iab.omid.library.pubnativenet.adsession.VerificationScriptResource;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.pubnative.lite.sdk.utils.Logger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class HyBidViewabilityVerificationScriptParser {
    private static final String KEY_HASH = "#";
    private static final String KEY_VIEWABILITY = "viewability";
    private static final Pattern PATTERN_SRC_VALUE = Pattern.compile("src=\"(.*?)\"");
    private static final Pattern PATTERN_VENDORKEY_VALUE = Pattern.compile("vk=(.*?);");
    private static final String RESPONSE_KEY_CONFIG = "config";
    private static final String TAG = "HyBidViewabilityVerificationScriptParser";

    public static VerificationScriptResource parseViewabilityObjectfromAdObject(JSONObject jSONObject) {
        String string;
        if (jSONObject == null) {
            return null;
        }
        try {
            string = jSONObject.getString("config");
        } catch (Exception unused) {
            string = "";
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            Matcher matcher = PATTERN_SRC_VALUE.matcher(string);
            matcher.find(0);
            String strGroup = matcher.group(1);
            if (TextUtils.isEmpty(strGroup)) {
                return null;
            }
            String[] strArrSplit = strGroup.split(KEY_HASH, 2);
            URL url = new URL(strArrSplit[0]);
            String str = strArrSplit[1];
            Matcher matcher2 = PATTERN_VENDORKEY_VALUE.matcher(str);
            matcher2.find(0);
            return VerificationScriptResource.createVerificationScriptResourceWithParameters(matcher2.group(1), url, str);
        } catch (Exception e) {
            Logger.d(TAG, " Exception: " + e.getMessage());
            return null;
        }
    }
}
