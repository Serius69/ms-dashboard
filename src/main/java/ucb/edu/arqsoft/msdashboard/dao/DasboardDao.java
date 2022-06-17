package ucb.edu.arqsoft.msdashboard.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.arqsoft.msdashboard.bl.DashboardBl;
import ucb.edu.arqsoft.msdashboard.dto.DataStringDoubleDto;
import ucb.edu.arqsoft.msdashboard.dto.DataNumberDto;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class DasboardDao {

    @Autowired
    private DataSource dataSource;
    private DashboardBl dashboardBl;
    //Retornar todos los productos sin stock
    public DataNumberDto getProductsWithoutstock() {

        DataNumberDto result = new DataNumberDto();
        try(
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(
                        " select count(*) from product where units_in_stock = 0" )
        )
        {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result.setQuantity(rs.getDouble("count(*)"));
                } else { // si no hay valores de BBDD
                result.setQuantity(0);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    //Retornar los productos con stock
    public DataNumberDto getProductsWithstock() {
        DataNumberDto result = new DataNumberDto();
        try(
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(
                        " select count(*)  from product where units_in_stock > 0" )
        )
        {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result.setQuantity(rs.getInt("count(*)"));

            } else { // si no hay valores de BBDD
                result.setQuantity(0);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    //Obtener la cantidad de prendas por categoria
    public List<DataStringDoubleDto> getProductCategory() {
        List<DataStringDoubleDto> result = new ArrayList<>();
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(
      " select b.category_name, count(*) from product as a join product_category as b where a.category_id = b.id group by b.id" )
        ) {
            ResultSet rs = pstmt.executeQuery();
//            if (rs.next()) {
                while (rs.next()) {
                    DataStringDoubleDto data = new DataStringDoubleDto();
                    data.setCategory(rs.getString("b.category_name"));
                    data.setQuentity(rs.getDouble("count(*)"));
                    result.add(data);
                }
//            } else { // si no hay valores de BBDD
//                data.setCategory(null);
//                data.setQuentity(0.0);
//                result.add(data);
//            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    //prendas vendidas por mes por categoria
    public List<DataStringDoubleDto> getProductSells() {
        List<DataStringDoubleDto> result = new ArrayList<>();
        try(
                Connection conn = dataSource.getConnection();
                //arreglar query
                PreparedStatement pstmt = conn.prepareStatement(
                        " select b.category_name, count(*) from product as a join product_category as b where a.category_id = b.id group by b.id" )
        )
        {
            ResultSet rs = pstmt.executeQuery();
//            if (rs.next()) {
            while (rs.next()) {
                DataStringDoubleDto data = new DataStringDoubleDto();
                data.setCategory(rs.getString("b.category_name"));
                data.setQuentity(rs.getDouble("count(*)"));
                result.add(data);
            }
//            } else { // si no hay valores de BBDD
//                result.setCategory(null);
//                result.setQuentity(0.0);
//            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    // monto de ventas por mes
    public List<DataStringDoubleDto> getSellsbyMonth() {
        List<DataStringDoubleDto> result = new ArrayList<>();
        try(
                Connection conn = dataSource.getConnection();
                //arreglar query
                PreparedStatement pstmt = conn.prepareStatement(
                        " select MONTHNAME(date_created) ,sum(total_price) from orders " +
                                "GROUP BY YEAR(date_created), MONTH(date_created)" )
        )
        {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                DataStringDoubleDto data = new DataStringDoubleDto();
                data.setCategory(rs.getString("MONTHNAME(date_created)"));
                data.setQuentity(rs.getDouble("sum(total_price)"));
                result.add(data);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
