package com.ofud.ofud.estudiante;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ofud.ofud.email.EmailServiceImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ServicioEstudianteImpl implements ServicioEstudiante{
    private final EstudianteDAO dao;
    private final EmailServiceImpl emailSender;

    @Override
    public Estudiante findEstudianteById(Long id) {
        return dao.findById(id).orElseThrow();
    }

    @Override
    public List<Estudiante> findAllEstudiantes() {
        return dao.findAll();
    }

    @Override
    public Estudiante saveEstudiante(Estudiante e) {
        emailSender.sendSimpleMessage(e.getCorreoPersonal(), "Resgitro exitoso", "Se ha realizado su registro exitosamente! :)<3 ");
        System.out.println("Email enviado correctamente");
        
        return dao.save(e);
    }

}
