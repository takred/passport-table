package takred.passporttable;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class PassportHistoryController {
    private final PassportHistoryService passportHistoryService;

    public PassportHistoryController(PassportHistoryService passportHistoryService) {
        this.passportHistoryService = passportHistoryService;
    }

    @PostMapping(value = "all_number_pass/{numberPass}")
    public List<Passport> listOldNumberPass(@PathVariable("numberPass") Long numberPass) {
        return passportHistoryService.listOldNumberPass(numberPass);
    }

    @PostMapping(value = "set_new_number_pass/{numberPass}")
    public void setNewNumberPass(@PathVariable("numberPass") Long numberPass,
                                 @RequestBody NewPassportParameters newPassportParameters) {
        passportHistoryService.setNewNumberPass(numberPass, newPassportParameters);
    }
}
