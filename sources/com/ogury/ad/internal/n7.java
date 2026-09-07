package com.ogury.ad.internal;

import com.unity3d.ads.core.domain.AndroidInitializeBoldSDK;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v31 com.ogury.ad.internal.n7[], still in use, count: 1, list:
  (r0v31 com.ogury.ad.internal.n7[]) from 0x02d2: INVOKE (r0v31 com.ogury.ad.internal.n7[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
	at java.base/java.util.ArrayList.forEach(Unknown Source)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes.dex */
public final class n7 {
    LE_001_CONDITIONS_NOT_MET_NO_INTERNET_CONNECTION("LE-001", "SDK_EVENT_LOAD_ERROR", "CONDITIONS_NOT_MET", "No Internet connection"),
    LE_008_CONFIG_RESTRICTIONS_AD_DISABLED("LE-008", "SDK_EVENT_LOAD_ERROR", "CONFIG_RESTRICTIONS", "Ad disabled"),
    LE_009_ADSYNC_ERROR_REQUEST_FAILED("LE-009", "SDK_EVENT_LOAD_ERROR", "ADSYNC_ERROR", "Request failed"),
    LE_011_ADSYNC_ERROR_NO_AD_RECEIVED("LE-011", "SDK_EVENT_LOAD_ERROR", "ADSYNC_ERROR", "No ad received"),
    LE_015_SDK_NEVER_INITIALIZED("LE-015", "SDK_EVENT_LOAD_ERROR", "INIT_ERROR", "SDK never initialized (asset key not found)"),
    LE_015_SDK_NOT_INITIALIZED("LE-015", "SDK_EVENT_LOAD_ERROR", "INIT_ERROR", "SDK not initialized"),
    LE_015_SDK_INITIALIZATION_FAILED("LE-015", "SDK_EVENT_LOAD_ERROR", "INIT_ERROR", "SDK initialization failed"),
    LE_016_SDK_CONFIGURATION_SYNCHRONIZATION_FAILED("LE-016", "SDK_EVENT_LOAD_ERROR", "PROFIG_ERROR", "SDK configuration synchronization failed"),
    LE_016_SDK_CONFIGURATION_NOT_SYNCED("LE-016", "SDK_EVENT_LOAD_ERROR", "PROFIG_ERROR", "SDK configuration is not synced"),
    LE_017_AD_ERROR_AD_MARKUP_PARSING_HAS_FAILED("LE-017", "SDK_EVENT_LOAD_ERROR", "AD_PARSING_ERROR", "Ad markup parsing has failed"),
    LE_017_AD_ERROR_AD_RESPONSE_PARSING_FAILED("LE-017", "SDK_EVENT_LOAD_ERROR", "AD_PARSING_ERROR", "Ad response parsing has failed"),
    LE_018_EMPTY_AD_HTML("LE-018", "SDK_EVENT_LOAD_ERROR", "PRECACHE_ERROR", "The ad HTML is empty"),
    LE_018_TIMEOUT("LE-018", "SDK_EVENT_LOAD_ERROR", "PRECACHE_ERROR", AndroidInitializeBoldSDK.MSG_TIMEOUT),
    LE_018_WEBVIEW_AD_CONTENT_EMBEDDING_ERROR("LE-018", "SDK_EVENT_LOAD_ERROR", "PRECACHE_ERROR", "Webview ad content embedding error"),
    LE_018_AD_UNLOAD("LE-018", "SDK_EVENT_LOAD_ERROR", "PRECACHE_ERROR", "Ad unloaded"),
    LE_018_WEBVIEW_NULL("LE-018", "SDK_EVENT_LOAD_ERROR", "PRECACHE_ERROR", "WebView is null"),
    LE_018_NO_WEBVIEW_LOADED("LE-018", "SDK_EVENT_LOAD_ERROR", "PRECACHE_ERROR", "No WebView loaded"),
    LE_018_UNKNOWN("LE-018", "SDK_EVENT_LOAD_ERROR", "PRECACHE_ERROR", "Unknown error"),
    LE_018_RENDER_PROCESS_GONE("LE-018", "SDK_EVENT_LOAD_ERROR", "PRECACHE_ERROR", "Webview terminated by the OS"),
    /* JADX INFO: Fake field, exist only in values array */
    LE_018_MRAID_FILE_FAILED_DOWNLOAD("LE-018", "SDK_EVENT_LOAD_ERROR", "PRECACHE_ERROR", "Mraid file failed to download"),
    LE_019_AD_ERROR_LOAD_DROPPED("LE-019", "SDK_EVENT_LOAD_ERROR", "CALL_ERROR", "Load dropped"),
    SE_001_CONFIG_RESTRICTIONS_AD_DISABLED("SE-001", "SDK_EVENT_SHOW_ERROR", "CONFIG_RESTRICTIONS", "Ad disabled"),
    SE_002_CONFIG_RESTRICTIONS_AD_EXPIRED("SE-002", "SDK_EVENT_SHOW_ERROR", "CONFIG_RESTRICTIONS", "Ad expired"),
    SE_003_SDK_NEVER_INITIALIZED("SE-003", "SDK_EVENT_SHOW_ERROR", "INIT_ERROR", "SDK never initialized (asset key not found)"),
    SE_003_SDK_NOT_INITIALIZED("SE-003", "SDK_EVENT_SHOW_ERROR", "INIT_ERROR", "SDK not initialized"),
    SE_003_SDK_INITIALIZATION_FAILED("SE-003", "SDK_EVENT_SHOW_ERROR", "INIT_ERROR", "SDK initialization failed"),
    SE_004_PRECACHE_ERROR_NO_AD_LOADED("SE-004", "SDK_EVENT_SHOW_ERROR", "PRECACHE_ERROR", "No ad loaded"),
    SE_006_PROFIG_ERROR_PROFIG_NOT_SYNCED("SE-006", "SDK_EVENT_SHOW_ERROR", "PROFIG_ERROR", "SDK configuration is not synced"),
    SE_008_CONDITIONS_NOT_MET_VIEW_IN_BACKGROUND("SE-008", "SDK_EVENT_SHOW_ERROR", "CONDITIONS_NOT_MET", "View in background"),
    SE_009_CONDITIONS_NOT_MET_ANOTHER_AD_ALREADY_DISPLAYED("SE-009", "SDK_EVENT_SHOW_ERROR", "CONDITIONS_NOT_MET", "Another ad already displayed"),
    SE_010_CONDITIONS_NOT_MET_NO_INTERNET("SE-010", "SDK_EVENT_SHOW_ERROR", "CONDITIONS_NOT_MET", "No Internet connection"),
    SE_011_CONDITIONS_NOT_MET_WV_TERMINATED("SE-011", "SDK_EVENT_SHOW_ERROR", "CONDITIONS_NOT_MET", "Webview terminated by the OS");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7367a;
    public final String b;
    public final String c;
    public final String d;

    static {
        EnumEntriesKt.enumEntries(n7VarArr);
    }

    public n7(String str, String str2, String str3, String str4) {
        super(str, i);
        this.f7367a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public static n7 valueOf(String str) {
        return (n7) Enum.valueOf(n7.class, str);
    }

    public static n7[] values() {
        return (n7[]) J.clone();
    }
}
