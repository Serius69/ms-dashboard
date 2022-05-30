## prendas sin stock
select count(*) from product where units_in_stock = 0;
## prendas con stock
select count(*) from product where units_in_stock > 0;

## prendas por categoria
select b.category_name, count(*) from product as a join product_category as b
where a.category_id = b.id
group by b.id ;

##num de compras por mes
select count(*) from orders GROUP BY YEAR(date_created), MONTH(date_created);

##cantidad de prendas vendidas por mes
select sum(total_quantity) from orders GROUP BY YEAR(date_created), MONTH(date_created);

##monto de ventas por mes
select sum(total_price) from orders GROUP BY YEAR(date_created), MONTH(date_created);

##cantidad de ventas por prenda ordenadas
select sum(quantity) from order_item group by (product_id) order by sum(quantity);