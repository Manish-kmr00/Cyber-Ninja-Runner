package com.yandex.div.storage.database;

import kotlin.Metadata;

/* JADX INFO: compiled from: StorageSchema.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0011X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"COLUMN_CARD_DATA", "", "COLUMN_CARD_GROUP_ID", "COLUMN_CARD_ID", "COLUMN_CARD_METADATA", "COLUMN_GROUP_ID", "COLUMN_LAYOUT_ID", "COLUMN_RAW_JSON_DATA", "COLUMN_RAW_JSON_ID", "COLUMN_TEMPLATE_DATA", "COLUMN_TEMPLATE_HASH", "COLUMN_TEMPLATE_ID", "CREATE_TABLE_CARDS", "CREATE_TABLE_RAW_JSON", "CREATE_TABLE_TEMPLATES", "CREATE_TABLE_TEMPLATE_REFERENCES", "DB_VERSION", "", "TABLE_CARDS", "TABLE_RAW_JSON", "TABLE_TEMPLATES", "TABLE_TEMPLATE_REFERENCES", "div-storage_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class StorageSchema {
    public static final String COLUMN_CARD_DATA = "card_data";
    public static final String COLUMN_CARD_GROUP_ID = "group_id";
    public static final String COLUMN_CARD_ID = "card_id";
    public static final String COLUMN_CARD_METADATA = "metadata";
    public static final String COLUMN_GROUP_ID = "group_id";
    public static final String COLUMN_LAYOUT_ID = "layout_id";
    public static final String COLUMN_RAW_JSON_DATA = "raw_json_data";
    public static final String COLUMN_RAW_JSON_ID = "raw_json_id";
    public static final String COLUMN_TEMPLATE_DATA = "template_data";
    public static final String COLUMN_TEMPLATE_HASH = "template_hash";
    public static final String COLUMN_TEMPLATE_ID = "template_id";
    public static final String CREATE_TABLE_CARDS = "\n    CREATE TABLE IF NOT EXISTS cards(\n    layout_id TEXT NOT NULL PRIMARY KEY,\n    card_data BLOB NULLABLE,\n    metadata BLOB NULLABLE,\n    group_id TEXT NOT NULL)";
    public static final String CREATE_TABLE_RAW_JSON = "\n    CREATE TABLE IF NOT EXISTS raw_json(\n    raw_json_id TEXT NOT NULL PRIMARY KEY,\n    raw_json_data BLOB NULLABLE)";
    public static final String CREATE_TABLE_TEMPLATES = "\n    CREATE TABLE IF NOT EXISTS templates(\n    template_hash TEXT NOT NULL PRIMARY KEY,\n    template_data BLOB NULLABLE)";
    public static final String CREATE_TABLE_TEMPLATE_REFERENCES = "\n    CREATE TABLE IF NOT EXISTS template_references(\n    group_id TEXT NOT NULL,\n    template_id TEXT NOT NULL,\n    template_hash TEXT NOT NULL,\n    PRIMARY KEY(group_id, template_id))";
    public static final int DB_VERSION = 3;
    public static final String TABLE_CARDS = "cards";
    public static final String TABLE_RAW_JSON = "raw_json";
    public static final String TABLE_TEMPLATES = "templates";
    public static final String TABLE_TEMPLATE_REFERENCES = "template_references";
}
