package pe.edu.i202221222.t2_pomacaja_josue.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rentalId;
    private Date rentalDate;
    private Integer customerId;
    private Date returnDate;
    private Integer staffId;
    private Timestamp lastUpdate;

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventoryId;

}
