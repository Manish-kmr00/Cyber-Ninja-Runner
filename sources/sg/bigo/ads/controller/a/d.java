package sg.bigo.ads.controller.a;

import android.text.TextUtils;
import android.util.Patterns;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes13.dex */
public final class d {
    public static String a(String str, String str2) {
        try {
            URL url = new URL(str);
            StringBuilder sb = new StringBuilder(str);
            String authority = url.getAuthority();
            int iLastIndexOf = str.lastIndexOf(authority);
            if (iLastIndexOf >= 0) {
                sb.replace(iLastIndexOf, authority.length() + iLastIndexOf, str2);
            }
            return sb.toString();
        } catch (Exception e) {
            sg.bigo.ads.common.t.a.a(0, "AntiBanUtils", "replaceHost error： " + e.getMessage());
            return str;
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            sg.bigo.ads.common.t.a.a(0, 3, "AntiBanUtils", "\"" + str + "\" is invalid host");
            return false;
        }
        int iIndexOf = str.indexOf(":");
        if (iIndexOf != -1) {
            str = str.substring(0, iIndexOf);
        }
        return Patterns.DOMAIN_NAME.matcher(str).matches();
    }

    public static Map<String, String> b(String str) {
        JSONArray jSONArray;
        HashMap map = new HashMap();
        if (q.a((CharSequence) str)) {
            return map;
        }
        try {
            jSONArray = new JSONArray(str);
        } catch (JSONException unused) {
            jSONArray = null;
        }
        if (jSONArray == null) {
            return map;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("country", "all");
                String strOptString2 = jSONObjectOptJSONObject.optString("host", "");
                if (a(strOptString2)) {
                    map.put(strOptString, strOptString2);
                }
            }
        }
        return map;
    }
}
