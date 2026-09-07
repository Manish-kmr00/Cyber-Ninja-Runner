package sg.bigo.ads.common.g.b;

import android.database.Cursor;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import net.pubnative.lite.sdk.db.DatabaseHelper;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.common.utils.j;

/* JADX INFO: loaded from: classes10.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f13188a;
    public boolean b;
    public int c;
    public long d;
    public String e;
    public long f;
    public long g;
    public Map<String, String> h;

    public c(Cursor cursor) {
        this.f13188a = -1L;
        this.b = false;
        this.c = 0;
        this.d = 0L;
        this.e = "";
        this.f13188a = cursor.getLong(cursor.getColumnIndex(DatabaseHelper._ID));
        try {
            this.h = j.a(new JSONObject(cursor.getString(cursor.getColumnIndex("ad_data"))));
        } catch (JSONException unused) {
        }
        a(cursor.getString(cursor.getColumnIndex("tracker_imp")));
        b(cursor.getString(cursor.getColumnIndex("tracker_cli")));
        c(cursor.getString(cursor.getColumnIndex("tracker_nurl")));
        d(cursor.getString(cursor.getColumnIndex("tracker_lurl")));
        this.c = cursor.getInt(cursor.getColumnIndex("tracker_type"));
        this.d = cursor.getLong(cursor.getColumnIndex("last_retry_ts"));
        this.e = cursor.getString(cursor.getColumnIndex("ext"));
        this.f = cursor.getLong(cursor.getColumnIndex("ctime"));
        this.g = cursor.getLong(cursor.getColumnIndex("mtime"));
        this.b = true;
    }

    public c(Map<String, String> map) {
        this.f13188a = -1L;
        this.b = false;
        this.c = 0;
        this.d = 0L;
        this.e = "";
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.h = map;
        this.f = jCurrentTimeMillis;
        this.g = jCurrentTimeMillis;
    }

    public final String a() {
        Map<String, String> map = this.h;
        if (map == null) {
            return "";
        }
        if ((map instanceof HashMap) && map != null) {
            map.remove(null);
            map.values().removeAll(Collections.singleton(null));
        }
        return new JSONObject(this.h).toString();
    }

    protected abstract void a(String str);

    public abstract String b();

    protected abstract void b(String str);

    public abstract String c();

    protected abstract void c(String str);

    public abstract String d();

    protected abstract void d(String str);

    public abstract String e();

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != c.class) {
            return false;
        }
        long j = this.f13188a;
        return j >= 0 && j == ((c) obj).f13188a;
    }

    public long f() {
        return 0L;
    }

    public String toString() {
        return "mId = " + this.f13188a;
    }
}
