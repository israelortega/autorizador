package mx.unam.sa.autorizador;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;
import mx.unam.sa.autorizador.entities.Area;
import mx.unam.sa.autorizador.entities.AreaId;
import mx.unam.sa.autorizador.entities.Puesto;
import mx.unam.sa.autorizador.entities.Rol;
import mx.unam.sa.autorizador.entities.SistEstrategico;
import mx.unam.sa.autorizador.entities.Usuario;
import mx.unam.sa.autorizador.repository.AreaRepo;
import mx.unam.sa.autorizador.repository.PuestoRepo;
import mx.unam.sa.autorizador.repository.RolRepo;
import mx.unam.sa.autorizador.repository.SistEstrategicoRepo;
import mx.unam.sa.autorizador.repository.UsuarioRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AutorizadorApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutorizadorApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UsuarioRepo usuarioRepo,
            SistEstrategicoRepo sistEstrategicoRepo,
            RolRepo rolRepo,
            AreaRepo areaRepo,
            PuestoRepo puestoRepo
    ) {
        return (args) -> {
            usuarioRepo.save(new Usuario(10, "Juan", "Rodríguez", "Perez", "127.0.0.1", "808093"));
            usuarioRepo.save(new Usuario(20, "Jose", "Martínez", "González", "127.0.0.1", "808093"));

            SistEstrategico sistema1 = sistEstrategicoRepo.save(new SistEstrategico(1, "Sistema 1", "Sistema SA", "", new SimpleDateFormat("dd-MM-yyyy").parse("01-01-2020"), new SimpleDateFormat("dd-MM-yyyy").parse("31-12-2023"), "127.0.0.1", "808093"));
            sistEstrategicoRepo.save(new SistEstrategico(2, "Sistema 2", "Sistema de DGPe", "", null, null, "127.0.0.1", "808093"));
            sistEstrategicoRepo.save(new SistEstrategico("Sistema ?", "Sitema de Obras", "", null, null, "127.0.0.1", "808093"));

            rolRepo.save(new Rol(1, "usuario", "Usuario", "U", "127.0.0.1", "808093", sistema1));
            rolRepo.save(new Rol(2, "admin", "Administrador", "A", "127.0.0.1", "808093",  sistema1));
            rolRepo.save(new Rol(3, "lectura", "Solo tiene permisos de lectura", "L", "127.0.0.1", "808093", sistema1));

            Area areahum = areaRepo.save(new Area(new AreaId(211, 1, 1), (short) 7, "Coordinación y Consejo Técnico de Humanidades", "127.0.0.1", "808093"));
            areaRepo.save(new Area(new AreaId(211, 1, 2), (short) 7, "Casa Universitaria del Libro", "127.0.0.1", "808093"));
            Area areaPer = areaRepo.save(new Area(new AreaId(723, 1, 1), (short) 1, "Dirección General de Personal", "127.0.0.1", "808093"));
            areaRepo.save(new Area(new AreaId(723, 2, 1), (short) 1, "Dirección General de Relaciones Laborales", "127.0.0.1", "808093"));
            
            Set <Puesto> puestos = new HashSet();
            Puesto puestTit = new Puesto(areaPer, "Titular", "Clave para el Director", "T", null, null, "127.0.0.1", "808093");
            puestos.add(puestTit);
            Puesto puestSec = new Puesto(areaPer, "Secretario", "Clave para el Secretario o Jefe de Unidad", "S", new SimpleDateFormat("dd-MM-yyyy").parse("01-01-2023"), new SimpleDateFormat("dd-MM-yyyy").parse("31-12-2023"), "127.0.0.1", "808093");
            puestos.add(puestSec);
            Puesto puestFirma = new Puesto(areaPer, "Firmante", "Firma documentos", "O", new SimpleDateFormat("dd-MM-yyyy").parse("01-01-2023"), new SimpleDateFormat("dd-MM-yyyy").parse("31-12-2023"), "127.0.0.1", "808093");
            puestos.add(puestFirma);
            Puesto puestHum = new Puesto(areahum, "Titular", "Clave para el Director", "T", null, null, "127.0.0.1", "808093");
            puestos.add(puestHum);
            
            
            puestoRepo.saveAll(puestos);
            
            
        };
    }

}
