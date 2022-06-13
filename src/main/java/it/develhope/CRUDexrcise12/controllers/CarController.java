package it.develhope.CRUDexrcise12.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.develhope.CRUDexrcise12.entities.Car;
import it.develhope.CRUDexrcise12.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping("")
    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public Car getSingleCar(@PathVariable long id){
        if (carRepository.existsById(id)) {
            return carRepository.findById(id).get();
        }else return new Car();
    }

    @PostMapping("")
    public Car createCar(@RequestBody Car car){
        return carRepository.saveAndFlush(car);
    }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable long id, @RequestParam String typeOfCar){
        Car car;
        if(carRepository.existsById(id)){
            car = carRepository.findById(id).get();
            car.setType(typeOfCar);
            car = carRepository.saveAndFlush(car);
        }else{
            car = new Car();
    }return car;
}
    @DeleteMapping("/{id}")
    public void deleteSingleCar (@PathVariable long id, HttpServletResponse httpServletResponse){
       if (carRepository.existsById(id))
           carRepository.deleteById(id);
       else
           httpServletResponse.setStatus(409);

    }
    @DeleteMapping("")
    public void deleteAll(){
        carRepository.deleteAll();
    }


}
