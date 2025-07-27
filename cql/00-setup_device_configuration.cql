-- Role: role_administrator
-- DROP ROLE role_administrator;
CREATE ROLE role_administrator WITH LOGIN = false AND SUPERUSER = false;


-- Role: role_service
-- DROP ROLE role_service;
CREATE ROLE role_service WITH LOGIN = false AND SUPERUSER = false;


-- Role: role_maintainer
-- DROP ROLE role_maintainer;
CREATE ROLE role_maintainer WITH LOGIN = false AND SUPERUSER = false;


-- Role: role_support
-- DROP ROLE role_support;
CREATE ROLE role_support WITH LOGIN = false AND SUPERUSER = false;


-- Owner administrator
-- DROP ROLE administrator;
CREATE ROLE administrator WITH PASSWORD = 'password' AND LOGIN = true;
GRANT role_administrator TO administrator;


-- Owner service
-- DROP ROLE service;
CREATE ROLE service WITH PASSWORD = 'password' AND LOGIN = true;
GRANT role_service TO service;


-- Owner maintainer
-- DROP ROLE maintainer;
CREATE ROLE maintainer WITH PASSWORD = 'password' AND LOGIN = true;
GRANT role_maintainer TO maintainer;


-- Owner support
-- DROP ROLE support;
CREATE ROLE support WITH PASSWORD = 'password' AND LOGIN = true;
GRANT role_support TO support;


-- Keyspace
-- DROP KEYSPACE device_configuration;
CREATE KEYSPACE device_configuration
    WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1}
     AND durable_writes = true;


-- Revoke all permissions from existing roles
-- REVOKE ALL PERMISSIONS ON KEYSPACE device_configuration FROM role_administrator;
-- REVOKE ALL PERMISSIONS ON KEYSPACE device_configuration FROM role_service;
-- REVOKE ALL PERMISSIONS ON KEYSPACE device_configuration FROM role_maintainer;
-- REVOKE ALL PERMISSIONS ON KEYSPACE device_configuration FROM role_support;


-- Grant permissions
GRANT ALL PERMISSIONS ON KEYSPACE device_configuration TO role_administrator;
GRANT SELECT, MODIFY ON KEYSPACE device_configuration TO role_service;
GRANT SELECT, MODIFY ON KEYSPACE device_configuration TO role_maintainer;
GRANT SELECT ON KEYSPACE device_configuration TO role_support;
