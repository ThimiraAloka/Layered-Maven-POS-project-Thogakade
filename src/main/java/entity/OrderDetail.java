package entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class OrderDetail {
    @Id
    private String orderId;
    private String itemCode;
    private int qty;
    private double unitPrice;
}
