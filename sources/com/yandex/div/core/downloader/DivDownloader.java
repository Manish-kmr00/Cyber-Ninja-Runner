package com.yandex.div.core.downloader;

import com.yandex.div.core.images.LoadReference;
import com.yandex.div.core.view2.Div2View;

/* JADX INFO: loaded from: classes13.dex */
public interface DivDownloader {
    public static final DivDownloader STUB = new DivDownloader() { // from class: com.yandex.div.core.downloader.DivDownloader$$ExternalSyntheticLambda0
        @Override // com.yandex.div.core.downloader.DivDownloader
        public final LoadReference downloadPatch(Div2View div2View, String str, DivPatchDownloadCallback divPatchDownloadCallback) {
            return DivDownloader.lambda$static$0(div2View, str, divPatchDownloadCallback);
        }
    };

    LoadReference downloadPatch(Div2View div2View, String str, DivPatchDownloadCallback divPatchDownloadCallback);

    static /* synthetic */ LoadReference lambda$static$0(Div2View div2View, String str, DivPatchDownloadCallback divPatchDownloadCallback) {
        throw new AssertionError("To load patch you must provide implementation of DivDownloader to your DivConfiguration. ");
    }
}
