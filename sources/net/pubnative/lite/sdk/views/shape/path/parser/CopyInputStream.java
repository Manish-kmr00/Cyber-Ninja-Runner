package net.pubnative.lite.sdk.views.shape.path.parser;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import net.pubnative.lite.sdk.HyBid;

/* JADX INFO: loaded from: classes12.dex */
class CopyInputStream {
    private static final String TAG = SvgToPath.TAG;
    private ByteArrayOutputStream _copy;
    private final InputStream _is;

    public CopyInputStream(InputStream inputStream) {
        this._is = inputStream;
        try {
            copy();
        } catch (IOException e) {
            HyBid.reportException((Exception) e);
            Log.w(TAG, "IOException in CopyInputStream " + e.toString());
        }
    }

    private void copy() throws IOException {
        this._copy = new ByteArrayOutputStream();
        byte[] bArr = new byte[256];
        while (true) {
            int i = this._is.read(bArr);
            if (-1 != i) {
                this._copy.write(bArr, 0, i);
            } else {
                this._copy.flush();
                return;
            }
        }
    }

    public ByteArrayInputStream getCopy() {
        return new ByteArrayInputStream(this._copy.toByteArray());
    }
}
