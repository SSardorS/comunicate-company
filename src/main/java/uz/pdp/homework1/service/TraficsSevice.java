package uz.pdp.homework1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.homework1.entity.Trafics;
import uz.pdp.homework1.entity.User;
import uz.pdp.homework1.payload.ApiResponse;
import uz.pdp.homework1.payload.TraficDto;
import uz.pdp.homework1.repository.TraficRepository;
import uz.pdp.homework1.repository.UserRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TraficsSevice {

    @Autowired
    TraficRepository traficRepository;

    @Autowired
    UserRepository userRepository;


    public ApiResponse add(TraficDto traficDto) {

        boolean b = traficRepository.existsByTrafficName(traficDto.getTrafficName());
        if (b){
            return new ApiResponse("Trafiv c nmae is already exists", false);
        }

        Trafics trafics = new Trafics(traficDto.getTrafficName(), traficDto.getTrafficSum(), traficDto.getTrafficNds(), traficDto.getDescription());
        traficRepository.save(trafics);

        return new ApiResponse("Add", true);



    }
}
