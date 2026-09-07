package sg.bigo.ads.common.g.b;

import android.database.Cursor;
import net.pubnative.lite.sdk.db.DatabaseHelper;

/* JADX INFO: loaded from: classes10.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f13187a;
    public String b;
    public String c;
    public long d;
    public String e;
    public long f;
    public long g;

    public b(Cursor cursor) {
        this.f13187a = -1L;
        this.f13187a = cursor.getLong(cursor.getColumnIndex(DatabaseHelper._ID));
        this.b = cursor.getString(cursor.getColumnIndex("event_id"));
        this.c = cursor.getString(cursor.getColumnIndex("event_info"));
        this.d = cursor.getLong(cursor.getColumnIndex("expired_ts"));
        this.e = cursor.getString(cursor.getColumnIndex("ext"));
        this.f = cursor.getLong(cursor.getColumnIndex("ctime"));
        this.g = cursor.getLong(cursor.getColumnIndex("mtime"));
    }

    public b(String str, String str2, long j) {
        this.f13187a = -1L;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.b = str;
        this.c = str2;
        this.d = j;
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
        if (obj.getClass() != b.class) {
            return false;
        }
        long j = this.f13187a;
        return j >= 0 && j == ((b) obj).f13187a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("mId = ");
        sb.append(this.f13187a).append(",mEventId = ");
        sb.append(this.b).append(",mExpiredTs = ");
        sb.append(this.d).append(",eventInfo = ");
        sb.append(this.c);
        return sb.toString();
    }
}
