package net.pubnative.lite.sdk.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.pubnative.lite.sdk.db.OnDatabaseResetListener;
import net.pubnative.lite.sdk.db.SessionImpression;
import net.pubnative.lite.sdk.utils.HyBidTimeUtils;
import net.pubnative.lite.sdk.utils.Logger;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes8.dex */
public class SessionImpressionPrefs {
    private static final String JSON_EXCEPTION = "JSONException";
    private static final String SESSION_IMPRESSION_LIST_KEY = "session_impression_key";
    private SharedPreferences.Editor editor;
    private Context mContext;
    private SharedPreferences sharedPreferences;

    public SessionImpressionPrefs(Context context) {
        if (context != null) {
            this.mContext = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences("session_prefs_reporting", 0);
            this.sharedPreferences = sharedPreferences;
            if (sharedPreferences != null) {
                this.editor = sharedPreferences.edit();
            }
        }
    }

    public synchronized void insert(String str) {
        SessionImpression sessionImpression = new SessionImpression();
        sessionImpression.setTimestamp(Long.valueOf(System.currentTimeMillis()));
        sessionImpression.setZoneId(str);
        Long ageOfApp = getAgeOfApp();
        sessionImpression.setSessionDuration(new HyBidTimeUtils().calculateSessionDuration(sessionImpression.getTimestamp(), ageOfApp));
        sessionImpression.setAgeOfApp(ageOfApp);
        manageImpressionSession(sessionImpression.getTimestamp());
        increment(sessionImpression);
    }

    private synchronized void increment(SessionImpression sessionImpression) {
        if (this.editor != null) {
            String string = this.sharedPreferences.getString(SESSION_IMPRESSION_LIST_KEY, "");
            ArrayList arrayList = new ArrayList();
            if (!string.isEmpty()) {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(new SessionImpression(jSONArray.getJSONObject(i)));
                    }
                    incrementZoneId(arrayList, sessionImpression);
                } catch (JSONException e) {
                    Logger.e(JSON_EXCEPTION, e.toString());
                }
            } else {
                sessionImpression.setCount(1);
                arrayList.add(sessionImpression);
            }
            this.editor.putString(SESSION_IMPRESSION_LIST_KEY, convertListToJson(arrayList).toString());
            this.editor.apply();
        }
    }

    private JSONArray convertListToJson(List<SessionImpression> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<SessionImpression> it = list.iterator();
        while (it.hasNext()) {
            try {
                jSONArray.put(it.next().toJson());
            } catch (Exception e) {
                Logger.e(JSON_EXCEPTION, e.toString());
            }
        }
        return jSONArray;
    }

    private synchronized void incrementZoneId(List<SessionImpression> list, SessionImpression sessionImpression) {
        if (list != null && sessionImpression != null) {
            for (int i = 0; i < list.size(); i++) {
                SessionImpression sessionImpression2 = list.get(i);
                if (sessionImpression2 != null && !TextUtils.isEmpty(sessionImpression.getZoneId()) && !TextUtils.isEmpty(sessionImpression2.getZoneId()) && sessionImpression.getZoneId().equals(sessionImpression2.getZoneId())) {
                    sessionImpression2.setCount(Integer.valueOf(sessionImpression2.getCount().intValue() + 1));
                }
            }
            sessionImpression.setCount(1);
            list.add(sessionImpression);
        }
    }

    private synchronized Long getAgeOfApp() {
        if (this.mContext == null) {
            return 0L;
        }
        return Long.valueOf(new HyBidPreferences(this.mContext).getSessionTimeStamp());
    }

    private synchronized void manageImpressionSession(Long l) {
        if (this.mContext == null) {
            return;
        }
        new HyBidPreferences(this.mContext).setSessionTimeStamp(l.longValue(), new OnDatabaseResetListener() { // from class: net.pubnative.lite.sdk.prefs.SessionImpressionPrefs$$ExternalSyntheticLambda0
            @Override // net.pubnative.lite.sdk.db.OnDatabaseResetListener
            public final void onDatabaseReset() {
                this.f$0.nukePrefs();
            }
        }, HyBidPreferences.TIMESTAMP.AD_REQUEST);
    }

    public synchronized void nukePrefs() {
        SharedPreferences.Editor editor = this.editor;
        if (editor != null) {
            editor.putString(SESSION_IMPRESSION_LIST_KEY, "");
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x006c  */
    public Integer getImpressionDepth(String str) {
        String string = this.sharedPreferences.getString(SESSION_IMPRESSION_LIST_KEY, "");
        ArrayList<SessionImpression> arrayList = new ArrayList();
        if (!string.isEmpty()) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(new SessionImpression(jSONArray.getJSONObject(i)));
                }
            } catch (JSONException e) {
                Logger.e(JSON_EXCEPTION, e.toString());
            }
            for (SessionImpression sessionImpression : arrayList) {
                if (!TextUtils.isEmpty(sessionImpression.getZoneId()) && !TextUtils.isEmpty(str) && sessionImpression.getZoneId().equals(str)) {
                    if (sessionImpression != null) {
                        return sessionImpression.getCount();
                    }
                }
            }
            sessionImpression = null;
            if (sessionImpression != null) {
                return sessionImpression.getCount();
            }
        }
        return 0;
    }
}
