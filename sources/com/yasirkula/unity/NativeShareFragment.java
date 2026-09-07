package com.yasirkula.unity;

import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.safedk.android.utils.Logger;

/* JADX INFO: loaded from: classes12.dex */
public class NativeShareFragment extends Fragment {
    public static final String FILES_ID = "NS_FILES";
    public static final String MIMES_ID = "NS_MIMES";
    private static final int SHARE_RESULT_CODE = 774457;
    public static final String SUBJECT_ID = "NS_SUBJECT";
    public static final String TARGET_CLASS_ID = "NS_TARGET_CLASS";
    public static final String TARGET_PACKAGE_ID = "NS_TARGET_PACKAGE";
    public static final String TEXT_ID = "NS_TEXT";
    public static final String TITLE_ID = "NS_TITLE";

    public static void safedk_NativeShareFragment_startActivityForResult_f43e384bd016772bbb20fa7e8c0adda1(NativeShareFragment p0, Intent p1, int p2) {
        Logger.d("SafeDK-Special|SafeDK: Call> Lcom/yasirkula/unity/NativeShareFragment;->startActivityForResult(Landroid/content/Intent;I)V");
        if (p1 == null) {
            return;
        }
        p0.startActivityForResult(p1, p2);
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (NativeShare.shareResultReceiver == null) {
            getFragmentManager().beginTransaction().remove(this).commit();
            return;
        }
        try {
            safedk_NativeShareFragment_startActivityForResult_f43e384bd016772bbb20fa7e8c0adda1(this, Intent.createChooser(NativeShare.CreateIntentFromBundle(getActivity(), getArguments()), getArguments().getString(TITLE_ID), NativeShareBroadcastListener.Initialize(getActivity())), SHARE_RESULT_CODE);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(getActivity(), "No apps can perform this action.", 1).show();
            onActivityResult(SHARE_RESULT_CODE, 0, null);
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != SHARE_RESULT_CODE) {
            return;
        }
        if (NativeShare.shareResultReceiver != null) {
            Log.d("Unity", "Reported share result (may not be correct): " + (resultCode == -1));
            if (resultCode == -1) {
                NativeShare.shareResultReceiver.OnShareCompleted(1, "");
            } else {
                NativeShare.shareResultReceiver.OnShareCompleted(2, "");
            }
        } else {
            Log.e("Unity", "NativeShareResultReceiver was null!");
        }
        getFragmentManager().beginTransaction().remove(this).commit();
    }
}
