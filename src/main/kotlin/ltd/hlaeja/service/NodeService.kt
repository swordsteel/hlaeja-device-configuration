package ltd.hlaeja.service

import io.github.oshai.kotlinlogging.KotlinLogging
import java.util.UUID
import ltd.hlaeja.entity.NodeEntity
import ltd.hlaeja.repository.NodeRepository
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Mono

private val log = KotlinLogging.logger {}

@Service
class NodeService(
    private val repository: NodeRepository,
) {
    fun getConfiguration(
        node: UUID,
    ): Mono<NodeEntity> = repository.findById(node)
        .switchIfEmpty(deviceNotFound(node))

    fun updateDevice(
        nodeEntity: NodeEntity,
    ): Mono<NodeEntity> = repository.save(nodeEntity)

    private fun deviceNotFound(
        node: UUID,
    ): Mono<NodeEntity> = Mono.error(
        ResponseStatusException(NOT_FOUND, "Node: $node do not exists".also { log.info { it } }),
    )
}
