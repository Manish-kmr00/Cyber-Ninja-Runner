package com.facebook.unity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.gamingservices.ContextChooseDialog;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.model.ContextChooseContent;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class FBUnityChooseGamingContextActivity extends BaseActivity {
    private static String TAG = "com.facebook.unity.FBUnityChooseGamingContextActivity";

    @Override // com.facebook.unity.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch("com.facebook", me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.facebook.unity.BaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle bundleExtra = getIntent().getBundleExtra(BaseActivity.ACTIVITY_PARAMS);
        final UnityMessage unityMessage = new UnityMessage("OnChooseGamingContextComplete");
        String string = bundleExtra.getString(Constants.CALLBACK_ID_KEY);
        Log.e(TAG, "callbackID: " + string);
        if (string != null) {
            unityMessage.put(Constants.CALLBACK_ID_KEY, string);
        }
        ContextChooseContent.Builder builder = new ContextChooseContent.Builder();
        Log.v(TAG, "ChooseGamingContext(" + bundleExtra + ")");
        try {
            ArrayList<String> stringArrayList = bundleExtra.getStringArrayList("filters");
            Log.v(TAG, "ChooseGamingContext filters: " + stringArrayList + "");
            String string2 = bundleExtra.getString(SDKConstants.PARAM_CONTEXT_MIN_SIZE);
            Integer numValueOf = !string2.isEmpty() ? Integer.valueOf(Integer.parseInt(string2)) : null;
            String string3 = bundleExtra.getString(SDKConstants.PARAM_CONTEXT_MAX_SIZE);
            Integer numValueOf2 = string3.isEmpty() ? null : Integer.valueOf(Integer.parseInt(string3));
            ContextChooseContent contextChooseContentBuild = builder.build();
            if (stringArrayList != null) {
                builder.setFilters(stringArrayList);
            }
            if (numValueOf != null) {
                builder.setMinSize(numValueOf);
            }
            if (numValueOf2 != null) {
                builder.setMaxSize(numValueOf2);
            }
            ContextChooseDialog contextChooseDialog = new ContextChooseDialog(this);
            contextChooseDialog.registerCallback(this.mCallbackManager, new FacebookCallback<ContextChooseDialog.Result>() { // from class: com.facebook.unity.FBUnityChooseGamingContextActivity.1
                @Override // com.facebook.FacebookCallback
                public void onSuccess(ContextChooseDialog.Result result) {
                    unityMessage.put("contextId", result.getContextID());
                    unityMessage.send();
                    FBUnityChooseGamingContextActivity.this.finish();
                }

                @Override // com.facebook.FacebookCallback
                public void onCancel() {
                    unityMessage.putCancelled();
                    unityMessage.send();
                    FBUnityChooseGamingContextActivity.this.finish();
                }

                @Override // com.facebook.FacebookCallback
                public void onError(FacebookException facebookException) {
                    unityMessage.sendError(facebookException.getMessage());
                    FBUnityChooseGamingContextActivity.this.finish();
                }
            });
            contextChooseDialog.show(contextChooseContentBuild);
        } catch (Exception e) {
            unityMessage.sendError(String.format("Invalid params: %s", e.getMessage()));
        }
    }
}
