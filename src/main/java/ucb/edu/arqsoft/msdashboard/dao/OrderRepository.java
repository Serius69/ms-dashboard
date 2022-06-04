package ucb.edu.arqsoft.msdashboard.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ucb.edu.arqsoft.msdashboard.entity.*;

@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order, Long> {

    Page<Order> findByCustomerEmailOrderByDateCreatedDesc(@Param("email") String email, Pageable pageable);

    //ordenes por mes
    @Query(value="select count(*) from orders GROUP BY YEAR(date_created), MONTH(date_created)",nativeQuery = true)
    public Integer getOrdenesMes();

    //prendas vendidas por mes
    @Query(value="select sum(total_quantity) from orders GROUP BY YEAR(date_created), MONTH(date_created)",nativeQuery = true)
    public Integer getPrendasMes();

    //prendas vendidas por mes y categoria
    @Query(value="select pc.category_name, sum(total_quantity) from orders as o JOIN order_item  as oi JOIN product as p JOIN product_category as pc " +
            "WHERE pc.id = p.category_id and p.id = oi.product_id AND o.order_tracking_number=oi.id\n" +
            "GROUP BY pc.category_name",nativeQuery = true)
    public Integer getPrendasMesCategoria();

    //monto de ventas por mes
    @Query(value="select sum(total_price) from orders GROUP BY YEAR(date_created), MONTH(date_created)",nativeQuery = true)
    public Float getMontoMes();

    //cantidad de ventas por cada prenda (ordenado)
    @Query(value="select sum(quantity) from order_item group by (product_id) order by sum(quantity)",nativeQuery = true)
    public Integer getCantidadPrendasMes();
}
