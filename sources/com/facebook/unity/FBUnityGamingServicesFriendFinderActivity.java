package com.facebook.unity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.gamingservices.FriendFinderDialog;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;

/* JADX INFO: loaded from: classes7.dex */
public class FBUnityGamingServicesFriendFinderActivity extends BaseActivity {
    public static final String DIALOG_PARAMS = "dialog_params";
    private static String TAG = "com.facebook.unity.FBUnityGamingServicesFriendFinderActivity";

    @Override // com.facebook.unity.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch("com.facebook", me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.facebook.unity.BaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle bundleExtra = getIntent().getBundleExtra(DIALOG_PARAMS);
        final UnityMessage unityMessage = new UnityMessage("OnFriendFinderComplete");
        String string = bundleExtra.getString(Constants.CALLBACK_ID_KEY);
        Log.e(TAG, "callbackID: " + string);
        if (string != null) {
            unityMessage.put(Constants.CALLBACK_ID_KEY, string);
        }
        FriendFinderDialog friendFinderDialog = new FriendFinderDialog(this);
        friendFinderDialog.registerCallback(this.mCallbackManager, new FacebookCallback<FriendFinderDialog.Result>() { // from class: com.facebook.unity.FBUnityGamingServicesFriendFinderActivity.1
            @Override // com.facebook.FacebookCallback
            public void onSuccess(FriendFinderDialog.Result result) {
                unityMessage.put("success", true);
                unityMessage.send();
                FBUnityGamingServicesFriendFinderActivity.this.finish();
            }

            @Override // com.facebook.FacebookCallback
            public void onCancel() {
                unityMessage.putCancelled();
                unityMessage.send();
                FBUnityGamingServicesFriendFinderActivity.this.finish();
            }

            @Override // com.facebook.FacebookCallback
            public void onError(FacebookException facebookException) {
                unityMessage.sendError(facebookException.getMessage());
                FBUnityGamingServicesFriendFinderActivity.this.finish();
            }
        });
        friendFinderDialog.show();
    }
}
