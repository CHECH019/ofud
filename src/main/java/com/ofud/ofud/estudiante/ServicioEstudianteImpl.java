package com.ofud.ofud.estudiante;

import java.util.ArrayList;
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
    public Estudiante findEstudianteById(String id) {
        return dao.findById(id).orElseThrow();
    }

    @Override
    public List<Estudiante> findAllEstudiantes() {
        return dao.findAll();
    }

    @Override
    public Estudiante saveEstudiante(Estudiante e) {
        emailSender.sendSimpleMessage(e.getCorreo(), "Resgitro exitoso", "Se ha realizado su registro exitosamente! :)<3 ");
        System.out.println("Email enviado correctamente");
        
        return dao.save(e);
    }

    @Override
    public List<EstudianteDTO> seleccionarEstudiantes() {
        List<EstudianteDTO> estudiantesSeleccionados = new ArrayList<>();
        dao.seleccionEstudiantes().forEach(
            t-> {
                estudiantesSeleccionados.add(
                    new EstudianteDTO(t[0], t[1], t[2], t[3], t[4], t[5])
                );
                saveSeleccionado(t[0]);

        });
        return estudiantesSeleccionados;
    }

    @Override
    public void saveSeleccionado(String codEstudiante) {
        int obra = dao.findObraIdByPeriodo("202301");
        int consec = dao.findCalendarioByObra(obra+"");
        dao.saveParticipacionEstudiante(obra+"", consec+"", codEstudiante);
        dao.setSeleccionInactiva(obra+"");
    }
    
    
}
