package sg.bigo.ads.common.u.a;

import android.text.TextUtils;
import com.json.mediationsdk.logger.IronSourceError;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import sg.bigo.ads.common.utils.h;

/* JADX INFO: loaded from: classes11.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final HttpURLConnection f13268a;
    final int b;
    final h<List<String>> c;
    private final c d;
    private final String e;
    private final boolean f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final URL f13269a;
        public final String b;
        public final int c;
        public final String d;
        public final int e;

        private a(URL url, String str, int i, String str2, int i2) {
            this.f13269a = url;
            this.b = str;
            this.c = i;
            this.d = str2;
            this.e = i2;
        }

        /* synthetic */ a(URL url, String str, int i, String str2, int i2, byte b) {
            this(url, str, i, str2, i2);
        }
    }

    public d(c cVar) throws IOException {
        this.d = cVar;
        HttpURLConnection httpURLConnectionA = cVar.a();
        this.f13268a = httpURLConnectionA;
        this.b = httpURLConnectionA.getResponseCode();
        this.e = httpURLConnectionA.getRequestMethod();
        h<List<String>> hVar = new h<>();
        this.c = hVar;
        Map<String, List<String>> headerFields = httpURLConnectionA.getHeaderFields();
        if (headerFields != null) {
            hVar.a(headerFields);
        }
        boolean zEqualsIgnoreCase = "gzip".equalsIgnoreCase(httpURLConnectionA.getContentEncoding());
        this.f = zEqualsIgnoreCase;
        if (zEqualsIgnoreCase && cVar.c) {
            hVar.b("Content-Encoding");
            hVar.b("Content-Length");
        }
    }

    private String a(String str) {
        List<String> listA = this.c.a(str);
        int size = listA != null ? listA.size() : 0;
        String str2 = "";
        while (TextUtils.isEmpty(str2) && size > 0) {
            str2 = listA.get(0);
        }
        return str2;
    }

    public final InputStream a() {
        InputStream inputStream = this.f13268a.getInputStream();
        return (this.f && this.d.c) ? new GZIPInputStream(inputStream) : inputStream;
    }

    public final a b() {
        int i = this.b;
        if (i == 307 || i == 308) {
            String strA = a("Location");
            if (!this.e.equalsIgnoreCase("GET") && !this.e.equalsIgnoreCase("HEAD")) {
                return new a(null, strA, 706, "redirect code(" + this.b + ") is only available for GET or HEAD method, current request method is " + this.e, this.b, (byte) 0);
            }
            return new a(null, strA, 0, "", this.b, (byte) 0);
        }
        switch (i) {
            case 300:
            case 301:
            case 302:
            case 303:
                String strA2 = a("Location");
                if (TextUtils.isEmpty(strA2)) {
                    return new a(null, strA2, 707, "empty location.", this.b, (byte) 0);
                }
                try {
                    URL url = new URL(this.f13268a.getURL(), strA2);
                    String string = url.toString();
                    if (TextUtils.equals(string, this.f13268a.getURL().toString())) {
                        return new a(url, strA2, 705, "redirect to the same url, location is " + strA2 + ", redirectURL is " + string, this.b, (byte) 0);
                    }
                    URL url2 = this.d.b;
                    if (url2 != null && TextUtils.equals(string, url2.toString())) {
                        return new a(url, strA2, 704, "redirect to origin url, location is " + strA2 + ", redirectURL is " + string, this.b, (byte) 0);
                    }
                    return new a(url, strA2, 0, "", this.b, (byte) 0);
                } catch (Exception unused) {
                    return new a(null, strA2, IronSourceError.ERROR_NT_INSTANCE_LOAD_TIMEOUT, "location->\"" + strA2 + "\" is not a network url.", this.b, (byte) 0);
                }
            default:
                return null;
        }
    }
}
