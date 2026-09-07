package com.mbridge.msdk.playercommon.exoplayer2.source;

import android.net.Uri;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;

/* JADX INFO: loaded from: classes8.dex */
public class UnrecognizedInputFormatException extends ParserException {
    public final Uri uri;

    public UnrecognizedInputFormatException(String str, Uri uri) {
        super(str);
        this.uri = uri;
    }
}
