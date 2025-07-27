-- Table: nodes
-- DROP TABLE IF EXISTS device_configuration.nodes;

CREATE TABLE IF NOT EXISTS device_configuration.nodes
(
    id            UUID PRIMARY KEY,
    timestamp     TIMESTAMP,
    configuration TEXT
);
