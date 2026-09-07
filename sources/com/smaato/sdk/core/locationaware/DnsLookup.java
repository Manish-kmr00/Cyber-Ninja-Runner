package com.smaato.sdk.core.locationaware;

import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public interface DnsLookup {
    List<TxtRecord> blockingTxt(String str) throws IOException;
}
