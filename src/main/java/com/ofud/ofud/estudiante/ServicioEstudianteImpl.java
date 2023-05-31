package com.ofud.ofud.estudiante;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return mapearQueryResulttoDTO(dao.seleccionEstudiantes());
    }

    @Override
    public void saveSeleccionado(String codEstudiante) {
        int obra = dao.findObraIdByPeriodo("202301");
        int consec = dao.findCalendarioByObra(obra+"");
        dao.saveParticipacionEstudiante(obra+"", consec+"", codEstudiante);
        dao.setSeleccionInactiva(obra+"");
    }

    @Override
    public List<EstudianteDTO> findSeleccionados(){
        return mapearQueryResulttoDTO(dao.findSeleccionados());
    }
    
    private List<EstudianteDTO> mapearQueryResulttoDTO(List<String[]> estudiantes){
        List<EstudianteDTO> estudiantesDTO = new ArrayList<>();
        estudiantes.forEach(
            t-> {
                estudiantesDTO.add(
                    new EstudianteDTO(t[0], t[1], t[2], t[3], t[4], t[5])
                );
                saveSeleccionado(t[0]);

        });
        return estudiantesDTO;
    }

    @Override
    public void marcarAsistencia(String idObra, String consec, List<String> codsEstudiante) {
        codsEstudiante.forEach(t->dao.asistencia(t, idObra, consec));
    }


    @Override
    public void sendMailElectivas() {
        String subject = "Electiva cursada en el grupo sinfonica UD - Periodo 202301";
        // t[0] //codigo
            // t[1] //nombre
            // t[2] //apelido
            // t[3] //facultad
            // t[4] // horas
            // t[5] // horas
            // t[6] //correo
        dao.estudianteElectivas().forEach(t->{
            String body = "Se informa al proyecto curricular "
                +t[3]+" que el estudiante "+t[1]+" "
                +t[2]+" con codigo "+t[0]+
                " cursó con un total de "+t[4]
                +" horas de"+t[5]+" horas necesarias de la electiva participación sinfonicaUD durante el período 202301";    
            
            emailSender.sendSimpleMessage(t[6], subject, body);
        });
    }

    @Override
    public Map<String, String> generarListaHorasTotales() {
        Map<String,String> estudiantes = new HashMap<>();
        dao.viaticos().forEach(t->{
            estudiantes.put("codigo", t[0]);
            estudiantes.put("nombre", t[1]);
            estudiantes.put("apellido", t[2]);
            estudiantes.put("horas_totales", t[3]);
            estudiantes.put("horas_necesarias", t[4]);
        });
        return estudiantes;
    }
}
