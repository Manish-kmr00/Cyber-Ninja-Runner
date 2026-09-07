package sg.bigo.ads.core.f.a;

import com.smaato.sdk.video.vast.model.MediaFile;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes13.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Node f13592a;

    public i(Node node) {
        this.f13592a = node;
    }

    public final String a() {
        return sg.bigo.ads.core.f.a.e(this.f13592a, "type");
    }

    public final String b() {
        return sg.bigo.ads.core.f.a.b(this.f13592a);
    }

    public final int c() {
        return sg.bigo.ads.core.f.a.d(this.f13592a, MediaFile.FILE_SIZE).intValue();
    }

    public final int d() {
        return sg.bigo.ads.core.f.a.d(this.f13592a, "bitrate").intValue();
    }

    public final String e() {
        return sg.bigo.ads.core.f.a.e(this.f13592a, "md5");
    }
}
