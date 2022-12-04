package pl.sda.j133.hibernate.fakturowanie.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Faktura {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String numerFaktury;
    @CreationTimestamp
    private LocalDate dataWystawienia;
    private LocalDate terminPlatnosci;
    private Double kwota;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Firma firma;
    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Kontrahent kontrahent;
    @OneToMany(mappedBy = "faktura")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Platnosc> platnosci;

}
