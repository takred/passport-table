package takred.passporttable;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static takred.passporttable.Gender.FEMALE;
import static takred.passporttable.Gender.MALE;

@Service
public class PassportTableService {
    PersonRepository personRepository;

    public PassportTableService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void registerNewPerson(String name, String surname, String patronymic,
                                  Gender gender, Integer age, Long numberPass) {
        Person person = new Person();
        person.setName(name);
        person.setSurname(surname);
        person.setPatronymic(patronymic);
        person.setGender(gender);
        person.setAge(age);
        person.setNumberPass(numberPass);
        personRepository.save(person);
    }

    public void registerNewPerson(Person person){
        personRepository.save(person);
    }

    public String correctionFullName(Long numberPuss, String fullName){
        Person person = personRepository.findById(numberPuss).orElse(null);
        if (person == null) {
            return "Такого номера паспорта не существует.";
        }
        String surname = fullName.substring(0, fullName.indexOf("_"));
        String name = fullName.substring(fullName.indexOf("_") + 1, fullName.indexOf("_", fullName.indexOf("_") + 1));
        String patronymic = fullName.substring(fullName.indexOf("_", fullName.indexOf("_") + 1));
        person.setName(name);
        person.setSurname(surname);
        person.setPatronymic(patronymic);
        return "ФИО успешно изменено.";
    }

    public String getInfoPerson(Long numberPass) {
        Person person = personRepository.findById(numberPass).orElse(null);
        if (person == null){
            return "Человека по этому номеру паспорта не зарегистрированно.";
        }
        String gender;
        if (person.getGender() == MALE){
            gender = "Мужской";
        } else if (person.getGender() == FEMALE){
            gender = "Женский";
        } else {
            gender = "Неопределённый";
        }
        return "ФИО - " + person.getSurname() + " " + person.getName() + " " + person.getPatronymic() +
                ", пол - " + gender + ", возраст - " + person.getAge() + " лет, номер паспорта - " + person.getNumberPass() + ";";
    }

    public Person getInfoPersonPerson(Long numberPass) {
        Person person = personRepository.findById(numberPass).orElse(null);
        return person;
    }

    public List<Person> searchByName(String name){
        List<Person> allPerson = new ArrayList<>(personRepository.findAll());
        List<Person> sortList = new ArrayList<>();
        for (int i = 0; i < allPerson.size(); i++) {
            if (allPerson.get(i).getName().equals(name)) {
                sortList.add(allPerson.get(i));
            }
        }
        return sortList;
    }

    public List<Person> search(Person person) {
        List<Person> allPerson = new ArrayList<>(personRepository.findAll());
        List<Person> sortList = new ArrayList<>();
        boolean coincidence = true;
        boolean searchName = person.getName() != null;
        boolean searchSurname = person.getSurname() != null;
        boolean searchPatronymic = person.getPatronymic() != null;
        boolean searchGender = person.getGender() != null;
        boolean searchAge = person.getAge() != null;
        boolean searchNumberPass = person.getNumberPass() != null;
//        Integer sumNotNull = 0;
//        if (searchName){
//            sumNotNull++;
//        }
//        if (searchSurname){
//            sumNotNull++;
//        }
//        if (searchPatronymic){
//            sumNotNull++;
//        }
//        if (searchGender){
//            sumNotNull++;
//        }
//        if (searchAge){
//            sumNotNull++;
//        }
//        if (searchNumberPass){
//            sumNotNull++;
//        }
//        if (sumNotNull == 0){
//            return sortList;
//        }

        for (int i = 0; i < allPerson.size(); i++) {
            Integer sumCoincidence = 0;
            if(searchName) {
                if (!allPerson.get(i).getName().equals(person.getName())) {
                    coincidence = false;
                }
//                else {
//                    sumCoincidence++;
//                }
            }
            if (coincidence && searchSurname){
                if (!allPerson.get(i).getSurname().equals(person.getSurname())){
                    coincidence = false;
                }
//                else {
//                    sumCoincidence++;
//                }
            }
            if (coincidence && searchPatronymic){
                if (!allPerson.get(i).getPatronymic().equals(person.getPatronymic())){
                    coincidence = false;
                }
//                else {
//                    sumCoincidence++;
//                }
            }
            if (coincidence && searchGender){
                if (!allPerson.get(i).getGender().equals(person.getGender())){
                    coincidence = false;
                }
//                else {
//                    sumCoincidence++;
//                }
            }
            if (coincidence && searchAge){
                if (!allPerson.get(i).getAge().equals(person.getAge())){
                    coincidence = false;
                }
//                else {
//                    sumCoincidence++;
//                }
            }
            if (coincidence && searchNumberPass){
                if (!allPerson.get(i).getNumberPass().equals(person.getNumberPass())){
                    coincidence = false;
                }
//                else {
//                    sumCoincidence++;
//                }
            }
            if (coincidence){
                sortList.add(allPerson.get(i));
            }
            coincidence = true;
        }
        return sortList;
    }
}
