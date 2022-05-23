package ucb.edu.arqsoft.msdashboard.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ucb.edu.arqsoft.msdashboard.service.ProductService;

@CrossOrigin("https://localhost:4200")
@RestController
@RequestMapping("/api/product")
public class ProductController {
    private ProductService productService;

}
