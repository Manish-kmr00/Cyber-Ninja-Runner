package com.facebook.unity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.gamingservices.GameRequestDialog;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.model.GameRequestContent;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class FBUnityGameRequestActivity extends BaseActivity {
    public static final String GAME_REQUEST_PARAMS = "game_request_params";

    @Override // com.facebook.unity.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch("com.facebook", me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.facebook.unity.BaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            showDialog();
        }
    }

    private void showDialog() {
        Bundle bundleExtra = getIntent().getBundleExtra(GAME_REQUEST_PARAMS);
        final UnityMessage unityMessage = new UnityMessage("OnAppRequestsComplete");
        if (bundleExtra.containsKey(Constants.CALLBACK_ID_KEY)) {
            unityMessage.put(Constants.CALLBACK_ID_KEY, bundleExtra.getString(Constants.CALLBACK_ID_KEY));
        }
        GameRequestContent.Builder builder = new GameRequestContent.Builder();
        if (bundleExtra.containsKey("message")) {
            builder.setMessage(bundleExtra.getString("message"));
        }
        if (bundleExtra.containsKey(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE)) {
            String string = bundleExtra.getString(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE);
            try {
                builder.setActionType(GameRequestContent.ActionType.valueOf(string));
            } catch (IllegalArgumentException unused) {
                unityMessage.sendError("Unknown action type: " + string);
                finish();
                return;
            }
        }
        if (bundleExtra.containsKey("object_id")) {
            builder.setObjectId(bundleExtra.getString("object_id"));
        }
        if (bundleExtra.containsKey("to")) {
            builder.setRecipients(Arrays.asList(bundleExtra.getString("to").split(StringUtils.COMMA)));
        }
        if (bundleExtra.containsKey("filters")) {
            String upperCase = bundleExtra.getString("filters").toUpperCase(Locale.ROOT);
            try {
                builder.setFilters(GameRequestContent.Filters.valueOf(upperCase));
            } catch (IllegalArgumentException unused2) {
                unityMessage.sendError("Unsupported filter type: " + upperCase);
                finish();
                return;
            }
        }
        if (bundleExtra.containsKey("data")) {
            builder.setData(bundleExtra.getString("data"));
        }
        if (bundleExtra.containsKey("title")) {
            builder.setTitle(bundleExtra.getString("title"));
        }
        GameRequestContent gameRequestContentBuild = builder.build();
        GameRequestDialog gameRequestDialog = new GameRequestDialog(this);
        gameRequestDialog.registerCallback(this.mCallbackManager, new FacebookCallback<GameRequestDialog.Result>() { // from class: com.facebook.unity.FBUnityGameRequestActivity.1
            @Override // com.facebook.FacebookCallback
            public void onSuccess(GameRequestDialog.Result result) {
                unityMessage.put("request", result.getRequestId());
                unityMessage.put("to", TextUtils.join(StringUtils.COMMA, result.getRequestRecipients()));
                unityMessage.send();
                FBUnityGameRequestActivity.this.finish();
            }

            @Override // com.facebook.FacebookCallback
            public void onCancel() {
                unityMessage.putCancelled();
                unityMessage.send();
                FBUnityGameRequestActivity.this.finish();
            }

            @Override // com.facebook.FacebookCallback
            public void onError(FacebookException facebookException) {
                unityMessage.sendError(facebookException.getMessage());
                FBUnityGameRequestActivity.this.finish();
            }
        });
        try {
            gameRequestDialog.show(gameRequestContentBuild);
        } catch (IllegalArgumentException e) {
            unityMessage.sendError("Unexpected exception encountered: " + e.toString());
            finish();
        }
    }
}
