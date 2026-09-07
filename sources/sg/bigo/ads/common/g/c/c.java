package sg.bigo.ads.common.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import net.pubnative.lite.sdk.db.DatabaseHelper;

/* JADX INFO: loaded from: classes6.dex */
public final class c {
    public static long a(String str) {
        sg.bigo.ads.common.t.a.a(0, 3, "TrackerDbHelper", "delete:".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return a(arrayList);
    }

    private static long a(List<String> list) {
        sg.bigo.ads.common.t.a.a(0, 3, "TrackerDbHelper", "delete:" + list.size());
        StringBuilder sb = new StringBuilder("_id in (");
        int i = 0;
        while (i < list.size()) {
            sb.append(i == 0 ? "?" : ",?");
            i++;
        }
        sb.append(")");
        long jB = sg.bigo.ads.common.g.a.a.b("tb_tracker", sb.toString(), (String[]) list.toArray(new String[0]));
        sg.bigo.ads.common.t.a.a(0, 3, "TrackerDbHelper", "delTrackerInfo count = ".concat(String.valueOf(jB)));
        return jB;
    }

    public static long a(sg.bigo.ads.common.g.b.c cVar) {
        sg.bigo.ads.common.t.a.a(0, 3, "TrackerDbHelper", "insert:" + cVar.toString());
        return sg.bigo.ads.common.g.a.a.a("tb_tracker", d(cVar));
    }

    public static Cursor a(long j) {
        return sg.bigo.ads.common.g.a.a.a("tb_tracker", "last_retry_ts < " + (System.currentTimeMillis() - j), null, "last_retry_ts", 10);
    }

    private static String a(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 0; i++) {
            sb.append(strArr[0]);
            sb.append("=? ");
        }
        return sb.toString();
    }

    public static long b(long j) {
        sg.bigo.ads.common.t.a.a(0, 3, "TrackerDbHelper", "clearTrackerInfo");
        long jB = sg.bigo.ads.common.g.a.a.b("tb_tracker", "ctime < ".concat(String.valueOf(j)), null);
        sg.bigo.ads.common.t.a.a(0, 3, "TrackerDbHelper", "clearTrackerInfo count = ".concat(String.valueOf(jB)));
        return jB;
    }

    public static long b(sg.bigo.ads.common.g.b.c cVar) {
        sg.bigo.ads.common.t.a.a(0, 3, "TrackerDbHelper", "update: " + cVar.toString());
        cVar.g = System.currentTimeMillis();
        return sg.bigo.ads.common.g.a.a.a("tb_tracker", d(cVar), a(new String[]{DatabaseHelper._ID}), new String[]{String.valueOf(cVar.f13188a)});
    }

    public static boolean c(sg.bigo.ads.common.g.b.c cVar) {
        sg.bigo.ads.common.t.a.a(0, 3, "TrackerDbHelper", "exist:" + cVar.toString());
        Cursor cursorA = sg.bigo.ads.common.g.a.a.a("tb_tracker", a(new String[]{DatabaseHelper._ID}), new String[]{String.valueOf(cVar.f13188a)});
        if (cursorA == null) {
            return false;
        }
        boolean zMoveToNext = cursorA.moveToNext();
        cursorA.close();
        return zMoveToNext;
    }

    private static ContentValues d(sg.bigo.ads.common.g.b.c cVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("ad_data", cVar.a());
        contentValues.put("tracker_imp", cVar.b());
        contentValues.put("tracker_cli", cVar.c());
        contentValues.put("tracker_nurl", cVar.d());
        contentValues.put("tracker_lurl", cVar.e());
        contentValues.put("last_retry_ts", Long.valueOf(cVar.f()));
        contentValues.put("ext", cVar.e);
        contentValues.put("ctime", Long.valueOf(cVar.f == 0 ? System.currentTimeMillis() : cVar.f));
        contentValues.put("mtime", Long.valueOf(cVar.g == 0 ? System.currentTimeMillis() : cVar.g));
        return contentValues;
    }
}
