package ucb.edu.arqsoft.msdashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ucb.edu.arqsoft.msdashboard.dao.ProductRepository;
import ucb.edu.arqsoft.msdashboard.service.ProductService;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/dashboard")
public class ProductController {
    private ProductService productService;
    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @RequestMapping(value="/prendassinstock", method = RequestMethod.GET)
    public ResponseEntity<Integer> getPrendasSinStock(){
        Integer a = 200;
        return new ResponseEntity<>(a, HttpStatus.OK);
    }
    @RequestMapping(value="/prendasconstock", method = RequestMethod.GET)
    public ResponseEntity<Integer> getPrendasConStock(){
        Integer a = productRepository.getPrendasConStock();
        return new ResponseEntity<>(a, HttpStatus.OK);
    }
    @RequestMapping(value="/prendasporcategoria", method = RequestMethod.GET)
    public ResponseEntity<List<Integer>> getPrendasPorCategoria(){
        List<Integer> a = productRepository.getPrendasPorCategoria();
        return new ResponseEntity<>(a, HttpStatus.OK);
    }
}
