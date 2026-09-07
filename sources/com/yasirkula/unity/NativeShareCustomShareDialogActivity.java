package com.yasirkula.unity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

/* JADX INFO: loaded from: classes11.dex */
public class NativeShareCustomShareDialogActivity extends Activity {
    private boolean dialogDisplayed;

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.native_share_custom_dialog_holder);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (!this.dialogDisplayed) {
            this.dialogDisplayed = true;
            NativeShareCustomShareDialog nativeShareCustomShareDialog = new NativeShareCustomShareDialog();
            nativeShareCustomShareDialog.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction().add(0, nativeShareCustomShareDialog).commit();
            return;
        }
        finish();
    }
}
