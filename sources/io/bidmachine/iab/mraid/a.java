package io.bidmachine.iab.mraid;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final DateFormat f12228a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ", Locale.US);
    static final String[] b = {"SU", "MO", "TU", "WE", "TH", "FR", "SA"};

    a() {
    }

    void a(JSONObject jSONObject, StringBuilder sb) {
        if (jSONObject.isNull("expires")) {
            return;
        }
        try {
            sb.append("UNTIL=").append(f12228a.parse(jSONObject.getString("expires"))).append(";");
        } catch (Exception unused) {
        }
    }

    void b(JSONObject jSONObject, StringBuilder sb) {
        if (jSONObject.isNull("frequency")) {
            return;
        }
        try {
            sb.append("FREQ=").append(jSONObject.getString("frequency")).append(";");
        } catch (Exception unused) {
        }
    }

    void c(JSONObject jSONObject, StringBuilder sb) {
        if (jSONObject.isNull("interval")) {
            return;
        }
        try {
            sb.append("INTERVAL=").append(jSONObject.getInt("interval")).append(";");
        } catch (Exception unused) {
        }
    }

    void d(JSONObject jSONObject, StringBuilder sb) {
        try {
            if (jSONObject.isNull("frequency") || !"monthly".equalsIgnoreCase(jSONObject.getString("frequency"))) {
                return;
            }
            if (!jSONObject.isNull("daysInMonth")) {
                JSONArray jSONArray = jSONObject.getJSONArray("daysInMonth");
                if (jSONArray.length() > 0) {
                    sb.append("BYMONTHDAY=").append(b(jSONArray)).append(";");
                }
            }
            if (jSONObject.isNull("weeksInMonth")) {
                return;
            }
            JSONArray jSONArray2 = jSONObject.getJSONArray("weeksInMonth");
            if (jSONArray2.length() > 0) {
                sb.append("BYWEEKNO=").append(b(jSONArray2)).append(";");
            }
        } catch (Exception unused) {
        }
    }

    void e(JSONObject jSONObject, StringBuilder sb) {
        try {
            if (jSONObject.isNull("frequency") || !"weekly".equalsIgnoreCase(jSONObject.getString("frequency")) || jSONObject.isNull("daysInWeek")) {
                return;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("daysInWeek");
            if (jSONArray.length() > 0) {
                sb.append("BYDAY=").append(a(jSONArray)).append(";");
            }
        } catch (Exception unused) {
        }
    }

    void f(JSONObject jSONObject, StringBuilder sb) {
        try {
            if (jSONObject.isNull("frequency") || !"yearly".equalsIgnoreCase(jSONObject.getString("frequency"))) {
                return;
            }
            if (!jSONObject.isNull("monthsInYear")) {
                JSONArray jSONArray = jSONObject.getJSONArray("monthsInYear");
                if (jSONArray.length() > 0) {
                    sb.append("BYMONTH=").append(b(jSONArray)).append(";");
                }
            }
            if (jSONObject.isNull("daysInYear")) {
                return;
            }
            JSONArray jSONArray2 = jSONObject.getJSONArray("daysInYear");
            if (jSONArray2.length() > 0) {
                sb.append("BYYEARDAY=").append(b(jSONArray2)).append(";");
            }
        } catch (Exception unused) {
        }
    }

    String a(JSONArray jSONArray) throws JSONException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jSONArray.length(); i++) {
            if (i > 0) {
                sb.append(StringUtils.COMMA);
            }
            int i2 = jSONArray.getInt(i);
            if (i2 >= 0 && i2 <= 6) {
                sb.append(b[i2]);
            }
        }
        return sb.toString();
    }

    String b(JSONArray jSONArray) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jSONArray.length(); i++) {
            if (i > 0) {
                sb.append(StringUtils.COMMA);
            }
            sb.append(jSONArray.get(i).toString());
        }
        return sb.toString();
    }

    String a(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        b(jSONObject, sb);
        c(jSONObject, sb);
        a(jSONObject, sb);
        e(jSONObject, sb);
        d(jSONObject, sb);
        f(jSONObject, sb);
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    MraidCalendarEvent b(JSONObject jSONObject) {
        String str = (String) Objects.requireNonNull(jSONObject.getString("description"));
        DateFormat dateFormat = f12228a;
        MraidCalendarEvent mraidCalendarEvent = new MraidCalendarEvent(str, (Date) Objects.requireNonNull(dateFormat.parse(jSONObject.getString("start"))));
        if (jSONObject.has("location")) {
            mraidCalendarEvent.a(jSONObject.getString("location"));
        }
        if (jSONObject.has("summary")) {
            mraidCalendarEvent.d(jSONObject.getString("summary"));
        }
        if (jSONObject.has("end")) {
            mraidCalendarEvent.a(dateFormat.parse(jSONObject.getString("end")));
        }
        if (jSONObject.has("status")) {
            mraidCalendarEvent.c(jSONObject.getString("status"));
        }
        if (jSONObject.has("transparency")) {
            mraidCalendarEvent.e(jSONObject.getString("transparency"));
        }
        if (jSONObject.has("recurrence")) {
            mraidCalendarEvent.b(a(jSONObject.getJSONObject("recurrence")));
        }
        return mraidCalendarEvent;
    }

    MraidCalendarEvent a(String str) {
        return b(new JSONObject(str));
    }
}
