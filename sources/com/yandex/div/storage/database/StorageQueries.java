package com.yandex.div.storage.database;

import kotlin.Metadata;

/* JADX INFO: compiled from: StorageQueries.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"DELETE_CARDS", "", "DELETE_CARDS_IDS", "DELETE_RAW_JSON_BY_IDS", "DELETE_TEMPLATES", "DELETE_TEMPLATE_USAGES", "DELETE_TEMPLATE_USAGES_BY_CARD_IDS", "DELETE_UNUSED_TEMPLATES", "DELETE_UNUSED_TEMPLATE_REFERENCES", "INSERT_TEMPLATE", "INSERT_TEMPLATE_USAGE", "REPLACE_CARD", "REPLACE_RAW_JSON", "SELECT_RAW_JSONS_BY_IDS", "SELECT_TEMPLATES_BY_HASHES", "div-storage_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class StorageQueries {
    public static final String DELETE_CARDS = "DELETE FROM cards";
    public static final String DELETE_CARDS_IDS = "DELETE FROM cards WHERE layout_id IN ";
    public static final String DELETE_RAW_JSON_BY_IDS = "DELETE FROM raw_json WHERE raw_json_id IN";
    public static final String DELETE_TEMPLATES = "DELETE FROM templates";
    public static final String DELETE_TEMPLATE_USAGES = "DELETE FROM template_references";
    public static final String DELETE_TEMPLATE_USAGES_BY_CARD_IDS = "\n    DELETE FROM template_references WHERE group_id IN\n";
    public static final String DELETE_UNUSED_TEMPLATES = "\n    DELETE FROM templates\n    WHERE template_hash NOT IN\n        (SELECT DISTINCT template_hash FROM template_references)\n    ";
    public static final String DELETE_UNUSED_TEMPLATE_REFERENCES = "\n    DELETE FROM template_references\n    WHERE group_id NOT IN\n        (SELECT group_id FROM cards)\n    ";
    public static final String INSERT_TEMPLATE = "INSERT OR IGNORE INTO templates VALUES (?, ?)";
    public static final String INSERT_TEMPLATE_USAGE = "INSERT OR IGNORE INTO template_references VALUES (?, ?, ?)";
    public static final String REPLACE_CARD = "INSERT OR REPLACE INTO cards VALUES (?, ?, ?, ?)";
    public static final String REPLACE_RAW_JSON = "INSERT OR REPLACE INTO raw_json VALUES (?, ?)";
    public static final String SELECT_RAW_JSONS_BY_IDS = "\n    SELECT raw_json_id, raw_json_data\n    FROM raw_json\n    WHERE raw_json_id IN\n";
    public static final String SELECT_TEMPLATES_BY_HASHES = "\n    SELECT t.template_hash, t.template_data\n    FROM templates AS t\n    WHERE t.template_hash in\n";
}
