package net.pubnative.lite.sdk.vpaid.models.vast;

import java.util.List;
import net.pubnative.lite.sdk.vpaid.xml.Tag;

/* JADX INFO: loaded from: classes11.dex */
public class MediaFiles {

    @Tag
    private ClosedCaptionFiles closedCaptionFiles;

    @Tag("InteractiveCreativeFile")
    private List<InteractiveCreativeFile> interactiveCreativeFiles;

    @Tag("MediaFile")
    private List<MediaFile> mediaFiles;

    @Tag("Mezzanine")
    private List<Mezzanine> mezzanines;

    public List<MediaFile> getMediaFiles() {
        return this.mediaFiles;
    }

    public List<Mezzanine> getMezzanines() {
        return this.mezzanines;
    }

    public List<InteractiveCreativeFile> getInteractiveCreativeFiles() {
        return this.interactiveCreativeFiles;
    }

    public ClosedCaptionFiles getClosedCaptionFiles() {
        return this.closedCaptionFiles;
    }
}
