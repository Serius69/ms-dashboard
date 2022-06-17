package ucb.edu.arqsoft.msdashboard.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.arqsoft.msdashboard.dao.DasboardDao;
import ucb.edu.arqsoft.msdashboard.dto.DataStringDoubleDto;
import ucb.edu.arqsoft.msdashboard.dto.DataNumberDto;

import java.util.List;

@Service
public class DashboardBl {
    @Autowired
    DasboardDao dasboardDao;

    public DataNumberDto getProductsWithstock() {
        return dasboardDao.getProductsWithstock();
    }
    public DataNumberDto getProductsWithoutstock() {
        return dasboardDao.getProductsWithoutstock();
    }
    public List<DataStringDoubleDto> getProductsCategory() {
        return dasboardDao.getProductCategory();
    }
    public List<DataStringDoubleDto> getProductSells() {
        return dasboardDao.getProductSells();
    }
    public List<DataStringDoubleDto> getSellsbyMonth() {
        return dasboardDao.getSellsbyMonth();
    }





}
