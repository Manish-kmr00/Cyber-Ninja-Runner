package sg.bigo.ads.core.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import com.json.b9;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONArray;
import org.json.JSONObject;
import sg.bigo.ads.api.a.i;

/* JADX INFO: loaded from: classes5.dex */
public class b extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f13614a;
    private sg.bigo.ads.core.h.c b;
    boolean g;
    public final C0896b h;
    public c i;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f13615a;
        private final C0896b b;

        public a(b bVar, C0896b c0896b) {
            this.f13615a = bVar;
            this.b = c0896b;
        }

        @JavascriptInterface
        public final void onCustomJSEventCallback(String str, String str2) {
            sg.bigo.ads.common.t.a.a(0, 3, "UniversalWebView", "onCustomJSEventCallback, eventType: " + str + ", eventJson: " + str2);
            sg.bigo.ads.core.h.c customWebChromeClient = this.f13615a.getCustomWebChromeClient();
            if (customWebChromeClient != null) {
                customWebChromeClient.a(this.f13615a, str, str2);
            }
        }

        @JavascriptInterface
        public final void webCollect(String str) {
            String string;
            C0896b c0896b = this.b;
            if (c0896b.f13616a == null) {
                c0896b.f13616a = new ArrayList();
            }
            if (!str.contains("notify") || str.startsWith(b9.i.d)) {
                string = str;
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    jSONObject.put("cur", SystemClock.elapsedRealtime());
                    string = jSONObject.toString();
                } catch (Exception unused) {
                    string = str;
                }
            }
            c0896b.f13616a.add(string);
            sg.bigo.ads.common.t.a.a(0, 3, "UniversalWebView", "webCollect: ".concat(String.valueOf(str)));
        }

        @JavascriptInterface
        public final void webStat(String str, String str2) {
            sg.bigo.ads.common.t.a.a(0, 3, "UniversalWebView", "statUniversalInfo, eventId: " + str + ", msgJson: " + str2);
        }
    }

    /* JADX INFO: renamed from: sg.bigo.ads.core.h.b$b, reason: collision with other inner class name */
    public static class C0896b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        List<String> f13616a;
        List<String> b;
        public Boolean c;
        public Boolean d;
        public long e = -1;
        public long f = -1;
        public long g = -1;

        final boolean a(String str) {
            List<String> list = this.b;
            if (str != null && list != null) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next())) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public final class c {
        private Boolean b;

        private c() {
        }

        public /* synthetic */ c(b bVar, byte b) {
            this();
        }

        private static boolean a(int[] iArr) {
            if (iArr.length <= 0) {
                return false;
            }
            int length = iArr.length;
            int i = length - 1;
            int i2 = 0;
            while (true) {
                int i3 = length / 2;
                if (i2 >= i3 || i < i3) {
                    return true;
                }
                if (iArr[i2] != iArr[i]) {
                    return false;
                }
                i2++;
                i--;
            }
        }

        public final Boolean a() {
            sg.bigo.ads.common.t.a.a(0, 3, "UniversalWebView", "Try to check not blank by bit");
            if (this.b != null) {
                sg.bigo.ads.common.t.a.a(0, 3, "UniversalWebView", "Has result for checking not blank by bit");
                return this.b;
            }
            if (b.this.j) {
                sg.bigo.ads.common.t.a.a(0, 3, "UniversalWebView", "WebView is destroyed stop checking not blank by bit");
                return null;
            }
            int width = b.this.getWidth();
            int height = b.this.getHeight();
            if (width > 0 && height > 0) {
                try {
                    int[] iArr = new int[width * height];
                    Bitmap bitmapA = sg.bigo.ads.common.utils.d.a(width, height, Bitmap.Config.RGB_565);
                    if (bitmapA == null) {
                        return null;
                    }
                    b.this.draw(new Canvas(bitmapA));
                    bitmapA.getPixels(iArr, 0, width, 0, 0, width, height);
                    bitmapA.recycle();
                    this.b = Boolean.valueOf(!a(iArr));
                    sg.bigo.ads.common.t.a.a(0, 3, "UniversalWebView", "The result of current banner checking not blank by bit: " + this.b);
                    return this.b;
                } catch (Exception unused) {
                }
            }
            return null;
        }
    }

    public b(Context context) {
        super(context);
        this.g = false;
        C0896b c0896b = new C0896b();
        this.h = c0896b;
        a aVar = new a(this, c0896b);
        this.f13614a = aVar;
        addJavascriptInterface(aVar, "bigossp");
    }

    public static void a(C0896b c0896b) {
        List<String> list;
        JSONObject jSONObjectOptJSONObject;
        if (!i.f13093a.n().a(0) || (list = c0896b.f13616a) == null || list.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            if (str.startsWith(b9.i.d)) {
                sb.append(str.substring(1, str.length() - 1)).append(StringUtils.COMMA);
            }
            sb.append(str).append(StringUtils.COMMA);
        }
        try {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray(b9.i.d + sb.substring(0, sb.length() - 1) + b9.i.e);
            int length = jSONArray2.length();
            JSONObject jSONObject = null;
            JSONObject jSONObject2 = null;
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArray2.optJSONObject(i);
                if (jSONObjectOptJSONObject2 != null) {
                    String strOptString = jSONObjectOptJSONObject2.optString("type");
                    if ("render_start".equals(strOptString)) {
                        jSONObject = jSONObjectOptJSONObject2;
                    }
                    if (Reporting.EventType.RENDER.equals(strOptString) && jSONObject2 == null) {
                        jSONObject2 = jSONObjectOptJSONObject2;
                    }
                    if (!"mayError".equals(strOptString) || ((jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("params")) != null && c0896b.a(jSONObjectOptJSONObject.optString("url")))) {
                        jSONArray.put(jSONObjectOptJSONObject2);
                    }
                }
            }
            if (jSONArray.length() > 0) {
                sg.bigo.ads.core.d.b.a(3002, 10113, jSONArray.toString());
            }
            if (jSONObject != null) {
                if (jSONObject2 != null) {
                    c0896b.c = Boolean.TRUE;
                    c0896b.e = jSONObject2.optLong("cur");
                } else {
                    c0896b.c = Boolean.FALSE;
                    c0896b.e = SystemClock.elapsedRealtime();
                }
            }
        } catch (Exception unused) {
        }
    }

    final void a(int i, WebResourceRequest webResourceRequest, int i2, CharSequence charSequence) {
        if (webResourceRequest != null) {
            sg.bigo.ads.common.t.a.a(0, 3, "UniversalWebView", "dispatchResourceError, type: " + i + ", url: " + webResourceRequest.getUrl() + ", errorCode: " + i2 + ", desc: " + ((Object) charSequence));
            C0896b c0896b = this.h;
            String strValueOf = String.valueOf(webResourceRequest.getUrl());
            if (c0896b.b == null) {
                c0896b.b = new ArrayList();
            }
            c0896b.b.add(strValueOf);
        }
    }

    public sg.bigo.ads.core.h.c getCustomWebChromeClient() {
        return this.b;
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.b = webChromeClient instanceof sg.bigo.ads.core.h.c ? (sg.bigo.ads.core.h.c) webChromeClient : null;
        super.setWebChromeClient(webChromeClient);
    }
}
