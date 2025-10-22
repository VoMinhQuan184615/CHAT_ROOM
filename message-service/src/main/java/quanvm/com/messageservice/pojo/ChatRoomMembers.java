package quanvm.com.messageservice.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoomMembers {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "chat_room_id")
    private ChatRooms chatRooms;

    private UUID userId; // Lấy từ User Service

    private Instant joinedAt = Instant.now();

}
