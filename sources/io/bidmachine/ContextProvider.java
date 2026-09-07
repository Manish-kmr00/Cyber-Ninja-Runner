package io.bidmachine;

import android.app.Activity;
import android.content.Context;

/* JADX INFO: loaded from: classes6.dex */
public interface ContextProvider {
    Activity getActivity();

    Context getApplicationContext();

    Context getContext();
}
