package net.pubnative.lite.sdk.mraid.internal;

import android.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.pubnative.lite.sdk.mraid.Assets;

/* JADX INFO: loaded from: classes13.dex */
public class MRAIDHtmlProcessor {
    public static String processRawHtml(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        Pattern.compile("<script\\s+[^>]*\\bsrc\\s*=\\s*([\"'])mraid\\.js\\1[^>]*>\\s*</script>\\n*", 2).matcher(stringBuffer);
        boolean zContains = removeAllScripts(str).contains("<html");
        boolean zContains2 = removeAllScripts(str).contains("<head");
        boolean zContains3 = removeAllScripts(str).contains("<body");
        String property = System.getProperty("line.separator");
        if (!zContains) {
            if (!zContains3) {
                stringBuffer.insert(0, "<body><div id='hybid-ad' align='center'>" + property);
                stringBuffer.append("</div></body>");
            }
            if (!zContains2) {
                stringBuffer.insert(0, "<head>" + property + "</head>" + property);
            }
            stringBuffer.insert(0, "<html>" + property);
            stringBuffer.append(property).append("</html>");
        } else if (!zContains2) {
            Matcher matcher = Pattern.compile("<html[^>]*>", 2).matcher(stringBuffer);
            for (int iEnd = 0; matcher.find(iEnd); iEnd = matcher.end()) {
                stringBuffer.insert(matcher.end(), property + "<head>" + property + "</head>");
            }
        }
        String str2 = "<script>" + property + new String(Base64.decode(Assets.mraidJS, 0)) + property + "</script>";
        String str3 = "<script>" + property + new String(Base64.decode(net.pubnative.lite.sdk.viewability.Assets.omsdkjs, 0)) + property + "</script>";
        String str4 = "<script>" + property + new String(Base64.decode(Assets.scaling_script_minified, 0)) + property + "</script>";
        Matcher matcher2 = Pattern.compile("<head[^>]*>", 2).matcher(stringBuffer);
        if (matcher2.find(0)) {
            stringBuffer.insert(matcher2.end(), property + "<meta name='viewport' content='width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no' />" + property + ("<style>" + property + "body { margin:0; padding:0;}" + property + "*:not(input) { -webkit-touch-callout:none; -webkit-user-select:none; -webkit-text-size-adjust:none; }" + property + "</style>") + property + str2 + property + str3 + property + str4);
        }
        return stringBuffer.toString();
    }

    private static String removeAllScripts(String str) {
        return (str == null || str.isEmpty()) ? "" : str.replaceAll("<script[\\s\\S]*?>[\\s\\S]*?<\\/script>", "");
    }
}
