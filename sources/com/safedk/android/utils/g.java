package com.safedk.android.utils;

import android.os.SystemClock;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes11.dex */
public class g {
    private static final String aW = "(?:%3C|\\\\+x3c|<|&lt;|&amp;lt;)<TAG_NAME>[\\s\\S]*?(?:%3E|\\\\+x3e|>|&gt;|&amp;gt;|\\*&quot;|&apos)([\\s\\S]*?)(?:%3C|\\\\+x3c|<|&lt;|&amp;lt;)(?:\\\\*/)<TAG_NAME>(?:%3E|\\\\+x3e|>|&gt;|&amp;gt;|\\*&quot;|&apos)";
    private static final String f = "RegexFactory";
    private static final String g = "(?:%3C|\\\\+x3c|<|&lt;|&amp;lt;)";
    private static final String h = "(?:%3E|\\\\+x3e|>|&gt;|&amp;gt;|\\*&quot;|&apos)";
    private static final String i = "(?:%3C|\\\\+x3c|<|&lt;|&amp;lt;)(?:\\\\*/)";
    private static final String j = "(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)";
    private static final String k = "(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)?";
    private static final String l = "(?:\\\\+x3D|%3d|=)";
    private static final String m = "(?:\\\\+x2B|%2b|\\+)";
    private static final String n = "[\\s\\S]*?";
    private static final String o = "(?:%26|\\\\+x26|&)";
    private static final String p = "(?:%24|\\\\+x24|$)";
    private static final String q = "(?:%21|\\\\+x21|!)";
    private static final String r = "(?:%5B|\\\\+x5B|\\[|\\\\n)";
    private static final String s = "(?:%5D|\\\\+x5D|\\])";
    private static final String t = "\\)";
    private static Pattern u = null;
    private static Pattern v = null;
    private static Pattern w = null;
    private static Pattern x = null;
    private static Pattern y = null;
    private static Pattern z = null;
    private static Pattern A = null;
    private static Pattern B = null;
    private static Pattern C = null;
    private static Pattern D = null;
    private static Pattern E = null;
    private static Pattern F = null;
    private static Pattern G = null;
    private static Pattern H = null;
    private static Pattern I = null;
    private static Pattern J = null;
    private static Pattern K = null;
    private static Pattern L = null;
    private static Pattern M = null;
    private static Pattern N = null;
    private static Pattern O = null;
    private static Pattern P = null;
    private static Pattern Q = null;
    private static Pattern R = null;
    private static Pattern S = null;
    private static Pattern T = null;
    private static Pattern U = null;
    private static Pattern V = null;
    private static Pattern W = null;
    private static Pattern X = null;
    private static Pattern Y = null;
    private static Pattern Z = null;
    private static Pattern aa = null;
    private static Pattern ab = null;
    private static Pattern ac = null;
    private static Pattern ad = null;
    private static Pattern ae = null;
    private static Pattern af = null;
    private static Pattern ag = null;
    private static Pattern ah = null;
    private static Pattern ai = null;
    private static Pattern aj = null;
    private static Pattern ak = null;
    private static Pattern al = null;
    private static Pattern am = null;
    private static Pattern an = null;
    private static Pattern ao = null;
    private static Pattern ap = null;
    private static Pattern aq = null;
    private static Pattern ar = null;
    private static Pattern as = null;
    private static Pattern at = null;
    private static Pattern au = null;
    private static Pattern av = null;
    private static Pattern aw = null;
    private static Pattern ax = null;
    private static Pattern ay = null;
    private static Pattern az = null;
    private static Pattern aA = null;
    private static Pattern aB = null;
    private static Pattern aC = null;
    private static Pattern aD = null;
    private static Pattern aE = null;
    private static Pattern aF = null;
    private static Pattern aG = null;
    private static Pattern aH = null;
    private static Pattern aI = null;
    private static Pattern aJ = null;
    private static Pattern aK = null;
    private static Pattern aL = null;
    private static Pattern aM = null;
    private static Pattern aN = null;
    private static Pattern aO = null;
    private static Pattern aP = null;
    private static Pattern aQ = null;
    private static Pattern aR = null;
    private static Pattern aS = null;
    private static Pattern aT = null;
    private static Pattern aU = null;
    private static Pattern aV = null;
    private static Pattern aX = null;
    private static Pattern aY = null;
    private static Pattern aZ = null;
    private static Pattern ba = null;
    private static Pattern bb = null;
    private static Pattern bc = null;
    private static Pattern bd = null;
    private static Pattern be = null;
    private static Pattern bf = null;
    private static Pattern bg = null;
    private static Pattern bh = null;
    private static Pattern bi = null;
    private static Pattern bj = null;
    private static Pattern bk = null;
    private static Pattern bl = null;
    private static Pattern bm = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Pattern f8159a = null;
    public static Pattern b = null;
    public static Pattern c = null;
    public static Pattern d = null;
    public static Pattern e = null;
    private static Pattern bn = null;
    private static Pattern bo = null;
    private static Pattern bp = null;
    private static Pattern bq = null;
    private static Pattern br = null;
    private static Pattern bs = null;
    private static Pattern bt = null;
    private static Pattern bu = null;
    private static Pattern bv = null;
    private static Pattern bw = null;
    private static Pattern bx = null;
    private static Pattern by = null;
    private static Pattern bz = null;
    private static Pattern bA = null;
    private static Pattern bB = null;
    private static Pattern bC = null;
    private static Pattern bD = null;
    private static Pattern bE = null;
    private static Pattern bF = null;
    private static Pattern bG = null;
    private static Pattern bH = null;
    private static Pattern bI = null;
    private static g bJ = null;

    public static g a() {
        return bJ;
    }

    public static Pattern b() {
        if (b == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            b = Pattern.compile("VAST.*/VAST", 34);
            Logger.d(f, "Regex VAST_FAST_VAST_BLOCK_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return b;
    }

    public static Pattern c() {
        if (f8159a == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            f8159a = Pattern.compile(a("VAST"), 2);
            Logger.d(f, "Regex VAST_BLOCK_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return f8159a;
    }

    public static Pattern d() {
        if (bm == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            bm = Pattern.compile(a("Impression"), 2);
            Logger.d(f, "Regex VAST_IMPRESSION_URL_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return bm;
    }

    public static Pattern e() {
        if (bl == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            bl = Pattern.compile(a("CompanionClickTracking"), 2);
            Logger.d(f, "Regex VAST_COMPANION_CLICK_TRACKING_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return bl;
    }

    public static Pattern f() {
        if (bk == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            bk = Pattern.compile(a("ClickTracking"), 2);
            Logger.d(f, "Regex VAST_CLICK_TRACKING_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return bk;
    }

    public static Pattern g() {
        if (bj == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            bj = Pattern.compile("(?:%3C|\\\\+x3c|<|&lt;|&amp;lt;)Tracking(?:[\\s]|%20)event(?:\\\\+x3D|%3d|=)(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)?([\\s\\S]*?)(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)?(?:%3E|\\\\+x3e|>|&gt;|&amp;gt;|\\*&quot;|&apos)([\\s\\S]*?)(?:%3C|\\\\+x3c|<|&lt;|&amp;lt;)(?:\\\\*/)Tracking(?:%3E|\\\\+x3e|>|&gt;|&amp;gt;|\\*&quot;|&apos)", 2);
            Logger.d(f, "Regex VAST_VIDEO_TRACKING_EVENT_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return bj;
    }

    public static Pattern h() {
        if (bi == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            bi = Pattern.compile(a("AdParameters"), 2);
            Logger.d(f, "Regex VAST_AD_PARAMETERS_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return bi;
    }

    public static Pattern i() {
        if (bh == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            bh = Pattern.compile(a("HTMLResource"), 2);
            Logger.d(f, "Regex VAST_HTML_RESOURCE_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return bh;
    }

    public static Pattern j() {
        if (bg == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            bg = Pattern.compile(a("IFrameResource"), 2);
            Logger.d(f, "Regex VAST_IFRAME_RESOURCE_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return bg;
    }

    public static Pattern k() {
        if (bf == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            bf = Pattern.compile(a("StaticResource"), 2);
            Logger.d(f, "Regex VAST_STATIC_RESOURCE_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return bf;
    }

    public static Pattern l() {
        if (be == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            be = Pattern.compile(a("YouTubeVideoId"), 2);
            Logger.d(f, "Regex VAST_YOUTUBE_VIDEO initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return be;
    }

    public static Pattern m() {
        if (bd == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            bd = Pattern.compile(a("VASTAdTagURI"), 2);
            Logger.d(f, "Regex VAST_VAST_AD_TAG_URI_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return bd;
    }

    public static Pattern n() {
        if (bc == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            bc = Pattern.compile(a("CompanionClickThrough"), 2);
            Logger.d(f, "Regex VAST_COMPANION_CLICK_URL_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return bc;
    }

    public static Pattern o() {
        if (bb == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            bb = Pattern.compile("(apiFramework(?:\\\\+x3D|%3d|=)(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)VPAID(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)|type(?:\\\\+x3D|%3d|=)(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)application/javascript(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;))", 2);
            Logger.d(f, "Regex VAST_MEDIA_FILE_PATTERN_JS_APP_ATTRIBUTE initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return bb;
    }

    public static Pattern p() {
        if (aZ == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aZ = Pattern.compile(aW.replaceFirst("<TAG_NAME>", "MediaFile[^s]").replace("<TAG_NAME>", "MediaFile"), 2);
            Logger.d(f, "Regex VAST_MEDIA_FILE_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return aZ;
    }

    public static Pattern q() {
        if (ba == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            ba = Pattern.compile("(?:%3C|\\\\+x3c|<|&lt;|&amp;lt;)MediaFile[\\s\\S]*?type(?:\\\\+x3D|%3d|=)(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)([\\s\\S]*?)(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)", 2);
            Logger.d(f, "Regex VAST_MEDIA_FILE_TYPE initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return ba;
    }

    public static Pattern r() {
        if (aY == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aY = Pattern.compile(a("ClickThrough"), 2);
            Logger.d(f, "Regex VAST_CLICK_URL_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms, value = " + aY.toString());
        }
        return aY;
    }

    public static Pattern s() {
        if (aX == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aX = Pattern.compile(a("AdSystem"), 2);
            Logger.d(f, "Regex VAST_AD_SYSTEM_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return aX;
    }

    public static Pattern t() {
        if (aV == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aV = Pattern.compile("(?:%3C|\\\\+x3c|<|&lt;|&amp;lt;)Creative[^s]?(?:id(?:\\\\+x3D|%3d|=)(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)([0-9]+)(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;))?.*?(?:%3E|\\\\+x3e|>|&gt;|&amp;gt;|\\*&quot;|&apos)[\\s\\S]*?(?:%3C|\\\\+x3c|<|&lt;|&amp;lt;)(?:\\\\*/)Creative(?:%3E|\\\\+x3e|>|&gt;|&amp;gt;|\\*&quot;|&apos)", 2);
            Logger.d(f, "Regex VAST_CREATIVE_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms, value = " + aV);
        }
        return aV;
    }

    public static Pattern u() {
        if (aU == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aU = Pattern.compile("(?:%3C|\\\\+x3c|<|&lt;|&amp;lt;)((.*?)(?:\\\\+x3D|%3d|=)(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)?(.*?)(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)?(?:(?: +|%20).*?)?)?(?:%3E|\\\\+x3e|>|&gt;|&amp;gt;|\\*&quot;|&apos)", 34);
            Logger.d(f, "Regex VAST_AD_ID_OPTIONAL_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return aU;
    }

    public static Pattern v() {
        if (aT == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aT = Pattern.compile("(?:%3C|\\\\+x3c|<|&lt;|&amp;lt;)(Creative|Ad)(?:(?: +|%20)id(?:\\\\+x3D|%3d|=)(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)?(.*?)(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)?(?:(?: +|%20).*?)?)?(?:%3E|\\\\+x3e|>|&gt;|&amp;gt;|\\*&quot;|&apos)", 34);
            Logger.d(f, "Regex VAST_AD_ID_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return aT;
    }

    public static Pattern w() {
        if (aS == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aS = Pattern.compile("(?:%3C|\\\\+x3c|<|&lt;|&amp;lt;)Ad(?:(?: +|%20)id(?:\\\\+x3D|%3d|=)(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)?(.*?)(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)?(?:(?: +|%20).*?)?)?(?:%3E|\\\\+x3e|>|&gt;|&amp;gt;|\\*&quot;|&apos)[\\s\\S]*?(?:%3C|\\\\+x3c|<|&lt;|&amp;lt;)(?:\\\\*/)Ad(?:%3E|\\\\+x3e|>|&gt;|&amp;gt;|\\*&quot;|&apos)", 34);
            Logger.d(f, "Regex VAST_AD_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return aS;
    }

    public static Pattern x() {
        if (aR == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aR = Pattern.compile("(?:%3C|\\\\+x3c|<|&lt;|&amp;lt;)(?:%21|\\\\+x21|!)(?:%5B|\\\\+x5B|\\[|\\\\n)CDATA(?:%5B|\\\\+x5B|\\[|\\\\n)([\\s\\S]*)(?:%5D|\\\\+x5D|\\])(?:%5D|\\\\+x5D|\\])(?:%3E|\\\\+x3e|>|&gt;|&amp;gt;|\\*&quot;|&apos)");
            Logger.d(f, "Regex CDATA_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return aR;
    }

    public static Pattern y() {
        if (aQ == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aQ = Pattern.compile("\\\\+u([0-9a-f]{4})");
            Logger.d(f, "Regex UNICODE_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return aQ;
    }

    public static Pattern z() {
        if (aO == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aO = Pattern.compile("data:([a-zA-Z]*\\/[a-zA-Z1-9]*);?([\\s\\S]*?;)base64,([^\\\"\\')]*)");
            Logger.d(f, "Regex HTML_DATA_RESOURCES_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return aO;
    }

    public static Pattern A() {
        if (aN == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aN = Pattern.compile("(https?:\\/\\/.*?).googlevideo.com\\/videoplayback");
            Logger.d(f, "Regex GOOGLE_VIDEO_DOMAIN_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return aN;
    }

    public static Pattern B() {
        if (aM == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aM = Pattern.compile("(https?:\\\\*\\/\\\\*\\/.*?)(?:;frame-src|(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)|(?:%3C|\\\\+x3c|<|&lt;|&amp;lt;)|(?:%3E|\\\\+x3e|>|&gt;|&amp;gt;|\\*&quot;|&apos)|\\s?(?:%5D|\\\\+x5D|\\]){2})");
            Logger.d(f, "Regex URL_RESOURCES_WITH_SPECIAL_CHARS initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return aM;
    }

    public static Pattern C() {
        if (aI == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aI = Pattern.compile("\\\\x3c(?:!DOCTYPE(?:.?))html\\\\x3e(.*?)(\\\\x3c/html\\\\x3e)");
            Logger.d(f, "Regex UNICODE_ENCODED_HTML initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return aI;
    }

    public static Pattern D() {
        if (aJ == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aJ = Pattern.compile("(?s)(<html>.+?</html>)|(%3Chtml%3E.+?%3C/html%3E)");
            Logger.d(f, "Regex HTML_CONTENT_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return aJ;
    }

    public static Pattern E() {
        if (aK == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aK = Pattern.compile("(<body>.+?</body>)");
            Logger.d(f, "Regex HTML_BODY_CONTENT_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return aK;
    }

    public static Pattern F() {
        if (aL == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aL = Pattern.compile("(<body.+?</body>)");
            Logger.d(f, "Regex HTML_BODY_CONTENT_PATTERN2 initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return aL;
    }

    public static Pattern G() {
        if (aH == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aH = Pattern.compile("((http|https|gmsg)(:|%3A)\\\\*(/|%2F)\\\\*(/|%2F).*?)(?:;frame-src| alt|(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)|(?:%3C|\\\\+x3c|<|&lt;|&amp;lt;)|(?:%3E|\\\\+x3e|>|&gt;|&amp;gt;|\\*&quot;|&apos)|(?:%5B|\\\\+x5B|\\[|\\\\n)|(?:%5D|\\\\+x5D|\\])|\\)|[\n\r\t\\x{0001}-\\x{001f}\\x{fffd}])");
            Logger.d(f, "Regex URL_RESOURCES initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return aH;
    }

    public static Pattern H() {
        if (aB == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aB = Pattern.compile("video_id(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;):[\\s]*(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)([\\s\\S]*?)(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)", 2);
            Logger.d(f, "Regex ADMOB_VIDEOID_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return aB;
    }

    public static Pattern I() {
        if (aA == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aA = Pattern.compile("creative_id(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;):[\\s]*(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)([\\s\\S]*?)(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)", 2);
            Logger.d(f, "Regex ADMOB_CREATIVEID_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return aA;
    }

    public static Pattern J() {
        if (az == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            az = Pattern.compile("destination_url(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;):[\\s]*(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)([\\s\\S]*?)(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)", 2);
            Logger.d(f, "Regex ADMOB_VIDEO_CLICKURL_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return az;
    }

    public static Pattern K() {
        if (ay == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            ay = Pattern.compile("........VAST .*?AdSystem", 32);
            Logger.d(f, "Regex MULTI_VAST_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return ay;
    }

    public static Pattern L() {
        if (ax == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            ax = Pattern.compile("pod.vast", 16);
            Logger.d(f, "Regex POD_VAST_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return ax;
    }

    public static Pattern M() {
        if (aw == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aw = Pattern.compile("VAST ", 16);
            Logger.d(f, "Regex VAST_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return aw;
    }

    public static Pattern N() {
        if (av == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            av = Pattern.compile("ad_click_dest[\\s].*?=[\\s].*?\\\"([\\S].*?)\\\"");
            Logger.d(f, "Regex MRAID_URL_CLICK_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return av;
    }

    public static Pattern O() {
        if (au == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            au = Pattern.compile("adUnitId='(.*?)'", 2);
            Logger.d(f, "Regex MAX_AD_VIEW_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return au;
    }

    public static Pattern P() {
        if (at == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            at = Pattern.compile("[0-9]{2,3}\\.[0-9]{2,3}\\.[0-9]{2,3}\\.[0-9]{2,3}");
            Logger.d(f, "Regex IP_ADDRESS_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return at;
    }

    public static Pattern Q() {
        if (as == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            as = Pattern.compile("publisher-app-icon\\s?\\{(.*?)background(-image)?:.*?url\\(\"\\s*(?<url>.*?)\"\\s*\\)(.*?)\\}", 34);
            Logger.d(f, "Regex PUBLISHER_APP_ICON_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return as;
    }

    public static Pattern R() {
        if (aq == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aq = Pattern.compile("<(?:canvas|svg)\\sclass=\\\\?\\\"(\\S+?)\\send-frame");
            Logger.d(f, "Regex IMAGE_URL_CLASS_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return aq;
    }

    public static Pattern S() {
        if (ap == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            ap = Pattern.compile("description[^>]+>\\s*<span[^>]+>([^<]+)");
            Logger.d(f, "Regex DESCRIPTION_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return ap;
    }

    public static Pattern T() {
        if (ao == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            ao = Pattern.compile("headline[^>]+>\\s*<span[^>]+>([^<]+)");
            Logger.d(f, "Regex HEADLINE_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return ao;
    }

    public static Pattern U() {
        if (an == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            an = Pattern.compile("short-app-name[^>]+truncated[^>]+>\\s*<span[^>]+>([^<]+)");
            Logger.d(f, "Regex SHORT_APP_NAME_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return an;
    }

    public static Pattern V() {
        if (am == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            am = Pattern.compile("<(?:canvas|svg)\\sclass=\\\\?\\\"(\\S+?)\\sendcard-app-icon");
            Logger.d(f, "Regex APP_ICON_CLASS_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return am;
    }

    public static Pattern W() {
        if (al == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            al = Pattern.compile("<div[^>]+podding-card[^>]*>");
            Logger.d(f, "Regex PODDING_CARD_DIV_CLASS_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return al;
    }

    public static Pattern X() {
        if (ak == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            ak = Pattern.compile("<div[^>]+\\sendcard[\\s>][^>]*>");
            Logger.d(f, "Regex ENDCARD_DIV_CLASS_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return ak;
    }

    public static Pattern Y() {
        if (aj == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aj = Pattern.compile("\\/VAST(?:%3E|\\\\+x3e|>|&gt;|&amp;gt;|\\*&quot;|&apos).+ytimg[^\"]+?\\/([^\\\"\\\\/]{11})\\/[^\"]+(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)");
            Logger.d(f, "Regex YOUTUBE_VIDEO_ID_PATTERN_2 initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return aj;
    }

    public static Pattern Z() {
        if (ai == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            ai = Pattern.compile("\\/VAST(?:%3E|\\\\+x3e|>|&gt;|&amp;gt;|\\*&quot;|&apos)(?:[^,]+,){6}(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)([^\\\"]{11})(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)");
            Logger.d(f, "Regex YOUTUBE_VIDEO_ID_PATTERN_1 initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return ai;
    }

    public static Pattern aa() {
        if (ah == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            ah = Pattern.compile("<meta([^>]+)\\sindex=\\\\?\\\"(\\d)\\\\?\\\"\\sname=\\\\?\\\"video_fields\\\\?\\\">");
            Logger.d(f, "Regex META_VIDEO_FIELDS_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return ah;
    }

    public static Pattern ab() {
        if (ag == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            ag = Pattern.compile("https://www\\.youtube\\.com/watch\\?v(\\\\x3d)(.*?)(\\\\x26)");
            Logger.d(f, "Regex YOUTUBE_VIDEO_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return ag;
    }

    public static Pattern ac() {
        if (af == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            af = Pattern.compile("Clickstring\\+([0-9])=(.*?)(?:(?:%24|\\\\+x24|$)|(?:%26|\\\\+x26|&)|(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;))", 2);
            Logger.d(f, "Regex CLICK_STRING_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return af;
    }

    public static Pattern ad() {
        if (ae == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            ae = Pattern.compile("<img[^>]*src=[\\\"']([^\\\"^']*)(.*)\\/>|image:url((.*))");
            Logger.d(f, "Regex AD_IMAGE_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return ae;
    }

    public static Pattern ae() {
        if (ad == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            ad = Pattern.compile("is_rewarded_html5_playable[^}]*?true");
            Logger.d(f, "Regex PLAYABLE_FLAG_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return ad;
    }

    public static Pattern af() {
        if (ac == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            ac = Pattern.compile("survey_payload[\\'\\\"]\\s*:\\s*[\\'\\\"](.*?)[\\'\\\"]");
            Logger.d(f, "Regex SURVEY_TEXT_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return ac;
    }

    public static Pattern ag() {
        if (ab == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            ab = Pattern.compile("<(?!script|head|link|meta)([a-zA-Z0-9]+)(?:\\s*[^>]*)>([^=\\/\\{]+?)<\\/\\1>");
            Logger.d(f, "Regex INNER_TEXT_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return ab;
    }

    public static Pattern ah() {
        if (aa == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aa = Pattern.compile("(?<!AdGroup\\+)Creative\\+ID\\+([0-9])=(.*?)(?:(?:%24|\\\\+x24|$)|(?:%26|\\\\+x26|&)|(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;))", 2);
            Logger.d(f, "Regex CREATIVE_ID_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return aa;
    }

    public static Pattern ai() {
        if (Z == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Z = Pattern.compile("AdGroup\\+Creative\\+ID\\+([0-9])=(.*?)(?:(?:%24|\\\\+x24|$)|(?:%26|\\\\+x26|&)|(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;))", 2);
            Logger.d(f, "Regex ADGROUP_CREATIVE_ID_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return Z;
    }

    public static Pattern aj() {
        if (X == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            X = Pattern.compile("Landing\\+Page\\+([0-9])=(.*?)&", 2);
            Logger.d(f, "Regex LANDING_PAGE_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return X;
    }

    public static Pattern ak() {
        if (ar == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            ar = Pattern.compile("Creatives=(.*?)(?:(?:%24|\\\\+x24|$)|(?:%26|\\\\+x26|&)|(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;))", 2);
            Logger.d(f, "Regex CREATIVES_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return ar;
    }

    public static Pattern al() {
        if (Y == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Y = Pattern.compile("destinationUrl: (?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)(.*?)(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)", 2);
            Logger.d(f, "Regex DESTINATION_URL_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms, value : " + Y);
        }
        return Y;
    }

    public static Pattern am() {
        if (W == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            W = Pattern.compile("Creative\\+ID\\+([0-9])", 2);
            Logger.d(f, "Regex MULTIPLE_ADS_COUNT_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return W;
    }

    public static Pattern an() {
        if (T == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            T = Pattern.compile("(src\\s*=\\s*['\\\"].*?\\/)([A-Za-z0-9]{8}_)(.*?['\\\"\\?])|(url\\(.*?\\/)([A-Za-z0-9]{8}_)(.*?[)\\?])", 2);
            Logger.d(f, "Regex DIRECTSOLD_CONTENT_SRC_REGEX_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return T;
    }

    public static Pattern ao() {
        if (U == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            U = Pattern.compile("\"URL over\"[ ]href=\"(.*?)\"", 2);
            Logger.d(f, "Regex URL_OVER_HREF_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return U;
    }

    public static Pattern ap() {
        if (V == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            V = Pattern.compile("href=\"(.*?)\"", 2);
            Logger.d(f, "Regex BANNER_HREF_CLICK_URL_PATTER initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return V;
    }

    public static Pattern aq() {
        if (R == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            R = Pattern.compile("<video .*src=\"(\\S*?)\".*</video>");
            Logger.d(f, "Regex VIDEO_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return R;
    }

    public static Pattern ar() {
        if (S == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            S = Pattern.compile("<script .*id=\"ad-context\">(.*?)</script>");
            Logger.d(f, "Regex AD_CONTEXT_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return S;
    }

    public static Pattern as() {
        if (Q == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Q = Pattern.compile("<span class=\"banner-description\">(.*?)</span>");
            Logger.d(f, "Regex BANNER_DESCRIPTION initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return Q;
    }

    public static Pattern at() {
        if (P == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            P = Pattern.compile("<span class=\"banner-title\">(.*?)</span>");
            Logger.d(f, "Regex BANNER_TITLE_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return P;
    }

    public static Pattern au() {
        if (O == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            O = Pattern.compile("!--(.*?)--");
            Logger.d(f, "Regex HTML_COMMENT_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return O;
    }

    public static Pattern av() {
        if (M == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            M = Pattern.compile("clickUrl: '([^']+)'");
            Logger.d(f, "Regex PLAYABLE_CLICK_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return M;
    }

    public static Pattern aw() {
        if (N == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            N = Pattern.compile("(market:[^'\"]+)['\"]");
            Logger.d(f, "Regex MARKET_APP_ID initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return N;
    }

    public static Pattern ax() {
        if (u == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            u = Pattern.compile("<tns:Ad>([\\s\\S]*?)</tns:Ad>", 2);
            Logger.d(f, "Regex PATTERN_FYBER_VAST_CONTENT initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return u;
    }

    public static Pattern ay() {
        if (v == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            v = Pattern.compile("<tns:AdNetwork Value=\"(.*?)\" />", 2);
            Logger.d(f, "Regex PATTERN_FYBER_VAST_CONTENT initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return v;
    }

    public static Pattern az() {
        if (w == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            w = Pattern.compile("<meta name=\"inneractive-session\" content=\"([\\s\\S]*?)\" \\/>", 2);
            Logger.d(f, "Regex PATTERN_FYBER_HTML_AD_META_SESSION initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return w;
    }

    public static Pattern aA() {
        if (x == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            x = Pattern.compile("<meta name=\"inneractive-session\" content=\"([\\s\\S]*?)\" \\/>", 2);
            Logger.d(f, "Regex PATTERN_FYBER_HTML_AD_CONTENT_JS_CSS initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return x;
    }

    public static Pattern aB() {
        if (y == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            y = Pattern.compile("<a.*?id=\"liftoff-link\".*a>", 2);
            Logger.d(f, "Regex LIFTOFF_CLICK_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return y;
    }

    public static Pattern aC() {
        if (D == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            D = Pattern.compile("<a(.*?)</a>", 2);
            Logger.d(f, "Regex HTML_ANCHOR_ELEMENT_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return D;
    }

    public static Pattern aD() {
        if (z == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            z = Pattern.compile("videoSrc:%20%22(.*?)%22", 2);
            Logger.d(f, "Regex VIDEO_URL_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return z;
    }

    public static Pattern aE() {
        if (A == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            A = Pattern.compile("<meta name=\"inneractive-session\" content=\"([\\s\\S]*?)\" \\/>", 2);
            Logger.d(f, "Regex HREF_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return A;
    }

    public static Pattern aF() {
        if (C == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            C = Pattern.compile("^[0-9a-f]*$");
            Logger.d(f, "Regex HASH_FILENAME_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return C;
    }

    public static Pattern aG() {
        if (B == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            B = Pattern.compile("event_payload\".*\"event_pl\":\"(.*?)\"", 34);
            Logger.d(f, "Regex EVENT_PAYLOAD_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return B;
    }

    public static Pattern aH() {
        if (E == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            E = Pattern.compile("src=\\\\?\"([^\\\\\"]+)");
            Logger.d(f, "Regex SRC_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return E;
    }

    public static Pattern aI() {
        if (H == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            H = Pattern.compile("src=\\\\?\"([^\"]+)");
            Logger.d(f, "Regex SRC_GREEDY_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return H;
    }

    public static Pattern aJ() {
        if (F == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            F = Pattern.compile("&lt;(img|IMG) (src|SRC)=&quot;(.*?)&quot;?(.*?)( style| STYLE|&gt;)");
            Logger.d(f, "Regex MRAID_IMG initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return F;
    }

    public static Pattern aK() {
        if (G == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            G = Pattern.compile("&lt;(a|A) (href|HREF)=&quot;(.*?)&quot;(&gt;| )");
            Logger.d(f, "Regex MRAID_ANCHOR_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return G;
    }

    public static Pattern aL() {
        if (I == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            I = Pattern.compile("pinpoint_url\\\":\\\"([^\\\"]+)\"");
            Logger.d(f, "Regex LIFTOFF_PINPOINT_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return I;
    }

    public static Pattern aM() {
        if (J == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            J = Pattern.compile("click_config\\\":\\{\\\"clickthrough_url\\\":\\{\\\"url\\\":\\\"([^\\\"]+)\\\"");
            Logger.d(f, "Regex LIFTOFF_CLICKTHROUGH_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return J;
    }

    public static Pattern aN() {
        if (L == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            L = Pattern.compile("\\{\\\"clickURLs\\\":\\{\\\"clickthroughURL\\\":\\{\\\"url\\\":\\\"([^\\\"]+)\\\"");
            Logger.d(f, "Regex LIFTOFF_PINPOINT_OUTER_ENV_CLICK_URL_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return L;
    }

    public static Pattern aO() {
        if (K == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            K = Pattern.compile("bidBundle\\\":\\\"([^\\\"]+)\\\"");
            Logger.d(f, "Regex LIFTOFF_BIDBUNDLE_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return K;
    }

    public static String a(String str) {
        return aW.replace("<TAG_NAME>", str);
    }

    public static Pattern aP() {
        if (c == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            c = Pattern.compile("trackingUrl = (\\'|\\\\\\\"|\\\")(.*?)(\\'|\\\\\\\"|\\\")(;| \\+)", 2);
            Logger.d(f, "Regex APPLOVIN_MRAID_CLICK_URL_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return c;
    }

    public static Pattern aQ() {
        if (bq == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            bq = Pattern.compile("OMG\\s+=\\s+.+\"clickUrl\".+?\"(.+?)\"");
            Logger.d(f, "Regex MINTEGRAL_DSP_MULTI_CLICK_URL initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return bq;
    }

    public static Pattern aR() {
        if (br == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            br = Pattern.compile("OMG\\s+=.*config\\\\\".?\\\\\"(.*?)\\\\\"");
            Logger.d(f, "Regex MINTEGRAL_MOREOFFER_CONFIG initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return br;
    }

    public static Pattern aS() {
        if (bs == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            bs = Pattern.compile("\"(<.*>)");
            Logger.d(f, "Regex HTML_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return bs;
    }

    public static Pattern aT() {
        if (aP == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aP = Pattern.compile("(?:%3C|\\\\+x3c|<|&lt;|&amp;lt;)a .*?href(?:\\\\+x3D|%3d|=)(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)(.*?)(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)");
            Logger.d(f, "Regex HTML_ANCHOR_REF_URL_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return aP;
    }

    public static Pattern aU() {
        if (aC == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aC = Pattern.compile("encrypted-tbn\\d*\\.gstatic.com/shopping\\?q");
            Logger.d(f, "Regex ADMOB_SHOPPING_COLLAGE_URL_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return aC;
    }

    public static Pattern aV() {
        if (d == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            d = Pattern.compile("\\\"clcode\\\":\\\"(\\S*?)\\\"");
            Logger.d(f, "Regex APPLOVIN_CLCODE_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return d;
    }

    public static Pattern aW() {
        if (bt == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            bt = Pattern.compile("(?:lazybumblebee\\.com|bidmachine\\.io|bm-ads\\.io)\\/track[^\\?]*?\\?.*?context[^=]*?=([^&]+?)&");
            Logger.d(f, "Regex BIDMACHINE_CONTEXT_ID_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return bt;
    }

    public static Pattern aX() {
        if (bu == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            bu = Pattern.compile("(?:lazybumblebee\\.com|bidmachine\\.io|bm-ads\\.io)\\/track[^\\?]*?\\?.*?context[^=]*?=([^&]+)");
            Logger.d(f, "Regex BIDMACHINE_CONTEXT_ID_PATTERN2 initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return bu;
    }

    public static Pattern aY() {
        if (bv == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            bv = Pattern.compile("\\\"&context=([^&]+?)\\\"");
            Logger.d(f, "Regex BIDMACHINE_CONTEXT_ID_HTML_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return bv;
    }

    public static Pattern aZ() {
        if (bw == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            bw = Pattern.compile("=\"adm\">(.*?)</div>");
            Logger.d(f, "Regex VERVE_ENCODED_JSON_HTML_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return bw;
    }

    public static Pattern ba() {
        if (bx == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            bx = Pattern.compile("adm.*?JSON.parse\\(.*?\\(\"(eyJ.*?)\"");
            Logger.d(f, "Regex VERVE_ENCODED_JSON_DATA_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return bx;
    }

    public static Pattern bb() {
        if (by == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            by = Pattern.compile("(\\{\"[^{}]*\"crid\"[^{}]*\\})");
            Logger.d(f, "Regex VERVE_JSON_DATA_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return by;
    }

    public static Pattern bc() {
        if (bn == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            bn = Pattern.compile("window.al_clcode\\s*=\\s*'(.*?)'");
            Logger.d(f, "Regex APPLOVIN_WINDOW_CLCODE_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return bn;
    }

    public static Pattern bd() {
        if (e == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            e = Pattern.compile("\"clcode\"\\s*:\\s*\"(.*?)\"");
            Logger.d(f, "Regex APPLOVIN_JSON_CLCODE_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return e;
    }

    public static Pattern be() {
        if (bo == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            bo = Pattern.compile("(?:%3C|\\\\+x3c|<|&lt;|&amp;lt;)script\\s+type=\"application/json\"\\s+id=\"ad-context\"(?:%3E|\\\\+x3e|>|&gt;|&amp;gt;|\\*&quot;|&apos)(.*?)(?:%3C|\\\\+x3c|<|&lt;|&amp;lt;)/script");
            Logger.d(f, "Regex APPLOVIN_ECOMMERCE_JSON_INSIDE_HTML_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return bo;
    }

    public static Pattern bf() {
        if (bC == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            bC = Pattern.compile("externalHtmlURL:\\s*\"([^\"]+)\"");
            Logger.d(f, "Regex VUNGLE_HTML_ENDCARD_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return bC;
    }

    public static Pattern bg() {
        if (aD == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aD = Pattern.compile("background\\s*:\\s*[a-z]+-gradient\\([^\\)]+\\)\\s*;?");
            Logger.d(f, "Regex ADMOB_BACKGROUND_GRADIENT_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return aD;
    }

    public static Pattern bh() {
        if (aE == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aE = Pattern.compile("<svg[^>]*viewBox=['\"]\\s*\\d+\\s*\\d+\\s*(\\d+)\\s*(\\d+)\\s*['\"][^>]*>", 32);
            Logger.d(f, "Regex ADMOB_SVG_VIEW_BOX_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return aE;
    }

    public static Pattern bi() {
        if (aF == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aF = Pattern.compile("<([a-zA-Z]+)(?:\\s+[^>]*)?\\sstyle\\s*=\\s*\"(?=.*(background-image\\s*:\\s*url\\([^\\)]+\\)\\s*;?)).*?\"[^>]*>", 32);
            Logger.d(f, "Regex ADMOB_BACKGROUND_IMAGE_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return aF;
    }

    public static Pattern bj() {
        if (aG == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aG = Pattern.compile("(background-size\\s*:\\s*(cover|contain)\\s*;?)", 32);
            Logger.d(f, "Regex ADMOB_BACKGROUND_SIZE_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return aG;
    }

    public static Pattern bk() {
        if (bz == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            bz = Pattern.compile("Chartboost\\.BiddingParams\\s*=\\s*.*\"impressionId\"\\s*:\\s*\"(.*?)\"", 32);
            Logger.d(f, "Regex CHARTBOOST_HTML_BIDDING_PARAMS_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return bz;
    }

    public static Pattern bl() {
        if (bA == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            bA = Pattern.compile("Chartboost\\.Params\\s*=.*?impressionId\\s*:\\s*\"(.*?)\"", 32);
            Logger.d(f, "Regex CHARTBOOST_HTML_NETWORK_PARAMS_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return bA;
    }

    public static Pattern bm() {
        if (bB == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            bB = Pattern.compile("[\\\"'`](ey[A-Za-z0-9+/=]{100,})[\\\"'`]", 32);
            Logger.d(f, "Regex CHARTBOOST_RENDERABLES_CREATIVE_ID_JSON_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return bB;
    }

    public static Pattern b(String str) {
        if (bp == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            bp = Pattern.compile("function\\s+" + str + ".*?\\{.*?targetUrl\\s*=\\s*\\\\?\\\"(.*?)\\\\?\\\"", 32);
            Logger.d(f, "Regex APPLOVIN_URL_OVER_JS_CLICK_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return bp;
    }

    public static Pattern bn() {
        if (bD == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            bD = Pattern.compile("chartboost\\.com/webview/(.*?)/(reward|interstitial|banner)|chartboost\\.com/auction/(.*?)/(reward|interstitial|banner)", 32);
            Logger.d(f, "Regex CHARTBOOST_PREFETCH_URL_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return bD;
    }

    public static Pattern bo() {
        if (bE == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            bE = Pattern.compile("(<picture.+?<\\?/picture>)");
            Logger.d(f, "Regex AMAZON_PICTURE_XML_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return bE;
    }

    public static Pattern bp() {
        if (bF == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            bF = Pattern.compile("font-family:\\s+'(Amazon)");
            Logger.d(f, "Regex AMAZON_FONT_FACE_STYLE_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return bF;
    }

    public static Pattern bq() {
        if (bG == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            bG = Pattern.compile("<div[^>]*?style=\\\\\\\"display:none[^>]*?id=\\\\\\\"(adm)\\\\\\\"", 32);
            Logger.d(f, "Regex AMAZON_ADM_DOWNSTREAMSTRUCT_PATTERN initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return bG;
    }

    public static Pattern br() {
        if (bH == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            bH = Pattern.compile("(window\\.\\$ad\\s*=\\s*document\\.getElementById\\('ad'\\);)");
            Logger.d(f, "Regex AMAZON_SPONSORED_IDENTIFIER_PATTERN1 initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return bH;
    }

    public static Pattern bs() {
        if (bI == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            bI = Pattern.compile("(window\\.imageCreative\\s*=\\s*Creative\\.default\\(\\$ad,)");
            Logger.d(f, "Regex AMAZON_SPONSORED_IDENTIFIER_PATTERN2 initialized, operation took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
        }
        return bI;
    }
}
