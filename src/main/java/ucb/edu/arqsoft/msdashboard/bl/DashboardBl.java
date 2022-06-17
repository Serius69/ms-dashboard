package ucb.edu.arqsoft.msdashboard.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.arqsoft.msdashboard.dao.DasboardDao;
import ucb.edu.arqsoft.msdashboard.dto.DataStringDoubleDto;
import ucb.edu.arqsoft.msdashboard.dto.DataIntDto;
import ucb.edu.arqsoft.msdashboard.dto.DataStringIntDto;
import ucb.edu.arqsoft.msdashboard.dto.DataStringStringIntDto;

import java.util.List;

@Service
public class DashboardBl {
    @Autowired
    DasboardDao dasboardDao;

    public DataIntDto getProductsWithstock() {
        return dasboardDao.getProductsWithstock();
    }
    public DataIntDto getProductsWithoutstock() {
        return dasboardDao.getProductsWithoutstock();
    }
    public List<DataStringDoubleDto> getProductsCategory() {
        return dasboardDao.getProductCategory();
    }
    public List<DataStringIntDto> getProductSells() {
        return dasboardDao.getProductSells();
    }
    public List<DataStringDoubleDto> getSellsbyMonth() {
        return dasboardDao.getSellsbyMonth();
    }
    public List<DataStringStringIntDto> getQuantitySellsbyMonthCategory() {
        return dasboardDao.getQuantitySellsbyMonthCategory();
    }





}
