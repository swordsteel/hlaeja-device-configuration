-- Create a table
CREATE TABLE IF NOT EXISTS device_configuration.nodes
(
    id            UUID PRIMARY KEY,
    timestamp     TIMESTAMP,
    configuration TEXT
);
