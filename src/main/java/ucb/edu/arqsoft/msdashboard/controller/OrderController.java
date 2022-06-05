package ucb.edu.arqsoft.msdashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ucb.edu.arqsoft.msdashboard.dao.OrderRepository;
import ucb.edu.arqsoft.msdashboard.dao.ProductRepository;
import ucb.edu.arqsoft.msdashboard.service.ProductService;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/order")
public class OrderController {

    private OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @RequestMapping(value="/prendasmes", method = RequestMethod.GET)
    public ResponseEntity<Integer> getPrendasMes(){
        //Integer a = orderRepository.getPrendasMes();
        return new ResponseEntity<>(13, HttpStatus.OK);
    }

    @RequestMapping(value="/prendasmescategoria", method = RequestMethod.GET)
    public ResponseEntity<Integer> getPrendasMesCategoria(){
        // a = orderRepository.getPrendasMesCategoria();
        return new ResponseEntity<>(14, HttpStatus.OK);
    }

    @RequestMapping(value="/ordenesmes", method = RequestMethod.GET)
    public ResponseEntity<Integer> getOrdenesMes(){
        //Integer a = orderRepository.getOrdenesMes();
        return new ResponseEntity<>(15, HttpStatus.OK);
    }

    @RequestMapping(value="/montomes", method = RequestMethod.GET)
    public ResponseEntity<Float> getMontoMes(){
        //Float a = orderRepository.getMontoMes();
        return new ResponseEntity<>(16.0f, HttpStatus.OK);
    }

    @RequestMapping(value="/cantidadprendasmes", method = RequestMethod.GET)
    public ResponseEntity<Integer> getCantidadPrendasMes(){
        //Integer a = orderRepository.getCantidadPrendasMes();
        return new ResponseEntity<>(17, HttpStatus.OK);
    }


}
