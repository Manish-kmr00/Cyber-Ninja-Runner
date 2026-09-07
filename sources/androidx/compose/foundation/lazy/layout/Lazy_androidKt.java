package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import kotlin.Metadata;

/* JADX INFO: compiled from: Lazy.android.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"getDefaultLazyLayoutKey", "", "index", "", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class Lazy_androidKt {
    @ExperimentalFoundationApi
    public static final Object getDefaultLazyLayoutKey(int i) {
        return new DefaultLazyKey(i);
    }
}
