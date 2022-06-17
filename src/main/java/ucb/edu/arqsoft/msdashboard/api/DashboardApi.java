package ucb.edu.arqsoft.msdashboard.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucb.edu.arqsoft.msdashboard.bl.DashboardBl;
import ucb.edu.arqsoft.msdashboard.dto.DataStringDoubleDto;
import ucb.edu.arqsoft.msdashboard.dto.DataNumberDto;
import ucb.edu.arqsoft.msdashboard.dto.DataStringIntDto;
import ucb.edu.arqsoft.msdashboard.dto.DataStringStringIntDto;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "https://localhost:4200")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardApi {

    @Autowired
    public DataSource dataSource;
    @Autowired
    private DashboardBl dashboardBl;

    @GetMapping(path = "/productsinstock")
    public DataNumberDto getProductWithoutStock() {
        DataNumberDto data = dashboardBl.getProductsWithoutstock();
        return data;
    }

    @GetMapping(path = "/productconstock")
    public DataNumberDto getProductWithStock() {
        DataNumberDto data = dashboardBl.getProductsWithstock();
        return data;
    }

    @GetMapping(path = "/productbycategory")
    public List<DataStringDoubleDto> getProductsCategory() {
        List<DataStringDoubleDto> dashboard = new ArrayList<>();
        dashboard= dashboardBl.getProductsCategory();
        return dashboard;
    }

    @GetMapping(path = "/productsells")
    public List<DataStringIntDto> getProductSells() {
        List<DataStringIntDto> dashboard = dashboardBl.getProductSells();
        return dashboard;
    }

    @GetMapping(path = "/moneysellsbymonth")
    public List<DataStringDoubleDto> getSellsbyMonth() {
        List<DataStringDoubleDto> dashboard = dashboardBl.getSellsbyMonth();
        return dashboard;
    }

    @GetMapping(path = "/productsellsbycategoryandmonth")
    public List<DataStringStringIntDto> getQuantitySellsbyMonthCategory() {
        List<DataStringStringIntDto> dashboard = dashboardBl.getQuantitySellsbyMonthCategory();
        return dashboard;
    }


}
