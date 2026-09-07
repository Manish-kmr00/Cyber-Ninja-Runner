package com.pubmatic.sdk.common.utility;

import android.content.Context;
import android.graphics.Bitmap;
import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.network.POBImageRequest;
import com.pubmatic.sdk.common.network.POBNetworkHandler;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class POBImageDownloadManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f7633a;
    private final Map b = Collections.synchronizedMap(new HashMap());
    private final Map c = Collections.synchronizedMap(new HashMap());
    private POBImageDownloadListener d;

    public interface POBImageDownloadListener {
        void onComplete(Map<String, Bitmap> map);
    }

    class a implements POBNetworkHandler.POBImageNetworkListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ POBImageRequest f7634a;

        a(POBImageRequest pOBImageRequest) {
            this.f7634a = pOBImageRequest;
        }

        @Override // com.pubmatic.sdk.common.network.POBNetworkHandler.POBImageNetworkListener
        public void onFailure(POBError pOBError) {
            POBLog.error("POBImageDownloadManager", "Unable to download image for url - %s", pOBError);
            POBImageDownloadManager.this.c.put(this.f7634a.getUrl(), null);
            POBImageDownloadManager.this.a();
        }

        @Override // com.pubmatic.sdk.common.network.POBNetworkHandler.POBImageNetworkListener
        public void onSuccess(Bitmap bitmap) {
            POBImageDownloadManager.this.c.put(this.f7634a.getUrl(), bitmap);
            POBImageDownloadManager.this.a();
        }
    }

    public POBImageDownloadManager(Context context, Set<String> set) {
        this.f7633a = context;
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    public void cancel() {
        Iterator it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            ((POBNetworkHandler) ((Map.Entry) it.next()).getKey()).cancelRequest("POBImageDownloadManager");
        }
    }

    public boolean isEmpty() {
        return this.b.isEmpty();
    }

    public void setListener(POBImageDownloadListener pOBImageDownloadListener) {
        this.d = pOBImageDownloadListener;
    }

    public void start() {
        if (this.b.isEmpty() && this.d != null) {
            a();
            return;
        }
        for (Map.Entry entry : this.b.entrySet()) {
            POBImageRequest pOBImageRequest = (POBImageRequest) entry.getValue();
            if (pOBImageRequest != null) {
                ((POBNetworkHandler) entry.getKey()).sendImageRequest(pOBImageRequest, new a(pOBImageRequest));
            }
        }
    }

    private void a(String str) {
        POBImageRequest pOBImageRequest = new POBImageRequest();
        pOBImageRequest.setRequestTag("POBImageDownloadManager");
        pOBImageRequest.setUrl(str);
        pOBImageRequest.setTimeout(5000);
        this.b.put(new POBNetworkHandler(this.f7633a), pOBImageRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        POBImageDownloadListener pOBImageDownloadListener;
        if (this.b.size() != this.c.size() || (pOBImageDownloadListener = this.d) == null) {
            return;
        }
        pOBImageDownloadListener.onComplete(this.c);
    }
}
