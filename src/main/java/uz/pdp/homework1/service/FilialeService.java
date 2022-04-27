package uz.pdp.homework1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.homework1.entity.Filiale;
import uz.pdp.homework1.entity.User;
import uz.pdp.homework1.payload.ApiResponse;
import uz.pdp.homework1.payload.FilialeDto;
import uz.pdp.homework1.repository.FilialeRepository;
import uz.pdp.homework1.repository.UserRepository;


import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class FilialeService {

    @Autowired
    FilialeRepository filialeRepository;

    @Autowired
    UserRepository userRepository;


    public ApiResponse add(FilialeDto filialeDto) {

        boolean b = filialeRepository.existsByFiliale(filialeDto.getFiliale());

        Set<User> users = new HashSet<>();

        for (Long aLong : filialeDto.getUserId()) {
            Optional<User> byId = userRepository.findById(aLong);
            if (byId.isPresent()){
                users.add(byId.get());
            }else {
                return new ApiResponse("user is not found", false);
            }
        }


        if (b) {
            return new ApiResponse("filiale is alreadu exists", false);
        }

        Filiale filiale = new Filiale(filialeDto.getFiliale(), users);
        filialeRepository.save(filiale);
        return new ApiResponse("Saved", true);


    }
}
