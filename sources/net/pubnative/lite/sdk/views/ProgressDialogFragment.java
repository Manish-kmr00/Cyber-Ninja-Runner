package net.pubnative.lite.sdk.views;

import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.os.Bundle;

/* JADX INFO: loaded from: classes11.dex */
public class ProgressDialogFragment extends DialogFragment {
    public static ProgressDialogFragment newInstance(String str, String str2) {
        ProgressDialogFragment progressDialogFragment = new ProgressDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString("message", str2);
        progressDialogFragment.setArguments(bundle);
        return progressDialogFragment;
    }

    @Override // android.app.DialogFragment
    public ProgressDialog onCreateDialog(Bundle bundle) {
        String string = getArguments().getString("title");
        String string2 = getArguments().getString("message");
        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle(string);
        progressDialog.setMessage(string2);
        setCancelable(false);
        progressDialog.show();
        return progressDialog;
    }
}
