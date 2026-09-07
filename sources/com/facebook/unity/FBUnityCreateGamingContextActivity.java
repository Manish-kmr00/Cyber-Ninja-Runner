package com.facebook.unity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.gamingservices.ContextCreateDialog;
import com.facebook.gamingservices.model.ContextCreateContent;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;

/* JADX INFO: loaded from: classes7.dex */
public class FBUnityCreateGamingContextActivity extends BaseActivity {
    private static String TAG = "com.facebook.unity.FBUnityCreateGamingContextActivity";

    @Override // com.facebook.unity.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch("com.facebook", me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.facebook.unity.BaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle bundleExtra = getIntent().getBundleExtra(BaseActivity.ACTIVITY_PARAMS);
        final UnityMessage unityMessage = new UnityMessage("OnCreateGamingContextComplete");
        String string = bundleExtra.getString(Constants.CALLBACK_ID_KEY);
        Log.e(TAG, "callbackID: " + string);
        if (string != null) {
            unityMessage.put(Constants.CALLBACK_ID_KEY, string);
        }
        String string2 = bundleExtra.getString("playerID");
        ContextCreateContent.Builder builder = new ContextCreateContent.Builder();
        builder.setSuggestedPlayerID(string2);
        ContextCreateContent contextCreateContentBuild = builder.build();
        ContextCreateDialog contextCreateDialog = new ContextCreateDialog(this);
        contextCreateDialog.registerCallback(this.mCallbackManager, new FacebookCallback<ContextCreateDialog.Result>() { // from class: com.facebook.unity.FBUnityCreateGamingContextActivity.1
            @Override // com.facebook.FacebookCallback
            public void onSuccess(ContextCreateDialog.Result result) {
                unityMessage.put("contextId", result.getContextID());
                unityMessage.send();
                FBUnityCreateGamingContextActivity.this.finish();
            }

            @Override // com.facebook.FacebookCallback
            public void onCancel() {
                unityMessage.putCancelled();
                unityMessage.send();
                FBUnityCreateGamingContextActivity.this.finish();
            }

            @Override // com.facebook.FacebookCallback
            public void onError(FacebookException facebookException) {
                unityMessage.sendError(facebookException.getMessage());
                FBUnityCreateGamingContextActivity.this.finish();
            }
        });
        contextCreateDialog.show(contextCreateContentBuild);
    }
}
