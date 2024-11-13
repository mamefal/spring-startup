package com.exo1.exo1.service;

import com.exo1.exo1.dto.UserDto;
import com.exo1.exo1.entity.User;
import com.exo1.exo1.mapper.UserMapper;
import com.exo1.exo1.repository.ProjetRepository;
import com.exo1.exo1.repository.TaskRepository;
import com.exo1.exo1.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private TaskRepository taskRepository;
    private ProjetRepository projetRepository;
    private UserMapper userMapper;
    
    public List<UserDto> findAll(int page, int size) {
        return userMapper.toDtos(userRepository.findAll());
    }

    public UserDto findById(long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new EmptyResultDataAccessException("User not found with id " + id, 1));
        return userMapper.toDto(user);
    }


    public UserDto save(UserDto userDto) {
        User user = userMapper.toEntity(userDto);

        user.getProjets().forEach(projet ->
                projet.getTasks().forEach(task -> task.setProjet(projet)));

        return userMapper.toDto(userRepository.save(user));
    }


    public UserDto update(Long id, UserDto userDto) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException("User not found with id " + id, 1));

        userDto.setId(existingUser.getId());
        User userUpdated = userMapper.toEntity(userDto);


        userUpdated.getProjets().forEach(projet -> {
            if (projetRepository.existsById(projet.getId())) {
                projet.setUsers(new HashSet<>(Collections.singleton(userUpdated)));
                projet.getTasks().forEach(task -> {
                    if (taskRepository.existsById(task.getId())) {
                        task.setProjet(projet);
                    }
                });
            }
        });

        return userMapper.toDto(userRepository.save(userUpdated));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
