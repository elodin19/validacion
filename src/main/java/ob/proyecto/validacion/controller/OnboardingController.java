package ob.proyecto.validacion.controller;

import ob.proyecto.validacion.dto.OnboardingRequestDto;
import ob.proyecto.validacion.services.user.UserServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador del proceso Onboarding, en el que el usuario añade dos fotografías de su documento de identidad
 * y se guardarán en un servicio de alojamiento en la nube, para su posterior validación.
 */
@RestController
@RequestMapping("/api/onboarding")
public class OnboardingController {

    private final UserServiceImpl userService;

    public OnboardingController(UserServiceImpl userService){
        this.userService = userService;
    }

    /**
     * Método que actualiza un usuario en con el número de teléfono y el enlace a la url de las dos imágenes
     * @param onboardingRequestDto La información para actualizar.
     * @return El Usuario actualizado y un mensaje de texto.
     */
    /*
    TODO: descomentar la linea de codigo despues de las pruebas
    @PreAuthorize("hasAuthority('USER')")
     */
    @RequestMapping(value = "/photos/{username}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> addPhotos(@PathVariable String username, OnboardingRequestDto onboardingRequestDto){

        return userService.addPhotos(username,onboardingRequestDto);
    }

    /**
     * Método que lista un usuario de la base de datos.
     * @param username Nombre de usuario del usuario a listar.
     * @return Usuario solicitado.
     */
    /*
    TODO: descomentar la linea de codigo despues de las pruebas
    @PreAuthorize("hasAuthority('USER')")
     */
    @GetMapping("/users/{username}")
    public ResponseEntity<?>  getUser(@PathVariable String username){
        return userService.getUserByUsername(username);
    }
}
