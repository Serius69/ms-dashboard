package ucb.edu.arqsoft.msdashboard.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ucb.edu.arqsoft.msdashboard.bl.DashboardBl;
import ucb.edu.arqsoft.msdashboard.dto.ResponseDto;

import javax.sql.DataSource;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DashboardController {
    @Autowired
    public DataSource dataSource;
    @Autowired
    private DashboardBl dashboardBl;


    @GetMapping(path = "/donador")
    public ResponseDto findAllDonadores() {
        return new ResponseDto( true, dashboardBl.findAllDonadores(), "Listado de todos los donadores");
    }

}
