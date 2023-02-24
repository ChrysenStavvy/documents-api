CREATE TABLE IF NOT EXISTS documents
(
    id                     integer                                                            not null primary key,
    meeting_id             integer,
    document_name          text                                                               not null,
    description            varchar(300),
    created_at             timestamp    default CURRENT_TIMESTAMP                             not null,
    uploading_party        varchar(100)                                                       not null,
    upload_confirmed       boolean      default false,
    status                 varchar(100)                                                       not null,
    parent_document_id     integer,
    signing_type           varchar(128)                                                       not null,
    document_type          varchar(120)                                                       not null,
    pdf_metadata           jsonb,
    meeting_document_guid  uuid,
    file_document_id       integer,
    source_document_id     integer,
    packet_id              integer,
    mime_type              varchar(256) default NULL::character varying,
    s3_key                 varchar(100)                                                       not null,
    s3_bucket              varchar(100)                                                       not null,
    has_notary_annotations boolean      default false                                         not null
);

alter table documents
    owner to test;
