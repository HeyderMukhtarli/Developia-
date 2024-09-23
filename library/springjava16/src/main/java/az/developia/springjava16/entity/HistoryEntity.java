package az.developia.springjava16.entity;

import az.developia.springjava16.enums.LibraryActivity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "history")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private Long bookId; // if applicable

    @Enumerated(EnumType.STRING)
    private LibraryActivity activity;
    private String note;
    private LocalDateTime timestamp;
}