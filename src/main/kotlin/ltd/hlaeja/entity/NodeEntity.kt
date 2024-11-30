package ltd.hlaeja.entity

import java.time.Instant
import java.util.UUID
import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table

@Table("nodes")
data class NodeEntity(
    @PrimaryKey
    val id: UUID,
    val timestamp: Instant,
    val configuration: String,
)
