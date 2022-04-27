package uz.pdp.homework1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import uz.pdp.homework1.entity.SimCard;
import uz.pdp.homework1.entity.USSDcode;
import uz.pdp.homework1.entity.User;
import uz.pdp.homework1.payload.ApiResponse;
import uz.pdp.homework1.repository.SimCardRepository;
import uz.pdp.homework1.repository.USSDCodeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class USSDCodeService {
    @Autowired
    USSDCodeRepository ussdCodeRepository;

    @Autowired
    SimCardRepository simCardRepository;

    public ApiResponse add(USSDcode ussdCodeDto) {
        boolean b = ussdCodeRepository.existsByCode(ussdCodeDto.getCode());
        if (b) {
            return new ApiResponse("this code is alredy  exists", false);
        }

        USSDcode ussdCode = new USSDcode();
        ussdCode.setCode(ussdCodeDto.getCode());
        ussdCode.setDescription(ussdCodeDto.getDescription());

        ussdCodeRepository.save(ussdCode);
        return new ApiResponse("Added", true);
    }

    public List<USSDcode> getAll() {
        return ussdCodeRepository.findAll();
    }

    public ApiResponse getByCode(int code) {
        Optional<USSDcode> byCode = ussdCodeRepository.findByCode(code);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Optional<SimCard> byOwner = simCardRepository.findByOwner(user);

        if (!byOwner.isPresent()){
            return new ApiResponse("not fount in this simcard", false);
        }

        if (!byCode.isPresent()){
            return new ApiResponse("This code is not found", false);
        }
        SimCard simCard = byOwner.get();

        switch (code){
            case 107:
                return new ApiResponse(true, "Your number"+simCard.getNumber()+" your sum: "+simCard.getSum());
            case 109:
                return new ApiResponse(true, "Your trafic"+simCard.getTrafic().getTrafficName()+" your sum: "+simCard.getTrafic().getTrafficSum());
            default:
                return new ApiResponse("code is not found",false);
        }
    }
}
