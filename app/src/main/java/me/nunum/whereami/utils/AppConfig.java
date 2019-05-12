package me.nunum.whereami.utils;

import java.util.UUID;

/**
 * Created by bullet on 08-01-2018.
 */

public class AppConfig {

    public static final String PREFERENCES_KEY_NAME = "localizations";

    public static final String REMOTE_HOST = "213.22.28.97";
    public static final Integer REMOTE_HOST_SINK_PORT = 8080;
    public static final Integer REMOTE_HOST_EXCHANGE_PORT = 9000;

    public static final Integer POOL_SIZE = 1;
    public static final Integer SINKER_DELAY = 9000;
    public static final Integer SINKER_PERIOD = 1000;

    public static final Integer PRODUCER_DELAY = 9000;
    public static final Integer PRODUCER_PERIOD = 10000;

    public static final String HTTP_REMOTE_HOST = "http://192.168.1.6:8080";
    public static final String HTTP_LOCALIZATIONS_RESOURCE = "/localization";
    public static final String HTTP_LOCALIZATION_POSITIONS_RESOURCE = "localization/:id/position";
    public static final String HTTP_PAGE_LOCALIZATION_RESOURCE = "/page/:x";
    public static final String HTTP_TRAINING_RESOURCE = "/localization/:id/train";
    public static final String HTTP_SPAM_RESOURCE = "localization/spam";
    public static final String HTTP_SAMPLES_RESOURCE = "fingerprint";


    public static final String HTTP_POSTS_RESOURCE = "/post";

    public static final Boolean PAGINATION_STATE = Boolean.TRUE;

    public static final Integer DATABASE_BATCH = 10;

    public static final String DEFAULT_USERNAME = "Anonymous";

    public static final String LOCALIZATION_URI = HTTP_REMOTE_HOST + HTTP_LOCALIZATIONS_RESOURCE;
    public static final String POSITIONS_URI = LOCALIZATION_URI + "/%d" + HTTP_LOCALIZATION_POSITIONS_RESOURCE;

    public static final String DATABASE_NAME = "wifi";
    public static final Integer DATABASE_VERSION = 1;

    public static final String TCP_PROTOCOL = "tcp";
    public static final String HTTP_PROTOCOL = "http";

    public static final String APPLICATION_INSTANCE = UUID.randomUUID().toString();

    public static final String JSON_MIME_TYPE_HEADER = "application/json";

    public static final Integer DEFAULT_ALGORITHM = 1;

    public static final int FIRST_PAGE = 1;

    public static final String CONNECTIVITY_TEST_HOST = "http://www.mocky.io";


}