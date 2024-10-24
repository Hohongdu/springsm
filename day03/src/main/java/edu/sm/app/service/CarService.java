package edu.sm.app.service;

import edu.sm.app.dto.CarDto;
import edu.sm.app.frame.SMService;
import edu.sm.app.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService implements SMService<Integer, CarDto> {

    final CarRepository carRepository;

    @Override
    public void add(CarDto value) throws Exception {
        carRepository.insert(value);
    }

    @Override
    public void modify(CarDto value) throws Exception {
        carRepository.update(value);
    }

    @Override
    public void del(Integer key) throws Exception {
        carRepository.delete(key);
    }

    @Override
    public CarDto get(Integer key) throws Exception {
        return carRepository.selectOne(key);
    }


    @Override
    public List<CarDto> get() throws Exception {
        return carRepository.select();
    }


    public List<CarDto> getAll() throws Exception {
        return carRepository.select(); // CarRepository에서 전체 차량을 조회하는 메서드를 호출합니다.
    }

    public List<CarDto> findByName(String name) throws Exception {
        return carRepository.findByName(name);
    }
}