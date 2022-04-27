package uz.pdp.homework1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.homework1.entity.SimCard;
import uz.pdp.homework1.entity.Trafics;
import uz.pdp.homework1.payload.ApiResponse;
import uz.pdp.homework1.payload.Period;
import uz.pdp.homework1.payload.SimCardDto;
import uz.pdp.homework1.repository.SimCardRepository;
import uz.pdp.homework1.repository.TraficRepository;
import uz.pdp.homework1.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class SimCardService {
    @Autowired
    SimCardRepository simCardRepository;

    @Autowired
    TraficRepository traficRepository;

    @Autowired
    UserRepository userRepository;

    public ApiResponse add(SimCardDto simCardDto){
        boolean b = simCardRepository.existsByNumber(simCardDto.getNumber());
        if (b){
            return new ApiResponse("This nomer is already exists", false);
        }

        Optional<Trafics> byId = traficRepository.findById(simCardDto.getTrafic());
        if (!byId.isPresent()){
            return new ApiResponse("This trafic is not found",false);
        }

        SimCard simCard = new SimCard(simCardDto.getNumber(), userRepository.getOne(simCardDto.getOwner()), simCardDto.getSum(), simCardDto.getSimSum(), byId.get(), simCardDto.isActive());
        simCardRepository.save(simCard);
        return new ApiResponse("saved", true);
    }

    public ApiResponse getSalesReport(Period period){
        Set<SimCard> byCreatedAtBetween = simCardRepository.findByCreatedAtBetween(period.getStartTime(), period.getEndTime());
        if (byCreatedAtBetween.isEmpty())
            return new ApiResponse("Malumot topilmadi", false);


        Double summ = null;

        for (SimCard simCard : byCreatedAtBetween) {
            summ+=simCard.getSaleSum();
        }

        return new ApiResponse("All sum: "+ summ, true, byCreatedAtBetween);
    }
}
