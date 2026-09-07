package net.pubnative.lite.sdk.models;

import java.util.Objects;

/* JADX INFO: loaded from: classes12.dex */
public class Topic {
    private final int id;
    private final long taxonomyVersion;
    private final String taxonomyVersionName;

    public Topic(int i, long j, String str) {
        this.id = i;
        this.taxonomyVersion = j;
        this.taxonomyVersionName = str;
    }

    public int getId() {
        return this.id;
    }

    public Long getTaxonomyVersion() {
        return Long.valueOf(this.taxonomyVersion);
    }

    public String getTaxonomyVersionName() {
        return this.taxonomyVersionName;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Topic topic = (Topic) obj;
        return this.id == topic.id && this.taxonomyVersion == topic.taxonomyVersion;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.id), Long.valueOf(this.taxonomyVersion));
    }
}
