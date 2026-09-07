package sg.bigo.ads.api.a;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public interface e {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13090a = "";
        public String b = "";
        public String c = "";
        public String d = "";
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13091a = "";
        public String b = "";
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13092a;
        public int b;
        public String[] c;
        public String d;

        public c(JSONObject jSONObject) {
            this.f13092a = "";
            this.b = 0;
            this.c = null;
            this.d = "";
            this.f13092a = jSONObject.optString("title", "");
            this.b = jSONObject.optInt("type", 0);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                this.c = new String[jSONArrayOptJSONArray.length()];
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    this.c[i] = jSONArrayOptJSONArray.optString(i);
                }
            }
            this.d = jSONObject.optString("id", "");
        }
    }

    String a();

    String b();

    long c();

    int d();

    String e();

    int f();

    String g();

    String h();

    f[] i();

    f j();

    f k();

    b l();

    c[] m();

    a n();
}
