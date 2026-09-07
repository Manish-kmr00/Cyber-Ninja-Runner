package sg.bigo.ads.common.u.a;

import android.net.Uri;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.mbridge.msdk.MBridgeConstans;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import sg.bigo.ads.common.g;
import sg.bigo.ads.common.u.f;
import sg.bigo.ads.common.utils.k;

/* JADX INFO: loaded from: classes12.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final sg.bigo.ads.common.u.b.c<? extends sg.bigo.ads.common.u.a> f13267a;
    URL b;
    boolean c;
    private final b d;
    private final g e;
    private final URL f;
    private int g;
    private HttpURLConnection h;

    private c(sg.bigo.ads.common.u.b.c cVar, URL url, URL url2, b bVar, g gVar) {
        this.c = false;
        this.f13267a = cVar;
        this.b = url;
        this.f = url2;
        this.d = bVar;
        this.e = gVar;
        sg.bigo.ads.common.t.a.a(0, 3, "HttpRequest", "request, " + cVar + ", redirectURL= " + url2 + ", content=" + cVar.d());
    }

    public c(sg.bigo.ads.common.u.b.c cVar, b bVar, g gVar) {
        this(cVar, null, null, bVar, gVar);
    }

    private URL a(Uri uri) {
        if (uri == null) {
            return null;
        }
        if (this.e == null || !this.f13267a.n) {
            return new URL(uri.toString());
        }
        Uri.Builder builderBuildUpon = Uri.parse(uri.toString()).buildUpon();
        a(builderBuildUpon, "sdk_ver", this.e.y());
        a(builderBuildUpon, "sdk_vc", "50201");
        a(builderBuildUpon, "country", this.e.U());
        a(builderBuildUpon, MBridgeConstans.APP_KEY, this.e.a());
        a(builderBuildUpon, "pkg_ver", this.e.c());
        a(builderBuildUpon, "pkg_vc", new StringBuilder().append(this.e.d()).toString());
        a(builderBuildUpon, "os", this.e.i());
        a(builderBuildUpon, "os_ver", this.e.j());
        a(builderBuildUpon, "os_lang", this.e.k());
        a(builderBuildUpon, "vendor", this.e.l());
        a(builderBuildUpon, "model", this.e.m());
        a(builderBuildUpon, "dpi", new StringBuilder().append(this.e.p()).toString());
        a(builderBuildUpon, "dpi_f", this.e.q());
        a(builderBuildUpon, "resolution", this.e.o());
        a(builderBuildUpon, "net", this.e.r());
        a(builderBuildUpon, "tz", this.e.s());
        if (this.f13267a.f()) {
            a(builderBuildUpon, "enc", "1");
        }
        return new URL(builderBuildUpon.build().toString());
    }

    private static void a(Uri.Builder builder, String str, String str2) {
        if (builder == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        builder.appendQueryParameter(str, str2);
    }

    public final HttpURLConnection a() throws IOException {
        String str;
        URL urlA = this.f;
        if (urlA == null) {
            this.f13267a.a("PreHost");
            T t = this.f13267a.j;
            String strA = t.a();
            String strF = t.f();
            String strD = t.d();
            if (!TextUtils.isEmpty(strF) && !TextUtils.isEmpty(strD) && !TextUtils.equals(strF, strD)) {
                this.f13267a.a("PreHost", strF);
            }
            if (t.e()) {
                this.f13267a.a(HttpHeaders.HOST, strD);
            }
            this.f13267a.h();
            urlA = a(Uri.parse(strA));
            this.b = urlA;
        } else if (urlA != null && this.e != null && this.f13267a.n) {
            urlA = a(Uri.parse(urlA.toString()));
        }
        boolean zEqualsIgnoreCase = "HTTPS".equalsIgnoreCase(urlA.getProtocol());
        URLConnection uRLConnectionOpenConnection = urlA.openConnection();
        this.h = zEqualsIgnoreCase ? (HttpsURLConnection) uRLConnectionOpenConnection : (HttpURLConnection) uRLConnectionOpenConnection;
        this.h.setInstanceFollowRedirects(false);
        this.h.setDoInput(true);
        this.h.setUseCaches(false);
        this.h.setConnectTimeout((int) this.f13267a.l);
        this.h.setReadTimeout((int) this.f13267a.l);
        this.h.setRequestMethod(this.f13267a.a());
        Map<String, Set<String>> map = this.f13267a.m;
        if (!map.containsKey("Connection")) {
            map.put("Connection", new HashSet(Collections.singletonList(HttpHeaders.KEEP_ALIVE)));
        }
        Set<String> set = map.get("Range");
        Set<String> set2 = map.get(HttpHeaders.ACCEPT_ENCODING);
        if (k.a(set) && k.a(set2)) {
            this.c = true;
            map.put(HttpHeaders.ACCEPT_ENCODING, new HashSet(Collections.singletonList("gzip")));
        }
        if (!map.containsKey(HttpHeaders.HOST)) {
            try {
                b bVar = this.d;
                String host = this.h.getURL().getHost();
                str = TextUtils.isEmpty(host) ? "" : bVar.f13266a.get(host);
            } catch (Exception unused) {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                map.put(HttpHeaders.HOST, new HashSet(Collections.singletonList(str)));
            }
        }
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            Set<String> value = entry.getValue();
            if (!TextUtils.isEmpty(key) && !k.a(value)) {
                for (String str2 : value) {
                    if (!TextUtils.isEmpty(str2)) {
                        this.h.addRequestProperty(key, str2);
                    }
                }
            }
        }
        byte[] bArrC = this.f13267a.c();
        if (bArrC != null && bArrC.length > 0) {
            f fVarB = this.f13267a.b();
            if (fVarB != null) {
                this.h.setRequestProperty("Content-Type", fVarB.toString());
            }
            this.h.setDoOutput(true);
            this.h.setRequestProperty("Content-Length", Long.toString(this.f13267a.e()));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(this.h.getOutputStream());
            bufferedOutputStream.write(bArrC);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        }
        return this.h;
    }

    public final c a(URL url) {
        c cVar = new c(this.f13267a, this.b, url, this.d, this.e);
        cVar.g = this.g + 1;
        return cVar;
    }

    public final boolean b() {
        return this.f != null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f != null) {
            sb.append("originUrl=").append(this.f13267a.g());
            sb.append(", redirectURL=").append(this.f);
            sb.append(", redirectCount=").append(this.g);
        } else {
            sb.append("requestUrl=").append(this.f13267a.g());
        }
        return sb.toString();
    }
}
