package io.bidmachine.nativead;

import android.graphics.Bitmap;
import android.net.Uri;
import io.bidmachine.iab.vast.VastRequest;

/* JADX INFO: loaded from: classes12.dex */
public interface NativeMediaPrivateData extends NativeMediaPublicData {
    VastRequest getVastRequest();

    void setIconBitmap(Bitmap bitmap);

    void setIconUri(Uri uri);

    void setImageBitmap(Bitmap bitmap);

    void setImageUri(Uri uri);

    void setVastRequest(VastRequest vastRequest);

    void setVideoUri(Uri uri);
}
