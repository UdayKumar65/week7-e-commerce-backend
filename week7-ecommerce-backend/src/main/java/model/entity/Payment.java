 package model.entity;

import enums.OrderStatus;
import enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Order order;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

	public void setOrder(jakarta.persistence.criteria.Order order2) {
		// TODO Auto-generated method stub
	}

	public void setStatus(PaymentStatus success) {
		// TODO Auto-generated method stub
		
	}

	public void setStatus(OrderStatus paid) {
		// TODO Auto-generated method stub
		
	}
}