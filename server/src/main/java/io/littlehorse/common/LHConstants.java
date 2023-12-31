package io.littlehorse.common;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LHConstants {

    // Other various constants used by code
    public static final Duration PUNCTUATOR_INERVAL = Duration.ofSeconds(2);
    public static final String EXT_EVT_HANDLER_VAR = "INPUT";

    // Make all global metadata use the same partition key so that they're processed
    // on the same node. This guarantees ordering. Note that metadata is low
    // throughput and low volume so partitioning is not needed.
    public static final String META_PARTITION_KEY = "METADATA";
    public static final String PARTITION_CLAIM_KEY = "PARTITION_CLAIM";
    public static final String PARTITION_CLAIM_GUID_HEADER = "PARTITION_CLAIM_GUID";

    // Reserved `FailureDef` names
    public static final String CHILD_FAILURE = "CHILD_FAILURE";
    public static final String VAR_SUB_ERROR = "VAR_SUB_ERROR";
    public static final String VAR_MUTATION_ERROR = "VAR_MUTATION_ERROR";
    public static final String TIMEOUT = "TIMEOUT";
    public static final String TASK_FAILURE = "TASK_FAILURE";
    public static final String VAR_ERROR = "VAR_ERROR";
    public static final String TASK_ERROR = "TASK_ERROR";
    public static final String INTERNAL_ERROR = "INTERNAL_ERROR";
    public static final Set<String> RESERVED_EXCEPTION_NAMES = new HashSet<>(
        Arrays.asList(
            CHILD_FAILURE,
            VAR_SUB_ERROR,
            VAR_MUTATION_ERROR,
            TASK_FAILURE,
            TIMEOUT,
            VAR_ERROR,
            TASK_ERROR,
            INTERNAL_ERROR
        )
    );

    public static final int DEFAULT_TASK_TIMEOUT_SECONDS = 15;

    public static final int DEFAULT_LIMIT = 1000;
    public static final int MIN_WORKER_ASSIGNMENT_BY_SERVER = 2;
    public static final long MAX_TASK_WORKER_INACTIVITY = 15L;

    public static final String CLUSTER_LEVEL_METRIC = "CLUSTER_LEVEL_METRIC";
}
// NOTE: Use m6a.4xlarge
