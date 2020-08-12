package sqa.springopencartproductservice.model.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import sqa.springopencart.customerservice.model.Entity.Customer;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId", nullable = false)
    private Integer orderId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order", fetch = FetchType.LAZY)
    private Set<OrderDetail> orderDetails;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @Column(name = "status")
    private String status;

    @Column(name = "orderDate")
    @DateTimeFormat(pattern = "mm/dd/yyyy")
    private String orderDate;

    @Column(name = "requiredDate")
    @DateTimeFormat(pattern = "mm/dd/yyyy")
    private String requiredDate;

    @Column(name = "shippedDate")
    @DateTimeFormat(pattern = "mm/dd/yyyy")
    private String shippedDate;
}
