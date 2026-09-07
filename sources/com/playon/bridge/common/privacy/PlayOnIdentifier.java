package com.playon.bridge.common.privacy;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.text.TextUtils;
import com.playon.bridge.common.AsyncTaskExecutor;
import com.playon.bridge.common.Log;
import com.playon.bridge.common.SdkInitializationListener;
import com.playon.bridge.common.util.Preconditions;
import com.pubmatic.sdk.rewardedad.POBRewardedAdEvent;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;

/* JADX INFO: loaded from: classes7.dex */
public class PlayOnIdentifier {
    private static final int MISSING_VALUE = -1;
    private static final String PREF_AD_INFO_GROUP = "com.playon.settings.identifier";
    private static final String PREF_IDENTIFIER_TIME = "privacy.identifier.time";
    private static final String PREF_IFA_IDENTIFIER = "privacy.identifier.ifa";
    private static final String PREF_LIMIT_AD_TRACKING = "privacy.limit.ad.tracking";
    private static final String PREF_PLAYON_IDENTIFIER = "privacy.identifier.playon";
    protected static final String TAG = Log.makeTag(POBRewardedAdEvent.KEY_IDENTIFER);
    RefreshAdvertisingInfoTask advertInfoTask = new RefreshAdvertisingInfoTask();
    private boolean initialized;
    private AdvertisingId mAdInfo;
    private final Context mAppContext;
    private boolean mRefreshingAdvertisingInfo;
    private volatile SdkInitializationListener mSdkInitializationListener;

    public PlayOnIdentifier(Context context, SdkInitializationListener sdkInitializationListener) {
        Preconditions.checkNotNull(context);
        this.mAppContext = context;
        this.mSdkInitializationListener = sdkInitializationListener;
        AdvertisingId idFromStorage = readIdFromStorage(context);
        this.mAdInfo = idFromStorage;
        if (idFromStorage == null) {
            this.mAdInfo = AdvertisingId.generateFreshAdvertisingId();
        }
        refreshAdvertisingInfo();
    }

    public AdvertisingId getAdvertisingInfo() {
        AdvertisingId advertisingId = this.mAdInfo;
        refreshAdvertisingInfo();
        return advertisingId;
    }

    public boolean isInitialized() {
        return this.initialized;
    }

    private void refreshAdvertisingInfo() {
        if (this.mRefreshingAdvertisingInfo) {
            return;
        }
        this.mRefreshingAdvertisingInfo = true;
        this.advertInfoTask.executeAsync(new String[0]);
    }

    static synchronized AdvertisingId readIdFromStorage(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_AD_INFO_GROUP, 0);
            String string = sharedPreferences.getString(PREF_IFA_IDENTIFIER, "");
            String string2 = sharedPreferences.getString(PREF_PLAYON_IDENTIFIER, "");
            boolean z = sharedPreferences.getBoolean(PREF_LIMIT_AD_TRACKING, false);
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                return new AdvertisingId(string, string2, z);
            }
        } catch (ClassCastException unused) {
            Log.d(TAG, "Cannot read identifier from shared preferences");
        }
        return null;
    }

    private static synchronized void writeIdToStorage(Context context, AdvertisingId advertisingId) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PREF_AD_INFO_GROUP, 0).edit();
        editorEdit.putBoolean(PREF_LIMIT_AD_TRACKING, advertisingId.mDoNotTrack);
        editorEdit.putString(PREF_IFA_IDENTIFIER, advertisingId.mAdvertisingId);
        editorEdit.putString(PREF_PLAYON_IDENTIFIER, advertisingId.mPlayOnId);
        editorEdit.apply();
    }

    static synchronized void clearStorage(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PREF_AD_INFO_GROUP, 0).edit();
        editorEdit.remove(PREF_LIMIT_AD_TRACKING);
        editorEdit.remove(PREF_IFA_IDENTIFIER);
        editorEdit.remove(PREF_PLAYON_IDENTIFIER);
        editorEdit.remove(PREF_IDENTIFIER_TIME);
        editorEdit.apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdvertisingInfo(String str, String str2, boolean z) {
        setAdvertisingInfo(new AdvertisingId(str, str2, z));
    }

    void setAdvertisingInfo(AdvertisingId advertisingId) {
        this.mAdInfo = advertisingId;
        writeIdToStorage(this.mAppContext, advertisingId);
        if (this.mSdkInitializationListener != null) {
            this.mSdkInitializationListener.onInitializationFinished();
            this.mSdkInitializationListener = null;
        }
        this.initialized = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdvertisingId getAmazonAdvertisingInfo(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        int i = Settings.Secure.getInt(contentResolver, CommonUrlParts.LIMIT_AD_TRACKING, -1);
        String string = Settings.Secure.getString(contentResolver, "advertising_id");
        if (i == -1 || TextUtils.isEmpty(string)) {
            return null;
        }
        return new AdvertisingId(string, this.mAdInfo.mPlayOnId, i != 0);
    }

    private class RefreshAdvertisingInfoTask extends AsyncTaskExecutor<String> {
        private RefreshAdvertisingInfoTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.playon.bridge.common.AsyncTaskExecutor
        public void doInBackground(String... strArr) {
            AdvertisingId amazonAdvertisingInfo;
            AdvertisingId advertisingId = PlayOnIdentifier.this.mAdInfo;
            GpsHelper.AdvertisingInfo advertisingInfoFetchAdvertisingInfoSync = GpsHelper.fetchAdvertisingInfoSync(PlayOnIdentifier.this.mAppContext);
            if (advertisingInfoFetchAdvertisingInfoSync != null && !TextUtils.isEmpty(advertisingInfoFetchAdvertisingInfoSync.advertisingId)) {
                amazonAdvertisingInfo = new AdvertisingId(advertisingInfoFetchAdvertisingInfoSync.advertisingId, advertisingId.mPlayOnId, advertisingInfoFetchAdvertisingInfoSync.limitAdTracking);
            } else {
                PlayOnIdentifier playOnIdentifier = PlayOnIdentifier.this;
                amazonAdvertisingInfo = playOnIdentifier.getAmazonAdvertisingInfo(playOnIdentifier.mAppContext);
            }
            if (amazonAdvertisingInfo != null) {
                PlayOnIdentifier.this.setAdvertisingInfo(amazonAdvertisingInfo.mAdvertisingId, advertisingId.mPlayOnId, amazonAdvertisingInfo.mDoNotTrack);
            } else {
                PlayOnIdentifier playOnIdentifier2 = PlayOnIdentifier.this;
                playOnIdentifier2.setAdvertisingInfo(playOnIdentifier2.mAdInfo);
            }
            PlayOnIdentifier.this.mRefreshingAdvertisingInfo = false;
        }
    }
}
