package team.antelope.fg.dao;

import java.util.List;

import team.antelope.fg.entity.Person;
public interface IPersonDao extends IBaseDao<Person> {
    List<Person> queryAllPerson();    
    int queryTotalRecords();    
    List <Person> queryAllPerson(int from, int to);
    
    // add
    Person queryByName(String name);
    Person queryByEmail(String email);
    Person queryByPhoneNum(String phoneNum);
}
