package ob.proyecto.validacion.controller;

import ob.proyecto.validacion.dto.OnboardingDto;
import ob.proyecto.validacion.services.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/onboarding")
public class OnboardingController {

    private final UserServiceImpl userService;

    public OnboardingController(UserServiceImpl userService){
        this.userService = userService;
    }

    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("/dni")
    public ResponseEntity<?> addPhotosAndPhone(@RequestBody OnboardingDto onboardingDto){

        return userService.addPhotosAndPhone(onboardingDto);
    }
}