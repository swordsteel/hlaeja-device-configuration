package ltd.hlaeja.controller

import java.util.UUID
import ltd.hlaeja.library.deviceConfiguration.Node
import ltd.hlaeja.service.NodeService
import ltd.hlaeja.util.toEntity
import ltd.hlaeja.util.toResponse
import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

private val log = KotlinLogging.logger {}

@RestController
class NodeController(
    private val service: NodeService,
) {

    @GetMapping("/node-{node}")
    fun getNodeConfiguration(
        @PathVariable node: UUID,
    ): Mono<Node.Response> = service.getConfiguration(node)
        .map { it.toResponse() }
        .also { log.debug("Endpoint getNodeConfiguration for node: {}", node) }

    @PutMapping("/node-{node}")
    fun updateNodeConfiguration(
        @PathVariable node: UUID,
        @RequestBody nodeRequest: Node.Request,
    ): Mono<Node.Response> = service.updateDevice(nodeRequest.toEntity(node))
        .map { it.toResponse() }
        .also { log.debug("Endpoint updateNodeConfiguration for node: {}", node) }
}
