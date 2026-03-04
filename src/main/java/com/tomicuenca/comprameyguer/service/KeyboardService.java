package com.tomicuenca.comprameyguer.service;

import com.tomicuenca.comprameyguer.dto.KeyboardDTO;
import com.tomicuenca.comprameyguer.dto.input.KeyboardInputDTO;
import com.tomicuenca.comprameyguer.entity.KeyboardEntity;
import com.tomicuenca.comprameyguer.mapper.KeyboardMapper;
import com.tomicuenca.comprameyguer.repository.KeyboardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class KeyboardService {

    private final KeyboardRepository keyboardRepository;


    public KeyboardDTO getTestKeyboard(){
        try {
            Optional<KeyboardEntity> opt = keyboardRepository.findById(2L);
            if(opt.get() != null){
                return KeyboardMapper.entityToDTO(opt.get());
            }
        }catch (Exception e){
            log.error("An error ocurred trying to retrieve the test keyboard: " + e);
        }
        return null;
    }

    public String saveKeyboard(KeyboardInputDTO input){
        try{
            KeyboardEntity entity = KeyboardMapper.inputDTOToEntity(input);
            keyboardRepository.save(entity);
            return "Keyboard saved successfully";
        }catch (Exception e){
            log.error("An error ocurred saving the keyboard: " + e);
            return "An error ocurred saving the keyboard";
        }
    }
}
