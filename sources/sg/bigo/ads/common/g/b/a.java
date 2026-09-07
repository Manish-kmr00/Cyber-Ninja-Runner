package sg.bigo.ads.common.g.b;

import android.database.Cursor;
import net.pubnative.lite.sdk.db.DatabaseHelper;

/* JADX INFO: loaded from: classes10.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f13186a;
    public String b;
    public String c;
    public int d;
    public String e;
    public long f;
    public long g;

    public a(Cursor cursor) {
        this.f13186a = -1L;
        this.f13186a = cursor.getLong(cursor.getColumnIndex(DatabaseHelper._ID));
        this.b = cursor.getString(cursor.getColumnIndex("event_action"));
        this.c = cursor.getString(cursor.getColumnIndex("event_info"));
        this.d = cursor.getInt(cursor.getColumnIndex("states"));
        this.e = cursor.getString(cursor.getColumnIndex("ext"));
        this.f = cursor.getLong(cursor.getColumnIndex("ctime"));
        this.g = cursor.getLong(cursor.getColumnIndex("mtime"));
    }

    public a(String str, String str2) {
        this.f13186a = -1L;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.b = str;
        this.c = str2;
        this.d = 0;
        this.e = "";
        this.f = jCurrentTimeMillis;
        this.g = jCurrentTimeMillis;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != a.class) {
            return false;
        }
        long j = this.f13186a;
        return j >= 0 && j == ((a) obj).f13186a;
    }

    public String toString() {
        return "mId = " + this.f13186a + ",eventInfo=" + this.c;
    }
}
