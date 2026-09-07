package sg.bigo.ads.core.player.a;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes12.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    HttpURLConnection f13688a;
    InputStream b;
    String c;

    public g(String str) {
        this.c = str;
    }

    public final int a(byte[] bArr) {
        StringBuilder sbAppend;
        String string;
        InputStream inputStream = this.b;
        if (inputStream == null) {
            sg.bigo.ads.common.t.a.a(0, "ProxyCache", "Error reading data from " + this.c + ": connection is absent!");
            return 0;
        }
        try {
            return inputStream.read(bArr, 0, bArr.length);
        } catch (InterruptedIOException e) {
            sbAppend = new StringBuilder("Reading source ").append(this.c).append(" is interrupted, error message is : ");
            string = e.toString();
            sg.bigo.ads.common.t.a.a(0, "ProxyCache", sbAppend.append(string).toString());
            return 0;
        } catch (IOException e2) {
            sbAppend = new StringBuilder("Error reading data from ").append(this.c).append(", error message is : ");
            string = e2.toString();
            sg.bigo.ads.common.t.a.a(0, "ProxyCache", sbAppend.append(string).toString());
            return 0;
        }
    }

    public final void a() {
        HttpURLConnection httpURLConnection = this.f13688a;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException e) {
                sg.bigo.ads.common.t.a.a(0, "ProxyCache", "Error closing connection correctly, the error message is : " + e.toString());
            } catch (IllegalArgumentException e2) {
                e = e2;
                sg.bigo.ads.common.t.a.a(0, "ProxyCache", "connection disconnect error..., the error message is : " + e.toString());
            } catch (NullPointerException e3) {
                e = e3;
                sg.bigo.ads.common.t.a.a(0, "ProxyCache", "connection disconnect error..., the error message is : " + e.toString());
            }
        }
    }

    final HttpURLConnection b() {
        String headerField = this.c;
        HttpURLConnection httpURLConnection = null;
        int i = 0;
        while (true) {
            try {
                sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "Open connection  to " + headerField);
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(headerField).openConnection();
                if (httpURLConnection2 == null) {
                    return httpURLConnection2;
                }
                try {
                    int responseCode = httpURLConnection2.getResponseCode();
                    boolean z = responseCode == 301 || responseCode == 302 || responseCode == 303;
                    if (z) {
                        headerField = httpURLConnection2.getHeaderField("Location");
                        i++;
                        httpURLConnection2.disconnect();
                    }
                    if (i > 5) {
                        sg.bigo.ads.common.t.a.a(0, "ProxyCache", "Too many redirects: ".concat(String.valueOf(i)));
                    }
                    if (!z) {
                        return httpURLConnection2;
                    }
                    httpURLConnection = httpURLConnection2;
                } catch (IOException e) {
                    e = e;
                    httpURLConnection = httpURLConnection2;
                    sg.bigo.ads.common.t.a.a(0, "ProxyCache", "PingHttpUrlSource#openConnection, error message is : " + e.toString());
                    return httpURLConnection;
                }
            } catch (IOException e2) {
                e = e2;
            }
        }
    }
}
