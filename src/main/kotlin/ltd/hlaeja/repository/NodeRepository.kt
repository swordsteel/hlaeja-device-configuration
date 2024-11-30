package ltd.hlaeja.repository

import java.util.UUID
import ltd.hlaeja.entity.NodeEntity
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository
import org.springframework.stereotype.Repository

@Repository
interface NodeRepository : ReactiveCassandraRepository<NodeEntity, UUID>
