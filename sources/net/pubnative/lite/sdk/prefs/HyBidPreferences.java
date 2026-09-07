package net.pubnative.lite.sdk.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import net.pubnative.lite.sdk.db.OnDatabaseResetListener;
import net.pubnative.lite.sdk.utils.HyBidTimeUtils;

/* JADX INFO: loaded from: classes5.dex */
public class HyBidPreferences {
    private SharedPreferences.Editor editor;
    private final SharedPreferences sharedPreferences;

    public static class Key {
        public static final String ATOM_ENABLED = "atom_enabled";
        public static final String App_FIRST_INSTALLED = "app_first_installed";
        public static final String IS_App_FIRST_INSTALLED_TRACKED = "is_app_first_installed_tracked";
        public static final String SESSION_TIMESTAMP = "session_timestamp";
        public static final String TOPICS_API_ENABLED = "topics_api_enabled";
    }

    public enum TIMESTAMP {
        NORMAL,
        AD_REQUEST
    }

    public HyBidPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("hybid_prefs_reporting", 0);
        this.sharedPreferences = sharedPreferences;
        if (sharedPreferences != null) {
            this.editor = sharedPreferences.edit();
        }
    }

    public void setAppFirstInstalledTime(String str) {
        if (isAppFirstInstalledTracked().booleanValue()) {
            return;
        }
        SharedPreferences sharedPreferences = this.sharedPreferences;
        if (sharedPreferences != null) {
            this.editor = sharedPreferences.edit();
        }
        this.editor.putString(Key.App_FIRST_INSTALLED, str);
        this.editor.putBoolean(Key.IS_App_FIRST_INSTALLED_TRACKED, true);
        this.editor.commit();
    }

    public void setTopicsAPIEnabled(Boolean bool) {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        if (sharedPreferences == null || bool == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        this.editor = editorEdit;
        editorEdit.putBoolean(Key.TOPICS_API_ENABLED, bool.booleanValue());
        this.editor.commit();
    }

    public Boolean isTopicsAPIEnabled() {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        if (sharedPreferences != null && sharedPreferences.contains(Key.TOPICS_API_ENABLED)) {
            return Boolean.valueOf(this.sharedPreferences.getBoolean(Key.TOPICS_API_ENABLED, false));
        }
        return null;
    }

    public void setAtomEnabled(Boolean bool) {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        if (sharedPreferences == null || bool == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        this.editor = editorEdit;
        editorEdit.putBoolean(Key.ATOM_ENABLED, bool.booleanValue());
        this.editor.commit();
    }

    public Boolean isAtomEnabled() {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        if (sharedPreferences != null && sharedPreferences.contains(Key.ATOM_ENABLED)) {
            return Boolean.valueOf(this.sharedPreferences.getBoolean(Key.ATOM_ENABLED, false));
        }
        return null;
    }

    public void setSessionTimeStamp(long j, OnDatabaseResetListener onDatabaseResetListener, TIMESTAMP timestamp) {
        long sessionTimeStamp = getSessionTimeStamp();
        if (sessionTimeStamp != 0) {
            if (new HyBidTimeUtils().IsStartingNewSession(j - sessionTimeStamp).booleanValue()) {
                if (onDatabaseResetListener != null) {
                    onDatabaseResetListener.onDatabaseReset();
                }
                SharedPreferences sharedPreferences = this.sharedPreferences;
                if (sharedPreferences != null) {
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    this.editor = editorEdit;
                    editorEdit.putLong(Key.SESSION_TIMESTAMP, sessionTimeStamp);
                    this.editor.commit();
                    return;
                }
                return;
            }
            return;
        }
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        if (sharedPreferences2 != null) {
            SharedPreferences.Editor editorEdit2 = sharedPreferences2.edit();
            this.editor = editorEdit2;
            editorEdit2.putLong(Key.SESSION_TIMESTAMP, j);
            this.editor.commit();
        }
    }

    public String getAppFirstInstalledTime() {
        return this.sharedPreferences.getString(Key.App_FIRST_INSTALLED, "");
    }

    private Boolean isAppFirstInstalledTracked() {
        return Boolean.valueOf(this.sharedPreferences.getBoolean(Key.IS_App_FIRST_INSTALLED_TRACKED, false));
    }

    public long getSessionTimeStamp() {
        return this.sharedPreferences.getLong(Key.SESSION_TIMESTAMP, 0L);
    }
}
