package com.documents.services.domain;

public enum DocumentStatus {
    NONE,
    ANNOTATING,
    CERTIFIED,
    FINALIZED,
    SIGNING_IN_PROGRESS,
    PENDING_FINALIZATION,
    ERROR_FINALIZATION,
    READY_TO_SIGN,
    RECORDED,
    UPLOADED,
    WET_SIGNED,
    CANCELED,
    READY_FOR_PRE_MEETING_QC
}
