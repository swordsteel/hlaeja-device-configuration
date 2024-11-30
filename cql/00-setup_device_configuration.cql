-- Create a keyspace
CREATE KEYSPACE IF NOT EXISTS device_configuration
    WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

-- Use the keyspace
USE device_configuration;
