package ltd.hlaeja.util

import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import java.util.UUID
import ltd.hlaeja.entity.NodeEntity
import ltd.hlaeja.library.deviceConfiguration.Node

fun NodeEntity.toResponse(): Node.Response = Node.Response(
    node = id,
    timestamp = ZonedDateTime.ofInstant(timestamp, ZoneId.systemDefault()),
    configuration = configuration,
)

fun Node.Request.toEntity(node: UUID): NodeEntity = NodeEntity(
    id = node,
    timestamp = Instant.now(),
    configuration = configuration,
)
