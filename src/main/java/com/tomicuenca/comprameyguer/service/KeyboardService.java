package com.tomicuenca.comprameyguer.service;

import com.tomicuenca.comprameyguer.dto.KeyboardDTO;
import com.tomicuenca.comprameyguer.dto.input.KeyboardInputDTO;
import com.tomicuenca.comprameyguer.entity.KeyboardEntity;
import com.tomicuenca.comprameyguer.entity.PeripheralEntity;
import com.tomicuenca.comprameyguer.mapper.KeyboardMapper;
import com.tomicuenca.comprameyguer.repository.KeyboardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class KeyboardService {

    private final KeyboardRepository keyboardRepository;


    public KeyboardDTO getKeyboard(Long id){
        try {
            Optional<KeyboardEntity> opt = keyboardRepository.findById(id);
            if(opt.get() != null){
                return KeyboardMapper.entityToDTO(opt.get());
            }
        }catch (Exception e){
            log.error("An error ocurred trying to retrieve the keyboard: " + e);
        }
        return null;
    }

    public List<String> getAllKeyboardModels(){
        try{
            List<KeyboardEntity> keyboardList = keyboardRepository.findAll();
            return keyboardList.stream().map(PeripheralEntity::getModel).toList();
        }catch (Exception e){
            log.error("An error ocurred trying to retrieve the keyboards: " + e);
            return List.of("An error ocurred trying to retrieve the keyboards");
        }
    }

    public String saveKeyboard(KeyboardInputDTO input){
        try{
            KeyboardEntity entity = KeyboardMapper.inputDTOToEntity(input);
            keyboardRepository.save(entity);
            return "Keyboard saved successfully";
        }catch (Exception e){
            log.error("An error ocurred trying to save the keyboard: " + e);
            return "An error ocurred trying to save the keyboard";
        }
    }

    public String sellKeyboard(Long id){
        try {
            Optional<KeyboardEntity> opt = keyboardRepository.findById(id);
            if(opt.get() != null){
                KeyboardEntity entity = opt.get();
                if(entity.getStock() > 0) {
                    entity.setStock(entity.getStock() - 1);
                    keyboardRepository.save(entity);
                    return String.format("Keyboard sold successfully. New stock: %s", entity.getStock());
                }
                else{
                    return "This keyboard is out of stock";
                }
            }
        }catch (Exception e){
            log.error("An error ocurred trying to sell the keyboard: " + e);
        }
        return "An error ocurred trying to sell the keyboard";
    }

}
