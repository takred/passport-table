package takred.passporttable;

//import org.graalvm.compiler.lir.alloc.lsra.LinearScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class PassportTableController {
    private final PassportTableService passportTableService;

    public PassportTableController(PassportTableService passportTableService) {
        this.passportTableService = passportTableService;
    }

    @RequestMapping(value = "register_new_person/{name}_{surname}_{patronymic}_{gender}_{age}_{numberPass}")
    public void registerNewPerson(@PathVariable("name") String name,@PathVariable("surname") String surname,
                                  @PathVariable("patronymic") String patronymic,@PathVariable("gender") Gender gender,
                                  @PathVariable("age") int age,@PathVariable("numberPass") Long numberPass) {
        passportTableService.registerNewPerson(name, surname, patronymic, gender, age, numberPass);
    }

    @PostMapping(value = "register_new_person_post")
    public void registerNewPersonPost(@RequestBody Person person){
        passportTableService.registerNewPerson(person);
    }

    @RequestMapping(value = "correction_full_name/{numberPass}/{fullName}")
    public String correctionFullName(@PathVariable("numberPass") Long numberPuss, @PathVariable("fullName") String fullName){
        return passportTableService.correctionFullName(numberPuss, fullName);
    }

    @RequestMapping(value = "info_person/{numberPass}")
    public String getInfoPerson(@PathVariable("numberPass") Long numberPass) {
        return passportTableService.getInfoPerson(numberPass);
    }

    @RequestMapping(value = "info_person_person/{numberPass}")
    public Person getInfoPersonPerson(@PathVariable("numberPass") Long numberPass) {
        return passportTableService.getInfoPersonPerson(numberPass);
    }

    @PostMapping(value = "search_by_name/{name}")
    public List<Person> searchByName(@PathVariable("name") String name) {
        return passportTableService.searchByName(name);
    }

    @PostMapping(value = "search_by_name")
    public List<Person> searchByNamePost(String name) {
        return passportTableService.searchByName(name);
    }

    @PostMapping(value = "search")
    public List<Person> searchPost(@RequestBody Person person) {
        return passportTableService.search(person);
    }
}
