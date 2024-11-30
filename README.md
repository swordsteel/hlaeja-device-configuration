# Hlæja Device Configuration

A vault of secrets, a treasure untold, Configurations gathered, both new and old. Each setting recorded, precise and secure, A map of intention, steadfast and pure. From thresholds to timings, and modes they require, Each value ignites the system’s fire. The Device Configuration, a beacon, a guide, Where every adjustment finds where to reside. In its care lies the key to deploy, The heart of the network, its balance, its joy. A treasure of purpose, its worth beyond measure, Device configurations, a system’s true treasure.

## Properties for deployment

| name                       | required | info                    |
|----------------------------|----------|-------------------------|
| spring.profiles.active     | *        | Spring Boot environment |
| cassandra.keyspace-name    |          |                         |
| cassandra.port             |          |                         |
| cassandra.schema-action    |          |                         |
| cassandra.local-datacenter |          |                         |
| cassandra.contact-points   | *        |                         |
| cassandra.username         | *        |                         |
| cassandra.password         | **       |                         |

Required: * can be stored as text, and ** need to be stored as secret.  

## Releasing Service

Run `release.sh` script from `master` branch.

## Development

### Global gradle properties

To authenticate with Gradle for services that require authentication, you can set your users and tokens in the `gradle.properties` file.

Here's how you can do it:

1. Open or create the `gradle.properties` file in your Gradle user home directory:
   - On Unix-like systems (Linux, macOS), this directory is typically `~/.gradle/`.
   - On Windows, this directory is typically `C:\Users\<YourUsername>\.gradle\`.
2. Add the following lines to the `gradle.properties` file:
   ```properties
   repository.user=your_user
   repository.token=your_token_value
   ```
   or use environment variables `REPOSITORY_USER`, and `REPOSITORY_TOKEN`
