package com.smaato.sdk.video.vast.buildlight;

import com.json.x8;
import com.smaato.sdk.video.vast.buildlight.compare.AverageBitratePicker;
import com.smaato.sdk.video.vast.buildlight.compare.BitrateComparator;
import com.smaato.sdk.video.vast.buildlight.compare.MediaFileComparator;
import com.smaato.sdk.video.vast.buildlight.compare.SizeComparator;
import com.smaato.sdk.video.vast.model.MediaFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class VastLinearMediaFilePicker {
    MediaFileResult pickMediaFile(List<MediaFile> list, VastConfigurationSettings vastConfigurationSettings) {
        if (list.isEmpty()) {
            return new MediaFileResult.Builder().build();
        }
        HashSet hashSet = new HashSet();
        ArrayList<MediaFile> arrayList = new ArrayList(list);
        Collections.sort(arrayList, new MediaFileComparator(new SizeComparator(vastConfigurationSettings), new BitrateComparator(new AverageBitratePicker(vastConfigurationSettings).getAverageBitrate(), x8.b.equalsIgnoreCase(vastConfigurationSettings.connectionType))));
        for (MediaFile mediaFile : arrayList) {
            if (mediaFile.isVpaid()) {
                hashSet.add(901);
            } else {
                String str = mediaFile.url;
                String strSubstring = str.substring(str.lastIndexOf(".") + 1);
                String str2 = mediaFile.type;
                if ((str2 != null && str2.matches("video/.*(?i)(mp4|3gp|mp2t|webm|mkv)")) || strSubstring.matches("(?i)^(mp4|3gp|mp2t|webm|mkv)$")) {
                    return new MediaFileResult.Builder().setMediaFile(mediaFile).build();
                }
            }
        }
        hashSet.add(403);
        return new MediaFileResult.Builder().setErrors(hashSet).build();
    }
}
