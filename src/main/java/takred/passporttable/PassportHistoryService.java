package takred.passporttable;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassportHistoryService {
    private final PassportHistoryRepository passportHistoryRepository;
    private final PassportTableService passportTableService;

    public PassportHistoryService(PassportHistoryRepository passportHistoryRepository, PassportTableService passportTableService) {
        this.passportHistoryRepository = passportHistoryRepository;
        this.passportTableService = passportTableService;
    }


    public List<Passport> listOldNumberPass(Long numberPass) {
        List<Passport> allNumbersPass = new ArrayList<>(passportHistoryRepository.findAll());
        List<Passport> allPersonNumberPass = new ArrayList<>();
        Person person = passportTableService.getInfoPersonPerson(numberPass);
        for (int i = 0; i < allNumbersPass.size(); i++) {
            if (allNumbersPass.get(i).getGroupId().equals(person.getId())){
                allPersonNumberPass.add(allNumbersPass.get(i));
            }
        }
        return allPersonNumberPass;
    }

    public void setNewNumberPass(Long numberPass, NewPassportParameters newPassportParameters) {
        Person person = passportTableService.getInfoPersonPerson(numberPass);
        person.setNumberPass(newPassportParameters.getNewNumberPass());
        person.setDateIssue(newPassportParameters.getDateIssue());
        passportTableService.save(person);

        Passport passport = new Passport();
        passport.setNumberPass(newPassportParameters.getNewNumberPass());
        passport.setGroupId(person.getId());
        passport.setDateIssue(person.getDateIssue());
        passportHistoryRepository.save(passport);
    }
}
