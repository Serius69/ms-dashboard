package ucb.edu.arqsoft.msdashboard.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;
import ucb.edu.arqsoft.msdashboard.entity.*;

import java.util.List;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);

    Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);

    //prendas sin stock
    @Query(value="select count(*) from product where units_in_stock = 0",nativeQuery = true)
    public Integer getPrendasSinStock();

    //prendas con stock
    @Query(value="select count(*) from product where units_in_stock > 0",nativeQuery = true)
    public Integer getPrendasConStock();

    //prendas por categoria
    @Query(value="    select b.category_name, count(*) from product as a join product_category as b\n" +
            "    where a.category_id = b.id\n" +
            "    group by b.id ",nativeQuery = true)
    public List<Integer> getPrendasPorCategoria();

}
