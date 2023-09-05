package com.merge.fullio.service.mainInfo;

import com.merge.fullio.DTO.strength.SkillDTO;
import com.merge.fullio.DTO.strength.SkillRequest;
import com.merge.fullio.DTO.strength.StrengthDTO;
import com.merge.fullio.DTO.strength.StrengthRequest;
import com.merge.fullio.DTO.user.UserDTO;
import com.merge.fullio.exception.clienterror._400.BadRequestException;
import com.merge.fullio.exception.clienterror._400.EntityNotFoundException;
import com.merge.fullio.model.strength.Strength;
import com.merge.fullio.model.user.User;
import com.merge.fullio.repository.StrengthRepository;
import com.merge.fullio.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MainInfoService {
    private final UserRepository userRepository;
    private final StrengthRepository strengthRepository;

    public UserDTO getUserInfo(User user){
        User user1 = userRepository.findByUsername(user.getUsername());
        return new UserDTO(user1.getId(), user1.getUsername(), user1.getRealname(), user1.getNickName(), user1.getEmail(), user1.getPhoneNumber());
    }

    public StrengthDTO getStrengthInfo(User user){
        User user1 = userRepository.findByUsername(user.getUsername());
        Optional<Strength> strengthOptional = strengthRepository.findByCreatedBy(user1);
        Strength strength = strengthOptional.get();
        return new StrengthDTO(strength.getId(), strength.getStrength_1(), strength.getStrength_2(), strength.getStrength_3(), strength.getStrength_4(), strength.getStrength_5(), strength.getMotto());
    }

//    public SkillDTO getSkillInfo(User user){
//
//    }

    public void saveStrength(StrengthRequest strengthRequest, User user){
        Optional<Strength> strengthOptional = strengthRepository.findByCreatedBy(user);
        if(strengthOptional.isEmpty()){
            Strength strength = new Strength(strengthRequest.getStrength1(),strengthRequest.getStrength2(),strengthRequest.getStrength3(),strengthRequest.getStrength4(),strengthRequest.getStrength5());
            strengthRepository.save(strength);
        } else {
            Strength strength = strengthOptional.get();
            //TODO: update coding
        }
    }


    public void saveSkill(SkillRequest skillRequest, User user) {
        Optional<Strength> strengthOptional = strengthRepository.findByCreatedBy(user);
        if(strengthOptional.isPresent()){
//            Strength strength = strengthOptional.get();

        } else {
            int number = skillRequest.getNumber();
            if(number > 4 || number < 1) throw new BadRequestException();
            else {
                Strength strength = new Strength(number, skillRequest.getSkill());
                strengthRepository.save(strength);
            }
        }

    }
}
